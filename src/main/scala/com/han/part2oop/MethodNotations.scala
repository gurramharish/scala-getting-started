package com.han.part2oop

object MethodNotations extends App {

  class Person(val name: String, favoriteMovie: String, val age: Int) {

    // methods with 1 parameter can be called in infix notation sytle
    def likes(movie: String): Boolean = movie == favoriteMovie
    def +(person: Person) = s"${this.name} is hanging out with ${person.name}"
    def +(tag: String) = new Person(s"$name ($tag)", favoriteMovie, age)

    def unary_! : String = s"$name, what the heck?"
    def unary_+ : Person = new Person(name, favoriteMovie, age + 1)

    def isAlive: Boolean = true
    def apply(name: String): String = s"Hi, my name is $name and I like $favoriteMovie"

    def learns(s: String)  = s"$name learns $s"
    def leranScala: String = learns("Scala")
    def apply(times: Int) = s"$name wathced $favoriteMovie $times times"

  }

  val mary = new Person("Mary", "Inception", 30)
  println(mary likes "Inception")
  val tom = new Person("Tom", "Matrix", 31)
  println(mary + tom)
  println(mary.+(tom))

  // prefix notation(unary operators)
  val x = -1 // equivalent with 1.unary_-
  val y = 1.unary_-

  // unary_ prefix only works with - + ~ !
  println(!mary)

  import scala.language.postfixOps
  //post notation without parameters
  println(mary isAlive)

  // apply
  println(mary("Hans"))

  println((mary + "Rock the JVM").name)
  println((+mary).age)
  println(mary leranScala)
  println(mary(10))
}
