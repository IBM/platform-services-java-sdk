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

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.google.gson.annotations.SerializedName;
import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * Service-related metadata.
 */
public class CFMetaData extends GenericModel {

  protected String type;
  @SerializedName("iam_compatible")
  protected Boolean iamCompatible;
  @SerializedName("unique_api_key")
  protected Boolean uniqueApiKey;
  protected Boolean provisionable;
  protected Boolean bindable;
  @SerializedName("async_provisioning_supported")
  protected Boolean asyncProvisioningSupported;
  @SerializedName("async_unprovisioning_supported")
  protected Boolean asyncUnprovisioningSupported;
  protected List<String> requires;
  @SerializedName("plan_updateable")
  protected Boolean planUpdateable;
  protected String state;
  @SerializedName("service_check_enabled")
  protected Boolean serviceCheckEnabled;
  @SerializedName("test_check_interval")
  protected Long testCheckInterval;
  @SerializedName("service_key_supported")
  protected Boolean serviceKeySupported;
  @SerializedName("cf_guid")
  protected Map<String, String> cfGuid;

  /**
   * Builder.
   */
  public static class Builder {
    private String type;
    private Boolean iamCompatible;
    private Boolean uniqueApiKey;
    private Boolean provisionable;
    private Boolean bindable;
    private Boolean asyncProvisioningSupported;
    private Boolean asyncUnprovisioningSupported;
    private List<String> requires;
    private Boolean planUpdateable;
    private String state;
    private Boolean serviceCheckEnabled;
    private Long testCheckInterval;
    private Boolean serviceKeySupported;
    private Map<String, String> cfGuid;

    private Builder(CFMetaData cfMetaData) {
      this.type = cfMetaData.type;
      this.iamCompatible = cfMetaData.iamCompatible;
      this.uniqueApiKey = cfMetaData.uniqueApiKey;
      this.provisionable = cfMetaData.provisionable;
      this.bindable = cfMetaData.bindable;
      this.asyncProvisioningSupported = cfMetaData.asyncProvisioningSupported;
      this.asyncUnprovisioningSupported = cfMetaData.asyncUnprovisioningSupported;
      this.requires = cfMetaData.requires;
      this.planUpdateable = cfMetaData.planUpdateable;
      this.state = cfMetaData.state;
      this.serviceCheckEnabled = cfMetaData.serviceCheckEnabled;
      this.testCheckInterval = cfMetaData.testCheckInterval;
      this.serviceKeySupported = cfMetaData.serviceKeySupported;
      this.cfGuid = cfMetaData.cfGuid;
    }

    /**
     * Instantiates a new builder.
     */
    public Builder() {
    }

    /**
     * Builds a CFMetaData.
     *
     * @return the new CFMetaData instance
     */
    public CFMetaData build() {
      return new CFMetaData(this);
    }

    /**
     * Adds an requires to requires.
     *
     * @param requires the new requires
     * @return the CFMetaData builder
     */
    public Builder addRequires(String requires) {
      com.ibm.cloud.sdk.core.util.Validator.notNull(requires,
        "requires cannot be null");
      if (this.requires == null) {
        this.requires = new ArrayList<String>();
      }
      this.requires.add(requires);
      return this;
    }

    /**
     * Set the type.
     *
     * @param type the type
     * @return the CFMetaData builder
     */
    public Builder type(String type) {
      this.type = type;
      return this;
    }

    /**
     * Set the iamCompatible.
     *
     * @param iamCompatible the iamCompatible
     * @return the CFMetaData builder
     */
    public Builder iamCompatible(Boolean iamCompatible) {
      this.iamCompatible = iamCompatible;
      return this;
    }

    /**
     * Set the uniqueApiKey.
     *
     * @param uniqueApiKey the uniqueApiKey
     * @return the CFMetaData builder
     */
    public Builder uniqueApiKey(Boolean uniqueApiKey) {
      this.uniqueApiKey = uniqueApiKey;
      return this;
    }

    /**
     * Set the provisionable.
     *
     * @param provisionable the provisionable
     * @return the CFMetaData builder
     */
    public Builder provisionable(Boolean provisionable) {
      this.provisionable = provisionable;
      return this;
    }

    /**
     * Set the bindable.
     *
     * @param bindable the bindable
     * @return the CFMetaData builder
     */
    public Builder bindable(Boolean bindable) {
      this.bindable = bindable;
      return this;
    }

    /**
     * Set the asyncProvisioningSupported.
     *
     * @param asyncProvisioningSupported the asyncProvisioningSupported
     * @return the CFMetaData builder
     */
    public Builder asyncProvisioningSupported(Boolean asyncProvisioningSupported) {
      this.asyncProvisioningSupported = asyncProvisioningSupported;
      return this;
    }

    /**
     * Set the asyncUnprovisioningSupported.
     *
     * @param asyncUnprovisioningSupported the asyncUnprovisioningSupported
     * @return the CFMetaData builder
     */
    public Builder asyncUnprovisioningSupported(Boolean asyncUnprovisioningSupported) {
      this.asyncUnprovisioningSupported = asyncUnprovisioningSupported;
      return this;
    }

    /**
     * Set the requires.
     * Existing requires will be replaced.
     *
     * @param requires the requires
     * @return the CFMetaData builder
     */
    public Builder requires(List<String> requires) {
      this.requires = requires;
      return this;
    }

    /**
     * Set the planUpdateable.
     *
     * @param planUpdateable the planUpdateable
     * @return the CFMetaData builder
     */
    public Builder planUpdateable(Boolean planUpdateable) {
      this.planUpdateable = planUpdateable;
      return this;
    }

    /**
     * Set the state.
     *
     * @param state the state
     * @return the CFMetaData builder
     */
    public Builder state(String state) {
      this.state = state;
      return this;
    }

    /**
     * Set the serviceCheckEnabled.
     *
     * @param serviceCheckEnabled the serviceCheckEnabled
     * @return the CFMetaData builder
     */
    public Builder serviceCheckEnabled(Boolean serviceCheckEnabled) {
      this.serviceCheckEnabled = serviceCheckEnabled;
      return this;
    }

    /**
     * Set the testCheckInterval.
     *
     * @param testCheckInterval the testCheckInterval
     * @return the CFMetaData builder
     */
    public Builder testCheckInterval(long testCheckInterval) {
      this.testCheckInterval = testCheckInterval;
      return this;
    }

    /**
     * Set the serviceKeySupported.
     *
     * @param serviceKeySupported the serviceKeySupported
     * @return the CFMetaData builder
     */
    public Builder serviceKeySupported(Boolean serviceKeySupported) {
      this.serviceKeySupported = serviceKeySupported;
      return this;
    }

    /**
     * Set the cfGuid.
     *
     * @param cfGuid the cfGuid
     * @return the CFMetaData builder
     */
    public Builder cfGuid(Map<String, String> cfGuid) {
      this.cfGuid = cfGuid;
      return this;
    }
  }

  protected CFMetaData(Builder builder) {
    type = builder.type;
    iamCompatible = builder.iamCompatible;
    uniqueApiKey = builder.uniqueApiKey;
    provisionable = builder.provisionable;
    bindable = builder.bindable;
    asyncProvisioningSupported = builder.asyncProvisioningSupported;
    asyncUnprovisioningSupported = builder.asyncUnprovisioningSupported;
    requires = builder.requires;
    planUpdateable = builder.planUpdateable;
    state = builder.state;
    serviceCheckEnabled = builder.serviceCheckEnabled;
    testCheckInterval = builder.testCheckInterval;
    serviceKeySupported = builder.serviceKeySupported;
    cfGuid = builder.cfGuid;
  }

  /**
   * New builder.
   *
   * @return a CFMetaData builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the type.
   *
   * Type of service.
   *
   * @return the type
   */
  public String type() {
    return type;
  }

  /**
   * Gets the iamCompatible.
   *
   * Boolean value that describes whether the service is compatible with Identity and Access Management.
   *
   * @return the iamCompatible
   */
  public Boolean iamCompatible() {
    return iamCompatible;
  }

  /**
   * Gets the uniqueApiKey.
   *
   * Boolean value that describes whether the service has a unique API key.
   *
   * @return the uniqueApiKey
   */
  public Boolean uniqueApiKey() {
    return uniqueApiKey;
  }

  /**
   * Gets the provisionable.
   *
   * Boolean value that describes whether the service is provisionable or not. You may need sales or support to create
   * this service.
   *
   * @return the provisionable
   */
  public Boolean provisionable() {
    return provisionable;
  }

  /**
   * Gets the bindable.
   *
   * Boolean value that describes whether you can create bindings for this service.
   *
   * @return the bindable
   */
  public Boolean bindable() {
    return bindable;
  }

  /**
   * Gets the asyncProvisioningSupported.
   *
   * Boolean value that describes whether the service supports asynchronous provisioning.
   *
   * @return the asyncProvisioningSupported
   */
  public Boolean asyncProvisioningSupported() {
    return asyncProvisioningSupported;
  }

  /**
   * Gets the asyncUnprovisioningSupported.
   *
   * Boolean value that describes whether the service supports asynchronous unprovisioning.
   *
   * @return the asyncUnprovisioningSupported
   */
  public Boolean asyncUnprovisioningSupported() {
    return asyncUnprovisioningSupported;
  }

  /**
   * Gets the requires.
   *
   * Service dependencies.
   *
   * @return the requires
   */
  public List<String> requires() {
    return requires;
  }

  /**
   * Gets the planUpdateable.
   *
   * Boolean value that describes whether the service supports upgrade or downgrade for some plans.
   *
   * @return the planUpdateable
   */
  public Boolean planUpdateable() {
    return planUpdateable;
  }

  /**
   * Gets the state.
   *
   * String that describes whether the service is active or inactive.
   *
   * @return the state
   */
  public String state() {
    return state;
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
   * Gets the serviceKeySupported.
   *
   * Boolean value that describes whether the service supports service keys.
   *
   * @return the serviceKeySupported
   */
  public Boolean serviceKeySupported() {
    return serviceKeySupported;
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

