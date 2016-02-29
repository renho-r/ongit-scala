package com.renho.hello

import scala.collection.mutable.ArrayBuffer

object ScalaInAction {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(136); 
  println("Welcome to the Scala worksheet");$skip(41); 
  var matrix = Array.ofDim[Double](3, 4);System.out.println("""matrix  : Array[Array[Double]] = """ + $show(matrix ));$skip(20); 
  matrix(2)(1) = 99}
  
}
