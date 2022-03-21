package com.han.part3fp

object AllCombinations extends App {

  val numbers = List(1, 2, 3, 4)
  val chars = List('a', 'b', 'c', 'd')

  val combinations = for {
    c <- chars
    n <- numbers
  } yield s"$c$n"

  println(combinations)
}
