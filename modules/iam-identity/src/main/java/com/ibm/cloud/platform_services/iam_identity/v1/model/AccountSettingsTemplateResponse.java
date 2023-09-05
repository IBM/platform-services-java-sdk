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
package com.ibm.cloud.platform_services.iam_identity.v1.model;

import java.util.List;

import com.google.gson.annotations.SerializedName;
import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * Response body format for account settings template REST requests.
 */
public class AccountSettingsTemplateResponse extends GenericModel {

  protected String id;
  protected Long version;
  @SerializedName("account_id")
  protected String accountId;
  protected String name;
  protected String description;
  protected Boolean committed;
  @SerializedName("account_settings")
  protected AccountSettingsComponent accountSettings;
  protected List<EnityHistoryRecord> history;
  @SerializedName("entity_tag")
  protected String entityTag;
  protected String crn;
  @SerializedName("created_at")
  protected String createdAt;
  @SerializedName("created_by_id")
  protected String createdById;
  @SerializedName("last_modified_at")
  protected String lastModifiedAt;
  @SerializedName("last_modified_by_id")
  protected String lastModifiedById;

  protected AccountSettingsTemplateResponse() { }

  /**
   * Gets the id.
   *
   * ID of the the template.
   *
   * @return the id
   */
  public String getId() {
    return id;
  }

  /**
   * Gets the version.
   *
   * Version of the the template.
   *
   * @return the version
   */
  public Long getVersion() {
    return version;
  }

  /**
   * Gets the accountId.
   *
   * ID of the account where the template resides.
   *
   * @return the accountId
   */
  public String getAccountId() {
    return accountId;
  }

  /**
   * Gets the name.
   *
   * The name of the trusted profile template. This is visible only in the enterprise account.
   *
   * @return the name
   */
  public String getName() {
    return name;
  }

  /**
   * Gets the description.
   *
   * The description of the trusted profile template. Describe the template for enterprise account users.
   *
   * @return the description
   */
  public String getDescription() {
    return description;
  }

  /**
   * Gets the committed.
   *
   * Committed flag determines if the template is ready for assignment.
   *
   * @return the committed
   */
  public Boolean isCommitted() {
    return committed;
  }

  /**
   * Gets the accountSettings.
   *
   * @return the accountSettings
   */
  public AccountSettingsComponent getAccountSettings() {
    return accountSettings;
  }

  /**
   * Gets the history.
   *
   * History of the Template.
   *
   * @return the history
   */
  public List<EnityHistoryRecord> getHistory() {
    return history;
  }

  /**
   * Gets the entityTag.
   *
   * Entity tag for this templateId-version combination.
   *
   * @return the entityTag
   */
  public String getEntityTag() {
    return entityTag;
  }

  /**
   * Gets the crn.
   *
   * Cloud resource name.
   *
   * @return the crn
   */
  public String getCrn() {
    return crn;
  }

  /**
   * Gets the createdAt.
   *
   * Template Created At.
   *
   * @return the createdAt
   */
  public String getCreatedAt() {
    return createdAt;
  }

  /**
   * Gets the createdById.
   *
   * IAMid of the creator.
   *
   * @return the createdById
   */
  public String getCreatedById() {
    return createdById;
  }

  /**
   * Gets the lastModifiedAt.
   *
   * Template last modified at.
   *
   * @return the lastModifiedAt
   */
  public String getLastModifiedAt() {
    return lastModifiedAt;
  }

  /**
   * Gets the lastModifiedById.
   *
   * IAMid of the identity that made the latest modification.
   *
   * @return the lastModifiedById
   */
  public String getLastModifiedById() {
    return lastModifiedById;
  }
}

