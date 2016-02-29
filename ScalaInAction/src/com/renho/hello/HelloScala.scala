package com.renho.hello

import scala.io.StdIn
import java.io.File

object HelloScala {
  def main(args: Array[String]): Unit = {
    val files = (new File(".")).listFiles()
    files.foreach {println}
  }
}