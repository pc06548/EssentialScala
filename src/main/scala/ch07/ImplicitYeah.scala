package ch07

/*
* Use your newfound powers to add a method yeah to Int, which prints Oh yeah! as many 􀦞mes as the Int
* on which it is called if the Int is posi􀦞ve, and is silent otherwise. Here’s an example of usage:
* */

object IntImplicits {

  implicit class IntOps(i: Int) {
    def yeah = {
      times(_ => println("yeah"))
    }

    def times(fn : Int => Unit): Unit = {
      for(n <- 0 until i) {
        fn(n)
      }
    }

  }

  def main(args: Array[String]): Unit = {
    3.yeah
    2.yeah
    (-2).yeah

    3.times(i => println(s"Yes it is $i"))
  }

}
