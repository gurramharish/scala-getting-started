package com.hans._02methodsandfunctions._01functions

object _08Closures extends App {

  val multipleOf = (number: Int) => {
    (x: Int) => x * number
  }

  val multipleOf6 = multipleOf(6)
  println(s"Multiple 20 with 6 :${multipleOf6(20)}")
  println(s"Multiple 14 with 7 :${multipleOf(7)(14)}")
}
