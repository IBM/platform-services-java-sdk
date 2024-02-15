/*
 * (C) Copyright IBM Corp. 2024.
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

package com.ibm.cloud.platform_services.partner_billing_units.v1;

import com.ibm.cloud.platform_services.partner_billing_units.v1.model.BillingOptionsSummary;
import com.ibm.cloud.platform_services.partner_billing_units.v1.model.CreditPoolsReportSummary;
import com.ibm.cloud.platform_services.partner_billing_units.v1.model.GetBillingOptionsOptions;
import com.ibm.cloud.platform_services.partner_billing_units.v1.model.GetCreditPoolsReportOptions;
import com.ibm.cloud.platform_services.partner_billing_units.v1.utils.TestUtilities;
import com.ibm.cloud.platform_services.test.SdkIntegrationTestBase;
import com.ibm.cloud.sdk.core.http.Response;
import com.ibm.cloud.sdk.core.service.exception.ServiceResponseException;
import com.ibm.cloud.sdk.core.service.model.FileWithMetadata;
import com.ibm.cloud.sdk.core.util.CredentialUtils;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import static org.testng.Assert.*;

/**
 * Integration test class for the PartnerBillingUnits service.
 */
public class PartnerBillingUnitsIT extends SdkIntegrationTestBase {
  public PartnerBillingUnits service = null;
  public static Map<String, String> config = null;
  final HashMap<String, InputStream> mockStreamMap = TestUtilities.createMockStreamMap();
  final List<FileWithMetadata> mockListFileWithMetadata = TestUtilities.creatMockListFileWithMetadata();
  
  // Test-related config properties.
  private static String PARTNER_ID;
  private static String CUSTOMER_ID;
  private static String RESELLER_ID;
  private static String BILLING_MONTH;
  /**
   * This method provides our config filename to the base class.
   */

  public String getConfigFilename() {
    return "../../partner_billing_units_v1.env";
  }

  @BeforeClass
  public void constructService() {
    // Ask super if we should skip the tests.
    if (skipTests()) {
      return;
    }

    service = PartnerBillingUnits.newInstance();
    assertNotNull(service);
    assertNotNull(service.getServiceUrl());

    // Load up our test-specific config properties.
    config = CredentialUtils.getServiceProperties(PartnerBillingUnits.DEFAULT_SERVICE_NAME);
    assertNotNull(config);
    assertFalse(config.isEmpty());
    assertEquals(service.getServiceUrl(), config.get("URL"));

    // Retrieve and verify some additional test-related config properties.
    PARTNER_ID = config.get("PARTNER_ID");
    CUSTOMER_ID = config.get("CUSTOMER_ID");
    RESELLER_ID = config.get("RESELLER_ID");
    BILLING_MONTH = config.get("BILLING_MONTH");
    assertNotNull(PARTNER_ID);
    assertNotNull(CUSTOMER_ID);
    assertNotNull(RESELLER_ID);
    assertNotNull(BILLING_MONTH);

    service.enableRetries(4, 30);

    System.out.println("Setup complete.");
  }

  @Test
  public void testGetBillingOptions() throws Exception {
    try {
      GetBillingOptionsOptions getBillingOptionsOptions = new GetBillingOptionsOptions.Builder()
        .partnerId(PARTNER_ID)
        .date(BILLING_MONTH)
        .limit(Long.valueOf("30"))
        .build();

      // Invoke operation
      Response<BillingOptionsSummary> response = service.getBillingOptions(getBillingOptionsOptions).execute();
      // Validate response
      assertNotNull(response);
      assertEquals(response.getStatusCode(), 200);

      BillingOptionsSummary billingOptionsSummaryResult = response.getResult();

      assertNotNull(billingOptionsSummaryResult);
    } catch (ServiceResponseException e) {
        fail(String.format("Service returned status code %d: %s%nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()));
    }
  }

  @Test
  public void testGetBillingOptionsResellerForPartner() throws Exception {
    try {
      GetBillingOptionsOptions getBillingOptionsOptions = new GetBillingOptionsOptions.Builder()
        .partnerId(PARTNER_ID)
        .resellerId(RESELLER_ID)
        .date(BILLING_MONTH)
        .limit(Long.valueOf("30"))
        .build();

      // Invoke operation
      Response<BillingOptionsSummary> response = service.getBillingOptions(getBillingOptionsOptions).execute();
      // Validate response
      assertNotNull(response);
      assertEquals(response.getStatusCode(), 200);

      BillingOptionsSummary billingOptionsSummaryResult = response.getResult();

      assertNotNull(billingOptionsSummaryResult);
    } catch (ServiceResponseException e) {
        fail(String.format("Service returned status code %d: %s%nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()));
    }
  }

  @Test
  public void testGetBillingOptionsCustomerForPartner() throws Exception {
    try {
      GetBillingOptionsOptions getBillingOptionsOptions = new GetBillingOptionsOptions.Builder()
        .partnerId(PARTNER_ID)
        .customerId(CUSTOMER_ID)
        .date(BILLING_MONTH)
        .limit(Long.valueOf("30"))
        .build();

      // Invoke operation
      Response<BillingOptionsSummary> response = service.getBillingOptions(getBillingOptionsOptions).execute();
      // Validate response
      assertNotNull(response);
      assertEquals(response.getStatusCode(), 200);

      BillingOptionsSummary billingOptionsSummaryResult = response.getResult();

      assertNotNull(billingOptionsSummaryResult);
    } catch (ServiceResponseException e) {
        fail(String.format("Service returned status code %d: %s%nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()));
    }
  }

  @Test
  public void testGetCreditPoolsReport() throws Exception {
    try {
      GetCreditPoolsReportOptions getCreditPoolsReportOptions = new GetCreditPoolsReportOptions.Builder()
        .partnerId(PARTNER_ID)
        .date(BILLING_MONTH)
        .limit(Long.valueOf("30"))
        .build();

      // Invoke operation
      Response<CreditPoolsReportSummary> response = service.getCreditPoolsReport(getCreditPoolsReportOptions).execute();
      // Validate response
      assertNotNull(response);
      assertEquals(response.getStatusCode(), 200);

      CreditPoolsReportSummary creditPoolsReportSummaryResult = response.getResult();

      assertNotNull(creditPoolsReportSummaryResult);
    } catch (ServiceResponseException e) {
        fail(String.format("Service returned status code %d: %s%nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()));
    }
  }

  @Test
  public void testGetCreditPoolsReportResellerForPartner() throws Exception {
    try {
      GetCreditPoolsReportOptions getCreditPoolsReportOptions = new GetCreditPoolsReportOptions.Builder()
        .partnerId(PARTNER_ID)
        .resellerId(RESELLER_ID)
        .date(BILLING_MONTH)
        .limit(Long.valueOf("30"))
        .build();

      // Invoke operation
      Response<CreditPoolsReportSummary> response = service.getCreditPoolsReport(getCreditPoolsReportOptions).execute();
      // Validate response
      assertNotNull(response);
      assertEquals(response.getStatusCode(), 200);

      CreditPoolsReportSummary creditPoolsReportSummaryResult = response.getResult();

      assertNotNull(creditPoolsReportSummaryResult);
    } catch (ServiceResponseException e) {
        fail(String.format("Service returned status code %d: %s%nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()));
    }
  }

  @Test
  public void testGetCreditPoolsReportCustomerForPartner() throws Exception {
    try {
      GetCreditPoolsReportOptions getCreditPoolsReportOptions = new GetCreditPoolsReportOptions.Builder()
        .partnerId(PARTNER_ID)
        .customerId(CUSTOMER_ID)
        .date(BILLING_MONTH)
        .limit(Long.valueOf("30"))
        .build();

      // Invoke operation
      Response<CreditPoolsReportSummary> response = service.getCreditPoolsReport(getCreditPoolsReportOptions).execute();
      // Validate response
      assertNotNull(response);
      assertEquals(response.getStatusCode(), 200);

      CreditPoolsReportSummary creditPoolsReportSummaryResult = response.getResult();

      assertNotNull(creditPoolsReportSummaryResult);
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
