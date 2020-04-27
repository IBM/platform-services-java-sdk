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

import com.google.gson.annotations.SerializedName;
import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * Deployment-related metadata.
 */
public class DeploymentBase extends GenericModel {

  protected String location;
  @SerializedName("target_crn")
  protected String targetCrn;
  protected DeploymentBaseBroker broker;
  @SerializedName("supports_rc_migration")
  protected Boolean supportsRcMigration;
  @SerializedName("target_network")
  protected String targetNetwork;

  /**
   * Builder.
   */
  public static class Builder {
    private String location;
    private String targetCrn;
    private DeploymentBaseBroker broker;
    private Boolean supportsRcMigration;
    private String targetNetwork;

    private Builder(DeploymentBase deploymentBase) {
      this.location = deploymentBase.location;
      this.targetCrn = deploymentBase.targetCrn;
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
     * Set the broker.
     *
     * @param broker the broker
     * @return the DeploymentBase builder
     */
    public Builder broker(DeploymentBaseBroker broker) {
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

  protected DeploymentBase(Builder builder) {
    location = builder.location;
    targetCrn = builder.targetCrn;
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
   * Gets the broker.
   *
   * The broker associated with a catalog entry.
   *
   * @return the broker
   */
  public DeploymentBaseBroker broker() {
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

