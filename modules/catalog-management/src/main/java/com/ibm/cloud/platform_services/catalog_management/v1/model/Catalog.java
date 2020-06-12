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
package com.ibm.cloud.platform_services.catalog_management.v1.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.google.gson.annotations.SerializedName;
import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * Catalog information.
 */
public class Catalog extends GenericModel {

  protected String id;
  @SerializedName("_rev")
  protected String rev;
  protected String label;
  @SerializedName("short_description")
  protected String shortDescription;
  @SerializedName("catalog_icon_url")
  protected String catalogIconUrl;
  protected List<String> tags;
  protected String url;
  protected String crn;
  @SerializedName("offerings_url")
  protected String offeringsUrl;
  protected List<Feature> features;
  protected Boolean disabled;
  protected Date created;
  protected Date updated;
  @SerializedName("resource_group_id")
  protected String resourceGroupId;
  @SerializedName("owning_account")
  protected String owningAccount;
  @SerializedName("catalog_filters")
  protected Filters catalogFilters;
  @SerializedName("syndication_settings")
  protected SyndicationResource syndicationSettings;

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
    private String url;
    private String crn;
    private String offeringsUrl;
    private List<Feature> features;
    private Boolean disabled;
    private Date created;
    private Date updated;
    private String resourceGroupId;
    private String owningAccount;
    private Filters catalogFilters;
    private SyndicationResource syndicationSettings;

    private Builder(Catalog catalog) {
      this.id = catalog.id;
      this.rev = catalog.rev;
      this.label = catalog.label;
      this.shortDescription = catalog.shortDescription;
      this.catalogIconUrl = catalog.catalogIconUrl;
      this.tags = catalog.tags;
      this.url = catalog.url;
      this.crn = catalog.crn;
      this.offeringsUrl = catalog.offeringsUrl;
      this.features = catalog.features;
      this.disabled = catalog.disabled;
      this.created = catalog.created;
      this.updated = catalog.updated;
      this.resourceGroupId = catalog.resourceGroupId;
      this.owningAccount = catalog.owningAccount;
      this.catalogFilters = catalog.catalogFilters;
      this.syndicationSettings = catalog.syndicationSettings;
    }

    /**
     * Instantiates a new builder.
     */
    public Builder() {
    }

    /**
     * Builds a Catalog.
     *
     * @return the new Catalog instance
     */
    public Catalog build() {
      return new Catalog(this);
    }

    /**
     * Adds an tags to tags.
     *
     * @param tags the new tags
     * @return the Catalog builder
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
     * @return the Catalog builder
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
     * @return the Catalog builder
     */
    public Builder id(String id) {
      this.id = id;
      return this;
    }

    /**
     * Set the rev.
     *
     * @param rev the rev
     * @return the Catalog builder
     */
    public Builder rev(String rev) {
      this.rev = rev;
      return this;
    }

    /**
     * Set the label.
     *
     * @param label the label
     * @return the Catalog builder
     */
    public Builder label(String label) {
      this.label = label;
      return this;
    }

    /**
     * Set the shortDescription.
     *
     * @param shortDescription the shortDescription
     * @return the Catalog builder
     */
    public Builder shortDescription(String shortDescription) {
      this.shortDescription = shortDescription;
      return this;
    }

    /**
     * Set the catalogIconUrl.
     *
     * @param catalogIconUrl the catalogIconUrl
     * @return the Catalog builder
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
     * @return the Catalog builder
     */
    public Builder tags(List<String> tags) {
      this.tags = tags;
      return this;
    }

    /**
     * Set the url.
     *
     * @param url the url
     * @return the Catalog builder
     */
    public Builder url(String url) {
      this.url = url;
      return this;
    }

    /**
     * Set the crn.
     *
     * @param crn the crn
     * @return the Catalog builder
     */
    public Builder crn(String crn) {
      this.crn = crn;
      return this;
    }

    /**
     * Set the offeringsUrl.
     *
     * @param offeringsUrl the offeringsUrl
     * @return the Catalog builder
     */
    public Builder offeringsUrl(String offeringsUrl) {
      this.offeringsUrl = offeringsUrl;
      return this;
    }

    /**
     * Set the features.
     * Existing features will be replaced.
     *
     * @param features the features
     * @return the Catalog builder
     */
    public Builder features(List<Feature> features) {
      this.features = features;
      return this;
    }

    /**
     * Set the disabled.
     *
     * @param disabled the disabled
     * @return the Catalog builder
     */
    public Builder disabled(Boolean disabled) {
      this.disabled = disabled;
      return this;
    }

    /**
     * Set the created.
     *
     * @param created the created
     * @return the Catalog builder
     */
    public Builder created(Date created) {
      this.created = created;
      return this;
    }

    /**
     * Set the updated.
     *
     * @param updated the updated
     * @return the Catalog builder
     */
    public Builder updated(Date updated) {
      this.updated = updated;
      return this;
    }

    /**
     * Set the resourceGroupId.
     *
     * @param resourceGroupId the resourceGroupId
     * @return the Catalog builder
     */
    public Builder resourceGroupId(String resourceGroupId) {
      this.resourceGroupId = resourceGroupId;
      return this;
    }

    /**
     * Set the owningAccount.
     *
     * @param owningAccount the owningAccount
     * @return the Catalog builder
     */
    public Builder owningAccount(String owningAccount) {
      this.owningAccount = owningAccount;
      return this;
    }

    /**
     * Set the catalogFilters.
     *
     * @param catalogFilters the catalogFilters
     * @return the Catalog builder
     */
    public Builder catalogFilters(Filters catalogFilters) {
      this.catalogFilters = catalogFilters;
      return this;
    }

    /**
     * Set the syndicationSettings.
     *
     * @param syndicationSettings the syndicationSettings
     * @return the Catalog builder
     */
    public Builder syndicationSettings(SyndicationResource syndicationSettings) {
      this.syndicationSettings = syndicationSettings;
      return this;
    }
  }

  protected Catalog(Builder builder) {
    id = builder.id;
    rev = builder.rev;
    label = builder.label;
    shortDescription = builder.shortDescription;
    catalogIconUrl = builder.catalogIconUrl;
    tags = builder.tags;
    url = builder.url;
    crn = builder.crn;
    offeringsUrl = builder.offeringsUrl;
    features = builder.features;
    disabled = builder.disabled;
    created = builder.created;
    updated = builder.updated;
    resourceGroupId = builder.resourceGroupId;
    owningAccount = builder.owningAccount;
    catalogFilters = builder.catalogFilters;
    syndicationSettings = builder.syndicationSettings;
  }

  /**
   * New builder.
   *
   * @return a Catalog builder
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
   * Gets the url.
   *
   * The url for this specific catalog.
   *
   * @return the url
   */
  public String url() {
    return url;
  }

  /**
   * Gets the crn.
   *
   * CRN associated with the catalog.
   *
   * @return the crn
   */
  public String crn() {
    return crn;
  }

  /**
   * Gets the offeringsUrl.
   *
   * URL path to offerings.
   *
   * @return the offeringsUrl
   */
  public String offeringsUrl() {
    return offeringsUrl;
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
   * Gets the created.
   *
   * The date'time this catalog was created.
   *
   * @return the created
   */
  public Date created() {
    return created;
  }

  /**
   * Gets the updated.
   *
   * The date'time this catalog was last updated.
   *
   * @return the updated
   */
  public Date updated() {
    return updated;
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
}

