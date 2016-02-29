package com.renho.oop

class Outer(val name: String) { outer => 
  class Inner(val name: String) {
    def showName(b: Inner){
      println("outerNmae:" + outer.name + "<=>innerName:" + b.name)
    }
  }
}

object OuterInner {
  def main(args: Array[String]): Unit = {
    val outer0 = new Outer("outer0")
    val outer1 = new Outer("outer1")
    val inner0 = new outer0.Inner("inner0")
    val inner1 = new outer1.Inner("inner1")
    inner0.showName(inner0)
  }
}