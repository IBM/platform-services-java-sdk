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

import com.ibm.cloud.platform_services.posture_management.v1.model.CreateValidationScanOptions;
import com.ibm.cloud.platform_services.posture_management.v1.model.ListProfileOptions;
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
// POSTURE_MANAGEMENT_APIKEY=<IAM apikey>
// POSTURE_MANAGEMENT_AUTH_URL=<IAM token service base URL - omit this if using the production environment>
//
// These configuration properties can be exported as environment variables, or stored
// in a configuration file and then:
// export IBM_CREDENTIALS_FILE=<name of configuration file>
//
public class PostureManagementExamples {
  private static final Logger logger = LoggerFactory.getLogger(PostureManagementExamples.class);
  protected PostureManagementExamples() { }

  @SuppressWarnings("checkstyle:methodlength")
  public static void main(String[] args) throws Exception {
    PostureManagement service = PostureManagement.newInstance();

    // Load up our test-specific config properties.
    Map<String, String> config = CredentialUtils.getServiceProperties(PostureManagement.DEFAULT_SERVICE_NAME);

    try {
      // begin-create_validation_scan
      CreateValidationScanOptions createValidationScanOptions = new CreateValidationScanOptions.Builder()
        .accountId("testString")
        .build();

      Response<Result> response = service.createValidationScan(createValidationScanOptions).execute();
      Result result = response.getResult();

      System.out.println(result);
      // end-create_validation_scan
    } catch (ServiceResponseException e) {
        logger.error(String.format("Service returned status code %s: %s\nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()), e);
    }

    try {
      // begin-list_profile
      ListProfileOptions listProfileOptions = new ListProfileOptions.Builder()
        .accountId("testString")
        .build();

      Response<ProfilesList> response = service.listProfile(listProfileOptions).execute();
      ProfilesList profilesList = response.getResult();

      System.out.println(profilesList);
      // end-list_profile
    } catch (ServiceResponseException e) {
        logger.error(String.format("Service returned status code %s: %s\nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()), e);
    }

    try {
      // begin-list_scopes
      ListScopesOptions listScopesOptions = new ListScopesOptions.Builder()
        .accountId("testString")
        .build();

      Response<ScopesList> response = service.listScopes(listScopesOptions).execute();
      ScopesList scopesList = response.getResult();

      System.out.println(scopesList);
      // end-list_scopes
    } catch (ServiceResponseException e) {
        logger.error(String.format("Service returned status code %s: %s\nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()), e);
    }

  }
}
