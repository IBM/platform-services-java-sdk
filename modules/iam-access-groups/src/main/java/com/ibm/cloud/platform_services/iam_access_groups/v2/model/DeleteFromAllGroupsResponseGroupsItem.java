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
 * DeleteFromAllGroupsResponseGroupsItem.
 */
public class DeleteFromAllGroupsResponseGroupsItem extends GenericModel {

  @SerializedName("access_group_id")
  protected String accessGroupId;
  @SerializedName("status_code")
  protected Long statusCode;
  protected String trace;
  protected List<Error> errors;

  protected DeleteFromAllGroupsResponseGroupsItem() { }

  /**
   * Gets the accessGroupId.
   *
   * The access group that the member is to be deleted from.
   *
   * @return the accessGroupId
   */
  public String getAccessGroupId() {
    return accessGroupId;
  }

  /**
   * Gets the statusCode.
   *
   * The outcome of the delete operation on this `access_group_id`.
   *
   * @return the statusCode
   */
  public Long getStatusCode() {
    return statusCode;
  }

  /**
   * Gets the trace.
   *
   * A transaction-id that can be used for debugging purposes.
   *
   * @return the trace
   */
  public String getTrace() {
    return trace;
  }

  /**
   * Gets the errors.
   *
   * A list of errors that occurred when trying to remove a member from groups.
   *
   * @return the errors
   */
  public List<Error> getErrors() {
    return errors;
  }
}

