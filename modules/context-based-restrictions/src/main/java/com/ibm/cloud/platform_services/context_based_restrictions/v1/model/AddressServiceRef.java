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
    /** serviceRef. */
    String SERVICEREF = "serviceRef";
  }


  /**
   * Builder.
   */
  public static class Builder {
    private String type;
    private ServiceRefValue ref;

    public Builder(Address addressServiceRef) {
      this.type = addressServiceRef.type;
      this.ref = addressServiceRef.ref;
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
     * @param ref the ref
     */
    public Builder(String type, ServiceRefValue ref) {
      this.type = type;
      this.ref = ref;
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
     * Set the ref.
     *
     * @param ref the ref
     * @return the AddressServiceRef builder
     */
    public Builder ref(ServiceRefValue ref) {
      this.ref = ref;
      return this;
    }
  }

  protected AddressServiceRef(Builder builder) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.type,
      "type cannot be null");
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.ref,
      "ref cannot be null");
    type = builder.type;
    ref = builder.ref;
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

