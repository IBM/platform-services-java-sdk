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

package com.ibm.cloud.platform_services.enterprise_billing_units.v1;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertNotNull;
import static org.testng.Assert.fail;

import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.ibm.cloud.platform_services.enterprise_billing_units.v1.model.BillingOptionsList;
import com.ibm.cloud.platform_services.enterprise_billing_units.v1.model.BillingUnit;
import com.ibm.cloud.platform_services.enterprise_billing_units.v1.model.BillingUnitsList;
import com.ibm.cloud.platform_services.enterprise_billing_units.v1.model.CreditPoolsList;
import com.ibm.cloud.platform_services.enterprise_billing_units.v1.model.GetBillingUnitOptions;
import com.ibm.cloud.platform_services.enterprise_billing_units.v1.model.GetCreditPoolsOptions;
import com.ibm.cloud.platform_services.enterprise_billing_units.v1.model.ListBillingOptionsOptions;
import com.ibm.cloud.platform_services.enterprise_billing_units.v1.model.ListBillingUnitsOptions;
import com.ibm.cloud.platform_services.enterprise_billing_units.v1.utils.TestUtilities;
import com.ibm.cloud.platform_services.test.SdkIntegrationTestBase;
import com.ibm.cloud.sdk.core.http.Response;
import com.ibm.cloud.sdk.core.service.exception.ServiceResponseException;
import com.ibm.cloud.sdk.core.service.model.FileWithMetadata;
import com.ibm.cloud.sdk.core.util.CredentialUtils;

/**
 * Integration test class for the EnterpriseBillingUnits service.
 */
public class EnterpriseBillingUnitsIT extends SdkIntegrationTestBase {
  public EnterpriseBillingUnits service = null;
  public static Map<String, String> config = null;
  final HashMap<String, InputStream> mockStreamMap = TestUtilities.createMockStreamMap();
  final List<FileWithMetadata> mockListFileWithMetadata = TestUtilities.creatMockListFileWithMetadata();

  private static String ENTERPRISE_ID;
  private static String ACCOUNT_ID;
  private static String ACCOUNT_GROUP_ID;
  private static String BILLING_UNIT_ID;

  @Override
  public String getConfigFilename() {
    return "../../enterprise_billing_units.env";
  }

  @Override
  public boolean loggingEnabled() {
      return false;
  }

  @BeforeClass
  public void constructService() {
    // Ask super if we should skip the tests.
    if (skipTests()) {
      return;
    }

    service = EnterpriseBillingUnits.newInstance();
    assertNotNull(service);
    assertNotNull(service.getServiceUrl());

    // Load up our test-specific config properties.
    config = CredentialUtils.getServiceProperties(EnterpriseBillingUnits.DEFAULT_SERVICE_NAME);
    assertNotNull(config);
    assertFalse(config.isEmpty());
    assertEquals(service.getServiceUrl(), config.get("URL"));

    System.out.println("Setup complete.");
  }

  @Test
  public void testGetBillingUnit() throws Exception {
    try {
      GetBillingUnitOptions getBillingUnitOptions = new GetBillingUnitOptions.Builder()
      .billingUnitId("testString")
      .build();

      // Invoke operation
      Response<BillingUnit> response = service.getBillingUnit(getBillingUnitOptions).execute();
      // Validate response
      assertNotNull(response);
      assertEquals(response.getStatusCode(), 200);

      BillingUnit billingUnitResult = response.getResult();

      assertNotNull(billingUnitResult);
    } catch (ServiceResponseException e) {
        fail(String.format("Service returned status code %d: %s\nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()));
    }
  }

  @Test
  public void testListBillingUnits() throws Exception {
    try {
      ListBillingUnitsOptions listBillingUnitsOptions = new ListBillingUnitsOptions.Builder()
      .accountId("testString")
      .enterpriseId("testString")
      .accountGroupId("testString")
      .build();

      // Invoke operation
      Response<BillingUnitsList> response = service.listBillingUnits(listBillingUnitsOptions).execute();
      // Validate response
      assertNotNull(response);
      assertEquals(response.getStatusCode(), 200);

      BillingUnitsList billingUnitsListResult = response.getResult();

      assertNotNull(billingUnitsListResult);
    } catch (ServiceResponseException e) {
        fail(String.format("Service returned status code %d: %s\nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()));
    }
  }

  @Test
  public void testListBillingOptions() throws Exception {
    try {
      ListBillingOptionsOptions listBillingOptionsOptions = new ListBillingOptionsOptions.Builder()
      .billingUnitId("testString")
      .build();

      // Invoke operation
      Response<BillingOptionsList> response = service.listBillingOptions(listBillingOptionsOptions).execute();
      // Validate response
      assertNotNull(response);
      assertEquals(response.getStatusCode(), 200);

      BillingOptionsList billingOptionsListResult = response.getResult();

      assertNotNull(billingOptionsListResult);
    } catch (ServiceResponseException e) {
        fail(String.format("Service returned status code %d: %s\nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()));
    }
  }

  @Test
  public void testGetCreditPools() throws Exception {
    try {
      GetCreditPoolsOptions getCreditPoolsOptions = new GetCreditPoolsOptions.Builder()
      .billingUnitId("testString")
      .date("testString")
      .type("testString")
      .build();

      // Invoke operation
      Response<CreditPoolsList> response = service.getCreditPools(getCreditPoolsOptions).execute();
      // Validate response
      assertNotNull(response);
      assertEquals(response.getStatusCode(), 200);

      CreditPoolsList creditPoolsListResult = response.getResult();

      assertNotNull(creditPoolsListResult);
    } catch (ServiceResponseException e) {
        fail(String.format("Service returned status code %d: %s\nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()));
    }
  }

  @AfterClass
  public void tearDown() {
    // Add any clean up logic here
    System.out.println("Clean up complete.");
  }
 }
