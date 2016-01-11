package com.renho.test

import java.io.{File, FileWriter}
import java.util.Random

/**
  * Created by renho on 2016/1/11.
  */
object CreateAvgFile {
	def main(args: Array[String]) {
		var fw = new FileWriter(new File("C:\\Users\\renho\\Desktop\\sample_age_data.txt"), false)
		var rand = new Random()
		var i = 0
		for(i <- 1 to 10 * 10000) {
			fw.write(i + " " + rand.nextInt(100))
			fw.write(System.getProperty("line.separator"))
		}
		fw.flush()
		fw.close()
	}
}
