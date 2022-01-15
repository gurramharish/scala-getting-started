package com.hans._02methodsandfunctions._03exceptionhandling

import com.hans._02methodsandfunctions._03exceptionhandling._05OptionSomeNone.convertToFloat

object _06EitherRightLeft extends App {

  def convertToFloat(someString: String): Either[String, Float] = {
    try {
      Right(someString.toFloat)
    } catch {
      case e: NumberFormatException =>
        Left(s"Encountered an error while parsing float: $someString")
    }
  }

  val googStockPrices = List("1367.36", "1360.66", "1394.20", "asdf", "1393.33", "1404.31", "1419.82")
  val stockPricesFloat = googStockPrices.map(convertToFloat)

  stockPricesFloat.foreach {
    case Right(price) => println(price)
    case Left(message) => println(message)
  }
}
