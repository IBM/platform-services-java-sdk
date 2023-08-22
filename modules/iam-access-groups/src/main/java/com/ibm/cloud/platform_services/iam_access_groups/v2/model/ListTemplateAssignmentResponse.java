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
package com.ibm.cloud.platform_services.iam_access_groups.v2.model;

import java.util.List;

import com.google.gson.annotations.SerializedName;
import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * Response object containing a list of template assignments.
 */
public class ListTemplateAssignmentResponse extends GenericModel {

  protected Long limit;
  protected Long offset;
  @SerializedName("total_count")
  protected Long totalCount;
  protected HrefStruct first;
  protected HrefStruct last;
  protected List<TemplateAssignmentResponse> assignments;

  protected ListTemplateAssignmentResponse() { }

  /**
   * Gets the limit.
   *
   * Maximum number of items returned in the response.
   *
   * @return the limit
   */
  public Long getLimit() {
    return limit;
  }

  /**
   * Gets the offset.
   *
   * Index of the first item returned in the response.
   *
   * @return the offset
   */
  public Long getOffset() {
    return offset;
  }

  /**
   * Gets the totalCount.
   *
   * Total number of items matching the query.
   *
   * @return the totalCount
   */
  public Long getTotalCount() {
    return totalCount;
  }

  /**
   * Gets the first.
   *
   * A link object.
   *
   * @return the first
   */
  public HrefStruct getFirst() {
    return first;
  }

  /**
   * Gets the last.
   *
   * A link object.
   *
   * @return the last
   */
  public HrefStruct getLast() {
    return last;
  }

  /**
   * Gets the assignments.
   *
   * List of template assignments.
   *
   * @return the assignments
   */
  public List<TemplateAssignmentResponse> getAssignments() {
    return assignments;
  }
}

