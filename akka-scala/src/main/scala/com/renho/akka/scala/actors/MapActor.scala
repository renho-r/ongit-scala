package com.renho.akka.scala.actors

import java.util.StringTokenizer

import akka.actor.{ActorRef, Actor}
import com.renho.akka.scala.messages.{Word, MapData}

import scala.collection.mutable.ListBuffer

/**
  * Created by renho on 2016/3/7.
  */
class MapActor(val reduceActor: ActorRef) extends  Actor {

	val STOP_WORDS_LIST = List("a", "is")

	override def receive: Receive = {
		case message: String => reduceActor ! evaluateExpression(message)
		case _ =>
	}

	def evaluateExpression(line: String): MapData = {
		var dataList = ListBuffer[Word]()
		val parser: StringTokenizer = new StringTokenizer(line)
		while(parser.hasMoreTokens) {
			var word = parser.nextToken().toLowerCase
			if(!STOP_WORDS_LIST.contains(word)) {
				dataList += new Word(word, 1)
			}
		}
		return new MapData(dataList.toList)
	}
}
