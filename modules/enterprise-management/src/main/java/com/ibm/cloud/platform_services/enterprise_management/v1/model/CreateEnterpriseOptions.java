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
package com.ibm.cloud.platform_services.enterprise_management.v1.model;

import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * The createEnterprise options.
 */
public class CreateEnterpriseOptions extends GenericModel {

  protected String sourceAccountId;
  protected String name;
  protected String primaryContactIamId;
  protected String domain;

  /**
   * Builder.
   */
  public static class Builder {
    private String sourceAccountId;
    private String name;
    private String primaryContactIamId;
    private String domain;

    private Builder(CreateEnterpriseOptions createEnterpriseOptions) {
      this.sourceAccountId = createEnterpriseOptions.sourceAccountId;
      this.name = createEnterpriseOptions.name;
      this.primaryContactIamId = createEnterpriseOptions.primaryContactIamId;
      this.domain = createEnterpriseOptions.domain;
    }

    /**
     * Instantiates a new builder.
     */
    public Builder() {
    }

    /**
     * Instantiates a new builder with required properties.
     *
     * @param sourceAccountId the sourceAccountId
     * @param name the name
     * @param primaryContactIamId the primaryContactIamId
     */
    public Builder(String sourceAccountId, String name, String primaryContactIamId) {
      this.sourceAccountId = sourceAccountId;
      this.name = name;
      this.primaryContactIamId = primaryContactIamId;
    }

    /**
     * Builds a CreateEnterpriseOptions.
     *
     * @return the new CreateEnterpriseOptions instance
     */
    public CreateEnterpriseOptions build() {
      return new CreateEnterpriseOptions(this);
    }

    /**
     * Set the sourceAccountId.
     *
     * @param sourceAccountId the sourceAccountId
     * @return the CreateEnterpriseOptions builder
     */
    public Builder sourceAccountId(String sourceAccountId) {
      this.sourceAccountId = sourceAccountId;
      return this;
    }

    /**
     * Set the name.
     *
     * @param name the name
     * @return the CreateEnterpriseOptions builder
     */
    public Builder name(String name) {
      this.name = name;
      return this;
    }

    /**
     * Set the primaryContactIamId.
     *
     * @param primaryContactIamId the primaryContactIamId
     * @return the CreateEnterpriseOptions builder
     */
    public Builder primaryContactIamId(String primaryContactIamId) {
      this.primaryContactIamId = primaryContactIamId;
      return this;
    }

    /**
     * Set the domain.
     *
     * @param domain the domain
     * @return the CreateEnterpriseOptions builder
     */
    public Builder domain(String domain) {
      this.domain = domain;
      return this;
    }
  }

  protected CreateEnterpriseOptions(Builder builder) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.sourceAccountId,
      "sourceAccountId cannot be null");
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.name,
      "name cannot be null");
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.primaryContactIamId,
      "primaryContactIamId cannot be null");
    sourceAccountId = builder.sourceAccountId;
    name = builder.name;
    primaryContactIamId = builder.primaryContactIamId;
    domain = builder.domain;
  }

  /**
   * New builder.
   *
   * @return a CreateEnterpriseOptions builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the sourceAccountId.
   *
   * The ID of the account that is used to create the enterprise.
   *
   * @return the sourceAccountId
   */
  public String sourceAccountId() {
    return sourceAccountId;
  }

  /**
   * Gets the name.
   *
   * The name of the enterprise. This field must have 3 - 60 characters.
   *
   * @return the name
   */
  public String name() {
    return name;
  }

  /**
   * Gets the primaryContactIamId.
   *
   * The IAM ID of the enterprise primary contact, such as `IBMid-0123ABC`. The IAM ID must already exist.
   *
   * @return the primaryContactIamId
   */
  public String primaryContactIamId() {
    return primaryContactIamId;
  }

  /**
   * Gets the domain.
   *
   * A domain or subdomain for the enterprise, such as `example.com` or `my.example.com`.
   *
   * @return the domain
   */
  public String domain() {
    return domain;
  }
}

