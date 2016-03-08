package com.renho.akka.scala

import java.util.concurrent.TimeUnit

import akka.actor.{Kill, PoisonPill, Props, ActorSystem}
import akka.util.Timeout
import com.renho.akka.scala.actors.MasterActor
import com.renho.akka.scala.messages.{BackResult, Result}
import akka.pattern.{ ask, pipe }
import scala.concurrent.Future
import scala.concurrent.Await
import scala.io.Source

/**
  * Created by renho on 2016/3/7.
  */
object MapReduceApplication {
	def main(args: Array[String]) {
		val system = ActorSystem("HelloAkka")
		val master = system.actorOf(Props[MasterActor], name = "master")
		println(master.path)
		val file = Source.fromFile("pom.xml")
		for(line <- file.getLines()) {
			master ! line
		}
		Thread.sleep(500)

		implicit val timeout = Timeout(5, TimeUnit.SECONDS)
		val future = master ? new BackResult
		val result = Await.result(future, timeout.duration).asInstanceOf[String]
		println(result)

		val future0: Future[String] = ask(master, new BackResult).mapTo[String]
		println(future0)

//		master ! PoisonPill
//		master ! Kill

		system.terminate()
	}
}
