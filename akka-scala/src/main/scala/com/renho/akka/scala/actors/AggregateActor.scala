package com.renho.akka.scala.actors

import akka.actor.Actor
import com.renho.akka.scala.messages.{Result, ReduceData}

/**
  * Created by renho on 2016/3/7.
  */
class AggregateActor extends Actor {

	var finalReduceMap: Map[String, Int] = Map[String, Int]()

	override def receive: Receive = {
		case message: ReduceData => aggregateInMemoryReduce(message.reduceDataMap)
		case message: Result => finalReduceMap.foreach(println)
		case _ =>
	}

	def aggregateInMemoryReduce(reduceDataMap: Map[String, Int]): Unit = {
		for(key <- reduceDataMap.keys) {
			if(finalReduceMap.contains(key)) {
				finalReduceMap += (key -> (finalReduceMap(key) + reduceDataMap(key)))
			} else {
				finalReduceMap += (key -> reduceDataMap(key))
			}
		}
	}
}
