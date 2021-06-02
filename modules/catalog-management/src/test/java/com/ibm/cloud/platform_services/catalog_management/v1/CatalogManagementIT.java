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

package com.ibm.cloud.platform_services.catalog_management.v1;

import com.ibm.cloud.platform_services.catalog_management.v1.model.*;
import com.ibm.cloud.platform_services.test.SdkIntegrationTestBase;
import com.ibm.cloud.sdk.core.http.Response;
import com.ibm.cloud.sdk.core.security.IamAuthenticator;
import com.ibm.cloud.sdk.core.security.IamToken;
import com.ibm.cloud.sdk.core.service.exception.*;
import com.ibm.cloud.sdk.core.util.CredentialUtils;

import java.util.*;

import org.testng.annotations.*;

import static org.testng.Assert.*;

/**
 * Integration test class for the CatalogManagement service.
 */
public class CatalogManagementIT extends SdkIntegrationTestBase {
  
  public CatalogManagement catalogManagementService = null;
  public CatalogManagement catalogManagementServiceNotAuthorized = null;
  public CatalogManagement serviceNotAuthenticatedShouldReturn401 = null;
  
  public static Map<String, String> config = null;
  
  /**
   * This method provides our config filename to the base class.
   */
  
  public String getConfigFilename() {
    return "../../catalog_mgmt.env";
  }
  
  private String accountId = null;
  private String clusterId = null;
  
  private String gitAuthToken = null;
  
  private String refreshTokenAuthorized = null;
  private String refreshTokenNotAuthorized = null;
  
  private String objectName = "JavaSdk6";
  private String labelJavaSdk = "java-sdk";
  private String kindVpe = "vpe";
  private String kindRoks = "roks";
  private String kindHelm = "helm";
  private String kindOperator = "operator";
  private String repoTypeGitPublic = "git_public";
  private String regionUsSouth = "us-south";
  private String namespaceJavaSdk = "java-sdk";
  
  private String bogusRevision = "bogus-revision";
  private String bogusCatalogId = "bogus-catalog-id";
  private String bogusOfferingId = "bogus-offering-id";
  private String bogusVersionLocatorId = "bogus-version-locator-id";
  private String bogusLicenseId = "bogus-license-id";
  private String bogusObjectId = "bogus-object-id";
  
  private String catalogId = null;
  private String offeringId = null;
  private String offeringInstanceId = null;
  
  private String versionLocatorId = null;
  
  private String objectId = null;
  
  @BeforeClass
  public void constructService() {
    // Ask super if we should skip the tests.
    if (skipTests()) {
      return;
    }
    
    catalogManagementServiceNotAuthorized = CatalogManagement.newInstance("NOT_AUTHORIZED");
    assertNotNull(catalogManagementServiceNotAuthorized);
    assertNotNull(catalogManagementServiceNotAuthorized.getServiceUrl());
    
    IamAuthenticator notAuthorizedIamAuthenticator = (IamAuthenticator) catalogManagementServiceNotAuthorized
        .getAuthenticator();
    IamToken iamTokenNotAuthorized = notAuthorizedIamAuthenticator.requestToken();
    refreshTokenNotAuthorized = iamTokenNotAuthorized.getRefreshToken();
    
    catalogManagementService = CatalogManagement.newInstance(CatalogManagement.DEFAULT_SERVICE_NAME);
    assertNotNull(catalogManagementService);
    assertNotNull(catalogManagementService.getServiceUrl());
    
    IamAuthenticator authorizedIamAuthenticator = (IamAuthenticator) catalogManagementService.getAuthenticator();
    IamToken iamAuthorizedToken = authorizedIamAuthenticator.requestToken();
    refreshTokenAuthorized = iamAuthorizedToken.getRefreshToken();
    
    // Load up our test-specific config properties.
    config = CredentialUtils.getServiceProperties(CatalogManagement.DEFAULT_SERVICE_NAME);
    assertNotNull(config);
    assertFalse(config.isEmpty());
    assertEquals(catalogManagementService.getServiceUrl(), config.get("URL"));
    
    accountId = config.get("ACCOUNT_ID");
    assertNotNull(accountId);
    
    clusterId = config.get("CLUSTER_ID");
    assertNotNull(clusterId);
    
    gitAuthToken = config.get("GIT_TOKEN");
    assertNotNull(gitAuthToken);
    
    System.out.println("Setup complete.");
  }
  
  // Regarding execution order...
  // this file contains 170+ tests and almost 5000 lines long so hard to navigate in it and track execution order
  // the order of the tests in the file represents the execution order with a twist
  // the twist is that there are blocks where there is an operation, e.g. createCatalog, and its negative tests
  // a block depends on the block which has executable (e.g. not Ignored) happy path test prior to it in this file,
  
  // for example
  // "getCatalog" (and its negative tests)
  // depends on "createCatalog"
  
  // another example
  // there are test blocks
  // block 1 (has not ignored happy path test)
  // block 2 (happy path test is ignored)
  // block 3
  // execution order
  // block 1 executes
  // block 2 executes and depends on block 1 happy path
  // block 3 executed and depends on block 1 happy path because block 2's happy path is ignored
  
  
  // a block contains the negative tests first and as last one the happy path
  
  //===
  // CreateCatalog block
  ///
  
  @Test(expectedExceptions = BadRequestException.class)
  public void testCreateCatalogReturns400WhenUserIsNotAuthorized() throws Exception {
    
    CreateCatalogOptions createCatalogOptions = new CreateCatalogOptions.Builder()
        .label(labelJavaSdk)
        .owningAccount(accountId)
        .kind(kindVpe)
        .build();
    
    catalogManagementServiceNotAuthorized.createCatalog(createCatalogOptions).execute();
  }
  
  @Test(expectedExceptions = BadRequestException.class)
  public void testCreateCatalogReturn400WhenBackendValidationFails() throws Exception {
    
    CreateCatalogOptions createCatalogOptions = new CreateCatalogOptions.Builder()
        .rev(bogusRevision)
        .label(labelJavaSdk)
        .owningAccount(accountId)
        .kind(kindVpe)
        .build();
    
    catalogManagementService.createCatalog(createCatalogOptions).execute();
  }
  
  @Test
  public void testCreateCatalog() throws Exception {
    try {
      CreateCatalogOptions createCatalogOptions = new CreateCatalogOptions.Builder()
          .label(labelJavaSdk)
          .owningAccount(accountId)
          .kind(kindVpe)
          .build();
      
      Response<Catalog> response = catalogManagementService.createCatalog(createCatalogOptions).execute();
      
      assertNotNull(response);
      assertEquals(response.getStatusCode(), 201);
      
      Catalog catalogResult = response.getResult();
      assertNotNull(catalogResult);
      catalogId = catalogResult.id();
      assertNotNull(catalogId);
      
    } catch (ServiceResponseException e) {
      fail(String.format("Service returned status code %d: %s\nError details: %s", e.getStatusCode(), e.getMessage(),
          e.getDebuggingInfo()));
    }
  }
  
  //====
  // GetCatalog block
  //====
  
  @Test(dependsOnMethods = {"testCreateCatalog"},
      expectedExceptions = NotFoundException.class)
  public void testGetCatalogReturns404WhenNoSuchCatalog() throws Exception {
    GetCatalogOptions getCatalogOptions = new GetCatalogOptions.Builder()
        .catalogIdentifier(catalogId + "c")
        .build();
    
    catalogManagementService.getCatalog(getCatalogOptions).execute();
  }
  
  @Test(dependsOnMethods = {"testCreateCatalog"},
      expectedExceptions = ForbiddenException.class)
  public void testGetCatalogReturns403WhenUserIsNotAuthorized() throws Exception {
    GetCatalogOptions getCatalogOptions = new GetCatalogOptions.Builder()
        .catalogIdentifier(catalogId)
        .build();
    
    catalogManagementServiceNotAuthorized.getCatalog(getCatalogOptions).execute();
  }
  
  @Test(dependsOnMethods = {"testCreateCatalog"})
  public void testGetCatalog() throws Exception {
    try {
      GetCatalogOptions getCatalogOptions = new GetCatalogOptions.Builder()
          .catalogIdentifier(catalogId)
          .build();
      
      Response<Catalog> response = catalogManagementService.getCatalog(getCatalogOptions).execute();
      
      assertNotNull(response);
      assertEquals(response.getStatusCode(), 200);
      
      Catalog catalogResult = response.getResult();
      assertNotNull(catalogResult);
      
    } catch (ServiceResponseException e) {
      fail(String.format("Service returned status code %d: %s\nError details: %s", e.getStatusCode(), e.getMessage(),
          e.getDebuggingInfo()));
    }
  }
  
  //====
  // ReplaceCatalog block
  //====
  
  @Test(dependsOnMethods = {"testGetCatalog"},
      expectedExceptions = NotFoundException.class)
  public void testReplaceCatalogReturns404WhenNoSuchCatalog() throws Exception {
    ReplaceCatalogOptions replaceCatalogOptions = new ReplaceCatalogOptions.Builder()
        .catalogIdentifier(catalogId + "c")
        .id(catalogId + "c")
        .build();
    
    catalogManagementService.replaceCatalog(replaceCatalogOptions).execute();
  }
  
  @Test(dependsOnMethods = {"testGetCatalog"},
      expectedExceptions = ForbiddenException.class)
  public void testReplaceCatalogReturns403WhenUserIsNotAuthorized() throws Exception {
    ReplaceCatalogOptions replaceCatalogOptions = new ReplaceCatalogOptions.Builder()
        .catalogIdentifier(catalogId)
        .id(catalogId)
        .build();
    
    catalogManagementServiceNotAuthorized.replaceCatalog(replaceCatalogOptions).execute();
  }
  
  @Test(dependsOnMethods = "testGetCatalog",
      expectedExceptions = BadRequestException.class)
  @Ignore
  public void testReplaceCatalogReturns400WhenBackendInputValidationFails() throws Exception {
    ReplaceCatalogOptions replaceCatalogOptions = new ReplaceCatalogOptions.Builder()
        .catalogIdentifier(catalogId)
        .id(catalogId)
        .tags(new ArrayList<>(Arrays.asList("java", "sdk", "tag")))
        .kind("bogus-kind")
        .build();
    
    catalogManagementService.replaceCatalog(replaceCatalogOptions).execute();
  }
  
  @Test(dependsOnMethods = {"testGetCatalog"})
  public void testReplaceCatalog() throws Exception {
    try {
      List<String> tags = new java.util.ArrayList<String>(java.util.Arrays.asList(
          "java",
          "sdk",
          "tag-1",
          "tag-2",
          "cloud",
          "platform-services"
      ));
      
      ReplaceCatalogOptions replaceCatalogOptions = new ReplaceCatalogOptions.Builder()
          .catalogIdentifier(catalogId)
          .id(catalogId)
          .tags(tags)
          .owningAccount(accountId)
          .build();
      
      Response<Catalog> response = catalogManagementService.replaceCatalog(replaceCatalogOptions).execute();
      assertNotNull(response);
      assertEquals(response.getStatusCode(), 200);
      
      Catalog catalogResult = response.getResult();
      assertNotNull(catalogResult);
      assertEquals(catalogResult.tags().equals(tags), true);
      
    } catch (ServiceResponseException e) {
      fail(String.format("Service returned status code %d: %s\nError details: %s", e.getStatusCode(), e.getMessage(),
          e.getDebuggingInfo()));
    }
  }
  
  //====
  // ListCatalog block
  //====
  
  @Test(dependsOnMethods = {"testReplaceCatalog"})
  public void testListCatalogs() throws Exception {
    try {
      Response<CatalogSearchResult> response = catalogManagementService.listCatalogs().execute();
      
      assertNotNull(response);
      assertEquals(response.getStatusCode(), 200);
      
      CatalogSearchResult catalogSearchResultResult = response.getResult();
      assertNotNull(catalogSearchResultResult);
      
      catalogSearchResultResult.getResources()
          .stream()
          .filter(p -> p.id().equals(catalogId))
          .findAny()
          .orElseThrow(() -> new RuntimeException(String.format("No catalog with id: %s", catalogId)));
      
    } catch (ServiceResponseException e) {
      fail(String.format("Service returned status code %d: %s\nError details: %s", e.getStatusCode(), e.getMessage(),
          e.getDebuggingInfo()));
    }
  }
  
  //====
  //CreateOffering block
  //====
  
  @Test(dependsOnMethods = {"testListCatalogs"},
      expectedExceptions = NotFoundException.class)
  public void testCreateOfferingReturns404WhenNoSuchCatalog() throws Exception {
    
    CreateOfferingOptions createOfferingOptions = new CreateOfferingOptions.Builder()
        .catalogIdentifier(bogusCatalogId)
        .build();
    
    catalogManagementService.createOffering(createOfferingOptions).execute();
  }
  
  @Test(dependsOnMethods = {"testListCatalogs"},
      expectedExceptions = BadRequestException.class)
  public void testCreateOfferingReturns400WhenBackendInputValidationFails() throws Exception {
    CreateOfferingOptions createOfferingOptions = new CreateOfferingOptions.Builder()
        .catalogIdentifier(catalogId)
        .catalogId(catalogId)
        .name("offering created by java sdk")
        .build();
    
    catalogManagementService.createOffering(createOfferingOptions).execute();
  }
  
  @Test(dependsOnMethods = {"testListCatalogs"},
      expectedExceptions = ForbiddenException.class)
  public void testCreateOfferingReturns403WhenUserIsNotAuthorized() throws Exception {
    CreateOfferingOptions createOfferingOptions = new CreateOfferingOptions.Builder()
        .catalogIdentifier(catalogId)
        .catalogId(catalogId)
        .name("offering created by java sdk")
        .build();
    
    catalogManagementServiceNotAuthorized.createOffering(createOfferingOptions).execute();
  }
  
  @Test(dependsOnMethods = {"testListCatalogs"})
  public void testCreateOffering() throws Exception {
    try {
      
      CreateOfferingOptions createOfferingOptions = new CreateOfferingOptions.Builder()
          .catalogIdentifier(catalogId)
          .label(labelJavaSdk)
          .name("offering-created-by-java-sdk")
          .build();
      
      Response<Offering> response = catalogManagementService.createOffering(createOfferingOptions).execute();
      
      assertNotNull(response);
      assertEquals(response.getStatusCode(), 201);
      
      Offering offeringResult = response.getResult();
      assertNotNull(offeringResult);
      offeringId = offeringResult.id();
      assertNotNull(offeringId);
      
    } catch (ServiceResponseException e) {
      fail(String.format("Service returned status code %d: %s\nError details: %s", e.getStatusCode(), e.getMessage(),
          e.getDebuggingInfo()));
    }
  }
  
  //====
  // GetOffering block
  //====
  
  @Test(dependsOnMethods = {"testCreateOffering"},
      expectedExceptions = NotFoundException.class)
  public void testGetOfferingReturns404WhenNoSuchOffering() throws Exception {
    GetOfferingOptions getOfferingOptions = new GetOfferingOptions.Builder()
        .catalogIdentifier(catalogId)
        .offeringId(bogusOfferingId)
        .build();
    
    catalogManagementService.getOffering(getOfferingOptions).execute();
  }
  
  @Test(dependsOnMethods = {"testCreateOffering"},
      expectedExceptions = ForbiddenException.class)
  public void testGetOfferingReturns403WhenUserIsNotAuthorized() throws Exception {
    GetOfferingOptions getOfferingOptions = new GetOfferingOptions.Builder()
        .catalogIdentifier(catalogId)
        .offeringId(offeringId)
        .build();
    
    catalogManagementServiceNotAuthorized.getOffering(getOfferingOptions).execute();
  }
  
  @Test(dependsOnMethods = {"testCreateOffering"})
  public void testGetOffering() throws Exception {
    try {
      GetOfferingOptions getOfferingOptions = new GetOfferingOptions.Builder()
          .catalogIdentifier(catalogId)
          .offeringId(offeringId)
          .build();
      
      Response<Offering> response = catalogManagementService.getOffering(getOfferingOptions).execute();
      
      assertNotNull(response);
      assertEquals(response.getStatusCode(), 200);
      
      Offering offeringResult = response.getResult();
      assertNotNull(offeringResult);
      
    } catch (ServiceResponseException e) {
      fail(String.format("Service returned status code %d: %s\nError details: %s", e.getStatusCode(), e.getMessage(),
          e.getDebuggingInfo()));
    }
  }
  
  //====
  // ReplaceOffering block
  //====
  
  @Test(dependsOnMethods = {"testGetOffering"},
      expectedExceptions = NotFoundException.class)
  public void testReplaceOfferingReturns404WhenNoSuchOffering() throws Exception {
    ReplaceOfferingOptions replaceOfferingOptions = new ReplaceOfferingOptions.Builder()
        .catalogIdentifier(catalogId)
        .offeringId(bogusOfferingId)
        .id(bogusOfferingId)
        .build();
    
    catalogManagementService.replaceOffering(replaceOfferingOptions).execute();
  }
  
  @Test(dependsOnMethods = {"testGetOffering"},
      expectedExceptions = BadRequestException.class)
  public void testReplaceOfferingReturns400WhenBackendInputValidationFails() throws Exception {
    ReplaceOfferingOptions replaceOfferingOptions = new ReplaceOfferingOptions.Builder()
        .catalogIdentifier(catalogId)
        .offeringId(offeringId)
        .id(bogusOfferingId)
        .build();
    
    catalogManagementService.replaceOffering(replaceOfferingOptions).execute();
  }
  
  @Test(dependsOnMethods = {"testGetOffering"},
      expectedExceptions = ForbiddenException.class)
  public void testReplaceOfferingReturns403WhenUserIsNotAuthorized() throws Exception {
    ReplaceOfferingOptions replaceOfferingOptions = new ReplaceOfferingOptions.Builder()
        .catalogIdentifier(catalogId)
        .offeringId(offeringId)
        .id(offeringId)
        .name("updated-offering-name-by-java-sdk")
        .build();
    
    // Invoke operation
    catalogManagementServiceNotAuthorized.replaceOffering(replaceOfferingOptions).execute();
  }
  
  @Test(dependsOnMethods = {"testGetOffering"},
      expectedExceptions = ConflictException.class)
  public void testReplaceOfferingReturns409WhenThereIsAConflict() throws Exception {
    ReplaceOfferingOptions replaceOfferingOptions = new ReplaceOfferingOptions.Builder()
        .catalogIdentifier(catalogId)
        .offeringId(offeringId)
        .id(offeringId)
        .name("updated-offering-name-by-java-sdk")
        .build();
    
    catalogManagementService.replaceOffering(replaceOfferingOptions).execute();
  }
  
  // it has a version related conflict
  // Once this test is enabled update the "dependsOnMethods" annotation of ListOfferings tests to this,
  // so those tests will be executed after this one
  @Test(dependsOnMethods = {"testGetOffering"})
  @Ignore
  public void testReplaceOffering() throws Exception {
    try {
      
      ReplaceOfferingOptions replaceOfferingOptions = new ReplaceOfferingOptions.Builder()
          .catalogIdentifier(catalogId)
          .offeringId(offeringId)
          .id(offeringId)
          .name("updated-offering-name-by-java-sdk")
          .build();
      
      Response<Offering> response = catalogManagementService.replaceOffering(replaceOfferingOptions).execute();
      
      assertNotNull(response);
      assertEquals(response.getStatusCode(), 200);
      
      Offering offeringResult = response.getResult();
      assertNotNull(offeringResult);
      
    } catch (ServiceResponseException e) {
      fail(String.format("Service returned status code %d: %s\nError details: %s", e.getStatusCode(), e.getMessage(),
          e.getDebuggingInfo()));
    }
  }
  
  //====
  // ListOfferings block
  //====
  
  @Test(dependsOnMethods = {"testGetOffering"},
      expectedExceptions = ForbiddenException.class)
  public void testListOfferingsReturns403WhenUserIsNotAuthorized() throws Exception {
    ListOfferingsOptions listOfferingsOptions = new ListOfferingsOptions.Builder()
        .catalogIdentifier(catalogId)
        .digest(true)
        .build();
    
    catalogManagementServiceNotAuthorized.listOfferings(listOfferingsOptions).execute();
  }
  
  @Test(dependsOnMethods = {"testGetOffering"},
      expectedExceptions = BadRequestException.class)
  public void testListOfferingsReturns400WhenBackendInputValidationFails() throws Exception {
    ListOfferingsOptions listOfferingsOptions = new ListOfferingsOptions.Builder()
        .catalogIdentifier(catalogId)
        .digest(true)
        .sort("bogus-sort-value")
        .build();
    
    catalogManagementService.listOfferings(listOfferingsOptions).execute();
  }
  
  @Test(dependsOnMethods = {"testGetOffering"},
      expectedExceptions = NotFoundException.class)
  public void testListOfferingsReturns404WhenNoSuchCatalog() throws Exception {
    ListOfferingsOptions listOfferingsOptions = new ListOfferingsOptions.Builder()
        .catalogIdentifier(bogusCatalogId)
        .digest(true)
        .build();
    
    catalogManagementService.listOfferings(listOfferingsOptions).execute();
  }
  
  @Test(dependsOnMethods = {"testGetOffering"})
  public void testListOfferings() throws Exception {
    try {
      ListOfferingsOptions listOfferingsOptions = new ListOfferingsOptions.Builder()
          .catalogIdentifier(catalogId)
          .digest(true)
          .build();
      
      Response<OfferingSearchResult> response = catalogManagementService.listOfferings(listOfferingsOptions).execute();
      
      assertNotNull(response);
      assertEquals(response.getStatusCode(), 200);
      
      OfferingSearchResult offeringSearchResultResult = response.getResult();
      assertNotNull(offeringSearchResultResult);
      
      response.getResult().getResources().stream()
          .filter(f -> f.id().equals(offeringId))
          .findAny()
          .orElseThrow(() -> new RuntimeException(String.format("No offering with id: %s", offeringId)));
      
    } catch (ServiceResponseException e) {
      fail(String.format("Service returned status code %d: %s\nError details: %s", e.getStatusCode(), e.getMessage(),
          e.getDebuggingInfo()));
    }
  }
  
  //====
  // ImportOffering block
  //====
  
  @Test(dependsOnMethods = {"testListOfferings"},
      expectedExceptions = ForbiddenException.class)
  public void testImportOfferingReturns403WhenUserIsNotAuthorized() throws Exception {
    ImportOfferingOptions importOfferingOptions = new ImportOfferingOptions.Builder()
        .catalogIdentifier(catalogId)
        .tags(new java.util.ArrayList<String>(java.util.Arrays.asList(
            "java",
            "sdk",
            "example-tag-1",
            "example-tag-2")))
        .targetKinds(new java.util.ArrayList<String>(java.util.Arrays.asList(kindRoks)))
        .zipurl("https://github.com/rhm-samples/node-red-operator/blob/master/node-red-operator/bundle/0.0" +
            ".2/node-red-operator.v0.0.2.clusterserviceversion.yaml")
        .targetVersion("0.0.2")
        .repoType(repoTypeGitPublic)
        .offeringId(offeringId)
        .xAuthToken(gitAuthToken)
        .build();
    
    catalogManagementServiceNotAuthorized.importOffering(importOfferingOptions).execute();
  }
  
  @Test(dependsOnMethods = {"testListOfferings"},
      expectedExceptions = BadRequestException.class)
  public void testImportOfferingReturns400WhenBackendInputValidationFails() throws Exception {
    ImportOfferingOptions importOfferingOptions = new ImportOfferingOptions.Builder()
        .catalogIdentifier(catalogId)
        .tags(new java.util.ArrayList<String>(java.util.Arrays.asList(
            "java",
            "sdk",
            "example-tag-1",
            "example-tag-2")))
        .targetKinds(new java.util.ArrayList<String>(java.util.Arrays.asList("rocks")))
        .zipurl("https://github.com/rhm-samples/node-red-operator/blob/master/node-red-operator/bundle/0.0" +
            ".2/node-red-operator.v0.0.2.clusterserviceversion.yaml")
        .targetVersion("0.0.2-patch")
        .repoType(repoTypeGitPublic)
        .xAuthToken(gitAuthToken)
        .build();
    
    catalogManagementService.importOffering(importOfferingOptions).execute();
  }
  
  @Test(dependsOnMethods = {"testListOfferings"},
      expectedExceptions = NotFoundException.class)
  public void testImportOfferingReturns404WhenNoSuchCatalog() throws Exception {
    ImportOfferingOptions importOfferingOptions = new ImportOfferingOptions.Builder()
        .catalogIdentifier(bogusCatalogId)
        .tags(new java.util.ArrayList<String>(java.util.Arrays.asList(
            "java",
            "sdk"
        )))
        .targetKinds(new java.util.ArrayList<String>(java.util.Arrays.asList(kindRoks)))
        .zipurl("https://github.com/rhm-samples/node-red-operator/blob/master/node-red-operator/bundle/0.0" +
            ".2/node-red-operator.v0.0.2.clusterserviceversion.yaml")
        .targetVersion("0.0.2")
        .offeringId(offeringId)
        .repoType(repoTypeGitPublic)
        .xAuthToken(gitAuthToken)
        .build();
    
    catalogManagementService.importOffering(importOfferingOptions).execute();
  }
  
  @Test(dependsOnMethods = {"testListOfferings"})
  public void testImportOffering() throws Exception {
    try {
      ImportOfferingOptions importOfferingOptions = new ImportOfferingOptions.Builder()
          .catalogIdentifier(catalogId)
          .tags(new java.util.ArrayList<String>(java.util.Arrays.asList(
              "java",
              "sdk"
          )))
          .targetKinds(new java.util.ArrayList<String>(java.util.Arrays.asList(kindRoks)))
          .zipurl("https://github.com/rhm-samples/node-red-operator/blob/master/node-red-operator/bundle/0.0" +
              ".2/node-red-operator.v0.0.2.clusterserviceversion.yaml")
          .offeringId(offeringId)
          .targetVersion("0.0.2")
          .includeConfig(true)
          .isVsi(true)
          .repoType(repoTypeGitPublic)
          .xAuthToken(gitAuthToken)
          .build();
      
      Response<Offering> response = catalogManagementService.importOffering(importOfferingOptions).execute();
      
      assertNotNull(response);
      assertEquals(response.getStatusCode(), 201);
      
      Offering offeringResult = response.getResult();
      assertNotNull(offeringResult);
      
      versionLocatorId = offeringResult.kinds().get(0).versions().get(0).versionLocator();
      assertNotNull(versionLocatorId);
      
    } catch (ServiceResponseException e) {
      fail(String.format("Service returned status code %d: %s\nError details: %s", e.getStatusCode(), e.getMessage(),
          e.getDebuggingInfo()));
    }
  }
  
  //====
  // ReloadOffering block
  //====
  
  @Test(dependsOnMethods = {"testImportOffering"},
      expectedExceptions = NotFoundException.class)
  public void testReloadOfferingReturns404WhenNoSuchOffering() throws Exception {
    ReloadOfferingOptions reloadOfferingOptions = new ReloadOfferingOptions.Builder()
        .catalogIdentifier(catalogId)
        .offeringId(bogusOfferingId)
        .targetVersion("0.0.2")
        .build();
    
    catalogManagementService.reloadOffering(reloadOfferingOptions).execute();
  }
  
  @Test(dependsOnMethods = {"testImportOffering"},
      expectedExceptions = ForbiddenException.class)
  public void testReloadOfferingReturns403WhenUserIsNotAuthorized() throws Exception {
    ReloadOfferingOptions reloadOfferingOptions = new ReloadOfferingOptions.Builder()
        .catalogIdentifier(catalogId)
        .offeringId(bogusOfferingId)
        .targetVersion("0.0.2")
        .build();
    
    catalogManagementServiceNotAuthorized.reloadOffering(reloadOfferingOptions).execute();
  }
  
  // don't have the proper data for execute this operation
  // once this test is enabled the block after it can depends on it
  @Test(dependsOnMethods = {"testImportOffering"})
  @Ignore
  public void testReloadOffering() throws Exception {
    try {
      ReloadOfferingOptions reloadOfferingOptions = new ReloadOfferingOptions.Builder()
          .catalogIdentifier(catalogId)
          .offeringId(offeringId)
          .targetVersion("0.0.2")
          .targetKinds(new java.util.ArrayList<String>(java.util.Arrays.asList(kindRoks)))
          .zipurl("https://github.com/rhm-samples/node-red-operator/blob/master/node-red-operator/bundle/0.0" +
              ".2/node-red-operator.v0.0.2.clusterserviceversion.yaml")
          .repoType(repoTypeGitPublic)
          .build();
      
      Response<Offering> response = catalogManagementService.reloadOffering(reloadOfferingOptions).execute();
      
      assertNotNull(response);
      assertEquals(response.getStatusCode(), 201);
      
      Offering offeringResult = response.getResult();
      assertNotNull(offeringResult);
      
    } catch (ServiceResponseException e) {
      fail(String.format("Service returned status code %d: %s\nError details: %s", e.getStatusCode(), e.getMessage(),
          e.getDebuggingInfo()));
    }
  }
  
  //====
  // Create Object block
  //====
  
  @Test(dependsOnMethods = {"testImportOffering"},
      expectedExceptions = BadRequestException.class)
  public void testCreateObjectReturns400WhenBackendInputValidationFails() throws Exception {
    PublishObject publishObjectModel = new PublishObject.Builder()
        .permitIbmPublicPublish(true)
        .ibmApproved(true)
        .publicApproved(true)
        .build();
    //
    State stateModel = new State.Builder()
        .current("new")
        .build();
    
    CreateObjectOptions createObjectOptions = new CreateObjectOptions.Builder()
        .catalogIdentifier(catalogId)
        .name(objectName)
        .crn("crn:v1:bluemix:public:iam-global-endpoint:global:::endpoint:private.iam.cloud.ibm.com")
        .url("test.ibm.hu")
        .kind(kindVpe)
        .publish(publishObjectModel)
        .state(stateModel)
        .catalogId(catalogId)
        .parentId("bogus region name")
        .build();
    
    catalogManagementService.createObject(createObjectOptions).execute();
  }
  
  @Test(dependsOnMethods = {"testImportOffering"},
      expectedExceptions = ForbiddenException.class)
  public void testCreateObjectReturns403WhenUserIsNotAuthorized() throws Exception {
    PublishObject publishObjectModel = new PublishObject.Builder()
        .permitIbmPublicPublish(true)
        .ibmApproved(true)
        .publicApproved(true)
        .build();
    State stateModel = new State.Builder()
        .current("new")
        .build();
    
    CreateObjectOptions createObjectOptions = new CreateObjectOptions.Builder()
        .catalogIdentifier(catalogId)
        .name(objectName)
        .crn("crn:v1:bluemix:public:iam-global-endpoint:global:::endpoint:private.iam.cloud.ibm.com")
        .url("test.ibm.hu")
        .parentId(regionUsSouth)
        .kind(kindVpe)
        .publish(publishObjectModel)
        .state(stateModel)
        .catalogId(catalogId)
        .build();
    
    catalogManagementServiceNotAuthorized.createObject(createObjectOptions).execute();
  }
  
  @Test(dependsOnMethods = {"testImportOffering"})
  public void testCreateObject() throws Exception {
    try {
      PublishObject publishObjectModel = new PublishObject.Builder()
          .permitIbmPublicPublish(true)
          .ibmApproved(true)
          .publicApproved(true)
          .build();
      //
      State stateModel = new State.Builder()
          .current("new")
          .build();
      
      CreateObjectOptions createObjectOptions = new CreateObjectOptions.Builder()
          .catalogIdentifier(catalogId)
          .name(objectName)
          .crn("crn:v1:bluemix:public:iam-global-endpoint:global:::endpoint:private.iam.cloud.ibm.com")
          .url("test.ibm.hu")
          .parentId(regionUsSouth)
          .kind(kindVpe)
          .publish(publishObjectModel)
          .state(stateModel)
          .catalogId(catalogId)
          .build();
      
      Response<CatalogObject> response = catalogManagementService.createObject(createObjectOptions).execute();
      
      assertNotNull(response);
      assertEquals(response.getStatusCode(), 201);
      
      CatalogObject catalogObjectResult = response.getResult();
      assertNotNull(catalogObjectResult);
      objectId = catalogObjectResult.id();
      assertNotNull(objectId);
      
    } catch (ServiceResponseException e) {
      fail(String.format("Service returned status code %d: %s\nError details: %s", e.getStatusCode(), e.getMessage(),
          e.getDebuggingInfo()));
    }
  }
  
  //====
  // Get Offering Audit block
  //====
  
  @Test(dependsOnMethods = {"testImportOffering"})
  public void testGetOfferingAuditReturns200WhenNoSuchOfferings() throws Exception {
    try {
      GetOfferingAuditOptions getOfferingAuditOptions = new GetOfferingAuditOptions.Builder()
          .catalogIdentifier(catalogId)
          .offeringId(offeringId + "c")
          .build();
      
      Response<AuditLog> response = catalogManagementService.getOfferingAudit(getOfferingAuditOptions).execute();
      
      assertNotNull(response);
      assertEquals(response.getStatusCode(), 200);
      
      AuditLog auditLogResult = response.getResult();
      assertNotNull(auditLogResult);
      
    } catch (ServiceResponseException e) {
      fail(String.format("Service returned status code %d: %s\nError details: %s", e.getStatusCode(), e.getMessage(),
          e.getDebuggingInfo()));
    }
  }
  
  @Test(dependsOnMethods = {"testImportOffering"},
      expectedExceptions = ForbiddenException.class)
  public void testGetOfferingAuditReturns403WhenUserIsNotAuthorized() throws Exception {
    GetOfferingAuditOptions getOfferingAuditOptions =
        new GetOfferingAuditOptions.Builder()
            .catalogIdentifier(catalogId)
            .offeringId(offeringId)
            .build();
    
    catalogManagementServiceNotAuthorized.getOfferingAudit(getOfferingAuditOptions).execute();
  }
  
  @Test(dependsOnMethods = {"testImportOffering"})
  public void testGetOfferingAudit() throws Exception {
    try {
      GetOfferingAuditOptions getOfferingAuditOptions = new GetOfferingAuditOptions.Builder()
          .catalogIdentifier(catalogId)
          .offeringId(offeringId)
          .build();
      
      Response<AuditLog> response = catalogManagementService.getOfferingAudit(getOfferingAuditOptions).execute();
      
      assertNotNull(response);
      assertEquals(response.getStatusCode(), 200);
      
      AuditLog auditLogResult = response.getResult();
      assertNotNull(auditLogResult);
      
    } catch (ServiceResponseException e) {
      fail(String.format("Service returned status code %d: %s\nError details: %s", e.getStatusCode(), e.getMessage(),
          e.getDebuggingInfo()));
    }
  }
  
  //====
  // Get Catalog Account block
  //====
  
  @Test(dependsOnMethods = {"testGetOfferingAudit"})
  public void testGetCatalogAccountReturns200WhenUserIsNotAuthorized() throws Exception {
    try {
      Response<Account> response = catalogManagementServiceNotAuthorized.getCatalogAccount()
          .execute();
      
      assertNotNull(response);
      assertEquals(response.getStatusCode(), 200);
    } catch (ServiceResponseException e) {
      fail(String.format("Service returned status code %d: %s\nError details: %s", e.getStatusCode(), e.getMessage(),
          e.getDebuggingInfo()));
    }
  }
  
  @Test(dependsOnMethods = {"testGetOfferingAudit"})
  public void testGetCatalogAccount() throws Exception {
    try {
      Response<Account> response = catalogManagementService.getCatalogAccount().execute();
      
      assertNotNull(response);
      assertEquals(response.getStatusCode(), 200);
      
      Account accountResult = response.getResult();
      assertNotNull(accountResult);
      assertEquals(accountResult.id(), accountId);
      
    } catch (ServiceResponseException e) {
      fail(String.format("Service returned status code %d: %s\nError details: %s", e.getStatusCode(), e.getMessage(),
          e.getDebuggingInfo()));
    }
  }
  
  //====
  // Update Catalog Account block
  //====
  
  @Test(dependsOnMethods = {"testGetCatalogAccount"},
      expectedExceptions = BadRequestException.class)
  public void testUpdateCatalogAccountReturns400WhenNoSuchCatalogAccount() throws Exception {
    UpdateCatalogAccountOptions updateCatalogAccountOptions = new UpdateCatalogAccountOptions.Builder()
        .id("bogus-account-id")
        .build();
    
    catalogManagementService.updateCatalogAccount(updateCatalogAccountOptions).execute();
  }
  
  @Test(expectedExceptions = ForbiddenException.class)
  public void testUpdateCatalogAccountReturns403WhenUserIsNotAuthorized() throws Exception {
    UpdateCatalogAccountOptions updateCatalogAccountOptions = new UpdateCatalogAccountOptions.Builder()
        .id(accountId)
        .build();
    
    catalogManagementServiceNotAuthorized.updateCatalogAccount(updateCatalogAccountOptions).execute();
  }
  
  // once this one is not ignored the following block dependency can point here
  @Test(dependsOnMethods = {"testGetCatalogAccount"})
  @Ignore
  public void testUpdateCatalogAccount() throws Exception {
    try {
      FilterTerms includedFilterTermsModel =
          new FilterTerms.Builder().filterTerms(new java.util.ArrayList<String>(java.util.Arrays
              .asList("included " + "filter" + " term - 1", "included " + "filter term - 2"))).build();
      
      CategoryFilter includedCategoryFilterModel = new CategoryFilter.Builder().include(true)
          .filter(includedFilterTermsModel)
          .build();
      
      FilterTerms excludedFilterTermsModel =
          new FilterTerms.Builder().filterTerms(new ArrayList<String>(Arrays.asList("excluded filter term - 1",
              "excluded filter term - 2")))
              .build();
      
      CategoryFilter excludedCategoryFilterModel = new CategoryFilter.Builder().include(true)
          .filter(excludedFilterTermsModel)
          .build();
      
      Filters filtersModel = new Filters.Builder().includeAll(true)
          .categoryFilters(new java.util.HashMap<String, CategoryFilter>() {
            {
              put("included-category-filter", includedCategoryFilterModel);
              put("excluded-category-filter", excludedCategoryFilterModel);
            }
          })
          .build();
      
      UpdateCatalogAccountOptions updateCatalogAccountOptions = new UpdateCatalogAccountOptions.Builder()
          .id(accountId)
          .hideIbmCloudCatalog(false)
          .accountFilters(filtersModel)
          .build();
      
      Response<Void> response = catalogManagementService.updateCatalogAccount(updateCatalogAccountOptions).execute();
      
      assertNotNull(response);
      assertEquals(response.getStatusCode(), 200);
      
    } catch (ServiceResponseException e) {
      fail(String.format("Service returned status code %d: %s\nError details: %s", e.getStatusCode(), e.getMessage(),
          e.getDebuggingInfo()));
    }
  }
  
  //====
  // Get Catalog Account Audit
  //====
  
  @Test(dependsOnMethods = {"testGetCatalogAccount"},
      expectedExceptions = ForbiddenException.class)
  public void testGetCatalogAccountAuditReturns403WhenUserIsNotAuthorized() {
    
    catalogManagementServiceNotAuthorized.getCatalogAccountAudit().execute();
  }
  
  @Test(dependsOnMethods = {"testGetCatalogAccount"})
  public void testGetCatalogAccountAudit() throws Exception {
    try {
      Response<AuditLog> response = catalogManagementService.getCatalogAccountAudit().execute();
      
      assertNotNull(response);
      assertEquals(response.getStatusCode(), 200);
      
      AuditLog auditLogResult = response.getResult();
      assertNotNull(auditLogResult);
      
    } catch (ServiceResponseException e) {
      fail(String.format("Service returned status code %d: %s\nError details: %s", e.getStatusCode(), e.getMessage(),
          e.getDebuggingInfo()));
    }
  }
  
  //====
  // Get Catalog Account Filters
  //====
  
  @Test(dependsOnMethods = {"testGetCatalogAccountAudit"},
      expectedExceptions = NotFoundException.class)
  public void testGetCatalogAccountFiltersReturns404WhenNoSuchCatalog() throws Exception {
    GetCatalogAccountFiltersOptions getCatalogAccountFiltersOptions = new GetCatalogAccountFiltersOptions.Builder()
        .catalog(catalogId + "c")
        .build();
    
    catalogManagementService.getCatalogAccountFilters(getCatalogAccountFiltersOptions).execute();
  }
  
  @Test(dependsOnMethods = {"testGetCatalogAccountAudit"},
      expectedExceptions = ForbiddenException.class)
  public void testGetCatalogAccountFiltersReturns403WhenUserIsNotAuthorized() throws Exception {
    GetCatalogAccountFiltersOptions getCatalogAccountFiltersOptions = new GetCatalogAccountFiltersOptions.Builder()
        .catalog(catalogId)
        .build();
    
    catalogManagementServiceNotAuthorized.getCatalogAccountFilters(getCatalogAccountFiltersOptions).execute();
  }
  
  @Test(dependsOnMethods = {"testGetCatalogAccountAudit"})
  public void testGetCatalogAccountFilters() throws Exception {
    try {
      GetCatalogAccountFiltersOptions getCatalogAccountFiltersOptions = new GetCatalogAccountFiltersOptions.Builder()
          .catalog(catalogId)
          .build();
      
      Response<AccumulatedFilters> response =
          catalogManagementService.getCatalogAccountFilters(getCatalogAccountFiltersOptions)
              .execute();
      
      assertNotNull(response);
      assertEquals(response.getStatusCode(), 200);
      
      AccumulatedFilters accumulatedFiltersResult = response.getResult();
      assertNotNull(accumulatedFiltersResult);
      
    } catch (ServiceResponseException e) {
      fail(String.format("Service returned status code %d: %s\nError details: %s", e.getStatusCode(), e.getMessage(),
          e.getDebuggingInfo()));
    }
  }
  
  //====
  // Get Catalog Audit block
  //====
  
  @Test(dependsOnMethods = {"testGetCatalogAccountFilters"},
      expectedExceptions = NotFoundException.class)
  public void testGetCatalogAuditReturns404WhenNoSuchCatalog() throws Exception {
    GetCatalogAuditOptions getCatalogAuditOptions = new GetCatalogAuditOptions.Builder()
        .catalogIdentifier(catalogId + "c")
        .build();
    
    catalogManagementService.getCatalogAudit(getCatalogAuditOptions).execute();
  }
  
  @Test(dependsOnMethods = {"testGetCatalogAccountFilters"},
      expectedExceptions = ForbiddenException.class)
  public void testGetCatalogAuditReturns403WhenUserIsNotAuthorized() throws Exception {
    GetCatalogAuditOptions getCatalogAuditOptions = new GetCatalogAuditOptions.Builder()
        .catalogIdentifier(catalogId)
        .build();
    
    catalogManagementServiceNotAuthorized.getCatalogAudit(getCatalogAuditOptions).execute();
  }
  
  @Test(dependsOnMethods = {"testGetCatalogAccountFilters"})
  public void testGetCatalogAudit() throws Exception {
    try {
      GetCatalogAuditOptions getCatalogAuditOptions = new GetCatalogAuditOptions.Builder()
          .catalogIdentifier(catalogId)
          .build();
      
      Response<AuditLog> response = catalogManagementService.getCatalogAudit(getCatalogAuditOptions).execute();
      
      assertNotNull(response);
      assertEquals(response.getStatusCode(), 200);
      
      AuditLog auditLogResult = response.getResult();
      assertNotNull(auditLogResult);
      
    } catch (ServiceResponseException e) {
      fail(String.format("Service returned status code %d: %s\nError details: %s", e.getStatusCode(), e.getMessage(),
          e.getDebuggingInfo()));
    }
  }
  
  //====
  // Get Consumption Offerings block
  //====
  
  @Test(dependsOnMethods = {"testGetCatalogAudit"},
      expectedExceptions = ForbiddenException.class)
  public void testGetConsumptionOfferingsReturns403WhenUserIsNotAuthorized() throws Exception {
    GetConsumptionOfferingsOptions getConsumptionOfferingsOptions = new GetConsumptionOfferingsOptions.Builder()
        .digest(true)
        .catalog(catalogId)
        .select("all")
        .includeHidden(true)
        .build();
    
    catalogManagementServiceNotAuthorized.getConsumptionOfferings(getConsumptionOfferingsOptions)
        .execute();
  }
  
  @Test(dependsOnMethods = {"testGetCatalogAudit"},
      expectedExceptions = NotFoundException.class)
  public void testGetConsumptionOfferingsReturns404WhenNoSuchConsumptionOfferings() throws Exception {
    GetConsumptionOfferingsOptions getConsumptionOfferingsOptions =
        new GetConsumptionOfferingsOptions.Builder()
            .digest(true)
            .catalog(bogusCatalogId)
            .select("all")
            .includeHidden(true)
            .build();
    
    catalogManagementService.getConsumptionOfferings(getConsumptionOfferingsOptions)
        .execute();
  }
  
  @Test(dependsOnMethods = {"testGetCatalogAudit"})
  public void testGetConsumptionOfferings() throws Exception {
    try {
      GetConsumptionOfferingsOptions getConsumptionOfferingsOptions = new GetConsumptionOfferingsOptions.Builder()
          .digest(true)
          .catalog(catalogId)
          .select("all")
          .includeHidden(true)
          .build();
      
      Response<OfferingSearchResult> response =
          catalogManagementService.getConsumptionOfferings(getConsumptionOfferingsOptions)
              .execute();
      
      assertNotNull(response);
      assertEquals(response.getStatusCode(), 200);
      
      OfferingSearchResult offeringSearchResultResult = response.getResult();
      assertNotNull(offeringSearchResultResult);
      
    } catch (ServiceResponseException e) {
      fail(String.format("Service returned status code %d: %s\nError details: %s", e.getStatusCode(), e.getMessage(),
          e.getDebuggingInfo()));
    }
  }
  
  //====
  // Import Offering Version block
  //====
  
  @Test(dependsOnMethods = {"testGetConsumptionOfferings"},
      expectedExceptions = BadRequestException.class)
  public void testImportOfferingVersionReturns400WhenBackendInputValidationFails() throws Exception {
    ImportOfferingVersionOptions importOfferingVersionOptions =
        new ImportOfferingVersionOptions.Builder()
            .catalogIdentifier(catalogId)
            .offeringId(offeringId)
            .targetKinds(new java.util.ArrayList<String>(java.util.Arrays.asList("rocks")))
            .zipurl("https://github.com/rhm-samples/node-red-operator/blob/master/node-red-operator/bundle/0.0" +
                ".2/node-red-operator.v0.0.2.clusterserviceversion.yaml")
            .targetVersion("0.0.2-patch")
            .repoType(repoTypeGitPublic)
            .build();
    
    catalogManagementService.importOfferingVersion(importOfferingVersionOptions).execute();
  }
  
  @Test(dependsOnMethods = {"testGetConsumptionOfferings"},
      expectedExceptions = NotFoundException.class)
  public void testImportOfferingVersionReturns404WhenNoSuchOfferings() throws Exception {
    ImportOfferingVersionOptions importOfferingVersionOptions =
        new ImportOfferingVersionOptions.Builder()
            .catalogIdentifier(catalogId)
            .offeringId(bogusOfferingId)
            .build();
    
    catalogManagementService.importOfferingVersion(importOfferingVersionOptions).execute();
  }
  
  @Test(dependsOnMethods = {"testGetConsumptionOfferings"},
      expectedExceptions = ForbiddenException.class)
  public void testImportOfferingVersionReturns403WhenUserIsNotAuthorized() throws Exception {
    ImportOfferingVersionOptions importOfferingVersionOptions = new ImportOfferingVersionOptions.Builder()
        .catalogIdentifier(catalogId)
        .offeringId(offeringId)
        .build();
    
    catalogManagementServiceNotAuthorized.importOfferingVersion(importOfferingVersionOptions).execute();
  }
  
  @Test(dependsOnMethods = {"testGetConsumptionOfferings"})
  public void testImportOfferingVersion() throws Exception {
    try {
      ImportOfferingVersionOptions importOfferingVersionOptions = new ImportOfferingVersionOptions.Builder()
          .catalogIdentifier(catalogId)
          .offeringId(offeringId)
          .zipurl("https://github.com/rhm-samples/node-red-operator/blob/master/node-red-operator/bundle/0.0" +
              ".2/node-red-operator.v0.0.2.clusterserviceversion.yaml")
          .targetVersion("0.0.3")
          .repoType(repoTypeGitPublic)
          .build();
      
      Response<Offering> response = catalogManagementService.importOfferingVersion(importOfferingVersionOptions)
          .execute();
      
      assertNotNull(response);
      assertEquals(response.getStatusCode(), 201);
      
      Offering offeringResult = response.getResult();
      assertNotNull(offeringResult);
      
    } catch (ServiceResponseException e) {
      fail(String.format("Service returned status code %d: %s\nError details: %s", e.getStatusCode(), e.getMessage(),
          e.getDebuggingInfo()));
    }
  }
  
  //====
  // Replace Offering Icon block
  //====
  
  // this function is disabled
  // once it is enabled the following block dependency can point here
  @Test(dependsOnMethods = {"testImportOfferingVersion"})
  @Ignore
  public void testReplaceOfferingIcon() throws Exception {
    try {
      ReplaceOfferingIconOptions replaceOfferingIconOptions = new ReplaceOfferingIconOptions.Builder()
          .catalogIdentifier(catalogId)
          .offeringId(offeringId)
          .fileName("testString")
          .build();
      
      Response<Offering> response = catalogManagementService.replaceOfferingIcon(replaceOfferingIconOptions).execute();
      
      assertNotNull(response);
      assertEquals(response.getStatusCode(), 200);
      
      Offering offeringResult = response.getResult();
      assertNotNull(offeringResult);
      
    } catch (ServiceResponseException e) {
      fail(String.format("Service returned status code %d: %s\nError details: %s", e.getStatusCode(), e.getMessage(),
          e.getDebuggingInfo()));
    }
  }
  
  @Test(dependsOnMethods = {"testImportOfferingVersion"},
      expectedExceptions = NotFoundException.class)
  @Ignore
  public void testReplaceOfferingIconReturns404WhenNoSuchOffering() throws Exception {
    ReplaceOfferingIconOptions replaceOfferingIconOptions = new ReplaceOfferingIconOptions.Builder()
        .catalogIdentifier(catalogId)
        .offeringId(offeringId)
        .fileName("filename")
        .build();
    
    catalogManagementService.replaceOfferingIcon(replaceOfferingIconOptions).execute();
  }
  
  @Test(dependsOnMethods = {"testImportOfferingVersion"},
      expectedExceptions = ForbiddenException.class)
  @Ignore
  public void testReplaceOfferingIconReturns403WhenUserIsNotAuthorized() throws Exception {
    ReplaceOfferingIconOptions replaceOfferingIconOptions = new ReplaceOfferingIconOptions.Builder()
        .catalogIdentifier(catalogId)
        .offeringId(offeringId)
        .fileName("filename")
        .build();
    
    catalogManagementServiceNotAuthorized.replaceOfferingIcon(replaceOfferingIconOptions).execute();
  }
  
  //====
  // Update Offering IBM
  //====
  
  // this user is not allowed to execute this operation
  @Test(dependsOnMethods = {"testImportOfferingVersion"},
      expectedExceptions = NotFoundException.class)
  @Ignore
  public void testUpdateOfferingIbmReturns404WhenNoSuchOffering() throws Exception {
    UpdateOfferingIbmOptions updateOfferingIbmOptions = new UpdateOfferingIbmOptions.Builder()
        .catalogIdentifier(catalogId)
        .offeringId(bogusOfferingId)
        .approvalType("allow_request")
        .approved("true")
        .build();
    
    catalogManagementService.updateOfferingIbm(updateOfferingIbmOptions).execute();
  }
  
  @Test(dependsOnMethods = {"testImportOfferingVersion"},
      expectedExceptions = ForbiddenException.class)
  public void testUpdateOfferingIbmReturns403WhenUserIsNotAuthorized() throws Exception {
    UpdateOfferingIbmOptions updateOfferingIbmOptions = new UpdateOfferingIbmOptions.Builder()
        .catalogIdentifier(catalogId)
        .offeringId(offeringId)
        .approvalType("allow_request")
        .approved("true")
        .build();
    
    catalogManagementServiceNotAuthorized.updateOfferingIbm(updateOfferingIbmOptions).execute();
  }
  
  // this user is not permitted to execute this operation
  // once this test enabled the following block's dependency can point here
  @Test(dependsOnMethods = {"testImportOfferingVersion"})
  @Ignore
  public void testUpdateOfferingIbm() throws Exception {
    try {
      UpdateOfferingIbmOptions updateOfferingIbmOptions = new UpdateOfferingIbmOptions.Builder()
          .catalogIdentifier(catalogId)
          .offeringId(offeringId)
          .approvalType("allow_request")
          .approved("true")
          .build();
      
      Response<ApprovalResult> response = catalogManagementService.updateOfferingIbm(updateOfferingIbmOptions)
          .execute();
      
      assertNotNull(response);
      assertEquals(response.getStatusCode(), 200);
      
      ApprovalResult approvalResultResult = response.getResult();
      assertNotNull(approvalResultResult);
      
    } catch (ServiceResponseException e) {
      fail(String.format("Service returned status code %d: %s\nError details: %s", e.getStatusCode(), e.getMessage(),
          e.getDebuggingInfo()));
    }
  }
  
  //====
  // Get Offering Updates
  //====
  
  @Test(dependsOnMethods = {"testImportOfferingVersion"},
      expectedExceptions = BadRequestException.class)
  public void testGetOfferingUpdatesReturns400WhenBackendInputValidationFails() throws Exception {
    GetOfferingUpdatesOptions getOfferingUpdatesOptions = new GetOfferingUpdatesOptions.Builder()
        .catalogIdentifier(catalogId)
        .offeringId(offeringId)
        .kind("rocks")
        .version("0.0.2")
        .clusterId(clusterId)
        .region("us-south-32")
        .build();
    
    catalogManagementService.getOfferingUpdates(getOfferingUpdatesOptions).execute();
  }
  
  @Test(dependsOnMethods = {"testImportOfferingVersion"},
      expectedExceptions = ForbiddenException.class)
  public void testGetOfferingUpdatesReturns403WhenUserIsNotAuthorized() throws Exception {
    GetOfferingUpdatesOptions getOfferingUpdatesOptions = new GetOfferingUpdatesOptions.Builder()
        .catalogIdentifier(catalogId)
        .offeringId(offeringId)
        .kind(kindRoks)
        .version("0.0.2")
        .clusterId(clusterId)
        .region(regionUsSouth)
        .namespace(namespaceJavaSdk)
        .build();
    
    catalogManagementServiceNotAuthorized.getOfferingUpdates(getOfferingUpdatesOptions).execute();
  }
  
  // once this test is enabled the next block's dependency can point here
  @Test(dependsOnMethods = {"testImportOfferingVersion"})
  @Ignore
  public void testGetOfferingUpdates() throws Exception {
    try {
      GetOfferingUpdatesOptions getOfferingUpdatesOptions = new GetOfferingUpdatesOptions.Builder()
          .catalogIdentifier(catalogId)
          .offeringId(offeringId)
          .kind(kindRoks)
          .version("0.0.2")
          .clusterId(clusterId)
          .region(regionUsSouth)
          .namespace(namespaceJavaSdk)
          .build();
      
      Response<List<VersionUpdateDescriptor>> response =
          catalogManagementService.getOfferingUpdates(getOfferingUpdatesOptions)
              .execute();
      
      assertNotNull(response);
      assertEquals(response.getStatusCode(), 200);
      
      List<VersionUpdateDescriptor> listVersionUpdateDescriptorResult = response.getResult();
      assertNotNull(listVersionUpdateDescriptorResult);
      
    } catch (ServiceResponseException e) {
      fail(String.format("Service returned status code %d: %s\nError details: %s", e.getStatusCode(), e.getMessage(),
          e.getDebuggingInfo()));
    }
  }
  
  //====
  // Get Offering Abouts block
  //====
  
  @Test(dependsOnMethods = {"testImportOfferingVersion"},
      expectedExceptions = BadRequestException.class)
  public void testGetOfferingAboutReturns400WhenValidationFails() throws Exception {
    GetOfferingAboutOptions getOfferingAboutOptions = new GetOfferingAboutOptions.Builder()
        .versionLocId(bogusVersionLocatorId)
        .build();
    
    catalogManagementService.getOfferingAbout(getOfferingAboutOptions).execute();
  }
  
  @Test(dependsOnMethods = {"testImportOfferingVersion"},
      expectedExceptions = BadRequestException.class)
  public void testGetOfferingAboutReturns400WhenNoSuchOfferingAbout() throws Exception {
    GetOfferingAboutOptions getOfferingAboutOptions = new GetOfferingAboutOptions.Builder()
        .versionLocId(versionLocatorId + 'c')
        .build();
    
    catalogManagementService.getOfferingAbout(getOfferingAboutOptions).execute();
  }
  
  @Test(dependsOnMethods = {"testImportOfferingVersion"},
      expectedExceptions = ForbiddenException.class)
  public void testGetOfferingAboutReturns403WhenUserIsNotAuthorized() throws Exception {
    GetOfferingAboutOptions getOfferingAboutOptions = new GetOfferingAboutOptions.Builder()
        .versionLocId(versionLocatorId)
        .build();
    
    catalogManagementServiceNotAuthorized.getOfferingAbout(getOfferingAboutOptions).execute();
  }
  
  @Test(dependsOnMethods = {"testImportOfferingVersion"})
  public void testGetOfferingAbout() throws Exception {
    try {
      GetOfferingAboutOptions getOfferingAboutOptions = new GetOfferingAboutOptions.Builder()
          .versionLocId(versionLocatorId)
          .build();
      
      Response<String> response = catalogManagementService.getOfferingAbout(getOfferingAboutOptions).execute();
      
      assertNotNull(response);
      assertEquals(response.getStatusCode(), 200);
      
      String resultResult = response.getResult();
      assertNotNull(resultResult);
      
    } catch (ServiceResponseException e) {
      fail(String.format("Service returned status code %d: %s\nError details: %s", e.getStatusCode(), e.getMessage(),
          e.getDebuggingInfo()));
    }
  }
  
  //====
  // Get Offering License
  //====
  
  @Test(dependsOnMethods = {"testGetOfferingAbout"},
      expectedExceptions = BadRequestException.class)
  public void testGetOfferingLicenseReturns400WhenBackendInputValidationFails() throws Exception {
    GetOfferingLicenseOptions getOfferingLicenseOptions = new GetOfferingLicenseOptions.Builder()
        .versionLocId(bogusVersionLocatorId)
        .licenseId(bogusLicenseId)
        .build();
    
    catalogManagementService.getOfferingLicense(getOfferingLicenseOptions).execute();
  }
  
  @Test(dependsOnMethods = {"testGetOfferingAbout"},
      expectedExceptions = BadRequestException.class)
  public void testGetOfferingLicenseReturns404WhenNoSuchOfferingLicense() throws Exception {
    GetOfferingLicenseOptions getOfferingLicenseOptions = new GetOfferingLicenseOptions.Builder()
        .versionLocId(versionLocatorId)
        .licenseId(bogusLicenseId)
        .build();
    
    catalogManagementService.getOfferingLicense(getOfferingLicenseOptions).execute();
  }
  
  @Test(dependsOnMethods = {"testGetOfferingAbout"},
      expectedExceptions = ForbiddenException.class)
  @Ignore
  public void testGetOfferingLicenseReturns403WhenUserIsNotAuthorized() throws Exception {
    GetOfferingLicenseOptions getOfferingLicenseOptions = new GetOfferingLicenseOptions.Builder()
        .versionLocId(versionLocatorId)
        .licenseId("license-id-is-needed")
        .build();
    
    catalogManagementServiceNotAuthorized.getOfferingLicense(getOfferingLicenseOptions).execute();
  }
  
  // once this test is enabled the next block's dependency can point here
  @Test(dependsOnMethods = {"testGetOfferingAbout"})
  @Ignore
  public void testGetOfferingLicense() throws Exception {
    try {
      GetOfferingLicenseOptions getOfferingLicenseOptions = new GetOfferingLicenseOptions.Builder()
          .versionLocId(versionLocatorId)
          .licenseId("license-id-is-needed")
          .build();
      
      Response<String> response = catalogManagementService.getOfferingLicense(getOfferingLicenseOptions).execute();
      
      assertNotNull(response);
      assertEquals(response.getStatusCode(), 200);
      
      String resultResult = response.getResult();
      assertNotNull(resultResult);
      
    } catch (ServiceResponseException e) {
      fail(String.format("Service returned status code %d: %s\nError details: %s", e.getStatusCode(), e.getMessage(),
          e.getDebuggingInfo()));
    }
  }
  
  //====
  // Get Offering Container Images block
  //====
  
  @Test(dependsOnMethods = {"testGetOfferingAbout"},
      expectedExceptions = BadRequestException.class)
  public void testGetOfferingContainerImagesReturns400WhenBackendInputValidationFails() throws Exception {
    GetOfferingContainerImagesOptions getOfferingContainerImagesOptions =
        new GetOfferingContainerImagesOptions.Builder()
            .versionLocId(bogusVersionLocatorId)
            .build();
    
    catalogManagementService.getOfferingContainerImages(getOfferingContainerImagesOptions)
        .execute();
  }
  
  @Test(dependsOnMethods = {"testGetOfferingAbout"},
      expectedExceptions = BadRequestException.class)
  public void testGetOfferingContainerImagesReturns404WhenNoSuchVersionLocId() throws Exception {
    GetOfferingContainerImagesOptions getOfferingContainerImagesOptions =
        new GetOfferingContainerImagesOptions.Builder()
            .versionLocId(versionLocatorId + "c")
            .build();
    
    catalogManagementService.getOfferingContainerImages(getOfferingContainerImagesOptions)
        .execute();
  }
  
  @Test(dependsOnMethods = {"testGetOfferingAbout"},
      expectedExceptions = ForbiddenException.class)
  public void testGetOfferingContainerImagesReturns403WhenUserIsNotAuthorized() throws Exception {
    GetOfferingContainerImagesOptions getOfferingContainerImagesOptions =
        new GetOfferingContainerImagesOptions.Builder()
            .versionLocId(versionLocatorId)
            .build();
    
    catalogManagementServiceNotAuthorized.getOfferingContainerImages(getOfferingContainerImagesOptions)
        .execute();
  }
  
  @Test(dependsOnMethods = {"testGetOfferingAbout"})
  public void testGetOfferingContainerImages() throws Exception {
    try {
      GetOfferingContainerImagesOptions getOfferingContainerImagesOptions =
          new GetOfferingContainerImagesOptions.Builder()
              .versionLocId(versionLocatorId)
              .build();
      
      Response<ImageManifest> response =
          catalogManagementService.getOfferingContainerImages(getOfferingContainerImagesOptions)
              .execute();
      
      assertNotNull(response);
      assertEquals(response.getStatusCode(), 200);
      
      ImageManifest imageManifestResult = response.getResult();
      assertNotNull(imageManifestResult);
      
    } catch (ServiceResponseException e) {
      fail(String.format("Service returned status code %d: %s\nError details: %s", e.getStatusCode(), e.getMessage(),
          e.getDebuggingInfo()));
    }
  }
  
  //====
  // Deprecate Version
  //====
  
  @Test(dependsOnMethods = {"testGetOfferingContainerImages"},
      expectedExceptions = BadRequestException.class)
  public void testDeprecateVersionReturns400WhenBackendInputValidationFails() throws Exception {
    DeprecateVersionOptions deprecateVersionOptions = new DeprecateVersionOptions.Builder()
        .versionLocId(bogusVersionLocatorId)
        .build();
    
    catalogManagementService.deprecateVersion(deprecateVersionOptions).execute();
  }
  
  @Test(dependsOnMethods = {"testGetOfferingContainerImages"},
      expectedExceptions = ForbiddenException.class)
  public void testDeprecateVersionReturns403WhenUserIsNotAuthorized() throws Exception {
    DeprecateVersionOptions deprecateVersionOptions = new DeprecateVersionOptions.Builder()
        .versionLocId(versionLocatorId)
        .build();
    
    catalogManagementServiceNotAuthorized.deprecateVersion(deprecateVersionOptions).execute();
  }
  
  @Test(dependsOnMethods = {"testGetOfferingContainerImages"},
      expectedExceptions = NotFoundException.class)
  public void testDeprecateVersionReturns404WhenNoSuchVersion() throws Exception {
    DeprecateVersionOptions deprecateVersionOptions = new DeprecateVersionOptions.Builder()
        .versionLocId(versionLocatorId + "c")
        .build();
    
    catalogManagementService.deprecateVersion(deprecateVersionOptions).execute();
  }
  
  // order of states are unknown yet
  // once this test is enabled the next block's dependency can point here
  @Test(dependsOnMethods = {"testGetOfferingContainerImages"})
  @Ignore
  public void testDeprecateVersion() throws Exception {
    try {
      DeprecateVersionOptions deprecateVersionOptions = new DeprecateVersionOptions.Builder()
          .versionLocId(versionLocatorId)
          .build();
      
      Response<Void> response = catalogManagementService.deprecateVersion(deprecateVersionOptions).execute();
      
      assertNotNull(response);
      assertEquals(response.getStatusCode(), 202);
      
    } catch (ServiceResponseException e) {
      fail(String.format("Service returned status code %d: %s\nError details: %s", e.getStatusCode(), e.getMessage(),
          e.getDebuggingInfo()));
    }
  }
  
  //====
  // Account Publish Version block
  //====
  
  @Test(dependsOnMethods = {"testGetOfferingContainerImages"},
      expectedExceptions = BadRequestException.class)
  public void testAccountPublishVersionReturns400WhenBackendInputValidationFails() throws Exception {
    AccountPublishVersionOptions accountPublishVersionOptions = new AccountPublishVersionOptions.Builder()
        .versionLocId(bogusVersionLocatorId)
        .build();
    
    catalogManagementService.accountPublishVersion(accountPublishVersionOptions).execute();
  }
  
  @Test(dependsOnMethods = {"testGetOfferingContainerImages"},
      expectedExceptions = BadRequestException.class)
  public void testAccountPublishVersionReturns400WhenNoSuchVersion() throws Exception {
    AccountPublishVersionOptions accountPublishVersionOptions = new AccountPublishVersionOptions.Builder()
        .versionLocId(versionLocatorId + "6")
        .build();
    
    catalogManagementService.accountPublishVersion(accountPublishVersionOptions).execute();
  }
  
  @Test(dependsOnMethods = {"testGetOfferingContainerImages"},
      expectedExceptions = ForbiddenException.class)
  public void testAccountPublishVersionReturns403WhenUserIsNotAuthorized() throws Exception {
    AccountPublishVersionOptions accountPublishVersionOptions = new AccountPublishVersionOptions.Builder()
        .versionLocId(versionLocatorId)
        .build();
    
    catalogManagementServiceNotAuthorized.accountPublishVersion(accountPublishVersionOptions).execute();
  }
  
  // order of states are unknown yet
  // once this test is enabled the next block's dependency can point here
  @Test(dependsOnMethods = {"testGetOfferingContainerImages"})
  @Ignore
  public void testAccountPublishVersion() throws Exception {
    try {
      AccountPublishVersionOptions accountPublishVersionOptions = new AccountPublishVersionOptions.Builder()
          .versionLocId(versionLocatorId)
          .build();
      
      Response<Void> response = catalogManagementService.accountPublishVersion(accountPublishVersionOptions).execute();
      
      assertNotNull(response);
      assertEquals(response.getStatusCode(), 202);
      
    } catch (ServiceResponseException e) {
      fail(String.format("Service returned status code %d: %s\nError details: %s", e.getStatusCode(), e.getMessage(),
          e.getDebuggingInfo()));
    }
  }
  
  //====
  // IBM Publish Version block
  //====
  
  @Test(dependsOnMethods = {"testGetOfferingContainerImages"},
      expectedExceptions = BadRequestException.class)
  public void testIbmPublishVersionReturns400WhenBackendInputValidationFails() throws Exception {
    IbmPublishVersionOptions ibmPublishVersionOptions = new IbmPublishVersionOptions.Builder()
        .versionLocId(bogusVersionLocatorId)
        .build();
    
    catalogManagementService.ibmPublishVersion(ibmPublishVersionOptions).execute();
  }
  
  @Test(dependsOnMethods = {"testGetOfferingContainerImages"},
      expectedExceptions = BadRequestException.class)
  public void testIbmPublishVersionReturns404WhenNoSuchVersion() throws Exception {
    IbmPublishVersionOptions ibmPublishVersionOptions = new IbmPublishVersionOptions.Builder()
        .versionLocId(versionLocatorId + "c")
        .build();
    
    catalogManagementService.ibmPublishVersion(ibmPublishVersionOptions).execute();
  }
  
  @Test(dependsOnMethods = {"testGetOfferingContainerImages"},
      expectedExceptions = ForbiddenException.class)
  public void testIbmPublishVersionReturns403WhenUserIsNotAuthorized() throws Exception {
    IbmPublishVersionOptions ibmPublishVersionOptions = new IbmPublishVersionOptions.Builder()
        .versionLocId(versionLocatorId)
        .build();
    
    catalogManagementServiceNotAuthorized.ibmPublishVersion(ibmPublishVersionOptions).execute();
  }
  
  // seemingly this user doesn't have the right to publish
  // once this test is enabled the next block's dependency can point here
  @Test(dependsOnMethods = {"testGetOfferingContainerImages"})
  @Ignore
  public void testIbmPublishVersion() throws Exception {
    try {
      IbmPublishVersionOptions ibmPublishVersionOptions = new IbmPublishVersionOptions.Builder()
          .versionLocId(versionLocatorId)
          .build();
      
      Response<Void> response = catalogManagementService.ibmPublishVersion(ibmPublishVersionOptions).execute();
      
      assertNotNull(response);
      assertEquals(response.getStatusCode(), 202);
      
    } catch (ServiceResponseException e) {
      fail(String.format("Service returned status code %d: %s\nError details: %s", e.getStatusCode(), e.getMessage(),
          e.getDebuggingInfo()));
    }
  }
  
  //====
  // Public Publish Version block
  //====
  
  @Test(dependsOnMethods = {"testGetOfferingContainerImages"},
      expectedExceptions = BadRequestException.class)
  public void testPublicPublishVersionReturns400WhenBackendInputValidationFails() throws Exception {
    PublicPublishVersionOptions publicPublishVersionOptions = new PublicPublishVersionOptions.Builder()
        .versionLocId(bogusVersionLocatorId)
        .build();
    
    catalogManagementService.publicPublishVersion(publicPublishVersionOptions).execute();
  }
  
  @Test(dependsOnMethods = {"testGetOfferingContainerImages"},
      expectedExceptions = BadRequestException.class)
  public void testPublicPublishVersionReturns404WhenNoSuchVersion() throws Exception {
    PublicPublishVersionOptions publicPublishVersionOptions = new PublicPublishVersionOptions.Builder()
        .versionLocId(versionLocatorId + "c")
        .build();
    
    catalogManagementService.publicPublishVersion(publicPublishVersionOptions).execute();
  }
  
  @Test(dependsOnMethods = {"testGetOfferingContainerImages"},
      expectedExceptions = ForbiddenException.class)
  public void testPublicPublishVersionReturns403WhenUserIsNotAuthorized() throws Exception {
    PublicPublishVersionOptions publicPublishVersionOptions = new PublicPublishVersionOptions.Builder()
        .versionLocId(versionLocatorId)
        .build();
    
    catalogManagementServiceNotAuthorized.publicPublishVersion(publicPublishVersionOptions).execute();
  }
  
  // order of states is unknown yet
  // once this test is enabled the next block's dependency can point here
  @Test(dependsOnMethods = {"testGetOfferingContainerImages"})
  @Ignore
  public void testPublicPublishVersion() throws Exception {
    try {
      PublicPublishVersionOptions publicPublishVersionOptions = new PublicPublishVersionOptions.Builder()
          .versionLocId(versionLocatorId)
          .build();
      
      Response<Void> response = catalogManagementService.publicPublishVersion(publicPublishVersionOptions).execute();
      
      assertNotNull(response);
      assertEquals(response.getStatusCode(), 202);
      
    } catch (ServiceResponseException e) {
      fail(String.format("Service returned status code %d: %s\nError details: %s", e.getStatusCode(), e.getMessage(),
          e.getDebuggingInfo()));
    }
  }
  
  //====
  // Commit Version block
  //====
  
  @Test(dependsOnMethods = {"testGetOfferingContainerImages"},
      expectedExceptions = BadRequestException.class)
  public void testCommitVersionReturns400WhenBackendInputValidationFails() throws Exception {
    CommitVersionOptions commitVersionOptions = new CommitVersionOptions.Builder()
        .versionLocId(bogusVersionLocatorId)
        .build();
    
    catalogManagementService.commitVersion(commitVersionOptions).execute();
  }
  
  @Test(dependsOnMethods = {"testGetOfferingContainerImages"},
      expectedExceptions = NotFoundException.class)
  public void testCommitVersionReturns404WhenNoSuchVersion() throws Exception {
    CommitVersionOptions commitVersionOptions = new CommitVersionOptions.Builder()
        .versionLocId(versionLocatorId + "aa")
        .build();
    
    catalogManagementService.commitVersion(commitVersionOptions).execute();
  }
  
  @Test(dependsOnMethods = {"testGetOfferingContainerImages"},
      expectedExceptions = ForbiddenException.class)
  public void testCommitVersionReturns403WhenUserIsNotAuthorized() throws Exception {
    CommitVersionOptions commitVersionOptions = new CommitVersionOptions.Builder()
        .versionLocId(versionLocatorId)
        .build();
    
    catalogManagementServiceNotAuthorized.commitVersion(commitVersionOptions).execute();
  }
  
  // once this test is enabled the next block's dependency can point here
  @Test(dependsOnMethods = {"testGetOfferingContainerImages"})
  @Ignore
  public void testCommitVersion() throws Exception {
    try {
      CommitVersionOptions commitVersionOptions = new CommitVersionOptions.Builder()
          .versionLocId(versionLocatorId)
          .build();
      
      Response<Void> response = catalogManagementService.commitVersion(commitVersionOptions).execute();
      
      assertNotNull(response);
      assertEquals(response.getStatusCode(), 200);
      
    } catch (ServiceResponseException e) {
      fail(String.format("Service returned status code %d: %s\nError details: %s", e.getStatusCode(), e.getMessage(),
          e.getDebuggingInfo()));
    }
  }
  
  //====
  // Copy Version block
  //====
  
  @Test(dependsOnMethods = {"testGetOfferingContainerImages"},
      expectedExceptions = BadRequestException.class)
  public void testCopyVersionReturns400WhenBackendInputValidationFails() throws Exception {
    CopyVersionOptions copyVersionOptions = new CopyVersionOptions.Builder()
        .versionLocId(bogusVersionLocatorId)
        .targetKinds(new java.util.ArrayList<String>(java.util.Arrays.asList(kindRoks)))
        .build();
    
    catalogManagementService.copyVersion(copyVersionOptions).execute();
  }
  
  @Test(dependsOnMethods = {"testGetOfferingContainerImages"},
      expectedExceptions = ForbiddenException.class)
  public void testCopyVersionReturns403WhenUserIsNotAuthorized() throws Exception {
    CopyVersionOptions copyVersionOptions = new CopyVersionOptions.Builder()
        .versionLocId(versionLocatorId)
        .targetKinds(new java.util.ArrayList<String>(java.util.Arrays.asList(kindRoks)))
        .build();
    
    catalogManagementServiceNotAuthorized.copyVersion(copyVersionOptions).execute();
  }
  
  @Test(dependsOnMethods = {"testGetOfferingContainerImages"},
      expectedExceptions = NotFoundException.class)
  public void testCopyVersionReturns404WhenNoSucVersion() throws Exception {
    CopyVersionOptions copyVersionOptions = new CopyVersionOptions.Builder()
        .versionLocId(versionLocatorId + "ds")
        .targetKinds(new java.util.ArrayList<String>(java.util.Arrays.asList(kindRoks)))
        .build();
    
    catalogManagementService.copyVersion(copyVersionOptions).execute();
  }
  
  // only helm is suppotred, but eventually helm is not supported... so this test is ignored...
  // once this test is enabled the next block's dependency can point here
  @Test(dependsOnMethods = {"testGetOfferingContainerImages"})
  @Ignore
  public void testCopyVersion() throws Exception {
    try {
      CopyVersionOptions copyVersionOptions = new CopyVersionOptions.Builder()
          .versionLocId(versionLocatorId)
          .targetKinds(new java.util.ArrayList<String>(java.util.Arrays.asList(kindHelm)))
          .build();
      
      Response<Void> response = catalogManagementService.copyVersion(copyVersionOptions).execute();
      
      assertNotNull(response);
      assertEquals(response.getStatusCode(), 200);
      
    } catch (ServiceResponseException e) {
      fail(String.format("Service returned status code %d: %s\nError details: %s", e.getStatusCode(), e.getMessage(),
          e.getDebuggingInfo()));
    }
  }
  
  //====
  // Get Offering Working Copy block
  //====
  
  @Test(dependsOnMethods = {"testGetOfferingContainerImages"},
      expectedExceptions = BadRequestException.class)
  public void testGetOfferingWorkingCopyReturns400WhenBackendInputValidationFails() throws Exception {
    GetOfferingWorkingCopyOptions getOfferingWorkingCopyOptions = new GetOfferingWorkingCopyOptions.Builder()
        .versionLocId(bogusVersionLocatorId)
        .build();
    
    catalogManagementService.getOfferingWorkingCopy(getOfferingWorkingCopyOptions).execute();
  }
  
  @Test(dependsOnMethods = {"testGetOfferingContainerImages"},
      expectedExceptions = NotFoundException.class)
  public void testGetOfferingWorkingCopyReturns404WhenNoSuchVersion() throws Exception {
    GetOfferingWorkingCopyOptions getOfferingWorkingCopyOptions = new GetOfferingWorkingCopyOptions.Builder()
        .versionLocId(versionLocatorId + 'c')
        .build();
    
    catalogManagementService.getOfferingWorkingCopy(getOfferingWorkingCopyOptions).execute();
  }
  
  @Test(dependsOnMethods = {"testGetOfferingContainerImages"},
      expectedExceptions = ForbiddenException.class)
  public void testGetOfferingWorkingCopyReturns403WhenUserIsNotAuthorized() throws Exception {
    GetOfferingWorkingCopyOptions getOfferingWorkingCopyOptions = new GetOfferingWorkingCopyOptions.Builder()
        .versionLocId(versionLocatorId)
        .build();
    
    catalogManagementServiceNotAuthorized.getOfferingWorkingCopy(getOfferingWorkingCopyOptions).execute();
  }
  
  // requires published state which this user cannot create
  // once this test is enabled the next block's dependency can point here
  @Test(dependsOnMethods = {"testGetOfferingContainerImages"})
  @Ignore
  public void testGetOfferingWorkingCopy() throws Exception {
    try {
      GetOfferingWorkingCopyOptions getOfferingWorkingCopyOptions = new GetOfferingWorkingCopyOptions.Builder()
          .versionLocId(versionLocatorId)
          .build();
      
      Response<Version> response = catalogManagementService.getOfferingWorkingCopy(getOfferingWorkingCopyOptions)
          .execute();
      
      assertNotNull(response);
      assertEquals(response.getStatusCode(), 200);
      
      Version versionResult = response.getResult();
      assertNotNull(versionResult);
      
    } catch (ServiceResponseException e) {
      fail(String.format("Service returned status code %d: %s\nError details: %s", e.getStatusCode(), e.getMessage(),
          e.getDebuggingInfo()));
    }
  }
  
  //====
  // Get Version block
  //====
  
  @Test(dependsOnMethods = {"testGetOfferingContainerImages"},
      expectedExceptions = BadRequestException.class)
  public void testGetVersionReturns400WhenBackendInputValidationFails() throws Exception {
    GetVersionOptions getVersionOptions = new GetVersionOptions.Builder()
        .versionLocId(bogusVersionLocatorId)
        .build();
    
    catalogManagementService.getVersion(getVersionOptions).execute();
  }
  
  @Test(dependsOnMethods = {"testGetOfferingContainerImages"},
      expectedExceptions = NotFoundException.class)
  public void testGetVersionReturns404WhenNoSuchVersion() throws Exception {
    GetVersionOptions getVersionOptions = new GetVersionOptions.Builder()
        .versionLocId(versionLocatorId + "1q")
        .build();
    
    catalogManagementService.getVersion(getVersionOptions).execute();
  }
  
  @Test(dependsOnMethods = {"testGetOfferingContainerImages"},
      expectedExceptions = ForbiddenException.class)
  public void testGetVersionReturns403WhenUserIsNotAuthorized() throws Exception {
    GetVersionOptions getVersionOptions = new GetVersionOptions.Builder()
        .versionLocId(versionLocatorId)
        .build();
    
    catalogManagementServiceNotAuthorized.getVersion(getVersionOptions).execute();
  }
  
  @Test(dependsOnMethods = {"testGetOfferingContainerImages"})
  public void testGetVersion() throws Exception {
    try {
      GetVersionOptions getVersionOptions = new GetVersionOptions.Builder()
          .versionLocId(versionLocatorId)
          .build();
      
      Response<Offering> response = catalogManagementService.getVersion(getVersionOptions).execute();
      
      assertNotNull(response);
      assertEquals(response.getStatusCode(), 200);
      
      Offering offeringResult = response.getResult();
      assertNotNull(offeringResult);
      
    } catch (ServiceResponseException e) {
      fail(String.format("Service returned status code %d: %s\nError details: %s", e.getStatusCode(), e.getMessage(),
          e.getDebuggingInfo()));
    }
  }
  
  //====
  // Get Cluster block
  //====
  
  @Test(dependsOnMethods = {"testGetVersion"},
      expectedExceptions = NotFoundException.class)
  public void testGetClusterReturns404WhenNoSuchCluster() throws Exception {
    GetClusterOptions getClusterOptions = new GetClusterOptions.Builder()
        .clusterId(clusterId + "c")
        .region(regionUsSouth)
        .xAuthRefreshToken(refreshTokenAuthorized)
        .build();
    
    catalogManagementService.getCluster(getClusterOptions).execute();
  }
  
  /*
  This test randomly returns either Unauthorized or BadRequest exception
  it is disabled
   */
  @Test(dependsOnMethods = {"testGetVersion"},
      expectedExceptions = UnauthorizedException.class)
  @Ignore
  public void testGetClusterReturns403WhenUserIsNotAuthorized() throws Exception {
    GetClusterOptions getClusterOptions = new GetClusterOptions.Builder()
        .clusterId(clusterId)
        .region(regionUsSouth)
        .xAuthRefreshToken(refreshTokenNotAuthorized)
        .build();
    
    catalogManagementServiceNotAuthorized.getCluster(getClusterOptions).execute();
  }
  
  @Test(dependsOnMethods = {"testGetVersion"})
  public void testGetCluster() throws Exception {
    try {
      GetClusterOptions getClusterOptions = new GetClusterOptions.Builder()
          .clusterId(clusterId)
          .region(regionUsSouth)
          .xAuthRefreshToken(refreshTokenAuthorized)
          .build();
      
      Response<ClusterInfo> response = catalogManagementService.getCluster(getClusterOptions).execute();
      
      assertNotNull(response);
      assertEquals(response.getStatusCode(), 200);
      
      ClusterInfo clusterInfoResult = response.getResult();
      assertNotNull(clusterInfoResult);
      
    } catch (ServiceResponseException e) {
      fail(String.format("Service returned status code %d: %s\nError details: %s", e.getStatusCode(), e.getMessage(),
          e.getDebuggingInfo()));
    }
  }
  
  //====
  // Get Namespaces block
  //====
  
  /*
this test randomly returns either NotFoundException or BadRequest
to achieve stable test running it is disabled
 */
  @Test(dependsOnMethods = {"testGetCluster"},
      expectedExceptions = NotFoundException.class)
  @Ignore
  public void testGetNamespacesReturns404WhenNoSuchCluster() throws Exception {
    GetNamespacesOptions getNamespacesOptions = new GetNamespacesOptions.Builder()
        .clusterId(clusterId + "c")
        .region(regionUsSouth)
        .xAuthRefreshToken(refreshTokenAuthorized)
        .build();
    
    catalogManagementService.getNamespaces(getNamespacesOptions).execute();
  }
  
  @Test(dependsOnMethods = {"testGetCluster"},
      expectedExceptions = UnauthorizedException.class)
  public void testGetNamespacesReturns401WhenUserIsNotAuthorized() throws Exception {
    GetNamespacesOptions getNamespacesOptions = new GetNamespacesOptions.Builder()
        .clusterId(clusterId)
        .region(regionUsSouth)
        .xAuthRefreshToken(refreshTokenNotAuthorized)
        .build();
    
    catalogManagementServiceNotAuthorized.getNamespaces(getNamespacesOptions).execute();
  }
  
  // TLS error
  @Test(dependsOnMethods = {"testGetCluster"})
  @Ignore
  public void testGetNamespaces() throws Exception {
    try {
      GetNamespacesOptions getNamespacesOptions = new GetNamespacesOptions.Builder()
          .clusterId(clusterId)
          .region(regionUsSouth)
          .xAuthRefreshToken(refreshTokenAuthorized)
          .build();
      
      Response<NamespaceSearchResult> response = catalogManagementService.getNamespaces(getNamespacesOptions).execute();
      
      assertNotNull(response);
      assertEquals(response.getStatusCode(), 200);
      
      NamespaceSearchResult namespaceSearchResultResult = response.getResult();
      assertNotNull(namespaceSearchResultResult);
      
    } catch (ServiceResponseException e) {
      fail(String.format("Service returned status code %d: %s\nError details: %s", e.getStatusCode(), e.getMessage(),
          e.getDebuggingInfo()));
    }
  }
  
  //====
  // Deploy Operators block
  //====
  
  @Test(dependsOnMethods = {"testGetCluster"},
      expectedExceptions = BadRequestException.class)
  public void testDeployOperatorsReturns400WhenNoSuchCluster() throws Exception {
    DeployOperatorsOptions deployOperatorsOptions = new DeployOperatorsOptions.Builder()
        .xAuthRefreshToken(refreshTokenAuthorized)
        .clusterId(clusterId + "a")
        .region(regionUsSouth)
        .namespaces(new java.util.ArrayList<String>(java.util.Arrays.asList(namespaceJavaSdk)))
        .allNamespaces(true)
        .versionLocatorId(versionLocatorId)
        .build();
    
    catalogManagementService.deployOperators(deployOperatorsOptions).execute();
  }
  
  @Test(dependsOnMethods = {"testGetCluster"},
      expectedExceptions = ForbiddenException.class)
  public void testDeployOperatorsReturns403WhenUserIsNotAuthorized() throws Exception {
    DeployOperatorsOptions deployOperatorsOptions = new DeployOperatorsOptions.Builder()
        .xAuthRefreshToken(refreshTokenAuthorized)
        .clusterId(clusterId)
        .region(regionUsSouth)
        .namespaces(new java.util.ArrayList<String>(java.util.Arrays.asList(namespaceJavaSdk)))
        .versionLocatorId(versionLocatorId)
        .build();
    
    catalogManagementServiceNotAuthorized.deployOperators(deployOperatorsOptions).execute();
  }
  
  // TLS handshake timeout
  @Test(dependsOnMethods = {"testGetCluster"})
  @Ignore
  public void testDeployOperators() throws Exception {
    try {
      DeployOperatorsOptions deployOperatorsOptions = new DeployOperatorsOptions.Builder()
          .xAuthRefreshToken(refreshTokenAuthorized)
          .clusterId(clusterId)
          .region(regionUsSouth)
          .namespaces(new java.util.ArrayList<String>(java.util.Arrays.asList(namespaceJavaSdk)))
          .versionLocatorId(versionLocatorId)
          .build();
      
      Response<List<OperatorDeployResult>> response = catalogManagementService.deployOperators(deployOperatorsOptions)
          .execute();
      
      assertNotNull(response);
      assertEquals(response.getStatusCode(), 200);
      
      List<OperatorDeployResult> listOperatorDeployResultResult = response.getResult();
      assertNotNull(listOperatorDeployResultResult);
      
    } catch (ServiceResponseException e) {
      fail(String.format("Service returned status code %d: %s\nError details: %s", e.getStatusCode(), e.getMessage(),
          e.getDebuggingInfo()));
    }
  }
  
  //====
  // List Operators block
  //====
  
  @Test(dependsOnMethods = {"testGetCluster"},
      expectedExceptions = BadRequestException.class)
  public void testListOperatorsReturns400WhenBackendInputValidationFails() throws Exception {
    ListOperatorsOptions listOperatorsOptions = new ListOperatorsOptions.Builder()
        .xAuthRefreshToken(refreshTokenAuthorized)
        .clusterId(clusterId)
        .region(regionUsSouth)
        .versionLocatorId(bogusVersionLocatorId)
        .build();
    
    catalogManagementService.listOperators(listOperatorsOptions).execute();
  }
  
  @Test(dependsOnMethods = {"testGetCluster"},
      expectedExceptions = ForbiddenException.class)
  public void testListOperatorsReturns403WhenUserIsNotAuthorized() throws Exception {
    ListOperatorsOptions listOperatorsOptions = new ListOperatorsOptions.Builder()
        .xAuthRefreshToken(refreshTokenAuthorized)
        .clusterId(clusterId)
        .region(regionUsSouth)
        .versionLocatorId(versionLocatorId)
        .build();
    
    catalogManagementServiceNotAuthorized.listOperators(listOperatorsOptions).execute();
  }
  
  // TLS handshake timeout
  @Test(dependsOnMethods = {"testGetCluster"})
  @Ignore
  public void testListOperators() throws Exception {
    try {
      ListOperatorsOptions listOperatorsOptions = new ListOperatorsOptions.Builder()
          .xAuthRefreshToken(refreshTokenAuthorized)
          .clusterId(clusterId)
          .region(regionUsSouth)
          .versionLocatorId(versionLocatorId)
          .build();
      
      Response<List<OperatorDeployResult>> response = catalogManagementService.listOperators(listOperatorsOptions)
          .execute();
      
      assertNotNull(response);
      assertEquals(response.getStatusCode(), 200);
      
      List<OperatorDeployResult> listOperatorDeployResultResult = response.getResult();
      assertNotNull(listOperatorDeployResultResult);
      
    } catch (ServiceResponseException e) {
      fail(String.format("Service returned status code %d: %s\nError details: %s", e.getStatusCode(), e.getMessage(),
          e.getDebuggingInfo()));
    }
  }
  
  //====
  // Replace Operators block
  //====
  
  @Test(dependsOnMethods = {"testGetCluster"},
      expectedExceptions = BadRequestException.class)
  public void testReplaceOperatorsReturns400WhenBackendInputValidationFails() throws Exception {
    ReplaceOperatorsOptions replaceOperatorsOptions = new ReplaceOperatorsOptions.Builder()
        .xAuthRefreshToken(refreshTokenAuthorized)
        .clusterId(clusterId)
        .region(regionUsSouth)
        .versionLocatorId(bogusVersionLocatorId)
        .build();
    
    catalogManagementService.replaceOperators(replaceOperatorsOptions).execute();
  }
  
  @Test(dependsOnMethods = {"testGetCluster"},
      expectedExceptions = ForbiddenException.class)
  public void testReplaceOperatorsReturns403WhenUserIsNotAuthorized() throws Exception {
    ReplaceOperatorsOptions replaceOperatorsOptions = new ReplaceOperatorsOptions.Builder()
        .xAuthRefreshToken(refreshTokenNotAuthorized)
        .clusterId(clusterId)
        .region(regionUsSouth)
        .allNamespaces(true)
        .versionLocatorId(versionLocatorId)
        .build();
    
    catalogManagementServiceNotAuthorized.replaceOperators(replaceOperatorsOptions).execute();
  }
  
  // TLS handshake timeout
  @Test(dependsOnMethods = {"testGetCluster"})
  @Ignore
  public void testReplaceOperators() throws Exception {
    try {
      ReplaceOperatorsOptions replaceOperatorsOptions = new ReplaceOperatorsOptions.Builder()
          .xAuthRefreshToken(refreshTokenAuthorized)
          .clusterId(clusterId)
          .region(regionUsSouth)
          .namespaces(new java.util.ArrayList<String>(java.util.Arrays.asList(namespaceJavaSdk)))
          .versionLocatorId(versionLocatorId)
          .build();
      
      Response<List<OperatorDeployResult>> response = catalogManagementService.replaceOperators(replaceOperatorsOptions)
          .execute();
      
      assertNotNull(response);
      assertEquals(response.getStatusCode(), 200);
      
      List<OperatorDeployResult> listOperatorDeployResultResult = response.getResult();
      assertNotNull(listOperatorDeployResultResult);
      
    } catch (ServiceResponseException e) {
      fail(String.format("Service returned status code %d: %s\nError details: %s", e.getStatusCode(), e.getMessage(),
          e.getDebuggingInfo()));
    }
  }
  
  //====
  // Install Version block
  //====
  
  @Test(dependsOnMethods = {"testGetCluster"},
      expectedExceptions = BadRequestException.class)
  public void testInstallVersionReturns400WhenBackendInputValidationFails() throws Exception {
    
    InstallVersionOptions installVersionOptions = new InstallVersionOptions.Builder()
        .versionLocId(bogusVersionLocatorId)
        .xAuthRefreshToken(refreshTokenAuthorized)
        .clusterId(clusterId)
        .region(regionUsSouth)
        .versionLocatorId(bogusVersionLocatorId)
        .build();
    
    catalogManagementService.installVersion(installVersionOptions).execute();
  }
  
  @Test(dependsOnMethods = {"testGetCluster"},
      expectedExceptions = ForbiddenException.class)
  public void testInstallVersionReturns403WhenUserIsNotAuthorized() throws Exception {
    InstallVersionOptions installVersionOptions = new InstallVersionOptions.Builder()
        .versionLocId(versionLocatorId)
        .xAuthRefreshToken(refreshTokenNotAuthorized)
        .clusterId(clusterId)
        .region(regionUsSouth)
        .versionLocatorId(versionLocatorId)
        .build();
    
    catalogManagementServiceNotAuthorized.installVersion(installVersionOptions).execute();
  }
  
  @Test(dependsOnMethods = {"testGetCluster"})
  @Ignore
  public void testInstallVersion() throws Exception {
    try {
      DeployRequestBodySchematics deployRequestBodySchematicsModel = new DeployRequestBodySchematics.Builder()
          .name("testString")
          .description("testString")
          .tags(new java.util.ArrayList<String>(java.util.Arrays.asList("testString")))
          .resourceGroupId("testString")
          .build();
      
      InstallVersionOptions installVersionOptions = new InstallVersionOptions.Builder()
          .versionLocId("testString")
          .versionLocatorId("testString")
          .xAuthRefreshToken(refreshTokenAuthorized)
          .clusterId(clusterId)
          .region("testString")
          .namespace("testString")
          .overrideValues(new java.util.HashMap<String, Object>() {
            {
              put("foo", "testString");
            }
          })
          .entitlementApikey("testString")
          .schematics(deployRequestBodySchematicsModel)
          .script("testString")
          .scriptId("testString")
          .vcenterId("testString")
          .vcenterUser("testString")
          .vcenterPassword("testString")
          .vcenterLocation("testString")
          .vcenterDatastore("testString")
          .build();
      
      Response<Void> response = catalogManagementService.installVersion(installVersionOptions).execute();
      
      assertNotNull(response);
      assertEquals(response.getStatusCode(), 202);
      
    } catch (ServiceResponseException e) {
      fail(String.format("Service returned status code %d: %s\nError details: %s", e.getStatusCode(), e.getMessage(),
          e.getDebuggingInfo()));
    }
  }
  
  //====
  // PreInstall Version block
  //====
  
  @Test(dependsOnMethods = {"testGetCluster"},
      expectedExceptions = BadRequestException.class)
  public void testPreinstallVersionReturns400WhenBackendInputValidationFails() throws Exception {
    
    PreinstallVersionOptions preinstallVersionOptions = new PreinstallVersionOptions.Builder()
        .versionLocId(bogusVersionLocatorId)
        .xAuthRefreshToken(refreshTokenAuthorized)
        .clusterId(clusterId)
        .region(regionUsSouth)
        .versionLocatorId(bogusVersionLocatorId)
        .build();
    
    catalogManagementService.preinstallVersion(preinstallVersionOptions).execute();
  }
  
  @Test(dependsOnMethods = {"testGetCluster"},
      expectedExceptions = ForbiddenException.class)
  public void testPreinstallVersionReturns403WhenUserIsNotAuthorized() throws Exception {
    PreinstallVersionOptions preinstallVersionOptions = new PreinstallVersionOptions.Builder()
        .versionLocId(versionLocatorId)
        .xAuthRefreshToken(refreshTokenNotAuthorized)
        .clusterId(clusterId)
        .region(regionUsSouth)
        .versionLocatorId(versionLocatorId)
        .build();
    
    catalogManagementServiceNotAuthorized.preinstallVersion(preinstallVersionOptions).execute();
  }
  
  @Test(dependsOnMethods = {"testGetCluster"})
  @Ignore
  public void testPreinstallVersion() throws Exception {
    try {
      DeployRequestBodySchematics deployRequestBodySchematicsModel = new DeployRequestBodySchematics.Builder().name(
          "testString")
          .description("testString")
          .tags(new java.util.ArrayList<String>(java.util.Arrays.asList("testString")))
          .resourceGroupId("testString")
          .build();
      
      PreinstallVersionOptions preinstallVersionOptions = new PreinstallVersionOptions.Builder().versionLocId(
          "testString")
          .xAuthRefreshToken("testString")
          .clusterId("testString")
          .region("testString")
          .namespace("testString")
          .overrideValues(new java.util.HashMap<String, Object>() {
            {
              put("foo", "testString");
            }
          })
          .entitlementApikey("testString")
          .schematics(deployRequestBodySchematicsModel)
          .script("testString")
          .scriptId("testString")
          .versionLocatorId("testString")
          .vcenterId("testString")
          .vcenterUser("testString")
          .vcenterPassword("testString")
          .vcenterLocation("testString")
          .vcenterDatastore("testString")
          .build();
      
      Response<Void> response = catalogManagementService.preinstallVersion(preinstallVersionOptions).execute();
      
      assertNotNull(response);
      assertEquals(response.getStatusCode(), 202);
      
    } catch (ServiceResponseException e) {
      fail(String.format("Service returned status code %d: %s\nError details: %s", e.getStatusCode(), e.getMessage(),
          e.getDebuggingInfo()));
    }
  }
  
  //====
  // Get PreInstall Version block
  //====
  
  @Test(dependsOnMethods = {"testGetCluster"},
      expectedExceptions = BadRequestException.class)
  public void testGetPreinstallReturns400WhenBackendInputValidationFails() throws Exception {
    GetPreinstallOptions getPreinstallOptions = new GetPreinstallOptions.Builder()
        .versionLocId(bogusVersionLocatorId)
        .xAuthRefreshToken(refreshTokenAuthorized)
        .clusterId(clusterId)
        .region(regionUsSouth)
        .build();
    
    catalogManagementService.getPreinstall(getPreinstallOptions).execute();
  }
  
  @Test(dependsOnMethods = {"testGetCluster"},
      expectedExceptions = ForbiddenException.class)
  public void testGetPreinstallReturns403WhenUserIsNotAuthorized() throws Exception {
    GetPreinstallOptions getPreinstallOptions = new GetPreinstallOptions.Builder()
        .versionLocId(versionLocatorId)
        .xAuthRefreshToken(refreshTokenAuthorized)
        .clusterId(clusterId)
        .region(regionUsSouth)
        .build();
    
    catalogManagementServiceNotAuthorized.getPreinstall(getPreinstallOptions).execute();
  }
  
  @Test(dependsOnMethods = {"testGetCluster"},
      expectedExceptions = BadRequestException.class)
  public void testGetPreinstallReturns404WhenNoSuchVersion() throws Exception {
    GetPreinstallOptions getPreinstallOptions = new GetPreinstallOptions.Builder()
        .versionLocId(versionLocatorId + "c")
        .xAuthRefreshToken(refreshTokenAuthorized)
        .clusterId(clusterId)
        .region(regionUsSouth)
        .build();
    
    catalogManagementService.getPreinstall(getPreinstallOptions).execute();
  }
  
  @Test(dependsOnMethods = {"testGetCluster"})
  @Ignore
  public void testGetPreinstall() throws Exception {
    try {
      GetPreinstallOptions getPreinstallOptions = new GetPreinstallOptions.Builder()
          .versionLocId(versionLocatorId)
          .xAuthRefreshToken(refreshTokenAuthorized)
          .clusterId(clusterId)
          .region(regionUsSouth)
          .build();
      
      Response<InstallStatus> response = catalogManagementService.getPreinstall(getPreinstallOptions).execute();
      
      assertNotNull(response);
      assertEquals(response.getStatusCode(), 200);
      
      InstallStatus installStatusResult = response.getResult();
      assertNotNull(installStatusResult);
      
    } catch (ServiceResponseException e) {
      fail(String.format("Service returned status code %d: %s\nError details: %s", e.getStatusCode(), e.getMessage(),
          e.getDebuggingInfo()));
    }
  }
  
  //====
  // Validate Install block
  //====
  
  @Test(dependsOnMethods = {"testGetCluster"},
      expectedExceptions = BadRequestException.class)
  public void testValidateInstallReturns400WhenBackendInputValidationFails() throws Exception {
    
    ValidateInstallOptions validateInstallOptions = new ValidateInstallOptions.Builder()
        .versionLocId(bogusVersionLocatorId)
        .xAuthRefreshToken(refreshTokenAuthorized)
        .clusterId(clusterId)
        .region(regionUsSouth)
        .build();
    
    catalogManagementService.validateInstall(validateInstallOptions).execute();
  }
  
  @Test(dependsOnMethods = {"testCreateCatalog", "testCreateOffering", "testImportOffering"},
      expectedExceptions = ForbiddenException.class)
  public void testValidateInstallReturns403WhenUserIsNotAuthorized() throws Exception {
    ValidateInstallOptions validateInstallOptions = new ValidateInstallOptions.Builder()
        .versionLocId(versionLocatorId)
        .xAuthRefreshToken(refreshTokenNotAuthorized)
        .clusterId(clusterId)
        .region(regionUsSouth)
        .versionLocatorId(versionLocatorId)
        .build();
    
    catalogManagementServiceNotAuthorized.validateInstall(validateInstallOptions).execute();
  }
  
  // TLS handshake timeout
  @Test(dependsOnMethods = {"testGetCluster"},
      expectedExceptions = NotFoundException.class)
  @Ignore
  public void testValidateInstallReturns404WhenNoSuchResource() throws Exception {
    ValidateInstallOptions validateInstallOptions = new ValidateInstallOptions.Builder()
        .versionLocId(versionLocatorId + "qa")
        .xAuthRefreshToken(refreshTokenNotAuthorized)
        .clusterId(clusterId)
        .region(regionUsSouth)
        .build();
    
    catalogManagementService.validateInstall(validateInstallOptions).execute();
  }
  
  // TLS handshake timeout
  @Test(dependsOnMethods = {"testGetCluster"})
  @Ignore
  public void testValidateInstall() throws Exception {
    try {
      ValidateInstallOptions validateInstallOptions = new ValidateInstallOptions.Builder()
          .versionLocId(versionLocatorId)
          .xAuthRefreshToken(refreshTokenAuthorized)
          .clusterId(clusterId)
          .region(regionUsSouth)
          .build();
      
      Response<Void> response = catalogManagementService.validateInstall(validateInstallOptions).execute();
      
      assertNotNull(response);
      assertEquals(response.getStatusCode(), 202);
      
    } catch (ServiceResponseException e) {
      fail(String.format("Service returned status code %d: %s\nError details: %s", e.getStatusCode(), e.getMessage(),
          e.getDebuggingInfo()));
    }
  }
  
  //====
  // Get Validation Status block
  //====
  
  @Test(dependsOnMethods = {"testGetCluster"},
      expectedExceptions = BadRequestException.class)
  public void testGetValidationStatusReturns400WhenValidationFails() throws Exception {
    GetValidationStatusOptions getValidationStatusOptions = new GetValidationStatusOptions.Builder()
        .versionLocId(bogusVersionLocatorId)
        .xAuthRefreshToken(refreshTokenAuthorized)
        .build();
    
    catalogManagementService.getValidationStatus(getValidationStatusOptions).execute();
  }
  
  @Test(dependsOnMethods = {"testGetCluster"},
      expectedExceptions = ForbiddenException.class)
  public void testGetValidationStatusReturns403WhenUserIsNotAuthorized() throws Exception {
    GetValidationStatusOptions getValidationStatusOptions = new GetValidationStatusOptions.Builder()
        .versionLocId(versionLocatorId)
        .xAuthRefreshToken(refreshTokenNotAuthorized)
        .build();
    
    catalogManagementServiceNotAuthorized.getValidationStatus(getValidationStatusOptions).execute();
  }
  
  @Test(dependsOnMethods = {"testGetCluster"},
      expectedExceptions = BadRequestException.class)
  public void testGetValidationStatusReturns404WhenNoSuchResource() throws Exception {
    GetValidationStatusOptions getValidationStatusOptions = new GetValidationStatusOptions.Builder()
        .versionLocId(versionLocatorId + "2w")
        .xAuthRefreshToken(refreshTokenAuthorized)
        .build();
    
    catalogManagementService.getValidationStatus(getValidationStatusOptions).execute();
  }
  
  @Test(dependsOnMethods = {"testGetCluster"})
  public void testGetValidationStatus() throws Exception {
    try {
      GetValidationStatusOptions getValidationStatusOptions = new GetValidationStatusOptions.Builder()
          .versionLocId(versionLocatorId)
          .xAuthRefreshToken(refreshTokenAuthorized)
          .build();
      
      Response<Validation> response = catalogManagementService.getValidationStatus(getValidationStatusOptions)
          .execute();
      
      assertNotNull(response);
      assertEquals(response.getStatusCode(), 200);
      
      Validation validationResult = response.getResult();
      assertNotNull(validationResult);
      
    } catch (ServiceResponseException e) {
      fail(String.format("Service returned status code %d: %s\nError details: %s", e.getStatusCode(), e.getMessage(),
          e.getDebuggingInfo()));
    }
  }
  
  //====
  // Get Override Values block
  //====
  
  @Test(dependsOnMethods = {"testGetCluster"},
      expectedExceptions = BadRequestException.class)
  public void testGetOverrideValuesReturns400WhenBackendInputValidationFails() throws Exception {
    GetOverrideValuesOptions getOverrideValuesOptions = new GetOverrideValuesOptions.Builder()
        .versionLocId(bogusVersionLocatorId)
        .build();
    
    catalogManagementService.getOverrideValues(getOverrideValuesOptions).execute();
  }
  
  @Test(dependsOnMethods = {"testGetCluster"},
      expectedExceptions = ForbiddenException.class)
  public void testGetOverrideValuesReturns403WhenUserIsNotAuthorized() throws Exception {
    GetOverrideValuesOptions getOverrideValuesOptions = new GetOverrideValuesOptions.Builder()
        .versionLocId(versionLocatorId)
        .build();
    
    catalogManagementServiceNotAuthorized.getOverrideValues(getOverrideValuesOptions).execute();
  }
  
  @Test(dependsOnMethods = {"testGetCluster"},
      expectedExceptions = BadRequestException.class)
  public void testGetOverrideValuesReturns400WhenNoSuchResource() throws Exception {
    GetOverrideValuesOptions getOverrideValuesOptions = new GetOverrideValuesOptions.Builder()
        .versionLocId(versionLocatorId + "q2")
        .build();
    
    catalogManagementService.getOverrideValues(getOverrideValuesOptions).execute();
  }
  
  // Validation is a pre-requisite here
  @Test(dependsOnMethods = {"testGetCluster"})
  @Ignore
  public void testGetOverrideValues() throws Exception {
    try {
      GetOverrideValuesOptions getOverrideValuesOptions = new GetOverrideValuesOptions.Builder()
          .versionLocId(versionLocatorId)
          .build();
      
      Response<Map<String, Object>> response = catalogManagementService.getOverrideValues(getOverrideValuesOptions)
          .execute();
      
      assertNotNull(response);
      assertEquals(response.getStatusCode(), 200);
      
      Map<String, Object> resultResult = response.getResult();
      assertNotNull(resultResult);
      
    } catch (ServiceResponseException e) {
      fail(String.format("Service returned status code %d: %s\nError details: %s", e.getStatusCode(), e.getMessage(),
          e.getDebuggingInfo()));
    }
  }
  
  //====
  // Search Objects block
  //====
  
  @Test(dependsOnMethods = {"testGetCluster"},
      expectedExceptions = BadRequestException.class)
  public void testSearchObjectsReturns400WhenBackendInputValidationFails() throws Exception {
    SearchObjectsOptions searchObjectsOptions = new SearchObjectsOptions.Builder()
        .query("")
        .collapse(true)
        .digest(true)
        .build();
    
    catalogManagementService.searchObjects(searchObjectsOptions).execute();
  }
  
  @Test(dependsOnMethods = {"testGetCluster"})
  public void testSearchObjectsReturns200WhenUserIsNotAuthorized() throws Exception {
    try {
      SearchObjectsOptions searchObjectsOptions = new SearchObjectsOptions.Builder()
          .query("query")
          .collapse(true)
          .digest(true)
          .build();
      
      Response<ObjectSearchResult> response = catalogManagementServiceNotAuthorized
          .searchObjects(searchObjectsOptions)
          .execute();
      assertNotNull(response);
      assertEquals(response.getStatusCode(), 200);
      
    } catch (ServiceResponseException e) {
      fail(String.format("Service returned status code %d: %s\nError details: %s", e.getStatusCode(), e.getMessage(),
          e.getDebuggingInfo()));
    }
  }
  
  @Test(dependsOnMethods = {"testGetCluster"})
  public void testSearchObjects() throws Exception {
    try {
      SearchObjectsOptions searchObjectsOptions = new SearchObjectsOptions.Builder()
          .query("name: " + objectName)
          .collapse(true)
          .digest(true)
          .build();
      
      Response<ObjectSearchResult> response = catalogManagementService.searchObjects(searchObjectsOptions).execute();
      
      assertNotNull(response);
      assertEquals(response.getStatusCode(), 200);
      
      ObjectSearchResult objectSearchResultResult = response.getResult();
      assertNotNull(objectSearchResultResult);
      
    } catch (ServiceResponseException e) {
      fail(String.format("Service returned status code %d: %s\nError details: %s", e.getStatusCode(), e.getMessage(),
          e.getDebuggingInfo()));
    }
  }
  
  //====
  // List Objects block
  //====
  
  @Test(dependsOnMethods = {"testGetCluster"},
      expectedExceptions = BadRequestException.class)
  public void testListObjectsReturns400WhenBackendInputValidationFails() throws Exception {
    ListObjectsOptions listObjectsOptions = new ListObjectsOptions.Builder()
        .catalogIdentifier(catalogId)
        .name(" ")
        .sort(" ")
        .build();
    
    catalogManagementService.listObjects(listObjectsOptions).execute();
  }
  
  @Test(dependsOnMethods = {"testGetCluster"})
  public void testListObjects() throws Exception {
    try {
      ListObjectsOptions listObjectsOptions = new ListObjectsOptions.Builder()
          .catalogIdentifier(catalogId)
          .build();
      
      Response<ObjectListResult> response = catalogManagementService.listObjects(listObjectsOptions).execute();
      
      assertNotNull(response);
      assertEquals(response.getStatusCode(), 200);
      
      ObjectListResult objectListResultResult = response.getResult();
      assertNotNull(objectListResultResult);
      
      objectListResultResult.getResources().stream()
          .filter(f -> f.id().equals(objectId))
          .findAny()
          .orElseThrow(() -> new RuntimeException(String.format("No object with id: %s", objectId)));
      
    } catch (ServiceResponseException e) {
      fail(String.format("Service returned status code %d: %s\nError details: %s", e.getStatusCode(), e.getMessage(),
          e.getDebuggingInfo()));
    }
  }
  
  //====
  // Replace Object block
  //====
  
  @Test(dependsOnMethods = {"testListObjects"},
      expectedExceptions = BadRequestException.class)
  // @Ignore
  public void testReplaceObjectReturns400WhenNoSuchObject() throws Exception {
    ReplaceObjectOptions replaceObjectOptions = new ReplaceObjectOptions.Builder()
        .catalogIdentifier(catalogId)
        .objectIdentifier(objectId)
        .id(objectId + "c")
        .name(objectName)
        .parentId(regionUsSouth)
        .catalogId(catalogId)
        .build();
    
    catalogManagementService.replaceObject(replaceObjectOptions).execute();
  }
  
  @Test(dependsOnMethods = {"testListObjects"},
      expectedExceptions = ForbiddenException.class)
  public void testReplaceObjectReturns403WhenUserIsNotAuthorized() throws Exception {
    
    ReplaceObjectOptions replaceObjectOptions = new ReplaceObjectOptions.Builder()
        .catalogIdentifier(catalogId)
        .objectIdentifier(objectId)
        .id(objectId)
        .name(objectName)
        .parentId(regionUsSouth)
        .catalogId(catalogId)
        .build();
    
    catalogManagementServiceNotAuthorized.replaceObject(replaceObjectOptions).execute();
  }
  
  // conflict on revisions
  @Test(dependsOnMethods = {"testListObjects"})
  @Ignore
  public void testReplaceObject() throws Exception {
    try {
      
      ReplaceObjectOptions replaceObjectOptions = new ReplaceObjectOptions.Builder()
          .catalogIdentifier(catalogId)
          .objectIdentifier(objectId)
          .id(objectId)
          .name(objectName)
          .parentId(regionUsSouth)
          .kind(kindVpe)
          .catalogId(catalogId)
          .build();
      
      Response<CatalogObject> response = catalogManagementService.replaceObject(replaceObjectOptions).execute();
      
      assertNotNull(response);
      assertEquals(response.getStatusCode(), 200);
      
      CatalogObject catalogObjectResult = response.getResult();
      assertNotNull(catalogObjectResult);
      
    } catch (ServiceResponseException e) {
      fail(String.format("Service returned status code %d: %s\nError details: %s", e.getStatusCode(), e.getMessage(),
          e.getDebuggingInfo()));
    }
  }
  
  //====
  // Get Object block
  //====
  
  @Test(dependsOnMethods = {"testListObjects"},
      expectedExceptions = NotFoundException.class)
  public void testGetObjectReturns404WhenNoSuchObject() throws Exception {
    GetObjectOptions getObjectOptions = new GetObjectOptions.Builder()
        .catalogIdentifier(catalogId)
        .objectIdentifier(objectId + "c")
        .build();
    
    catalogManagementService.getObject(getObjectOptions).execute();
  }
  
  @Test(dependsOnMethods = {"testListObjects"},
      expectedExceptions = ForbiddenException.class)
  public void testGetObjectReturns403WhenUserIsNotAuthorized() throws Exception {
    GetObjectOptions getObjectOptions = new GetObjectOptions.Builder()
        .catalogIdentifier(catalogId)
        .objectIdentifier(objectId)
        .build();
    
    catalogManagementServiceNotAuthorized.getObject(getObjectOptions).execute();
  }
  
  @Test(dependsOnMethods = {"testListObjects"})
  public void testGetObject() throws Exception {
    try {
      GetObjectOptions getObjectOptions = new GetObjectOptions.Builder()
          .catalogIdentifier(catalogId)
          .objectIdentifier(objectId)
          .build();
      
      Response<CatalogObject> response = catalogManagementService.getObject(getObjectOptions).execute();
      
      assertNotNull(response);
      assertEquals(response.getStatusCode(), 200);
      
      CatalogObject catalogObjectResult = response.getResult();
      assertNotNull(catalogObjectResult);
      
    } catch (ServiceResponseException e) {
      fail(String.format("Service returned status code %d: %s\nError details: %s", e.getStatusCode(), e.getMessage(),
          e.getDebuggingInfo()));
    }
  }
  
  //====
  // Get Object Audit block
  //====
  
  @Test(dependsOnMethods = {"testGetObject"},
      expectedExceptions = ForbiddenException.class)
  public void testGetObjectAuditReturns403WhenUserIsNotAuthorized() throws Exception {
    GetObjectAuditOptions getObjectAuditOptions = new GetObjectAuditOptions.Builder()
        .catalogIdentifier(catalogId)
        .objectIdentifier(objectId)
        .build();
    
    catalogManagementServiceNotAuthorized.getObjectAudit(getObjectAuditOptions).execute();
  }
  
  @Test(dependsOnMethods = {"testGetObject"})
  public void testGetObjectAuditReturns200WhenNoSuchObject() throws Exception {
    try {
      GetObjectAuditOptions getObjectAuditOptions = new GetObjectAuditOptions.Builder()
          .catalogIdentifier(catalogId)
          .objectIdentifier(objectId + "c")
          .build();
      
      Response<AuditLog> response = catalogManagementService.getObjectAudit(getObjectAuditOptions).execute();
      
      assertNotNull(response);
      assertEquals(response.getStatusCode(), 200);
      
      AuditLog auditLogResult = response.getResult();
      assertNotNull(auditLogResult);
      
    } catch (ServiceResponseException e) {
      fail(String.format("Service returned status code %d: %s\nError details: %s", e.getStatusCode(), e.getMessage(),
          e.getDebuggingInfo()));
    }
  }
  
  @Test(dependsOnMethods = {"testGetObject"})
  public void testGetObjectAudit() throws Exception {
    try {
      GetObjectAuditOptions getObjectAuditOptions = new GetObjectAuditOptions.Builder()
          .catalogIdentifier(catalogId)
          .objectIdentifier(objectId)
          .build();
      
      Response<AuditLog> response = catalogManagementService.getObjectAudit(getObjectAuditOptions).execute();
      
      assertNotNull(response);
      assertEquals(response.getStatusCode(), 200);
      
      AuditLog auditLogResult = response.getResult();
      assertNotNull(auditLogResult);
      
    } catch (ServiceResponseException e) {
      fail(String.format("Service returned status code %d: %s\nError details: %s", e.getStatusCode(), e.getMessage(),
          e.getDebuggingInfo()));
    }
  }
  
  //====
  // Account Publish Object block
  //====
  
  @Test(dependsOnMethods = {"testGetObjectAudit"},
      expectedExceptions = NotFoundException.class)
  public void testAccountPublishObjectReturns404WhenNoSuchObject() throws Exception {
    AccountPublishObjectOptions accountPublishObjectOptions = new AccountPublishObjectOptions.Builder()
        .catalogIdentifier(catalogId)
        .objectIdentifier(bogusObjectId)
        .build();
    
    catalogManagementService.accountPublishObject(accountPublishObjectOptions).execute();
  }
  
  @Test(dependsOnMethods = {"testGetObjectAudit"},
      expectedExceptions = ForbiddenException.class)
  public void testAccountPublishObjectReturns403WhenUserIsNotAuthorized() throws Exception {
    AccountPublishObjectOptions accountPublishObjectOptions = new AccountPublishObjectOptions.Builder()
        .catalogIdentifier(catalogId)
        .objectIdentifier(objectId)
        .build();
    
    catalogManagementServiceNotAuthorized.accountPublishObject(accountPublishObjectOptions).execute();
  }
  
  @Test(dependsOnMethods = {"testGetObjectAudit"})
  public void testAccountPublishObject() throws Exception {
    try {
      AccountPublishObjectOptions accountPublishObjectOptions = new AccountPublishObjectOptions.Builder()
          .catalogIdentifier(catalogId)
          .objectIdentifier(objectId)
          .build();
      
      Response<Void> response = catalogManagementService.accountPublishObject(accountPublishObjectOptions).execute();
      
      assertNotNull(response);
      assertEquals(response.getStatusCode(), 202);
      
    } catch (ServiceResponseException e) {
      fail(String.format("Service returned status code %d: %s\nError details: %s", e.getStatusCode(), e.getMessage(),
          e.getDebuggingInfo()));
    }
  }
  
  //====
  // Shared Publish Object block
  //====
  
  @Test(dependsOnMethods = {"testAccountPublishObject"},
      expectedExceptions = NotFoundException.class)
  public void testSharedPublishObjectReturns404WhenNoSuchObject() throws Exception {
    SharedPublishObjectOptions sharedPublishObjectOptions = new SharedPublishObjectOptions.Builder()
        .catalogIdentifier(catalogId)
        .objectIdentifier(objectId + "c")
        .build();
    
    catalogManagementService.sharedPublishObject(sharedPublishObjectOptions).execute();
  }
  
  @Test(dependsOnMethods = {"testAccountPublishObject"},
      expectedExceptions = ForbiddenException.class)
  public void testSharedPublishObjectReturns403WhenUserIsNotAuthorized() throws Exception {
    SharedPublishObjectOptions sharedPublishObjectOptions = new SharedPublishObjectOptions.Builder()
        .catalogIdentifier(catalogId)
        .objectIdentifier(objectId)
        .build();
    
    catalogManagementServiceNotAuthorized.sharedPublishObject(sharedPublishObjectOptions).execute();
  }
  
  @Test(dependsOnMethods = {"testAccountPublishObject"})
  @Ignore
  public void testSharedPublishObject() throws Exception {
    try {
      SharedPublishObjectOptions sharedPublishObjectOptions = new SharedPublishObjectOptions.Builder()
          .catalogIdentifier(catalogId)
          .objectIdentifier(objectId)
          .build();
      
      Response<Void> response = catalogManagementService.sharedPublishObject(sharedPublishObjectOptions).execute();
      
      assertNotNull(response);
      assertEquals(response.getStatusCode(), 202);
      
    } catch (ServiceResponseException e) {
      fail(String.format("Service returned status code %d: %s\nError details: %s", e.getStatusCode(), e.getMessage(),
          e.getDebuggingInfo()));
    }
  }
  
  //====
  // IBM Publish Object block
  //====
  
  @Test(dependsOnMethods = {"testAccountPublishObject"},
      expectedExceptions = NotFoundException.class)
  public void testIbmPublishObjectReturns404WhenNoSuchObject() throws Exception {
    IbmPublishObjectOptions ibmPublishObjectOptions = new IbmPublishObjectOptions.Builder()
        .catalogIdentifier(catalogId)
        .objectIdentifier(objectId + "cc")
        .build();
    
    catalogManagementService.ibmPublishObject(ibmPublishObjectOptions).execute();
  }
  
  @Test(dependsOnMethods = {"testAccountPublishObject"},
      expectedExceptions = ForbiddenException.class)
  public void testIbmPublishObjectReturns403WhenUSerIsNotAuthorized() throws Exception {
    IbmPublishObjectOptions ibmPublishObjectOptions = new IbmPublishObjectOptions.Builder()
        .catalogIdentifier(catalogId)
        .objectIdentifier(objectId)
        .build();
    
    catalogManagementServiceNotAuthorized.ibmPublishObject(ibmPublishObjectOptions).execute();
  }
  
  @Test(dependsOnMethods = {"testAccountPublishObject"})
  @Ignore
  public void testIbmPublishObject() throws Exception {
    try {
      IbmPublishObjectOptions ibmPublishObjectOptions = new IbmPublishObjectOptions.Builder()
          .catalogIdentifier(catalogId)
          .objectIdentifier(objectId)
          .build();
      
      Response<Void> response = catalogManagementService.ibmPublishObject(ibmPublishObjectOptions).execute();
      
      assertNotNull(response);
      assertEquals(response.getStatusCode(), 202);
      
    } catch (ServiceResponseException e) {
      fail(String.format("Service returned status code %d: %s\nError details: %s", e.getStatusCode(), e.getMessage(),
          e.getDebuggingInfo()));
    }
  }
  
  //====
  // Public Publish Object block
  //====
  
  @Test(dependsOnMethods = {"testAccountPublishObject"},
      expectedExceptions = NotFoundException.class)
  public void testPublicPublishObjectReturns404WhenNoSuchObject() throws Exception {
    PublicPublishObjectOptions publicPublishObjectOptions = new PublicPublishObjectOptions.Builder()
        .catalogIdentifier(catalogId)
        .objectIdentifier(objectId + "cc")
        .build();
    
    catalogManagementService.publicPublishObject(publicPublishObjectOptions).execute();
  }
  
  @Test(dependsOnMethods = {"testAccountPublishObject"},
      expectedExceptions = ForbiddenException.class)
  public void testPublicPublishObjectReturns403WhenUserIsNotAuthorized() throws Exception {
    PublicPublishObjectOptions publicPublishObjectOptions = new PublicPublishObjectOptions.Builder()
        .catalogIdentifier(catalogId)
        .objectIdentifier(objectId)
        .build();
    
    catalogManagementServiceNotAuthorized.publicPublishObject(publicPublishObjectOptions).execute();
  }
  
  @Test(dependsOnMethods = {"testAccountPublishObject"})
  @Ignore
  public void testPublicPublishObject() throws Exception {
    try {
      PublicPublishObjectOptions publicPublishObjectOptions =
          new PublicPublishObjectOptions.Builder()
              .catalogIdentifier(catalogId)
              .objectIdentifier(objectId)
              .build();
      
      Response<Void> response = catalogManagementService.publicPublishObject(publicPublishObjectOptions).execute();
      
      assertNotNull(response);
      assertEquals(response.getStatusCode(), 202);
      
    } catch (ServiceResponseException e) {
      fail(String.format("Service returned status code %d: %s\nError details: %s", e.getStatusCode(), e.getMessage(),
          e.getDebuggingInfo()));
    }
  }
  
  //====
  // Create Object Access block
  //====
  
  @Test(dependsOnMethods = {"testAccountPublishObject"},
      expectedExceptions = NotFoundException.class)
  public void testCreateObjectAccessReturns404WhenNoSuchObject() throws Exception {
    CreateObjectAccessOptions createObjectAccessOptions = new CreateObjectAccessOptions.Builder()
        .catalogIdentifier(catalogId)
        .objectIdentifier(objectId + "c")
        .accountIdentifier(accountId)
        .build();
    
    catalogManagementService.createObjectAccess(createObjectAccessOptions).execute();
  }
  
  @Test(dependsOnMethods = {"testAccountPublishObject"},
      expectedExceptions = ForbiddenException.class)
  public void testCreateObjectAccessReturns403WhenUserIsNotAuthorized() throws Exception {
    CreateObjectAccessOptions createObjectAccessOptions = new CreateObjectAccessOptions.Builder()
        .catalogIdentifier(catalogId)
        .objectIdentifier(objectId)
        .accountIdentifier(accountId)
        .build();
    
    catalogManagementServiceNotAuthorized.createObjectAccess(createObjectAccessOptions).execute();
  }
  
  @Test(dependsOnMethods = {"testAccountPublishObject"})
  public void testCreateObjectAccess() throws Exception {
    try {
      CreateObjectAccessOptions createObjectAccessOptions =
          new CreateObjectAccessOptions.Builder()
              .catalogIdentifier(catalogId)
              .objectIdentifier(objectId)
              .accountIdentifier(accountId)
              .build();
      
      Response<Void> response = catalogManagementService.createObjectAccess(createObjectAccessOptions).execute();
      
      assertNotNull(response);
      assertEquals(response.getStatusCode(), 201);
      
    } catch (ServiceResponseException e) {
      fail(String.format("Service returned status code %d: %s\nError details: %s", e.getStatusCode(), e.getMessage(),
          e.getDebuggingInfo()));
    }
  }
  
  //====
  // Get Object Access List block
  //====
  
  @Test(dependsOnMethods = {"testCreateObjectAccess"})
  public void testGetObjectAccessListReturns200WhenNoSuchObject() throws Exception {
    try {
      GetObjectAccessListOptions getObjectAccessListOptions = new GetObjectAccessListOptions.Builder()
          .catalogIdentifier(catalogId)
          .objectIdentifier(objectId + "cc")
          .build();
      
      Response<ObjectAccessListResult> response = catalogManagementService
          .getObjectAccessList(getObjectAccessListOptions)
          .execute();
      
      assertNotNull(response);
      assertEquals(response.getStatusCode(), 200);
      
    } catch (ServiceResponseException e) {
      fail(String.format("Service returned status code %d: %s\nError details: %s", e.getStatusCode(), e.getMessage(),
          e.getDebuggingInfo()));
    }
  }
  
  @Test(dependsOnMethods = {"testCreateObjectAccess"},
      expectedExceptions = ForbiddenException.class)
  public void testGetObjectAccessListReturns403WhenUserIsNotAuthorized() throws Exception {
    GetObjectAccessListOptions getObjectAccessListOptions = new GetObjectAccessListOptions.Builder()
        .catalogIdentifier(catalogId)
        .objectIdentifier(objectId)
        .build();
    
    catalogManagementServiceNotAuthorized.getObjectAccessList(getObjectAccessListOptions).execute();
  }
  
  @Test(dependsOnMethods = {"testCreateObjectAccess"})
  public void testGetObjectAccessList() throws Exception {
    try {
      GetObjectAccessListOptions getObjectAccessListOptions = new GetObjectAccessListOptions.Builder()
          .catalogIdentifier(catalogId)
          .objectIdentifier(objectId)
          .build();
      
      Response<ObjectAccessListResult> response =
          catalogManagementService.getObjectAccessList(getObjectAccessListOptions)
              .execute();
      
      assertNotNull(response);
      assertEquals(response.getStatusCode(), 200);
      
      ObjectAccessListResult objectAccessListResultResult = response.getResult();
      assertNotNull(objectAccessListResultResult);
      
    } catch (ServiceResponseException e) {
      fail(String.format("Service returned status code %d: %s\nError details: %s", e.getStatusCode(), e.getMessage(),
          e.getDebuggingInfo()));
    }
  }
  
  //====
  // Get Object Access block
  //====
  
  @Test(dependsOnMethods = {"testGetObjectAccessList"},
      expectedExceptions = NotFoundException.class)
  public void testGetObjectAccessReturns404WhenNoSuchObjectAccess() throws Exception {
    GetObjectAccessOptions getObjectAccessOptions = new GetObjectAccessOptions.Builder()
        .catalogIdentifier(catalogId)
        .objectIdentifier(objectId + "c")
        .accountIdentifier(accountId)
        .build();
    
    catalogManagementService.getObjectAccess(getObjectAccessOptions).execute();
  }
  
  @Test(dependsOnMethods = {"testGetObjectAccessList"},
      expectedExceptions = ForbiddenException.class)
  public void testGetObjectAccessReturns403WhenUserIsNotAuthorized() throws Exception {
    GetObjectAccessOptions getObjectAccessOptions = new GetObjectAccessOptions.Builder()
        .catalogIdentifier(catalogId)
        .objectIdentifier(objectId)
        .accountIdentifier(accountId)
        .build();
    
    catalogManagementServiceNotAuthorized.getObjectAccess(getObjectAccessOptions).execute();
  }
  
  @Test(dependsOnMethods = {"testGetObjectAccessList"})
  @Ignore
  public void testGetObjectAccess() throws Exception {
    try {
      GetObjectAccessOptions getObjectAccessOptions = new GetObjectAccessOptions.Builder()
          .catalogIdentifier(catalogId)
          .objectIdentifier(objectId)
          .accountIdentifier(accountId)
          .build();
      
      Response<ObjectAccess> response = catalogManagementService.getObjectAccess(getObjectAccessOptions).execute();
      
      assertNotNull(response);
      assertEquals(response.getStatusCode(), 200);
      
      ObjectAccess objectAccessResult = response.getResult();
      assertNotNull(objectAccessResult);
      
    } catch (ServiceResponseException e) {
      fail(String.format("Service returned status code %d: %s\nError details: %s", e.getStatusCode(), e.getMessage(),
          e.getDebuggingInfo()));
    }
  }
  
  //====
  // Add Object Access List block
  //====
  
  @Test(dependsOnMethods = {"testGetObjectAccessList"},
      expectedExceptions = NotFoundException.class)
  public void testAddObjectAccessListReturns404WhenNoSuchObject() throws Exception {
    AddObjectAccessListOptions addObjectAccessListOptions = new AddObjectAccessListOptions.Builder()
        .catalogIdentifier(catalogId)
        .objectIdentifier(objectId + "cc")
        .accounts(new java.util.ArrayList<String>(java.util.Arrays.asList(accountId)))
        .build();
    
    catalogManagementService.addObjectAccessList(addObjectAccessListOptions).execute();
  }
  
  @Test(dependsOnMethods = {"testGetObjectAccessList"},
      expectedExceptions = ForbiddenException.class)
  public void testAddObjectAccessListReturns403WhenUserIsNotAuthorized() throws Exception {
    AddObjectAccessListOptions addObjectAccessListOptions = new AddObjectAccessListOptions.Builder()
        .catalogIdentifier(catalogId)
        .objectIdentifier(objectId)
        .accounts(new java.util.ArrayList<String>(java.util.Arrays.asList(accountId)))
        .build();
    
    catalogManagementServiceNotAuthorized.addObjectAccessList(addObjectAccessListOptions).execute();
  }
  
  @Test(dependsOnMethods = {"testGetObjectAccessList"})
  public void testAddObjectAccessList() throws Exception {
    try {
      AddObjectAccessListOptions addObjectAccessListOptions =
          new AddObjectAccessListOptions.Builder()
              .catalogIdentifier(catalogId)
              .objectIdentifier(objectId)
              .accounts(new java.util.ArrayList<String>(java.util.Arrays.asList(accountId)))
              .build();
      
      Response<AccessListBulkResponse> response =
          catalogManagementService.addObjectAccessList(addObjectAccessListOptions)
              .execute();
      
      assertNotNull(response);
      assertEquals(response.getStatusCode(), 201);
      
      AccessListBulkResponse accessListBulkResponseResult = response.getResult();
      assertNotNull(accessListBulkResponseResult);
      
    } catch (ServiceResponseException e) {
      fail(String.format("Service returned status code %d: %s\nError details: %s", e.getStatusCode(), e.getMessage(),
          e.getDebuggingInfo()));
    }
  }
  
  //====
  // Create Offering Instance block
  //====
  
  @Test(dependsOnMethods = {"testAddObjectAccessList"},
      expectedExceptions = BadRequestException.class)
  public void testCreateOfferingInstanceReturns400WhenBackendInputValidationFails() throws Exception {
    CreateOfferingInstanceOptions createOfferingInstanceOptions = new CreateOfferingInstanceOptions.Builder()
        .xAuthRefreshToken(refreshTokenAuthorized)
        .id("offering-instance-created-by-java-sdk")
        .label("offering-instance-created-by-java-sdk-label")
        .catalogId(catalogId)
        .offeringId(offeringId)
        .kindFormat("fake-kind")
        .version("0.0.3")
        .clusterId(clusterId)
        .clusterRegion(regionUsSouth)
        .clusterAllNamespaces(true)
        .build();
    
    catalogManagementService.createOfferingInstance(createOfferingInstanceOptions).execute();
  }
  
  @Test(dependsOnMethods = {"testAddObjectAccessList"},
      expectedExceptions = ForbiddenException.class)
  public void testCreateOfferingInstanceReturns403WhenUserIsNotAuthorized() throws Exception {
    CreateOfferingInstanceOptions createOfferingInstanceOptions = new CreateOfferingInstanceOptions.Builder()
        .xAuthRefreshToken(refreshTokenNotAuthorized)
        .id("offering-instance-created-by-java-sdk")
        .label("offering-instance-created-by-java-sdk-label")
        .catalogId(catalogId)
        .offeringId(offeringId)
        .kindFormat(kindOperator)
        .version("0.0.3")
        .clusterId(clusterId)
        .clusterRegion(regionUsSouth)
        .clusterAllNamespaces(true)
        .build();
    
    catalogManagementServiceNotAuthorized.createOfferingInstance(createOfferingInstanceOptions).execute();
  }
  
  @Test(dependsOnMethods = {"testAddObjectAccessList"},
      expectedExceptions = NotFoundException.class)
  public void testCreateOfferingInstanceReturns404WhenNoSuchResource() throws Exception {
    CreateOfferingInstanceOptions createOfferingInstanceOptions = new CreateOfferingInstanceOptions.Builder()
        .xAuthRefreshToken(refreshTokenAuthorized)
        .id("offering-instance-created-by-java-sdk")
        .label("offering-instance-created-by-java-sdk-label")
        .catalogId(catalogId + "cc")
        .offeringId(offeringId)
        .kindFormat(kindOperator)
        .version("0.0.3")
        .clusterId(clusterId)
        .clusterRegion(regionUsSouth)
        .clusterAllNamespaces(true)
        .build();
    
    catalogManagementService.createOfferingInstance(createOfferingInstanceOptions).execute();
  }
  
  @Test(dependsOnMethods = {"testAddObjectAccessList"})
  @Ignore
  public void testCreateOfferingInstance() throws Exception {
    try {
      CreateOfferingInstanceOptions createOfferingInstanceOptions =
          new CreateOfferingInstanceOptions.Builder().xAuthRefreshToken(refreshTokenAuthorized)
              .id("offering-instance-created-by-java-sdk")
              .label("offering-instance-created-by-java-sdk-label")
              .catalogId(catalogId)
              .offeringId(offeringId)
              .kindFormat(kindOperator)
              .version("0.0.3")
              .clusterId(clusterId)
              .clusterRegion(regionUsSouth)
              .clusterAllNamespaces(true)
              .build();
      
      Response<OfferingInstance> response =
          catalogManagementService.createOfferingInstance(createOfferingInstanceOptions)
              .execute();
      
      assertNotNull(response);
      assertEquals(response.getStatusCode(), 201);
      
      OfferingInstance offeringInstanceResult = response.getResult();
      assertNotNull(offeringInstanceResult);
      
      offeringInstanceId = offeringInstanceResult.id();
      assertNotNull(offeringInstanceId);
      
    } catch (ServiceResponseException e) {
      fail(String.format("Service returned status code %d: %s\nError details: %s", e.getStatusCode(), e.getMessage(),
          e.getDebuggingInfo()));
    }
  }
  
  //====
  // Get Offering Instance block
  //====
  
  @Test(dependsOnMethods = {"testAddObjectAccessList"},
      expectedExceptions = ForbiddenException.class)
  @Ignore
  public void testGetOfferingInstanceReturns403WhenUserIsNotAuthorized() throws Exception {
    GetOfferingInstanceOptions getOfferingInstanceOptions = new GetOfferingInstanceOptions.Builder()
        .instanceIdentifier(offeringInstanceId)
        .build();
    
    catalogManagementServiceNotAuthorized.getOfferingInstance(getOfferingInstanceOptions).execute();
  }
  
  @Test(expectedExceptions = NotFoundException.class)
  public void testGetOfferingInstanceReturns404WhenSuchResource() throws Exception {
    GetOfferingInstanceOptions getOfferingInstanceOptions = new GetOfferingInstanceOptions.Builder()
        .instanceIdentifier("offeringInstanceId")
        .build();
    
    catalogManagementService.getOfferingInstance(getOfferingInstanceOptions).execute();
  }
  
  @Test(dependsOnMethods = {"testAddObjectAccessList"})
  @Ignore
  public void testGetOfferingInstance() throws Exception {
    try {
      GetOfferingInstanceOptions getOfferingInstanceOptions = new GetOfferingInstanceOptions.Builder()
          .instanceIdentifier(offeringInstanceId)
          .build();
      
      Response<OfferingInstance> response = catalogManagementService.getOfferingInstance(getOfferingInstanceOptions)
          .execute();
      
      assertNotNull(response);
      assertEquals(response.getStatusCode(), 200);
      
      OfferingInstance offeringInstanceResult = response.getResult();
      assertNotNull(offeringInstanceResult);
      
    } catch (ServiceResponseException e) {
      fail(String.format("Service returned status code %d: %s\nError details: %s", e.getStatusCode(), e.getMessage(),
          e.getDebuggingInfo()));
    }
  }
  
  //====
  // Put Offering Instance block
  //====
  
  @Test(dependsOnMethods = {"testAddObjectAccessList"},
      expectedExceptions = BadRequestException.class)
  public void testPutOfferingInstanceReturns400WhenBackendInputValidationFails() throws Exception {
    PutOfferingInstanceOptions putOfferingInstanceOptions = new PutOfferingInstanceOptions.Builder()
        .instanceIdentifier("bogus-offering-instance-id")
        .xAuthRefreshToken(refreshTokenAuthorized)
        .xAuthRefreshToken(refreshTokenAuthorized)
        .id(offeringInstanceId)
        .catalogId(catalogId)
        .offeringId(offeringId)
        .kindFormat(kindOperator)
        .clusterId(clusterId)
        .clusterRegion(regionUsSouth)
        .clusterAllNamespaces(true)
        .build();
    
    catalogManagementService.putOfferingInstance(putOfferingInstanceOptions).execute();
  }
  
  @Test(dependsOnMethods = {"testAddObjectAccessList"},
      expectedExceptions = ForbiddenException.class)
  @Ignore
  public void testPutOfferingInstanceReturns403WhenUserIsNotAuthorized() throws Exception {
    PutOfferingInstanceOptions putOfferingInstanceOptions = new PutOfferingInstanceOptions.Builder()
        .instanceIdentifier("offering-instance-id")
        .xAuthRefreshToken(refreshTokenAuthorized)
        .xAuthRefreshToken(refreshTokenAuthorized)
        .id(offeringInstanceId)
        .catalogId(catalogId)
        .offeringId(offeringId)
        .kindFormat(kindOperator)
        .clusterId(clusterId)
        .clusterRegion(regionUsSouth)
        .clusterAllNamespaces(true)
        .build();
    
    catalogManagementServiceNotAuthorized.putOfferingInstance(putOfferingInstanceOptions).execute();
  }
  
  @Test(dependsOnMethods = {"testAddObjectAccessList"},
      expectedExceptions = NotFoundException.class)
  public void testPutOfferingInstanceReturns404WhenNoSuchResource() throws Exception {
    PutOfferingInstanceOptions putOfferingInstanceOptions = new PutOfferingInstanceOptions.Builder()
        .instanceIdentifier("offering-instance-id")
        .xAuthRefreshToken(refreshTokenAuthorized)
        .xAuthRefreshToken(refreshTokenAuthorized)
        .id("offering-instance-id")
        .catalogId(catalogId)
        .offeringId(offeringId)
        .kindFormat(kindOperator)
        .clusterId(clusterId)
        .clusterRegion(regionUsSouth)
        .clusterAllNamespaces(true)
        .build();
    
    catalogManagementService.putOfferingInstance(putOfferingInstanceOptions).execute();
  }
  
  @Test(dependsOnMethods = {"testAddObjectAccessList"})
  @Ignore
  public void testPutOfferingInstance() throws Exception {
    try {
      PutOfferingInstanceOptions putOfferingInstanceOptions = new PutOfferingInstanceOptions.Builder()
          .instanceIdentifier(offeringInstanceId)
          .xAuthRefreshToken(refreshTokenAuthorized)
          .id(offeringInstanceId)
          .catalogId(catalogId)
          .offeringId(offeringId)
          .kindFormat(kindOperator)
          .clusterId(clusterId)
          .clusterRegion(regionUsSouth)
          .clusterAllNamespaces(true)
          .build();
      
      Response<OfferingInstance> response = catalogManagementService.putOfferingInstance(putOfferingInstanceOptions)
          .execute();
      
      assertNotNull(response);
      assertEquals(response.getStatusCode(), 200);
      
      OfferingInstance offeringInstanceResult = response.getResult();
      assertNotNull(offeringInstanceResult);
      
    } catch (ServiceResponseException e) {
      fail(String.format("Service returned status code %d: %s\nError details: %s", e.getStatusCode(), e.getMessage(),
          e.getDebuggingInfo()));
    }
  }
  
  //====
  // Delete Version block
  //====
  
  @Test(dependsOnMethods = {"testAddObjectAccessList"},
      expectedExceptions = BadRequestException.class)
  public void testDeleteVersionReturns400WhenValidationFails() throws Exception {
    DeleteVersionOptions deleteVersionOptions = new DeleteVersionOptions.Builder()
        .versionLocId(bogusVersionLocatorId)
        .build();
    
    catalogManagementService.deleteVersion(deleteVersionOptions).execute();
  }
  
  @Test(dependsOnMethods = {"testAddObjectAccessList"},
      expectedExceptions = ForbiddenException.class)
  public void testDeleteVersionReturns403WhenUserIsNotAuthorized() throws Exception {
    DeleteVersionOptions deleteVersionOptions = new DeleteVersionOptions.Builder()
        .versionLocId(versionLocatorId)
        .build();
    
    catalogManagementServiceNotAuthorized.deleteVersion(deleteVersionOptions).execute();
  }
  
  @Test(dependsOnMethods = {"testAddObjectAccessList"})
  @Ignore
  public void testDeleteVersion() throws Exception {
    try {
      DeleteVersionOptions deleteVersionOptions = new DeleteVersionOptions.Builder()
          .versionLocId(versionLocatorId)
          .build();
      
      Response<Void> response = catalogManagementService.deleteVersion(deleteVersionOptions).execute();
      
      assertNotNull(response);
      assertEquals(response.getStatusCode(), 200);
      
    } catch (ServiceResponseException e) {
      fail(String.format("Service returned status code %d: %s\nError details: %s", e.getStatusCode(), e.getMessage(),
          e.getDebuggingInfo()));
    }
  }
  
  //====
  // Delete Operators block
  //====
  
  @Test(dependsOnMethods = {"testAddObjectAccessList"},
      expectedExceptions = BadRequestException.class)
  public void testDeleteOperatorsReturns400WhenBackendInputValidationFails() throws Exception {
    DeleteOperatorsOptions deleteOperatorsOptions = new DeleteOperatorsOptions.Builder()
        .xAuthRefreshToken(refreshTokenAuthorized)
        .clusterId(clusterId)
        .region(regionUsSouth)
        .versionLocatorId(bogusVersionLocatorId)
        .build();
    
    catalogManagementService.deleteOperators(deleteOperatorsOptions).execute();
  }
  
  @Test(dependsOnMethods = {"testAddObjectAccessList"},
      expectedExceptions = ForbiddenException.class)
  public void testDeleteOperatorsReturns403WhenUserIsNotAuthorized() throws Exception {
    DeleteOperatorsOptions deleteOperatorsOptions = new DeleteOperatorsOptions.Builder()
        .xAuthRefreshToken(refreshTokenNotAuthorized)
        .clusterId(clusterId)
        .region(regionUsSouth)
        .versionLocatorId(versionLocatorId)
        .build();
    
    catalogManagementServiceNotAuthorized.deleteOperators(deleteOperatorsOptions).execute();
  }
  
  // TLS handshake timeout
  @Test(dependsOnMethods = {"testAddObjectAccessList"})
  @Ignore
  public void testDeleteOperators() throws Exception {
    try {
      DeleteOperatorsOptions deleteOperatorsOptions = new DeleteOperatorsOptions.Builder()
          .xAuthRefreshToken(refreshTokenAuthorized)
          .clusterId(clusterId)
          .region(regionUsSouth)
          .versionLocatorId(versionLocatorId)
          .build();
      
      Response<Void> response = catalogManagementService.deleteOperators(deleteOperatorsOptions).execute();
      
      assertNotNull(response);
      assertEquals(response.getStatusCode(), 200);
      
    } catch (ServiceResponseException e) {
      fail(String.format("Service returned status code %d: %s\nError details: %s", e.getStatusCode(), e.getMessage(),
          e.getDebuggingInfo()));
    }
  }
  
  //====
  // Delete Offering Instance block
  //====
  
  @Test(dependsOnMethods = {"testAddObjectAccessList"},
      expectedExceptions = NotFoundException.class)
  public void testDeleteOfferingInstanceReturns404WhenNoSuchOfferingInstance() throws Exception {
    DeleteOfferingInstanceOptions deleteOfferingInstanceOptions =
        new DeleteOfferingInstanceOptions.Builder()
            .instanceIdentifier("offering-instance-id")
            .xAuthRefreshToken(refreshTokenAuthorized)
            .build();
    
    catalogManagementService.deleteOfferingInstance(deleteOfferingInstanceOptions)
        .execute();
  }
  
  @Test(dependsOnMethods = {"testAddObjectAccessList"},
      expectedExceptions = ForbiddenException.class)
  @Ignore
  public void testDeleteOfferingInstanceReturns403WhenUserIsNotAuthorized() throws Exception {
    DeleteOfferingInstanceOptions deleteOfferingInstanceOptions =
        new DeleteOfferingInstanceOptions.Builder()
            .instanceIdentifier(offeringInstanceId)
            .xAuthRefreshToken(refreshTokenNotAuthorized)
            .build();
    
    catalogManagementServiceNotAuthorized.deleteOfferingInstance(deleteOfferingInstanceOptions)
        .execute();
    
  }
  
  @Test(dependsOnMethods = {"testAddObjectAccessList"})
  @Ignore
  public void testDeleteOfferingInstance() throws Exception {
    try {
      DeleteOfferingInstanceOptions deleteOfferingInstanceOptions =
          new DeleteOfferingInstanceOptions.Builder()
              .instanceIdentifier(offeringInstanceId)
              .xAuthRefreshToken(refreshTokenAuthorized)
              .build();
      
      Response<Void> response = catalogManagementService.deleteOfferingInstance(deleteOfferingInstanceOptions)
          .execute();
      
      assertNotNull(response);
      assertEquals(response.getStatusCode(), 200);
      
    } catch (ServiceResponseException e) {
      fail(String.format("Service returned status code %d: %s\nError details: %s", e.getStatusCode(), e.getMessage(),
          e.getDebuggingInfo()));
    }
  }
  
  //====
  // Delete Object Access List block
  //====
  
  @Test(dependsOnMethods = {"testAddObjectAccessList"},
      expectedExceptions = NotFoundException.class)
  public void testDeleteObjectAccessListReturn404WhenNoSuchObject() throws Exception {
    DeleteObjectAccessListOptions deleteObjectAccessListOptions = new DeleteObjectAccessListOptions.Builder()
        .catalogIdentifier(catalogId)
        .objectIdentifier(bogusObjectId)
        .accounts(new java.util.ArrayList<String>(java.util.Arrays.asList(accountId)))
        .build();
    
    catalogManagementService.deleteObjectAccessList(deleteObjectAccessListOptions).execute();
  }
  
  @Test(dependsOnMethods = {"testAddObjectAccessList"},
      expectedExceptions = ForbiddenException.class)
  public void testDeleteObjectAccessListReturn403WhenUserIsNotAuthorized() throws Exception {
    DeleteObjectAccessListOptions deleteObjectAccessListOptions = new DeleteObjectAccessListOptions.Builder()
        .catalogIdentifier(catalogId)
        .objectIdentifier(objectId)
        .accounts(new java.util.ArrayList<String>(java.util.Arrays.asList(accountId)))
        .build();
    
    catalogManagementServiceNotAuthorized.deleteObjectAccessList(deleteObjectAccessListOptions).execute();
  }
  
  @Test(dependsOnMethods = {"testAddObjectAccessList"})
  public void testDeleteObjectAccessList() throws Exception {
    try {
      DeleteObjectAccessListOptions deleteObjectAccessListOptions =
          new DeleteObjectAccessListOptions.Builder()
              .catalogIdentifier(catalogId)
              .objectIdentifier(objectId)
              .accounts(new java.util.ArrayList<String>(java.util.Arrays.asList(accountId)))
              .build();
      
      Response<AccessListBulkResponse> response =
          catalogManagementService.deleteObjectAccessList(deleteObjectAccessListOptions)
              .execute();
      
      assertNotNull(response);
      assertEquals(response.getStatusCode(), 200);
      
      AccessListBulkResponse accessListBulkResponseResult = response.getResult();
      assertNotNull(accessListBulkResponseResult);
      
    } catch (ServiceResponseException e) {
      fail(String.format("Service returned status code %d: %s\nError details: %s", e.getStatusCode(), e.getMessage(),
          e.getDebuggingInfo()));
    }
  }
  
  //====
  // Delete Object Access block
  //====
  
  @Test(dependsOnMethods = {"testDeleteObjectAccessList"},
      expectedExceptions = NotFoundException.class)
  public void testDeleteObjectAccessReturns404WhenNoSuchObjectAccess() throws Exception {
    DeleteObjectAccessOptions deleteObjectAccessOptions = new DeleteObjectAccessOptions.Builder()
        .catalogIdentifier(catalogId)
        .objectIdentifier(objectId + "cc")
        .accountIdentifier(accountId)
        .build();
    
    catalogManagementService.deleteObjectAccess(deleteObjectAccessOptions).execute();
  }
  
  @Test(dependsOnMethods = {"testDeleteObjectAccessList"},
      expectedExceptions = ForbiddenException.class)
  public void testDeleteObjectAccessReturns403WhenUserIsNotAuthorized() throws Exception {
    DeleteObjectAccessOptions deleteObjectAccessOptions = new DeleteObjectAccessOptions.Builder()
        .catalogIdentifier(catalogId)
        .objectIdentifier(objectId)
        .accountIdentifier(accountId)
        .build();
    
    catalogManagementServiceNotAuthorized.deleteObjectAccess(deleteObjectAccessOptions).execute();
  }
  
  @Test(dependsOnMethods = {"testDeleteObjectAccessList"})
  @Ignore
  public void testDeleteObjectAccess() throws Exception {
    try {
      DeleteObjectAccessOptions deleteObjectAccessOptions = new DeleteObjectAccessOptions.Builder()
          .catalogIdentifier(catalogId)
          .objectIdentifier(objectId)
          .accountIdentifier(accountId)
          .build();
      
      Response<Void> response = catalogManagementService.deleteObjectAccess(deleteObjectAccessOptions).execute();
      
      assertNotNull(response);
      assertEquals(response.getStatusCode(), 200);
      
    } catch (ServiceResponseException e) {
      fail(String.format("Service returned status code %d: %s\nError details: %s", e.getStatusCode(), e.getMessage(),
          e.getDebuggingInfo()));
    }
  }
  
  //====
  // Delete Object block
  //====
  
  @Test(dependsOnMethods = {"testDeleteObjectAccessList"})
  public void testDeleteObjectReturns200WhenNoSuchObject() throws Exception {
    try {
      DeleteObjectOptions deleteObjectOptions = new DeleteObjectOptions.Builder()
          .catalogIdentifier(catalogId)
          .objectIdentifier(objectId + "cc")
          .build();
      
      Response<Void> response = catalogManagementService.deleteObject(deleteObjectOptions).execute();
      
      assertNotNull(response);
      assertEquals(response.getStatusCode(), 200);
    } catch (ServiceResponseException e) {
      fail(String.format("Service returned status code %d: %s\nError details: %s", e.getStatusCode(), e.getMessage(),
          e.getDebuggingInfo()));
    }
  }
  
  @Test(dependsOnMethods = {"testDeleteObjectAccessList"},
      expectedExceptions = ForbiddenException.class)
  @Ignore
  public void testDeleteObjectReturns403WhenUserIsNotAuthorized() throws Exception {
    DeleteObjectOptions deleteObjectOptions = new DeleteObjectOptions.Builder()
        .catalogIdentifier(catalogId)
        .objectIdentifier(objectId)
        .build();
    
    catalogManagementServiceNotAuthorized.deleteObject(deleteObjectOptions).execute();
  }
  
  @Test(dependsOnMethods = {"testDeleteObjectAccessList"})
  public void testDeleteObject() throws Exception {
    try {
      DeleteObjectOptions deleteObjectOptions = new DeleteObjectOptions.Builder()
          .catalogIdentifier(catalogId)
          .objectIdentifier(objectId)
          .build();
      
      Response<Void> response = catalogManagementService.deleteObject(deleteObjectOptions).execute();
      
      assertNotNull(response);
      assertEquals(response.getStatusCode(), 200);
      
    } catch (ServiceResponseException e) {
      fail(String.format("Service returned status code %d: %s\nError details: %s", e.getStatusCode(), e.getMessage(),
          e.getDebuggingInfo()));
    }
  }
  
  //====
  // Delete Offering block
  //====
  
  @Test(dependsOnMethods = {"testDeleteObjectAccessList"})
  public void testDeleteOfferingReturns200WhenNoSuchOfferings() throws Exception {
    try {
      DeleteOfferingOptions deleteOfferingOptions = new DeleteOfferingOptions.Builder()
          .catalogIdentifier(catalogId)
          .offeringId(bogusOfferingId)
          .build();
      
      Response<Void> response = catalogManagementService.deleteOffering(deleteOfferingOptions).execute();
      
      assertNotNull(response);
      assertEquals(response.getStatusCode(), 200);
      
    } catch (ServiceResponseException e) {
      fail(String.format("Service returned status code %d: %s\nError details: %s", e.getStatusCode(), e.getMessage(),
          e.getDebuggingInfo()));
    }
  }
  
  @Test(dependsOnMethods = {"testDeleteObjectAccessList"},
      expectedExceptions = ForbiddenException.class)
  public void testDeleteOfferingReturns403WhenUserIsNotAuthorized() throws Exception {
    DeleteOfferingOptions deleteOfferingOptions = new DeleteOfferingOptions.Builder()
        .catalogIdentifier(catalogId)
        .offeringId(offeringId)
        .build();
    
    catalogManagementServiceNotAuthorized.deleteOffering(deleteOfferingOptions).execute();
  }
  
  @Test(dependsOnMethods = {"testDeleteObjectAccessList"})
  public void testDeleteOffering() throws Exception {
    try {
      DeleteOfferingOptions deleteOfferingOptions = new DeleteOfferingOptions.Builder()
          .catalogIdentifier(catalogId)
          .offeringId(offeringId)
          .build();
      
      Response<Void> response = catalogManagementService.deleteOffering(deleteOfferingOptions).execute();
      
      assertNotNull(response);
      assertEquals(response.getStatusCode(), 200);
      
    } catch (ServiceResponseException e) {
      fail(String.format("Service returned status code %d: %s\nError details: %s", e.getStatusCode(), e.getMessage(),
          e.getDebuggingInfo()));
    }
  }
  
  //====
  // Delete Catalog block
  //====
  
  @Test(dependsOnMethods = {"testDeleteOffering"},
      expectedExceptions = BadRequestException.class)
  @Ignore
  public void testDeleteCatalogReturns400WhenNoSuchCatalog() throws Exception {
    DeleteCatalogOptions deleteCatalogOptions = new DeleteCatalogOptions.Builder()
        .catalogIdentifier(bogusCatalogId)
        .build();
    
    catalogManagementService.deleteCatalog(deleteCatalogOptions).execute();
  }
  
  @Test(dependsOnMethods = {"testDeleteOffering"},
      expectedExceptions = ForbiddenException.class)
  public void testDeleteCatalogReturns403WhenUserIsNotAuthorized() throws Exception {
    DeleteCatalogOptions deleteCatalogOptions = new DeleteCatalogOptions.Builder()
        .catalogIdentifier(catalogId)
        .build();
    
    catalogManagementServiceNotAuthorized.deleteCatalog(deleteCatalogOptions).execute();
  }
  
  // it has to be the last one executed
  @Test(dependsOnMethods = {"testDeleteOffering"})
  public void testDeleteCatalog() throws Exception {
    try {
      DeleteCatalogOptions deleteCatalogOptions = new DeleteCatalogOptions.Builder().catalogIdentifier(catalogId)
          .build();
      
      Response<Void> response = catalogManagementService.deleteCatalog(deleteCatalogOptions).execute();
      
      assertNotNull(response);
      assertEquals(response.getStatusCode(), 200);
      
    } catch (ServiceResponseException e) {
      fail(String.format("Service returned status code %d: %s\nError details: %s", e.getStatusCode(), e.getMessage(),
          e.getDebuggingInfo()));
    }
  }
  
  @AfterClass
  public void tearDown() {
    
    try {
      DeleteObjectAccessOptions deleteObjectAccessOptions = new DeleteObjectAccessOptions.Builder()
          .catalogIdentifier(catalogId)
          .objectIdentifier(objectId)
          .accountIdentifier(accountId)
          .build();
      catalogManagementService.deleteObjectAccess(deleteObjectAccessOptions).execute();
    } catch (ServiceResponseException e) {
      System.out.println("Object Access is already deleted.");
    }
    
    try {
      DeleteVersionOptions deleteVersionOptions = new DeleteVersionOptions.Builder()
          .versionLocId("testString")
          .build();
      catalogManagementService.deleteVersion(deleteVersionOptions).execute();
    } catch (ServiceResponseException e) {
      System.out.println("Version is already deleted.");
    }
    
    try {
      DeleteObjectOptions deleteObjectOptions = new DeleteObjectOptions.Builder()
          .catalogIdentifier(catalogId)
          .objectIdentifier(objectId)
          .build();
      catalogManagementService.deleteObject(deleteObjectOptions).execute();
    } catch (ServiceResponseException e) {
      System.out.println("Object is already deleted.");
    }
    
    try {
      DeleteCatalogOptions deleteCatalogOptions = new DeleteCatalogOptions.Builder().catalogIdentifier(catalogId)
          .build();
      catalogManagementService.deleteCatalog(deleteCatalogOptions).execute();
    } catch (ServiceResponseException e) {
      System.out.println("Catalog is already deleted.");
    }
    
    System.out.println("Clean up complete.");
  }
  
}
