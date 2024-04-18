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
package com.ibm.cloud.platform_services.usage_metering.v4.model;

import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * Resource usage details.
 */
public class ResourceUsageDetails extends GenericModel {

  protected Long status;
  protected String location;
  protected String code;
  protected String message;

  protected ResourceUsageDetails() { }

  /**
   * Gets the status.
   *
   * A response code similar to HTTP status codes.
   *
   * @return the status
   */
  public Long getStatus() {
    return status;
  }

  /**
   * Gets the location.
   *
   * The location of the usage.
   *
   * @return the location
   */
  public String getLocation() {
    return location;
  }

  /**
   * Gets the code.
   *
   * The error code that was encountered.
   *
   * @return the code
   */
  public String getCode() {
    return code;
  }

  /**
   * Gets the message.
   *
   * A description of the error.
   *
   * @return the message
   */
  public String getMessage() {
    return message;
  }
}

