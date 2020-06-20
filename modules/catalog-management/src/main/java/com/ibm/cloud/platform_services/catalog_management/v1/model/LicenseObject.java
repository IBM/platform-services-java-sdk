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
 * License information.
 */
public class LicenseObject extends GenericModel {

  protected String name;
  @SerializedName("offering_type")
  protected String offeringType;
  @SerializedName("seats_allowed")
  protected String seatsAllowed;
  @SerializedName("seats_used")
  protected String seatsUsed;
  @SerializedName("owner_id")
  protected String ownerId;
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
  @SerializedName("license_product_id")
  protected String licenseProductId;
  @SerializedName("license_provider_url")
  protected String licenseProviderUrl;
  @SerializedName("effective_from")
  protected String effectiveFrom;
  @SerializedName("effective_until")
  protected String effectiveUntil;
  protected Boolean internal;
  @SerializedName("offering_list")
  protected List<LicenseOfferingReference> offeringList;

  /**
   * Gets the name.
   *
   * License name.
   *
   * @return the name
   */
  public String getName() {
    return name;
  }

  /**
   * Gets the offeringType.
   *
   * Type of offering.
   *
   * @return the offeringType
   */
  public String getOfferingType() {
    return offeringType;
  }

  /**
   * Gets the seatsAllowed.
   *
   * Number of seats allowed for license.
   *
   * @return the seatsAllowed
   */
  public String getSeatsAllowed() {
    return seatsAllowed;
  }

  /**
   * Gets the seatsUsed.
   *
   * Number of seats used for license.
   *
   * @return the seatsUsed
   */
  public String getSeatsUsed() {
    return seatsUsed;
  }

  /**
   * Gets the ownerId.
   *
   * ID of license owner.
   *
   * @return the ownerId
   */
  public String getOwnerId() {
    return ownerId;
  }

  /**
   * Gets the licenseOfferingId.
   *
   * Marketplace offering ID for this license.
   *
   * @return the licenseOfferingId
   */
  public String getLicenseOfferingId() {
    return licenseOfferingId;
  }

  /**
   * Gets the licenseId.
   *
   * specific license entitlement ID from the license provider, eg. D1W3R4.
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
   * type of license entitlement, e.g. ibm-ppa.
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
   * Gets the licenseProductId.
   *
   * specific license entitlement ID from the license provider, eg. D1W3R4.
   *
   * @return the licenseProductId
   */
  public String getLicenseProductId() {
    return licenseProductId;
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
   * Gets the effectiveFrom.
   *
   * license is good from this starting date. eg. '2019-07-17T21:21:47.6794935Z'.
   *
   * @return the effectiveFrom
   */
  public String getEffectiveFrom() {
    return effectiveFrom;
  }

  /**
   * Gets the effectiveUntil.
   *
   * license is good until this ending date. eg. '2019-07-17T21:21:47.6794935Z'.
   *
   * @return the effectiveUntil
   */
  public String getEffectiveUntil() {
    return effectiveUntil;
  }

  /**
   * Gets the internal.
   *
   * If true, this will allow use of this license by all IBMers.
   *
   * @return the internal
   */
  public Boolean isInternal() {
    return internal;
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

