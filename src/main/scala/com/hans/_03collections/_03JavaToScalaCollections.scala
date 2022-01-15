package com.hans._03collections

import java.util
import scala.jdk.FunctionWrappers.AsJavaConsumer
import scala.jdk.CollectionConverters._

object _03JavaToScalaCollections extends App {

  val scala = List[Int]()
  val java = new util.ArrayList[Int]()
  java.add(1)
  java.add(2)

  scala.foreach(println(_))
  java.forEach(AsJavaConsumer[Int](n => println(s"-$n")))

  for(e <- scala) {
    println(e)
  }

  for (e <- java.asScala) {
    println(e)
  }

  // scala to java
  val moreJava= scala.asJava
}
