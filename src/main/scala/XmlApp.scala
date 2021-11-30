import scala.xml.{Elem, NodeSeq}

object XmlApp extends App {

  val person: Elem = <person>
    <firstName>Harish</firstName>
    <lastName>Gurram</lastName>
    <emails>
      <email type="primary">ghk@gmail.com</email>
      <email type="secondary">ghk1@gmail.com</email>
    </emails>
    <address>
      <street>SV Street</street>
      <city>Nandyal</city>
      <zip>518501</zip>
    </address>
  </person>

  val node: NodeSeq = person \ "firstName"

  println(node.text)
  (person \\ "email").foreach(e => println(e.text))
  (person \\ "@type").foreach{e => println(e)}
}
