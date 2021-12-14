package com.hans._02methodsandfunctions._03exceptionhandling

import java.io.{BufferedReader, FileReader}
import scala.util.{Failure, Success, Try, Using}

object _03TrySuccessFailureWithUsing extends App {

  val lines: Try[List[String]] = Using(new BufferedReader(new FileReader(
    "src/main/resources/dividendStocks.csv"
  ))) {
    reader => Iterator.continually(reader.readLine()).takeWhile(_ != null).toList
  }

  lines match {
    case Success(lines) => lines.foreach(println)
    case Failure(exception) => println(exception.getMessage)
  }
}
