package com.renho.oop

trait Logger {
//  def log(msg: String)
  def log(msg: String){}
}

class ConcreteTrait extends Logger {
//  override def log(msg: String) = println("Log:" + msg)
  def concreteLog = log("It's ConcreteTrait")
}

class ConcreteTrait2 extends Logger with Cloneable {
  override def log(msg: String) = println("Log:" + msg)
  def concreteLog = log("It's ConcreteTrait2")
}

trait TraitLogger extends Logger {
  override def log(msg: String) = println("Log:" + msg)
}

object UseTrait extends App{
//  val logger = new ConcreteTrait
//  logger.concreteLog
  
//  val logger = new ConcreteTrait
  //混入trait
  val logger = new ConcreteTrait with TraitLogger
  logger.concreteLog
}