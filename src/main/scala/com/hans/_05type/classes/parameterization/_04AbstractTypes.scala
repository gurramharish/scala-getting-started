package com.hans._05type.classes.parameterization

import scala.util.Random

abstract class Supplier {
  type T

  def get: T
}

object _04AbstractTypes extends App {

  val dice = new Supplier {
    override type T = Int

    override def get: T = Random.between(1, 7)
  }

  println(dice.get)
  println(dice.get)
}
