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

import java.util.List;

import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * Artifacts List.
 */
public class Artifacts extends GenericModel {

  protected Long count;
  protected List<Artifact> resources;

  protected Artifacts() { }

  /**
   * Gets the count.
   *
   * The total number of artifacts.
   *
   * @return the count
   */
  public Long getCount() {
    return count;
  }

  /**
   * Gets the resources.
   *
   * The list of artifacts.
   *
   * @return the resources
   */
  public List<Artifact> getResources() {
    return resources;
  }
}

