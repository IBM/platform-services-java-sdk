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
package com.ibm.cloud.platform_services.global_tagging.v1.model;

import java.util.List;

import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * Results of an attach_tag or detach_tag request.
 */
public class TagResults extends GenericModel {

  protected List<TagResultsItem> results;

  /**
   * Gets the results.
   *
   * Array of results of an attach_tag or detach_tag request.
   *
   * @return the results
   */
  public List<TagResultsItem> getResults() {
    return results;
  }
}

