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
package com.ibm.cloud.platform_services.enterprise_management.v1.model;

import com.google.gson.annotations.SerializedName;
import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * The traits object can be used to set properties on child accounts of an enterprise. You can pass a field to opt-out
 * of Multi-Factor Authentication setting or setup enterprise IAM settings when creating a child account in the
 * enterprise. This is an optional field.
 */
public class CreateAccountRequestTraits extends GenericModel {

  protected String mfa;
  @SerializedName("enterprise_iam_managed")
  protected Boolean enterpriseIamManaged;

  /**
   * Builder.
   */
  public static class Builder {
    private String mfa;
    private Boolean enterpriseIamManaged;

    /**
     * Instantiates a new Builder from an existing CreateAccountRequestTraits instance.
     *
     * @param createAccountRequestTraits the instance to initialize the Builder with
     */
    private Builder(CreateAccountRequestTraits createAccountRequestTraits) {
      this.mfa = createAccountRequestTraits.mfa;
      this.enterpriseIamManaged = createAccountRequestTraits.enterpriseIamManaged;
    }

    /**
     * Instantiates a new builder.
     */
    public Builder() {
    }

    /**
     * Builds a CreateAccountRequestTraits.
     *
     * @return the new CreateAccountRequestTraits instance
     */
    public CreateAccountRequestTraits build() {
      return new CreateAccountRequestTraits(this);
    }

    /**
     * Set the mfa.
     *
     * @param mfa the mfa
     * @return the CreateAccountRequestTraits builder
     */
    public Builder mfa(String mfa) {
      this.mfa = mfa;
      return this;
    }

    /**
     * Set the enterpriseIamManaged.
     *
     * @param enterpriseIamManaged the enterpriseIamManaged
     * @return the CreateAccountRequestTraits builder
     */
    public Builder enterpriseIamManaged(Boolean enterpriseIamManaged) {
      this.enterpriseIamManaged = enterpriseIamManaged;
      return this;
    }
  }

  protected CreateAccountRequestTraits() { }

  protected CreateAccountRequestTraits(Builder builder) {
    mfa = builder.mfa;
    enterpriseIamManaged = builder.enterpriseIamManaged;
  }

  /**
   * New builder.
   *
   * @return a CreateAccountRequestTraits builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the mfa.
   *
   * By default MFA will be enabled on a child account. To opt out, pass the traits object with the mfa field set to
   * empty string. This is an optional field.
   *
   * @return the mfa
   */
  public String mfa() {
    return mfa;
  }

  /**
   * Gets the enterpriseIamManaged.
   *
   * The Enterprise IAM settings property will be turned off for a newly created child account by default. You can
   * enable this property by passing 'true' in this boolean field. This is an optional field.
   *
   * @return the enterpriseIamManaged
   */
  public Boolean enterpriseIamManaged() {
    return enterpriseIamManaged;
  }
}

