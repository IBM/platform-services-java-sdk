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

import java.util.ArrayList;
import java.util.List;

import com.google.gson.annotations.SerializedName;
import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * Offering filter terms.
 */
public class FilterTerms extends GenericModel {

  @SerializedName("filter_terms")
  protected List<String> filterTerms;

  /**
   * Builder.
   */
  public static class Builder {
    private List<String> filterTerms;

    private Builder(FilterTerms filterTerms) {
      this.filterTerms = filterTerms.filterTerms;
    }

    /**
     * Instantiates a new builder.
     */
    public Builder() {
    }

    /**
     * Builds a FilterTerms.
     *
     * @return the new FilterTerms instance
     */
    public FilterTerms build() {
      return new FilterTerms(this);
    }

    /**
     * Adds an filterTerms to filterTerms.
     *
     * @param filterTerms the new filterTerms
     * @return the FilterTerms builder
     */
    public Builder addFilterTerms(String filterTerms) {
      com.ibm.cloud.sdk.core.util.Validator.notNull(filterTerms,
        "filterTerms cannot be null");
      if (this.filterTerms == null) {
        this.filterTerms = new ArrayList<String>();
      }
      this.filterTerms.add(filterTerms);
      return this;
    }

    /**
     * Set the filterTerms.
     * Existing filterTerms will be replaced.
     *
     * @param filterTerms the filterTerms
     * @return the FilterTerms builder
     */
    public Builder filterTerms(List<String> filterTerms) {
      this.filterTerms = filterTerms;
      return this;
    }
  }

  protected FilterTerms(Builder builder) {
    filterTerms = builder.filterTerms;
  }

  /**
   * New builder.
   *
   * @return a FilterTerms builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the filterTerms.
   *
   * List of values to match against. If include is true, then if the offering has one of the values then the offering
   * is included. If include is false, then if the offering has one of the values then the offering is excluded.
   *
   * @return the filterTerms
   */
  public List<String> filterTerms() {
    return filterTerms;
  }
}

