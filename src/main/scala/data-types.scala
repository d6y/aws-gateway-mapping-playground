import scala.beans.BeanProperty

object Util {
  def urlDecode(s: String): String = java.net.URLDecoder.decode(s)
}

case class Context(
  @BeanProperty httpMethod : String = "POST"
)

case class Input(
  data: String = "x=y"
) {

  def path(arg: String): String =
    arg match {
      case "$"       => data
      case otherwise => throw new UnsupportedOperationException(s"$otherwise not suported on path")
    }
}