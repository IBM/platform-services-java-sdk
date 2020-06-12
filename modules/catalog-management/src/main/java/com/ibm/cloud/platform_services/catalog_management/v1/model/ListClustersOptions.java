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
 * The listClusters options.
 */
public class ListClustersOptions extends GenericModel {

  protected Long limit;
  protected Long offset;
  protected String type;

  /**
   * Builder.
   */
  public static class Builder {
    private Long limit;
    private Long offset;
    private String type;

    private Builder(ListClustersOptions listClustersOptions) {
      this.limit = listClustersOptions.limit;
      this.offset = listClustersOptions.offset;
      this.type = listClustersOptions.type;
    }

    /**
     * Instantiates a new builder.
     */
    public Builder() {
    }

    /**
     * Builds a ListClustersOptions.
     *
     * @return the new ListClustersOptions instance
     */
    public ListClustersOptions build() {
      return new ListClustersOptions(this);
    }

    /**
     * Set the limit.
     *
     * @param limit the limit
     * @return the ListClustersOptions builder
     */
    public Builder limit(long limit) {
      this.limit = limit;
      return this;
    }

    /**
     * Set the offset.
     *
     * @param offset the offset
     * @return the ListClustersOptions builder
     */
    public Builder offset(long offset) {
      this.offset = offset;
      return this;
    }

    /**
     * Set the type.
     *
     * @param type the type
     * @return the ListClustersOptions builder
     */
    public Builder type(String type) {
      this.type = type;
      return this;
    }
  }

  protected ListClustersOptions(Builder builder) {
    limit = builder.limit;
    offset = builder.offset;
    type = builder.type;
  }

  /**
   * New builder.
   *
   * @return a ListClustersOptions builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the limit.
   *
   * number or results to return.
   *
   * @return the limit
   */
  public Long limit() {
    return limit;
  }

  /**
   * Gets the offset.
   *
   * number of results to skip before returning values.
   *
   * @return the offset
   */
  public Long offset() {
    return offset;
  }

  /**
   * Gets the type.
   *
   * Kubernetes or OpenShift.  Default is kubernetes.
   *
   * @return the type
   */
  public String type() {
    return type;
  }
}

