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

package com.ibm.cloud.platform_services.enterprise_usage_reports.v1;

import com.ibm.cloud.platform_services.enterprise_usage_reports.v1.model.GetResourceUsageReportOptions;
import com.ibm.cloud.platform_services.enterprise_usage_reports.v1.model.Link;
import com.ibm.cloud.platform_services.enterprise_usage_reports.v1.model.MetricUsage;
import com.ibm.cloud.platform_services.enterprise_usage_reports.v1.model.PlanUsage;
import com.ibm.cloud.platform_services.enterprise_usage_reports.v1.model.Reports;
import com.ibm.cloud.platform_services.enterprise_usage_reports.v1.model.ResourceUsage;
import com.ibm.cloud.platform_services.enterprise_usage_reports.v1.model.ResourceUsageReport;
import com.ibm.cloud.platform_services.enterprise_usage_reports.v1.utils.TestUtilities;
import com.ibm.cloud.platform_services.test.SdkIntegrationTestBase;
import com.ibm.cloud.sdk.core.http.Response;
import com.ibm.cloud.sdk.core.service.exception.ServiceResponseException;
import com.ibm.cloud.sdk.core.service.model.FileWithMetadata;
import com.ibm.cloud.sdk.core.util.CredentialUtils;

import okhttp3.HttpUrl;

import java.io.InputStream;
import java.net.URI;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import static org.testng.Assert.*;

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

    /**
     * This method provides our config filename to the base class.
     */
    public String getConfigFilename() {
        return "../../enterprise_usage_reports.env";
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
        System.out.println("Setup complete.");
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
                    offset = getOffsetFromURL(result.getNext().getHref());
                } else {
                    offset = null;
                }
            } while (offset != null);

            assertFalse(results.isEmpty());
            // System.out.println(String.format("Retrieved %d reports.", results.size()));
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
                    offset = getOffsetFromURL(result.getNext().getHref());
                } else {
                    offset = null;
                }
            } while (offset != null);

            assertFalse(results.isEmpty());
            // System.out.println(String.format("Retrieved %d reports.", results.size()));
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
                    offset = getOffsetFromURL(result.getNext().getHref());
                } else {
                    offset = null;
                }
            } while (offset != null);

            assertFalse(results.isEmpty());
            // System.out.println(String.format("Retrieved %d reports.", results.size()));
        } catch (ServiceResponseException e) {
            fail(String.format("Service returned status code %d: %s\nError details: %s", e.getStatusCode(),
                    e.getMessage(), e.getDebuggingInfo()));
        }
    }

    private String getOffsetFromURL(String s) {
        try {
            if (s == null) {
                return null;
            }

            // Parse "s" as a URI and retrieve its decoded query string.
            URI uri = new URI(s);
            String query = uri.getQuery();
            if (query == null || query.isEmpty()) {
                return null;
            }

            // Parse the query string into a map of key/value pairs.
            Map<String, String> params = new LinkedHashMap<>();
            for (String param : query.split("&")) {
                String[] keyValue = param.split("=", 2);
                String value = keyValue.length > 1 ? keyValue[1] : null;
                if (!keyValue[0].isEmpty()) {
                    params.put(keyValue[0], value);
                }
            }

            return params.get("offset");
        } catch (Throwable t) {

        }

        return null;
    }
}
