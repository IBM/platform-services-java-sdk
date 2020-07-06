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
package com.ibm.cloud.platform_services.open_service_broker.v1.model;

import com.google.gson.annotations.SerializedName;
import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * OK - MUST be returned if the service instance already exists, is fully provisioned, and the requested parameters are
 * identical to the existing service instance.
 */
public class Resp2079872Root extends GenericModel {

  @SerializedName("dashboard_url")
  protected String dashboardUrl;
  protected String operation;

  /**
   * Gets the dashboardUrl.
   *
   * The URL of a web-based management user interface for the service instance; we refer to this as a service dashboard.
   * The URL MUST contain enough information for the dashboard to identify the resource being accessed. Note: a broker
   * that wishes to return `dashboard_url` for a service instance MUST return it with the initial response to the
   * provision request, even if the service is provisioned asynchronously. If present, it MUST be a non-empty string.
   *
   * @return the dashboardUrl
   */
  public String getDashboardUrl() {
    return dashboardUrl;
  }

  /**
   * Gets the operation.
   *
   * For asynchronous responses, service brokers MAY return an identifier representing the operation. The value of this
   * field MUST be provided by the platform with requests to the `last_operation` endpoint in a URL encoded query
   * parameter. If present, MUST be a non-empty string.
   *
   * @return the operation
   */
  public String getOperation() {
    return operation;
  }
}

