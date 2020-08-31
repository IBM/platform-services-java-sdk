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
package com.ibm.cloud.platform_services.configuration_governance.v1.model;

import java.util.List;

import com.google.gson.annotations.SerializedName;
import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * A list of rules.
 */
public class RuleList extends GenericModel {

  protected Long offset;
  protected Long limit;
  @SerializedName("total_count")
  protected Long totalCount;
  protected Link first;
  protected Link last;
  protected List<Rule> rules;

  /**
   * Gets the offset.
   *
   * The requested offset for the returned items.
   *
   * @return the offset
   */
  public Long getOffset() {
    return offset;
  }

  /**
   * Gets the limit.
   *
   * The requested limit for the returned items.
   *
   * @return the limit
   */
  public Long getLimit() {
    return limit;
  }

  /**
   * Gets the totalCount.
   *
   * The total number of available items.
   *
   * @return the totalCount
   */
  public Long getTotalCount() {
    return totalCount;
  }

  /**
   * Gets the first.
   *
   * The first page of available items.
   *
   * @return the first
   */
  public Link getFirst() {
    return first;
  }

  /**
   * Gets the last.
   *
   * The last page of available items.
   *
   * @return the last
   */
  public Link getLast() {
    return last;
  }

  /**
   * Gets the rules.
   *
   * An array of rules.
   *
   * @return the rules
   */
  public List<Rule> getRules() {
    return rules;
  }
}

