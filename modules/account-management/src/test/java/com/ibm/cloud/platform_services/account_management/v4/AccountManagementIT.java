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
import com.ibm.cloud.platform_services.account_management.v4.model.AccountResponseTraits;
import com.ibm.cloud.platform_services.account_management.v4.model.GetAccountOptions;
import com.ibm.cloud.platform_services.account_management.v4.utils.TestUtilities;
import com.ibm.cloud.sdk.core.http.Response;
import com.ibm.cloud.sdk.core.service.exception.ServiceResponseException;
import com.ibm.cloud.sdk.core.service.model.FileWithMetadata;
import com.ibm.cloud.sdk.core.util.CredentialUtils;
import com.ibm.cloud.platform_services.test.SdkIntegrationTestBase;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import static org.testng.Assert.*;

/**
 * Integration test class for the AccountManagement service.
 */
public class AccountManagementIT extends SdkIntegrationTestBase {
  public AccountManagement service = null;
  public static Map<String, String> config = null;
  final HashMap<String, InputStream> mockStreamMap = TestUtilities.createMockStreamMap();
  final List<FileWithMetadata> mockListFileWithMetadata = TestUtilities.creatMockListFileWithMetadata();
  /**
   * This method provides our config filename to the base class.
   */

  public String getConfigFilename() {
    return "../../account_management_v4.env";
  }
  private String accountId = null;

  @BeforeClass
  public void constructService() {
    // Ask super if we should skip the tests.
    if (skipTests()) {
      return;
    }

    service = AccountManagement.newInstance();
    assertNotNull(service);
    assertNotNull(service.getServiceUrl());

    // Load up our test-specific config properties.
    config = CredentialUtils.getServiceProperties(AccountManagement.DEFAULT_SERVICE_NAME);
    assertNotNull(config);
    assertFalse(config.isEmpty());
    assertEquals(service.getServiceUrl(), config.get("URL"));
    accountId = config.get("ACCOUNT_ID");
    assertNotNull(accountId);
    
    service.enableRetries(4, 30);

    System.out.println("Setup complete.");
  }

  @Test
  public void testGetAccount() throws Exception {
    try {
      GetAccountOptions getAccountOptions = new GetAccountOptions.Builder()
        .accountId(accountId)
        .build();

      // Invoke operation
      Response<AccountResponse> response = service.getAccount(getAccountOptions).execute();
      // Validate response
      assertNotNull(response);
      assertEquals(response.getStatusCode(), 200);

      AccountResponse accountResponseResult = response.getResult();
      assertNotNull(accountResponseResult);

    } catch (ServiceResponseException e) {
        fail(String.format("Service returned status code %d: %s%nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()));
    }
  }

  @AfterClass
  public void tearDown() {
    // Add any clean up logic here
    System.out.println("Clean up complete.");
  }
 }
