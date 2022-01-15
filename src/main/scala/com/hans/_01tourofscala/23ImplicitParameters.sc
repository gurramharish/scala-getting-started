abstract class Monoid[A] {
  def add(x: A, y: A): A
  def unit: A
}

object ImplicitTest {

  implicit val stringMonoid: Monoid[String] = new Monoid[String] {
    override def add(x: String, y: String): String = x concat y

    override def unit = ""
  }

  implicit val intMonoid: Monoid[Int] = new Monoid[Int] {
    override def add(x: Int, y: Int): Int = x + y

    override def unit = 0
  }

  def sum[A](list: List[A])(implicit m: Monoid[A]): A = {
    if (list.isEmpty) m.unit
    else m.add(list.head, sum(list.tail))
  }

  def testImplicits() = {
    println(s"Sum Int : ${sum(List(1, 2, 3, 4, 5))}")
    println(s"Sum String: ${sum(List("a", "b", "c", "d", "e"))}")
  }
}

ImplicitTest.testImplicits()





