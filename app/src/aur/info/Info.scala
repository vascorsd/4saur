package aur.info

import aur.{rpcVersion, QueryType, Version}

case class Info private[aur] (
    version: Version,
    queryType: QueryType,
    params: Params
)

case class Params(
    arg: List[String]
)

object Info {

  def fetch(`package`: String*) = {
    Info(
      rpcVersion,
      QueryType.Info,
      Params(
        `package`.toList
      )
    )
  }
}
