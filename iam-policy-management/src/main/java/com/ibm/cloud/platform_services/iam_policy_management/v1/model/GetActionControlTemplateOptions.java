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

import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * The getActionControlTemplate options.
 */
public class GetActionControlTemplateOptions extends GenericModel {

  /**
   * The action control template state.
   */
  public interface State {
    /** active. */
    String ACTIVE = "active";
    /** deleted. */
    String DELETED = "deleted";
  }

  protected String actionControlTemplateId;
  protected String state;

  /**
   * Builder.
   */
  public static class Builder {
    private String actionControlTemplateId;
    private String state;

    /**
     * Instantiates a new Builder from an existing GetActionControlTemplateOptions instance.
     *
     * @param getActionControlTemplateOptions the instance to initialize the Builder with
     */
    private Builder(GetActionControlTemplateOptions getActionControlTemplateOptions) {
      this.actionControlTemplateId = getActionControlTemplateOptions.actionControlTemplateId;
      this.state = getActionControlTemplateOptions.state;
    }

    /**
     * Instantiates a new builder.
     */
    public Builder() {
    }

    /**
     * Instantiates a new builder with required properties.
     *
     * @param actionControlTemplateId the actionControlTemplateId
     */
    public Builder(String actionControlTemplateId) {
      this.actionControlTemplateId = actionControlTemplateId;
    }

    /**
     * Builds a GetActionControlTemplateOptions.
     *
     * @return the new GetActionControlTemplateOptions instance
     */
    public GetActionControlTemplateOptions build() {
      return new GetActionControlTemplateOptions(this);
    }

    /**
     * Set the actionControlTemplateId.
     *
     * @param actionControlTemplateId the actionControlTemplateId
     * @return the GetActionControlTemplateOptions builder
     */
    public Builder actionControlTemplateId(String actionControlTemplateId) {
      this.actionControlTemplateId = actionControlTemplateId;
      return this;
    }

    /**
     * Set the state.
     *
     * @param state the state
     * @return the GetActionControlTemplateOptions builder
     */
    public Builder state(String state) {
      this.state = state;
      return this;
    }
  }

  protected GetActionControlTemplateOptions() { }

  protected GetActionControlTemplateOptions(Builder builder) {
    com.ibm.cloud.sdk.core.util.Validator.notEmpty(builder.actionControlTemplateId,
      "actionControlTemplateId cannot be empty");
    actionControlTemplateId = builder.actionControlTemplateId;
    state = builder.state;
  }

  /**
   * New builder.
   *
   * @return a GetActionControlTemplateOptions builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the actionControlTemplateId.
   *
   * Action control template ID.
   *
   * @return the actionControlTemplateId
   */
  public String actionControlTemplateId() {
    return actionControlTemplateId;
  }

  /**
   * Gets the state.
   *
   * The action control template state.
   *
   * @return the state
   */
  public String state() {
    return state;
  }
}

