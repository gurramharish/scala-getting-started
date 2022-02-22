package com.han.part3fp

import scala.annotation.tailrec

object HOFsCurries extends App {

  val superFunction: (Int, (String, Int => Boolean) => Int) => (Int => Int) = null

  @tailrec
  def nTimes(f: Int => Int, n: Int, value: Int): Int =
    if(n <= 0) value
    else nTimes(f, n - 1, f(value))

  def plusOne = (x: Int) => x + 1

  println(nTimes(plusOne, 10, 1))

  def nTimesBetter(f: Int => Int, n: Int): Int => Int =
    if(n <= 0) (x: Int) => x
    else x => nTimesBetter(f, n - 1)(f(x))

  val plusTenTimes = nTimesBetter(plusOne, 10)

  println(plusTenTimes(10))

  def toCurry(f: (Int, Int) => Int): Int => Int => Int = x => y => f(x, y)

  def fromCurry(f: Int => Int => Int): (Int, Int) => Int =
    (x, y) => f(x)(y)

  def compose[A, B, T](f: A => B, g: T => A): T => B = x => f(g(x))

  def afterThen[A, B, C](f: A => B, g: B => C): A => C = x => g(f(x))

  def superAdder2: (Int => Int => Int) = toCurry(_ + _)

  def add4 = superAdder2(4)

  println(add4(17))

  def simpleAdder3 = fromCurry(superAdder2)
  println(simpleAdder3(4, 17))

  val add2 = (x: Int) => x + 2
  val times3 = (x: Int) => x * 3

  val composed = compose(add2, times3)
  val ordered = afterThen(add2, times3)

  println(composed(4))
  println(ordered(4))

}
