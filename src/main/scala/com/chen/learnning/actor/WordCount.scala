package com.chen.learnning.actor

import java.io.File

import scala.actors.Future
import scala.collection.immutable


object WordCount {


  def main(args: Array[String]): Unit = {

    val dir = "./data/"
    val filenameList: immutable.Seq[String] = new File(dir).list().toList
    println(filenameList)
    val fileDirList = filenameList.map(dir + _)
    val wordCountList: immutable.Seq[WordCountActor] = fileDirList.map(f => new WordCountActor)

    val actorWithFile: immutable.Seq[(WordCountActor, String)] = wordCountList.zip(fileDirList)

    val futureList: immutable.Seq[Future[Any]] = actorWithFile.map {
      keyVal => {
        val actor = keyVal._1
        actor.start()

        val future: Future[Any] = actor !! WordCountTask(keyVal._2)
        future
      }
    }
    
    // 判断所有的future是否都有返回值，如果都返回后，则往下继续执行
    while (futureList.exists(!_.isSet)){}

    // 从每一个 future 中，获取数据．
    val wordCountMap: immutable.Seq[Map[String, Int]] = futureList.map(_.apply().asInstanceOf[WordCountResult].wordCountMap)

    //统计
    val result: Map[String, Int] = wordCountMap.flatten.groupBy(_._1).map(keyVal => keyVal._1 -> keyVal._2.map(_._2).sum)
    println(result)
    
    
    
    


  }

  // 根据文件数量，来创建对应个数的 WordCountActor 对象。


  // WordCountActor 对象要和文件关联，可以使用 zip 把它们拉链到一起。



  // 每个 WordCountActor 都要对文件中的单词数量进行统计，


  // 每个 WordCountActor 统计后的结果，返回给 MainActor


  // 对接收到的每个 WordCountActor 返回的数量 Map[String，Int]，进行合并.

}
