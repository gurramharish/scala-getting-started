# Scala Big Picture

## Understanding the Scala Ecosystem

1. Supports Object-Oriented and Functional-Oriented Programming

2. Strong type system

3. Epoch, Major and Minor versions(2(Epoch).13(Major).7(Minor))

## Problem Scala Solves

1. Functional Over Imperative Style of Programming(Through expressions)
    
    ```scala
    def getNumber(a: Int, b: Int) = if (a < b) 10 else 5
    ```

2. Enables Multiple Inheritance using Traits(Traits are similar to Interfaces in Java)

3. Better Concurrency Support(Future API for asynchronous, Distributed Systems with Akka toolkit)

4. Less verbosity, High Developer Productivity

    ```scala
    // Immutable Instances, Pattern Matching, Instance Cloning with single line
    case class Person(first: String, last: String, age: Int)
    ```

## Advantages and Disadvantages

### Advantages

1. A blend of Object-Oriented and Functional Paradigm

2. A concise and expressive language

3. Interoperable with Java

4. A strongly typed language

### Disadvantages

1. High Learning curve

2. Takes a long time to compile(Dotty compiler in Scala 3 to improve compilation time)

## Scala Ecosystem and Use Cases

1. For type safe static sites Scala has Scala.js

2. Play framework for server side applications

3. Anorm, Slick and Hibernate for database

4. Akka library for concurrent distributed applications

5. BigDL, Cortex, MLlib, ScalaNLP for Big Data and Machine Learning projects

## Understanding Structure of Scala Programming

1. Defining variables

   ```scala
   val number: Int = 100
   ```

2. Unicode BMP Character Set(Basic Multilingual Plane)

3. Defining Functions

   ```scala
   def multiplyBy2(number: Int): Int = number * 2
   ```

## Control Structures

1. if, for, while, do-while

   ```scala
   val result = for (amount <- amounts) yield amount

   val results = for {
   amount <- amounts
   currency <- currencies
   multiple <- multiples
   if amount > 10 && amount < 45 && currency == "USD"
   if multiple >= 2
   } yield s"$currency ${multiple * amount}"
   ```
   
## Pattern Matching

1. Pattern matching is the act of checking a given sequence of tokens for the presence of the constituents of some pattern.

   ```scala
   input match {
      case 50 => println("$50")
      case 100 => {
        println("$100")
      }  
   }
   ```
