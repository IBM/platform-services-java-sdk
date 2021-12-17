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

import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * The getCatalogAccountFilters options.
 */
public class GetCatalogAccountFiltersOptions extends GenericModel {

  protected String catalog;

  /**
   * Builder.
   */
  public static class Builder {
    private String catalog;

    private Builder(GetCatalogAccountFiltersOptions getCatalogAccountFiltersOptions) {
      this.catalog = getCatalogAccountFiltersOptions.catalog;
    }

    /**
     * Instantiates a new builder.
     */
    public Builder() {
    }

    /**
     * Builds a GetCatalogAccountFiltersOptions.
     *
     * @return the new GetCatalogAccountFiltersOptions instance
     */
    public GetCatalogAccountFiltersOptions build() {
      return new GetCatalogAccountFiltersOptions(this);
    }

    /**
     * Set the catalog.
     *
     * @param catalog the catalog
     * @return the GetCatalogAccountFiltersOptions builder
     */
    public Builder catalog(String catalog) {
      this.catalog = catalog;
      return this;
    }
  }

  protected GetCatalogAccountFiltersOptions(Builder builder) {
    catalog = builder.catalog;
  }

  /**
   * New builder.
   *
   * @return a GetCatalogAccountFiltersOptions builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the catalog.
   *
   * catalog id. Narrow down filters to the account and just the one catalog.
   *
   * @return the catalog
   */
  public String catalog() {
    return catalog;
  }
}

