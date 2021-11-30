val amounts = Array(10, 20, 30 , 40, 50)
val currencies = Array("USD", "NZD")
val multiples = Array(1, 2, 3)

val result = for (amount <- amounts) yield amount

val results = for {
  amount <- amounts
  currency <- currencies
  multiple <- multiples
  if amount > 10 && amount < 45 && currency == "USD"
  if multiple >= 2
} yield s"$currency ${multiple * amount}"

// foreach
amounts.foreach(amount => println(amount * 100))












