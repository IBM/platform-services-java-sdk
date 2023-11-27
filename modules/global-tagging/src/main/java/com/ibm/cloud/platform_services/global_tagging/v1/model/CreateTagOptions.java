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
package com.ibm.cloud.platform_services.global_tagging.v1.model;

import java.util.ArrayList;
import java.util.List;

import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * The createTag options.
 */
public class CreateTagOptions extends GenericModel {

  /**
   * The type of the tags you want to create. The only allowed value is `access`.
   */
  public interface TagType {
    /** access. */
    String ACCESS = "access";
  }

  protected List<String> tagNames;
  protected String xRequestId;
  protected String xCorrelationId;
  protected String transactionId;
  protected String accountId;
  protected String tagType;

  /**
   * Builder.
   */
  public static class Builder {
    private List<String> tagNames;
    private String xRequestId;
    private String xCorrelationId;
    private String transactionId;
    private String accountId;
    private String tagType;

    /**
     * Instantiates a new Builder from an existing CreateTagOptions instance.
     *
     * @param createTagOptions the instance to initialize the Builder with
     */
    private Builder(CreateTagOptions createTagOptions) {
      this.tagNames = createTagOptions.tagNames;
      this.xRequestId = createTagOptions.xRequestId;
      this.xCorrelationId = createTagOptions.xCorrelationId;
      this.transactionId = createTagOptions.transactionId;
      this.accountId = createTagOptions.accountId;
      this.tagType = createTagOptions.tagType;
    }

    /**
     * Instantiates a new builder.
     */
    public Builder() {
    }

    /**
     * Instantiates a new builder with required properties.
     *
     * @param tagNames the tagNames
     */
    public Builder(List<String> tagNames) {
      this.tagNames = tagNames;
    }

    /**
     * Builds a CreateTagOptions.
     *
     * @return the new CreateTagOptions instance
     */
    public CreateTagOptions build() {
      return new CreateTagOptions(this);
    }

    /**
     * Adds an tagNames to tagNames.
     *
     * @param tagNames the new tagNames
     * @return the CreateTagOptions builder
     */
    public Builder addTagNames(String tagNames) {
      com.ibm.cloud.sdk.core.util.Validator.notNull(tagNames,
        "tagNames cannot be null");
      if (this.tagNames == null) {
        this.tagNames = new ArrayList<String>();
      }
      this.tagNames.add(tagNames);
      return this;
    }

    /**
     * Set the tagNames.
     * Existing tagNames will be replaced.
     *
     * @param tagNames the tagNames
     * @return the CreateTagOptions builder
     */
    public Builder tagNames(List<String> tagNames) {
      this.tagNames = tagNames;
      return this;
    }

    /**
     * Set the xRequestId.
     *
     * @param xRequestId the xRequestId
     * @return the CreateTagOptions builder
     */
    public Builder xRequestId(String xRequestId) {
      this.xRequestId = xRequestId;
      return this;
    }

    /**
     * Set the xCorrelationId.
     *
     * @param xCorrelationId the xCorrelationId
     * @return the CreateTagOptions builder
     */
    public Builder xCorrelationId(String xCorrelationId) {
      this.xCorrelationId = xCorrelationId;
      return this;
    }

    /**
     * Set the transactionId.
     *
     * @param transactionId the transactionId
     * @return the CreateTagOptions builder
     * @deprecated this method is deprecated and may be removed in a future release
     */
    @Deprecated
    public Builder transactionId(String transactionId) {
      this.transactionId = transactionId;
      return this;
    }

    /**
     * Set the accountId.
     *
     * @param accountId the accountId
     * @return the CreateTagOptions builder
     */
    public Builder accountId(String accountId) {
      this.accountId = accountId;
      return this;
    }

    /**
     * Set the tagType.
     *
     * @param tagType the tagType
     * @return the CreateTagOptions builder
     */
    public Builder tagType(String tagType) {
      this.tagType = tagType;
      return this;
    }
  }

  protected CreateTagOptions() { }

  protected CreateTagOptions(Builder builder) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.tagNames,
      "tagNames cannot be null");
    tagNames = builder.tagNames;
    xRequestId = builder.xRequestId;
    xCorrelationId = builder.xCorrelationId;
    transactionId = builder.transactionId;
    accountId = builder.accountId;
    tagType = builder.tagType;
  }

  /**
   * New builder.
   *
   * @return a CreateTagOptions builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the tagNames.
   *
   * An array of tag names to create.
   *
   * @return the tagNames
   */
  public List<String> tagNames() {
    return tagNames;
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
   * Gets the transactionId.
   *
   * An alphanumeric string that can be used to trace a request across services. If not specified, it automatically
   * generated with the prefix "gst-".
   *
   * @return the transactionId
   * @deprecated this method is deprecated and may be removed in a future release
   */
  @Deprecated
  public String transactionId() {
    return transactionId;
  }

  /**
   * Gets the accountId.
   *
   * The ID of the billing account where the tag must be created.
   *
   * @return the accountId
   */
  public String accountId() {
    return accountId;
  }

  /**
   * Gets the tagType.
   *
   * The type of the tags you want to create. The only allowed value is `access`.
   *
   * @return the tagType
   */
  public String tagType() {
    return tagType;
  }
}

