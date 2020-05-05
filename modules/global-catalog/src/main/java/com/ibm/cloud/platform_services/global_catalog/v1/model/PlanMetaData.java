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
package com.ibm.cloud.platform_services.global_catalog.v1.model;

import java.util.Map;

import com.google.gson.annotations.SerializedName;
import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * Plan-related metadata.
 */
public class PlanMetaData extends GenericModel {

  protected Boolean bindable;
  protected Boolean reservable;
  @SerializedName("allow_internal_users")
  protected Boolean allowInternalUsers;
  @SerializedName("async_provisioning_supported")
  protected Boolean asyncProvisioningSupported;
  @SerializedName("async_unprovisioning_supported")
  protected Boolean asyncUnprovisioningSupported;
  @SerializedName("test_check_interval")
  protected Long testCheckInterval;
  @SerializedName("single_scope_instance")
  protected String singleScopeInstance;
  @SerializedName("service_check_enabled")
  protected Boolean serviceCheckEnabled;
  @SerializedName("cf_guid")
  protected Map<String, String> cfGuid;

  /**
   * Builder.
   */
  public static class Builder {
    private Boolean bindable;
    private Boolean reservable;
    private Boolean allowInternalUsers;
    private Boolean asyncProvisioningSupported;
    private Boolean asyncUnprovisioningSupported;
    private Long testCheckInterval;
    private String singleScopeInstance;
    private Boolean serviceCheckEnabled;
    private Map<String, String> cfGuid;

    private Builder(PlanMetaData planMetaData) {
      this.bindable = planMetaData.bindable;
      this.reservable = planMetaData.reservable;
      this.allowInternalUsers = planMetaData.allowInternalUsers;
      this.asyncProvisioningSupported = planMetaData.asyncProvisioningSupported;
      this.asyncUnprovisioningSupported = planMetaData.asyncUnprovisioningSupported;
      this.testCheckInterval = planMetaData.testCheckInterval;
      this.singleScopeInstance = planMetaData.singleScopeInstance;
      this.serviceCheckEnabled = planMetaData.serviceCheckEnabled;
      this.cfGuid = planMetaData.cfGuid;
    }

    /**
     * Instantiates a new builder.
     */
    public Builder() {
    }

    /**
     * Builds a PlanMetaData.
     *
     * @return the new PlanMetaData instance
     */
    public PlanMetaData build() {
      return new PlanMetaData(this);
    }

    /**
     * Set the bindable.
     *
     * @param bindable the bindable
     * @return the PlanMetaData builder
     */
    public Builder bindable(Boolean bindable) {
      this.bindable = bindable;
      return this;
    }

    /**
     * Set the reservable.
     *
     * @param reservable the reservable
     * @return the PlanMetaData builder
     */
    public Builder reservable(Boolean reservable) {
      this.reservable = reservable;
      return this;
    }

    /**
     * Set the allowInternalUsers.
     *
     * @param allowInternalUsers the allowInternalUsers
     * @return the PlanMetaData builder
     */
    public Builder allowInternalUsers(Boolean allowInternalUsers) {
      this.allowInternalUsers = allowInternalUsers;
      return this;
    }

    /**
     * Set the asyncProvisioningSupported.
     *
     * @param asyncProvisioningSupported the asyncProvisioningSupported
     * @return the PlanMetaData builder
     */
    public Builder asyncProvisioningSupported(Boolean asyncProvisioningSupported) {
      this.asyncProvisioningSupported = asyncProvisioningSupported;
      return this;
    }

    /**
     * Set the asyncUnprovisioningSupported.
     *
     * @param asyncUnprovisioningSupported the asyncUnprovisioningSupported
     * @return the PlanMetaData builder
     */
    public Builder asyncUnprovisioningSupported(Boolean asyncUnprovisioningSupported) {
      this.asyncUnprovisioningSupported = asyncUnprovisioningSupported;
      return this;
    }

    /**
     * Set the testCheckInterval.
     *
     * @param testCheckInterval the testCheckInterval
     * @return the PlanMetaData builder
     */
    public Builder testCheckInterval(long testCheckInterval) {
      this.testCheckInterval = testCheckInterval;
      return this;
    }

    /**
     * Set the singleScopeInstance.
     *
     * @param singleScopeInstance the singleScopeInstance
     * @return the PlanMetaData builder
     */
    public Builder singleScopeInstance(String singleScopeInstance) {
      this.singleScopeInstance = singleScopeInstance;
      return this;
    }

    /**
     * Set the serviceCheckEnabled.
     *
     * @param serviceCheckEnabled the serviceCheckEnabled
     * @return the PlanMetaData builder
     */
    public Builder serviceCheckEnabled(Boolean serviceCheckEnabled) {
      this.serviceCheckEnabled = serviceCheckEnabled;
      return this;
    }

    /**
     * Set the cfGuid.
     *
     * @param cfGuid the cfGuid
     * @return the PlanMetaData builder
     */
    public Builder cfGuid(Map<String, String> cfGuid) {
      this.cfGuid = cfGuid;
      return this;
    }
  }

  protected PlanMetaData(Builder builder) {
    bindable = builder.bindable;
    reservable = builder.reservable;
    allowInternalUsers = builder.allowInternalUsers;
    asyncProvisioningSupported = builder.asyncProvisioningSupported;
    asyncUnprovisioningSupported = builder.asyncUnprovisioningSupported;
    testCheckInterval = builder.testCheckInterval;
    singleScopeInstance = builder.singleScopeInstance;
    serviceCheckEnabled = builder.serviceCheckEnabled;
    cfGuid = builder.cfGuid;
  }

  /**
   * New builder.
   *
   * @return a PlanMetaData builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the bindable.
   *
   * Boolean value that describes whether the service can be bound to an application.
   *
   * @return the bindable
   */
  public Boolean bindable() {
    return bindable;
  }

  /**
   * Gets the reservable.
   *
   * Boolean value that describes whether the service can be reserved.
   *
   * @return the reservable
   */
  public Boolean reservable() {
    return reservable;
  }

  /**
   * Gets the allowInternalUsers.
   *
   * Boolean value that describes whether the service can be used internally.
   *
   * @return the allowInternalUsers
   */
  public Boolean allowInternalUsers() {
    return allowInternalUsers;
  }

  /**
   * Gets the asyncProvisioningSupported.
   *
   * Boolean value that describes whether the service can be provisioned asynchronously.
   *
   * @return the asyncProvisioningSupported
   */
  public Boolean asyncProvisioningSupported() {
    return asyncProvisioningSupported;
  }

  /**
   * Gets the asyncUnprovisioningSupported.
   *
   * Boolean value that describes whether the service can be unprovisioned asynchronously.
   *
   * @return the asyncUnprovisioningSupported
   */
  public Boolean asyncUnprovisioningSupported() {
    return asyncUnprovisioningSupported;
  }

  /**
   * Gets the testCheckInterval.
   *
   * Test check interval.
   *
   * @return the testCheckInterval
   */
  public Long testCheckInterval() {
    return testCheckInterval;
  }

  /**
   * Gets the singleScopeInstance.
   *
   * Single scope instance.
   *
   * @return the singleScopeInstance
   */
  public String singleScopeInstance() {
    return singleScopeInstance;
  }

  /**
   * Gets the serviceCheckEnabled.
   *
   * Boolean value that describes whether the service check is enabled.
   *
   * @return the serviceCheckEnabled
   */
  public Boolean serviceCheckEnabled() {
    return serviceCheckEnabled;
  }

  /**
   * Gets the cfGuid.
   *
   * If the field is imported from Cloud Foundry, the Cloud Foundry region's GUID. This is a required field. For
   * example, `us-south=123`.
   *
   * @return the cfGuid
   */
  public Map<String, String> cfGuid() {
    return cfGuid;
  }
}

