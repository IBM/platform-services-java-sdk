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
package com.ibm.cloud.platform_services.case_management.v1.model;

import java.util.ArrayList;
import java.util.List;

import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * Payload to add/remove users to/from the case watchlist.
 */
public class Watchlist extends GenericModel {

  protected List<User> watchlist;

  /**
   * Builder.
   */
  public static class Builder {
    private List<User> watchlist;

    /**
     * Instantiates a new Builder from an existing Watchlist instance.
     *
     * @param watchlist the instance to initialize the Builder with
     */
    private Builder(Watchlist watchlist) {
      this.watchlist = watchlist.watchlist;
    }

    /**
     * Instantiates a new builder.
     */
    public Builder() {
    }

    /**
     * Builds a Watchlist.
     *
     * @return the new Watchlist instance
     */
    public Watchlist build() {
      return new Watchlist(this);
    }

    /**
     * Adds an watchlist to watchlist.
     *
     * @param watchlist the new watchlist
     * @return the Watchlist builder
     */
    public Builder addWatchlist(User watchlist) {
      com.ibm.cloud.sdk.core.util.Validator.notNull(watchlist,
        "watchlist cannot be null");
      if (this.watchlist == null) {
        this.watchlist = new ArrayList<User>();
      }
      this.watchlist.add(watchlist);
      return this;
    }

    /**
     * Set the watchlist.
     * Existing watchlist will be replaced.
     *
     * @param watchlist the watchlist
     * @return the Watchlist builder
     */
    public Builder watchlist(List<User> watchlist) {
      this.watchlist = watchlist;
      return this;
    }
  }

  protected Watchlist() { }

  protected Watchlist(Builder builder) {
    watchlist = builder.watchlist;
  }

  /**
   * New builder.
   *
   * @return a Watchlist builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the watchlist.
   *
   * Array of user ID objects.
   *
   * @return the watchlist
   */
  public List<User> watchlist() {
    return watchlist;
  }
}

