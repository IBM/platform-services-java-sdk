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
 * TestDestinationRequestBodyPrototype.
 *
 * Classes which extend this class:
 * - TestDestinationRequestBodyPrototypeTestEventNotificationDestinationRequestBodyPrototype
 */
public class TestDestinationRequestBodyPrototype extends GenericModel {
  @SuppressWarnings("unused")
  protected static String discriminatorPropertyName = "destination_type";
  protected static java.util.Map<String, Class<?>> discriminatorMapping;
  static {
    discriminatorMapping = new java.util.HashMap<>();
    discriminatorMapping.put("event_notifications", TestDestinationRequestBodyPrototypeTestEventNotificationDestinationRequestBodyPrototype.class);
  }
  /**
   * The type of the destination.
   */
  public interface DestinationType {
    /** event_notifications. */
    String EVENT_NOTIFICATIONS = "event_notifications";
  }

  /**
   * The type of the notification to test.
   */
  public interface NotificationType {
    /** incident. */
    String INCIDENT = "incident";
    /** announcements. */
    String ANNOUNCEMENTS = "announcements";
    /** maintenance. */
    String MAINTENANCE = "maintenance";
    /** security_bulletins. */
    String SECURITY_BULLETINS = "security_bulletins";
    /** resource. */
    String RESOURCE = "resource";
    /** billing_and_usage. */
    String BILLING_AND_USAGE = "billing_and_usage";
  }

  @SerializedName("destination_type")
  protected String destinationType;
  @SerializedName("notification_type")
  protected String notificationType;

  protected TestDestinationRequestBodyPrototype() { }

  /**
   * Gets the destinationType.
   *
   * The type of the destination.
   *
   * @return the destinationType
   */
  public String destinationType() {
    return destinationType;
  }

  /**
   * Gets the notificationType.
   *
   * The type of the notification to test.
   *
   * @return the notificationType
   */
  public String notificationType() {
    return notificationType;
  }
}

