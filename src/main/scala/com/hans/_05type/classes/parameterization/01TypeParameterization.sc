case class Pair[T, U](fst: T, snd: U) {

  def switch: Pair[U, T] = this.copy(fst = snd, snd = fst)
  override def toString: String = s"$fst $snd"
}

val pair = Pair(1, "First")
val i = pair.fst

pair.switch

