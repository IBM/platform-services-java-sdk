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
package com.ibm.cloud.platform_services.global_catalog.v1.model;

import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * Artifact Details.
 */
public class Artifact extends GenericModel {

  protected String name;
  protected String updated;
  protected String url;
  protected String etag;
  protected Long size;

  /**
   * Gets the name.
   *
   * The name of the artifact.
   *
   * @return the name
   */
  public String getName() {
    return name;
  }

  /**
   * Gets the updated.
   *
   * The timestamp of the last update to the artifact.
   *
   * @return the updated
   */
  public String getUpdated() {
    return updated;
  }

  /**
   * Gets the url.
   *
   * The url for the artifact.
   *
   * @return the url
   */
  public String getUrl() {
    return url;
  }

  /**
   * Gets the etag.
   *
   * The etag of the artifact.
   *
   * @return the etag
   */
  public String getEtag() {
    return etag;
  }

  /**
   * Gets the size.
   *
   * The content length of the artifact.
   *
   * @return the size
   */
  public Long getSize() {
    return size;
  }
}

