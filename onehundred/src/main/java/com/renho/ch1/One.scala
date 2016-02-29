package com.renho.ch1

/**
  * Created by renho on 2016/2/17.
  */
object One {
	val hi = 20
	def main(args: Array[String]) {
		val a = 0
		for(a <- 0 until hi) {
			printSpa(a)
			printSta(a)
			println()
		}
	}

	def printSpa(a: Int): Unit = {
		for(b <- 0 until hi - a - 1) {
			print(" ")
		}
	}

	def printSta(a: Int): Unit = {
		for(b <- 0 until 2 * a + 1) {
			print("*")
		}
	}
}
