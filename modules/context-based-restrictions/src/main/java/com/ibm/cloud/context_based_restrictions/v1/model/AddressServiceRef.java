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
 * A service reference.
 */
public class AddressServiceRef extends Address {

  /**
   * The type of address.
   */
  public interface Type {
    /** serviceRef. */
    String SERVICEREF = "serviceRef";
  }


  /**
   * Builder.
   */
  public static class Builder {
    private String type;
    private ServiceRefValue value;

    public Builder(Address addressServiceRef) {
      this.type = addressServiceRef.type;
      this.value = addressServiceRef.value;
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
    public Builder(String type, ServiceRefValue value) {
      this.type = type;
      this.value = value;
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
     * Set the value.
     *
     * @param value the value
     * @return the AddressServiceRef builder
     */
    public Builder value(ServiceRefValue value) {
      this.value = value;
      return this;
    }
  }

  protected AddressServiceRef(Builder builder) {
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
   * @return a AddressServiceRef builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }
}

