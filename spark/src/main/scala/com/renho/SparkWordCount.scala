package com.renho

import org.apache.spark.{SparkContext, SparkConf}

/**
  * Created by renho on 2016/1/7.
  */
object SparkWordCount {
	def main(args: Array[String]) {
		var conf = new SparkConf()
		conf.setMaster("spark://master:7077")
		conf.setAppName("SparkWordCount")
		var sc = new SparkContext(conf)
		sc.addJar("file:///d:/sparkData/lib/spark-wordcount-in-java-win.jar")

		var textFile = sc.textFile("file:///d:/sparkData/files", 2)
		textFile.collect().foreach(println)
		//统计count
		var result0 = textFile.flatMap(line => line.split("\\s+").map(word => (word, 1))).reduceByKey((a, b) => a + b)
		result0.collect().foreach(println)
//		取出现最多
		var result1 = textFile.flatMap(line => line.split("\\s+").map(word => (word, 1)))
			.reduceByKey((a,b) => a + b)
			.reduce((a, b) =>
				if (a._2 > b._2) {
					a
				} else {
					b
				}
			)
		println(result1);
		result0.lookup()
	}
}
