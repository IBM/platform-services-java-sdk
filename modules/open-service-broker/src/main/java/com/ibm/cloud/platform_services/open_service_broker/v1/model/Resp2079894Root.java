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
 * OK - MUST be returned upon successful processing of this request.
 */
public class Resp2079894Root extends GenericModel {

  protected String description;
  protected String state;

  /**
   * Gets the description.
   *
   * A user-facing message displayed to the platform API client. Can be used to tell the user details about the status
   * of the operation. If present, MUST be a non-empty string.
   *
   * @return the description
   */
  public String getDescription() {
    return description;
  }

  /**
   * Gets the state.
   *
   * Valid values are `in progress`, `succeeded`, and `failed`. While `â€ state": "in progressâ€ `, the platform SHOULD
   * continue polling. A response with `â€ state": "succeededâ€ ` or `â€ state": "failedâ€ ` MUST cause the platform to
   * cease polling.
   *
   * @return the state
   */
  public String getState() {
    return state;
  }
}

