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
package com.ibm.cloud.platform_services.global_catalog.v1.model;

import java.util.List;

import com.google.gson.annotations.SerializedName;
import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * The results obtained by performing a search.
 */
public class SearchResult extends GenericModel {

  protected String page;
  @SerializedName("results_per_page")
  protected String resultsPerPage;
  @SerializedName("total_results")
  protected String totalResults;
  protected List<Object> resources;

  /**
   * Gets the page.
   *
   * Returned Page Number.
   *
   * @return the page
   */
  public String getPage() {
    return page;
  }

  /**
   * Gets the resultsPerPage.
   *
   * Results Per Page – if the page is full.
   *
   * @return the resultsPerPage
   */
  public String getResultsPerPage() {
    return resultsPerPage;
  }

  /**
   * Gets the totalResults.
   *
   * Total number of results.
   *
   * @return the totalResults
   */
  public String getTotalResults() {
    return totalResults;
  }

  /**
   * Gets the resources.
   *
   * Resulting objects.
   *
   * @return the resources
   */
  public List<Object> getResources() {
    return resources;
  }
}

