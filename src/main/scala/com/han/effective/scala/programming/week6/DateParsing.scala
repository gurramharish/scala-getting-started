package com.han.effective.scala.programming.week6

import java.time.{LocalDate, Period}
import scala.io.Source
import scala.util.{Success, Try, Using}

object DateParsing extends App {

  def parseDate(str: String): Try[LocalDate] = Try(LocalDate.parse(str))

  def tryPeriod(str1: String, str2: String): Try[Period] =
    parseDate(str1).flatMap(date1 => {
      parseDate(str2).map(date2 => {
        Period.between(date1, date2)
      })
    })

  def tryPeriodForComprehension(str1: String, str2: String): Try[Period] = {
    for {
      date1 <- parseDate(str1)
      date2 <- parseDate(str2)
    } yield Period.between(date1, date2)
  }

  println(tryPeriodForComprehension("2021-07-20", "2022-02-20"))
  println(tryPeriodForComprehension("2022-20-20", "2022-01-12").recoverWith{
    case ex: RuntimeException => println(s"Exception in finding period $ex")
      Try(Period.ZERO)
  })

  println(tryPeriodForComprehension("2022-10-10", "2020-01-20"))
  println(tryPeriodForComprehension("2020-01-20", "2022-10-10"))
  println(tryPeriodForComprehension("2021-12-12", "2022-20-20").recover{
    case ex: RuntimeException => println(s"Something Wrong $ex")
  })



  // read string dates from file
  def readDateStrings(fileName: String): Try[Seq[String]] =
    Using(Source.fromFile(fileName)) { source =>
      val dateStrings = source.getLines.toSeq
      dateStrings
    }

  println(readDateStrings("./src/main/resources/dates.txt"))


  def parseDates(fileName:String): Try[Seq[LocalDate]] =
    readDateStrings(fileName).flatMap {
      (dateStrings: Seq[String]) => dateStrings.foldLeft[Try[Seq[LocalDate]]](Success(Vector.empty)) {
        (tryDates, str) =>
          for {
            dates <- tryDates
            date <- parseDate(str)
          } yield dates :+ date
      }
    }

  println(parseDates("./src/main/resources/dates.txt"))

}
