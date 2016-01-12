package com.renho.ch6

/**
  * Created by renho on 2016/1/12.
  */
object Testx {
	def main(args: Array[String]) {
		//隐式转换
		implicit def intToRational(x: Int) = new Rational(x)
		var r0 = new Rational(1, 2)
		println(2 * r0)
	}
}
