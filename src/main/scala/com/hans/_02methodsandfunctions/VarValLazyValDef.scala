package com.hans._02methodsandfunctions

object VarValLazyValDef extends App {

  val data = {
    println("Array is initialized")
    Array("MicroSoft", "Google", "TM")
  }

  println("Before accessing data")
  data.foreach(println)
  data(2) = "TSLA"
  println("------------------")
  data.foreach(println)

  def stockPrice = {
    println("Returning stock price")
    14
  }

  def volume = {
    println("Returning Volume")
    100
  }

  println("###################################")

  def finalValue = {
    println("Calculating final value")
    stockPrice * volume
  }

  println(s"Final value is $finalValue")

  println("------------------------------")
  println(s"Final value again $finalValue")

}
