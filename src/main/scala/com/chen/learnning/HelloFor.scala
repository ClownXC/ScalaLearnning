package com.chen.learnning

object HelloFor {

  def main(args: Array[String]): Unit = {
    println(1 to 10)
    println(1 until 10)
    println(1 to (10, 2))
    
    for(i <-  1 to 10){
      println(i)
    }

    for (i <- 1 until 10; if i%2 == 0){
      println(i)
    }

    for (i <- 1 to 9; j <- 1 to i){
      print(j + "x" + i + "=" + i*j + " ")
      if(i == j) println()
    }

//    5.scala中不能使用count++，count一 只能使用count =count+1，count += 1
//    6.for循环用yield 关键字返回一个集合: for{子句}yield{变量或表达式}，原来的集合不会被改变，只会
//      通过你的for/yield构建出一个新的集合。
    val list = for (i <- 1 to 10; if i > 5) yield i
    for (i <- list){
      println("i: " + i)
    }
    val list2 = for (i <- 1 to 10; if i > 5) yield i%2
    for (i <- list2){
      println("i: " + i)
    }





      

  }

}
