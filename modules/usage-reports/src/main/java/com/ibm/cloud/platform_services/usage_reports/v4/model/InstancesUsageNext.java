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
package com.ibm.cloud.platform_services.usage_reports.v4.model;

import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * The link to the next page of the search query.
 */
public class InstancesUsageNext extends GenericModel {

  protected String href;
  protected String offset;

  protected InstancesUsageNext() { }

  /**
   * Gets the href.
   *
   * A link to a page of query results.
   *
   * @return the href
   */
  public String getHref() {
    return href;
  }

  /**
   * Gets the offset.
   *
   * The value of the `_start` query parameter to fetch the next page.
   *
   * @return the offset
   */
  public String getOffset() {
    return offset;
  }
}

