/*
 * (C) Copyright IBM Corp. 2024.
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

package com.ibm.cloud.platform_services.iam_policy_management.v1.model;

import java.util.Date;

import com.google.gson.annotations.SerializedName;
import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * The core set of properties associated with the policy template.
 */
public class PolicyTemplate extends GenericModel {

  /**
   * State of policy template.
   */
  public interface State {
    /** active. */
    String ACTIVE = "active";
    /** deleted. */
    String DELETED = "deleted";
  }

  protected String name;
  protected String description;
  @SerializedName("account_id")
  protected String accountId;
  protected String version;
  protected Boolean committed;
  protected TemplatePolicy policy;
  protected String state;
  protected String id;
  protected String href;
  @SerializedName("created_at")
  protected Date createdAt;
  @SerializedName("created_by_id")
  protected String createdById;
  @SerializedName("last_modified_at")
  protected Date lastModifiedAt;
  @SerializedName("last_modified_by_id")
  protected String lastModifiedById;

  protected PolicyTemplate() { }

  /**
   * Gets the name.
   *
   * Required field when creating a new template. Otherwise this field is optional. If the field is included it will
   * change the name value for all existing versions of the template.
   *
   * @return the name
   */
  public String getName() {
    return name;
  }

  /**
   * Gets the description.
   *
   * Description of the policy template. This is shown to users in the enterprise account. Use this to describe the
   * purpose or context of the policy for enterprise users managing IAM templates.
   *
   * @return the description
   */
  public String getDescription() {
    return description;
  }

  /**
   * Gets the accountId.
   *
   * Enterprise account ID where this template will be created.
   *
   * @return the accountId
   */
  public String getAccountId() {
    return accountId;
  }

  /**
   * Gets the version.
   *
   * Template version.
   *
   * @return the version
   */
  public String getVersion() {
    return version;
  }

  /**
   * Gets the committed.
   *
   * Committed status of the template version.
   *
   * @return the committed
   */
  public Boolean isCommitted() {
    return committed;
  }

  /**
   * Gets the policy.
   *
   * The core set of properties associated with the template's policy objet.
   *
   * @return the policy
   */
  public TemplatePolicy getPolicy() {
    return policy;
  }

  /**
   * Gets the state.
   *
   * State of policy template.
   *
   * @return the state
   */
  public String getState() {
    return state;
  }

  /**
   * Gets the id.
   *
   * The policy template ID.
   *
   * @return the id
   */
  public String getId() {
    return id;
  }

  /**
   * Gets the href.
   *
   * The href URL that links to the policy templates API by policy template ID.
   *
   * @return the href
   */
  public String getHref() {
    return href;
  }

  /**
   * Gets the createdAt.
   *
   * The UTC timestamp when the policy template was created.
   *
   * @return the createdAt
   */
  public Date getCreatedAt() {
    return createdAt;
  }

  /**
   * Gets the createdById.
   *
   * The iam ID of the entity that created the policy template.
   *
   * @return the createdById
   */
  public String getCreatedById() {
    return createdById;
  }

  /**
   * Gets the lastModifiedAt.
   *
   * The UTC timestamp when the policy template was last modified.
   *
   * @return the lastModifiedAt
   */
  public Date getLastModifiedAt() {
    return lastModifiedAt;
  }

  /**
   * Gets the lastModifiedById.
   *
   * The iam ID of the entity that last modified the policy template.
   *
   * @return the lastModifiedById
   */
  public String getLastModifiedById() {
    return lastModifiedById;
  }
}

