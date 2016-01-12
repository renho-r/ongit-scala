package com.renho.step.e11

/**
  * Created by renho on 2016/1/12.
  */
object FuncTest {
	def formatArgs(args: Array[String]) = args.mkString("\n")
	def main(args: Array[String]) {
//		print(formatArgs(Array("one", "two", "three")))
		val res = formatArgs(Array("zero", "one", "two"))
		assert(res == "zero\none\ntwo")
	}
}
