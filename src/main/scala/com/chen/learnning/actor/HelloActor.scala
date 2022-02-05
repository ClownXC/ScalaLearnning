package com.chen.learnning.actor

import scala.actors.Actor

/**
1.  scala 在2.11.x版本中加入了Akka并发编程框架，老版本已经废弃。
2.  Actor的编程模型和Akka很像，我们这里学习Actor的目的是为学习AKka做准备。
 */
class HelloActor extends Actor {
  override def act(): Unit = {
    while (true){
      receive({
        case x: String => println("hello ")
        case _ => println("no match")
      })
    }
  }
}


object TestActor {
  def main(args: Array[String]): Unit = {

    val actor = new HelloActor
    actor.start()

    actor ! "actor"
    actor ! 1

  }
}