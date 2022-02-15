package com.han.part1basics

import scala.annotation.tailrec

object Recursion extends App {

  def factorial(n: Int): BigInt = {
    if(n <= 1) 1
    else {
      n * factorial(n - 1)
    }
  }

  def anotherFactorial(n: Int): BigInt = {
    def factorialHelper(x: Int, accumulator: BigInt): BigInt = {
      if (n <= 1) 1
      else factorialHelper(x - 1, accumulator * x)
    }
    factorialHelper(n, 1)
  }

  // WHEN YOU NEED LOOPS, USE TAIL_RECURSION

  def isPrimeNonTailRec(n: Int): Boolean = {

    def isPrimeUntil(t: Int): Boolean = {
      if(t <= 1) true else n % t != 0 && isPrimeUntil(t - 1)
    }
    isPrimeUntil(n / 2)
  }

  def isPrime(n: Int): Boolean = {
    @tailrec
    def isPrimeTailRec(t: Int, isStillPrime: Boolean): Boolean = {
      if(!isStillPrime) false
      else if(t <= 1) true
      else isPrimeTailRec(t - 1, n % t != 0 && isStillPrime)
    }
    isPrimeTailRec(n, true)
  }

  def fibonacciNonTailRec(n: Int): Int = {
    if(n <=  2) 1 else fibonacciNonTailRec(n - 1) + fibonacciNonTailRec(n - 2)
  }

  // We need to have 2 accumulators, based on recursive calls the accumulator count increases
  def fibonaci(n: Int): Int = {

    @tailrec
    def fibonnaciTailRec(t: Int, previous: Int, current: Int): Int = {
      println(s"Calling fibonnaci for t : $t")
      if(t <= 1) current
      else fibonnaciTailRec(t - 1, previous + current, previous)
    }

    fibonnaciTailRec(n, 1, 1)
  }

  def fibonacciFromStart(n: Int): Int = {
    def fibonacciTailrec(t: Int, last: Int, nextLast: Int): Int = {
      println(s"Calling fibonnaci for t : $t")
      if(t >= n) last
      else fibonacciTailrec(t + 1, last + nextLast, last)
    }

    if(n <= 2) 1
    else fibonacciTailrec(2, 1, 1)
  }

  println(fibonacciFromStart(10))
  println(fibonacciFromStart(0))
  println(fibonacciFromStart(1))
  println(fibonacciFromStart(2))
  println(fibonacciFromStart(3))
  println(fibonacciFromStart(4))
  println(fibonacciFromStart(5))
  println(fibonacciFromStart(6))
  println(fibonacciFromStart(7))
  println(fibonacciFromStart(8))
  println(fibonacciFromStart(9))

}
