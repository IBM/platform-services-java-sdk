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
package com.ibm.cloud.platform_services.iam_identity.v1.model;

import java.util.List;

import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * Response body format for the List trusted profiles V1 REST request.
 */
public class TrustedProfilesList extends GenericModel {

  protected ResponseContext context;
  protected Long offset;
  protected Long limit;
  protected String first;
  protected String previous;
  protected String next;
  protected List<TrustedProfile> profiles;

  /**
   * Gets the context.
   *
   * Context with key properties for problem determination.
   *
   * @return the context
   */
  public ResponseContext getContext() {
    return context;
  }

  /**
   * Gets the offset.
   *
   * The offset of the current page.
   *
   * @return the offset
   */
  public Long getOffset() {
    return offset;
  }

  /**
   * Gets the limit.
   *
   * Optional size of a single page. Default is 20 items per page. Valid range is 1 to 100.
   *
   * @return the limit
   */
  public Long getLimit() {
    return limit;
  }

  /**
   * Gets the first.
   *
   * Link to the first page.
   *
   * @return the first
   */
  public String getFirst() {
    return first;
  }

  /**
   * Gets the previous.
   *
   * Link to the previous available page. If 'previous' property is not part of the response no previous page is
   * available.
   *
   * @return the previous
   */
  public String getPrevious() {
    return previous;
  }

  /**
   * Gets the next.
   *
   * Link to the next available page. If 'next' property is not part of the response no next page is available.
   *
   * @return the next
   */
  public String getNext() {
    return next;
  }

  /**
   * Gets the profiles.
   *
   * List of trusted profiles.
   *
   * @return the profiles
   */
  public List<TrustedProfile> getProfiles() {
    return profiles;
  }
}

