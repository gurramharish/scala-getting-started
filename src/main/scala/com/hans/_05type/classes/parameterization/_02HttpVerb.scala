package com.hans._05type.classes.parameterization

import com.hans._05type.classes.parameterization.HttpUtlis.HttpVerb

import scala.util.{Failure, Success, Try}

object _02HttpVerb extends App {

  def toHttpVerbTry(verb: String): Try[HttpVerb] = Try {
    HttpUtlis.asHttpVerb(verb)
  }

  def toHttpVerbOption(verb: String): Option[HttpVerb] = Try {
    HttpUtlis.asHttpVerb(verb)
  }.toOption

  def toHttpVerbEither(verb: String): Either[Throwable, HttpVerb] = Try {
    HttpUtlis.asHttpVerb(verb)
  } match {
    case Success(value) => Right(value)
    case Failure(exception) => Left(exception)
  }

  println(toHttpVerbEither("get"))
  println(toHttpVerbEither("got"))

}

object HttpUtlis {

  sealed trait HttpVerb
  case object GET extends HttpVerb
  case object PUT extends HttpVerb
  case object POST extends HttpVerb

  def asHttpVerb(verb: String): HttpVerb =
    verb.toLowerCase match {
      case "get" => GET
      case "post" => POST
      case "put" => PUT
      case other => throw new IllegalArgumentException(s"No equivalent HttpVerb for $other")
    }
}
