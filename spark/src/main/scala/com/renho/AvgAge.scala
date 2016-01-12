package com.renho

import org.apache.spark.{SparkContext, SparkConf}

/**
  * Created by renho on 2016/1/12.
  */
object AvgAge {
	def main(args: Array[String]) {
		var sparkConf = new SparkConf()
		sparkConf.setMaster("spark://master:7077")
		sparkConf.setAppName("AvgAge")
		var sc = new SparkContext(sparkConf)
		sc.addJar("file:///d:/sparkData/lib/spark-wordcount-in-java-win.jar")

		var rdd = sc.textFile("file:///home/hadoop/sample_age_data.txt")
		var count = rdd.count()
		val sum = rdd.map(lines => lines.split(" ")(1).toInt).reduce((a, b) => (a.toInt + b.toInt))
		println("AvgAge:" + (sum/count))
	}
}
