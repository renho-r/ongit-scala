package com.renho.step.e10

/**
  * Created by renho on 2016/1/12.
  */
object SetTest {
	def main(args: Array[String]) {
		var jetSet = Set("Boeing", "Airbus")
		jetSet += "Lear"
		println(jetSet.contains("Cessna"))
	}
}
