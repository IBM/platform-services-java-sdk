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
package com.ibm.cloud.platform_services.case_management.v1.model;

import java.util.List;

import com.google.gson.annotations.SerializedName;
import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * Response of a GET /cases request.
 */
public class CaseList extends GenericModel {

  @SerializedName("total_count")
  protected Long totalCount;
  protected PaginationLink first;
  protected PaginationLink next;
  protected PaginationLink previous;
  protected PaginationLink last;
  protected List<Case> cases;

  /**
   * Gets the totalCount.
   *
   * Total number of cases satisfying the query.
   *
   * @return the totalCount
   */
  public Long getTotalCount() {
    return totalCount;
  }

  /**
   * Gets the first.
   *
   * Container for URL pointer to related pages of cases.
   *
   * @return the first
   */
  public PaginationLink getFirst() {
    return first;
  }

  /**
   * Gets the next.
   *
   * Container for URL pointer to related pages of cases.
   *
   * @return the next
   */
  public PaginationLink getNext() {
    return next;
  }

  /**
   * Gets the previous.
   *
   * Container for URL pointer to related pages of cases.
   *
   * @return the previous
   */
  public PaginationLink getPrevious() {
    return previous;
  }

  /**
   * Gets the last.
   *
   * Container for URL pointer to related pages of cases.
   *
   * @return the last
   */
  public PaginationLink getLast() {
    return last;
  }

  /**
   * Gets the cases.
   *
   * List of cases.
   *
   * @return the cases
   */
  public List<Case> getCases() {
    return cases;
  }
}

