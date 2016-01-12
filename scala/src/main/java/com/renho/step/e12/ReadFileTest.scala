package com.renho.step.e12

import scala.io.Source

/**
  * Created by renho on 2016/1/12.
  */
object ReadFileTest {
	def main(args: Array[String]) {
//		if (args.length > 0) {
//			for (line <- Source.fromFile(args(0)).getLines)
//				println(line.length + " " + line)
//		}
//		else
//			Console.err.println("Please enter filename")

		val lines = Source.fromFile(args(0)).getLines.toList
//		var maxWidth = 0
//		for (line <- lines)
//			maxWidth = maxWidth.max(widthOfLength(line))

		val longestLine = lines.reduceLeft((a, b) => if (a.length > b.length) a else b)
		val widths = lines.map(widthOfLength)
		println(widths)
		val maxWidth = widthOfLength(longestLine)
		for (line <- lines) {
			val numSpaces = maxWidth - widthOfLength(line)
			val padding = " " * numSpaces
			println(padding + line.length + " | " + line)
		}
	}
	def widthOfLength(s: String) = s.length.toString.length
}
