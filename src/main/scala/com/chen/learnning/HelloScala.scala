package com.chen.learnning

import scala.io.StdIn

/**
 * @author  zxc
 *
*1. 一行的结尾可以省略分号，如果说一行中有多个语句那么可以使用分号送行附不
*2. var 修饰变量，val 修饰常量
*3. class 默认实现 getter setter 方法
*4. class 中如果有参数传入，那么这个构造器就是这个类的默认构造器
*5. 重写构造器，必须调用类默认的构造器
*6. class 被 new 对象的时候，除了方法内部不效行，真它地方的代码都会被执行
*7. object 里面不能传进参数，object 里面的属性和方法都是静态（类似 java 中 static 修饰的东西）
*8. 伴生类和伴生对象：在一个scala文件中，如果 class 和 object 的名字一样
           *则互为伴生类和伴生对象，他们可以直接访问到互相的私有成员变量
 *
 *
 *
 */
class Person(xname: String, xage: Int){

  val name: String = xname
  val age: Int = xage
  private var money = 100

  def this(xname: String, xage: Int, xmoney: Int){
    this(xname, xage)
    money = xmoney
    Person.height = 50
  }

}

object Person{
  private var height: Double  = 47.5
}



object HelloScala {

  def main(args: Array[String]): Unit = {

    var name = "hello"

    val v1 = StdIn.readInt()


    println("hello scala")
  }
}
