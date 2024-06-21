/*
 * (C) Copyright IBM Corp. 2024.
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
 * The attachTag options.
 */
public class AttachTagOptions extends GenericModel {

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

  protected List<Resource> resources;
  protected String tagName;
  protected List<String> tagNames;
  protected String xRequestId;
  protected String xCorrelationId;
  protected String accountId;
  protected String tagType;
  protected Boolean replace;
  protected Boolean update;

  /**
   * Builder.
   */
  public static class Builder {
    private List<Resource> resources;
    private String tagName;
    private List<String> tagNames;
    private String xRequestId;
    private String xCorrelationId;
    private String accountId;
    private String tagType;
    private Boolean replace;
    private Boolean update;

    /**
     * Instantiates a new Builder from an existing AttachTagOptions instance.
     *
     * @param attachTagOptions the instance to initialize the Builder with
     */
    private Builder(AttachTagOptions attachTagOptions) {
      this.resources = attachTagOptions.resources;
      this.tagName = attachTagOptions.tagName;
      this.tagNames = attachTagOptions.tagNames;
      this.xRequestId = attachTagOptions.xRequestId;
      this.xCorrelationId = attachTagOptions.xCorrelationId;
      this.accountId = attachTagOptions.accountId;
      this.tagType = attachTagOptions.tagType;
      this.replace = attachTagOptions.replace;
      this.update = attachTagOptions.update;
    }

    /**
     * Instantiates a new builder.
     */
    public Builder() {
    }

    /**
     * Instantiates a new builder with required properties.
     *
     * @param resources the resources
     */
    public Builder(List<Resource> resources) {
      this.resources = resources;
    }

    /**
     * Builds a AttachTagOptions.
     *
     * @return the new AttachTagOptions instance
     */
    public AttachTagOptions build() {
      return new AttachTagOptions(this);
    }

    /**
     * Adds a new element to resources.
     *
     * @param resources the new element to be added
     * @return the AttachTagOptions builder
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
     * Adds a new element to tagNames.
     *
     * @param tagNames the new element to be added
     * @return the AttachTagOptions builder
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
     * Set the resources.
     * Existing resources will be replaced.
     *
     * @param resources the resources
     * @return the AttachTagOptions builder
     */
    public Builder resources(List<Resource> resources) {
      this.resources = resources;
      return this;
    }

    /**
     * Set the tagName.
     *
     * @param tagName the tagName
     * @return the AttachTagOptions builder
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
     * @return the AttachTagOptions builder
     */
    public Builder tagNames(List<String> tagNames) {
      this.tagNames = tagNames;
      return this;
    }

    /**
     * Set the xRequestId.
     *
     * @param xRequestId the xRequestId
     * @return the AttachTagOptions builder
     */
    public Builder xRequestId(String xRequestId) {
      this.xRequestId = xRequestId;
      return this;
    }

    /**
     * Set the xCorrelationId.
     *
     * @param xCorrelationId the xCorrelationId
     * @return the AttachTagOptions builder
     */
    public Builder xCorrelationId(String xCorrelationId) {
      this.xCorrelationId = xCorrelationId;
      return this;
    }

    /**
     * Set the accountId.
     *
     * @param accountId the accountId
     * @return the AttachTagOptions builder
     */
    public Builder accountId(String accountId) {
      this.accountId = accountId;
      return this;
    }

    /**
     * Set the tagType.
     *
     * @param tagType the tagType
     * @return the AttachTagOptions builder
     */
    public Builder tagType(String tagType) {
      this.tagType = tagType;
      return this;
    }

    /**
     * Set the replace.
     *
     * @param replace the replace
     * @return the AttachTagOptions builder
     */
    public Builder replace(Boolean replace) {
      this.replace = replace;
      return this;
    }

    /**
     * Set the update.
     *
     * @param update the update
     * @return the AttachTagOptions builder
     */
    public Builder update(Boolean update) {
      this.update = update;
      return this;
    }
  }

  protected AttachTagOptions() { }

  protected AttachTagOptions(Builder builder) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.resources,
      "resources cannot be null");
    resources = builder.resources;
    tagName = builder.tagName;
    tagNames = builder.tagNames;
    xRequestId = builder.xRequestId;
    xCorrelationId = builder.xCorrelationId;
    accountId = builder.accountId;
    tagType = builder.tagType;
    replace = builder.replace;
    update = builder.update;
  }

  /**
   * New builder.
   *
   * @return a AttachTagOptions builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the resources.
   *
   * List of resources on which the tag or tags are attached.
   *
   * @return the resources
   */
  public List<Resource> resources() {
    return resources;
  }

  /**
   * Gets the tagName.
   *
   * The name of the tag to attach.
   *
   * @return the tagName
   */
  public String tagName() {
    return tagName;
  }

  /**
   * Gets the tagNames.
   *
   * An array of tag names to attach.
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
   * Gets the accountId.
   *
   * The ID of the billing account of the tagged resource. It is a required parameter if `tag_type` is set to `service`.
   * Otherwise, it is inferred from the authorization IAM token.
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

  /**
   * Gets the replace.
   *
   * Flag to request replacement of all attached tags. Set `true` if you want to replace all tags attached to the
   * resource with the current ones. Default value is false.
   *
   * @return the replace
   */
  public Boolean replace() {
    return replace;
  }

  /**
   * Gets the update.
   *
   * Flag to request update of attached tags in the format `key:value`. Here's how it works for each tag in the request
   * body: If the tag to attach is in the format `key:value`, the System will atomically detach all existing tags
   * starting with `key:` and attach the new `key:value` tag. If no such tags exist, a new `key:value` tag will be
   * attached. If the tag is not in the `key:value` format (e.g., a simple label), the System will attach the label as
   * usual. The update query parameter is available for user and access management tags, but not for service tags.
   *
   * @return the update
   */
  public Boolean update() {
    return update;
  }
}

