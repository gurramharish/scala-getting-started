package com.han.part2oop

object AnonymousClasses extends App {

  abstract class Animal {
    def eat: Unit
  }

  val funnyAnimal: Animal = new Animal {
    override def eat: Unit = println("I laugh while eating!! Ha ha ha ha!!")
  }

  val angryAnimal: Animal = new Animal {
    override def eat: Unit = println("I shout while eating!!")
  }
  funnyAnimal.eat
  println(funnyAnimal.getClass)
  angryAnimal.eat
  println(angryAnimal.getClass)

  class Person(val name: String) {
    def sayHi: Unit = println(s"Hi, my name is $name, how can I help")
  }

  val welcomePerson = new Person("Harish") {
    def welcome(guestName: String) = println(s"Welcome !! $guestName :)")

  }
  welcomePerson.welcome("Sai")
  welcomePerson.sayHi
  println(welcomePerson.getClass)
}
