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
 * Control whether or not child account administrators can update and remove dynamic rules from the enterprise-managed
 * access group in their account. These action controls will override outer level action controls.
 */
public class RulesActionControls extends GenericModel {

  protected Boolean remove;
  protected Boolean update;

  /**
   * Builder.
   */
  public static class Builder {
    private Boolean remove;
    private Boolean update;

    /**
     * Instantiates a new Builder from an existing RulesActionControls instance.
     *
     * @param rulesActionControls the instance to initialize the Builder with
     */
    private Builder(RulesActionControls rulesActionControls) {
      this.remove = rulesActionControls.remove;
      this.update = rulesActionControls.update;
    }

    /**
     * Instantiates a new builder.
     */
    public Builder() {
    }

    /**
     * Builds a RulesActionControls.
     *
     * @return the new RulesActionControls instance
     */
    public RulesActionControls build() {
      return new RulesActionControls(this);
    }

    /**
     * Set the remove.
     *
     * @param remove the remove
     * @return the RulesActionControls builder
     */
    public Builder remove(Boolean remove) {
      this.remove = remove;
      return this;
    }

    /**
     * Set the update.
     *
     * @param update the update
     * @return the RulesActionControls builder
     */
    public Builder update(Boolean update) {
      this.update = update;
      return this;
    }
  }

  protected RulesActionControls() { }

  protected RulesActionControls(Builder builder) {
    remove = builder.remove;
    update = builder.update;
  }

  /**
   * New builder.
   *
   * @return a RulesActionControls builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the remove.
   *
   * Action control for removing enterprise-managed dynamic rule in an enterprise-managed access group.
   *
   * @return the remove
   */
  public Boolean remove() {
    return remove;
  }

  /**
   * Gets the update.
   *
   * Action control for updating enterprise-managed dynamic rule in an enterprise-managed access group.
   *
   * @return the update
   */
  public Boolean update() {
    return update;
  }
}

