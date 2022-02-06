package com.chen.learnning.actor

import scala.actors.Actor


/**
 * 1.创建一个MsgActor，并向它发送一个异步有返回消息，该消息包含两个字段(id,message)
 * 2. MsgActor 回复一个消息，该消息包含两个字段 (message、 name)
 * 3. 打印回复消息
 */
class ActorPractice3 {


  case class Message(id: Int, content: String)

  case class ReplyMessage(content: String, name: String)


  object MsgActor extends Actor {

    override def act(): Unit = {
      loop {
        react {
          case Message(id, message) => {
            println(s"MsgActor: ${id}: ${message}")
            sender ! ReplyMessage("Hello MainActor, I am MsgActor", "hello ")

          }
        }
      }
    }


    def main(args: Array[String]): Unit = {
      MsgActor.start()

      val value: Future[Any] = MsgActor !! Message(1, "hello, I am MainActor")
      while (! value.isSet){}

      val message: ReplyMessage = value.apply.asInstanceOf[ReplyMessage]
      println(s"${message.content}")

    }
  }


}
