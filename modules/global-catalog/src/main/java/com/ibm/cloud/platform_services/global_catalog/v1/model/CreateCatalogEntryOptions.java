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

package com.ibm.cloud.platform_services.global_catalog.v1.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * The createCatalogEntry options.
 */
public class CreateCatalogEntryOptions extends GenericModel {

  /**
   * The type of catalog entry, **service**, **template**, **dashboard**, which determines the type and shape of the
   * object.
   */
  public interface Kind {
    /** service. */
    String SERVICE = "service";
    /** template. */
    String TEMPLATE = "template";
    /** dashboard. */
    String DASHBOARD = "dashboard";
  }

  protected String name;
  protected String kind;
  protected Map<String, Overview> overviewUi;
  protected Image images;
  protected Boolean disabled;
  protected List<String> tags;
  protected Provider provider;
  protected String id;
  protected String parentId;
  protected Boolean group;
  protected Boolean active;
  protected String url;
  protected ObjectMetadataSet metadata;
  protected String account;

  /**
   * Builder.
   */
  public static class Builder {
    private String name;
    private String kind;
    private Map<String, Overview> overviewUi;
    private Image images;
    private Boolean disabled;
    private List<String> tags;
    private Provider provider;
    private String id;
    private String parentId;
    private Boolean group;
    private Boolean active;
    private String url;
    private ObjectMetadataSet metadata;
    private String account;

    /**
     * Instantiates a new Builder from an existing CreateCatalogEntryOptions instance.
     *
     * @param createCatalogEntryOptions the instance to initialize the Builder with
     */
    private Builder(CreateCatalogEntryOptions createCatalogEntryOptions) {
      this.name = createCatalogEntryOptions.name;
      this.kind = createCatalogEntryOptions.kind;
      this.overviewUi = createCatalogEntryOptions.overviewUi;
      this.images = createCatalogEntryOptions.images;
      this.disabled = createCatalogEntryOptions.disabled;
      this.tags = createCatalogEntryOptions.tags;
      this.provider = createCatalogEntryOptions.provider;
      this.id = createCatalogEntryOptions.id;
      this.parentId = createCatalogEntryOptions.parentId;
      this.group = createCatalogEntryOptions.group;
      this.active = createCatalogEntryOptions.active;
      this.url = createCatalogEntryOptions.url;
      this.metadata = createCatalogEntryOptions.metadata;
      this.account = createCatalogEntryOptions.account;
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
     * @param kind the kind
     * @param overviewUi the overviewUi
     * @param images the images
     * @param disabled the disabled
     * @param tags the tags
     * @param provider the provider
     * @param id the id
     */
    public Builder(String name, String kind, Map<String, Overview> overviewUi, Image images, Boolean disabled, List<String> tags, Provider provider, String id) {
      this.name = name;
      this.kind = kind;
      this.overviewUi = overviewUi;
      this.images = images;
      this.disabled = disabled;
      this.tags = tags;
      this.provider = provider;
      this.id = id;
    }

    /**
     * Builds a CreateCatalogEntryOptions.
     *
     * @return the new CreateCatalogEntryOptions instance
     */
    public CreateCatalogEntryOptions build() {
      return new CreateCatalogEntryOptions(this);
    }

    /**
     * Adds a new element to tags.
     *
     * @param tags the new element to be added
     * @return the CreateCatalogEntryOptions builder
     */
    public Builder addTags(String tags) {
      com.ibm.cloud.sdk.core.util.Validator.notNull(tags,
        "tags cannot be null");
      if (this.tags == null) {
        this.tags = new ArrayList<String>();
      }
      this.tags.add(tags);
      return this;
    }

    /**
     * Set the name.
     *
     * @param name the name
     * @return the CreateCatalogEntryOptions builder
     */
    public Builder name(String name) {
      this.name = name;
      return this;
    }

    /**
     * Set the kind.
     *
     * @param kind the kind
     * @return the CreateCatalogEntryOptions builder
     */
    public Builder kind(String kind) {
      this.kind = kind;
      return this;
    }

    /**
     * Set the overviewUi.
     *
     * @param overviewUi the overviewUi
     * @return the CreateCatalogEntryOptions builder
     */
    public Builder overviewUi(Map<String, Overview> overviewUi) {
      this.overviewUi = overviewUi;
      return this;
    }

    /**
     * Set the images.
     *
     * @param images the images
     * @return the CreateCatalogEntryOptions builder
     */
    public Builder images(Image images) {
      this.images = images;
      return this;
    }

    /**
     * Set the disabled.
     *
     * @param disabled the disabled
     * @return the CreateCatalogEntryOptions builder
     */
    public Builder disabled(Boolean disabled) {
      this.disabled = disabled;
      return this;
    }

    /**
     * Set the tags.
     * Existing tags will be replaced.
     *
     * @param tags the tags
     * @return the CreateCatalogEntryOptions builder
     */
    public Builder tags(List<String> tags) {
      this.tags = tags;
      return this;
    }

    /**
     * Set the provider.
     *
     * @param provider the provider
     * @return the CreateCatalogEntryOptions builder
     */
    public Builder provider(Provider provider) {
      this.provider = provider;
      return this;
    }

    /**
     * Set the id.
     *
     * @param id the id
     * @return the CreateCatalogEntryOptions builder
     */
    public Builder id(String id) {
      this.id = id;
      return this;
    }

    /**
     * Set the parentId.
     *
     * @param parentId the parentId
     * @return the CreateCatalogEntryOptions builder
     */
    public Builder parentId(String parentId) {
      this.parentId = parentId;
      return this;
    }

    /**
     * Set the group.
     *
     * @param group the group
     * @return the CreateCatalogEntryOptions builder
     */
    public Builder group(Boolean group) {
      this.group = group;
      return this;
    }

    /**
     * Set the active.
     *
     * @param active the active
     * @return the CreateCatalogEntryOptions builder
     */
    public Builder active(Boolean active) {
      this.active = active;
      return this;
    }

    /**
     * Set the url.
     *
     * @param url the url
     * @return the CreateCatalogEntryOptions builder
     */
    public Builder url(String url) {
      this.url = url;
      return this;
    }

    /**
     * Set the metadata.
     *
     * @param metadata the metadata
     * @return the CreateCatalogEntryOptions builder
     */
    public Builder metadata(ObjectMetadataSet metadata) {
      this.metadata = metadata;
      return this;
    }

    /**
     * Set the account.
     *
     * @param account the account
     * @return the CreateCatalogEntryOptions builder
     */
    public Builder account(String account) {
      this.account = account;
      return this;
    }
  }

  protected CreateCatalogEntryOptions() { }

  protected CreateCatalogEntryOptions(Builder builder) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.name,
      "name cannot be null");
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.kind,
      "kind cannot be null");
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.overviewUi,
      "overviewUi cannot be null");
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.images,
      "images cannot be null");
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.disabled,
      "disabled cannot be null");
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.tags,
      "tags cannot be null");
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.provider,
      "provider cannot be null");
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.id,
      "id cannot be null");
    name = builder.name;
    kind = builder.kind;
    overviewUi = builder.overviewUi;
    images = builder.images;
    disabled = builder.disabled;
    tags = builder.tags;
    provider = builder.provider;
    id = builder.id;
    parentId = builder.parentId;
    group = builder.group;
    active = builder.active;
    url = builder.url;
    metadata = builder.metadata;
    account = builder.account;
  }

  /**
   * New builder.
   *
   * @return a CreateCatalogEntryOptions builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the name.
   *
   * Programmatic name for this catalog entry, which must be formatted like a CRN segment. See the display name in
   * OverviewUI for a user-readable name.
   *
   * @return the name
   */
  public String name() {
    return name;
  }

  /**
   * Gets the kind.
   *
   * The type of catalog entry, **service**, **template**, **dashboard**, which determines the type and shape of the
   * object.
   *
   * @return the kind
   */
  public String kind() {
    return kind;
  }

  /**
   * Gets the overviewUi.
   *
   * Overview is nested in the top level. The key value pair is `[_language_]overview_ui`.
   *
   * @return the overviewUi
   */
  public Map<String, Overview> overviewUi() {
    return overviewUi;
  }

  /**
   * Gets the images.
   *
   * Image annotation for this catalog entry. The image is a URL.
   *
   * @return the images
   */
  public Image images() {
    return images;
  }

  /**
   * Gets the disabled.
   *
   * Boolean value that determines the global visibility for the catalog entry, and its children. If it is not enabled,
   * all plans are disabled.
   *
   * @return the disabled
   */
  public Boolean disabled() {
    return disabled;
  }

  /**
   * Gets the tags.
   *
   * A list of tags. For example, IBM, 3rd Party, Beta, GA, and Single Tenant.
   *
   * @return the tags
   */
  public List<String> tags() {
    return tags;
  }

  /**
   * Gets the provider.
   *
   * Information related to the provider associated with a catalog entry.
   *
   * @return the provider
   */
  public Provider provider() {
    return provider;
  }

  /**
   * Gets the id.
   *
   * Catalog entry's unique ID. It's the same across all catalog instances.
   *
   * @return the id
   */
  public String id() {
    return id;
  }

  /**
   * Gets the parentId.
   *
   * The ID of the parent catalog entry if it exists.
   *
   * @return the parentId
   */
  public String parentId() {
    return parentId;
  }

  /**
   * Gets the group.
   *
   * Boolean value that determines whether the catalog entry is a group.
   *
   * @return the group
   */
  public Boolean group() {
    return group;
  }

  /**
   * Gets the active.
   *
   * Boolean value that describes whether the service is active.
   *
   * @return the active
   */
  public Boolean active() {
    return active;
  }

  /**
   * Gets the url.
   *
   * Url of the object.
   *
   * @return the url
   */
  public String url() {
    return url;
  }

  /**
   * Gets the metadata.
   *
   * Model used to describe metadata object that can be set.
   *
   * @return the metadata
   */
  public ObjectMetadataSet metadata() {
    return metadata;
  }

  /**
   * Gets the account.
   *
   * This changes the scope of the request regardless of the authorization header. Example scopes are `account` and
   * `global`. `account=global` is reqired if operating with a service ID that has a global admin policy, for example
   * `GET /?account=global`.
   *
   * @return the account
   */
  public String account() {
    return account;
  }
}

