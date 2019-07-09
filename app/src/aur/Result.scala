package aur

import io.circe._
import io.circe.generic.extras._
import io.circe.syntax._
import io.scalaland.catnip._
import cats._
import cats.derived.ShowPretty
import cats.implicits._


@Semi(ShowPretty)
case class Response
(
  meta: Meta,
  results: List[Data],
  error: Option[String]
)

object Response {
  implicit val decoderResult: Decoder[Response] = new Decoder[Response] {
    def apply(c: HCursor): Decoder.Result[Response] = for {
      meta <- c.as[Meta]
      results <- c.downField("results").as[List[Data]]
      error <- c.downField("error").as[Option[String]]
    } yield Response(meta, results, error)
  }

  implicit val encoderResult: Encoder[Response] = new Encoder[Response] {
    def apply(a: Response): Json = {
      val meta = a.meta.asJson
      val results = Json.obj("results" -> a.results.asJson)
      val error = a.error.fold(Json.obj())(err => Json.obj("error" -> err.asJson))

      meta.deepMerge(results).deepMerge(error)
    }
  }
}

@Semi(ShowPretty)
@ConfiguredJsonCodec
case class Meta
(
  version: Version,
  `type`: String,
  @JsonKey("resultcount")
  resultCount: Long,
)
object Meta {
  implicit val jsonCodecConfig = Configuration.default
}

@Semi(ShowPretty)
@ConfiguredJsonCodec
case class Data
(
  @JsonKey("ID")
  id: Long,
  @JsonKey("Name")
  name: String,
  PackageBaseID: Long,
  PackageBase: String,
  Version: String,
  Description: String,
  URL: String,
  NumVotes: Long,
  Popularity: BigDecimal,
  OutOfDate: Option[Long],
  Maintainer: Option[String],
  FirstSubmitted: Long,
  LastModified: Long,
  URLPath: String,
)
object Data {
  implicit val jsonCodecConfig = Configuration.default
}
