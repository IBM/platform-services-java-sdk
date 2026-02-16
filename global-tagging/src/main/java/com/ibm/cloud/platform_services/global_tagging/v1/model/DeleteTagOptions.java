/*
 * (C) Copyright IBM Corp. 2026.
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

package com.ibm.cloud.platform_services.global_tagging.v1.model;

import java.util.ArrayList;
import java.util.List;

import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * The deleteTag options.
 */
public class DeleteTagOptions extends GenericModel {

  public interface Providers {
    /** ghost. */
    String GHOST = "ghost";
    /** ims. */
    String IMS = "ims";
  }

  /**
   * The type of the tag. Supported values are `user`, `service` and `access`. `service` and `access` are not supported
   * for IMS resources (`providers` parameter set to `ims`).
   */
  public interface TagType {
    /** user. */
    String USER = "user";
    /** service. */
    String SERVICE = "service";
    /** access. */
    String ACCESS = "access";
  }

  protected String tagName;
  protected String xRequestId;
  protected String xCorrelationId;
  protected List<String> providers;
  protected String accountId;
  protected String tagType;

  /**
   * Builder.
   */
  public static class Builder {
    private String tagName;
    private String xRequestId;
    private String xCorrelationId;
    private List<String> providers;
    private String accountId;
    private String tagType;

    /**
     * Instantiates a new Builder from an existing DeleteTagOptions instance.
     *
     * @param deleteTagOptions the instance to initialize the Builder with
     */
    private Builder(DeleteTagOptions deleteTagOptions) {
      this.tagName = deleteTagOptions.tagName;
      this.xRequestId = deleteTagOptions.xRequestId;
      this.xCorrelationId = deleteTagOptions.xCorrelationId;
      this.providers = deleteTagOptions.providers;
      this.accountId = deleteTagOptions.accountId;
      this.tagType = deleteTagOptions.tagType;
    }

    /**
     * Instantiates a new builder.
     */
    public Builder() {
    }

    /**
     * Instantiates a new builder with required properties.
     *
     * @param tagName the tagName
     */
    public Builder(String tagName) {
      this.tagName = tagName;
    }

    /**
     * Builds a DeleteTagOptions.
     *
     * @return the new DeleteTagOptions instance
     */
    public DeleteTagOptions build() {
      return new DeleteTagOptions(this);
    }

    /**
     * Adds a new element to providers.
     *
     * @param providers the new element to be added
     * @return the DeleteTagOptions builder
     */
    public Builder addProviders(String providers) {
      com.ibm.cloud.sdk.core.util.Validator.notNull(providers,
        "providers cannot be null");
      if (this.providers == null) {
        this.providers = new ArrayList<String>();
      }
      this.providers.add(providers);
      return this;
    }

    /**
     * Set the tagName.
     *
     * @param tagName the tagName
     * @return the DeleteTagOptions builder
     */
    public Builder tagName(String tagName) {
      this.tagName = tagName;
      return this;
    }

    /**
     * Set the xRequestId.
     *
     * @param xRequestId the xRequestId
     * @return the DeleteTagOptions builder
     */
    public Builder xRequestId(String xRequestId) {
      this.xRequestId = xRequestId;
      return this;
    }

    /**
     * Set the xCorrelationId.
     *
     * @param xCorrelationId the xCorrelationId
     * @return the DeleteTagOptions builder
     */
    public Builder xCorrelationId(String xCorrelationId) {
      this.xCorrelationId = xCorrelationId;
      return this;
    }

    /**
     * Set the providers.
     * Existing providers will be replaced.
     *
     * @param providers the providers
     * @return the DeleteTagOptions builder
     */
    public Builder providers(List<String> providers) {
      this.providers = providers;
      return this;
    }

    /**
     * Set the accountId.
     *
     * @param accountId the accountId
     * @return the DeleteTagOptions builder
     */
    public Builder accountId(String accountId) {
      this.accountId = accountId;
      return this;
    }

    /**
     * Set the tagType.
     *
     * @param tagType the tagType
     * @return the DeleteTagOptions builder
     */
    public Builder tagType(String tagType) {
      this.tagType = tagType;
      return this;
    }
  }

  protected DeleteTagOptions() { }

  protected DeleteTagOptions(Builder builder) {
    com.ibm.cloud.sdk.core.util.Validator.notEmpty(builder.tagName,
      "tagName cannot be empty");
    tagName = builder.tagName;
    xRequestId = builder.xRequestId;
    xCorrelationId = builder.xCorrelationId;
    providers = builder.providers;
    accountId = builder.accountId;
    tagType = builder.tagType;
  }

  /**
   * New builder.
   *
   * @return a DeleteTagOptions builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the tagName.
   *
   * The name of tag to be deleted.
   *
   * @return the tagName
   */
  public String tagName() {
    return tagName;
  }

  /**
   * Gets the xRequestId.
   *
   * An alphanumeric string that is used to trace the request. The value  may include ASCII alphanumerics and any of
   * following segment separators: space ( ), comma (,), hyphen, (-), and underscore (_) and may have a length up to
   * 1024 bytes. The value is considered invalid and must be ignored if that value includes any other character or is
   * longer than 1024 bytes or is fewer than 8 characters. If not specified or invalid, it is automatically replaced by
   * a random (version 4) UUID.
   *
   * @return the xRequestId
   */
  public String xRequestId() {
    return xRequestId;
  }

  /**
   * Gets the xCorrelationId.
   *
   * An alphanumeric string that is used to trace the request as a part of a larger context: the same value is used for
   * downstream requests and retries of those requests. The value may include ASCII alphanumerics and any of following
   * segment separators: space ( ), comma (,), hyphen, (-), and underscore (_) and may have a length up to 1024 bytes.
   * The value is considered invalid and must be ignored if that value includes any other character or is longer than
   * 1024 bytes or is fewer than 8 characters. If not specified or invalid, it is automatically replaced by a random
   * (version 4) UUID.
   *
   * @return the xCorrelationId
   */
  public String xCorrelationId() {
    return xCorrelationId;
  }

  /**
   * Gets the providers.
   *
   * Select a provider. Supported values are `ghost` and `ims`. To delete tags both in Global Search and Tagging and in
   * IMS, use `ghost,ims`.
   *
   * @return the providers
   */
  public List<String> providers() {
    return providers;
  }

  /**
   * Gets the accountId.
   *
   * The ID of the billing account to delete the tag for. It is a required parameter if `tag_type` is set to `service`,
   * otherwise it is inferred from the authorization IAM token.
   *
   * @return the accountId
   */
  public String accountId() {
    return accountId;
  }

  /**
   * Gets the tagType.
   *
   * The type of the tag. Supported values are `user`, `service` and `access`. `service` and `access` are not supported
   * for IMS resources (`providers` parameter set to `ims`).
   *
   * @return the tagType
   */
  public String tagType() {
    return tagType;
  }
}

