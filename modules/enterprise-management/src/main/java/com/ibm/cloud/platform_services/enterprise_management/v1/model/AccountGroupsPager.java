/*
 * (C) Copyright IBM Corp. 2022.
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
package com.ibm.cloud.platform_services.enterprise_management.v1.model;

import com.ibm.cloud.platform_services.enterprise_management.v1.EnterpriseManagement;
import com.ibm.cloud.sdk.core.util.UrlHelper;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

/**
 * AccountGroupsPager can be used to simplify the use of the "listAccountGroups" method.
 */
public class AccountGroupsPager {
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
  protected ListAccountGroupsOptions options;
  protected EnterpriseManagement client;
  protected PageContext pageContext;

  // Hide the default ctor.
  protected AccountGroupsPager() { }

  /**
   * Constructs a new AccountGroupsPager instance with the specified client and options model instance.
   * @param client the EnterpriseManagement instance to be used to invoke the "listAccountGroups" method
   * @param options the ListAccountGroupsOptions instance to be used to invoke the "listAccountGroups" method
   */
  public AccountGroupsPager(EnterpriseManagement client, ListAccountGroupsOptions options) {
    if (options.nextDocid() != null) {
      throw new IllegalArgumentException("The options 'nextDocid' field should not be set");
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
   * @return a List&lt;AccountGroup&gt; that contains the next page of results
   */
  public List<AccountGroup> getNext() {
    if (!hasNext()) {
      throw new NoSuchElementException("No more results available");
    }

    ListAccountGroupsOptions.Builder builder = this.options.newBuilder();
    if (this.pageContext.getNext() != null) {
      builder.nextDocid(this.pageContext.getNext());
    }
    this.options = builder.build();

    ListAccountGroupsResponse result = client.listAccountGroups(options).execute().getResult();

    String next = null;
    if (result.getNextUrl() != null) {
      String queryParam = UrlHelper.getQueryParam(result.getNextUrl(), "next_docid");
      if (queryParam != null) {
        next = queryParam;
      }
    }
    this.pageContext.setNext(next);
    if (next == null) {
      this.hasNext = false;
    }

    return result.getResources();
  }

  /**
   * Returns all results by invoking getNext() repeatedly until all pages of results have been retrieved.
   * @return a List&lt;AccountGroup&gt; containing all results returned by the "listAccountGroups" method
   */
  public List<AccountGroup> getAll() {
    List<AccountGroup> results = new ArrayList<>();
    while (hasNext()) {
      List<AccountGroup> nextPage = getNext();
      results.addAll(nextPage);
    }
    return results;
  }
}
