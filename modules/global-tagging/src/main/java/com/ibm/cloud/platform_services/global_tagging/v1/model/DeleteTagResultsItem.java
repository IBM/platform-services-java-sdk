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

import com.google.gson.annotations.SerializedName;
import com.google.gson.reflect.TypeToken;
import com.ibm.cloud.sdk.core.service.model.DynamicModel;

/**
 * Result of a delete_tag request.
 */
public class DeleteTagResultsItem extends DynamicModel<Object> {

  /**
   * The provider of the tag.
   */
  public interface Provider {
    /** ghost. */
    String GHOST = "ghost";
    /** ims. */
    String IMS = "ims";
  }

  @SerializedName("provider")
  protected String provider;
  @SerializedName("is_error")
  protected Boolean isError;

  public DeleteTagResultsItem() {
    super(new TypeToken<Object>() { });
  }

  /**
   * Gets the provider.
   *
   * The provider of the tag.
   *
   * @return the provider
   */
  public String getProvider() {
    return this.provider;
  }

  /**
   * Gets the isError.
   *
   * It is `true` if the operation exits with an error.
   *
   * @return the isError
   */
  public Boolean isIsError() {
    return this.isError;
  }
}
