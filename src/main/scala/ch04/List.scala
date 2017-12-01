package ch04

sealed trait IntList {
  def length: Int =
    this match {
      case End => 0
      case pair:Pair => 1 + pair.tail.length
    }
  def double: IntList =
    this match {
      case End => End
      case pair:Pair => Pair(pair.head * 2, pair.tail.double)
    }
  def product: Int =
    this match {
      case End => 1
      case pair:Pair => pair.head * pair.tail.product
    }
  def sum: Int =
    this match {
      case End => 0
      case pair:Pair => pair.head + pair.tail.product
    }
}
final case object End extends IntList
final case class Pair(head: Int, tail: IntList) extends IntList
