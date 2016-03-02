package com.renho.basics

import scala.io.Source

object FunctionOps {
  def main(args: Array[String]): Unit = {
//    processData("C:/Users/renho/Desktop/scala.txt", 10)
    var increase = (x: Int) => x + 1
    println(increase(10))
    val someNums = List(1, 2, 3, 4, 5)
    someNums.foreach(println)
    someNums.filter(x => x > 0)
    someNums.filter(_ > 0)
    
    val f = (_: Int) + (_: Int)
    println(f(10, 100))
  }
  
  def processData(fileName: String, width: Int) {
    def processLine(line: String) {
      if(line.length < width) {
        println(line)
      }
    }
    val file = Source.fromFile(fileName)
    for(line <- file.getLines) {
      processLine(line)
    }
  }
}