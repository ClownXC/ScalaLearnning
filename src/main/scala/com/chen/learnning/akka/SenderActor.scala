package com.chen.learnning.akka

import akka.actor.{Actor, ActorSelection}

/**
 * 在Actor并发編程模型中：实现act(）方法，如果想持续接收消息，需要通过1oop + react 組合方法实现。
 * 在Akka并发编程模型中：实现receive()，直接在该方法中通过偏函数来处理数据
 */
object SenderActor extends Actor {
  override def receive: Receive = {
    case "start" => {
      println("接收到消息： start")

      val receiverActor: ActorSelection = context.actorSelection("akka://actorSystem/user/receiverActor")
      receiverActor ! SubmitTaskMessage("I am SenderActor, send message to ReceiverActor")
    }

    case SuccessSubmitTaskMessage(msg) => {
      println("SenderActor 接收到回执信息: " + msg)
    }
  }
}


