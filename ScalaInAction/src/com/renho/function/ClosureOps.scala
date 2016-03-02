package com.renho.function

object ClosureOps {
  def main(args: Array[String]): Unit = {
    val data = List(1, 2, 3, 4, 5, 6)
    var sum = 0
    data.foreach(sum += _)
    println(sum)
    println(data.sum)
    
    def add(more: Int) = (x: Int) => x + more
    val a = add(1)
    val b = add(100)
    println(add(100)(200))
    println(a(100))
    println(b(100))
  }
}