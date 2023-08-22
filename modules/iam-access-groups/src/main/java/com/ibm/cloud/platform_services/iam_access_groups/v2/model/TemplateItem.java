/*
 * (C) Copyright IBM Corp. 2023.
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
package com.ibm.cloud.platform_services.iam_access_groups.v2.model;

import com.google.gson.annotations.SerializedName;
import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * TemplateItem.
 */
public class TemplateItem extends GenericModel {

  protected String id;
  protected String name;
  protected String description;
  protected String version;
  @SerializedName("created_at")
  protected String createdAt;
  @SerializedName("created_by_id")
  protected String createdById;
  @SerializedName("last_modified_at")
  protected String lastModifiedAt;
  @SerializedName("last_modified_by_id")
  protected String lastModifiedById;
  protected String href;

  protected TemplateItem() { }

  /**
   * Gets the id.
   *
   * The ID of the template.
   *
   * @return the id
   */
  public String getId() {
    return id;
  }

  /**
   * Gets the name.
   *
   * The name of the template.
   *
   * @return the name
   */
  public String getName() {
    return name;
  }

  /**
   * Gets the description.
   *
   * The description of the template.
   *
   * @return the description
   */
  public String getDescription() {
    return description;
  }

  /**
   * Gets the version.
   *
   * The version of the template.
   *
   * @return the version
   */
  public String getVersion() {
    return version;
  }

  /**
   * Gets the createdAt.
   *
   * The timestamp when the template was created.
   *
   * @return the createdAt
   */
  public String getCreatedAt() {
    return createdAt;
  }

  /**
   * Gets the createdById.
   *
   * The ID of the user who created the template.
   *
   * @return the createdById
   */
  public String getCreatedById() {
    return createdById;
  }

  /**
   * Gets the lastModifiedAt.
   *
   * The timestamp when the template was last modified.
   *
   * @return the lastModifiedAt
   */
  public String getLastModifiedAt() {
    return lastModifiedAt;
  }

  /**
   * Gets the lastModifiedById.
   *
   * The ID of the user who last modified the template.
   *
   * @return the lastModifiedById
   */
  public String getLastModifiedById() {
    return lastModifiedById;
  }

  /**
   * Gets the href.
   *
   * The URL to access the template resource.
   *
   * @return the href
   */
  public String getHref() {
    return href;
  }
}

