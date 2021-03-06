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

package com.ibm.cloud.platform_services.catalog_management.v1;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertNotEquals;
import static org.testng.Assert.assertNull;
import static org.testng.Assert.assertTrue;
import static org.testng.Assert.fail;
import static org.testng.AssertJUnit.assertNotNull;

import java.util.List;
import java.util.Map;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

import com.ibm.cloud.platform_services.catalog_management.v1.model.Account;
import com.ibm.cloud.platform_services.catalog_management.v1.model.AccumulatedFilters;
import com.ibm.cloud.platform_services.catalog_management.v1.model.Catalog;
import com.ibm.cloud.platform_services.catalog_management.v1.model.CatalogSearchResult;
import com.ibm.cloud.platform_services.catalog_management.v1.model.CreateCatalogOptions;
import com.ibm.cloud.platform_services.catalog_management.v1.model.CreateOfferingOptions;
import com.ibm.cloud.platform_services.catalog_management.v1.model.DeleteCatalogOptions;
import com.ibm.cloud.platform_services.catalog_management.v1.model.DeleteOfferingOptions;
import com.ibm.cloud.platform_services.catalog_management.v1.model.DeleteVersionOptions;
import com.ibm.cloud.platform_services.catalog_management.v1.model.GetCatalogOptions;
import com.ibm.cloud.platform_services.catalog_management.v1.model.GetOfferingOptions;
import com.ibm.cloud.platform_services.catalog_management.v1.model.GetVersionAboutOptions;
import com.ibm.cloud.platform_services.catalog_management.v1.model.GetVersionOptions;
import com.ibm.cloud.platform_services.catalog_management.v1.model.GetVersionUpdatesOptions;
import com.ibm.cloud.platform_services.catalog_management.v1.model.ImportOfferingOptions;
import com.ibm.cloud.platform_services.catalog_management.v1.model.ImportOfferingVersionOptions;
import com.ibm.cloud.platform_services.catalog_management.v1.model.LicenseEntitlements;
import com.ibm.cloud.platform_services.catalog_management.v1.model.LicenseProviders;
import com.ibm.cloud.platform_services.catalog_management.v1.model.ListLicenseEntitlementsOptions;
import com.ibm.cloud.platform_services.catalog_management.v1.model.ListOfferingsOptions;
import com.ibm.cloud.platform_services.catalog_management.v1.model.Offering;
import com.ibm.cloud.platform_services.catalog_management.v1.model.OfferingSearchResult;
import com.ibm.cloud.platform_services.catalog_management.v1.model.ReloadOfferingOptions;
import com.ibm.cloud.platform_services.catalog_management.v1.model.ReplaceCatalogOptions;
import com.ibm.cloud.platform_services.catalog_management.v1.model.ReplaceOfferingOptions;
import com.ibm.cloud.platform_services.catalog_management.v1.model.SearchLicenseOfferingsOptions;
import com.ibm.cloud.platform_services.catalog_management.v1.model.SearchLicenseVersionsOptions;
import com.ibm.cloud.platform_services.catalog_management.v1.model.VersionUpdateDescriptor;
import com.ibm.cloud.platform_services.test.SdkIntegrationTestBase;
import com.ibm.cloud.sdk.core.http.Response;
import com.ibm.cloud.sdk.core.service.exception.ForbiddenException;
import com.ibm.cloud.sdk.core.service.exception.NotFoundException;
import com.ibm.cloud.sdk.core.util.CredentialUtils;

/**
 * Integration test class for the CatalogManagement service.
 */
public class CatalogManagementIT extends SdkIntegrationTestBase {
    CatalogManagement service = null;

    private static final long timestamp = System.currentTimeMillis() / 1000L;
    private static final String expectedLabel = String.format("integration-test-%d", timestamp);
    private static final String expectedAccount = "67d27f28d43948b2b3bda9138f251a13";
    private static final String expectedShortDesc = "test";
    private static final String expectedURL = "https://cm.globalcatalog.test.cloud.ibm.com/api/v1-beta/catalogs/%s";
    private static final String expectedOfferingsURL = "https://cm.globalcatalog.test.cloud.ibm.com/api/v1-beta/catalogs/%s/offerings";
    private static final String fakeName = "bogus";
    private static final String fakeVersionLocator = "bogus.bogus";
    private static final String expectedOfferingName = "test-offering";
    private static final String expectedOfferingURL  = "https://cm.globalcatalog.test.cloud.ibm.com/api/v1-beta/catalogs/%s/offerings/%s";

    private String gitToken;

    @Override
    public String getConfigFilename() {
        return "../../catalog_mgmt.env";
    }

    @Override
    public boolean loggingEnabled() {
        return false;
    }

    @BeforeClass
    public void constructService() {
        if (skipTests()) {
            return;
        }

        service = CatalogManagement.newInstance();
        assertNotNull(service);
        assertNotNull(service.getServiceUrl());

        Map<String, String> config = CredentialUtils.getServiceProperties(CatalogManagement.DEFAULT_SERVICE_NAME);

        gitToken = config.get("GIT_TOKEN");
        assertNotNull(gitToken);
    }

    @BeforeMethod
    public void beforeTest() {
        Response<CatalogSearchResult> response = service.listCatalogs().execute();

        if (response.getResult().getResources() != null) {
            for (int i = 0; i < response.getResult().getResources().size(); i++) {
                if (response.getResult().getResources().get(i).label().equals(expectedLabel)) {
                    String id = response.getResult().getResources().get(i).id();
                    DeleteCatalogOptions deleteOptions = new DeleteCatalogOptions.Builder().catalogIdentifier(id).build();
                    service.deleteCatalog(deleteOptions).execute();
                }
            }
        }
    }

    @AfterMethod
    public void afterTest() {
        Response<CatalogSearchResult> response = service.listCatalogs().execute();

        if (response.getResult().getResources() != null) {
            for (int i = 0; i < response.getResult().getResources().size(); i++) {
                if (response.getResult().getResources().get(i).label().equals(expectedLabel)) {
                    String id = response.getResult().getResources().get(i).id();
                    DeleteCatalogOptions deleteOptions = new DeleteCatalogOptions.Builder().catalogIdentifier(id).build();
                    service.deleteCatalog(deleteOptions).execute();
                }
            }
        }
    }

    @Test
    public void testGetCatalogAccount() {
        Response<Account> response = service.getCatalogAccount().execute();
        Account result = response.getResult();

        assertNotNull(result);
        assertEquals(response.getStatusCode(), 200);
        assertEquals(result.id(), expectedAccount);
        assertTrue(result.accountFilters().includeAll());
        assertEquals(result.accountFilters().categoryFilters(), null);
        assertEquals(result.accountFilters().idFilters().include(), null);
        assertEquals(result.accountFilters().idFilters().exclude(), null);
    }

    @Test
    public void testGetCatalogAccountFilters() {
        Response<AccumulatedFilters> response = service.getCatalogAccountFilters().execute();
        AccumulatedFilters result = response.getResult();

        assertNotNull(result);
        assertEquals(response.getStatusCode(), 200);
        assertTrue(result.getAccountFilters().get(0).includeAll());
        assertEquals(result.getAccountFilters().get(0).categoryFilters(), null);
        assertEquals(result.getAccountFilters().get(0).idFilters().include(), null);
        assertEquals(result.getAccountFilters().get(0).idFilters().exclude(), null);
    }

    @Test
    public void testListCatalogs() {
        int catalogCount = 0;
        int catalogIndex = -1;

        CreateCatalogOptions createOptions = new CreateCatalogOptions.Builder().label(expectedLabel).shortDescription(expectedShortDesc).build();
        Response<Catalog> createResponse = service.createCatalog(createOptions).execute();
        Catalog createResult = createResponse.getResult();

        Response<CatalogSearchResult> listResponse = service.listCatalogs().execute();
        CatalogSearchResult result = listResponse.getResult();

        if (result != null) {
            for (int i = 0; i < result.getResources().size(); i++) {
                if (result.getResources().get(i).label().equals(expectedLabel)) {
                    catalogCount++;
                    catalogIndex = i;
                }
            }
        }

        DeleteCatalogOptions deleteOptions = new DeleteCatalogOptions.Builder().catalogIdentifier(createResult.id()).build();
        service.deleteCatalog(deleteOptions).execute();

        assertNotNull(result);
        assertEquals(listResponse.getStatusCode(), 200);
        assertEquals(result.getOffset(), Long.valueOf(0));
        assertEquals(result.getLimit(), Long.valueOf(0));
        assertEquals(catalogCount, 1);
        assertEquals(result.getLast(), null);
        assertEquals(result.getPrev(), null);
        assertEquals(result.getNext(), null);

        assertEquals(result.getResources().get(catalogIndex).label(), expectedLabel);
        assertEquals(result.getResources().get(catalogIndex).shortDescription(), expectedShortDesc);
        assertEquals(result.getResources().get(catalogIndex).url(), String.format(expectedURL, createResult.id()));
        assertEquals(result.getResources().get(catalogIndex).offeringsUrl(), String.format(expectedOfferingsURL, createResult.id()));
        assertEquals(result.getResources().get(catalogIndex).owningAccount(), expectedAccount);
        assertFalse(result.getResources().get(catalogIndex).catalogFilters().includeAll());
        assertEquals(result.getResources().get(catalogIndex).catalogFilters().categoryFilters(), null);
        assertEquals(result.getResources().get(catalogIndex).catalogFilters().idFilters().include(), null);
        assertEquals(result.getResources().get(catalogIndex).catalogFilters().idFilters().exclude(), null);
    }

    @Test
    public void testCreateCatalog() {
        CreateCatalogOptions createOptions = new CreateCatalogOptions.Builder().label(expectedLabel).shortDescription(expectedShortDesc).build();
        Response<Catalog> response = service.createCatalog(createOptions).execute();
        Catalog result = response.getResult();

        DeleteCatalogOptions deleteOptions = new DeleteCatalogOptions.Builder().catalogIdentifier(result.id()).build();
        service.deleteCatalog(deleteOptions).execute();

        assertNotNull(result);
        assertEquals(response.getStatusCode(), 201);
        assertEquals(result.label(), expectedLabel);
        assertEquals(result.shortDescription(), expectedShortDesc);
        assertEquals(result.url(), String.format(expectedURL, result.id()));
        assertEquals(result.offeringsUrl(), String.format(expectedOfferingsURL, result.id()));
        assertEquals(result.owningAccount(), expectedAccount);
        assertFalse(result.catalogFilters().includeAll());
        assertEquals(result.catalogFilters().categoryFilters(), null);
        assertEquals(result.catalogFilters().idFilters().include(), null);
        assertEquals(result.catalogFilters().idFilters().exclude(), null);

        log("createCatalog() result:\n" + result.toString());
    }

    @Test
    public void testGetCatalog() {
        CreateCatalogOptions createOptions = new CreateCatalogOptions.Builder().label(expectedLabel).shortDescription(expectedShortDesc).build();
        Response<Catalog> createResponse = service.createCatalog(createOptions).execute();
        Catalog createResult = createResponse.getResult();

        GetCatalogOptions getOptions = new GetCatalogOptions.Builder().catalogIdentifier(createResult.id()).build();
        Response<Catalog> getResponse = service.getCatalog(getOptions).execute();
        Catalog getResult = getResponse.getResult();

        DeleteCatalogOptions deleteOptions = new DeleteCatalogOptions.Builder().catalogIdentifier(createResult.id()).build();
        service.deleteCatalog(deleteOptions).execute();

        assertNotNull(getResult);
        assertEquals(getResponse.getStatusCode(), 200);
        assertEquals(getResult.label(), expectedLabel);
        assertEquals(getResult.shortDescription(), expectedShortDesc);
        assertEquals(getResult.url(), String.format(expectedURL, getResult.id()));
        assertEquals(getResult.offeringsUrl(), String.format(expectedOfferingsURL, getResult.id()));
        assertEquals(getResult.owningAccount(), expectedAccount);
        assertFalse(getResult.catalogFilters().includeAll());
        assertEquals(getResult.catalogFilters().categoryFilters(), null);
        assertEquals(getResult.catalogFilters().idFilters().include(), null);
        assertEquals(getResult.catalogFilters().idFilters().exclude(), null);
    }

    @Test(expectedExceptions = {NotFoundException.class})
    public void testGetCatalogFailure() {
        GetCatalogOptions getOptions = new GetCatalogOptions.Builder().catalogIdentifier(fakeName).build();
        service.getCatalog(getOptions).execute();
    }

    @Test
    public void testUpdateCatalog() {
        final String expectedLabelUpdated = "test2";
        final String expectedShortDescUpdated = "integration-test-update";

        CreateCatalogOptions createOptions = new CreateCatalogOptions.Builder().label(expectedLabel).shortDescription(expectedShortDesc).build();
        Response<Catalog> createResponse = service.createCatalog(createOptions).execute();
        Catalog createResult = createResponse.getResult();

        ReplaceCatalogOptions replaceOptions = new ReplaceCatalogOptions.Builder().catalogIdentifier(createResult.id()).id(createResult.id()).label(expectedLabelUpdated).shortDescription(expectedShortDescUpdated).build();
        Response<Catalog> replaceResponse = service.replaceCatalog(replaceOptions).execute();
        Catalog replaceResult = replaceResponse.getResult();

        DeleteCatalogOptions deleteOptions = new DeleteCatalogOptions.Builder().catalogIdentifier(createResult.id()).build();
        service.deleteCatalog(deleteOptions).execute();

        assertNotNull(replaceResult);
        assertEquals(replaceResponse.getStatusCode(), 200);
        assertEquals(replaceResult.label(), expectedLabelUpdated);
        assertEquals(replaceResult.shortDescription(), expectedShortDescUpdated);
        // assertEquals(replaceResult.url(), String.format(expectedURL, replaceResult.id()));
        // assertEquals(replaceResult.offeringsUrl(), String.format(expectedOfferingsURL, replaceResult.id()));
        // assertEquals(replaceResult.owningAccount(), expectedAccount);
        assertTrue(replaceResult.catalogFilters().includeAll());
        assertEquals(replaceResult.catalogFilters().categoryFilters(), null);
        assertEquals(replaceResult.catalogFilters().idFilters().include(), null);
        assertEquals(replaceResult.catalogFilters().idFilters().exclude(), null);
    }

    @Test(expectedExceptions = {NotFoundException.class})
    public void testUpdateCatalogFailure() {
        ReplaceCatalogOptions replaceOptions = new ReplaceCatalogOptions.Builder().catalogIdentifier(fakeName).id(fakeName).build();
        service.replaceCatalog(replaceOptions).execute();
    }

    @Test
    public void testDeleteCatalog() {
        CreateCatalogOptions createOptions = new CreateCatalogOptions.Builder().label(expectedLabel).shortDescription(expectedShortDesc).build();
        Response<Catalog> createResponse = service.createCatalog(createOptions).execute();
        Catalog createResult = createResponse.getResult();

        DeleteCatalogOptions deleteOptions = new DeleteCatalogOptions.Builder().catalogIdentifier(createResult.id()).build();
        Response<Void> deleteResponse = service.deleteCatalog(deleteOptions).execute();

        assertNotNull(deleteResponse);
        assertEquals(deleteResponse.getStatusCode(), 200);
    }

    @Test
    public void testDeleteCatalogFailure() {
        DeleteCatalogOptions deleteOptions = new DeleteCatalogOptions.Builder().catalogIdentifier(fakeName).build();
        Response<Void> response = service.deleteCatalog(deleteOptions).execute();

        assertNotNull(response);
        assertEquals(response.getStatusCode(), 200);
    }

    @Test
    public void testCreateOffering() {
        CreateCatalogOptions catalogOptions = new CreateCatalogOptions.Builder().label(expectedLabel).shortDescription(expectedShortDesc).build();
        Response<Catalog> catalogResponse = service.createCatalog(catalogOptions).execute();
        Catalog catalogResult = catalogResponse.getResult();

        CreateOfferingOptions offeringOptions = new CreateOfferingOptions.Builder().catalogIdentifier(catalogResult.id()).name(expectedOfferingName).label(expectedLabel).build();
        Response<Offering> offeringResponse = service.createOffering(offeringOptions).execute();
        Offering offeringResult = offeringResponse.getResult();

        DeleteCatalogOptions deleteOptions = new DeleteCatalogOptions.Builder().catalogIdentifier(catalogResult.id()).build();
        service.deleteCatalog(deleteOptions).execute();

        assertNotNull(offeringResponse);
        assertEquals(offeringResponse.getStatusCode(), 201);
        assertEquals(offeringResult.name(), expectedOfferingName);
        assertEquals(offeringResult.url(), String.format(expectedOfferingURL, catalogResult.id(), offeringResult.id()));
        assertEquals(offeringResult.label(), expectedLabel);
    }


    @Test
    public void testGetOffering() {
        CreateCatalogOptions catalogOptions = new CreateCatalogOptions.Builder().label(expectedLabel).shortDescription(expectedShortDesc).build();
        Response<Catalog> catalogResponse = service.createCatalog(catalogOptions).execute();
        Catalog catalogResult = catalogResponse.getResult();

        CreateOfferingOptions offeringOptions = new CreateOfferingOptions.Builder().catalogIdentifier(catalogResult.id()).name(expectedOfferingName).label(expectedLabel).build();
        Response<Offering> offeringResponse = service.createOffering(offeringOptions).execute();
        Offering offeringResult = offeringResponse.getResult();

        GetOfferingOptions getOptions = new GetOfferingOptions.Builder().catalogIdentifier(catalogResult.id()).offeringId(offeringResult.id()).build();
        Response<Offering> getResponse = service.getOffering(getOptions).execute();
        Offering getResult = getResponse.getResult();

        DeleteCatalogOptions deleteOptions = new DeleteCatalogOptions.Builder().catalogIdentifier(catalogResult.id()).build();
        service.deleteCatalog(deleteOptions).execute();

        assertNotNull(getResponse);
        assertEquals(getResponse.getStatusCode(), 200);
        assertEquals(getResult.name(), expectedOfferingName);
        assertEquals(getResult.url(), String.format(expectedOfferingURL, catalogResult.id(), offeringResult.id()));
        assertEquals(getResult.label(), expectedLabel);
    }

    @Test
    public void testGetOfferingFailure() {
        CreateCatalogOptions catalogOptions = new CreateCatalogOptions.Builder().label(expectedLabel).shortDescription(expectedShortDesc).build();
        Response<Catalog> catalogResponse = service.createCatalog(catalogOptions).execute();
        Catalog catalogResult = catalogResponse.getResult();

        try {
            GetOfferingOptions getOptions = new GetOfferingOptions.Builder().catalogIdentifier(catalogResult.id()).offeringId(fakeName).build();
            service.getOffering(getOptions).execute();
            fail("Expected NotFoundException.");
        } catch (NotFoundException e) {
            assertEquals(e.getStatusCode(), 404);
        }

        DeleteCatalogOptions deleteOptions = new DeleteCatalogOptions.Builder().catalogIdentifier(catalogResult.id()).build();
        service.deleteCatalog(deleteOptions).execute();

        try {
            GetOfferingOptions getOptions = new GetOfferingOptions.Builder().catalogIdentifier(catalogResult.id()).offeringId(fakeName).build();
            service.getOffering(getOptions).execute();
            fail("Expected NotFoundException.");
        } catch (ForbiddenException e) {
            assertEquals(e.getStatusCode(), 403);
        }
    }

    @Test
    public void testListOfferings() {
        final Long expectedLimit = 100L;
        final Long expectedOffset = 0L;
        final Long expectedTotalCount = 1L;
        final Long expectedResourceCount = 1L;
        final int expectedResourceLen = 1;
        final String expectedFirst = "/api/v1-beta/catalogs/%s/offerings?limit=100&sort=label";
        final String expectedLast = "/api/v1-beta/catalogs/%s/offerings?limit=100&sort=label";

        CreateCatalogOptions catalogOptions = new CreateCatalogOptions.Builder().label(expectedLabel).shortDescription(expectedShortDesc).build();
        Response<Catalog> catalogResponse = service.createCatalog(catalogOptions).execute();
        Catalog catalogResult = catalogResponse.getResult();

        CreateOfferingOptions offeringOptions = new CreateOfferingOptions.Builder().catalogIdentifier(catalogResult.id()).name(expectedOfferingName).label(expectedLabel).build();
        Response<Offering> offeringResponse = service.createOffering(offeringOptions).execute();
        Offering offeringResult = offeringResponse.getResult();

        ListOfferingsOptions listOptions = new ListOfferingsOptions.Builder().catalogIdentifier(catalogResult.id()).build();
        Response<OfferingSearchResult> listResponse = service.listOfferings(listOptions).execute();
        OfferingSearchResult listResult = listResponse.getResult();

        DeleteCatalogOptions deleteOptions = new DeleteCatalogOptions.Builder().catalogIdentifier(catalogResult.id()).build();
        service.deleteCatalog(deleteOptions).execute();

        assertNotNull(listResponse);
        assertEquals(listResponse.getStatusCode(), 200);
        assertEquals(listResult.getOffset(), expectedOffset);
        assertEquals(listResult.getLimit(), expectedLimit);
        assertEquals(listResult.getTotalCount(), expectedTotalCount);
        assertEquals(listResult.getResourceCount(), expectedResourceCount);
        assertEquals(listResult.getFirst(), String.format(expectedFirst, catalogResult.id()));
        assertEquals(listResult.getLast(), String.format(expectedLast, catalogResult.id()));
        assertEquals(listResult.getResources().size(), expectedResourceLen);
        assertEquals(listResult.getResources().get(0).id(), offeringResult.id());
        assertEquals(listResult.getResources().get(0).url(), String.format(expectedOfferingURL, catalogResult.id(), offeringResult.id()));
        assertEquals(listResult.getResources().get(0).label(), expectedLabel);
        assertEquals(listResult.getResources().get(0).name(), expectedOfferingName);
        assertEquals(listResult.getResources().get(0).catalogId(), catalogResult.id());
        assertEquals(listResult.getResources().get(0).catalogName(), expectedLabel);
    }

    @Test
    public void testDeleteOffering() {
        CreateCatalogOptions catalogOptions = new CreateCatalogOptions.Builder().label(expectedLabel).shortDescription(expectedShortDesc).build();
        Response<Catalog> catalogResponse = service.createCatalog(catalogOptions).execute();
        Catalog catalogResult = catalogResponse.getResult();

        CreateOfferingOptions offeringOptions = new CreateOfferingOptions.Builder().catalogIdentifier(catalogResult.id()).name(expectedOfferingName).label(expectedLabel).build();
        Response<Offering> offeringResponse = service.createOffering(offeringOptions).execute();
        Offering offeringResult = offeringResponse.getResult();

        DeleteOfferingOptions deleteOfferingOptions = new DeleteOfferingOptions.Builder().catalogIdentifier(catalogResult.id()).offeringId(offeringResult.id()).build();
        Response<Void> deleteOfferingResponse = service.deleteOffering(deleteOfferingOptions).execute();

        DeleteCatalogOptions deleteOptions = new DeleteCatalogOptions.Builder().catalogIdentifier(catalogResult.id()).build();
        service.deleteCatalog(deleteOptions).execute();

        assertNotNull(deleteOfferingResponse);
        assertEquals(deleteOfferingResponse.getStatusCode(), 200);
    }

    @Test(expectedExceptions = {ForbiddenException.class})
    public void testDeleteOfferingFailure() {
        CreateCatalogOptions catalogOptions = new CreateCatalogOptions.Builder().label(expectedLabel).shortDescription(expectedShortDesc).build();
        Response<Catalog> catalogResponse = service.createCatalog(catalogOptions).execute();
        Catalog catalogResult = catalogResponse.getResult();

        DeleteOfferingOptions deleteOfferingOptions = new DeleteOfferingOptions.Builder().catalogIdentifier(catalogResult.id()).offeringId(fakeName).build();
        Response<Void> deleteOfferingResponse = service.deleteOffering(deleteOfferingOptions).execute();

        assertNotNull(deleteOfferingResponse);
        assertEquals(deleteOfferingResponse.getStatusCode(), 200);

        DeleteCatalogOptions deleteOptions = new DeleteCatalogOptions.Builder().catalogIdentifier(catalogResult.id()).build();
        service.deleteCatalog(deleteOptions).execute();

        DeleteOfferingOptions deleteOfferingNoCatalogOptions = new DeleteOfferingOptions.Builder().catalogIdentifier(catalogResult.id()).offeringId(fakeName).build();
        service.deleteOffering(deleteOfferingNoCatalogOptions).execute();
    }

    @Test
    public void testUpdateOffering() {
        final String expectedLabelUpdate = "test-update";
        final String expectedShortDesc = "test-desc";
        final String expectedShortDescUpdate = "test-desc-update";

        CreateCatalogOptions catalogOptions = new CreateCatalogOptions.Builder().label(expectedLabel).shortDescription(expectedShortDesc).build();
        Response<Catalog> catalogResponse = service.createCatalog(catalogOptions).execute();
        Catalog catalogResult = catalogResponse.getResult();

        CreateOfferingOptions offeringOptions = new CreateOfferingOptions.Builder().catalogIdentifier(catalogResult.id()).name(expectedOfferingName).label(expectedLabel).build();
        Response<Offering> offeringResponse = service.createOffering(offeringOptions).execute();
        Offering offeringResult = offeringResponse.getResult();

        ReplaceOfferingOptions replaceOptions = new ReplaceOfferingOptions.Builder().catalogIdentifier(catalogResult.id()).id(offeringResult.id()).offeringId(offeringResult.id()).label(expectedLabelUpdate).shortDescription(expectedShortDescUpdate).rev(offeringResult.rev()).build();
        Response<Catalog> replaceResponse = service.replaceOffering(replaceOptions).execute();
        Catalog replaceResult = replaceResponse.getResult();

        DeleteCatalogOptions deleteOptions = new DeleteCatalogOptions.Builder().catalogIdentifier(catalogResult.id()).build();
        service.deleteCatalog(deleteOptions).execute();

        assertNotNull(replaceResponse);
        assertEquals(replaceResponse.getStatusCode(), 200);
        assertEquals(replaceResult.url(), String.format(expectedOfferingURL, catalogResult.id(), offeringResult.id()));
        assertEquals(replaceResult.label(), expectedLabelUpdate);
        assertEquals(replaceResult.shortDescription(), expectedShortDescUpdate);
    }

    @Test
    public void testUpdateOfferingFailure() {
        CreateCatalogOptions catalogOptions = new CreateCatalogOptions.Builder().label(expectedLabel).shortDescription(expectedShortDesc).build();
        Response<Catalog> catalogResponse = service.createCatalog(catalogOptions).execute();
        Catalog catalogResult = catalogResponse.getResult();

        try {
            ReplaceOfferingOptions replaceOptions = new ReplaceOfferingOptions.Builder().catalogIdentifier(catalogResult.id()).id(fakeName).offeringId(fakeName).rev(fakeName).build();
            service.replaceOffering(replaceOptions).execute();
            fail("Expected NotFoundException.");
        } catch (NotFoundException e) {
            assertEquals(e.getStatusCode(), 404);
        }

        DeleteCatalogOptions deleteOptions = new DeleteCatalogOptions.Builder().catalogIdentifier(catalogResult.id()).build();
        service.deleteCatalog(deleteOptions).execute();

        try {
            ReplaceOfferingOptions replaceOptions = new ReplaceOfferingOptions.Builder().catalogIdentifier(catalogResult.id()).id(fakeName).offeringId(fakeName).rev(fakeName).build();
            service.replaceOffering(replaceOptions).execute();
            fail("Expected NotFoundException.");
        } catch (ForbiddenException e) {
            assertEquals(e.getStatusCode(), 403);
        }
    }

    @Test
    public void testGetConsumptionOfferings() {
        Response<OfferingSearchResult> listResponse = service.getConsumptionOfferings().execute();
        OfferingSearchResult result = listResponse.getResult();

        assertNotNull(result);
        assertEquals(listResponse.getStatusCode(), 200);
        assertEquals(result.getOffset(), Long.valueOf(0));
        assertNotEquals(result.getLimit(), Long.valueOf(0));
        assertNotEquals(result.getTotalCount(), 0);
        assertNotNull(result.getLast());
        assertNull(result.getPrev());
        assertNotNull(result.getNext());
        assertNotEquals(result.getResources().size(), 0);
    }

    @Ignore
    @Test
    public void testImportOffering() {
        final String expectedOfferingName = "jenkins-operator";
        final String expectedOfferingLabel = "Jenkins Operator";
        final String expectedOfferingTargetKind = "roks";
        final String expectedOfferingVersion = "0.4.0";
        final int expectedOfferingVersions = 1;
        final int expectedOfferingKinds = 1;
        final String expectedOfferingShortDesc = "Kubernetes native operator which fully manages Jenkins on Openshift.";
        final String expectedOfferingURL = "https://cm.globalcatalog.test.cloud.ibm.com/api/v1-beta/catalogs/%s/offerings/%s";
        final String expectedOfferingZipURL = "https://github.com/operator-framework/community-operators/blob/master/community-operators/jenkins-operator/0.4.0/jenkins-operator.v0.4.0.clusterserviceversion.yaml";

        CreateCatalogOptions catalogOptions = new CreateCatalogOptions.Builder().label(expectedLabel).shortDescription(expectedShortDesc).build();
        Response<Catalog> catalogResponse = service.createCatalog(catalogOptions).execute();
        Catalog catalogResult = catalogResponse.getResult();

        ImportOfferingOptions offeringOptions = new ImportOfferingOptions.Builder().catalogIdentifier(catalogResult.id()).zipurl(expectedOfferingZipURL).xAuthToken(gitToken).build();
        Response<Offering> offeringResponse = service.importOffering(offeringOptions).execute();
        Offering offeringResult = offeringResponse.getResult();

        DeleteCatalogOptions deleteOptions = new DeleteCatalogOptions.Builder().catalogIdentifier(catalogResult.id()).build();
        service.deleteCatalog(deleteOptions).execute();

        assertNotNull(offeringResponse);
        assertEquals(offeringResponse.getStatusCode(), 201);
        assertEquals(offeringResult.name(), expectedOfferingName);
        assertEquals(offeringResult.url(), String.format(expectedOfferingURL, catalogResult.id(), offeringResult.id()));
        assertEquals(offeringResult.label(), expectedOfferingLabel);
        assertEquals(offeringResult.shortDescription(), expectedOfferingShortDesc);
        assertEquals(offeringResult.catalogName(), expectedLabel);
        assertEquals(offeringResult.catalogId(), catalogResult.id());
        assertEquals(offeringResult.kinds().size(), expectedOfferingKinds);
        assertEquals(offeringResult.kinds().get(0).targetKind(), expectedOfferingTargetKind);
        assertEquals(offeringResult.kinds().get(0).versions().size(), expectedOfferingVersions);
        assertEquals(offeringResult.kinds().get(0).versions().get(0).version(), expectedOfferingVersion);
        assertEquals(offeringResult.kinds().get(0).versions().get(0).tgzUrl(), expectedOfferingZipURL);
    }

    @Ignore
    @Test
    public void testImportOfferingVersion() {
        final String expectedOfferingName = "jenkins-operator";
        final String expectedOfferingLabel = "Jenkins Operator";
        final String expectedOfferingTargetKind = "roks";
        final int expectedOfferingKinds = 1;
        final int expectedOfferingVersions = 2;
        final String expectedOfferingVersion1 = "0.3.31";
        final String expectedOfferingVersion2 = "0.4.0";
        final String expectedOfferingShortDesc = "Kubernetes native operator which fully manages Jenkins on Openshift.";
        final String expectedOfferingURL = "https://cm.globalcatalog.test.cloud.ibm.com/api/v1-beta/catalogs/%s/offerings/%s";
        final String expectedOfferingZipURL = "https://github.com/operator-framework/community-operators/blob/master/community-operators/jenkins-operator/0.3.31/jenkins-operator.v0.3.31.clusterserviceversion.yaml";
        final String expectedOfferingZipURLUpdate = "https://github.com/operator-framework/community-operators/blob/master/community-operators/jenkins-operator/0.4.0/jenkins-operator.v0.4.0.clusterserviceversion.yaml";

        CreateCatalogOptions catalogOptions = new CreateCatalogOptions.Builder().label(expectedLabel).shortDescription(expectedShortDesc).build();
        Response<Catalog> catalogResponse = service.createCatalog(catalogOptions).execute();
        Catalog catalogResult = catalogResponse.getResult();

        ImportOfferingOptions offeringOptions = new ImportOfferingOptions.Builder().catalogIdentifier(catalogResult.id()).zipurl(expectedOfferingZipURL).xAuthToken(gitToken).build();
        Response<Offering> offeringResponse = service.importOffering(offeringOptions).execute();
        Offering offeringResult = offeringResponse.getResult();

        ImportOfferingVersionOptions newOfferingOptions = new ImportOfferingVersionOptions.Builder().catalogIdentifier(catalogResult.id()).offeringId(offeringResult.id()).zipurl(expectedOfferingZipURLUpdate).xAuthToken(gitToken).build();
        Response<Offering> newOfferingResponse = service.importOfferingVersion(newOfferingOptions).execute();
        Offering newOfferingResult = newOfferingResponse.getResult();

        DeleteCatalogOptions deleteOptions = new DeleteCatalogOptions.Builder().catalogIdentifier(catalogResult.id()).build();
        service.deleteCatalog(deleteOptions).execute();

        assertNotNull(newOfferingResponse);
        assertEquals(newOfferingResponse.getStatusCode(), 201);
        assertEquals(newOfferingResult.name(), expectedOfferingName);
        assertEquals(newOfferingResult.url(), String.format(expectedOfferingURL, catalogResult.id(), offeringResult.id()));
        assertEquals(newOfferingResult.label(), expectedOfferingLabel);
        assertEquals(newOfferingResult.shortDescription(), expectedOfferingShortDesc);
        assertEquals(newOfferingResult.catalogName(), expectedLabel);
        assertEquals(newOfferingResult.catalogId(), catalogResult.id());
        assertEquals(newOfferingResult.kinds().size(), expectedOfferingKinds);
        assertEquals(newOfferingResult.kinds().get(0).targetKind(), expectedOfferingTargetKind);
        assertEquals(newOfferingResult.kinds().get(0).versions().size(), expectedOfferingVersions);
        assertEquals(newOfferingResult.kinds().get(0).versions().get(0).version(), expectedOfferingVersion1);
        assertEquals(newOfferingResult.kinds().get(0).versions().get(0).tgzUrl(), expectedOfferingZipURL);
        assertEquals(newOfferingResult.kinds().get(0).versions().get(1).version(), expectedOfferingVersion2);
        assertEquals(newOfferingResult.kinds().get(0).versions().get(1).tgzUrl(), expectedOfferingZipURLUpdate);
    }

    @Test
    public void testImportOfferinVersionFailure() {
        final String expectedOfferingZipURLUpdate = "https://github.com/operator-framework/community-operators/blob/master/community-operators/jenkins-operator/0.4.0/jenkins-operator.v0.4.0.clusterserviceversion.yaml";

        CreateCatalogOptions catalogOptions = new CreateCatalogOptions.Builder().label(expectedLabel).shortDescription(expectedShortDesc).build();
        Response<Catalog> catalogResponse = service.createCatalog(catalogOptions).execute();
        Catalog catalogResult = catalogResponse.getResult();

        try {
            ImportOfferingVersionOptions offeringOptions = new ImportOfferingVersionOptions.Builder().catalogIdentifier(catalogResult.id()).offeringId(fakeName).zipurl(expectedOfferingZipURLUpdate).xAuthToken(gitToken).build();
            service.importOfferingVersion(offeringOptions).execute();
            fail("Expected NotFoundException.");
        } catch (NotFoundException e) {
            assertEquals(e.getStatusCode(), 404);
        }

        DeleteCatalogOptions deleteOptions = new DeleteCatalogOptions.Builder().catalogIdentifier(catalogResult.id()).build();
        service.deleteCatalog(deleteOptions).execute();

        try {
            ImportOfferingVersionOptions offeringOptions = new ImportOfferingVersionOptions.Builder().catalogIdentifier(catalogResult.id()).offeringId(fakeName).zipurl(expectedOfferingZipURLUpdate).xAuthToken(gitToken).build();
            service.importOfferingVersion(offeringOptions).execute();
            fail("Expected NotFoundException.");
        } catch (ForbiddenException e) {
            assertEquals(e.getStatusCode(), 403);
        }
    }

    @Ignore
    @Test
    public void testReloadOfferingVersion() {
        final String expectedOfferingName = "jenkins-operator";
        final String expectedOfferingLabel = "Jenkins Operator";
        final String expectedOfferingTargetKind = "roks";
        final String expectedOfferingVersion = "0.4.0";
        final int expectedOfferingKinds = 1;
        final int expectedOfferingVersions = 1;
        final String expectedOfferingShortDesc = "Kubernetes native operator which fully manages Jenkins on Openshift.";
        final String expectedOfferingURL = "https://cm.globalcatalog.test.cloud.ibm.com/api/v1-beta/catalogs/%s/offerings/%s";
        final String expectedOfferingZipURL = "https://github.com/operator-framework/community-operators/blob/master/community-operators/jenkins-operator/0.4.0/jenkins-operator.v0.4.0.clusterserviceversion.yaml";

        CreateCatalogOptions catalogOptions = new CreateCatalogOptions.Builder().label(expectedLabel).shortDescription(expectedShortDesc).build();
        Response<Catalog> catalogResponse = service.createCatalog(catalogOptions).execute();
        Catalog catalogResult = catalogResponse.getResult();

        ImportOfferingOptions offeringOptions = new ImportOfferingOptions.Builder().catalogIdentifier(catalogResult.id()).zipurl(expectedOfferingZipURL).xAuthToken(gitToken).build();
        Response<Offering> offeringResponse = service.importOffering(offeringOptions).execute();
        Offering offeringResult = offeringResponse.getResult();

        ReloadOfferingOptions reloadOfferingOptions = new ReloadOfferingOptions.Builder().catalogIdentifier(catalogResult.id()).offeringId(offeringResult.id()).zipurl(expectedOfferingZipURL).targetVersion(expectedOfferingVersion).xAuthToken(gitToken).build();
        Response<Offering> reloadOfferingResponse = service.reloadOffering(reloadOfferingOptions).execute();
        Offering reloadOfferingResult = reloadOfferingResponse.getResult();

        DeleteCatalogOptions deleteOptions = new DeleteCatalogOptions.Builder().catalogIdentifier(catalogResult.id()).build();
        service.deleteCatalog(deleteOptions).execute();

        assertNotNull(reloadOfferingResponse);
        assertEquals(reloadOfferingResponse.getStatusCode(), 200);
        assertEquals(reloadOfferingResult.name(), expectedOfferingName);
        assertEquals(reloadOfferingResult.url(), String.format(expectedOfferingURL, catalogResult.id(), offeringResult.id()));
        assertEquals(reloadOfferingResult.label(), expectedOfferingLabel);
        assertEquals(reloadOfferingResult.shortDescription(), expectedOfferingShortDesc);
        assertEquals(reloadOfferingResult.catalogName(), expectedLabel);
        assertEquals(reloadOfferingResult.catalogId(), catalogResult.id());
        assertEquals(reloadOfferingResult.kinds().size(), expectedOfferingKinds);
        assertEquals(reloadOfferingResult.kinds().get(0).targetKind(), expectedOfferingTargetKind);
        assertEquals(reloadOfferingResult.kinds().get(0).versions().size(), expectedOfferingVersions);
        assertEquals(reloadOfferingResult.kinds().get(0).versions().get(0).version(), expectedOfferingVersion);
        assertEquals(reloadOfferingResult.kinds().get(0).versions().get(0).tgzUrl(), expectedOfferingZipURL);
    }

    @Test
    public void testReloadOfferingVersionFailure() {
        final String expectedOfferingVersion = "0.4.0";
        final String expectedOfferingZipURL = "https://github.com/operator-framework/community-operators/blob/master/community-operators/jenkins-operator/0.4.0/jenkins-operator.v0.4.0.clusterserviceversion.yaml";

        CreateCatalogOptions catalogOptions = new CreateCatalogOptions.Builder().label(expectedLabel).shortDescription(expectedShortDesc).build();
        Response<Catalog> catalogResponse = service.createCatalog(catalogOptions).execute();
        Catalog catalogResult = catalogResponse.getResult();

        try {
            ReloadOfferingOptions reloadOfferingOptions = new ReloadOfferingOptions.Builder().catalogIdentifier(catalogResult.id()).offeringId(fakeName).zipurl(expectedOfferingZipURL).targetVersion(expectedOfferingVersion).build();
            service.reloadOffering(reloadOfferingOptions).execute();
            fail("Expected NotFoundException.");
        } catch (NotFoundException e) {
            assertEquals(e.getStatusCode(), 404);
        }

        DeleteCatalogOptions deleteOptions = new DeleteCatalogOptions.Builder().catalogIdentifier(catalogResult.id()).build();
        service.deleteCatalog(deleteOptions).execute();

        try {
            ReloadOfferingOptions reloadOfferingOptions = new ReloadOfferingOptions.Builder().catalogIdentifier(catalogResult.id()).offeringId(fakeName).zipurl(expectedOfferingZipURL).targetVersion(expectedOfferingVersion).build();
            service.reloadOffering(reloadOfferingOptions).execute();
            fail("Expected NotFoundException.");
        } catch (ForbiddenException e) {
            assertEquals(e.getStatusCode(), 403);
        }
    }

    @Ignore
    @Test
    public void testGetVersion() {
        final String expectedOfferingName = "jenkins-operator";
        final String expectedOfferingLabel = "Jenkins Operator";
        final String expectedOfferingTargetKind = "roks";
        final String expectedOfferingVersion = "0.4.0";
        final int expectedOfferingKinds = 1;
        final int expectedOfferingVersions = 1;
        final String expectedOfferingShortDesc = "Kubernetes native operator which fully manages Jenkins on Openshift.";
        final String expectedOfferingURL = "https://cm.globalcatalog.test.cloud.ibm.com/api/v1-beta/catalogs/%s/offerings/%s";
        final String expectedOfferingZipURL = "https://github.com/operator-framework/community-operators/blob/master/community-operators/jenkins-operator/0.4.0/jenkins-operator.v0.4.0.clusterserviceversion.yaml";

        CreateCatalogOptions catalogOptions = new CreateCatalogOptions.Builder().label(expectedLabel).shortDescription(expectedShortDesc).build();
        Response<Catalog> catalogResponse = service.createCatalog(catalogOptions).execute();
        Catalog catalogResult = catalogResponse.getResult();

        ImportOfferingOptions offeringOptions = new ImportOfferingOptions.Builder().catalogIdentifier(catalogResult.id()).zipurl(expectedOfferingZipURL).xAuthToken(gitToken).build();
        Response<Offering> offeringResponse = service.importOffering(offeringOptions).execute();
        Offering offeringResult = offeringResponse.getResult();

        GetVersionOptions getOptions = new GetVersionOptions.Builder().versionLocId(offeringResult.kinds().get(0).versions().get(0).versionLocator()).build();
        Response<Offering> getResponse = service.getVersion(getOptions).execute();
        Offering getResult = getResponse.getResult();

        DeleteCatalogOptions deleteOptions = new DeleteCatalogOptions.Builder().catalogIdentifier(catalogResult.id()).build();
        service.deleteCatalog(deleteOptions).execute();

        assertNotNull(getResponse);
        assertEquals(getResponse.getStatusCode(), 200);
        assertEquals(getResult.name(), expectedOfferingName);
        assertEquals(getResult.url(), String.format(expectedOfferingURL, catalogResult.id(), offeringResult.id()));
        assertEquals(getResult.label(), expectedOfferingLabel);
        assertEquals(getResult.shortDescription(), expectedOfferingShortDesc);
        assertEquals(getResult.catalogName(), expectedLabel);
        assertEquals(getResult.catalogId(), catalogResult.id());
        assertEquals(getResult.kinds().size(), expectedOfferingKinds);
        assertEquals(getResult.kinds().get(0).targetKind(), expectedOfferingTargetKind);
        assertEquals(getResult.kinds().get(0).versions().size(), expectedOfferingVersions);
        assertEquals(getResult.kinds().get(0).versions().get(0).version(), expectedOfferingVersion);
        assertEquals(getResult.kinds().get(0).versions().get(0).tgzUrl(), expectedOfferingZipURL);
    }

    @Test(expectedExceptions = {NotFoundException.class})
    public void testGetVersionFailure() {
        GetVersionOptions getOptions = new GetVersionOptions.Builder().versionLocId(fakeVersionLocator).build();
        service.getVersion(getOptions).execute();
    }

    @Ignore
    @Test
    public void testDeleteVersion() {
        final String expectedOfferingZipURL = "https://github.com/operator-framework/community-operators/blob/master/community-operators/jenkins-operator/0.4.0/jenkins-operator.v0.4.0.clusterserviceversion.yaml";

        CreateCatalogOptions catalogOptions = new CreateCatalogOptions.Builder().label(expectedLabel).shortDescription(expectedShortDesc).build();
        Response<Catalog> catalogResponse = service.createCatalog(catalogOptions).execute();
        Catalog catalogResult = catalogResponse.getResult();

        ImportOfferingOptions offeringOptions = new ImportOfferingOptions.Builder().catalogIdentifier(catalogResult.id()).zipurl(expectedOfferingZipURL).xAuthToken(gitToken).build();
        Response<Offering> offeringResponse = service.importOffering(offeringOptions).execute();
        Offering offeringResult = offeringResponse.getResult();

        DeleteVersionOptions deleteOption = new DeleteVersionOptions.Builder().versionLocId(offeringResult.kinds().get(0).versions().get(0).versionLocator()).build();
        Response<Void> deleteResponse = service.deleteVersion(deleteOption).execute();

        DeleteCatalogOptions deleteOptions = new DeleteCatalogOptions.Builder().catalogIdentifier(catalogResult.id()).build();
        service.deleteCatalog(deleteOptions).execute();

        assertNotNull(deleteResponse);
        assertEquals(deleteResponse.getStatusCode(), 200);
    }

    @Test(expectedExceptions = {NotFoundException.class})
    public void testDeleteVersionFailure() {
        DeleteVersionOptions deleteOption = new DeleteVersionOptions.Builder().versionLocId(fakeVersionLocator).build();
        service.deleteVersion(deleteOption).execute();
    }

    @Ignore
    @Test
    public void testGetVersionAbout() {
        final String expectedOfferingZipURL = "https://github.com/operator-framework/community-operators/blob/master/community-operators/jenkins-operator/0.4.0/jenkins-operator.v0.4.0.clusterserviceversion.yaml";

        CreateCatalogOptions catalogOptions = new CreateCatalogOptions.Builder().label(expectedLabel).shortDescription(expectedShortDesc).build();
        Response<Catalog> catalogResponse = service.createCatalog(catalogOptions).execute();
        Catalog catalogResult = catalogResponse.getResult();

        ImportOfferingOptions offeringOptions = new ImportOfferingOptions.Builder().catalogIdentifier(catalogResult.id()).zipurl(expectedOfferingZipURL).xAuthToken(gitToken).build();
        Response<Offering> offeringResponse = service.importOffering(offeringOptions).execute();
        Offering offeringResult = offeringResponse.getResult();

        GetVersionAboutOptions getOptions = new GetVersionAboutOptions.Builder().versionLocId(offeringResult.kinds().get(0).versions().get(0).versionLocator()).build();
        Response<String> getResponse = service.getVersionAbout(getOptions).execute();

        DeleteCatalogOptions deleteOptions = new DeleteCatalogOptions.Builder().catalogIdentifier(catalogResult.id()).build();
        service.deleteCatalog(deleteOptions).execute();

        assertNotNull(getResponse);
        assertEquals(getResponse.getStatusCode(), 200);
        assertNotEquals(getResponse.getResult().length(), 0);
    }

    @Test(expectedExceptions = {NotFoundException.class})
    public void testGetVersionAboutFailure() {
        GetVersionAboutOptions getOptions = new GetVersionAboutOptions.Builder().versionLocId(fakeVersionLocator).build();
        service.getVersionAbout(getOptions).execute();
    }

    @Ignore
    @Test
    public void testGetVersionUpdates() {
        final int expectedOfferingUpdates = 1;
        final String expectedOfferingVersion2 = "0.4.0";
        final String expectedOfferingZipURL = "https://github.com/operator-framework/community-operators/blob/master/community-operators/jenkins-operator/0.3.31/jenkins-operator.v0.3.31.clusterserviceversion.yaml";
        final String expectedOfferingZipURLUpdate = "https://github.com/operator-framework/community-operators/blob/master/community-operators/jenkins-operator/0.4.0/jenkins-operator.v0.4.0.clusterserviceversion.yaml";

        CreateCatalogOptions catalogOptions = new CreateCatalogOptions.Builder().label(expectedLabel).shortDescription(expectedShortDesc).build();
        Response<Catalog> catalogResponse = service.createCatalog(catalogOptions).execute();
        Catalog catalogResult = catalogResponse.getResult();

        ImportOfferingOptions offeringOptions = new ImportOfferingOptions.Builder().catalogIdentifier(catalogResult.id()).zipurl(expectedOfferingZipURL).xAuthToken(gitToken).build();
        Response<Offering> offeringResponse = service.importOffering(offeringOptions).execute();
        Offering offeringResult = offeringResponse.getResult();

        ImportOfferingVersionOptions newOfferingOptions = new ImportOfferingVersionOptions.Builder().catalogIdentifier(catalogResult.id()).offeringId(offeringResult.id()).zipurl(expectedOfferingZipURLUpdate).xAuthToken(gitToken).build();
        Response<Offering> newOfferingResponse = service.importOfferingVersion(newOfferingOptions).execute();
        Offering newOfferingResult = newOfferingResponse.getResult();


        GetVersionUpdatesOptions getOptions = new GetVersionUpdatesOptions.Builder().versionLocId(offeringResult.kinds().get(0).versions().get(0).versionLocator()).build();
        Response<List<VersionUpdateDescriptor>> getResponse = service.getVersionUpdates(getOptions).execute();
        List<VersionUpdateDescriptor> getResult = getResponse.getResult();

        DeleteCatalogOptions deleteOptions = new DeleteCatalogOptions.Builder().catalogIdentifier(catalogResult.id()).build();
        service.deleteCatalog(deleteOptions).execute();

        assertNotNull(getResponse);
        assertEquals(getResponse.getStatusCode(), 200);
        assertEquals(getResult.size(), expectedOfferingUpdates);
        assertEquals(getResult.get(0).getVersionLocator(), newOfferingResult.kinds().get(0).versions().get(1).versionLocator());
        assertEquals(getResult.get(0).getVersion(), expectedOfferingVersion2);
        assertEquals(getResult.get(0).getPackageVersion(), expectedOfferingVersion2);
        assertTrue(getResult.get(0).isCanUpdate());
    }

    @Test(expectedExceptions = {NotFoundException.class})
    public void testGetVersionUpdatesFailure() {
        GetVersionUpdatesOptions getOptions = new GetVersionUpdatesOptions.Builder().versionLocId(fakeVersionLocator).build();
        service.getVersionUpdates(getOptions).execute();
    }

    @Test
    public void testGetLicenseProviders() {
        final int expectedResourceCount = 1;
        final Long expectedTotalResults = 1L;
        final Long expectedTotalPages = 1L;
        final String expectedName = "IBM Passport Advantage";
        final String expectedOfferingType = "content";
        final String expectedCreateURL = "https://www.ibm.com/software/passportadvantage/aboutpassport.html";
        final String expectedInfoURL = "https://www.ibm.com/software/passportadvantage/";
        final String expectedURL = "/v1/licensing/license_providers/11cabc37-c4a7-410b-894d-8cb3586423f1";
        final String expectedState = "active";


        Response<LicenseProviders> response = service.getLicenseProviders().execute();
        LicenseProviders result = response.getResult();

        assertNotNull(result);
        assertEquals(response.getStatusCode(), 200);
        assertEquals(result.getResources().size(), expectedResourceCount);
        assertEquals(result.getTotalResults(), expectedTotalResults);
        assertEquals(result.getTotalPages(), expectedTotalPages);
        assertEquals(result.getResources().get(0).getName(), expectedName);
        assertEquals(result.getResources().get(0).getOfferingType(), expectedOfferingType);
        assertEquals(result.getResources().get(0).getInfoUrl(), expectedInfoURL);
        assertEquals(result.getResources().get(0).getCreateUrl(), expectedCreateURL);
        assertEquals(result.getResources().get(0).getUrl(), expectedURL);
        assertEquals(result.getResources().get(0).getState(), expectedState);
    }

    @Test
    public void testListLicenseEntitlements() {
        final int expectedResourceCount = 0;
        final Long expectedTotalResults = 0L;
        final Long expectedTotalPages = 1L;

        ListLicenseEntitlementsOptions getOptions = new ListLicenseEntitlementsOptions.Builder().licenseProductId(fakeName).build();
        Response<LicenseEntitlements> response = service.listLicenseEntitlements(getOptions).execute();
        LicenseEntitlements result = response.getResult();

        assertNotNull(result);
        assertEquals(response.getStatusCode(), 200);
        assertEquals(result.getResources().size(), expectedResourceCount);
        assertEquals(result.getTotalResults(), expectedTotalResults);
        assertEquals(result.getTotalPages(), expectedTotalPages);
    }

    @Test(expectedExceptions = {ForbiddenException.class})
    public void testSearchLicenseVersionFailure() {
        SearchLicenseVersionsOptions getOptions = new SearchLicenseVersionsOptions.Builder().q(fakeName).build();
        service.searchLicenseVersions(getOptions).execute();
    }

    @Test(expectedExceptions = {ForbiddenException.class})
    public void testSearchLicenseOfferingsFailure() {
        SearchLicenseOfferingsOptions getOptions = new SearchLicenseOfferingsOptions.Builder().q(fakeName).build();
        service.searchLicenseOfferings(getOptions).execute();
    }
}
