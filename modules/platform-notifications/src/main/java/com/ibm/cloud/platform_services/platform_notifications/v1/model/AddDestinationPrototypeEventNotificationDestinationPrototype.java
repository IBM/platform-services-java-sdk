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

/**
 * Prototype for creating an Event Notifications destination entry.
 */
public class AddDestinationPrototypeEventNotificationDestinationPrototype extends AddDestinationPrototype {

  /**
   * The type of the destination.
   */
  public interface DestinationType {
    /** event_notifications. */
    String EVENT_NOTIFICATIONS = "event_notifications";
  }


  /**
   * Builder.
   */
  public static class Builder {
    private String destinationId;
    private String destinationType;

    /**
     * Instantiates a new Builder from an existing AddDestinationPrototypeEventNotificationDestinationPrototype instance.
     *
     * @param addDestinationPrototypeEventNotificationDestinationPrototype the instance to initialize the Builder with
     */
    public Builder(AddDestinationPrototype addDestinationPrototypeEventNotificationDestinationPrototype) {
      this.destinationId = addDestinationPrototypeEventNotificationDestinationPrototype.destinationId;
      this.destinationType = addDestinationPrototypeEventNotificationDestinationPrototype.destinationType;
    }

    /**
     * Instantiates a new builder.
     */
    public Builder() {
    }

    /**
     * Instantiates a new builder with required properties.
     *
     * @param destinationId the destinationId
     * @param destinationType the destinationType
     */
    public Builder(String destinationId, String destinationType) {
      this.destinationId = destinationId;
      this.destinationType = destinationType;
    }

    /**
     * Builds a AddDestinationPrototypeEventNotificationDestinationPrototype.
     *
     * @return the new AddDestinationPrototypeEventNotificationDestinationPrototype instance
     */
    public AddDestinationPrototypeEventNotificationDestinationPrototype build() {
      return new AddDestinationPrototypeEventNotificationDestinationPrototype(this);
    }

    /**
     * Set the destinationId.
     *
     * @param destinationId the destinationId
     * @return the AddDestinationPrototypeEventNotificationDestinationPrototype builder
     */
    public Builder destinationId(String destinationId) {
      this.destinationId = destinationId;
      return this;
    }

    /**
     * Set the destinationType.
     *
     * @param destinationType the destinationType
     * @return the AddDestinationPrototypeEventNotificationDestinationPrototype builder
     */
    public Builder destinationType(String destinationType) {
      this.destinationType = destinationType;
      return this;
    }
  }

  protected AddDestinationPrototypeEventNotificationDestinationPrototype() { }

  protected AddDestinationPrototypeEventNotificationDestinationPrototype(Builder builder) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.destinationId,
      "destinationId cannot be null");
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.destinationType,
      "destinationType cannot be null");
    destinationId = builder.destinationId;
    destinationType = builder.destinationType;
  }

  /**
   * New builder.
   *
   * @return a AddDestinationPrototypeEventNotificationDestinationPrototype builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }
}

