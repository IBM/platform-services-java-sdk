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
package com.ibm.cloud.platform_services.iam_access_groups.v2.model;

import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * The getAccessGroup options.
 */
public class GetAccessGroupOptions extends GenericModel {

  protected String accessGroupId;
  protected String transactionId;
  protected Boolean showFederated;

  /**
   * Builder.
   */
  public static class Builder {
    private String accessGroupId;
    private String transactionId;
    private Boolean showFederated;

    private Builder(GetAccessGroupOptions getAccessGroupOptions) {
      this.accessGroupId = getAccessGroupOptions.accessGroupId;
      this.transactionId = getAccessGroupOptions.transactionId;
      this.showFederated = getAccessGroupOptions.showFederated;
    }

    /**
     * Instantiates a new builder.
     */
    public Builder() {
    }

    /**
     * Instantiates a new builder with required properties.
     *
     * @param accessGroupId the accessGroupId
     */
    public Builder(String accessGroupId) {
      this.accessGroupId = accessGroupId;
    }

    /**
     * Builds a GetAccessGroupOptions.
     *
     * @return the new GetAccessGroupOptions instance
     */
    public GetAccessGroupOptions build() {
      return new GetAccessGroupOptions(this);
    }

    /**
     * Set the accessGroupId.
     *
     * @param accessGroupId the accessGroupId
     * @return the GetAccessGroupOptions builder
     */
    public Builder accessGroupId(String accessGroupId) {
      this.accessGroupId = accessGroupId;
      return this;
    }

    /**
     * Set the transactionId.
     *
     * @param transactionId the transactionId
     * @return the GetAccessGroupOptions builder
     */
    public Builder transactionId(String transactionId) {
      this.transactionId = transactionId;
      return this;
    }

    /**
     * Set the showFederated.
     *
     * @param showFederated the showFederated
     * @return the GetAccessGroupOptions builder
     */
    public Builder showFederated(Boolean showFederated) {
      this.showFederated = showFederated;
      return this;
    }
  }

  protected GetAccessGroupOptions(Builder builder) {
    com.ibm.cloud.sdk.core.util.Validator.notEmpty(builder.accessGroupId,
      "accessGroupId cannot be empty");
    accessGroupId = builder.accessGroupId;
    transactionId = builder.transactionId;
    showFederated = builder.showFederated;
  }

  /**
   * New builder.
   *
   * @return a GetAccessGroupOptions builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the accessGroupId.
   *
   * The Access Group to get.
   *
   * @return the accessGroupId
   */
  public String accessGroupId() {
    return accessGroupId;
  }

  /**
   * Gets the transactionId.
   *
   * An optional transaction id for the request.
   *
   * @return the transactionId
   */
  public String transactionId() {
    return transactionId;
  }

  /**
   * Gets the showFederated.
   *
   * If show_federated is true, the group will return an is_federated value that is set to true if rules exist for the
   * group.
   *
   * @return the showFederated
   */
  public Boolean showFederated() {
    return showFederated;
  }
}

