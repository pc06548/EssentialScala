package ch05

/*
* Create a generic trait called Maybe of a generic type A with two subtypes, Full containing an A, and Empty
* containing no value.
* Implement fold for this type.
* */

sealed trait Maybe[A] {

  def fold[B](initialValue: B, function: (B, A) => B): B = {
    this match {
      case Full(value) => function(initialValue, value)
      case Empty() => initialValue
    }
  }

}

case class Full[A](value: A) extends Maybe[A]

case class Empty[A]() extends Maybe[A]