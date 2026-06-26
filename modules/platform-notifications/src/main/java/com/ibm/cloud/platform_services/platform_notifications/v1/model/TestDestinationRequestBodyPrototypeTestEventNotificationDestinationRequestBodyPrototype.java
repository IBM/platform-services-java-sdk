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
 * Request body for testing an Event Notifications destination.
 */
public class TestDestinationRequestBodyPrototypeTestEventNotificationDestinationRequestBodyPrototype extends TestDestinationRequestBodyPrototype {

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


  /**
   * Builder.
   */
  public static class Builder {
    private String destinationType;
    private String notificationType;

    /**
     * Instantiates a new Builder from an existing TestDestinationRequestBodyPrototypeTestEventNotificationDestinationRequestBodyPrototype instance.
     *
     * @param testDestinationRequestBodyPrototypeTestEventNotificationDestinationRequestBodyPrototype the instance to initialize the Builder with
     */
    public Builder(TestDestinationRequestBodyPrototype testDestinationRequestBodyPrototypeTestEventNotificationDestinationRequestBodyPrototype) {
      this.destinationType = testDestinationRequestBodyPrototypeTestEventNotificationDestinationRequestBodyPrototype.destinationType;
      this.notificationType = testDestinationRequestBodyPrototypeTestEventNotificationDestinationRequestBodyPrototype.notificationType;
    }

    /**
     * Instantiates a new builder.
     */
    public Builder() {
    }

    /**
     * Instantiates a new builder with required properties.
     *
     * @param destinationType the destinationType
     * @param notificationType the notificationType
     */
    public Builder(String destinationType, String notificationType) {
      this.destinationType = destinationType;
      this.notificationType = notificationType;
    }

    /**
     * Builds a TestDestinationRequestBodyPrototypeTestEventNotificationDestinationRequestBodyPrototype.
     *
     * @return the new TestDestinationRequestBodyPrototypeTestEventNotificationDestinationRequestBodyPrototype instance
     */
    public TestDestinationRequestBodyPrototypeTestEventNotificationDestinationRequestBodyPrototype build() {
      return new TestDestinationRequestBodyPrototypeTestEventNotificationDestinationRequestBodyPrototype(this);
    }

    /**
     * Set the destinationType.
     *
     * @param destinationType the destinationType
     * @return the TestDestinationRequestBodyPrototypeTestEventNotificationDestinationRequestBodyPrototype builder
     */
    public Builder destinationType(String destinationType) {
      this.destinationType = destinationType;
      return this;
    }

    /**
     * Set the notificationType.
     *
     * @param notificationType the notificationType
     * @return the TestDestinationRequestBodyPrototypeTestEventNotificationDestinationRequestBodyPrototype builder
     */
    public Builder notificationType(String notificationType) {
      this.notificationType = notificationType;
      return this;
    }
  }

  protected TestDestinationRequestBodyPrototypeTestEventNotificationDestinationRequestBodyPrototype() { }

  protected TestDestinationRequestBodyPrototypeTestEventNotificationDestinationRequestBodyPrototype(Builder builder) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.destinationType,
      "destinationType cannot be null");
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.notificationType,
      "notificationType cannot be null");
    destinationType = builder.destinationType;
    notificationType = builder.notificationType;
  }

  /**
   * New builder.
   *
   * @return a TestDestinationRequestBodyPrototypeTestEventNotificationDestinationRequestBodyPrototype builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }
}

