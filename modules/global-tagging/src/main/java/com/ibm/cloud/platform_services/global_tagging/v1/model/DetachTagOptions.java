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

package com.ibm.cloud.platform_services.global_tagging.v1.model;

import java.util.ArrayList;
import java.util.List;

import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * The detachTag options.
 */
public class DetachTagOptions extends GenericModel {

  /**
   * The type of the tag. Supported values are `user`, `service` and `access`. `service` and `access` are not supported
   * for IMS resources.
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
  protected List<String> tagNames;
  protected List<Resource> resources;
  protected QueryString query;
  protected String xRequestId;
  protected String xCorrelationId;
  protected String accountId;
  protected String tagType;

  /**
   * Builder.
   */
  public static class Builder {
    private String tagName;
    private List<String> tagNames;
    private List<Resource> resources;
    private QueryString query;
    private String xRequestId;
    private String xCorrelationId;
    private String accountId;
    private String tagType;

    /**
     * Instantiates a new Builder from an existing DetachTagOptions instance.
     *
     * @param detachTagOptions the instance to initialize the Builder with
     */
    private Builder(DetachTagOptions detachTagOptions) {
      this.tagName = detachTagOptions.tagName;
      this.tagNames = detachTagOptions.tagNames;
      this.resources = detachTagOptions.resources;
      this.query = detachTagOptions.query;
      this.xRequestId = detachTagOptions.xRequestId;
      this.xCorrelationId = detachTagOptions.xCorrelationId;
      this.accountId = detachTagOptions.accountId;
      this.tagType = detachTagOptions.tagType;
    }

    /**
     * Instantiates a new builder.
     */
    public Builder() {
    }

    /**
     * Builds a DetachTagOptions.
     *
     * @return the new DetachTagOptions instance
     */
    public DetachTagOptions build() {
      return new DetachTagOptions(this);
    }

    /**
     * Adds a new element to tagNames.
     *
     * @param tagNames the new element to be added
     * @return the DetachTagOptions builder
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
     * Adds a new element to resources.
     *
     * @param resources the new element to be added
     * @return the DetachTagOptions builder
     */
    public Builder addResources(Resource resources) {
      com.ibm.cloud.sdk.core.util.Validator.notNull(resources,
        "resources cannot be null");
      if (this.resources == null) {
        this.resources = new ArrayList<Resource>();
      }
      this.resources.add(resources);
      return this;
    }

    /**
     * Set the tagName.
     *
     * @param tagName the tagName
     * @return the DetachTagOptions builder
     */
    public Builder tagName(String tagName) {
      this.tagName = tagName;
      return this;
    }

    /**
     * Set the tagNames.
     * Existing tagNames will be replaced.
     *
     * @param tagNames the tagNames
     * @return the DetachTagOptions builder
     */
    public Builder tagNames(List<String> tagNames) {
      this.tagNames = tagNames;
      return this;
    }

    /**
     * Set the resources.
     * Existing resources will be replaced.
     *
     * @param resources the resources
     * @return the DetachTagOptions builder
     */
    public Builder resources(List<Resource> resources) {
      this.resources = resources;
      return this;
    }

    /**
     * Set the query.
     *
     * @param query the query
     * @return the DetachTagOptions builder
     */
    public Builder query(QueryString query) {
      this.query = query;
      return this;
    }

    /**
     * Set the xRequestId.
     *
     * @param xRequestId the xRequestId
     * @return the DetachTagOptions builder
     */
    public Builder xRequestId(String xRequestId) {
      this.xRequestId = xRequestId;
      return this;
    }

    /**
     * Set the xCorrelationId.
     *
     * @param xCorrelationId the xCorrelationId
     * @return the DetachTagOptions builder
     */
    public Builder xCorrelationId(String xCorrelationId) {
      this.xCorrelationId = xCorrelationId;
      return this;
    }

    /**
     * Set the accountId.
     *
     * @param accountId the accountId
     * @return the DetachTagOptions builder
     */
    public Builder accountId(String accountId) {
      this.accountId = accountId;
      return this;
    }

    /**
     * Set the tagType.
     *
     * @param tagType the tagType
     * @return the DetachTagOptions builder
     */
    public Builder tagType(String tagType) {
      this.tagType = tagType;
      return this;
    }
  }

  protected DetachTagOptions() { }

  protected DetachTagOptions(Builder builder) {
    tagName = builder.tagName;
    tagNames = builder.tagNames;
    resources = builder.resources;
    query = builder.query;
    xRequestId = builder.xRequestId;
    xCorrelationId = builder.xCorrelationId;
    accountId = builder.accountId;
    tagType = builder.tagType;
  }

  /**
   * New builder.
   *
   * @return a DetachTagOptions builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the tagName.
   *
   * The name of the tag to detach.
   *
   * @return the tagName
   */
  public String tagName() {
    return tagName;
  }

  /**
   * Gets the tagNames.
   *
   * An array of tag names to detach.
   *
   * @return the tagNames
   */
  public List<String> tagNames() {
    return tagNames;
  }

  /**
   * Gets the resources.
   *
   * List of resources on which the tagging operation operates on.
   *
   * @return the resources
   */
  public List<Resource> resources() {
    return resources;
  }

  /**
   * Gets the query.
   *
   * A valid Global Search string.
   *
   * @return the query
   */
  public QueryString query() {
    return query;
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
   * Gets the accountId.
   *
   * The ID of the billing account of the untagged resource. It is a required parameter if `tag_type` is set to
   * `service`, otherwise it is inferred from the authorization IAM token.
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
   * for IMS resources.
   *
   * @return the tagType
   */
  public String tagType() {
    return tagType;
  }
}

