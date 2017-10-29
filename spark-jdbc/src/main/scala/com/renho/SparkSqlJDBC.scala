package com.renho

import org.apache.spark.sql.SQLContext
import org.apache.spark.{SparkConf, SparkContext}

object SparkSqlJDBC {

  def main(args: Array[String]): Unit = {

    val conf = new SparkConf().setAppName("myApp")
    conf.setMaster("spark://master:7077")
    val sc = new SparkContext(conf)
    sc.addJar("file:///Users/renho/workspace/spark-deploy/spark-jdbc/spark-jdbc.jar")
    var sqlContext = new SQLContext(sc)


    val jdbcDF = sqlContext.read.format("jdbc").option("url", "jdbc:oracle:thin:@192.168.31.128:1521:ORCL")
      .option("driver", "oracle.jdbc.driver.OracleDriver").option("dbtable", "emp")
      .option("user", "c##scott").option("password", "tiger").load()

    jdbcDF.show
  }

}
