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

  protected CatalogEntryMetadataDeployment() { }

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
   * The original region in which this deployment existed.
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
   * Cloud resource name for this deployment.
   *
   * @return the serviceCrn
   */
  public String getServiceCrn() {
    return serviceCrn;
  }

  /**
   * Gets the mccpId.
   *
   * ID of the multi cloud connectivity platform.
   *
   * @return the mccpId
   * @deprecated this method is deprecated and may be removed in a future release
   */
  @Deprecated
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
   * @deprecated this method is deprecated and may be removed in a future release
   */
  @Deprecated
  public Boolean isSupportsRcMigration() {
    return supportsRcMigration;
  }

  /**
   * Gets the targetNetwork.
   *
   * When using the service_endpoint_supported tag for a deployment, this optional field can be set on a deployment to
   * denote the supported service endpoint type (cse_private, public, or cse_private+public).
   *
   * @return the targetNetwork
   */
  public String getTargetNetwork() {
    return targetNetwork;
  }
}

