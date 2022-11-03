/*
 * (C) Copyright IBM Corp. 2022.
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
package com.ibm.cloud.platform_services.resource_controller.v2.model;

import com.google.gson.annotations.SerializedName;
import com.google.gson.reflect.TypeToken;
import com.ibm.cloud.sdk.core.service.model.DynamicModel;

/**
 * The status of the last operation requested on the instance.
 */
public class ResourceInstanceLastOperation extends DynamicModel<Object> {

  /**
   * The last operation state of the resoure instance. This indicates if the resource's last operation is in progress,
   * succeeded or failed.
   */
  public interface State {
    /** in progress. */
    String IN_PROGRESS = "in progress";
    /** succeeded. */
    String SUCCEEDED = "succeeded";
    /** failed. */
    String FAILED = "failed";
  }

  @SerializedName("type")
  protected String type;
  @SerializedName("state")
  protected String state;
  @SerializedName("sub_type")
  protected String subType;
  @SerializedName("async")
  protected Boolean async;
  @SerializedName("description")
  protected String description;
  @SerializedName("reason_code")
  protected String reasonCode;
  @SerializedName("poll_after")
  protected Double pollAfter;
  @SerializedName("cancelable")
  protected Boolean cancelable;
  @SerializedName("poll")
  protected Boolean poll;

  public ResourceInstanceLastOperation() {
    super(new TypeToken<Object>() { });
  }

  /**
   * Gets the type.
   *
   * The last operation type of the resource instance.
   *
   * @return the type
   */
  public String getType() {
    return this.type;
  }

  /**
   * Gets the state.
   *
   * The last operation state of the resoure instance. This indicates if the resource's last operation is in progress,
   * succeeded or failed.
   *
   * @return the state
   */
  public String getState() {
    return this.state;
  }

  /**
   * Gets the subType.
   *
   * The last operation sub type of the resoure instance.
   *
   * @return the subType
   */
  public String getSubType() {
    return this.subType;
  }

  /**
   * Gets the async.
   *
   * A boolean that indicates if the resource is provisioned asynchronously or not.
   *
   * @return the async
   */
  public Boolean isAsync() {
    return this.async;
  }

  /**
   * Gets the description.
   *
   * The description of the status of last operation.
   *
   * @return the description
   */
  public String getDescription() {
    return this.description;
  }

  /**
   * Gets the reasonCode.
   *
   * Optional string that states the reason code for the last operation state change.
   *
   * @return the reasonCode
   */
  public String getReasonCode() {
    return this.reasonCode;
  }

  /**
   * Gets the pollAfter.
   *
   * A field which indicates the time after which the instance's last operation is to be polled.
   *
   * @return the pollAfter
   */
  public Double getPollAfter() {
    return this.pollAfter;
  }

  /**
   * Gets the cancelable.
   *
   * A boolean that indicates if the resource's last operation is cancelable or not.
   *
   * @return the cancelable
   */
  public Boolean isCancelable() {
    return this.cancelable;
  }

  /**
   * Gets the poll.
   *
   * A boolean that indicates if the resource broker's last operation can be polled or not.
   *
   * @return the poll
   */
  public Boolean isPoll() {
    return this.poll;
  }
}
