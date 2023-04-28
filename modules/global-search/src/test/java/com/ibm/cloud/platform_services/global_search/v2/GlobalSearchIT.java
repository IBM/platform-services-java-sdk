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

package com.ibm.cloud.platform_services.global_search.v2;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertNotNull;
import static org.testng.Assert.fail;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.ibm.cloud.platform_services.global_search.v2.model.GetSupportedTypesOptions;
import com.ibm.cloud.platform_services.global_search.v2.model.ResultItem;
import com.ibm.cloud.platform_services.global_search.v2.model.ScanResult;
import com.ibm.cloud.platform_services.global_search.v2.model.SearchOptions;
import com.ibm.cloud.platform_services.global_search.v2.model.SupportedTypesList;
import com.ibm.cloud.platform_services.global_search.v2.utils.TestUtilities;
import com.ibm.cloud.platform_services.test.SdkIntegrationTestBase;
import com.ibm.cloud.sdk.core.http.Response;
import com.ibm.cloud.sdk.core.service.exception.ServiceResponseException;
import com.ibm.cloud.sdk.core.service.model.FileWithMetadata;
import com.ibm.cloud.sdk.core.util.CredentialUtils;

/**
 * Integration test class for the GlobalSearch service.
 */
public class GlobalSearchIT extends SdkIntegrationTestBase {
    public GlobalSearch service = null;
    public static Map<String, String> config = null;
    final HashMap<String, InputStream> mockStreamMap = TestUtilities.createMockStreamMap();
    final List<FileWithMetadata> mockListFileWithMetadata = TestUtilities.creatMockListFileWithMetadata();

    private String transactionId = UUID.randomUUID().toString();

    @Override
    public String getConfigFilename() {
        return "../../global_search.env";
    }

    @Override
    public boolean loggingEnabled() {
        return true;
    }

    @BeforeClass
    public void constructService() {
        // Ask super if we should skip the tests.
        if (skipTests()) {
            return;
        }

        service = GlobalSearch.newInstance();
        assertNotNull(service);
        assertNotNull(service.getServiceUrl());

        // Load up our test-specific config properties.
        config = CredentialUtils.getServiceProperties(GlobalSearch.DEFAULT_SERVICE_NAME);
        assertNotNull(config);
        assertFalse(config.isEmpty());
        assertEquals(service.getServiceUrl(), config.get("URL"));

        log("Setup complete.");
    }

    @Test
    public void testSearch() throws Exception {
        try {
            List<ResultItem> searchResults = new ArrayList<>();

            // Search for resources 1 item at a time to exercise pagination.
            String searchCursor = null;
            boolean moreResults = true;

            do {
                SearchOptions searchOptions = new SearchOptions.Builder()
                        .query("GST-sdk-*")
                        .fields(new java.util.ArrayList<String>(java.util.Arrays.asList("*")))
                        .searchCursor(searchCursor)
                        .transactionId(transactionId)
                        .limit(1)
                        .build();

                Response<ScanResult> response = service.search(searchOptions).execute();
                assertNotNull(response);
                assertEquals(response.getStatusCode(), 200);
                ScanResult scanResult = response.getResult();
                assertNotNull(scanResult);
                log(String.format("search() result:\n%s\n", scanResult.toString()));

                if (!scanResult.getItems().isEmpty()) {
                    searchCursor = scanResult.getSearchCursor();
                    searchResults.addAll(scanResult.getItems());
                } else {
                    moreResults = false;
                }
            } while (moreResults);

            log(String.format("Total results returned by search(): %s\n", searchResults.size()));
        } catch (ServiceResponseException e) {
            fail(String.format("Service returned status code %d: %s\nError details: %s", e.getStatusCode(),
                    e.getMessage(), e.getDebuggingInfo()));
        }
    }

    @AfterClass
    public void tearDown() {
        // Add any clean up logic here
        System.out.println("Clean up complete.");
    }
}
