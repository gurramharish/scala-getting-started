package com.hans._05type.classes.parameterization

import com.hans._05type.classes.parameterization._03CurrencyTransfer.Currency.{INR, SGD}

object _03CurrencyTransfer extends App {

  sealed trait ISOCountryCode
  object ISOCountryCode {
    case object SG extends ISOCountryCode
    case object IN extends ISOCountryCode
  }


  abstract class Currency(val isoCode: ISOCountryCode, val desc: String)
  case object SGD extends Currency(ISOCountryCode.SG, "Singapore Dollar")
  case object INR extends Currency(ISOCountryCode.IN, "Indian Rupees")

  object Currency {
    type SGD = SGD.type
    type INR = INR.type
  }

  case class Amount[T](value: Double, currency: T) {
    def add(amount: Double): Amount[T] = this.copy(value = value + amount)
    def sub(amount: Double): Amount[T] = {
      require(value > amount, "Not enough value to subtract")
      this.copy(value = value - amount)
    }

    def add(amount: Amount[T]): Amount[T] = add(amount.value)
    def sub(amount: Amount[T]): Amount[T] = sub(amount.value)
  }

  case class TransferInfo[S, R](sending: Amount[S], receiving: Amount[R], fee: Amount[S], conversionRate: Amount[R])

  val sendingAmount: Amount[SGD] = Amount(1000, SGD)

  val fee = sendingAmount.copy(value = 0.0058 * sendingAmount.value)
  val conversionRate: Amount[INR] = Amount(55.38, INR)

  val amountToBeConverted = sendingAmount.sub(fee.value)
  val receivingAmount = Amount(amountToBeConverted.value * conversionRate.value, conversionRate.currency)

  val transferInfo = TransferInfo[SGD, INR](sendingAmount, receivingAmount, fee, conversionRate)
  println(s"Transfer Information is $transferInfo")

}
