import java.util.Date

class Stack[A] {
  private var elements: List[A] = Nil
  def push(x: A): Unit = elements = x :: elements

  def peek: A = elements.head
  def pop(): A = {
    val currentTop = peek
    elements = elements.tail
    currentTop
  }
}

class Employee(name: String)
case class DirectEmployee(name: String) extends Employee(name)
case class ContractEmployee(name: String, contractEndDate: Date) extends Employee(name)

val employeeStack = new Stack[Employee]
employeeStack.push(new Employee("Harish"))
employeeStack.push(DirectEmployee("Sai"))
employeeStack.push(ContractEmployee("Jake", new Date))

println(employeeStack.pop())
println(employeeStack.pop())
println(employeeStack.pop())
