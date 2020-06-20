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
 * License offering reference.
 */
public class LicenseOfferingReference extends GenericModel {

  protected String id;
  protected String name;
  protected String label;
  @SerializedName("offering_icon_url")
  protected String offeringIconUrl;
  @SerializedName("account_id")
  protected String accountId;
  @SerializedName("catalog_id")
  protected String catalogId;

  /**
   * Gets the id.
   *
   * Offering ID.
   *
   * @return the id
   */
  public String getId() {
    return id;
  }

  /**
   * Gets the name.
   *
   * Offering name.
   *
   * @return the name
   */
  public String getName() {
    return name;
  }

  /**
   * Gets the label.
   *
   * Offering label'.
   *
   * @return the label
   */
  public String getLabel() {
    return label;
  }

  /**
   * Gets the offeringIconUrl.
   *
   * URL to offering icon.
   *
   * @return the offeringIconUrl
   */
  public String getOfferingIconUrl() {
    return offeringIconUrl;
  }

  /**
   * Gets the accountId.
   *
   * Account ID associated with offering.
   *
   * @return the accountId
   */
  public String getAccountId() {
    return accountId;
  }

  /**
   * Gets the catalogId.
   *
   * Catalog ID associated with offering.
   *
   * @return the catalogId
   */
  public String getCatalogId() {
    return catalogId;
  }
}

