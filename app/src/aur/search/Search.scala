package aur.search

import aur._

case class Search private[aur] (
    version: Version,
    queryType: QueryType,
    params: Params
)

object Search {

  def make(by: Criteria, value: String): Search = {
    Search(
      rpcVersion,
      QueryType.Search,
      Params(
        by = Some(by),
        arg = value
      )
    )
  }

  def validate(s: Search): Either[String, Search] = {
    s match {
      case Search(`rpcVersion`, QueryType.Search, _) => Right(s)
      case _                                         => Left("Invalid search values created")
    }
  }
}

case class Params(
    by: Option[Criteria], // when by is not passed, the server uses NameDesc
    arg: String
)
