package ch05

sealed trait Maybe[A] {

  def fold[B](initialValue: B, function: (B, A) => B): B = {
    this match {
      case Full(value) => function(initialValue, value)
      case Empty => initialValue
    }
  }

}

case class Full[A](value: A) extends Maybe[A]

case object Empty extends Maybe[Nothing]