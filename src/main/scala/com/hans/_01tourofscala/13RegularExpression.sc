val numberPattern = "[0-9]".r

val matched = numberPattern.findFirstMatchIn("123121234ghj")

matched match {
  case Some(_) => println("Password Ok")
  case None => println("Password must contain a number")
}

// Key value pattern
val keyValPattern = "([0-9a-zA-Z- ]+): ([0-9a-zA-Z-#()/. ]+)".r

val input: String =
  """
    |background-color: #A03300
    |background-image: url(img/header100.png);
    |""".stripMargin

for(patternMatch <- keyValPattern.findAllMatchIn(input)) {
  println(s"key: ${patternMatch.group(1)}, value: ${patternMatch.group(2)}")
}
