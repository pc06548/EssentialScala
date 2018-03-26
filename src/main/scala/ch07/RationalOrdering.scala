package ch07

final case class Rational(numerator: Int, denominator: Int)
object RationalOrdering {
  implicit val rationalLessThanOrdering = Ordering.fromLessThan[Rational]((a,b) => a.numerator.toDouble/a.denominator.toDouble
    < b.numerator.toDouble/b.denominator.toDouble)

  def main(args: Array[String]): Unit = {
    println(List(Rational(1, 2), Rational(3, 4), Rational(1, 3)).sorted)
  }
}
