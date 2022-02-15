package com.han.effective.scala.programming.week6

import scala.io.Source

object TryCatchFinally extends App {

  val data = Source.fromResource("data.txt").getLines.toList
  println(data)

}
