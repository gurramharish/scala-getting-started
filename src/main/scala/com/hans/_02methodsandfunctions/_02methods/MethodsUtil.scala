package com.hans._02methodsandfunctions._02methods

import com.hans._02methodsandfunctions._01functions.{StockMarketRecord, StockRecord}

import scala.io.Source

object MethodsUtil {

  def readData = {
    val source = Source.fromFile("src/main/resources/stockMarketData.csv")
    source.getLines().drop(1)
      .map(_.split(",").map(_.trim).toList).toVector
      .map(cols => StockMarketRecord(cols(0), cols(1).toFloat, cols(2).toFloat, cols(3).toFloat, cols(4).toFloat, cols(5)))
  }

  def readGoogleData = {
    val source = Source.fromFile("src/main/resources/GOOG.csv")
    source.getLines().drop(1)
      .map(_.split(",").map(_.trim).toVector).toVector
      .map(cols => StockRecord(cols(0), cols(1).toFloat,
        cols(2).toFloat, cols(3).toFloat, cols(4).toFloat,
        cols(5).toFloat, cols(6).toDouble))
  }
}
