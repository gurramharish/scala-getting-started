package com.hans._04asynchronous

object _02AsynchronousExecution extends App {

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
    var contestInfo: ContestInfo = null
    val t1 = threaded {
      contestInfo = fetchContestInfo(contestId)
    }
    var userInfo: UserInfo = null
    val t2 = threaded {
      userInfo = fetchUserInfo(userId)
    }
    t1.join()
    t2.join()
    println(s"[${Thread.currentThread()}] \t contestInfo: $contestInfo \t userInfo: $userInfo")
    true
  }

  def threaded(exec: => Any): Thread = {
    val child = new Thread {
      override def run(): Unit = exec
    }
    child.start()
    child
  }

  registerParticipant(10, 2);
  println(s"[${Thread.currentThread()}] main thread, performing other operations.")
}
