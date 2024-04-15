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
package com.ibm.cloud.platform_services.usage_metering.v4.model;

import java.util.ArrayList;
import java.util.List;

import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * The reportResourceUsage options.
 */
public class ReportResourceUsageOptions extends GenericModel {

  protected String resourceId;
  protected List<ResourceInstanceUsage> resourceUsage;

  /**
   * Builder.
   */
  public static class Builder {
    private String resourceId;
    private List<ResourceInstanceUsage> resourceUsage;

    /**
     * Instantiates a new Builder from an existing ReportResourceUsageOptions instance.
     *
     * @param reportResourceUsageOptions the instance to initialize the Builder with
     */
    private Builder(ReportResourceUsageOptions reportResourceUsageOptions) {
      this.resourceId = reportResourceUsageOptions.resourceId;
      this.resourceUsage = reportResourceUsageOptions.resourceUsage;
    }

    /**
     * Instantiates a new builder.
     */
    public Builder() {
    }

    /**
     * Instantiates a new builder with required properties.
     *
     * @param resourceId the resourceId
     * @param resourceUsage the resourceUsage
     */
    public Builder(String resourceId, List<ResourceInstanceUsage> resourceUsage) {
      this.resourceId = resourceId;
      this.resourceUsage = resourceUsage;
    }

    /**
     * Builds a ReportResourceUsageOptions.
     *
     * @return the new ReportResourceUsageOptions instance
     */
    public ReportResourceUsageOptions build() {
      return new ReportResourceUsageOptions(this);
    }

    /**
     * Adds a new element to resourceUsage.
     *
     * @param resourceUsage the new element to be added
     * @return the ReportResourceUsageOptions builder
     */
    public Builder addResourceUsage(ResourceInstanceUsage resourceUsage) {
      com.ibm.cloud.sdk.core.util.Validator.notNull(resourceUsage,
        "resourceUsage cannot be null");
      if (this.resourceUsage == null) {
        this.resourceUsage = new ArrayList<ResourceInstanceUsage>();
      }
      this.resourceUsage.add(resourceUsage);
      return this;
    }

    /**
     * Set the resourceId.
     *
     * @param resourceId the resourceId
     * @return the ReportResourceUsageOptions builder
     */
    public Builder resourceId(String resourceId) {
      this.resourceId = resourceId;
      return this;
    }

    /**
     * Set the resourceUsage.
     * Existing resourceUsage will be replaced.
     *
     * @param resourceUsage the resourceUsage
     * @return the ReportResourceUsageOptions builder
     */
    public Builder resourceUsage(List<ResourceInstanceUsage> resourceUsage) {
      this.resourceUsage = resourceUsage;
      return this;
    }
  }

  protected ReportResourceUsageOptions() { }

  protected ReportResourceUsageOptions(Builder builder) {
    com.ibm.cloud.sdk.core.util.Validator.notEmpty(builder.resourceId,
      "resourceId cannot be empty");
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.resourceUsage,
      "resourceUsage cannot be null");
    resourceId = builder.resourceId;
    resourceUsage = builder.resourceUsage;
  }

  /**
   * New builder.
   *
   * @return a ReportResourceUsageOptions builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the resourceId.
   *
   * The resource for which the usage is submitted. You can find this value as the Global catalog ID listed on the
   * Brokers tab in Partner Center.
   *
   * @return the resourceId
   */
  public String resourceId() {
    return resourceId;
  }

  /**
   * Gets the resourceUsage.
   *
   * Array of usage records.
   *
   * @return the resourceUsage
   */
  public List<ResourceInstanceUsage> resourceUsage() {
    return resourceUsage;
  }
}

