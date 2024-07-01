/*
 * (C) Copyright IBM Corp. 2024.
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

package com.ibm.cloud.platform_services.iam_policy_management.v1.model;

import com.google.gson.annotations.SerializedName;
import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * ErrorObject.
 */
public class ErrorObject extends GenericModel {

  /**
   * The API error code for the error.
   */
  public interface Code {
    /** insufficent_permissions. */
    String INSUFFICENT_PERMISSIONS = "insufficent_permissions";
    /** invalid_body. */
    String INVALID_BODY = "invalid_body";
    /** invalid_token. */
    String INVALID_TOKEN = "invalid_token";
    /** missing_required_query_parameter. */
    String MISSING_REQUIRED_QUERY_PARAMETER = "missing_required_query_parameter";
    /** not_found. */
    String NOT_FOUND = "not_found";
    /** policy_conflict_error. */
    String POLICY_CONFLICT_ERROR = "policy_conflict_error";
    /** policy_not_found. */
    String POLICY_NOT_FOUND = "policy_not_found";
    /** request_not_processed. */
    String REQUEST_NOT_PROCESSED = "request_not_processed";
    /** role_conflict_error. */
    String ROLE_CONFLICT_ERROR = "role_conflict_error";
    /** role_not_found. */
    String ROLE_NOT_FOUND = "role_not_found";
    /** too_many_requests. */
    String TOO_MANY_REQUESTS = "too_many_requests";
    /** unable_to_process. */
    String UNABLE_TO_PROCESS = "unable_to_process";
    /** unsupported_content_type. */
    String UNSUPPORTED_CONTENT_TYPE = "unsupported_content_type";
    /** policy_template_conflict_error. */
    String POLICY_TEMPLATE_CONFLICT_ERROR = "policy_template_conflict_error";
    /** policy_template_not_found. */
    String POLICY_TEMPLATE_NOT_FOUND = "policy_template_not_found";
    /** policy_assignment_not_found. */
    String POLICY_ASSIGNMENT_NOT_FOUND = "policy_assignment_not_found";
    /** policy_assignment_conflict_error. */
    String POLICY_ASSIGNMENT_CONFLICT_ERROR = "policy_assignment_conflict_error";
  }

  protected String code;
  protected String message;
  protected ErrorDetails details;
  @SerializedName("more_info")
  protected String moreInfo;

  protected ErrorObject() { }

  /**
   * Gets the code.
   *
   * The API error code for the error.
   *
   * @return the code
   */
  public String getCode() {
    return code;
  }

  /**
   * Gets the message.
   *
   * The error message returned by the API.
   *
   * @return the message
   */
  public String getMessage() {
    return message;
  }

  /**
   * Gets the details.
   *
   * Additional error details.
   *
   * @return the details
   */
  public ErrorDetails getDetails() {
    return details;
  }

  /**
   * Gets the moreInfo.
   *
   * Additional info for error.
   *
   * @return the moreInfo
   */
  public String getMoreInfo() {
    return moreInfo;
  }
}

