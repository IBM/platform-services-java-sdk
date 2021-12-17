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
package com.ibm.cloud.platform_services.catalog_management.v1.model;

import java.util.List;
import java.util.Map;

import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * Release information.
 */
public class InstallStatusRelease extends GenericModel {

  protected List<Map<String, Object>> deployments;
  protected List<Map<String, Object>> replicasets;
  protected List<Map<String, Object>> statefulsets;
  protected List<Map<String, Object>> pods;
  protected List<Map<String, String>> errors;

  /**
   * Gets the deployments.
   *
   * Kube deployments.
   *
   * @return the deployments
   */
  public List<Map<String, Object>> getDeployments() {
    return deployments;
  }

  /**
   * Gets the replicasets.
   *
   * Kube replica sets.
   *
   * @return the replicasets
   */
  public List<Map<String, Object>> getReplicasets() {
    return replicasets;
  }

  /**
   * Gets the statefulsets.
   *
   * Kube stateful sets.
   *
   * @return the statefulsets
   */
  public List<Map<String, Object>> getStatefulsets() {
    return statefulsets;
  }

  /**
   * Gets the pods.
   *
   * Kube pods.
   *
   * @return the pods
   */
  public List<Map<String, Object>> getPods() {
    return pods;
  }

  /**
   * Gets the errors.
   *
   * Kube errors.
   *
   * @return the errors
   */
  public List<Map<String, String>> getErrors() {
    return errors;
  }
}

