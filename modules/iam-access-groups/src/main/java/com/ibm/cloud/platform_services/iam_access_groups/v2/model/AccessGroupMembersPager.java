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
package com.ibm.cloud.platform_services.iam_access_groups.v2.model;

import com.ibm.cloud.platform_services.iam_access_groups.v2.IamAccessGroups;
import com.ibm.cloud.sdk.core.util.UrlHelper;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

/**
 * AccessGroupMembersPager can be used to simplify the use of the "listAccessGroupMembers" method.
 */
public class AccessGroupMembersPager {
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
  protected ListAccessGroupMembersOptions options;
  protected IamAccessGroups client;
  protected PageContext pageContext;

  // Hide the default ctor.
  protected AccessGroupMembersPager() { }

  /**
   * Constructs a new AccessGroupMembersPager instance with the specified client and options model instance.
   * @param client the IamAccessGroups instance to be used to invoke the "listAccessGroupMembers" method
   * @param options the ListAccessGroupMembersOptions instance to be used to invoke the "listAccessGroupMembers" method
   */
  public AccessGroupMembersPager(IamAccessGroups client, ListAccessGroupMembersOptions options) {
    if (options.offset() != null && options.offset().longValue() != 0) {
      throw new IllegalArgumentException("The options 'offset' field should not be set");
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
   * @return a List&lt;ListGroupMembersResponseMember&gt; that contains the next page of results
   */
  public List<ListGroupMembersResponseMember> getNext() {
    if (!hasNext()) {
      throw new NoSuchElementException("No more results available");
    }

    ListAccessGroupMembersOptions.Builder builder = this.options.newBuilder();
    if (this.pageContext.getNext() != null) {
      builder.offset(this.pageContext.getNext());
    }
    this.options = builder.build();

    GroupMembersList result = client.listAccessGroupMembers(options).execute().getResult();

    Long next = null;
    if (result.getNext() != null) {
      String queryParam = UrlHelper.getQueryParam(result.getNext().getHref(), "offset");
      if (queryParam != null) {
        next = Long.valueOf(queryParam);
      }
    }
    this.pageContext.setNext(next);
    if (next == null) {
      this.hasNext = false;
    }

    return result.getMembers();
  }

  /**
   * Returns all results by invoking getNext() repeatedly until all pages of results have been retrieved.
   * @return a List&lt;ListGroupMembersResponseMember&gt; containing all results returned by the "listAccessGroupMembers" method
   */
  public List<ListGroupMembersResponseMember> getAll() {
    List<ListGroupMembersResponseMember> results = new ArrayList<>();
    while (hasNext()) {
      List<ListGroupMembersResponseMember> nextPage = getNext();
      results.addAll(nextPage);
    }
    return results;
  }
}
