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
package com.ibm.cloud.platform_services.context_based_restrictions.v1.model;

import java.util.Date;

import com.google.gson.annotations.SerializedName;
import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * An output account settings.
 */
public class AccountSettings extends GenericModel {

  protected String id;
  protected String crn;
  @SerializedName("rule_count_limit")
  protected Long ruleCountLimit;
  @SerializedName("zone_count_limit")
  protected Long zoneCountLimit;
  @SerializedName("current_rule_count")
  protected Long currentRuleCount;
  @SerializedName("current_zone_count")
  protected Long currentZoneCount;
  protected String href;
  @SerializedName("created_at")
  protected Date createdAt;
  @SerializedName("created_by_id")
  protected String createdById;
  @SerializedName("last_modified_at")
  protected Date lastModifiedAt;
  @SerializedName("last_modified_by_id")
  protected String lastModifiedById;

  protected AccountSettings() { }

  /**
   * Gets the id.
   *
   * The globally unique ID of the account settings.
   *
   * @return the id
   */
  public String getId() {
    return id;
  }

  /**
   * Gets the crn.
   *
   * The account settings CRN.
   *
   * @return the crn
   */
  public String getCrn() {
    return crn;
  }

  /**
   * Gets the ruleCountLimit.
   *
   * the max number of rules allowed for the account.
   *
   * @return the ruleCountLimit
   */
  public Long getRuleCountLimit() {
    return ruleCountLimit;
  }

  /**
   * Gets the zoneCountLimit.
   *
   * the max number of zones allowed for the account.
   *
   * @return the zoneCountLimit
   */
  public Long getZoneCountLimit() {
    return zoneCountLimit;
  }

  /**
   * Gets the currentRuleCount.
   *
   * the current number of rules used by the account.
   *
   * @return the currentRuleCount
   */
  public Long getCurrentRuleCount() {
    return currentRuleCount;
  }

  /**
   * Gets the currentZoneCount.
   *
   * the current number of zones used by the account.
   *
   * @return the currentZoneCount
   */
  public Long getCurrentZoneCount() {
    return currentZoneCount;
  }

  /**
   * Gets the href.
   *
   * The href link to the resource.
   *
   * @return the href
   */
  public String getHref() {
    return href;
  }

  /**
   * Gets the createdAt.
   *
   * The time the resource was created.
   *
   * @return the createdAt
   */
  public Date getCreatedAt() {
    return createdAt;
  }

  /**
   * Gets the createdById.
   *
   * IAM ID of the user or service which created the resource.
   *
   * @return the createdById
   */
  public String getCreatedById() {
    return createdById;
  }

  /**
   * Gets the lastModifiedAt.
   *
   * The last time the resource was modified.
   *
   * @return the lastModifiedAt
   */
  public Date getLastModifiedAt() {
    return lastModifiedAt;
  }

  /**
   * Gets the lastModifiedById.
   *
   * IAM ID of the user or service which modified the resource.
   *
   * @return the lastModifiedById
   */
  public String getLastModifiedById() {
    return lastModifiedById;
  }
}

