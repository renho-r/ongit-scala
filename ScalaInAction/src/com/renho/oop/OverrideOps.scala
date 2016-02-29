package com.renho.oop

class Person1(val name: String, var age: Int) {
  println("Person1")
  val school = "BJU"
  def sleep = "8 hours"
  override def toString() = "Person1 toString => name:" + name + "<=>age:" + age
}

class Worker(name: String, age: Int, val salary: Long) extends Person1(name, age) {
  override val school = "scala"
  override def sleep = "10 hours"
}

object OverrideOps {
  def main(args: Array[String]): Unit = {
    val p0 = new Person1("renho", 0)
    println(p0)
    println(p0.school)
    println(p0.sleep)
    
    val w0 = new Worker("renho", 0, 100)
    println(w0)
    println(w0.school)
    println(w0.sleep)
  }
}