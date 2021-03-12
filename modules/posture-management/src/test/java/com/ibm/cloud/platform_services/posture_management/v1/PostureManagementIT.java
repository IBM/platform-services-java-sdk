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
import com.ibm.cloud.platform_services.posture_management.v1.utils.TestUtilities;
import com.ibm.cloud.platform_services.test.SdkIntegrationTestBase;
import com.ibm.cloud.sdk.core.http.Response;
import com.ibm.cloud.sdk.core.service.exception.ServiceResponseException;
import com.ibm.cloud.sdk.core.service.model.FileWithMetadata;
import com.ibm.cloud.sdk.core.util.CredentialUtils;

import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.testng.ITestContext;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

/**
 * Integration test class for the PostureManagement service.
 */
public class PostureManagementIT extends SdkIntegrationTestBase {

    public PostureManagement service = null;
    public static Map<String, String> config = null;

    private static String URL;
    private static String AUTH_TYPE;
    private static String APIKEY;
    private static String AUTH_URL;
    private static String ACCOUNT_ID;
    private static String PROFILE_NAME;
    private static String SCOPES_NAME;

    private static String SCOPE_ID = "scopeId";
    private static String PROFILE_ID = "profileId";

    /**
     * This method provides our config filename to the base class.
     */
    public String getConfigFilename() {
        return "../../posture_management_v1.env";
    }

    @BeforeClass
    public void constructService(ITestContext iTestContext) {
        // Ask super if we should skip the tests.
        if (skipTests()) {
            return;
        }

        service = PostureManagement.newInstance();
        assertNotNull(service);
        assertNotNull(service.getServiceUrl());

        // Load up our test-specific config properties.
        config = CredentialUtils.getServiceProperties(PostureManagement.DEFAULT_SERVICE_NAME);
        assertNotNull(config);
        assertFalse(config.isEmpty());
        assertEquals(service.getServiceUrl(), config.get("URL"));

        URL = config.get("URL");
        AUTH_TYPE = config.get("AUTH_TYPE");
        APIKEY = config.get("APIKEY");
        AUTH_URL = config.get("AUTH_URL");
        ACCOUNT_ID = config.get("ACCOUNT_ID");
        PROFILE_NAME = config.get("PROFILE_NAME");
        SCOPES_NAME = config.get("SCOPES_NAME");

        assertNotNull(URL);
        assertNotNull(AUTH_TYPE);
        assertNotNull(APIKEY);
        assertNotNull(AUTH_URL);
        assertNotNull(ACCOUNT_ID);
        assertNotNull(PROFILE_NAME);
        assertNotNull(SCOPES_NAME);

        System.out.println("Setup complete.");
    }

    @AfterClass
    public void tearDown() {
        // Add any clean up logic here
        System.out.println("Clean up complete.");
    }

    @Test(priority = 0)
    public void testListScopes(ITestContext iTestContext)
            throws Exception {
        try {
            ListScopesOptions listScopesOptions = new ListScopesOptions.Builder().accountId(ACCOUNT_ID)
                                                                                 .name(SCOPES_NAME)
                                                                                 .build();

            // Invoke operation
            Response<ScopesList> response = service.listScopes(listScopesOptions)
                                                   .execute();
            // Validate response
            assertNotNull(response);
            assertEquals(response.getStatusCode(), 200);

            ScopesList scopesListResult = response.getResult();

            assertNotNull(scopesListResult);
            assertNotEquals(scopesListResult.getScopes().size(), 0);
            assertNotEquals(scopesListResult.getScopes().get(0).getScopeId(), 0L);

            iTestContext.setAttribute(SCOPE_ID, scopesListResult.getScopes().get(0).getScopeId());
        } catch (ServiceResponseException e) {
            fail(String.format("Service returned status code %d: %s\nError details: %s", e.getStatusCode(),
                               e.getMessage(), e.getDebuggingInfo()));
        }
    }

    @Test(priority = 1)
    public void testListProfile(ITestContext iTestContext)
            throws Exception {
        try {
            ListProfileOptions listProfileOptions = new ListProfileOptions.Builder().accountId(ACCOUNT_ID)
                                                                                    .name(PROFILE_NAME)
                                                                                    .build();

            // Invoke operation
            Response<ProfilesList> response = service.listProfile(listProfileOptions)
                                                     .execute();
            // Validate response
            assertNotNull(response);
            assertEquals(response.getStatusCode(), 200);

            ProfilesList profilesListResult = response.getResult();

            assertNotNull(profilesListResult);
            assertNotEquals(profilesListResult.getProfiles().size(), 0);
            assertNotEquals(profilesListResult.getProfiles().get(0).getProfileId(), 0L);
            iTestContext.setAttribute(PROFILE_ID, profilesListResult.getProfiles().get(0).getProfileId());
        } catch (ServiceResponseException e) {
            fail(String.format("Service returned status code %d: %s\nError details: %s", e.getStatusCode(),
                               e.getMessage(), e.getDebuggingInfo()));
        }
    }

    @Test(priority = 2)
    public void testCreateValidationScan(ITestContext iTestContext)
            throws Exception {
        try {
            Long scopeId = (Long) iTestContext.getAttribute(SCOPE_ID);
            Long profileId = (Long) iTestContext.getAttribute(PROFILE_ID);

            CreateValidationScanOptions createValidationScanOptions =
                    new CreateValidationScanOptions.Builder().accountId(ACCOUNT_ID)
                                                             .scopeId(scopeId)
                                                             .profileId(profileId)
                                                             .build();

            // Invoke operation
            Response<Result> response = service.createValidationScan(createValidationScanOptions)
                                               .execute();
            // Validate response
            assertNotNull(response);
            assertEquals(response.getStatusCode(), 200);

            Result resultResult = response.getResult();

            assertNotNull(resultResult);
        } catch (ServiceResponseException e) {
            fail(String.format("Service returned status code %d: %s\nError details: %s", e.getStatusCode(),
                               e.getMessage(), e.getDebuggingInfo()));
        }
    }

}
