def volume = 1000
println(s"Volume is : $volume")

var stockPrice = 79

println(s"Stock price is : $stockPrice")

stockPrice = 78

println(s"Now stock price is : $stockPrice")

val name = {
  println("Invoking expression block!!")
  var firstName = "Harish"
  val lastName = "Gurram"
  s"$firstName $lastName"
}

println(s"Full Name is: $name")

// def keyword is used to define methods which are
// evaluated each time they are invoked
def finalValue: Int = stockPrice * volume

finalValue

// lazy val

val faceValue = 5

lazy val lazyFaceValue = 5

faceValue

lazyFaceValue





