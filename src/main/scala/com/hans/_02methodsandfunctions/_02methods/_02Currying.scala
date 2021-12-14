package com.hans._02methodsandfunctions._02methods

import com.hans._02methodsandfunctions._01functions.StockMarketRecord

import scala.io.Source

object _02Currying extends App {

  val records = MethodsUtil.readData

  // Curried function
  def getPrice(date: String)(ticker: String)(priceType: String) = {
    val stock = records.filter(item => item.date == date && item.ticker == ticker)(0)
    priceType match {
      case "high" => stock.high
      case "low" => stock.low
      case "close" => stock.close
      case _ => stock.open
    }
  }

  // Currying function using placeholders is a partially applied function
  val getPriceForGoog = getPrice("11-06-2020")("GOOG") _

  val getPriceForMicrosoft = getPrice("12-06-2020") _

  println(s"Google high price : ${getPriceForGoog("high")}")

  println(s"TM stock low on 12-06-2020 : ${getPrice("12-06-2020")("TM")("low")}")
}
