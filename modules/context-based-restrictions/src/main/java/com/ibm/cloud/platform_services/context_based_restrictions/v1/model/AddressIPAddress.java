/*
 * (C) Copyright IBM Corp. 2022.
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
 * A single IP address.
 */
public class AddressIPAddress extends Address {

  /**
   * The type of address.
   */
  public interface Type {
    /** ipAddress. */
    String IPADDRESS = "ipAddress";
  }


  /**
   * Builder.
   */
  public static class Builder {
    private String type;
    private String value;

    public Builder(Address addressIpAddress) {
      this.type = addressIpAddress.type;
      this.value = addressIpAddress.value;
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
     * Builds a AddressIPAddress.
     *
     * @return the new AddressIPAddress instance
     */
    public AddressIPAddress build() {
      return new AddressIPAddress(this);
    }

    /**
     * Set the type.
     *
     * @param type the type
     * @return the AddressIPAddress builder
     */
    public Builder type(String type) {
      this.type = type;
      return this;
    }

    /**
     * Set the value.
     *
     * @param value the value
     * @return the AddressIPAddress builder
     */
    public Builder value(String value) {
      this.value = value;
      return this;
    }
  }

  protected AddressIPAddress() { }

  protected AddressIPAddress(Builder builder) {
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
   * @return a AddressIPAddress builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }
}

