package com.renho.step.e7

/**
  * Created by renho on 2016/1/12.
  */
object ArrayTest {
	def main(args: Array[String]) {
//		var greetStrings = new Array[String](3)
		var greetStrings = Array("zero", "one", "two")
		greetStrings(0) = "hello"
		greetStrings(1) = " "
		greetStrings(2) = "world!\n"
		for(i <- 0 to 2) {
			print(greetStrings(i))
		}
	}
}
