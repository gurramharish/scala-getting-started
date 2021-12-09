package com.hans._02methodsandfunctions._01functions

object _05PartialAppliedFunctionsUsingPlaceHolders extends App {
  val stockPrices = List(1367.36, 1360.66, 1371.20, 1394.20, 1393.33, 1404.31, 1419.82, 1429.73)

  def checkPriceGreaterThan1400(price: Double) = price > 1400

  // Creating a partial applied function from the method with all arguments
  val checkPriceGreaterThan1400Function = checkPriceGreaterThan1400 _

  val stockPricesGreaterThan1400 = stockPrices.filter(checkPriceGreaterThan1400Function)
  println(s"> 1400 : $stockPricesGreaterThan1400")

  def checkPriceInRange(price: Double, lower: Double, upper: Double) = price >= lower && price <= upper

  // creating a partial applied function from method with all arguments
  val checkPriceInRangeFunction = checkPriceInRange _

  val _stockRange1390To1410 = stockPrices.filter(checkPriceInRangeFunction(_, 1390, 1410))
  println(s"Stocks in range 1390 to 1400 : ${_stockRange1390To1410}")

  // Creating a partial applied function from method with one arguments
  val checkPriceInRangeUpper1420Function = checkPriceInRange(_, _, upper = 1420)
  val _stockRange1370To1420 = stockPrices.filter(checkPriceInRangeUpper1420Function(_, 1370))
  println(s"Stocks in range 1370 to 1420 : ${_stockRange1370To1420}")

  // Creating a partial applied function from method with 2 arguments
  val checkPriceInRange1380To1420Function = checkPriceInRange(_: Double, 1380, 1420)
  val _stockRange1380To1420 = stockPrices.filter(checkPriceInRange1380To1420Function)
  println(s"Stocks in range 1380 to 1420: ${_stockRange1380To1420}")

}
