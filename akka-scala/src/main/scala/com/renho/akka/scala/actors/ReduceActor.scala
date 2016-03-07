package com.renho.akka.scala.actors

import akka.actor.{ActorRef, Actor}
import com.renho.akka.scala.messages.{Word, MapData, ReduceData}

/**
  * Created by renho on 2016/3/7.
  */
class ReduceActor(val aggregateActor: ActorRef) extends Actor {

	override def receive: Receive = {
		case message: MapData => aggregateActor ! reduce(message.dataList)
		case _ =>
	}

	def reduce(dataList: List[Word]): ReduceData = {
		var reduceMap = Map[String, Int]()
		for(wd <- dataList) {
			if(reduceMap.contains(wd.word)) {
				reduceMap.updated(wd.word, reduceMap(wd.word) + 1)
			} else {
				reduceMap += (wd.word -> 1)
			}
		}
		new ReduceData(reduceMap)
	}
}
