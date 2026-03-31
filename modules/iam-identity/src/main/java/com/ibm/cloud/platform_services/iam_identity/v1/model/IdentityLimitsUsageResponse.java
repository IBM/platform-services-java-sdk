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

import com.google.gson.annotations.SerializedName;
import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * Response body format for identity limits usage.
 */
public class IdentityLimitsUsageResponse extends GenericModel {

  @SerializedName("serviceid_groups")
  protected LimitCount serviceidGroups;
  @SerializedName("serviceids_per_group")
  protected IdentityLimitsUsageResponseServiceidsPerGroup serviceidsPerGroup;
  protected LimitCount profiles;
  @SerializedName("apikeys_per_identity")
  protected IdentityLimitsUsageResponseApikeysPerIdentity apikeysPerIdentity;
  @SerializedName("profile_templates")
  protected LimitCount profileTemplates;
  @SerializedName("account_settings_templates")
  protected LimitCount accountSettingsTemplates;
  @SerializedName("template_versions_per_template")
  protected IdentityLimitsUsageResponseTemplateVersionsPerTemplate templateVersionsPerTemplate;
  protected LimitCount idps;
  @SerializedName("claim_rules_per_group")
  protected IdentityLimitsUsageResponseClaimRulesPerGroup claimRulesPerGroup;
  @SerializedName("claim_rules_per_profile")
  protected IdentityLimitsUsageResponseClaimRulesPerProfile claimRulesPerProfile;
  @SerializedName("cr_links")
  protected LimitCount crLinks;
  @SerializedName("cr_links_per_profile")
  protected IdentityLimitsUsageResponseCrLinksPerProfile crLinksPerProfile;
  @SerializedName("cr_rules")
  protected LimitCount crRules;
  @SerializedName("cr_rules_per_profile")
  protected IdentityLimitsUsageResponseCrRulesPerProfile crRulesPerProfile;

  protected IdentityLimitsUsageResponse() { }

  /**
   * Gets the serviceidGroups.
   *
   * Limit and current usage count for a resource.
   *
   * @return the serviceidGroups
   */
  public LimitCount getServiceidGroups() {
    return serviceidGroups;
  }

  /**
   * Gets the serviceidsPerGroup.
   *
   * Usage count for service IDs per group.
   *
   * @return the serviceidsPerGroup
   */
  public IdentityLimitsUsageResponseServiceidsPerGroup getServiceidsPerGroup() {
    return serviceidsPerGroup;
  }

  /**
   * Gets the profiles.
   *
   * Limit and current usage count for a resource.
   *
   * @return the profiles
   */
  public LimitCount getProfiles() {
    return profiles;
  }

  /**
   * Gets the apikeysPerIdentity.
   *
   * Usage count for API keys per identity.
   *
   * @return the apikeysPerIdentity
   */
  public IdentityLimitsUsageResponseApikeysPerIdentity getApikeysPerIdentity() {
    return apikeysPerIdentity;
  }

  /**
   * Gets the profileTemplates.
   *
   * Limit and current usage count for a resource.
   *
   * @return the profileTemplates
   */
  public LimitCount getProfileTemplates() {
    return profileTemplates;
  }

  /**
   * Gets the accountSettingsTemplates.
   *
   * Limit and current usage count for a resource.
   *
   * @return the accountSettingsTemplates
   */
  public LimitCount getAccountSettingsTemplates() {
    return accountSettingsTemplates;
  }

  /**
   * Gets the templateVersionsPerTemplate.
   *
   * Usage count for template versions per template.
   *
   * @return the templateVersionsPerTemplate
   */
  public IdentityLimitsUsageResponseTemplateVersionsPerTemplate getTemplateVersionsPerTemplate() {
    return templateVersionsPerTemplate;
  }

  /**
   * Gets the idps.
   *
   * Limit and current usage count for a resource.
   *
   * @return the idps
   */
  public LimitCount getIdps() {
    return idps;
  }

  /**
   * Gets the claimRulesPerGroup.
   *
   * Usage count for claim rules per access group.
   *
   * @return the claimRulesPerGroup
   */
  public IdentityLimitsUsageResponseClaimRulesPerGroup getClaimRulesPerGroup() {
    return claimRulesPerGroup;
  }

  /**
   * Gets the claimRulesPerProfile.
   *
   * Usage count for claim rules per profile.
   *
   * @return the claimRulesPerProfile
   */
  public IdentityLimitsUsageResponseClaimRulesPerProfile getClaimRulesPerProfile() {
    return claimRulesPerProfile;
  }

  /**
   * Gets the crLinks.
   *
   * Limit and current usage count for a resource.
   *
   * @return the crLinks
   */
  public LimitCount getCrLinks() {
    return crLinks;
  }

  /**
   * Gets the crLinksPerProfile.
   *
   * Usage count for compute resource links per profile.
   *
   * @return the crLinksPerProfile
   */
  public IdentityLimitsUsageResponseCrLinksPerProfile getCrLinksPerProfile() {
    return crLinksPerProfile;
  }

  /**
   * Gets the crRules.
   *
   * Limit and current usage count for a resource.
   *
   * @return the crRules
   */
  public LimitCount getCrRules() {
    return crRules;
  }

  /**
   * Gets the crRulesPerProfile.
   *
   * Usage count for compute resource rules per profile.
   *
   * @return the crRulesPerProfile
   */
  public IdentityLimitsUsageResponseCrRulesPerProfile getCrRulesPerProfile() {
    return crRulesPerProfile;
  }
}

