package com.hans._05type.classes.parameterization

object _06TypeErasure extends App {

  def listOf[T](list: List[T]): String = {
    list match {
      case _: List[Int] => "Integer"
      case _: List[String] => "String"
      case _ => "Any"
    }
  }

  val numbers = List(1, 2, 3)
  println(listOf(numbers))

  val words = List("one", "two", "three")
  println(listOf(words))


}
