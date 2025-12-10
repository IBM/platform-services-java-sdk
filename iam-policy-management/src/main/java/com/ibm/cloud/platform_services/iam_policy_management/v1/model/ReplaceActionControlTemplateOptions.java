/*
 * (C) Copyright IBM Corp. 2025.
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
 * The replaceActionControlTemplate options.
 */
public class ReplaceActionControlTemplateOptions extends GenericModel {

  protected String actionControlTemplateId;
  protected String version;
  protected String ifMatch;
  protected String name;
  protected String description;
  protected TemplateActionControl actionControl;
  protected Boolean committed;

  /**
   * Builder.
   */
  public static class Builder {
    private String actionControlTemplateId;
    private String version;
    private String ifMatch;
    private String name;
    private String description;
    private TemplateActionControl actionControl;
    private Boolean committed;

    /**
     * Instantiates a new Builder from an existing ReplaceActionControlTemplateOptions instance.
     *
     * @param replaceActionControlTemplateOptions the instance to initialize the Builder with
     */
    private Builder(ReplaceActionControlTemplateOptions replaceActionControlTemplateOptions) {
      this.actionControlTemplateId = replaceActionControlTemplateOptions.actionControlTemplateId;
      this.version = replaceActionControlTemplateOptions.version;
      this.ifMatch = replaceActionControlTemplateOptions.ifMatch;
      this.name = replaceActionControlTemplateOptions.name;
      this.description = replaceActionControlTemplateOptions.description;
      this.actionControl = replaceActionControlTemplateOptions.actionControl;
      this.committed = replaceActionControlTemplateOptions.committed;
    }

    /**
     * Instantiates a new builder.
     */
    public Builder() {
    }

    /**
     * Instantiates a new builder with required properties.
     *
     * @param actionControlTemplateId the actionControlTemplateId
     * @param version the version
     * @param ifMatch the ifMatch
     */
    public Builder(String actionControlTemplateId, String version, String ifMatch) {
      this.actionControlTemplateId = actionControlTemplateId;
      this.version = version;
      this.ifMatch = ifMatch;
    }

    /**
     * Builds a ReplaceActionControlTemplateOptions.
     *
     * @return the new ReplaceActionControlTemplateOptions instance
     */
    public ReplaceActionControlTemplateOptions build() {
      return new ReplaceActionControlTemplateOptions(this);
    }

    /**
     * Set the actionControlTemplateId.
     *
     * @param actionControlTemplateId the actionControlTemplateId
     * @return the ReplaceActionControlTemplateOptions builder
     */
    public Builder actionControlTemplateId(String actionControlTemplateId) {
      this.actionControlTemplateId = actionControlTemplateId;
      return this;
    }

    /**
     * Set the version.
     *
     * @param version the version
     * @return the ReplaceActionControlTemplateOptions builder
     */
    public Builder version(String version) {
      this.version = version;
      return this;
    }

    /**
     * Set the ifMatch.
     *
     * @param ifMatch the ifMatch
     * @return the ReplaceActionControlTemplateOptions builder
     */
    public Builder ifMatch(String ifMatch) {
      this.ifMatch = ifMatch;
      return this;
    }

    /**
     * Set the name.
     *
     * @param name the name
     * @return the ReplaceActionControlTemplateOptions builder
     */
    public Builder name(String name) {
      this.name = name;
      return this;
    }

    /**
     * Set the description.
     *
     * @param description the description
     * @return the ReplaceActionControlTemplateOptions builder
     */
    public Builder description(String description) {
      this.description = description;
      return this;
    }

    /**
     * Set the actionControl.
     *
     * @param actionControl the actionControl
     * @return the ReplaceActionControlTemplateOptions builder
     */
    public Builder actionControl(TemplateActionControl actionControl) {
      this.actionControl = actionControl;
      return this;
    }

    /**
     * Set the committed.
     *
     * @param committed the committed
     * @return the ReplaceActionControlTemplateOptions builder
     */
    public Builder committed(Boolean committed) {
      this.committed = committed;
      return this;
    }
  }

  protected ReplaceActionControlTemplateOptions() { }

  protected ReplaceActionControlTemplateOptions(Builder builder) {
    com.ibm.cloud.sdk.core.util.Validator.notEmpty(builder.actionControlTemplateId,
      "actionControlTemplateId cannot be empty");
    com.ibm.cloud.sdk.core.util.Validator.notEmpty(builder.version,
      "version cannot be empty");
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.ifMatch,
      "ifMatch cannot be null");
    actionControlTemplateId = builder.actionControlTemplateId;
    version = builder.version;
    ifMatch = builder.ifMatch;
    name = builder.name;
    description = builder.description;
    actionControl = builder.actionControl;
    committed = builder.committed;
  }

  /**
   * New builder.
   *
   * @return a ReplaceActionControlTemplateOptions builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the actionControlTemplateId.
   *
   * Action control template ID.
   *
   * @return the actionControlTemplateId
   */
  public String actionControlTemplateId() {
    return actionControlTemplateId;
  }

  /**
   * Gets the version.
   *
   * Action control template version.
   *
   * @return the version
   */
  public String version() {
    return version;
  }

  /**
   * Gets the ifMatch.
   *
   * The revision number for updating an action control template version must match the Etag value of the existing
   * action control template version. The Etag can be retrieved using the GET
   * /v1/action_control_templates/{template_id}/versions/{version} API and looking at the Etag response header.
   *
   * @return the ifMatch
   */
  public String ifMatch() {
    return ifMatch;
  }

  /**
   * Gets the name.
   *
   * Required field when creating a new template. Otherwise, this field is optional. If the field is included, it will
   * change the name value for all existing versions of the template.
   *
   * @return the name
   */
  public String name() {
    return name;
  }

  /**
   * Gets the description.
   *
   * Description of the action control template. This is shown to users in the enterprise account. Use this to describe
   * the purpose or context of the action control for enterprise users managing IAM templates.
   *
   * @return the description
   */
  public String description() {
    return description;
  }

  /**
   * Gets the actionControl.
   *
   * The action control properties that are created in an action resource when the template is assigned.
   *
   * @return the actionControl
   */
  public TemplateActionControl actionControl() {
    return actionControl;
  }

  /**
   * Gets the committed.
   *
   * Committed status of the template version. If committed is set to true, then the template version can no longer be
   * updated.
   *
   * @return the committed
   */
  public Boolean committed() {
    return committed;
  }
}

