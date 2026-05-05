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
 * AddDestinationPrototype.
 *
 * Classes which extend this class:
 * - AddDestinationPrototypeEventNotificationDestinationPrototype
 */
public class AddDestinationPrototype extends GenericModel {
  @SuppressWarnings("unused")
  protected static String discriminatorPropertyName = "destination_type";
  protected static java.util.Map<String, Class<?>> discriminatorMapping;
  static {
    discriminatorMapping = new java.util.HashMap<>();
    discriminatorMapping.put("event_notifications", AddDestinationPrototypeEventNotificationDestinationPrototype.class);
  }
  /**
   * The type of the destination.
   */
  public interface DestinationType {
    /** event_notifications. */
    String EVENT_NOTIFICATIONS = "event_notifications";
  }

  @SerializedName("destination_id")
  protected String destinationId;
  @SerializedName("destination_type")
  protected String destinationType;

  protected AddDestinationPrototype() { }

  /**
   * Gets the destinationId.
   *
   * The GUID of the Event Notifications instance.
   *
   * @return the destinationId
   */
  public String destinationId() {
    return destinationId;
  }

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
}

