/*
 * Copyright 2019 HM Revenue & Customs
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

package uk.gov.hmrc.apipublisher.connectors

import javax.inject.{Inject, Singleton}
import uk.gov.hmrc.apipublisher.models.RegistrationRequest
import uk.gov.hmrc.http.HeaderCarrier
import uk.gov.hmrc.play.bootstrap.http.HttpClient

import scala.concurrent.{ExecutionContext, Future}

@Singleton
class APIDocumentationConnector @Inject()(config: ApiDocumentationConfig, http: HttpClient)(implicit val ec: ExecutionContext) extends ConnectorRecovery {

  lazy val serviceBaseUrl: String = config.baseUrl

  def registerService(registrationRequest: RegistrationRequest)(implicit hc: HeaderCarrier): Future[Unit] = {
    http.POST(s"$serviceBaseUrl/apis/register", registrationRequest).map(_ => ()) recover unprocessableRecovery
  }
}

case class ApiDocumentationConfig(baseUrl: String)