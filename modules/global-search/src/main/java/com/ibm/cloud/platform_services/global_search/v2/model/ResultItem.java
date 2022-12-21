/*
 * (C) Copyright IBM Corp. 2022.
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
package com.ibm.cloud.platform_services.global_search.v2.model;

import com.google.gson.annotations.SerializedName;
import com.google.gson.reflect.TypeToken;
import com.ibm.cloud.sdk.core.service.model.DynamicModel;

/**
 * A resource returned in a search result, which is identified by its `crn`. It contains other properties that depend on
 * the resource type.
 */
public class ResultItem extends DynamicModel<Object> {

  @SerializedName("crn")
  protected String crn;

  public ResultItem() {
    super(new TypeToken<Object>() { });
  }

  /**
   * Gets the crn.
   *
   * Resource identifier in CRN format.
   *
   * @return the crn
   */
  public String getCrn() {
    return this.crn;
  }
}
