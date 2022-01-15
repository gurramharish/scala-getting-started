def factorial(x: Int): Int = {
  def fact(x: Int, accumulator: Int): Int = {
    if(x <= 1) accumulator
    else fact(x - 1, x * accumulator)
  }
  fact(x, 1)
}

println(s"Factorial of 2: ${factorial(2)}")
println(s"Factorial of 10: ${factorial(10)}")
