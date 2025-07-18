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

package com.ibm.cloud.platform_services.iam_identity.v1.model;

import com.google.gson.annotations.SerializedName;
import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * ServiceIdGroup.
 */
public class ServiceIdGroup extends GenericModel {

  protected String id;
  @SerializedName("entity_tag")
  protected String entityTag;
  @SerializedName("account_id")
  protected String accountId;
  protected String crn;
  protected String name;
  protected String description;
  @SerializedName("created_at")
  protected String createdAt;
  @SerializedName("created_by")
  protected String createdBy;
  @SerializedName("modified_at")
  protected String modifiedAt;

  protected ServiceIdGroup() { }

  /**
   * Gets the id.
   *
   * ID of the the service ID group.
   *
   * @return the id
   */
  public String getId() {
    return id;
  }

  /**
   * Gets the entityTag.
   *
   * Version of the service ID group details object. You need to specify this value when updating the service ID group
   * to avoid stale updates.
   *
   * @return the entityTag
   */
  public String getEntityTag() {
    return entityTag;
  }

  /**
   * Gets the accountId.
   *
   * ID of the account the service ID group belongs to.
   *
   * @return the accountId
   */
  public String getAccountId() {
    return accountId;
  }

  /**
   * Gets the crn.
   *
   * Cloud Resource Name of the item.
   *
   * @return the crn
   */
  public String getCrn() {
    return crn;
  }

  /**
   * Gets the name.
   *
   * Name of the service ID group. Unique in the account.
   *
   * @return the name
   */
  public String getName() {
    return name;
  }

  /**
   * Gets the description.
   *
   * Description of the service ID group.
   *
   * @return the description
   */
  public String getDescription() {
    return description;
  }

  /**
   * Gets the createdAt.
   *
   * Timestamp of when the service ID group was created.
   *
   * @return the createdAt
   */
  public String getCreatedAt() {
    return createdAt;
  }

  /**
   * Gets the createdBy.
   *
   * IAM ID of the user or service which created the Service Id group.
   *
   * @return the createdBy
   */
  public String getCreatedBy() {
    return createdBy;
  }

  /**
   * Gets the modifiedAt.
   *
   * Timestamp of when the service ID group was modified.
   *
   * @return the modifiedAt
   */
  public String getModifiedAt() {
    return modifiedAt;
  }
}

