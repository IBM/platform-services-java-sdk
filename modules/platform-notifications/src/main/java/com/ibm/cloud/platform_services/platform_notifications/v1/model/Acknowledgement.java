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

import com.google.gson.annotations.SerializedName;
import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * Status indicating whether the user has unread notifications.
 */
public class Acknowledgement extends GenericModel {

  @SerializedName("has_unread")
  protected Boolean hasUnread;
  @SerializedName("latest_notification_id")
  protected String latestNotificationId;
  @SerializedName("last_acknowledged_id")
  protected String lastAcknowledgedId;

  protected Acknowledgement() { }

  /**
   * Gets the hasUnread.
   *
   * Indicates whether the user has unread notifications.
   *
   * @return the hasUnread
   */
  public Boolean isHasUnread() {
    return hasUnread;
  }

  /**
   * Gets the latestNotificationId.
   *
   * The ID of the most recent notification available to the user.
   *
   * @return the latestNotificationId
   */
  public String getLatestNotificationId() {
    return latestNotificationId;
  }

  /**
   * Gets the lastAcknowledgedId.
   *
   * The ID of the last notification acknowledged by the user.
   *
   * @return the lastAcknowledgedId
   */
  public String getLastAcknowledgedId() {
    return lastAcknowledgedId;
  }
}

