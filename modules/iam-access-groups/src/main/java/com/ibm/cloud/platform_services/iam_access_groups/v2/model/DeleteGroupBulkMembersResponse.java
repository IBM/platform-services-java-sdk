/*
 * (C) Copyright IBM Corp. 2022.
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
 * The access group id and the members removed from it.
 */
public class DeleteGroupBulkMembersResponse extends GenericModel {

  @SerializedName("access_group_id")
  protected String accessGroupId;
  protected List<DeleteGroupBulkMembersResponseMembersItem> members;

  protected DeleteGroupBulkMembersResponse() { }

  /**
   * Gets the accessGroupId.
   *
   * The access group id.
   *
   * @return the accessGroupId
   */
  public String getAccessGroupId() {
    return accessGroupId;
  }

  /**
   * Gets the members.
   *
   * The `iam_id`s removed from the access group.
   *
   * @return the members
   */
  public List<DeleteGroupBulkMembersResponseMembersItem> getMembers() {
    return members;
  }
}

