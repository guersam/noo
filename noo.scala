//> using scala "2.13.10"
//> using option "-Xsource:3"
//> using lib "dev.zio::zio:2.0.4"
//> using lib "dev.zio::zio-http:0.0.3"

import zio.*
import zio.http.*
import zio.http.model.Method

object Main extends ZIOAppDefault {

  val app: HttpApp[Any, Nothing] = Http.collect[Request] {
    case Method.GET -> !! / "random-property" => Response.text("Strong Centers")
  }

  override val run =
    Server.serve(app).provide(Server.default)
}