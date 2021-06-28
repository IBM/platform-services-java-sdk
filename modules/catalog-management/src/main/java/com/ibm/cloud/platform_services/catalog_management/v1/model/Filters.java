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

import java.util.Map;

/**
 * Filters for account and catalog filters.
 */
public class Filters extends GenericModel {

  @SerializedName("include_all")
  protected Boolean includeAll;
  @SerializedName("category_filters")
  protected Map<String, CategoryFilter> categoryFilters;
  @SerializedName("id_filters")
  protected IDFilter idFilters;

  /**
   * Builder.
   */
  public static class Builder {
    private Boolean includeAll;
    private Map<String, CategoryFilter> categoryFilters;
    private IDFilter idFilters;

    private Builder(Filters filters) {
      this.includeAll = filters.includeAll;
      this.categoryFilters = filters.categoryFilters;
      this.idFilters = filters.idFilters;
    }

    /**
     * Instantiates a new builder.
     */
    public Builder() {
    }

    /**
     * Builds a Filters.
     *
     * @return the new Filters instance
     */
    public Filters build() {
      return new Filters(this);
    }

    /**
     * Set the includeAll.
     *
     * @param includeAll the includeAll
     * @return the Filters builder
     */
    public Builder includeAll(Boolean includeAll) {
      this.includeAll = includeAll;
      return this;
    }

    /**
     * Set the categoryFilters.
     *
     * @param categoryFilters the categoryFilters
     * @return the Filters builder
     */
    public Builder categoryFilters(Map<String, CategoryFilter> categoryFilters) {
      this.categoryFilters = categoryFilters;
      return this;
    }

    /**
     * Set the idFilters.
     *
     * @param idFilters the idFilters
     * @return the Filters builder
     */
    public Builder idFilters(IDFilter idFilters) {
      this.idFilters = idFilters;
      return this;
    }
  }

  protected Filters(Builder builder) {
    includeAll = builder.includeAll;
    categoryFilters = builder.categoryFilters;
    idFilters = builder.idFilters;
  }

  /**
   * New builder.
   *
   * @return a Filters builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the includeAll.
   *
   * -&gt; true - Include all of the public catalog when filtering. Further settings will specifically exclude some
   * offerings. false - Exclude all of the public catalog when filtering. Further settings will specifically include
   * some offerings.
   *
   * @return the includeAll
   */
  public Boolean includeAll() {
    return includeAll;
  }

  /**
   * Gets the categoryFilters.
   *
   * Filter against offering properties.
   *
   * @return the categoryFilters
   */
  public Map<String, CategoryFilter> categoryFilters() {
    return categoryFilters;
  }

  /**
   * Gets the idFilters.
   *
   * Filter on offering ID's. There is an include filter and an exclule filter. Both can be set.
   *
   * @return the idFilters
   */
  public IDFilter idFilters() {
    return idFilters;
  }
}

