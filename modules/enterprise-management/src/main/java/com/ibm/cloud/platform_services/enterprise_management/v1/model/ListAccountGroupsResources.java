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
package com.ibm.cloud.platform_services.enterprise_management.v1.model;

import com.google.gson.annotations.SerializedName;
import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * An object that represents account groups resource.
 */
public class ListAccountGroupsResources extends GenericModel {

  protected String url;
  protected String id;
  protected String crn;
  protected String parent;
  @SerializedName("enterprise_account_id")
  protected String enterpriseAccountId;
  @SerializedName("enterprise_id")
  protected String enterpriseId;
  @SerializedName("enterprise_path")
  protected String enterprisePath;
  protected String name;
  protected String state;
  @SerializedName("primary_contact_iam_id")
  protected String primaryContactIamId;
  @SerializedName("primary_contact_email")
  protected String primaryContactEmail;
  @SerializedName("created_at")
  protected String createdAt;
  @SerializedName("created_by")
  protected String createdBy;
  @SerializedName("updated_at")
  protected String updatedAt;
  @SerializedName("updated_by")
  protected String updatedBy;

  /**
   * Gets the url.
   *
   * The URL of the account group.
   *
   * @return the url
   */
  public String getUrl() {
    return url;
  }

  /**
   * Gets the id.
   *
   * The account group ID.
   *
   * @return the id
   */
  public String getId() {
    return id;
  }

  /**
   * Gets the crn.
   *
   * The Cloud Resource Name (CRN) of the account group.
   *
   * @return the crn
   */
  public String getCrn() {
    return crn;
  }

  /**
   * Gets the parent.
   *
   * The CRN of the parent of the account group.
   *
   * @return the parent
   */
  public String getParent() {
    return parent;
  }

  /**
   * Gets the enterpriseAccountId.
   *
   * The enterprise account ID.
   *
   * @return the enterpriseAccountId
   */
  public String getEnterpriseAccountId() {
    return enterpriseAccountId;
  }

  /**
   * Gets the enterpriseId.
   *
   * The enterprise ID that the account group is a part of.
   *
   * @return the enterpriseId
   */
  public String getEnterpriseId() {
    return enterpriseId;
  }

  /**
   * Gets the enterprisePath.
   *
   * The path from the enterprise to this particular account group.
   *
   * @return the enterprisePath
   */
  public String getEnterprisePath() {
    return enterprisePath;
  }

  /**
   * Gets the name.
   *
   * The name of the account group.
   *
   * @return the name
   */
  public String getName() {
    return name;
  }

  /**
   * Gets the state.
   *
   * The state of the account group.
   *
   * @return the state
   */
  public String getState() {
    return state;
  }

  /**
   * Gets the primaryContactIamId.
   *
   * The IAM ID of the primary contact of the account group.
   *
   * @return the primaryContactIamId
   */
  public String getPrimaryContactIamId() {
    return primaryContactIamId;
  }

  /**
   * Gets the primaryContactEmail.
   *
   * The email address of the primary contact of the account group.
   *
   * @return the primaryContactEmail
   */
  public String getPrimaryContactEmail() {
    return primaryContactEmail;
  }

  /**
   * Gets the createdAt.
   *
   * The time stamp at which the account group was created.
   *
   * @return the createdAt
   */
  public String getCreatedAt() {
    return createdAt;
  }

  /**
   * Gets the createdBy.
   *
   * The IAM ID of the user or service that created the account group.
   *
   * @return the createdBy
   */
  public String getCreatedBy() {
    return createdBy;
  }

  /**
   * Gets the updatedAt.
   *
   * The time stamp at which the account group was last updated.
   *
   * @return the updatedAt
   */
  public String getUpdatedAt() {
    return updatedAt;
  }

  /**
   * Gets the updatedBy.
   *
   * The IAM ID of the user or service that updated the account group.
   *
   * @return the updatedBy
   */
  public String getUpdatedBy() {
    return updatedBy;
  }
}

