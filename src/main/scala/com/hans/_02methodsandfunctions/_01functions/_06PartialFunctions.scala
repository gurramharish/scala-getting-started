package com.hans._02methodsandfunctions._01functions

import scala.io.Source

// Partial functions are different from partial applied functions
object _06PartialFunctions extends App {

  val divide64By = new PartialFunction[Int, Int] {
    override def isDefinedAt(x: Int): Boolean = x != 0

    override def apply(v1: Int): Int = 64 / v1
  }

  println(s"is divide6By defined at 6: ${divide64By.isDefinedAt(6)}")
  println(s"is divide6By defined at 0: ${divide64By.isDefinedAt(0)}")

  // Implementing partial functions with pattern matching
  val divide64ByPatternMatching: PartialFunction[Int, Int] = {
    case x: Int if x != 0 => 64 / x
  }

  println(s"is divide6By defined at 6: ${divide64ByPatternMatching.isDefinedAt(6)}")
  println(s"is divide6By defined at 0: ${divide64ByPatternMatching.isDefinedAt(0)}")

  val readFinanceData = () => {
    val source = Source.fromFile("src/main/resources/stockMarketData.csv")
    for {
      line <- source.getLines().drop(1).toVector
      cols = line.split(",").map(_.trim)
    } yield StockMarketRecord(cols(0), cols(1).toFloat, cols(2).toFloat, cols(3).toFloat, cols(4).toFloat, cols(5))
  }
  val data = readFinanceData()

  val printStockRecords: PartialFunction[String, Unit] = new PartialFunction[String, Unit] {
    val recordedTickers = List("MSFT", "GOOG", "TTM", "TM", "DB", "BNS")

    def isDefinedAt(ticker: String) = recordedTickers.contains(ticker)

    def apply(ticker: String): Unit = {
      for (line <- data.filter(_.ticker == ticker)) {
        println(s"Date : ${line.date} Ticker: ${line.ticker} Close: ${line.close}")
      }
    }
  }
  printStockRecords("MSFT")
  // printStockRecords Partial function with Pattern matching
  val printStockRecordsPatternMatching: PartialFunction[String, Unit] = {
    case ticker: String if (List("MSFT", "GOOG", "TTM", "TM", "DB", "BNS").contains(ticker)) =>
      for (line <- data.filter(_.ticker == ticker)) {
        println(s"Date : ${line.date} Tick: ${line.ticker} Close: ${line.close}")
      }
  }

  // collect method takes partial function as input and check isDefinedAt before invoking apply
  List("GAG", "GOOG") collect {
    printStockRecordsPatternMatching
  }

  val printTechStockRecords: PartialFunction[String, Unit] = {
    case ticker: String if (ticker == "GOOG" || ticker == "MSFT") =>
      for (line <- data.filter(_.ticker == ticker)) println(s"${line.ticker}: close price ${line.close} on date - ${line.date}")
  }

  val printMotorStockRecords: PartialFunction[String, Unit] = {
    case ticker: String if (ticker == "TTM" || ticker == "TM") =>
      for (line <- data.filter(_.ticker == ticker)) println(s"Ticker-${line.ticker}: close price ${line.close} on date - ${line.date}")
  }


  val printTechOrMotorStocks = printTechStockRecords orElse printMotorStockRecords

  println(s"Records :: $data")
  printTechOrMotorStocks("GOOG")
  printTechOrMotorStocks("TM")
}
