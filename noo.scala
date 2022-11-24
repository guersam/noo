//> using scala "2.13.10"
//> using option "-source:3"
//> using lib "dev.zio::zio:2.0.4"

import zio.*

object Main extends ZIOAppDefault {
  val run =
    Console.printLine("Strong Centers")
}