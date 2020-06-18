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

import com.google.gson.annotations.SerializedName;
import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * Installation status.
 */
public class InstallStatus extends GenericModel {

  protected InstallStatusMetadata metadata;
  protected InstallStatusRelease release;
  @SerializedName("content_mgmt")
  protected InstallStatusContentMgmt contentMgmt;

  /**
   * Gets the metadata.
   *
   * Installation status metadata.
   *
   * @return the metadata
   */
  public InstallStatusMetadata getMetadata() {
    return metadata;
  }

  /**
   * Gets the release.
   *
   * Release information.
   *
   * @return the release
   */
  public InstallStatusRelease getRelease() {
    return release;
  }

  /**
   * Gets the contentMgmt.
   *
   * Content management information.
   *
   * @return the contentMgmt
   */
  public InstallStatusContentMgmt getContentMgmt() {
    return contentMgmt;
  }
}

