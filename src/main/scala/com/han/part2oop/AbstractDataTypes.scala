package com.han.part2oop

object AbstractDataTypes extends App {


  abstract class Animal {
    val creatureType: String = "wild"
    def eat: Unit
  }

  class Dog extends Animal {
    override val creatureType: String = "Canine"

    override def eat: Unit = println("Crunch, Crunch")

  }

  trait Carnivore {
    def eat(animanl: Animal): Unit
    val preferredMeat: String = "fresh meat"
  }

  class Crocodile extends Animal with Carnivore {
    override val creatureType: String = "croc"

    def eat: Unit = println("nom nom nom")

    override def eat(animanl: Animal): Unit = s"I'm a croc and I am eating ${animanl.creatureType}"
  }

  val dog = new Dog
  val croc = new Crocodile
  croc.eat(dog)

  // trait Behavior, abstract class - thing

}
