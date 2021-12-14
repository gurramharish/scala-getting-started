package com.hans._02methodsandfunctions._03exceptionhandling

import java.io.{FileNotFoundException, IOException}
import scala.io.{BufferedSource, Source}

object _01ExceptionHandling extends App {

  // Imperative try catch finally block

  def getLinesFromFile(fileName: String): List[String] = {
    var sourcePath: BufferedSource = null
    try {
      sourcePath = Source.fromFile(fileName)
      println("Reading file completed")
      sourcePath.getLines().toList
    } catch {
      case ex: FileNotFoundException => {
        println("File not found")
        List()
      }
      case ex: IOException => {
        println("Input/Output Exception")
        List()
      }
    } finally {
      println("Close file if it has been opened")
      if(sourcePath != null) {
        println("Closing file")
        sourcePath.close()
      }
    }
  }

  val lines = getLinesFromFile("src/main/resources/dividendStocks.csv")
  lines.foreach(println)
  println("-------------------------------------- End of code reached")
}
