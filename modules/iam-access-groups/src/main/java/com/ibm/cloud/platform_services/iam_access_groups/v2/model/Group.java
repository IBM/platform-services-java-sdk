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
package com.ibm.cloud.platform_services.iam_access_groups.v2.model;

import java.util.Date;

import com.google.gson.annotations.SerializedName;
import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * An IAM access group.
 */
public class Group extends GenericModel {

  protected String id;
  protected String name;
  protected String description;
  @SerializedName("account_id")
  protected String accountId;
  @SerializedName("created_at")
  protected Date createdAt;
  @SerializedName("created_by_id")
  protected String createdById;
  @SerializedName("last_modified_at")
  protected Date lastModifiedAt;
  @SerializedName("last_modified_by_id")
  protected String lastModifiedById;
  protected String href;
  @SerializedName("is_federated")
  protected Boolean isFederated;

  protected Group() { }

  /**
   * Gets the id.
   *
   * The group's access group ID.
   *
   * @return the id
   */
  public String getId() {
    return id;
  }

  /**
   * Gets the name.
   *
   * The group's name.
   *
   * @return the name
   */
  public String getName() {
    return name;
  }

  /**
   * Gets the description.
   *
   * The group's description - if defined.
   *
   * @return the description
   */
  public String getDescription() {
    return description;
  }

  /**
   * Gets the accountId.
   *
   * The account id where the group was created.
   *
   * @return the accountId
   */
  public String getAccountId() {
    return accountId;
  }

  /**
   * Gets the createdAt.
   *
   * The timestamp the group was created at.
   *
   * @return the createdAt
   */
  public Date getCreatedAt() {
    return createdAt;
  }

  /**
   * Gets the createdById.
   *
   * The `iam_id` of the entity that created the group.
   *
   * @return the createdById
   */
  public String getCreatedById() {
    return createdById;
  }

  /**
   * Gets the lastModifiedAt.
   *
   * The timestamp the group was last edited at.
   *
   * @return the lastModifiedAt
   */
  public Date getLastModifiedAt() {
    return lastModifiedAt;
  }

  /**
   * Gets the lastModifiedById.
   *
   * The `iam_id` of the entity that last modified the group name or description.
   *
   * @return the lastModifiedById
   */
  public String getLastModifiedById() {
    return lastModifiedById;
  }

  /**
   * Gets the href.
   *
   * A url to the given group resource.
   *
   * @return the href
   */
  public String getHref() {
    return href;
  }

  /**
   * Gets the isFederated.
   *
   * This is set to true if rules exist for the group.
   *
   * @return the isFederated
   */
  public Boolean isIsFederated() {
    return isFederated;
  }
}

