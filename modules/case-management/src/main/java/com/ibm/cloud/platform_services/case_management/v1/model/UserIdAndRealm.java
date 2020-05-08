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

import com.google.gson.annotations.SerializedName;
import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * UserIdAndRealm.
 */
public class UserIdAndRealm extends GenericModel {

  /**
   * the ID realm.
   */
  public interface Realm {
    /** IBMid. */
    String IBMID = "IBMid";
    /** SL. */
    String SL = "SL";
    /** BSS. */
    String BSS = "BSS";
  }

  protected String realm;
  @SerializedName("user_id")
  protected String userId;

  /**
   * Builder.
   */
  public static class Builder {
    private String realm;
    private String userId;

    private Builder(UserIdAndRealm userIdAndRealm) {
      this.realm = userIdAndRealm.realm;
      this.userId = userIdAndRealm.userId;
    }

    /**
     * Instantiates a new builder.
     */
    public Builder() {
    }

    /**
     * Instantiates a new builder with required properties.
     *
     * @param realm the realm
     * @param userId the userId
     */
    public Builder(String realm, String userId) {
      this.realm = realm;
      this.userId = userId;
    }

    /**
     * Builds a UserIdAndRealm.
     *
     * @return the new UserIdAndRealm instance
     */
    public UserIdAndRealm build() {
      return new UserIdAndRealm(this);
    }

    /**
     * Set the realm.
     *
     * @param realm the realm
     * @return the UserIdAndRealm builder
     */
    public Builder realm(String realm) {
      this.realm = realm;
      return this;
    }

    /**
     * Set the userId.
     *
     * @param userId the userId
     * @return the UserIdAndRealm builder
     */
    public Builder userId(String userId) {
      this.userId = userId;
      return this;
    }
  }

  protected UserIdAndRealm(Builder builder) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.realm,
      "realm cannot be null");
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.userId,
      "userId cannot be null");
    realm = builder.realm;
    userId = builder.userId;
  }

  /**
   * New builder.
   *
   * @return a UserIdAndRealm builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the realm.
   *
   * the ID realm.
   *
   * @return the realm
   */
  public String realm() {
    return realm;
  }

  /**
   * Gets the userId.
   *
   * unique user ID in the realm specified by the type.
   *
   * @return the userId
   */
  public String userId() {
    return userId;
  }
}

