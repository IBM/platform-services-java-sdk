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

import java.util.List;

/**
 * The accumulated filters for an account. This will return the account filters plus a filter for each catalog the user
 * has access to.
 */
public class AccumulatedFilters extends GenericModel {

  @SerializedName("account_filters")
  protected List<Filters> accountFilters;
  @SerializedName("catalog_filters")
  protected List<AccumulatedFiltersCatalogFiltersItem> catalogFilters;

  /**
   * Gets the accountFilters.
   *
   * Filters for accounts (at this time this will always be just one item array).
   *
   * @return the accountFilters
   */
  public List<Filters> getAccountFilters() {
    return accountFilters;
  }

  /**
   * Gets the catalogFilters.
   *
   * The filters for all of the accessible catalogs.
   *
   * @return the catalogFilters
   */
  public List<AccumulatedFiltersCatalogFiltersItem> getCatalogFilters() {
    return catalogFilters;
  }
}

