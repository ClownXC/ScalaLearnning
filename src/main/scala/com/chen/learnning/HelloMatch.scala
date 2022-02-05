package com.chen.learnning

object HelloMatch {
  def main(args: Array[String]): Unit = {
    val tuple: (Int, String, Float, Char) = (1, "2", 3.0f, 'd')

    val iterator: Iterator[Any] = tuple.productIterator
    while(iterator.hasNext){
      test(iterator.next())
    }


    def test(x: Any) = {
      x match {
        case 1 => println("match 1")
        case _: Int => println("match int")
        case _: String => println("match string")
        case _ =>println("no match")

      }
    }
  }
}
