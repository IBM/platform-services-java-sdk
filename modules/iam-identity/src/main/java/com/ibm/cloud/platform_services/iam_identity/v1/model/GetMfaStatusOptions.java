/*
 * (C) Copyright IBM Corp. 2024.
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
 * The getMfaStatus options.
 */
public class GetMfaStatusOptions extends GenericModel {

  protected String accountId;
  protected String iamId;

  /**
   * Builder.
   */
  public static class Builder {
    private String accountId;
    private String iamId;

    /**
     * Instantiates a new Builder from an existing GetMfaStatusOptions instance.
     *
     * @param getMfaStatusOptions the instance to initialize the Builder with
     */
    private Builder(GetMfaStatusOptions getMfaStatusOptions) {
      this.accountId = getMfaStatusOptions.accountId;
      this.iamId = getMfaStatusOptions.iamId;
    }

    /**
     * Instantiates a new builder.
     */
    public Builder() {
    }

    /**
     * Instantiates a new builder with required properties.
     *
     * @param accountId the accountId
     * @param iamId the iamId
     */
    public Builder(String accountId, String iamId) {
      this.accountId = accountId;
      this.iamId = iamId;
    }

    /**
     * Builds a GetMfaStatusOptions.
     *
     * @return the new GetMfaStatusOptions instance
     */
    public GetMfaStatusOptions build() {
      return new GetMfaStatusOptions(this);
    }

    /**
     * Set the accountId.
     *
     * @param accountId the accountId
     * @return the GetMfaStatusOptions builder
     */
    public Builder accountId(String accountId) {
      this.accountId = accountId;
      return this;
    }

    /**
     * Set the iamId.
     *
     * @param iamId the iamId
     * @return the GetMfaStatusOptions builder
     */
    public Builder iamId(String iamId) {
      this.iamId = iamId;
      return this;
    }
  }

  protected GetMfaStatusOptions() { }

  protected GetMfaStatusOptions(Builder builder) {
    com.ibm.cloud.sdk.core.util.Validator.notEmpty(builder.accountId,
      "accountId cannot be empty");
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.iamId,
      "iamId cannot be null");
    accountId = builder.accountId;
    iamId = builder.iamId;
  }

  /**
   * New builder.
   *
   * @return a GetMfaStatusOptions builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the accountId.
   *
   * ID of the account.
   *
   * @return the accountId
   */
  public String accountId() {
    return accountId;
  }

  /**
   * Gets the iamId.
   *
   * iam_id of the user. This user must be the member of the account.
   *
   * @return the iamId
   */
  public String iamId() {
    return iamId;
  }
}

