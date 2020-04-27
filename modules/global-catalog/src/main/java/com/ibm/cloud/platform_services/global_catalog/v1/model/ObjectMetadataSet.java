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
package com.ibm.cloud.platform_services.global_catalog.v1.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.google.gson.annotations.SerializedName;
import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * Model used to describe metadata object that can be set.
 */
public class ObjectMetadataSet extends GenericModel {

  @SerializedName("rc_compatible")
  protected Boolean rcCompatible;
  protected UIMetaData ui;
  protected List<String> compliance;
  protected ObjectMetadataBaseService service;
  protected ObjectMetadataBasePlan plan;
  protected ObjectMetadataBaseTemplate template;
  protected ObjectMetadataBaseAlias alias;
  protected ObjectMetadataBaseSla sla;
  protected Callbacks callbacks;
  protected String version;
  @SerializedName("original_name")
  protected String originalName;
  protected Map<String, Object> other;
  protected PricingSet pricing;
  protected DeploymentBase deployment;

  /**
   * Builder.
   */
  public static class Builder {
    private Boolean rcCompatible;
    private UIMetaData ui;
    private List<String> compliance;
    private ObjectMetadataBaseService service;
    private ObjectMetadataBasePlan plan;
    private ObjectMetadataBaseTemplate template;
    private ObjectMetadataBaseAlias alias;
    private ObjectMetadataBaseSla sla;
    private Callbacks callbacks;
    private String version;
    private String originalName;
    private Map<String, Object> other;
    private PricingSet pricing;
    private DeploymentBase deployment;

    private Builder(ObjectMetadataSet objectMetadataSet) {
      this.rcCompatible = objectMetadataSet.rcCompatible;
      this.ui = objectMetadataSet.ui;
      this.compliance = objectMetadataSet.compliance;
      this.service = objectMetadataSet.service;
      this.plan = objectMetadataSet.plan;
      this.template = objectMetadataSet.template;
      this.alias = objectMetadataSet.alias;
      this.sla = objectMetadataSet.sla;
      this.callbacks = objectMetadataSet.callbacks;
      this.version = objectMetadataSet.version;
      this.originalName = objectMetadataSet.originalName;
      this.other = objectMetadataSet.other;
      this.pricing = objectMetadataSet.pricing;
      this.deployment = objectMetadataSet.deployment;
    }

    /**
     * Instantiates a new builder.
     */
    public Builder() {
    }

    /**
     * Builds a ObjectMetadataSet.
     *
     * @return the new ObjectMetadataSet instance
     */
    public ObjectMetadataSet build() {
      return new ObjectMetadataSet(this);
    }

    /**
     * Adds an compliance to compliance.
     *
     * @param compliance the new compliance
     * @return the ObjectMetadataSet builder
     */
    public Builder addCompliance(String compliance) {
      com.ibm.cloud.sdk.core.util.Validator.notNull(compliance,
        "compliance cannot be null");
      if (this.compliance == null) {
        this.compliance = new ArrayList<String>();
      }
      this.compliance.add(compliance);
      return this;
    }

    /**
     * Set the rcCompatible.
     *
     * @param rcCompatible the rcCompatible
     * @return the ObjectMetadataSet builder
     */
    public Builder rcCompatible(Boolean rcCompatible) {
      this.rcCompatible = rcCompatible;
      return this;
    }

    /**
     * Set the ui.
     *
     * @param ui the ui
     * @return the ObjectMetadataSet builder
     */
    public Builder ui(UIMetaData ui) {
      this.ui = ui;
      return this;
    }

    /**
     * Set the compliance.
     * Existing compliance will be replaced.
     *
     * @param compliance the compliance
     * @return the ObjectMetadataSet builder
     */
    public Builder compliance(List<String> compliance) {
      this.compliance = compliance;
      return this;
    }

    /**
     * Set the service.
     *
     * @param service the service
     * @return the ObjectMetadataSet builder
     */
    public Builder service(ObjectMetadataBaseService service) {
      this.service = service;
      return this;
    }

    /**
     * Set the plan.
     *
     * @param plan the plan
     * @return the ObjectMetadataSet builder
     */
    public Builder plan(ObjectMetadataBasePlan plan) {
      this.plan = plan;
      return this;
    }

    /**
     * Set the template.
     *
     * @param template the template
     * @return the ObjectMetadataSet builder
     */
    public Builder template(ObjectMetadataBaseTemplate template) {
      this.template = template;
      return this;
    }

    /**
     * Set the alias.
     *
     * @param alias the alias
     * @return the ObjectMetadataSet builder
     */
    public Builder alias(ObjectMetadataBaseAlias alias) {
      this.alias = alias;
      return this;
    }

    /**
     * Set the sla.
     *
     * @param sla the sla
     * @return the ObjectMetadataSet builder
     */
    public Builder sla(ObjectMetadataBaseSla sla) {
      this.sla = sla;
      return this;
    }

    /**
     * Set the callbacks.
     *
     * @param callbacks the callbacks
     * @return the ObjectMetadataSet builder
     */
    public Builder callbacks(Callbacks callbacks) {
      this.callbacks = callbacks;
      return this;
    }

    /**
     * Set the version.
     *
     * @param version the version
     * @return the ObjectMetadataSet builder
     */
    public Builder version(String version) {
      this.version = version;
      return this;
    }

    /**
     * Set the originalName.
     *
     * @param originalName the originalName
     * @return the ObjectMetadataSet builder
     */
    public Builder originalName(String originalName) {
      this.originalName = originalName;
      return this;
    }

    /**
     * Set the other.
     *
     * @param other the other
     * @return the ObjectMetadataSet builder
     */
    public Builder other(Map<String, Object> other) {
      this.other = other;
      return this;
    }

    /**
     * Set the pricing.
     *
     * @param pricing the pricing
     * @return the ObjectMetadataSet builder
     */
    public Builder pricing(PricingSet pricing) {
      this.pricing = pricing;
      return this;
    }

    /**
     * Set the deployment.
     *
     * @param deployment the deployment
     * @return the ObjectMetadataSet builder
     */
    public Builder deployment(DeploymentBase deployment) {
      this.deployment = deployment;
      return this;
    }
  }

  protected ObjectMetadataSet(Builder builder) {
    rcCompatible = builder.rcCompatible;
    ui = builder.ui;
    compliance = builder.compliance;
    service = builder.service;
    plan = builder.plan;
    template = builder.template;
    alias = builder.alias;
    sla = builder.sla;
    callbacks = builder.callbacks;
    version = builder.version;
    originalName = builder.originalName;
    other = builder.other;
    pricing = builder.pricing;
    deployment = builder.deployment;
  }

  /**
   * New builder.
   *
   * @return a ObjectMetadataSet builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the rcCompatible.
   *
   * Boolean value that describes whether the service is compatible with the Resource Controller.
   *
   * @return the rcCompatible
   */
  public Boolean rcCompatible() {
    return rcCompatible;
  }

  /**
   * Gets the ui.
   *
   * Information related to the UI presentation associated with a catalog entry.
   *
   * @return the ui
   */
  public UIMetaData ui() {
    return ui;
  }

  /**
   * Gets the compliance.
   *
   * Compliance information for HIPAA and PCI.
   *
   * @return the compliance
   */
  public List<String> compliance() {
    return compliance;
  }

  /**
   * Gets the service.
   *
   * Service-related metadata.
   *
   * @return the service
   */
  public ObjectMetadataBaseService service() {
    return service;
  }

  /**
   * Gets the plan.
   *
   * Plan-related metadata.
   *
   * @return the plan
   */
  public ObjectMetadataBasePlan plan() {
    return plan;
  }

  /**
   * Gets the template.
   *
   * Template-related metadata.
   *
   * @return the template
   */
  public ObjectMetadataBaseTemplate template() {
    return template;
  }

  /**
   * Gets the alias.
   *
   * Alias-related metadata.
   *
   * @return the alias
   */
  public ObjectMetadataBaseAlias alias() {
    return alias;
  }

  /**
   * Gets the sla.
   *
   * Service Level Agreement related metadata.
   *
   * @return the sla
   */
  public ObjectMetadataBaseSla sla() {
    return sla;
  }

  /**
   * Gets the callbacks.
   *
   * Callback-related information associated with a catalog entry.
   *
   * @return the callbacks
   */
  public Callbacks callbacks() {
    return callbacks;
  }

  /**
   * Gets the version.
   *
   * Optional version of the object.
   *
   * @return the version
   */
  public String version() {
    return version;
  }

  /**
   * Gets the originalName.
   *
   * The original name of the object.
   *
   * @return the originalName
   */
  public String originalName() {
    return originalName;
  }

  /**
   * Gets the other.
   *
   * Additional information.
   *
   * @return the other
   */
  public Map<String, Object> other() {
    return other;
  }

  /**
   * Gets the pricing.
   *
   * Pricing-related information.
   *
   * @return the pricing
   */
  public PricingSet pricing() {
    return pricing;
  }

  /**
   * Gets the deployment.
   *
   * Deployment-related metadata.
   *
   * @return the deployment
   */
  public DeploymentBase deployment() {
    return deployment;
  }
}

