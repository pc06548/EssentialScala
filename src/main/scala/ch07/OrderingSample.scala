package ch07
import scala.math.Ordering

object OrderingSample {

  val minOrdering = Ordering.fromLessThan[Int](_ < _)
  val maxOrdering = Ordering.fromLessThan[Int](_ > _)

  def main(args: Array[String]): Unit = {
    val list = List(3,4,1,2)
    println(list.sorted(minOrdering))
    println(list.sorted(maxOrdering))
  }

}
