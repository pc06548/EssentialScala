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

  def fold(end: Int, f: (Int, Int) => Int): Int =
    this match {
      case End => end
      case pair: Pair => f(pair.head, pair.tail.fold(end, f))
    }

  def sumFold = fold(0, (a:Int, b:Int) => a+b)
  def productFold = fold(1, (a:Int, b:Int) => a*b)
  def lengthFold = fold(0, (a:Int, b:Int) => 1 + b)
}
final case object End extends IntList
final case class Pair(head: Int, tail: IntList) extends IntList
