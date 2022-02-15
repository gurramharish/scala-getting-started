package com.han.part2oop

object CaseClasses extends App {

  case class Person(name: String, age: Int)

  // 1. Class parameters are fields in case classes
  val jim = new Person("Jim", 34)
  println(jim.name)

  // 2. sensible toString
  println(jim)

  // 3. equals and hashcode implemented
  val jim2 = new Person("Jim", 34)
  println(jim == jim2)

  // 4. CCs have handy copy method
  val jim3 = jim.copy(age = 40)
  println(jim3)

  // 5. Case classes have companion objects
  val thePerson = Person
  val mary = Person("Mary", 23)
  val temp = thePerson("Hello", 90)
  println(s"ThePerson : $temp")

  // 6. Case classes are serializable

  // 7. Case classes have extractor pattern = CCs can be used in PATTERN MATCHING

  case object UK {
    def name: String = "the UK of GB and NI"
  }

}
