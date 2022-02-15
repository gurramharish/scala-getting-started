package com.han.effective.scala.programming.week6

import java.time.LocalDate
import scala.util.Try

object ValidatingData extends App {

  type Errors = Seq[String]

  type Validated[A] = Either[Errors, A]

  val validInt: Validated[Int] = Right(42)

  val inValidInt: Validated[Int] = Left(Seq("Invalid Integer"))

  val double: Validated[Int] = validInt.map(n => n + n)

  val dInv: Validated[Int] = inValidInt.map(n => n + n)

  println(s"double $double, dInv $dInv")

  def parseDate(str: String): Validated[LocalDate] = Try(LocalDate.parse(str)).toEither
    .left.map(error => Seq(error.getMessage))

  println(parseDate("2022-10-20"))
  println(parseDate("2022-14-20"))

  def validateBoth[A, B](validatedA: Validated[A], validatedB: Validated[B]): Validated[(A, B)] =
    (validatedA, validatedB) match {
      case (Right(a), Right(b)) => Right(a, b)
      case (Left(e), Right(_)) => Left(e)
      case (Right(_), Left(e)) => Left(e)
      case (Left(e1), Left(e2)) => Left(e1 ++ e2)
    }

  def parseDates(strings: Seq[String]): Validated[Seq[LocalDate]] =
    strings.foldLeft[Validated[Seq[LocalDate]]](Right(Vector.empty)) {
      (validatedDates, str) =>
        val validatedDate = parseDate(str)
        validateBoth(validatedDates, validatedDate)
          .map(dates => dates._1 :+ dates._2)
    }

  parseDates(List("2020-01-04", "2020-10-10", "2022-12-12"))
  parseDates(List("20"))

}
