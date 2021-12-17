/*
 * (C) Copyright IBM Corp. 2021.
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
package com.ibm.cloud.platform_services.catalog_management.v1.model;

import java.util.ArrayList;
import java.util.List;

import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * The createCatalog options.
 */
public class CreateCatalogOptions extends GenericModel {

  protected String id;
  protected String rev;
  protected String label;
  protected String shortDescription;
  protected String catalogIconUrl;
  protected List<String> tags;
  protected List<Feature> features;
  protected Boolean disabled;
  protected String resourceGroupId;
  protected String owningAccount;
  protected Filters catalogFilters;
  protected SyndicationResource syndicationSettings;
  protected String kind;

  /**
   * Builder.
   */
  public static class Builder {
    private String id;
    private String rev;
    private String label;
    private String shortDescription;
    private String catalogIconUrl;
    private List<String> tags;
    private List<Feature> features;
    private Boolean disabled;
    private String resourceGroupId;
    private String owningAccount;
    private Filters catalogFilters;
    private SyndicationResource syndicationSettings;
    private String kind;

    private Builder(CreateCatalogOptions createCatalogOptions) {
      this.id = createCatalogOptions.id;
      this.rev = createCatalogOptions.rev;
      this.label = createCatalogOptions.label;
      this.shortDescription = createCatalogOptions.shortDescription;
      this.catalogIconUrl = createCatalogOptions.catalogIconUrl;
      this.tags = createCatalogOptions.tags;
      this.features = createCatalogOptions.features;
      this.disabled = createCatalogOptions.disabled;
      this.resourceGroupId = createCatalogOptions.resourceGroupId;
      this.owningAccount = createCatalogOptions.owningAccount;
      this.catalogFilters = createCatalogOptions.catalogFilters;
      this.syndicationSettings = createCatalogOptions.syndicationSettings;
      this.kind = createCatalogOptions.kind;
    }

    /**
     * Instantiates a new builder.
     */
    public Builder() {
    }

    /**
     * Builds a CreateCatalogOptions.
     *
     * @return the new CreateCatalogOptions instance
     */
    public CreateCatalogOptions build() {
      return new CreateCatalogOptions(this);
    }

    /**
     * Adds an tags to tags.
     *
     * @param tags the new tags
     * @return the CreateCatalogOptions builder
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
     * Adds an features to features.
     *
     * @param features the new features
     * @return the CreateCatalogOptions builder
     */
    public Builder addFeatures(Feature features) {
      com.ibm.cloud.sdk.core.util.Validator.notNull(features,
        "features cannot be null");
      if (this.features == null) {
        this.features = new ArrayList<Feature>();
      }
      this.features.add(features);
      return this;
    }

    /**
     * Set the id.
     *
     * @param id the id
     * @return the CreateCatalogOptions builder
     */
    public Builder id(String id) {
      this.id = id;
      return this;
    }

    /**
     * Set the rev.
     *
     * @param rev the rev
     * @return the CreateCatalogOptions builder
     */
    public Builder rev(String rev) {
      this.rev = rev;
      return this;
    }

    /**
     * Set the label.
     *
     * @param label the label
     * @return the CreateCatalogOptions builder
     */
    public Builder label(String label) {
      this.label = label;
      return this;
    }

    /**
     * Set the shortDescription.
     *
     * @param shortDescription the shortDescription
     * @return the CreateCatalogOptions builder
     */
    public Builder shortDescription(String shortDescription) {
      this.shortDescription = shortDescription;
      return this;
    }

    /**
     * Set the catalogIconUrl.
     *
     * @param catalogIconUrl the catalogIconUrl
     * @return the CreateCatalogOptions builder
     */
    public Builder catalogIconUrl(String catalogIconUrl) {
      this.catalogIconUrl = catalogIconUrl;
      return this;
    }

    /**
     * Set the tags.
     * Existing tags will be replaced.
     *
     * @param tags the tags
     * @return the CreateCatalogOptions builder
     */
    public Builder tags(List<String> tags) {
      this.tags = tags;
      return this;
    }

    /**
     * Set the features.
     * Existing features will be replaced.
     *
     * @param features the features
     * @return the CreateCatalogOptions builder
     */
    public Builder features(List<Feature> features) {
      this.features = features;
      return this;
    }

    /**
     * Set the disabled.
     *
     * @param disabled the disabled
     * @return the CreateCatalogOptions builder
     */
    public Builder disabled(Boolean disabled) {
      this.disabled = disabled;
      return this;
    }

    /**
     * Set the resourceGroupId.
     *
     * @param resourceGroupId the resourceGroupId
     * @return the CreateCatalogOptions builder
     */
    public Builder resourceGroupId(String resourceGroupId) {
      this.resourceGroupId = resourceGroupId;
      return this;
    }

    /**
     * Set the owningAccount.
     *
     * @param owningAccount the owningAccount
     * @return the CreateCatalogOptions builder
     */
    public Builder owningAccount(String owningAccount) {
      this.owningAccount = owningAccount;
      return this;
    }

    /**
     * Set the catalogFilters.
     *
     * @param catalogFilters the catalogFilters
     * @return the CreateCatalogOptions builder
     */
    public Builder catalogFilters(Filters catalogFilters) {
      this.catalogFilters = catalogFilters;
      return this;
    }

    /**
     * Set the syndicationSettings.
     *
     * @param syndicationSettings the syndicationSettings
     * @return the CreateCatalogOptions builder
     */
    public Builder syndicationSettings(SyndicationResource syndicationSettings) {
      this.syndicationSettings = syndicationSettings;
      return this;
    }

    /**
     * Set the kind.
     *
     * @param kind the kind
     * @return the CreateCatalogOptions builder
     */
    public Builder kind(String kind) {
      this.kind = kind;
      return this;
    }

    /**
     * Set the catalog.
     *
     * @param catalog the catalog
     * @return the CreateCatalogOptions builder
     */
    public Builder catalog(Catalog catalog) {
      this.id = catalog.id();
      this.rev = catalog.rev();
      this.label = catalog.label();
      this.shortDescription = catalog.shortDescription();
      this.catalogIconUrl = catalog.catalogIconUrl();
      this.tags = catalog.tags();
      this.features = catalog.features();
      this.disabled = catalog.disabled();
      this.resourceGroupId = catalog.resourceGroupId();
      this.owningAccount = catalog.owningAccount();
      this.catalogFilters = catalog.catalogFilters();
      this.syndicationSettings = catalog.syndicationSettings();
      this.kind = catalog.kind();
      return this;
    }
  }

  protected CreateCatalogOptions(Builder builder) {
    id = builder.id;
    rev = builder.rev;
    label = builder.label;
    shortDescription = builder.shortDescription;
    catalogIconUrl = builder.catalogIconUrl;
    tags = builder.tags;
    features = builder.features;
    disabled = builder.disabled;
    resourceGroupId = builder.resourceGroupId;
    owningAccount = builder.owningAccount;
    catalogFilters = builder.catalogFilters;
    syndicationSettings = builder.syndicationSettings;
    kind = builder.kind;
  }

  /**
   * New builder.
   *
   * @return a CreateCatalogOptions builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the id.
   *
   * Unique ID.
   *
   * @return the id
   */
  public String id() {
    return id;
  }

  /**
   * Gets the rev.
   *
   * Cloudant revision.
   *
   * @return the rev
   */
  public String rev() {
    return rev;
  }

  /**
   * Gets the label.
   *
   * Display Name in the requested language.
   *
   * @return the label
   */
  public String label() {
    return label;
  }

  /**
   * Gets the shortDescription.
   *
   * Description in the requested language.
   *
   * @return the shortDescription
   */
  public String shortDescription() {
    return shortDescription;
  }

  /**
   * Gets the catalogIconUrl.
   *
   * URL for an icon associated with this catalog.
   *
   * @return the catalogIconUrl
   */
  public String catalogIconUrl() {
    return catalogIconUrl;
  }

  /**
   * Gets the tags.
   *
   * List of tags associated with this catalog.
   *
   * @return the tags
   */
  public List<String> tags() {
    return tags;
  }

  /**
   * Gets the features.
   *
   * List of features associated with this catalog.
   *
   * @return the features
   */
  public List<Feature> features() {
    return features;
  }

  /**
   * Gets the disabled.
   *
   * Denotes whether a catalog is disabled.
   *
   * @return the disabled
   */
  public Boolean disabled() {
    return disabled;
  }

  /**
   * Gets the resourceGroupId.
   *
   * Resource group id the catalog is owned by.
   *
   * @return the resourceGroupId
   */
  public String resourceGroupId() {
    return resourceGroupId;
  }

  /**
   * Gets the owningAccount.
   *
   * Account that owns catalog.
   *
   * @return the owningAccount
   */
  public String owningAccount() {
    return owningAccount;
  }

  /**
   * Gets the catalogFilters.
   *
   * Filters for account and catalog filters.
   *
   * @return the catalogFilters
   */
  public Filters catalogFilters() {
    return catalogFilters;
  }

  /**
   * Gets the syndicationSettings.
   *
   * Feature information.
   *
   * @return the syndicationSettings
   */
  public SyndicationResource syndicationSettings() {
    return syndicationSettings;
  }

  /**
   * Gets the kind.
   *
   * Kind of catalog. Supported kinds are offering and vpe.
   *
   * @return the kind
   */
  public String kind() {
    return kind;
  }
}

