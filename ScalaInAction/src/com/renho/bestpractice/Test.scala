package com.renho.bestpractice

class Test {
  def n = Test.num
}

object Test {
  var num = 100
}

object Main {
  def main(args: Array[String]): Unit = {
    val t0 = new Test
    val t1 = new Test
    println("t0=" + t0.n + ":" + "t1=" + t1.n)
    Test.num = 200
    println("t0=" + t0.n + ":" + "t1=" + t1.n)
    println(Test.num)
    println("t0=" + t0.n + ":" + "t1=" + t1.n)
  }
}