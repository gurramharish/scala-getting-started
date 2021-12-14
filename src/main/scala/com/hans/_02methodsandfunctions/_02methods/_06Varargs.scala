package com.hans._02methodsandfunctions._02methods

object _06Varargs extends App {

  private val data = MethodsUtil.readData

  // var args should be the last parameter
  def getRecords(date: String, tickers: String*) = {
    data.filter(record => tickers.contains(record.ticker))
      .map(record => (record.date, record.ticker, record.close))
  }

  println(getRecords("12-06-2020","MSFT", "DB").mkString("-"))
  println(s"No ticker: ${getRecords("11-06-2020")}")

  // We can pass collections as variable arguments like bellow
  val tickers = List("GOOG", "TM")
  println(s"List as input : ${getRecords("12-06-2020", tickers: _*).mkString("@")}")
}
