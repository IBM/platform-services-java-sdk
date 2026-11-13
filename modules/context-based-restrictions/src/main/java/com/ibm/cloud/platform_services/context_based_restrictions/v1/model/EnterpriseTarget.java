/*
 * (C) Copyright IBM Corp. 2026.
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

package com.ibm.cloud.platform_services.context_based_restrictions.v1.model;

import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * An enterprise entity target (e.g. an account within an enterprise).
 */
public class EnterpriseTarget extends GenericModel {

  /**
   * The type of the enterprise target.
   */
  public interface Type {
    /** Account. */
    String ACCOUNT = "Account";
    /** AccountGroup. */
    String ACCOUNTGROUP = "AccountGroup";
    /** Enterprise. */
    String ENTERPRISE = "Enterprise";
  }

  protected String type;
  protected String id;

  /**
   * Builder.
   */
  public static class Builder {
    private String type;
    private String id;

    /**
     * Instantiates a new Builder from an existing EnterpriseTarget instance.
     *
     * @param enterpriseTarget the instance to initialize the Builder with
     */
    private Builder(EnterpriseTarget enterpriseTarget) {
      this.type = enterpriseTarget.type;
      this.id = enterpriseTarget.id;
    }

    /**
     * Instantiates a new builder.
     */
    public Builder() {
    }

    /**
     * Instantiates a new builder with required properties.
     *
     * @param type the type
     * @param id the id
     */
    public Builder(String type, String id) {
      this.type = type;
      this.id = id;
    }

    /**
     * Builds a EnterpriseTarget.
     *
     * @return the new EnterpriseTarget instance
     */
    public EnterpriseTarget build() {
      return new EnterpriseTarget(this);
    }

    /**
     * Set the type.
     *
     * @param type the type
     * @return the EnterpriseTarget builder
     */
    public Builder type(String type) {
      this.type = type;
      return this;
    }

    /**
     * Set the id.
     *
     * @param id the id
     * @return the EnterpriseTarget builder
     */
    public Builder id(String id) {
      this.id = id;
      return this;
    }
  }

  protected EnterpriseTarget() { }

  protected EnterpriseTarget(Builder builder) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.type,
      "type cannot be null");
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.id,
      "id cannot be null");
    type = builder.type;
    id = builder.id;
  }

  /**
   * New builder.
   *
   * @return a EnterpriseTarget builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the type.
   *
   * The type of the enterprise target.
   *
   * @return the type
   */
  public String type() {
    return type;
  }

  /**
   * Gets the id.
   *
   * The ID of the enterprise target entity.
   *
   * @return the id
   */
  public String id() {
    return id;
  }
}

