package com.renho.pattern_match

object Option_Internal {

  def main(args: Array[String]){
    val scores = Map("Alice" -> 99, "Spark" -> 100)
    scores.get("Aliced") match {
  	  case Some(score) => println(score)
  	  case None => println("No score")
  	}
  }
}