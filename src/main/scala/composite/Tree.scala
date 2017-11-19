package tree

import scala.collection.mutable._


trait Node {
  def print(prefix: String): Unit
}

class Leaf(data: String) extends Node {
  override def print(prefix: String): Unit =
    println(s"${prefix}${data}")
}

class Tree extends Node {
  private val children = ListBuffer.empty[Node]

  override def print(prefix: String): Unit = {
    println(s"${prefix}")
    children.foreach(_.print(s"${prefix}"))
    println(s"${prefix})")
  }

  def add(child: Node): Unit = {
    children += child
  }

  def remove(): Unit = {
    if (children.nonEmpty) {
      children.remove(0)
    }
  }
}
