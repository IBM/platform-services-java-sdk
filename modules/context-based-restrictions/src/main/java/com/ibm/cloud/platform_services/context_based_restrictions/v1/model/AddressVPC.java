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
 * A single VPC address.
 */
public class AddressVPC extends Address {

  /**
   * The type of address.
   */
  public interface Type {
    /** vpc. */
    String VPC = "vpc";
  }


  /**
   * Builder.
   */
  public static class Builder {
    private String type;
    private String value;

    public Builder(Address addressVpc) {
      this.type = addressVpc.type;
      this.value = addressVpc.value;
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
     * Builds a AddressVPC.
     *
     * @return the new AddressVPC instance
     */
    public AddressVPC build() {
      return new AddressVPC(this);
    }

    /**
     * Set the type.
     *
     * @param type the type
     * @return the AddressVPC builder
     */
    public Builder type(String type) {
      this.type = type;
      return this;
    }

    /**
     * Set the value.
     *
     * @param value the value
     * @return the AddressVPC builder
     */
    public Builder value(String value) {
      this.value = value;
      return this;
    }
  }

  protected AddressVPC() { }

  protected AddressVPC(Builder builder) {
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
   * @return a AddressVPC builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }
}

