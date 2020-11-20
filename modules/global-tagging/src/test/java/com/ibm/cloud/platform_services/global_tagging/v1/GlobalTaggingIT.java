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
import static org.testng.Assert.assertTrue;
import static org.testng.Assert.fail;

import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.stream.Collectors;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.ibm.cloud.platform_services.global_tagging.v1.model.AttachTagOptions;
import com.ibm.cloud.platform_services.global_tagging.v1.model.DeleteTagAllOptions;
import com.ibm.cloud.platform_services.global_tagging.v1.model.DeleteTagOptions;
import com.ibm.cloud.platform_services.global_tagging.v1.model.DeleteTagResults;
import com.ibm.cloud.platform_services.global_tagging.v1.model.DeleteTagResultsItem;
import com.ibm.cloud.platform_services.global_tagging.v1.model.DeleteTagsResult;
import com.ibm.cloud.platform_services.global_tagging.v1.model.DetachTagOptions;
import com.ibm.cloud.platform_services.global_tagging.v1.model.ListTagsOptions;
import com.ibm.cloud.platform_services.global_tagging.v1.model.Resource;
import com.ibm.cloud.platform_services.global_tagging.v1.model.TagList;
import com.ibm.cloud.platform_services.global_tagging.v1.model.TagResults;
import com.ibm.cloud.platform_services.global_tagging.v1.model.TagResultsItem;
import com.ibm.cloud.platform_services.test.SdkIntegrationTestBase;
import com.ibm.cloud.sdk.core.http.Response;
import com.ibm.cloud.sdk.core.service.exception.ServiceResponseException;
import com.ibm.cloud.sdk.core.util.CredentialUtils;

/**
 * Integration test class for the GlobalTagging service.
 */
public class GlobalTaggingIT extends SdkIntegrationTestBase {
    public GlobalTagging service = null;
    public static Map<String, String> config = null;

    private String resourceCRN;
    private String tagName;

    @Override
    public String getConfigFilename() {
        return "../../global_tagging.env";
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

        service = GlobalTagging.newInstance();
        assertNotNull(service);
        assertNotNull(service.getServiceUrl());

        // Load up our test-specific config properties.
        config = CredentialUtils.getServiceProperties(GlobalTagging.DEFAULT_SERVICE_NAME);
        assertNotNull(config);
        assertFalse(config.isEmpty());
        assertEquals(service.getServiceUrl(), config.get("URL"));

        resourceCRN = config.get("RESOURCE_CRN");
        assertNotNull(resourceCRN);

        Random rand = new Random();
        tagName = String.format("java-sdk-%d", rand.nextInt(1000000));

        log("Service URL: " + service.getServiceUrl());
        log("Resource CRN: " + resourceCRN);
        log("Test Tag: " + tagName);

        log("Setup complete.");
    }

    @Test
    public void testListTags() throws Exception {
        try {
            ListTagsOptions listTagsOptions = new ListTagsOptions.Builder()
                    .offset(0)
                    .limit(1000)
                    .build();

            Response<TagList> response = service.listTags(listTagsOptions).execute();
            assertNotNull(response);
            assertEquals(response.getStatusCode(), 200);

            TagList tagListResult = response.getResult();
            assertNotNull(tagListResult);
            log(String.format("listTags() response:\n%s", tagListResult.toString()));
        } catch (ServiceResponseException e) {
            fail(String.format("Service returned status code %d: %s\nError details: %s", e.getStatusCode(),
                    e.getMessage(), e.getDebuggingInfo()));
        }
    }

    @Test(dependsOnMethods = { "testListTags" })
    public void testAttachTag() throws Exception {
        try {
            Resource resourceModel = new Resource.Builder()
                    .resourceId(resourceCRN)
                    .build();

            AttachTagOptions attachTagOptions = new AttachTagOptions.Builder()
                    .addResources(resourceModel)
                    .addTagNames(tagName)
                    .build();

            Response<TagResults> response = service.attachTag(attachTagOptions).execute();
            assertNotNull(response);
            assertEquals(response.getStatusCode(), 200);

            TagResults tagResultsResult = response.getResult();
            assertNotNull(tagResultsResult);
            log(String.format("attachTag() response:\n%s", tagResultsResult.toString()));

            assertNotNull(tagResultsResult.getResults());
            for (TagResultsItem result : tagResultsResult.getResults()) {
                assertFalse(result.isIsError());
            }

            // Make sure the tag was in fact attached to the resource.
            List<String> tags = getTagNamesForResource(service, resourceCRN);
            assertNotNull(tags);
            log("Resource now has these tags: " + tags);
            assertTrue(tags.contains(tagName));
        } catch (ServiceResponseException e) {
            fail(String.format("Service returned status code %d: %s\nError details: %s", e.getStatusCode(),
                    e.getMessage(), e.getDebuggingInfo()));
        }
    }

    @Test(dependsOnMethods = { "testAttachTag" })
    public void testDetachTag() throws Exception {
        try {
            Resource resourceModel = new Resource.Builder()
                    .resourceId(resourceCRN)
                    .build();

            DetachTagOptions detachTagOptions = new DetachTagOptions.Builder()
                    .addResources(resourceModel)
                    .addTagNames(tagName)
                    .build();

            Response<TagResults> response = service.detachTag(detachTagOptions).execute();
            assertNotNull(response);
            assertEquals(response.getStatusCode(), 200);

            TagResults tagResultsResult = response.getResult();
            assertNotNull(tagResultsResult);
            log(String.format("detachTag() response:\n%s", tagResultsResult.toString()));

            assertNotNull(tagResultsResult.getResults());
            for (TagResultsItem result : tagResultsResult.getResults()) {
                assertFalse(result.isIsError());
            }

            // Make sure the tag was in fact detached from the resource.
            List<String> tags = getTagNamesForResource(service, resourceCRN);
            assertNotNull(tags);
            log("Resource now has these tags: " + tags);
            assertFalse(tags.contains(tagName));
        } catch (ServiceResponseException e) {
            fail(String.format("Service returned status code %d: %s\nError details: %s", e.getStatusCode(),
                    e.getMessage(), e.getDebuggingInfo()));
        }
    }

    @Test(dependsOnMethods = { "testDetachTag" })
    public void testDeleteTag() throws Exception {
        try {
            DeleteTagOptions deleteTagOptions = new DeleteTagOptions.Builder()
                    .tagName(tagName)
                    .build();

            Response<DeleteTagResults> response = service.deleteTag(deleteTagOptions).execute();
            assertNotNull(response);
            assertEquals(response.getStatusCode(), 200);
            DeleteTagResults deleteTagResults = response.getResult();
            assertNotNull(deleteTagResults);
            log(String.format("deleteTag() response:\n%s", deleteTagResults.toString()));

            assertNotNull(deleteTagResults.getResults());
            for (DeleteTagResultsItem result : deleteTagResults.getResults()) {
                assertFalse(result.isIsError());
            }
        } catch (ServiceResponseException e) {
            fail(String.format("Service returned status code %d: %s\nError details: %s", e.getStatusCode(),
                    e.getMessage(), e.getDebuggingInfo()));
        }
    }

    @Test(dependsOnMethods = { "testDeleteTag" })
    public void testDeleteTagAll() throws Exception {
        try {
            DeleteTagAllOptions deleteTagAllOptions = new DeleteTagAllOptions.Builder().build();

            Response<DeleteTagsResult> response = service.deleteTagAll(deleteTagAllOptions).execute();
            assertNotNull(response);
            assertEquals(response.getStatusCode(), 200);

            DeleteTagsResult deleteTagsResult = response.getResult();
            assertNotNull(deleteTagsResult);
            log(String.format("deleteTagAll() response:\n%s", deleteTagsResult.toString()));
        } catch (ServiceResponseException e) {
            fail(String.format("Service returned status code %d: %s\nError details: %s", e.getStatusCode(),
                    e.getMessage(), e.getDebuggingInfo()));
        }
    }

    private List<String> getTagNamesForResource(GlobalTagging service, String resourceId) {
        try {
            ListTagsOptions options = new ListTagsOptions.Builder().attachedTo(resourceId).build();
            Response<TagList> listResponse = service.listTags(options).execute();
            TagList tagList = listResponse.getResult();
            if (tagList != null) {
                return tagList.getItems().stream().map(t -> t.getName()).collect(Collectors.toList());
            }
        } catch (ServiceResponseException e) {
            // absorb any errors with the operation
        }
        return null;
    }
}
