package com.renho.pattern_match

object Hello_Pattern_Match {
  def main(args: Array[String]): Unit = {
    var data = 30
    data match {
      case 1 => println("first")
      case 2 => println("second")
      case _ => println("unknown")
    }
    
    data = 2
    val result = data match {
      case i if 1 == i => "first" + i
      case i if 2 == i => "second" + i
      case _ => "unknown"
    }
    println(result)
    
    "Renho !".foreach{
      c =>
        println(
            c match {
              case ' ' => "space"
              case ch => "char:" + ch
            }
        )
    }
  }
}