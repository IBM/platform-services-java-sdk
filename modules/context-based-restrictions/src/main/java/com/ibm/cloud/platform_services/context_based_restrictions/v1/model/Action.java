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

package com.ibm.cloud.platform_services.context_based_restrictions.v1.model;

import com.google.gson.annotations.SerializedName;
import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * Service API Type actions.
 */
public class Action extends GenericModel {

  @SerializedName("action_id")
  protected String actionId;
  protected String description;

  protected Action() { }

  /**
   * Gets the actionId.
   *
   * The id of the action.
   *
   * @return the actionId
   */
  public String getActionId() {
    return actionId;
  }

  /**
   * Gets the description.
   *
   * The description of the action.
   *
   * @return the description
   */
  public String getDescription() {
    return description;
  }
}

