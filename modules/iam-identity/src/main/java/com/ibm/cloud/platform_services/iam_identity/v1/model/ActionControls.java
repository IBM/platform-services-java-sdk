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

package com.ibm.cloud.platform_services.iam_identity.v1.model;

import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * ActionControls.
 */
public class ActionControls extends GenericModel {

  protected ActionControlsIdentities identities;
  protected ActionControlsRules rules;
  protected ActionControlsPolicies policies;

  /**
   * Builder.
   */
  public static class Builder {
    private ActionControlsIdentities identities;
    private ActionControlsRules rules;
    private ActionControlsPolicies policies;

    /**
     * Instantiates a new Builder from an existing ActionControls instance.
     *
     * @param actionControls the instance to initialize the Builder with
     */
    private Builder(ActionControls actionControls) {
      this.identities = actionControls.identities;
      this.rules = actionControls.rules;
      this.policies = actionControls.policies;
    }

    /**
     * Instantiates a new builder.
     */
    public Builder() {
    }

    /**
     * Instantiates a new builder with required properties.
     *
     * @param rules the rules
     * @param policies the policies
     */
    public Builder(ActionControlsRules rules, ActionControlsPolicies policies) {
      this.rules = rules;
      this.policies = policies;
    }

    /**
     * Builds a ActionControls.
     *
     * @return the new ActionControls instance
     */
    public ActionControls build() {
      return new ActionControls(this);
    }

    /**
     * Set the identities.
     *
     * @param identities the identities
     * @return the ActionControls builder
     */
    public Builder identities(ActionControlsIdentities identities) {
      this.identities = identities;
      return this;
    }

    /**
     * Set the rules.
     *
     * @param rules the rules
     * @return the ActionControls builder
     */
    public Builder rules(ActionControlsRules rules) {
      this.rules = rules;
      return this;
    }

    /**
     * Set the policies.
     *
     * @param policies the policies
     * @return the ActionControls builder
     */
    public Builder policies(ActionControlsPolicies policies) {
      this.policies = policies;
      return this;
    }
  }

  protected ActionControls() { }

  protected ActionControls(Builder builder) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.rules,
      "rules cannot be null");
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.policies,
      "policies cannot be null");
    identities = builder.identities;
    rules = builder.rules;
    policies = builder.policies;
  }

  /**
   * New builder.
   *
   * @return a ActionControls builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the identities.
   *
   * @return the identities
   */
  public ActionControlsIdentities identities() {
    return identities;
  }

  /**
   * Gets the rules.
   *
   * @return the rules
   */
  public ActionControlsRules rules() {
    return rules;
  }

  /**
   * Gets the policies.
   *
   * @return the policies
   */
  public ActionControlsPolicies policies() {
    return policies;
  }
}

