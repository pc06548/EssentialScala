package ch04

object IntegersTree {

  def sum(integersTree: IntegersTree) : Int = {
    integersTree match {
      case node: Node => sum(node.leftTree) + sum(node.rightTree)
      case leaf: Leaf => leaf.element
    }
  }

  def double(integersTree: IntegersTree): IntegersTree = {
    integersTree match {
      case node: Node => Node(double(node.leftTree), double(node.rightTree))
      case leaf: Leaf => Leaf(leaf.element*2)
    }
  }
}

sealed trait IntegersTree {
  def sum: Int
  def double: IntegersTree
}

final case class Leaf(element: Int) extends IntegersTree {
  override def sum: Int = element

  override def double: IntegersTree = Leaf(element*2)
}

final case class Node(leftTree: IntegersTree, rightTree: IntegersTree) extends IntegersTree {
  override def sum: Int = leftTree.sum + rightTree.sum

  override def double: IntegersTree = Node(leftTree.double, rightTree.double)
}
