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

import java.util.List;
import java.util.Map;

import com.google.gson.annotations.SerializedName;
import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * Indicates if the current version can be upgraded to the version identified by the descriptor.
 */
public class VersionUpdateDescriptor extends GenericModel {

  @SerializedName("version_locator")
  protected String versionLocator;
  protected String version;
  protected State state;
  @SerializedName("required_resources")
  protected List<Resource> requiredResources;
  @SerializedName("package_version")
  protected String packageVersion;
  protected String sha;
  @SerializedName("can_update")
  protected Boolean canUpdate;
  protected Map<String, String> messages;

  /**
   * Gets the versionLocator.
   *
   * A dotted value of `catalogID`.`versionID`.
   *
   * @return the versionLocator
   */
  public String getVersionLocator() {
    return versionLocator;
  }

  /**
   * Gets the version.
   *
   * the version number of this version.
   *
   * @return the version
   */
  public String getVersion() {
    return version;
  }

  /**
   * Gets the state.
   *
   * Offering state.
   *
   * @return the state
   */
  public State getState() {
    return state;
  }

  /**
   * Gets the requiredResources.
   *
   * Resource requirments for installation.
   *
   * @return the requiredResources
   */
  public List<Resource> getRequiredResources() {
    return requiredResources;
  }

  /**
   * Gets the packageVersion.
   *
   * Version of package.
   *
   * @return the packageVersion
   */
  public String getPackageVersion() {
    return packageVersion;
  }

  /**
   * Gets the sha.
   *
   * The SHA value of this version.
   *
   * @return the sha
   */
  public String getSha() {
    return sha;
  }

  /**
   * Gets the canUpdate.
   *
   * true if the current version can be upgraded to this version, false otherwise.
   *
   * @return the canUpdate
   */
  public Boolean isCanUpdate() {
    return canUpdate;
  }

  /**
   * Gets the messages.
   *
   * If can_update is false, this map will contain messages for each failed check, otherwise it will be omitted.
   * Possible keys include nodes, cores, mem, disk, targetVersion, and install-permission-check.
   *
   * @return the messages
   */
  public Map<String, String> getMessages() {
    return messages;
  }
}

