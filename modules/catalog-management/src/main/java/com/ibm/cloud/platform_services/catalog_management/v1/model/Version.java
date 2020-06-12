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
import java.util.Map;

import com.google.gson.annotations.SerializedName;
import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * Offering version information.
 */
public class Version extends GenericModel {

  protected String id;
  @SerializedName("_rev")
  protected String rev;
  protected String crn;
  protected String version;
  protected String sha;
  protected Date created;
  protected Date updated;
  @SerializedName("offering_id")
  protected String offeringId;
  @SerializedName("catalog_id")
  protected String catalogId;
  @SerializedName("kind_id")
  protected String kindId;
  protected List<String> tags;
  @SerializedName("repo_url")
  protected String repoUrl;
  @SerializedName("source_url")
  protected String sourceUrl;
  @SerializedName("tgz_url")
  protected String tgzUrl;
  protected List<Configuration> configuration;
  protected Map<String, Object> metadata;
  protected Validation validation;
  @SerializedName("required_resources")
  protected List<Resource> requiredResources;
  @SerializedName("single_instance")
  protected Boolean singleInstance;
  protected Script install;
  @SerializedName("pre_install")
  protected List<Script> preInstall;
  protected VersionEntitlement entitlement;
  protected List<License> licenses;
  @SerializedName("image_manifest_url")
  protected String imageManifestUrl;
  protected Boolean deprecated;
  @SerializedName("package_version")
  protected String packageVersion;
  protected State state;
  @SerializedName("version_locator")
  protected String versionLocator;
  @SerializedName("console_url")
  protected String consoleUrl;
  @SerializedName("long_description")
  protected String longDescription;
  @SerializedName("whitelisted_accounts")
  protected List<String> whitelistedAccounts;

  /**
   * Builder.
   */
  public static class Builder {
    private String id;
    private String rev;
    private String crn;
    private String version;
    private String sha;
    private Date created;
    private Date updated;
    private String offeringId;
    private String catalogId;
    private String kindId;
    private List<String> tags;
    private String repoUrl;
    private String sourceUrl;
    private String tgzUrl;
    private List<Configuration> configuration;
    private Map<String, Object> metadata;
    private Validation validation;
    private List<Resource> requiredResources;
    private Boolean singleInstance;
    private Script install;
    private List<Script> preInstall;
    private VersionEntitlement entitlement;
    private List<License> licenses;
    private String imageManifestUrl;
    private Boolean deprecated;
    private String packageVersion;
    private State state;
    private String versionLocator;
    private String consoleUrl;
    private String longDescription;
    private List<String> whitelistedAccounts;

    private Builder(Version version) {
      this.id = version.id;
      this.rev = version.rev;
      this.crn = version.crn;
      this.version = version.version;
      this.sha = version.sha;
      this.created = version.created;
      this.updated = version.updated;
      this.offeringId = version.offeringId;
      this.catalogId = version.catalogId;
      this.kindId = version.kindId;
      this.tags = version.tags;
      this.repoUrl = version.repoUrl;
      this.sourceUrl = version.sourceUrl;
      this.tgzUrl = version.tgzUrl;
      this.configuration = version.configuration;
      this.metadata = version.metadata;
      this.validation = version.validation;
      this.requiredResources = version.requiredResources;
      this.singleInstance = version.singleInstance;
      this.install = version.install;
      this.preInstall = version.preInstall;
      this.entitlement = version.entitlement;
      this.licenses = version.licenses;
      this.imageManifestUrl = version.imageManifestUrl;
      this.deprecated = version.deprecated;
      this.packageVersion = version.packageVersion;
      this.state = version.state;
      this.versionLocator = version.versionLocator;
      this.consoleUrl = version.consoleUrl;
      this.longDescription = version.longDescription;
      this.whitelistedAccounts = version.whitelistedAccounts;
    }

    /**
     * Instantiates a new builder.
     */
    public Builder() {
    }

    /**
     * Builds a Version.
     *
     * @return the new Version instance
     */
    public Version build() {
      return new Version(this);
    }

    /**
     * Adds an tags to tags.
     *
     * @param tags the new tags
     * @return the Version builder
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
     * Adds an configuration to configuration.
     *
     * @param configuration the new configuration
     * @return the Version builder
     */
    public Builder addConfiguration(Configuration configuration) {
      com.ibm.cloud.sdk.core.util.Validator.notNull(configuration,
        "configuration cannot be null");
      if (this.configuration == null) {
        this.configuration = new ArrayList<Configuration>();
      }
      this.configuration.add(configuration);
      return this;
    }

    /**
     * Adds an requiredResources to requiredResources.
     *
     * @param requiredResources the new requiredResources
     * @return the Version builder
     */
    public Builder addRequiredResources(Resource requiredResources) {
      com.ibm.cloud.sdk.core.util.Validator.notNull(requiredResources,
        "requiredResources cannot be null");
      if (this.requiredResources == null) {
        this.requiredResources = new ArrayList<Resource>();
      }
      this.requiredResources.add(requiredResources);
      return this;
    }

    /**
     * Adds an preInstall to preInstall.
     *
     * @param preInstall the new preInstall
     * @return the Version builder
     */
    public Builder addPreInstall(Script preInstall) {
      com.ibm.cloud.sdk.core.util.Validator.notNull(preInstall,
        "preInstall cannot be null");
      if (this.preInstall == null) {
        this.preInstall = new ArrayList<Script>();
      }
      this.preInstall.add(preInstall);
      return this;
    }

    /**
     * Adds an licenses to licenses.
     *
     * @param licenses the new licenses
     * @return the Version builder
     */
    public Builder addLicenses(License licenses) {
      com.ibm.cloud.sdk.core.util.Validator.notNull(licenses,
        "licenses cannot be null");
      if (this.licenses == null) {
        this.licenses = new ArrayList<License>();
      }
      this.licenses.add(licenses);
      return this;
    }

    /**
     * Adds an whitelistedAccounts to whitelistedAccounts.
     *
     * @param whitelistedAccounts the new whitelistedAccounts
     * @return the Version builder
     */
    public Builder addWhitelistedAccounts(String whitelistedAccounts) {
      com.ibm.cloud.sdk.core.util.Validator.notNull(whitelistedAccounts,
        "whitelistedAccounts cannot be null");
      if (this.whitelistedAccounts == null) {
        this.whitelistedAccounts = new ArrayList<String>();
      }
      this.whitelistedAccounts.add(whitelistedAccounts);
      return this;
    }

    /**
     * Set the id.
     *
     * @param id the id
     * @return the Version builder
     */
    public Builder id(String id) {
      this.id = id;
      return this;
    }

    /**
     * Set the rev.
     *
     * @param rev the rev
     * @return the Version builder
     */
    public Builder rev(String rev) {
      this.rev = rev;
      return this;
    }

    /**
     * Set the crn.
     *
     * @param crn the crn
     * @return the Version builder
     */
    public Builder crn(String crn) {
      this.crn = crn;
      return this;
    }

    /**
     * Set the version.
     *
     * @param version the version
     * @return the Version builder
     */
    public Builder version(String version) {
      this.version = version;
      return this;
    }

    /**
     * Set the sha.
     *
     * @param sha the sha
     * @return the Version builder
     */
    public Builder sha(String sha) {
      this.sha = sha;
      return this;
    }

    /**
     * Set the created.
     *
     * @param created the created
     * @return the Version builder
     */
    public Builder created(Date created) {
      this.created = created;
      return this;
    }

    /**
     * Set the updated.
     *
     * @param updated the updated
     * @return the Version builder
     */
    public Builder updated(Date updated) {
      this.updated = updated;
      return this;
    }

    /**
     * Set the offeringId.
     *
     * @param offeringId the offeringId
     * @return the Version builder
     */
    public Builder offeringId(String offeringId) {
      this.offeringId = offeringId;
      return this;
    }

    /**
     * Set the catalogId.
     *
     * @param catalogId the catalogId
     * @return the Version builder
     */
    public Builder catalogId(String catalogId) {
      this.catalogId = catalogId;
      return this;
    }

    /**
     * Set the kindId.
     *
     * @param kindId the kindId
     * @return the Version builder
     */
    public Builder kindId(String kindId) {
      this.kindId = kindId;
      return this;
    }

    /**
     * Set the tags.
     * Existing tags will be replaced.
     *
     * @param tags the tags
     * @return the Version builder
     */
    public Builder tags(List<String> tags) {
      this.tags = tags;
      return this;
    }

    /**
     * Set the repoUrl.
     *
     * @param repoUrl the repoUrl
     * @return the Version builder
     */
    public Builder repoUrl(String repoUrl) {
      this.repoUrl = repoUrl;
      return this;
    }

    /**
     * Set the sourceUrl.
     *
     * @param sourceUrl the sourceUrl
     * @return the Version builder
     */
    public Builder sourceUrl(String sourceUrl) {
      this.sourceUrl = sourceUrl;
      return this;
    }

    /**
     * Set the tgzUrl.
     *
     * @param tgzUrl the tgzUrl
     * @return the Version builder
     */
    public Builder tgzUrl(String tgzUrl) {
      this.tgzUrl = tgzUrl;
      return this;
    }

    /**
     * Set the configuration.
     * Existing configuration will be replaced.
     *
     * @param configuration the configuration
     * @return the Version builder
     */
    public Builder configuration(List<Configuration> configuration) {
      this.configuration = configuration;
      return this;
    }

    /**
     * Set the metadata.
     *
     * @param metadata the metadata
     * @return the Version builder
     */
    public Builder metadata(Map<String, Object> metadata) {
      this.metadata = metadata;
      return this;
    }

    /**
     * Set the validation.
     *
     * @param validation the validation
     * @return the Version builder
     */
    public Builder validation(Validation validation) {
      this.validation = validation;
      return this;
    }

    /**
     * Set the requiredResources.
     * Existing requiredResources will be replaced.
     *
     * @param requiredResources the requiredResources
     * @return the Version builder
     */
    public Builder requiredResources(List<Resource> requiredResources) {
      this.requiredResources = requiredResources;
      return this;
    }

    /**
     * Set the singleInstance.
     *
     * @param singleInstance the singleInstance
     * @return the Version builder
     */
    public Builder singleInstance(Boolean singleInstance) {
      this.singleInstance = singleInstance;
      return this;
    }

    /**
     * Set the install.
     *
     * @param install the install
     * @return the Version builder
     */
    public Builder install(Script install) {
      this.install = install;
      return this;
    }

    /**
     * Set the preInstall.
     * Existing preInstall will be replaced.
     *
     * @param preInstall the preInstall
     * @return the Version builder
     */
    public Builder preInstall(List<Script> preInstall) {
      this.preInstall = preInstall;
      return this;
    }

    /**
     * Set the entitlement.
     *
     * @param entitlement the entitlement
     * @return the Version builder
     */
    public Builder entitlement(VersionEntitlement entitlement) {
      this.entitlement = entitlement;
      return this;
    }

    /**
     * Set the licenses.
     * Existing licenses will be replaced.
     *
     * @param licenses the licenses
     * @return the Version builder
     */
    public Builder licenses(List<License> licenses) {
      this.licenses = licenses;
      return this;
    }

    /**
     * Set the imageManifestUrl.
     *
     * @param imageManifestUrl the imageManifestUrl
     * @return the Version builder
     */
    public Builder imageManifestUrl(String imageManifestUrl) {
      this.imageManifestUrl = imageManifestUrl;
      return this;
    }

    /**
     * Set the deprecated.
     *
     * @param deprecated the deprecated
     * @return the Version builder
     */
    public Builder deprecated(Boolean deprecated) {
      this.deprecated = deprecated;
      return this;
    }

    /**
     * Set the packageVersion.
     *
     * @param packageVersion the packageVersion
     * @return the Version builder
     */
    public Builder packageVersion(String packageVersion) {
      this.packageVersion = packageVersion;
      return this;
    }

    /**
     * Set the state.
     *
     * @param state the state
     * @return the Version builder
     */
    public Builder state(State state) {
      this.state = state;
      return this;
    }

    /**
     * Set the versionLocator.
     *
     * @param versionLocator the versionLocator
     * @return the Version builder
     */
    public Builder versionLocator(String versionLocator) {
      this.versionLocator = versionLocator;
      return this;
    }

    /**
     * Set the consoleUrl.
     *
     * @param consoleUrl the consoleUrl
     * @return the Version builder
     */
    public Builder consoleUrl(String consoleUrl) {
      this.consoleUrl = consoleUrl;
      return this;
    }

    /**
     * Set the longDescription.
     *
     * @param longDescription the longDescription
     * @return the Version builder
     */
    public Builder longDescription(String longDescription) {
      this.longDescription = longDescription;
      return this;
    }

    /**
     * Set the whitelistedAccounts.
     * Existing whitelistedAccounts will be replaced.
     *
     * @param whitelistedAccounts the whitelistedAccounts
     * @return the Version builder
     */
    public Builder whitelistedAccounts(List<String> whitelistedAccounts) {
      this.whitelistedAccounts = whitelistedAccounts;
      return this;
    }
  }

  protected Version(Builder builder) {
    id = builder.id;
    rev = builder.rev;
    crn = builder.crn;
    version = builder.version;
    sha = builder.sha;
    created = builder.created;
    updated = builder.updated;
    offeringId = builder.offeringId;
    catalogId = builder.catalogId;
    kindId = builder.kindId;
    tags = builder.tags;
    repoUrl = builder.repoUrl;
    sourceUrl = builder.sourceUrl;
    tgzUrl = builder.tgzUrl;
    configuration = builder.configuration;
    metadata = builder.metadata;
    validation = builder.validation;
    requiredResources = builder.requiredResources;
    singleInstance = builder.singleInstance;
    install = builder.install;
    preInstall = builder.preInstall;
    entitlement = builder.entitlement;
    licenses = builder.licenses;
    imageManifestUrl = builder.imageManifestUrl;
    deprecated = builder.deprecated;
    packageVersion = builder.packageVersion;
    state = builder.state;
    versionLocator = builder.versionLocator;
    consoleUrl = builder.consoleUrl;
    longDescription = builder.longDescription;
    whitelistedAccounts = builder.whitelistedAccounts;
  }

  /**
   * New builder.
   *
   * @return a Version builder
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
   * Gets the crn.
   *
   * Version's CRN.
   *
   * @return the crn
   */
  public String crn() {
    return crn;
  }

  /**
   * Gets the version.
   *
   * Version of content type.
   *
   * @return the version
   */
  public String version() {
    return version;
  }

  /**
   * Gets the sha.
   *
   * hash of the content.
   *
   * @return the sha
   */
  public String sha() {
    return sha;
  }

  /**
   * Gets the created.
   *
   * The date and time this version was created.
   *
   * @return the created
   */
  public Date created() {
    return created;
  }

  /**
   * Gets the updated.
   *
   * The date and time this version was last updated.
   *
   * @return the updated
   */
  public Date updated() {
    return updated;
  }

  /**
   * Gets the offeringId.
   *
   * Offering ID.
   *
   * @return the offeringId
   */
  public String offeringId() {
    return offeringId;
  }

  /**
   * Gets the catalogId.
   *
   * Catalog ID.
   *
   * @return the catalogId
   */
  public String catalogId() {
    return catalogId;
  }

  /**
   * Gets the kindId.
   *
   * Kind ID.
   *
   * @return the kindId
   */
  public String kindId() {
    return kindId;
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
   * Gets the repoUrl.
   *
   * Content's repo URL.
   *
   * @return the repoUrl
   */
  public String repoUrl() {
    return repoUrl;
  }

  /**
   * Gets the sourceUrl.
   *
   * Content's source URL (e.g git repo).
   *
   * @return the sourceUrl
   */
  public String sourceUrl() {
    return sourceUrl;
  }

  /**
   * Gets the tgzUrl.
   *
   * File used to on-board this version.
   *
   * @return the tgzUrl
   */
  public String tgzUrl() {
    return tgzUrl;
  }

  /**
   * Gets the configuration.
   *
   * List of user solicited overrides.
   *
   * @return the configuration
   */
  public List<Configuration> configuration() {
    return configuration;
  }

  /**
   * Gets the metadata.
   *
   * Open ended metadata information.
   *
   * @return the metadata
   */
  public Map<String, Object> metadata() {
    return metadata;
  }

  /**
   * Gets the validation.
   *
   * Validation response.
   *
   * @return the validation
   */
  public Validation validation() {
    return validation;
  }

  /**
   * Gets the requiredResources.
   *
   * Resource requirments for installation.
   *
   * @return the requiredResources
   */
  public List<Resource> requiredResources() {
    return requiredResources;
  }

  /**
   * Gets the singleInstance.
   *
   * Denotes if single instance can be deployed to a given cluster.
   *
   * @return the singleInstance
   */
  public Boolean singleInstance() {
    return singleInstance;
  }

  /**
   * Gets the install.
   *
   * Script information.
   *
   * @return the install
   */
  public Script install() {
    return install;
  }

  /**
   * Gets the preInstall.
   *
   * Optional pre-install instructions.
   *
   * @return the preInstall
   */
  public List<Script> preInstall() {
    return preInstall;
  }

  /**
   * Gets the entitlement.
   *
   * Entitlement license info.
   *
   * @return the entitlement
   */
  public VersionEntitlement entitlement() {
    return entitlement;
  }

  /**
   * Gets the licenses.
   *
   * List of licenses the product was built with.
   *
   * @return the licenses
   */
  public List<License> licenses() {
    return licenses;
  }

  /**
   * Gets the imageManifestUrl.
   *
   * If set, denotes a url to a YAML file with list of container images used by this version.
   *
   * @return the imageManifestUrl
   */
  public String imageManifestUrl() {
    return imageManifestUrl;
  }

  /**
   * Gets the deprecated.
   *
   * read only field, indicating if this version is deprecated.
   *
   * @return the deprecated
   */
  public Boolean deprecated() {
    return deprecated;
  }

  /**
   * Gets the packageVersion.
   *
   * Version of the package used to create this version.
   *
   * @return the packageVersion
   */
  public String packageVersion() {
    return packageVersion;
  }

  /**
   * Gets the state.
   *
   * Offering state.
   *
   * @return the state
   */
  public State state() {
    return state;
  }

  /**
   * Gets the versionLocator.
   *
   * A dotted value of `catalogID`.`versionID`.
   *
   * @return the versionLocator
   */
  public String versionLocator() {
    return versionLocator;
  }

  /**
   * Gets the consoleUrl.
   *
   * Console URL.
   *
   * @return the consoleUrl
   */
  public String consoleUrl() {
    return consoleUrl;
  }

  /**
   * Gets the longDescription.
   *
   * Long description for version.
   *
   * @return the longDescription
   */
  public String longDescription() {
    return longDescription;
  }

  /**
   * Gets the whitelistedAccounts.
   *
   * Whitelisted accounts for version.
   *
   * @return the whitelistedAccounts
   */
  public List<String> whitelistedAccounts() {
    return whitelistedAccounts;
  }
}

