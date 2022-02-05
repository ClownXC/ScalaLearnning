package com.chen.learnning

object HelloMap {

  def main(args: Array[String]): Unit = {
    val map: Map[String, Any] = Map("name" -> "chen", "age" -> 18, ("money", 300))

    map.foreach(println)
    map.foreach(x => {
      println(x._1 + "  " + x._2)
    })


    val option: Option[Any] = map.get("name")
    println(option.get)

    val option2: Option[Any] = map.get("name2")
    val value: Any = map.getOrElse("name3", "none")
    println(option2.getOrElse("none"))

    map.values.foreach(println)
    map.keys.foreach(println)

    val map2: Map[String, Any] = Map("name" -> "ci", "age" -> 18, ("money", 300))
    val map3: Map[String, Any] = map.++(map2)
    map3.foreach(println)
    val map4: Map[String, Any] = map.++:(map2)
    map4.foreach(println)
  }

}
