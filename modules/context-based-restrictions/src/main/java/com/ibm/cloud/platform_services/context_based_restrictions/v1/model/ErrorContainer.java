/*
 * (C) Copyright IBM Corp. 2026.
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

package com.ibm.cloud.platform_services.context_based_restrictions.v1.model;

import java.util.List;

import com.google.gson.annotations.SerializedName;
import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * Container of error details to return for failed operations.
 */
public class ErrorContainer extends GenericModel {

  protected List<Error> errors;
  protected String trace;
  @SerializedName("status_code")
  protected Long statusCode;

  protected ErrorContainer() { }

  /**
   * Gets the errors.
   *
   * An array with at least one error.
   *
   * @return the errors
   */
  public List<Error> getErrors() {
    return errors;
  }

  /**
   * Gets the trace.
   *
   * A lowercase UUID uniquely identifying the request.
   *
   * @return the trace
   */
  public String getTrace() {
    return trace;
  }

  /**
   * Gets the statusCode.
   *
   * The HTTP status code used for the response.
   *
   * @return the statusCode
   */
  public Long getStatusCode() {
    return statusCode;
  }
}

