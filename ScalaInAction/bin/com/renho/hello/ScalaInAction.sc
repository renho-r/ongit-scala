package com.renho.hello

import scala.collection.mutable.ArrayBuffer

object ScalaInAction {
  println("Welcome to the Scala worksheet")       //> Welcome to the Scala worksheet
  var matrix = Array.ofDim[Double](3, 4)          //> matrix  : Array[Array[Double]] = Array(Array(0.0, 0.0, 0.0, 0.0), Array(0.0,
                                                  //|  0.0, 0.0, 0.0), Array(0.0, 0.0, 0.0, 0.0))
  matrix(2)(1) = 99                               //> java.lang.ArrayIndexOutOfBoundsException: 3
                                                  //| 	at com.renho.hello.ScalaInAction$$anonfun$main$1.apply$mcV$sp(com.renho.
                                                  //| hello.ScalaInAction.scala:8)
                                                  //| 	at org.scalaide.worksheet.runtime.library.WorksheetSupport$$anonfun$$exe
                                                  //| cute$1.apply$mcV$sp(WorksheetSupport.scala:76)
                                                  //| 	at org.scalaide.worksheet.runtime.library.WorksheetSupport$.redirected(W
                                                  //| orksheetSupport.scala:65)
                                                  //| 	at org.scalaide.worksheet.runtime.library.WorksheetSupport$.$execute(Wor
                                                  //| ksheetSupport.scala:75)
                                                  //| 	at com.renho.hello.ScalaInAction$.main(com.renho.hello.ScalaInAction.sca
                                                  //| la:5)
                                                  //| 	at com.renho.hello.ScalaInAction.main(com.renho.hello.ScalaInAction.scal
                                                  //| a)
  
}