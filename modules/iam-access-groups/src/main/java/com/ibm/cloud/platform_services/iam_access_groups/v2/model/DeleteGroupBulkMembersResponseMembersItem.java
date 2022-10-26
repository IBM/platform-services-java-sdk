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
 * DeleteGroupBulkMembersResponseMembersItem.
 */
public class DeleteGroupBulkMembersResponseMembersItem extends GenericModel {

  @SerializedName("iam_id")
  protected String iamId;
  protected String trace;
  @SerializedName("status_code")
  protected Long statusCode;
  protected List<Error> errors;

  protected DeleteGroupBulkMembersResponseMembersItem() { }

  /**
   * Gets the iamId.
   *
   * The `iam_id` to be deleted.
   *
   * @return the iamId
   */
  public String getIamId() {
    return iamId;
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
   * Gets the statusCode.
   *
   * The outcome of the delete membership operation on this `access_group_id`.
   *
   * @return the statusCode
   */
  public Long getStatusCode() {
    return statusCode;
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

