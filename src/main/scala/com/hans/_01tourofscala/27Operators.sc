// Any method with the single parameter

case class Vec(x: Double, y: Double) {
  def +(that: Vec): Vec = Vec(this.x + that.x, this.y + that.y)
}

val vector1 = Vec(20.0, 30.0)
val vector2 = Vec(12.0, 14.0)

val vector3 = vector1 + vector2

case class MyBool(x: Boolean) {
  def and(that: MyBool): MyBool = if(x) that else this
  def or(that: MyBool): MyBool = if(x) this else that
  def negate: MyBool = MyBool(!x)
}

def not(x: MyBool) = x.negate
def xor(x: MyBool, y: MyBool) = (x or y) and not(x and y)

xor(MyBool(true), MyBool(false))
xor(MyBool(true), MyBool(true))
xor(MyBool(false), MyBool(false))
xor(MyBool(false), MyBool(true))







