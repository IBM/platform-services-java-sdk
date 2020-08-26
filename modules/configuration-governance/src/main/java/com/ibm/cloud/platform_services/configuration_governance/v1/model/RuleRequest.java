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
 * User-settable properties associated with a rule to be created or updated.
 */
public class RuleRequest extends GenericModel {

  /**
   * The type of rule. Rules that you create are `user_defined`. Rules that are created by IBM are `service_defined`.
   */
  public interface RuleType {
    /** user_defined. */
    String USER_DEFINED = "user_defined";
    /** service_defined. */
    String SERVICE_DEFINED = "service_defined";
  }

  @SerializedName("account_id")
  protected String accountId;
  protected String name;
  protected String description;
  protected String version;
  @SerializedName("rule_type")
  protected String ruleType;
  protected List<RuleImport> imports;
  protected TargetResource target;
  @SerializedName("required_config")
  protected RuleRequiredConfig requiredConfig;
  @SerializedName("enforcement_actions")
  protected List<EnforcementAction> enforcementActions;
  protected List<String> labels;

  /**
   * Builder.
   */
  public static class Builder {
    private String accountId;
    private String name;
    private String description;
    private String version;
    private String ruleType;
    private List<RuleImport> imports;
    private TargetResource target;
    private RuleRequiredConfig requiredConfig;
    private List<EnforcementAction> enforcementActions;
    private List<String> labels;

    private Builder(RuleRequest ruleRequest) {
      this.accountId = ruleRequest.accountId;
      this.name = ruleRequest.name;
      this.description = ruleRequest.description;
      this.version = ruleRequest.version;
      this.ruleType = ruleRequest.ruleType;
      this.imports = ruleRequest.imports;
      this.target = ruleRequest.target;
      this.requiredConfig = ruleRequest.requiredConfig;
      this.enforcementActions = ruleRequest.enforcementActions;
      this.labels = ruleRequest.labels;
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
     * @param description the description
     * @param target the target
     * @param requiredConfig the requiredConfig
     * @param enforcementActions the enforcementActions
     */
    public Builder(String name, String description, TargetResource target, RuleRequiredConfig requiredConfig, List<EnforcementAction> enforcementActions) {
      this.name = name;
      this.description = description;
      this.target = target;
      this.requiredConfig = requiredConfig;
      this.enforcementActions = enforcementActions;
    }

    /**
     * Builds a RuleRequest.
     *
     * @return the new RuleRequest instance
     */
    public RuleRequest build() {
      return new RuleRequest(this);
    }

    /**
     * Adds an xImport to imports.
     *
     * @param xImport the new xImport
     * @return the RuleRequest builder
     */
    public Builder addXImport(RuleImport xImport) {
      com.ibm.cloud.sdk.core.util.Validator.notNull(xImport,
        "xImport cannot be null");
      if (this.imports == null) {
        this.imports = new ArrayList<RuleImport>();
      }
      this.imports.add(xImport);
      return this;
    }

    /**
     * Adds an enforcementAction to enforcementActions.
     *
     * @param enforcementAction the new enforcementAction
     * @return the RuleRequest builder
     */
    public Builder addEnforcementAction(EnforcementAction enforcementAction) {
      com.ibm.cloud.sdk.core.util.Validator.notNull(enforcementAction,
        "enforcementAction cannot be null");
      if (this.enforcementActions == null) {
        this.enforcementActions = new ArrayList<EnforcementAction>();
      }
      this.enforcementActions.add(enforcementAction);
      return this;
    }

    /**
     * Adds an label to labels.
     *
     * @param label the new label
     * @return the RuleRequest builder
     */
    public Builder addLabel(String label) {
      com.ibm.cloud.sdk.core.util.Validator.notNull(label,
        "label cannot be null");
      if (this.labels == null) {
        this.labels = new ArrayList<String>();
      }
      this.labels.add(label);
      return this;
    }

    /**
     * Set the accountId.
     *
     * @param accountId the accountId
     * @return the RuleRequest builder
     */
    public Builder accountId(String accountId) {
      this.accountId = accountId;
      return this;
    }

    /**
     * Set the name.
     *
     * @param name the name
     * @return the RuleRequest builder
     */
    public Builder name(String name) {
      this.name = name;
      return this;
    }

    /**
     * Set the description.
     *
     * @param description the description
     * @return the RuleRequest builder
     */
    public Builder description(String description) {
      this.description = description;
      return this;
    }

    /**
     * Set the version.
     *
     * @param version the version
     * @return the RuleRequest builder
     */
    public Builder version(String version) {
      this.version = version;
      return this;
    }

    /**
     * Set the ruleType.
     *
     * @param ruleType the ruleType
     * @return the RuleRequest builder
     */
    public Builder ruleType(String ruleType) {
      this.ruleType = ruleType;
      return this;
    }

    /**
     * Set the imports.
     * Existing imports will be replaced.
     *
     * @param imports the imports
     * @return the RuleRequest builder
     */
    public Builder imports(List<RuleImport> imports) {
      this.imports = imports;
      return this;
    }

    /**
     * Set the target.
     *
     * @param target the target
     * @return the RuleRequest builder
     */
    public Builder target(TargetResource target) {
      this.target = target;
      return this;
    }

    /**
     * Set the requiredConfig.
     *
     * @param requiredConfig the requiredConfig
     * @return the RuleRequest builder
     */
    public Builder requiredConfig(RuleRequiredConfig requiredConfig) {
      this.requiredConfig = requiredConfig;
      return this;
    }

    /**
     * Set the enforcementActions.
     * Existing enforcementActions will be replaced.
     *
     * @param enforcementActions the enforcementActions
     * @return the RuleRequest builder
     */
    public Builder enforcementActions(List<EnforcementAction> enforcementActions) {
      this.enforcementActions = enforcementActions;
      return this;
    }

    /**
     * Set the labels.
     * Existing labels will be replaced.
     *
     * @param labels the labels
     * @return the RuleRequest builder
     */
    public Builder labels(List<String> labels) {
      this.labels = labels;
      return this;
    }
  }

  protected RuleRequest(Builder builder) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.name,
      "name cannot be null");
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.description,
      "description cannot be null");
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.target,
      "target cannot be null");
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.requiredConfig,
      "requiredConfig cannot be null");
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.enforcementActions,
      "enforcementActions cannot be null");
    accountId = builder.accountId;
    name = builder.name;
    description = builder.description;
    version = builder.version;
    ruleType = builder.ruleType;
    imports = builder.imports;
    target = builder.target;
    requiredConfig = builder.requiredConfig;
    enforcementActions = builder.enforcementActions;
    labels = builder.labels;
  }

  /**
   * New builder.
   *
   * @return a RuleRequest builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the accountId.
   *
   * Your IBM Cloud account ID.
   *
   * @return the accountId
   */
  public String accountId() {
    return accountId;
  }

  /**
   * Gets the name.
   *
   * A human-readable alias to assign to your rule.
   *
   * @return the name
   */
  public String name() {
    return name;
  }

  /**
   * Gets the description.
   *
   * An extended description of your rule.
   *
   * @return the description
   */
  public String description() {
    return description;
  }

  /**
   * Gets the version.
   *
   * A field that you can use to store and manage a custom version for this rule.
   *
   * @return the version
   */
  public String version() {
    return version;
  }

  /**
   * Gets the ruleType.
   *
   * The type of rule. Rules that you create are `user_defined`. Rules that are created by IBM are `service_defined`.
   *
   * @return the ruleType
   */
  public String ruleType() {
    return ruleType;
  }

  /**
   * Gets the imports.
   *
   * Parameters that are imported by IBM as metadata to create
   * `service_defined` rules.
   *
   * @return the imports
   */
  public List<RuleImport> imports() {
    return imports;
  }

  /**
   * Gets the target.
   *
   * The properties that describe the resource that you want to target
   * with the rule.
   *
   * @return the target
   */
  public TargetResource target() {
    return target;
  }

  /**
   * Gets the requiredConfig.
   *
   * @return the requiredConfig
   */
  public RuleRequiredConfig requiredConfig() {
    return requiredConfig;
  }

  /**
   * Gets the enforcementActions.
   *
   * The actions that the service must run on your behalf when a request to create or modify the target resource does
   * not comply with your conditions.
   *
   * @return the enforcementActions
   */
  public List<EnforcementAction> enforcementActions() {
    return enforcementActions;
  }

  /**
   * Gets the labels.
   *
   * Labels that you can use to group and search for similar rules, such as those that help you to meet a specific
   * organization guideline.
   *
   * @return the labels
   */
  public List<String> labels() {
    return labels;
  }
}

