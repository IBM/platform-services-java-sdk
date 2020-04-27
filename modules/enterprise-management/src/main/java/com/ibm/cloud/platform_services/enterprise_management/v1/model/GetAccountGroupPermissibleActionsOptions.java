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
 * The getAccountGroupPermissibleActions options.
 */
public class GetAccountGroupPermissibleActionsOptions extends GenericModel {

  protected String accountGroupId;
  protected List<String> actions;

  /**
   * Builder.
   */
  public static class Builder {
    private String accountGroupId;
    private List<String> actions;

    private Builder(GetAccountGroupPermissibleActionsOptions getAccountGroupPermissibleActionsOptions) {
      this.accountGroupId = getAccountGroupPermissibleActionsOptions.accountGroupId;
      this.actions = getAccountGroupPermissibleActionsOptions.actions;
    }

    /**
     * Instantiates a new builder.
     */
    public Builder() {
    }

    /**
     * Instantiates a new builder with required properties.
     *
     * @param accountGroupId the accountGroupId
     */
    public Builder(String accountGroupId) {
      this.accountGroupId = accountGroupId;
    }

    /**
     * Builds a GetAccountGroupPermissibleActionsOptions.
     *
     * @return the new GetAccountGroupPermissibleActionsOptions instance
     */
    public GetAccountGroupPermissibleActionsOptions build() {
      return new GetAccountGroupPermissibleActionsOptions(this);
    }

    /**
     * Adds an actions to actions.
     *
     * @param actions the new actions
     * @return the GetAccountGroupPermissibleActionsOptions builder
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
     * Set the accountGroupId.
     *
     * @param accountGroupId the accountGroupId
     * @return the GetAccountGroupPermissibleActionsOptions builder
     */
    public Builder accountGroupId(String accountGroupId) {
      this.accountGroupId = accountGroupId;
      return this;
    }

    /**
     * Set the actions.
     * Existing actions will be replaced.
     *
     * @param actions the actions
     * @return the GetAccountGroupPermissibleActionsOptions builder
     */
    public Builder actions(List<String> actions) {
      this.actions = actions;
      return this;
    }
  }

  protected GetAccountGroupPermissibleActionsOptions(Builder builder) {
    com.ibm.cloud.sdk.core.util.Validator.notEmpty(builder.accountGroupId,
      "accountGroupId cannot be empty");
    accountGroupId = builder.accountGroupId;
    actions = builder.actions;
  }

  /**
   * New builder.
   *
   * @return a GetAccountGroupPermissibleActionsOptions builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the accountGroupId.
   *
   * The ID of the account group to check for permissible actions.
   *
   * @return the accountGroupId
   */
  public String accountGroupId() {
    return accountGroupId;
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

