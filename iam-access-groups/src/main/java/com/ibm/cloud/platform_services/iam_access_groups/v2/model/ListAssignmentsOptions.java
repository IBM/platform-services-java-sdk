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
package com.ibm.cloud.platform_services.iam_access_groups.v2.model;

import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * The listAssignments options.
 */
public class ListAssignmentsOptions extends GenericModel {

  protected String accountId;

  /**
   * Builder.
   */
  public static class Builder {
    private String accountId;

    /**
     * Instantiates a new Builder from an existing ListAssignmentsOptions instance.
     *
     * @param listAssignmentsOptions the instance to initialize the Builder with
     */
    private Builder(ListAssignmentsOptions listAssignmentsOptions) {
      this.accountId = listAssignmentsOptions.accountId;
    }

    /**
     * Instantiates a new builder.
     */
    public Builder() {
    }

    /**
     * Builds a ListAssignmentsOptions.
     *
     * @return the new ListAssignmentsOptions instance
     */
    public ListAssignmentsOptions build() {
      return new ListAssignmentsOptions(this);
    }

    /**
     * Set the accountId.
     *
     * @param accountId the accountId
     * @return the ListAssignmentsOptions builder
     */
    public Builder accountId(String accountId) {
      this.accountId = accountId;
      return this;
    }
  }

  protected ListAssignmentsOptions() { }

  protected ListAssignmentsOptions(Builder builder) {
    accountId = builder.accountId;
  }

  /**
   * New builder.
   *
   * @return a ListAssignmentsOptions builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the accountId.
   *
   * query parameter account id.
   *
   * @return the accountId
   */
  public String accountId() {
    return accountId;
  }
}

