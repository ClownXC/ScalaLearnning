package com.chen.learnning

/**
 * 1.同类型的参数的隐式值只能在作用域内出现一次，同一个作用域内不能定义多个类型一样的隐式值。
 * 2.implicit 关键字必须放在隐式参数定义的开头
 * 3.一个方法只有一个参数是隐式转换参数时，那么可以直接定义 implicit 关键字修饰的参数，调用时直接
 * 创建类型不传入参数即可。
 * 4.一个方法如果有多个参数，要实现部分参数的隐式转换,必须使用柯里化这种方式隐式关键字出现在后
 * 面，只能出现一次。
 */
object HelloImplict {

  implicit val address: String = "shanghai"
  implicit val age: Int = 18

  def test(implicit name: String) = {
    println(name)
  }

  // 多个参数的函数使用隐式参数时，隐式参数写在最后，并且使用柯里化函数的写法。
  def test2(name: String)(implicit age: Int, address: String) = {
    println(name + ": " + age + ": " + address)
  }

  def main(args: Array[String]): Unit = {
    test("name")
    test
    test2("chen")
    test2("chen")(20, "beijing")
  }

}

/**
 * 1. 隐式转换函数是使用关键字 implicit 修饰的函数。当 Scala 运行时，假设如果 A 类型变量调用了 method()
 * 这个方法，发现 A 类型的变量没有 method() 方法，而 B 类型有此 method() 方法，会在作用域中寻找有没有隐式转
 * 换函数将 A 类型转换成 B 类型，如果有隐式转换函数，那么 A 类型就可以调用 method() 这个方法。
 *
 * 2. 隐式转换函数只与函数的参数类型和返回类型有关，与函数名称无关，所以作用域内不能有相同的参数类型和
 * 返回类型的不同名称隐式转换函数。
 */
class Bird(name: String) {
  def fly() = {
    println(name + ": flying")
  }
}

class Pig(name: String) {
  val xname = name

}

object HelloImplictFunction{

  /**
   * 隐式转换函数是使用关键字 implicit 修饰的函数。当 Scala 运行时，假设如果 A 类型变量调用了 method()
   * 这个方法，发现 A 类型的变量没有 method() 方法，而 B 类型有此 method() 方法，会在作用域中寻找有没有隐式转
   * 换函数将 A 类型转换成 B 类型，如果有隐式转换函数，那么 A 类型就可以调用 method() 这个方法。
   *
   * 隐式转换函数只与函数的参数类型和返回类型有关
   * @param pig
   * @return
   */
  implicit def pigToBird(pig: Pig): Bird = {
    new Bird(pig.xname)
  }

  def main(args: Array[String]): Unit = {
    val bird = new Bird("bird")
    bird.fly()

    val pig = new Pig("pig")
    pig.fly()
  }
}




/**
使用 implicit 关键字修饰的类就是隐式类。若一个变量 A 没有某些方法或者某些变量时，而这个变量 A 可以
调用某些方法或者某些变量时，可以定义一个隐式类，隐式类中定义这些方法或者变量，隐式类中传入A即可。


隐式类必须定义在类，包对象，伴生对象中。
隐式类的构造必须只有一个参数，同一个类，包对象，伴生对象中不能出现同类型构造的隐式类。

 */

class Rabbit(xname: String){
  val name = xname
}

object HelloImplictClass{

  implicit class Animal(rabbit: Rabbit){
    val age = 3
    def fly(): Unit ={
      println(rabbit.name + " :flying===")
    }
  }
  def main(args: Array[String]): Unit = {
    val rabbit = new Rabbit("rabbit")
    rabbit.fly()
    println(rabbit.age)

  }
}