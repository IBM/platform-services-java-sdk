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
package com.ibm.cloud.platform_services.case_management.v1.model;

import com.google.gson.annotations.SerializedName;
import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * Specify if the case should be treated as EU regulated. Only one of the following properties is required. Call EU
 * support utility endpoint to determine which property must be specified for your account.
 */
public class CasePayloadEu extends GenericModel {

  protected Boolean supported;
  @SerializedName("data_center")
  protected Long dataCenter;

  /**
   * Builder.
   */
  public static class Builder {
    private Boolean supported;
    private Long dataCenter;

    private Builder(CasePayloadEu casePayloadEu) {
      this.supported = casePayloadEu.supported;
      this.dataCenter = casePayloadEu.dataCenter;
    }

    /**
     * Instantiates a new builder.
     */
    public Builder() {
    }

    /**
     * Builds a CasePayloadEu.
     *
     * @return the new CasePayloadEu instance
     */
    public CasePayloadEu build() {
      return new CasePayloadEu(this);
    }

    /**
     * Set the supported.
     *
     * @param supported the supported
     * @return the CasePayloadEu builder
     */
    public Builder supported(Boolean supported) {
      this.supported = supported;
      return this;
    }

    /**
     * Set the dataCenter.
     *
     * @param dataCenter the dataCenter
     * @return the CasePayloadEu builder
     */
    public Builder dataCenter(long dataCenter) {
      this.dataCenter = dataCenter;
      return this;
    }
  }

  protected CasePayloadEu(Builder builder) {
    supported = builder.supported;
    dataCenter = builder.dataCenter;
  }

  /**
   * New builder.
   *
   * @return a CasePayloadEu builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the supported.
   *
   * @return the supported
   */
  public Boolean supported() {
    return supported;
  }

  /**
   * Gets the dataCenter.
   *
   * If EU supported utility endpoint specifies datacenter then pass the datacenter id to mark a case as EU supported.
   *
   * @return the dataCenter
   */
  public Long dataCenter() {
    return dataCenter;
  }
}

