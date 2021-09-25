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
    /** ipRange. */
    String IPRANGE = "ipRange";
  }


  /**
   * Builder.
   */
  public static class Builder {
    private String type;
    private String value;

    public Builder(Address addressIpAddressRange) {
      this.type = addressIpAddressRange.type;
      this.value = addressIpAddressRange.value;
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
     * @param value the value
     */
    public Builder(String type, String value) {
      this.type = type;
      this.value = value;
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
     * Set the value.
     *
     * @param value the value
     * @return the AddressIPAddressRange builder
     */
    public Builder value(String value) {
      this.value = value;
      return this;
    }
  }

  protected AddressIPAddressRange(Builder builder) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.type,
      "type cannot be null");
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.value,
      "value cannot be null");
    type = builder.type;
    value = builder.value;
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

