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

import java.util.ArrayList;
import java.util.List;

import com.google.gson.annotations.SerializedName;
import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * TemplateAccountSettingsRestrictUserDomains.
 */
public class TemplateAccountSettingsRestrictUserDomains extends GenericModel {

  @SerializedName("account_sufficient")
  protected Boolean accountSufficient;
  protected List<AccountSettingsUserDomainRestriction> restrictions;

  /**
   * Builder.
   */
  public static class Builder {
    private Boolean accountSufficient;
    private List<AccountSettingsUserDomainRestriction> restrictions;

    /**
     * Instantiates a new Builder from an existing TemplateAccountSettingsRestrictUserDomains instance.
     *
     * @param templateAccountSettingsRestrictUserDomains the instance to initialize the Builder with
     */
    private Builder(TemplateAccountSettingsRestrictUserDomains templateAccountSettingsRestrictUserDomains) {
      this.accountSufficient = templateAccountSettingsRestrictUserDomains.accountSufficient;
      this.restrictions = templateAccountSettingsRestrictUserDomains.restrictions;
    }

    /**
     * Instantiates a new builder.
     */
    public Builder() {
    }

    /**
     * Builds a TemplateAccountSettingsRestrictUserDomains.
     *
     * @return the new TemplateAccountSettingsRestrictUserDomains instance
     */
    public TemplateAccountSettingsRestrictUserDomains build() {
      return new TemplateAccountSettingsRestrictUserDomains(this);
    }

    /**
     * Adds a new element to restrictions.
     *
     * @param restrictions the new element to be added
     * @return the TemplateAccountSettingsRestrictUserDomains builder
     */
    public Builder addRestrictions(AccountSettingsUserDomainRestriction restrictions) {
      com.ibm.cloud.sdk.core.util.Validator.notNull(restrictions,
        "restrictions cannot be null");
      if (this.restrictions == null) {
        this.restrictions = new ArrayList<AccountSettingsUserDomainRestriction>();
      }
      this.restrictions.add(restrictions);
      return this;
    }

    /**
     * Set the accountSufficient.
     *
     * @param accountSufficient the accountSufficient
     * @return the TemplateAccountSettingsRestrictUserDomains builder
     */
    public Builder accountSufficient(Boolean accountSufficient) {
      this.accountSufficient = accountSufficient;
      return this;
    }

    /**
     * Set the restrictions.
     * Existing restrictions will be replaced.
     *
     * @param restrictions the restrictions
     * @return the TemplateAccountSettingsRestrictUserDomains builder
     */
    public Builder restrictions(List<AccountSettingsUserDomainRestriction> restrictions) {
      this.restrictions = restrictions;
      return this;
    }
  }

  protected TemplateAccountSettingsRestrictUserDomains() { }

  protected TemplateAccountSettingsRestrictUserDomains(Builder builder) {
    accountSufficient = builder.accountSufficient;
    restrictions = builder.restrictions;
  }

  /**
   * New builder.
   *
   * @return a TemplateAccountSettingsRestrictUserDomains builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the accountSufficient.
   *
   * @return the accountSufficient
   */
  public Boolean accountSufficient() {
    return accountSufficient;
  }

  /**
   * Gets the restrictions.
   *
   * Defines if account invitations are restricted to specified domains. To remove an entry for a realm_id, perform an
   * update (PUT) request with only the realm_id set.
   *
   * @return the restrictions
   */
  public List<AccountSettingsUserDomainRestriction> restrictions() {
    return restrictions;
  }
}

