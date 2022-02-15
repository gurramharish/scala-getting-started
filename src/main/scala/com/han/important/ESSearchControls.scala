package com.han.important

object ESSearchControls extends App {


  object SearchControls {
    val x = loadConfig
    def loadConfig = {
      println("Load config executed!!")
      "Hello"
    }
  }

  println("Loading Search control objects!!")
  val x = new {SearchControls}
  println(SearchControls.x)
  println(SearchControls.x)
  println(SearchControls.x)
  println(SearchControls.x)
  println(SearchControls.x)
}
