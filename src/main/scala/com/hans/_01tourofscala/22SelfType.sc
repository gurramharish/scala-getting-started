trait User {
  def username: String
}

trait Tweeter {
  this: User => // reassign this
  def tweet(message: String) = println(s"$username: $message")
}

class VerifiedTweeter(val username_ : String) extends Tweeter with User {
  override def username = s"real $username_"
}

val realJustin = new VerifiedTweeter("Justin")
realJustin.tweet("Good Morning!!")