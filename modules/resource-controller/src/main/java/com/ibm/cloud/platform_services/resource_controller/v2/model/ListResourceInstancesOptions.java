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
 * The listResourceInstances options.
 */
public class ListResourceInstancesOptions extends GenericModel {

  /**
   * The state of the instance. If not specified, instances in state `active` and `provisioning` are returned.
   */
  public interface State {
    /** active. */
    String ACTIVE = "active";
    /** provisioning. */
    String PROVISIONING = "provisioning";
    /** removed. */
    String REMOVED = "removed";
  }

  protected String guid;
  protected String name;
  protected String resourceGroupId;
  protected String resourceId;
  protected String resourcePlanId;
  protected String type;
  protected String subType;
  protected Long limit;
  protected String start;
  protected String state;
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
    private String resourcePlanId;
    private String type;
    private String subType;
    private Long limit;
    private String start;
    private String state;
    private String updatedFrom;
    private String updatedTo;

    private Builder(ListResourceInstancesOptions listResourceInstancesOptions) {
      this.guid = listResourceInstancesOptions.guid;
      this.name = listResourceInstancesOptions.name;
      this.resourceGroupId = listResourceInstancesOptions.resourceGroupId;
      this.resourceId = listResourceInstancesOptions.resourceId;
      this.resourcePlanId = listResourceInstancesOptions.resourcePlanId;
      this.type = listResourceInstancesOptions.type;
      this.subType = listResourceInstancesOptions.subType;
      this.limit = listResourceInstancesOptions.limit;
      this.start = listResourceInstancesOptions.start;
      this.state = listResourceInstancesOptions.state;
      this.updatedFrom = listResourceInstancesOptions.updatedFrom;
      this.updatedTo = listResourceInstancesOptions.updatedTo;
    }

    /**
     * Instantiates a new builder.
     */
    public Builder() {
    }

    /**
     * Builds a ListResourceInstancesOptions.
     *
     * @return the new ListResourceInstancesOptions instance
     */
    public ListResourceInstancesOptions build() {
      return new ListResourceInstancesOptions(this);
    }

    /**
     * Set the guid.
     *
     * @param guid the guid
     * @return the ListResourceInstancesOptions builder
     */
    public Builder guid(String guid) {
      this.guid = guid;
      return this;
    }

    /**
     * Set the name.
     *
     * @param name the name
     * @return the ListResourceInstancesOptions builder
     */
    public Builder name(String name) {
      this.name = name;
      return this;
    }

    /**
     * Set the resourceGroupId.
     *
     * @param resourceGroupId the resourceGroupId
     * @return the ListResourceInstancesOptions builder
     */
    public Builder resourceGroupId(String resourceGroupId) {
      this.resourceGroupId = resourceGroupId;
      return this;
    }

    /**
     * Set the resourceId.
     *
     * @param resourceId the resourceId
     * @return the ListResourceInstancesOptions builder
     */
    public Builder resourceId(String resourceId) {
      this.resourceId = resourceId;
      return this;
    }

    /**
     * Set the resourcePlanId.
     *
     * @param resourcePlanId the resourcePlanId
     * @return the ListResourceInstancesOptions builder
     */
    public Builder resourcePlanId(String resourcePlanId) {
      this.resourcePlanId = resourcePlanId;
      return this;
    }

    /**
     * Set the type.
     *
     * @param type the type
     * @return the ListResourceInstancesOptions builder
     */
    public Builder type(String type) {
      this.type = type;
      return this;
    }

    /**
     * Set the subType.
     *
     * @param subType the subType
     * @return the ListResourceInstancesOptions builder
     */
    public Builder subType(String subType) {
      this.subType = subType;
      return this;
    }

    /**
     * Set the limit.
     *
     * @param limit the limit
     * @return the ListResourceInstancesOptions builder
     */
    public Builder limit(long limit) {
      this.limit = limit;
      return this;
    }

    /**
     * Set the start.
     *
     * @param start the start
     * @return the ListResourceInstancesOptions builder
     */
    public Builder start(String start) {
      this.start = start;
      return this;
    }

    /**
     * Set the state.
     *
     * @param state the state
     * @return the ListResourceInstancesOptions builder
     */
    public Builder state(String state) {
      this.state = state;
      return this;
    }

    /**
     * Set the updatedFrom.
     *
     * @param updatedFrom the updatedFrom
     * @return the ListResourceInstancesOptions builder
     */
    public Builder updatedFrom(String updatedFrom) {
      this.updatedFrom = updatedFrom;
      return this;
    }

    /**
     * Set the updatedTo.
     *
     * @param updatedTo the updatedTo
     * @return the ListResourceInstancesOptions builder
     */
    public Builder updatedTo(String updatedTo) {
      this.updatedTo = updatedTo;
      return this;
    }
  }

  protected ListResourceInstancesOptions(Builder builder) {
    guid = builder.guid;
    name = builder.name;
    resourceGroupId = builder.resourceGroupId;
    resourceId = builder.resourceId;
    resourcePlanId = builder.resourcePlanId;
    type = builder.type;
    subType = builder.subType;
    limit = builder.limit;
    start = builder.start;
    state = builder.state;
    updatedFrom = builder.updatedFrom;
    updatedTo = builder.updatedTo;
  }

  /**
   * New builder.
   *
   * @return a ListResourceInstancesOptions builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the guid.
   *
   * When you provision a new resource in the specified location for the selected plan, a GUID (globally unique
   * identifier) is created. This is a unique internal GUID managed by Resource controller that corresponds to the
   * instance.
   *
   * @return the guid
   */
  public String guid() {
    return guid;
  }

  /**
   * Gets the name.
   *
   * The human-readable name of the instance.
   *
   * @return the name
   */
  public String name() {
    return name;
  }

  /**
   * Gets the resourceGroupId.
   *
   * Short ID of a resource group.
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
   * Gets the resourcePlanId.
   *
   * The unique ID of the plan associated with the offering. This value is provided by and stored in the global catalog.
   *
   * @return the resourcePlanId
   */
  public String resourcePlanId() {
    return resourcePlanId;
  }

  /**
   * Gets the type.
   *
   * The type of the instance, for example, `service_instance`.
   *
   * @return the type
   */
  public String type() {
    return type;
  }

  /**
   * Gets the subType.
   *
   * The sub-type of instance, for example, `cfaas`.
   *
   * @return the subType
   */
  public String subType() {
    return subType;
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
   * Gets the state.
   *
   * The state of the instance. If not specified, instances in state `active` and `provisioning` are returned.
   *
   * @return the state
   */
  public String state() {
    return state;
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

