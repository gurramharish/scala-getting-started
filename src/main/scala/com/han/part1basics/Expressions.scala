package com.han.part1basics

object Expressions extends App {

  val x = 1 + 2
  println(x)

  var aVariable = 10

  val aWeirdValue  = (aVariable = 3)
  println(s"A weird Value : $aWeirdValue")
  println(s"A variable value : $aVariable")

  val aCodeBlock = {
    println("I am going to define block scope variables and return some of them")
    val x = 10
    val y = 20
    x + y + this.x
  }
  println(s"A cobe block value : $aCodeBlock")

  val somevalue = {
    2 < 3
  }

  val someOtherValue = {
    if(somevalue) 239 else 986
    42
  }


  val shardNumber = {
    val dunsNumber = 858194459
    val numberOfShards = 2
    val whichLong = (dunsNumber | Long.MaxValue)
    println(s"Which Long : $whichLong")
    whichLong % numberOfShards + 1
  }

  println(s"Shard Number is : $shardNumber")

  println(s"20 & 18 = ${20 & 18}") // 10100 & 10010 = 10000
  println(s"20 | 18 = ${20 | 18}")

  val dsShardIndex = {
    val key = "f71d0ce3-1df6-3108-a3f9-f5a236b505a0"
    val hex = key.substring(32, 36)
    println(s"Hex from key is : $hex")
    val numOfShards = 9
    val keyNum = Integer.parseInt(hex, 16)
    keyNum % numOfShards + 1
  }

  println(s"DS ShardIndex from key is :$dsShardIndex")



}
