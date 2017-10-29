package com.renho.spark

import java.io.{File, FileWriter}

object CreateAgeFile {

  def main(args: Array[String]): Unit = {
    val fw = new FileWriter(new File("/Users/renho/sample_age_data.txt"), true)
    var rd = new scala.util.Random()
    var i = 0
    for(i <- 1 to 10 * 10000) {
      fw.write(i + " " + rd.nextInt(100))
      fw.write(System.getProperty("line.separator"))
    }
    fw.flush()
    fw.close()
  }

}
