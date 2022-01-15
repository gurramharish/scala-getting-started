package com.hans._05type.classes.parameterization

object StringConversions {
  implicit def tokenizer(title: String): List[String] = title.split("\\s").toList

}

object _10ImplicitConversions extends App {

  def capitalizer(words: List[String]): List[String] = words.map(_.capitalize)

  import StringConversions._
  println(capitalizer("hello world! - good morning!!").mkString(" "))

}
