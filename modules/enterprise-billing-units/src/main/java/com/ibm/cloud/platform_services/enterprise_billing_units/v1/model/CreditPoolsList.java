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
package com.ibm.cloud.platform_services.enterprise_billing_units.v1.model;

import java.util.List;

import com.google.gson.annotations.SerializedName;
import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * A search result containing zero or more credit pools.
 */
public class CreditPoolsList extends GenericModel {

  @SerializedName("rows_count")
  protected Long rowsCount;
  @SerializedName("next_url")
  protected String nextUrl;
  protected List<CreditPool> resources;

  /**
   * Gets the rowsCount.
   *
   * The number of credit pools that were found by the query.
   *
   * @return the rowsCount
   */
  public Long getRowsCount() {
    return rowsCount;
  }

  /**
   * Gets the nextUrl.
   *
   * A bookmark URL to the query for the next batch of billing units. Use a value of `null` if no additional pages are
   * required.
   *
   * @return the nextUrl
   */
  public String getNextUrl() {
    return nextUrl;
  }

  /**
   * Gets the resources.
   *
   * A list of credit pools found by the query.
   *
   * @return the resources
   */
  public List<CreditPool> getResources() {
    return resources;
  }
}

