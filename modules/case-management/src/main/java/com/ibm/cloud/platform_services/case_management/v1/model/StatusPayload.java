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
 * Payload to update status of the case.
 *
 * Classes which extend this class:
 * - ResolvePayload
 * - UnresolvePayload
 * - AcceptPayload
 */
public class StatusPayload extends GenericModel {
  @SuppressWarnings("unused")
  protected static String discriminatorPropertyName = "action";
  protected static java.util.Map<String, Class<?>> discriminatorMapping;
  static {
    discriminatorMapping = new java.util.HashMap<>();
    discriminatorMapping.put("resolve", ResolvePayload.class);
    discriminatorMapping.put("unresolve", UnresolvePayload.class);
    discriminatorMapping.put("accept", AcceptPayload.class);
  }

  /**
   * action to perform on the case.
   */
  public interface Action {
    /** resolve. */
    String RESOLVE = "resolve";
    /** unresolve. */
    String UNRESOLVE = "unresolve";
    /** accept. */
    String ACCEPT = "accept";
  }

  protected String action;
  protected String comment;
  @SerializedName("resolution_code")
  protected Long resolutionCode;

  protected StatusPayload() {
  }

  /**
   * Gets the action.
   *
   * action to perform on the case.
   *
   * @return the action
   */
  public String action() {
    return action;
  }

  /**
   * Gets the comment.
   *
   * comment of resolution.
   *
   * @return the comment
   */
  public String comment() {
    return comment;
  }

  /**
   * Gets the resolutionCode.
   *
   * * 1: Client error
   * * 2: Defect found with Component/Service
   * * 3: Documentation Error
   * * 4: Sollution found in forums
   * * 5: Solution found in public Documentation
   * * 6: Solution no longer required
   * * 7: Solution provided by IBM outside of support case
   * * 8: Solution provided by IBM support engineer.
   *
   * @return the resolutionCode
   */
  public Long resolutionCode() {
    return resolutionCode;
  }
}

