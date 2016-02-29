package com.renho.oop

class Person {
  private var age = 0
  def increment() { age +=1}
  def current = age
}

class Student {
  var age = 0
  private var privateAge = 0
  private[this] var thisPrivateAge = 0
  def increment() { privateAge +=1; age += 1}
  var name = "Renho"
  
  def isYounger(other: Student): Student = if(privateAge<other.privateAge) this else other
//  def isYounger(other: Student): Student = if(thisPrivateAge<other.thisPrivateAge) this else other
}

object HelloOop {
  def main(args: Array[String]): Unit = {
    val person = new Person
    person.increment()
    person.increment
    println(person.current)
    
    val student = new Student
    println(student.age)
    student.age = 10
    println(student.name)
    
    val s0 = new Student
    s0.name = "s0"
    val s1 = new Student
    s1.name = "s1"
    
    s0.increment()
    var s2 = s0.isYounger(s1)
    println(s2.name)
    s2 = s1.isYounger(s0)
    println(s2.name)
  }
}