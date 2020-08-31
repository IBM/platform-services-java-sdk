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
package com.ibm.cloud.platform_services.configuration_governance.v1.model;

import java.util.List;

import com.google.gson.annotations.SerializedName;
import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * Response information for a rule request.
 *
 * If the 'status_code' property indicates success, the 'request_id' and 'rule' properties will be present.   If the
 * 'status_code' property indicates an error, the 'request_id', 'errors', and 'trace' fields will be present.
 */
public class CreateRuleResponse extends GenericModel {

  @SerializedName("request_id")
  protected String requestId;
  @SerializedName("status_code")
  protected Long statusCode;
  protected Rule rule;
  protected List<RuleResponseError> errors;
  protected String trace;

  /**
   * Gets the requestId.
   *
   * The identifier that is used to correlate an individual request.
   *
   * To assist with debugging, you can use this ID to identify and inspect only one request that was made as part of a
   * bulk operation.
   *
   * @return the requestId
   */
  public String getRequestId() {
    return requestId;
  }

  /**
   * Gets the statusCode.
   *
   * The HTTP response status code.
   *
   * @return the statusCode
   */
  public Long getStatusCode() {
    return statusCode;
  }

  /**
   * Gets the rule.
   *
   * Information about a newly-created rule.
   *
   * This field will be present for a successful request.
   *
   * @return the rule
   */
  public Rule getRule() {
    return rule;
  }

  /**
   * Gets the errors.
   *
   * The error contents of the multi-status response.
   *
   * This field will be present for a failed rule request.
   *
   * @return the errors
   */
  public List<RuleResponseError> getErrors() {
    return errors;
  }

  /**
   * Gets the trace.
   *
   * The UUID that uniquely identifies the request.
   *
   * This field will be present for a failed rule request.
   *
   * @return the trace
   */
  public String getTrace() {
    return trace;
  }
}

