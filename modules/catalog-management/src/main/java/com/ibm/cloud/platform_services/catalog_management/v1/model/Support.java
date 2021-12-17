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

import java.util.ArrayList;
import java.util.List;

import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * Offering Support information.
 */
public class Support extends GenericModel {

  protected String url;
  protected String process;
  protected List<String> locations;

  /**
   * Builder.
   */
  public static class Builder {
    private String url;
    private String process;
    private List<String> locations;

    private Builder(Support support) {
      this.url = support.url;
      this.process = support.process;
      this.locations = support.locations;
    }

    /**
     * Instantiates a new builder.
     */
    public Builder() {
    }

    /**
     * Builds a Support.
     *
     * @return the new Support instance
     */
    public Support build() {
      return new Support(this);
    }

    /**
     * Adds an locations to locations.
     *
     * @param locations the new locations
     * @return the Support builder
     */
    public Builder addLocations(String locations) {
      com.ibm.cloud.sdk.core.util.Validator.notNull(locations,
        "locations cannot be null");
      if (this.locations == null) {
        this.locations = new ArrayList<String>();
      }
      this.locations.add(locations);
      return this;
    }

    /**
     * Set the url.
     *
     * @param url the url
     * @return the Support builder
     */
    public Builder url(String url) {
      this.url = url;
      return this;
    }

    /**
     * Set the process.
     *
     * @param process the process
     * @return the Support builder
     */
    public Builder process(String process) {
      this.process = process;
      return this;
    }

    /**
     * Set the locations.
     * Existing locations will be replaced.
     *
     * @param locations the locations
     * @return the Support builder
     */
    public Builder locations(List<String> locations) {
      this.locations = locations;
      return this;
    }
  }

  protected Support(Builder builder) {
    url = builder.url;
    process = builder.process;
    locations = builder.locations;
  }

  /**
   * New builder.
   *
   * @return a Support builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the url.
   *
   * URL to be displayed in the Consumption UI for getting support on this offering.
   *
   * @return the url
   */
  public String url() {
    return url;
  }

  /**
   * Gets the process.
   *
   * Support process as provided by an ISV.
   *
   * @return the process
   */
  public String process() {
    return process;
  }

  /**
   * Gets the locations.
   *
   * A list of country codes indicating where support is provided.
   *
   * @return the locations
   */
  public List<String> locations() {
    return locations;
  }
}

