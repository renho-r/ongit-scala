import java.io.{FileOutputStream, OutputStreamWriter, BufferedWriter, FileWriter}

import scala.io.Source

/**
  * Created by renho on 2016/4/20.
  */
object Main {
	def main (args: Array[String]) {
		val lines = Source.fromFile("C:\\Users\\renho\\Desktop\\ip_as_cc\\ip_as_cc.txt").getLines().toList
	}
}
