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
 * The result of applying a zone assignment to a target entity.
 */
public class EnterpriseResource extends GenericModel {

  @SerializedName("resource_created")
  protected EnterpriseResourceID resourceCreated;
  @SerializedName("error_message")
  protected ErrorContainer errorMessage;

  protected EnterpriseResource() { }

  /**
   * Gets the resourceCreated.
   *
   * The identifier of the resource that was created as a result of the assignment.
   *
   * @return the resourceCreated
   */
  public EnterpriseResourceID getResourceCreated() {
    return resourceCreated;
  }

  /**
   * Gets the errorMessage.
   *
   * The error that occurred when applying the assignment to this target, if any.
   *
   * @return the errorMessage
   */
  public ErrorContainer getErrorMessage() {
    return errorMessage;
  }
}

