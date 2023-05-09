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
package com.ibm.cloud.platform_services.iam_access_groups.v2.model;

import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * Error contains the code and message for an error returned to the user code is a string identifying the problem,
 * examples "missing_field", "reserved_value" message is a string explaining the solution to the problem that was
 * encountered.
 */
public class Error extends GenericModel {

  protected String code;
  protected String message;

  protected Error() { }

  /**
   * Gets the code.
   *
   * A human-readable error code represented by a snake case string.
   *
   * @return the code
   */
  public String getCode() {
    return code;
  }

  /**
   * Gets the message.
   *
   * A specific error message that details the issue or an action to take.
   *
   * @return the message
   */
  public String getMessage() {
    return message;
  }
}

