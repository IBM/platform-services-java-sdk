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
package com.ibm.cloud.platform_services.iam_identity.v1.model;

import com.google.gson.annotations.SerializedName;
import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * Context with key properties for problem determination.
 */
public class ResponseContext extends GenericModel {

  @SerializedName("transaction_id")
  protected String transactionId;
  protected String operation;
  @SerializedName("user_agent")
  protected String userAgent;
  protected String url;
  @SerializedName("instance_id")
  protected String instanceId;
  @SerializedName("thread_id")
  protected String threadId;
  protected String host;
  @SerializedName("start_time")
  protected String startTime;
  @SerializedName("end_time")
  protected String endTime;
  @SerializedName("elapsed_time")
  protected String elapsedTime;
  @SerializedName("cluster_name")
  protected String clusterName;

  /**
   * Gets the transactionId.
   *
   * The transaction ID of the inbound REST request.
   *
   * @return the transactionId
   */
  public String getTransactionId() {
    return transactionId;
  }

  /**
   * Gets the operation.
   *
   * The operation of the inbound REST request.
   *
   * @return the operation
   */
  public String getOperation() {
    return operation;
  }

  /**
   * Gets the userAgent.
   *
   * The user agent of the inbound REST request.
   *
   * @return the userAgent
   */
  public String getUserAgent() {
    return userAgent;
  }

  /**
   * Gets the url.
   *
   * The URL of that cluster.
   *
   * @return the url
   */
  public String getUrl() {
    return url;
  }

  /**
   * Gets the instanceId.
   *
   * The instance ID of the server instance processing the request.
   *
   * @return the instanceId
   */
  public String getInstanceId() {
    return instanceId;
  }

  /**
   * Gets the threadId.
   *
   * The thread ID of the server instance processing the request.
   *
   * @return the threadId
   */
  public String getThreadId() {
    return threadId;
  }

  /**
   * Gets the host.
   *
   * The host of the server instance processing the request.
   *
   * @return the host
   */
  public String getHost() {
    return host;
  }

  /**
   * Gets the startTime.
   *
   * The start time of the request.
   *
   * @return the startTime
   */
  public String getStartTime() {
    return startTime;
  }

  /**
   * Gets the endTime.
   *
   * The finish time of the request.
   *
   * @return the endTime
   */
  public String getEndTime() {
    return endTime;
  }

  /**
   * Gets the elapsedTime.
   *
   * The elapsed time in msec.
   *
   * @return the elapsedTime
   */
  public String getElapsedTime() {
    return elapsedTime;
  }

  /**
   * Gets the clusterName.
   *
   * The cluster name.
   *
   * @return the clusterName
   */
  public String getClusterName() {
    return clusterName;
  }
}

