package com.hans._03collections

case class OrderDetails(val id: String, val amount: Int)
case class Order(val customerName: String, val details: OrderDetails)
case class Address(val street: String, val postalCode: Option[Int])
case class Customer(val name: String, val address: Option[Address])
case class ShippingLabel(val customerName: String, val street: String, val postalCode: Int)

object Database extends Database

class Database {
  val customers = List[Customer](
    Customer("Harish", Option(Address("XYZ St", Option(518501)))),
    Customer("Sai", Option(Address("ABC St", None))),
    Customer("Dhikshan", Option(Address("BCD St", Option(223301)))),
  )

  def find(customerName: String): Option[Customer] = customers.find(_.name == customerName)
}
object _05Monads extends App {

  val orders = List[Order](
    Order("Harish", OrderDetails("HMK001", 11)),
    Order("Sai", OrderDetails("HMK002", 22)),
    Order("Dhikshan", OrderDetails("HMK003", 223)),
    Order("Anand", OrderDetails("HMK004", 111))
  )

  def generateShippingLabels() = {
    orders.flatMap(order => {
      Database.find(order.customerName)
        .flatMap(customer => customer.address.flatMap(address => address.postalCode.map(postalCode =>
        ShippingLabel(customer.name, address.street, postalCode))))
    })
  }

  def generateShippingLabelsWithForComprhension() = {
    for {
      order <- orders
      customer <- Database.find(order.customerName)
      address <- customer.address
      postalCode <- address.postalCode
    } yield {
      ShippingLabel(customer.name, address.street, postalCode)
    }
  }


}
