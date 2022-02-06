package com.chen.learnning.akka

import akka.actor.{ActorRef, ActorSystem, Props}
import com.typesafe.config.ConfigFactory

object Entrance {

  def main(args: Array[String]): Unit = {

    val actorSystem = ActorSystem("actorSystem", ConfigFactory.load())
    val senderActor: ActorRef = actorSystem.actorOf(Props(SenderActor), "senderActor")
    val receiverActor: ActorRef = actorSystem.actorOf(Props(ReceiverActor), "receiverActor")

    senderActor ! "start"

  }

}
