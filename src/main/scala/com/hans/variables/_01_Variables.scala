package com.hans.variables

import java.time.{LocalDate, LocalDateTime, ZoneId, ZonedDateTime}

object _01_Variables extends App {

  var number_1: Int = 10
  var number_2 = 200
  println(number_2)

  var aString = "He said \"I am good, how are you?\""
  println(aString)

  val anInt: Int = 5
  val aDouble: Double = 3.2
  val aFloat: Float = 1.3f
  val aLong: Long = 1000
  val aChar: Char = 'H'
  val aShort = 120
  val aByte: Byte = 1
  val aUnit: Unit = println("1")
  val anotherUnit: Unit = println("Hello")

  var five: AnyVal = 5

  // Declaring array
  var array: Array[Int] = Array(1, 2, 3, 4, 5)
  println("Hello array item : " + array(4))

  var aNull: Null = null

  // Type casting
  val short1 = 128
  val shortToInt = short1

  // Time and date
  val localDate = LocalDate.of(2021, 10, 20)
  println(localDate.isBefore(LocalDate.now()))

  val nextDate = localDate.plusDays(1)
  println(nextDate)
  val zonIds = ZoneId.getAvailableZoneIds
  println(zonIds)
  val zonedDate = ZonedDateTime.of(LocalDateTime.now(), ZoneId.of("US/Pacific"))
  println("Zoned date time : " + zonedDate)
}
