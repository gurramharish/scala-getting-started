package com.hans._03collections

import scala.collection.immutable.SortedSet

object _04TransformingElements extends App {

  val evens: Int => Boolean = _ % 2 == 0

  val shortWords: String => Boolean = _.length <= 3

  val numbers = List(1, 2, 3, 4, 5, 6)
  val setSorted = SortedSet(2, 3, 4, 6, 7, 1, 10, 9, 8)
  val words = "The quick brown fox jumps over the lazy dog".split(" ").to(List)

  val evenNumbers = numbers.filter(evens)
  println(s"Event numbers $evenNumbers")
  val notEvens = numbers.filterNot(evens)
  println(s"Not evens $notEvens")
  val someEvens = numbers.withFilter(evens)
  println(s"Evens with filter : ${someEvens.map(_.toString)}")

  val partitions = words.partition(shortWords)
  println(s"Partitioned data : $partitions")

  val takeWhiles = numbers.takeWhile(_ < 5)
  println(s"TakeWhiles : $takeWhiles")

  val dropWhiles = evenNumbers.dropWhile(x => x % 4 == 0)
  println(s"Drop Whiles : $dropWhiles")

  println(setSorted.span(_ > 2))

  val smallWords = words.filter(shortWords)
  println(s"Small words $smallWords")

  // Map and flatMap
  val doubles: Int => Int = _ * 2

  val doubled = numbers.map(doubles)
  println(s"Doubled list : $doubled")

  val l1 = List("My Name is Harish Kumar", "My Age is 32")
  val totalNumberOfWords = l1.flatMap(_.split(" ")).size
  println(s"Total number of words :: $totalNumberOfWords")

  // Pipelining computations
  // validate credit card number
  def validate(number: String): Boolean = {
    val sum = number.map(_.asDigit)
      .reverse
      .zipWithIndex
      .map { case(digit, index) => if (index % 2 == 0) digit else digit * 2}
      .flatMap(number => List(number /10, number % 10))
      .sum
    sum % 10 == 0
  }

  println(s"Is Valid card 49927398716 : ${validate("49927398716")}")
  println(s"Is valid card 79927398711 : ${validate("79927398711")}")



}
