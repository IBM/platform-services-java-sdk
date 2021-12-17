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
package com.ibm.cloud.platform_services.catalog_management.v1.model;

import java.util.Date;

import com.google.gson.annotations.SerializedName;
import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * An audit record which describes a change made to a catalog or associated resource.
 */
public class AuditRecord extends GenericModel {

  protected String id;
  protected Date created;
  @SerializedName("change_type")
  protected String changeType;
  @SerializedName("target_type")
  protected String targetType;
  @SerializedName("target_id")
  protected String targetId;
  @SerializedName("who_delegate_email")
  protected String whoDelegateEmail;
  protected String message;

  /**
   * Gets the id.
   *
   * The identifier of the audit record.
   *
   * @return the id
   */
  public String getId() {
    return id;
  }

  /**
   * Gets the created.
   *
   * The time at which the change was made.
   *
   * @return the created
   */
  public Date getCreated() {
    return created;
  }

  /**
   * Gets the changeType.
   *
   * The type of change described by the audit record.
   *
   * @return the changeType
   */
  public String getChangeType() {
    return changeType;
  }

  /**
   * Gets the targetType.
   *
   * The resource type associated with the change.
   *
   * @return the targetType
   */
  public String getTargetType() {
    return targetType;
  }

  /**
   * Gets the targetId.
   *
   * The identifier of the resource that was changed.
   *
   * @return the targetId
   */
  public String getTargetId() {
    return targetId;
  }

  /**
   * Gets the whoDelegateEmail.
   *
   * The email address of the user that made the change.
   *
   * @return the whoDelegateEmail
   */
  public String getWhoDelegateEmail() {
    return whoDelegateEmail;
  }

  /**
   * Gets the message.
   *
   * A message which describes the change.
   *
   * @return the message
   */
  public String getMessage() {
    return message;
  }
}

