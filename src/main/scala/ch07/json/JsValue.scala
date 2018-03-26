package ch07.json

trait JsValue

final case class JsObject(values: Map[String, JsValue]) extends JsValue

final case class JsString(value: String) extends JsValue