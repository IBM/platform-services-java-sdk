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
package com.ibm.cloud.platform_services.iam_identity.v1.model;

import java.util.Date;
import java.util.List;

import com.google.gson.annotations.SerializedName;
import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * Response body format for API key V1 REST requests.
 */
public class ApiKey extends GenericModel {

  protected ResponseContext context;
  protected String id;
  @SerializedName("entity_tag")
  protected String entityTag;
  protected String crn;
  protected Boolean locked;
  @SerializedName("created_at")
  protected Date createdAt;
  @SerializedName("created_by")
  protected String createdBy;
  @SerializedName("modified_at")
  protected Date modifiedAt;
  protected String name;
  protected String description;
  @SerializedName("iam_id")
  protected String iamId;
  @SerializedName("account_id")
  protected String accountId;
  protected String apikey;
  protected List<EnityHistoryRecord> history;
  protected Activity activity;

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
   * Unique identifier of this API Key.
   *
   * @return the id
   */
  public String getId() {
    return id;
  }

  /**
   * Gets the entityTag.
   *
   * Version of the API Key details object. You need to specify this value when updating the API key to avoid stale
   * updates.
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
   * 'crn:v1:bluemix:public:iam-identity:us-south:a/myaccount::apikey:1234-9012-5678'.
   *
   * @return the crn
   */
  public String getCrn() {
    return crn;
  }

  /**
   * Gets the locked.
   *
   * The API key cannot be changed if set to true.
   *
   * @return the locked
   */
  public Boolean isLocked() {
    return locked;
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
   * Gets the createdBy.
   *
   * IAM ID of the user or service which created the API key.
   *
   * @return the createdBy
   */
  public String getCreatedBy() {
    return createdBy;
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
   * Name of the API key. The name is not checked for uniqueness. Therefore multiple names with the same value can
   * exist. Access is done via the UUID of the API key.
   *
   * @return the name
   */
  public String getName() {
    return name;
  }

  /**
   * Gets the description.
   *
   * The optional description of the API key. The 'description' property is only available if a description was provided
   * during a create of an API key.
   *
   * @return the description
   */
  public String getDescription() {
    return description;
  }

  /**
   * Gets the iamId.
   *
   * The iam_id that this API key authenticates.
   *
   * @return the iamId
   */
  public String getIamId() {
    return iamId;
  }

  /**
   * Gets the accountId.
   *
   * ID of the account that this API key authenticates for.
   *
   * @return the accountId
   */
  public String getAccountId() {
    return accountId;
  }

  /**
   * Gets the apikey.
   *
   * The API key value. This property only contains the API key value for the following cases: create an API key, update
   * a service ID API key that stores the API key value as retrievable, or get a service ID API key that stores the API
   * key value as retrievable. All other operations don't return the API key value, for example all user API key related
   * operations, except for create, don't contain the API key value.
   *
   * @return the apikey
   */
  public String getApikey() {
    return apikey;
  }

  /**
   * Gets the history.
   *
   * History of the API key.
   *
   * @return the history
   */
  public List<EnityHistoryRecord> getHistory() {
    return history;
  }

  /**
   * Gets the activity.
   *
   * @return the activity
   */
  public Activity getActivity() {
    return activity;
  }
}

