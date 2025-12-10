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

package com.ibm.cloud.platform_services.iam_policy_management.v1.model;

import com.google.gson.annotations.SerializedName;
import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * The settings for each identity type.
 */
public class IdentityTypes extends GenericModel {

  protected IdentityTypesBase user;
  @SerializedName("service_id")
  protected IdentityTypesBase serviceId;
  protected IdentityTypesBase service;

  protected IdentityTypes() { }

  /**
   * Gets the user.
   *
   * The core set of properties associated with an identity type.
   *
   * @return the user
   */
  public IdentityTypesBase getUser() {
    return user;
  }

  /**
   * Gets the serviceId.
   *
   * The core set of properties associated with an identity type.
   *
   * @return the serviceId
   */
  public IdentityTypesBase getServiceId() {
    return serviceId;
  }

  /**
   * Gets the service.
   *
   * The core set of properties associated with an identity type.
   *
   * @return the service
   */
  public IdentityTypesBase getService() {
    return service;
  }
}

