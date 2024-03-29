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
package com.ibm.cloud.platform_services.resource_controller.v2.model;

import com.google.gson.annotations.SerializedName;
import com.google.gson.reflect.TypeToken;
import com.ibm.cloud.sdk.core.service.model.DynamicModel;

/**
 * The credentials for a resource.
 */
public class Credentials extends DynamicModel<Object> {

  /**
   * If present, the user doesn't have the correct access to view the credentials and the details are redacted.  The
   * string value identifies the level of access that's required to view the credential. For additional information, see
   * [viewing a
   * credential](https://cloud.ibm.com/docs/account?topic=account-service_credentials&amp;interface=ui#viewing-credentials-ui).
   */
  public interface Redacted {
    /** REDACTED. */
    String REDACTED = "REDACTED";
    /** REDACTED_EXPLICIT. */
    String REDACTED_EXPLICIT = "REDACTED_EXPLICIT";
  }

  @SerializedName("REDACTED")
  protected String redacted;
  @SerializedName("apikey")
  protected String apikey;
  @SerializedName("iam_apikey_description")
  protected String iamApikeyDescription;
  @SerializedName("iam_apikey_name")
  protected String iamApikeyName;
  @SerializedName("iam_role_crn")
  protected String iamRoleCrn;
  @SerializedName("iam_serviceid_crn")
  protected String iamServiceidCrn;

  public Credentials() {
    super(new TypeToken<Object>() { });
  }

  /**
   * Gets the redacted.
   *
   * If present, the user doesn't have the correct access to view the credentials and the details are redacted.  The
   * string value identifies the level of access that's required to view the credential. For additional information, see
   * [viewing a
   * credential](https://cloud.ibm.com/docs/account?topic=account-service_credentials&amp;interface=ui#viewing-credentials-ui).
   *
   * @return the redacted
   */
  public String getRedacted() {
    return this.redacted;
  }

  /**
   * Gets the apikey.
   *
   * The API key for the credentials.
   *
   * @return the apikey
   */
  public String getApikey() {
    return this.apikey;
  }

  /**
   * Gets the iamApikeyDescription.
   *
   * The optional description of the API key.
   *
   * @return the iamApikeyDescription
   */
  public String getIamApikeyDescription() {
    return this.iamApikeyDescription;
  }

  /**
   * Gets the iamApikeyName.
   *
   * The name of the API key.
   *
   * @return the iamApikeyName
   */
  public String getIamApikeyName() {
    return this.iamApikeyName;
  }

  /**
   * Gets the iamRoleCrn.
   *
   * The Cloud Resource Name for the role of the credentials.
   *
   * @return the iamRoleCrn
   */
  public String getIamRoleCrn() {
    return this.iamRoleCrn;
  }

  /**
   * Gets the iamServiceidCrn.
   *
   * The Cloud Resource Name for the service ID of the credentials.
   *
   * @return the iamServiceidCrn
   */
  public String getIamServiceidCrn() {
    return this.iamServiceidCrn;
  }
}
