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

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.ibm.cloud.platform_services.global_tagging.v1.model.AttachTagOptions;
import com.ibm.cloud.platform_services.global_tagging.v1.model.CreateTagOptions;
import com.ibm.cloud.platform_services.global_tagging.v1.model.CreateTagResults;
import com.ibm.cloud.platform_services.global_tagging.v1.model.DeleteTagAllOptions;
import com.ibm.cloud.platform_services.global_tagging.v1.model.DeleteTagOptions;
import com.ibm.cloud.platform_services.global_tagging.v1.model.DeleteTagResults;
import com.ibm.cloud.platform_services.global_tagging.v1.model.DeleteTagResultsItem;
import com.ibm.cloud.platform_services.global_tagging.v1.model.DeleteTagsResult;
import com.ibm.cloud.platform_services.global_tagging.v1.model.DeleteTagsResultItem;
import com.ibm.cloud.platform_services.global_tagging.v1.model.DetachTagOptions;
import com.ibm.cloud.platform_services.global_tagging.v1.model.ListTagsOptions;
import com.ibm.cloud.platform_services.global_tagging.v1.model.Resource;
import com.ibm.cloud.platform_services.global_tagging.v1.model.Tag;
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

    private static final String sdkLabel = "java-sdk";
    private static final String userTag1 = String.format("%s-user-test1", sdkLabel);
    private static final String userTag2 = String.format("%s-user-test2", sdkLabel);
    private static final String accessTag1 = String.format("env:%s-public", sdkLabel);
    private static final String accessTag2 = String.format("region:%s-us-south", sdkLabel);

    private String resourceCRN;

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

        log("Service URL: " + service.getServiceUrl());
        log("Resource CRN: " + resourceCRN);

        cleanTags(service);

        log("Setup complete.");
    }

    @AfterClass
    public void tearDown() {
        log("Teardown...");
        cleanTags(service);
        log("Finished teardown.");
    }

    @Test
    public void testCreateTag() throws Exception {
        try {
            CreateTagOptions createTagOptions = new CreateTagOptions.Builder()
                    .addTagNames(accessTag1)
                    .addTagNames(accessTag2)
                    .tagType("access")
                    .build();

            // Invoke operation
            Response<CreateTagResults> response = service.createTag(createTagOptions).execute();
            // Validate response
            assertNotNull(response);
            assertEquals(response.getStatusCode(), 200);

            CreateTagResults createTagResultsResult = response.getResult();
            assertNotNull(createTagResultsResult);
            log(String.format("createTag() response:\n%s", createTagResultsResult.toString()));
        } catch (ServiceResponseException e) {
            fail(String.format("Service returned status code %d: %s\nError details: %s", e.getStatusCode(),
                    e.getMessage(), e.getDebuggingInfo()));
        }
    }

    @Test(dependsOnMethods = { "testCreateTag" })
    public void testAttachTagUser() throws Exception {
        try {
            Resource resourceModel = new Resource.Builder()
                    .resourceId(resourceCRN)
                    .build();

            AttachTagOptions attachTagOptions = new AttachTagOptions.Builder()
                    .addResources(resourceModel)
                    .addTagNames(userTag1)
                    .addTagNames(userTag2)
                    .tagType("user")
                    .build();

            Response<TagResults> response = service.attachTag(attachTagOptions).execute();
            assertNotNull(response);
            assertEquals(response.getStatusCode(), 200);

            TagResults tagResultsResult = response.getResult();
            assertNotNull(tagResultsResult);
            log(String.format("attachTag(user) response:\n%s", tagResultsResult.toString()));

            assertNotNull(tagResultsResult.getResults());
            for (TagResultsItem result : tagResultsResult.getResults()) {
                assertFalse(result.isIsError());
            }

            // Make sure the tag was in fact attached to the resource.
            List<String> tags = getTagNamesForResource(service, resourceCRN, "user");
            assertNotNull(tags);
            log("Resource now has these user tags: " + tags);
            assertTrue(tags.contains(userTag1));
            assertTrue(tags.contains(userTag2));
        } catch (ServiceResponseException e) {
            fail(String.format("Service returned status code %d: %s\nError details: %s", e.getStatusCode(),
                    e.getMessage(), e.getDebuggingInfo()));
        }
    }

    @Test(dependsOnMethods = { "testAttachTagUser" })
    public void testAttachTagAccess() throws Exception {
        try {
            Resource resourceModel = new Resource.Builder()
                    .resourceId(resourceCRN)
                    .build();

            AttachTagOptions attachTagOptions = new AttachTagOptions.Builder()
                    .addResources(resourceModel)
                    .addTagNames(accessTag1)
                    .addTagNames(accessTag2)
                    .tagType("access")
                    .build();

            Response<TagResults> response = service.attachTag(attachTagOptions).execute();
            assertNotNull(response);
            assertEquals(response.getStatusCode(), 200);

            TagResults tagResultsResult = response.getResult();
            assertNotNull(tagResultsResult);
            log(String.format("attachTag(access) response:\n%s", tagResultsResult.toString()));

            assertNotNull(tagResultsResult.getResults());
            for (TagResultsItem result : tagResultsResult.getResults()) {
                assertFalse(result.isIsError());
            }

            // Make sure the tag was in fact attached to the resource.
            List<String> tags = getTagNamesForResource(service, resourceCRN, "access");
            assertNotNull(tags);
            log("Resource now has these access tags: " + tags);
            assertTrue(tags.contains(accessTag1));
            assertTrue(tags.contains(accessTag2));
        } catch (ServiceResponseException e) {
            fail(String.format("Service returned status code %d: %s\nError details: %s", e.getStatusCode(),
                    e.getMessage(), e.getDebuggingInfo()));
        }
    }

    @Test(dependsOnMethods = { "testAttachTagAccess" })
    public void testListTagsUser() throws Exception {
        try {
            List<Tag> results = new ArrayList<>();

            // Retrieve the search results 1 page at a time to test the pagination.
            ListTagsOptions listTagsOptions = new ListTagsOptions.Builder()
                    .limit(500)
                    .tagType("user")
                    .build();

            boolean moreResults = true;
            int offset = 0;
            while (moreResults) {
                listTagsOptions = listTagsOptions.newBuilder().offset(offset).build();

                Response<TagList> response = service.listTags(listTagsOptions).execute();
                assertNotNull(response);
                assertEquals(response.getStatusCode(), 200);

                TagList tagListResult = response.getResult();
                assertNotNull(tagListResult);

                if (tagListResult.getItems() != null && tagListResult.getItems().size() > 0) {
                    results.addAll(tagListResult.getItems());
                    offset += tagListResult.getItems().size();
                } else {
                    moreResults = false;
                }
            }
            log(String.format("Retrieved a total of %d user tags.\n", results.size()));

            List<String> matches = new ArrayList<>();
            for (Tag tag : results) {
                if (tag.getName().contains(sdkLabel)) {
                    matches.add(tag.getName());
                }
            }
            log(String.format("Found %d user tags containing our label: %s\n", matches.size(), matches.toString()));
        } catch (ServiceResponseException e) {
            fail(String.format("Service returned status code %d: %s\nError details: %s", e.getStatusCode(),
                    e.getMessage(), e.getDebuggingInfo()));
        }
    }

    @Test(dependsOnMethods = { "testListTagsUser" })
    public void testListTagsAccess() throws Exception {
        try {
            List<Tag> results = new ArrayList<>();

            // Retrieve the search results 1 page at a time to test the pagination.
            ListTagsOptions listTagsOptions = new ListTagsOptions.Builder()
                    .limit(500)
                    .tagType("access")
                    .build();

            boolean moreResults = true;
            int offset = 0;
            while (moreResults) {
                listTagsOptions = listTagsOptions.newBuilder().offset(offset).build();

                Response<TagList> response = service.listTags(listTagsOptions).execute();
                assertNotNull(response);
                assertEquals(response.getStatusCode(), 200);

                TagList tagListResult = response.getResult();
                assertNotNull(tagListResult);

                if (tagListResult.getItems() != null && tagListResult.getItems().size() > 0) {
                    results.addAll(tagListResult.getItems());
                    offset += tagListResult.getItems().size();
                } else {
                    moreResults = false;
                }
            }
            log(String.format("Retrieved a total of %d access tags.\n", results.size()));

            List<String> matches = new ArrayList<>();
            for (Tag tag : results) {
                if (tag.getName().contains(sdkLabel)) {
                    matches.add(tag.getName());
                }
            }
            log(String.format("Found %d access tags containing our label: %s\n", matches.size(), matches.toString()));
        } catch (ServiceResponseException e) {
            fail(String.format("Service returned status code %d: %s\nError details: %s", e.getStatusCode(),
                    e.getMessage(), e.getDebuggingInfo()));
        }
    }

    @Test(dependsOnMethods = { "testListTagsAccess" })
    public void testDetachTagUser() throws Exception {
        try {
            Resource resourceModel = new Resource.Builder()
                    .resourceId(resourceCRN)
                    .build();

            DetachTagOptions detachTagOptions = new DetachTagOptions.Builder()
                    .addResources(resourceModel)
                    .addTagNames(userTag1)
                    .addTagNames(userTag2)
                    .tagType("user")
                    .build();

            Response<TagResults> response = service.detachTag(detachTagOptions).execute();
            assertNotNull(response);
            assertEquals(response.getStatusCode(), 200);

            TagResults tagResultsResult = response.getResult();
            assertNotNull(tagResultsResult);
            log(String.format("detachTag(user) response:\n%s", tagResultsResult.toString()));

            assertNotNull(tagResultsResult.getResults());
            for (TagResultsItem result : tagResultsResult.getResults()) {
                assertFalse(result.isIsError());
            }

            // Make sure the tags were in fact detached from the resource.
            List<String> tags = getTagNamesForResource(service, resourceCRN, "user");
            assertNotNull(tags);
            log("Resource now has these user tags: " + tags);
            assertFalse(tags.contains(userTag1));
            assertFalse(tags.contains(userTag2));
        } catch (ServiceResponseException e) {
            fail(String.format("Service returned status code %d: %s\nError details: %s", e.getStatusCode(),
                    e.getMessage(), e.getDebuggingInfo()));
        }
    }

    @Test(dependsOnMethods = { "testDetachTagUser" })
    public void testDetachTagAccess() throws Exception {
        try {
            Resource resourceModel = new Resource.Builder()
                    .resourceId(resourceCRN)
                    .build();

            DetachTagOptions detachTagOptions = new DetachTagOptions.Builder()
                    .addResources(resourceModel)
                    .addTagNames(accessTag1)
                    .addTagNames(accessTag2)
                    .tagType("access")
                    .build();

            Response<TagResults> response = service.detachTag(detachTagOptions).execute();
            assertNotNull(response);
            assertEquals(response.getStatusCode(), 200);

            TagResults tagResultsResult = response.getResult();
            assertNotNull(tagResultsResult);
            log(String.format("detachTag(access) response:\n%s", tagResultsResult.toString()));

            assertNotNull(tagResultsResult.getResults());
            for (TagResultsItem result : tagResultsResult.getResults()) {
                assertFalse(result.isIsError());
            }

            // Make sure the tags were in fact detached from the resource.
            List<String> tags = getTagNamesForResource(service, resourceCRN, "access");
            assertNotNull(tags);
            log("Resource now has these access tags: " + tags);
            assertFalse(tags.contains(accessTag1));
            assertFalse(tags.contains(accessTag2));
        } catch (ServiceResponseException e) {
            fail(String.format("Service returned status code %d: %s\nError details: %s", e.getStatusCode(),
                    e.getMessage(), e.getDebuggingInfo()));
        }
    }

    @Test(dependsOnMethods = { "testDetachTagAccess" })
    public void testDeleteTagUser() throws Exception {
        try {
            DeleteTagOptions deleteTagOptions = new DeleteTagOptions.Builder()
                    .tagName(userTag1)
                    .tagType("user")
                    .build();

            Response<DeleteTagResults> response = service.deleteTag(deleteTagOptions).execute();
            assertNotNull(response);
            assertEquals(response.getStatusCode(), 200);
            DeleteTagResults deleteTagResults = response.getResult();
            assertNotNull(deleteTagResults);
            log(String.format("deleteTag(user) response:\n%s", deleteTagResults.toString()));

            assertNotNull(deleteTagResults.getResults());
            for (DeleteTagResultsItem result : deleteTagResults.getResults()) {
                assertFalse(result.isIsError());
            }
        } catch (ServiceResponseException e) {
            fail(String.format("Service returned status code %d: %s\nError details: %s", e.getStatusCode(),
                    e.getMessage(), e.getDebuggingInfo()));
        }
    }

    @Test(dependsOnMethods = { "testDeleteTagUser" })
    public void testDeleteTagAccess() throws Exception {
        try {
            DeleteTagOptions deleteTagOptions = new DeleteTagOptions.Builder()
                    .tagName(accessTag1)
                    .tagType("access")
                    .build();

            Response<DeleteTagResults> response = service.deleteTag(deleteTagOptions).execute();
            assertNotNull(response);
            assertEquals(response.getStatusCode(), 200);
            DeleteTagResults deleteTagResults = response.getResult();
            assertNotNull(deleteTagResults);
            log(String.format("deleteTag(user) response:\n%s", deleteTagResults.toString()));

            assertNotNull(deleteTagResults.getResults());
            for (DeleteTagResultsItem result : deleteTagResults.getResults()) {
                assertFalse(result.isIsError());
            }
        } catch (ServiceResponseException e) {
            fail(String.format("Service returned status code %d: %s\nError details: %s", e.getStatusCode(),
                    e.getMessage(), e.getDebuggingInfo()));
        }
    }

    @Test(dependsOnMethods = { "testDeleteTagAccess" })
    public void testDeleteTagAllUser() throws Exception {
        try {
            DeleteTagAllOptions deleteTagAllOptions = new DeleteTagAllOptions.Builder()
                    .tagType("user")
                    .build();

            Response<DeleteTagsResult> response = service.deleteTagAll(deleteTagAllOptions).execute();
            assertNotNull(response);
            assertEquals(response.getStatusCode(), 200);

            DeleteTagsResult deleteTagsResult = response.getResult();
            assertNotNull(deleteTagsResult);
            log(String.format("deleteTagAll(user) response:\n%s", deleteTagsResult.toString()));
            for (DeleteTagsResultItem item : deleteTagsResult.getItems()) {
                assertFalse(item.isIsError());
            }
        } catch (ServiceResponseException e) {
            fail(String.format("Service returned status code %d: %s\nError details: %s", e.getStatusCode(),
                    e.getMessage(), e.getDebuggingInfo()));
        }
    }

    @Test(dependsOnMethods = { "testDeleteTagAllUser" })
    public void testDeleteTagAllAccess() throws Exception {
        try {
            DeleteTagAllOptions deleteTagAllOptions = new DeleteTagAllOptions.Builder()
                    .tagType("access")
                    .build();

            Response<DeleteTagsResult> response = service.deleteTagAll(deleteTagAllOptions).execute();
            assertNotNull(response);
            assertEquals(response.getStatusCode(), 200);

            DeleteTagsResult deleteTagsResult = response.getResult();
            assertNotNull(deleteTagsResult);
            log(String.format("deleteTagAll(access) response:\n%s", deleteTagsResult.toString()));
            for (DeleteTagsResultItem item : deleteTagsResult.getItems()) {
                assertFalse(item.isIsError());
            }
        } catch (ServiceResponseException e) {
            fail(String.format("Service returned status code %d: %s\nError details: %s", e.getStatusCode(),
                    e.getMessage(), e.getDebuggingInfo()));
        }
    }

    private List<String> getTagNamesForResource(GlobalTagging service, String resourceId, String tagType) {
        try {
            ListTagsOptions options = new ListTagsOptions.Builder()
                    .attachedTo(resourceId)
                    .tagType(tagType)
                    .build();
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

    private void deleteTag(GlobalTagging service, String tag, String tagType) {
        DeleteTagOptions deleteTagOptions = new DeleteTagOptions.Builder().tagName(tag).tagType(tagType).build();
        Response<DeleteTagResults> response = service.deleteTag(deleteTagOptions).execute();
        assertNotNull(response);
        assertEquals(response.getStatusCode(), 200);
        DeleteTagResults deleteTagResults = response.getResult();
        assertNotNull(deleteTagResults);
        assertNotNull(deleteTagResults.getResults());
        for (DeleteTagResultsItem result : deleteTagResults.getResults()) {
            assertFalse(result.isIsError());
        }
    }

    private void detachTag(GlobalTagging service, String resourceID, String tag, String tagType) {
        Resource resourceModel = new Resource.Builder().resourceId(resourceCRN).build();
        DetachTagOptions detachTagOptions = new DetachTagOptions.Builder().addResources(resourceModel).addTagNames(tag)
                .tagType(tagType).build();
        Response<TagResults> response = service.detachTag(detachTagOptions).execute();
        assertNotNull(response);
        assertEquals(response.getStatusCode(), 200);
        TagResults tagResultsResult = response.getResult();
        assertNotNull(tagResultsResult);
        assertNotNull(tagResultsResult.getResults());
        for (TagResultsItem result : tagResultsResult.getResults()) {
            assertFalse(result.isIsError());
        }
    }

    private List<String> listTagsWithLabel(GlobalTagging service, String tagType, String label) {
        List<String> tagNames = new ArrayList<>();

        // Retrieve the search results 1 page at a time to test the pagination.
        ListTagsOptions listTagsOptions = new ListTagsOptions.Builder().limit(500).tagType(tagType).build();
        boolean moreResults = true;
        int offset = 0;
        while (moreResults) {
            listTagsOptions = listTagsOptions.newBuilder().offset(offset).build();
            Response<TagList> response = service.listTags(listTagsOptions).execute();
            assertNotNull(response);
            assertEquals(response.getStatusCode(), 200);
            TagList tagListResult = response.getResult();
            assertNotNull(tagListResult);

            if (tagListResult.getItems() != null && tagListResult.getItems().size() > 0) {
                List<String> tagsContainingLabel = tagListResult.getItems().stream()
                        .map(t -> t.getName()).filter(n -> n.contains(sdkLabel)).collect(Collectors.toList());
                tagNames.addAll(tagsContainingLabel);
                offset += tagListResult.getItems().size();
            } else {
                moreResults = false;
            }
        }

        return tagNames;
    }

    private void cleanTags(GlobalTagging service) {
        // Detach all user and access tags that contain our label.
        List<String> tags;

        tags = getTagNamesForResource(service, resourceCRN, "user");
        for (String tag : tags) {
            if (tag.contains(sdkLabel)) {
                detachTag(service, resourceCRN, tag, "user");
                log(String.format("Detached user tag %s from resource %s", tag, resourceCRN));
            }
        }
        tags = getTagNamesForResource(service, resourceCRN, "user");
        log(String.format("Resource now has these user tags: %s", tags));

        tags = getTagNamesForResource(service, resourceCRN, "access");
        for (String tag : tags) {
            if (tag.contains(sdkLabel)) {
                detachTag(service, resourceCRN, tag, "access");
                log(String.format("Detached access tag %s from resource %s", tag, resourceCRN));
            }
        }
        tags = getTagNamesForResource(service, resourceCRN, "access");
        log(String.format("Resource now has these access tags: %s", tags));

        // Delete all user and access tags that contain our label.
        tags = listTagsWithLabel(service, "user", sdkLabel);
        log(String.format("Found %d user tag(s) that contain our label.", tags.size()));
        for (String tag : tags) {
            deleteTag(service, tag, "user");
            log(String.format("Deleted user tag: %s", tag));
        }

        tags = listTagsWithLabel(service, "access", sdkLabel);
        log(String.format("Found %d access tag(s) that contain our label.", tags.size()));
        for (String tag : tags) {
            deleteTag(service, tag, "access");
            log(String.format("Deleted access tag: %s", tag));
        }
    }
}
