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
package com.ibm.cloud.platform_services.global_tagging.v1.model;

import com.google.gson.annotations.SerializedName;
import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * CreateTagResultsResultsItem.
 */
public class CreateTagResultsResultsItem extends GenericModel {

  @SerializedName("tag_name")
  protected String tagName;
  @SerializedName("is_error")
  protected Boolean isError;

  protected CreateTagResultsResultsItem() { }

  /**
   * Gets the tagName.
   *
   * The name of the tag created.
   *
   * @return the tagName
   */
  public String getTagName() {
    return tagName;
  }

  /**
   * Gets the isError.
   *
   * true if the tag was not created (for example, the tag already exists).
   *
   * @return the isError
   */
  public Boolean isIsError() {
    return isError;
  }
}

