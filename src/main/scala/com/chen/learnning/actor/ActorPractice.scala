package com.chen.learnning.actor

import scala.actors.Actor

class Actor1 extends Actor {
  override def act(): Unit = {
    for (i <- 1 to 10) println("actor1:===========" + i)
  }
}


class Actor2 extends Actor {
  override def act(): Unit = {
    for (i <- 1 to 10) println("actor2:---" + i)
  }
}




object ActorLearnningDemo1 {


  object TestActor1 extends Actor {
    override def act(): Unit = for (i <- 1 to 10) println("actor1:", i)
  }

  object TestActor2 extends Actor {
    override def act(): Unit = for (i <- 11 to 20) println("actor2: ", i)
  }


  def main(args: Array[String]): Unit = {

    TestActor1.start()
    TestActor2.start()

  }
}


object ActorPractice {

  object ActorSender extends Actor {
    override def act(): Unit = {
      // 发送一个异步字符串消息给 ActorReceiver
      ActorReceiver ! "hello ActorReceiver, i am  ActorSender"
    }
  }

  object ActorReceiver extends Actor {
    override def act(): Unit = {
      //接收到该消,息后打印出来
      //receive() 只能接收一次。
      while (true){
        receive {
          case x: String => println(x)
        }
      }
    }

    def main(args: Array[String]): Unit = {

      ActorSender.start()
      ActorReceiver.start()

    }




  }



  object ActorPractice2 {

    object ActorSender extends Actor {
      override def act(): Unit = {
        // 发送一个异步字符串消息给 ActorReceiver
        ActorReceiver ! "hello ActorReceiver, i am  ActorSender"
      }
    }

    object ActorReceiver extends Actor {
      override def act(): Unit = {
        //接收到该消,息后打印出来
        //receive() 只能接收一次。
        loop {
          react {
            case x: String => println(x)
          }
        }
      }

      def main(args: Array[String]): Unit = {

        ActorSender.start()
        ActorReceiver.start()

      }
    }









      def main(args: Array[String]): Unit = {

        println("==============")
      }

  }

}
















