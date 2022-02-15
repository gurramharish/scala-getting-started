package com.han.part3fp

object WhatsAFunction extends App {

  // use functions as first class elements
  // problem: oop

  val doubler = new MyFunction[Int, Int] {
    override def apply(element: Int): Int = element * 2
  }

  println(doubler(2))

  val stringToIntConverter = new Function[String, Int] {
    override def apply(v1: String): Int = v1.toInt
  }

  val adder: (Int, Int) => Int = (v1: Int, v2: Int) => v1 + v2

  println(stringToIntConverter("10") + 10)
  println(adder(10, 20) + 30)

  // ALL SCALA FUNCTIONS ARE OBJECTS
  val stringConcatenation = (s1: String, s2: String) => s"$s1 $s2"
  println(stringConcatenation("Harish", "Kumar"))

  val higherOrderFunction: Int => Int => Int = (n: Int) => {
    (v: Int) => n * v
  }

  val multiplierOf10 = higherOrderFunction(10)
  println(multiplierOf10(3))

  println(higherOrderFunction(10)(20))
}

trait MyFunction[A, B] {
  def apply(element: A): B
}
