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

import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * AccumulatedFiltersCatalogFiltersItem.
 */
public class AccumulatedFiltersCatalogFiltersItem extends GenericModel {

  protected AccumulatedFiltersCatalogFiltersItemCatalog catalog;
  protected Filters filters;

  /**
   * Gets the catalog.
   *
   * Filters for catalog.
   *
   * @return the catalog
   */
  public AccumulatedFiltersCatalogFiltersItemCatalog getCatalog() {
    return catalog;
  }

  /**
   * Gets the filters.
   *
   * Filters for account and catalog filters.
   *
   * @return the filters
   */
  public Filters getFilters() {
    return filters;
  }
}

