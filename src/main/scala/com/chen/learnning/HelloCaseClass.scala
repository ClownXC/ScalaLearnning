package com.chen.learnning

case class Boy(name: String, age: Int)

object HelloCaseClass{
  def main(args: Array[String]): Unit = {

    val chen: Boy = Boy("chen", 18)
    println(chen)
  }
}
