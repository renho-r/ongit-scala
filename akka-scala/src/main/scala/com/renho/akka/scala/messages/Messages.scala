package com.renho.akka.scala.messages

/**
  * Created by renho on 2016/3/7.
  */
class Word(val word: String, val count: Int)
case class Result()
class MapData(val dataList: List[Word])
class ReduceData(val reduceDataMap: Map[String, Int])

case class BackResult()
