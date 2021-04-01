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
package com.ibm.cloud.platform_services.iam_access_groups.v2.model;

import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * The isMemberOfAccessGroup options.
 */
public class IsMemberOfAccessGroupOptions extends GenericModel {

  protected String accessGroupId;
  protected String iamId;
  protected String transactionId;

  /**
   * Builder.
   */
  public static class Builder {
    private String accessGroupId;
    private String iamId;
    private String transactionId;

    private Builder(IsMemberOfAccessGroupOptions isMemberOfAccessGroupOptions) {
      this.accessGroupId = isMemberOfAccessGroupOptions.accessGroupId;
      this.iamId = isMemberOfAccessGroupOptions.iamId;
      this.transactionId = isMemberOfAccessGroupOptions.transactionId;
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
     * @param iamId the iamId
     */
    public Builder(String accessGroupId, String iamId) {
      this.accessGroupId = accessGroupId;
      this.iamId = iamId;
    }

    /**
     * Builds a IsMemberOfAccessGroupOptions.
     *
     * @return the new IsMemberOfAccessGroupOptions instance
     */
    public IsMemberOfAccessGroupOptions build() {
      return new IsMemberOfAccessGroupOptions(this);
    }

    /**
     * Set the accessGroupId.
     *
     * @param accessGroupId the accessGroupId
     * @return the IsMemberOfAccessGroupOptions builder
     */
    public Builder accessGroupId(String accessGroupId) {
      this.accessGroupId = accessGroupId;
      return this;
    }

    /**
     * Set the iamId.
     *
     * @param iamId the iamId
     * @return the IsMemberOfAccessGroupOptions builder
     */
    public Builder iamId(String iamId) {
      this.iamId = iamId;
      return this;
    }

    /**
     * Set the transactionId.
     *
     * @param transactionId the transactionId
     * @return the IsMemberOfAccessGroupOptions builder
     */
    public Builder transactionId(String transactionId) {
      this.transactionId = transactionId;
      return this;
    }
  }

  protected IsMemberOfAccessGroupOptions(Builder builder) {
    com.ibm.cloud.sdk.core.util.Validator.notEmpty(builder.accessGroupId,
      "accessGroupId cannot be empty");
    com.ibm.cloud.sdk.core.util.Validator.notEmpty(builder.iamId,
      "iamId cannot be empty");
    accessGroupId = builder.accessGroupId;
    iamId = builder.iamId;
    transactionId = builder.transactionId;
  }

  /**
   * New builder.
   *
   * @return a IsMemberOfAccessGroupOptions builder
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
   * Gets the iamId.
   *
   * The IAM identifier.
   *
   * @return the iamId
   */
  public String iamId() {
    return iamId;
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

