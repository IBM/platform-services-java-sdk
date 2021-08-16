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
import java.util.List;

import com.google.gson.annotations.SerializedName;
import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * ProfileClaimRule.
 */
public class ProfileClaimRule extends GenericModel {

  protected String id;
  @SerializedName("entity_tag")
  protected String entityTag;
  @SerializedName("created_at")
  protected Date createdAt;
  @SerializedName("modified_at")
  protected Date modifiedAt;
  protected String name;
  protected String type;
  @SerializedName("realm_name")
  protected String realmName;
  protected Long expiration;
  @SerializedName("cr_type")
  protected String crType;
  protected List<ProfileClaimRuleConditions> conditions;

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
   * The optional claim rule name.
   *
   * @return the name
   */
  public String getName() {
    return name;
  }

  /**
   * Gets the type.
   *
   * Type of the Calim rule, either 'Profile-SAML' or 'Profile-CR'.
   *
   * @return the type
   */
  public String getType() {
    return type;
  }

  /**
   * Gets the realmName.
   *
   * The realm name of the Idp this claim rule applies to.
   *
   * @return the realmName
   */
  public String getRealmName() {
    return realmName;
  }

  /**
   * Gets the expiration.
   *
   * Session expiration in seconds.
   *
   * @return the expiration
   */
  public Long getExpiration() {
    return expiration;
  }

  /**
   * Gets the crType.
   *
   * The compute resource type. Not required if type is Profile-SAML. Valid values are VSI, IKS_SA, ROKS_SA.
   *
   * @return the crType
   */
  public String getCrType() {
    return crType;
  }

  /**
   * Gets the conditions.
   *
   * Conditions of this claim rule.
   *
   * @return the conditions
   */
  public List<ProfileClaimRuleConditions> getConditions() {
    return conditions;
  }
}

