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

package com.ibm.cloud.platform_services.iam_policy_management.v1.model;

import java.util.Date;

import com.google.gson.annotations.SerializedName;
import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * The set of properties associated with the action control template.
 */
public class ActionControlTemplate extends GenericModel {

  /**
   * State of action control template.
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
  protected Boolean committed;
  @SerializedName("action_control")
  protected TemplateActionControl actionControl;
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
  protected String version;
  protected String state;

  protected ActionControlTemplate() { }

  /**
   * Gets the name.
   *
   * Required field when creating a new template. Otherwise, this field is optional. If the field is included, it
   * changes the name value for all existing versions of the template.
   *
   * @return the name
   */
  public String getName() {
    return name;
  }

  /**
   * Gets the description.
   *
   * Description of the action control template. This is shown to users in the enterprise account. Use this to describe
   * the purpose or context of the action control for enterprise users managing IAM templates.
   *
   * @return the description
   */
  public String getDescription() {
    return description;
  }

  /**
   * Gets the accountId.
   *
   * Enterprise account ID where this template is created.
   *
   * @return the accountId
   */
  public String getAccountId() {
    return accountId;
  }

  /**
   * Gets the committed.
   *
   * Committed status of the template. If committed is set to true, then the template version can no longer be updated.
   *
   * @return the committed
   */
  public Boolean isCommitted() {
    return committed;
  }

  /**
   * Gets the actionControl.
   *
   * The action control properties that are created in an action resource when the template is assigned.
   *
   * @return the actionControl
   */
  public TemplateActionControl getActionControl() {
    return actionControl;
  }

  /**
   * Gets the id.
   *
   * The action control template ID.
   *
   * @return the id
   */
  public String getId() {
    return id;
  }

  /**
   * Gets the href.
   *
   * The href URL that links to the action control templates API by action control template ID.
   *
   * @return the href
   */
  public String getHref() {
    return href;
  }

  /**
   * Gets the createdAt.
   *
   * The UTC timestamp when the action control template was created.
   *
   * @return the createdAt
   */
  public Date getCreatedAt() {
    return createdAt;
  }

  /**
   * Gets the createdById.
   *
   * The IAM ID of the entity that created the action control template.
   *
   * @return the createdById
   */
  public String getCreatedById() {
    return createdById;
  }

  /**
   * Gets the lastModifiedAt.
   *
   * The UTC timestamp when the action control template was last modified.
   *
   * @return the lastModifiedAt
   */
  public Date getLastModifiedAt() {
    return lastModifiedAt;
  }

  /**
   * Gets the lastModifiedById.
   *
   * The IAM ID of the entity that last modified the action control template.
   *
   * @return the lastModifiedById
   */
  public String getLastModifiedById() {
    return lastModifiedById;
  }

  /**
   * Gets the version.
   *
   * The version number of the template used to identify different versions of same template.
   *
   * @return the version
   */
  public String getVersion() {
    return version;
  }

  /**
   * Gets the state.
   *
   * State of action control template.
   *
   * @return the state
   */
  public String getState() {
    return state;
  }
}

