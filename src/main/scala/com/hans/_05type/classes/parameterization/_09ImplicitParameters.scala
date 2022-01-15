package com.hans._05type.classes.parameterization

import java.io.File

object PSFiles {

  def listFiles(implicit dir: String): Unit = {
    val file = new File(dir)
    if(file.isDirectory)
      file.list().foreach(f => println(f))
    else println("empty or no directory")
  }

  def listFilesCount(count: Int)(implicit dir: String): Unit = {
    val file = new File(dir)
    if(file.isDirectory)
      file.list().take(count).foreach(f => println(f))
    else println("empty or no directory")
  }

  object Implicits {
    implicit val current = "."
  }
}

object _09Implicit extends App {

  import PSFiles._
  import PSFiles.Implicits.current

  listFiles
  println("============")
  listFilesCount(3)
}
