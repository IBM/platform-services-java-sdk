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
package com.ibm.cloud.platform_services.case_management.v1.model;

import java.util.ArrayList;
import java.util.List;

import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * The removeWatchlist options.
 */
public class RemoveWatchlistOptions extends GenericModel {

  protected String caseNumber;
  protected List<User> watchlist;

  /**
   * Builder.
   */
  public static class Builder {
    private String caseNumber;
    private List<User> watchlist;

    private Builder(RemoveWatchlistOptions removeWatchlistOptions) {
      this.caseNumber = removeWatchlistOptions.caseNumber;
      this.watchlist = removeWatchlistOptions.watchlist;
    }

    /**
     * Instantiates a new builder.
     */
    public Builder() {
    }

    /**
     * Instantiates a new builder with required properties.
     *
     * @param caseNumber the caseNumber
     */
    public Builder(String caseNumber) {
      this.caseNumber = caseNumber;
    }

    /**
     * Builds a RemoveWatchlistOptions.
     *
     * @return the new RemoveWatchlistOptions instance
     */
    public RemoveWatchlistOptions build() {
      return new RemoveWatchlistOptions(this);
    }

    /**
     * Adds an watchlist to watchlist.
     *
     * @param watchlist the new watchlist
     * @return the RemoveWatchlistOptions builder
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
     * Set the caseNumber.
     *
     * @param caseNumber the caseNumber
     * @return the RemoveWatchlistOptions builder
     */
    public Builder caseNumber(String caseNumber) {
      this.caseNumber = caseNumber;
      return this;
    }

    /**
     * Set the watchlist.
     * Existing watchlist will be replaced.
     *
     * @param watchlist the watchlist
     * @return the RemoveWatchlistOptions builder
     */
    public Builder watchlist(List<User> watchlist) {
      this.watchlist = watchlist;
      return this;
    }

    /**
     * Set the watchlist.
     *
     * @param watchlist the watchlist
     * @return the RemoveWatchlistOptions builder
     */
    public Builder watchlist(Watchlist watchlist) {
      this.watchlist = watchlist.watchlist();
      return this;
    }
  }

  protected RemoveWatchlistOptions(Builder builder) {
    com.ibm.cloud.sdk.core.util.Validator.notEmpty(builder.caseNumber,
      "caseNumber cannot be empty");
    caseNumber = builder.caseNumber;
    watchlist = builder.watchlist;
  }

  /**
   * New builder.
   *
   * @return a RemoveWatchlistOptions builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the caseNumber.
   *
   * Unique identifier of a case.
   *
   * @return the caseNumber
   */
  public String caseNumber() {
    return caseNumber;
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

