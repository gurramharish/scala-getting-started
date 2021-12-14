package com.hans._02methodsandfunctions._02methods

import com.hans._02methodsandfunctions._02methods._02Currying.records

object _05NamedAndDefaultArguments extends App {

  val records = MethodsUtil.readData

  def getStockPriceDetails(date: String = "11-06-2020", ticker: String, priceType: String = "open") = {
    val stock = records.filter(item => item.date == date && item.ticker == ticker)(0)
    val price = priceType match {
      case "high" => stock.high
      case "low" => stock.low
      case "close" => stock.close
      case _ => stock.open
    }
    (stock.date, stock.ticker, price)
  }

  println(getStockPriceDetails(ticker = "BNS", date = "12-06-2020", priceType  = "low"))

  println(getStockPriceDetails("12-06-2020", priceType  = "low", ticker = "DB"))

  println(getStockPriceDetails(ticker = "GOOG"))
}
