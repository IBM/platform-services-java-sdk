/*
 * (C) Copyright IBM Corp. 2021.
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
package com.ibm.cloud.platform_services.global_catalog.v1.model;

import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * Information related to the visibility of a catalog entry.
 */
public class Visibility extends GenericModel {

  protected String restrictions;
  protected String owner;
  protected Boolean extendable;
  protected VisibilityDetail include;
  protected VisibilityDetail exclude;
  protected Boolean approved;

  /**
   * Builder.
   */
  public static class Builder {
    private Boolean extendable;
    private VisibilityDetail include;
    private VisibilityDetail exclude;

    private Builder(Visibility visibility) {
      this.extendable = visibility.extendable;
      this.include = visibility.include;
      this.exclude = visibility.exclude;
    }

    /**
     * Instantiates a new builder.
     */
    public Builder() {
    }

    /**
     * Builds a Visibility.
     *
     * @return the new Visibility instance
     */
    public Visibility build() {
      return new Visibility(this);
    }

    /**
     * Set the extendable.
     *
     * @param extendable the extendable
     * @return the Visibility builder
     */
    public Builder extendable(Boolean extendable) {
      this.extendable = extendable;
      return this;
    }

    /**
     * Set the include.
     *
     * @param include the include
     * @return the Visibility builder
     */
    public Builder include(VisibilityDetail include) {
      this.include = include;
      return this;
    }

    /**
     * Set the exclude.
     *
     * @param exclude the exclude
     * @return the Visibility builder
     */
    public Builder exclude(VisibilityDetail exclude) {
      this.exclude = exclude;
      return this;
    }
  }

  protected Visibility(Builder builder) {
    extendable = builder.extendable;
    include = builder.include;
    exclude = builder.exclude;
  }

  /**
   * New builder.
   *
   * @return a Visibility builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the restrictions.
   *
   * This controls the overall visibility. It is an enum of *public*, *ibm_only*, and *private*. public means it is
   * visible to all. ibm_only means it is visible to all IBM unless their account is explicitly excluded. private means
   * it is visible only to the included accounts.
   *
   * @return the restrictions
   */
  public String restrictions() {
    return restrictions;
  }

  /**
   * Gets the owner.
   *
   * IAM Scope-related information associated with a catalog entry.
   *
   * @return the owner
   */
  public String owner() {
    return owner;
  }

  /**
   * Gets the extendable.
   *
   * Allows the visibility to be extenable.
   *
   * @return the extendable
   */
  public Boolean extendable() {
    return extendable;
  }

  /**
   * Gets the include.
   *
   * Visibility details related to a catalog entry.
   *
   * @return the include
   */
  public VisibilityDetail include() {
    return include;
  }

  /**
   * Gets the exclude.
   *
   * Visibility details related to a catalog entry.
   *
   * @return the exclude
   */
  public VisibilityDetail exclude() {
    return exclude;
  }

  /**
   * Gets the approved.
   *
   * Determines whether the owning account has full control over the visibility of the entry such as adding non-IBM
   * accounts to the whitelist and making entries `private`, `ibm_only` or `public`.
   *
   * @return the approved
   */
  public Boolean approved() {
    return approved;
  }
}

