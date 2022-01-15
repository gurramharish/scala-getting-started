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

// For comprehension for flat maps
def camelCaseForComprehension = (s: String) => {
  for {
    filtered <- filterNonAlphabets(s)
    capitalized <- capitalizeWords(filtered)
    camelCased <- removeAllSpaces(capitalized)
  } yield camelCased
}