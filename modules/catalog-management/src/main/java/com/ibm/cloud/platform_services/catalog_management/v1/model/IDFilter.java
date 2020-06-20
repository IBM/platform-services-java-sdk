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
 * Filter on offering ID's. There is an include filter and an exclule filter. Both can be set.
 */
public class IDFilter extends GenericModel {

  protected FilterTerms include;
  protected FilterTerms exclude;

  /**
   * Builder.
   */
  public static class Builder {
    private FilterTerms include;
    private FilterTerms exclude;

    private Builder(IDFilter idFilter) {
      this.include = idFilter.include;
      this.exclude = idFilter.exclude;
    }

    /**
     * Instantiates a new builder.
     */
    public Builder() {
    }

    /**
     * Builds a IDFilter.
     *
     * @return the new IDFilter instance
     */
    public IDFilter build() {
      return new IDFilter(this);
    }

    /**
     * Set the include.
     *
     * @param include the include
     * @return the IDFilter builder
     */
    public Builder include(FilterTerms include) {
      this.include = include;
      return this;
    }

    /**
     * Set the exclude.
     *
     * @param exclude the exclude
     * @return the IDFilter builder
     */
    public Builder exclude(FilterTerms exclude) {
      this.exclude = exclude;
      return this;
    }
  }

  protected IDFilter(Builder builder) {
    include = builder.include;
    exclude = builder.exclude;
  }

  /**
   * New builder.
   *
   * @return a IDFilter builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the include.
   *
   * Offering filter terms.
   *
   * @return the include
   */
  public FilterTerms include() {
    return include;
  }

  /**
   * Gets the exclude.
   *
   * Offering filter terms.
   *
   * @return the exclude
   */
  public FilterTerms exclude() {
    return exclude;
  }
}

