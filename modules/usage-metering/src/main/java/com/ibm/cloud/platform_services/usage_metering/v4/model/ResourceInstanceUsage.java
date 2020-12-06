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
package com.ibm.cloud.platform_services.usage_metering.v4.model;

import java.util.ArrayList;
import java.util.List;

import com.google.gson.annotations.SerializedName;
import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * Usage information for a resource instance.
 */
public class ResourceInstanceUsage extends GenericModel {

  @SerializedName("resource_instance_id")
  protected String resourceInstanceId;
  @SerializedName("plan_id")
  protected String planId;
  protected String region;
  protected Long start;
  protected Long end;
  @SerializedName("measured_usage")
  protected List<MeasureAndQuantity> measuredUsage;
  @SerializedName("consumer_id")
  protected String consumerId;

  /**
   * Builder.
   */
  public static class Builder {
    private String resourceInstanceId;
    private String planId;
    private String region;
    private Long start;
    private Long end;
    private List<MeasureAndQuantity> measuredUsage;
    private String consumerId;

    private Builder(ResourceInstanceUsage resourceInstanceUsage) {
      this.resourceInstanceId = resourceInstanceUsage.resourceInstanceId;
      this.planId = resourceInstanceUsage.planId;
      this.region = resourceInstanceUsage.region;
      this.start = resourceInstanceUsage.start;
      this.end = resourceInstanceUsage.end;
      this.measuredUsage = resourceInstanceUsage.measuredUsage;
      this.consumerId = resourceInstanceUsage.consumerId;
    }

    /**
     * Instantiates a new builder.
     */
    public Builder() {
    }

    /**
     * Instantiates a new builder with required properties.
     *
     * @param resourceInstanceId the resourceInstanceId
     * @param planId the planId
     * @param start the start
     * @param end the end
     * @param measuredUsage the measuredUsage
     */
    public Builder(String resourceInstanceId, String planId, Long start, Long end, List<MeasureAndQuantity> measuredUsage) {
      this.resourceInstanceId = resourceInstanceId;
      this.planId = planId;
      this.start = start;
      this.end = end;
      this.measuredUsage = measuredUsage;
    }

    /**
     * Builds a ResourceInstanceUsage.
     *
     * @return the new ResourceInstanceUsage instance
     */
    public ResourceInstanceUsage build() {
      return new ResourceInstanceUsage(this);
    }

    /**
     * Adds an measuredUsage to measuredUsage.
     *
     * @param measuredUsage the new measuredUsage
     * @return the ResourceInstanceUsage builder
     */
    public Builder addMeasuredUsage(MeasureAndQuantity measuredUsage) {
      com.ibm.cloud.sdk.core.util.Validator.notNull(measuredUsage,
        "measuredUsage cannot be null");
      if (this.measuredUsage == null) {
        this.measuredUsage = new ArrayList<MeasureAndQuantity>();
      }
      this.measuredUsage.add(measuredUsage);
      return this;
    }

    /**
     * Set the resourceInstanceId.
     *
     * @param resourceInstanceId the resourceInstanceId
     * @return the ResourceInstanceUsage builder
     */
    public Builder resourceInstanceId(String resourceInstanceId) {
      this.resourceInstanceId = resourceInstanceId;
      return this;
    }

    /**
     * Set the planId.
     *
     * @param planId the planId
     * @return the ResourceInstanceUsage builder
     */
    public Builder planId(String planId) {
      this.planId = planId;
      return this;
    }

    /**
     * Set the region.
     *
     * @param region the region
     * @return the ResourceInstanceUsage builder
     */
    public Builder region(String region) {
      this.region = region;
      return this;
    }

    /**
     * Set the start.
     *
     * @param start the start
     * @return the ResourceInstanceUsage builder
     */
    public Builder start(long start) {
      this.start = start;
      return this;
    }

    /**
     * Set the end.
     *
     * @param end the end
     * @return the ResourceInstanceUsage builder
     */
    public Builder end(long end) {
      this.end = end;
      return this;
    }

    /**
     * Set the measuredUsage.
     * Existing measuredUsage will be replaced.
     *
     * @param measuredUsage the measuredUsage
     * @return the ResourceInstanceUsage builder
     */
    public Builder measuredUsage(List<MeasureAndQuantity> measuredUsage) {
      this.measuredUsage = measuredUsage;
      return this;
    }

    /**
     * Set the consumerId.
     *
     * @param consumerId the consumerId
     * @return the ResourceInstanceUsage builder
     */
    public Builder consumerId(String consumerId) {
      this.consumerId = consumerId;
      return this;
    }
  }

  protected ResourceInstanceUsage(Builder builder) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.resourceInstanceId,
      "resourceInstanceId cannot be null");
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.planId,
      "planId cannot be null");
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.start,
      "start cannot be null");
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.end,
      "end cannot be null");
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.measuredUsage,
      "measuredUsage cannot be null");
    resourceInstanceId = builder.resourceInstanceId;
    planId = builder.planId;
    region = builder.region;
    start = builder.start;
    end = builder.end;
    measuredUsage = builder.measuredUsage;
    consumerId = builder.consumerId;
  }

  /**
   * New builder.
   *
   * @return a ResourceInstanceUsage builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the resourceInstanceId.
   *
   * The ID of the instance that incurred the usage. The ID is a CRN for instances that are provisioned with the
   * resource controller.
   *
   * @return the resourceInstanceId
   */
  public String resourceInstanceId() {
    return resourceInstanceId;
  }

  /**
   * Gets the planId.
   *
   * The plan with which the instance's usage should be metered.
   *
   * @return the planId
   */
  public String planId() {
    return planId;
  }

  /**
   * Gets the region.
   *
   * The pricing region to which the usage must be aggregated. This field is required if the ID is not a CRN or if the
   * CRN does not have a region.
   *
   * @return the region
   */
  public String region() {
    return region;
  }

  /**
   * Gets the start.
   *
   * The time from which the resource instance was metered in the format milliseconds since epoch.
   *
   * @return the start
   */
  public Long start() {
    return start;
  }

  /**
   * Gets the end.
   *
   * The time until which the resource instance was metered in the format milliseconds since epoch. This value is the
   * same as start value for event-based submissions.
   *
   * @return the end
   */
  public Long end() {
    return end;
  }

  /**
   * Gets the measuredUsage.
   *
   * Usage measurements for the resource instance.
   *
   * @return the measuredUsage
   */
  public List<MeasureAndQuantity> measuredUsage() {
    return measuredUsage;
  }

  /**
   * Gets the consumerId.
   *
   * If an instance's usage should be aggregated at the consumer level, specify the ID of the consumer. Usage is
   * accumulated to the instance-consumer combination.
   *
   * @return the consumerId
   */
  public String consumerId() {
    return consumerId;
  }
}

