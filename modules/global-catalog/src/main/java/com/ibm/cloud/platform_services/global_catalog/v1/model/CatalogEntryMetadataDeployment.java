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
public class CatalogEntryMetadataDeployment extends GenericModel {

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
   * Gets the location.
   *
   * Describes the region where the service is located.
   *
   * @return the location
   */
  public String getLocation() {
    return location;
  }

  /**
   * Gets the locationUrl.
   *
   * Pointer to the location resource in the catalog.
   *
   * @return the locationUrl
   */
  public String getLocationUrl() {
    return locationUrl;
  }

  /**
   * Gets the originalLocation.
   *
   * Original service location.
   *
   * @return the originalLocation
   */
  public String getOriginalLocation() {
    return originalLocation;
  }

  /**
   * Gets the targetCrn.
   *
   * A CRN that describes the deployment. crn:v1:[cname]:[ctype]:[location]:[scope]::[resource-type]:[resource].
   *
   * @return the targetCrn
   */
  public String getTargetCrn() {
    return targetCrn;
  }

  /**
   * Gets the serviceCrn.
   *
   * CRN for the service.
   *
   * @return the serviceCrn
   */
  public String getServiceCrn() {
    return serviceCrn;
  }

  /**
   * Gets the mccpId.
   *
   * ID for MCCP.
   *
   * @return the mccpId
   */
  public String getMccpId() {
    return mccpId;
  }

  /**
   * Gets the broker.
   *
   * The broker associated with a catalog entry.
   *
   * @return the broker
   */
  public Broker getBroker() {
    return broker;
  }

  /**
   * Gets the supportsRcMigration.
   *
   * This deployment not only supports RC but is ready to migrate and support the RC broker for a location.
   *
   * @return the supportsRcMigration
   */
  public Boolean isSupportsRcMigration() {
    return supportsRcMigration;
  }

  /**
   * Gets the targetNetwork.
   *
   * network to use during deployment.
   *
   * @return the targetNetwork
   */
  public String getTargetNetwork() {
    return targetNetwork;
  }
}

