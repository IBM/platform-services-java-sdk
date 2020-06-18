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

import java.util.Date;
import java.util.List;

import com.google.gson.annotations.SerializedName;
import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * A chart entry in the repo. This response will contain many chart names.
 */
public class HelmRepoListChart extends GenericModel {

  @SerializedName("api_version")
  protected String apiVersion;
  protected Date created;
  protected String description;
  protected Boolean deprecated;
  protected String digest;
  protected String home;
  protected String icon;
  protected List<String> keywords;
  protected List<Maintainers> maintainers;
  protected String name;
  @SerializedName("tiller_version")
  protected String tillerVersion;
  protected List<String> urls;
  protected List<String> sources;
  protected String version;
  protected String appVersion;

  /**
   * Gets the apiVersion.
   *
   * API version.
   *
   * @return the apiVersion
   */
  public String getApiVersion() {
    return apiVersion;
  }

  /**
   * Gets the created.
   *
   * Date and time created.
   *
   * @return the created
   */
  public Date getCreated() {
    return created;
  }

  /**
   * Gets the description.
   *
   * Description of Helm repo entry.
   *
   * @return the description
   */
  public String getDescription() {
    return description;
  }

  /**
   * Gets the deprecated.
   *
   * Denotes whether repo entry is deprecated.
   *
   * @return the deprecated
   */
  public Boolean isDeprecated() {
    return deprecated;
  }

  /**
   * Gets the digest.
   *
   * Digest of entry.
   *
   * @return the digest
   */
  public String getDigest() {
    return digest;
  }

  /**
   * Gets the home.
   *
   * Location of repo entry.
   *
   * @return the home
   */
  public String getHome() {
    return home;
  }

  /**
   * Gets the icon.
   *
   * Entry icon.
   *
   * @return the icon
   */
  public String getIcon() {
    return icon;
  }

  /**
   * Gets the keywords.
   *
   * List of keywords.
   *
   * @return the keywords
   */
  public List<String> getKeywords() {
    return keywords;
  }

  /**
   * Gets the maintainers.
   *
   * Emails and names of repo maintainers.
   *
   * @return the maintainers
   */
  public List<Maintainers> getMaintainers() {
    return maintainers;
  }

  /**
   * Gets the name.
   *
   * Entry name.
   *
   * @return the name
   */
  public String getName() {
    return name;
  }

  /**
   * Gets the tillerVersion.
   *
   * Helm server version.
   *
   * @return the tillerVersion
   */
  public String getTillerVersion() {
    return tillerVersion;
  }

  /**
   * Gets the urls.
   *
   * Array of URLs.
   *
   * @return the urls
   */
  public List<String> getUrls() {
    return urls;
  }

  /**
   * Gets the sources.
   *
   * Array of sources.
   *
   * @return the sources
   */
  public List<String> getSources() {
    return sources;
  }

  /**
   * Gets the version.
   *
   * Entry version.
   *
   * @return the version
   */
  public String getVersion() {
    return version;
  }

  /**
   * Gets the appVersion.
   *
   * Application version.
   *
   * @return the appVersion
   */
  public String getAppVersion() {
    return appVersion;
  }
}

