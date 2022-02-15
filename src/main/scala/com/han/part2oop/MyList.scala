package com.han.part2oop

import com.han.part2oop.Generics.{Animal => GAnimal}


abstract class MyList[+A] {

  def head: A

  def tail: MyList[A]

  def isEmpty: Boolean

  def add[B >: A](element: B): MyList[B]

  def map[B](transformer: A => B): MyList[B]

  def flatMap[B](transformer: A => MyList[B]): MyList[B]

  def filter(predicate: A => Boolean): MyList[A]

  def ++[B >: A](list: MyList[B]): MyList[B]


  def printElements: String

  override def toString: String = s"[$printElements]"

}

// Nothing is proper substitute for any type
case object Empty extends MyList[Nothing] {

  def head: Nothing = throw new NoSuchElementException

  def tail: MyList[Nothing] = throw new NoSuchElementException

  def isEmpty: Boolean = true

  def add[B >: Nothing](element: B): MyList[B] = new Cons(element, Empty)

  override def printElements: String = ""

  def map[B](transformer: Nothing => B): MyList[B] = Empty

  def flatMap[B](transformer: Nothing => MyList[B]): MyList[B] = Empty

  def filter(predicate: Nothing => Boolean): MyList[Nothing] = Empty

  def ++[B >: Nothing](list: MyList[B]): MyList[B] = list
}

case class Cons[+A](h: A, t: MyList[A]) extends MyList[A] {

  def head: A = h

  def tail: MyList[A] = t

  def isEmpty: Boolean = false

  def add[B >: A](element: B): MyList[B] = new Cons(element, this)

  override def printElements: String = if(t.isEmpty) s"$h" else s"$h ${t.printElements}"

  def filter(predicate: A => Boolean): MyList[A] = if(predicate(h)) new Cons(h, t.filter(predicate))
  else t.filter(predicate)

  def map[B](transformer: A => B): MyList[B] = new Cons(transformer(h), t.map(transformer))



  def ++[B >: A](list: MyList[B]): MyList[B] = new Cons[B](h, t ++ list)

  override def flatMap[B](transformer: A => MyList[B]): MyList[B] = transformer(h) ++ t.flatMap(transformer)
}

object ListTest extends App {

  val aa = new GAnimal

  println(aa.getClass)

  val list = new Cons(1, new Cons(2, new Cons(3, Empty)))
  println(list.tail.head)
  println(list.toString)

  val listOfIntegers: MyList[Int] = Empty

  val consIntList: MyList[Int] = new Cons[Int](10, new Cons[Int](20, Empty))
  println(consIntList)
  println(consIntList.map{value =>
    10 * value
  }.toString)

  println(list.flatMap{ value =>
    new Cons[Int](value, new Cons(value + 1, Empty))
  }.toString)
}
