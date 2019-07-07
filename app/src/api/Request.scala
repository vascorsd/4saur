package api

import tapir._

object Request {
  type Version = Int
  val rpcVersion: Version = 5

  case class Search(
    version: Version,
    queryType: QueryType,
    params: SearchParams
  )
  object Search {
    def make(params: SearchParams): Search =
      Search(rpcVersion, QueryType.Search, params)

    def validate(s: Search): Either[String, Search] = {
      s match {
        case Search(`rpcVersion`, QueryType.Search, _) => Right(s)
        case _ => Left("Invalid search values created")
      }
    }
  }

  case class SearchParams
  (
    by: Option[SearchKind], // when by is not passed, the server uses NameDesc
    arg: String,
  )

  sealed trait SearchKind
  object SearchKind {
    object Name extends SearchKind
    object NameDesc extends SearchKind
    object Maintainer extends SearchKind
    object Depends extends SearchKind
    object MakeDepends extends SearchKind
    object OptDepends extends SearchKind
    object CheckDepends extends SearchKind

    // ===
    implicit
    val tapirCodecSearchKind = Codec
      .stringPlainCodecUtf8
      .mapDecode[SearchKind] { str =>
      str match {
        case "name" => DecodeResult.Value(SearchKind.Name)
        case "name-desc" => DecodeResult.Value(SearchKind.NameDesc)
        case "maintainer" => DecodeResult.Value(SearchKind.Maintainer)
        case "depends" => DecodeResult.Value(SearchKind.Depends)
        case "makedepends" => DecodeResult.Value(SearchKind.MakeDepends)
        case "optdepends" => DecodeResult.Value(SearchKind.OptDepends)
        case "checkdepends" => DecodeResult.Value(SearchKind.CheckDepends)
        case _ => DecodeResult
          .Mismatch(
            "name|name-desc|maintainer|depends|makedepends|optdepends|checkdepends",
            str
          )
      }
    } { sKind =>
      sKind match {
        case SearchKind.Name => "name"
        case SearchKind.NameDesc => "name-desc"
        case SearchKind.Maintainer => "maintainer"
        case SearchKind.Depends => "depends"
        case SearchKind.MakeDepends => "makedepends"
        case SearchKind.OptDepends => "optdepends"
        case SearchKind.CheckDepends => "checkdepends"
      }
    }

  }

}
