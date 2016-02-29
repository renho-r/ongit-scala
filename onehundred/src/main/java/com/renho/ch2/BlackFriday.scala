package com.renho.ch2

import java.text.SimpleDateFormat
import java.util.Calendar

/**
  * Created by renho on 2016/2/18.
  */
object BlackFriday {
	def main(args: Array[String]) {
		val df = new SimpleDateFormat("yyyy-MM-dd")
		val cld = Calendar.getInstance()
		for(year <- 2000 to 2016; month <- 0 to 11) {
			cld.set(year, month, 13)
			if(5 == cld.get(Calendar.DAY_OF_WEEK) - 1) {
				println("黑色星期五:" + df.format(cld.getTime))
			}
		}
	}
}
