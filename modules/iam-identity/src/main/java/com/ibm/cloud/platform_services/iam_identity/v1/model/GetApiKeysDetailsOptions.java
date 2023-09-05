/*
 * (C) Copyright IBM Corp. 2023.
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
 * The getApiKeysDetails options.
 */
public class GetApiKeysDetailsOptions extends GenericModel {

  protected String iamApiKey;
  protected Boolean includeHistory;

  /**
   * Builder.
   */
  public static class Builder {
    private String iamApiKey;
    private Boolean includeHistory;

    /**
     * Instantiates a new Builder from an existing GetApiKeysDetailsOptions instance.
     *
     * @param getApiKeysDetailsOptions the instance to initialize the Builder with
     */
    private Builder(GetApiKeysDetailsOptions getApiKeysDetailsOptions) {
      this.iamApiKey = getApiKeysDetailsOptions.iamApiKey;
      this.includeHistory = getApiKeysDetailsOptions.includeHistory;
    }

    /**
     * Instantiates a new builder.
     */
    public Builder() {
    }

    /**
     * Builds a GetApiKeysDetailsOptions.
     *
     * @return the new GetApiKeysDetailsOptions instance
     */
    public GetApiKeysDetailsOptions build() {
      return new GetApiKeysDetailsOptions(this);
    }

    /**
     * Set the iamApiKey.
     *
     * @param iamApiKey the iamApiKey
     * @return the GetApiKeysDetailsOptions builder
     */
    public Builder iamApiKey(String iamApiKey) {
      this.iamApiKey = iamApiKey;
      return this;
    }

    /**
     * Set the includeHistory.
     *
     * @param includeHistory the includeHistory
     * @return the GetApiKeysDetailsOptions builder
     */
    public Builder includeHistory(Boolean includeHistory) {
      this.includeHistory = includeHistory;
      return this;
    }
  }

  protected GetApiKeysDetailsOptions() { }

  protected GetApiKeysDetailsOptions(Builder builder) {
    iamApiKey = builder.iamApiKey;
    includeHistory = builder.includeHistory;
  }

  /**
   * New builder.
   *
   * @return a GetApiKeysDetailsOptions builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the iamApiKey.
   *
   * API key value.
   *
   * @return the iamApiKey
   */
  public String iamApiKey() {
    return iamApiKey;
  }

  /**
   * Gets the includeHistory.
   *
   * Defines if the entity history is included in the response.
   *
   * @return the includeHistory
   */
  public Boolean includeHistory() {
    return includeHistory;
  }
}

