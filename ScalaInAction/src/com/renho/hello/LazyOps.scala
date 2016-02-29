package com.renho.hello

import scala.io.Source

object LazyOps {
  def main(args: Array[String]): Unit = {
//    lazy val file = Source.fromFile("Eeee:/renho.txt")
    val file = Source.fromFile("Eeee:/renho.txt")
    println("Ok")
    file.getLines().foreach { println }
  }
}