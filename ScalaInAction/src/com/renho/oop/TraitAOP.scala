package com.renho.oop

trait Action {
  def doAction
}

trait TBeforeAfter extends Action {
  abstract override def doAction {
    println("before")
    super.doAction
    println("after")
  }
}

trait TAfterBefore extends Action {
  abstract override def doAction {
    println("after123")
    super.doAction
    println("before456")
  }
}

class Work extends Action{
  override def doAction = println("working...")
}

object TraitAOP extends App {
  val wfa = new Work with TBeforeAfter with TAfterBefore
  wfa.doAction
}