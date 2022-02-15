package com.han.important

object Boot extends App {

}

abstract class Booter {
  val configData: String = loadConfig
  def loadConfig: String = {
    println("Loading config Data :: ")
    "Confgured"
  }
  def boot(): Unit
}

class FirstBooter extends Booter {

  def boot() = {
    println("First Booter invoked!")
  }
}

trait LastBooter extends Booter {

  abstract override def boot(): Unit = {
    super.boot()
    println("Last Booter finished!!")
  }
}

trait LiftBooter extends Booter {
  abstract override def boot(): Unit = {
    super.boot()
    println("Lisft Booter !!")
  }
}

