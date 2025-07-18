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

package com.ibm.cloud.platform_services.iam_identity.v1.model;

import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * The listServiceIdGroup options.
 */
public class ListServiceIdGroupOptions extends GenericModel {

  protected String accountId;

  /**
   * Builder.
   */
  public static class Builder {
    private String accountId;

    /**
     * Instantiates a new Builder from an existing ListServiceIdGroupOptions instance.
     *
     * @param listServiceIdGroupOptions the instance to initialize the Builder with
     */
    private Builder(ListServiceIdGroupOptions listServiceIdGroupOptions) {
      this.accountId = listServiceIdGroupOptions.accountId;
    }

    /**
     * Instantiates a new builder.
     */
    public Builder() {
    }

    /**
     * Builds a ListServiceIdGroupOptions.
     *
     * @return the new ListServiceIdGroupOptions instance
     */
    public ListServiceIdGroupOptions build() {
      return new ListServiceIdGroupOptions(this);
    }

    /**
     * Set the accountId.
     *
     * @param accountId the accountId
     * @return the ListServiceIdGroupOptions builder
     */
    public Builder accountId(String accountId) {
      this.accountId = accountId;
      return this;
    }
  }

  protected ListServiceIdGroupOptions() { }

  protected ListServiceIdGroupOptions(Builder builder) {
    accountId = builder.accountId;
  }

  /**
   * New builder.
   *
   * @return a ListServiceIdGroupOptions builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the accountId.
   *
   * Account ID of the service ID groups to query.
   *
   * @return the accountId
   */
  public String accountId() {
    return accountId;
  }
}

