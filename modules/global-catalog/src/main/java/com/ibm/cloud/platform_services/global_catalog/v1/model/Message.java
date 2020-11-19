/*
 * (C) Copyright IBM Corp. 2020.
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
package com.ibm.cloud.platform_services.global_catalog.v1.model;

import java.util.Date;
import java.util.Map;

import com.google.gson.annotations.SerializedName;
import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * log object describing who did what.
 */
public class Message extends GenericModel {

  protected String id;
  protected Visibility effective;
  protected Date time;
  @SerializedName("who_id")
  protected String whoId;
  @SerializedName("who_name")
  protected String whoName;
  @SerializedName("who_email")
  protected String whoEmail;
  protected String instance;
  protected String gid;
  protected String type;
  protected String message;
  protected Map<String, Object> data;

  /**
   * Gets the id.
   *
   * id of catalog entry.
   *
   * @return the id
   */
  public String getId() {
    return id;
  }

  /**
   * Gets the effective.
   *
   * Information related to the visibility of a catalog entry.
   *
   * @return the effective
   */
  public Visibility getEffective() {
    return effective;
  }

  /**
   * Gets the time.
   *
   * time of action.
   *
   * @return the time
   */
  public Date getTime() {
    return time;
  }

  /**
   * Gets the whoId.
   *
   * user ID of person who did action.
   *
   * @return the whoId
   */
  public String getWhoId() {
    return whoId;
  }

  /**
   * Gets the whoName.
   *
   * name of person who did action.
   *
   * @return the whoName
   */
  public String getWhoName() {
    return whoName;
  }

  /**
   * Gets the whoEmail.
   *
   * user email of person who did action.
   *
   * @return the whoEmail
   */
  public String getWhoEmail() {
    return whoEmail;
  }

  /**
   * Gets the instance.
   *
   * Global catalog instance where this occured.
   *
   * @return the instance
   */
  public String getInstance() {
    return instance;
  }

  /**
   * Gets the gid.
   *
   * transaction id associatd with action.
   *
   * @return the gid
   */
  public String getGid() {
    return gid;
  }

  /**
   * Gets the type.
   *
   * type of action taken.
   *
   * @return the type
   */
  public String getType() {
    return type;
  }

  /**
   * Gets the message.
   *
   * message describing action.
   *
   * @return the message
   */
  public String getMessage() {
    return message;
  }

  /**
   * Gets the data.
   *
   * An object containing details on changes made to object data.
   *
   * @return the data
   */
  public Map<String, Object> getData() {
    return data;
  }
}

