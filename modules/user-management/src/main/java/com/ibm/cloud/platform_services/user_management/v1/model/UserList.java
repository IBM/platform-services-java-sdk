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
package com.ibm.cloud.platform_services.user_management.v1.model;

import java.util.List;

import com.google.gson.annotations.SerializedName;
import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * The users returned.
 */
public class UserList extends GenericModel {

  @SerializedName("total_results")
  protected Double totalResults;
  protected Double limit;
  @SerializedName("first_url")
  protected String firstUrl;
  @SerializedName("next_url")
  protected String nextUrl;
  protected List<UserProfile> resources;

  /**
   * Gets the totalResults.
   *
   * The number of users returned.
   *
   * @return the totalResults
   */
  public Double getTotalResults() {
    return totalResults;
  }

  /**
   * Gets the limit.
   *
   * A limit to the number of users returned in a page.
   *
   * @return the limit
   */
  public Double getLimit() {
    return limit;
  }

  /**
   * Gets the firstUrl.
   *
   * The first URL of the get users API.
   *
   * @return the firstUrl
   */
  public String getFirstUrl() {
    return firstUrl;
  }

  /**
   * Gets the nextUrl.
   *
   * The next URL of the get users API.
   *
   * @return the nextUrl
   */
  public String getNextUrl() {
    return nextUrl;
  }

  /**
   * Gets the resources.
   *
   * A list of users in the account.
   *
   * @return the resources
   */
  public List<UserProfile> getResources() {
    return resources;
  }
}

