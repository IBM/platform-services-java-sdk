/*
 * (C) Copyright IBM Corp. 2023.
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

import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * Body parameters for assignment error.
 */
public class TemplateAssignmentResourceError extends GenericModel {

  protected String name;
  protected String errorCode;
  protected String message;
  protected String statusCode;

  protected TemplateAssignmentResourceError() { }

  /**
   * Gets the name.
   *
   * Name of the error.
   *
   * @return the name
   */
  public String getName() {
    return name;
  }

  /**
   * Gets the errorCode.
   *
   * Internal error code.
   *
   * @return the errorCode
   */
  public String getErrorCode() {
    return errorCode;
  }

  /**
   * Gets the message.
   *
   * Error message detailing the nature of the error.
   *
   * @return the message
   */
  public String getMessage() {
    return message;
  }

  /**
   * Gets the statusCode.
   *
   * Internal status code for the error.
   *
   * @return the statusCode
   */
  public String getStatusCode() {
    return statusCode;
  }
}

