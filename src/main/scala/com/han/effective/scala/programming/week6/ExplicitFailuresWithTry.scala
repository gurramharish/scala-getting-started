package com.han.effective.scala.programming.week6

import java.time.LocalDate
import scala.util.Try

object ExplicitFailuresWithTry extends App {

  def attempt: Try[Unit] = Try {
    println("So far, so good")
    println("Still there")
    throw new RuntimeException("We can't continue")
    println("You will never see this")
  }

  // When there is a exception and you want to recover
  attempt.recover {
    case ex: RuntimeException => {
      System.err.println(s"Something went wrong, ${ex.getMessage}")
      print("Stopping the program")
    }
  }


  val handler: PartialFunction[Throwable, Unit] = {
    case ex: RuntimeException => println("An exception was thrown")
  }

  val handler2: PartialFunction[Throwable, Unit] =
    new PartialFunction[Throwable, Unit] {
      override def isDefinedAt(x: Throwable): Boolean = x match {
        case exn: RuntimeException => true
        case _ => false
      }

      override def apply(v1: Throwable): Unit = v1 match {
        case exn: RuntimeException => println(s"An exception was thrown $v1")
      }
    }

  attempt.recover(handler)


}
