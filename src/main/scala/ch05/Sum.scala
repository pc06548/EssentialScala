package ch05

sealed trait Sum[A, B] {
  def fold[C](initialValue: C, function: (C, Sum[A,B]) => C): C = {
    this match {
      case left: Left[_,_] => function(initialValue,  left)
      case right: Right[_,_] => function(initialValue, right)
    }
  }

  def sumToC[C](acc:C)(sum:Sum[A,B]):C = {
    sum match {
      case left: Left[_,_] => acc
      case left: Right[_,_] => acc
    }
  }
}

object  A {

}

case class Left[A,B](value: A) extends Sum[A, B]

case class Right[A,B](value: B) extends Sum[A, B]