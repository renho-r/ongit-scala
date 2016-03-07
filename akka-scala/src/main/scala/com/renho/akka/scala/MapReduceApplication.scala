package com.renho.akka.scala

import akka.actor.{Props, ActorSystem}
import com.renho.akka.scala.actors.MasterActor
import com.renho.akka.scala.messages.Result

/**
  * Created by renho on 2016/3/7.
  */
object MapReduceApplication {
	def main(args: Array[String]) {
		val system = ActorSystem("HelloAkka")
		val master = system.actorOf(Props[MasterActor], name = "master")
		master ! "hello renho"
		master ! "hello renho"
		master ! "hello renho"
		master ! "hello renho haha"
		Thread.sleep(500)
		master ! new Result
		system.terminate()
	}
}
