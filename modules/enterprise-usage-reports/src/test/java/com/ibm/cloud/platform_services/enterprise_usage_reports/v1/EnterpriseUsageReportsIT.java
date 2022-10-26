/*
 * (C) Copyright IBM Corp. 2020, 2022.
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

package com.ibm.cloud.platform_services.enterprise_usage_reports.v1;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertNotNull;
import static org.testng.Assert.fail;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.ibm.cloud.platform_services.enterprise_usage_reports.v1.model.GetResourceUsageReportOptions;
import com.ibm.cloud.platform_services.enterprise_usage_reports.v1.model.GetResourceUsageReportPager;
import com.ibm.cloud.platform_services.enterprise_usage_reports.v1.model.Reports;
import com.ibm.cloud.platform_services.enterprise_usage_reports.v1.model.ResourceUsageReport;
import com.ibm.cloud.platform_services.enterprise_usage_reports.v1.utils.TestUtilities;
import com.ibm.cloud.platform_services.test.SdkIntegrationTestBase;
import com.ibm.cloud.sdk.core.http.Response;
import com.ibm.cloud.sdk.core.service.exception.ServiceResponseException;
import com.ibm.cloud.sdk.core.service.model.FileWithMetadata;
import com.ibm.cloud.sdk.core.util.CredentialUtils;
import com.ibm.cloud.sdk.core.util.UrlHelper;

/**
 * Integration test class for the EnterpriseUsageReports service.
 */
public class EnterpriseUsageReportsIT extends SdkIntegrationTestBase {
    public EnterpriseUsageReports service = null;
    public static Map<String, String> config = null;
    final HashMap<String, InputStream> mockStreamMap = TestUtilities.createMockStreamMap();
    final List<FileWithMetadata> mockListFileWithMetadata = TestUtilities.creatMockListFileWithMetadata();

    // Test-related config properties.
    private static String ACCOUNT_ID;
    private static String ACCOUNT_GROUP_ID;
    private static String ENTERPRISE_ID;
    private static String BILLING_MONTH;

    @Override
    public String getConfigFilename() {
        return "../../enterprise_usage_reports.env";
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

        service = EnterpriseUsageReports.newInstance();
        assertNotNull(service);
        assertNotNull(service.getServiceUrl());

        // Load up our test-specific config properties.
        config = CredentialUtils.getServiceProperties(EnterpriseUsageReports.DEFAULT_SERVICE_NAME);
        assertNotNull(config);
        assertFalse(config.isEmpty());
        assertEquals(service.getServiceUrl(), config.get("URL"));

        // Retrieve and verify some additional test-related config properties.
        ACCOUNT_ID = config.get("ACCOUNT_ID");
        ACCOUNT_GROUP_ID = config.get("ACCOUNT_GROUP_ID");
        ENTERPRISE_ID = config.get("ENTERPRISE_ID");
        BILLING_MONTH = config.get("BILLING_MONTH");
        assertNotNull(ACCOUNT_ID);
        assertNotNull(ACCOUNT_GROUP_ID);
        assertNotNull(ENTERPRISE_ID);
        assertNotNull(BILLING_MONTH);
        log("Setup complete.");
    }

    @Test
    public void testGetResourceUsageReportEnterprise() throws Exception {
        try {
            List<ResourceUsageReport> results = new ArrayList<>();
            String offset = null;
            do {
                GetResourceUsageReportOptions getResourceUsageReportOptions = new GetResourceUsageReportOptions.Builder()
                        .enterpriseId(ENTERPRISE_ID)
                        .month(BILLING_MONTH)
                        .limit(1L)
                        .offset(offset)
                        .build();

                Response<Reports> response = service.getResourceUsageReport(getResourceUsageReportOptions).execute();
                assertNotNull(response);
                assertEquals(response.getStatusCode(), 200);

                Reports result = response.getResult();
                assertNotNull(result);

                // Add the just-retrieved page to the results.
                if (result.getReports() != null) {
                    results.addAll(result.getReports());
                }

                // Get the offset of the next page.
                if (result.getNext() != null) {
                    offset = UrlHelper.getQueryParam(result.getNext().getHref(), "offset");
                } else {
                    offset = null;
                }
            } while (offset != null);

            assertFalse(results.isEmpty());
            log(String.format("Retrieved %d reports.", results.size()));
        } catch (ServiceResponseException e) {
            fail(String.format("Service returned status code %d: %s\nError details: %s", e.getStatusCode(),
                    e.getMessage(), e.getDebuggingInfo()));
        }
    }

    @Test
    public void testGetResourceUsageReportAccount() throws Exception {
        try {
            List<ResourceUsageReport> results = new ArrayList<>();
            String offset = null;
            do {
                GetResourceUsageReportOptions getResourceUsageReportOptions = new GetResourceUsageReportOptions.Builder()
                        .accountId(ACCOUNT_ID)
                        .month(BILLING_MONTH)
                        .limit(1L)
                        .offset(offset)
                        .build();

                Response<Reports> response = service.getResourceUsageReport(getResourceUsageReportOptions).execute();
                assertNotNull(response);
                assertEquals(response.getStatusCode(), 200);

                Reports result = response.getResult();
                assertNotNull(result);

                // Add the just-retrieved page to the results.
                if (result.getReports() != null) {
                    results.addAll(result.getReports());
                }

                // Get the offset of the next page.
                if (result.getNext() != null) {
                    offset = UrlHelper.getQueryParam(result.getNext().getHref(), "offset");
                } else {
                    offset = null;
                }
            } while (offset != null);

            assertFalse(results.isEmpty());
            log(String.format("Retrieved %d reports.", results.size()));
        } catch (ServiceResponseException e) {
            fail(String.format("Service returned status code %d: %s\nError details: %s", e.getStatusCode(),
                    e.getMessage(), e.getDebuggingInfo()));
        }
    }

    @Test
    public void testGetResourceUsageReportAccountGroup() throws Exception {
        try {
            List<ResourceUsageReport> results = new ArrayList<>();
            String offset = null;
            do {
                GetResourceUsageReportOptions getResourceUsageReportOptions = new GetResourceUsageReportOptions.Builder()
                        .accountGroupId(ACCOUNT_GROUP_ID)
                        .month(BILLING_MONTH)
                        .limit(1L)
                        .offset(offset)
                        .build();

                Response<Reports> response = service.getResourceUsageReport(getResourceUsageReportOptions).execute();
                assertNotNull(response);
                assertEquals(response.getStatusCode(), 200);

                Reports result = response.getResult();
                assertNotNull(result);

                // Add the just-retrieved page to the results.
                if (result.getReports() != null) {
                    results.addAll(result.getReports());
                }

                // Get the offset of the next page.
                if (result.getNext() != null) {
                    offset = UrlHelper.getQueryParam(result.getNext().getHref(), "offset");
                } else {
                    offset = null;
                }
            } while (offset != null);

            assertFalse(results.isEmpty());
            log(String.format("Retrieved %d reports.", results.size()));
        } catch (ServiceResponseException e) {
            fail(String.format("Service returned status code %d: %s\nError details: %s", e.getStatusCode(),
                    e.getMessage(), e.getDebuggingInfo()));
        }
    }

    @Test
    public void testGetResourceUsageReportWithPager() throws Exception {
      try {
        GetResourceUsageReportOptions options = new GetResourceUsageReportOptions.Builder()
            .accountGroupId(ACCOUNT_GROUP_ID).month(BILLING_MONTH).build();

        // Test getNext().
        List<ResourceUsageReport> allResults = new ArrayList<>();
        GetResourceUsageReportPager pager = new GetResourceUsageReportPager(service, options);
        while (pager.hasNext()) {
          List<ResourceUsageReport> nextPage = pager.getNext();
          assertNotNull(nextPage);
          allResults.addAll(nextPage);
        }
        assertFalse(allResults.isEmpty());

        // Test getAll();
        pager = new GetResourceUsageReportPager(service, options);
        List<ResourceUsageReport> allItems = pager.getAll();
        assertNotNull(allItems);
        assertFalse(allItems.isEmpty());

        assertEquals(allItems.size(), allResults.size());
        System.out.println(String.format("Retrieved a total of %d item(s) with pagination.", allResults.size()));
      } catch (ServiceResponseException e) {
        fail(String.format("Service returned status code %d: %s%nError details: %s", e.getStatusCode(), e.getMessage(),
            e.getDebuggingInfo()));
      }
    }
  }
