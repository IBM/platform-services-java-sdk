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
package com.ibm.cloud.platform_services.resource_controller.v2.model;

import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * The listResourceKeys options.
 */
public class ListResourceKeysOptions extends GenericModel {

  protected String guid;
  protected String name;
  protected String resourceGroupId;
  protected String resourceId;
  protected Long limit;
  protected String start;
  protected String updatedFrom;
  protected String updatedTo;

  /**
   * Builder.
   */
  public static class Builder {
    private String guid;
    private String name;
    private String resourceGroupId;
    private String resourceId;
    private Long limit;
    private String start;
    private String updatedFrom;
    private String updatedTo;

    private Builder(ListResourceKeysOptions listResourceKeysOptions) {
      this.guid = listResourceKeysOptions.guid;
      this.name = listResourceKeysOptions.name;
      this.resourceGroupId = listResourceKeysOptions.resourceGroupId;
      this.resourceId = listResourceKeysOptions.resourceId;
      this.limit = listResourceKeysOptions.limit;
      this.start = listResourceKeysOptions.start;
      this.updatedFrom = listResourceKeysOptions.updatedFrom;
      this.updatedTo = listResourceKeysOptions.updatedTo;
    }

    /**
     * Instantiates a new builder.
     */
    public Builder() {
    }

    /**
     * Builds a ListResourceKeysOptions.
     *
     * @return the new ListResourceKeysOptions instance
     */
    public ListResourceKeysOptions build() {
      return new ListResourceKeysOptions(this);
    }

    /**
     * Set the guid.
     *
     * @param guid the guid
     * @return the ListResourceKeysOptions builder
     */
    public Builder guid(String guid) {
      this.guid = guid;
      return this;
    }

    /**
     * Set the name.
     *
     * @param name the name
     * @return the ListResourceKeysOptions builder
     */
    public Builder name(String name) {
      this.name = name;
      return this;
    }

    /**
     * Set the resourceGroupId.
     *
     * @param resourceGroupId the resourceGroupId
     * @return the ListResourceKeysOptions builder
     */
    public Builder resourceGroupId(String resourceGroupId) {
      this.resourceGroupId = resourceGroupId;
      return this;
    }

    /**
     * Set the resourceId.
     *
     * @param resourceId the resourceId
     * @return the ListResourceKeysOptions builder
     */
    public Builder resourceId(String resourceId) {
      this.resourceId = resourceId;
      return this;
    }

    /**
     * Set the limit.
     *
     * @param limit the limit
     * @return the ListResourceKeysOptions builder
     */
    public Builder limit(long limit) {
      this.limit = limit;
      return this;
    }

    /**
     * Set the start.
     *
     * @param start the start
     * @return the ListResourceKeysOptions builder
     */
    public Builder start(String start) {
      this.start = start;
      return this;
    }

    /**
     * Set the updatedFrom.
     *
     * @param updatedFrom the updatedFrom
     * @return the ListResourceKeysOptions builder
     */
    public Builder updatedFrom(String updatedFrom) {
      this.updatedFrom = updatedFrom;
      return this;
    }

    /**
     * Set the updatedTo.
     *
     * @param updatedTo the updatedTo
     * @return the ListResourceKeysOptions builder
     */
    public Builder updatedTo(String updatedTo) {
      this.updatedTo = updatedTo;
      return this;
    }
  }

  protected ListResourceKeysOptions(Builder builder) {
    guid = builder.guid;
    name = builder.name;
    resourceGroupId = builder.resourceGroupId;
    resourceId = builder.resourceId;
    limit = builder.limit;
    start = builder.start;
    updatedFrom = builder.updatedFrom;
    updatedTo = builder.updatedTo;
  }

  /**
   * New builder.
   *
   * @return a ListResourceKeysOptions builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the guid.
   *
   * When you create a new key, a GUID (globally unique identifier) is assigned. This is a unique internal GUID managed
   * by Resource controller that corresponds to the key.
   *
   * @return the guid
   */
  public String guid() {
    return guid;
  }

  /**
   * Gets the name.
   *
   * The human-readable name of the key.
   *
   * @return the name
   */
  public String name() {
    return name;
  }

  /**
   * Gets the resourceGroupId.
   *
   * The short ID of the resource group.
   *
   * @return the resourceGroupId
   */
  public String resourceGroupId() {
    return resourceGroupId;
  }

  /**
   * Gets the resourceId.
   *
   * The unique ID of the offering. This value is provided by and stored in the global catalog.
   *
   * @return the resourceId
   */
  public String resourceId() {
    return resourceId;
  }

  /**
   * Gets the limit.
   *
   * Limit on how many items should be returned.
   *
   * @return the limit
   */
  public Long limit() {
    return limit;
  }

  /**
   * Gets the start.
   *
   * An optional token that indicates the beginning of the page of results to be returned. Any additional query
   * parameters are ignored if a page token is present. If omitted, the first page of results is returned. This value is
   * obtained from the 'next_url' field of the operation response.
   *
   * @return the start
   */
  public String start() {
    return start;
  }

  /**
   * Gets the updatedFrom.
   *
   * Start date inclusive filter.
   *
   * @return the updatedFrom
   */
  public String updatedFrom() {
    return updatedFrom;
  }

  /**
   * Gets the updatedTo.
   *
   * End date inclusive filter.
   *
   * @return the updatedTo
   */
  public String updatedTo() {
    return updatedTo;
  }
}

