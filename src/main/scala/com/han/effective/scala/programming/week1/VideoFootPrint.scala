package com.han.effective.scala.programming.week1

import com.han.effective.scala.programming.week1.Network._

case class Experience(duration: Int, definition: Double, network: Network)

// Bellow code can be converted to Enum in Scala3
sealed trait Network
object Network {
  case object Fixed extends Network
  case object Mobile extends Network
}

object VideoFootPrint extends App {
  val lowQuality = 0.3
  val highQuality = 0.6

  val thirtyMinutes = 30 * 60

  val dataCenterEnergy = 0.000072
  val kgCO2PerKwh = 0.5

  def networkEnergy(network: Network) = network match {
    case Mobile => 0.00088
    case Fixed => 0.00043
  }

  val highQualityMobile = Experience(thirtyMinutes, highQuality, Network.Mobile)
  val lowQualityFixed = Experience(thirtyMinutes, lowQuality, Network.Fixed)

  def footPrint(experience: Experience): Double = {
    val megaBytes = experience.duration * experience.definition
    val energy = dataCenterEnergy + networkEnergy(experience.network)
    energy * megaBytes * kgCO2PerKwh
  }

  println(s"High Quality Mobile : ${footPrint(highQualityMobile)}")
  println(s"Low Quality Fixed : ${footPrint(lowQualityFixed)}")
}
