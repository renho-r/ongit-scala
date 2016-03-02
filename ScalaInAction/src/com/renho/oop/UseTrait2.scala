package com.renho.oop

class Human {
  println("human")
}

trait TTeacher extends Human {
  println("TTeacher")
  def teach
}

trait PianoPlayer extends Human {
  println("PianoPlayer")
  def playPiano = println("PianoPlayer piano")
}

class PianoTeacher extends Human with TTeacher with PianoPlayer {
  override def teach = println("PianoTeacher teach")
}

object UseTrait2 extends App{
  val t1 = new PianoTeacher
  t1.playPiano
  t1.teach
  println("----------")
//  val t2 = new Human with TTeacher {
//    override def teach = println("Human with TTeacher teach")
//  }
//  t2.teach
  val t2 = new Human with TTeacher with PianoPlayer {
    override def teach = println("Human with TTeacher with PianoPlayer teach")
  }
  t2.teach
  t2.playPiano
}