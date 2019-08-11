import aur._
import aur.info.Info
import aur.search._
import cats.implicits._

object Main extends App {
  println(Endpoints.searchCall.show)

  import com.softwaremill.sttp._
  import tapir.client.sttp._

  implicit val backend: SttpBackend[Id, Nothing] = HttpURLConnectionBackend()

  val request = Endpoints
    .searchCall
    .toSttpRequest(uri"https://aur.archlinux.org/")
    .apply(
      Search.make(Criteria.Depends, "scala")
    )

  val result = request.send().unsafeBody

  println(s"result: ${result.show}")

  val requestI = Endpoints
    .infoCall
    .toSttpRequest(uri"https://aur.archlinux.org/")
    .apply(
      Info.fetch("bloop", "guix")
    )

  val resultI = requestI.send().unsafeBody

  println(s"result: ${resultI.show}")

}
