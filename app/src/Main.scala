import api.Request.SearchParams
import api.{AurEndpoints, Request}

object Main extends App {
  println(AurEndpoints.searchCall.show)

  import com.softwaremill.sttp._
  import tapir.client.sttp._

  implicit val backend: SttpBackend[Id, Nothing] = HttpURLConnectionBackend()

  val request = AurEndpoints.searchCall
    .toSttpRequest(uri"https://aur.archlinux.org/")
    .apply(Request.Search.make(SearchParams(Option.empty, "scala")))

  val result = request.send().unsafeBody

  println(s"result: ${result}")
}
