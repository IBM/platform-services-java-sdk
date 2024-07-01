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
import java.util.List;

import com.google.gson.annotations.SerializedName;
import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * An additional set of properties associated with a role.
 */
public class CustomRole extends GenericModel {

  protected String id;
  @SerializedName("display_name")
  protected String displayName;
  protected String description;
  protected List<String> actions;
  protected String crn;
  protected String name;
  @SerializedName("account_id")
  protected String accountId;
  @SerializedName("service_name")
  protected String serviceName;
  @SerializedName("created_at")
  protected Date createdAt;
  @SerializedName("created_by_id")
  protected String createdById;
  @SerializedName("last_modified_at")
  protected Date lastModifiedAt;
  @SerializedName("last_modified_by_id")
  protected String lastModifiedById;
  protected String href;

  protected CustomRole() { }

  /**
   * Gets the id.
   *
   * The role ID. Composed of hexadecimal characters.
   *
   * @return the id
   */
  public String getId() {
    return id;
  }

  /**
   * Gets the displayName.
   *
   * The display name of the role that is shown in the console.
   *
   * @return the displayName
   */
  public String getDisplayName() {
    return displayName;
  }

  /**
   * Gets the description.
   *
   * The description of the role.
   *
   * @return the description
   */
  public String getDescription() {
    return description;
  }

  /**
   * Gets the actions.
   *
   * The actions of the role. For more information, see [IAM roles and
   * actions](https://cloud.ibm.com/docs/account?topic=account-iam-service-roles-actions).
   *
   * @return the actions
   */
  public List<String> getActions() {
    return actions;
  }

  /**
   * Gets the crn.
   *
   * The role Cloud Resource Name (CRN). Example CRN:
   * 'crn:v1:ibmcloud:public:iam-access-management::a/exampleAccountId::customRole:ExampleRoleName'.
   *
   * @return the crn
   */
  public String getCrn() {
    return crn;
  }

  /**
   * Gets the name.
   *
   * The name of the role that is used in the CRN. Can only be alphanumeric and has to be capitalized.
   *
   * @return the name
   */
  public String getName() {
    return name;
  }

  /**
   * Gets the accountId.
   *
   * The account GUID.
   *
   * @return the accountId
   */
  public String getAccountId() {
    return accountId;
  }

  /**
   * Gets the serviceName.
   *
   * The service name.
   *
   * @return the serviceName
   */
  public String getServiceName() {
    return serviceName;
  }

  /**
   * Gets the createdAt.
   *
   * The UTC timestamp when the role was created.
   *
   * @return the createdAt
   */
  public Date getCreatedAt() {
    return createdAt;
  }

  /**
   * Gets the createdById.
   *
   * The iam ID of the entity that created the role.
   *
   * @return the createdById
   */
  public String getCreatedById() {
    return createdById;
  }

  /**
   * Gets the lastModifiedAt.
   *
   * The UTC timestamp when the role was last modified.
   *
   * @return the lastModifiedAt
   */
  public Date getLastModifiedAt() {
    return lastModifiedAt;
  }

  /**
   * Gets the lastModifiedById.
   *
   * The iam ID of the entity that last modified the policy.
   *
   * @return the lastModifiedById
   */
  public String getLastModifiedById() {
    return lastModifiedById;
  }

  /**
   * Gets the href.
   *
   * The href link back to the role.
   *
   * @return the href
   */
  public String getHref() {
    return href;
  }
}

