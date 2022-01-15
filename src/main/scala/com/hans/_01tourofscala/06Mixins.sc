abstract class Booter {
  def message(): Unit
}
trait A extends Booter {
  override abstract def message(): Unit = {
    super.message()
    println("Message from trait A")
  }
}

trait B extends Booter {
  override abstract def message(): Unit = {
    super.message()
    println("Message from trait B")
  }
}


class FirstBooter extends Booter{
  override def message(): Unit = {
    println("I am from FirstBooter")
  }
}

val booter = new FirstBooter with B with A
booter.message()

// Mixin examples

abstract class M {
  val message: String
}

class M1 extends M {
  override val message: String = "I'm an instance of class M1"
}

trait M2 extends M {
  def loudMessage = message.toUpperCase
}

class M3 extends M1 with M2
val m3 = new M3
println(m3.message)
println(m3.loudMessage)

// Abstract class with abstract Type T
abstract class AbsIterator {
  type T
  def hasNext: Boolean
  def next(): T
}

class StringIterator(s: String) extends AbsIterator {
  override type T = Char

  private var i = 0

  override def hasNext = i < s.length

  override def next() = {
    val ch = s charAt i
    i += 1
    ch
  }
}

trait RichIterator extends AbsIterator {
  def foreach(f: T => Unit): Unit = while (hasNext) f(next)
}

class RichStringIterator(s:String) extends StringIterator(s) with RichIterator

val richStringIterator = new RichStringIterator("HarishKumar")
richStringIterator.foreach(println)





