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
package com.ibm.cloud.platform_services.open_service_broker.v1.model;

import com.google.gson.annotations.SerializedName;
import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * Check the active status of an enabled service.
 */
public class Resp1874644Root extends GenericModel {

  protected Boolean active;
  protected Boolean enabled;
  @SerializedName("last_active")
  protected Double lastActive;

  /**
   * Gets the active.
   *
   * Indicates (from the viewpoint of the provider) whether the service instance is active and is meaningful if enabled
   * is true. The default value is true if not specified.
   *
   * @return the active
   */
  public Boolean isActive() {
    return active;
  }

  /**
   * Gets the enabled.
   *
   * Indicates the current state of the service instance.
   *
   * @return the enabled
   */
  public Boolean isEnabled() {
    return enabled;
  }

  /**
   * Gets the lastActive.
   *
   * Indicates when the service instance was last accessed/modified/etc., and is meaningful if enabled is true AND
   * active is false. Represented as milliseconds since the epoch, but does not need to be accurate to the second/hour.
   *
   * @return the lastActive
   */
  public Double getLastActive() {
    return lastActive;
  }
}

