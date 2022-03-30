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
package com.ibm.cloud.platform_services.iam_identity.v1.model;

import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * The getServiceId options.
 */
public class GetServiceIdOptions extends GenericModel {

  protected String id;
  protected Boolean includeHistory;
  protected Boolean includeActivity;

  /**
   * Builder.
   */
  public static class Builder {
    private String id;
    private Boolean includeHistory;
    private Boolean includeActivity;

    private Builder(GetServiceIdOptions getServiceIdOptions) {
      this.id = getServiceIdOptions.id;
      this.includeHistory = getServiceIdOptions.includeHistory;
      this.includeActivity = getServiceIdOptions.includeActivity;
    }

    /**
     * Instantiates a new builder.
     */
    public Builder() {
    }

    /**
     * Instantiates a new builder with required properties.
     *
     * @param id the id
     */
    public Builder(String id) {
      this.id = id;
    }

    /**
     * Builds a GetServiceIdOptions.
     *
     * @return the new GetServiceIdOptions instance
     */
    public GetServiceIdOptions build() {
      return new GetServiceIdOptions(this);
    }

    /**
     * Set the id.
     *
     * @param id the id
     * @return the GetServiceIdOptions builder
     */
    public Builder id(String id) {
      this.id = id;
      return this;
    }

    /**
     * Set the includeHistory.
     *
     * @param includeHistory the includeHistory
     * @return the GetServiceIdOptions builder
     */
    public Builder includeHistory(Boolean includeHistory) {
      this.includeHistory = includeHistory;
      return this;
    }

    /**
     * Set the includeActivity.
     *
     * @param includeActivity the includeActivity
     * @return the GetServiceIdOptions builder
     */
    public Builder includeActivity(Boolean includeActivity) {
      this.includeActivity = includeActivity;
      return this;
    }
  }

  protected GetServiceIdOptions(Builder builder) {
    com.ibm.cloud.sdk.core.util.Validator.notEmpty(builder.id,
      "id cannot be empty");
    id = builder.id;
    includeHistory = builder.includeHistory;
    includeActivity = builder.includeActivity;
  }

  /**
   * New builder.
   *
   * @return a GetServiceIdOptions builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the id.
   *
   * Unique ID of the service ID.
   *
   * @return the id
   */
  public String id() {
    return id;
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

  /**
   * Gets the includeActivity.
   *
   * Defines if the entity's activity is included in the response. Retrieving activity data is an expensive operation,
   * so please only request this when needed.
   *
   * @return the includeActivity
   */
  public Boolean includeActivity() {
    return includeActivity;
  }
}

