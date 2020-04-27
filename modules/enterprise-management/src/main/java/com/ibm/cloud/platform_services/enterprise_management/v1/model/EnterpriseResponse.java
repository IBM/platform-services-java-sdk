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
 * The response from calling get enterprise.
 */
public class EnterpriseResponse extends GenericModel {

  protected String url;
  protected String id;
  @SerializedName("enterprise_account_id")
  protected String enterpriseAccountId;
  protected String crn;
  protected String name;
  protected String domain;
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
   * The URL of the enterprise.
   *
   * @return the url
   */
  public String getUrl() {
    return url;
  }

  /**
   * Gets the id.
   *
   * The enterprise ID.
   *
   * @return the id
   */
  public String getId() {
    return id;
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
   * Gets the crn.
   *
   * The Cloud Resource Name (CRN) of the enterprise.
   *
   * @return the crn
   */
  public String getCrn() {
    return crn;
  }

  /**
   * Gets the name.
   *
   * The name of the enterprise.
   *
   * @return the name
   */
  public String getName() {
    return name;
  }

  /**
   * Gets the domain.
   *
   * The domain of the enterprise.
   *
   * @return the domain
   */
  public String getDomain() {
    return domain;
  }

  /**
   * Gets the state.
   *
   * The state of the enterprise.
   *
   * @return the state
   */
  public String getState() {
    return state;
  }

  /**
   * Gets the primaryContactIamId.
   *
   * The IAM ID of the primary contact of the enterprise, such as `IBMid-0123ABC`.
   *
   * @return the primaryContactIamId
   */
  public String getPrimaryContactIamId() {
    return primaryContactIamId;
  }

  /**
   * Gets the primaryContactEmail.
   *
   * The email of the primary contact of the enterprise.
   *
   * @return the primaryContactEmail
   */
  public String getPrimaryContactEmail() {
    return primaryContactEmail;
  }

  /**
   * Gets the createdAt.
   *
   * The time stamp at which the enterprise was created.
   *
   * @return the createdAt
   */
  public String getCreatedAt() {
    return createdAt;
  }

  /**
   * Gets the createdBy.
   *
   * The IAM ID of the user or service that created the enterprise.
   *
   * @return the createdBy
   */
  public String getCreatedBy() {
    return createdBy;
  }

  /**
   * Gets the updatedAt.
   *
   * The time stamp at which the enterprise was last updated.
   *
   * @return the updatedAt
   */
  public String getUpdatedAt() {
    return updatedAt;
  }

  /**
   * Gets the updatedBy.
   *
   * The IAM ID of the user or service that updated the enterprise.
   *
   * @return the updatedBy
   */
  public String getUpdatedBy() {
    return updatedBy;
  }
}

