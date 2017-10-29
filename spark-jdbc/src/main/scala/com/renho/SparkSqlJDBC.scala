package com.renho

import java.util.Properties

import org.apache.spark.sql.{SQLContext, SaveMode}
import org.apache.spark.{SparkConf, SparkContext}
import org.apache.spark.sql.functions._

object SparkSqlJDBC {

  def main(args: Array[String]): Unit = {

    val conf = new SparkConf().setAppName("myApp")
    conf.setMaster("spark://master:7077")
    val sc = new SparkContext(conf)
    sc.addJar("file:///Users/renho/workspace/spark-deploy/spark-jdbc/spark-jdbc.jar")
    var sqlContext = new SQLContext(sc)


//    val jdbcDF = sqlContext.read.format("jdbc").option("url", "jdbc:oracle:thin:@192.168.31.128:1521:ORCL")
//      .option("driver", "oracle.jdbc.driver.OracleDriver").option("dbtable", "emp")
//      .option("user", "c##scott").option("password", "tiger").load()
    val properties = new Properties()
    properties.put("driver", "oracle.jdbc.driver.OracleDriver")
    properties.put("user", "c##scott")
    properties.put("password", "tiger")
    val jdbcDF = sqlContext.read.jdbc("jdbc:oracle:thin:@192.168.31.128:1521:ORCL", "emp", properties)

    jdbcDF.show
//    +-----+------+---------+----+--------------------+-------+-------+------+
//    |EMPNO| ENAME|      JOB| MGR|            HIREDATE|    SAL|   COMM|DEPTNO|
//    +-----+------+---------+----+--------------------+-------+-------+------+
//    | 7369| SMITH|    CLERK|7902|1980-12-17 00:00:...| 800.00|   null|    20|
//    | 7499| ALLEN| SALESMAN|7698|1981-02-20 00:00:...|1600.00| 300.00|    30|
//    | 7521|  WARD| SALESMAN|7698|1981-02-22 00:00:...|1250.00| 500.00|    30|
//    | 7566| JONES|  MANAGER|7839|1981-04-02 00:00:...|2975.00|   null|    20|
//    | 7654|MARTIN| SALESMAN|7698|1981-09-28 00:00:...|1250.00|1400.00|    30|
//    | 7698| BLAKE|  MANAGER|7839|1981-05-01 00:00:...|2850.00|   null|    30|
//    | 7782| CLARK|  MANAGER|7839|1981-06-09 00:00:...|2450.00|   null|    10|
//    | 7788| SCOTT|  ANALYST|7566|1987-01-24 00:00:...|3000.00|   null|    20|
//    | 7839|  KING|PRESIDENT|null|1981-11-17 00:00:...|5000.00|   null|    10|
//    | 7844|TURNER| SALESMAN|7698|1981-09-08 00:00:...|1500.00|   0.00|    30|
//    | 7876| ADAMS|    CLERK|7788|1987-04-02 00:00:...|1100.00|   null|    20|
//    | 7900| JAMES|    CLERK|7698|1981-12-03 00:00:...| 950.00|   null|    30|
//    | 7902|  FORD|  ANALYST|7566|1981-12-03 00:00:...|3000.00|   null|    20|
//    | 7934|MILLER|    CLERK|7782|1982-01-23 00:00:...|1300.00|   null|    10|
//    +-----+------+---------+----+--------------------+-------+-------+------+
//    jdbcDF.where("ename = 'ADAMS'").show
//    jdbcDF.filter("ename = 'ADAMS'").show
//    jdbcDF.select("ename", "sal").show
//    jdbcDF.selectExpr("ename", "sal * 1.1").show
//    jdbcDF.drop("deptno").show
//    jdbcDF.orderBy(desc("sal")).show
//    jdbcDF.dropDuplicates("deptno").show
//    jdbcDF.agg("EMPNO" -> "max", "sal" -> "max").show
//    val maxValue = jdbcDF.agg("sal" -> "max").first().get(0)
//    println(maxValue)
//    jdbcDF.where("sal=" + maxValue).show
//    jdbcDF.where("sal=" + )
//    jdbcDF.groupBy("deptno", "empno", "ename").max("sal").show
//    jdbcDF.groupBy("empno", "ename").agg(max("sal") as "sal").write.mode(SaveMode.Overwrite).format("jdbc").option("url", "jdbc:oracle:thin:@192.168.31.128:1521:ORCL")
//      .option("driver", "oracle.jdbc.driver.OracleDriver").option("dbtable", "renho")
//      .option("user", "c##scott").option("password", "tiger").save();

    sc.stop()

  }

}
