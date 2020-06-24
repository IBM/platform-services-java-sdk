/*
 * (C) Copyright IBM Corp. 2020.
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
package com.ibm.cloud.platform_services.open_service_broker.v1.model;

import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * The replaceState options.
 */
public class ReplaceStateOptions extends GenericModel {

  protected String instanceId;
  protected Boolean enabled;
  protected String initiatorId;
  protected String reasonCode;

  /**
   * Builder.
   */
  public static class Builder {
    private String instanceId;
    private Boolean enabled;
    private String initiatorId;
    private String reasonCode;

    private Builder(ReplaceStateOptions replaceStateOptions) {
      this.instanceId = replaceStateOptions.instanceId;
      this.enabled = replaceStateOptions.enabled;
      this.initiatorId = replaceStateOptions.initiatorId;
      this.reasonCode = replaceStateOptions.reasonCode;
    }

    /**
     * Instantiates a new builder.
     */
    public Builder() {
    }

    /**
     * Instantiates a new builder with required properties.
     *
     * @param instanceId the instanceId
     */
    public Builder(String instanceId) {
      this.instanceId = instanceId;
    }

    /**
     * Builds a ReplaceStateOptions.
     *
     * @return the new ReplaceStateOptions instance
     */
    public ReplaceStateOptions build() {
      return new ReplaceStateOptions(this);
    }

    /**
     * Set the instanceId.
     *
     * @param instanceId the instanceId
     * @return the ReplaceStateOptions builder
     */
    public Builder instanceId(String instanceId) {
      this.instanceId = instanceId;
      return this;
    }

    /**
     * Set the enabled.
     *
     * @param enabled the enabled
     * @return the ReplaceStateOptions builder
     */
    public Builder enabled(Boolean enabled) {
      this.enabled = enabled;
      return this;
    }

    /**
     * Set the initiatorId.
     *
     * @param initiatorId the initiatorId
     * @return the ReplaceStateOptions builder
     */
    public Builder initiatorId(String initiatorId) {
      this.initiatorId = initiatorId;
      return this;
    }

    /**
     * Set the reasonCode.
     *
     * @param reasonCode the reasonCode
     * @return the ReplaceStateOptions builder
     */
    public Builder reasonCode(String reasonCode) {
      this.reasonCode = reasonCode;
      return this;
    }
  }

  protected ReplaceStateOptions(Builder builder) {
    com.ibm.cloud.sdk.core.util.Validator.notEmpty(builder.instanceId,
      "instanceId cannot be empty");
    instanceId = builder.instanceId;
    enabled = builder.enabled;
    initiatorId = builder.initiatorId;
    reasonCode = builder.reasonCode;
  }

  /**
   * New builder.
   *
   * @return a ReplaceStateOptions builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the instanceId.
   *
   * The `instance_id` of a service instance is provided by the IBM Cloud platform. This ID will be used for future
   * requests to bind and deprovision, so the broker can use it to correlate the resource it creates.
   *
   * @return the instanceId
   */
  public String instanceId() {
    return instanceId;
  }

  /**
   * Gets the enabled.
   *
   * Indicates the current state of the service instance.
   *
   * @return the enabled
   */
  public Boolean enabled() {
    return enabled;
  }

  /**
   * Gets the initiatorId.
   *
   * Optional string that shows the user ID that is initiating the call.
   *
   * @return the initiatorId
   */
  public String initiatorId() {
    return initiatorId;
  }

  /**
   * Gets the reasonCode.
   *
   * Optional string that states the reason code for the service instance state change. Valid values are
   * `IBMCLOUD_ACCT_ACTIVATE`, `IBMCLOUD_RECLAMATION_RESTORE`, or `IBMCLOUD_SERVICE_INSTANCE_BELOW_CAP` for enable
   * calls; `IBMCLOUD_ACCT_SUSPEND`, `IBMCLOUD_RECLAMATION_SCHEDULE`, or `IBMCLOUD_SERVICE_INSTANCE_ABOVE_CAP` for
   * disable calls; and `IBMCLOUD_ADMIN_REQUEST` for enable and disable calls.&lt;br/&gt;&lt;br/&gt;Previously accepted
   * values had a `BMX_` prefix, such as `BMX_ACCT_ACTIVATE`. These values are deprecated.
   *
   * @return the reasonCode
   */
  public String reasonCode() {
    return reasonCode;
  }
}

