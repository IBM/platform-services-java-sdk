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

  protected Long lastAcknowledged;
  protected String accountId;

  /**
   * Builder.
   */
  public static class Builder {
    private Long lastAcknowledged;
    private String accountId;

    /**
     * Instantiates a new Builder from an existing ReplaceNotificationAcknowledgementOptions instance.
     *
     * @param replaceNotificationAcknowledgementOptions the instance to initialize the Builder with
     */
    private Builder(ReplaceNotificationAcknowledgementOptions replaceNotificationAcknowledgementOptions) {
      this.lastAcknowledged = replaceNotificationAcknowledgementOptions.lastAcknowledged;
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
     * @param lastAcknowledged the lastAcknowledged
     */
    public Builder(Long lastAcknowledged) {
      this.lastAcknowledged = lastAcknowledged;
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
     * Set the lastAcknowledged.
     *
     * @param lastAcknowledged the lastAcknowledged
     * @return the ReplaceNotificationAcknowledgementOptions builder
     */
    public Builder lastAcknowledged(long lastAcknowledged) {
      this.lastAcknowledged = lastAcknowledged;
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
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.lastAcknowledged,
      "lastAcknowledged cannot be null");
    lastAcknowledged = builder.lastAcknowledged;
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
   * Gets the lastAcknowledged.
   *
   * The timestamp of the last acknowledgement.
   *
   * @return the lastAcknowledged
   */
  public Long lastAcknowledged() {
    return lastAcknowledged;
  }

  /**
   * Gets the accountId.
   *
   * The IBM Cloud account ID. If not provided, the account ID from the bearer token will be used.
   *
   * @return the accountId
   */
  public String accountId() {
    return accountId;
  }
}

