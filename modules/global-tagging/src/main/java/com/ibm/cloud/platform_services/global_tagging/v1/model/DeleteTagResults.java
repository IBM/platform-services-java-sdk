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
package com.ibm.cloud.platform_services.global_tagging.v1.model;

import java.util.List;

import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * Results of a delete_tag request.
 */
public class DeleteTagResults extends GenericModel {

  protected List<DeleteTagResultsItem> results;

  /**
   * Gets the results.
   *
   * Array of results of a delete_tag request.
   *
   * @return the results
   */
  public List<DeleteTagResultsItem> getResults() {
    return results;
  }
}

