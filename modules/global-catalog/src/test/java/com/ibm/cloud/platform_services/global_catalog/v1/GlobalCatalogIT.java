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

package com.ibm.cloud.platform_services.global_catalog.v1;

import static org.testng.Assert.*;
import static org.testng.AssertJUnit.assertNotNull;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Arrays;
import java.util.List;

import org.testng.annotations.*;

import com.ibm.cloud.platform_services.test.SdkIntegrationTestBase;
import com.ibm.cloud.platform_services.global_catalog.v1.model.*;
import com.ibm.cloud.sdk.core.service.exception.NotFoundException;
import com.ibm.cloud.sdk.core.service.exception.ConflictException;
import com.ibm.cloud.sdk.core.service.exception.ForbiddenException;
import com.ibm.cloud.sdk.core.http.Response;

/**
 * Integration test class for the GlobalCatalog service.
 */
public class GlobalCatalogIT extends SdkIntegrationTestBase {
    GlobalCatalog service = null;

    private static final long timestamp = System.currentTimeMillis() / 1000L;
    private static final String id = String.format("someId%d", timestamp);
    private static final String idChild = String.format("someChildId%d", timestamp);
    private static final String name = String.format("someName%d", timestamp);
    private static final String nameUpdated = String.format("someNameUpdated%d", timestamp);
    private static final String nameChild = String.format("someChildName%d", timestamp);
    private static final String kind = "service";
    private static final Boolean active = false;
    private static final Boolean disabled = false;
    private static final String artifactId = "someArtifactId.json";
    private static final byte[] artifact = "This is a simulated artifact".getBytes();
    private static final String visibilityRestriction = "private";

    CreateCatalogEntryOptions defaultCreate;
    CreateCatalogEntryOptions defaultChild;
    DeleteCatalogEntryOptions defaultDelete;
    GetCatalogEntryOptions defaultGet;
    UpdateCatalogEntryOptions defaultUpdate;
    RestoreCatalogEntryOptions defaultRestore;
    RestoreCatalogEntryOptions bogusRestore;
    GetChildObjectsOptions getChild;
    GetVisibilityOptions getVisibility;
    UpdateVisibilityOptions updateVisibility;
    GetPricingOptions getPricing;
    ListArtifactsOptions listArtifacts;
    UploadArtifactOptions uploadArtifact;
    GetArtifactOptions getArtifact;
    DeleteArtifactOptions deleteArtifact;

    public String getConfigFilename() {
        return "../../global_catalog.env";
    }

    @BeforeClass
    public void constructService() {
        if (skipTests()) {
            return;
        }

        service = GlobalCatalog.newInstance();
        assertNotNull(service);
        assertNotNull(service.getServiceUrl());

        List<String> tags = Arrays.asList("a", "b", "c");
        List<String> tagsUpdated = Arrays.asList("x", "y", "z");
        Overview overviewValueDefault = new Overview.Builder()
                .displayName("display")
                .longDescription("long")
                .description("desc")
                .build();
        Overview overviewValueUpdated = new Overview.Builder()
                .displayName("displayUpdated")
                .longDescription("longUpdated")
                .description("descUpdated")
                .build();
        OverviewUI overview = new OverviewUI();
        OverviewUI overviewUpdated = new OverviewUI();
        overview.put("en", overviewValueDefault);
        overviewUpdated.put("en", overviewValueUpdated);
        Image image = new Image.Builder()
                .image("image")
                .smallImage("small")
                .mediumImage("medium")
                .featureImage("feature")
                .build();
        Image imageUpdated = new Image.Builder()
                .image("imageUpdated")
                .smallImage("smallUpdated")
                .mediumImage("mediumUpdated")
                .featureImage("featureUpdated")
                .build();
        Provider provider = new Provider.Builder().email("bogus@us.ibm.com").name("someName").build();
        Provider providerUpdated = new Provider.Builder().email("bogus@us.ibm.com").name("someNameUpdated").build();

        defaultCreate = new CreateCatalogEntryOptions.Builder()
                .id(id)
                .name(name)
                .active(active)
                .kind(kind)
                .disabled(disabled)
                .overviewUi(overview)
                .images(image)
                .tags(tags)
                .provider(provider)
                .build();
        defaultDelete = new DeleteCatalogEntryOptions.Builder().id(id).force(true).build();
        defaultGet = new GetCatalogEntryOptions.Builder().id(id).build();
        defaultUpdate = new UpdateCatalogEntryOptions.Builder()
                .id(id)
                .name(nameUpdated)
                .active(active)
                .kind(kind)
                .disabled(disabled)
                .overviewUi(overviewUpdated)
                .images(imageUpdated)
                .tags(tagsUpdated)
                .provider(providerUpdated)
                .build();
        defaultChild = new CreateCatalogEntryOptions.Builder()
                .id(idChild)
                .name(nameChild)
                .parentId(id)
                .active(active)
                .kind(kind)
                .disabled(disabled)
                .overviewUi(overview)
                .images(image)
                .tags(tags)
                .provider(provider)
                .build();
        getChild = new GetChildObjectsOptions.Builder().id(idChild).kind(kind).build();
        defaultRestore = new RestoreCatalogEntryOptions.Builder().id(id).build();
        bogusRestore = new RestoreCatalogEntryOptions.Builder().id("bogus").build();
        getVisibility = new GetVisibilityOptions.Builder().id(defaultCreate.id()).build();
        updateVisibility = new UpdateVisibilityOptions.Builder().id(defaultCreate.id()).build();
        getPricing = new GetPricingOptions.Builder().id(defaultCreate.id()).build();
        listArtifacts = new ListArtifactsOptions.Builder().objectId(defaultCreate.id()).build();
        uploadArtifact = new UploadArtifactOptions.Builder()
                .objectId(defaultCreate.id())
                .artifactId(artifactId)
                .artifact(new ByteArrayInputStream(artifact))
                .contentType("text/plain")
                .build();
        getArtifact = new GetArtifactOptions.Builder()
                .objectId(defaultCreate.id())
                .artifactId(artifactId)
                .build();
        deleteArtifact = new DeleteArtifactOptions.Builder()
                .objectId(defaultCreate.id())
                .artifactId(artifactId)
                .build();
    }

    @BeforeMethod
    public void beforeTest() {
        service.deleteCatalogEntry(defaultDelete).execute();
    }

    @AfterMethod
    public void afterTest() {
        service.deleteCatalogEntry(defaultDelete).execute();
    }

    @Test
    public void testCreateCatalogEntry() {
        Response<CatalogEntry> response = service.createCatalogEntry(defaultCreate).execute();
        assertNotNull(response);
        assertEquals(response.getStatusCode(), 201);

        CatalogEntry result = response.getResult();
        assertNotNull(result);
        assertEquals(result.getId(), defaultCreate.id());
        assertEquals(result.getName(), defaultCreate.name());
        assertEquals(result.getKind(), defaultCreate.kind());
        assertEquals(result.getImages(), defaultCreate.images());
        assertEquals(result.getTags(), defaultCreate.tags());
        assertEquals(result.getProvider(), defaultCreate.provider());
    }

    @Test(dependsOnMethods = { "testCreateCatalogEntry" })
    public void testGetCatalogEntry() {
        service.createCatalogEntry(defaultCreate).execute();
        Response<CatalogEntry> response = service.getCatalogEntry(defaultGet).execute();
        assertNotNull(response);
        assertEquals(response.getStatusCode(), 200);

        CatalogEntry result = response.getResult();
        assertNotNull(result);
        assertEquals(result.getId(), defaultCreate.id());
        assertEquals(result.getName(), defaultCreate.name());
        assertEquals(result.getKind(), defaultCreate.kind());
        assertEquals(result.getImages(), defaultCreate.images());
        assertEquals(result.getTags(), defaultCreate.tags());
        assertEquals(result.getProvider(), defaultCreate.provider());
    }

    @Test(dependsOnMethods = { "testGetCatalogEntry" })
    public void testUpdateCatalogEntry() {
        service.createCatalogEntry(defaultCreate).execute();
        Response<CatalogEntry> response = service.updateCatalogEntry(defaultUpdate).execute();
        assertNotNull(response);
        assertEquals(response.getStatusCode(), 200);

        CatalogEntry result = response.getResult();
        assertNotNull(result);
        assertEquals(result.getId(), defaultUpdate.id());
        assertEquals(result.getName(), defaultUpdate.name());
        assertEquals(result.getKind(), defaultUpdate.kind());
        assertEquals(result.getImages(), defaultUpdate.images());
        assertEquals(result.getTags(), defaultUpdate.tags());
        assertEquals(result.getProvider(), defaultUpdate.provider());
    }

    @Test(dependsOnMethods = { "testUpdateCatalogEntry" })
    public void testDeleteCatalogEntry() {
        service.createCatalogEntry(defaultCreate).execute();
        Response<Void> response = service.deleteCatalogEntry(defaultDelete).execute();
        assertNotNull(response);
        assertEquals(response.getStatusCode(), 200);
    }

    @Test(dependsOnMethods = { "testDeleteCatalogEntry" })
    public void testGetCatalogEntryAfterDeleteFailure() {
        service.createCatalogEntry(defaultCreate).execute();
        service.deleteCatalogEntry(defaultDelete).execute();

        try {
            service.getCatalogEntry(defaultGet).execute();
            fail("Expected exception.");
        } catch (NotFoundException e) {
            assertEquals(e.getStatusCode(), 404);
        }
    }

    @Test(dependsOnMethods = { "testDeleteCatalogEntry" })
    public void testGetCatalogEntryFailure() {
        try {
            service.getCatalogEntry(defaultGet).execute();
            fail("Expected NotFoundException.");
        } catch (NotFoundException e) {
            assertEquals(e.getStatusCode(), 404);
        }
    }

    @Test(dependsOnMethods = { "testDeleteCatalogEntry" })
    public void testDeleteCatalogEntryFailure() {
        service.createCatalogEntry(defaultCreate).execute();
        Response<Void> response = service.deleteCatalogEntry(defaultDelete).execute();
        assertNotNull(response);
        assertEquals(response.getStatusCode(), 200);
    }

    @Test(dependsOnMethods = { "testUpdateCatalogEntry" })
    public void testUpdateCatalogEntryFailure() {
        try {
            service.updateCatalogEntry(defaultUpdate).execute();
            fail("Expected NotFoundException.");
        } catch (NotFoundException e) {
            assertEquals(e.getStatusCode(), 404);
        }
    }

    @Test(dependsOnMethods = { "testUpdateCatalogEntryFailure" })
    public void testCreateCatalogEntryFailure() {
        service.createCatalogEntry(defaultCreate).execute();

        try {
            service.createCatalogEntry(defaultCreate).execute();
            fail("Expected ConflictException.");
        } catch (ConflictException e) {
            assertEquals(e.getStatusCode(), 409);
        }
    }

    @Ignore
    @Test
    public void testListCatalogEntries() {
        Response<EntrySearchResult> response = service.listCatalogEntries().execute();
        assertNotNull(response);
        assertEquals(response.getStatusCode(), 200);

        EntrySearchResult result = response.getResult();
        assertNotNull(result);
        assertNotNull(result.getResources());
        assertTrue(result.getResources().size() > 0);
    }

    @Ignore
    @Test
    public void testGetChildObjects() {
        service.createCatalogEntry(defaultCreate).execute();
        service.createCatalogEntry(defaultChild).execute();
        Response<EntrySearchResult> response = service.getChildObjects(getChild).execute();
        assertNotNull(response);
        assertEquals(response.getStatusCode(), 200);

        EntrySearchResult result = response.getResult();
        assertNotNull(result);
        assertEquals(result.getResourceCount(), Long.valueOf(1));
        System.out.println(result.getResources().get(0));
    }

    @Test
    public void testGetChildObjectsFailure() {
        try {
            service.getChildObjects(getChild).execute();
            fail("Expected NotFoundException.");
        } catch (NotFoundException e) {
            assertEquals(e.getStatusCode(), 404);
        }
    }

    @Ignore
    @Test
    public void testRestoreCatalogEntry() {
        service.createCatalogEntry(defaultCreate).execute();
        service.deleteCatalogEntry(defaultDelete).execute();
        Response<Void> restoreResponse = service.restoreCatalogEntry(defaultRestore).execute();
        assertNotNull(restoreResponse);
        assertEquals(restoreResponse.getStatusCode(), 200);

        Response<CatalogEntry> getResponse = service.getCatalogEntry(defaultGet).execute();
        assertNotNull(getResponse);
        assertEquals(getResponse.getStatusCode(), 200);

        CatalogEntry result = getResponse.getResult();
        assertNotNull(result);
        assertEquals(result.getId(), defaultCreate.id());
        assertEquals(result.getName(), defaultCreate.name());
        assertEquals(result.getKind(), defaultCreate.kind());
        assertEquals(result.getImages(), defaultCreate.images());
        assertEquals(result.getTags(), defaultCreate.tags());
        assertEquals(result.getProvider(), defaultCreate.provider());
    }

    @Test
    public void testRestoreCatalogEntryFailure() {
        try {
            service.restoreCatalogEntry(bogusRestore).execute();
            fail("Expected NotFoundException.");
        } catch (NotFoundException e) {
            assertEquals(e.getStatusCode(), 404);
        }
    }

    @Test
    public void testGetVisibility() {
        service.createCatalogEntry(defaultCreate).execute();
        Response<Visibility> response = service.getVisibility(getVisibility).execute();
        assertNotNull(response);
        assertEquals(response.getStatusCode(), 200);

        Visibility result = response.getResult();
        assertNotNull(result);
        assertEquals(result.restrictions(), visibilityRestriction);
    }

    @Test
    public void testGetVisibilityFailure() {
        try {
            service.getVisibility(getVisibility).execute();
            fail("Expected NotFoundException.");
        } catch (NotFoundException e) {
            assertEquals(e.getStatusCode(), 404);
        }
    }

    @Test
    public void testUpdateVisibility() {
        service.createCatalogEntry(defaultCreate).execute();

        try {
            service.updateVisibility(updateVisibility).execute();
            fail("Expected ForbiddenException.");
        } catch (ForbiddenException e) {
            assertEquals(e.getStatusCode(), 403);
        }
    }

    @Test
    public void testUpdateVisibilityFailure() {
        try {
            service.updateVisibility(updateVisibility).execute();
            fail("Expected NotFoundException.");
        } catch (NotFoundException e) {
            assertEquals(e.getStatusCode(), 404);
        }
    }

    @Test
    public void testGetPricingFailure() {
        service.createCatalogEntry(defaultCreate).execute();

        try {
            service.getPricing(getPricing).execute();
            fail("Expected NotFoundException.");
        } catch (NotFoundException e) {
            assertEquals(e.getStatusCode(), 404);
        }

        service.deleteCatalogEntry(defaultDelete).execute();

        try {
            service.getPricing(getPricing).execute();
            fail("Expected NotFoundException.");
        } catch (NotFoundException e) {
            assertEquals(e.getStatusCode(), 404);
        }
    }

    @Ignore
    @Test
    public void testListArtifacts() {
        service.createCatalogEntry(defaultCreate).execute();
        service.uploadArtifact(uploadArtifact).execute();
        Response<Artifacts> response = service.listArtifacts(listArtifacts).execute();
        assertNotNull(response);
        assertEquals(response.getStatusCode(), 200);

        Artifacts result = response.getResult();
        assertNotNull(result);
        assertEquals(result.getCount().intValue(), 1);

        List<Artifact> resources = result.getResources();
        assertNotNull(resources);
        assertEquals(resources.size(), 1);
        assertEquals(resources.get(0).getName(), uploadArtifact.artifactId());
        assertEquals(resources.get(0).getUrl(), String.format("%s/%s/artifacts/%s", service.getServiceUrl(), defaultCreate.id(), uploadArtifact.artifactId()));
        assertEquals(resources.get(0).getSize().intValue(), 23); // TODO: busted always returns a value for 4???
    }

    @Test
    public void testListArtifactsFailure() {
        Response<Artifacts> response = service.listArtifacts(listArtifacts).execute();
        assertNotNull(response);
        assertEquals(response.getStatusCode(), 200);

        Artifacts result = response.getResult();
        assertNotNull(result);
        assertEquals(result.getCount().intValue(), 0);
    }

    @Test
    public void testGetArtifacts() {
        service.createCatalogEntry(defaultCreate).execute();
        service.uploadArtifact(uploadArtifact).execute();
        Response<InputStream> response = service.getArtifact(getArtifact).execute();
        assertNotNull(response);
        assertEquals(response.getStatusCode(), 200);
        // TODO can't assert that 2 input streams are equal.
        // Will need to read the bytes in each one and compare that.
        // assertEquals(response.getResult(), uploadArtifact.artifact());
    }

    @Test
    public void testGetArtifactFailure() {
        service.createCatalogEntry(defaultCreate).execute();

        try {
            service.getArtifact(getArtifact).execute();
            fail("Expected NotFoundException.");
        } catch (NotFoundException e) {
            assertEquals(e.getStatusCode(), 404);
        }

        service.deleteCatalogEntry(defaultDelete);

        try {
            service.getArtifact(getArtifact).execute();
            fail("Expected NotFoundException.");
        } catch (NotFoundException e) {
            assertEquals(e.getStatusCode(), 404);
        }
    }

    @Test
    public void testCreateArtifact() {
        service.createCatalogEntry(defaultCreate).execute();
        Response<Void> response = service.uploadArtifact(uploadArtifact).execute();
        assertNotNull(response);
        assertEquals(response.getStatusCode(), 200);
    }

    @Test
    public void testCreateArtifactFailure() {
        try {
            service.uploadArtifact(uploadArtifact).execute();
            fail("Expected NotFoundException.");
        } catch (NotFoundException e) {
            assertEquals(e.getStatusCode(), 404);
        }
    }

    @Test
    public void testDeleteArtifact() {
        service.createCatalogEntry(defaultCreate).execute();
        service.uploadArtifact(uploadArtifact).execute();
        Response<Void> response = service.deleteArtifact(deleteArtifact).execute();
        assertNotNull(response);
        assertEquals(response.getStatusCode(), 200);
    }

    @Test
    public void testDeleteArtifactFailure() {
        try {
            service.deleteArtifact(deleteArtifact).execute();
            fail("Expected NotFoundException.");
        } catch (NotFoundException e) {
            assertEquals(e.getStatusCode(), 404);
        }
    }
}