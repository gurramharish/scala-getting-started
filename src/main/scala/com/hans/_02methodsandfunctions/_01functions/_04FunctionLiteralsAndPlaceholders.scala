package com.hans._02methodsandfunctions._01functions

import scala.io.Source

object _04FunctionLiteralsAndPlaceholders extends App {

  val source = Source.fromFile("src/main/resources/GOOG.csv")

  val readFinanceData = () => {
    for {
      line <- source.getLines().drop(1).toVector
      cols = line.split(",").map(_.trim)
    } yield StockRecord(cols(0), cols(1).toFloat,
      cols(2).toFloat, cols(3).toFloat, cols(4).toFloat,
      cols(5).toFloat, cols(6).toDouble)
  }

  var data = readFinanceData()

  val getTotalNumberOfRows = () => data.size

  val getAvgCloseValue = () => data.map(_.close).sum / data.size

  val getMinCloseValue = () => data.map(_.close).min

  val getMaxCloseValue = () => data.map(_.close).max

  val getCloseValueOnDate = (givenData: String) => data.filter(_.date == givenData).map(_.close).head

  println(s"Dataset Size : ${getTotalNumberOfRows()}")
  println(s"Average close: ${getAvgCloseValue()}")
  println(s"Min close : ${getMinCloseValue()}")
  println(s"Max close : ${getMaxCloseValue()}")

  val date = "2020-01-03"
  println(s"Close value on $date: ${getCloseValueOnDate(date)}")

  // (open: Double, close: Double) => open - close
  // val priceDelta = (_: Double) - (_: Double)

  val getDailyDelta = (openPrice: Double, closePrice: Double, deltaFunc: (Double, Double) => Double) => deltaFunc(openPrice, closePrice)

  val record = data.filter(_.date == date)(0)
  println(s"Record on date - $date : $record")

  println(s"Delta on day $date is : ${getDailyDelta(record.open, record.close, _ - _)}")

}
