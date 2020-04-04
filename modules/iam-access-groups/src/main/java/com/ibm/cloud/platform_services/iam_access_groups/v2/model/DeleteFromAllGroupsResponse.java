/*
 * (C) Copyright IBM Corp. 2020.
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

import java.util.List;

import com.google.gson.annotations.SerializedName;
import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * The response from the delete member from access groups request.
 */
public class DeleteFromAllGroupsResponse extends GenericModel {

  @SerializedName("iam_id")
  protected String iamId;
  protected List<DeleteFromAllGroupsResponseGroupsItem> groups;

  /**
   * Gets the iamId.
   *
   * The `iam_id` of the member to removed from groups.
   *
   * @return the iamId
   */
  public String getIamId() {
    return iamId;
  }

  /**
   * Gets the groups.
   *
   * The groups the member was removed from.
   *
   * @return the groups
   */
  public List<DeleteFromAllGroupsResponseGroupsItem> getGroups() {
    return groups;
  }
}

