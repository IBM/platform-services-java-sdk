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

package com.ibm.cloud.platform_services.global_tagging.v1;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertNotNull;
import static org.testng.Assert.fail;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;
import java.util.Random;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.ibm.cloud.platform_services.global_tagging.v1.model.AttachTagOptions;
import com.ibm.cloud.platform_services.global_tagging.v1.model.DeleteTagOptions;
import com.ibm.cloud.platform_services.global_tagging.v1.model.DeleteTagResults;
import com.ibm.cloud.platform_services.global_tagging.v1.model.DeleteTagResultsItem;
import com.ibm.cloud.platform_services.global_tagging.v1.model.DetachTagOptions;
import com.ibm.cloud.platform_services.global_tagging.v1.model.ListTagsOptions;
import com.ibm.cloud.platform_services.global_tagging.v1.model.Resource;
import com.ibm.cloud.platform_services.global_tagging.v1.model.TagList;
import com.ibm.cloud.platform_services.global_tagging.v1.model.TagResults;
import com.ibm.cloud.platform_services.global_tagging.v1.model.TagResultsItem;
import com.ibm.cloud.platform_services.test.SdkIntegrationTestBase;
import com.ibm.cloud.sdk.core.http.Response;
import com.ibm.cloud.sdk.core.security.IamAuthenticator;
import com.ibm.cloud.sdk.core.service.exception.ServiceResponseException;

/**
 * Integration test class for the GlobalTagging service.
 */
public class GlobalTaggingIT extends SdkIntegrationTestBase {

    Properties prop = null;
    GlobalTagging globalTagging = null;

    private static final String TAG_NAME_PREFIX = "java-sdk-";
    private String TAG_NAME_SUFFIX = "100";

    /**
     * This method provides our config filename to the base class.
     */
    public String getConfigFilename() {
        return "../../ghost.env";
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
            System.out.println(
                    String.format("Unable to load properties file %s: %s", getConfigFilename(), t.getMessage()));
            this.skipTests = true;
            return;
        }

        // Create the IAM authenticator.
        IamAuthenticator authenticator = new IamAuthenticator(this.prop.getProperty("GST_IINTERNA_APIKEY"));
        authenticator.setURL(this.prop.getProperty("GST_IAM_URL"));

        // Create the service instance.
        this.globalTagging = new GlobalTagging(GlobalTagging.DEFAULT_SERVICE_NAME, authenticator);
        this.globalTagging.setServiceUrl(this.prop.getProperty("GST_TAGS_URL"));

        // generate tag name suffix
        Random rand = new Random(); // instance of random class
        int upperbound = 1000000;
        int int_random = rand.nextInt(upperbound);
        this.TAG_NAME_SUFFIX = "" + int_random;
        System.out.println("Name TAG test = " + TAG_NAME_PREFIX + this.TAG_NAME_SUFFIX);
    }

    @Test
    public void testListTags() {
        System.out.println("START 1 GlobalTaggingITest.testGetAllTag method");
        assertNotNull(this.globalTagging);

        try {
            // Test 1 - GetAll Tag
            Response<TagList> response = globalTagging.listTags().execute();
            assertNotNull(response);
            System.out.println("testGetAllTag status code= " + response.getStatusCode());
            assertEquals(response.getStatusCode(), 200);
            TagList result = response.getResult();
            assertNotNull(result);
        } catch (ServiceResponseException e) {
            fail(String.format("Service returned status code %s: %s\nError details: %s", e.getStatusCode(),
                    e.getMessage(), e.getDebuggingInfo()));
        }
    }

    @Test(dependsOnMethods = { "testListTags" })
    public void testAttachTag() throws Exception, InterruptedException {
        System.out.println("START 2 GlobalTaggingITest.testAttachTag method");

        try {
            // Test 2 - Attach Tag
            String tagName = TAG_NAME_PREFIX + this.TAG_NAME_SUFFIX;
            System.out.println("testAttachTag tagName = " + tagName);
            Resource resource = new Resource.Builder().resourceId(this.prop.getProperty("GST_RESOURCE_CRN"))
                    .resourceType("cf-application").build();
            AttachTagOptions ato = new AttachTagOptions.Builder().addTagNames(tagName).addResources(resource).build();

            Response<TagResults> response = globalTagging.attachTag(ato).execute();
            assertNotNull(response);
            System.out.println("testAttachTag status code= " + response.getStatusCode());
            assertEquals(response.getStatusCode(), 200);
            TagResults result = response.getResult();
            System.out.println("testAttachTag result= " + result);
            assertNotNull(result);
            assertFalse(((TagResultsItem) (result.getResults().get(0))).isIsError().booleanValue());

            // Test 2 - call GetAll with attached-to parameter true in order to find the tag
            // just created
            ListTagsOptions lto = new ListTagsOptions.Builder().attachedTo(this.prop.getProperty("GST_RESOURCE_CRN"))
                    .build();

            Response<TagList> tlResponse = globalTagging.listTags(lto).execute();
            assertNotNull(tlResponse);
            assertEquals(tlResponse.getStatusCode(), 200);
            TagList tlResult = tlResponse.getResult();
            assertNotNull(tlResult);

        } catch (ServiceResponseException e) {
            fail(String.format("Service returned status code %s: %s\nError details: %s", e.getStatusCode(),
                    e.getMessage(), e.getDebuggingInfo()));
        }
    }

    @Test(dependsOnMethods = { "testAttachTag" })
    public void testDetachTag() {
        System.out.println("START 3 GlobalTaggingITest.testDetachTag method");

        try {
            // Test 3 - Detach Tag
            String tagName = TAG_NAME_PREFIX + this.TAG_NAME_SUFFIX;
            System.out.println("testDetachTag tagName = " + tagName);

            Resource resource = new Resource.Builder().resourceId(this.prop.getProperty("GST_RESOURCE_CRN"))
                    .resourceType("cf-application").build();

            DetachTagOptions dto = new DetachTagOptions.Builder().addTagNames(tagName).addResources(resource).build();

            Response<TagResults> response = globalTagging.detachTag(dto).execute();
            assertNotNull(response);
            System.out.println("testDetachTag status code= " + response.getStatusCode());
            assertEquals(response.getStatusCode(), 200);
            TagResults result = response.getResult();
            assertNotNull(result);
            System.out.println("testDetachTag result= " + result);
            assertFalse(((TagResultsItem) (result.getResults().get(0))).isIsError().booleanValue());

        } catch (ServiceResponseException e) {
            fail(String.format("Service returned status code %s: %s\nError details: %s", e.getStatusCode(),
                    e.getMessage(), e.getDebuggingInfo()));
        }
    }

    @Test(dependsOnMethods = { "testDetachTag" })
    public void testDeleteTag() {
        System.out.println("START 4 GlobalTaggingITest.testDeleteTag method");

        try {
            // Test 4 - Delete Tag
            String tagName = TAG_NAME_PREFIX + this.TAG_NAME_SUFFIX;
            System.out.println("testDeleteTag tagName = " + tagName);

            DeleteTagOptions dto = new DeleteTagOptions.Builder(tagName).build();

            Response<DeleteTagResults> response = globalTagging.deleteTag(dto).execute();
            assertEquals(response.getStatusCode(), 200);
            assertNotNull(response);
            DeleteTagResults result = response.getResult();
            System.out.println("testDeleteTag result= " + result);
            assertNotNull(result);
            assertFalse(((DeleteTagResultsItem) (result.getResults().get(0))).isIsError().booleanValue());

        } catch (ServiceResponseException e) {
            fail(String.format("Service returned status code %s: %s\nError details: %s", e.getStatusCode(),
                    e.getMessage(), e.getDebuggingInfo()));
        }
    }

    @AfterClass
    public void tearDown() {
        // Delete any resources created during this test that have not already been deleted.
    }
}
