/*
 * (C) Copyright IBM Corp. 2025.
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
  @SerializedName("crn_mask")
  protected String crnMask;
  @SerializedName("paid_only")
  protected Boolean paidOnly;
  @SerializedName("custom_create_page_hybrid_enabled")
  protected Boolean customCreatePageHybridEnabled;

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
    private String crnMask;
    private Boolean paidOnly;
    private Boolean customCreatePageHybridEnabled;

    /**
     * Instantiates a new Builder from an existing CFMetaData instance.
     *
     * @param cfMetaData the instance to initialize the Builder with
     */
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
      this.crnMask = cfMetaData.crnMask;
      this.paidOnly = cfMetaData.paidOnly;
      this.customCreatePageHybridEnabled = cfMetaData.customCreatePageHybridEnabled;
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
     * Adds a new element to requires.
     *
     * @param requires the new element to be added
     * @return the CFMetaData builder
     * @deprecated this method is deprecated and may be removed in a future release
     */
    @Deprecated
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
     * @deprecated this method is deprecated and may be removed in a future release
     */
    @Deprecated
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
     * @deprecated this method is deprecated and may be removed in a future release
     */
    @Deprecated
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
     * @deprecated this method is deprecated and may be removed in a future release
     */
    @Deprecated
    public Builder asyncProvisioningSupported(Boolean asyncProvisioningSupported) {
      this.asyncProvisioningSupported = asyncProvisioningSupported;
      return this;
    }

    /**
     * Set the asyncUnprovisioningSupported.
     *
     * @param asyncUnprovisioningSupported the asyncUnprovisioningSupported
     * @return the CFMetaData builder
     * @deprecated this method is deprecated and may be removed in a future release
     */
    @Deprecated
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
     * @deprecated this method is deprecated and may be removed in a future release
     */
    @Deprecated
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
     * @deprecated this method is deprecated and may be removed in a future release
     */
    @Deprecated
    public Builder state(String state) {
      this.state = state;
      return this;
    }

    /**
     * Set the serviceCheckEnabled.
     *
     * @param serviceCheckEnabled the serviceCheckEnabled
     * @return the CFMetaData builder
     * @deprecated this method is deprecated and may be removed in a future release
     */
    @Deprecated
    public Builder serviceCheckEnabled(Boolean serviceCheckEnabled) {
      this.serviceCheckEnabled = serviceCheckEnabled;
      return this;
    }

    /**
     * Set the testCheckInterval.
     *
     * @param testCheckInterval the testCheckInterval
     * @return the CFMetaData builder
     * @deprecated this method is deprecated and may be removed in a future release
     */
    @Deprecated
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
     * @deprecated this method is deprecated and may be removed in a future release
     */
    @Deprecated
    public Builder cfGuid(Map<String, String> cfGuid) {
      this.cfGuid = cfGuid;
      return this;
    }

    /**
     * Set the crnMask.
     *
     * @param crnMask the crnMask
     * @return the CFMetaData builder
     */
    public Builder crnMask(String crnMask) {
      this.crnMask = crnMask;
      return this;
    }

    /**
     * Set the paidOnly.
     *
     * @param paidOnly the paidOnly
     * @return the CFMetaData builder
     * @deprecated this method is deprecated and may be removed in a future release
     */
    @Deprecated
    public Builder paidOnly(Boolean paidOnly) {
      this.paidOnly = paidOnly;
      return this;
    }

    /**
     * Set the customCreatePageHybridEnabled.
     *
     * @param customCreatePageHybridEnabled the customCreatePageHybridEnabled
     * @return the CFMetaData builder
     */
    public Builder customCreatePageHybridEnabled(Boolean customCreatePageHybridEnabled) {
      this.customCreatePageHybridEnabled = customCreatePageHybridEnabled;
      return this;
    }
  }

  protected CFMetaData() { }

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
    crnMask = builder.crnMask;
    paidOnly = builder.paidOnly;
    customCreatePageHybridEnabled = builder.customCreatePageHybridEnabled;
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
   * The type of service (public, cfaas, personal_catalog, kms, toolchain, etc.).
   *
   * @return the type
   * @deprecated this method is deprecated and may be removed in a future release
   */
  @Deprecated
  public String type() {
    return type;
  }

  /**
   * Gets the iamCompatible.
   *
   * Boolean value that describes whether the service is compatible with Identity and Access Management for
   * authentication and authorization.
   *
   * @return the iamCompatible
   */
  public Boolean iamCompatible() {
    return iamCompatible;
  }

  /**
   * Gets the uniqueApiKey.
   *
   * Boolean value that describes whether the service has a unique API key. Only settable on services, should be set via
   * partnercenter.
   *
   * @return the uniqueApiKey
   * @deprecated this method is deprecated and may be removed in a future release
   */
  @Deprecated
  public Boolean uniqueApiKey() {
    return uniqueApiKey;
  }

  /**
   * Gets the provisionable.
   *
   * Boolean value that, if true, the service is provisionable via resource controller (RC) or, if false, via a service
   * control point API. If false, you may need sales or support to create this service.
   *
   * @return the provisionable
   */
  public Boolean provisionable() {
    return provisionable;
  }

  /**
   * Gets the bindable.
   *
   * Boolean value that describes whether the service can be bound to an application. If true then this will create and
   * use resource keys.
   *
   * @return the bindable
   */
  public Boolean bindable() {
    return bindable;
  }

  /**
   * Gets the asyncProvisioningSupported.
   *
   * Boolean value that describes whether the service supports asynchronous provisioning. Now handled by a 202 response
   * indicating support from the broker on provisioning.
   *
   * @return the asyncProvisioningSupported
   * @deprecated this method is deprecated and may be removed in a future release
   */
  @Deprecated
  public Boolean asyncProvisioningSupported() {
    return asyncProvisioningSupported;
  }

  /**
   * Gets the asyncUnprovisioningSupported.
   *
   * Boolean value that describes whether the service supports asynchronous unprovisioning. Now handled by a 202
   * response indicating support from the broker on unprovisioning.
   *
   * @return the asyncUnprovisioningSupported
   * @deprecated this method is deprecated and may be removed in a future release
   */
  @Deprecated
  public Boolean asyncUnprovisioningSupported() {
    return asyncUnprovisioningSupported;
  }

  /**
   * Gets the requires.
   *
   * Dependencies needed to use this service.
   *
   * @return the requires
   * @deprecated this method is deprecated and may be removed in a future release
   */
  @Deprecated
  public List<String> requires() {
    return requires;
  }

  /**
   * Gets the planUpdateable.
   *
   * Boolean value that describes whether the service supports changing plans within the service. Only settable on
   * services, read only on plans and deployments.
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
   * @deprecated this method is deprecated and may be removed in a future release
   */
  @Deprecated
  public String state() {
    return state;
  }

  /**
   * Gets the serviceCheckEnabled.
   *
   * Boolean value that describes whether the Estado testing service will perform uptime tests for this service.
   *
   * @return the serviceCheckEnabled
   * @deprecated this method is deprecated and may be removed in a future release
   */
  @Deprecated
  public Boolean serviceCheckEnabled() {
    return serviceCheckEnabled;
  }

  /**
   * Gets the testCheckInterval.
   *
   * A unit of time that determines the time in between uptime checks performed by Estado.
   *
   * @return the testCheckInterval
   * @deprecated this method is deprecated and may be removed in a future release
   */
  @Deprecated
  public Long testCheckInterval() {
    return testCheckInterval;
  }

  /**
   * Gets the serviceKeySupported.
   *
   * Boolean value that describes whether the service supports the creation of service credentials. Without service key
   * support, a service cannot be bound to a cluster.
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
   * @deprecated this method is deprecated and may be removed in a future release
   */
  @Deprecated
  public Map<String, String> cfGuid() {
    return cfGuid;
  }

  /**
   * Gets the crnMask.
   *
   * Cloud resource name identifying the environment containing this service.
   *
   * @return the crnMask
   */
  public String crnMask() {
    return crnMask;
  }

  /**
   * Gets the paidOnly.
   *
   * Boolean flag indicating if this service only offers paid pricing plans rather than the default paygo.
   *
   * @return the paidOnly
   * @deprecated this method is deprecated and may be removed in a future release
   */
  @Deprecated
  public Boolean paidOnly() {
    return paidOnly;
  }

  /**
   * Gets the customCreatePageHybridEnabled.
   *
   * Boolean flag that determines if the hybrid page is accessible from the main catalog provisioning page.
   *
   * @return the customCreatePageHybridEnabled
   */
  public Boolean customCreatePageHybridEnabled() {
    return customCreatePageHybridEnabled;
  }
}

