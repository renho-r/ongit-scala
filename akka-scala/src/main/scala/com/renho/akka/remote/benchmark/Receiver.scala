package com.renho.akka.remote.benchmark

import akka.actor.Actor
import akka.actor.ActorSystem
import com.typesafe.config.ConfigFactory
import akka.actor.Props

object Receiver {
  def main(args: Array[String]): Unit = {
    val system = ActorSystem("Sys", ConfigFactory.load("remotelookup"))
    system.actorOf(Props[Receiver], "rcv")
  }
}

class Receiver extends Actor {
  import Sender._

  def receive = {
    case m: Echo  => {println(m); sender() ! m}
    case Shutdown => context.system.terminate()
//    case num: Array[Byte] => println(num)
    case _        =>
  }
}

