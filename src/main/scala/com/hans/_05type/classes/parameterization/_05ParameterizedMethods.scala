package com.hans._05type.classes.parameterization

object _05ParameterizedMethods extends App {

  def operationP[T](a: T, b: T, op: (T, T) => T) = op(a, b)

  println(operationP[Int](20, 22, (a: Int, b: Int) => a + b))
}
