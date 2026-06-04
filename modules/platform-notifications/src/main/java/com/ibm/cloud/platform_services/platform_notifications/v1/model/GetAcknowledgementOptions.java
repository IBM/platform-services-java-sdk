/*
 * (C) Copyright IBM Corp. 2026.
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

package com.ibm.cloud.platform_services.platform_notifications.v1.model;

import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * The getAcknowledgement options.
 */
public class GetAcknowledgementOptions extends GenericModel {

  protected String accountId;

  /**
   * Builder.
   */
  public static class Builder {
    private String accountId;

    /**
     * Instantiates a new Builder from an existing GetAcknowledgementOptions instance.
     *
     * @param getAcknowledgementOptions the instance to initialize the Builder with
     */
    private Builder(GetAcknowledgementOptions getAcknowledgementOptions) {
      this.accountId = getAcknowledgementOptions.accountId;
    }

    /**
     * Instantiates a new builder.
     */
    public Builder() {
    }

    /**
     * Builds a GetAcknowledgementOptions.
     *
     * @return the new GetAcknowledgementOptions instance
     */
    public GetAcknowledgementOptions build() {
      return new GetAcknowledgementOptions(this);
    }

    /**
     * Set the accountId.
     *
     * @param accountId the accountId
     * @return the GetAcknowledgementOptions builder
     */
    public Builder accountId(String accountId) {
      this.accountId = accountId;
      return this;
    }
  }

  protected GetAcknowledgementOptions() { }

  protected GetAcknowledgementOptions(Builder builder) {
    accountId = builder.accountId;
  }

  /**
   * New builder.
   *
   * @return a GetAcknowledgementOptions builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the accountId.
   *
   * The IBM Cloud account ID. If not provided, the account ID from the bearer token will be used.
   *
   * @return the accountId
   */
  public String accountId() {
    return accountId;
  }
}

