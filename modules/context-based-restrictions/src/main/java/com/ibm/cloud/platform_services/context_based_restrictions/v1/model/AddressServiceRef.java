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
package com.ibm.cloud.platform_services.context_based_restrictions.v1.model;

/**
 * A service reference.
 */
public class AddressServiceRef extends Address {

  /**
   * The type of address.
   */
  public interface Type {
    /** ipAddress. */
    String IPADDRESS = "ipAddress";
    /** ipRange. */
    String IPRANGE = "ipRange";
    /** subnet. */
    String SUBNET = "subnet";
    /** vpc. */
    String VPC = "vpc";
    /** serviceRef. */
    String SERVICEREF = "serviceRef";
  }


  /**
   * Builder.
   */
  public static class Builder {
    private String type;
    private ServiceRefValue serviceRef;

    public Builder(Address addressServiceRef) {
      this.type = addressServiceRef.type;
      this.serviceRef = addressServiceRef.serviceRef;
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
     * @param serviceRef the serviceRef
     */
    public Builder(String type, ServiceRefValue serviceRef) {
      this.type = type;
      this.serviceRef = serviceRef;
    }

    /**
     * Builds a AddressServiceRef.
     *
     * @return the new AddressServiceRef instance
     */
    public AddressServiceRef build() {
      return new AddressServiceRef(this);
    }

    /**
     * Set the type.
     *
     * @param type the type
     * @return the AddressServiceRef builder
     */
    public Builder type(String type) {
      this.type = type;
      return this;
    }

    /**
     * Set the serviceRef.
     *
     * @param serviceRef the serviceRef
     * @return the AddressServiceRef builder
     */
    public Builder serviceRef(ServiceRefValue serviceRef) {
      this.serviceRef = serviceRef;
      return this;
    }
  }

  protected AddressServiceRef(Builder builder) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.type,
      "type cannot be null");
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.serviceRef,
      "serviceRef cannot be null");
    type = builder.type;
    serviceRef = builder.serviceRef;
  }

  /**
   * New builder.
   *
   * @return a AddressServiceRef builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }
}

