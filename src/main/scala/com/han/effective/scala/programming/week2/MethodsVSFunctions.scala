package com.han.effective.scala.programming.week2


object MethodsVSFunctions extends App {

  def increment(x: Int): Int = {
    println("Method invoked")
    x + 1
  }

  val increment: Int => Int = x => {
    println("Function increment invoked!!")
    x + 1
  }

  for {
    i <- 1 to 10
  }  println(i)

  println(increment.getClass)


  def execute[T, R](value: T, f: T => R): R = f(value)

  println(execute(10, increment))

  val andThenIncrement = increment.andThen(increment).andThen(t => t + 40)
  println(andThenIncrement(20))

  val stringLengthInc = increment.compose[String](s => s.length)
  println(stringLengthInc("Harish"))


}
