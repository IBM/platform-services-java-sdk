/*
 * (C) Copyright IBM Corp. 2024.
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
package com.ibm.cloud.platform_services.usage_metering.v4.model;

import java.util.List;

import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * Response when usage submitted is accepted.
 */
public class ResponseAccepted extends GenericModel {

  protected List<ResourceUsageDetails> resources;

  protected ResponseAccepted() { }

  /**
   * Gets the resources.
   *
   * Response body that contains the status of each submitted usage record.
   *
   * @return the resources
   */
  public List<ResourceUsageDetails> getResources() {
    return resources;
  }
}

