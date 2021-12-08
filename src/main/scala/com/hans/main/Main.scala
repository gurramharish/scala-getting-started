package com.hans.main

object Main {
  def main(args: Array[String]): Unit = {
    val Array(code: String, value: String) = args(0).split("\\s")
    if(!Set("CAD", "NZD").contains(code)) {
      println("Supported Currencies are CAD and NZD")
      sys.exit()
    }

    val utils = new Utils()
    val rate = utils.getRateFrom(code)
    val valueAsDouble = value.toDouble
    println(s"USD ${valueAsDouble * rate}")
  }
}

class Utils {
  private val cadToUsd: Double = 1/1.30
  private val nzdToUsd: Double = 1/1.50

  def getRateFrom(code: String): Double = {
    println(s"Getting rate for code $code")
    code match {
      case "CAD" => cadToUsd
      case "NZD" => nzdToUsd
    }
  }
}
