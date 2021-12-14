package com.hans._02methodsandfunctions._03exceptionhandling

import scala.annotation.tailrec
import scala.io.{Source, StdIn}
import scala.util.{Failure, Success, Try}

object _04TrySuccessFailureWithCombinators extends App {

  def readCSVFile(filePath: String): Seq[DividendRecord] = {
    val source = Source.fromFile(filePath)
    source.getLines().drop(1).toVector.map(_.split(",").map(_.trim))
      .map(cols => DividendRecord(cols(0), cols(1), cols(2).toFloat, cols(3).toFloat))
  }

  val records = readCSVFile("src/main/resources/dividendStocks.csv")

  @tailrec
  def calculateDividendYield(): Try[Double] = {
    val ticker = StdIn.readLine("Enter ticker: ")
    val currentPrice = Try(StdIn.readLine("Enter current price: ").toDouble)

    val faceValue: Try[Double] = Try(
      records.filter(_.ticker == ticker).map(_.faceValue).head.toDouble
    )

    val dividendRate: Try[Double] = Try(
      records.filter(_.ticker == ticker).map(_.dividend).head * 0.01
    )

    val dividendPerShare: Try[Double] = faceValue.flatMap(
      fv => dividendRate.map(divRate => fv * divRate)
    )

    val dividendYield: Try[Double] = dividendPerShare.flatMap(
      divPerShare => currentPrice.map(currPrice => divPerShare / currPrice * 100)
    )

    dividendYield match {
      case Success(divYield) =>
        println(s"Dividend yield of $ticker is: ${divYield}%")
        Success(divYield)

      case Failure(exception) =>
        println(s"------ ${exception.getMessage}")
        println("An error occurred along the way, try again!")
        calculateDividendYield()
    }
  }

  calculateDividendYield()
}
