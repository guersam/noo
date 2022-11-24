//> using scala "2.13.10"
//> using option "-Xsource:3"
//> using lib "dev.zio::zio:2.0.4"
//> using lib "dev.zio::zio-http:0.0.3"

import zio.*
import zio.http.*
import zio.http.model.Method

object Main extends ZIOAppDefault {

  case class Property(name: String, description: String)

  val properties = Vector(
    Property("1. Levels of Scale", ""),
    Property("2. Strong Centers", ""),
    Property("3. Boundaries", ""),
    Property("4. Alternating Repetition", ""),
    Property("5. Positive Space", ""),
    Property("6. Good Shape", ""),
    Property("7. Local Symmetries", ""),
    Property("8. Deep Interlock and Ambiguity", ""),
    Property("9. Contrast", ""),
    Property("10. Gradients", ""),
    Property("11. Roughness", ""),
    Property("12. Echoes", ""),
    Property("13. The Void", ""),
    Property("14. Simplicity and Inner Calm", ""),
    Property("15. Not-separatedness", ""),
  )

  val app: HttpApp[Any, Nothing] = Http.collect[Request] {
    case Method.GET -> !! / "random-property" =>
      val picked = scala.util.Random.shuffle(properties).head
      Response.text(picked.name)
  }

  override val run =
    Server.serve(app).provide(Server.default)
}