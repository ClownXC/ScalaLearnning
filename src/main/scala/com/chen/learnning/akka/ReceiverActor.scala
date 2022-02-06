package com.chen.learnning.akka

import akka.actor.Actor

object ReceiverActor extends Actor {
  override def receive: Receive = {
    case SubmitTaskMessage(msg) => {
      println(msg)

      sender ! SuccessSubmitTaskMessage("I am ReceiverActor, Hello")

    }
  }
}
