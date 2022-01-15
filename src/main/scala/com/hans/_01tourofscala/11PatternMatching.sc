import scala.util.Random

val x: Int = Random.nextInt(10)

x match {
  case 0 => "zero"
  case 1 => "one"
  case 2 => "two"
  case 3 => "three"
  case 4 => "four"
  case _ => "above 4"
}

abstract class Notification

case class Email(sender: String, title: String, body: String) extends Notification
case class SMS(caller: String, message: String) extends Notification
case class VoiceRecording(contactName: String, link: String) extends Notification

def showNotification(notification: Notification): String = notification match {
  case Email(sender, title, _) => s"You got an email from $sender with title: $title"
  case SMS(number, message) => s"You got an SMS from $number! Message: $message"
  case VoiceRecording(contactName, link) => s"You received a voice recording from $contactName! Click the link to hear it: $link"
}

showNotification(SMS("9922993399", "Hi Harish! How are you?"))

// Pattern Guards are the if condition to make case more specific
val importantPeopleInfo = List("8670222", "ghk@gmail.com")
def showImportantNotification(notification: Notification): String = notification match {
  case Email(sender, _, _) if importantPeopleInfo.contains(sender) => "You got email from special one!"
  case SMS(number, _) if importantPeopleInfo.contains(number) => "You got a SMS from special someone!"
  case other => showNotification(other)
}

showImportantNotification(Email("ghk@gmail.com", "Regarding KT!", "KT about Sharding"))

// Matching on type only
abstract class Device
case class Phone(model: String) extends Device {
  def screenOff = "turning screen off"
}
case class Computer(model: String) extends Device {
  def screenSaverOn = {
    println("Called Screen Saver On!")
    "Turning screen saver on...."
  }
}

def goIdle(device: Device) = device match {
  case p: Phone => p.screenOff
  case c: Computer => c.screenSaverOn
}

goIdle(Phone("Samsung Galaxy 9+"))

// Sealed classes
sealed abstract class Furniture
case class Couch() extends Furniture
case class Chair() extends Furniture

def findPlaceToSit(piece: Furniture): String = piece match {
  case a: Couch => "Lie on the couch"
  case b: Chair => "Sit on the chair"
}

findPlaceToSit(new Chair)







