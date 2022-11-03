/*
 * (C) Copyright IBM Corp. 2022.
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
package com.ibm.cloud.platform_services.resource_controller.v2.model;

import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * The listReclamations options.
 */
public class ListReclamationsOptions extends GenericModel {

  protected String accountId;
  protected String resourceInstanceId;

  /**
   * Builder.
   */
  public static class Builder {
    private String accountId;
    private String resourceInstanceId;

    /**
     * Instantiates a new Builder from an existing ListReclamationsOptions instance.
     *
     * @param listReclamationsOptions the instance to initialize the Builder with
     */
    private Builder(ListReclamationsOptions listReclamationsOptions) {
      this.accountId = listReclamationsOptions.accountId;
      this.resourceInstanceId = listReclamationsOptions.resourceInstanceId;
    }

    /**
     * Instantiates a new builder.
     */
    public Builder() {
    }

    /**
     * Builds a ListReclamationsOptions.
     *
     * @return the new ListReclamationsOptions instance
     */
    public ListReclamationsOptions build() {
      return new ListReclamationsOptions(this);
    }

    /**
     * Set the accountId.
     *
     * @param accountId the accountId
     * @return the ListReclamationsOptions builder
     */
    public Builder accountId(String accountId) {
      this.accountId = accountId;
      return this;
    }

    /**
     * Set the resourceInstanceId.
     *
     * @param resourceInstanceId the resourceInstanceId
     * @return the ListReclamationsOptions builder
     */
    public Builder resourceInstanceId(String resourceInstanceId) {
      this.resourceInstanceId = resourceInstanceId;
      return this;
    }
  }

  protected ListReclamationsOptions() { }

  protected ListReclamationsOptions(Builder builder) {
    accountId = builder.accountId;
    resourceInstanceId = builder.resourceInstanceId;
  }

  /**
   * New builder.
   *
   * @return a ListReclamationsOptions builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the accountId.
   *
   * An alpha-numeric value identifying the account ID.
   *
   * @return the accountId
   */
  public String accountId() {
    return accountId;
  }

  /**
   * Gets the resourceInstanceId.
   *
   * The GUID of the resource instance.
   *
   * @return the resourceInstanceId
   */
  public String resourceInstanceId() {
    return resourceInstanceId;
  }
}

