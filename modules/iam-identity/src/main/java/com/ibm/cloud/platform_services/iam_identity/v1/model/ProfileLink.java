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
package com.ibm.cloud.platform_services.iam_identity.v1.model;

import java.util.Date;

import com.google.gson.annotations.SerializedName;
import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * Link details.
 */
public class ProfileLink extends GenericModel {

  protected String id;
  @SerializedName("entity_tag")
  protected String entityTag;
  @SerializedName("created_at")
  protected Date createdAt;
  @SerializedName("modified_at")
  protected Date modifiedAt;
  protected String name;
  @SerializedName("cr_type")
  protected String crType;
  protected ProfileLinkLink link;

  /**
   * Gets the id.
   *
   * the unique identifier of the claim rule.
   *
   * @return the id
   */
  public String getId() {
    return id;
  }

  /**
   * Gets the entityTag.
   *
   * version of the claim rule.
   *
   * @return the entityTag
   */
  public String getEntityTag() {
    return entityTag;
  }

  /**
   * Gets the createdAt.
   *
   * If set contains a date time string of the creation date in ISO format.
   *
   * @return the createdAt
   */
  public Date getCreatedAt() {
    return createdAt;
  }

  /**
   * Gets the modifiedAt.
   *
   * If set contains a date time string of the last modification date in ISO format.
   *
   * @return the modifiedAt
   */
  public Date getModifiedAt() {
    return modifiedAt;
  }

  /**
   * Gets the name.
   *
   * Optional name of the Link.
   *
   * @return the name
   */
  public String getName() {
    return name;
  }

  /**
   * Gets the crType.
   *
   * The compute resource type. Valid values are VSI, IKS_SA, ROKS_SA.
   *
   * @return the crType
   */
  public String getCrType() {
    return crType;
  }

  /**
   * Gets the link.
   *
   * @return the link
   */
  public ProfileLinkLink getLink() {
    return link;
  }
}

