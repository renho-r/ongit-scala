package com.renho.oop

class University {
  val id = University.newStudentNo
  val idPriv = University.newStudentNoPriv
  private var num = 0
  def aClass(number: Int) = this.num += number
}

object University{
  private var studentNo = 0
  def newStudentNo = {
    studentNo += 1
    studentNo
  }
  private def newStudentNoPriv = {
    
  }
}

object ObjectOps {
  def main(args: Array[String]): Unit = {
    println(University.newStudentNo)
    println(University.newStudentNo)
//    println(University.newStudentNoPriv)
    
  }
}