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
package com.ibm.cloud.platform_services.iam_access_groups.v2.model;

import java.util.List;

import com.google.gson.annotations.SerializedName;
import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * Response object for a single access group template version.
 */
public class ListTemplateVersionResponse extends GenericModel {

  protected String name;
  protected String description;
  @SerializedName("account_id")
  protected String accountId;
  protected String version;
  protected Boolean committed;
  protected AccessGroupResponse group;
  @SerializedName("policy_template_references")
  protected List<PolicyTemplates> policyTemplateReferences;
  protected String href;
  @SerializedName("created_at")
  protected String createdAt;
  @SerializedName("created_by_id")
  protected String createdById;
  @SerializedName("last_modified_at")
  protected String lastModifiedAt;
  @SerializedName("last_modified_by_id")
  protected String lastModifiedById;

  protected ListTemplateVersionResponse() { }

  /**
   * Gets the name.
   *
   * The name of the template.
   *
   * @return the name
   */
  public String getName() {
    return name;
  }

  /**
   * Gets the description.
   *
   * The description of the template.
   *
   * @return the description
   */
  public String getDescription() {
    return description;
  }

  /**
   * Gets the accountId.
   *
   * The ID of the account associated with the template.
   *
   * @return the accountId
   */
  public String getAccountId() {
    return accountId;
  }

  /**
   * Gets the version.
   *
   * The version number of the template.
   *
   * @return the version
   */
  public String getVersion() {
    return version;
  }

  /**
   * Gets the committed.
   *
   * A boolean indicating whether the template is committed or not.
   *
   * @return the committed
   */
  public Boolean isCommitted() {
    return committed;
  }

  /**
   * Gets the group.
   *
   * Access Group Component.
   *
   * @return the group
   */
  public AccessGroupResponse getGroup() {
    return group;
  }

  /**
   * Gets the policyTemplateReferences.
   *
   * A list of policy templates associated with the template.
   *
   * @return the policyTemplateReferences
   */
  public List<PolicyTemplates> getPolicyTemplateReferences() {
    return policyTemplateReferences;
  }

  /**
   * Gets the href.
   *
   * The URL to the template resource.
   *
   * @return the href
   */
  public String getHref() {
    return href;
  }

  /**
   * Gets the createdAt.
   *
   * The date and time the template was created.
   *
   * @return the createdAt
   */
  public String getCreatedAt() {
    return createdAt;
  }

  /**
   * Gets the createdById.
   *
   * The ID of the user who created the template.
   *
   * @return the createdById
   */
  public String getCreatedById() {
    return createdById;
  }

  /**
   * Gets the lastModifiedAt.
   *
   * The date and time the template was last modified.
   *
   * @return the lastModifiedAt
   */
  public String getLastModifiedAt() {
    return lastModifiedAt;
  }

  /**
   * Gets the lastModifiedById.
   *
   * The ID of the user who last modified the template.
   *
   * @return the lastModifiedById
   */
  public String getLastModifiedById() {
    return lastModifiedById;
  }
}

