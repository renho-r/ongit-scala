package com.renho.oop

abstract class SuperTeacher(val name: String) {
  var id: Int
  var age: Int
  def teach
}

class TeacherForMaths(name: String) extends SuperTeacher(name) {
  override var id: Int = name.hashCode()
  override var age: Int = 1
  override def teach() {
    println("teach")
  }
  def show() {
    println("show")
  }
}

object SuperTeacher {
  def main(args: Array[String]): Unit = {
    var tfm = new TeacherForMaths("renho")
    tfm.teach()
    println(tfm)
    tfm.show
    
    var st: SuperTeacher = new TeacherForMaths("renho")
    println(st)
//    st.show
  }
}