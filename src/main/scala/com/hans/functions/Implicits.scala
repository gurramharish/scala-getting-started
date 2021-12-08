package com.hans.functions

import scala.language.implicitConversions

case class Currency(amount: Double, toUSD: Double, code: String = "USD")
object Implicits extends App {
  implicit def stringToCurrency(money: String): Currency = {
    val Array(code: String, value: String) = money.split("\\s")
    val amountAsDouble = value.toDouble
    code match {
      case "USD" => Currency(amount = amountAsDouble, toUSD = amountAsDouble)
      case "NZD" => Currency(amountAsDouble, amountAsDouble * (1/1.5))
      case "CAD" => Currency(amountAsDouble, amountAsDouble * (1/1.30))
    }
  }

  println(stringToCurrency("NZD 50"))
  println(stringToCurrency("USD 50"))
  println(stringToCurrency("CAD 50"))
  val cad: Currency = "CAD 200"
  println(s"CAD : $cad")

}
