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

import com.google.gson.annotations.SerializedName;
import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * RuleImport.
 */
public class RuleImport extends GenericModel {

  protected String name;
  @SerializedName("ui_support")
  protected UISupport uiSupport;

  /**
   * Builder.
   */
  public static class Builder {
    private String name;
    private UISupport uiSupport;

    private Builder(RuleImport ruleImport) {
      this.name = ruleImport.name;
      this.uiSupport = ruleImport.uiSupport;
    }

    /**
     * Instantiates a new builder.
     */
    public Builder() {
    }

    /**
     * Instantiates a new builder with required properties.
     *
     * @param name the name
     */
    public Builder(String name) {
      this.name = name;
    }

    /**
     * Builds a RuleImport.
     *
     * @return the new RuleImport instance
     */
    public RuleImport build() {
      return new RuleImport(this);
    }

    /**
     * Set the name.
     *
     * @param name the name
     * @return the RuleImport builder
     */
    public Builder name(String name) {
      this.name = name;
      return this;
    }

    /**
     * Set the uiSupport.
     *
     * @param uiSupport the uiSupport
     * @return the RuleImport builder
     */
    public Builder uiSupport(UISupport uiSupport) {
      this.uiSupport = uiSupport;
      return this;
    }
  }

  protected RuleImport(Builder builder) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.name,
      "name cannot be null");
    name = builder.name;
    uiSupport = builder.uiSupport;
  }

  /**
   * New builder.
   *
   * @return a RuleImport builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the name.
   *
   * The imported name for a rule.
   *
   * @return the name
   */
  public String name() {
    return name;
  }

  /**
   * Gets the uiSupport.
   *
   * Imported metadata that displays in the dashboard.
   *
   * @return the uiSupport
   */
  public UISupport uiSupport() {
    return uiSupport;
  }
}

