package com.chen.learnning.actor


/**
 * MessagePackage文件，是用来记录本案例中，涉及到的所有的样例类的．
 */


/**
 * MainActor 给每一个 WordCountActor 发送任务的 格式．
 *
 * @param filename : 具体的要统计的文件路径
 */
case class WordCountTask(filename: String)

/**
 * 每个 WordCountActor 返回的统计后的结果的 格式。
 *
 * @param wordCountMap : 具体的返回结果，例如：Map(“hadoop”->6, "sqoop"->1)
 */
case class WordCountResult(wordCountMap: Map[String, Int])

