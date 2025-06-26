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
 * The updateServiceIdGroup options.
 */
public class UpdateServiceIdGroupOptions extends GenericModel {

  protected String id;
  protected String ifMatch;
  protected String name;
  protected String description;

  /**
   * Builder.
   */
  public static class Builder {
    private String id;
    private String ifMatch;
    private String name;
    private String description;

    /**
     * Instantiates a new Builder from an existing UpdateServiceIdGroupOptions instance.
     *
     * @param updateServiceIdGroupOptions the instance to initialize the Builder with
     */
    private Builder(UpdateServiceIdGroupOptions updateServiceIdGroupOptions) {
      this.id = updateServiceIdGroupOptions.id;
      this.ifMatch = updateServiceIdGroupOptions.ifMatch;
      this.name = updateServiceIdGroupOptions.name;
      this.description = updateServiceIdGroupOptions.description;
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
     * @param ifMatch the ifMatch
     * @param name the name
     */
    public Builder(String id, String ifMatch, String name) {
      this.id = id;
      this.ifMatch = ifMatch;
      this.name = name;
    }

    /**
     * Builds a UpdateServiceIdGroupOptions.
     *
     * @return the new UpdateServiceIdGroupOptions instance
     */
    public UpdateServiceIdGroupOptions build() {
      return new UpdateServiceIdGroupOptions(this);
    }

    /**
     * Set the id.
     *
     * @param id the id
     * @return the UpdateServiceIdGroupOptions builder
     */
    public Builder id(String id) {
      this.id = id;
      return this;
    }

    /**
     * Set the ifMatch.
     *
     * @param ifMatch the ifMatch
     * @return the UpdateServiceIdGroupOptions builder
     */
    public Builder ifMatch(String ifMatch) {
      this.ifMatch = ifMatch;
      return this;
    }

    /**
     * Set the name.
     *
     * @param name the name
     * @return the UpdateServiceIdGroupOptions builder
     */
    public Builder name(String name) {
      this.name = name;
      return this;
    }

    /**
     * Set the description.
     *
     * @param description the description
     * @return the UpdateServiceIdGroupOptions builder
     */
    public Builder description(String description) {
      this.description = description;
      return this;
    }
  }

  protected UpdateServiceIdGroupOptions() { }

  protected UpdateServiceIdGroupOptions(Builder builder) {
    com.ibm.cloud.sdk.core.util.Validator.notEmpty(builder.id,
      "id cannot be empty");
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.ifMatch,
      "ifMatch cannot be null");
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.name,
      "name cannot be null");
    id = builder.id;
    ifMatch = builder.ifMatch;
    name = builder.name;
    description = builder.description;
  }

  /**
   * New builder.
   *
   * @return a UpdateServiceIdGroupOptions builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the id.
   *
   * Unique ID of the service ID group to be updated.
   *
   * @return the id
   */
  public String id() {
    return id;
  }

  /**
   * Gets the ifMatch.
   *
   * Version of the service ID gorup to be updated. Specify the version that you retrieved when reading service ID
   * group. This value helps identifying parallel usage of this API. Pass * to indicate to update any version available.
   * This might result in stale updates.
   *
   * @return the ifMatch
   */
  public String ifMatch() {
    return ifMatch;
  }

  /**
   * Gets the name.
   *
   * Name of the service ID group. Unique in the account.
   *
   * @return the name
   */
  public String name() {
    return name;
  }

  /**
   * Gets the description.
   *
   * Description of the service ID group.
   *
   * @return the description
   */
  public String description() {
    return description;
  }
}

