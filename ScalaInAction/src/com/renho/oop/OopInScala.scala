package com.renho.oop

//class Teacher {
//  var name: String = _
//  private var age = 0
//  private[this] val gender = "male"
//  
//  def this(name: String) {
//    this
//    this.name = name
//  }
//}

//class Teacher(val name: String, val age: Int) {
//  private[this] val gender = "male"
//}

//class Teacher(namex: String, agex: Int) {
//  private[this] val gender = "male"
//  var name: String = namex
//  private var age = agex
//}

class Teacher private (val name: String, val age: Int) {
  var gender = "male"
  
  def this(name: String, age: Int, gender: String) {
    this(name, age)
    this.gender = gender
  }
}

object OopInScala {
  def main(args: Array[String]): Unit = {
//    val t0 = new Teacher
//    println(t0.name)
//    
//    val t1 = new Teacher("renho")
//    println(t1.name)
    
//    val t0 = new Teacher("renho", 10)
    val t0 = new Teacher("renho", 10, "male")
    println(t0.name)
  }
}