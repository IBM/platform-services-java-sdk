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
 * The settings to apply for each identity type for a request.
 */
public class IdentityTypesPatch extends GenericModel {

  protected IdentityTypesBase user;
  @SerializedName("service_id")
  protected IdentityTypesBase serviceId;
  protected IdentityTypesBase service;

  /**
   * Builder.
   */
  public static class Builder {
    private IdentityTypesBase user;
    private IdentityTypesBase serviceId;
    private IdentityTypesBase service;

    /**
     * Instantiates a new Builder from an existing IdentityTypesPatch instance.
     *
     * @param identityTypesPatch the instance to initialize the Builder with
     */
    private Builder(IdentityTypesPatch identityTypesPatch) {
      this.user = identityTypesPatch.user;
      this.serviceId = identityTypesPatch.serviceId;
      this.service = identityTypesPatch.service;
    }

    /**
     * Instantiates a new builder.
     */
    public Builder() {
    }

    /**
     * Builds a IdentityTypesPatch.
     *
     * @return the new IdentityTypesPatch instance
     */
    public IdentityTypesPatch build() {
      return new IdentityTypesPatch(this);
    }

    /**
     * Set the user.
     *
     * @param user the user
     * @return the IdentityTypesPatch builder
     */
    public Builder user(IdentityTypesBase user) {
      this.user = user;
      return this;
    }

    /**
     * Set the serviceId.
     *
     * @param serviceId the serviceId
     * @return the IdentityTypesPatch builder
     */
    public Builder serviceId(IdentityTypesBase serviceId) {
      this.serviceId = serviceId;
      return this;
    }

    /**
     * Set the service.
     *
     * @param service the service
     * @return the IdentityTypesPatch builder
     */
    public Builder service(IdentityTypesBase service) {
      this.service = service;
      return this;
    }
  }

  protected IdentityTypesPatch() { }

  protected IdentityTypesPatch(Builder builder) {
    user = builder.user;
    serviceId = builder.serviceId;
    service = builder.service;
  }

  /**
   * New builder.
   *
   * @return a IdentityTypesPatch builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the user.
   *
   * The core set of properties associated with an identity type.
   *
   * @return the user
   */
  public IdentityTypesBase user() {
    return user;
  }

  /**
   * Gets the serviceId.
   *
   * The core set of properties associated with an identity type.
   *
   * @return the serviceId
   */
  public IdentityTypesBase serviceId() {
    return serviceId;
  }

  /**
   * Gets the service.
   *
   * The core set of properties associated with an identity type.
   *
   * @return the service
   */
  public IdentityTypesBase service() {
    return service;
  }
}

