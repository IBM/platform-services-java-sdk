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
 * Filter on a category. The filter will match against the values of the given category with include or exclude.
 */
public class CategoryFilter extends GenericModel {

  protected Boolean include;
  protected FilterTerms filter;

  /**
   * Builder.
   */
  public static class Builder {
    private Boolean include;
    private FilterTerms filter;

    private Builder(CategoryFilter categoryFilter) {
      this.include = categoryFilter.include;
      this.filter = categoryFilter.filter;
    }

    /**
     * Instantiates a new builder.
     */
    public Builder() {
    }

    /**
     * Builds a CategoryFilter.
     *
     * @return the new CategoryFilter instance
     */
    public CategoryFilter build() {
      return new CategoryFilter(this);
    }

    /**
     * Set the include.
     *
     * @param include the include
     * @return the CategoryFilter builder
     */
    public Builder include(Boolean include) {
      this.include = include;
      return this;
    }

    /**
     * Set the filter.
     *
     * @param filter the filter
     * @return the CategoryFilter builder
     */
    public Builder filter(FilterTerms filter) {
      this.filter = filter;
      return this;
    }
  }

  protected CategoryFilter(Builder builder) {
    include = builder.include;
    filter = builder.filter;
  }

  /**
   * New builder.
   *
   * @return a CategoryFilter builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the include.
   *
   * -&gt; true - This is an include filter, false - this is an exclude filter.
   *
   * @return the include
   */
  public Boolean include() {
    return include;
  }

  /**
   * Gets the filter.
   *
   * Offering filter terms.
   *
   * @return the filter
   */
  public FilterTerms filter() {
    return filter;
  }
}

