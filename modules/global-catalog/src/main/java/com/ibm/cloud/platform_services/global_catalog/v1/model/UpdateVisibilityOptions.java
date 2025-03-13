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

package com.ibm.cloud.platform_services.global_catalog.v1.model;

import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * The updateVisibility options.
 */
public class UpdateVisibilityOptions extends GenericModel {

  protected String id;
  protected Boolean extendable;
  protected VisibilityDetail include;
  protected VisibilityDetail exclude;
  protected String account;

  /**
   * Builder.
   */
  public static class Builder {
    private String id;
    private Boolean extendable;
    private VisibilityDetail include;
    private VisibilityDetail exclude;
    private String account;

    /**
     * Instantiates a new Builder from an existing UpdateVisibilityOptions instance.
     *
     * @param updateVisibilityOptions the instance to initialize the Builder with
     */
    private Builder(UpdateVisibilityOptions updateVisibilityOptions) {
      this.id = updateVisibilityOptions.id;
      this.extendable = updateVisibilityOptions.extendable;
      this.include = updateVisibilityOptions.include;
      this.exclude = updateVisibilityOptions.exclude;
      this.account = updateVisibilityOptions.account;
    }

    /**
     * Instantiates a new builder.
     */
    public Builder() {
    }

    /**
     * Instantiates a new builder with required properties.
     *
     * @param id the id
     */
    public Builder(String id) {
      this.id = id;
    }

    /**
     * Builds a UpdateVisibilityOptions.
     *
     * @return the new UpdateVisibilityOptions instance
     */
    public UpdateVisibilityOptions build() {
      return new UpdateVisibilityOptions(this);
    }

    /**
     * Set the id.
     *
     * @param id the id
     * @return the UpdateVisibilityOptions builder
     */
    public Builder id(String id) {
      this.id = id;
      return this;
    }

    /**
     * Set the extendable.
     *
     * @param extendable the extendable
     * @return the UpdateVisibilityOptions builder
     */
    public Builder extendable(Boolean extendable) {
      this.extendable = extendable;
      return this;
    }

    /**
     * Set the include.
     *
     * @param include the include
     * @return the UpdateVisibilityOptions builder
     */
    public Builder include(VisibilityDetail include) {
      this.include = include;
      return this;
    }

    /**
     * Set the exclude.
     *
     * @param exclude the exclude
     * @return the UpdateVisibilityOptions builder
     */
    public Builder exclude(VisibilityDetail exclude) {
      this.exclude = exclude;
      return this;
    }

    /**
     * Set the account.
     *
     * @param account the account
     * @return the UpdateVisibilityOptions builder
     */
    public Builder account(String account) {
      this.account = account;
      return this;
    }

    /**
     * Set the visibility.
     *
     * @param visibility the visibility
     * @return the UpdateVisibilityOptions builder
     */
    public Builder visibility(Visibility visibility) {
      this.extendable = visibility.extendable();
      this.include = visibility.include();
      this.exclude = visibility.exclude();
      return this;
    }
  }

  protected UpdateVisibilityOptions() { }

  protected UpdateVisibilityOptions(Builder builder) {
    com.ibm.cloud.sdk.core.util.Validator.notEmpty(builder.id,
      "id cannot be empty");
    id = builder.id;
    extendable = builder.extendable;
    include = builder.include;
    exclude = builder.exclude;
    account = builder.account;
  }

  /**
   * New builder.
   *
   * @return a UpdateVisibilityOptions builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the id.
   *
   * The object's unique ID.
   *
   * @return the id
   */
  public String id() {
    return id;
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
   * Gets the account.
   *
   * This changes the scope of the request regardless of the authorization header. Example scopes are `account` and
   * `global`. `account=global` is reqired if operating with a service ID that has a global admin policy, for example
   * `GET /?account=global`.
   *
   * @return the account
   */
  public String account() {
    return account;
  }
}

