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

import com.google.gson.annotations.SerializedName;
import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * Error information.
 */
public class Error extends GenericModel {

  protected String code;
  @SerializedName("message_code")
  protected String messageCode;
  protected String message;
  protected String details;

  protected Error() { }

  /**
   * Gets the code.
   *
   * Error code of the REST Exception.
   *
   * @return the code
   */
  public String getCode() {
    return code;
  }

  /**
   * Gets the messageCode.
   *
   * Error message code of the REST Exception.
   *
   * @return the messageCode
   */
  public String getMessageCode() {
    return messageCode;
  }

  /**
   * Gets the message.
   *
   * Error message of the REST Exception. Error messages are derived base on the input locale of the REST request and
   * the available Message catalogs. Dynamic fallback to 'us-english' is happening if no message catalog is available
   * for the provided input locale.
   *
   * @return the message
   */
  public String getMessage() {
    return message;
  }

  /**
   * Gets the details.
   *
   * Error details of the REST Exception.
   *
   * @return the details
   */
  public String getDetails() {
    return details;
  }
}

