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

import com.google.gson.annotations.SerializedName;
import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * The results of a deleting unattatched tags.
 */
public class DeleteTagsResult extends GenericModel {

  @SerializedName("total_count")
  protected Long totalCount;
  protected Boolean errors;
  protected List<DeleteTagsResultItem> items;

  /**
   * Gets the totalCount.
   *
   * The number of tags deleted in the account.
   *
   * @return the totalCount
   */
  public Long getTotalCount() {
    return totalCount;
  }

  /**
   * Gets the errors.
   *
   * An indicator that is set to true if there was an error deleting some of the tags.
   *
   * @return the errors
   */
  public Boolean isErrors() {
    return errors;
  }

  /**
   * Gets the items.
   *
   * @return the items
   */
  public List<DeleteTagsResultItem> getItems() {
    return items;
  }
}

