package com.renho.spark

import org.apache.spark.{SparkConf, SparkContext}

object MyTest {
  def main(args: Array[String]): Unit = {
    println("start")
    var conf = new SparkConf()
    conf.setAppName("MySparkTest")
    conf.setMaster("spark://192.168.31.150:7077")
    var sc = new SparkContext(conf)
    sc.addJar("file:///Users/renho/workspace/spark-deploy/spark-hive.jar")
    var rdd = sc.parallelize(1 to 10)
    rdd.collect().foreach(println)

    var sum = rdd.map(i => i * 10).reduce((a, b) => (a + b))
    println(sum)
    sc.stop()
  }
}
