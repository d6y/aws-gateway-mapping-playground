import org.apache.velocity.{Template, VelocityContext}
import org.apache.velocity.app.VelocityEngine
import java.io.StringWriter

object Runner {
  def run(
    filename: String,
    context:  Context,
    input:    Input
  ): String = {
    val engine = new VelocityEngine()
    val context = new VelocityContext()
    context.put( "context", Context() )
    context.put( "input",   input )
    context.put( "util",    Util )
    engine.init()

    val template = engine.getTemplate(filename)

    val out = new StringWriter()
    template.merge(context, out)
    out.toString
  }
}

object Main {

  def main(args: Array[String]): Unit = {
    println(
      Runner.run("src/test/resources/hello-world.vm", Context(), Input())
    )
  }

}