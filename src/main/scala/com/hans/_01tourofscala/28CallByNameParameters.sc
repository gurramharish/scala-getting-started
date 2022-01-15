import scala.util.Random

def calculate(input: => Int) = {
  println(s"Calculate invoked!!")
  input * 37
}

def provideNumber = {
  println("Get me a number!!")
  Random.nextInt(100)
}

calculate(provideNumber)
val number = provideNumber
calculate(number)


def whileLoop(condition: => Boolean)(body: => Unit): Unit =
  if(condition) {
    body
    whileLoop(condition)(body)
  }

var i = 2
whileLoop(i > 0) {
  println(i)
  i -= 1
}



