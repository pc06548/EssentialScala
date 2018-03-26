package ch07

/*
* Scala provides two equality predicates: by value (==) and by reference (eq). Nonetheless, we some􀦞mes need
* addi􀦞onal predicates. For instance, we could compare people by just email address if we were valida􀦞ng new
* user accounts in some web applica􀦞on.
* Implement a trait Equal of some type A, with a method equal that compares two values of type A and returns
* a Boolean. Equal is a type class.
* */

case class Person(name: String, email: String)

trait Equal[A] {
  def equal(a:A, b:A): Boolean
}

object EqualByEmail extends Equal[Person] {
  override def equal(a: Person, b: Person): Boolean = a.email.equals(b.email)
}


object EqualByEmailAndName extends Equal[Person] {
  override def equal(a: Person, b: Person): Boolean = a.name.equals(b.name) && EqualByEmail.equal(a,b)
}


/*
* Implement an object called Eq with an apply method. This method should accept two explicit parameters
* of type A and an implicit Equal[A]. It should perform the equality checking using the provided Equal.
* */

object Eq {
  def apply[A](a:A, b:A)(implicit instance: Equal[A]) = instance.equal(a, b)
}

/*
* Now implement an interface on the companion object for Equal using the no-argument apply method pa􀂂ern.
* The following code should work.
* */

object Equal {
  def apply[A](implicit instance: Equal[A]) = instance

  implicit class ToEqual[A](a: A) {
    def ===(other: A)(implicit equal: Equal[A]): Boolean = {
      equal.equal(a, other)
    }
  }
}

object Demo {
  def main(args: Array[String]): Unit = {
    Eq[Person](Person("d", "def"), Person("a", "abc"))(EqualByEmail)

    Equal[Person](EqualByEmail).equal(Person("d", "def"), Person("a", "abc"))
  }
}