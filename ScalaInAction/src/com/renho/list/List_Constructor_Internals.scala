package com.renho.list

abstract class Big_Data
class Hadoop extends Big_Data
class Spark extends Big_Data

object List_Constructor_Internals {

  def main(args: Array[String]){
    val hadoop = new Hadoop :: Nil
    val big_Data = new Spark :: hadoop
    
    println(hadoop)
    println(big_Data)
  }

}