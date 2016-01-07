package com.renho.sogoulabs

import org.apache.spark.{SparkContext, SparkConf}

/**
  * Created by renho on 2016/1/7.
  */
/**
  * 格式说明：
	数据格式为
	访问时间\t用户ID\t[查询词]\t该URL在返回结果中的排名\t用户点击的顺序号\t用户点击的URL
	其中，用户ID是根据用户使用浏览器访问搜索引擎时的Cookie信息自动赋值，即同一次使用浏览器输入的不同查询对应同一个用户ID。
  */
object SoGouLog {
	def main(args: Array[String]) {
		var conf = new SparkConf()
		conf.setAppName("SoGouLog")
		conf.setMaster("spark://master:7077")
		var sc = new SparkContext(conf)
		sc.addJar("file:///d:/sparkData/lib/spark-wordcount-in-java-win.jar")

		var textFile = sc.textFile("file:///d:/sparkData/files/SogouQ.sample", 2)
	}
}
