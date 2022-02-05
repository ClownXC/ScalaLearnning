package com.chen.learnning

// 偏函数: 有 case 没有 match
object HelloPartialFunction {

  def main(args: Array[String]): Unit = {
    println(test("scala"))

    val list = List(1, 3, 5, "map") map { case i: Int => i + 1 }
    val list2 = List(1, 3, 5, "map") collect { case i: Int => i + 1 }






  }

  def test: PartialFunction[String, String] = {
    case "go" => "hello go "
    case "scala" => "hello scala"
    case _ => "no match"
  }
}
