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
 * The listResourceBindings options.
 */
public class ListResourceBindingsOptions extends GenericModel {

  protected String guid;
  protected String name;
  protected String resourceGroupId;
  protected String resourceId;
  protected String regionBindingId;
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
    private String regionBindingId;
    private Long limit;
    private String start;
    private String updatedFrom;
    private String updatedTo;

    private Builder(ListResourceBindingsOptions listResourceBindingsOptions) {
      this.guid = listResourceBindingsOptions.guid;
      this.name = listResourceBindingsOptions.name;
      this.resourceGroupId = listResourceBindingsOptions.resourceGroupId;
      this.resourceId = listResourceBindingsOptions.resourceId;
      this.regionBindingId = listResourceBindingsOptions.regionBindingId;
      this.limit = listResourceBindingsOptions.limit;
      this.start = listResourceBindingsOptions.start;
      this.updatedFrom = listResourceBindingsOptions.updatedFrom;
      this.updatedTo = listResourceBindingsOptions.updatedTo;
    }

    /**
     * Instantiates a new builder.
     */
    public Builder() {
    }

    /**
     * Builds a ListResourceBindingsOptions.
     *
     * @return the new ListResourceBindingsOptions instance
     */
    public ListResourceBindingsOptions build() {
      return new ListResourceBindingsOptions(this);
    }

    /**
     * Set the guid.
     *
     * @param guid the guid
     * @return the ListResourceBindingsOptions builder
     */
    public Builder guid(String guid) {
      this.guid = guid;
      return this;
    }

    /**
     * Set the name.
     *
     * @param name the name
     * @return the ListResourceBindingsOptions builder
     */
    public Builder name(String name) {
      this.name = name;
      return this;
    }

    /**
     * Set the resourceGroupId.
     *
     * @param resourceGroupId the resourceGroupId
     * @return the ListResourceBindingsOptions builder
     */
    public Builder resourceGroupId(String resourceGroupId) {
      this.resourceGroupId = resourceGroupId;
      return this;
    }

    /**
     * Set the resourceId.
     *
     * @param resourceId the resourceId
     * @return the ListResourceBindingsOptions builder
     */
    public Builder resourceId(String resourceId) {
      this.resourceId = resourceId;
      return this;
    }

    /**
     * Set the regionBindingId.
     *
     * @param regionBindingId the regionBindingId
     * @return the ListResourceBindingsOptions builder
     */
    public Builder regionBindingId(String regionBindingId) {
      this.regionBindingId = regionBindingId;
      return this;
    }

    /**
     * Set the limit.
     *
     * @param limit the limit
     * @return the ListResourceBindingsOptions builder
     */
    public Builder limit(long limit) {
      this.limit = limit;
      return this;
    }

    /**
     * Set the start.
     *
     * @param start the start
     * @return the ListResourceBindingsOptions builder
     */
    public Builder start(String start) {
      this.start = start;
      return this;
    }

    /**
     * Set the updatedFrom.
     *
     * @param updatedFrom the updatedFrom
     * @return the ListResourceBindingsOptions builder
     */
    public Builder updatedFrom(String updatedFrom) {
      this.updatedFrom = updatedFrom;
      return this;
    }

    /**
     * Set the updatedTo.
     *
     * @param updatedTo the updatedTo
     * @return the ListResourceBindingsOptions builder
     */
    public Builder updatedTo(String updatedTo) {
      this.updatedTo = updatedTo;
      return this;
    }
  }

  protected ListResourceBindingsOptions(Builder builder) {
    guid = builder.guid;
    name = builder.name;
    resourceGroupId = builder.resourceGroupId;
    resourceId = builder.resourceId;
    regionBindingId = builder.regionBindingId;
    limit = builder.limit;
    start = builder.start;
    updatedFrom = builder.updatedFrom;
    updatedTo = builder.updatedTo;
  }

  /**
   * New builder.
   *
   * @return a ListResourceBindingsOptions builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the guid.
   *
   * The short ID of the binding.
   *
   * @return the guid
   */
  public String guid() {
    return guid;
  }

  /**
   * Gets the name.
   *
   * The human-readable name of the binding.
   *
   * @return the name
   */
  public String name() {
    return name;
  }

  /**
   * Gets the resourceGroupId.
   *
   * Short ID of the resource group.
   *
   * @return the resourceGroupId
   */
  public String resourceGroupId() {
    return resourceGroupId;
  }

  /**
   * Gets the resourceId.
   *
   * The unique ID of the offering (service name). This value is provided by and stored in the global catalog.
   *
   * @return the resourceId
   */
  public String resourceId() {
    return resourceId;
  }

  /**
   * Gets the regionBindingId.
   *
   * Short ID of the binding in the specific targeted environment, for example, service_binding_id in a given IBM Cloud
   * environment.
   *
   * @return the regionBindingId
   */
  public String regionBindingId() {
    return regionBindingId;
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

