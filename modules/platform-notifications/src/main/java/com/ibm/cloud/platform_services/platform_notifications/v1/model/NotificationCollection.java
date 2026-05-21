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

import java.util.List;

import com.google.gson.annotations.SerializedName;
import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * Collection of user notifications with token-based pagination metadata.
 */
public class NotificationCollection extends GenericModel {

  protected Long limit;
  @SerializedName("total_count")
  protected Long totalCount;
  protected PaginationLink first;
  protected PaginationLinkWithToken previous;
  protected PaginationLinkWithToken next;
  protected PaginationLinkWithToken last;
  protected List<Notification> notifications;

  protected NotificationCollection() { }

  /**
   * Gets the limit.
   *
   * The maximum number of items returned in this response.
   *
   * @return the limit
   */
  public Long getLimit() {
    return limit;
  }

  /**
   * Gets the totalCount.
   *
   * The total number of notifications in the collection.
   *
   * @return the totalCount
   */
  public Long getTotalCount() {
    return totalCount;
  }

  /**
   * Gets the first.
   *
   * A pagination link object containing the URL to a page.
   *
   * @return the first
   */
  public PaginationLink getFirst() {
    return first;
  }

  /**
   * Gets the previous.
   *
   * A pagination link object with a page token. Used for next, previous, and last page links.
   *
   * @return the previous
   */
  public PaginationLinkWithToken getPrevious() {
    return previous;
  }

  /**
   * Gets the next.
   *
   * A pagination link object with a page token. Used for next, previous, and last page links.
   *
   * @return the next
   */
  public PaginationLinkWithToken getNext() {
    return next;
  }

  /**
   * Gets the last.
   *
   * A pagination link object with a page token. Used for next, previous, and last page links.
   *
   * @return the last
   */
  public PaginationLinkWithToken getLast() {
    return last;
  }

  /**
   * Gets the notifications.
   *
   * Array of notification entries.
   *
   * @return the notifications
   */
  public List<Notification> getNotifications() {
    return notifications;
  }
}

