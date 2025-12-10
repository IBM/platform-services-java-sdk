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

package com.ibm.cloud.platform_services.iam_policy_management.v1.model;

import java.util.ArrayList;
import java.util.List;

import com.google.gson.annotations.SerializedName;
import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * The core set of properties associated with an identity type.
 */
public class IdentityTypesBase extends GenericModel {

  /**
   * The state of the identity type.
   */
  public interface State {
    /** enabled. */
    String ENABLED = "enabled";
    /** monitor. */
    String MONITOR = "monitor";
    /** limited. */
    String LIMITED = "limited";
  }

  protected String state;
  @SerializedName("external_allowed_accounts")
  protected List<String> externalAllowedAccounts;

  /**
   * Builder.
   */
  public static class Builder {
    private String state;
    private List<String> externalAllowedAccounts;

    /**
     * Instantiates a new Builder from an existing IdentityTypesBase instance.
     *
     * @param identityTypesBase the instance to initialize the Builder with
     */
    private Builder(IdentityTypesBase identityTypesBase) {
      this.state = identityTypesBase.state;
      this.externalAllowedAccounts = identityTypesBase.externalAllowedAccounts;
    }

    /**
     * Instantiates a new builder.
     */
    public Builder() {
    }

    /**
     * Instantiates a new builder with required properties.
     *
     * @param state the state
     * @param externalAllowedAccounts the externalAllowedAccounts
     */
    public Builder(String state, List<String> externalAllowedAccounts) {
      this.state = state;
      this.externalAllowedAccounts = externalAllowedAccounts;
    }

    /**
     * Builds a IdentityTypesBase.
     *
     * @return the new IdentityTypesBase instance
     */
    public IdentityTypesBase build() {
      return new IdentityTypesBase(this);
    }

    /**
     * Adds a new element to externalAllowedAccounts.
     *
     * @param externalAllowedAccounts the new element to be added
     * @return the IdentityTypesBase builder
     */
    public Builder addExternalAllowedAccounts(String externalAllowedAccounts) {
      com.ibm.cloud.sdk.core.util.Validator.notNull(externalAllowedAccounts,
        "externalAllowedAccounts cannot be null");
      if (this.externalAllowedAccounts == null) {
        this.externalAllowedAccounts = new ArrayList<String>();
      }
      this.externalAllowedAccounts.add(externalAllowedAccounts);
      return this;
    }

    /**
     * Set the state.
     *
     * @param state the state
     * @return the IdentityTypesBase builder
     */
    public Builder state(String state) {
      this.state = state;
      return this;
    }

    /**
     * Set the externalAllowedAccounts.
     * Existing externalAllowedAccounts will be replaced.
     *
     * @param externalAllowedAccounts the externalAllowedAccounts
     * @return the IdentityTypesBase builder
     */
    public Builder externalAllowedAccounts(List<String> externalAllowedAccounts) {
      this.externalAllowedAccounts = externalAllowedAccounts;
      return this;
    }
  }

  protected IdentityTypesBase() { }

  protected IdentityTypesBase(Builder builder) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.state,
      "state cannot be null");
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.externalAllowedAccounts,
      "externalAllowedAccounts cannot be null");
    state = builder.state;
    externalAllowedAccounts = builder.externalAllowedAccounts;
  }

  /**
   * New builder.
   *
   * @return a IdentityTypesBase builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the state.
   *
   * The state of the identity type.
   *
   * @return the state
   */
  public String state() {
    return state;
  }

  /**
   * Gets the externalAllowedAccounts.
   *
   * List of accounts that the state applies to for a given identity.
   *
   * @return the externalAllowedAccounts
   */
  public List<String> externalAllowedAccounts() {
    return externalAllowedAccounts;
  }
}

