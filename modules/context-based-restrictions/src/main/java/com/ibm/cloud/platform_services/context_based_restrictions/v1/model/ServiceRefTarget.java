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

package com.ibm.cloud.platform_services.context_based_restrictions.v1.model;

import java.util.List;

import com.google.gson.annotations.SerializedName;
import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * Summary information about a service reference target.
 */
public class ServiceRefTarget extends GenericModel {

  @SerializedName("service_name")
  protected String serviceName;
  @SerializedName("service_type")
  protected String serviceType;
  protected List<ServiceRefTargetLocationsItem> locations;
  @SerializedName("display_name")
  protected String displayName;

  protected ServiceRefTarget() { }

  /**
   * Gets the serviceName.
   *
   * The name of the service.
   *
   * @return the serviceName
   */
  public String getServiceName() {
    return serviceName;
  }

  /**
   * Gets the serviceType.
   *
   * The type of the service.
   *
   * @return the serviceType
   */
  public String getServiceType() {
    return serviceType;
  }

  /**
   * Gets the locations.
   *
   * The locations the service is available.
   *
   * @return the locations
   */
  public List<ServiceRefTargetLocationsItem> getLocations() {
    return locations;
  }

  /**
   * Gets the displayName.
   *
   * The display name of the service.
   *
   * @return the displayName
   */
  public String getDisplayName() {
    return displayName;
  }
}

