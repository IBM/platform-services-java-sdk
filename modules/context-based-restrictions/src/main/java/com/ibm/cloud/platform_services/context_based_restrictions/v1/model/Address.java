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

import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * A zone address.
 *
 * Classes which extend this class:
 * - AddressIPAddress
 * - AddressIPAddressRange
 * - AddressSubnet
 * - AddressVPC
 * - AddressServiceRef
 */
public class Address extends GenericModel {
  @SuppressWarnings("unused")
  protected static String discriminatorPropertyName = "type";
  protected static java.util.Map<String, Class<?>> discriminatorMapping;
  static {
    discriminatorMapping = new java.util.HashMap<>();
    discriminatorMapping.put("ipAddress", AddressIPAddress.class);
    discriminatorMapping.put("ipRange", AddressIPAddressRange.class);
    discriminatorMapping.put("subnet", AddressSubnet.class);
    discriminatorMapping.put("vpc", AddressVPC.class);
    discriminatorMapping.put("serviceRef", AddressServiceRef.class);
  }

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

  protected String type;
  protected String value;
  protected ServiceRefValue ref;

  protected Address() {
  }

  /**
   * Gets the type.
   *
   * The type of address.
   *
   * @return the type
   */
  public String type() {
    return type;
  }

  /**
   * Gets the value.
   *
   * The IP address.
   *
   * @return the value
   */
  public String value() {
    return value;
  }

  /**
   * Gets the ref.
   *
   * A service reference value.
   *
   * @return the ref
   */
  public ServiceRefValue ref() {
    return ref;
  }
}

