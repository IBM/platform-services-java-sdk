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

import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * Link details.
 */
public class CreateProfileLinkRequestLink extends GenericModel {

  protected String crn;
  protected String namespace;
  protected String name;

  /**
   * Builder.
   */
  public static class Builder {
    private String crn;
    private String namespace;
    private String name;

    private Builder(CreateProfileLinkRequestLink createProfileLinkRequestLink) {
      this.crn = createProfileLinkRequestLink.crn;
      this.namespace = createProfileLinkRequestLink.namespace;
      this.name = createProfileLinkRequestLink.name;
    }

    /**
     * Instantiates a new builder.
     */
    public Builder() {
    }

    /**
     * Instantiates a new builder with required properties.
     *
     * @param crn the crn
     * @param namespace the namespace
     */
    public Builder(String crn, String namespace) {
      this.crn = crn;
      this.namespace = namespace;
    }

    /**
     * Builds a CreateProfileLinkRequestLink.
     *
     * @return the new CreateProfileLinkRequestLink instance
     */
    public CreateProfileLinkRequestLink build() {
      return new CreateProfileLinkRequestLink(this);
    }

    /**
     * Set the crn.
     *
     * @param crn the crn
     * @return the CreateProfileLinkRequestLink builder
     */
    public Builder crn(String crn) {
      this.crn = crn;
      return this;
    }

    /**
     * Set the namespace.
     *
     * @param namespace the namespace
     * @return the CreateProfileLinkRequestLink builder
     */
    public Builder namespace(String namespace) {
      this.namespace = namespace;
      return this;
    }

    /**
     * Set the name.
     *
     * @param name the name
     * @return the CreateProfileLinkRequestLink builder
     */
    public Builder name(String name) {
      this.name = name;
      return this;
    }
  }

  protected CreateProfileLinkRequestLink(Builder builder) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.crn,
      "crn cannot be null");
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.namespace,
      "namespace cannot be null");
    crn = builder.crn;
    namespace = builder.namespace;
    name = builder.name;
  }

  /**
   * New builder.
   *
   * @return a CreateProfileLinkRequestLink builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the crn.
   *
   * The CRN of the compute resource.
   *
   * @return the crn
   */
  public String crn() {
    return crn;
  }

  /**
   * Gets the namespace.
   *
   * The compute resource namespace, only required if cr_type is IKS_SA or ROKS_SA.
   *
   * @return the namespace
   */
  public String namespace() {
    return namespace;
  }

  /**
   * Gets the name.
   *
   * Name of the compute resource, only required if cr_type is IKS_SA or ROKS_SA.
   *
   * @return the name
   */
  public String name() {
    return name;
  }
}

