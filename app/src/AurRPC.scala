import tapir._


sealed trait
QueryType

object
AurRPC {
  val rpcVersion = 5

  val baseCall = endpoint
    .get
    .in("rpc/")
    .in(query[Int]("v").description("AUR RPC version in use"))
    .in(query[QueryType]("type").description("Query type to execute"))

  val searchCall = baseCall
    .in(query[String]("arg").description("The argument/value passed to the selected search"))

}

object
QueryType {

  object Search
    extends QueryType

  object Info
    extends QueryType

  implicit val queryTypeCodec: Codec[QueryType, MediaType.TextPlain, String] =
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