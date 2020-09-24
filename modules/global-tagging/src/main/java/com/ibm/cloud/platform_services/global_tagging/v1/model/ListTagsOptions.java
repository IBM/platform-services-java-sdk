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
package com.ibm.cloud.platform_services.global_tagging.v1.model;

import java.util.ArrayList;
import java.util.List;

import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * The listTags options.
 */
public class ListTagsOptions extends GenericModel {

  /**
   * The type of the tag you want to list. Supported values are `user` and `service`.
   */
  public interface TagType {
    /** user. */
    String USER = "user";
    /** service. */
    String SERVICE = "service";
  }

  public interface Providers {
    /** ghost. */
    String GHOST = "ghost";
    /** ims. */
    String IMS = "ims";
  }

  /**
   * Order the output by tag name.
   */
  public interface OrderByName {
    /** asc. */
    String ASC = "asc";
    /** desc. */
    String DESC = "desc";
  }

  protected String accountId;
  protected String tagType;
  protected Boolean fullData;
  protected List<String> providers;
  protected String attachedTo;
  protected Long offset;
  protected Long limit;
  protected Long timeout;
  protected String orderByName;
  protected Boolean attachedOnly;

  /**
   * Builder.
   */
  public static class Builder {
    private String accountId;
    private String tagType;
    private Boolean fullData;
    private List<String> providers;
    private String attachedTo;
    private Long offset;
    private Long limit;
    private Long timeout;
    private String orderByName;
    private Boolean attachedOnly;

    private Builder(ListTagsOptions listTagsOptions) {
      this.accountId = listTagsOptions.accountId;
      this.tagType = listTagsOptions.tagType;
      this.fullData = listTagsOptions.fullData;
      this.providers = listTagsOptions.providers;
      this.attachedTo = listTagsOptions.attachedTo;
      this.offset = listTagsOptions.offset;
      this.limit = listTagsOptions.limit;
      this.timeout = listTagsOptions.timeout;
      this.orderByName = listTagsOptions.orderByName;
      this.attachedOnly = listTagsOptions.attachedOnly;
    }

    /**
     * Instantiates a new builder.
     */
    public Builder() {
    }

    /**
     * Builds a ListTagsOptions.
     *
     * @return the new ListTagsOptions instance
     */
    public ListTagsOptions build() {
      return new ListTagsOptions(this);
    }

    /**
     * Adds an providers to providers.
     *
     * @param providers the new providers
     * @return the ListTagsOptions builder
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
     * Set the accountId.
     *
     * @param accountId the accountId
     * @return the ListTagsOptions builder
     */
    public Builder accountId(String accountId) {
      this.accountId = accountId;
      return this;
    }

    /**
     * Set the tagType.
     *
     * @param tagType the tagType
     * @return the ListTagsOptions builder
     */
    public Builder tagType(String tagType) {
      this.tagType = tagType;
      return this;
    }

    /**
     * Set the fullData.
     *
     * @param fullData the fullData
     * @return the ListTagsOptions builder
     */
    public Builder fullData(Boolean fullData) {
      this.fullData = fullData;
      return this;
    }

    /**
     * Set the providers.
     * Existing providers will be replaced.
     *
     * @param providers the providers
     * @return the ListTagsOptions builder
     */
    public Builder providers(List<String> providers) {
      this.providers = providers;
      return this;
    }

    /**
     * Set the attachedTo.
     *
     * @param attachedTo the attachedTo
     * @return the ListTagsOptions builder
     */
    public Builder attachedTo(String attachedTo) {
      this.attachedTo = attachedTo;
      return this;
    }

    /**
     * Set the offset.
     *
     * @param offset the offset
     * @return the ListTagsOptions builder
     */
    public Builder offset(long offset) {
      this.offset = offset;
      return this;
    }

    /**
     * Set the limit.
     *
     * @param limit the limit
     * @return the ListTagsOptions builder
     */
    public Builder limit(long limit) {
      this.limit = limit;
      return this;
    }

    /**
     * Set the timeout.
     *
     * @param timeout the timeout
     * @return the ListTagsOptions builder
     */
    public Builder timeout(long timeout) {
      this.timeout = timeout;
      return this;
    }

    /**
     * Set the orderByName.
     *
     * @param orderByName the orderByName
     * @return the ListTagsOptions builder
     */
    public Builder orderByName(String orderByName) {
      this.orderByName = orderByName;
      return this;
    }

    /**
     * Set the attachedOnly.
     *
     * @param attachedOnly the attachedOnly
     * @return the ListTagsOptions builder
     */
    public Builder attachedOnly(Boolean attachedOnly) {
      this.attachedOnly = attachedOnly;
      return this;
    }
  }

  protected ListTagsOptions(Builder builder) {
    accountId = builder.accountId;
    tagType = builder.tagType;
    fullData = builder.fullData;
    providers = builder.providers;
    attachedTo = builder.attachedTo;
    offset = builder.offset;
    limit = builder.limit;
    timeout = builder.timeout;
    orderByName = builder.orderByName;
    attachedOnly = builder.attachedOnly;
  }

  /**
   * New builder.
   *
   * @return a ListTagsOptions builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the accountId.
   *
   * The ID of the billing account to list the tags for. If it is not set, then it is taken from the authorization
   * token. This parameter is required if `tag_type` is set to `service`.
   *
   * @return the accountId
   */
  public String accountId() {
    return accountId;
  }

  /**
   * Gets the tagType.
   *
   * The type of the tag you want to list. Supported values are `user` and `service`.
   *
   * @return the tagType
   */
  public String tagType() {
    return tagType;
  }

  /**
   * Gets the fullData.
   *
   * If set to `true`, this query returns the provider, `ghost`, `ims` or `ghost,ims`, where the tag exists and the
   * number of attached resources.
   *
   * @return the fullData
   */
  public Boolean fullData() {
    return fullData;
  }

  /**
   * Gets the providers.
   *
   * Select a provider. Supported values are `ghost` and `ims`. To list GhoST tags and infrastructure tags use
   * `ghost,ims`. `service` tags can only be attached to GhoST onboarded resources, so you don't need to set this
   * parameter when listing `service` tags.
   *
   * @return the providers
   */
  public List<String> providers() {
    return providers;
  }

  /**
   * Gets the attachedTo.
   *
   * If you want to return only the list of tags attached to a specified resource, pass the ID of the resource on this
   * parameter. For GhoST onboarded resources, the resource ID is the CRN; for IMS resources, it is the IMS ID. When
   * using this parameter, you must specify the appropriate provider (`ims` or `ghost`).
   *
   * @return the attachedTo
   */
  public String attachedTo() {
    return attachedTo;
  }

  /**
   * Gets the offset.
   *
   * The offset is the index of the item from which you want to start returning data from.
   *
   * @return the offset
   */
  public Long offset() {
    return offset;
  }

  /**
   * Gets the limit.
   *
   * The number of tags to return.
   *
   * @return the limit
   */
  public Long limit() {
    return limit;
  }

  /**
   * Gets the timeout.
   *
   * The search timeout bounds the search request to be executed within the specified time value. It returns the hits
   * accumulated until time runs out.
   *
   * @return the timeout
   */
  public Long timeout() {
    return timeout;
  }

  /**
   * Gets the orderByName.
   *
   * Order the output by tag name.
   *
   * @return the orderByName
   */
  public String orderByName() {
    return orderByName;
  }

  /**
   * Gets the attachedOnly.
   *
   * Filter on attached tags. If `true`, it returns only tags that are attached to one or more resources. If `false`, it
   * returns all tags.
   *
   * @return the attachedOnly
   */
  public Boolean attachedOnly() {
    return attachedOnly;
  }
}

