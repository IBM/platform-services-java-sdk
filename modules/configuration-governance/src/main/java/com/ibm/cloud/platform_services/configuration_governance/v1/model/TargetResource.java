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
package com.ibm.cloud.platform_services.configuration_governance.v1.model;

import java.util.ArrayList;
import java.util.List;

import com.google.gson.annotations.SerializedName;
import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * The properties that describe the resource that you want to target with the rule.
 */
public class TargetResource extends GenericModel {

  @SerializedName("service_name")
  protected String serviceName;
  @SerializedName("resource_kind")
  protected String resourceKind;
  @SerializedName("additional_target_attributes")
  protected List<RuleTargetAttribute> additionalTargetAttributes;

  /**
   * Builder.
   */
  public static class Builder {
    private String serviceName;
    private String resourceKind;
    private List<RuleTargetAttribute> additionalTargetAttributes;

    private Builder(TargetResource targetResource) {
      this.serviceName = targetResource.serviceName;
      this.resourceKind = targetResource.resourceKind;
      this.additionalTargetAttributes = targetResource.additionalTargetAttributes;
    }

    /**
     * Instantiates a new builder.
     */
    public Builder() {
    }

    /**
     * Instantiates a new builder with required properties.
     *
     * @param serviceName the serviceName
     * @param resourceKind the resourceKind
     */
    public Builder(String serviceName, String resourceKind) {
      this.serviceName = serviceName;
      this.resourceKind = resourceKind;
    }

    /**
     * Builds a TargetResource.
     *
     * @return the new TargetResource instance
     */
    public TargetResource build() {
      return new TargetResource(this);
    }

    /**
     * Adds an additionalTargetAttribute to additionalTargetAttributes.
     *
     * @param additionalTargetAttribute the new additionalTargetAttribute
     * @return the TargetResource builder
     */
    public Builder addAdditionalTargetAttribute(RuleTargetAttribute additionalTargetAttribute) {
      com.ibm.cloud.sdk.core.util.Validator.notNull(additionalTargetAttribute,
        "additionalTargetAttribute cannot be null");
      if (this.additionalTargetAttributes == null) {
        this.additionalTargetAttributes = new ArrayList<RuleTargetAttribute>();
      }
      this.additionalTargetAttributes.add(additionalTargetAttribute);
      return this;
    }

    /**
     * Set the serviceName.
     *
     * @param serviceName the serviceName
     * @return the TargetResource builder
     */
    public Builder serviceName(String serviceName) {
      this.serviceName = serviceName;
      return this;
    }

    /**
     * Set the resourceKind.
     *
     * @param resourceKind the resourceKind
     * @return the TargetResource builder
     */
    public Builder resourceKind(String resourceKind) {
      this.resourceKind = resourceKind;
      return this;
    }

    /**
     * Set the additionalTargetAttributes.
     * Existing additionalTargetAttributes will be replaced.
     *
     * @param additionalTargetAttributes the additionalTargetAttributes
     * @return the TargetResource builder
     */
    public Builder additionalTargetAttributes(List<RuleTargetAttribute> additionalTargetAttributes) {
      this.additionalTargetAttributes = additionalTargetAttributes;
      return this;
    }
  }

  protected TargetResource(Builder builder) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.serviceName,
      "serviceName cannot be null");
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.resourceKind,
      "resourceKind cannot be null");
    serviceName = builder.serviceName;
    resourceKind = builder.resourceKind;
    additionalTargetAttributes = builder.additionalTargetAttributes;
  }

  /**
   * New builder.
   *
   * @return a TargetResource builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the serviceName.
   *
   * The programmatic name of the IBM Cloud service that you want to target with the rule.
   *
   * @return the serviceName
   */
  public String serviceName() {
    return serviceName;
  }

  /**
   * Gets the resourceKind.
   *
   * The type of resource that you want to target.
   *
   * @return the resourceKind
   */
  public String resourceKind() {
    return resourceKind;
  }

  /**
   * Gets the additionalTargetAttributes.
   *
   * An extra qualifier for the resource kind. When you include additional attributes, only the resources that match the
   * definition are included in the rule.
   *
   * @return the additionalTargetAttributes
   */
  public List<RuleTargetAttribute> additionalTargetAttributes() {
    return additionalTargetAttributes;
  }
}

