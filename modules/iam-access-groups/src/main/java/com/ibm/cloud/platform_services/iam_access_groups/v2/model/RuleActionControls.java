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
 * Control whether or not access group administrators in child accounts can update and remove this dynamic rule in the
 * enterprise-managed access group in their account.This overrides outer level AssertionsActionControls.
 */
public class RuleActionControls extends GenericModel {

  protected Boolean remove;

  /**
   * Builder.
   */
  public static class Builder {
    private Boolean remove;

    /**
     * Instantiates a new Builder from an existing RuleActionControls instance.
     *
     * @param ruleActionControls the instance to initialize the Builder with
     */
    private Builder(RuleActionControls ruleActionControls) {
      this.remove = ruleActionControls.remove;
    }

    /**
     * Instantiates a new builder.
     */
    public Builder() {
    }

    /**
     * Builds a RuleActionControls.
     *
     * @return the new RuleActionControls instance
     */
    public RuleActionControls build() {
      return new RuleActionControls(this);
    }

    /**
     * Set the remove.
     *
     * @param remove the remove
     * @return the RuleActionControls builder
     */
    public Builder remove(Boolean remove) {
      this.remove = remove;
      return this;
    }
  }

  protected RuleActionControls() { }

  protected RuleActionControls(Builder builder) {
    remove = builder.remove;
  }

  /**
   * New builder.
   *
   * @return a RuleActionControls builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the remove.
   *
   * Action control for removing this enterprise-managed dynamic rule.
   *
   * @return the remove
   */
  public Boolean remove() {
    return remove;
  }
}

