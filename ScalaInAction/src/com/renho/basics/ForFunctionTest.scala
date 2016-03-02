package com.renho.basics

object ForFunctionTest {
  def main(args: Array[String]): Unit = {
    for(i <- 1 to 2; j <- 1 to 2) {
      print(100*i + j + " ")
    }
    println
    for(i <- 1 to 2; j <- 1 to 2 if i != j) {
      print(100*i + j + " ")
    }
    println
    def addA(x: Int) = x + 100
    println(addA(100))
    
    val add = (x: Int) => x + 100
    println(add(200))
    
    def fac(n: Int):Int = if(n<0) 0 else fac(n-1)
    println(fac(100))
    
    def defValue(i: Int = 0, str: String = " renho ") = i + str
    println(defValue())
    println(defValue(100, " hello "))
    println(defValue(100))
    println(defValue(str = " hello ", i = 200))
    
    def connected(args: Int*) = {
      args.foreach {println}
    }
    connected(1, 3, 5, 7, 9)
  }
}