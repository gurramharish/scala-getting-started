package com.hans._02methodsandfunctions._03exceptionhandling

import scala.io.{BufferedSource, Source}
import scala.util.{Failure, Success, Try}

object _02TrySuccessFailure extends App {

  def getLinesFromFile(fileName: String): Try[BufferedSource] = {
    Try(Source.fromFile(fileName))
  }

  val trySourcePath = getLinesFromFile("src/main/resources/dividendStocks.csv")

  trySourcePath match {
    case Success(sourcePath) => sourcePath.getLines().toList.foreach(println)

    case Failure(exception) => println(exception.getMessage)
  }
}
