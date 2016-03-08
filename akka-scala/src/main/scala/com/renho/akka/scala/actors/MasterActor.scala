package com.renho.akka.scala.actors

import akka.actor.{ActorRef, Props, Actor}
import com.renho.akka.scala.messages.{BackResult, Result}

/**
  * Created by renho on 2016/3/7.
  */
class MasterActor extends  Actor{
	val aggregateActor: ActorRef = context.actorOf(Props[AggregateActor], name="aggregate")
	val reduceActor: ActorRef = context.actorOf(Props(new ReduceActor(aggregateActor)), name="reduce")
	val mapActor: ActorRef = context.actorOf(Props(new MapActor(reduceActor)), name="map")

	println(aggregateActor.path)
	println(reduceActor.path)
	println(mapActor.path)

	override def receive: Receive = {
		case message: String =>
//			mapActor ! message
			//Forwards the message and passes the original sender actor as the sender.
			mapActor.forward(message)
		case message: Result => aggregateActor ! message
		case message: BackResult => sender() ! "back result string"
		case _ =>
	}

	override def postStop(): Unit = {
		println("PostStop");
	}
}
