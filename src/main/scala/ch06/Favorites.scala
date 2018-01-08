package ch06

object Favorites {

  val people = Set(
    "Alice",
    "Bob",
    "Charlie",
    "Derek",
    "Edith",
    "Fred")

  val ages = Map(
    "Alice" -> 20,
    "Bob" -> 30,
    "Charlie" -> 50,
    "Derek" -> 40,
    "Edith" -> 10,
    "Fred" -> 60)

  val favoriteColors = Map(
    "Bob" -> "green",
    "Derek" -> "magenta",
    "Fred" -> "yellow")

  val favoriteLolcats = Map(
    "Alice" -> "Long Cat",
    "Charlie" -> "Ceiling Cat",
    "Edith" -> "Cloud Cat")

  def favoriteColor(name: String): String = {
    favoriteColors.getOrElse(name, "beige")
  }

  def printColors = {
    favoriteColors.map(println(_))
  }

  def lookup[T](name: String, map: Map[String, T]): Option[T] = {
    map.get(name)
  }

  def colorOfOldest = {
    val oldest = people.foldLeft(Option.empty[String])((acc, entry) => {
      if(ages.getOrElse(entry, 0) > acc.flatMap(ages.get).getOrElse(0)) {
        Some(entry)
      } else
        acc
    })

    for{
      old <- oldest
      favCol <- favoriteColors.get(old)
    } yield favCol
  }

}
