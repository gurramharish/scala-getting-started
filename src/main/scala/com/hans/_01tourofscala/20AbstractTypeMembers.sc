trait Buffer {
  type T
  val element: T
}

abstract class SeqBuffer extends Buffer {
  type U
  type T <: Seq[U]
  def length = element.length
}

abstract class IntSeqBuffer extends SeqBuffer {
  type U = Int
}

def newIntSeqBuf(elem1: Int, elem2: Int): IntSeqBuffer =
  new IntSeqBuffer {
    type T = List[U]
    val element: this.T = List(elem1, elem2)
  }

def newIntSetBuf(e1: Int, e2: Int): IntSeqBuffer =
  new IntSeqBuffer {
    override type T = Set[U]
    override val element: this.T = Set(e1, e2)
  }

val buf = newIntSeqBuf(10, 20)
println(s"length = ${buf.length}")
println(s"content = ${buf.element}")


// abstract type members into type parameters of class

abstract class TBuffer[+T] {
  val element: T
}

abstract class TSeqBuffer[U, +T <: Seq[U]] extends TBuffer[T] {
  def length = element.length
}

def newTIntSeqBuf(e1: Int, e2: Int): TSeqBuffer[Int, Seq[Int]] =
  new TSeqBuffer[Int, List[Int]] {
    val element = List(e1, e2)
  }

val tBuf = newTIntSeqBuf(30, 40)
println(s"TBuf content = ${tBuf.element}")
