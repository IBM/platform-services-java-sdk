/*
 * (C) Copyright IBM Corp. 2020.
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
 * The deleteAccessGroup options.
 */
public class DeleteAccessGroupOptions extends GenericModel {

  protected String accessGroupId;
  protected String transactionId;
  protected Boolean force;

  /**
   * Builder.
   */
  public static class Builder {
    private String accessGroupId;
    private String transactionId;
    private Boolean force;

    private Builder(DeleteAccessGroupOptions deleteAccessGroupOptions) {
      this.accessGroupId = deleteAccessGroupOptions.accessGroupId;
      this.transactionId = deleteAccessGroupOptions.transactionId;
      this.force = deleteAccessGroupOptions.force;
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
     */
    public Builder(String accessGroupId) {
      this.accessGroupId = accessGroupId;
    }

    /**
     * Builds a DeleteAccessGroupOptions.
     *
     * @return the new DeleteAccessGroupOptions instance
     */
    public DeleteAccessGroupOptions build() {
      return new DeleteAccessGroupOptions(this);
    }

    /**
     * Set the accessGroupId.
     *
     * @param accessGroupId the accessGroupId
     * @return the DeleteAccessGroupOptions builder
     */
    public Builder accessGroupId(String accessGroupId) {
      this.accessGroupId = accessGroupId;
      return this;
    }

    /**
     * Set the transactionId.
     *
     * @param transactionId the transactionId
     * @return the DeleteAccessGroupOptions builder
     */
    public Builder transactionId(String transactionId) {
      this.transactionId = transactionId;
      return this;
    }

    /**
     * Set the force.
     *
     * @param force the force
     * @return the DeleteAccessGroupOptions builder
     */
    public Builder force(Boolean force) {
      this.force = force;
      return this;
    }
  }

  protected DeleteAccessGroupOptions(Builder builder) {
    com.ibm.cloud.sdk.core.util.Validator.notEmpty(builder.accessGroupId,
      "accessGroupId cannot be empty");
    accessGroupId = builder.accessGroupId;
    transactionId = builder.transactionId;
    force = builder.force;
  }

  /**
   * New builder.
   *
   * @return a DeleteAccessGroupOptions builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the accessGroupId.
   *
   * The Access group to delete.
   *
   * @return the accessGroupId
   */
  public String accessGroupId() {
    return accessGroupId;
  }

  /**
   * Gets the transactionId.
   *
   * An optional transaction id for the request.
   *
   * @return the transactionId
   */
  public String transactionId() {
    return transactionId;
  }

  /**
   * Gets the force.
   *
   * If force is true, delete the group as well as its associated members and rules.
   *
   * @return the force
   */
  public Boolean force() {
    return force;
  }
}

