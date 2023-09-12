/*
 * (C) Copyright IBM Corp. 2023.
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
package com.ibm.cloud.platform_services.context_based_restrictions.v1.model;

import java.util.Date;
import java.util.List;

import com.google.gson.annotations.SerializedName;
import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * An output zone summary.
 */
public class ZoneSummary extends GenericModel {

  protected String id;
  protected String crn;
  protected String name;
  protected String description;
  @SerializedName("addresses_preview")
  protected List<Address> addressesPreview;
  @SerializedName("address_count")
  protected Long addressCount;
  @SerializedName("excluded_count")
  protected Long excludedCount;
  protected String href;
  @SerializedName("created_at")
  protected Date createdAt;
  @SerializedName("created_by_id")
  protected String createdById;
  @SerializedName("last_modified_at")
  protected Date lastModifiedAt;
  @SerializedName("last_modified_by_id")
  protected String lastModifiedById;

  protected ZoneSummary() { }

  /**
   * Gets the id.
   *
   * The globally unique ID of the zone.
   *
   * @return the id
   */
  public String getId() {
    return id;
  }

  /**
   * Gets the crn.
   *
   * The zone CRN.
   *
   * @return the crn
   */
  public String getCrn() {
    return crn;
  }

  /**
   * Gets the name.
   *
   * The name of the zone.
   *
   * @return the name
   */
  public String getName() {
    return name;
  }

  /**
   * Gets the description.
   *
   * The description of the zone.
   *
   * @return the description
   */
  public String getDescription() {
    return description;
  }

  /**
   * Gets the addressesPreview.
   *
   * A preview of addresses in the zone (3 addresses maximum).
   *
   * @return the addressesPreview
   */
  public List<Address> getAddressesPreview() {
    return addressesPreview;
  }

  /**
   * Gets the addressCount.
   *
   * The number of addresses in the zone.
   *
   * @return the addressCount
   */
  public Long getAddressCount() {
    return addressCount;
  }

  /**
   * Gets the excludedCount.
   *
   * The number of excluded addresses in the zone.
   *
   * @return the excludedCount
   */
  public Long getExcludedCount() {
    return excludedCount;
  }

  /**
   * Gets the href.
   *
   * The href link to the resource.
   *
   * @return the href
   */
  public String getHref() {
    return href;
  }

  /**
   * Gets the createdAt.
   *
   * The time the resource was created.
   *
   * @return the createdAt
   */
  public Date getCreatedAt() {
    return createdAt;
  }

  /**
   * Gets the createdById.
   *
   * IAM ID of the user or service which created the resource.
   *
   * @return the createdById
   */
  public String getCreatedById() {
    return createdById;
  }

  /**
   * Gets the lastModifiedAt.
   *
   * The last time the resource was modified.
   *
   * @return the lastModifiedAt
   */
  public Date getLastModifiedAt() {
    return lastModifiedAt;
  }

  /**
   * Gets the lastModifiedById.
   *
   * IAM ID of the user or service which modified the resource.
   *
   * @return the lastModifiedById
   */
  public String getLastModifiedById() {
    return lastModifiedById;
  }
}

