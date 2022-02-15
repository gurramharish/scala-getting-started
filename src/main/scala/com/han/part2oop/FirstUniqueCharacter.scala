package com.han.part2oop

object FirstUniqueCharacter extends App {

  val s = "I love my India"
  val maps = s.replace(" ", "").toLowerCase.groupBy(_.toChar)
  val cMap = maps.map({
    case (x, d) => x -> d.size
  })
  println(s"Map class :${cMap.getClass}")
  println(s"Map : $cMap")
}
