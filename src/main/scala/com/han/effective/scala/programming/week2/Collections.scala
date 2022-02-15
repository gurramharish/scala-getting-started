package com.han.effective.scala.programming.week2

import scala.collection.immutable.{Map => ImmutableMap}
import scala.collection.mutable
import scala.collection.mutable.{ArrayBuffer, Map => MutableMap}


object Collections extends App {

  val imMap = ImmutableMap(10 -> "Ten", 20 -> "Twenty")
  imMap + (30 -> "Thirty")

  val mutableMap = MutableMap(10 -> "Ten", 20 -> "Twenty")
  mutableMap += (30 -> "Thirty")

  println(imMap)
  println(mutableMap)

   // Empty constructors
  List.empty[Int]
  ArrayBuffer.empty[Double]

  // Constructing with Varargs
  List(1, 2, 3, 4)
  ArrayBuffer("a", "b", "c")
  Map("a" -> true)
  val pair1: (String, Int) = "Alice" -> 32
  val pair2: (String, Boolean) = ("Bob", true)
  val tuple: (Int, String, Boolean) = (10, "foo", true)

  def sampleVarargs(args: Int*) = args.length
  println(sampleVarargs(10, 20, 30, 40, 50))


  // Prepending and Appending Elements
  val l1 = List("a", "b", "c")
  val preL2 = "d" +: l1
  val appL2 = l1 :+ "d"
  println(l1, preL2, appL2)

  // We cannot use +: and :+ on Map because it does not store values in any particular order
  val myMap = Map("a" -> true) + ("b" -> false)
  println(myMap)

  // Transforming Collections
  val sampleMap = scala.collection.mutable.Map(1 -> "No", 2 -> "Yes", 3 -> "Hi")
  val newMap = sampleMap.map(s => (s._1, s._2 * s._1))
  val newList = sampleMap.map(s => s._2 * s._1)
  println(s"Simple map : $sampleMap")
  println(s"New Map : $newMap")
  println(s"List from Map : $newList")

  // FoldLeft
  val combinedString = newList.foldLeft(""){(acc, elm) => acc + elm}
  println(s"Combined string is $combinedString")
  val reverseList = newList.foldLeft(List.empty[String]){
    (acc, elm) => elm +: acc
  }
  println(s"Reverse List $reverseList")

  // Group by
  val emails = List("alice@sca.la", "bob@sca.la", "carol@ghk.com")

  val domain: String => String = email => email.dropWhile(c => c != '@').drop(1)
  println(s"Domain for ghk@harish.com : ${domain("ghk@harish.com")}")

  println(s"Drop right : ${"ghk@ghk.com".dropRight(4)}")

  val emailsByDomain = emails.groupBy(domain)
  println(s"Emails by domain are $emailsByDomain")
}
