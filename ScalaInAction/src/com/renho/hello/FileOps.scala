package com.renho.hello

import scala.io.Source

object FileOps {
  def main(args: Array[String]): Unit = {
//    val file = Source.fromFile("./.classpath")
    val file = Source.fromURL("http://spark.apache.org/")
    for(line <- file.getLines()) {
      println(line)
    }
  }
}