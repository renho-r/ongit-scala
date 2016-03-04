package com.renho.bestpractice

object Assinment_Internals {

  def main(args: Array[String]) {
    val a@b = 1000
    println("a = " + a + ", b = " + b)
    val (c,d) = (1000,2000)
//    val (e,F) = (1000,2000)
    val Array(g,h) = Array(1000,2000)
    println("g = " + g + ", h = " + h)
    println(Array(g, h)(0))
//    val Array(i,J) = Array(1000,2000) 
    object Test { val 1 = 1 } 
//    object Test { val 1 = 2 } 
    println(Test)
    
    var x@y = 100
    println("x = " + x + ", y = " + y)
    x = 2000
    println("x = " + x + ", y = " + y)
    y = 3000
    println("x = " + x + ", y = " + y)
  }

}