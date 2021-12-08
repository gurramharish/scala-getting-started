// Understanding pattern matching, literal pattern matching, variable pattern matching
// pattern matching as expression
// pattern matching on types
// extracting data using pattern matching

var amount = 300

val result = amount match {
  case a if a >= 50 && a <= 100 => s"Bill is between $$50 and $$100"
  case a => s"$$$a"
}

println(result)

// Pattern matching on types

abstract class Currency
case class USD() extends Currency
case class CAD() extends Currency
case class NZD() extends Currency {
  def nzd(): Unit = {
    println("I am NZD!!")
  }
}

val currency: Currency = NZD()

val convertToUSD = currency match {
  case u: USD => s"USD $amount"
  case c: CAD => s"USD ${amount * (1/1.30)}"
  case n: NZD => s"USD ${amount * (1/1.50)}"
}

// Pattern matching for extracting data

val anArray = Array(100, 200, 300, 500, 600)

val extractMatch = anArray match {
  case Array(_, _, third) => s"Has 3 elements $third"
  case Array(_, _, _, fourth) => s"$fourth Has 4 or more elements"
  case _ => "No match found!!"
}

val aTuple: (Currency, Int) = (NZD(), 100)

val convertedTuple = aTuple match {
  case (nzd: NZD, i) =>
    nzd.nzd()
    (USD(), i * (1/1.50))
  case (usd: USD, i) => (usd, i)
}














