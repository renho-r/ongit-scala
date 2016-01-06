package com.renho

import org.apache.spark.{SparkContext, SparkConf}

/**
  * Created by renho on 2016/1/6.
  */
object MySparkTest {
	def main(args: Array[String]) {
		var conf = new SparkConf()
		conf.setAppName("MySparkTest")
		conf.setMaster("spark://master:7077")
		var sc = new SparkContext(conf)
		sc.addJar("file:///d:sparkData/lib/spark-wordcount-in-java-win.jar")
		var rdd = sc.parallelize(1 to 10)
		rdd.collect().foreach(println)

		var sum = rdd.map(i => i * 10).reduce((a, b) => (a + b))
		println(sum)
		sc.stop()
	}
}
