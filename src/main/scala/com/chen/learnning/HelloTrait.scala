package com.chen.learnning

trait Play {
  val name: String = "chen"
  val age: Int = 18
  def play(): Unit = {
    println("play")
  }
}

trait Study{
  def study()
}

class People extends Play with Study{
  override def study(): Unit = {
    println("study")
  }
}

object HelloTrait{
  def main(args: Array[String]): Unit = {
    val people = new People
    people.study()
    people.play()

  }
}
