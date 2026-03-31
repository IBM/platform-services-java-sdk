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

package com.ibm.cloud.platform_services.iam_identity.v1.model;

import com.google.gson.annotations.SerializedName;
import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * Service ID count for a specific group.
 */
public class ServiceIdGroupCount extends GenericModel {

  @SerializedName("group_id")
  protected String groupId;
  protected Long count;

  protected ServiceIdGroupCount() { }

  /**
   * Gets the groupId.
   *
   * Service ID group identifier.
   *
   * @return the groupId
   */
  public String getGroupId() {
    return groupId;
  }

  /**
   * Gets the count.
   *
   * Number of service IDs in the group.
   *
   * @return the count
   */
  public Long getCount() {
    return count;
  }
}

