package com.hans._02methodsandfunctions._01functions

import scala.io.Source

object _10HigherOrderFunctionInvocationWithFunctionLiteralBlocks extends App {

  val readFinanceData = () => {
    val source = Source.fromFile("src/main/resources/stockMarketData.csv")
    for {
      line <- source.getLines().drop(1).map(_.trim).toVector
      cols = line.split(",").map(_.trim)
    } yield StockMarketRecord(cols(0), cols(1).toFloat, cols(2).toFloat, cols(3).toFloat, cols(4).toFloat, cols(5))
  }

  val records = readFinanceData()

  val getStockDetails = (ticker: String, extractFunction: (StockMarketRecord) => Float) => {
    val filterRecords = records.filter(_.ticker == ticker)
    val record = filterRecords(0)
    extractFunction(record)
  }

  // higher-order function with function literal block
  def getStockDetailsWithFunctionLiteralBlock(ticker: String)(extractFunction: (StockMarketRecord) => Float): Float =  {
    val filterRecords = records.filter(_.ticker == ticker)
    val record = filterRecords(0)
    extractFunction(record)
  }

  val ttmStockDetails = getStockDetails("TTM", (record: StockMarketRecord) => record.high // function literal
  )
  println(s"TTM high : $ttmStockDetails")

  println("+++++++++++++++++++++++++++++++++++++++++++++++++")
  val stockDetails = getStockDetailsWithFunctionLiteralBlock("TTM") {
    (record: StockMarketRecord) => record.low
  }

  println(s"TTM low : ${stockDetails}")
}
