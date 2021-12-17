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
import java.util.Date;
import java.util.List;
import java.util.Map;

import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * The createOffering options.
 */
public class CreateOfferingOptions extends GenericModel {

  protected String catalogIdentifier;
  protected String id;
  protected String rev;
  protected String url;
  protected String crn;
  protected String label;
  protected String name;
  protected String offeringIconUrl;
  protected String offeringDocsUrl;
  protected String offeringSupportUrl;
  protected List<String> tags;
  protected List<String> keywords;
  protected Rating rating;
  protected Date created;
  protected Date updated;
  protected String shortDescription;
  protected String longDescription;
  protected List<Feature> features;
  protected List<Kind> kinds;
  protected Boolean permitRequestIbmPublicPublish;
  protected Boolean ibmPublishApproved;
  protected Boolean publicPublishApproved;
  protected String publicOriginalCrn;
  protected String publishPublicCrn;
  protected String portalApprovalRecord;
  protected String portalUiUrl;
  protected String catalogId;
  protected String catalogName;
  protected Map<String, Object> metadata;
  protected String disclaimer;
  protected Boolean hidden;
  protected String provider;
  protected ProviderInfo providerInfo;
  protected RepoInfo repoInfo;
  protected Support support;
  protected List<MediaItem> media;

  /**
   * Builder.
   */
  public static class Builder {
    private String catalogIdentifier;
    private String id;
    private String rev;
    private String url;
    private String crn;
    private String label;
    private String name;
    private String offeringIconUrl;
    private String offeringDocsUrl;
    private String offeringSupportUrl;
    private List<String> tags;
    private List<String> keywords;
    private Rating rating;
    private Date created;
    private Date updated;
    private String shortDescription;
    private String longDescription;
    private List<Feature> features;
    private List<Kind> kinds;
    private Boolean permitRequestIbmPublicPublish;
    private Boolean ibmPublishApproved;
    private Boolean publicPublishApproved;
    private String publicOriginalCrn;
    private String publishPublicCrn;
    private String portalApprovalRecord;
    private String portalUiUrl;
    private String catalogId;
    private String catalogName;
    private Map<String, Object> metadata;
    private String disclaimer;
    private Boolean hidden;
    private String provider;
    private ProviderInfo providerInfo;
    private RepoInfo repoInfo;
    private Support support;
    private List<MediaItem> media;

    private Builder(CreateOfferingOptions createOfferingOptions) {
      this.catalogIdentifier = createOfferingOptions.catalogIdentifier;
      this.id = createOfferingOptions.id;
      this.rev = createOfferingOptions.rev;
      this.url = createOfferingOptions.url;
      this.crn = createOfferingOptions.crn;
      this.label = createOfferingOptions.label;
      this.name = createOfferingOptions.name;
      this.offeringIconUrl = createOfferingOptions.offeringIconUrl;
      this.offeringDocsUrl = createOfferingOptions.offeringDocsUrl;
      this.offeringSupportUrl = createOfferingOptions.offeringSupportUrl;
      this.tags = createOfferingOptions.tags;
      this.keywords = createOfferingOptions.keywords;
      this.rating = createOfferingOptions.rating;
      this.created = createOfferingOptions.created;
      this.updated = createOfferingOptions.updated;
      this.shortDescription = createOfferingOptions.shortDescription;
      this.longDescription = createOfferingOptions.longDescription;
      this.features = createOfferingOptions.features;
      this.kinds = createOfferingOptions.kinds;
      this.permitRequestIbmPublicPublish = createOfferingOptions.permitRequestIbmPublicPublish;
      this.ibmPublishApproved = createOfferingOptions.ibmPublishApproved;
      this.publicPublishApproved = createOfferingOptions.publicPublishApproved;
      this.publicOriginalCrn = createOfferingOptions.publicOriginalCrn;
      this.publishPublicCrn = createOfferingOptions.publishPublicCrn;
      this.portalApprovalRecord = createOfferingOptions.portalApprovalRecord;
      this.portalUiUrl = createOfferingOptions.portalUiUrl;
      this.catalogId = createOfferingOptions.catalogId;
      this.catalogName = createOfferingOptions.catalogName;
      this.metadata = createOfferingOptions.metadata;
      this.disclaimer = createOfferingOptions.disclaimer;
      this.hidden = createOfferingOptions.hidden;
      this.provider = createOfferingOptions.provider;
      this.providerInfo = createOfferingOptions.providerInfo;
      this.repoInfo = createOfferingOptions.repoInfo;
      this.support = createOfferingOptions.support;
      this.media = createOfferingOptions.media;
    }

    /**
     * Instantiates a new builder.
     */
    public Builder() {
    }

    /**
     * Instantiates a new builder with required properties.
     *
     * @param catalogIdentifier the catalogIdentifier
     */
    public Builder(String catalogIdentifier) {
      this.catalogIdentifier = catalogIdentifier;
    }

    /**
     * Builds a CreateOfferingOptions.
     *
     * @return the new CreateOfferingOptions instance
     */
    public CreateOfferingOptions build() {
      return new CreateOfferingOptions(this);
    }

    /**
     * Adds an tags to tags.
     *
     * @param tags the new tags
     * @return the CreateOfferingOptions builder
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
     * Adds an keywords to keywords.
     *
     * @param keywords the new keywords
     * @return the CreateOfferingOptions builder
     */
    public Builder addKeywords(String keywords) {
      com.ibm.cloud.sdk.core.util.Validator.notNull(keywords,
        "keywords cannot be null");
      if (this.keywords == null) {
        this.keywords = new ArrayList<String>();
      }
      this.keywords.add(keywords);
      return this;
    }

    /**
     * Adds an features to features.
     *
     * @param features the new features
     * @return the CreateOfferingOptions builder
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
     * Adds an kinds to kinds.
     *
     * @param kinds the new kinds
     * @return the CreateOfferingOptions builder
     */
    public Builder addKinds(Kind kinds) {
      com.ibm.cloud.sdk.core.util.Validator.notNull(kinds,
        "kinds cannot be null");
      if (this.kinds == null) {
        this.kinds = new ArrayList<Kind>();
      }
      this.kinds.add(kinds);
      return this;
    }

    /**
     * Adds an media to media.
     *
     * @param media the new media
     * @return the CreateOfferingOptions builder
     */
    public Builder addMedia(MediaItem media) {
      com.ibm.cloud.sdk.core.util.Validator.notNull(media,
        "media cannot be null");
      if (this.media == null) {
        this.media = new ArrayList<MediaItem>();
      }
      this.media.add(media);
      return this;
    }

    /**
     * Set the catalogIdentifier.
     *
     * @param catalogIdentifier the catalogIdentifier
     * @return the CreateOfferingOptions builder
     */
    public Builder catalogIdentifier(String catalogIdentifier) {
      this.catalogIdentifier = catalogIdentifier;
      return this;
    }

    /**
     * Set the id.
     *
     * @param id the id
     * @return the CreateOfferingOptions builder
     */
    public Builder id(String id) {
      this.id = id;
      return this;
    }

    /**
     * Set the rev.
     *
     * @param rev the rev
     * @return the CreateOfferingOptions builder
     */
    public Builder rev(String rev) {
      this.rev = rev;
      return this;
    }

    /**
     * Set the url.
     *
     * @param url the url
     * @return the CreateOfferingOptions builder
     */
    public Builder url(String url) {
      this.url = url;
      return this;
    }

    /**
     * Set the crn.
     *
     * @param crn the crn
     * @return the CreateOfferingOptions builder
     */
    public Builder crn(String crn) {
      this.crn = crn;
      return this;
    }

    /**
     * Set the label.
     *
     * @param label the label
     * @return the CreateOfferingOptions builder
     */
    public Builder label(String label) {
      this.label = label;
      return this;
    }

    /**
     * Set the name.
     *
     * @param name the name
     * @return the CreateOfferingOptions builder
     */
    public Builder name(String name) {
      this.name = name;
      return this;
    }

    /**
     * Set the offeringIconUrl.
     *
     * @param offeringIconUrl the offeringIconUrl
     * @return the CreateOfferingOptions builder
     */
    public Builder offeringIconUrl(String offeringIconUrl) {
      this.offeringIconUrl = offeringIconUrl;
      return this;
    }

    /**
     * Set the offeringDocsUrl.
     *
     * @param offeringDocsUrl the offeringDocsUrl
     * @return the CreateOfferingOptions builder
     */
    public Builder offeringDocsUrl(String offeringDocsUrl) {
      this.offeringDocsUrl = offeringDocsUrl;
      return this;
    }

    /**
     * Set the offeringSupportUrl.
     *
     * @param offeringSupportUrl the offeringSupportUrl
     * @return the CreateOfferingOptions builder
     */
    public Builder offeringSupportUrl(String offeringSupportUrl) {
      this.offeringSupportUrl = offeringSupportUrl;
      return this;
    }

    /**
     * Set the tags.
     * Existing tags will be replaced.
     *
     * @param tags the tags
     * @return the CreateOfferingOptions builder
     */
    public Builder tags(List<String> tags) {
      this.tags = tags;
      return this;
    }

    /**
     * Set the keywords.
     * Existing keywords will be replaced.
     *
     * @param keywords the keywords
     * @return the CreateOfferingOptions builder
     */
    public Builder keywords(List<String> keywords) {
      this.keywords = keywords;
      return this;
    }

    /**
     * Set the rating.
     *
     * @param rating the rating
     * @return the CreateOfferingOptions builder
     */
    public Builder rating(Rating rating) {
      this.rating = rating;
      return this;
    }

    /**
     * Set the created.
     *
     * @param created the created
     * @return the CreateOfferingOptions builder
     */
    public Builder created(Date created) {
      this.created = created;
      return this;
    }

    /**
     * Set the updated.
     *
     * @param updated the updated
     * @return the CreateOfferingOptions builder
     */
    public Builder updated(Date updated) {
      this.updated = updated;
      return this;
    }

    /**
     * Set the shortDescription.
     *
     * @param shortDescription the shortDescription
     * @return the CreateOfferingOptions builder
     */
    public Builder shortDescription(String shortDescription) {
      this.shortDescription = shortDescription;
      return this;
    }

    /**
     * Set the longDescription.
     *
     * @param longDescription the longDescription
     * @return the CreateOfferingOptions builder
     */
    public Builder longDescription(String longDescription) {
      this.longDescription = longDescription;
      return this;
    }

    /**
     * Set the features.
     * Existing features will be replaced.
     *
     * @param features the features
     * @return the CreateOfferingOptions builder
     */
    public Builder features(List<Feature> features) {
      this.features = features;
      return this;
    }

    /**
     * Set the kinds.
     * Existing kinds will be replaced.
     *
     * @param kinds the kinds
     * @return the CreateOfferingOptions builder
     */
    public Builder kinds(List<Kind> kinds) {
      this.kinds = kinds;
      return this;
    }

    /**
     * Set the permitRequestIbmPublicPublish.
     *
     * @param permitRequestIbmPublicPublish the permitRequestIbmPublicPublish
     * @return the CreateOfferingOptions builder
     */
    public Builder permitRequestIbmPublicPublish(Boolean permitRequestIbmPublicPublish) {
      this.permitRequestIbmPublicPublish = permitRequestIbmPublicPublish;
      return this;
    }

    /**
     * Set the ibmPublishApproved.
     *
     * @param ibmPublishApproved the ibmPublishApproved
     * @return the CreateOfferingOptions builder
     */
    public Builder ibmPublishApproved(Boolean ibmPublishApproved) {
      this.ibmPublishApproved = ibmPublishApproved;
      return this;
    }

    /**
     * Set the publicPublishApproved.
     *
     * @param publicPublishApproved the publicPublishApproved
     * @return the CreateOfferingOptions builder
     */
    public Builder publicPublishApproved(Boolean publicPublishApproved) {
      this.publicPublishApproved = publicPublishApproved;
      return this;
    }

    /**
     * Set the publicOriginalCrn.
     *
     * @param publicOriginalCrn the publicOriginalCrn
     * @return the CreateOfferingOptions builder
     */
    public Builder publicOriginalCrn(String publicOriginalCrn) {
      this.publicOriginalCrn = publicOriginalCrn;
      return this;
    }

    /**
     * Set the publishPublicCrn.
     *
     * @param publishPublicCrn the publishPublicCrn
     * @return the CreateOfferingOptions builder
     */
    public Builder publishPublicCrn(String publishPublicCrn) {
      this.publishPublicCrn = publishPublicCrn;
      return this;
    }

    /**
     * Set the portalApprovalRecord.
     *
     * @param portalApprovalRecord the portalApprovalRecord
     * @return the CreateOfferingOptions builder
     */
    public Builder portalApprovalRecord(String portalApprovalRecord) {
      this.portalApprovalRecord = portalApprovalRecord;
      return this;
    }

    /**
     * Set the portalUiUrl.
     *
     * @param portalUiUrl the portalUiUrl
     * @return the CreateOfferingOptions builder
     */
    public Builder portalUiUrl(String portalUiUrl) {
      this.portalUiUrl = portalUiUrl;
      return this;
    }

    /**
     * Set the catalogId.
     *
     * @param catalogId the catalogId
     * @return the CreateOfferingOptions builder
     */
    public Builder catalogId(String catalogId) {
      this.catalogId = catalogId;
      return this;
    }

    /**
     * Set the catalogName.
     *
     * @param catalogName the catalogName
     * @return the CreateOfferingOptions builder
     */
    public Builder catalogName(String catalogName) {
      this.catalogName = catalogName;
      return this;
    }

    /**
     * Set the metadata.
     *
     * @param metadata the metadata
     * @return the CreateOfferingOptions builder
     */
    public Builder metadata(Map<String, Object> metadata) {
      this.metadata = metadata;
      return this;
    }

    /**
     * Set the disclaimer.
     *
     * @param disclaimer the disclaimer
     * @return the CreateOfferingOptions builder
     */
    public Builder disclaimer(String disclaimer) {
      this.disclaimer = disclaimer;
      return this;
    }

    /**
     * Set the hidden.
     *
     * @param hidden the hidden
     * @return the CreateOfferingOptions builder
     */
    public Builder hidden(Boolean hidden) {
      this.hidden = hidden;
      return this;
    }

    /**
     * Set the provider.
     *
     * @param provider the provider
     * @return the CreateOfferingOptions builder
     */
    public Builder provider(String provider) {
      this.provider = provider;
      return this;
    }

    /**
     * Set the providerInfo.
     *
     * @param providerInfo the providerInfo
     * @return the CreateOfferingOptions builder
     */
    public Builder providerInfo(ProviderInfo providerInfo) {
      this.providerInfo = providerInfo;
      return this;
    }

    /**
     * Set the repoInfo.
     *
     * @param repoInfo the repoInfo
     * @return the CreateOfferingOptions builder
     */
    public Builder repoInfo(RepoInfo repoInfo) {
      this.repoInfo = repoInfo;
      return this;
    }

    /**
     * Set the support.
     *
     * @param support the support
     * @return the CreateOfferingOptions builder
     */
    public Builder support(Support support) {
      this.support = support;
      return this;
    }

    /**
     * Set the media.
     * Existing media will be replaced.
     *
     * @param media the media
     * @return the CreateOfferingOptions builder
     */
    public Builder media(List<MediaItem> media) {
      this.media = media;
      return this;
    }

    /**
     * Set the offering.
     *
     * @param offering the offering
     * @return the CreateOfferingOptions builder
     */
    public Builder offering(Offering offering) {
      this.id = offering.id();
      this.rev = offering.rev();
      this.url = offering.url();
      this.crn = offering.crn();
      this.label = offering.label();
      this.name = offering.name();
      this.offeringIconUrl = offering.offeringIconUrl();
      this.offeringDocsUrl = offering.offeringDocsUrl();
      this.offeringSupportUrl = offering.offeringSupportUrl();
      this.tags = offering.tags();
      this.keywords = offering.keywords();
      this.rating = offering.rating();
      this.created = offering.created();
      this.updated = offering.updated();
      this.shortDescription = offering.shortDescription();
      this.longDescription = offering.longDescription();
      this.features = offering.features();
      this.kinds = offering.kinds();
      this.permitRequestIbmPublicPublish = offering.permitRequestIbmPublicPublish();
      this.ibmPublishApproved = offering.ibmPublishApproved();
      this.publicPublishApproved = offering.publicPublishApproved();
      this.publicOriginalCrn = offering.publicOriginalCrn();
      this.publishPublicCrn = offering.publishPublicCrn();
      this.portalApprovalRecord = offering.portalApprovalRecord();
      this.portalUiUrl = offering.portalUiUrl();
      this.catalogId = offering.catalogId();
      this.catalogName = offering.catalogName();
      this.metadata = offering.metadata();
      this.disclaimer = offering.disclaimer();
      this.hidden = offering.hidden();
      this.provider = offering.provider();
      this.providerInfo = offering.providerInfo();
      this.repoInfo = offering.repoInfo();
      this.support = offering.support();
      this.media = offering.media();
      return this;
    }
  }

  protected CreateOfferingOptions(Builder builder) {
    com.ibm.cloud.sdk.core.util.Validator.notEmpty(builder.catalogIdentifier,
      "catalogIdentifier cannot be empty");
    catalogIdentifier = builder.catalogIdentifier;
    id = builder.id;
    rev = builder.rev;
    url = builder.url;
    crn = builder.crn;
    label = builder.label;
    name = builder.name;
    offeringIconUrl = builder.offeringIconUrl;
    offeringDocsUrl = builder.offeringDocsUrl;
    offeringSupportUrl = builder.offeringSupportUrl;
    tags = builder.tags;
    keywords = builder.keywords;
    rating = builder.rating;
    created = builder.created;
    updated = builder.updated;
    shortDescription = builder.shortDescription;
    longDescription = builder.longDescription;
    features = builder.features;
    kinds = builder.kinds;
    permitRequestIbmPublicPublish = builder.permitRequestIbmPublicPublish;
    ibmPublishApproved = builder.ibmPublishApproved;
    publicPublishApproved = builder.publicPublishApproved;
    publicOriginalCrn = builder.publicOriginalCrn;
    publishPublicCrn = builder.publishPublicCrn;
    portalApprovalRecord = builder.portalApprovalRecord;
    portalUiUrl = builder.portalUiUrl;
    catalogId = builder.catalogId;
    catalogName = builder.catalogName;
    metadata = builder.metadata;
    disclaimer = builder.disclaimer;
    hidden = builder.hidden;
    provider = builder.provider;
    providerInfo = builder.providerInfo;
    repoInfo = builder.repoInfo;
    support = builder.support;
    media = builder.media;
  }

  /**
   * New builder.
   *
   * @return a CreateOfferingOptions builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the catalogIdentifier.
   *
   * Catalog identifier.
   *
   * @return the catalogIdentifier
   */
  public String catalogIdentifier() {
    return catalogIdentifier;
  }

  /**
   * Gets the id.
   *
   * unique id.
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
   * Gets the url.
   *
   * The url for this specific offering.
   *
   * @return the url
   */
  public String url() {
    return url;
  }

  /**
   * Gets the crn.
   *
   * The crn for this specific offering.
   *
   * @return the crn
   */
  public String crn() {
    return crn;
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
   * Gets the name.
   *
   * The programmatic name of this offering.
   *
   * @return the name
   */
  public String name() {
    return name;
  }

  /**
   * Gets the offeringIconUrl.
   *
   * URL for an icon associated with this offering.
   *
   * @return the offeringIconUrl
   */
  public String offeringIconUrl() {
    return offeringIconUrl;
  }

  /**
   * Gets the offeringDocsUrl.
   *
   * URL for an additional docs with this offering.
   *
   * @return the offeringDocsUrl
   */
  public String offeringDocsUrl() {
    return offeringDocsUrl;
  }

  /**
   * Gets the offeringSupportUrl.
   *
   * [deprecated] - Use offering.support instead.  URL to be displayed in the Consumption UI for getting support on this
   * offering.
   *
   * @return the offeringSupportUrl
   */
  public String offeringSupportUrl() {
    return offeringSupportUrl;
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
   * Gets the keywords.
   *
   * List of keywords associated with offering, typically used to search for it.
   *
   * @return the keywords
   */
  public List<String> keywords() {
    return keywords;
  }

  /**
   * Gets the rating.
   *
   * Repository info for offerings.
   *
   * @return the rating
   */
  public Rating rating() {
    return rating;
  }

  /**
   * Gets the created.
   *
   * The date and time this catalog was created.
   *
   * @return the created
   */
  public Date created() {
    return created;
  }

  /**
   * Gets the updated.
   *
   * The date and time this catalog was last updated.
   *
   * @return the updated
   */
  public Date updated() {
    return updated;
  }

  /**
   * Gets the shortDescription.
   *
   * Short description in the requested language.
   *
   * @return the shortDescription
   */
  public String shortDescription() {
    return shortDescription;
  }

  /**
   * Gets the longDescription.
   *
   * Long description in the requested language.
   *
   * @return the longDescription
   */
  public String longDescription() {
    return longDescription;
  }

  /**
   * Gets the features.
   *
   * list of features associated with this offering.
   *
   * @return the features
   */
  public List<Feature> features() {
    return features;
  }

  /**
   * Gets the kinds.
   *
   * Array of kind.
   *
   * @return the kinds
   */
  public List<Kind> kinds() {
    return kinds;
  }

  /**
   * Gets the permitRequestIbmPublicPublish.
   *
   * Is it permitted to request publishing to IBM or Public.
   *
   * @return the permitRequestIbmPublicPublish
   */
  public Boolean permitRequestIbmPublicPublish() {
    return permitRequestIbmPublicPublish;
  }

  /**
   * Gets the ibmPublishApproved.
   *
   * Indicates if this offering has been approved for use by all IBMers.
   *
   * @return the ibmPublishApproved
   */
  public Boolean ibmPublishApproved() {
    return ibmPublishApproved;
  }

  /**
   * Gets the publicPublishApproved.
   *
   * Indicates if this offering has been approved for use by all IBM Cloud users.
   *
   * @return the publicPublishApproved
   */
  public Boolean publicPublishApproved() {
    return publicPublishApproved;
  }

  /**
   * Gets the publicOriginalCrn.
   *
   * The original offering CRN that this publish entry came from.
   *
   * @return the publicOriginalCrn
   */
  public String publicOriginalCrn() {
    return publicOriginalCrn;
  }

  /**
   * Gets the publishPublicCrn.
   *
   * The crn of the public catalog entry of this offering.
   *
   * @return the publishPublicCrn
   */
  public String publishPublicCrn() {
    return publishPublicCrn;
  }

  /**
   * Gets the portalApprovalRecord.
   *
   * The portal's approval record ID.
   *
   * @return the portalApprovalRecord
   */
  public String portalApprovalRecord() {
    return portalApprovalRecord;
  }

  /**
   * Gets the portalUiUrl.
   *
   * The portal UI URL.
   *
   * @return the portalUiUrl
   */
  public String portalUiUrl() {
    return portalUiUrl;
  }

  /**
   * Gets the catalogId.
   *
   * The id of the catalog containing this offering.
   *
   * @return the catalogId
   */
  public String catalogId() {
    return catalogId;
  }

  /**
   * Gets the catalogName.
   *
   * The name of the catalog.
   *
   * @return the catalogName
   */
  public String catalogName() {
    return catalogName;
  }

  /**
   * Gets the metadata.
   *
   * Map of metadata values for this offering.
   *
   * @return the metadata
   */
  public Map<String, Object> metadata() {
    return metadata;
  }

  /**
   * Gets the disclaimer.
   *
   * A disclaimer for this offering.
   *
   * @return the disclaimer
   */
  public String disclaimer() {
    return disclaimer;
  }

  /**
   * Gets the hidden.
   *
   * Determine if this offering should be displayed in the Consumption UI.
   *
   * @return the hidden
   */
  public Boolean hidden() {
    return hidden;
  }

  /**
   * Gets the provider.
   *
   * Deprecated - Provider of this offering.
   *
   * @return the provider
   */
  public String provider() {
    return provider;
  }

  /**
   * Gets the providerInfo.
   *
   * Information on the provider for this offering, or omitted if no provider information is given.
   *
   * @return the providerInfo
   */
  public ProviderInfo providerInfo() {
    return providerInfo;
  }

  /**
   * Gets the repoInfo.
   *
   * Repository info for offerings.
   *
   * @return the repoInfo
   */
  public RepoInfo repoInfo() {
    return repoInfo;
  }

  /**
   * Gets the support.
   *
   * Offering Support information.
   *
   * @return the support
   */
  public Support support() {
    return support;
  }

  /**
   * Gets the media.
   *
   * A list of media items related to this offering.
   *
   * @return the media
   */
  public List<MediaItem> media() {
    return media;
  }
}

