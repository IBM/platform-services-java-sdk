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
   * Builder.
   */
  public static class Builder {
    private String transactionId;
    private String operation;
    private String userAgent;
    private String url;
    private String instanceId;
    private String threadId;
    private String host;
    private String startTime;
    private String endTime;
    private String elapsedTime;
    private String clusterName;

    /**
     * Instantiates a new Builder from an existing ResponseContext instance.
     *
     * @param responseContext the instance to initialize the Builder with
     */
    private Builder(ResponseContext responseContext) {
      this.transactionId = responseContext.transactionId;
      this.operation = responseContext.operation;
      this.userAgent = responseContext.userAgent;
      this.url = responseContext.url;
      this.instanceId = responseContext.instanceId;
      this.threadId = responseContext.threadId;
      this.host = responseContext.host;
      this.startTime = responseContext.startTime;
      this.endTime = responseContext.endTime;
      this.elapsedTime = responseContext.elapsedTime;
      this.clusterName = responseContext.clusterName;
    }

    /**
     * Instantiates a new builder.
     */
    public Builder() {
    }

    /**
     * Builds a ResponseContext.
     *
     * @return the new ResponseContext instance
     */
    public ResponseContext build() {
      return new ResponseContext(this);
    }

    /**
     * Set the transactionId.
     *
     * @param transactionId the transactionId
     * @return the ResponseContext builder
     */
    public Builder transactionId(String transactionId) {
      this.transactionId = transactionId;
      return this;
    }

    /**
     * Set the operation.
     *
     * @param operation the operation
     * @return the ResponseContext builder
     */
    public Builder operation(String operation) {
      this.operation = operation;
      return this;
    }

    /**
     * Set the userAgent.
     *
     * @param userAgent the userAgent
     * @return the ResponseContext builder
     */
    public Builder userAgent(String userAgent) {
      this.userAgent = userAgent;
      return this;
    }

    /**
     * Set the url.
     *
     * @param url the url
     * @return the ResponseContext builder
     */
    public Builder url(String url) {
      this.url = url;
      return this;
    }

    /**
     * Set the instanceId.
     *
     * @param instanceId the instanceId
     * @return the ResponseContext builder
     */
    public Builder instanceId(String instanceId) {
      this.instanceId = instanceId;
      return this;
    }

    /**
     * Set the threadId.
     *
     * @param threadId the threadId
     * @return the ResponseContext builder
     */
    public Builder threadId(String threadId) {
      this.threadId = threadId;
      return this;
    }

    /**
     * Set the host.
     *
     * @param host the host
     * @return the ResponseContext builder
     */
    public Builder host(String host) {
      this.host = host;
      return this;
    }

    /**
     * Set the startTime.
     *
     * @param startTime the startTime
     * @return the ResponseContext builder
     */
    public Builder startTime(String startTime) {
      this.startTime = startTime;
      return this;
    }

    /**
     * Set the endTime.
     *
     * @param endTime the endTime
     * @return the ResponseContext builder
     */
    public Builder endTime(String endTime) {
      this.endTime = endTime;
      return this;
    }

    /**
     * Set the elapsedTime.
     *
     * @param elapsedTime the elapsedTime
     * @return the ResponseContext builder
     */
    public Builder elapsedTime(String elapsedTime) {
      this.elapsedTime = elapsedTime;
      return this;
    }

    /**
     * Set the clusterName.
     *
     * @param clusterName the clusterName
     * @return the ResponseContext builder
     */
    public Builder clusterName(String clusterName) {
      this.clusterName = clusterName;
      return this;
    }
  }

  protected ResponseContext() { }

  protected ResponseContext(Builder builder) {
    transactionId = builder.transactionId;
    operation = builder.operation;
    userAgent = builder.userAgent;
    url = builder.url;
    instanceId = builder.instanceId;
    threadId = builder.threadId;
    host = builder.host;
    startTime = builder.startTime;
    endTime = builder.endTime;
    elapsedTime = builder.elapsedTime;
    clusterName = builder.clusterName;
  }

  /**
   * New builder.
   *
   * @return a ResponseContext builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the transactionId.
   *
   * The transaction ID of the inbound REST request.
   *
   * @return the transactionId
   */
  public String transactionId() {
    return transactionId;
  }

  /**
   * Gets the operation.
   *
   * The operation of the inbound REST request.
   *
   * @return the operation
   */
  public String operation() {
    return operation;
  }

  /**
   * Gets the userAgent.
   *
   * The user agent of the inbound REST request.
   *
   * @return the userAgent
   */
  public String userAgent() {
    return userAgent;
  }

  /**
   * Gets the url.
   *
   * The URL of that cluster.
   *
   * @return the url
   */
  public String url() {
    return url;
  }

  /**
   * Gets the instanceId.
   *
   * The instance ID of the server instance processing the request.
   *
   * @return the instanceId
   */
  public String instanceId() {
    return instanceId;
  }

  /**
   * Gets the threadId.
   *
   * The thread ID of the server instance processing the request.
   *
   * @return the threadId
   */
  public String threadId() {
    return threadId;
  }

  /**
   * Gets the host.
   *
   * The host of the server instance processing the request.
   *
   * @return the host
   */
  public String host() {
    return host;
  }

  /**
   * Gets the startTime.
   *
   * The start time of the request.
   *
   * @return the startTime
   */
  public String startTime() {
    return startTime;
  }

  /**
   * Gets the endTime.
   *
   * The finish time of the request.
   *
   * @return the endTime
   */
  public String endTime() {
    return endTime;
  }

  /**
   * Gets the elapsedTime.
   *
   * The elapsed time in msec.
   *
   * @return the elapsedTime
   */
  public String elapsedTime() {
    return elapsedTime;
  }

  /**
   * Gets the clusterName.
   *
   * The cluster name.
   *
   * @return the clusterName
   */
  public String clusterName() {
    return clusterName;
  }
}

