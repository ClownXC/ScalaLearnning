package com.chen.learnning

import scala.collection.mutable
import scala.collection.mutable.ListBuffer


object HelloList {

  def main(args: Array[String]): Unit = {
    val list = List(1, 2, 3, 4, 2, 1, 10, 23)
    list.foreach(println)

    println("=======================")
    val list1 = list.filter(x => {
      if (x > 2) true else false
    })

    list1.foreach(println)

    println("=======================")
    val num = list.count(x => {
      if (x > 2) true else false
    })
    
    println(num)
    println("=======================")

    val res = list.map(x => {
      x * 2
    })

    val list2 = List("hello go", "hello scala", "hello go")
    val list3: List[String] = list2.flatMap(x => {
      x.split(" ")
    })

    list3.foreach(println)

    val listBuffer: mutable.Seq[Int] = ListBuffer[Int](1, 2, 3, 4, 5)
//    listBuffer.append(1, 2)



  }

}
