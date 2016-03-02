package com.renho.basics

object ArrayOperations {
  def main(args: Array[String]): Unit = {
    val arr = Array(1, 2, 3, 4, 5)
    println(arr)
    arr.foreach(println)
    for(a <- 0 until arr.length) println(arr(a))
    for(a <- arr) println(a)
  }
}