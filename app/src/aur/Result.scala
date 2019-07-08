package aur

import io.circe._

//case class Meta
//(
//  version: Version,
//  `type`: String,
//  resultCount: Int,
//)
//
//case class Response
//(
//  meta: Meta,
//  data: Data,
//)





sealed trait ReturnType extends Product with Serializable
object ReturnType {
  case object search extends ReturnType
  case object multiInfo extends ReturnType
  case object error extends ReturnType
//  object Error {
//    import io.circe.generic.semiauto.{deriveDecoder, deriveEncoder}
//    implicit val decoderResult: Decoder[Error] = deriveDecoder[Error]
//    implicit val encoderResult: ObjectEncoder[Error] = deriveEncoder[Error]
//  }

  // ---
  import io.circe.generic.extras._
  import io.circe.generic.extras.semiauto._
  implicit val configResult: Configuration = Configuration.default
    .withDiscriminator("type")
  implicit val decoderReturnType: Decoder[ReturnType] = deriveEnumerationDecoder[ReturnType]
  implicit val encoderReturnType: Encoder[ReturnType] = deriveEnumerationEncoder[ReturnType]
}

sealed trait Data extends Product with Serializable
object Data {
  case object Empty extends Data
  // ---
  import io.circe.generic.extras._
  import io.circe.generic.extras.semiauto._
  implicit val configResult: Configuration = Configuration.default
  implicit val decoderData: Decoder[Data] = deriveEnumerationDecoder[Data]
  implicit val encoderData: Encoder[Data] = deriveEnumerationEncoder[Data]
}

case class Result
(
  version: Version,
  `type`: ReturnType,
  resultcount: Int,
  results: List[Json],
  error: Option[String],
)

object Result {
  import io.circe.generic.semiauto._
  implicit val decoderResult: Decoder[Result] = deriveDecoder[Result]
  implicit val encoderResult: ObjectEncoder[Result] = deriveEncoder[Result]
}