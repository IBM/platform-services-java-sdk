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
 * The updateEnterprise options.
 */
public class UpdateEnterpriseOptions extends GenericModel {

  protected String enterpriseId;
  protected String name;
  protected String domain;
  protected String primaryContactIamId;

  /**
   * Builder.
   */
  public static class Builder {
    private String enterpriseId;
    private String name;
    private String domain;
    private String primaryContactIamId;

    private Builder(UpdateEnterpriseOptions updateEnterpriseOptions) {
      this.enterpriseId = updateEnterpriseOptions.enterpriseId;
      this.name = updateEnterpriseOptions.name;
      this.domain = updateEnterpriseOptions.domain;
      this.primaryContactIamId = updateEnterpriseOptions.primaryContactIamId;
    }

    /**
     * Instantiates a new builder.
     */
    public Builder() {
    }

    /**
     * Instantiates a new builder with required properties.
     *
     * @param enterpriseId the enterpriseId
     */
    public Builder(String enterpriseId) {
      this.enterpriseId = enterpriseId;
    }

    /**
     * Builds a UpdateEnterpriseOptions.
     *
     * @return the new UpdateEnterpriseOptions instance
     */
    public UpdateEnterpriseOptions build() {
      return new UpdateEnterpriseOptions(this);
    }

    /**
     * Set the enterpriseId.
     *
     * @param enterpriseId the enterpriseId
     * @return the UpdateEnterpriseOptions builder
     */
    public Builder enterpriseId(String enterpriseId) {
      this.enterpriseId = enterpriseId;
      return this;
    }

    /**
     * Set the name.
     *
     * @param name the name
     * @return the UpdateEnterpriseOptions builder
     */
    public Builder name(String name) {
      this.name = name;
      return this;
    }

    /**
     * Set the domain.
     *
     * @param domain the domain
     * @return the UpdateEnterpriseOptions builder
     */
    public Builder domain(String domain) {
      this.domain = domain;
      return this;
    }

    /**
     * Set the primaryContactIamId.
     *
     * @param primaryContactIamId the primaryContactIamId
     * @return the UpdateEnterpriseOptions builder
     */
    public Builder primaryContactIamId(String primaryContactIamId) {
      this.primaryContactIamId = primaryContactIamId;
      return this;
    }
  }

  protected UpdateEnterpriseOptions(Builder builder) {
    com.ibm.cloud.sdk.core.util.Validator.notEmpty(builder.enterpriseId,
      "enterpriseId cannot be empty");
    enterpriseId = builder.enterpriseId;
    name = builder.name;
    domain = builder.domain;
    primaryContactIamId = builder.primaryContactIamId;
  }

  /**
   * New builder.
   *
   * @return a UpdateEnterpriseOptions builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the enterpriseId.
   *
   * The ID of the enterprise to retrieve.
   *
   * @return the enterpriseId
   */
  public String enterpriseId() {
    return enterpriseId;
  }

  /**
   * Gets the name.
   *
   * The new name of the enterprise. This field must have 3 - 60 characters.
   *
   * @return the name
   */
  public String name() {
    return name;
  }

  /**
   * Gets the domain.
   *
   * The new domain of the enterprise. This field has a limit of 60 characters.
   *
   * @return the domain
   */
  public String domain() {
    return domain;
  }

  /**
   * Gets the primaryContactIamId.
   *
   * The IAM ID of the user to be the new primary contact for the enterprise.
   *
   * @return the primaryContactIamId
   */
  public String primaryContactIamId() {
    return primaryContactIamId;
  }
}

