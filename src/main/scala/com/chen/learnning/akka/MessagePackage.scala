package com.chen.learnning.akka

/**
 * 表示提交任务的消息格式
 * @param msg: 具体的发送信息
 */
case class SubmitTaskMessage(msg: String)


/**
 * 表示提交任务成功后的回执信息的格式
 * @param msg: 具体的回执信息
 */
case class SuccessSubmitTaskMessage(msg: String)


