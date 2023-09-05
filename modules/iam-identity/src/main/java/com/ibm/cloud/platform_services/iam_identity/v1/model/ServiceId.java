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
package com.ibm.cloud.platform_services.iam_identity.v1.model;

import java.util.Date;
import java.util.List;

import com.google.gson.annotations.SerializedName;
import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * Response body format for service ID V1 REST requests.
 */
public class ServiceId extends GenericModel {

  protected ResponseContext context;
  protected String id;
  @SerializedName("iam_id")
  protected String iamId;
  @SerializedName("entity_tag")
  protected String entityTag;
  protected String crn;
  protected Boolean locked;
  @SerializedName("created_at")
  protected Date createdAt;
  @SerializedName("modified_at")
  protected Date modifiedAt;
  @SerializedName("account_id")
  protected String accountId;
  protected String name;
  protected String description;
  @SerializedName("unique_instance_crns")
  protected List<String> uniqueInstanceCrns;
  protected List<EnityHistoryRecord> history;
  protected ApiKey apikey;
  protected Activity activity;

  protected ServiceId() { }

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
   * Unique identifier of this Service Id.
   *
   * @return the id
   */
  public String getId() {
    return id;
  }

  /**
   * Gets the iamId.
   *
   * Cloud wide identifier for identities of this service ID.
   *
   * @return the iamId
   */
  public String getIamId() {
    return iamId;
  }

  /**
   * Gets the entityTag.
   *
   * Version of the service ID details object. You need to specify this value when updating the service ID to avoid
   * stale updates.
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
   * 'crn:v1:bluemix:public:iam-identity:us-south:a/myaccount::serviceid:1234-5678-9012'.
   *
   * @return the crn
   */
  public String getCrn() {
    return crn;
  }

  /**
   * Gets the locked.
   *
   * The service ID cannot be changed if set to true.
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
   * Gets the accountId.
   *
   * ID of the account the service ID belongs to.
   *
   * @return the accountId
   */
  public String getAccountId() {
    return accountId;
  }

  /**
   * Gets the name.
   *
   * Name of the Service Id. The name is not checked for uniqueness. Therefore multiple names with the same value can
   * exist. Access is done via the UUID of the Service Id.
   *
   * @return the name
   */
  public String getName() {
    return name;
  }

  /**
   * Gets the description.
   *
   * The optional description of the Service Id. The 'description' property is only available if a description was
   * provided during a create of a Service Id.
   *
   * @return the description
   */
  public String getDescription() {
    return description;
  }

  /**
   * Gets the uniqueInstanceCrns.
   *
   * Optional list of CRNs (string array) which point to the services connected to the service ID.
   *
   * @return the uniqueInstanceCrns
   */
  public List<String> getUniqueInstanceCrns() {
    return uniqueInstanceCrns;
  }

  /**
   * Gets the history.
   *
   * History of the Service ID.
   *
   * @return the history
   */
  public List<EnityHistoryRecord> getHistory() {
    return history;
  }

  /**
   * Gets the apikey.
   *
   * Response body format for API key V1 REST requests.
   *
   * @return the apikey
   */
  public ApiKey getApikey() {
    return apikey;
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

