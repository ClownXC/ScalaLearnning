package com.chen.learnning

object HelloTuple {

  def main(args: Array[String]): Unit = {

    val tuple1: Tuple1[Int] = Tuple1(1)
    val tuple2: (Int, Int) = Tuple2(1, 2)
    val tuple22: (Int, String) = (2, "hello")

    val tuple3: (Int, String, Double) = Tuple3(1, "2", 3.14)

    val iterator: Iterator[Any] = tuple2.productIterator
    while (iterator.hasNext){
      println(iterator.next)
    }

    println(tuple2._1 + " " + tuple2._2)

    val swap = tuple2.swap

  }

}
