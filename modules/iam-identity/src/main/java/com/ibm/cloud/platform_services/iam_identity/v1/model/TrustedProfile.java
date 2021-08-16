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
 * Response body format for trusted profile V1 REST requests.
 */
public class TrustedProfile extends GenericModel {

  protected ResponseContext context;
  protected String id;
  @SerializedName("entity_tag")
  protected String entityTag;
  protected String crn;
  protected String name;
  protected String description;
  @SerializedName("created_at")
  protected Date createdAt;
  @SerializedName("modified_at")
  protected Date modifiedAt;
  @SerializedName("iam_id")
  protected String iamId;
  @SerializedName("account_id")
  protected String accountId;
  @SerializedName("ims_account_id")
  protected Long imsAccountId;
  @SerializedName("ims_user_id")
  protected Long imsUserId;
  protected List<EnityHistoryRecord> history;

  /**
   * Gets the context.
   *
   * Context with key properties for problem determination.
   *
   * @return the context
   */
  public ResponseContext getContext() {
    return context;
  }

  /**
   * Gets the id.
   *
   * the unique identifier of the trusted profile. Example:'Profile-94497d0d-2ac3-41bf-a993-a49d1b14627c'.
   *
   * @return the id
   */
  public String getId() {
    return id;
  }

  /**
   * Gets the entityTag.
   *
   * Version of the trusted profile details object. You need to specify this value when updating the trusted profile to
   * avoid stale updates.
   *
   * @return the entityTag
   */
  public String getEntityTag() {
    return entityTag;
  }

  /**
   * Gets the crn.
   *
   * Cloud Resource Name of the item. Example Cloud Resource Name:
   * 'crn:v1:bluemix:public:iam-identity:us-south:a/myaccount::profile:Profile-94497d0d-2ac3-41bf-a993-a49d1b14627c'.
   *
   * @return the crn
   */
  public String getCrn() {
    return crn;
  }

  /**
   * Gets the name.
   *
   * Name of the trusted profile. The name is checked for uniqueness. Therefore trusted profiles with the same names can
   * not exist in the same account.
   *
   * @return the name
   */
  public String getName() {
    return name;
  }

  /**
   * Gets the description.
   *
   * The optional description of the trusted profile. The 'description' property is only available if a description was
   * provided during a create of a trusted profile.
   *
   * @return the description
   */
  public String getDescription() {
    return description;
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
   * Gets the iamId.
   *
   * The iam_id of this trusted profile.
   *
   * @return the iamId
   */
  public String getIamId() {
    return iamId;
  }

  /**
   * Gets the accountId.
   *
   * ID of the account that this trusted profile belong to.
   *
   * @return the accountId
   */
  public String getAccountId() {
    return accountId;
  }

  /**
   * Gets the imsAccountId.
   *
   * IMS acount ID of the trusted profile.
   *
   * @return the imsAccountId
   */
  public Long getImsAccountId() {
    return imsAccountId;
  }

  /**
   * Gets the imsUserId.
   *
   * IMS user ID of the trusted profile.
   *
   * @return the imsUserId
   */
  public Long getImsUserId() {
    return imsUserId;
  }

  /**
   * Gets the history.
   *
   * History of the trusted profile.
   *
   * @return the history
   */
  public List<EnityHistoryRecord> getHistory() {
    return history;
  }
}

