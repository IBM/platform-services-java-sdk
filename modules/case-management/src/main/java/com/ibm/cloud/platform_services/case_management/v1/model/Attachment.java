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
package com.ibm.cloud.platform_services.case_management.v1.model;

import com.google.gson.annotations.SerializedName;
import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * Details of an attachment.
 */
public class Attachment extends GenericModel {

  protected String id;
  protected String filename;
  @SerializedName("size_in_bytes")
  protected Long sizeInBytes;
  @SerializedName("created_at")
  protected String createdAt;
  protected String url;

  /**
   * Gets the id.
   *
   * Unique identifier of the attachment in database.
   *
   * @return the id
   */
  public String getId() {
    return id;
  }

  /**
   * Gets the filename.
   *
   * Name of the attachment.
   *
   * @return the filename
   */
  public String getFilename() {
    return filename;
  }

  /**
   * Gets the sizeInBytes.
   *
   * Size of the attachment in bytes.
   *
   * @return the sizeInBytes
   */
  public Long getSizeInBytes() {
    return sizeInBytes;
  }

  /**
   * Gets the createdAt.
   *
   * Date time of uploading in UTC.
   *
   * @return the createdAt
   */
  public String getCreatedAt() {
    return createdAt;
  }

  /**
   * Gets the url.
   *
   * URL of the attachment used to download.
   *
   * @return the url
   */
  public String getUrl() {
    return url;
  }
}

