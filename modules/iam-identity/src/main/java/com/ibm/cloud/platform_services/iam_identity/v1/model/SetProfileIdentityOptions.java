/*
 * (C) Copyright IBM Corp. 2023.
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
 * The setProfileIdentity options.
 */
public class SetProfileIdentityOptions extends GenericModel {

  /**
   * Type of the identity.
   */
  public interface IdentityType {
    /** user. */
    String USER = "user";
    /** serviceid. */
    String SERVICEID = "serviceid";
    /** crn. */
    String CRN = "crn";
  }

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

  protected String profileId;
  protected String identityType;
  protected String identifier;
  protected String type;
  protected List<String> accounts;
  protected String description;

  /**
   * Builder.
   */
  public static class Builder {
    private String profileId;
    private String identityType;
    private String identifier;
    private String type;
    private List<String> accounts;
    private String description;

    /**
     * Instantiates a new Builder from an existing SetProfileIdentityOptions instance.
     *
     * @param setProfileIdentityOptions the instance to initialize the Builder with
     */
    private Builder(SetProfileIdentityOptions setProfileIdentityOptions) {
      this.profileId = setProfileIdentityOptions.profileId;
      this.identityType = setProfileIdentityOptions.identityType;
      this.identifier = setProfileIdentityOptions.identifier;
      this.type = setProfileIdentityOptions.type;
      this.accounts = setProfileIdentityOptions.accounts;
      this.description = setProfileIdentityOptions.description;
    }

    /**
     * Instantiates a new builder.
     */
    public Builder() {
    }

    /**
     * Instantiates a new builder with required properties.
     *
     * @param profileId the profileId
     * @param identityType the identityType
     * @param identifier the identifier
     * @param type the type
     */
    public Builder(String profileId, String identityType, String identifier, String type) {
      this.profileId = profileId;
      this.identityType = identityType;
      this.identifier = identifier;
      this.type = type;
    }

    /**
     * Builds a SetProfileIdentityOptions.
     *
     * @return the new SetProfileIdentityOptions instance
     */
    public SetProfileIdentityOptions build() {
      return new SetProfileIdentityOptions(this);
    }

    /**
     * Adds an accounts to accounts.
     *
     * @param accounts the new accounts
     * @return the SetProfileIdentityOptions builder
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
     * Set the profileId.
     *
     * @param profileId the profileId
     * @return the SetProfileIdentityOptions builder
     */
    public Builder profileId(String profileId) {
      this.profileId = profileId;
      return this;
    }

    /**
     * Set the identityType.
     *
     * @param identityType the identityType
     * @return the SetProfileIdentityOptions builder
     */
    public Builder identityType(String identityType) {
      this.identityType = identityType;
      return this;
    }

    /**
     * Set the identifier.
     *
     * @param identifier the identifier
     * @return the SetProfileIdentityOptions builder
     */
    public Builder identifier(String identifier) {
      this.identifier = identifier;
      return this;
    }

    /**
     * Set the type.
     *
     * @param type the type
     * @return the SetProfileIdentityOptions builder
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
     * @return the SetProfileIdentityOptions builder
     */
    public Builder accounts(List<String> accounts) {
      this.accounts = accounts;
      return this;
    }

    /**
     * Set the description.
     *
     * @param description the description
     * @return the SetProfileIdentityOptions builder
     */
    public Builder description(String description) {
      this.description = description;
      return this;
    }
  }

  protected SetProfileIdentityOptions() { }

  protected SetProfileIdentityOptions(Builder builder) {
    com.ibm.cloud.sdk.core.util.Validator.notEmpty(builder.profileId,
      "profileId cannot be empty");
    com.ibm.cloud.sdk.core.util.Validator.notEmpty(builder.identityType,
      "identityType cannot be empty");
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.identifier,
      "identifier cannot be null");
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.type,
      "type cannot be null");
    profileId = builder.profileId;
    identityType = builder.identityType;
    identifier = builder.identifier;
    type = builder.type;
    accounts = builder.accounts;
    description = builder.description;
  }

  /**
   * New builder.
   *
   * @return a SetProfileIdentityOptions builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the profileId.
   *
   * ID of the trusted profile.
   *
   * @return the profileId
   */
  public String profileId() {
    return profileId;
  }

  /**
   * Gets the identityType.
   *
   * Type of the identity.
   *
   * @return the identityType
   */
  public String identityType() {
    return identityType;
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

