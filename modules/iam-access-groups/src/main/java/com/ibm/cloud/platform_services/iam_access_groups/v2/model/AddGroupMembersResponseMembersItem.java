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

import java.util.Date;
import java.util.List;

import com.google.gson.annotations.SerializedName;
import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * AddGroupMembersResponseMembersItem.
 */
public class AddGroupMembersResponseMembersItem extends GenericModel {

  @SerializedName("iam_id")
  protected String iamId;
  protected String type;
  @SerializedName("created_at")
  protected Date createdAt;
  @SerializedName("created_by_id")
  protected String createdById;
  @SerializedName("status_code")
  protected Long statusCode;
  protected String trace;
  protected List<Error> errors;

  protected AddGroupMembersResponseMembersItem() { }

  /**
   * Gets the iamId.
   *
   * The IBMid or Service Id of the member.
   *
   * @return the iamId
   */
  public String getIamId() {
    return iamId;
  }

  /**
   * Gets the type.
   *
   * The member type - either `user`, `service` or `profile`.
   *
   * @return the type
   */
  public String getType() {
    return type;
  }

  /**
   * Gets the createdAt.
   *
   * The timestamp of when the membership was created.
   *
   * @return the createdAt
   */
  public Date getCreatedAt() {
    return createdAt;
  }

  /**
   * Gets the createdById.
   *
   * The `iam_id` of the entity that created the membership.
   *
   * @return the createdById
   */
  public String getCreatedById() {
    return createdById;
  }

  /**
   * Gets the statusCode.
   *
   * The outcome of the operation on this `iam_id`.
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
   * A list of errors that occurred when trying to add members to a group.
   *
   * @return the errors
   */
  public List<Error> getErrors() {
    return errors;
  }
}

