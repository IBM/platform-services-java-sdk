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

import java.util.List;
import java.util.Map;

import com.google.gson.annotations.SerializedName;
import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * Resp2079876Root.
 */
public class Resp2079876Root extends GenericModel {

  protected Map<String, Object> credentials;
  @SerializedName("syslog_drain_url")
  protected String syslogDrainUrl;
  @SerializedName("route_service_url")
  protected String routeServiceUrl;
  @SerializedName("volume_mounts")
  protected List<VolumeMount> volumeMounts;

  /**
   * Gets the credentials.
   *
   * A free-form hash of credentials that can be used by applications or users to access the service.
   *
   * @return the credentials
   */
  public Map<String, Object> getCredentials() {
    return credentials;
  }

  /**
   * Gets the syslogDrainUrl.
   *
   * A URL to which logs MUST be streamed. 'requires':['syslog_drain'] MUST be declared in the Catalog endpoint or the
   * platform MUST consider the response invalid.
   *
   * @return the syslogDrainUrl
   */
  public String getSyslogDrainUrl() {
    return syslogDrainUrl;
  }

  /**
   * Gets the routeServiceUrl.
   *
   * A URL to which the platform MUST proxy requests for the address sent with bind_resource.route in the request body.
   * 'requires':['route_forwarding'] MUST be declared in the Catalog endpoint or the platform can consider the response
   * invalid.
   *
   * @return the routeServiceUrl
   */
  public String getRouteServiceUrl() {
    return routeServiceUrl;
  }

  /**
   * Gets the volumeMounts.
   *
   * An array of configuration for remote storage devices to be mounted into an application container filesystem.
   * 'requires':['volume_mount'] MUST be declared in the Catalog endpoint or the platform can consider the response
   * invalid.
   *
   * @return the volumeMounts
   */
  public List<VolumeMount> getVolumeMounts() {
    return volumeMounts;
  }
}

