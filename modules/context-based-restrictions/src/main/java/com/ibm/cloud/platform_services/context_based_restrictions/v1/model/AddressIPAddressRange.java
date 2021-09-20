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
 * An IP address range.
 */
public class AddressIPAddressRange extends Address {

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
    private String ipRange;

    public Builder(Address addressIpAddressRange) {
      this.type = addressIpAddressRange.type;
      this.ipRange = addressIpAddressRange.ipRange;
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
     * @param ipRange the ipRange
     */
    public Builder(String type, String ipRange) {
      this.type = type;
      this.ipRange = ipRange;
    }

    /**
     * Builds a AddressIPAddressRange.
     *
     * @return the new AddressIPAddressRange instance
     */
    public AddressIPAddressRange build() {
      return new AddressIPAddressRange(this);
    }

    /**
     * Set the type.
     *
     * @param type the type
     * @return the AddressIPAddressRange builder
     */
    public Builder type(String type) {
      this.type = type;
      return this;
    }

    /**
     * Set the ipRange.
     *
     * @param ipRange the ipRange
     * @return the AddressIPAddressRange builder
     */
    public Builder ipRange(String ipRange) {
      this.ipRange = ipRange;
      return this;
    }
  }

  protected AddressIPAddressRange(Builder builder) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.type,
      "type cannot be null");
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.ipRange,
      "ipRange cannot be null");
    type = builder.type;
    ipRange = builder.ipRange;
  }

  /**
   * New builder.
   *
   * @return a AddressIPAddressRange builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }
}

