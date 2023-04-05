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

package com.ibm.cloud.platform_services.enterprise_billing_units.v1;

import com.ibm.cloud.platform_services.enterprise_billing_units.v1.model.BillingOption;
import com.ibm.cloud.platform_services.enterprise_billing_units.v1.model.BillingOptionsList;
import com.ibm.cloud.platform_services.enterprise_billing_units.v1.model.BillingOptionsPager;
import com.ibm.cloud.platform_services.enterprise_billing_units.v1.model.BillingUnit;
import com.ibm.cloud.platform_services.enterprise_billing_units.v1.model.BillingUnitsList;
import com.ibm.cloud.platform_services.enterprise_billing_units.v1.model.BillingUnitsPager;
import com.ibm.cloud.platform_services.enterprise_billing_units.v1.model.CreditPool;
import com.ibm.cloud.platform_services.enterprise_billing_units.v1.model.CreditPoolOverage;
import com.ibm.cloud.platform_services.enterprise_billing_units.v1.model.CreditPoolsList;
import com.ibm.cloud.platform_services.enterprise_billing_units.v1.model.GetBillingUnitOptions;
import com.ibm.cloud.platform_services.enterprise_billing_units.v1.model.GetCreditPoolsOptions;
import com.ibm.cloud.platform_services.enterprise_billing_units.v1.model.ListBillingOptionsOptions;
import com.ibm.cloud.platform_services.enterprise_billing_units.v1.model.ListBillingUnitsOptions;
import com.ibm.cloud.platform_services.enterprise_billing_units.v1.model.TermCredits;
import com.ibm.cloud.platform_services.enterprise_billing_units.v1.utils.TestUtilities;
import com.ibm.cloud.platform_services.test.SdkIntegrationTestBase;
import com.ibm.cloud.sdk.core.http.Response;
import com.ibm.cloud.sdk.core.service.exception.ServiceResponseException;
import com.ibm.cloud.sdk.core.service.model.FileWithMetadata;
import com.ibm.cloud.sdk.core.util.CredentialUtils;
import com.ibm.cloud.sdk.core.util.DateUtils;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import static org.testng.Assert.*;

/**
 * Integration test class for the EnterpriseBillingUnits service.
 */
public class EnterpriseBillingUnitsIT extends SdkIntegrationTestBase {
  public EnterpriseBillingUnits service = null;
  public static Map<String, String> config = null;
  final HashMap<String, InputStream> mockStreamMap = TestUtilities.createMockStreamMap();
  final List<FileWithMetadata> mockListFileWithMetadata = TestUtilities.creatMockListFileWithMetadata();
  /**
   * This method provides our config filename to the base class.
   */

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

    service.enableRetries(4, 30);
    ENTERPRISE_ID = config.get("ENTERPRISE_ID");
    ACCOUNT_ID = config.get("ACCOUNT_ID");
    ACCOUNT_GROUP_ID = config.get("ACCOUNT_GROUP_ID");
    BILLING_UNIT_ID = config.get("BILLING_UNIT_ID");

    assertNotNull(ENTERPRISE_ID);
    assertNotNull(ACCOUNT_ID);
    assertNotNull(ACCOUNT_GROUP_ID);
    assertNotNull(BILLING_UNIT_ID);

    log("Service URL: " + service.getServiceUrl());

    System.out.println("Setup complete.");
  }

  @Test
  public void testGetBillingUnit() throws Exception {
    try {
      GetBillingUnitOptions getBillingUnitOptions = new GetBillingUnitOptions.Builder()
          .billingUnitId(BILLING_UNIT_ID)
          .build();

      // Invoke operation
      Response<BillingUnit> response = service.getBillingUnit(getBillingUnitOptions).execute();
      // Validate response
      assertNotNull(response);
      assertEquals(response.getStatusCode(), 200);

      BillingUnit billingUnitResult = response.getResult();
      assertNotNull(billingUnitResult);
      log(String.format(">>> getBillingUnit response:\n%s", billingUnitResult.toString()));
    } catch (ServiceResponseException e) {
      fail(String.format("Service returned status code %d: %s%nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()));
    }
  }

  @Test(dependsOnMethods = { "testGetBillingUnit" })
  public void testListBillingUnitsEnterpriseId() throws Exception {
    try {
      ListBillingUnitsOptions listBillingUnitsOptions = new ListBillingUnitsOptions.Builder()
          .enterpriseId(ENTERPRISE_ID)
          .build();

      // Invoke operation
      Response<BillingUnitsList> response = service.listBillingUnits(listBillingUnitsOptions).execute();
      // Validate response
      assertNotNull(response);
      assertEquals(response.getStatusCode(), 200);

      BillingUnitsList billingUnitsListResult = response.getResult();
      assertNotNull(billingUnitsListResult);
      log(String.format(">>> listBillingUnits(enterprise id) response:\n%s", billingUnitsListResult.toString()));
    } catch (ServiceResponseException e) {
      fail(String.format("Service returned status code %d: %s%nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()));
    }
  }

  @Test
  public void testListBillingUnitsAccountId() throws Exception {
    try {
      ListBillingUnitsOptions listBillingUnitsOptions = new ListBillingUnitsOptions.Builder()
          .accountId(ACCOUNT_ID)
          .build();

      // Invoke operation
      Response<BillingUnitsList> response = service.listBillingUnits(listBillingUnitsOptions).execute();
      // Validate response
      assertNotNull(response);
      assertEquals(response.getStatusCode(), 200);

      BillingUnitsList billingUnitsListResult = response.getResult();
      assertNotNull(billingUnitsListResult);
      log(String.format(">>> listBillingUnits(account id) response:\n%s", billingUnitsListResult.toString()));
    } catch (ServiceResponseException e) {
      fail(String.format("Service returned status code %d: %s\nError details: %s", e.getStatusCode(),
          e.getMessage(), e.getDebuggingInfo()));
    }
  }

  @Test
  public void testListBillingUnitsAccountGroupId() throws Exception {
    try {
      ListBillingUnitsOptions listBillingUnitsOptions = new ListBillingUnitsOptions.Builder()
          .accountGroupId(ACCOUNT_GROUP_ID)
          .build();

      // Invoke operation
      Response<BillingUnitsList> response = service.listBillingUnits(listBillingUnitsOptions).execute();
      // Validate response
      assertNotNull(response);
      assertEquals(response.getStatusCode(), 200);

      BillingUnitsList billingUnitsListResult = response.getResult();
      assertNotNull(billingUnitsListResult);
      log(String.format(">>> listBillingUnits(account group id) response:\n%s", billingUnitsListResult.toString()));
    } catch (ServiceResponseException e) {
      fail(String.format("Service returned status code %d: %s\nError details: %s", e.getStatusCode(),
          e.getMessage(), e.getDebuggingInfo()));
    }
  }

  @Test
  public void testListBillingUnitsWithPager() throws Exception {
    try {
      ListBillingUnitsOptions options = new ListBillingUnitsOptions.Builder()
          .enterpriseId(ENTERPRISE_ID)
          .limit(Long.valueOf("10"))
          .build();

      // Test getNext().
      List<BillingUnit> allResults = new ArrayList<>();
      BillingUnitsPager pager = new BillingUnitsPager(service, options);
      while (pager.hasNext()) {
        List<BillingUnit> nextPage = pager.getNext();
        assertNotNull(nextPage);
        allResults.addAll(nextPage);
      }
      assertFalse(allResults.isEmpty());

      // Test getAll();
      pager = new BillingUnitsPager(service, options);
      List<BillingUnit> allItems = pager.getAll();
      assertNotNull(allItems);
      assertFalse(allItems.isEmpty());

      assertEquals(allItems.size(), allResults.size());
      System.out.println(String.format("Retrieved a total of %d item(s) with pagination.", allResults.size()));
    } catch (ServiceResponseException e) {
      fail(String.format("Service returned status code %d: %s%nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()));
    }
  }

  @Test
  public void testListBillingOptions() throws Exception {
    try {
      ListBillingOptionsOptions listBillingOptionsOptions = new ListBillingOptionsOptions.Builder()
          .billingUnitId(BILLING_UNIT_ID)
          .limit(Long.valueOf("10"))
          .start("testString")
          .build();

      // Invoke operation
      Response<BillingOptionsList> response = service.listBillingOptions(listBillingOptionsOptions).execute();
      // Validate response
      assertNotNull(response);
      assertEquals(response.getStatusCode(), 200);

      BillingOptionsList billingOptionsListResult = response.getResult();
      assertNotNull(billingOptionsListResult);
      log(String.format(">>> listBillingOptions() response:\n%s", billingOptionsListResult.toString()));
    } catch (ServiceResponseException e) {
      fail(String.format("Service returned status code %d: %s%nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()));
    }
  }

  @Test(dependsOnMethods = { "testListBillingOptions" })
  public void testListBillingOptionsWithPager() throws Exception {
    try {
      ListBillingOptionsOptions options = new ListBillingOptionsOptions.Builder()
          .billingUnitId(BILLING_UNIT_ID)
          .build();

      // Test getNext().
      List<BillingOption> allResults = new ArrayList<>();
      BillingOptionsPager pager = new BillingOptionsPager(service, options);
      while (pager.hasNext()) {
        List<BillingOption> nextPage = pager.getNext();
        assertNotNull(nextPage);
        allResults.addAll(nextPage);
      }
      assertFalse(allResults.isEmpty());

      // Test getAll();
      pager = new BillingOptionsPager(service, options);
      List<BillingOption> allItems = pager.getAll();
      assertNotNull(allItems);
      assertFalse(allItems.isEmpty());

      assertEquals(allItems.size(), allResults.size());
      System.out.println(String.format("Retrieved a total of %d item(s) with pagination.", allResults.size()));
    } catch (ServiceResponseException e) {
      fail(String.format("Service returned status code %d: %s%nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()));
    }
  }

  @Test(dependsOnMethods = { "testListBillingOptions" })
  public void testGetCreditPools() throws Exception {
    try {

      GetCreditPoolsOptions getCreditPoolsOptions = new GetCreditPoolsOptions.Builder()
          .billingUnitId(BILLING_UNIT_ID)
          .type("PLATFORM")
          .build();

      // Invoke operation
      Response<CreditPoolsList> response = service.getCreditPools(getCreditPoolsOptions).execute();
      // Validate response
      assertNotNull(response);
      assertEquals(response.getStatusCode(), 200);

      CreditPoolsList creditPoolsListResult = response.getResult();
      assertNotNull(creditPoolsListResult);
      log(String.format(">>> getCreditPools() response:\n%s", creditPoolsListResult.toString()));
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
