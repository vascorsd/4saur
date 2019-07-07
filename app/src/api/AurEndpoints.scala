package api

import api.Request.{SearchKind, Version}
import tapir._



sealed trait
ReturnType

object
ReturnType {
  object
  Search
      extends ReturnType

  object
  MultiInfo
      extends ReturnType

  object
  Error
      extends ReturnType
}

sealed trait
ReturnData

object
ReturnData {
  object
  Empty
      extends ReturnData

}


case class
InfoQuery
(
  arg: List[String],
)

case class
Result
(
  version: Int,
  `type`: ReturnType,
  resultCount: Int,
  results: ReturnData,
  error: Option[String],
)

object AurEndpoints {
  lazy
  val baseCall = endpoint
    .get
    .in("rpc" / "")
    .in(query[Version]("v").description("AUR RPC version in use"))
    .in(query[QueryType]("type").description("Type of query to execute"))
    .errorOut(stringBody)
    .out(stringBody)

  lazy
  val searchCall = baseCall
    .in(searchInput)
    .mapIn[Request.Search] { case (v, qType, params) =>
      Request.Search(v, qType, params)
    } { s =>
      (s.version, s.queryType, s.params)
    }


  lazy
  val infoCall = baseCall
    .in(infoInput)

  private lazy
  val searchInput =
    query[Option[SearchKind]]("by")
      .and(
        query[String]("arg").description("The argument/value passed to the selected search")
      )
      .mapTo(Request.SearchParams)

  private lazy
  val infoInput =
    query[List[String]]("arg[]")
      .mapTo(InfoQuery)
}


sealed trait QueryType
object QueryType {
  object Search extends QueryType
  object Info extends QueryType

  // instances:
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