package com.renho.basics

object RegExpressOps {
  def main(args: Array[String]): Unit = {
    val regex = """([0-9]+) ([a-z]+)""".r
    
    for(matchString <- regex.findAllIn("123 abc, 456 def")) {
      println(matchString)
    }
    
    println(regex.findFirstIn("123 abc, 456 def"))
    
    val regex(num, str) = "789 ghi"
    println(num + ":" + str)
    
    val line = "01234 abcdefg"
    line match {
      case regex(num, str) => println(num + ":" + str)
      case _ => println("no")
    }
  }
}