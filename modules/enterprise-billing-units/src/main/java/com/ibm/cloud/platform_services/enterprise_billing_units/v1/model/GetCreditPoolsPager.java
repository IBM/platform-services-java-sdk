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
package com.ibm.cloud.platform_services.enterprise_billing_units.v1.model;

import com.ibm.cloud.platform_services.enterprise_billing_units.v1.EnterpriseBillingUnits;
import com.ibm.cloud.sdk.core.util.UrlHelper;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

/**
 * GetCreditPoolsPager can be used to simplify the use of the "getCreditPools" method.
 */
public class GetCreditPoolsPager {
  private static class PageContext {
    private Long next;
    public Long getNext() {
      return next;
    }
    public void setNext(Long next) {
      this.next = next;
    }
  }

  protected boolean hasNext;
  protected GetCreditPoolsOptions options;
  protected EnterpriseBillingUnits client;
  protected PageContext pageContext;

  // Hide the default ctor.
  protected GetCreditPoolsPager() { }

  /**
   * Constructs a new GetCreditPoolsPager instance with the specified client and options model instance.
   * @param client the EnterpriseBillingUnits instance to be used to invoke the "getCreditPools" method
   * @param options the GetCreditPoolsOptions instance to be used to invoke the "getCreditPools" method
   */
  public GetCreditPoolsPager(EnterpriseBillingUnits client, GetCreditPoolsOptions options) {
    if (options.start() != null && options.start().longValue() != 0) {
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
   * @return a List&lt;CreditPool&gt; that contains the next page of results
   */
  public List<CreditPool> getNext() {
    if (!hasNext()) {
      throw new NoSuchElementException("No more results available");
    }

    GetCreditPoolsOptions.Builder builder = this.options.newBuilder();
    if (this.pageContext.getNext() != null) {
      builder.start(this.pageContext.getNext());
    }
    this.options = builder.build();

    CreditPoolsList result = client.getCreditPools(options).execute().getResult();

    Long next = null;
    if (result.getNextUrl() != null) {
      String queryParam = UrlHelper.getQueryParam(result.getNextUrl(), "start");
      if (queryParam != null) {
        next = Long.valueOf(queryParam);
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
   * @return a List&lt;CreditPool&gt; containing all results returned by the "getCreditPools" method
   */
  public List<CreditPool> getAll() {
    List<CreditPool> results = new ArrayList<>();
    while (hasNext()) {
      List<CreditPool> nextPage = getNext();
      results.addAll(nextPage);
    }
    return results;
  }
}
