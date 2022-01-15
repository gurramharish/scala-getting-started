import java.util.Date

class Human(name: String, age: Int)
class Employee(val name: String, val age: Int) extends Human(name, age)
class ContractEmployee(name: String, age: Int, contractEnd: Date) extends Employee(name, age)

def employeeByAge(list: List[Employee]) = list.groupBy(e => e.age)
val listEmployees = List(
  new Employee("Harish", 31),
  new Employee("Sai", 29),
  new Employee("Json", 31),
  new Employee("Mike", 29)
)

val listContractEmployees = List(
  new ContractEmployee("Joe", 40, new Date),
  new ContractEmployee("Michele", 31, new Date),
  new ContractEmployee("Jake", 40, new Date)
)

employeeByAge(listEmployees)
employeeByAge(listContractEmployees)

// Contravariance with upper type bound to Employee
class AccessCard[-T <: Employee]

def access[T >: ContractEmployee <: Employee](card: AccessCard[T]) = {
  println("Accessed!!")
}

val ceCard = new AccessCard[ContractEmployee]
val eCard = new AccessCard[Employee]
//val guestCard = new AccessCard[Human] Upper bound till employee
access(ceCard)
access(eCard)
//access(guestCard)



val e = new Employee("H", 20)










