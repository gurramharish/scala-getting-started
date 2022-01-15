case class Currency(amount: Double, toUSD: Double, code: String = "USD")

implicit def stringToCurrency(money: String): Currency = {
  val Array(code: String, value: String) = money.split("\\s");
  val amountAsDouble = value.toDouble
  code match {
    case "USD" => Currency(amountAsDouble, amountAsDouble)
    case "NZD" => Currency(amountAsDouble, amountAsDouble * (1/1.5))
    case "CAD" => Currency(amountAsDouble, amountAsDouble * (1/1.30))
  }
}

val nzd: Currency = "NZD 200"

