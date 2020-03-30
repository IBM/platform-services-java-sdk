/*
 * (C) Copyright IBM Corp. 2020.
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
package com.ibm.cloud.platform_services.global_tagging.v1.model;

import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * The deleteTagAll options.
 */
public class DeleteTagAllOptions extends GenericModel {

  /**
   * Select a provider. Supported values are `ghost` and `ims`.
   */
  public interface Providers {
    /** ghost. */
    String GHOST = "ghost";
    /** ims. */
    String IMS = "ims";
  }

  protected String providers;

  /**
   * Builder.
   */
  public static class Builder {
    private String providers;

    private Builder(DeleteTagAllOptions deleteTagAllOptions) {
      this.providers = deleteTagAllOptions.providers;
    }

    /**
     * Instantiates a new builder.
     */
    public Builder() {
    }

    /**
     * Builds a DeleteTagAllOptions.
     *
     * @return the new DeleteTagAllOptions instance
     */
    public DeleteTagAllOptions build() {
      return new DeleteTagAllOptions(this);
    }

    /**
     * Set the providers.
     *
     * @param providers the providers
     * @return the DeleteTagAllOptions builder
     */
    public Builder providers(String providers) {
      this.providers = providers;
      return this;
    }
  }

  protected DeleteTagAllOptions(Builder builder) {
    providers = builder.providers;
  }

  /**
   * New builder.
   *
   * @return a DeleteTagAllOptions builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the providers.
   *
   * Select a provider. Supported values are `ghost` and `ims`.
   *
   * @return the providers
   */
  public String providers() {
    return providers;
  }
}

