package com.renho.ch1

/**
  * Created by renho on 2016/2/18.
  */
object Two {
	def main(args: Array[String]): Unit = {
		for(a <- 1 to 9) {
			for(b <- 1 to a) {
				print(a + " * " + b + " = " + (a * b) + "\t")
			}
			println()
		}
	}
}
