package com.renho.basics

object MapOps {
  def main(args: Array[String]): Unit = {
    val map = Map("scala" -> 1, "spark" -> 2)
    println(map)
    for((k, v) <- map) {
      println(k + ":" + v)
    }
    for((k, _) <- map) {
      println(k + ":")
    }
  }
}