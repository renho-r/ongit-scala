package com.renho.basics

object Map_Tuple {
  def main(args: Array[String]): Unit = {
    val map = Map("str0" -> 0, "str1" -> 1, "str2" -> 2)
    println(map("str1"))
//    map("str1") = 100
    val mutableMap = scala.collection.mutable.Map("str0" -> 0, "str1" -> 1, "str2" -> 2)
    mutableMap("str1") = 100
    println(mutableMap)
    val str3 = mutableMap.getOrElse("str3", 100)
    println(str3)
    mutableMap += "str4" -> 4
    println(mutableMap)
    mutableMap -= "str0"
    println(mutableMap)
    
    val tp = (1, 2, "renho", (1, "x"))
    println(tp)
    val (n0, n1, s0, (nn0, ss0)) = tp
    println(nn0)
    println(tp._4._2)
    
    val up = "Hello Renho".partition(_.isUpper)
    println(up)
    
    val a = Array(1, 2, 3, 4)
    val b = Array("", "[", "]")
    val c = a.zip(b)
    val d = b.zip(a)
    c.foreach(println)
    d.foreach(println)
    println(c.length)
  }
}