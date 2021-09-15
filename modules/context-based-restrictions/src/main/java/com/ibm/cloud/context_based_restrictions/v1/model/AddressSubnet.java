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
package com.ibm.cloud.context_based_restrictions.v1.model;

/**
 * A subnet in CIDR format.
 */
public class AddressSubnet extends Address {

  /**
   * The type of address.
   */
  public interface Type {
    /** subnet. */
    String SUBNET = "subnet";
  }


  /**
   * Builder.
   */
  public static class Builder {
    private String type;
    private String value;

    public Builder(Address addressSubnet) {
      this.type = addressSubnet.type;
      this.value = addressSubnet.value;
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
     * Builds a AddressSubnet.
     *
     * @return the new AddressSubnet instance
     */
    public AddressSubnet build() {
      return new AddressSubnet(this);
    }

    /**
     * Set the type.
     *
     * @param type the type
     * @return the AddressSubnet builder
     */
    public Builder type(String type) {
      this.type = type;
      return this;
    }

    /**
     * Set the value.
     *
     * @param value the value
     * @return the AddressSubnet builder
     */
    public Builder value(String value) {
      this.value = value;
      return this;
    }
  }

  protected AddressSubnet(Builder builder) {
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
   * @return a AddressSubnet builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }
}

