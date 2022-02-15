package com.han.part2oop

object Exceptions extends App {


//  val aWeirdValue = throw new NullPointerException

  def getInt(withExceptions: Boolean): Int = if(withExceptions) throw new RuntimeException("No Int for you") else 42

  // try catch is expression in scala
  val potentialFail = try {
    getInt(true)
  } catch {
    case e: RuntimeException => 20
  } finally {
    println("finally")
  }

}

