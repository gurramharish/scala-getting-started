package com.hans._05type.classes.parameterization

 object TypeClass extends App {

   trait Combiner[T] {
     def combine(a: T, b: T): T
   }

   object Combiner {
     implicit val intCombiner: Combiner[Int] = (a: Int, b: Int) => a + b

     implicit val stringCombiner: Combiner[String] = (a: String, b: String) => a + b

     implicit def listCombiner[T]: Combiner[List[T]] = (a: List[T], b: List[T]) => a ++ b



   }

   object CombineOperations {
//     def combine[T](a: T, b: T)(implicit ev: Combiner[T]): T = ev.combine(a, b)

     // Context bound
     def combine[T: Combiner](a: T, b: T): T = implicitly[Combiner[T]].combine(a, b)

     def combine[T](a: T, b: T, c: T)(implicit ev: Combiner[T]): T = combine(a, combine(b, c))

     implicit class CombinerExt[T](pair: (T, T)) {
       def combine(implicit ev: Combiner[T]): T = ev.combine(pair._1, pair._2)
     }

   }

   object MyCombiner {
     implicit  val myStringCombiner: Combiner[String] = (a: String, b: String) => s"$a $b"


   }

   import CombineOperations._
   import MyCombiner.myStringCombiner
   val intCombined = combine(1, 2)
   val stringCombined = combine("Harish Kumar", "Gurram")
   val listCombined = combine(List(1, 2, 3), List(4, 5, 6))
   val helloMessageCombined = ("Hello", "World").combine
   val threeIntCombined = combine(10, 20, 30)

   println(s"Int Combined : $intCombined")
   println(s"String Combined: $stringCombined")
   println(s"List Combined : $listCombined")
   println(s"Message combined : $helloMessageCombined")
   println(s"3 Int combined : $threeIntCombined")

 }