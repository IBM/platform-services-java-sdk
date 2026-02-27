/*
 * (C) Copyright IBM Corp. 2026.
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

package com.ibm.cloud.platform_services.account_management.v4;

import com.ibm.cloud.platform_services.account_management.v4.model.AccountResponse;
import com.ibm.cloud.platform_services.account_management.v4.model.GetAccountOptions;
import com.ibm.cloud.sdk.core.http.Response;
import com.ibm.cloud.sdk.core.service.exception.ServiceResponseException;
import com.ibm.cloud.sdk.core.util.CredentialUtils;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * This class contains examples of how to use the account_management service.
 *
 * The following configuration properties are assumed to be defined:
 * ACCOUNT_MANAGEMENT_URL=&lt;service base url&gt;
 * ACCOUNT_MANAGEMENT_AUTH_TYPE=iam
 * ACCOUNT_MANAGEMENT_APIKEY=&lt;IAM apikey&gt;
 * ACCOUNT_MANAGEMENT_AUTH_URL=&lt;IAM token service base URL - omit this if using the production environment&gt;
 *
 * These configuration properties can be exported as environment variables, or stored
 * in a configuration file and then:
 * export IBM_CREDENTIALS_FILE=&lt;name of configuration file&gt;
 */
public class AccountManagementExamples {
  private static final Logger logger = LoggerFactory.getLogger(AccountManagementExamples.class);
  protected AccountManagementExamples() { }
  private static String accountId;

  static {
    System.setProperty("IBM_CREDENTIALS_FILE", "../../account_management_v4.env");
  }

  /**
   * The main() function invokes operations of the account_management service.
   * @param args command-line arguments
   * @throws Exception an error occurred
   */
  @SuppressWarnings("checkstyle:methodlength")
  public static void main(String[] args) throws Exception {
    AccountManagement accountManagementService = AccountManagement.newInstance();

    // Load up our test-specific config properties.
    Map<String, String> testConfigProperties = CredentialUtils.getServiceProperties(AccountManagement.DEFAULT_SERVICE_NAME);
    accountId = testConfigProperties.get("ACCOUNT_ID");

    try {
      System.out.println("getAccount() result:");
      // begin-getAccount
      GetAccountOptions getAccountOptions = new GetAccountOptions.Builder()
        .accountId(accountId)
        .build();

      Response<AccountResponse> response = accountManagementService.getAccount(getAccountOptions).execute();
      AccountResponse accountResponse = response.getResult();

      System.out.println(accountResponse);
      // end-getAccount
    } catch (ServiceResponseException e) {
        logger.error(String.format("Service returned status code %s: %s%nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()), e);
    }
  }
}
