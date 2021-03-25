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

package com.ibm.cloud.platform_services.posture_management.v1;

import com.ibm.cloud.platform_services.posture_management.v1.model.CreateValidationOptions;
import com.ibm.cloud.platform_services.posture_management.v1.model.ListProfilesOptions;
import com.ibm.cloud.platform_services.posture_management.v1.model.ListScopesOptions;
import com.ibm.cloud.platform_services.posture_management.v1.model.ProfilesList;
import com.ibm.cloud.platform_services.posture_management.v1.model.Result;
import com.ibm.cloud.platform_services.posture_management.v1.model.ScopesList;
import com.ibm.cloud.sdk.core.http.Response;
import com.ibm.cloud.sdk.core.service.exception.ServiceResponseException;
import com.ibm.cloud.sdk.core.util.CredentialUtils;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

//
// This file provides an example of how to use the Posture Management service.
//
// The following configuration properties are assumed to be defined:
// POSTURE_MANAGEMENT_URL=<service base url>
// POSTURE_MANAGEMENT_AUTH_TYPE=iam
// POSTURE_MANAGEMENT_APIKEY=<IAM Api key>
// POSTURE_MANAGEMENT_AUTH_URL=<IAM token service base URL - omit this if using the production environment>
// POSTURE_MANAGEMENT_ACCOUNT_ID=<IBM Cloud Account ID>
// POSTURE_MANAGEMENT_PROFILE_NAME=<Name of the Profile>
// POSTURE_MANAGEMENT_SCOPES_NAME=<Name of the Scope>
//
// These configuration properties can be exported as environment variables, or stored
// in a configuration file and then:
// export IBM_CREDENTIALS_FILE=<name of configuration file>
//
public class PostureManagementExamples {
  private static final Logger logger = LoggerFactory.getLogger(PostureManagementExamples.class);
  protected PostureManagementExamples() { }

  static {
    System.setProperty("IBM_CREDENTIALS_FILE", "../../posture_management.env");
  }

  @SuppressWarnings("checkstyle:methodlength")
  public static void main(String[] args) throws Exception {
    PostureManagement service = PostureManagement.newInstance();

    // Load up our test-specific config properties.
    Map<String, String> config = CredentialUtils.getServiceProperties(PostureManagement.DEFAULT_SERVICE_NAME);

    String accountId = config.get("ACCOUNT_ID");
    String profileName = config.get("PROFILE_NAME");
    String scopesName = config.get("SCOPES_NAME");

    String profileId = null;
    String scopeId = null;
    String groupProfileId = "0";

    try {
      // begin-list_profile
      ListProfilesOptions listProfileOptions = new ListProfilesOptions.Builder()
        .accountId(accountId)
        .name(profileName)
        .build();

      Response<ProfilesList> response = service.listProfiles(listProfileOptions).execute();
      ProfilesList profilesList = response.getResult();

      System.out.printf("listProfiles() result:%n%s%n", profilesList);
      // end-list_profile
      profileId = profilesList.getProfiles().get(0).getProfileId();
    } catch (ServiceResponseException e) {
        logger.error(String.format("Service returned status code %s: %s\nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()), e);
    }

    try {
      // begin-list_scopes
      ListScopesOptions listScopesOptions = new ListScopesOptions.Builder()
        .accountId(accountId)
        .name(scopesName)
        .build();

      Response<ScopesList> response = service.listScopes(listScopesOptions).execute();
      ScopesList scopesList = response.getResult();

      System.out.printf("listScopes() result:%n%s%n", scopesList);
      // end-list_scopes
      scopeId = scopesList.getScopes().get(0).getScopeId();
    } catch (ServiceResponseException e) {
        logger.error(String.format("Service returned status code %s: %s\nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()), e);
    }

    try {
      // begin-create_validation_scan
      CreateValidationOptions createValidationScanOptions = new CreateValidationOptions.Builder()
              .accountId(accountId)
              .profileId(profileId)
              .scopeId(scopeId)
              .groupProfileId(groupProfileId)
              .build();

      Response<Result> response = service.createValidation(createValidationScanOptions).execute();
      Result result = response.getResult();

      System.out.printf("createValidation() result:%n%s%n", result);
      // end-create_validation_scan

    } catch (ServiceResponseException e) {
      logger.error(String.format("Service returned status code %s: %s\nError details: %s",
                                 e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()), e);
    }

  }
}
