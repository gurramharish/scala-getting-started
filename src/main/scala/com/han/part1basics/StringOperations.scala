package com.han.part1basics

object StringOperations extends App {

  val str: String = "Hell0, I am learning Scala"

  println(str.charAt(2))
  println(str.substring(0, 5))
  println(str.split("\\s").toList)
  println(str.replace(" ", "-"))
  println(str.toLowerCase)
  println(str.length)

  val aNumberString = "2"
  val aNumber = aNumberString.toInt
  println('a' +: aNumberString :+ 'z')

  // String interpolation
  val name = "David"
  val age = 12
  val greeting = s"Hello, my name is $name, and I am $age years old"
  println(greeting)

  // F-interpolation
  val speed = 1.2f
  val myth = f"$name%s can eat $speed%2.3f burgers perminute"
  println(myth)

  // raw-interpolator
  println(raw"This is a \n newline")
  val escaped = "This is a \n newline"
  println(s"$escaped")
  println(raw"$escaped")
}
