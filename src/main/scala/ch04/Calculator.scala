package ch04

object Calculator {

  def + (calculation: Calculation, int: Int) = {
    calculation match {
      case success: Success => Success(success.result + int)
      case failure: Failure => failure
    }
  }
  def - (calculation: Calculation, int: Int) = {
    calculation match {
      case success: Success => Success(success.result - int)
      case failure: Failure => failure
    }
  }

  def / (calculation: Calculation, int: Int) = {
    calculation match {
      case success: Success =>  {
        int match {
          case 0 => Failure("Divison by zero")
          case _ => success.result / int
        }
      }
      case failure: Failure => failure
    }
  }
}
sealed trait Calculation
final case class Success(result: Int) extends Calculation
final case class Failure(reason: String) extends Calculation
