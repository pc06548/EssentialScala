package ch06

object UnionFunctions {

  def setUnion[A](set1: Set[A], set2: Set[A]): Set[A] = {
    set1.foldLeft(set2)((acc, entry) => {
      acc + entry
    })
  }


  def mapUnion[A](map1: Map[A, Int], map2: Map[A, Int]): Map[A,Int] = {
    map1.foldLeft(map2)((acc, entry) => {
      val newVal: Option[Int] = for{
        ac <- acc.get(entry._1)
      } yield {
        ac + entry._2
      }
      acc + (entry._1 -> newVal.getOrElse(entry._2))
    })
  }

  def mapGenericUnion[A,B](map1: Map[A, B], map2: Map[A, B], unite: ((B,B) => B)): Map[A,B] = {
    map1.foldLeft(map2)((acc, entry) => {
      val newVal: Option[B] = for{
        ac <- acc.get(entry._1)
      } yield {
        unite(ac, entry._2)
      }
      acc + (entry._1 -> newVal.getOrElse(entry._2))
    })
  }
}
