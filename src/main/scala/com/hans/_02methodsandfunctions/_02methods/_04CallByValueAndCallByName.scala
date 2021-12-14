package com.hans._02methodsandfunctions._02methods

import com.hans._02methodsandfunctions._01functions.StockMarketRecord

object _04CallByValueAndCallByName extends App {

  // understanding call by value and call by name method evaluation strategies
  val records = MethodsUtil.readData

  println(s"Records : $records")

  /*
  <b>Call by value</b> is the strict evaluation strategy that Scala uses by default,
  here the expressions corresponding to input arguments are evaluated before the
  function body is executed
  <b>Call by name</b> is the non-strict evaluation strategy in Scala, here the
  expressions corresponding to input arguments are evaluated only when the program
  needs it, we can convert the method to call by name using fat arrow(=>)
   */
  def makeMomentumBasedTradingDecision(record: => StockMarketRecord, percentDelta: Float) = {
    println(s"Calculating percentage move")
    // Evaluated only at the 1st reference
    lazy val stock = record
    println("============================")
    val percentageMove = ((stock.close - stock.open) / stock.open) * 100

    if (percentageMove > percentDelta) {
      println(s"Buy ${stock.ticker}")
    } else if (percentageMove < -percentDelta) {
      println(s"Sell ${stock.ticker}")
    } else {
      println(s"No call on ${stock.ticker}")
    }
  }

  def getRecord(ticker: String): StockMarketRecord = {
    println(s"Accessing getRecord!!")
    records.filter(_.ticker == ticker)(1)
  }

  makeMomentumBasedTradingDecision(getRecord("MSFT"), 1)
  println("MSFT Done!!")

  val googRecord = getRecord("GOOG")
  println("Fetched Goog record!!")
  makeMomentumBasedTradingDecision(googRecord, 1)
}
