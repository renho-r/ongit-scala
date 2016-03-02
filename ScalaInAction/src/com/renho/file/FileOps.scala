package com.renho.file

import scala.io.Source
import java.io.PrintWriter
import java.io.File
import scala.io.StdIn

object FileOps {
  def main(args: Array[String]): Unit = {
    val file = Source.fromFile("C:/Users/renho/Desktop/scala.txt")
//    val file = Source.fromURL("http://spark.apache.org/")
//    for(line <- file.getLines()) {
//      println(line)
//    }
//    file.foreach {println}
//    file.foreach {print}
//    println("------------")
//    file.reset()
//    file.foreach {print}
    
//    val pw = new PrintWriter(new File("C:/Users/renho/Desktop/scala.txt_bak"))
//    file.foreach {pw.print}
//    file.close
//    pw.close()
    println("input XXX")
    val str = StdIn.readLine()
    println(str)
  }
}