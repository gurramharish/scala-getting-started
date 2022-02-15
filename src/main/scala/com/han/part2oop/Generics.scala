package com.han.part2oop

object Generics extends App {

  class MyList[+A] {
    def add[B >: A](element: B): MyList[B] = ???
    /*
      A = Cat
      B = Animal
     */
  }

  class MyMap[Key, Value]
  val listOfIntegers = new MyList[Int]
  val stringIntMap = new MyMap[String, Int]

  // generic methods
  object MyList {
    def empty[T]: MyList[T] = new MyList[T]
  }
  print(MyList.empty[Int])

  // Variance problem
  class Animal
  class Cat extends Animal
  class Dog extends Animal

  // 1. Yes List[Cat] extends List[Animal] = Covariance
  class CovariantList[+A]
  val animal: Animal = new Cat
  val animalList: CovariantList[Animal] = new CovariantList[Cat]
  val dogList: CovariantList[Animal] = new CovariantList[Dog]

  // animalList.add(new Dog) ??? HARD Question -> We return list of Animal

  // 2. No = Invariance
  class InvariantList[A]
  val animals: InvariantList[Animal] = new InvariantList[Animal]
//  val catsInvariance: InvariantList[Animal] = new InvariantList[Cat] - Compilation error
  val catsInvariance: InvariantList[Cat] = new InvariantList[Cat]

  // 3. Hell No(Opposite of Covariant) = CONTRAVARIANCE
  class ContravariantList[-A]
  val cats: ContravariantList[Cat] = new ContravariantList[Animal]
  val dogs: ContravariantList[Dog] = new ContravariantList[Animal]
//  val animals: ContravariantList[Animal] = new ContravariantList[Cat] - Compilation Error

  // Bound type
  class Cage[A <: Animal](animal: A)
  val cage = new Cage[Animal](new Cat)
  println(s"Cage :$cage")

  class Car
//  val cage2 = new Cage(new Car) - Compilation error saying Car do not conform to value type parameter bounds[A <: Animal]
}
