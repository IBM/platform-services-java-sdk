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
 * The getEnterprisePermissibleActions options.
 */
public class GetEnterprisePermissibleActionsOptions extends GenericModel {

  protected String enterpriseId;
  protected List<String> actions;

  /**
   * Builder.
   */
  public static class Builder {
    private String enterpriseId;
    private List<String> actions;

    private Builder(GetEnterprisePermissibleActionsOptions getEnterprisePermissibleActionsOptions) {
      this.enterpriseId = getEnterprisePermissibleActionsOptions.enterpriseId;
      this.actions = getEnterprisePermissibleActionsOptions.actions;
    }

    /**
     * Instantiates a new builder.
     */
    public Builder() {
    }

    /**
     * Instantiates a new builder with required properties.
     *
     * @param enterpriseId the enterpriseId
     */
    public Builder(String enterpriseId) {
      this.enterpriseId = enterpriseId;
    }

    /**
     * Builds a GetEnterprisePermissibleActionsOptions.
     *
     * @return the new GetEnterprisePermissibleActionsOptions instance
     */
    public GetEnterprisePermissibleActionsOptions build() {
      return new GetEnterprisePermissibleActionsOptions(this);
    }

    /**
     * Adds an actions to actions.
     *
     * @param actions the new actions
     * @return the GetEnterprisePermissibleActionsOptions builder
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
     * Set the enterpriseId.
     *
     * @param enterpriseId the enterpriseId
     * @return the GetEnterprisePermissibleActionsOptions builder
     */
    public Builder enterpriseId(String enterpriseId) {
      this.enterpriseId = enterpriseId;
      return this;
    }

    /**
     * Set the actions.
     * Existing actions will be replaced.
     *
     * @param actions the actions
     * @return the GetEnterprisePermissibleActionsOptions builder
     */
    public Builder actions(List<String> actions) {
      this.actions = actions;
      return this;
    }
  }

  protected GetEnterprisePermissibleActionsOptions(Builder builder) {
    com.ibm.cloud.sdk.core.util.Validator.notEmpty(builder.enterpriseId,
      "enterpriseId cannot be empty");
    enterpriseId = builder.enterpriseId;
    actions = builder.actions;
  }

  /**
   * New builder.
   *
   * @return a GetEnterprisePermissibleActionsOptions builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the enterpriseId.
   *
   * The ID of the enterprise to check for permissible actions.
   *
   * @return the enterpriseId
   */
  public String enterpriseId() {
    return enterpriseId;
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

