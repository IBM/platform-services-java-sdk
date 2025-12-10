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

import com.ibm.cloud.platform_services.iam_policy_management.v1.IamPolicyManagement;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

/**
 * PoliciesPager can be used to simplify the use of the "listPolicies" method.
 */
public class PoliciesPager {
  private static class PageContext {
    private String next;
    public String getNext() {
      return next;
    }
    public void setNext(String next) {
      this.next = next;
    }
  }

  protected boolean hasNext;
  protected ListPoliciesOptions options;
  protected IamPolicyManagement client;
  protected PageContext pageContext;

  // Hide the default ctor.
  protected PoliciesPager() { }

  /**
   * Constructs a new PoliciesPager instance with the specified client and options model instance.
   * @param client the IamPolicyManagement instance to be used to invoke the "listPolicies" method
   * @param options the ListPoliciesOptions instance to be used to invoke the "listPolicies" method
   */
  public PoliciesPager(IamPolicyManagement client, ListPoliciesOptions options) {
    if (options.start() != null) {
      throw new IllegalArgumentException("The options 'start' field should not be set");
    }

    this.hasNext = true;
    this.client = client;
    this.options = options.newBuilder().build();
    this.pageContext = new PageContext();
  }

  /**
   * Returns true if there are more results to be retrieved.
   * @return boolean
   */
  public boolean hasNext() {
    return hasNext;
  }

  /**
   * Returns the next page of results.
   * @return a List&lt;PolicyTemplateMetaData&gt; that contains the next page of results
   */
  public List<PolicyTemplateMetaData> getNext() {
    if (!hasNext()) {
      throw new NoSuchElementException("No more results available");
    }

    ListPoliciesOptions.Builder builder = this.options.newBuilder();
    if (this.pageContext.getNext() != null) {
      builder.start(this.pageContext.getNext());
    }
    this.options = builder.build();

    PolicyCollection result = client.listPolicies(options).execute().getResult();

    String next = null;
    if (result.getNext() != null) {
      next = result.getNext().getStart();
    }
    this.pageContext.setNext(next);
    if (next == null) {
      this.hasNext = false;
    }

    return result.getPolicies();
  }

  /**
   * Returns all results by invoking getNext() repeatedly until all pages of results have been retrieved.
   * @return a List&lt;PolicyTemplateMetaData&gt; containing all results returned by the "listPolicies" method
   */
  public List<PolicyTemplateMetaData> getAll() {
    List<PolicyTemplateMetaData> results = new ArrayList<>();
    while (hasNext()) {
      List<PolicyTemplateMetaData> nextPage = getNext();
      results.addAll(nextPage);
    }
    return results;
  }
}
