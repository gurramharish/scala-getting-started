trait HairColor

trait Iterator[A] {
  def hasNext: Boolean
  def next(): A
}

class IntIterator(to: Int = 10) extends Iterator[Int] {
  private var current = 0
  override def hasNext = current < to

  override def next() = {
    if(hasNext) {
      val t = current
      current += 1
      t
    } else 0
  }
}

val iterator = new IntIterator
iterator.next()
iterator.next()

val it2 = new IntIterator(2)
it2.next()
it2.next()
it2.next()

