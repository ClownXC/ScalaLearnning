package com.chen.learnning

object HelloSet {

  def main(args: Array[String]): Unit = {


    val set1 = Set(1, 2, 3)
    set1.foreach(println)

    val set2 = Set(2,34,5)
    val set3: Set[Int] = set2.union(set1)
    set3.foreach(println)

    val list1: List[Int] = set3.toList
    val array: Array[Int] = set2.toArray

    val str: String = set3.mkString
    println(str)

    val str1: String = set3.mkString("===")
    println(str1)

  }

}
