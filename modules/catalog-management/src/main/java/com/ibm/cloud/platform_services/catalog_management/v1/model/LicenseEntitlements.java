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
 * Paginated list of license entitlements.
 */
public class LicenseEntitlements extends GenericModel {

  @SerializedName("total_results")
  protected Long totalResults;
  @SerializedName("total_pages")
  protected Long totalPages;
  @SerializedName("prev_url")
  protected String prevUrl;
  @SerializedName("next_url")
  protected String nextUrl;
  protected List<LicenseEntitlement> resources;

  /**
   * Gets the totalResults.
   *
   * Total number of results.
   *
   * @return the totalResults
   */
  public Long getTotalResults() {
    return totalResults;
  }

  /**
   * Gets the totalPages.
   *
   * Total number of pages.
   *
   * @return the totalPages
   */
  public Long getTotalPages() {
    return totalPages;
  }

  /**
   * Gets the prevUrl.
   *
   * Previous URL.
   *
   * @return the prevUrl
   */
  public String getPrevUrl() {
    return prevUrl;
  }

  /**
   * Gets the nextUrl.
   *
   * Next URL.
   *
   * @return the nextUrl
   */
  public String getNextUrl() {
    return nextUrl;
  }

  /**
   * Gets the resources.
   *
   * Resulting Entitlement objects.
   *
   * @return the resources
   */
  public List<LicenseEntitlement> getResources() {
    return resources;
  }
}

