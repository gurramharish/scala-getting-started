package com.hans._02methodsandfunctions._02methods

import scala.util.Random

object _03TypeParameters extends App {

  // Generic function
  def pickRandom[A](list: Seq[A]) = list(Random.nextInt(list.length))


  val stock = pickRandom(List("MSFT", "GOOG", "TM", "DB", "TSLA", "DNB"))
  val quantity = pickRandom(List(10, 20, 30, 400, 500, 100, 1000))
  val value = pickRandom(List(10.0, 30.5, 20.2, 45.9, 50.0, 60.2))

  println(s"The pick for the day is $quantity shares of $stock if price is greater than $value")
}
