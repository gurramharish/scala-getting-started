val numbers = List(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
val res = numbers.foldLeft(0)((m, n) => m + n)

// Partial Application

val numbersFunc = numbers.foldLeft(List[Int]())_

val squares = numbersFunc((xs, x) => xs :+ x * x)

val cubes = numbersFunc((xs, x) => xs :+ x * x * x)

