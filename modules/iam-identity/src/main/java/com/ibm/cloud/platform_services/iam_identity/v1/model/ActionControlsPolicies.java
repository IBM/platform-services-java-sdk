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
 * ActionControlsPolicies.
 */
public class ActionControlsPolicies extends GenericModel {

  protected Boolean add;
  protected Boolean remove;

  /**
   * Builder.
   */
  public static class Builder {
    private Boolean add;
    private Boolean remove;

    /**
     * Instantiates a new Builder from an existing ActionControlsPolicies instance.
     *
     * @param actionControlsPolicies the instance to initialize the Builder with
     */
    private Builder(ActionControlsPolicies actionControlsPolicies) {
      this.add = actionControlsPolicies.add;
      this.remove = actionControlsPolicies.remove;
    }

    /**
     * Instantiates a new builder.
     */
    public Builder() {
    }

    /**
     * Instantiates a new builder with required properties.
     *
     * @param add the add
     * @param remove the remove
     */
    public Builder(Boolean add, Boolean remove) {
      this.add = add;
      this.remove = remove;
    }

    /**
     * Builds a ActionControlsPolicies.
     *
     * @return the new ActionControlsPolicies instance
     */
    public ActionControlsPolicies build() {
      return new ActionControlsPolicies(this);
    }

    /**
     * Set the add.
     *
     * @param add the add
     * @return the ActionControlsPolicies builder
     */
    public Builder add(Boolean add) {
      this.add = add;
      return this;
    }

    /**
     * Set the remove.
     *
     * @param remove the remove
     * @return the ActionControlsPolicies builder
     */
    public Builder remove(Boolean remove) {
      this.remove = remove;
      return this;
    }
  }

  protected ActionControlsPolicies() { }

  protected ActionControlsPolicies(Builder builder) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.add,
      "add cannot be null");
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.remove,
      "remove cannot be null");
    add = builder.add;
    remove = builder.remove;
  }

  /**
   * New builder.
   *
   * @return a ActionControlsPolicies builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the add.
   *
   * @return the add
   */
  public Boolean add() {
    return add;
  }

  /**
   * Gets the remove.
   *
   * @return the remove
   */
  public Boolean remove() {
    return remove;
  }
}

