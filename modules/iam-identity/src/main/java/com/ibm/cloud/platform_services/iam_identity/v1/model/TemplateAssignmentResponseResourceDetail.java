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
package com.ibm.cloud.platform_services.iam_identity.v1.model;

import com.google.gson.annotations.SerializedName;
import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * TemplateAssignmentResponseResourceDetail.
 */
public class TemplateAssignmentResponseResourceDetail extends GenericModel {

  protected String id;
  protected String version;
  @SerializedName("resource_created")
  protected TemplateAssignmentResource resourceCreated;
  @SerializedName("error_message")
  protected TemplateAssignmentResourceError errorMessage;
  protected String status;

  protected TemplateAssignmentResponseResourceDetail() { }

  /**
   * Gets the id.
   *
   * Policy Template Id, only returned for a profile assignment with policy references.
   *
   * @return the id
   */
  public String getId() {
    return id;
  }

  /**
   * Gets the version.
   *
   * Policy version, only returned for a profile assignment with policy references.
   *
   * @return the version
   */
  public String getVersion() {
    return version;
  }

  /**
   * Gets the resourceCreated.
   *
   * Body parameters for created resource.
   *
   * @return the resourceCreated
   */
  public TemplateAssignmentResource getResourceCreated() {
    return resourceCreated;
  }

  /**
   * Gets the errorMessage.
   *
   * Body parameters for assignment error.
   *
   * @return the errorMessage
   */
  public TemplateAssignmentResourceError getErrorMessage() {
    return errorMessage;
  }

  /**
   * Gets the status.
   *
   * Status for the target account's assignment.
   *
   * @return the status
   */
  public String getStatus() {
    return status;
  }
}

