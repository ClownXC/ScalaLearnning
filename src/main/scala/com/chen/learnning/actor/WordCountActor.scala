package com.chen.learnning.actor

import scala.actors.Actor
import scala.collection.immutable
import scala.io.Source

class WordCountActor extends Actor {
  override def act(): Unit = {
    loop {
      react {
        case WordCountTask(filename) => {
          val lineList: immutable.Seq[String] = Source.fromFile(filename).getLines().toList

          val wordList: immutable.Seq[String] = lineList.flatMap(_.split(" "))
          val wordAndCount: immutable.Seq[(String, Int)] = wordList.map(_ -> 1)
          val groupMap: Map[String, immutable.Seq[(String, Int)]] = wordAndCount.groupBy(_._1)

          val wordCountMap: Map[String, Int] = groupMap.map(keyVal => keyVal._1 -> keyVal._2.map(_._2).sum)

          sender ! WordCountResult(wordCountMap)


        }

      }
    }
  }
}
