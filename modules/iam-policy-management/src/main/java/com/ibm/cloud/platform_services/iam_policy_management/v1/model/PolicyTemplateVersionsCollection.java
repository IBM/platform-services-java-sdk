/*
 * (C) Copyright IBM Corp. 2025.
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

package com.ibm.cloud.platform_services.iam_policy_management.v1.model;

import java.util.List;

import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * A collection of versions for a specific policy template.
 */
public class PolicyTemplateVersionsCollection extends GenericModel {

  protected Long limit;
  protected First first;
  protected Next next;
  protected Previous previous;
  protected List<PolicyTemplate> versions;

  protected PolicyTemplateVersionsCollection() { }

  /**
   * Gets the limit.
   *
   * The number of documents to include per each page of collection.
   *
   * @return the limit
   */
  public Long getLimit() {
    return limit;
  }

  /**
   * Gets the first.
   *
   * Details with href linking to first page of requested collection.
   *
   * @return the first
   */
  public First getFirst() {
    return first;
  }

  /**
   * Gets the next.
   *
   * Details with href linking to following page of requested collection.
   *
   * @return the next
   */
  public Next getNext() {
    return next;
  }

  /**
   * Gets the previous.
   *
   * Details with href linking to previous page of requested collection.
   *
   * @return the previous
   */
  public Previous getPrevious() {
    return previous;
  }

  /**
   * Gets the versions.
   *
   * List of policy templates versions.
   *
   * @return the versions
   */
  public List<PolicyTemplate> getVersions() {
    return versions;
  }
}

