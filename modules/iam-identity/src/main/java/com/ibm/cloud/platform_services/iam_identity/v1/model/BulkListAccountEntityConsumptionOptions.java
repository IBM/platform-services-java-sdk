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

import java.util.ArrayList;
import java.util.List;

import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * The bulkListAccountEntityConsumption options.
 */
public class BulkListAccountEntityConsumptionOptions extends GenericModel {

  protected String accountId;
  protected Boolean serviceidGroups;
  protected List<String> serviceidsPerGroup;
  protected Boolean profiles;
  protected List<String> apikeysPerIdentity;
  protected Boolean templates;
  protected List<String> templateVersionsPerTemplate;
  protected Boolean idps;
  protected List<String> claimRulesPerGroup;
  protected List<String> claimRulesPerProfile;
  protected Boolean crLinks;
  protected List<String> crLinksPerProfile;
  protected Boolean crRules;
  protected List<String> crRulesPerProfile;

  /**
   * Builder.
   */
  public static class Builder {
    private String accountId;
    private Boolean serviceidGroups;
    private List<String> serviceidsPerGroup;
    private Boolean profiles;
    private List<String> apikeysPerIdentity;
    private Boolean templates;
    private List<String> templateVersionsPerTemplate;
    private Boolean idps;
    private List<String> claimRulesPerGroup;
    private List<String> claimRulesPerProfile;
    private Boolean crLinks;
    private List<String> crLinksPerProfile;
    private Boolean crRules;
    private List<String> crRulesPerProfile;

    /**
     * Instantiates a new Builder from an existing BulkListAccountEntityConsumptionOptions instance.
     *
     * @param bulkListAccountEntityConsumptionOptions the instance to initialize the Builder with
     */
    private Builder(BulkListAccountEntityConsumptionOptions bulkListAccountEntityConsumptionOptions) {
      this.accountId = bulkListAccountEntityConsumptionOptions.accountId;
      this.serviceidGroups = bulkListAccountEntityConsumptionOptions.serviceidGroups;
      this.serviceidsPerGroup = bulkListAccountEntityConsumptionOptions.serviceidsPerGroup;
      this.profiles = bulkListAccountEntityConsumptionOptions.profiles;
      this.apikeysPerIdentity = bulkListAccountEntityConsumptionOptions.apikeysPerIdentity;
      this.templates = bulkListAccountEntityConsumptionOptions.templates;
      this.templateVersionsPerTemplate = bulkListAccountEntityConsumptionOptions.templateVersionsPerTemplate;
      this.idps = bulkListAccountEntityConsumptionOptions.idps;
      this.claimRulesPerGroup = bulkListAccountEntityConsumptionOptions.claimRulesPerGroup;
      this.claimRulesPerProfile = bulkListAccountEntityConsumptionOptions.claimRulesPerProfile;
      this.crLinks = bulkListAccountEntityConsumptionOptions.crLinks;
      this.crLinksPerProfile = bulkListAccountEntityConsumptionOptions.crLinksPerProfile;
      this.crRules = bulkListAccountEntityConsumptionOptions.crRules;
      this.crRulesPerProfile = bulkListAccountEntityConsumptionOptions.crRulesPerProfile;
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
     * Builds a BulkListAccountEntityConsumptionOptions.
     *
     * @return the new BulkListAccountEntityConsumptionOptions instance
     */
    public BulkListAccountEntityConsumptionOptions build() {
      return new BulkListAccountEntityConsumptionOptions(this);
    }

    /**
     * Adds a new element to serviceidsPerGroup.
     *
     * @param serviceidsPerGroup the new element to be added
     * @return the BulkListAccountEntityConsumptionOptions builder
     */
    public Builder addServiceidsPerGroup(String serviceidsPerGroup) {
      com.ibm.cloud.sdk.core.util.Validator.notNull(serviceidsPerGroup,
        "serviceidsPerGroup cannot be null");
      if (this.serviceidsPerGroup == null) {
        this.serviceidsPerGroup = new ArrayList<String>();
      }
      this.serviceidsPerGroup.add(serviceidsPerGroup);
      return this;
    }

    /**
     * Adds a new element to apikeysPerIdentity.
     *
     * @param apikeysPerIdentity the new element to be added
     * @return the BulkListAccountEntityConsumptionOptions builder
     */
    public Builder addApikeysPerIdentity(String apikeysPerIdentity) {
      com.ibm.cloud.sdk.core.util.Validator.notNull(apikeysPerIdentity,
        "apikeysPerIdentity cannot be null");
      if (this.apikeysPerIdentity == null) {
        this.apikeysPerIdentity = new ArrayList<String>();
      }
      this.apikeysPerIdentity.add(apikeysPerIdentity);
      return this;
    }

    /**
     * Adds a new element to templateVersionsPerTemplate.
     *
     * @param templateVersionsPerTemplate the new element to be added
     * @return the BulkListAccountEntityConsumptionOptions builder
     */
    public Builder addTemplateVersionsPerTemplate(String templateVersionsPerTemplate) {
      com.ibm.cloud.sdk.core.util.Validator.notNull(templateVersionsPerTemplate,
        "templateVersionsPerTemplate cannot be null");
      if (this.templateVersionsPerTemplate == null) {
        this.templateVersionsPerTemplate = new ArrayList<String>();
      }
      this.templateVersionsPerTemplate.add(templateVersionsPerTemplate);
      return this;
    }

    /**
     * Adds a new element to claimRulesPerGroup.
     *
     * @param claimRulesPerGroup the new element to be added
     * @return the BulkListAccountEntityConsumptionOptions builder
     */
    public Builder addClaimRulesPerGroup(String claimRulesPerGroup) {
      com.ibm.cloud.sdk.core.util.Validator.notNull(claimRulesPerGroup,
        "claimRulesPerGroup cannot be null");
      if (this.claimRulesPerGroup == null) {
        this.claimRulesPerGroup = new ArrayList<String>();
      }
      this.claimRulesPerGroup.add(claimRulesPerGroup);
      return this;
    }

    /**
     * Adds a new element to claimRulesPerProfile.
     *
     * @param claimRulesPerProfile the new element to be added
     * @return the BulkListAccountEntityConsumptionOptions builder
     */
    public Builder addClaimRulesPerProfile(String claimRulesPerProfile) {
      com.ibm.cloud.sdk.core.util.Validator.notNull(claimRulesPerProfile,
        "claimRulesPerProfile cannot be null");
      if (this.claimRulesPerProfile == null) {
        this.claimRulesPerProfile = new ArrayList<String>();
      }
      this.claimRulesPerProfile.add(claimRulesPerProfile);
      return this;
    }

    /**
     * Adds a new element to crLinksPerProfile.
     *
     * @param crLinksPerProfile the new element to be added
     * @return the BulkListAccountEntityConsumptionOptions builder
     */
    public Builder addCrLinksPerProfile(String crLinksPerProfile) {
      com.ibm.cloud.sdk.core.util.Validator.notNull(crLinksPerProfile,
        "crLinksPerProfile cannot be null");
      if (this.crLinksPerProfile == null) {
        this.crLinksPerProfile = new ArrayList<String>();
      }
      this.crLinksPerProfile.add(crLinksPerProfile);
      return this;
    }

    /**
     * Adds a new element to crRulesPerProfile.
     *
     * @param crRulesPerProfile the new element to be added
     * @return the BulkListAccountEntityConsumptionOptions builder
     */
    public Builder addCrRulesPerProfile(String crRulesPerProfile) {
      com.ibm.cloud.sdk.core.util.Validator.notNull(crRulesPerProfile,
        "crRulesPerProfile cannot be null");
      if (this.crRulesPerProfile == null) {
        this.crRulesPerProfile = new ArrayList<String>();
      }
      this.crRulesPerProfile.add(crRulesPerProfile);
      return this;
    }

    /**
     * Set the accountId.
     *
     * @param accountId the accountId
     * @return the BulkListAccountEntityConsumptionOptions builder
     */
    public Builder accountId(String accountId) {
      this.accountId = accountId;
      return this;
    }

    /**
     * Set the serviceidGroups.
     *
     * @param serviceidGroups the serviceidGroups
     * @return the BulkListAccountEntityConsumptionOptions builder
     */
    public Builder serviceidGroups(Boolean serviceidGroups) {
      this.serviceidGroups = serviceidGroups;
      return this;
    }

    /**
     * Set the serviceidsPerGroup.
     * Existing serviceidsPerGroup will be replaced.
     *
     * @param serviceidsPerGroup the serviceidsPerGroup
     * @return the BulkListAccountEntityConsumptionOptions builder
     */
    public Builder serviceidsPerGroup(List<String> serviceidsPerGroup) {
      this.serviceidsPerGroup = serviceidsPerGroup;
      return this;
    }

    /**
     * Set the profiles.
     *
     * @param profiles the profiles
     * @return the BulkListAccountEntityConsumptionOptions builder
     */
    public Builder profiles(Boolean profiles) {
      this.profiles = profiles;
      return this;
    }

    /**
     * Set the apikeysPerIdentity.
     * Existing apikeysPerIdentity will be replaced.
     *
     * @param apikeysPerIdentity the apikeysPerIdentity
     * @return the BulkListAccountEntityConsumptionOptions builder
     */
    public Builder apikeysPerIdentity(List<String> apikeysPerIdentity) {
      this.apikeysPerIdentity = apikeysPerIdentity;
      return this;
    }

    /**
     * Set the templates.
     *
     * @param templates the templates
     * @return the BulkListAccountEntityConsumptionOptions builder
     */
    public Builder templates(Boolean templates) {
      this.templates = templates;
      return this;
    }

    /**
     * Set the templateVersionsPerTemplate.
     * Existing templateVersionsPerTemplate will be replaced.
     *
     * @param templateVersionsPerTemplate the templateVersionsPerTemplate
     * @return the BulkListAccountEntityConsumptionOptions builder
     */
    public Builder templateVersionsPerTemplate(List<String> templateVersionsPerTemplate) {
      this.templateVersionsPerTemplate = templateVersionsPerTemplate;
      return this;
    }

    /**
     * Set the idps.
     *
     * @param idps the idps
     * @return the BulkListAccountEntityConsumptionOptions builder
     */
    public Builder idps(Boolean idps) {
      this.idps = idps;
      return this;
    }

    /**
     * Set the claimRulesPerGroup.
     * Existing claimRulesPerGroup will be replaced.
     *
     * @param claimRulesPerGroup the claimRulesPerGroup
     * @return the BulkListAccountEntityConsumptionOptions builder
     */
    public Builder claimRulesPerGroup(List<String> claimRulesPerGroup) {
      this.claimRulesPerGroup = claimRulesPerGroup;
      return this;
    }

    /**
     * Set the claimRulesPerProfile.
     * Existing claimRulesPerProfile will be replaced.
     *
     * @param claimRulesPerProfile the claimRulesPerProfile
     * @return the BulkListAccountEntityConsumptionOptions builder
     */
    public Builder claimRulesPerProfile(List<String> claimRulesPerProfile) {
      this.claimRulesPerProfile = claimRulesPerProfile;
      return this;
    }

    /**
     * Set the crLinks.
     *
     * @param crLinks the crLinks
     * @return the BulkListAccountEntityConsumptionOptions builder
     */
    public Builder crLinks(Boolean crLinks) {
      this.crLinks = crLinks;
      return this;
    }

    /**
     * Set the crLinksPerProfile.
     * Existing crLinksPerProfile will be replaced.
     *
     * @param crLinksPerProfile the crLinksPerProfile
     * @return the BulkListAccountEntityConsumptionOptions builder
     */
    public Builder crLinksPerProfile(List<String> crLinksPerProfile) {
      this.crLinksPerProfile = crLinksPerProfile;
      return this;
    }

    /**
     * Set the crRules.
     *
     * @param crRules the crRules
     * @return the BulkListAccountEntityConsumptionOptions builder
     */
    public Builder crRules(Boolean crRules) {
      this.crRules = crRules;
      return this;
    }

    /**
     * Set the crRulesPerProfile.
     * Existing crRulesPerProfile will be replaced.
     *
     * @param crRulesPerProfile the crRulesPerProfile
     * @return the BulkListAccountEntityConsumptionOptions builder
     */
    public Builder crRulesPerProfile(List<String> crRulesPerProfile) {
      this.crRulesPerProfile = crRulesPerProfile;
      return this;
    }
  }

  protected BulkListAccountEntityConsumptionOptions() { }

  protected BulkListAccountEntityConsumptionOptions(Builder builder) {
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
   * @return a BulkListAccountEntityConsumptionOptions builder
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
   * Flag to include service ID groups usage.
   *
   * @return the serviceidGroups
   */
  public Boolean serviceidGroups() {
    return serviceidGroups;
  }

  /**
   * Gets the serviceidsPerGroup.
   *
   * List of service ID group IDs to get usage for.
   *
   * @return the serviceidsPerGroup
   */
  public List<String> serviceidsPerGroup() {
    return serviceidsPerGroup;
  }

  /**
   * Gets the profiles.
   *
   * Flag to include trusted profiles usage.
   *
   * @return the profiles
   */
  public Boolean profiles() {
    return profiles;
  }

  /**
   * Gets the apikeysPerIdentity.
   *
   * List of identity IDs to get API key usage for.
   *
   * @return the apikeysPerIdentity
   */
  public List<String> apikeysPerIdentity() {
    return apikeysPerIdentity;
  }

  /**
   * Gets the templates.
   *
   * Flag to include templates usage.
   *
   * @return the templates
   */
  public Boolean templates() {
    return templates;
  }

  /**
   * Gets the templateVersionsPerTemplate.
   *
   * List of template IDs to get version usage for.
   *
   * @return the templateVersionsPerTemplate
   */
  public List<String> templateVersionsPerTemplate() {
    return templateVersionsPerTemplate;
  }

  /**
   * Gets the idps.
   *
   * Flag to include identity providers usage.
   *
   * @return the idps
   */
  public Boolean idps() {
    return idps;
  }

  /**
   * Gets the claimRulesPerGroup.
   *
   * List of access group IDs to get claim rules usage for.
   *
   * @return the claimRulesPerGroup
   */
  public List<String> claimRulesPerGroup() {
    return claimRulesPerGroup;
  }

  /**
   * Gets the claimRulesPerProfile.
   *
   * List of profile IDs to get claim rules usage for.
   *
   * @return the claimRulesPerProfile
   */
  public List<String> claimRulesPerProfile() {
    return claimRulesPerProfile;
  }

  /**
   * Gets the crLinks.
   *
   * Flag to include compute resource links usage.
   *
   * @return the crLinks
   */
  public Boolean crLinks() {
    return crLinks;
  }

  /**
   * Gets the crLinksPerProfile.
   *
   * List of profile IDs to get compute resource links usage for.
   *
   * @return the crLinksPerProfile
   */
  public List<String> crLinksPerProfile() {
    return crLinksPerProfile;
  }

  /**
   * Gets the crRules.
   *
   * Flag to include compute resource rules usage.
   *
   * @return the crRules
   */
  public Boolean crRules() {
    return crRules;
  }

  /**
   * Gets the crRulesPerProfile.
   *
   * List of profile IDs to get compute resource rules usage for.
   *
   * @return the crRulesPerProfile
   */
  public List<String> crRulesPerProfile() {
    return crRulesPerProfile;
  }
}

