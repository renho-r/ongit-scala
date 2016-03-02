package com.renho.function

object Curring {
  def main(args: Array[String]): Unit = {
    def m(x: Int) = (y: Int) => x * y
    println(m(10)(20))
    
    def curring(x: Int)(y: Int) = x * y
    println(curring(10)(10))
    
    val a = Array("hello", "renho")
    val b = Array("Hello", "Renho")
    
    println(a.corresponds(b)(_.equalsIgnoreCase(_)))
  }
}