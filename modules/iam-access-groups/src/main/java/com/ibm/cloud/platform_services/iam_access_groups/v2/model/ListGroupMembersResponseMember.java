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

import com.google.gson.annotations.SerializedName;
import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * A single member of an access group in a list.
 */
public class ListGroupMembersResponseMember extends GenericModel {

  @SerializedName("iam_id")
  protected String iamId;
  protected String type;
  protected String name;
  protected String email;
  protected String description;
  protected String href;
  @SerializedName("created_at")
  protected Date createdAt;
  @SerializedName("created_by_id")
  protected String createdById;

  /**
   * Gets the iamId.
   *
   * The IBMid or Service Id of the member.
   *
   * @return the iamId
   */
  public String getIamId() {
    return iamId;
  }

  /**
   * Gets the type.
   *
   * The member type - either `user` or `service`.
   *
   * @return the type
   */
  public String getType() {
    return type;
  }

  /**
   * Gets the name.
   *
   * The user's or service id's name.
   *
   * @return the name
   */
  public String getName() {
    return name;
  }

  /**
   * Gets the email.
   *
   * If the member type is user, this is the user's email.
   *
   * @return the email
   */
  public String getEmail() {
    return email;
  }

  /**
   * Gets the description.
   *
   * If the member type is service, this is the service id's description.
   *
   * @return the description
   */
  public String getDescription() {
    return description;
  }

  /**
   * Gets the href.
   *
   * A url to the given member resource.
   *
   * @return the href
   */
  public String getHref() {
    return href;
  }

  /**
   * Gets the createdAt.
   *
   * The timestamp the membership was created at.
   *
   * @return the createdAt
   */
  public Date getCreatedAt() {
    return createdAt;
  }

  /**
   * Gets the createdById.
   *
   * The `iam_id` of the entity that created the membership.
   *
   * @return the createdById
   */
  public String getCreatedById() {
    return createdById;
  }
}

