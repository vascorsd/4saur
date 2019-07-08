package aur.search

import tapir._


sealed trait SearchKind extends Product with Serializable
object SearchKind {
  case object Name extends SearchKind
  case object NameDesc extends SearchKind
  case object Maintainer extends SearchKind
  case object Depends extends SearchKind
  case object MakeDepends extends SearchKind
  case object OptDepends extends SearchKind
  case object CheckDepends extends SearchKind

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
