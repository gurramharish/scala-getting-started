val words = List("Harish", "Kumar", "Gurram")

val splitsList = words.map(_.split("").toList)

val splitAsSingleList = words.flatMap(_.split("").toList)

val upperCaseWords = words.flatMap(_.toUpperCase)

val numbers = List(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)

val squares = numbers.map(num => num * num)

def filterNonAlphabets(s: String): Option[String] =
  if(s != null)
    Some(s.filter(c => (c >= 65 && c <= 90) || (c >= 97 && c <= 122) || c == 32))
  else None


def capitalizeWords(s: String): Option[String] =
  if(s != null)
    Some(s.split(" ")
      .map(_.capitalize)
      .mkString
    )
  else None

def removeAllSpaces(s: String): Option[String] =
  if (s != null)
    Some(s.replaceAll("\\s+", ""))
  else None


def camelCase(s: String) = {
  filterNonAlphabets(s)
    .flatMap { filtered =>
      capitalizeWords(filtered)
        .flatMap {
          capitalized => removeAllSpaces(capitalized)
        }
    }
}

print(s"Camel case :: ${camelCase("I am number one 1")}")

// For comprehension for flat maps
def camelCaseForComprehension = (s: String) => {
  for {
    filtered <- filterNonAlphabets(s)
    capitalized <- capitalizeWords(filtered)
    camelCased <- removeAllSpaces(capitalized)
  } yield camelCased
}

println(s"Camel case for :: ${camelCaseForComprehension("I am number one 10")}")
println(s"All numbers : ${camelCaseForComprehension("123444")}")

