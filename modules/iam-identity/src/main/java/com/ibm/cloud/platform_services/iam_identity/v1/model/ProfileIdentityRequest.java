/*
 * (C) Copyright IBM Corp. 2025.
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

package com.ibm.cloud.platform_services.iam_identity.v1.model;

import java.util.ArrayList;
import java.util.List;

import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * ProfileIdentityRequest.
 */
public class ProfileIdentityRequest extends GenericModel {

  /**
   * Type of the identity.
   */
  public interface Type {
    /** user. */
    String USER = "user";
    /** serviceid. */
    String SERVICEID = "serviceid";
    /** crn. */
    String CRN = "crn";
  }

  protected String identifier;
  protected String type;
  protected List<String> accounts;
  protected String description;

  /**
   * Builder.
   */
  public static class Builder {
    private String identifier;
    private String type;
    private List<String> accounts;
    private String description;

    /**
     * Instantiates a new Builder from an existing ProfileIdentityRequest instance.
     *
     * @param profileIdentityRequest the instance to initialize the Builder with
     */
    private Builder(ProfileIdentityRequest profileIdentityRequest) {
      this.identifier = profileIdentityRequest.identifier;
      this.type = profileIdentityRequest.type;
      this.accounts = profileIdentityRequest.accounts;
      this.description = profileIdentityRequest.description;
    }

    /**
     * Instantiates a new builder.
     */
    public Builder() {
    }

    /**
     * Instantiates a new builder with required properties.
     *
     * @param identifier the identifier
     * @param type the type
     */
    public Builder(String identifier, String type) {
      this.identifier = identifier;
      this.type = type;
    }

    /**
     * Builds a ProfileIdentityRequest.
     *
     * @return the new ProfileIdentityRequest instance
     */
    public ProfileIdentityRequest build() {
      return new ProfileIdentityRequest(this);
    }

    /**
     * Adds a new element to accounts.
     *
     * @param accounts the new element to be added
     * @return the ProfileIdentityRequest builder
     */
    public Builder addAccounts(String accounts) {
      com.ibm.cloud.sdk.core.util.Validator.notNull(accounts,
        "accounts cannot be null");
      if (this.accounts == null) {
        this.accounts = new ArrayList<String>();
      }
      this.accounts.add(accounts);
      return this;
    }

    /**
     * Set the identifier.
     *
     * @param identifier the identifier
     * @return the ProfileIdentityRequest builder
     */
    public Builder identifier(String identifier) {
      this.identifier = identifier;
      return this;
    }

    /**
     * Set the type.
     *
     * @param type the type
     * @return the ProfileIdentityRequest builder
     */
    public Builder type(String type) {
      this.type = type;
      return this;
    }

    /**
     * Set the accounts.
     * Existing accounts will be replaced.
     *
     * @param accounts the accounts
     * @return the ProfileIdentityRequest builder
     */
    public Builder accounts(List<String> accounts) {
      this.accounts = accounts;
      return this;
    }

    /**
     * Set the description.
     *
     * @param description the description
     * @return the ProfileIdentityRequest builder
     */
    public Builder description(String description) {
      this.description = description;
      return this;
    }
  }

  protected ProfileIdentityRequest() { }

  protected ProfileIdentityRequest(Builder builder) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.identifier,
      "identifier cannot be null");
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.type,
      "type cannot be null");
    identifier = builder.identifier;
    type = builder.type;
    accounts = builder.accounts;
    description = builder.description;
  }

  /**
   * New builder.
   *
   * @return a ProfileIdentityRequest builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the identifier.
   *
   * Identifier of the identity that can assume the trusted profiles. This can be a user identifier (IAM id), serviceid
   * or crn. Internally it uses account id of the service id for the identifier 'serviceid' and for the identifier 'crn'
   * it uses account id contained in the CRN.
   *
   * @return the identifier
   */
  public String identifier() {
    return identifier;
  }

  /**
   * Gets the type.
   *
   * Type of the identity.
   *
   * @return the type
   */
  public String type() {
    return type;
  }

  /**
   * Gets the accounts.
   *
   * Only valid for the type user. Accounts from which a user can assume the trusted profile.
   *
   * @return the accounts
   */
  public List<String> accounts() {
    return accounts;
  }

  /**
   * Gets the description.
   *
   * Description of the identity that can assume the trusted profile. This is optional field for all the types of
   * identities. When this field is not set for the identity type 'serviceid' then the description of the service id is
   * used. Description is recommended for the identity type 'crn' E.g. 'Instance 1234 of IBM Cloud Service project'.
   *
   * @return the description
   */
  public String description() {
    return description;
  }
}

