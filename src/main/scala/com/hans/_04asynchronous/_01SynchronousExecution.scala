package com.hans._04asynchronous

object _01SynchronousExecution extends App {

  case class UserInfo(userId: Int, name: String, email: String)
  case class ContestInfo(contestId: Int, name: String)

  def fetchContestInfo(contestId: Int): ContestInfo = {
    println(s"[${Thread.currentThread()}] fetch contest info")
    ContestInfo(contestId, "Weekly Contest")
  }

  def fetchUserInfo(userId: Int): UserInfo = {
    println(s"[${Thread.currentThread()}] fetch user info")
    UserInfo(userId, "Harish Kumar", "ghk@gmail.com")
  }

  def registerParticipant(userId: Int, contestId: Int): Boolean = {
    println(s"${Thread.currentThread()} register participant")
    val contestInfo = fetchContestInfo(contestId)
    val userInfo = fetchUserInfo(userId)
    println(s"[${Thread.currentThread()}] \t contestInfo: $contestInfo \t userInfo: $userInfo")
    true
  }

  registerParticipant(10, 2);
  println(s"[${Thread.currentThread()}] main thread, performing other operations.")
}
