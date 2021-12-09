package com.hans._02methodsandfunctions._01functions

import scala.io.Source
import scala.util.Random

object _09FunctionInvocationWithExpressionBlocks extends App {

  val readFinanceData = () => {
    val source = Source.fromFile("src/main/resources/stockMarketData.csv")
    for {
      line <- source.getLines().drop(1).map(_.trim).toVector
      cols = line.split(",").map(_.trim)
    } yield StockMarketRecord(cols(0), cols(1).toFloat, cols(2).toFloat, cols(3).toFloat, cols(4).toFloat, cols(5))
  }

  val records = readFinanceData()

  println(s"records :: $records")

  val getSockDetails = (ticker: String) => {
    println(s"Getting stock details for $ticker")
    records.filter(_.ticker == ticker)
  }

  val stockDetails = getSockDetails("MSFT")
  println(s"MSFT stock details : $stockDetails")

  val randomStockDetails = getSockDetails {
    val list = List("MSFT", "GOOG", "TM", "TTM", "DB", "BNS")
    val randomNumber = Random.nextInt(list.size)
    list(randomNumber)
  }

  println(s"Random ticker details : $randomStockDetails")
}
