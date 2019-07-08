package aur

import tapir._


sealed trait QueryType extends Product with Serializable
object QueryType {
  case object Search extends QueryType
  case object Info extends QueryType

  // ---
  implicit
  val queryTypeCodec: Codec[QueryType, MediaType.TextPlain, String] =
    Codec.stringPlainCodecUtf8
      .mapDecode { str =>
        str match {
          case "query" => DecodeResult.Value(QueryType.Search)
          case "info" => DecodeResult.Value(QueryType.Info)
          case v => DecodeResult.Mismatch("query | info", v)
        }
      } { typed =>
        typed match {
          case QueryType.Search => "search"
          case QueryType.Info => "info"
        }
      }
}
