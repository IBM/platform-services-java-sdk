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
 * An action that can be performed by the policy subject when assigned role.
 */
public class RoleAction extends GenericModel {

  protected String id;
  @SerializedName("display_name")
  protected String displayName;
  protected String description;

  protected RoleAction() { }

  /**
   * Gets the id.
   *
   * Unique identifier for action with structure service.resource.action e.g., cbr.rule.read.
   *
   * @return the id
   */
  public String getId() {
    return id;
  }

  /**
   * Gets the displayName.
   *
   * Service defined display name for action.
   *
   * @return the displayName
   */
  public String getDisplayName() {
    return displayName;
  }

  /**
   * Gets the description.
   *
   * Service defined description for action.
   *
   * @return the description
   */
  public String getDescription() {
    return description;
  }
}

