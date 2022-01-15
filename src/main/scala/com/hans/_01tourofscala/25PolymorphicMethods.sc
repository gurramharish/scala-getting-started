def listOfDuplicates[A](x: A, length: Int): List[A] = {
  if (length < 1) {
    Nil
  } else x :: listOfDuplicates(x, length -1)
}

listOfDuplicates(10, 10)
listOfDuplicates("Ha", 3)

def fac(n: Int): Int = if (n == 0) 1 else n * fac(n - 1)