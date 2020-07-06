/*
 * (C) Copyright IBM Corp. 2020.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except in compliance with
 * the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License is distributed on
 * an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations under the License.
 */
package com.ibm.cloud.platform_services.open_service_broker.v1.model;

import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * Accepted - MUST be returned if the service instance provisioning is in progress. This triggers the IBM Cloud platform
 * to poll the Service Instance `last_operation` Endpoint for operation status. Note that a re-sent `PUT` request MUST
 * return a `202 Accepted`, not a `200 OK`, if the service instance is not yet fully provisioned.
 */
public class Resp2079874Root extends GenericModel {

  protected String operation;

  /**
   * Gets the operation.
   *
   * For asynchronous responses, service brokers MAY return an identifier representing the operation. The value of this
   * field MUST be provided by the platform with requests to the Last Operation endpoint in a URL encoded query
   * parameter. If present, MUST be a non-empty string.
   *
   * @return the operation
   */
  public String getOperation() {
    return operation;
  }
}

