package ch07

/*
* Implement an enrichment so we can use this type class via a triple equal (===) method. For example, if the
* correct implicits are in scope the following should work.
* "abcd".===("ABCD") // Assumes case-insensitive equality implicit
* */


object EqualEnrichment {
  implicit class EqualEnrichMent(a: String) {
    def ===(b: String): Boolean = {
      a.equalsIgnoreCase(b)
    }
  }

  def main(args: Array[String]): Unit = {
    println("abcd".===("ABCD"))
  }
}