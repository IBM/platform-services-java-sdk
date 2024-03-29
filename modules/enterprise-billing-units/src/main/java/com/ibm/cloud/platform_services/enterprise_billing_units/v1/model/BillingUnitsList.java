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
package com.ibm.cloud.platform_services.enterprise_billing_units.v1.model;

import java.util.List;

import com.google.gson.annotations.SerializedName;
import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * A search result contining zero or more billing units.
 */
public class BillingUnitsList extends GenericModel {

  @SerializedName("rows_count")
  protected Long rowsCount;
  @SerializedName("next_url")
  protected String nextUrl;
  protected List<BillingUnit> resources;

  protected BillingUnitsList() { }

  /**
   * Gets the rowsCount.
   *
   * A count of the billing units that were found by the query.
   *
   * @return the rowsCount
   */
  public Long getRowsCount() {
    return rowsCount;
  }

  /**
   * Gets the nextUrl.
   *
   * Bookmark URL to query for next batch of billing units. This returns `null` if no additional pages are required.
   *
   * @return the nextUrl
   */
  public String getNextUrl() {
    return nextUrl;
  }

  /**
   * Gets the resources.
   *
   * A list of billing units found.
   *
   * @return the resources
   */
  public List<BillingUnit> getResources() {
    return resources;
  }
}

