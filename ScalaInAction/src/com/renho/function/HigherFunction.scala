package com.renho.function

import scala.math._

object HigherFunction {
  def main(args: Array[String]): Unit = {
    (1 to 9).map("*" * _).foreach(println)
    (1 to 9).filter(_%2 == 0).foreach(println)
    println((1 to 9).reduceLeft(_ * _))
    println((1 to 9).reduce(_ * _))
    "hello renho scala is abc".split(" ").sortWith(_.length < _.length).foreach(println)
    
    val fun = ceil _
    val num = 3.14
    println(fun(num))
    Array(3.14, 1.42, 2.0, 4.99).map(fun).foreach(println)
    
    val triple = (x: Double) => x * 3
    Array(3.14, 1.42, 2.0, 4.99).map(triple).foreach(println)
    Array(3.14, 1.42, 2.0, 4.99).map((x: Double) => x * 3).foreach(println)
    Array(3.14, 1.42, 2.0, 4.99).map{(x: Double) => x * 3}.foreach(println)
    
    def higher_order_functions(f: (Double) => Double) = f(0.25)
    println(higher_order_functions(ceil _))
    println(higher_order_functions(floor))
    
    def mulBy(factor: Double) = (x: Double) => factor * x
    println(mulBy(100)(100))
    
    val quintuple = mulBy(5)
    println(quintuple(10))
    println(higher_order_functions((x: Double) => x*3))
    println(higher_order_functions(mulBy(5)))
    println(higher_order_functions(3 * _))
    
    val fun2 = 3 * (_: Double)
    println(fun2(3))
    
    val fun3: (Double) => Double =  _ * 3
    println(fun3(100))
  }
}