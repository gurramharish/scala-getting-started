package com.hans._02methodsandfunctions._03exceptionhandling

object _05OptionSomeNone extends App {

  def convertToFloat(someString: String): Option[Float] = {
    try {
      Some(someString.toFloat)
    } catch {
      case e: NumberFormatException => None
    }
  }

  val googStockPrices = List("1367.36", "1360.66", "1394.20", "asdf", "1393.33", "1404.31", "1419.82")
  val stockPricesFloat = googStockPrices.map(convertToFloat)
  println(stockPricesFloat.filter(_.nonEmpty))
  println(stockPricesFloat.map(_.getOrElse(-1)))
}
