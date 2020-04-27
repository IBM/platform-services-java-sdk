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

import com.google.gson.annotations.SerializedName;
import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * Template-related metadata.
 */
public class ObjectMetadataBaseTemplate extends GenericModel {

  protected List<String> services;
  @SerializedName("default_memory")
  protected Long defaultMemory;
  @SerializedName("start_cmd")
  protected String startCmd;
  protected ObjectMetadataBaseTemplateSource source;
  @SerializedName("runtime_catalog_id")
  protected String runtimeCatalogId;
  @SerializedName("cf_runtime_id")
  protected String cfRuntimeId;
  @SerializedName("template_id")
  protected String templateId;
  @SerializedName("executable_file")
  protected String executableFile;
  protected String buildpack;
  @SerializedName("environment_variables")
  protected ObjectMetadataBaseTemplateEnvironmentVariables environmentVariables;

  /**
   * Builder.
   */
  public static class Builder {
    private List<String> services;
    private Long defaultMemory;
    private String startCmd;
    private ObjectMetadataBaseTemplateSource source;
    private String runtimeCatalogId;
    private String cfRuntimeId;
    private String templateId;
    private String executableFile;
    private String buildpack;
    private ObjectMetadataBaseTemplateEnvironmentVariables environmentVariables;

    private Builder(ObjectMetadataBaseTemplate objectMetadataBaseTemplate) {
      this.services = objectMetadataBaseTemplate.services;
      this.defaultMemory = objectMetadataBaseTemplate.defaultMemory;
      this.startCmd = objectMetadataBaseTemplate.startCmd;
      this.source = objectMetadataBaseTemplate.source;
      this.runtimeCatalogId = objectMetadataBaseTemplate.runtimeCatalogId;
      this.cfRuntimeId = objectMetadataBaseTemplate.cfRuntimeId;
      this.templateId = objectMetadataBaseTemplate.templateId;
      this.executableFile = objectMetadataBaseTemplate.executableFile;
      this.buildpack = objectMetadataBaseTemplate.buildpack;
      this.environmentVariables = objectMetadataBaseTemplate.environmentVariables;
    }

    /**
     * Instantiates a new builder.
     */
    public Builder() {
    }

    /**
     * Builds a ObjectMetadataBaseTemplate.
     *
     * @return the new ObjectMetadataBaseTemplate instance
     */
    public ObjectMetadataBaseTemplate build() {
      return new ObjectMetadataBaseTemplate(this);
    }

    /**
     * Adds an services to services.
     *
     * @param services the new services
     * @return the ObjectMetadataBaseTemplate builder
     */
    public Builder addServices(String services) {
      com.ibm.cloud.sdk.core.util.Validator.notNull(services,
        "services cannot be null");
      if (this.services == null) {
        this.services = new ArrayList<String>();
      }
      this.services.add(services);
      return this;
    }

    /**
     * Set the services.
     * Existing services will be replaced.
     *
     * @param services the services
     * @return the ObjectMetadataBaseTemplate builder
     */
    public Builder services(List<String> services) {
      this.services = services;
      return this;
    }

    /**
     * Set the defaultMemory.
     *
     * @param defaultMemory the defaultMemory
     * @return the ObjectMetadataBaseTemplate builder
     */
    public Builder defaultMemory(long defaultMemory) {
      this.defaultMemory = defaultMemory;
      return this;
    }

    /**
     * Set the startCmd.
     *
     * @param startCmd the startCmd
     * @return the ObjectMetadataBaseTemplate builder
     */
    public Builder startCmd(String startCmd) {
      this.startCmd = startCmd;
      return this;
    }

    /**
     * Set the source.
     *
     * @param source the source
     * @return the ObjectMetadataBaseTemplate builder
     */
    public Builder source(ObjectMetadataBaseTemplateSource source) {
      this.source = source;
      return this;
    }

    /**
     * Set the runtimeCatalogId.
     *
     * @param runtimeCatalogId the runtimeCatalogId
     * @return the ObjectMetadataBaseTemplate builder
     */
    public Builder runtimeCatalogId(String runtimeCatalogId) {
      this.runtimeCatalogId = runtimeCatalogId;
      return this;
    }

    /**
     * Set the cfRuntimeId.
     *
     * @param cfRuntimeId the cfRuntimeId
     * @return the ObjectMetadataBaseTemplate builder
     */
    public Builder cfRuntimeId(String cfRuntimeId) {
      this.cfRuntimeId = cfRuntimeId;
      return this;
    }

    /**
     * Set the templateId.
     *
     * @param templateId the templateId
     * @return the ObjectMetadataBaseTemplate builder
     */
    public Builder templateId(String templateId) {
      this.templateId = templateId;
      return this;
    }

    /**
     * Set the executableFile.
     *
     * @param executableFile the executableFile
     * @return the ObjectMetadataBaseTemplate builder
     */
    public Builder executableFile(String executableFile) {
      this.executableFile = executableFile;
      return this;
    }

    /**
     * Set the buildpack.
     *
     * @param buildpack the buildpack
     * @return the ObjectMetadataBaseTemplate builder
     */
    public Builder buildpack(String buildpack) {
      this.buildpack = buildpack;
      return this;
    }

    /**
     * Set the environmentVariables.
     *
     * @param environmentVariables the environmentVariables
     * @return the ObjectMetadataBaseTemplate builder
     */
    public Builder environmentVariables(ObjectMetadataBaseTemplateEnvironmentVariables environmentVariables) {
      this.environmentVariables = environmentVariables;
      return this;
    }
  }

  protected ObjectMetadataBaseTemplate(Builder builder) {
    services = builder.services;
    defaultMemory = builder.defaultMemory;
    startCmd = builder.startCmd;
    source = builder.source;
    runtimeCatalogId = builder.runtimeCatalogId;
    cfRuntimeId = builder.cfRuntimeId;
    templateId = builder.templateId;
    executableFile = builder.executableFile;
    buildpack = builder.buildpack;
    environmentVariables = builder.environmentVariables;
  }

  /**
   * New builder.
   *
   * @return a ObjectMetadataBaseTemplate builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the services.
   *
   * List of required offering or plan IDs.
   *
   * @return the services
   */
  public List<String> services() {
    return services;
  }

  /**
   * Gets the defaultMemory.
   *
   * Cloud Foundry instance memory value.
   *
   * @return the defaultMemory
   */
  public Long defaultMemory() {
    return defaultMemory;
  }

  /**
   * Gets the startCmd.
   *
   * Start Command.
   *
   * @return the startCmd
   */
  public String startCmd() {
    return startCmd;
  }

  /**
   * Gets the source.
   *
   * Location of your applications source files.
   *
   * @return the source
   */
  public ObjectMetadataBaseTemplateSource source() {
    return source;
  }

  /**
   * Gets the runtimeCatalogId.
   *
   * ID of the runtime.
   *
   * @return the runtimeCatalogId
   */
  public String runtimeCatalogId() {
    return runtimeCatalogId;
  }

  /**
   * Gets the cfRuntimeId.
   *
   * ID of the Cloud Foundry runtime.
   *
   * @return the cfRuntimeId
   */
  public String cfRuntimeId() {
    return cfRuntimeId;
  }

  /**
   * Gets the templateId.
   *
   * ID of the boilerplate or template.
   *
   * @return the templateId
   */
  public String templateId() {
    return templateId;
  }

  /**
   * Gets the executableFile.
   *
   * File path to the executable file for the template.
   *
   * @return the executableFile
   */
  public String executableFile() {
    return executableFile;
  }

  /**
   * Gets the buildpack.
   *
   * ID of the buildpack used by the template.
   *
   * @return the buildpack
   */
  public String buildpack() {
    return buildpack;
  }

  /**
   * Gets the environmentVariables.
   *
   * Environment variables for the template.
   *
   * @return the environmentVariables
   */
  public ObjectMetadataBaseTemplateEnvironmentVariables environmentVariables() {
    return environmentVariables;
  }
}

