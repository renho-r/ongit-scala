package com.renho

/**
  * Created by renho on 2016/1/6.
  */
object ScalaTest {
	def main(args: Array[String]) {
		var i = 0;
		for(i <- 1 until 10) {
			println(i);
		}

		for(i <- 1 to 10) {
			println(i);
		}
	}
}
