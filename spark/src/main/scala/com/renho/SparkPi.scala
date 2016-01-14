/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

// scalastyle:off println
package com.renho

import org.apache.spark.deploy.worker.Worker
import org.apache.spark._

import scala.math.random

/** Computes an approximation to pi */
object SparkPi {
	def main(args: Array[String]) {
		val conf = new SparkConf().setAppName("Spark Pi")
		conf.set("spark.executor.extraJavaOptions", "-Xdebug -Xrunjdwp:transport=dt_socket,address=8005,server=y,suspend=n")
		System.setProperty("user.name", "hadoop")
		conf.setMaster("spark://master:7077")
		val spark = new SparkContext(conf)
		spark.addJar("file:///d:sparkData/lib/spark-wordcount-in-java-win.jar")

		println("sleep begin.")
		Thread.sleep(10000) //等待10s，让有足够时间启动driver的remote debug
		println("sleep end.")
		val slices = if (args.length > 0) args(0).toInt else 2
		val n = math.min(100000L * slices, Int.MaxValue).toInt // avoid overflow
		val count = spark.parallelize(1 until n, slices).map { i =>
				val x = random * 2 - 1
				val y = random * 2 - 1
				if (x*x + y*y < 1) 1 else 0
			}.reduce(_ + _)
		println("Pi is roughly " + 4.0 * count / n)
		spark.stop()
	}
}
// scalastyle:on println
