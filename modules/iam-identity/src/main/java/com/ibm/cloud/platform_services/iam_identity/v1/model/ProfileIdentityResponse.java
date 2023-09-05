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

import java.util.List;

import com.google.gson.annotations.SerializedName;
import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * ProfileIdentityResponse.
 */
public class ProfileIdentityResponse extends GenericModel {

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

  @SerializedName("iam_id")
  protected String iamId;
  protected String identifier;
  protected String type;
  protected List<String> accounts;
  protected String description;

  protected ProfileIdentityResponse() { }

  /**
   * Gets the iamId.
   *
   * IAM ID of the identity.
   *
   * @return the iamId
   */
  public String getIamId() {
    return iamId;
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
  public String getIdentifier() {
    return identifier;
  }

  /**
   * Gets the type.
   *
   * Type of the identity.
   *
   * @return the type
   */
  public String getType() {
    return type;
  }

  /**
   * Gets the accounts.
   *
   * Only valid for the type user. Accounts from which a user can assume the trusted profile.
   *
   * @return the accounts
   */
  public List<String> getAccounts() {
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
  public String getDescription() {
    return description;
  }
}

