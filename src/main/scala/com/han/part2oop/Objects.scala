package com.han.part2oop

import scala.language.postfixOps

object Objects extends App {

  // SCALA DOES NOT HAVE CLASS LEVEL FUNCTIONALITY ("static")

  object Person {
    // static/class level
    val N_EYES = 2
    def canFly = false
    // Scala object = SINGLETON INSTANCE

    def apply(mother: Person, father: Person): Person = new Person("Boobie")
  }

  class Person(name: String) {
    def nameOfPerson = name
  }

  println(Person.N_EYES)
  print(Person canFly)
  val mary = new Person("Mary")
  val jhon = new Person("Jhon")
  val boobie = Person(mary, jhon)

  // Scala Applications = Scala object with
  // def main(args: Array[String]): Unit {}
}
