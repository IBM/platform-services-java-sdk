/*
 * (C) Copyright IBM Corp. 2024.
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

package com.ibm.cloud.platform_services.iam_policy_management.v1.model;

import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * The getV2Policy options.
 */
public class GetV2PolicyOptions extends GenericModel {

  /**
   * Include additional data for policy returned
   * * `include_last_permit` - returns details of when the policy last granted a permit decision and the number of times
   * it has done so
   * * `display` - returns the list of all actions included in each of the policy roles and translations for all
   * relevant fields.
   */
  public interface Format {
    /** include_last_permit. */
    String INCLUDE_LAST_PERMIT = "include_last_permit";
    /** display. */
    String DISPLAY = "display";
  }

  protected String id;
  protected String format;

  /**
   * Builder.
   */
  public static class Builder {
    private String id;
    private String format;

    /**
     * Instantiates a new Builder from an existing GetV2PolicyOptions instance.
     *
     * @param getV2PolicyOptions the instance to initialize the Builder with
     */
    private Builder(GetV2PolicyOptions getV2PolicyOptions) {
      this.id = getV2PolicyOptions.id;
      this.format = getV2PolicyOptions.format;
    }

    /**
     * Instantiates a new builder.
     */
    public Builder() {
    }

    /**
     * Instantiates a new builder with required properties.
     *
     * @param id the id
     */
    public Builder(String id) {
      this.id = id;
    }

    /**
     * Builds a GetV2PolicyOptions.
     *
     * @return the new GetV2PolicyOptions instance
     */
    public GetV2PolicyOptions build() {
      return new GetV2PolicyOptions(this);
    }

    /**
     * Set the id.
     *
     * @param id the id
     * @return the GetV2PolicyOptions builder
     */
    public Builder id(String id) {
      this.id = id;
      return this;
    }

    /**
     * Set the format.
     *
     * @param format the format
     * @return the GetV2PolicyOptions builder
     */
    public Builder format(String format) {
      this.format = format;
      return this;
    }
  }

  protected GetV2PolicyOptions() { }

  protected GetV2PolicyOptions(Builder builder) {
    com.ibm.cloud.sdk.core.util.Validator.notEmpty(builder.id,
      "id cannot be empty");
    id = builder.id;
    format = builder.format;
  }

  /**
   * New builder.
   *
   * @return a GetV2PolicyOptions builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the id.
   *
   * The policy ID.
   *
   * @return the id
   */
  public String id() {
    return id;
  }

  /**
   * Gets the format.
   *
   * Include additional data for policy returned
   * * `include_last_permit` - returns details of when the policy last granted a permit decision and the number of times
   * it has done so
   * * `display` - returns the list of all actions included in each of the policy roles and translations for all
   * relevant fields.
   *
   * @return the format
   */
  public String format() {
    return format;
  }
}

