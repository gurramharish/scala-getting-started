package com.han.effective.scala.programming.week2

import scala.annotation.tailrec

object Loops extends App {

  def factorialFoldLeft(n: Int): BigInt = (1 to n).foldLeft[BigInt](1){(acc: BigInt, elem: Int) => acc * elem}

  def imperativeFactorial(n: Int): Int = {
    var acc = 1
    var i = 1
    while (i <= n) {
      i = i + 1
      acc *= i
    }
    acc
  }

  def recursiveFactorial(n: Int): Int = {
    if(n == 0) 1 else n * recursiveFactorial(n - 1)
  }

  def factorial(n: Int): BigInt = {
    @tailrec
    def factorialTailRec(i: Int, accumulator: BigInt): BigInt = {
      if(i == 0) accumulator
      else factorialTailRec(i - 1, i * accumulator)
    }
    factorialTailRec(n, 1)
  }

  println(s"Factorial of 3 : ${factorialFoldLeft(3)}")
  println(s"Factorial imperative 10 : ${imperativeFactorial(10)}")
//  println(s"Factorial of 10000 : ${factorial(100000)}")
  println(recursiveFactorial(1))
  println(recursiveFactorial(2))
  println(recursiveFactorial(3))
  println(recursiveFactorial(4))

  case class Task(name: String, duration: Int, requirements: List[Task])

  def totalDuration(task: Task): Int = {
    val time = task.requirements.map(totalDuration).maxOption.getOrElse(0)
    task.duration + time
  }

   val csSetup = Task("CS Setup", 4, Nil)
  val IDE = Task("IDE", 3, Nil)
  val hack = Task("hack", 8, List(csSetup, IDE))
  val deploy = Task("deploy", 3, List(hack))
  println(s"Total duration : ${totalDuration(deploy)}")
}
