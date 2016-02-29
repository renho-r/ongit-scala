package com.renho.oop

class ApplyTest {
  def apply() = {
    println("class ApplyTest apply")
  }
  def show() {
    println("show")
  }
}

object ApplyTest {
  def apply() = {
    println("object ApplyTest apply")
    new ApplyTest()
  }
}

object ApplyOps {
  def main(args: Array[String]): Unit = {
    var at = ApplyTest()
    at()
    at.show()
  }
}