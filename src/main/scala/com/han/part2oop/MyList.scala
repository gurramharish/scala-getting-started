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

  def foreach(f: A => Unit): Unit

  def sort(compare: (A, A) => Int): MyList[A]

  def zipWith[B, C](list: MyList[B], zip: (A, B) => C): MyList[C]

  def fold[B](start: B)(f: (B, A) => B): B

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

  override def foreach(f: Nothing => Unit): Unit = ()

  override def sort(compare: (Nothing, Nothing) => Int): MyList[Nothing] = Empty

  override def zipWith[B, C](list: MyList[B], zip: (Nothing, B) => C): MyList[C] =
    if(!list.isEmpty) throw new IllegalArgumentException("Lists do not have the same length")
    else Empty

  override def fold[B](start: B)(f: (B, Nothing) => B): B = start
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

  override def foreach(f: A => Unit): Unit = {
    f(h)
    t.foreach(f)
  }

  override def sort(compare: (A, A) => Int): MyList[A] = {
    def insert(x: A, sortedList: MyList[A]): MyList[A] = {
      if(sortedList.isEmpty) new Cons(x, Empty)
      else if(compare(x, sortedList.head) <= 0) new Cons(x, sortedList)
      else new Cons(sortedList.head, insert(x, sortedList.tail))
    }

    val sortedTail = t.sort(compare)
    insert(h, sortedTail)

  }

  override def zipWith[B, C](list: MyList[B], zip: (A, B) => C): MyList[C] =
    if(list.isEmpty) throw new IllegalArgumentException("Lists do not have same length")
    else new Cons[C](zip(h, list.head), t.zipWith(list.tail, zip))

  override def fold[B](start: B)(f: (B, A) => B): B = {
    val newStart = f(start, h)
    t.fold(newStart)(f)
  }

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

  list.foreach(i => println(s"Hello: $i"))

  val unsortedList = new Cons[Int](11, new Cons[Int](1, new Cons[Int](3, Empty)))
  println(unsortedList.sort((a, b) => b - a))

  println(unsortedList.zipWith[Int, String](list, _ + "-" + _))

  // Fold
  println(unsortedList.fold(10){(s, i) => s + i})
  println(unsortedList.fold(10)(_ + _))

}
