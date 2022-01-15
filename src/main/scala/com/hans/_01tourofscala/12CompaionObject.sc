
import scala.math

case class Circle(radius: Double) {
  import Circle._
  def area = calculateArea(radius)
}

object Circle {
  private def calculateArea(radius: Double): Double = {
    println("Calculate area of circle")
    math.Pi * math.pow(radius, 2.0)
  }
}
val c = Circle(10.2)
c.area
c.area






