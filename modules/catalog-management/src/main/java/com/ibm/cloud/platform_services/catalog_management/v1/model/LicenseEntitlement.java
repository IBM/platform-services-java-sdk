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

import java.util.List;

import com.google.gson.annotations.SerializedName;
import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * License entitlement.
 */
public class LicenseEntitlement extends GenericModel {

  protected String name;
  protected String id;
  protected String crn;
  protected String url;
  @SerializedName("offering_type")
  protected String offeringType;
  protected String state;
  @SerializedName("effective_from")
  protected String effectiveFrom;
  @SerializedName("effective_until")
  protected String effectiveUntil;
  @SerializedName("account_id")
  protected String accountId;
  @SerializedName("owner_id")
  protected String ownerId;
  @SerializedName("version_id")
  protected String versionId;
  @SerializedName("license_offering_id")
  protected String licenseOfferingId;
  @SerializedName("license_id")
  protected String licenseId;
  @SerializedName("license_owner_id")
  protected String licenseOwnerId;
  @SerializedName("license_type")
  protected String licenseType;
  @SerializedName("license_provider_id")
  protected String licenseProviderId;
  @SerializedName("license_provider_url")
  protected String licenseProviderUrl;
  @SerializedName("license_product_id")
  protected String licenseProductId;
  @SerializedName("namespace_repository")
  protected String namespaceRepository;
  protected String apikey;
  @SerializedName("create_by")
  protected String createBy;
  @SerializedName("update_by")
  protected String updateBy;
  @SerializedName("create_at")
  protected String createAt;
  @SerializedName("updated_at")
  protected String updatedAt;
  protected List<LicenseEntitlementHistoryItem> history;
  @SerializedName("offering_list")
  protected List<LicenseOfferingReference> offeringList;

  /**
   * Gets the name.
   *
   * Entitlement name.
   *
   * @return the name
   */
  public String getName() {
    return name;
  }

  /**
   * Gets the id.
   *
   * Entitlement ID.
   *
   * @return the id
   */
  public String getId() {
    return id;
  }

  /**
   * Gets the crn.
   *
   * Entitlement CRN.
   *
   * @return the crn
   */
  public String getCrn() {
    return crn;
  }

  /**
   * Gets the url.
   *
   * URL for the BSS entitlement, e.g. /v1/licensing/entitlements/:id.
   *
   * @return the url
   */
  public String getUrl() {
    return url;
  }

  /**
   * Gets the offeringType.
   *
   * Entitlement offering type.
   *
   * @return the offeringType
   */
  public String getOfferingType() {
    return offeringType;
  }

  /**
   * Gets the state.
   *
   * State of the BSS entitlement, e.g. 'active' or if it's been deleted, 'removed'.
   *
   * @return the state
   */
  public String getState() {
    return state;
  }

  /**
   * Gets the effectiveFrom.
   *
   * Entitlement is good from this starting date. eg. '2019-07-17T21:21:47.6794935Z'.
   *
   * @return the effectiveFrom
   */
  public String getEffectiveFrom() {
    return effectiveFrom;
  }

  /**
   * Gets the effectiveUntil.
   *
   * Entitlement is good until this ending date. eg. '2019-07-17T21:21:47.6794935Z'.
   *
   * @return the effectiveUntil
   */
  public String getEffectiveUntil() {
    return effectiveUntil;
  }

  /**
   * Gets the accountId.
   *
   * Account ID where this entitlement is bound to.
   *
   * @return the accountId
   */
  public String getAccountId() {
    return accountId;
  }

  /**
   * Gets the ownerId.
   *
   * Account ID of owner.
   *
   * @return the ownerId
   */
  public String getOwnerId() {
    return ownerId;
  }

  /**
   * Gets the versionId.
   *
   * GC ID of the specific offering version.
   *
   * @return the versionId
   */
  public String getVersionId() {
    return versionId;
  }

  /**
   * Gets the licenseOfferingId.
   *
   * Marketplace offering ID for this license entitlement.
   *
   * @return the licenseOfferingId
   */
  public String getLicenseOfferingId() {
    return licenseOfferingId;
  }

  /**
   * Gets the licenseId.
   *
   * Specific license entitlement ID from the license provider, eg. D1W3R4.
   *
   * @return the licenseId
   */
  public String getLicenseId() {
    return licenseId;
  }

  /**
   * Gets the licenseOwnerId.
   *
   * IBM ID of the owner of this license entitlement.
   *
   * @return the licenseOwnerId
   */
  public String getLicenseOwnerId() {
    return licenseOwnerId;
  }

  /**
   * Gets the licenseType.
   *
   * Type of license entitlement, e.g. ibm-ppa.
   *
   * @return the licenseType
   */
  public String getLicenseType() {
    return licenseType;
  }

  /**
   * Gets the licenseProviderId.
   *
   * ID of the license provider.
   *
   * @return the licenseProviderId
   */
  public String getLicenseProviderId() {
    return licenseProviderId;
  }

  /**
   * Gets the licenseProviderUrl.
   *
   * URL for the BSS license provider, e.g. /v1/licensing/license_providers/:license_provider_id.
   *
   * @return the licenseProviderUrl
   */
  public String getLicenseProviderUrl() {
    return licenseProviderUrl;
  }

  /**
   * Gets the licenseProductId.
   *
   * Specific license entitlement ID from the license provider, eg. D1W3R4.
   *
   * @return the licenseProductId
   */
  public String getLicenseProductId() {
    return licenseProductId;
  }

  /**
   * Gets the namespaceRepository.
   *
   * Location of the registry images, eg. cp/cp4d.
   *
   * @return the namespaceRepository
   */
  public String getNamespaceRepository() {
    return namespaceRepository;
  }

  /**
   * Gets the apikey.
   *
   * API key for access to the license entitlement.
   *
   * @return the apikey
   */
  public String getApikey() {
    return apikey;
  }

  /**
   * Gets the createBy.
   *
   * IBM ID.
   *
   * @return the createBy
   */
  public String getCreateBy() {
    return createBy;
  }

  /**
   * Gets the updateBy.
   *
   * IBM ID.
   *
   * @return the updateBy
   */
  public String getUpdateBy() {
    return updateBy;
  }

  /**
   * Gets the createAt.
   *
   * Creation date, eg. '2019-07-17T21:21:47.6794935Z'.
   *
   * @return the createAt
   */
  public String getCreateAt() {
    return createAt;
  }

  /**
   * Gets the updatedAt.
   *
   * Date last updated, eg. '2019-07-17T21:21:47.6794935Z'.
   *
   * @return the updatedAt
   */
  public String getUpdatedAt() {
    return updatedAt;
  }

  /**
   * Gets the history.
   *
   * Entitlement history.
   *
   * @return the history
   */
  public List<LicenseEntitlementHistoryItem> getHistory() {
    return history;
  }

  /**
   * Gets the offeringList.
   *
   * Array of license offering references.
   *
   * @return the offeringList
   */
  public List<LicenseOfferingReference> getOfferingList() {
    return offeringList;
  }
}

