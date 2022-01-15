class User

val user = new User

class Point(var x: Int, var y: Int = 0) {
  def move(dx: Int, dy: Int): Unit = {
    x = x + dx
    y = y + dy
  }

  override def toString: String = s"($x, Sy)"
}

class SafePoint {
  private var _x = 0
  private var _y = 0
  private val bound = 100

  // getter methods
  def x = _x
  def y = _y
  def printWarning = println("WARNING: Out of bounds")

  // setter method x(_= is the special operator for setter methods)
  def x_=(newValue: Int): Unit = {
    if(newValue < bound) _x = newValue else printWarning
  }

  // setter method y
  def y_=(newValue: Int): Unit = {
    if(newValue < bound) _y = newValue else  printWarning
  }

  override def toString: String = s"(${_x}, ${_y})"
}


var safePoint = new SafePoint
safePoint.x = 1000
safePoint.y = 20
safePoint.x = 30
println(s"Safe point $safePoint")




