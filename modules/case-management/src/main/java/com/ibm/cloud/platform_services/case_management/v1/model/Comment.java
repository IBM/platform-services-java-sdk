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
package com.ibm.cloud.platform_services.case_management.v1.model;

import com.google.gson.annotations.SerializedName;
import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * A comment in a case.
 */
public class Comment extends GenericModel {

  protected String value;
  @SerializedName("added_at")
  protected String addedAt;
  @SerializedName("added_by")
  protected User addedBy;

  /**
   * Gets the value.
   *
   * The comment.
   *
   * @return the value
   */
  public String getValue() {
    return value;
  }

  /**
   * Gets the addedAt.
   *
   * Date time when comment was added in UTC.
   *
   * @return the addedAt
   */
  public String getAddedAt() {
    return addedAt;
  }

  /**
   * Gets the addedBy.
   *
   * User info in a case.
   *
   * @return the addedBy
   */
  public User getAddedBy() {
    return addedBy;
  }
}

