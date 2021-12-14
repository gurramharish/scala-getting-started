package com.hans._02methodsandfunctions._02methods

import com.hans._02methodsandfunctions._01functions.StockRecord

import scala.annotation.tailrec

object _07Recursion extends App {

  val data = MethodsUtil.readGoogleData

  @tailrec
  def rollingAverage(records: Vector[StockRecord], numDays: Int): Unit = {
    if (records.length < numDays) {
      throw new Exception("Error to see stack trace!!")
    } else {
      val averageClose = records.map(_.close).take(numDays).sum / numDays
      println(s"Rolling average close for $numDays days date ${records.head.date}: $averageClose")
      val updatedRecords = records.drop(1)
      rollingAverage(updatedRecords, numDays)
    }
  }

  rollingAverage(records = data, 7)
}
