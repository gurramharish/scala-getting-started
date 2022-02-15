package com.han.part1basics

import scala.annotation.tailrec

object Functions extends App {

  def aFunction(a: String, b: String): String = s"$a $b"

  @tailrec
  def aRepeatedFunction(aString: String, n: Int, accumulator: String = ""): String = {
    if(n == 0) accumulator else aRepeatedFunction(aString, n - 1, s"$accumulator $aString")
  }

  println(aRepeatedFunction("Harish", 10))

  // WHEN YOU NEED LOOPS, USE RECURSION

  def factorial(n: Long): BigInt = {

    @tailrec
    def factorialHelper(n: Long, accumulator: BigInt): BigInt = {
      if (n == 1) accumulator else factorialHelper(n = n - 1, accumulator * n)
    }
    factorialHelper(n, 1)
  }

  def fact(n: Int): BigInt = {
    if (n <= 0) 1 else n * fact(n - 1)
  }

  println(factorial(10))
  println("====================================")
  println(fact(10))

 def fibonacci(n: Int): Int = {
   if(n <=  2) 1 else fibonacci(n - 1) + fibonacci(n - 2)
 }

 println(fibonacci(10))


  def isPrime(n: Int): Boolean = {

    def isPrimeUntil(t: Int): Boolean = {
      if(t <= 1) true else n % t != 0 && isPrimeUntil(t - 1)
    }
    isPrimeUntil(n / 2)
  }
  println(s"Is 37 prime : ${isPrime(37)}")
  
  

}
