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
 * object access.
 */
public class ObjectAccess extends GenericModel {

  protected String id;
  protected String account;
  @SerializedName("catalog_id")
  protected String catalogId;
  @SerializedName("target_id")
  protected String targetId;
  protected Date create;

  /**
   * Gets the id.
   *
   * unique id.
   *
   * @return the id
   */
  public String getId() {
    return id;
  }

  /**
   * Gets the account.
   *
   * account id.
   *
   * @return the account
   */
  public String getAccount() {
    return account;
  }

  /**
   * Gets the catalogId.
   *
   * unique id.
   *
   * @return the catalogId
   */
  public String getCatalogId() {
    return catalogId;
  }

  /**
   * Gets the targetId.
   *
   * object id.
   *
   * @return the targetId
   */
  public String getTargetId() {
    return targetId;
  }

  /**
   * Gets the create.
   *
   * date and time create.
   *
   * @return the create
   */
  public Date getCreate() {
    return create;
  }
}

