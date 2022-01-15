import scala.util.Random

object CustomerID {
  def apply(name: String) = s"$name-${Random.nextLong(100000)}"

  def unapply(customerID: String): Option[String] = {
    val stringArray: Array[String] = customerID.split("-")
    if(stringArray.tail.nonEmpty) Some(stringArray.head) else None
  }
}

val cID = CustomerID("Harish")
cID match {
  case CustomerID(name) => println(name)
  case _ => println("Could not extract a Customer ID")
}

class User(val name: String, val age: Int)

object User {
  def apply(name: String, age: Int) = new User(name, age)

  def unapply(user: User): Option[(String, Int)] = Some(user.name, user.age)
}

val user = User("Harish", 30)
println(user)
user match {
  case User((name, age)) => println(s"name: $name and age : $age")
  case _ => println("Unable to extract user !!")
}






















