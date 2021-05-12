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

import java.util.Map;

import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * The preinstallVersion options.
 */
public class PreinstallVersionOptions extends GenericModel {

  protected String versionLocId;
  protected String xAuthRefreshToken;
  protected String clusterId;
  protected String region;
  protected String namespace;
  protected Map<String, Object> overrideValues;
  protected String entitlementApikey;
  protected DeployRequestBodySchematics schematics;
  protected String script;
  protected String scriptId;
  protected String versionLocatorId;
  protected String vcenterId;
  protected String vcenterUser;
  protected String vcenterPassword;
  protected String vcenterLocation;
  protected String vcenterDatastore;

  /**
   * Builder.
   */
  public static class Builder {
    private String versionLocId;
    private String xAuthRefreshToken;
    private String clusterId;
    private String region;
    private String namespace;
    private Map<String, Object> overrideValues;
    private String entitlementApikey;
    private DeployRequestBodySchematics schematics;
    private String script;
    private String scriptId;
    private String versionLocatorId;
    private String vcenterId;
    private String vcenterUser;
    private String vcenterPassword;
    private String vcenterLocation;
    private String vcenterDatastore;

    private Builder(PreinstallVersionOptions preinstallVersionOptions) {
      this.versionLocId = preinstallVersionOptions.versionLocId;
      this.xAuthRefreshToken = preinstallVersionOptions.xAuthRefreshToken;
      this.clusterId = preinstallVersionOptions.clusterId;
      this.region = preinstallVersionOptions.region;
      this.namespace = preinstallVersionOptions.namespace;
      this.overrideValues = preinstallVersionOptions.overrideValues;
      this.entitlementApikey = preinstallVersionOptions.entitlementApikey;
      this.schematics = preinstallVersionOptions.schematics;
      this.script = preinstallVersionOptions.script;
      this.scriptId = preinstallVersionOptions.scriptId;
      this.versionLocatorId = preinstallVersionOptions.versionLocatorId;
      this.vcenterId = preinstallVersionOptions.vcenterId;
      this.vcenterUser = preinstallVersionOptions.vcenterUser;
      this.vcenterPassword = preinstallVersionOptions.vcenterPassword;
      this.vcenterLocation = preinstallVersionOptions.vcenterLocation;
      this.vcenterDatastore = preinstallVersionOptions.vcenterDatastore;
    }

    /**
     * Instantiates a new builder.
     */
    public Builder() {
    }

    /**
     * Instantiates a new builder with required properties.
     *
     * @param versionLocId the versionLocId
     * @param xAuthRefreshToken the xAuthRefreshToken
     */
    public Builder(String versionLocId, String xAuthRefreshToken) {
      this.versionLocId = versionLocId;
      this.xAuthRefreshToken = xAuthRefreshToken;
    }

    /**
     * Builds a PreinstallVersionOptions.
     *
     * @return the new PreinstallVersionOptions instance
     */
    public PreinstallVersionOptions build() {
      return new PreinstallVersionOptions(this);
    }

    /**
     * Set the versionLocId.
     *
     * @param versionLocId the versionLocId
     * @return the PreinstallVersionOptions builder
     */
    public Builder versionLocId(String versionLocId) {
      this.versionLocId = versionLocId;
      return this;
    }

    /**
     * Set the xAuthRefreshToken.
     *
     * @param xAuthRefreshToken the xAuthRefreshToken
     * @return the PreinstallVersionOptions builder
     */
    public Builder xAuthRefreshToken(String xAuthRefreshToken) {
      this.xAuthRefreshToken = xAuthRefreshToken;
      return this;
    }

    /**
     * Set the clusterId.
     *
     * @param clusterId the clusterId
     * @return the PreinstallVersionOptions builder
     */
    public Builder clusterId(String clusterId) {
      this.clusterId = clusterId;
      return this;
    }

    /**
     * Set the region.
     *
     * @param region the region
     * @return the PreinstallVersionOptions builder
     */
    public Builder region(String region) {
      this.region = region;
      return this;
    }

    /**
     * Set the namespace.
     *
     * @param namespace the namespace
     * @return the PreinstallVersionOptions builder
     */
    public Builder namespace(String namespace) {
      this.namespace = namespace;
      return this;
    }

    /**
     * Set the overrideValues.
     *
     * @param overrideValues the overrideValues
     * @return the PreinstallVersionOptions builder
     */
    public Builder overrideValues(Map<String, Object> overrideValues) {
      this.overrideValues = overrideValues;
      return this;
    }

    /**
     * Set the entitlementApikey.
     *
     * @param entitlementApikey the entitlementApikey
     * @return the PreinstallVersionOptions builder
     */
    public Builder entitlementApikey(String entitlementApikey) {
      this.entitlementApikey = entitlementApikey;
      return this;
    }

    /**
     * Set the schematics.
     *
     * @param schematics the schematics
     * @return the PreinstallVersionOptions builder
     */
    public Builder schematics(DeployRequestBodySchematics schematics) {
      this.schematics = schematics;
      return this;
    }

    /**
     * Set the script.
     *
     * @param script the script
     * @return the PreinstallVersionOptions builder
     */
    public Builder script(String script) {
      this.script = script;
      return this;
    }

    /**
     * Set the scriptId.
     *
     * @param scriptId the scriptId
     * @return the PreinstallVersionOptions builder
     */
    public Builder scriptId(String scriptId) {
      this.scriptId = scriptId;
      return this;
    }

    /**
     * Set the versionLocatorId.
     *
     * @param versionLocatorId the versionLocatorId
     * @return the PreinstallVersionOptions builder
     */
    public Builder versionLocatorId(String versionLocatorId) {
      this.versionLocatorId = versionLocatorId;
      return this;
    }

    /**
     * Set the vcenterId.
     *
     * @param vcenterId the vcenterId
     * @return the PreinstallVersionOptions builder
     */
    public Builder vcenterId(String vcenterId) {
      this.vcenterId = vcenterId;
      return this;
    }

    /**
     * Set the vcenterUser.
     *
     * @param vcenterUser the vcenterUser
     * @return the PreinstallVersionOptions builder
     */
    public Builder vcenterUser(String vcenterUser) {
      this.vcenterUser = vcenterUser;
      return this;
    }

    /**
     * Set the vcenterPassword.
     *
     * @param vcenterPassword the vcenterPassword
     * @return the PreinstallVersionOptions builder
     */
    public Builder vcenterPassword(String vcenterPassword) {
      this.vcenterPassword = vcenterPassword;
      return this;
    }

    /**
     * Set the vcenterLocation.
     *
     * @param vcenterLocation the vcenterLocation
     * @return the PreinstallVersionOptions builder
     */
    public Builder vcenterLocation(String vcenterLocation) {
      this.vcenterLocation = vcenterLocation;
      return this;
    }

    /**
     * Set the vcenterDatastore.
     *
     * @param vcenterDatastore the vcenterDatastore
     * @return the PreinstallVersionOptions builder
     */
    public Builder vcenterDatastore(String vcenterDatastore) {
      this.vcenterDatastore = vcenterDatastore;
      return this;
    }
  }

  protected PreinstallVersionOptions(Builder builder) {
    com.ibm.cloud.sdk.core.util.Validator.notEmpty(builder.versionLocId,
      "versionLocId cannot be empty");
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.xAuthRefreshToken,
      "xAuthRefreshToken cannot be null");
    versionLocId = builder.versionLocId;
    xAuthRefreshToken = builder.xAuthRefreshToken;
    clusterId = builder.clusterId;
    region = builder.region;
    namespace = builder.namespace;
    overrideValues = builder.overrideValues;
    entitlementApikey = builder.entitlementApikey;
    schematics = builder.schematics;
    script = builder.script;
    scriptId = builder.scriptId;
    versionLocatorId = builder.versionLocatorId;
    vcenterId = builder.vcenterId;
    vcenterUser = builder.vcenterUser;
    vcenterPassword = builder.vcenterPassword;
    vcenterLocation = builder.vcenterLocation;
    vcenterDatastore = builder.vcenterDatastore;
  }

  /**
   * New builder.
   *
   * @return a PreinstallVersionOptions builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the versionLocId.
   *
   * A dotted value of `catalogID`.`versionID`.
   *
   * @return the versionLocId
   */
  public String versionLocId() {
    return versionLocId;
  }

  /**
   * Gets the xAuthRefreshToken.
   *
   * IAM Refresh token.
   *
   * @return the xAuthRefreshToken
   */
  public String xAuthRefreshToken() {
    return xAuthRefreshToken;
  }

  /**
   * Gets the clusterId.
   *
   * Cluster ID.
   *
   * @return the clusterId
   */
  public String clusterId() {
    return clusterId;
  }

  /**
   * Gets the region.
   *
   * Cluster region.
   *
   * @return the region
   */
  public String region() {
    return region;
  }

  /**
   * Gets the namespace.
   *
   * Kube namespace.
   *
   * @return the namespace
   */
  public String namespace() {
    return namespace;
  }

  /**
   * Gets the overrideValues.
   *
   * Object containing Helm chart override values.  To use a secret for items of type password, specify a JSON encoded
   * value of $ref:#/components/schemas/SecretInstance, prefixed with `cmsm_v1:`.
   *
   * @return the overrideValues
   */
  public Map<String, Object> overrideValues() {
    return overrideValues;
  }

  /**
   * Gets the entitlementApikey.
   *
   * Entitlement API Key for this offering.
   *
   * @return the entitlementApikey
   */
  public String entitlementApikey() {
    return entitlementApikey;
  }

  /**
   * Gets the schematics.
   *
   * Schematics workspace configuration.
   *
   * @return the schematics
   */
  public DeployRequestBodySchematics schematics() {
    return schematics;
  }

  /**
   * Gets the script.
   *
   * Script.
   *
   * @return the script
   */
  public String script() {
    return script;
  }

  /**
   * Gets the scriptId.
   *
   * Script ID.
   *
   * @return the scriptId
   */
  public String scriptId() {
    return scriptId;
  }

  /**
   * Gets the versionLocatorId.
   *
   * A dotted value of `catalogID`.`versionID`.
   *
   * @return the versionLocatorId
   */
  public String versionLocatorId() {
    return versionLocatorId;
  }

  /**
   * Gets the vcenterId.
   *
   * VCenter ID.
   *
   * @return the vcenterId
   */
  public String vcenterId() {
    return vcenterId;
  }

  /**
   * Gets the vcenterUser.
   *
   * VCenter User.
   *
   * @return the vcenterUser
   */
  public String vcenterUser() {
    return vcenterUser;
  }

  /**
   * Gets the vcenterPassword.
   *
   * VCenter Password.
   *
   * @return the vcenterPassword
   */
  public String vcenterPassword() {
    return vcenterPassword;
  }

  /**
   * Gets the vcenterLocation.
   *
   * VCenter Location.
   *
   * @return the vcenterLocation
   */
  public String vcenterLocation() {
    return vcenterLocation;
  }

  /**
   * Gets the vcenterDatastore.
   *
   * VCenter Datastore.
   *
   * @return the vcenterDatastore
   */
  public String vcenterDatastore() {
    return vcenterDatastore;
  }
}

