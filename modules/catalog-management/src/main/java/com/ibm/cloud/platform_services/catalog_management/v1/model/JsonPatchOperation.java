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
 * This model represents an individual patch operation to be performed on a JSON document, as defined by RFC 6902.
 */
public class JsonPatchOperation extends GenericModel {

  /**
   * The operation to be performed.
   */
  public interface Op {
    /** add. */
    String ADD = "add";
    /** remove. */
    String REMOVE = "remove";
    /** replace. */
    String REPLACE = "replace";
    /** move. */
    String MOVE = "move";
    /** copy. */
    String COPY = "copy";
    /** test. */
    String TEST = "test";
  }

  protected String op;
  protected String path;
  protected String from;
  protected Object value;

  /**
   * Builder.
   */
  public static class Builder {
    private String op;
    private String path;
    private String from;
    private Object value;

    private Builder(JsonPatchOperation jsonPatchOperation) {
      this.op = jsonPatchOperation.op;
      this.path = jsonPatchOperation.path;
      this.from = jsonPatchOperation.from;
      this.value = jsonPatchOperation.value;
    }

    /**
     * Instantiates a new builder.
     */
    public Builder() {
    }

    /**
     * Instantiates a new builder with required properties.
     *
     * @param op the op
     * @param path the path
     */
    public Builder(String op, String path) {
      this.op = op;
      this.path = path;
    }

    /**
     * Builds a JsonPatchOperation.
     *
     * @return the new JsonPatchOperation instance
     */
    public JsonPatchOperation build() {
      return new JsonPatchOperation(this);
    }

    /**
     * Set the op.
     *
     * @param op the op
     * @return the JsonPatchOperation builder
     */
    public Builder op(String op) {
      this.op = op;
      return this;
    }

    /**
     * Set the path.
     *
     * @param path the path
     * @return the JsonPatchOperation builder
     */
    public Builder path(String path) {
      this.path = path;
      return this;
    }

    /**
     * Set the from.
     *
     * @param from the from
     * @return the JsonPatchOperation builder
     */
    public Builder from(String from) {
      this.from = from;
      return this;
    }

    /**
     * Set the value.
     *
     * @param value the value
     * @return the JsonPatchOperation builder
     */
    public Builder value(Object value) {
      this.value = value;
      return this;
    }
  }

  protected JsonPatchOperation(Builder builder) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.op,
      "op cannot be null");
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.path,
      "path cannot be null");
    op = builder.op;
    path = builder.path;
    from = builder.from;
    value = builder.value;
  }

  /**
   * New builder.
   *
   * @return a JsonPatchOperation builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the op.
   *
   * The operation to be performed.
   *
   * @return the op
   */
  public String op() {
    return op;
  }

  /**
   * Gets the path.
   *
   * The JSON Pointer that identifies the field that is the target of the operation.
   *
   * @return the path
   */
  public String path() {
    return path;
  }

  /**
   * Gets the from.
   *
   * The JSON Pointer that identifies the field that is the source of the operation.
   *
   * @return the from
   */
  public String from() {
    return from;
  }

  /**
   * Gets the value.
   *
   * The value to be used within the operation.
   *
   * @return the value
   */
  public Object value() {
    return value;
  }
}

