package com.hans._02methodsandfunctions._01functions

import scala.io.Source

case class StockInformation(records: Vector[StockMarketRecord]) {

  def extractHigh(): Vector[(String, Float)] = records.map(record => (record.ticker, record.high))

  def extractOpen(): Vector[(String, Float)] = records.map(record => (record.ticker, record.open))

  def extractClose(): Vector[(String, Float)] = records.map(record => (record.ticker, record.close))

  def extractDelta(): Vector[(String, Float)] = records.map(record => (record.ticker, record.close - record.open))

  def extractInfo(extractFunction: () => Vector[(String, Float)]) = extractFunction()

}

object _07HigherOrderFunctions extends App {

  val readFinanceData = () => {
    val source = Source.fromFile("src/main/resources/stockMarketData.csv")
    for {
      line <- source.getLines().drop(1).map(_.trim).toVector
      cols = line.split(",")
    } yield StockMarketRecord(cols(0), cols(1).toFloat, cols(2).toFloat, cols(3).toFloat, cols(4).toFloat, cols(5))
  }

  val records = readFinanceData()

  val  extractHigh = (records: Vector[StockMarketRecord]) => records.map(record => (record.ticker, record.high))

  val extractLow = (records: Vector[StockMarketRecord]) => for(record <- records) yield (record.ticker, record.low)

  val extractOpen = (records: Vector[StockMarketRecord]) => records.map(record => (record.ticker, record.open))

  val extractInformation = (records: Vector[StockMarketRecord], extractFunction: (Vector[StockMarketRecord]) => Vector[(String, Float)]) => extractFunction(records)

  println(s"Extract High : ${extractInformation(records, extractHigh)}")
  println(s"Extract Low : ${extractInformation(records, extractLow)}")
  println(s"Extract Open : ${extractInformation(records, extractOpen)}")

  val stockInformation = StockInformation(records)

  println("###################################################################")

  println(s"Extract High : ${stockInformation.extractHigh}")
  println(s"Extract Open : ${stockInformation.extractOpen}")
  println(s"Extract Open : ${stockInformation.extractDelta}")

  println("$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$")

  val getExtractFunction = (functionName: String, records: Vector[StockMarketRecord]) => {
    functionName match {
      case "high" => () => records.map(record => (record.ticker, record.high))
      case "open" => () => records.map(record => (record.ticker, record.open))
      case "low" => () => records.map(record => (record.ticker, record.low))
      case "delta" => () => records.map(record => (record.ticker, record.close - record.open))
      case "close" => () => records.map(record => (record.ticker, record.close))
      case _ => () => Vector()
    }
  }

  val extractDefault = getExtractFunction("ll", records)
  val extractHighFunc = getExtractFunction("high", records)
  val extractLowFunc = getExtractFunction("low", records)
  val extractCloseFunc = getExtractFunction("close", records)
  val extractDeltaFunc = getExtractFunction("delta", records)

  println(s"Default : ${extractDefault()}")
  println(s"High : ${extractHighFunc()}")
  println(s"Low : ${extractLowFunc()}")
  println(s"Delta : ${extractDeltaFunc()}")

}
