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
 * Control whether or not access group administrators in child accounts can add, remove, and update dynamic rules for
 * the enterprise-managed access group in their account. The inner level RuleActionControls override these `remove` and
 * `update` action controls.
 */
public class AssertionsActionControls extends GenericModel {

  protected Boolean add;
  protected Boolean remove;
  protected Boolean update;

  /**
   * Builder.
   */
  public static class Builder {
    private Boolean add;
    private Boolean remove;
    private Boolean update;

    /**
     * Instantiates a new Builder from an existing AssertionsActionControls instance.
     *
     * @param assertionsActionControls the instance to initialize the Builder with
     */
    private Builder(AssertionsActionControls assertionsActionControls) {
      this.add = assertionsActionControls.add;
      this.remove = assertionsActionControls.remove;
      this.update = assertionsActionControls.update;
    }

    /**
     * Instantiates a new builder.
     */
    public Builder() {
    }

    /**
     * Builds a AssertionsActionControls.
     *
     * @return the new AssertionsActionControls instance
     */
    public AssertionsActionControls build() {
      return new AssertionsActionControls(this);
    }

    /**
     * Set the add.
     *
     * @param add the add
     * @return the AssertionsActionControls builder
     */
    public Builder add(Boolean add) {
      this.add = add;
      return this;
    }

    /**
     * Set the remove.
     *
     * @param remove the remove
     * @return the AssertionsActionControls builder
     */
    public Builder remove(Boolean remove) {
      this.remove = remove;
      return this;
    }

    /**
     * Set the update.
     *
     * @param update the update
     * @return the AssertionsActionControls builder
     */
    public Builder update(Boolean update) {
      this.update = update;
      return this;
    }
  }

  protected AssertionsActionControls() { }

  protected AssertionsActionControls(Builder builder) {
    add = builder.add;
    remove = builder.remove;
    update = builder.update;
  }

  /**
   * New builder.
   *
   * @return a AssertionsActionControls builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the add.
   *
   * Action control for adding dynamic rules to an enterprise-managed access group. If an access group administrator in
   * a child account adds a dynamic rule, they can always update or remove it.
   *
   * @return the add
   */
  public Boolean add() {
    return add;
  }

  /**
   * Gets the remove.
   *
   * Action control for removing enterprise-managed dynamic rules in an enterprise-managed access group.
   *
   * @return the remove
   */
  public Boolean remove() {
    return remove;
  }

  /**
   * Gets the update.
   *
   * Action control for updating enterprise-managed dynamic rules in an enterprise-managed access group.
   *
   * @return the update
   */
  public Boolean update() {
    return update;
  }
}

