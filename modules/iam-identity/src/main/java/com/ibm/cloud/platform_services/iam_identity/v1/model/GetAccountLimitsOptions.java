/*
 * (C) Copyright IBM Corp. 2026.
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
 * The getAccountLimits options.
 */
public class GetAccountLimitsOptions extends GenericModel {

  protected String accountId;
  protected Boolean serviceidGroups;
  protected String serviceidsPerGroup;
  protected String profiles;
  protected String apikeysPerIdentity;
  protected String templates;
  protected String templateVersionsPerTemplate;
  protected String idps;
  protected String claimRulesPerGroup;
  protected String claimRulesPerProfile;
  protected String crLinks;
  protected String crLinksPerProfile;
  protected String crRules;
  protected String crRulesPerProfile;

  /**
   * Builder.
   */
  public static class Builder {
    private String accountId;
    private Boolean serviceidGroups;
    private String serviceidsPerGroup;
    private String profiles;
    private String apikeysPerIdentity;
    private String templates;
    private String templateVersionsPerTemplate;
    private String idps;
    private String claimRulesPerGroup;
    private String claimRulesPerProfile;
    private String crLinks;
    private String crLinksPerProfile;
    private String crRules;
    private String crRulesPerProfile;

    /**
     * Instantiates a new Builder from an existing GetAccountLimitsOptions instance.
     *
     * @param getAccountLimitsOptions the instance to initialize the Builder with
     */
    private Builder(GetAccountLimitsOptions getAccountLimitsOptions) {
      this.accountId = getAccountLimitsOptions.accountId;
      this.serviceidGroups = getAccountLimitsOptions.serviceidGroups;
      this.serviceidsPerGroup = getAccountLimitsOptions.serviceidsPerGroup;
      this.profiles = getAccountLimitsOptions.profiles;
      this.apikeysPerIdentity = getAccountLimitsOptions.apikeysPerIdentity;
      this.templates = getAccountLimitsOptions.templates;
      this.templateVersionsPerTemplate = getAccountLimitsOptions.templateVersionsPerTemplate;
      this.idps = getAccountLimitsOptions.idps;
      this.claimRulesPerGroup = getAccountLimitsOptions.claimRulesPerGroup;
      this.claimRulesPerProfile = getAccountLimitsOptions.claimRulesPerProfile;
      this.crLinks = getAccountLimitsOptions.crLinks;
      this.crLinksPerProfile = getAccountLimitsOptions.crLinksPerProfile;
      this.crRules = getAccountLimitsOptions.crRules;
      this.crRulesPerProfile = getAccountLimitsOptions.crRulesPerProfile;
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
     */
    public Builder(String accountId) {
      this.accountId = accountId;
    }

    /**
     * Builds a GetAccountLimitsOptions.
     *
     * @return the new GetAccountLimitsOptions instance
     */
    public GetAccountLimitsOptions build() {
      return new GetAccountLimitsOptions(this);
    }

    /**
     * Set the accountId.
     *
     * @param accountId the accountId
     * @return the GetAccountLimitsOptions builder
     */
    public Builder accountId(String accountId) {
      this.accountId = accountId;
      return this;
    }

    /**
     * Set the serviceidGroups.
     *
     * @param serviceidGroups the serviceidGroups
     * @return the GetAccountLimitsOptions builder
     */
    public Builder serviceidGroups(Boolean serviceidGroups) {
      this.serviceidGroups = serviceidGroups;
      return this;
    }

    /**
     * Set the serviceidsPerGroup.
     *
     * @param serviceidsPerGroup the serviceidsPerGroup
     * @return the GetAccountLimitsOptions builder
     */
    public Builder serviceidsPerGroup(String serviceidsPerGroup) {
      this.serviceidsPerGroup = serviceidsPerGroup;
      return this;
    }

    /**
     * Set the profiles.
     *
     * @param profiles the profiles
     * @return the GetAccountLimitsOptions builder
     */
    public Builder profiles(String profiles) {
      this.profiles = profiles;
      return this;
    }

    /**
     * Set the apikeysPerIdentity.
     *
     * @param apikeysPerIdentity the apikeysPerIdentity
     * @return the GetAccountLimitsOptions builder
     */
    public Builder apikeysPerIdentity(String apikeysPerIdentity) {
      this.apikeysPerIdentity = apikeysPerIdentity;
      return this;
    }

    /**
     * Set the templates.
     *
     * @param templates the templates
     * @return the GetAccountLimitsOptions builder
     */
    public Builder templates(String templates) {
      this.templates = templates;
      return this;
    }

    /**
     * Set the templateVersionsPerTemplate.
     *
     * @param templateVersionsPerTemplate the templateVersionsPerTemplate
     * @return the GetAccountLimitsOptions builder
     */
    public Builder templateVersionsPerTemplate(String templateVersionsPerTemplate) {
      this.templateVersionsPerTemplate = templateVersionsPerTemplate;
      return this;
    }

    /**
     * Set the idps.
     *
     * @param idps the idps
     * @return the GetAccountLimitsOptions builder
     */
    public Builder idps(String idps) {
      this.idps = idps;
      return this;
    }

    /**
     * Set the claimRulesPerGroup.
     *
     * @param claimRulesPerGroup the claimRulesPerGroup
     * @return the GetAccountLimitsOptions builder
     */
    public Builder claimRulesPerGroup(String claimRulesPerGroup) {
      this.claimRulesPerGroup = claimRulesPerGroup;
      return this;
    }

    /**
     * Set the claimRulesPerProfile.
     *
     * @param claimRulesPerProfile the claimRulesPerProfile
     * @return the GetAccountLimitsOptions builder
     */
    public Builder claimRulesPerProfile(String claimRulesPerProfile) {
      this.claimRulesPerProfile = claimRulesPerProfile;
      return this;
    }

    /**
     * Set the crLinks.
     *
     * @param crLinks the crLinks
     * @return the GetAccountLimitsOptions builder
     */
    public Builder crLinks(String crLinks) {
      this.crLinks = crLinks;
      return this;
    }

    /**
     * Set the crLinksPerProfile.
     *
     * @param crLinksPerProfile the crLinksPerProfile
     * @return the GetAccountLimitsOptions builder
     */
    public Builder crLinksPerProfile(String crLinksPerProfile) {
      this.crLinksPerProfile = crLinksPerProfile;
      return this;
    }

    /**
     * Set the crRules.
     *
     * @param crRules the crRules
     * @return the GetAccountLimitsOptions builder
     */
    public Builder crRules(String crRules) {
      this.crRules = crRules;
      return this;
    }

    /**
     * Set the crRulesPerProfile.
     *
     * @param crRulesPerProfile the crRulesPerProfile
     * @return the GetAccountLimitsOptions builder
     */
    public Builder crRulesPerProfile(String crRulesPerProfile) {
      this.crRulesPerProfile = crRulesPerProfile;
      return this;
    }
  }

  protected GetAccountLimitsOptions() { }

  protected GetAccountLimitsOptions(Builder builder) {
    com.ibm.cloud.sdk.core.util.Validator.notEmpty(builder.accountId,
      "accountId cannot be empty");
    accountId = builder.accountId;
    serviceidGroups = builder.serviceidGroups;
    serviceidsPerGroup = builder.serviceidsPerGroup;
    profiles = builder.profiles;
    apikeysPerIdentity = builder.apikeysPerIdentity;
    templates = builder.templates;
    templateVersionsPerTemplate = builder.templateVersionsPerTemplate;
    idps = builder.idps;
    claimRulesPerGroup = builder.claimRulesPerGroup;
    claimRulesPerProfile = builder.claimRulesPerProfile;
    crLinks = builder.crLinks;
    crLinksPerProfile = builder.crLinksPerProfile;
    crRules = builder.crRules;
    crRulesPerProfile = builder.crRulesPerProfile;
  }

  /**
   * New builder.
   *
   * @return a GetAccountLimitsOptions builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the accountId.
   *
   * Unique ID of the account.
   *
   * @return the accountId
   */
  public String accountId() {
    return accountId;
  }

  /**
   * Gets the serviceidGroups.
   *
   * Boolean to include serviceid group consumption.
   *
   * @return the serviceidGroups
   */
  public Boolean serviceidGroups() {
    return serviceidGroups;
  }

  /**
   * Gets the serviceidsPerGroup.
   *
   * Comma seperated list of ServiceID groups to include for consumption.
   *
   * @return the serviceidsPerGroup
   */
  public String serviceidsPerGroup() {
    return serviceidsPerGroup;
  }

  /**
   * Gets the profiles.
   *
   * Boolean to include trusted profiles consumption.
   *
   * @return the profiles
   */
  public String profiles() {
    return profiles;
  }

  /**
   * Gets the apikeysPerIdentity.
   *
   * Comma seperated list of IAM IDs to include for API key consumption.
   *
   * @return the apikeysPerIdentity
   */
  public String apikeysPerIdentity() {
    return apikeysPerIdentity;
  }

  /**
   * Gets the templates.
   *
   * Boolean to include template consumption.
   *
   * @return the templates
   */
  public String templates() {
    return templates;
  }

  /**
   * Gets the templateVersionsPerTemplate.
   *
   * Comma seperated list of template IDs to include for template version consumption.
   *
   * @return the templateVersionsPerTemplate
   */
  public String templateVersionsPerTemplate() {
    return templateVersionsPerTemplate;
  }

  /**
   * Gets the idps.
   *
   * Boolean to include identity provider consumption.
   *
   * @return the idps
   */
  public String idps() {
    return idps;
  }

  /**
   * Gets the claimRulesPerGroup.
   *
   * Comma seperated list of access groups to include for claim rules consumption.
   *
   * @return the claimRulesPerGroup
   */
  public String claimRulesPerGroup() {
    return claimRulesPerGroup;
  }

  /**
   * Gets the claimRulesPerProfile.
   *
   * Comma seperated list of profiles to include for claim rules consumption.
   *
   * @return the claimRulesPerProfile
   */
  public String claimRulesPerProfile() {
    return claimRulesPerProfile;
  }

  /**
   * Gets the crLinks.
   *
   * Boolean to include compute resource links consumption.
   *
   * @return the crLinks
   */
  public String crLinks() {
    return crLinks;
  }

  /**
   * Gets the crLinksPerProfile.
   *
   * Comma seperated list of profile IDs to include for cr links consumption.
   *
   * @return the crLinksPerProfile
   */
  public String crLinksPerProfile() {
    return crLinksPerProfile;
  }

  /**
   * Gets the crRules.
   *
   * Boolean to include compute resource rules consumption.
   *
   * @return the crRules
   */
  public String crRules() {
    return crRules;
  }

  /**
   * Gets the crRulesPerProfile.
   *
   * Comma seperated list of profile IDs to include for cr rules consumption.
   *
   * @return the crRulesPerProfile
   */
  public String crRulesPerProfile() {
    return crRulesPerProfile;
  }
}

