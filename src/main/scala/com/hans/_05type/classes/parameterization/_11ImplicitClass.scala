package com.hans._05type.classes.parameterization

import com.hans._05type.classes.parameterization._11ImplicitClass.Currency.{INR, SGD, USD}

import scala.language.postfixOps

object _11ImplicitClass extends App {

  sealed trait Currency
  object Currency {
    case object SGD extends Currency
    case object INR extends Currency
    case object USD extends Currency

    type SGD = SGD.type
    type INR = INR.type
    type USD = USD.type
  }

  case class Amount[T <: Currency](value: Double, currency: T)

  implicit  class AmountExt[T <: Currency](amount: Amount[T]) {
    def +(that: Amount[T]): Amount[T] = amount.copy(value = amount.value + that.value)
  }

  implicit class DoubleToAmount(d: Double) {
    def usd: Amount[USD] = Amount(d, USD)
    def sgd: Amount[SGD] = Amount(d, SGD)
    def inr: Amount[INR] = Amount(d, INR)
  }


  val tenUSD = Amount(10, USD)
  val oneUSD = Amount(1, USD)

  println(tenUSD + oneUSD)
  println(s"(2 inr) + (100 inr) :: ${(2.0 inr) + (100.0 inr)}")
}


