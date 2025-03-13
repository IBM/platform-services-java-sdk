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

import com.google.gson.annotations.SerializedName;
import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * Deployment-related metadata.
 */
public class DeploymentBase extends GenericModel {

  protected String location;
  @SerializedName("location_url")
  protected String locationUrl;
  @SerializedName("original_location")
  protected String originalLocation;
  @SerializedName("target_crn")
  protected String targetCrn;
  @SerializedName("service_crn")
  protected String serviceCrn;
  @SerializedName("mccp_id")
  protected String mccpId;
  protected Broker broker;
  @SerializedName("supports_rc_migration")
  protected Boolean supportsRcMigration;
  @SerializedName("target_network")
  protected String targetNetwork;

  /**
   * Builder.
   */
  public static class Builder {
    private String location;
    private String locationUrl;
    private String originalLocation;
    private String targetCrn;
    private String serviceCrn;
    private String mccpId;
    private Broker broker;
    private Boolean supportsRcMigration;
    private String targetNetwork;

    /**
     * Instantiates a new Builder from an existing DeploymentBase instance.
     *
     * @param deploymentBase the instance to initialize the Builder with
     */
    private Builder(DeploymentBase deploymentBase) {
      this.location = deploymentBase.location;
      this.locationUrl = deploymentBase.locationUrl;
      this.originalLocation = deploymentBase.originalLocation;
      this.targetCrn = deploymentBase.targetCrn;
      this.serviceCrn = deploymentBase.serviceCrn;
      this.mccpId = deploymentBase.mccpId;
      this.broker = deploymentBase.broker;
      this.supportsRcMigration = deploymentBase.supportsRcMigration;
      this.targetNetwork = deploymentBase.targetNetwork;
    }

    /**
     * Instantiates a new builder.
     */
    public Builder() {
    }

    /**
     * Builds a DeploymentBase.
     *
     * @return the new DeploymentBase instance
     */
    public DeploymentBase build() {
      return new DeploymentBase(this);
    }

    /**
     * Set the location.
     *
     * @param location the location
     * @return the DeploymentBase builder
     */
    public Builder location(String location) {
      this.location = location;
      return this;
    }

    /**
     * Set the locationUrl.
     *
     * @param locationUrl the locationUrl
     * @return the DeploymentBase builder
     */
    public Builder locationUrl(String locationUrl) {
      this.locationUrl = locationUrl;
      return this;
    }

    /**
     * Set the originalLocation.
     *
     * @param originalLocation the originalLocation
     * @return the DeploymentBase builder
     */
    public Builder originalLocation(String originalLocation) {
      this.originalLocation = originalLocation;
      return this;
    }

    /**
     * Set the targetCrn.
     *
     * @param targetCrn the targetCrn
     * @return the DeploymentBase builder
     */
    public Builder targetCrn(String targetCrn) {
      this.targetCrn = targetCrn;
      return this;
    }

    /**
     * Set the serviceCrn.
     *
     * @param serviceCrn the serviceCrn
     * @return the DeploymentBase builder
     */
    public Builder serviceCrn(String serviceCrn) {
      this.serviceCrn = serviceCrn;
      return this;
    }

    /**
     * Set the mccpId.
     *
     * @param mccpId the mccpId
     * @return the DeploymentBase builder
     */
    public Builder mccpId(String mccpId) {
      this.mccpId = mccpId;
      return this;
    }

    /**
     * Set the broker.
     *
     * @param broker the broker
     * @return the DeploymentBase builder
     */
    public Builder broker(Broker broker) {
      this.broker = broker;
      return this;
    }

    /**
     * Set the supportsRcMigration.
     *
     * @param supportsRcMigration the supportsRcMigration
     * @return the DeploymentBase builder
     */
    public Builder supportsRcMigration(Boolean supportsRcMigration) {
      this.supportsRcMigration = supportsRcMigration;
      return this;
    }

    /**
     * Set the targetNetwork.
     *
     * @param targetNetwork the targetNetwork
     * @return the DeploymentBase builder
     */
    public Builder targetNetwork(String targetNetwork) {
      this.targetNetwork = targetNetwork;
      return this;
    }
  }

  protected DeploymentBase() { }

  protected DeploymentBase(Builder builder) {
    location = builder.location;
    locationUrl = builder.locationUrl;
    originalLocation = builder.originalLocation;
    targetCrn = builder.targetCrn;
    serviceCrn = builder.serviceCrn;
    mccpId = builder.mccpId;
    broker = builder.broker;
    supportsRcMigration = builder.supportsRcMigration;
    targetNetwork = builder.targetNetwork;
  }

  /**
   * New builder.
   *
   * @return a DeploymentBase builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the location.
   *
   * Describes the region where the service is located.
   *
   * @return the location
   */
  public String location() {
    return location;
  }

  /**
   * Gets the locationUrl.
   *
   * URL of deployment.
   *
   * @return the locationUrl
   */
  public String locationUrl() {
    return locationUrl;
  }

  /**
   * Gets the originalLocation.
   *
   * Original service location.
   *
   * @return the originalLocation
   */
  public String originalLocation() {
    return originalLocation;
  }

  /**
   * Gets the targetCrn.
   *
   * A CRN that describes the deployment. crn:v1:[cname]:[ctype]:[location]:[scope]::[resource-type]:[resource].
   *
   * @return the targetCrn
   */
  public String targetCrn() {
    return targetCrn;
  }

  /**
   * Gets the serviceCrn.
   *
   * CRN for the service.
   *
   * @return the serviceCrn
   */
  public String serviceCrn() {
    return serviceCrn;
  }

  /**
   * Gets the mccpId.
   *
   * ID for MCCP.
   *
   * @return the mccpId
   */
  public String mccpId() {
    return mccpId;
  }

  /**
   * Gets the broker.
   *
   * The broker associated with a catalog entry.
   *
   * @return the broker
   */
  public Broker broker() {
    return broker;
  }

  /**
   * Gets the supportsRcMigration.
   *
   * This deployment not only supports RC but is ready to migrate and support the RC broker for a location.
   *
   * @return the supportsRcMigration
   */
  public Boolean supportsRcMigration() {
    return supportsRcMigration;
  }

  /**
   * Gets the targetNetwork.
   *
   * network to use during deployment.
   *
   * @return the targetNetwork
   */
  public String targetNetwork() {
    return targetNetwork;
  }
}

