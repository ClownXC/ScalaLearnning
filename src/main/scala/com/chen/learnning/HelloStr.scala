package com.chen.learnning

object HelloStr {

  def main(args: Array[String]): Unit = {

    val str: String = "abcd"
    println(str.indexOf("c"))

    val abcd: String = "Abcd"
    println(str.compareToIgnoreCase(abcd))

    val sb = new StringBuilder()
    sb.append(str).append(abcd)

    sb.++=("hello3")
    sb ++= "hello2"
    sb += 'e'
    sb + 'f'

    println(sb.toString)


  }

}
