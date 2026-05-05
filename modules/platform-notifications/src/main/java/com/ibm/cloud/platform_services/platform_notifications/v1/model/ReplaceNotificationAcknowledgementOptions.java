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

import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * The replaceNotificationAcknowledgement options.
 */
public class ReplaceNotificationAcknowledgementOptions extends GenericModel {

  protected String lastAcknowledgedId;
  protected String accountId;

  /**
   * Builder.
   */
  public static class Builder {
    private String lastAcknowledgedId;
    private String accountId;

    /**
     * Instantiates a new Builder from an existing ReplaceNotificationAcknowledgementOptions instance.
     *
     * @param replaceNotificationAcknowledgementOptions the instance to initialize the Builder with
     */
    private Builder(ReplaceNotificationAcknowledgementOptions replaceNotificationAcknowledgementOptions) {
      this.lastAcknowledgedId = replaceNotificationAcknowledgementOptions.lastAcknowledgedId;
      this.accountId = replaceNotificationAcknowledgementOptions.accountId;
    }

    /**
     * Instantiates a new builder.
     */
    public Builder() {
    }

    /**
     * Instantiates a new builder with required properties.
     *
     * @param lastAcknowledgedId the lastAcknowledgedId
     */
    public Builder(String lastAcknowledgedId) {
      this.lastAcknowledgedId = lastAcknowledgedId;
    }

    /**
     * Builds a ReplaceNotificationAcknowledgementOptions.
     *
     * @return the new ReplaceNotificationAcknowledgementOptions instance
     */
    public ReplaceNotificationAcknowledgementOptions build() {
      return new ReplaceNotificationAcknowledgementOptions(this);
    }

    /**
     * Set the lastAcknowledgedId.
     *
     * @param lastAcknowledgedId the lastAcknowledgedId
     * @return the ReplaceNotificationAcknowledgementOptions builder
     */
    public Builder lastAcknowledgedId(String lastAcknowledgedId) {
      this.lastAcknowledgedId = lastAcknowledgedId;
      return this;
    }

    /**
     * Set the accountId.
     *
     * @param accountId the accountId
     * @return the ReplaceNotificationAcknowledgementOptions builder
     */
    public Builder accountId(String accountId) {
      this.accountId = accountId;
      return this;
    }
  }

  protected ReplaceNotificationAcknowledgementOptions() { }

  protected ReplaceNotificationAcknowledgementOptions(Builder builder) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.lastAcknowledgedId,
      "lastAcknowledgedId cannot be null");
    lastAcknowledgedId = builder.lastAcknowledgedId;
    accountId = builder.accountId;
  }

  /**
   * New builder.
   *
   * @return a ReplaceNotificationAcknowledgementOptions builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the lastAcknowledgedId.
   *
   * The ID of a notification.
   *
   * @return the lastAcknowledgedId
   */
  public String lastAcknowledgedId() {
    return lastAcknowledgedId;
  }

  /**
   * Gets the accountId.
   *
   * The account ID to update acknowledgement for.
   *
   * @return the accountId
   */
  public String accountId() {
    return accountId;
  }
}

