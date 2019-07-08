import aur._
import aur.search._

object Main extends App {
  println(Endpoints.searchCall.show)

  import com.softwaremill.sttp._
  import tapir.client.sttp._

  implicit val backend: SttpBackend[Id, Nothing] = HttpURLConnectionBackend()

  val request = Endpoints.searchCall
    .toSttpRequest(uri"https://aur.archlinux.org/")
    .apply(Search.make(SearchKind.Name, "scala"))

  val result = request.send().unsafeBody

  println(s"result: ${result}")
}
