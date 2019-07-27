package aur

import cats.derived.ShowPretty
import io.circe._
import io.circe.generic.extras._
import io.circe.syntax._
import io.scalaland.catnip._
import cats.implicits._

@Semi(ShowPretty)
case class Response(
    meta: Meta,
    results: List[Data],
    error: Option[String]
)

object Response {
  implicit val decoderResult: Decoder[Response] = new Decoder[Response] {

    def apply(c: HCursor): Decoder.Result[Response] =
      for {
        meta    <- c.as[Meta]
        results <- c.downField("results").as[List[Data]]
        error   <- c.downField("error").as[Option[String]]
      } yield Response(meta, results, error)
  }

  implicit val encoderResult: Encoder[Response] = new Encoder[Response] {

    def apply(a: Response): Json = {
      val meta = a.meta.asJson
      val results = Json.obj("results" -> a.results.asJson)
      val error =
        a.error.fold(Json.obj())(err => Json.obj("error" -> err.asJson))

      meta.deepMerge(results).deepMerge(error)
    }
  }
}

@Semi(ShowPretty)
@ConfiguredJsonCodec
case class Meta(
    version: Version,
    `type`: String,
    @JsonKey("resultcount")
    resultCount: Long
)

object Meta {
  implicit val jsonCodecConfig = Configuration.default
}

@Semi(ShowPretty)
@ConfiguredJsonCodec
case class Data(
    // ================================== Search type:
    @JsonKey("ID")
    id: Long,
    @JsonKey("Name")
    name: String,
    @JsonKey("PackageBaseID")
    packageBaseId: Long,
    @JsonKey("PackageBase")
    packageBase: String,
    @JsonKey("Version")
    version: String,
    @JsonKey("Description")
    description: String,
    @JsonKey("URL")
    url: String,
    @JsonKey("NumVotes")
    numVotes: Long,
    @JsonKey("Popularity")
    popularity: BigDecimal,
    @JsonKey("OutOfDate")
    outOfDate: Option[Long],
    @JsonKey("Maintainer")
    maintainer: Option[String],
    @JsonKey("FirstSubmitted")
    firstSubmitted: Long,
    @JsonKey("LastModified")
    lastModified: Long,
    URLPath: String,
    // ================================== Info type has extra:
    @JsonKey("Depends")
    depends: Option[List[String]],
    @JsonKey("MakeDepends")
    makeDepends: Option[List[String]],
    @JsonKey("OptDepends")
    optDepends: Option[List[String]],
    @JsonKey("CheckDepends")
    checkDepends: Option[List[String]],
    @JsonKey("Conflicts")
    conflicts: Option[List[String]],
    @JsonKey("Provides")
    provides: Option[List[String]],
    @JsonKey("Replaces")
    replaces: Option[List[String]],
    @JsonKey("Groups")
    groups: Option[List[String]],
    @JsonKey("License")
    license: Option[List[String]],
    @JsonKey("Keywords")
    keywords: Option[List[String]]
)

object Data {
  implicit val jsonCodecConfig = Configuration.default
}
