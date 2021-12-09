package com.hans._02methodsandfunctions._01functions

object MethodAndFunctions extends App {

  val data = Array("Harish", "Kumar", "Gurram")

  // Part of the class
  // It has name, signature
  /*
    We can invoke the method just by its name without parenthesis'()'
    if the method is not taking any input as arguments
   */
  def getSizeMethod() = {
    println("getSizeMethod invoked!!")
    data.length
  }

  // is a object by itself, implementation of trait
  // parenthesis is must
  val getLengthFunction = () => {
    println("getLengthFunction invoked!!")
    data.length
  }

  println(s"getSizeMethod type : ${getSizeMethod.getClass}")
  println(s"getLengthFunction type : ${getLengthFunction.getClass}")

  println("----------------------- Invoking function and method --------------")

  println(s"Method : ${getSizeMethod()}")
  println(s"Method call without parenthesis : $getSizeMethod")
  println {
    s"Function : ${getLengthFunction()}"
  }
  println(s"function call without parenthesis : $getLengthFunction")

  // calling function by invoking apply() method
  println(s"Function invocation through apply : ${getLengthFunction.apply()}")
  // checking getLengthFunction is a implementation of Function0 trait
  println(s"is getLengthFunction of type Function0 : ${getLengthFunction.isInstanceOf[Function0[_]]}")

  // Methods and functions taking input arguments
  def existsMethod(name: String): Boolean = data.contains(name)

  val existsFunction: String => Boolean = (name: String) => data.contains(name)

  // A method can be coerced to function object by using method name followed by space and _
  // this uses partially applied functions
  val exists = existsMethod _

  println(s"Does 'Kumar' Exists method : ${existsMethod("Kumar")}")
  println(s"Does 'Hans' Exists function : ${existsFunction("Hans")}")
  println(s"Does 'Gurram' exists functions : ${exists("Gurram")}")
}
