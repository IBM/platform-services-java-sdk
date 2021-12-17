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

import com.google.gson.annotations.SerializedName;
import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * Script information.
 */
public class Script extends GenericModel {

  protected String instructions;
  protected String script;
  @SerializedName("script_permission")
  protected String scriptPermission;
  @SerializedName("delete_script")
  protected String deleteScript;
  protected String scope;

  /**
   * Builder.
   */
  public static class Builder {
    private String instructions;
    private String script;
    private String scriptPermission;
    private String deleteScript;
    private String scope;

    private Builder(Script script) {
      this.instructions = script.instructions;
      this.script = script.script;
      this.scriptPermission = script.scriptPermission;
      this.deleteScript = script.deleteScript;
      this.scope = script.scope;
    }

    /**
     * Instantiates a new builder.
     */
    public Builder() {
    }

    /**
     * Builds a Script.
     *
     * @return the new Script instance
     */
    public Script build() {
      return new Script(this);
    }

    /**
     * Set the instructions.
     *
     * @param instructions the instructions
     * @return the Script builder
     */
    public Builder instructions(String instructions) {
      this.instructions = instructions;
      return this;
    }

    /**
     * Set the script.
     *
     * @param script the script
     * @return the Script builder
     */
    public Builder script(String script) {
      this.script = script;
      return this;
    }

    /**
     * Set the scriptPermission.
     *
     * @param scriptPermission the scriptPermission
     * @return the Script builder
     */
    public Builder scriptPermission(String scriptPermission) {
      this.scriptPermission = scriptPermission;
      return this;
    }

    /**
     * Set the deleteScript.
     *
     * @param deleteScript the deleteScript
     * @return the Script builder
     */
    public Builder deleteScript(String deleteScript) {
      this.deleteScript = deleteScript;
      return this;
    }

    /**
     * Set the scope.
     *
     * @param scope the scope
     * @return the Script builder
     */
    public Builder scope(String scope) {
      this.scope = scope;
      return this;
    }
  }

  protected Script(Builder builder) {
    instructions = builder.instructions;
    script = builder.script;
    scriptPermission = builder.scriptPermission;
    deleteScript = builder.deleteScript;
    scope = builder.scope;
  }

  /**
   * New builder.
   *
   * @return a Script builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the instructions.
   *
   * Instruction on step and by whom (role) that are needed to take place to prepare the target for installing this
   * version.
   *
   * @return the instructions
   */
  public String instructions() {
    return instructions;
  }

  /**
   * Gets the script.
   *
   * Optional script that needs to be run post any pre-condition script.
   *
   * @return the script
   */
  public String script() {
    return script;
  }

  /**
   * Gets the scriptPermission.
   *
   * Optional iam permissions that are required on the target cluster to run this script.
   *
   * @return the scriptPermission
   */
  public String scriptPermission() {
    return scriptPermission;
  }

  /**
   * Gets the deleteScript.
   *
   * Optional script that if run will remove the installed version.
   *
   * @return the deleteScript
   */
  public String deleteScript() {
    return deleteScript;
  }

  /**
   * Gets the scope.
   *
   * Optional value indicating if this script is scoped to a namespace or the entire cluster.
   *
   * @return the scope
   */
  public String scope() {
    return scope;
  }
}

