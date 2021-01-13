/*
 * (C) Copyright IBM Corp. 2021.
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
 * A rule of an access group.
 */
public class Rule extends GenericModel {

  protected String id;
  protected String name;
  protected Long expiration;
  @SerializedName("realm_name")
  protected String realmName;
  @SerializedName("access_group_id")
  protected String accessGroupId;
  @SerializedName("account_id")
  protected String accountId;
  protected List<RuleConditions> conditions;
  @SerializedName("created_at")
  protected Date createdAt;
  @SerializedName("created_by_id")
  protected String createdById;
  @SerializedName("last_modified_at")
  protected Date lastModifiedAt;
  @SerializedName("last_modified_by_id")
  protected String lastModifiedById;

  /**
   * Gets the id.
   *
   * The rule id.
   *
   * @return the id
   */
  public String getId() {
    return id;
  }

  /**
   * Gets the name.
   *
   * The name of the rule.
   *
   * @return the name
   */
  public String getName() {
    return name;
  }

  /**
   * Gets the expiration.
   *
   * The number of hours that the rule lives for (Must be between 1 and 24).
   *
   * @return the expiration
   */
  public Long getExpiration() {
    return expiration;
  }

  /**
   * Gets the realmName.
   *
   * The url of the identity provider.
   *
   * @return the realmName
   */
  public String getRealmName() {
    return realmName;
  }

  /**
   * Gets the accessGroupId.
   *
   * The group id that the rule is assigned to.
   *
   * @return the accessGroupId
   */
  public String getAccessGroupId() {
    return accessGroupId;
  }

  /**
   * Gets the accountId.
   *
   * The account id that the group is in.
   *
   * @return the accountId
   */
  public String getAccountId() {
    return accountId;
  }

  /**
   * Gets the conditions.
   *
   * A list of conditions the rule must satisfy.
   *
   * @return the conditions
   */
  public List<RuleConditions> getConditions() {
    return conditions;
  }

  /**
   * Gets the createdAt.
   *
   * The timestamp the rule was created at.
   *
   * @return the createdAt
   */
  public Date getCreatedAt() {
    return createdAt;
  }

  /**
   * Gets the createdById.
   *
   * The `iam_id` of the entity that created the rule.
   *
   * @return the createdById
   */
  public String getCreatedById() {
    return createdById;
  }

  /**
   * Gets the lastModifiedAt.
   *
   * The timestamp the rule was last edited at.
   *
   * @return the lastModifiedAt
   */
  public Date getLastModifiedAt() {
    return lastModifiedAt;
  }

  /**
   * Gets the lastModifiedById.
   *
   * The IAM id that last modified the rule.
   *
   * @return the lastModifiedById
   */
  public String getLastModifiedById() {
    return lastModifiedById;
  }
}

