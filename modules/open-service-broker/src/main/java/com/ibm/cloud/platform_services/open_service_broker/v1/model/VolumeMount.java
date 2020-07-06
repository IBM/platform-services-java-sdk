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
 * VolumeMount.
 */
public class VolumeMount extends GenericModel {

  protected String driver;
  @SerializedName("container_dir")
  protected String containerDir;
  protected String mode;
  @SerializedName("device_type")
  protected String deviceType;
  protected String device;

  /**
   * Gets the driver.
   *
   * A free-form hash of credentials that can be used by applications or users to access the service.
   *
   * @return the driver
   */
  public String getDriver() {
    return driver;
  }

  /**
   * Gets the containerDir.
   *
   * The path in the application container onto which the volume will be mounted. This specification does not mandate
   * what action the platform is to take if the path specified already exists in the container.
   *
   * @return the containerDir
   */
  public String getContainerDir() {
    return containerDir;
  }

  /**
   * Gets the mode.
   *
   * 'r' to mount the volume read-only or 'rw' to mount it read-write.
   *
   * @return the mode
   */
  public String getMode() {
    return mode;
  }

  /**
   * Gets the deviceType.
   *
   * A string specifying the type of device to mount. Currently the only supported value is 'shared'.
   *
   * @return the deviceType
   */
  public String getDeviceType() {
    return deviceType;
  }

  /**
   * Gets the device.
   *
   * Device object containing device_type specific details. Currently only shared devices are supported.
   *
   * @return the device
   */
  public String getDevice() {
    return device;
  }
}

