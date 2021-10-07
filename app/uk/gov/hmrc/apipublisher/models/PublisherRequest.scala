/*
 * Copyright 2021 HM Revenue & Customs
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package uk.gov.hmrc.apipublisher.models

import play.api.libs.json._
import uk.gov.hmrc.apipublisher.models.APICategory.{APICategory, formatAPICategory}
import uk.gov.hmrc.http.UnprocessableEntityException


case class OptionalFieldDefinitions(version: String, fieldDefinitions: Option[Seq[FieldDefinition]])

object OptionalFieldDefinitions {
  implicit val reads = Json.reads[OptionalFieldDefinitions]
}

case class Scope(key: String, name: String, description: String)

object Scope {
  implicit val formats = Json.format[Scope]
}

case class ServiceLocation(serviceName: String, serviceUrl: String, metadata: Option[Map[String, String]] = None)

object ServiceLocation {
  implicit val formats = Json.format[ServiceLocation]
}
