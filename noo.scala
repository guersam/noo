//> using scala "2.13.10"
//> using option "-Xsource:3"
//> using lib "dev.zio::zio:2.0.4"
//> using lib "dev.zio::zio-http:0.0.3"

import zio.*
import zio.http.*
import zio.http.model.Method

object Main extends ZIOAppDefault {

  val app: HttpApp[Any, Nothing] = Http.collect[Request] {
    case Method.GET -> !! / "random-property" =>
      val properties = Vector(
        "1. Levels of Scale",
        "2. Strong Centers",
        "3. Boundaries",
        "4. Alternating Repetition",
        "5. Positive Space",
        "6. Good Shape",
        "7. Local Symmetries",
        "8. Deep Interlock and Ambiguity",
        "9. Contrast",
        "10. Gradients",
        "11. Roughness",
        "12. Echoes",
        "13. The Void",
        "14. Simplicity and Inner Calm",
        "15. Not-separatedness",
      )
      val picked = scala.util.Random.shuffle(properties).head
      Response.text(picked)
  }

  override val run =
    Server.serve(app).provide(Server.default)
}