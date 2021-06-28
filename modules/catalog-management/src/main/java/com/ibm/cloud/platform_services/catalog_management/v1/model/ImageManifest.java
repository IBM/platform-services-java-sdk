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

import com.ibm.cloud.sdk.core.service.model.GenericModel;

import java.util.List;

/**
 * Image Manifest.
 */
public class ImageManifest extends GenericModel {

  protected String description;
  protected List<Image> images;

  /**
   * Gets the description.
   *
   * Image manifest description.
   *
   * @return the description
   */
  public String getDescription() {
    return description;
  }

  /**
   * Gets the images.
   *
   * List of images.
   *
   * @return the images
   */
  public List<Image> getImages() {
    return images;
  }
}

