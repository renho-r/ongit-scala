package com.renho.ch10

/**
  * Created by renho on 2016/1/12.
  */
abstract class Element {
	def contents: Array[String]
	val height = contents.length
	val width =
		if (height == 0) 0 else contents(0).length
}