class Foo[+A] // A covariant class
class Bar[-A] // A contravariant class
class Baz[A] // An invariant class

abstract class Animal {
  def name: String
}
case class Cat(name: String) extends Animal
case class Dog(name: String) extends Animal

// Covariance(+) Will take only sub types
def printAnimalNames(animals: List[Animal]): Unit = animals.foreach {
  animal => println(animal.name)
}

val cats: List[Cat] = List(Cat("Whiskers"), Cat("Tom"))
val dogs: List[Dog] = List(Dog("Fido"), Dog("Rex"))

printAnimalNames(cats ++: dogs)
println("========================")
printAnimalNames(cats)

// Contravariance (-) Can take parent class objects
abstract class Printer[-A] {
  def print(value: A): Unit
}

class AnimalPrinter extends Printer[Animal] {
  override def print(value: Animal): Unit = println(s"I am animal's printer : ${value.name}")
}

def printMyCat(printer: Printer[Cat], cat: Cat): Unit = printer.print(cat)

printMyCat(new AnimalPrinter, Cat("Tom Cat"))

// Invariance Scala generic classes are invariant by default

class Container[A](value: A) {
  private var _value: A = value
  def getValue: A = _value
  def setValue(value: A): Unit = {
    _value = value
  }
}

val catContainer: Container[Cat] = new Container[Cat](Cat("Tim Tom"))
// The bellow line wont compile due to
//val animalContainer: Container[Animal] = catContainer


// Invariance other example
abstract class SmallAnimal extends Animal
case class Mouse(name: String) extends SmallAnimal

// Baeldung Variance Examples

sealed trait Test
class UnitTest extends Test
class IntegrationTest extends UnitTest
class FunctionalTest extends IntegrationTest

// Covariant
class TestSuite[+T](tests: List[T])

val suite: TestSuite[Test] = new TestSuite[UnitTest](List(new UnitTest))


// Contravariance
class Person(val name: String)
class Employee(name: String, val salary: Int) extends Person(name)
class Manager(name: String, salary: Int, val manages: List[Employee]) extends Employee(name, salary)

class Assert[-T, V](expr: (T, V) => Boolean) {
  def assert(target: T, value: V): Boolean = expr(target, value)
}

val personAssert = new Assert[Person, String]((p: Person, v: String) => p.name == v)
val employeeAssert = new Assert[Employee, String]((e, v) => e.name == v && e.salary > 1000)
val mangerAssert = new Assert[Manager, String]((m, v) => m.name == v && m.manages.nonEmpty)

trait Asserts[T, V] {
  def asserts: List[Assert[T, V]]
  def execute(target: T, value: V): Boolean = {
    asserts.map(a => a.assert(target, value))
      .reduce(_ && _)
  }
}

class AssertsEmployee(val asserts: List[Assert[Employee, String]]) extends Asserts[Employee, String]

val harish = new Employee("Harish", 500000)
val tester = new AssertsEmployee(List(personAssert, employeeAssert))
tester.execute(harish, "Bob")

// Invariance

class InvarianceAssert[T](expr: T => Boolean) {
  def assert(target: T): Boolean = expr(target)
}

val personAssert: InvarianceAssert[Person] = new InvarianceAssert[Person](p => p.name == "Bob")

