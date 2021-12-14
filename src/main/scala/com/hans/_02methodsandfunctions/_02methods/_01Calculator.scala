package com.hans._02methodsandfunctions._02methods

object _01Calculator {

  def computeSum(a: Int, b: Int): Int = a + b

  // procedure
  def printSum(a: Int, b: Int) {
    println(s"Sum : ${a + b}")
  }

  def main(args: Array[String]): Unit = {
    println(s"Compute Sum : ${_01Calculator.computeSum(10, 30)}")
    printSum(33, 22)
  }
}
