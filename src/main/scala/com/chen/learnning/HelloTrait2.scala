package com.chen.learnning


trait Equal {
  def isEqual(x: Any): Boolean

  def isNotEqual(x: Any): Boolean = {
    ! isEqual(x)
  }

}

class Point(xx: Int, yy: Int) extends Equal {

  val x = xx
  val y = yy


  override def isEqual(p: Any): Boolean = {
    if (p.isInstanceOf[Point]){
      val point: Point = p.asInstanceOf[Point]
      x == point.x && y == point.y
    }else{
      false
    }
  }
}


class HelloTrait2 {

}
