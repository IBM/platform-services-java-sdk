/*
 * (C) Copyright IBM Corp. 2022.
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
 * The updateAccessGroup options.
 */
public class UpdateAccessGroupOptions extends GenericModel {

  protected String accessGroupId;
  protected String ifMatch;
  protected String name;
  protected String description;
  protected String transactionId;

  /**
   * Builder.
   */
  public static class Builder {
    private String accessGroupId;
    private String ifMatch;
    private String name;
    private String description;
    private String transactionId;

    /**
     * Instantiates a new Builder from an existing UpdateAccessGroupOptions instance.
     *
     * @param updateAccessGroupOptions the instance to initialize the Builder with
     */
    private Builder(UpdateAccessGroupOptions updateAccessGroupOptions) {
      this.accessGroupId = updateAccessGroupOptions.accessGroupId;
      this.ifMatch = updateAccessGroupOptions.ifMatch;
      this.name = updateAccessGroupOptions.name;
      this.description = updateAccessGroupOptions.description;
      this.transactionId = updateAccessGroupOptions.transactionId;
    }

    /**
     * Instantiates a new builder.
     */
    public Builder() {
    }

    /**
     * Instantiates a new builder with required properties.
     *
     * @param accessGroupId the accessGroupId
     * @param ifMatch the ifMatch
     */
    public Builder(String accessGroupId, String ifMatch) {
      this.accessGroupId = accessGroupId;
      this.ifMatch = ifMatch;
    }

    /**
     * Builds a UpdateAccessGroupOptions.
     *
     * @return the new UpdateAccessGroupOptions instance
     */
    public UpdateAccessGroupOptions build() {
      return new UpdateAccessGroupOptions(this);
    }

    /**
     * Set the accessGroupId.
     *
     * @param accessGroupId the accessGroupId
     * @return the UpdateAccessGroupOptions builder
     */
    public Builder accessGroupId(String accessGroupId) {
      this.accessGroupId = accessGroupId;
      return this;
    }

    /**
     * Set the ifMatch.
     *
     * @param ifMatch the ifMatch
     * @return the UpdateAccessGroupOptions builder
     */
    public Builder ifMatch(String ifMatch) {
      this.ifMatch = ifMatch;
      return this;
    }

    /**
     * Set the name.
     *
     * @param name the name
     * @return the UpdateAccessGroupOptions builder
     */
    public Builder name(String name) {
      this.name = name;
      return this;
    }

    /**
     * Set the description.
     *
     * @param description the description
     * @return the UpdateAccessGroupOptions builder
     */
    public Builder description(String description) {
      this.description = description;
      return this;
    }

    /**
     * Set the transactionId.
     *
     * @param transactionId the transactionId
     * @return the UpdateAccessGroupOptions builder
     */
    public Builder transactionId(String transactionId) {
      this.transactionId = transactionId;
      return this;
    }
  }

  protected UpdateAccessGroupOptions() { }

  protected UpdateAccessGroupOptions(Builder builder) {
    com.ibm.cloud.sdk.core.util.Validator.notEmpty(builder.accessGroupId,
      "accessGroupId cannot be empty");
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.ifMatch,
      "ifMatch cannot be null");
    accessGroupId = builder.accessGroupId;
    ifMatch = builder.ifMatch;
    name = builder.name;
    description = builder.description;
    transactionId = builder.transactionId;
  }

  /**
   * New builder.
   *
   * @return a UpdateAccessGroupOptions builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the accessGroupId.
   *
   * The access group identifier.
   *
   * @return the accessGroupId
   */
  public String accessGroupId() {
    return accessGroupId;
  }

  /**
   * Gets the ifMatch.
   *
   * The current revision number of the group being updated. This can be found in the Create/Get access group response
   * ETag header.
   *
   * @return the ifMatch
   */
  public String ifMatch() {
    return ifMatch;
  }

  /**
   * Gets the name.
   *
   * Assign the specified name to the access group. This field is case-insensitive and has a limit of 100 characters.
   * The group name has to be unique within an account.
   *
   * @return the name
   */
  public String name() {
    return name;
  }

  /**
   * Gets the description.
   *
   * Assign an optional description for the access group. This field has a limit of 250 characters.
   *
   * @return the description
   */
  public String description() {
    return description;
  }

  /**
   * Gets the transactionId.
   *
   * An optional transaction ID can be passed to your request, which can be useful for tracking calls through multiple
   * services by using one identifier. The header key must be set to Transaction-Id and the value is anything that you
   * choose. If no transaction ID is passed in, then a random ID is generated.
   *
   * @return the transactionId
   */
  public String transactionId() {
    return transactionId;
  }
}

