/*
 * (C) Copyright IBM Corp. 2021.
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
package com.ibm.cloud.platform_services.resource_controller.v2.model;

import java.util.List;

import com.google.gson.annotations.SerializedName;
import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * A list of resource bindings.
 */
public class ResourceBindingsList extends GenericModel {

  @SerializedName("next_url")
  protected String nextUrl;
  protected List<ResourceBinding> resources;
  @SerializedName("rows_count")
  protected Long rowsCount;

  /**
   * Gets the nextUrl.
   *
   * The URL for requesting the next page of results.
   *
   * @return the nextUrl
   */
  public String getNextUrl() {
    return nextUrl;
  }

  /**
   * Gets the resources.
   *
   * A list of resource bindings.
   *
   * @return the resources
   */
  public List<ResourceBinding> getResources() {
    return resources;
  }

  /**
   * Gets the rowsCount.
   *
   * The number of resource bindings in `resources`.
   *
   * @return the rowsCount
   */
  public Long getRowsCount() {
    return rowsCount;
  }
}

