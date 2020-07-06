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
 * Platform specific contextual information under which the service instance is to be provisioned.
 */
public class Context extends GenericModel {

  @SerializedName("account_id")
  protected String accountId;
  protected String crn;
  protected String platform;

  /**
   * Builder.
   */
  public static class Builder {
    private String accountId;
    private String crn;
    private String platform;

    private Builder(Context context) {
      this.accountId = context.accountId;
      this.crn = context.crn;
      this.platform = context.platform;
    }

    /**
     * Instantiates a new builder.
     */
    public Builder() {
    }

    /**
     * Builds a Context.
     *
     * @return the new Context instance
     */
    public Context build() {
      return new Context(this);
    }

    /**
     * Set the accountId.
     *
     * @param accountId the accountId
     * @return the Context builder
     */
    public Builder accountId(String accountId) {
      this.accountId = accountId;
      return this;
    }

    /**
     * Set the crn.
     *
     * @param crn the crn
     * @return the Context builder
     */
    public Builder crn(String crn) {
      this.crn = crn;
      return this;
    }

    /**
     * Set the platform.
     *
     * @param platform the platform
     * @return the Context builder
     */
    public Builder platform(String platform) {
      this.platform = platform;
      return this;
    }
  }

  protected Context(Builder builder) {
    accountId = builder.accountId;
    crn = builder.crn;
    platform = builder.platform;
  }

  /**
   * New builder.
   *
   * @return a Context builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the accountId.
   *
   * Returns the ID of the account in IBM Cloud that is provisioning the service instance.
   *
   * @return the accountId
   */
  public String accountId() {
    return accountId;
  }

  /**
   * Gets the crn.
   *
   * When a customer provisions your service in IBM Cloud, a service instance is created and this instance is identified
   * by its IBM Cloud Resource Name (CRN). The CRN is utilized in all aspects of the interaction with IBM Cloud
   * including provisioning, binding (creating credentials and endpoints), metering, dashboard display, and access
   * control. From a service provider perspective, the CRN can largely be treated as an opaque string to be utilized
   * with the IBM Cloud APIs, but it can also be decomposed via the following structure:
   * `crn:version:cname:ctype:service-name:location:scope:service-instance:resource-type:resource`.
   *
   * @return the crn
   */
  public String crn() {
    return crn;
  }

  /**
   * Gets the platform.
   *
   * Identifies the platform as "ibmcloud".
   *
   * @return the platform
   */
  public String platform() {
    return platform;
  }
}

