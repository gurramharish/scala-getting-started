package com.han.effective.scala.programming.week1

case class Card(shape: Shape, count: Count, color: Color, shade: Shading)

sealed trait Count
object Count {
  case object One extends Count
  case object Two extends Count
  case object Three extends Count
}

sealed trait Shape
object Shape {
  case object Diamond extends Shape
  case object Squiggle extends Shape
  case object Oval extends Shape
}
sealed trait Color
object Color {
  case object Red extends Color
  case object Green extends Color
  case object Purple extends Color
}
sealed trait Shading
object Shading {
  case object Stripped extends Shading
  case object Solid extends Shading
  case object Open extends Shading
}

object SetGame extends App {

  val deck = List(
    Card(Shape.Diamond, Count.One, Color.Purple, Shading.Stripped),
    Card(Shape.Oval, Count.Two, Color.Red, Shading.Open),
    Card(Shape.Squiggle, Count.Three, Color.Green, Shading.Open)
  )

 println(s"Is valid set : ${isValidSet(deck(0), deck(1), deck(2))}")

  def isValidSet(card1 : Card, card2: Card, card3: Card): Boolean = {
    checkProperty(card1.shade, card2.shade, card3.shade) &&
      checkProperty(card1.count, card2.count, card3.count) &&
      checkProperty(card1.color, card2.color, card3.color) &&
      checkProperty(card1.shape, card2.shape, card3.shape)
  }

  def checkProperty[T](t1: T, t2: T, t3: T): Boolean = {
    val allSame = t1 == t2 && t1 == t3
    val allDifferent = t1 != t2 && t1 != t3 && t2 != t3
    allSame || allDifferent
  }
}
