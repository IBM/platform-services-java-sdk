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
package com.ibm.cloud.platform_services.context_based_restrictions.v1.model;

import java.util.Date;
import java.util.List;

import com.google.gson.annotations.SerializedName;
import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * An output rule.
 */
public class Rule extends GenericModel {

  /**
   * The rule enforcement mode:
   *  * `enabled` - The restrictions are enforced and reported. This is the default.
   *  * `disabled` - The restrictions are disabled. Nothing is enforced or reported.
   *  * `report` - The restrictions are evaluated and reported, but not enforced.
   */
  public interface EnforcementMode {
    /** enabled. */
    String ENABLED = "enabled";
    /** disabled. */
    String DISABLED = "disabled";
    /** report. */
    String REPORT = "report";
  }

  protected String id;
  protected String crn;
  protected String description;
  protected List<RuleContext> contexts;
  protected List<Resource> resources;
  @SerializedName("enforcement_mode")
  protected String enforcementMode;
  protected String href;
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
   * The globally unique ID of the rule.
   *
   * @return the id
   */
  public String getId() {
    return id;
  }

  /**
   * Gets the crn.
   *
   * The rule CRN.
   *
   * @return the crn
   */
  public String getCrn() {
    return crn;
  }

  /**
   * Gets the description.
   *
   * The description of the rule.
   *
   * @return the description
   */
  public String getDescription() {
    return description;
  }

  /**
   * Gets the contexts.
   *
   * The contexts this rule applies to.
   *
   * @return the contexts
   */
  public List<RuleContext> getContexts() {
    return contexts;
  }

  /**
   * Gets the resources.
   *
   * The resources this rule apply to.
   *
   * @return the resources
   */
  public List<Resource> getResources() {
    return resources;
  }

  /**
   * Gets the enforcementMode.
   *
   * The rule enforcement mode:
   *  * `enabled` - The restrictions are enforced and reported. This is the default.
   *  * `disabled` - The restrictions are disabled. Nothing is enforced or reported.
   *  * `report` - The restrictions are evaluated and reported, but not enforced.
   *
   * @return the enforcementMode
   */
  public String getEnforcementMode() {
    return enforcementMode;
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

