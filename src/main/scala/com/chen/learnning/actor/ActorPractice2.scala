package com.chen.learnning.actor

import scala.actors.Actor


/**
 * 1. 创建一个 MsgActor，并向它发送一个同步消息，该消息包含两个字段（id、 message)
 * 2. MsgActor回复一个消息，该消息包含两个字段 (message、name)
 * 3. 打印回复消息
 */
object ActorPractice2 {

  case class Message(id: Int, content: String)
  case class ReplyMessage(content: String, name: String)

  object MsgActor extends Actor {
    override def act(): Unit = {
      loop {
        react {
          case Message(id, message) => {
            println(s"MsgActor: ${message}")
            sender ! ReplyMessage("Hello MainActor, I am MsgActor", "mainactor")
          }
        }
      }
    }
  }


  def main(args: Array[String]): Unit = {
    MsgActor.start()

    val result: Any = MsgActor !? Message(1, "hello, I am MainActor")
    val message: ReplyMessage = result.asInstanceOf[ReplyMessage]
    println(s"${message.content}")
  }


}
