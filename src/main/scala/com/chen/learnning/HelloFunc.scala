package com.chen.learnning

import java.util.Date

object HelloFunc {


  /**
   * 1. return 关健字可以省略，scala 自动将函数的最后一行的值作为函数的返回值
   * 2. = 可以省路，如果省略，函数会自动将返回值丢弃，一股用在无返回值的函数中去省略 =。
   * 3. 传递给方法的参数可以在方法中使用，并且 scala 规定方法的传过来的参数为 val 的，不是var的。
   *
   * @param x
   * @param y
   * @return
   */
  def getMax(x: Int, y: Int): Int = {
    if (x > y) x else y
  }


  /**
   * 递归函数
   */
  def f(num: Int): Int = {

    if (num == 1) return num
    num * f(num - 1)
  }


  def f2(x: Int = 5, y: Int): Int = {
    x * y
  }

  def f3(x: Int*): Seq[Int] = {
    x
  }

  def f5(x: Int*): Int = {
    var sum: Int = 0
    for (i <- x) {
      sum = sum + i
    }
    sum
  }

  /**
   * 匿名函数
   */
  val f6 = (x: Int, y: Int) => println(x + y)
  f6(1, 3)

  /**
   * 偏应用函数
   * @param date
   * @param str
   */
  def log(date: Date, str: String) = {
    println("date is: " + date + ", log is " + str)
  }
  
  def f20(x: Int, y: Int): Int = x + y
  
  def f21 (x: Int, add: (Int, Int) => Int): Int = {
    val res = add(1, 2)
    x * res
  }

  def f22 (s1: String, s2: String): (String, String) => String = {

    def f220 (s3: String, s4: String): String = {
      s1 + "===" + s2 + "===" + s3 + "===" + s4
    }
    f220
  }


  def kellFunction(x: Int, y: Int)(str1: String, str2: String): String = {
    x + y + str1 + str2
  }

  def main(args: Array[String]): Unit = {

    println("kellFunction: " + kellFunction(1, 2)("hello", "world"))

    val function: (String, String) => String = f22("hello", "scala")
    println(function("good", "evening"))

    println(f22("hello", "scala")("hello", "world"))




    val i1 = f21(3, f20)
    println("i1:  " + i1)

    f21(2,(x: Int, y: Int) => x + y)
    
    
    
    val i = f(7)
    println(i)
    
    

    val date = new Date()
    val logwithdate = log(date, _:String)
    
    logwithdate("l1")
    logwithdate("l2")
    logwithdate("l3")

    //    val i1 = f2(y = 10)




  }





}



