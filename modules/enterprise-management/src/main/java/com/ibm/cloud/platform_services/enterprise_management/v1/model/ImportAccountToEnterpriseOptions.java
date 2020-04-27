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
 * The importAccountToEnterprise options.
 */
public class ImportAccountToEnterpriseOptions extends GenericModel {

  protected String enterpriseId;
  protected String accountId;
  protected String parent;
  protected String billingUnitId;

  /**
   * Builder.
   */
  public static class Builder {
    private String enterpriseId;
    private String accountId;
    private String parent;
    private String billingUnitId;

    private Builder(ImportAccountToEnterpriseOptions importAccountToEnterpriseOptions) {
      this.enterpriseId = importAccountToEnterpriseOptions.enterpriseId;
      this.accountId = importAccountToEnterpriseOptions.accountId;
      this.parent = importAccountToEnterpriseOptions.parent;
      this.billingUnitId = importAccountToEnterpriseOptions.billingUnitId;
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
     * @param accountId the accountId
     */
    public Builder(String enterpriseId, String accountId) {
      this.enterpriseId = enterpriseId;
      this.accountId = accountId;
    }

    /**
     * Builds a ImportAccountToEnterpriseOptions.
     *
     * @return the new ImportAccountToEnterpriseOptions instance
     */
    public ImportAccountToEnterpriseOptions build() {
      return new ImportAccountToEnterpriseOptions(this);
    }

    /**
     * Set the enterpriseId.
     *
     * @param enterpriseId the enterpriseId
     * @return the ImportAccountToEnterpriseOptions builder
     */
    public Builder enterpriseId(String enterpriseId) {
      this.enterpriseId = enterpriseId;
      return this;
    }

    /**
     * Set the accountId.
     *
     * @param accountId the accountId
     * @return the ImportAccountToEnterpriseOptions builder
     */
    public Builder accountId(String accountId) {
      this.accountId = accountId;
      return this;
    }

    /**
     * Set the parent.
     *
     * @param parent the parent
     * @return the ImportAccountToEnterpriseOptions builder
     */
    public Builder parent(String parent) {
      this.parent = parent;
      return this;
    }

    /**
     * Set the billingUnitId.
     *
     * @param billingUnitId the billingUnitId
     * @return the ImportAccountToEnterpriseOptions builder
     */
    public Builder billingUnitId(String billingUnitId) {
      this.billingUnitId = billingUnitId;
      return this;
    }
  }

  protected ImportAccountToEnterpriseOptions(Builder builder) {
    com.ibm.cloud.sdk.core.util.Validator.notEmpty(builder.enterpriseId,
      "enterpriseId cannot be empty");
    com.ibm.cloud.sdk.core.util.Validator.notEmpty(builder.accountId,
      "accountId cannot be empty");
    enterpriseId = builder.enterpriseId;
    accountId = builder.accountId;
    parent = builder.parent;
    billingUnitId = builder.billingUnitId;
  }

  /**
   * New builder.
   *
   * @return a ImportAccountToEnterpriseOptions builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the enterpriseId.
   *
   * The ID of the enterprise to import the stand-alone account into.
   *
   * @return the enterpriseId
   */
  public String enterpriseId() {
    return enterpriseId;
  }

  /**
   * Gets the accountId.
   *
   * The ID of the existing stand-alone account to be imported.
   *
   * @return the accountId
   */
  public String accountId() {
    return accountId;
  }

  /**
   * Gets the parent.
   *
   * The CRN of the expected parent of the imported account. The parent is the enterprise or account group that the
   * account is added to.
   *
   * @return the parent
   */
  public String parent() {
    return parent;
  }

  /**
   * Gets the billingUnitId.
   *
   * The ID of the [billing unit](/apidocs/enterprise-apis/billing-unit) to use for billing this account in the
   * enterprise.
   *
   * @return the billingUnitId
   */
  public String billingUnitId() {
    return billingUnitId;
  }
}

