package com.han.effective.scala.programming.week6

import java.time.LocalDate
import scala.io.Source
import scala.util.{Failure, Success, Try, Using}

object TryAndEitherCombined extends App {

  type Errors = Seq[String]
  type Validated[A] = Either[Errors, A]


  def readDateStrings(fileName: String): Try[Seq[String]] =
    Using(Source.fromFile(fileName)) {
      source => source.getLines.toSeq
    }

  def parseDate(str: String): Validated[LocalDate] = Try(LocalDate.parse(str)) match {
    case Failure(exception) => Left(Seq(exception.toString))
    case Success(value) => Right(value)
  }

  def validateBoth[A, B](a: Validated[A], b: Validated[B]): Validated[(A, B)] =
    (a, b) match {
      case (Right(a), Right(b)) => Right(a, b)
      case (Left(exception), Right(_)) => Left(exception)
      case (Right(_), Left(exception)) => Left(exception)
      case (Left(e1), Left(e2)) => Left(e1 ++ e2)
    }

  def validateEach[A, B](as: Seq[A])(validate: A => Validated[B]): Validated[Seq[B]] =
    as.foldLeft[Validated[Seq[B]]](Right(Vector.empty)) {
      (validatedBs, a) =>
        val validatedB = validate(a)
        validateBoth(validatedBs, validatedB)
          .map((tuples: (Seq[B], B)) => tuples._1 :+ tuples._2)
    }

  def readAndParseDates(fileName: String): Try[Validated[Seq[LocalDate]]] =
    readDateStrings(fileName).map{
      dateStrings =>
        validateEach(dateStrings)(parseDate)
    }

  def run(fileName: String): Unit =
    readAndParseDates(fileName) match {
      case Failure(exception) =>
        System.err.println(s"Unable to parse dates file: $exception")
      case Success(validatedDates) =>
        validatedDates match {
          case Left(errors) => errors.foreach(println)
          case Right(dates) => dates.foreach(println)
        }
    }

  run("./src/main/resources/dates.txt")
}
