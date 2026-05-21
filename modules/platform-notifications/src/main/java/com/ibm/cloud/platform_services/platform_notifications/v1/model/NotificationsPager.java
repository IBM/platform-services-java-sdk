/*
 * (C) Copyright IBM Corp. 2026.
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

package com.ibm.cloud.platform_services.platform_notifications.v1.model;

import com.ibm.cloud.platform_services.platform_notifications.v1.PlatformNotifications;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

/**
 * NotificationsPager can be used to simplify the use of the "listNotifications" method.
 */
public class NotificationsPager {
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
  protected ListNotificationsOptions options;
  protected PlatformNotifications client;
  protected PageContext pageContext;

  // Hide the default ctor.
  protected NotificationsPager() { }

  /**
   * Constructs a new NotificationsPager instance with the specified client and options model instance.
   * @param client the PlatformNotifications instance to be used to invoke the "listNotifications" method
   * @param options the ListNotificationsOptions instance to be used to invoke the "listNotifications" method
   */
  public NotificationsPager(PlatformNotifications client, ListNotificationsOptions options) {
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
   * @return a List&lt;Notification&gt; that contains the next page of results
   */
  public List<Notification> getNext() {
    if (!hasNext()) {
      throw new NoSuchElementException("No more results available");
    }

    ListNotificationsOptions.Builder builder = this.options.newBuilder();
    if (this.pageContext.getNext() != null) {
      builder.start(this.pageContext.getNext());
    }
    this.options = builder.build();

    NotificationCollection result = client.listNotifications(options).execute().getResult();

    String next = null;
    if (result.getNext() != null) {
      next = result.getNext().getStart();
    }
    this.pageContext.setNext(next);
    if (next == null) {
      this.hasNext = false;
    }

    return result.getNotifications();
  }

  /**
   * Returns all results by invoking getNext() repeatedly until all pages of results have been retrieved.
   * @return a List&lt;Notification&gt; containing all results returned by the "listNotifications" method
   */
  public List<Notification> getAll() {
    List<Notification> results = new ArrayList<>();
    while (hasNext()) {
      List<Notification> nextPage = getNext();
      results.addAll(nextPage);
    }
    return results;
  }
}
