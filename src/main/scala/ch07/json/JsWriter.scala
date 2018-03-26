package ch07.json

import java.util.Date

trait JsWriter[A] {
  def write(value: A) : JsValue
}


object JsUtil {
  def toJson[A](value: A)(implicit writer: JsWriter[A]): JsValue = {
    writer.write(value)
  }
}



object JsWriter {

  implicit object AnonymousJsWriter extends JsWriter[Anonymous] {
    override def write(value: Anonymous): JsValue = {
      JsObject(Map("id" -> JsString(value.id),
        "createdAt" -> JsString(value.createdAt.toString)))
    }
  }

  implicit object UserJsWriter extends JsWriter[User] {
    override def write(value: User): JsValue = {
      JsObject(Map(
        "id" -> JsString(value.id),
        "email" -> JsString(value.email),
        "createdAt" -> JsString(value.createdAt.toString)
      ))

    }
  }

  implicit object VisitorWriter extends JsWriter[Visitor] {
    def write(value: Visitor) = value match {
      case anon: Anonymous => anon.toJson
      case user: User => user.toJson
    }
  }

  implicit class JsUtil[A](value: A) {
    def toJson(implicit writer: JsWriter[A]) = {
      writer.write(value)
    }
  }

  def main(args: Array[String]): Unit = {
    val visitors: Seq[Visitor] = Seq(Anonymous("001", new Date), User("003", "dave@xample.com", new Date))
    val jsons: Seq[JsValue] = visitors.map(visitor => visitor.toJson)
  }

}