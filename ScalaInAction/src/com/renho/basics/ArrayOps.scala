package com.renho.basics

import scala.collection.mutable.ArrayBuffer
import scala.util.Sorting

object ArrayOps {
  def main(args: Array[String]): Unit = {
    val nums = new Array[Int](10)
    val a = new Array[String](10)
    val s = Array("hello ", "scala")
    s.foreach { print }
    println
    s(1) = "renho"
    s.foreach { print }
    
    val b = new ArrayBuffer[Int]()
    b += 1
    b += (1, 2, 3, 5)
    b ++= Array(8, 13, 21)
    println(b)
    println(b.trimEnd(5))
    println(b)
    b.insert(2, 6)
    println(b)
    b.insert(2, 7, 8, 9)
    println(b)
    b.remove(2)
    println(b)
    b.remove(2, 3)
    println(b)
    
    println(b.toArray)
    val c = for(e <- b.toArray) yield 2 * e
    c.foreach(println)
    
    val result = for(e <- b.toArray) 2 * e
    println(result)
    def x():String = {
      "renho"
    }
    println(x)
    
    c.filter(2 == _).map(println)
    c.filter(e => 2 == e).map(println)
    println(c.sum)
    println(s.max)
    s.sorted.foreach(println)
    Sorting.quickSort(c)
    println(c.mkString(","))
    println(c.mkString("[[", ",", "]]"))
    
    var matrix = Array.ofDim[Double](3, 4)
    matrix(3)(4) = 99
  }
}