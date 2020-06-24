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
 * Bind a resource.
 */
public class BindResource extends GenericModel {

  @SerializedName("account_id")
  protected String accountId;
  @SerializedName("serviceid_crn")
  protected String serviceidCrn;
  @SerializedName("target_crn")
  protected String targetCrn;

  /**
   * Builder.
   */
  public static class Builder {
    private String accountId;
    private String serviceidCrn;
    private String targetCrn;

    private Builder(BindResource bindResource) {
      this.accountId = bindResource.accountId;
      this.serviceidCrn = bindResource.serviceidCrn;
      this.targetCrn = bindResource.targetCrn;
    }

    /**
     * Instantiates a new builder.
     */
    public Builder() {
    }

    /**
     * Builds a BindResource.
     *
     * @return the new BindResource instance
     */
    public BindResource build() {
      return new BindResource(this);
    }

    /**
     * Set the accountId.
     *
     * @param accountId the accountId
     * @return the BindResource builder
     */
    public Builder accountId(String accountId) {
      this.accountId = accountId;
      return this;
    }

    /**
     * Set the serviceidCrn.
     *
     * @param serviceidCrn the serviceidCrn
     * @return the BindResource builder
     */
    public Builder serviceidCrn(String serviceidCrn) {
      this.serviceidCrn = serviceidCrn;
      return this;
    }

    /**
     * Set the targetCrn.
     *
     * @param targetCrn the targetCrn
     * @return the BindResource builder
     */
    public Builder targetCrn(String targetCrn) {
      this.targetCrn = targetCrn;
      return this;
    }
  }

  protected BindResource(Builder builder) {
    accountId = builder.accountId;
    serviceidCrn = builder.serviceidCrn;
    targetCrn = builder.targetCrn;
  }

  /**
   * New builder.
   *
   * @return a BindResource builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the accountId.
   *
   * Account owner of resource to bind.
   *
   * @return the accountId
   */
  public String accountId() {
    return accountId;
  }

  /**
   * Gets the serviceidCrn.
   *
   * Service ID of resource to bind.
   *
   * @return the serviceidCrn
   */
  public String serviceidCrn() {
    return serviceidCrn;
  }

  /**
   * Gets the targetCrn.
   *
   * Target ID of resource to bind.
   *
   * @return the targetCrn
   */
  public String targetCrn() {
    return targetCrn;
  }
}

