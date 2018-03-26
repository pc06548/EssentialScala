package ch07

/*
* We have a requirement to order Orders in three different ways:
* 1. by totalPrice;
* 2. by number of units; and
* 3. by unitPrice.
* Implement and package implicits to provide these orderings, and jus􀦞fy your packaging.
* */

final case class Order(units: Int, unitPrice: Double) {
  val totalPrice: Double = units * unitPrice
}

object Order {
  implicit val orderByTotalPrice = Ordering.fromLessThan[Order]((a,b) => a.totalPrice < b.totalPrice)
}

object OrderByUnits {
  implicit val orderByNumberOfUnits = Ordering.fromLessThan[Order]((a,b) => a.units < b.units)
}

object OrderByUnitPrice {
  implicit val orderByNumberOfUnitPrice = Ordering.fromLessThan[Order]((a,b) => a.unitPrice < b.unitPrice)
}

object OrderingOrders {
}
