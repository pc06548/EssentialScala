package ch06

import scala.util.Try

object Addition {

  def main(args: Array[String]) {

    val opt1: Option[Int] = Some(1)
    val opt2: Option[Int] = Some(2)
    val opt3: Option[Int] = Some(3)

    val seq1 = Seq(1)
    val seq2 = Seq(2)
    val seq3 = Seq(3)


    val try1 = Try(1)
    val try2 = Try(2)
    val try3 = Try(3)

    for {
      o1 <- opt1
      o2 <- opt2
      o3 <- opt3
    } yield {
      o1 + o2 + o3
    }

    for {
      o1 <- seq1
      o2 <- seq2
      o3 <- seq3
    } yield {
      o1 + o2 + o3
    }

    for {
      o1 <- try1
      o2 <- try2
      o3 <- try3
    } yield {
      o1 + o2 + o3
    }
  }

}
