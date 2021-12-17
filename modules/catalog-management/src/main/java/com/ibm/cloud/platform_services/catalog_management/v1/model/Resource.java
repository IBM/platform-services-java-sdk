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
package com.ibm.cloud.platform_services.catalog_management.v1.model;

import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * Resource requirements.
 */
public class Resource extends GenericModel {

  /**
   * Type of requirement.
   */
  public interface Type {
    /** mem. */
    String MEM = "mem";
    /** disk. */
    String DISK = "disk";
    /** cores. */
    String CORES = "cores";
    /** targetVersion. */
    String TARGETVERSION = "targetVersion";
    /** nodes. */
    String NODES = "nodes";
  }

  protected String type;
  protected Object value;

  /**
   * Builder.
   */
  public static class Builder {
    private String type;
    private Object value;

    private Builder(Resource resource) {
      this.type = resource.type;
      this.value = resource.value;
    }

    /**
     * Instantiates a new builder.
     */
    public Builder() {
    }

    /**
     * Builds a Resource.
     *
     * @return the new Resource instance
     */
    public Resource build() {
      return new Resource(this);
    }

    /**
     * Set the type.
     *
     * @param type the type
     * @return the Resource builder
     */
    public Builder type(String type) {
      this.type = type;
      return this;
    }

    /**
     * Set the value.
     *
     * @param value the value
     * @return the Resource builder
     */
    public Builder value(Object value) {
      this.value = value;
      return this;
    }
  }

  protected Resource(Builder builder) {
    type = builder.type;
    value = builder.value;
  }

  /**
   * New builder.
   *
   * @return a Resource builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the type.
   *
   * Type of requirement.
   *
   * @return the type
   */
  public String type() {
    return type;
  }

  /**
   * Gets the value.
   *
   * mem, disk, cores, and nodes can be parsed as an int.  targetVersion will be a semver range value.
   *
   * @return the value
   */
  public Object value() {
    return value;
  }
}

