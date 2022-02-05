package com.chen.learnning.actor

import scala.actors.Actor

class Actor1 extends Actor  {
  override def act(): Unit = {
    for (i <- 1 to 10) println ("actor1:===========" + i)
  }
}


class Actor2 extends Actor {
  override def act(): Unit = {
    for (i <- 1 to 10) println ("actor2:---" + i)
  }
}

object ActorPractice{
  def main(args: Array[String]): Unit = {

  }
}
