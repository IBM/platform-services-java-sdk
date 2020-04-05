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

package com.ibm.cloud.platform_services.iam_access_groups.v2;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;
import static org.testng.AssertJUnit.assertNotNull;

import java.util.List;
import java.util.Map;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.ibm.cloud.platform_services.iam_access_groups.v2.model.CreateAccessGroupOptions;
import com.ibm.cloud.platform_services.iam_access_groups.v2.model.DeleteAccessGroupOptions;
import com.ibm.cloud.platform_services.iam_access_groups.v2.model.GetAccessGroupOptions;
import com.ibm.cloud.platform_services.iam_access_groups.v2.model.Group;
import com.ibm.cloud.platform_services.iam_access_groups.v2.model.GroupsList;
import com.ibm.cloud.platform_services.iam_access_groups.v2.model.ListAccessGroupsOptions;
import com.ibm.cloud.platform_services.iam_access_groups.v2.model.UpdateAccessGroupOptions;
import com.ibm.cloud.platform_services.test.SdkIntegrationTestBase;
import com.ibm.cloud.sdk.core.http.Response;
import com.ibm.cloud.sdk.core.util.CredentialUtils;

/**
 * Integration test class for the IamAccessGroups service.
 */
public class IamAccessGroupsIT extends SdkIntegrationTestBase {

    private static final String HEADER_ETAG = "ETag";

    private static final String TEST_GROUP_NAME = "SDK Test Group - Java";
    private static final String TEST_GROUP_DESC = "This group is used for integration test purposes. It can be deleted at any time.";

    IamAccessGroups service = null;
    String testAccountId = null;
    String testGroupId = null;
    String testGroupETag = null;


    /**
     * This method provides our config filename to the base class.
     */
    public String getConfigFilename() {
        return "../../iam_access_groups.env";
    }

    /**
     * This method is invoked before any @Test-annotated methods, and is responsible for
     * creating the instance of the service that will be used by the rest of the test methods,
     * as well as any other required initialization.
     */
    @BeforeClass
    public void constructService() {
        // Ask super if we should skip the tests.
        if (skipTests()) {
            return;
        }

        //
        // Perform the necessary setup required by this testcase.
        //

        // Load up the config properties for this service.
        Map<String, String> config = CredentialUtils.getServiceProperties(IamAccessGroups.DEFAULT_SERVICE_NAME);
        System.out.println("Service properties:\n" + config.toString());

        // Retrieve our test-specific properties.
        testAccountId = config.get("TEST_ACCOUNT_ID");
        assertNotNull(testAccountId);

        // Construct the service from our external configuration.
        service = IamAccessGroups.newInstance();
        assertNotNull(service);
        assertNotNull(service.getServiceUrl());

        System.out.println("Using Account Id: " + testAccountId);
        System.out.println("Using Service URL: " + service.getServiceUrl());
    }

    @Test
    public void testCreateAccessGroup() {
        CreateAccessGroupOptions options = new CreateAccessGroupOptions.Builder()
                .accountId(testAccountId)
                .name(TEST_GROUP_NAME)
                .build();

        Response<Group> response = service.createAccessGroup(options).execute();
        assertNotNull(response);
        assertEquals(response.getStatusCode(), 201);

        Group result = response.getResult();
        assertNotNull(result);
        assertEquals(result.getAccountId(), testAccountId);
        assertEquals(result.getName(), TEST_GROUP_NAME);

        testGroupId = result.getId();
        System.out.println(String.format("Created Access Group: id=%s, accountId=%s",
                result.getId(), result.getAccountId()));
    }

    @Test(dependsOnMethods = {"testCreateAccessGroup"})
    public void testGetAccessGroup() {
        assertNotNull(testGroupId);

        GetAccessGroupOptions options = new GetAccessGroupOptions.Builder()
                .accessGroupId(testGroupId)
                .build();

        Response<Group> response = service.getAccessGroup(options).execute();
        assertNotNull(response);
        assertEquals(response.getStatusCode(), 200);

        Group result = response.getResult();
        assertNotNull(result);
        assertEquals(result.getAccountId(), testAccountId);
        assertEquals(result.getName(), TEST_GROUP_NAME);
        assertEquals(result.getId(), testGroupId);

        System.out.println(String.format("\nResponse headers:\n%s", response.getHeaders().toString()));

        List<String> values = response.getHeaders().values(HEADER_ETAG);
        assertNotNull(values);
        testGroupETag = values.get(0);

        System.out.println(String.format("Retrieved Access Group: id=%s, accountId=%s ETag=%s",
                result.getId(), result.getAccountId(), testGroupETag));
    }

    @Test(dependsOnMethods = {"testGetAccessGroup"})
    public void testUpdateAccessGroupDescription() {
        assertNotNull(testGroupId);
        assertNotNull(testGroupETag);

        UpdateAccessGroupOptions options = new UpdateAccessGroupOptions.Builder()
                .accessGroupId(testGroupId)
                .ifMatch(testGroupETag)
                .description(TEST_GROUP_DESC)
                .build();

        Response<Group> response = service.updateAccessGroup(options).execute();
        assertNotNull(response);
        assertEquals(response.getStatusCode(), 200);

        Group result = response.getResult();
        assertNotNull(result);
        assertEquals(result.getAccountId(), testAccountId);
        assertEquals(result.getName(), TEST_GROUP_NAME);
        assertEquals(result.getId(), testGroupId);
        assertEquals(result.getDescription(), TEST_GROUP_DESC);

        System.out.println(String.format("Updated Access Group: id=%s, accountId=%s, description=%s",
                result.getId(), result.getAccountId(), result.getDescription()));

    }

    @Test(dependsOnMethods = {"testUpdateAccessGroupDescription"})
    public void testListAccessGroups() throws Exception, InterruptedException {
        ListAccessGroupsOptions options = new ListAccessGroupsOptions.Builder()
                .accountId(testAccountId)
                .hidePublicAccess(true)
                .build();

        Response<GroupsList> response = service.listAccessGroups(options).execute();
        assertNotNull(response);
        assertEquals(response.getStatusCode(), 200);

        GroupsList result = response.getResult();
        assertNotNull(response.getResult());
        System.out.println("ListAccessGroups results:");
        System.out.println("total count: " + result.getTotalCount());

        boolean foundTestGroup = false;
        for (Group group : result.getGroups()) {
            System.out.println(
                    String.format("Access group: id=%s, accountId=%s, description=%s",
                            group.getId(), group.getAccountId(), group.getDescription()));

            if (testGroupId.equals(group.getId())) {
                foundTestGroup = true;
                break;
            }
        }
        assertTrue(foundTestGroup);
    }

    @AfterClass
    public void tearDown() {
        // Delete all the access groups that we created during the test.
        ListAccessGroupsOptions options = new ListAccessGroupsOptions.Builder()
                .accountId(testAccountId)
                .hidePublicAccess(true)
                .build();

        Response<GroupsList> response = service.listAccessGroups(options).execute();
        assertNotNull(response);

        GroupsList result = response.getResult();
        assertNotNull(result);
        for (Group group : result.getGroups()) {
            if (TEST_GROUP_NAME.equals(group.getName())) {
                DeleteAccessGroupOptions deleteOptions = new DeleteAccessGroupOptions.Builder()
                        .accessGroupId(group.getId())
                        .force(true)
                        .build();
                Response<Void> deleteResponse = service.deleteAccessGroup(deleteOptions).execute();
                assertNotNull(deleteResponse);
                assertEquals(deleteResponse.getStatusCode(), 204);

                System.out.println(
                        String.format("Deleted Access group: id=%s", group.getId()));
            }
        }
    }
}
