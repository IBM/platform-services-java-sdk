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

package com.ibm.cloud.platform_services.global_tagging.v1.model;

import com.google.gson.annotations.SerializedName;
import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * Result of an attach_tag or detach_tag request for a tagged resource.
 */
public class TagResultsItem extends GenericModel {

  @SerializedName("resource_id")
  protected String resourceId;
  @SerializedName("is_error")
  protected Boolean isError;
  protected String message;

  protected TagResultsItem() { }

  /**
   * Gets the resourceId.
   *
   * The CRN or IMS ID of the resource.
   *
   * @return the resourceId
   */
  public String getResourceId() {
    return resourceId;
  }

  /**
   * Gets the isError.
   *
   * It is `true` if the operation exits with an error.
   *
   * @return the isError
   */
  public Boolean isIsError() {
    return isError;
  }

  /**
   * Gets the message.
   *
   * Error message returned when the operation fails.
   *
   * @return the message
   */
  public String getMessage() {
    return message;
  }
}

