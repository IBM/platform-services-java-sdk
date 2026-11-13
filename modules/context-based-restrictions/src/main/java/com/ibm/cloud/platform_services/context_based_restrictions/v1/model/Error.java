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

import com.google.gson.annotations.SerializedName;
import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * Error details to return for failed operations.
 */
public class Error extends GenericModel {

  protected String code;
  protected String message;
  @SerializedName("more_info")
  protected String moreInfo;
  protected ErrorTarget target;
  protected String cause;

  protected Error() { }

  /**
   * Gets the code.
   *
   * A code that is used to identify the problem that caused the error.
   *
   * @return the code
   */
  public String getCode() {
    return code;
  }

  /**
   * Gets the message.
   *
   * An extended description that describes the solution to the problem.
   *
   * @return the message
   */
  public String getMessage() {
    return message;
  }

  /**
   * Gets the moreInfo.
   *
   * The publicly-accessible URL where information about the error can be read in a web browser.
   *
   * @return the moreInfo
   */
  public String getMoreInfo() {
    return moreInfo;
  }

  /**
   * Gets the target.
   *
   * The error target.
   *
   * @return the target
   */
  public ErrorTarget getTarget() {
    return target;
  }

  /**
   * Gets the cause.
   *
   * The underlying cause of the error.
   *
   * @return the cause
   */
  public String getCause() {
    return cause;
  }
}

