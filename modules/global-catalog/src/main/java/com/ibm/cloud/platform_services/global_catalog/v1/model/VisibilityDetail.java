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

package com.ibm.cloud.platform_services.global_catalog.v1.model;

import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * Visibility details related to a catalog entry.
 */
public class VisibilityDetail extends GenericModel {

  protected VisibilityDetailAccounts accounts;

  /**
   * Builder.
   */
  public static class Builder {
    private VisibilityDetailAccounts accounts;

    /**
     * Instantiates a new Builder from an existing VisibilityDetail instance.
     *
     * @param visibilityDetail the instance to initialize the Builder with
     */
    private Builder(VisibilityDetail visibilityDetail) {
      this.accounts = visibilityDetail.accounts;
    }

    /**
     * Instantiates a new builder.
     */
    public Builder() {
    }

    /**
     * Instantiates a new builder with required properties.
     *
     * @param accounts the accounts
     */
    public Builder(VisibilityDetailAccounts accounts) {
      this.accounts = accounts;
    }

    /**
     * Builds a VisibilityDetail.
     *
     * @return the new VisibilityDetail instance
     */
    public VisibilityDetail build() {
      return new VisibilityDetail(this);
    }

    /**
     * Set the accounts.
     *
     * @param accounts the accounts
     * @return the VisibilityDetail builder
     */
    public Builder accounts(VisibilityDetailAccounts accounts) {
      this.accounts = accounts;
      return this;
    }
  }

  protected VisibilityDetail() { }

  protected VisibilityDetail(Builder builder) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.accounts,
      "accounts cannot be null");
    accounts = builder.accounts;
  }

  /**
   * New builder.
   *
   * @return a VisibilityDetail builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the accounts.
   *
   * Information related to the accounts for which a catalog entry is visible.
   *
   * @return the accounts
   */
  public VisibilityDetailAccounts accounts() {
    return accounts;
  }
}

