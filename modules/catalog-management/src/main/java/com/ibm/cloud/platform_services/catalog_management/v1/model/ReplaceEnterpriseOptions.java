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
package com.ibm.cloud.platform_services.catalog_management.v1.model;

import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * The replaceEnterprise options.
 */
public class ReplaceEnterpriseOptions extends GenericModel {

  protected String enterpriseId;
  protected String id;
  protected String rev;
  protected Filters accountFilters;
  protected EnterpriseAccountGroups accountGroups;

  /**
   * Builder.
   */
  public static class Builder {
    private String enterpriseId;
    private String id;
    private String rev;
    private Filters accountFilters;
    private EnterpriseAccountGroups accountGroups;

    private Builder(ReplaceEnterpriseOptions replaceEnterpriseOptions) {
      this.enterpriseId = replaceEnterpriseOptions.enterpriseId;
      this.id = replaceEnterpriseOptions.id;
      this.rev = replaceEnterpriseOptions.rev;
      this.accountFilters = replaceEnterpriseOptions.accountFilters;
      this.accountGroups = replaceEnterpriseOptions.accountGroups;
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
     * Builds a ReplaceEnterpriseOptions.
     *
     * @return the new ReplaceEnterpriseOptions instance
     */
    public ReplaceEnterpriseOptions build() {
      return new ReplaceEnterpriseOptions(this);
    }

    /**
     * Set the enterpriseId.
     *
     * @param enterpriseId the enterpriseId
     * @return the ReplaceEnterpriseOptions builder
     */
    public Builder enterpriseId(String enterpriseId) {
      this.enterpriseId = enterpriseId;
      return this;
    }

    /**
     * Set the id.
     *
     * @param id the id
     * @return the ReplaceEnterpriseOptions builder
     */
    public Builder id(String id) {
      this.id = id;
      return this;
    }

    /**
     * Set the rev.
     *
     * @param rev the rev
     * @return the ReplaceEnterpriseOptions builder
     */
    public Builder rev(String rev) {
      this.rev = rev;
      return this;
    }

    /**
     * Set the accountFilters.
     *
     * @param accountFilters the accountFilters
     * @return the ReplaceEnterpriseOptions builder
     */
    public Builder accountFilters(Filters accountFilters) {
      this.accountFilters = accountFilters;
      return this;
    }

    /**
     * Set the accountGroups.
     *
     * @param accountGroups the accountGroups
     * @return the ReplaceEnterpriseOptions builder
     */
    public Builder accountGroups(EnterpriseAccountGroups accountGroups) {
      this.accountGroups = accountGroups;
      return this;
    }

    /**
     * Set the enterprise.
     *
     * @param enterprise the enterprise
     * @return the ReplaceEnterpriseOptions builder
     */
    public Builder enterprise(Enterprise enterprise) {
      this.id = enterprise.id();
      this.rev = enterprise.rev();
      this.accountFilters = enterprise.accountFilters();
      this.accountGroups = enterprise.accountGroups();
      return this;
    }
  }

  protected ReplaceEnterpriseOptions(Builder builder) {
    com.ibm.cloud.sdk.core.util.Validator.notEmpty(builder.enterpriseId,
      "enterpriseId cannot be empty");
    enterpriseId = builder.enterpriseId;
    id = builder.id;
    rev = builder.rev;
    accountFilters = builder.accountFilters;
    accountGroups = builder.accountGroups;
  }

  /**
   * New builder.
   *
   * @return a ReplaceEnterpriseOptions builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the enterpriseId.
   *
   * Enterprise identification.
   *
   * @return the enterpriseId
   */
  public String enterpriseId() {
    return enterpriseId;
  }

  /**
   * Gets the id.
   *
   * Enterprise identification.
   *
   * @return the id
   */
  public String id() {
    return id;
  }

  /**
   * Gets the rev.
   *
   * Cloudant revision.
   *
   * @return the rev
   */
  public String rev() {
    return rev;
  }

  /**
   * Gets the accountFilters.
   *
   * Filters for account and catalog filters.
   *
   * @return the accountFilters
   */
  public Filters accountFilters() {
    return accountFilters;
  }

  /**
   * Gets the accountGroups.
   *
   * Map of account group ids to AccountGroup objects.
   *
   * @return the accountGroups
   */
  public EnterpriseAccountGroups accountGroups() {
    return accountGroups;
  }
}

