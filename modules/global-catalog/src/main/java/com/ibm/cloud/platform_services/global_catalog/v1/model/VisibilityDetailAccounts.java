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

import com.google.gson.annotations.SerializedName;
import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * Information related to the accounts for which a catalog entry is visible.
 */
public class VisibilityDetailAccounts extends GenericModel {

  @SerializedName("_accountid_")
  protected String accountid;

  /**
   * Builder.
   */
  public static class Builder {
    private String accountid;

    /**
     * Instantiates a new Builder from an existing VisibilityDetailAccounts instance.
     *
     * @param visibilityDetailAccounts the instance to initialize the Builder with
     */
    private Builder(VisibilityDetailAccounts visibilityDetailAccounts) {
      this.accountid = visibilityDetailAccounts.accountid;
    }

    /**
     * Instantiates a new builder.
     */
    public Builder() {
    }

    /**
     * Builds a VisibilityDetailAccounts.
     *
     * @return the new VisibilityDetailAccounts instance
     */
    public VisibilityDetailAccounts build() {
      return new VisibilityDetailAccounts(this);
    }

    /**
     * Set the accountid.
     *
     * @param accountid the accountid
     * @return the VisibilityDetailAccounts builder
     */
    public Builder accountid(String accountid) {
      this.accountid = accountid;
      return this;
    }
  }

  protected VisibilityDetailAccounts() { }

  protected VisibilityDetailAccounts(Builder builder) {
    accountid = builder.accountid;
  }

  /**
   * New builder.
   *
   * @return a VisibilityDetailAccounts builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the accountid.
   *
   * (_accountid_) is the GUID of the account and the value is the scope of who set it. For setting visibility use "" as
   * the value. It is replaced with the owner scope when saved.
   *
   * @return the accountid
   */
  public String accountid() {
    return accountid;
  }
}

