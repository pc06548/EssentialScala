package ch05

trait LinkedList[A] {
  def length: Int = {
    this match {
      case End() => 0
      case pair:Pair[A] => 1 + pair.tail.length
    }
  }

  def contains(element: A): Boolean = {
    this match {
      case End() => false
      case pair:Pair[A] => {
        if(pair.head == element) true
        else pair.tail.contains(element)
      }
    }
  }

  def apply(position: Int):Result[A] = {
    this match {
      case End() => Failure("Bad things happened")
      case pair:Pair[A] => if(position == 0) Success(pair.head) else pair.tail(position-1)
    }
  }

  /*def fold[B](end: B, f: (A, B) => B): B =
    this match {
      case End => end
      case pair: Pair[A] => f(pair.head, pair.tail.fold(end, f))
    }

  def sumFold = fold(0, (a:Int, b:Int) => a+b)
  def productFold = fold(1, (a:Int, b:Int) => a*b)
  def lengthFold = fold(0, (a:Int, b:Int) => 1 + b)
  def doubleFold = fold(End, (a:Int, list: LinkedList[Int]) => Pair(a*2, list))*/

}

case class End[A]() extends LinkedList[A]
case class Pair[A](head:A, tail: LinkedList[A]) extends LinkedList[A]


