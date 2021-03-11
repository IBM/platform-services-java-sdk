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
 * The listResourceAliases options.
 */
public class ListResourceAliasesOptions extends GenericModel {

  protected String guid;
  protected String name;
  protected String resourceInstanceId;
  protected String regionInstanceId;
  protected String resourceId;
  protected String resourceGroupId;
  protected String limit;
  protected String updatedFrom;
  protected String updatedTo;

  /**
   * Builder.
   */
  public static class Builder {
    private String guid;
    private String name;
    private String resourceInstanceId;
    private String regionInstanceId;
    private String resourceId;
    private String resourceGroupId;
    private String limit;
    private String updatedFrom;
    private String updatedTo;

    private Builder(ListResourceAliasesOptions listResourceAliasesOptions) {
      this.guid = listResourceAliasesOptions.guid;
      this.name = listResourceAliasesOptions.name;
      this.resourceInstanceId = listResourceAliasesOptions.resourceInstanceId;
      this.regionInstanceId = listResourceAliasesOptions.regionInstanceId;
      this.resourceId = listResourceAliasesOptions.resourceId;
      this.resourceGroupId = listResourceAliasesOptions.resourceGroupId;
      this.limit = listResourceAliasesOptions.limit;
      this.updatedFrom = listResourceAliasesOptions.updatedFrom;
      this.updatedTo = listResourceAliasesOptions.updatedTo;
    }

    /**
     * Instantiates a new builder.
     */
    public Builder() {
    }

    /**
     * Builds a ListResourceAliasesOptions.
     *
     * @return the new ListResourceAliasesOptions instance
     */
    public ListResourceAliasesOptions build() {
      return new ListResourceAliasesOptions(this);
    }

    /**
     * Set the guid.
     *
     * @param guid the guid
     * @return the ListResourceAliasesOptions builder
     */
    public Builder guid(String guid) {
      this.guid = guid;
      return this;
    }

    /**
     * Set the name.
     *
     * @param name the name
     * @return the ListResourceAliasesOptions builder
     */
    public Builder name(String name) {
      this.name = name;
      return this;
    }

    /**
     * Set the resourceInstanceId.
     *
     * @param resourceInstanceId the resourceInstanceId
     * @return the ListResourceAliasesOptions builder
     */
    public Builder resourceInstanceId(String resourceInstanceId) {
      this.resourceInstanceId = resourceInstanceId;
      return this;
    }

    /**
     * Set the regionInstanceId.
     *
     * @param regionInstanceId the regionInstanceId
     * @return the ListResourceAliasesOptions builder
     */
    public Builder regionInstanceId(String regionInstanceId) {
      this.regionInstanceId = regionInstanceId;
      return this;
    }

    /**
     * Set the resourceId.
     *
     * @param resourceId the resourceId
     * @return the ListResourceAliasesOptions builder
     */
    public Builder resourceId(String resourceId) {
      this.resourceId = resourceId;
      return this;
    }

    /**
     * Set the resourceGroupId.
     *
     * @param resourceGroupId the resourceGroupId
     * @return the ListResourceAliasesOptions builder
     */
    public Builder resourceGroupId(String resourceGroupId) {
      this.resourceGroupId = resourceGroupId;
      return this;
    }

    /**
     * Set the limit.
     *
     * @param limit the limit
     * @return the ListResourceAliasesOptions builder
     */
    public Builder limit(String limit) {
      this.limit = limit;
      return this;
    }

    /**
     * Set the updatedFrom.
     *
     * @param updatedFrom the updatedFrom
     * @return the ListResourceAliasesOptions builder
     */
    public Builder updatedFrom(String updatedFrom) {
      this.updatedFrom = updatedFrom;
      return this;
    }

    /**
     * Set the updatedTo.
     *
     * @param updatedTo the updatedTo
     * @return the ListResourceAliasesOptions builder
     */
    public Builder updatedTo(String updatedTo) {
      this.updatedTo = updatedTo;
      return this;
    }
  }

  protected ListResourceAliasesOptions(Builder builder) {
    guid = builder.guid;
    name = builder.name;
    resourceInstanceId = builder.resourceInstanceId;
    regionInstanceId = builder.regionInstanceId;
    resourceId = builder.resourceId;
    resourceGroupId = builder.resourceGroupId;
    limit = builder.limit;
    updatedFrom = builder.updatedFrom;
    updatedTo = builder.updatedTo;
  }

  /**
   * New builder.
   *
   * @return a ListResourceAliasesOptions builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the guid.
   *
   * Short ID of the alias.
   *
   * @return the guid
   */
  public String guid() {
    return guid;
  }

  /**
   * Gets the name.
   *
   * The human-readable name of the alias.
   *
   * @return the name
   */
  public String name() {
    return name;
  }

  /**
   * Gets the resourceInstanceId.
   *
   * Resource instance short ID.
   *
   * @return the resourceInstanceId
   */
  public String resourceInstanceId() {
    return resourceInstanceId;
  }

  /**
   * Gets the regionInstanceId.
   *
   * Short ID of the instance in a specific targeted environment. For example, `service_instance_id` in a given IBM
   * Cloud environment.
   *
   * @return the regionInstanceId
   */
  public String regionInstanceId() {
    return regionInstanceId;
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
   * Gets the resourceGroupId.
   *
   * Short ID of Resource group.
   *
   * @return the resourceGroupId
   */
  public String resourceGroupId() {
    return resourceGroupId;
  }

  /**
   * Gets the limit.
   *
   * Limit on how many items should be returned.
   *
   * @return the limit
   */
  public String limit() {
    return limit;
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

