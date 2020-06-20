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
package com.ibm.cloud.platform_services.catalog_management.v1.model;

import com.google.gson.annotations.SerializedName;
import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * Catalog reference.
 */
public class SchematicsWorkspaceCatalogRef extends GenericModel {

  @SerializedName("item_id")
  protected String itemId;
  @SerializedName("item_name")
  protected String itemName;
  @SerializedName("item_url")
  protected String itemUrl;

  /**
   * Gets the itemId.
   *
   * Version locator ID.
   *
   * @return the itemId
   */
  public String getItemId() {
    return itemId;
  }

  /**
   * Gets the itemName.
   *
   * The name of the offering that generated this Blueprint.
   *
   * @return the itemName
   */
  public String getItemName() {
    return itemName;
  }

  /**
   * Gets the itemUrl.
   *
   * Relative Dashboard URL for content that generated this Blueprint.
   *
   * @return the itemUrl
   */
  public String getItemUrl() {
    return itemUrl;
  }
}

