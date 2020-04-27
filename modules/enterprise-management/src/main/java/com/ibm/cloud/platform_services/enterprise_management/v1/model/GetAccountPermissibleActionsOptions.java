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
package com.ibm.cloud.platform_services.enterprise_management.v1.model;

import java.util.ArrayList;
import java.util.List;

import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * The getAccountPermissibleActions options.
 */
public class GetAccountPermissibleActionsOptions extends GenericModel {

  protected String accountId;
  protected List<String> actions;

  /**
   * Builder.
   */
  public static class Builder {
    private String accountId;
    private List<String> actions;

    private Builder(GetAccountPermissibleActionsOptions getAccountPermissibleActionsOptions) {
      this.accountId = getAccountPermissibleActionsOptions.accountId;
      this.actions = getAccountPermissibleActionsOptions.actions;
    }

    /**
     * Instantiates a new builder.
     */
    public Builder() {
    }

    /**
     * Instantiates a new builder with required properties.
     *
     * @param accountId the accountId
     */
    public Builder(String accountId) {
      this.accountId = accountId;
    }

    /**
     * Builds a GetAccountPermissibleActionsOptions.
     *
     * @return the new GetAccountPermissibleActionsOptions instance
     */
    public GetAccountPermissibleActionsOptions build() {
      return new GetAccountPermissibleActionsOptions(this);
    }

    /**
     * Adds an actions to actions.
     *
     * @param actions the new actions
     * @return the GetAccountPermissibleActionsOptions builder
     */
    public Builder addActions(String actions) {
      com.ibm.cloud.sdk.core.util.Validator.notNull(actions,
        "actions cannot be null");
      if (this.actions == null) {
        this.actions = new ArrayList<String>();
      }
      this.actions.add(actions);
      return this;
    }

    /**
     * Set the accountId.
     *
     * @param accountId the accountId
     * @return the GetAccountPermissibleActionsOptions builder
     */
    public Builder accountId(String accountId) {
      this.accountId = accountId;
      return this;
    }

    /**
     * Set the actions.
     * Existing actions will be replaced.
     *
     * @param actions the actions
     * @return the GetAccountPermissibleActionsOptions builder
     */
    public Builder actions(List<String> actions) {
      this.actions = actions;
      return this;
    }
  }

  protected GetAccountPermissibleActionsOptions(Builder builder) {
    com.ibm.cloud.sdk.core.util.Validator.notEmpty(builder.accountId,
      "accountId cannot be empty");
    accountId = builder.accountId;
    actions = builder.actions;
  }

  /**
   * New builder.
   *
   * @return a GetAccountPermissibleActionsOptions builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the accountId.
   *
   * The ID of the account to check for permissible actions.
   *
   * @return the accountId
   */
  public String accountId() {
    return accountId;
  }

  /**
   * Gets the actions.
   *
   * A list of names of permissible actions.
   *
   * @return the actions
   */
  public List<String> actions() {
    return actions;
  }
}

