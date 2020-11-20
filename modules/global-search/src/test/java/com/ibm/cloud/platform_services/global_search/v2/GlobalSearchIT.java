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
import static org.testng.Assert.assertNotNull;
import static org.testng.Assert.fail;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.ibm.cloud.platform_services.global_search.v2.model.ScanResult;
import com.ibm.cloud.platform_services.global_search.v2.model.SearchOptions;
import com.ibm.cloud.platform_services.global_search.v2.model.SupportedTypesList;
import com.ibm.cloud.platform_services.test.SdkIntegrationTestBase;
import com.ibm.cloud.sdk.core.http.Response;
import com.ibm.cloud.sdk.core.security.IamAuthenticator;
import com.ibm.cloud.sdk.core.service.exception.ServiceResponseException;

/**
 * Integration test class for the GlobalSearch service.
 */
public class GlobalSearchIT extends SdkIntegrationTestBase {

    Properties prop = null;
    GlobalSearch globalSearch = null;

    /**
     * This method provides our config filename to the base class.
     */
    @Override
    public String getConfigFilename() {
        return "../../ghost.env";
    }

    @Override
    public boolean loggingEnabled() {
        return false;
    }

    /**
     * This method is invoked before any @Test-annotated methods, and is responsible
     * for creating the instance of the service that will be used by the rest of the
     * test methods, as well as any other required initialization.
     */
    @BeforeClass
    public void constructService() {
        // Ask super if we should skip the tests.
        if (skipTests()) {
            return;
        }

        try {
            InputStream input = new FileInputStream(getConfigFilename());
            this.prop = new Properties();
            this.prop.load(input);
        } catch (Throwable t) {
            log(String.format("Unable to load properties file %s: %s", getConfigFilename(), t.getMessage()));
            this.skipTests = true;
            return;
        }

        // Create the IAM authenticator.
        IamAuthenticator authenticator = new IamAuthenticator(this.prop.getProperty("GST_IINTERNA_APIKEY"));
        authenticator.setURL(this.prop.getProperty("GST_IAM_URL"));

        // Create the service instance.
        this.globalSearch = new GlobalSearch("global_search", authenticator);
        this.globalSearch.setServiceUrl(this.prop.getProperty("GST_API_URL"));
    }

    @Test
    public void testSearchAll() {
        log("START GlobalSearchIT.testSearchAll method");

        try {
            // Test - search all resource
            SearchOptions searchOpt = new SearchOptions.Builder()
                    .query("name:gst-sdk*")
                    .build();
            Response<ScanResult> response = this.globalSearch.search(searchOpt).execute();
            assertNotNull(response);
            ScanResult result = response.getResult();
            assertNotNull(result);
            log("response: " + result.getItems());
            assertEquals(result.getItems().size(), 2);
        } catch (ServiceResponseException e) {
            fail(String.format("Service returned status code %s: %s\nError details: %s",
                    e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()));
        }
    }

    @Test(dependsOnMethods = { "testSearchAll" })
    public void testSearchOne() {
        log("START GlobalSearchIT.testSearchOne method");

        try {
            // Test - search all resource and set limit = 1
            SearchOptions searchOpt = new SearchOptions.Builder()
                    .query(this.prop.getProperty("GST_QUERY"))
                    .limit(1)
                    .addFields("crn")
                    .addFields("name")
                    .build();
            Response<ScanResult> response = this.globalSearch.search(searchOpt).execute();
            assertNotNull(response);

            ScanResult result = response.getResult();
            assertNotNull(result);
            assertEquals(result.getItems().size(), 1);
            log("response: " + result.getItems());
        } catch (ServiceResponseException e) {
            fail(String.format("Service returned status code %s: %s\nError details: %s", e.getStatusCode(),
                    e.getMessage(), e.getDebuggingInfo()));
        }
    }

    @Test(dependsOnMethods = { "testSearchOne" })
    public void testGetSupportedTypes() {
        // Test 3 - getSupportedTypes operation
        Response<SupportedTypesList> responseSTL = this.globalSearch.getSupportedTypes().execute();
        assertNotNull(responseSTL);
        SupportedTypesList resultSTL = responseSTL.getResult();
        assertNotNull(resultSTL);
        log("response SupportedTypesList: " + resultSTL.getSupportedTypes());
    }
}
