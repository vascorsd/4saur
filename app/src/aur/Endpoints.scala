package aur

import aur.info._
import aur.search._
import tapir._
import tapir.json.circe._

object Endpoints {
  lazy val baseCall = endpoint
    .get
    .in("rpc" / "")
    .in(query[Version]("v").description("AUR RPC version in use"))
    .in(query[QueryType]("type").description("Type of query to execute"))
    .errorOut(jsonBody[Response])
    .out(jsonBody[Response])

  lazy val searchCall = baseCall
    .in(searchInput)
    .mapIn[Search] {
      case (v, qType, params) =>
        Search(v, qType, params)
    } { s =>
      (s.version, s.queryType, s.params)
    }

  lazy val infoCall = baseCall
    .in(infoInput)
    .mapIn[Info] {
      case (v, qType, params) =>
        Info(v, qType, params)
    } { i =>
      (i.version, i.queryType, i.params)
    }

  private lazy val infoInput =
    query[List[String]]("arg[]")
      .mapTo(info.Params)

  private lazy val searchInput =
    query[Option[Criteria]]("by")
      .description("The kind of search that is going to be performed")
      .and(
        query[String]("arg")
          .description("The argument/value passed to the selected search")
      )
      .mapTo(search.Params)

}
