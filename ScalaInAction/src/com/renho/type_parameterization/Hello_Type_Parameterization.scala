package com.renho.type_parameterization

import scala.collection.immutable.Queue
import scala.reflect.ClassTag

class Triple[F, S, T](val first: F, val second: S, val third: T)
class Renho[R: ClassTag]
class ConcreteRenho[U: ClassTag, T: ClassTag] extends Renho[U]()

object Hello_Type_Parameterization {

  def main(args: Array[String]) {
    val triple = new Triple("Spark", 3, 3.1415)
    val bigData = new Triple[String, String, Char]("Spark", "Hadoop", 'R')
    
    def getData[T](list : List[T]) = list(list.length / 2)
    println(getData(List("Spark", "Hadoop", 'R')))
    val f = getData[Int] _
    println(f(List(1,2,3,4,5,6)))
    
    val queue = Queue(1,2,3,4,5)
    val queue_appended = queue enqueue 6
    println("queue : " + queue + "   " + "queue_appended : " + queue_appended)
    
    val renho = new Renho
    val crenho = new ConcreteRenho[String, Int]
    
    def foo[A, B](f: A => List[A], b: A) = f(b)
    foo((x: Int) => List(x), 30)
    
  }

}