package com.renho.step.e10

import scala.collection.mutable.Map
/**
  * Created by renho on 2016/1/12.
  */
object MapTest {
	def main(args: Array[String]) {
		val treasureMap = Map[Int, String]()
		treasureMap += (1 -> "Go to island.")
		treasureMap += (2 -> "Find big X on ground.")
		treasureMap += (3 -> "Dig.")
		println(treasureMap)

		val romanNumeral = Map(
			1 -> "I", 2 -> "II", 3 -> "III", 4 -> "IV", 5 -> "V"
		)
		println(romanNumeral(4))
	}
}
