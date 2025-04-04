/*
 * (C) Copyright IBM Corp. 2025.
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

package com.ibm.cloud.platform_services.iam_identity.v1.model;

import java.util.List;

import com.google.gson.annotations.SerializedName;
import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * Response body parameters in case of error situations.
 */
public class ExceptionResponse extends GenericModel {

  protected ResponseContext context;
  @SerializedName("status_code")
  protected String statusCode;
  protected List<Error> errors;
  protected String trace;

  protected ExceptionResponse() { }

  /**
   * Gets the context.
   *
   * Context with key properties for problem determination.
   *
   * @return the context
   */
  public ResponseContext getContext() {
    return context;
  }

  /**
   * Gets the statusCode.
   *
   * Error message code of the REST Exception.
   *
   * @return the statusCode
   */
  public String getStatusCode() {
    return statusCode;
  }

  /**
   * Gets the errors.
   *
   * List of errors that occured.
   *
   * @return the errors
   */
  public List<Error> getErrors() {
    return errors;
  }

  /**
   * Gets the trace.
   *
   * Unique ID of the requst.
   *
   * @return the trace
   */
  public String getTrace() {
    return trace;
  }
}

