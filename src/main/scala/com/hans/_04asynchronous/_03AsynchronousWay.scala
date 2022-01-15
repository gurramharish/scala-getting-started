package com.hans._04asynchronous

import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.Future

object _03AsynchronousWay extends App {

  case class UserInfo(userId: Int, name: String, email: String)
  case class ContestInfo(contestId: Int, name: String)

  def fetchContestInfo(contestId: Int): Future[ContestInfo] = Future {
    println(s"[${Thread.currentThread()}] fetch contest info")
    Thread.sleep(2000L)
    ContestInfo(contestId, "Weekly Contest")
  }

  def fetchUserInfo(userId: Int): Future[UserInfo] = Future {
    println(s"[${Thread.currentThread()}] fetch user info")
    Thread.sleep(3000L)
    UserInfo(userId, "Harish Kumar", "ghk@gmail.com")
  }

  def registerParticipant(userId: Int, contestId: Int): Future[Boolean] = Future {
    println(s"${Thread.currentThread()} registerParticipant")
    val contestInfoFuture = fetchContestInfo(contestId)
    val userInfoFuture = fetchUserInfo(userId)
    for {
      userInfo <- userInfoFuture
      contestInfo <- contestInfoFuture
    }  { println(s"[${Thread.currentThread()}] \t contestInfo: $contestInfo \t userInfo: $userInfo")}
    true
  }

  val firstParticipant = registerParticipant(10, 2);
  firstParticipant.foreach(registered => println(s"[${Thread.currentThread()}] main thread, participant registered $registered."))

  Thread.sleep(10000L)
}
