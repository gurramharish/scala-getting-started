package com.han.part2oop

import org.w3c.dom.css.Counter

class Person(name: String, val age: Int) {

  println("Person instansiated!!!")
  val x = age

  def greet(name: String): Unit = println(s"${this.name} says: Hi, $name")

  //multiple construcotrs
  def this(name: String) = this(name, 0)
  def this() = this("Harish", 0)
}
// class parameters are NOT FIELDS
// To convert class parameters to Fields is by add val or var keyword


class Writer(val firstName: String, val surName: String, val year: Int) {
  def fullName = s"$firstName $surName"
}

class Novel(name: String, year: Int, author: Writer) {
  def authorAge = year - author.year
  def isWrrittenBy(author: Writer) = author == this.author
  def copy(newYear: Int) = new Novel(name, newYear, author)
}

class Counter(val count: Int) {
  def inc = new Counter(count + 1)
  def dec = new Counter(count - 1)
  def inc(n: Int): Counter = {
    if(n <= 0) this
    else inc.inc(n - 1)
  }
  def dec(n: Int): Counter = {
    if(n <= 0) this
    else dec.dec(n - 1)
  }

  def print = println(count)
}

object OOBasics extends App {

  val person = new Person("harish", 30)
  println(person.age)

  val author = new Writer("Charles", "Dickens", 1812)
  val imposter = new Writer("Charles", "Dickens", 1812)

  val counter = new Counter(10)
  val newCounter = counter.inc(10)
  newCounter.print
}
