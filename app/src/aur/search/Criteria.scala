package aur.search

import tapir._

sealed trait Criteria extends Product with Serializable

object Criteria {
  case object Name extends Criteria
  case object NameDesc extends Criteria
  case object Maintainer extends Criteria
  case object Depends extends Criteria
  case object MakeDepends extends Criteria
  case object OptDepends extends Criteria
  case object CheckDepends extends Criteria

  // ===
  implicit val tapirCodecSearchKind = Codec
    .stringPlainCodecUtf8
    .mapDecode[Criteria] { str =>
      str match {
        case "name"         => DecodeResult.Value(Criteria.Name)
        case "name-desc"    => DecodeResult.Value(Criteria.NameDesc)
        case "maintainer"   => DecodeResult.Value(Criteria.Maintainer)
        case "depends"      => DecodeResult.Value(Criteria.Depends)
        case "makedepends"  => DecodeResult.Value(Criteria.MakeDepends)
        case "optdepends"   => DecodeResult.Value(Criteria.OptDepends)
        case "checkdepends" => DecodeResult.Value(Criteria.CheckDepends)
        case _ =>
          DecodeResult
            .Mismatch(
              "name|name-desc|maintainer|depends|makedepends|optdepends|checkdepends",
              str
            )
      }
    } { sKind =>
      sKind match {
        case Criteria.Name         => "name"
        case Criteria.NameDesc     => "name-desc"
        case Criteria.Maintainer   => "maintainer"
        case Criteria.Depends      => "depends"
        case Criteria.MakeDepends  => "makedepends"
        case Criteria.OptDepends   => "optdepends"
        case Criteria.CheckDepends => "checkdepends"
      }
    }

}
