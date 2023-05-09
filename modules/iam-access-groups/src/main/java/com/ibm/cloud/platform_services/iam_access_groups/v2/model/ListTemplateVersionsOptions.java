/*
 * (C) Copyright IBM Corp. 2023.
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
 * The listTemplateVersions options.
 */
public class ListTemplateVersionsOptions extends GenericModel {

  protected String templateId;
  protected Long limit;
  protected Long offset;

  /**
   * Builder.
   */
  public static class Builder {
    private String templateId;
    private Long limit;
    private Long offset;

    /**
     * Instantiates a new Builder from an existing ListTemplateVersionsOptions instance.
     *
     * @param listTemplateVersionsOptions the instance to initialize the Builder with
     */
    private Builder(ListTemplateVersionsOptions listTemplateVersionsOptions) {
      this.templateId = listTemplateVersionsOptions.templateId;
      this.limit = listTemplateVersionsOptions.limit;
      this.offset = listTemplateVersionsOptions.offset;
    }

    /**
     * Instantiates a new builder.
     */
    public Builder() {
    }

    /**
     * Instantiates a new builder with required properties.
     *
     * @param templateId the templateId
     */
    public Builder(String templateId) {
      this.templateId = templateId;
    }

    /**
     * Builds a ListTemplateVersionsOptions.
     *
     * @return the new ListTemplateVersionsOptions instance
     */
    public ListTemplateVersionsOptions build() {
      return new ListTemplateVersionsOptions(this);
    }

    /**
     * Set the templateId.
     *
     * @param templateId the templateId
     * @return the ListTemplateVersionsOptions builder
     */
    public Builder templateId(String templateId) {
      this.templateId = templateId;
      return this;
    }

    /**
     * Set the limit.
     *
     * @param limit the limit
     * @return the ListTemplateVersionsOptions builder
     */
    public Builder limit(long limit) {
      this.limit = limit;
      return this;
    }

    /**
     * Set the offset.
     *
     * @param offset the offset
     * @return the ListTemplateVersionsOptions builder
     */
    public Builder offset(long offset) {
      this.offset = offset;
      return this;
    }
  }

  protected ListTemplateVersionsOptions() { }

  protected ListTemplateVersionsOptions(Builder builder) {
    com.ibm.cloud.sdk.core.util.Validator.notEmpty(builder.templateId,
      "templateId cannot be empty");
    templateId = builder.templateId;
    limit = builder.limit;
    offset = builder.offset;
  }

  /**
   * New builder.
   *
   * @return a ListTemplateVersionsOptions builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the templateId.
   *
   * template id parameter.
   *
   * @return the templateId
   */
  public String templateId() {
    return templateId;
  }

  /**
   * Gets the limit.
   *
   * limit parameter.
   *
   * @return the limit
   */
  public Long limit() {
    return limit;
  }

  /**
   * Gets the offset.
   *
   * offset parameter.
   *
   * @return the offset
   */
  public Long offset() {
    return offset;
  }
}

