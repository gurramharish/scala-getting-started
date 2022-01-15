import scala.annotation.tailrec

def factorial(x: Int): Int = {

  @tailrec
  def factorialHelper(x: Int, accumulator: Int): Int = {
    if (x == 1) accumulator else factorialHelper(x -1, accumulator * x)
  }

  factorialHelper(x, 1)
}

factorial(10)

def fibonacci(index: Int): Int = {

  @tailrec
  def tailRecFibonacci(index: Int, previous: Int, current: Int): Int = {
    if(index <= 0) current
    else tailRecFibonacci(index - 1, previous = previous + current, current = previous)
  }
  tailRecFibonacci(index, previous = 1, current = 0)
}

fibonacci(10)

fibonacci(12)



