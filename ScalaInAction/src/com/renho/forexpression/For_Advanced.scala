package com.renho.forexpression

object For_Advanced {

  def main(args: Array[String]) {
    println(map(List(1, 2, 3, 4, 5), (_: Int)*2))
    val result = for{
      i <- 1 to 10
    } yield i * 2
    println(result)
  }
  
  def map[A, B](list: List[A], f: A => B): List[B] =
		  for(element <- list) yield f(element)
  def flatMap[A, B](list: List[A], f: A => List[B]): List[B] =
		  for(x <- list; y <- f(x)) yield y
  def filter[A](list: List[A], f: A => Boolean): List[A] =
		  for(elem <- list if f(elem)) yield elem
}