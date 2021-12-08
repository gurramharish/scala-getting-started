
// def functionName(argument: Type): ReturnType {}

def square(x: Int): Int = x * x

val sq_2 = square(2)

def multiply(nums: Int*): Int = {
  var product = 1
  for (num <- nums) product = product * num
  product
}

println(multiply(10, 20, 30, 40))

// Creating functions inside a function

def sumOdd(n: Int): Int = {
  def getOdd(x: Int): Array[Int] = {
    var result = Array[Int]()
    var current = 1
    while (current <= x) {
      result = result :+ current
      current = current + 2
    }
    result
  }
  val odds = getOdd(n)
  println(odds.mkString(","))
  odds.sum
}

sumOdd(70)
25 * 49

// Working with named arguments
def greet(first: String, last: String): Unit = println(s"Hello! $first, $last")

greet("Harish", "Gurram")
greet("Gurram", "Harish")
greet(last = "Gurram", first = "Harish")

def logTransaction(amount: Double, debit: Boolean = true, currency: String = "USD"): Unit = {
  val symbol = if(debit) "-" else "+"
  println(s"$symbol $currency $amount")
}

logTransaction(100, debit = false, "CAD")
logTransaction(20)
logTransaction(30)

// Understanding Higher Order functions
def transform(f: Int => Int, numbers: Int*) = numbers.map(f)


println(transform(square, 10, 20))

println(transform((n: Int) => n * n * n, 2, 3, 4))

val nums = Array(1, 2, 3, 4, 5, 6, 7)
val evenSquares = nums.filter(n => n % 2 == 0).map(n => n * n)
println(nums.mkString(","))
println(evenSquares.mkString(","))















