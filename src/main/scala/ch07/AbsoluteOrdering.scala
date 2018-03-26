package ch07

/*
* Define an Ordering that orders Ints from lowest to highest by absolute value. The following test cases should
* pass.
* Now make your ordering an implicit value
* */
object AbsoluteOrdering {

  implicit val absOrdering = Ordering.fromLessThan[Int]((a,b) => math.abs(a) < math.abs(b))

  def main(args: Array[String]): Unit = {
    println(List(-1,2,3,-4).sorted(absOrdering))
    println(List(-1,2,3,-4).sorted)
  }
}
