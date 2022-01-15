case class MyPair[A, B](x: A, y: B)

val p = MyPair(1, "Scala")

def id[T <: Long](x: T) = x * x

Seq(1, 2, 3).map(_ * 2)

