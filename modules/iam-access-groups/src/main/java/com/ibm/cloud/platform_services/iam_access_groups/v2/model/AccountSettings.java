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

import com.google.gson.annotations.SerializedName;
import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * The Access Groups settings for a specific account.
 */
public class AccountSettings extends GenericModel {

  @SerializedName("account_id")
  protected String accountId;
  @SerializedName("last_modified_at")
  protected String lastModifiedAt;
  @SerializedName("last_modified_by_id")
  protected String lastModifiedById;
  @SerializedName("public_access_enabled")
  protected Boolean publicAccessEnabled;

  /**
   * Gets the accountId.
   *
   * The account id of the settings being shown.
   *
   * @return the accountId
   */
  public String getAccountId() {
    return accountId;
  }

  /**
   * Gets the lastModifiedAt.
   *
   * The timestamp the settings were last edited at.
   *
   * @return the lastModifiedAt
   */
  public String getLastModifiedAt() {
    return lastModifiedAt;
  }

  /**
   * Gets the lastModifiedById.
   *
   * The `iam_id` of the entity that last modified the settings.
   *
   * @return the lastModifiedById
   */
  public String getLastModifiedById() {
    return lastModifiedById;
  }

  /**
   * Gets the publicAccessEnabled.
   *
   * This flag controls the public access feature within the account. It is set to true by default. Note: When this flag
   * is set to false, all policies within the account attached to the Public Access group will be deleted.
   *
   * @return the publicAccessEnabled
   */
  public Boolean isPublicAccessEnabled() {
    return publicAccessEnabled;
  }
}

