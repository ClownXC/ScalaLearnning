package com.chen.learnning

import scala.collection.mutable
import scala.collection.mutable.ArrayBuffer
object HelloArray {
  def main(args: Array[String]): Unit = {
    val array = Array(1, 2, 3)
    println(array(0))

    for (i <- array){
      println(i)
    }

    array.foreach(i => print(i))
    println("=======")
    array.foreach(print(_))
    println("======")
    array.foreach(print)



    val array2 = new Array[Int](3)
    array2(0) = 1
    array2(1) = 2
    array2(2) = 3

    val array3 = new Array[Array[Int]](3)
    array3(0) = Array(0, 1)
    array3(1) = Array(2, 3)
    array3(2) = Array(4, 5)

    val arr5: Array[Int] = Array.concat(array, array2)
    arr5.foreach(println)

    val muarr: mutable.Seq[String] = ArrayBuffer[String]("a", "b", "c")
//    muarr.append("e", "f")



  }
}
