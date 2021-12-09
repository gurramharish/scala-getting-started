package com.hans._02methodsandfunctions._01functions

object _03ImplementingFunctions extends App {

  // Working with function literals and placeholder syntax

  var multiplyBy100 = (x: Int) => x * 100

  println(multiplyBy100(3))
  println(multiplyBy100(20))
  multiplyBy100 = (x: Int) => x * 1000

  val stockPrices = List(1345.45, 1234.56, 1435.22, 1401.90, 1500.67, 1456.88)
  // Inferring the double type for p is called target typing
  val stockPricesGreaterThan1400 = stockPrices.filter(p => p > 1400)
  println(s"Prices above 1400 : $stockPricesGreaterThan1400")


  // Using placeholder(_) to hold one or more parameters to be passed into a function
  val pricesAbove1400 = stockPrices.filter(_ > 1400)
  println(s"Prices above 1400 using placeholder : $pricesAbove1400")

  val stockTickers = Array("goog", "msft", "tm")

  val upperCaseTickers = stockTickers.map(_.toUpperCase)
  println(s"Uppercase tickers is :: ${upperCaseTickers.mkString(",")}")
}
