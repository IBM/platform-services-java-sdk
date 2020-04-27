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
package com.ibm.cloud.platform_services.global_catalog.v1.model;

import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * Service Level Agreement related metadata.
 */
public class ObjectMetadataBaseSla extends GenericModel {

  protected String terms;
  protected String tenancy;
  protected String provisioning;
  protected String responsiveness;
  protected ObjectMetadataBaseSlaDr dr;

  /**
   * Builder.
   */
  public static class Builder {
    private String terms;
    private String tenancy;
    private String provisioning;
    private String responsiveness;
    private ObjectMetadataBaseSlaDr dr;

    private Builder(ObjectMetadataBaseSla objectMetadataBaseSla) {
      this.terms = objectMetadataBaseSla.terms;
      this.tenancy = objectMetadataBaseSla.tenancy;
      this.provisioning = objectMetadataBaseSla.provisioning;
      this.responsiveness = objectMetadataBaseSla.responsiveness;
      this.dr = objectMetadataBaseSla.dr;
    }

    /**
     * Instantiates a new builder.
     */
    public Builder() {
    }

    /**
     * Builds a ObjectMetadataBaseSla.
     *
     * @return the new ObjectMetadataBaseSla instance
     */
    public ObjectMetadataBaseSla build() {
      return new ObjectMetadataBaseSla(this);
    }

    /**
     * Set the terms.
     *
     * @param terms the terms
     * @return the ObjectMetadataBaseSla builder
     */
    public Builder terms(String terms) {
      this.terms = terms;
      return this;
    }

    /**
     * Set the tenancy.
     *
     * @param tenancy the tenancy
     * @return the ObjectMetadataBaseSla builder
     */
    public Builder tenancy(String tenancy) {
      this.tenancy = tenancy;
      return this;
    }

    /**
     * Set the provisioning.
     *
     * @param provisioning the provisioning
     * @return the ObjectMetadataBaseSla builder
     */
    public Builder provisioning(String provisioning) {
      this.provisioning = provisioning;
      return this;
    }

    /**
     * Set the responsiveness.
     *
     * @param responsiveness the responsiveness
     * @return the ObjectMetadataBaseSla builder
     */
    public Builder responsiveness(String responsiveness) {
      this.responsiveness = responsiveness;
      return this;
    }

    /**
     * Set the dr.
     *
     * @param dr the dr
     * @return the ObjectMetadataBaseSla builder
     */
    public Builder dr(ObjectMetadataBaseSlaDr dr) {
      this.dr = dr;
      return this;
    }
  }

  protected ObjectMetadataBaseSla(Builder builder) {
    terms = builder.terms;
    tenancy = builder.tenancy;
    provisioning = builder.provisioning;
    responsiveness = builder.responsiveness;
    dr = builder.dr;
  }

  /**
   * New builder.
   *
   * @return a ObjectMetadataBaseSla builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the terms.
   *
   * Required Service License Agreement Terms of Use.
   *
   * @return the terms
   */
  public String terms() {
    return terms;
  }

  /**
   * Gets the tenancy.
   *
   * Required deployment type. Valid values are dedicated, local, or public. It can be Single or Multi tennancy, more
   * specifically on a Server, VM, Physical, or Pod.
   *
   * @return the tenancy
   */
  public String tenancy() {
    return tenancy;
  }

  /**
   * Gets the provisioning.
   *
   * Provisioning reliability, for example, 99.95.
   *
   * @return the provisioning
   */
  public String provisioning() {
    return provisioning;
  }

  /**
   * Gets the responsiveness.
   *
   * Uptime reliability of the service, for example, 99.95.
   *
   * @return the responsiveness
   */
  public String responsiveness() {
    return responsiveness;
  }

  /**
   * Gets the dr.
   *
   * SLA Disaster Recovery-related metadata.
   *
   * @return the dr
   */
  public ObjectMetadataBaseSlaDr dr() {
    return dr;
  }
}

