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
  
  public CatalogManagement catalogManagementServiceAuthorized = null;
  public CatalogManagement catalogManagementServiceNotAuthorized = null;
  
  public static Map<String, String> config = null;
  
  /**
   * This method provides our config filename to the base class.
   */
  
  public String getConfigFilename() {
    return "../../catalog_mgmt.env";
  }
  
  private final String objectName = "object_created_by_java_sdk6";
  private final String objectCrn = "crn:v1:bluemix:public:iam-global-endpoint:global:::endpoint:private.iam.cloud.ibm" +
      ".com";
  private final String labelJavaSdk = "java-sdk";
  private final String kindVpe = "vpe";
  private final String kindRoks = "roks";
  private final String repoTypeGitPublic = "git_public";
  private final String regionUsSouth = "us-south";
  private final String namespaceJavaSdk = "java-sdk";
  private final String importOfferingZipUrl = "https://github.com/rhm-samples/node-red-operator/blob/master/node-red" +
      "-operator/bundle/0.0.2/node-red-operator.v0.0.2.clusterserviceversion.yaml";
  private final String bogusVersionLocatorId = "bogus-version-locator-id";
  
  private String accountId = null;
  private String clusterId = null;
  
  private String gitAuthToken = null;
  
  private String refreshTokenAuthorized = null;
  private String refreshTokenNotAuthorized = null;
  
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
    
    catalogManagementServiceAuthorized = CatalogManagement.newInstance(CatalogManagement.DEFAULT_SERVICE_NAME);
    assertNotNull(catalogManagementServiceAuthorized);
    assertNotNull(catalogManagementServiceAuthorized.getServiceUrl());
    
    IamAuthenticator authorizedIamAuthenticator =
        (IamAuthenticator) catalogManagementServiceAuthorized.getAuthenticator();
    IamToken iamAuthorizedToken = authorizedIamAuthenticator.requestToken();
    refreshTokenAuthorized = iamAuthorizedToken.getRefreshToken();
    
    // Load up our test-specific config properties.
    config = CredentialUtils.getServiceProperties(CatalogManagement.DEFAULT_SERVICE_NAME);
    assertNotNull(config);
    assertFalse(config.isEmpty());
    assertEquals(catalogManagementServiceAuthorized.getServiceUrl(), config.get("URL"));
    
    accountId = config.get("ACCOUNT_ID");
    assertNotNull(accountId);
    
    clusterId = config.get("CLUSTER_ID");
    assertNotNull(clusterId);
    
    gitAuthToken = config.get("GIT_TOKEN");
    assertNotNull(gitAuthToken);
    
    System.out.println("Setup complete.");
  }
  
  // Regarding execution order.
  // this file contains 230+ tests and almost 4000+ lines long, so, possibly hard to navigate in it and track
  // execution order as TestNG has its own random way of executing test cases
  
  // in order to have the same file layout as the other three SDK has, and by that have a better maintenance
  // experience working with these files I tried to tweak TestNG's execution order manipulation a little bit. Nothing
  // difficult, but requires some attention and patience.
  
  // the tweak is that, there are blocks where there is an operation, e.g. createCatalog, and its happy path
  // and negative tests, these blocks are marked by comments
  
  // from execution order point of view an execution of a block depends on another block's happy path test. The
  // reason behind this is that negative tests don't make any modification, they "just" return 4xx status code, but
  // the happy path tests may modify data in the system and this data might be pre-requisite for a later test
  
  // for example
  // "getCatalog" (and its negative tests)
  // depends on "createCatalog"
  
  // another example
  
  // block 1 - negative test 1
  // block 1 - negative test 2
  // block 1 - happy path
  
  // all of block 2 depends on "block 1 - happy path" test case
  // block 2 - negative test 1
  // block 2 - negative test 2
  // block 2 - happy path
  
  // if you have to put the happy path test to ignore state you have to modify the dependsOnMethods annotation of the
  // later tests
  
  // a block contains the negative tests first and as last one the happy path (except once :-) )
  
  //====
  // Create Catalog block
  //====
  
  @Test(expectedExceptions = BadRequestException.class)
  public void testCreateCatalogReturns400WhenUserIsNotAuthorized() throws Exception {
    
    CreateCatalogOptions createCatalogOptions = new CreateCatalogOptions.Builder()
        .label(labelJavaSdk)
        .addTags("sdk")
        .addTags("java")
        .owningAccount(accountId)
        .kind(kindVpe)
        .build();
    
    catalogManagementServiceNotAuthorized.createCatalog(createCatalogOptions).execute();
  }
  
  @Test(expectedExceptions = BadRequestException.class)
  public void testCreateCatalogReturn400WhenBackendInputValidationFails() throws Exception {
    
    CreateCatalogOptions createCatalogOptions = new CreateCatalogOptions.Builder()
        .label(labelJavaSdk)
        .rev("bogus-revision")
        .addTags("sdk")
        .addTags("java")
        .owningAccount(accountId)
        .kind(kindVpe)
        .build();
    
    catalogManagementServiceAuthorized.createCatalog(createCatalogOptions).execute();
  }
  
  @Test
  public void testCreateCatalog() throws Exception {
    try {
      CreateCatalogOptions createCatalogOptions = new CreateCatalogOptions.Builder()
          .label(labelJavaSdk)
          .addTags("sdk")
          .addTags("java")
          .kind(kindVpe)
          .owningAccount(accountId)
          .build();
      
      Response<Catalog> response = catalogManagementServiceAuthorized.createCatalog(createCatalogOptions).execute();
      assertNotNull(response);
      assertEquals(response.getStatusCode(), 201);
      
      Catalog catalogResult = response.getResult();
      assertNotNull(catalogResult);
      assertNotNull(catalogResult.id());
      catalogId = catalogResult.id();
      
    } catch (ServiceResponseException e) {
      fail(String.format("Service returned status code %d: %s\nError details: %s", e.getStatusCode(), e.getMessage(),
          e.getDebuggingInfo()));
    }
  }
  
  //====
  // Get Catalog block
  //====
  
  @Test(dependsOnMethods = {"testCreateCatalog"},
      expectedExceptions = NotFoundException.class)
  public void testGetCatalogReturns404WhenNoSuchCatalog() throws Exception {
    GetCatalogOptions getCatalogOptions = new GetCatalogOptions.Builder()
        .catalogIdentifier("invalid-" + catalogId)
        .build();
    
    catalogManagementServiceAuthorized.getCatalog(getCatalogOptions).execute();
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
      
      Response<Catalog> response = catalogManagementServiceAuthorized.getCatalog(getCatalogOptions).execute();
      assertNotNull(response);
      assertEquals(response.getStatusCode(), 200);
      
      Catalog catalogResult = response.getResult();
      assertNotNull(catalogResult);
      assertEquals(catalogResult.id(), catalogId);
      
    } catch (ServiceResponseException e) {
      fail(String.format("Service returned status code %d: %s\nError details: %s", e.getStatusCode(), e.getMessage(),
          e.getDebuggingInfo()));
    }
  }
  
  //====
  // Replace Catalog block
  //====
  
  @Test(dependsOnMethods = {"testGetCatalog"},
      expectedExceptions = ForbiddenException.class)
  public void testReplaceCatalogReturns403WhenUserIsNotAuthorized() throws Exception {
    ReplaceCatalogOptions replaceCatalogOptions = new ReplaceCatalogOptions.Builder()
        .catalogIdentifier(catalogId)
        .id(catalogId)
        .owningAccount(accountId)
        .kind(kindVpe)
        .build();
    
    catalogManagementServiceNotAuthorized.replaceCatalog(replaceCatalogOptions).execute();
  }
  
  @Test(dependsOnMethods = "testGetCatalog",
      expectedExceptions = BadRequestException.class)
  public void testReplaceCatalogReturns400WhenBackendInputValidationFails() throws Exception {
    ReplaceCatalogOptions replaceCatalogOptions = new ReplaceCatalogOptions.Builder()
        .catalogIdentifier(catalogId)
        .id("invalid-" + catalogId)
        .owningAccount(accountId)
        .kind(kindVpe)
        .build();
    
    catalogManagementServiceAuthorized.replaceCatalog(replaceCatalogOptions).execute();
  }
  
  @Test(dependsOnMethods = {"testGetCatalog"},
      expectedExceptions = NotFoundException.class)
  public void testReplaceCatalogReturns404WhenNoSuchCatalog() throws Exception {
    ReplaceCatalogOptions replaceCatalogOptions = new ReplaceCatalogOptions.Builder()
        .catalogIdentifier("invalid-" + catalogId)
        .id("invalid-" + catalogId)
        .owningAccount(accountId)
        .kind(kindVpe)
        .build();
    
    catalogManagementServiceAuthorized.replaceCatalog(replaceCatalogOptions).execute();
  }
  
  @Test(dependsOnMethods = {"testGetCatalog"})
  public void testReplaceCatalog() throws Exception {
    try {
      ArrayList<String> tags = new ArrayList<>(Arrays.asList("java", "sdk", "update"));
      ReplaceCatalogOptions replaceCatalogOptions = new ReplaceCatalogOptions.Builder()
          .catalogIdentifier(catalogId)
          .id(catalogId)
          .tags(tags)
          .owningAccount(accountId)
          .kind(kindVpe)
          .build();
      
      Response<Catalog> response = catalogManagementServiceAuthorized.replaceCatalog(replaceCatalogOptions).execute();
      assertNotNull(response);
      assertEquals(response.getStatusCode(), 200);
      
      Catalog catalogResult = response.getResult();
      assertNotNull(catalogResult);
      assertTrue(catalogResult.tags().containsAll(tags));
      
    } catch (ServiceResponseException e) {
      fail(String.format("Service returned status code %d: %s\nError details: %s", e.getStatusCode(), e.getMessage(),
          e.getDebuggingInfo()));
    }
  }
  
  //====
  // List Catalog block
  //====
  
  @Test(dependsOnMethods = {"testReplaceCatalog"})
  public void testListCatalogs() throws Exception {
    try {
      Response<CatalogSearchResult> response = catalogManagementServiceAuthorized.listCatalogs().execute();
      
      assertNotNull(response);
      assertEquals(response.getStatusCode(), 200);
      
      CatalogSearchResult catalogSearchResultResult = response.getResult();
      assertNotNull(catalogSearchResultResult);
      
      // it fails 8 times out of 10, if it fails the whole execution fails, so it is commented out
      // the reason behind this failure is that the database query has a limit over the result set and as more and
      // more tests run more and more catalogs in the system and the chance of having the newly created catalog in
      // the result set gets smaller
      // catalogSearchResultResult.getResources()
      //     .stream()
      //     .filter(p -> p.id().equals(catalogId))
      //     .findAny()
      //     .orElseThrow(() -> new RuntimeException(String.format("No catalog with id: %s", catalogId)));
      //
    } catch (ServiceResponseException e) {
      fail(String.format("Service returned status code %d: %s\nError details: %s", e.getStatusCode(), e.getMessage(),
          e.getDebuggingInfo()));
    }
  }
  
  //====
  //Create Offering block
  //====
  
  @Test(dependsOnMethods = {"testListCatalogs"},
      expectedExceptions = NotFoundException.class)
  public void testCreateOfferingReturns404WhenNoSuchCatalog() throws Exception {
    
    CreateOfferingOptions createOfferingOptions = new CreateOfferingOptions.Builder()
        .catalogIdentifier("invalid-" + catalogId)
        .build();
    
    catalogManagementServiceAuthorized.createOffering(createOfferingOptions).execute();
  }
  
  @Test(dependsOnMethods = {"testListCatalogs"},
      expectedExceptions = BadRequestException.class)
  public void testCreateOfferingReturns400WhenBackendInputValidationFails() throws Exception {
    CreateOfferingOptions createOfferingOptions = new CreateOfferingOptions.Builder()
        .catalogIdentifier(catalogId)
        .catalogId(catalogId)
        .name("offering created by java sdk")
        .build();
    
    catalogManagementServiceAuthorized.createOffering(createOfferingOptions).execute();
  }
  
  @Test(dependsOnMethods = {"testListCatalogs"},
      expectedExceptions = ForbiddenException.class)
  public void testCreateOfferingReturns403WhenUserIsNotAuthorized() throws Exception {
    CreateOfferingOptions createOfferingOptions = new CreateOfferingOptions.Builder()
        .catalogIdentifier(catalogId)
        .catalogId(catalogId)
        .name("offering-created-by-java-sdk")
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
      
      Response<Offering> response = catalogManagementServiceAuthorized.createOffering(createOfferingOptions).execute();
      
      assertNotNull(response);
      assertEquals(response.getStatusCode(), 201);
      
      Offering offeringResult = response.getResult();
      assertNotNull(offeringResult);
      assertNotNull(offeringResult.id());
      offeringId = offeringResult.id();
      
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
        .offeringId("invalid-" + offeringId)
        .build();
    
    catalogManagementServiceAuthorized.getOffering(getOfferingOptions).execute();
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
      
      Response<Offering> response = catalogManagementServiceAuthorized.getOffering(getOfferingOptions).execute();
      
      assertNotNull(response);
      assertEquals(response.getStatusCode(), 200);
      
      Offering offeringResult = response.getResult();
      assertNotNull(offeringResult);
      assertEquals(offeringResult.id(), offeringId);
      assertEquals(offeringResult.catalogId(), catalogId);
      
    } catch (ServiceResponseException e) {
      fail(String.format("Service returned status code %d: %s\nError details: %s", e.getStatusCode(), e.getMessage(),
          e.getDebuggingInfo()));
    }
  }
  
  //====
  // Replace Offering block
  //====
  
  @Test(dependsOnMethods = {"testGetOffering"},
      expectedExceptions = NotFoundException.class)
  public void testReplaceOfferingReturns404WhenNoSuchOffering() throws Exception {
    ReplaceOfferingOptions replaceOfferingOptions = new ReplaceOfferingOptions.Builder()
        .catalogIdentifier(catalogId)
        .offeringId("invalid-" + offeringId)
        .id("invalid-" + offeringId)
        .name("updated-offering-name-by-java-sdk")
        .build();
    
    catalogManagementServiceAuthorized.replaceOffering(replaceOfferingOptions).execute();
  }
  
  @Test(dependsOnMethods = {"testGetOffering"},
      expectedExceptions = BadRequestException.class)
  public void testReplaceOfferingReturns400WhenBackendInputValidationFails() throws Exception {
    ReplaceOfferingOptions replaceOfferingOptions = new ReplaceOfferingOptions.Builder()
        .catalogIdentifier(catalogId)
        .offeringId(offeringId)
        .id(offeringId)
        .name("updated offering name by java sdk")
        .build();
    
    catalogManagementServiceAuthorized.replaceOffering(replaceOfferingOptions).execute();
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
    
    catalogManagementServiceNotAuthorized.replaceOffering(replaceOfferingOptions).execute();
  }
  
  // once the version related conflict is resolved this test requires a conflict case
  @Test(dependsOnMethods = {"testGetOffering"},
      expectedExceptions = ConflictException.class)
  public void testReplaceOfferingReturns409WhenConflictOccurs() throws Exception {
    ReplaceOfferingOptions replaceOfferingOptions = new ReplaceOfferingOptions.Builder()
        .catalogIdentifier(catalogId)
        .offeringId(offeringId)
        .id(offeringId)
        .name("updated-offering-name-by-java-sdk")
        .build();
    
    catalogManagementServiceAuthorized.replaceOffering(replaceOfferingOptions).execute();
  }
  
  // it has a version related conflict
  // Once this test is enabled update the "dependsOnMethods" annotation of ListOfferings tests to this,
  // so those tests will be executed after this one
  @Test(dependsOnMethods = {"testGetOffering"})
  @Ignore
  public void testReplaceOffering() throws Exception {
    try {
      
      String updatedOfferingName = "updated-offering-name-by-java-sdk";
      ReplaceOfferingOptions replaceOfferingOptions = new ReplaceOfferingOptions.Builder()
          .catalogIdentifier(catalogId)
          .offeringId(offeringId)
          .id(offeringId)
          .name(updatedOfferingName)
          .build();
      
      Response<Offering> response = catalogManagementServiceAuthorized.replaceOffering(replaceOfferingOptions)
          .execute();
      
      assertNotNull(response);
      assertEquals(response.getStatusCode(), 200);
      
      Offering offeringResult = response.getResult();
      assertNotNull(offeringResult);
      assertEquals(offeringResult.id(), offeringId);
      assertEquals(offeringResult.catalogId(), catalogId);
      assertEquals(offeringResult.name(), updatedOfferingName);
      
    } catch (ServiceResponseException e) {
      fail(String.format("Service returned status code %d: %s\nError details: %s", e.getStatusCode(), e.getMessage(),
          e.getDebuggingInfo()));
    }
  }
  
  //====
  // List Offerings block
  //====
  
  @Test(dependsOnMethods = {"testGetOffering"},
      expectedExceptions = ForbiddenException.class)
  public void testListOfferingsReturns403WhenUserIsNotAuthorized() throws Exception {
    ListOfferingsOptions listOfferingsOptions = new ListOfferingsOptions.Builder()
        .catalogIdentifier(catalogId)
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
    
    catalogManagementServiceAuthorized.listOfferings(listOfferingsOptions).execute();
  }
  
  @Test(dependsOnMethods = {"testGetOffering"},
      expectedExceptions = NotFoundException.class)
  public void testListOfferingsReturns404WhenNoSuchCatalog() throws Exception {
    ListOfferingsOptions listOfferingsOptions = new ListOfferingsOptions.Builder()
        .catalogIdentifier("invalid-" + catalogId)
        .build();
    
    catalogManagementServiceAuthorized.listOfferings(listOfferingsOptions).execute();
  }
  
  @Test(dependsOnMethods = {"testGetOffering"})
  public void testListOfferings() throws Exception {
    try {
      
      int offset = 0;
      int limit = 50;
      boolean fetch = true;
      boolean isOfferingFound = false;
      int amountOfOfferings = 0;
      
      while (fetch) {
        ListOfferingsOptions listOfferingsOptions = new ListOfferingsOptions.Builder()
            .catalogIdentifier(catalogId)
            .offset(offset)
            .limit(limit)
            .build();
        
        Response<OfferingSearchResult> response = catalogManagementServiceAuthorized
            .listOfferings(listOfferingsOptions)
            .execute();
        
        assertNotNull(response);
        assertEquals(response.getStatusCode(), 200);
        
        OfferingSearchResult offeringSearchResultResult = response.getResult();
        assertNotNull(offeringSearchResultResult);
        
        if (offeringSearchResultResult.getResourceCount() > 0) {
          offset += 50;
          amountOfOfferings += offeringSearchResultResult.getResourceCount().intValue();
        } else {
          fetch = false;
        }
        
        if (!isOfferingFound) {
          Integer result = Math.toIntExact(response.getResult().getResources().stream()
              .filter(f -> f.id().equals(offeringId))
              .count());
          if (result != 0) {
            isOfferingFound = true;
          }
        }
      }
      
      System.out.println(String.format("Amount of offerings: %s", amountOfOfferings));
      
    } catch (ServiceResponseException e) {
      fail(String.format("Service returned status code %d: %s\nError details: %s", e.getStatusCode(), e.getMessage(),
          e.getDebuggingInfo()));
    }
  }
  
  //====
  // Import Offering block
  //====
  
  @Test(dependsOnMethods = {"testListOfferings"},
      expectedExceptions = ForbiddenException.class)
  public void testImportOfferingReturns403WhenUserIsNotAuthorized() throws Exception {
    ImportOfferingOptions importOfferingOptions = new ImportOfferingOptions.Builder()
        .catalogIdentifier(catalogId)
        .addTags("java")
        .addTags("sdk")
        .addTargetKinds(kindVpe)
        .zipurl(importOfferingZipUrl)
        .offeringId(offeringId)
        .targetVersion("0.0.3")
        .repoType(repoTypeGitPublic)
        .xAuthToken(gitAuthToken)
        .build();
    
    catalogManagementServiceNotAuthorized.importOffering(importOfferingOptions).execute();
  }
  
  @Test(dependsOnMethods = {"testListOfferings"},
      expectedExceptions = BadRequestException.class)
  public void testImportOfferingReturns400WhenBackendInputValidationFails() throws Exception {
    ImportOfferingOptions importOfferingOptions = new ImportOfferingOptions.Builder()
        .catalogIdentifier(catalogId)
        .addTags("java")
        .addTags("sdk")
        .addTargetKinds("rocks")
        .zipurl(importOfferingZipUrl)
        .offeringId(offeringId)
        .targetVersion("0.0.2-patch")
        .repoType(repoTypeGitPublic)
        .xAuthToken(gitAuthToken)
        .build();
    
    catalogManagementServiceAuthorized.importOffering(importOfferingOptions).execute();
  }
  
  @Test(dependsOnMethods = {"testListOfferings"},
      expectedExceptions = NotFoundException.class)
  public void testImportOfferingReturns404WhenNoSuchCatalog() throws Exception {
    ImportOfferingOptions importOfferingOptions = new ImportOfferingOptions.Builder()
        .catalogIdentifier("invalid-" + catalogId)
        .addTags("java")
        .addTags("sdk")
        .addTargetKinds(kindRoks)
        .zipurl(importOfferingZipUrl)
        .offeringId(offeringId)
        .targetVersion("0.0.2")
        .repoType(repoTypeGitPublic)
        .xAuthToken(gitAuthToken)
        .build();
    
    catalogManagementServiceAuthorized.importOffering(importOfferingOptions).execute();
  }
  
  @Test(dependsOnMethods = {"testListOfferings"})
  public void testImportOffering() throws Exception {
    try {
      ImportOfferingOptions importOfferingOptions = new ImportOfferingOptions.Builder()
          .catalogIdentifier(catalogId)
          .addTags("java")
          .addTags("sdk")
          .addTargetKinds(kindRoks)
          .zipurl(importOfferingZipUrl)
          .offeringId(offeringId)
          .targetVersion("0.0.2")
          .repoType(repoTypeGitPublic)
          .xAuthToken(gitAuthToken)
          .build();
      
      Response<Offering> response = catalogManagementServiceAuthorized.importOffering(importOfferingOptions).execute();
      
      assertNotNull(response);
      assertEquals(response.getStatusCode(), 201);
      
      Offering offeringResult = response.getResult();
      assertNotNull(offeringResult);
      assertNotNull(offeringResult.kinds().get(0).versions().get(0).versionLocator());
      versionLocatorId = offeringResult.kinds().get(0).versions().get(0).versionLocator();
      
    } catch (ServiceResponseException e) {
      fail(String.format("Service returned status code %d: %s\nError details: %s", e.getStatusCode(), e.getMessage(),
          e.getDebuggingInfo()));
    }
  }
  
  @Test(dependsOnMethods = {"testListOfferings"},
      expectedExceptions = ConflictException.class)
  public void testImportOfferingReturns409WhenConflictOccurs() throws Exception {
    ImportOfferingOptions importOfferingOptions = new ImportOfferingOptions.Builder()
        .catalogIdentifier(catalogId)
        .addTags("java")
        .addTags("sdk")
        .addTargetKinds(kindRoks)
        .zipurl(importOfferingZipUrl)
        .offeringId(offeringId)
        .targetVersion("0.0.2")
        .repoType(repoTypeGitPublic)
        .xAuthToken(gitAuthToken)
        .build();
    
    catalogManagementServiceAuthorized.importOffering(importOfferingOptions).execute();
  }
  
  //====
  // Reload Offering block
  //====
  
  @Test(dependsOnMethods = {"testImportOffering"},
      expectedExceptions = NotFoundException.class)
  public void testReloadOfferingReturns404WhenNoSuchOffering() throws Exception {
    ReloadOfferingOptions reloadOfferingOptions = new ReloadOfferingOptions.Builder()
        .catalogIdentifier(catalogId)
        .offeringId("invalid-" + offeringId)
        .targetVersion("0.0.2")
        .addTargetKinds(kindRoks)
        .zipurl(importOfferingZipUrl)
        .repoType(repoTypeGitPublic)
        .build();
    
    catalogManagementServiceAuthorized.reloadOffering(reloadOfferingOptions).execute();
  }
  
  @Test(dependsOnMethods = {"testImportOffering"},
      expectedExceptions = ForbiddenException.class)
  public void testReloadOfferingReturns403WhenUserIsNotAuthorized() throws Exception {
    ReloadOfferingOptions reloadOfferingOptions = new ReloadOfferingOptions.Builder()
        .catalogIdentifier(catalogId)
        .offeringId(offeringId)
        .targetVersion("0.0.2")
        .addTargetKinds(kindVpe)
        .zipurl(importOfferingZipUrl)
        .repoType(repoTypeGitPublic)
        .build();
    
    catalogManagementServiceNotAuthorized.reloadOffering(reloadOfferingOptions).execute();
  }
  
  // Error: Could not find a kind with a target/format value of roks:operator for the current offering, Code: 400
  // once this test is enabled the block after it can depends on it
  @Test(dependsOnMethods = {"testImportOffering"})
  @Ignore
  public void testReloadOffering() throws Exception {
    try {
      ReloadOfferingOptions reloadOfferingOptions = new ReloadOfferingOptions.Builder()
          .catalogIdentifier(catalogId)
          .offeringId(offeringId)
          .targetVersion("0.0.2")
          .addTargetKinds(kindRoks)
          .zipurl(importOfferingZipUrl)
          .repoType(repoTypeGitPublic)
          .build();
      
      Response<Offering> response = catalogManagementServiceAuthorized.reloadOffering(reloadOfferingOptions).execute();
      
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
    
    State stateModel = new State.Builder()
        .current("new")
        .build();
    
    CreateObjectOptions createObjectOptions = new CreateObjectOptions.Builder()
        .catalogIdentifier(catalogId)
        .catalogId(catalogId)
        .name(objectName)
        .crn(objectCrn)
        .parentId("bogus region name")
        .kind(kindVpe)
        .publish(publishObjectModel)
        .state(stateModel)
        .build();
    
    catalogManagementServiceAuthorized.createObject(createObjectOptions).execute();
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
        .catalogId(catalogId)
        .name(objectName)
        .crn(objectCrn)
        .parentId(regionUsSouth)
        .kind(kindVpe)
        .publish(publishObjectModel)
        .state(stateModel)
        .build();
    
    catalogManagementServiceNotAuthorized.createObject(createObjectOptions).execute();
  }
  
  @Test(dependsOnMethods = {"testImportOffering"},
      expectedExceptions = NotFoundException.class)
  public void testCreateObjectReturns404WhenNoSuchCatalog() throws Exception {
    PublishObject publishObjectModel = new PublishObject.Builder()
        .permitIbmPublicPublish(true)
        .ibmApproved(true)
        .publicApproved(true)
        .build();
    State stateModel = new State.Builder()
        .current("new")
        .build();
    
    CreateObjectOptions createObjectOptions = new CreateObjectOptions.Builder()
        .catalogIdentifier("invalid-" + catalogId)
        .catalogId("invalid-" + catalogId)
        .name(objectName)
        .crn(objectCrn)
        .parentId(regionUsSouth)
        .kind(kindVpe)
        .publish(publishObjectModel)
        .state(stateModel)
        .build();
    
    catalogManagementServiceAuthorized.createObject(createObjectOptions).execute();
  }
  
  @Test(dependsOnMethods = {"testImportOffering"})
  public void testCreateObject() throws Exception {
    try {
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
          .catalogId(catalogId)
          .name(objectName)
          .crn(objectCrn)
          .parentId(regionUsSouth)
          .kind(kindVpe)
          .publish(publishObjectModel)
          .state(stateModel)
          .build();
      
      Response<CatalogObject> response = catalogManagementServiceAuthorized.createObject(createObjectOptions).execute();
      
      assertNotNull(response);
      assertEquals(response.getStatusCode(), 201);
      
      CatalogObject catalogObjectResult = response.getResult();
      assertNotNull(catalogObjectResult);
      assertNotNull(catalogObjectResult.id());
      
      objectId = catalogObjectResult.id();
      
    } catch (ServiceResponseException e) {
      fail(String.format("Service returned status code %d: %s\nError details: %s", e.getStatusCode(), e.getMessage(),
          e.getDebuggingInfo()));
    }
  }
  
  //====
  // Get Offering Audit block
  //====
  
  @Test(dependsOnMethods = {"testCreateObject"})
  public void testGetOfferingAuditReturns200WhenNoSuchOfferings() throws Exception {
    try {
      GetOfferingAuditOptions getOfferingAuditOptions = new GetOfferingAuditOptions.Builder()
          .catalogIdentifier(catalogId)
          .offeringId("invalid-" + offeringId)
          .build();
      
      Response<AuditLog> response = catalogManagementServiceAuthorized.getOfferingAudit(getOfferingAuditOptions)
          .execute();
      
      assertNotNull(response);
      assertEquals(response.getStatusCode(), 200);
      
    } catch (ServiceResponseException e) {
      fail(String.format("Service returned status code %d: %s\nError details: %s", e.getStatusCode(), e.getMessage(),
          e.getDebuggingInfo()));
    }
  }
  
  @Test(dependsOnMethods = {"testCreateObject"},
      expectedExceptions = ForbiddenException.class)
  public void testGetOfferingAuditReturns403WhenUserIsNotAuthorized() throws Exception {
    GetOfferingAuditOptions getOfferingAuditOptions = new GetOfferingAuditOptions.Builder()
        .catalogIdentifier(catalogId)
        .offeringId(offeringId)
        .build();
    
    catalogManagementServiceNotAuthorized.getOfferingAudit(getOfferingAuditOptions).execute();
  }
  
  @Test(dependsOnMethods = {"testCreateObject"})
  public void testGetOfferingAudit() throws Exception {
    try {
      GetOfferingAuditOptions getOfferingAuditOptions = new GetOfferingAuditOptions.Builder()
          .catalogIdentifier(catalogId)
          .offeringId(offeringId)
          .build();
      
      Response<AuditLog> response = catalogManagementServiceAuthorized.getOfferingAudit(getOfferingAuditOptions)
          .execute();
      
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
  public void testGetCatalogAccount() throws Exception {
    try {
      Response<Account> response = catalogManagementServiceAuthorized.getCatalogAccount().execute();
      
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
  public void testUpdateCatalogAccountReturns400WhenNoSuchAccount() throws Exception {
    UpdateCatalogAccountOptions updateCatalogAccountOptions = new UpdateCatalogAccountOptions.Builder()
        .id("invalid-" + accountId)
        .build();
    
    catalogManagementServiceAuthorized.updateCatalogAccount(updateCatalogAccountOptions).execute();
  }
  
  @Test(dependsOnMethods = {"testGetCatalogAccount"},
      expectedExceptions = ForbiddenException.class)
  public void testUpdateCatalogAccountReturns403WhenUserIsNotAuthorized() throws Exception {
    UpdateCatalogAccountOptions updateCatalogAccountOptions = new UpdateCatalogAccountOptions.Builder()
        .id(accountId)
        .build();
    
    catalogManagementServiceNotAuthorized.updateCatalogAccount(updateCatalogAccountOptions).execute();
  }
  
  @Test(dependsOnMethods = {"testGetCatalogAccount"},
      expectedExceptions = BadRequestException.class)
  @Ignore
  public void testUpdateCatalogAccountReturns400WhenBackendInputValidationFails() throws Exception {
    
    // user is not granted for this operation
    // a body with failing data comes here
    
    UpdateCatalogAccountOptions updateCatalogAccountOptions = new UpdateCatalogAccountOptions.Builder()
        .id(accountId)
        .build();
    
    catalogManagementServiceAuthorized.updateCatalogAccount(updateCatalogAccountOptions).execute();
  }
  
  // once this one is not ignored the following block dependency can point here
  @Test(dependsOnMethods = {"testGetCatalogAccount"})
  @Ignore
  public void testUpdateCatalogAccount() throws Exception {
    try {
      
      // user is not granted for this operation
      // a body with right data comes here
      
      UpdateCatalogAccountOptions updateCatalogAccountOptions = new UpdateCatalogAccountOptions.Builder()
          .id(accountId)
          .build();
      
      Response<Void> response = catalogManagementServiceAuthorized.updateCatalogAccount(updateCatalogAccountOptions)
          .execute();
      
      assertNotNull(response);
      assertEquals(response.getStatusCode(), 200);
      assertNotNull(response.getResult());
      
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
      Response<AuditLog> response = catalogManagementServiceAuthorized.getCatalogAccountAudit().execute();
      
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
      expectedExceptions = ForbiddenException.class)
  public void testGetCatalogAccountFiltersReturns403WhenUserIsNotAuthorized() throws Exception {
    GetCatalogAccountFiltersOptions getCatalogAccountFiltersOptions = new GetCatalogAccountFiltersOptions.Builder()
        .catalog(catalogId)
        .build();
    
    catalogManagementServiceNotAuthorized.getCatalogAccountFilters(getCatalogAccountFiltersOptions).execute();
  }
  
  @Test(dependsOnMethods = {"testGetCatalogAccountAudit"},
      expectedExceptions = NotFoundException.class)
  public void testGetCatalogAccountFiltersReturns404WhenNoSuchCatalog() throws Exception {
    GetCatalogAccountFiltersOptions getCatalogAccountFiltersOptions = new GetCatalogAccountFiltersOptions.Builder()
        .catalog("invalid-" + catalogId)
        .build();
    
    catalogManagementServiceAuthorized.getCatalogAccountFilters(getCatalogAccountFiltersOptions).execute();
  }
  
  @Test(dependsOnMethods = {"testGetCatalogAccountAudit"})
  public void testGetCatalogAccountFilters() throws Exception {
    try {
      GetCatalogAccountFiltersOptions getCatalogAccountFiltersOptions = new GetCatalogAccountFiltersOptions.Builder()
          .catalog(catalogId)
          .build();
      
      Response<AccumulatedFilters> response =
          catalogManagementServiceAuthorized.getCatalogAccountFilters(getCatalogAccountFiltersOptions)
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
        .catalogIdentifier("invalid-" + catalogId)
        .build();
    
    catalogManagementServiceAuthorized.getCatalogAudit(getCatalogAuditOptions).execute();
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
      
      Response<AuditLog> response = catalogManagementServiceAuthorized.getCatalogAudit(getCatalogAuditOptions)
          .execute();
      
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
        .catalog(catalogId)
        .select("all")
        .build();
    
    catalogManagementServiceNotAuthorized.getConsumptionOfferings(getConsumptionOfferingsOptions)
        .execute();
  }
  
  @Test(dependsOnMethods = {"testGetCatalogAudit"},
      expectedExceptions = NotFoundException.class)
  public void testGetConsumptionOfferingsReturns404WhenNoSuchCatalog() throws Exception {
    GetConsumptionOfferingsOptions getConsumptionOfferingsOptions =
        new GetConsumptionOfferingsOptions.Builder()
            .catalog("invalid-" + catalogId)
            .select("all")
            .build();
    
    catalogManagementServiceAuthorized.getConsumptionOfferings(getConsumptionOfferingsOptions)
        .execute();
  }
  
  @Test(dependsOnMethods = {"testGetCatalogAudit"})
  public void testGetConsumptionOfferings() throws Exception {
    try {
      GetConsumptionOfferingsOptions getConsumptionOfferingsOptions = new GetConsumptionOfferingsOptions.Builder()
          .catalog(catalogId)
          .select("all")
          .build();
      
      Response<OfferingSearchResult> response =
          catalogManagementServiceAuthorized.getConsumptionOfferings(getConsumptionOfferingsOptions)
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
    ImportOfferingVersionOptions importOfferingVersionOptions = new ImportOfferingVersionOptions.Builder()
        .catalogIdentifier(catalogId)
        .offeringId(offeringId)
        .addTargetKinds("rocks")
        .zipurl(importOfferingZipUrl)
        .targetVersion("0.0.3")
        .repoType(repoTypeGitPublic)
        .build();
    
    catalogManagementServiceAuthorized.importOfferingVersion(importOfferingVersionOptions).execute();
  }
  
  @Test(dependsOnMethods = {"testGetConsumptionOfferings"},
      expectedExceptions = NotFoundException.class)
  public void testImportOfferingVersionReturns404WhenNoSuchOfferings() throws Exception {
    ImportOfferingVersionOptions importOfferingVersionOptions = new ImportOfferingVersionOptions.Builder()
        .catalogIdentifier(catalogId)
        .offeringId("invalid-" + offeringId)
        .addTargetKinds(kindRoks)
        .zipurl(importOfferingZipUrl)
        .targetVersion("0.0.3")
        .repoType(repoTypeGitPublic)
        .build();
    
    catalogManagementServiceAuthorized.importOfferingVersion(importOfferingVersionOptions).execute();
  }
  
  @Test(dependsOnMethods = {"testGetConsumptionOfferings"},
      expectedExceptions = ForbiddenException.class)
  public void testImportOfferingVersionReturns403WhenUserIsNotAuthorized() throws Exception {
    ImportOfferingVersionOptions importOfferingVersionOptions = new ImportOfferingVersionOptions.Builder()
        .catalogIdentifier(catalogId)
        .offeringId(offeringId)
        .addTargetKinds(kindRoks)
        .zipurl(importOfferingZipUrl)
        .targetVersion("0.0.3")
        .repoType(repoTypeGitPublic)
        .build();
    
    catalogManagementServiceNotAuthorized.importOfferingVersion(importOfferingVersionOptions).execute();
  }
  
  @Test(dependsOnMethods = {"testGetConsumptionOfferings"})
  public void testImportOfferingVersion() throws Exception {
    try {
      ImportOfferingVersionOptions importOfferingVersionOptions = new ImportOfferingVersionOptions.Builder()
          .catalogIdentifier(catalogId)
          .offeringId(offeringId)
          .addTargetKinds(kindRoks)
          .zipurl(importOfferingZipUrl)
          .targetVersion("0.0.3")
          .repoType(repoTypeGitPublic)
          .build();
      
      Response<Offering> response =
          catalogManagementServiceAuthorized.importOfferingVersion(importOfferingVersionOptions)
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
  @Test(dependsOnMethods = {"testImportOfferingVersion"},
      expectedExceptions = NotFoundException.class)
  @Ignore
  public void testReplaceOfferingIconReturns404WhenNoSuchOffering() throws Exception {
    ReplaceOfferingIconOptions replaceOfferingIconOptions = new ReplaceOfferingIconOptions.Builder()
        .catalogIdentifier(catalogId)
        .offeringId("invalid-" + offeringId)
        .fileName("filename.jpg")
        .build();
    
    catalogManagementServiceAuthorized.replaceOfferingIcon(replaceOfferingIconOptions).execute();
  }
  
  // this function is disabled
  @Test(dependsOnMethods = {"testImportOfferingVersion"},
      expectedExceptions = ForbiddenException.class)
  @Ignore
  public void testReplaceOfferingIconReturns403WhenUserIsNotAuthorized() throws Exception {
    ReplaceOfferingIconOptions replaceOfferingIconOptions = new ReplaceOfferingIconOptions.Builder()
        .catalogIdentifier(catalogId)
        .offeringId(offeringId)
        .fileName("filename.jpg")
        .build();
    
    catalogManagementServiceNotAuthorized.replaceOfferingIcon(replaceOfferingIconOptions).execute();
  }
  
  // this function is disabled
  // once it is enabled the following block dependency can point here
  @Test(dependsOnMethods = {"testImportOfferingVersion"})
  @Ignore
  public void testReplaceOfferingIcon() throws Exception {
    try {
      ReplaceOfferingIconOptions replaceOfferingIconOptions = new ReplaceOfferingIconOptions.Builder()
          .catalogIdentifier(catalogId)
          .offeringId(offeringId)
          .fileName("filename.jpg")
          .build();
      
      Response<Offering> response = catalogManagementServiceAuthorized.replaceOfferingIcon(replaceOfferingIconOptions)
          .execute();
      
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
  // Update Offering IBM
  //====
  
  @Test(dependsOnMethods = {"testImportOfferingVersion"},
      expectedExceptions = BadRequestException.class)
  @Ignore("once the user is granted for this operation this test can be executed")
  public void testUpdateOfferingIbmReturns400WhenBackendInputValidationFails() throws Exception {
    UpdateOfferingIbmOptions updateOfferingIbmOptions = new UpdateOfferingIbmOptions.Builder()
        .catalogIdentifier(catalogId)
        .offeringId(offeringId)
        .approvalType("bogus approval type")
        .approved("true")
        .build();
    
    catalogManagementServiceAuthorized.updateOfferingIbm(updateOfferingIbmOptions).execute();
  }
  
  @Test(dependsOnMethods = {"testImportOfferingVersion"},
      expectedExceptions = BadRequestException.class)
  @Ignore("once the user is granted for this operation this test can be executed")
  public void testUpdateOfferingIbmReturns404WhenNoSuchOffering() throws Exception {
    UpdateOfferingIbmOptions updateOfferingIbmOptions = new UpdateOfferingIbmOptions.Builder()
        .catalogIdentifier(catalogId)
        .offeringId("invalid-" + offeringId)
        .approvalType("allow_request")
        .approved("true")
        .build();
    
    catalogManagementServiceAuthorized.updateOfferingIbm(updateOfferingIbmOptions).execute();
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
  
  @Test(dependsOnMethods = {"testImportOfferingVersion"})
  @Ignore("once the user is granted for this operation this test can be executed")
  public void testUpdateOfferingIbm() throws Exception {
    try {
      UpdateOfferingIbmOptions updateOfferingIbmOptions = new UpdateOfferingIbmOptions.Builder()
          .catalogIdentifier(catalogId)
          .offeringId(offeringId)
          .approvalType("allow_request")
          .approved("true")
          .build();
      
      Response<ApprovalResult> response = catalogManagementServiceAuthorized.updateOfferingIbm(updateOfferingIbmOptions)
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
        .region(regionUsSouth)
        .build();
    
    catalogManagementServiceAuthorized.getOfferingUpdates(getOfferingUpdatesOptions).execute();
  }
  
  // it always complaining about offering types which is somehow related to create/import offerings
  // once this is resolved there is a chance we can squeeze a 404 out from the service
  
  @Test(dependsOnMethods = {"testImportOfferingVersion"},
      expectedExceptions = BadRequestException.class)
  @Ignore("Offering type issues")
  public void testGetOfferingUpdatesReturns404WhenNoSuchOfferings() throws Exception {
    GetOfferingUpdatesOptions getOfferingUpdatesOptions = new GetOfferingUpdatesOptions.Builder()
        .catalogIdentifier(catalogId)
        .offeringId("invalid-" + offeringId)
        .kind(kindRoks)
        .version("0.0.2")
        .clusterId(clusterId)
        .region(regionUsSouth)
        .build();
    
    catalogManagementServiceAuthorized.getOfferingUpdates(getOfferingUpdatesOptions).execute();
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
  @Ignore("Requires an offering type different than helm, roks or vpe")
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
          catalogManagementServiceAuthorized.getOfferingUpdates(getOfferingUpdatesOptions)
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
  public void testGetOfferingAboutReturns400WhenBackendInputValidationFails() throws Exception {
    GetOfferingAboutOptions getOfferingAboutOptions = new GetOfferingAboutOptions.Builder()
        .versionLocId(bogusVersionLocatorId)
        .build();
    
    catalogManagementServiceAuthorized.getOfferingAbout(getOfferingAboutOptions).execute();
  }
  
  @Test(dependsOnMethods = {"testImportOfferingVersion"},
      expectedExceptions = NotFoundException.class)
  public void testGetOfferingAboutReturns404WhenNoSuchVersion() throws Exception {
    GetOfferingAboutOptions getOfferingAboutOptions = new GetOfferingAboutOptions.Builder()
        .versionLocId("invalid-" + versionLocatorId)
        .build();
    
    catalogManagementServiceAuthorized.getOfferingAbout(getOfferingAboutOptions).execute();
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
      
      Response<String> response = catalogManagementServiceAuthorized.getOfferingAbout(getOfferingAboutOptions)
          .execute();
      
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
        .versionLocId(versionLocatorId)
        .licenseId("license-id-is-needed")
        .build();
    
    catalogManagementServiceAuthorized.getOfferingLicense(getOfferingLicenseOptions).execute();
  }
  
  @Test(dependsOnMethods = {"testGetOfferingAbout"},
      expectedExceptions = NotFoundException.class)
  public void testGetOfferingLicenseReturns404WhenNoSuchVersion() throws Exception {
    GetOfferingLicenseOptions getOfferingLicenseOptions = new GetOfferingLicenseOptions.Builder()
        .versionLocId("invalid-" + versionLocatorId)
        .licenseId("license-id-is-needed")
        .build();
    
    catalogManagementServiceAuthorized.getOfferingLicense(getOfferingLicenseOptions).execute();
  }
  
  @Test(dependsOnMethods = {"testGetOfferingAbout"},
      expectedExceptions = ForbiddenException.class)
  @Ignore("No license")
  public void testGetOfferingLicenseReturns403WhenUserIsNotAuthorized() throws Exception {
    GetOfferingLicenseOptions getOfferingLicenseOptions = new GetOfferingLicenseOptions.Builder()
        .versionLocId(versionLocatorId)
        .licenseId("license-id-is-needed")
        .build();
    
    catalogManagementServiceNotAuthorized.getOfferingLicense(getOfferingLicenseOptions).execute();
  }
  
  // once this test is enabled the next block's dependency can point here
  @Test(dependsOnMethods = {"testGetOfferingAbout"})
  @Ignore("No license")
  public void testGetOfferingLicense() throws Exception {
    try {
      GetOfferingLicenseOptions getOfferingLicenseOptions = new GetOfferingLicenseOptions.Builder()
          .versionLocId(versionLocatorId)
          .licenseId("license-id-is-needed")
          .build();
      
      Response<String> response = catalogManagementServiceAuthorized.getOfferingLicense(getOfferingLicenseOptions)
          .execute();
      
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
    
    catalogManagementServiceAuthorized.getOfferingContainerImages(getOfferingContainerImagesOptions)
        .execute();
  }
  
  @Test(dependsOnMethods = {"testGetOfferingAbout"},
      expectedExceptions = NotFoundException.class)
  public void testGetOfferingContainerImagesReturns404WhenNoSuchVersion() throws Exception {
    GetOfferingContainerImagesOptions getOfferingContainerImagesOptions =
        new GetOfferingContainerImagesOptions.Builder()
            .versionLocId("invalid-" + versionLocatorId)
            .build();
    
    catalogManagementServiceAuthorized.getOfferingContainerImages(getOfferingContainerImagesOptions)
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
          catalogManagementServiceAuthorized.getOfferingContainerImages(getOfferingContainerImagesOptions)
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
  // Deprecate Version block
  //====
  
  @Test(dependsOnMethods = {"testGetOfferingContainerImages"},
      expectedExceptions = NotFoundException.class)
  public void testDeprecateVersionReturns404WhenNoSuchVersion() throws Exception {
    DeprecateVersionOptions deprecateVersionOptions = new DeprecateVersionOptions.Builder()
        .versionLocId("invalid-" + versionLocatorId)
        .build();
    
    catalogManagementServiceAuthorized.deprecateVersion(deprecateVersionOptions).execute();
  }
  
  @Test(dependsOnMethods = {"testGetOfferingContainerImages"},
      expectedExceptions = BadRequestException.class)
  public void testDeprecateVersionReturns400WhenBackendInputValidationFails() throws Exception {
    DeprecateVersionOptions deprecateVersionOptions = new DeprecateVersionOptions.Builder()
        .versionLocId(bogusVersionLocatorId)
        .build();
    
    catalogManagementServiceAuthorized.deprecateVersion(deprecateVersionOptions).execute();
  }
  
  @Test(dependsOnMethods = {"testGetOfferingContainerImages"},
      expectedExceptions = ForbiddenException.class)
  public void testDeprecateVersionReturns403WhenUserIsNotAuthorized() throws Exception {
    DeprecateVersionOptions deprecateVersionOptions = new DeprecateVersionOptions.Builder()
        .versionLocId(versionLocatorId)
        .build();
    
    catalogManagementServiceNotAuthorized.deprecateVersion(deprecateVersionOptions).execute();
  }
  
  // once this test is enabled the next block's dependency can point here
  @Test(dependsOnMethods = {"testGetOfferingContainerImages"})
  @Ignore("Order of states is needed")
  public void testDeprecateVersion() throws Exception {
    try {
      DeprecateVersionOptions deprecateVersionOptions = new DeprecateVersionOptions.Builder()
          .versionLocId(versionLocatorId)
          .build();
      
      Response<Void> response = catalogManagementServiceAuthorized.deprecateVersion(deprecateVersionOptions).execute();
      
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
    
    catalogManagementServiceAuthorized.accountPublishVersion(accountPublishVersionOptions).execute();
  }
  
  @Test(dependsOnMethods = {"testGetOfferingContainerImages"},
      expectedExceptions = NotFoundException.class)
  public void testAccountPublishVersionReturns404WhenNoSuchVersion() throws Exception {
    AccountPublishVersionOptions accountPublishVersionOptions = new AccountPublishVersionOptions.Builder()
        .versionLocId("invalid-" + versionLocatorId)
        .build();
    
    catalogManagementServiceAuthorized.accountPublishVersion(accountPublishVersionOptions).execute();
  }
  
  @Test(dependsOnMethods = {"testGetOfferingContainerImages"},
      expectedExceptions = ForbiddenException.class)
  public void testAccountPublishVersionReturns403WhenUserIsNotAuthorized() throws Exception {
    AccountPublishVersionOptions accountPublishVersionOptions = new AccountPublishVersionOptions.Builder()
        .versionLocId(versionLocatorId)
        .build();
    
    catalogManagementServiceNotAuthorized.accountPublishVersion(accountPublishVersionOptions).execute();
  }
  
  // once this test is enabled the next block's dependency can point here
  @Test(dependsOnMethods = {"testGetOfferingContainerImages"})
  @Ignore("Order of states is needed")
  public void testAccountPublishVersion() throws Exception {
    try {
      AccountPublishVersionOptions accountPublishVersionOptions = new AccountPublishVersionOptions.Builder()
          .versionLocId(versionLocatorId)
          .build();
      
      Response<Void> response = catalogManagementServiceAuthorized.accountPublishVersion(accountPublishVersionOptions)
          .execute();
      
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
    
    catalogManagementServiceAuthorized.ibmPublishVersion(ibmPublishVersionOptions).execute();
  }
  
  @Test(dependsOnMethods = {"testGetOfferingContainerImages"},
      expectedExceptions = NotFoundException.class)
  public void testIbmPublishVersionReturns404WhenNoSuchVersion() throws Exception {
    IbmPublishVersionOptions ibmPublishVersionOptions = new IbmPublishVersionOptions.Builder()
        .versionLocId("invalid-" + versionLocatorId)
        .build();
    
    catalogManagementServiceAuthorized.ibmPublishVersion(ibmPublishVersionOptions).execute();
  }
  
  @Test(dependsOnMethods = {"testGetOfferingContainerImages"},
      expectedExceptions = ForbiddenException.class)
  public void testIbmPublishVersionReturns403WhenUserIsNotAuthorized() throws Exception {
    IbmPublishVersionOptions ibmPublishVersionOptions = new IbmPublishVersionOptions.Builder()
        .versionLocId(versionLocatorId)
        .build();
    
    catalogManagementServiceNotAuthorized.ibmPublishVersion(ibmPublishVersionOptions).execute();
  }
  
  // once this test is enabled the next block's dependency can point here
  @Test(dependsOnMethods = {"testGetOfferingContainerImages"})
  @Ignore("User is not granted.")
  public void testIbmPublishVersion() throws Exception {
    try {
      IbmPublishVersionOptions ibmPublishVersionOptions = new IbmPublishVersionOptions.Builder()
          .versionLocId(versionLocatorId)
          .build();
      
      Response<Void> response = catalogManagementServiceAuthorized.ibmPublishVersion(ibmPublishVersionOptions)
          .execute();
      
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
    
    catalogManagementServiceAuthorized.publicPublishVersion(publicPublishVersionOptions).execute();
  }
  
  @Test(dependsOnMethods = {"testGetOfferingContainerImages"},
      expectedExceptions = NotFoundException.class)
  public void testPublicPublishVersionReturns404WhenNoSuchVersion() throws Exception {
    PublicPublishVersionOptions publicPublishVersionOptions = new PublicPublishVersionOptions.Builder()
        .versionLocId("invalid-" + versionLocatorId)
        .build();
    
    catalogManagementServiceAuthorized.publicPublishVersion(publicPublishVersionOptions).execute();
  }
  
  @Test(dependsOnMethods = {"testGetOfferingContainerImages"},
      expectedExceptions = ForbiddenException.class)
  public void testPublicPublishVersionReturns403WhenUserIsNotAuthorized() throws Exception {
    PublicPublishVersionOptions publicPublishVersionOptions = new PublicPublishVersionOptions.Builder()
        .versionLocId(versionLocatorId)
        .build();
    
    catalogManagementServiceNotAuthorized.publicPublishVersion(publicPublishVersionOptions).execute();
  }
  
  // once this test is enabled the next block's dependency can point here
  @Test(dependsOnMethods = {"testGetOfferingContainerImages"})
  @Ignore("User is not granted.")
  public void testPublicPublishVersion() throws Exception {
    try {
      PublicPublishVersionOptions publicPublishVersionOptions = new PublicPublishVersionOptions.Builder()
          .versionLocId(versionLocatorId)
          .build();
      
      Response<Void> response = catalogManagementServiceAuthorized.publicPublishVersion(publicPublishVersionOptions)
          .execute();
      
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
    
    catalogManagementServiceAuthorized.commitVersion(commitVersionOptions).execute();
  }
  
  @Test(dependsOnMethods = {"testGetOfferingContainerImages"},
      expectedExceptions = NotFoundException.class)
  public void testCommitVersionReturns404WhenNoSuchVersion() throws Exception {
    CommitVersionOptions commitVersionOptions = new CommitVersionOptions.Builder()
        .versionLocId("invalid-" + versionLocatorId)
        .build();
    
    catalogManagementServiceAuthorized.commitVersion(commitVersionOptions).execute();
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
  @Ignore("Workflow of versions is missing")
  public void testCommitVersion() throws Exception {
    try {
      CommitVersionOptions commitVersionOptions = new CommitVersionOptions.Builder()
          .versionLocId(versionLocatorId)
          .build();
      
      Response<Void> response = catalogManagementServiceAuthorized.commitVersion(commitVersionOptions).execute();
      
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
      expectedExceptions = ForbiddenException.class)
  public void testCopyVersionReturns403WhenUserIsNotAuthorized() throws Exception {
    CopyVersionOptions copyVersionOptions = new CopyVersionOptions.Builder()
        .versionLocId(versionLocatorId)
        .addTargetKinds(kindRoks)
        .build();
    
    catalogManagementServiceNotAuthorized.copyVersion(copyVersionOptions).execute();
  }
  
  @Test(dependsOnMethods = {"testGetOfferingContainerImages"},
      expectedExceptions = NotFoundException.class)
  public void testCopyVersionReturns404WhenNoSuchVersion() throws Exception {
    CopyVersionOptions copyVersionOptions = new CopyVersionOptions.Builder()
        .versionLocId("invalid-" + versionLocatorId)
        .addTargetKinds(kindRoks)
        .build();
    
    catalogManagementServiceAuthorized.copyVersion(copyVersionOptions).execute();
  }
  
  @Test(dependsOnMethods = {"testGetOfferingContainerImages"},
      expectedExceptions = BadRequestException.class)
  public void testCopyVersionReturns400WhenBackendInputValidationFails() throws Exception {
    CopyVersionOptions copyVersionOptions = new CopyVersionOptions.Builder()
        .versionLocId(bogusVersionLocatorId)
        .addTargetKinds(kindRoks)
        .build();
    
    catalogManagementServiceAuthorized.copyVersion(copyVersionOptions).execute();
  }
  
  // once this test is enabled the next block's dependency can point here
  @Test(dependsOnMethods = {"testGetOfferingContainerImages"})
  @Ignore("Only for helm, but helm is not supported.")
  public void testCopyVersion() throws Exception {
    try {
      CopyVersionOptions copyVersionOptions = new CopyVersionOptions.Builder()
          .versionLocId(versionLocatorId)
          .addTargetKinds(kindRoks)
          .build();
      
      Response<Void> response = catalogManagementServiceAuthorized.copyVersion(copyVersionOptions).execute();
      
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
    
    catalogManagementServiceAuthorized.getOfferingWorkingCopy(getOfferingWorkingCopyOptions).execute();
  }
  
  @Test(dependsOnMethods = {"testGetOfferingContainerImages"},
      expectedExceptions = ForbiddenException.class)
  public void testGetOfferingWorkingCopyReturns403WhenUserIsNotAuthorized() throws Exception {
    GetOfferingWorkingCopyOptions getOfferingWorkingCopyOptions = new GetOfferingWorkingCopyOptions.Builder()
        .versionLocId(versionLocatorId)
        .build();
    
    catalogManagementServiceNotAuthorized.getOfferingWorkingCopy(getOfferingWorkingCopyOptions).execute();
  }
  
  @Test(dependsOnMethods = {"testGetOfferingContainerImages"},
      expectedExceptions = NotFoundException.class)
  public void testGetOfferingWorkingCopyReturns404WhenNoSuchVersion() throws Exception {
    GetOfferingWorkingCopyOptions getOfferingWorkingCopyOptions = new GetOfferingWorkingCopyOptions.Builder()
        .versionLocId("invalid-" + versionLocatorId)
        .build();
    
    catalogManagementServiceAuthorized.getOfferingWorkingCopy(getOfferingWorkingCopyOptions).execute();
  }
  
  // once this test is enabled the next block's dependency can point here
  @Test(dependsOnMethods = {"testGetOfferingContainerImages"})
  @Ignore("requires published state which this user cannot create")
  public void testGetOfferingWorkingCopy() throws Exception {
    try {
      GetOfferingWorkingCopyOptions getOfferingWorkingCopyOptions = new GetOfferingWorkingCopyOptions.Builder()
          .versionLocId(versionLocatorId)
          .build();
      
      Response<Version> response =
          catalogManagementServiceAuthorized.getOfferingWorkingCopy(getOfferingWorkingCopyOptions)
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
    
    catalogManagementServiceAuthorized.getVersion(getVersionOptions).execute();
  }
  
  @Test(dependsOnMethods = {"testGetOfferingContainerImages"},
      expectedExceptions = NotFoundException.class)
  public void testGetVersionReturns404WhenNoSuchVersion() throws Exception {
    GetVersionOptions getVersionOptions = new GetVersionOptions.Builder()
        .versionLocId("invalid-" + versionLocatorId)
        .build();
    
    catalogManagementServiceAuthorized.getVersion(getVersionOptions).execute();
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
      
      Response<Offering> response = catalogManagementServiceAuthorized.getVersion(getVersionOptions).execute();
      
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
      expectedExceptions = UnauthorizedException.class)
  @Ignore("possibly this user doesn't have right to execute this operation")
  public void testGetClusterReturns403WhenUserIsNotAuthorized() throws Exception {
    GetClusterOptions getClusterOptions = new GetClusterOptions.Builder()
        .clusterId(clusterId)
        .region(regionUsSouth)
        .xAuthRefreshToken(refreshTokenNotAuthorized)
        .build();
    
    catalogManagementServiceNotAuthorized.getCluster(getClusterOptions).execute();
  }
  
  @Test(dependsOnMethods = {"testGetVersion"},
      expectedExceptions = NotFoundException.class)
  public void testGetClusterReturns404WhenNoSuchCluster() throws Exception {
    GetClusterOptions getClusterOptions = new GetClusterOptions.Builder()
        .clusterId("invalid-" + clusterId)
        .region(regionUsSouth)
        .xAuthRefreshToken(refreshTokenAuthorized)
        .build();
    
    catalogManagementServiceAuthorized.getCluster(getClusterOptions).execute();
  }
  
  @Test(dependsOnMethods = {"testGetVersion"})
  @Ignore("possibly this user doesn't have right to execute this operation")
  public void testGetCluster() throws Exception {
    try {
      
      GetClusterOptions getClusterOptions = new GetClusterOptions.Builder()
          .clusterId(clusterId)
          .region(regionUsSouth)
          .xAuthRefreshToken(refreshTokenAuthorized)
          .build();
      
      Response<ClusterInfo> response = catalogManagementServiceAuthorized.getCluster(getClusterOptions).execute();
      
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
  
  @Test(dependsOnMethods = {"testGetVersion"},
      expectedExceptions = NotFoundException.class)
  public void testGetNamespacesReturns404WhenNoSuchCluster() throws Exception {
    GetNamespacesOptions getNamespacesOptions = new GetNamespacesOptions.Builder()
        .clusterId("invalid-" + clusterId)
        .region(regionUsSouth)
        .xAuthRefreshToken(refreshTokenAuthorized)
        .build();
    
    catalogManagementServiceAuthorized.getNamespaces(getNamespacesOptions).execute();
  }
  
  @Test(dependsOnMethods = {"testGetVersion"},
      expectedExceptions = ForbiddenException.class)
  @Ignore("It returns randomly either 401 and 404, so it is skipped.")
  public void testGetNamespacesReturns403WhenUserIsNotAuthorized() throws Exception {
    GetNamespacesOptions getNamespacesOptions = new GetNamespacesOptions.Builder()
        .clusterId(clusterId)
        .region(regionUsSouth)
        .xAuthRefreshToken(refreshTokenNotAuthorized)
        .build();
    
    catalogManagementServiceNotAuthorized.getNamespaces(getNamespacesOptions).execute();
  }
  
  @Test(dependsOnMethods = {"testGetVersion"})
  @Ignore("Possibly the user is not granted.")
  public void testGetNamespaces() throws Exception {
    try {
      GetNamespacesOptions getNamespacesOptions = new GetNamespacesOptions.Builder()
          .clusterId(clusterId)
          .region(regionUsSouth)
          .xAuthRefreshToken(refreshTokenAuthorized)
          .build();
      
      Response<NamespaceSearchResult> response = catalogManagementServiceAuthorized.getNamespaces(getNamespacesOptions)
          .execute();
      
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
  
  @Test(dependsOnMethods = {"testGetVersion"},
      expectedExceptions = ForbiddenException.class)
  public void testDeployOperatorsReturns403WhenUserIsNotAuthorized() throws Exception {
    DeployOperatorsOptions deployOperatorsOptions = new DeployOperatorsOptions.Builder()
        .xAuthRefreshToken(refreshTokenNotAuthorized)
        .clusterId(clusterId)
        .region(regionUsSouth)
        .allNamespaces(true)
        .versionLocatorId(versionLocatorId)
        .build();
    
    catalogManagementServiceNotAuthorized.deployOperators(deployOperatorsOptions).execute();
  }
  
  @Test(dependsOnMethods = {"testGetVersion"},
      expectedExceptions = NotFoundException.class)
  public void testDeployOperatorsReturns404WhenNoSuchCluster() throws Exception {
    DeployOperatorsOptions deployOperatorsOptions = new DeployOperatorsOptions.Builder()
        .xAuthRefreshToken(refreshTokenAuthorized)
        .clusterId("invalid-" + clusterId)
        .region(regionUsSouth)
        .allNamespaces(true)
        .versionLocatorId(versionLocatorId)
        .build();
    
    catalogManagementServiceAuthorized.deployOperators(deployOperatorsOptions).execute();
  }
  
  @Test(dependsOnMethods = {"testGetVersion"},
      expectedExceptions = BadRequestException.class)
  public void testDeployOperatorsReturns400WhenBackendInputValidationFails() throws Exception {
    DeployOperatorsOptions deployOperatorsOptions = new DeployOperatorsOptions.Builder()
        .xAuthRefreshToken(refreshTokenAuthorized)
        .clusterId(clusterId)
        .region(regionUsSouth)
        .allNamespaces(true)
        .versionLocatorId(bogusVersionLocatorId)
        .build();
    
    catalogManagementServiceAuthorized.deployOperators(deployOperatorsOptions).execute();
  }
  
  @Test(dependsOnMethods = {"testGetVersion"})
  @Ignore("Possibly the user is not granted.")
  public void testDeployOperators() throws Exception {
    try {
      DeployOperatorsOptions deployOperatorsOptions = new DeployOperatorsOptions.Builder()
          .xAuthRefreshToken(refreshTokenAuthorized)
          .clusterId(clusterId)
          .region(regionUsSouth)
          .allNamespaces(true)
          .versionLocatorId(versionLocatorId)
          .build();
      
      Response<List<OperatorDeployResult>> response =
          catalogManagementServiceAuthorized.deployOperators(deployOperatorsOptions)
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
  
  @Test(dependsOnMethods = {"testGetVersion"},
      expectedExceptions = ForbiddenException.class)
  public void testListOperatorsReturns403WhenUserIsNotAuthorized() throws Exception {
    ListOperatorsOptions listOperatorsOptions = new ListOperatorsOptions.Builder()
        .xAuthRefreshToken(refreshTokenNotAuthorized)
        .clusterId(clusterId)
        .region(regionUsSouth)
        .versionLocatorId(versionLocatorId)
        .build();
    
    catalogManagementServiceNotAuthorized.listOperators(listOperatorsOptions).execute();
  }
  
  @Test(dependsOnMethods = {"testGetVersion"},
      expectedExceptions = BadRequestException.class)
  public void testListOperatorsReturns400WhenBackendInputValidationFails() throws Exception {
    ListOperatorsOptions listOperatorsOptions = new ListOperatorsOptions.Builder()
        .xAuthRefreshToken(refreshTokenAuthorized)
        .clusterId(clusterId)
        .region(regionUsSouth)
        .versionLocatorId(bogusVersionLocatorId)
        .build();
    
    catalogManagementServiceAuthorized.listOperators(listOperatorsOptions).execute();
  }
  
  @Test(dependsOnMethods = {"testGetVersion"},
      expectedExceptions = NotFoundException.class)
  public void testListOperatorsReturns404WhenNoSuchCluster() throws Exception {
    ListOperatorsOptions listOperatorsOptions = new ListOperatorsOptions.Builder()
        .xAuthRefreshToken(refreshTokenAuthorized)
        .clusterId("invalid-" + clusterId)
        .region(regionUsSouth)
        .versionLocatorId(versionLocatorId)
        .build();
    
    catalogManagementServiceAuthorized.listOperators(listOperatorsOptions).execute();
  }
  
  @Test(dependsOnMethods = {"testGetVersion"})
  @Ignore("Possibly the user is not granted.")
  public void testListOperators() throws Exception {
    try {
      ListOperatorsOptions listOperatorsOptions = new ListOperatorsOptions.Builder()
          .xAuthRefreshToken(refreshTokenAuthorized)
          .clusterId(clusterId)
          .region(regionUsSouth)
          .versionLocatorId(versionLocatorId)
          .build();
      
      Response<List<OperatorDeployResult>> response =
          catalogManagementServiceAuthorized.listOperators(listOperatorsOptions)
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
  
  @Test(dependsOnMethods = {"testGetVersion"},
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
  
  @Test(dependsOnMethods = {"testGetVersion"},
      expectedExceptions = BadRequestException.class)
  public void testReplaceOperatorsReturns404WhenNoSuchCluster() throws Exception {
    ReplaceOperatorsOptions replaceOperatorsOptions = new ReplaceOperatorsOptions.Builder()
        .xAuthRefreshToken(refreshTokenAuthorized)
        .clusterId("invalid-" + clusterId)
        .region(regionUsSouth)
        .versionLocatorId(versionLocatorId)
        .build();
    
    catalogManagementServiceAuthorized.replaceOperators(replaceOperatorsOptions).execute();
  }
  
  @Test(dependsOnMethods = {"testGetVersion"},
      expectedExceptions = BadRequestException.class)
  public void testReplaceOperatorsReturns400WhenBackendInputValidationFails() throws Exception {
    ReplaceOperatorsOptions replaceOperatorsOptions = new ReplaceOperatorsOptions.Builder()
        .xAuthRefreshToken(refreshTokenAuthorized)
        .clusterId(clusterId)
        .region(regionUsSouth)
        .versionLocatorId(bogusVersionLocatorId)
        .build();
    
    catalogManagementServiceAuthorized.replaceOperators(replaceOperatorsOptions).execute();
  }
  
  @Test(dependsOnMethods = {"testGetVersion"})
  @Ignore("Possibly this user is not granted.")
  public void testReplaceOperators() throws Exception {
    try {
      ReplaceOperatorsOptions replaceOperatorsOptions = new ReplaceOperatorsOptions.Builder()
          .xAuthRefreshToken(refreshTokenAuthorized)
          .clusterId(clusterId)
          .region(regionUsSouth)
          .allNamespaces(true)
          .versionLocatorId(versionLocatorId)
          .build();
      
      Response<List<OperatorDeployResult>> response =
          catalogManagementServiceAuthorized.replaceOperators(replaceOperatorsOptions)
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
  
  @Test(dependsOnMethods = {"testGetVersion"},
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
  
  @Test(dependsOnMethods = {"testGetVersion"},
      expectedExceptions = NotFoundException.class)
  public void testInstallVersionReturns404WhenNoSuchCluster() throws Exception {
    
    InstallVersionOptions installVersionOptions = new InstallVersionOptions.Builder()
        .versionLocId(versionLocatorId)
        .xAuthRefreshToken(refreshTokenAuthorized)
        .clusterId("invalid" + clusterId)
        .region(regionUsSouth)
        .versionLocatorId(versionLocatorId)
        .build();
    
    catalogManagementServiceAuthorized.installVersion(installVersionOptions).execute();
  }
  
  @Test(dependsOnMethods = {"testGetVersion"},
      expectedExceptions = BadRequestException.class)
  public void testInstallVersionReturns400WhenBackendInputValidationFails() throws Exception {
    
    InstallVersionOptions installVersionOptions = new InstallVersionOptions.Builder()
        .versionLocId(bogusVersionLocatorId)
        .xAuthRefreshToken(refreshTokenAuthorized)
        .clusterId(clusterId)
        .region(regionUsSouth)
        .versionLocatorId(bogusVersionLocatorId)
        .build();
    
    catalogManagementServiceAuthorized.installVersion(installVersionOptions).execute();
  }
  
  @Test(dependsOnMethods = {"testGetVersion"})
  @Ignore("Possibly this user is not granted.")
  public void testInstallVersion() throws Exception {
    try {
      
      InstallVersionOptions installVersionOptions = new InstallVersionOptions.Builder()
          .versionLocId(versionLocatorId)
          .xAuthRefreshToken(refreshTokenAuthorized)
          .clusterId(clusterId)
          .region(regionUsSouth)
          .versionLocatorId(versionLocatorId)
          .build();
      
      Response<Void> response = catalogManagementServiceAuthorized.installVersion(installVersionOptions).execute();
      
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
  
  @Test(dependsOnMethods = {"testGetVersion"},
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
  
  @Test(dependsOnMethods = {"testGetVersion"},
      expectedExceptions = BadRequestException.class)
  @Ignore("Requires preinstall script.")
  public void testPreinstallVersionReturns404WhenNoSuchCluster() throws Exception {
    
    // it requires a version where preinstall script is installed
    // but I don't know how to do it
    // one it is done possible to squeeze a 404 from the cluster
    // until then it checks 400
    
    PreinstallVersionOptions preinstallVersionOptions = new PreinstallVersionOptions.Builder()
        .versionLocId(versionLocatorId)
        .xAuthRefreshToken(refreshTokenAuthorized)
        .clusterId("invalid-" + clusterId)
        .region(regionUsSouth)
        .versionLocatorId(versionLocatorId)
        .build();
    
    catalogManagementServiceAuthorized.preinstallVersion(preinstallVersionOptions).execute();
  }
  
  @Test(dependsOnMethods = {"testGetVersion"},
      expectedExceptions = BadRequestException.class)
  public void testPreinstallVersionReturns400WhenBackendInputValidationFails() throws Exception {
    
    PreinstallVersionOptions preinstallVersionOptions = new PreinstallVersionOptions.Builder()
        .versionLocId(bogusVersionLocatorId)
        .xAuthRefreshToken(refreshTokenAuthorized)
        .clusterId(clusterId)
        .region(regionUsSouth)
        .versionLocatorId(bogusVersionLocatorId)
        .build();
    
    catalogManagementServiceAuthorized.preinstallVersion(preinstallVersionOptions).execute();
  }
  
  // Error: Attempt to run pre-install script on a version that has no pre-install script specified
  @Test(dependsOnMethods = {"testGetVersion"})
  @Ignore("Requires pre-install script.")
  public void testPreinstallVersion() throws Exception {
    try {
      
      PreinstallVersionOptions preinstallVersionOptions = new PreinstallVersionOptions.Builder()
          .versionLocId(versionLocatorId)
          .xAuthRefreshToken(refreshTokenAuthorized)
          .clusterId(clusterId)
          .region(regionUsSouth)
          .versionLocatorId(versionLocatorId)
          .build();
      
      Response<Void> response = catalogManagementServiceAuthorized.preinstallVersion(preinstallVersionOptions)
          .execute();
      
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
  
  @Test(dependsOnMethods = {"testGetVersion"},
      expectedExceptions = ForbiddenException.class)
  public void testGetPreinstallReturns403WhenUserIsNotAuthorized() throws Exception {
    GetPreinstallOptions getPreinstallOptions = new GetPreinstallOptions.Builder()
        .versionLocId(versionLocatorId)
        .xAuthRefreshToken(refreshTokenNotAuthorized)
        .clusterId(clusterId)
        .region(regionUsSouth)
        .build();
    
    catalogManagementServiceNotAuthorized.getPreinstall(getPreinstallOptions).execute();
  }
  
  @Test(dependsOnMethods = {"testGetVersion"},
      expectedExceptions = NotFoundException.class)
  public void testGetPreinstallReturns404WhenNoSuchVersion() throws Exception {
    GetPreinstallOptions getPreinstallOptions = new GetPreinstallOptions.Builder()
        .versionLocId("invalid-" + versionLocatorId)
        .xAuthRefreshToken(refreshTokenAuthorized)
        .clusterId(clusterId)
        .region(regionUsSouth)
        .build();
    
    catalogManagementServiceAuthorized.getPreinstall(getPreinstallOptions).execute();
  }
  
  @Test(dependsOnMethods = {"testGetVersion"},
      expectedExceptions = BadRequestException.class)
  public void testGetPreinstallReturns400WhenBackendInputValidationFails() throws Exception {
    GetPreinstallOptions getPreinstallOptions = new GetPreinstallOptions.Builder()
        .versionLocId(bogusVersionLocatorId)
        .xAuthRefreshToken(refreshTokenAuthorized)
        .clusterId(clusterId)
        .region(regionUsSouth)
        .build();
    
    catalogManagementServiceAuthorized.getPreinstall(getPreinstallOptions).execute();
  }
  
  // Error: Attempt to get pre-install status on a version that has no pre-install script
  @Test(dependsOnMethods = {"testGetVersion"})
  @Ignore("Pre-install script is required.")
  public void testGetPreinstall() throws Exception {
    try {
      GetPreinstallOptions getPreinstallOptions = new GetPreinstallOptions.Builder()
          .versionLocId(versionLocatorId)
          .xAuthRefreshToken(refreshTokenAuthorized)
          .clusterId(clusterId)
          .region(regionUsSouth)
          .build();
      
      Response<InstallStatus> response = catalogManagementServiceAuthorized.getPreinstall(getPreinstallOptions)
          .execute();
      
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
  
  @Test(dependsOnMethods = {"testGetVersion"},
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
  
  @Test(dependsOnMethods = {"testGetVersion"},
      expectedExceptions = NotFoundException.class)
  @Ignore
  public void testValidateInstallReturns404WhenNoSuchVersion() throws Exception {
    ValidateInstallOptions validateInstallOptions = new ValidateInstallOptions.Builder()
        .versionLocId("invalid-" + versionLocatorId)
        .xAuthRefreshToken(refreshTokenAuthorized)
        .clusterId(clusterId)
        .region(regionUsSouth)
        .versionLocatorId("invalid-" + versionLocatorId)
        .build();
    
    catalogManagementServiceAuthorized.validateInstall(validateInstallOptions).execute();
  }
  
  @Test(dependsOnMethods = {"testGetVersion"},
      expectedExceptions = BadRequestException.class)
  public void testValidateInstallReturns400WhenBackendInputValidationFails() throws Exception {
    
    ValidateInstallOptions validateInstallOptions = new ValidateInstallOptions.Builder()
        .versionLocId(bogusVersionLocatorId)
        .xAuthRefreshToken(refreshTokenAuthorized)
        .clusterId(clusterId)
        .region(regionUsSouth)
        .versionLocatorId(bogusVersionLocatorId)
        .build();
    
    catalogManagementServiceAuthorized.validateInstall(validateInstallOptions).execute();
  }
  
  @Test(dependsOnMethods = {"testGetVersion"})
  @Ignore("Possibly this user is not granted.")
  public void testValidateInstall() throws Exception {
    try {
      ValidateInstallOptions validateInstallOptions = new ValidateInstallOptions.Builder()
          .versionLocId(versionLocatorId)
          .xAuthRefreshToken(refreshTokenAuthorized)
          .clusterId(clusterId)
          .region(regionUsSouth)
          .build();
      
      Response<Void> response = catalogManagementServiceAuthorized.validateInstall(validateInstallOptions).execute();
      
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
  
  @Test(dependsOnMethods = {"testGetVersion"},
      expectedExceptions = ForbiddenException.class)
  public void testGetValidationStatusReturns403WhenUserIsNotAuthorized() throws Exception {
    GetValidationStatusOptions getValidationStatusOptions = new GetValidationStatusOptions.Builder()
        .versionLocId(versionLocatorId)
        .xAuthRefreshToken(refreshTokenNotAuthorized)
        .build();
    
    catalogManagementServiceNotAuthorized.getValidationStatus(getValidationStatusOptions).execute();
  }
  
  @Test(dependsOnMethods = {"testGetVersion"},
      expectedExceptions = NotFoundException.class)
  public void testGetValidationStatusReturns404WhenNoSuchVersion() throws Exception {
    GetValidationStatusOptions getValidationStatusOptions = new GetValidationStatusOptions.Builder()
        .versionLocId("invalid-" + versionLocatorId)
        .xAuthRefreshToken(refreshTokenAuthorized)
        .build();
    
    catalogManagementServiceAuthorized.getValidationStatus(getValidationStatusOptions).execute();
  }
  
  @Test(dependsOnMethods = {"testGetVersion"},
      expectedExceptions = BadRequestException.class)
  public void testGetValidationStatusReturns400WhenBackendInputValidationFails() throws Exception {
    GetValidationStatusOptions getValidationStatusOptions = new GetValidationStatusOptions.Builder()
        .versionLocId(bogusVersionLocatorId)
        .xAuthRefreshToken(refreshTokenAuthorized)
        .build();
    
    catalogManagementServiceAuthorized.getValidationStatus(getValidationStatusOptions).execute();
  }
  
  @Test(dependsOnMethods = {"testGetVersion"})
  public void testGetValidationStatus() throws Exception {
    try {
      GetValidationStatusOptions getValidationStatusOptions = new GetValidationStatusOptions.Builder()
          .versionLocId(versionLocatorId)
          .xAuthRefreshToken(refreshTokenAuthorized)
          .build();
      
      Response<Validation> response = catalogManagementServiceAuthorized.getValidationStatus(getValidationStatusOptions)
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
  
  @Test(dependsOnMethods = {"testGetValidationStatus"},
      expectedExceptions = ForbiddenException.class)
  public void testGetOverrideValuesReturns403WhenUserIsNotAuthorized() throws Exception {
    GetOverrideValuesOptions getOverrideValuesOptions = new GetOverrideValuesOptions.Builder()
        .versionLocId(versionLocatorId)
        .build();
    
    catalogManagementServiceNotAuthorized.getOverrideValues(getOverrideValuesOptions).execute();
  }
  
  @Test(dependsOnMethods = {"testGetValidationStatus"},
      expectedExceptions = NotFoundException.class)
  public void testGetOverrideValuesReturns404WhenNoSuchVersion() throws Exception {
    GetOverrideValuesOptions getOverrideValuesOptions = new GetOverrideValuesOptions.Builder()
        .versionLocId("invalid-" + versionLocatorId)
        .build();
    
    catalogManagementServiceAuthorized.getOverrideValues(getOverrideValuesOptions).execute();
  }
  
  @Test(dependsOnMethods = {"testGetValidationStatus"},
      expectedExceptions = BadRequestException.class)
  public void testGetOverrideValuesReturns400WhenBackendInputValidationFails() throws Exception {
    GetOverrideValuesOptions getOverrideValuesOptions = new GetOverrideValuesOptions.Builder()
        .versionLocId(bogusVersionLocatorId)
        .build();
    
    catalogManagementServiceAuthorized.getOverrideValues(getOverrideValuesOptions).execute();
  }
  
  @Test(dependsOnMethods = {"testGetValidationStatus"})
  @Ignore("requires validation run before this operation")
  public void testGetOverrideValues() throws Exception {
    
    try {
      GetOverrideValuesOptions getOverrideValuesOptions = new GetOverrideValuesOptions.Builder()
          .versionLocId(versionLocatorId)
          .build();
      
      Response<Map<String, Object>> response =
          catalogManagementServiceAuthorized.getOverrideValues(getOverrideValuesOptions)
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
  
  @Test(dependsOnMethods = {"testGetValidationStatus"},
      expectedExceptions = BadRequestException.class)
  public void testSearchObjectsReturns400WhenBackendInputValidationFails() throws Exception {
    SearchObjectsOptions searchObjectsOptions = new SearchObjectsOptions.Builder()
        .query("")
        .collapse(true)
        .digest(true)
        .build();
    
    catalogManagementServiceAuthorized.searchObjects(searchObjectsOptions).execute();
  }
  
  @Test(dependsOnMethods = {"testGetValidationStatus"})
  public void testSearchObjectsReturns200WhenUserIsNotAuthorized() throws Exception {
    try {
      SearchObjectsOptions searchObjectsOptions = new SearchObjectsOptions.Builder()
          .query("name: " + objectName)
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
  
  @Test(dependsOnMethods = {"testGetValidationStatus"})
  public void testSearchObjects() throws Exception {
    try {
      
      int offset = 0;
      int limit = 50;
      boolean fetch = true;
      int amountOfObjects = 0;
      
      while (fetch) {
        SearchObjectsOptions searchObjectsOptions = new SearchObjectsOptions.Builder()
            .query("name: object*")
            .collapse(true)
            .digest(true)
            .offset(offset)
            .limit(limit)
            .build();
        
        Response<ObjectSearchResult> response = catalogManagementServiceAuthorized.searchObjects(searchObjectsOptions)
            .execute();
        
        assertNotNull(response);
        assertEquals(response.getStatusCode(), 200);
        
        ObjectSearchResult objectSearchResultResult = response.getResult();
        assertNotNull(objectSearchResultResult);
        
        if (objectSearchResultResult.getResourceCount() > 0) {
          offset += 50;
          amountOfObjects += objectSearchResultResult.getResourceCount().intValue();
        } else {
          fetch = false;
        }
      }
      System.out.println(String.format("Amount of objects: %s", amountOfObjects));
      
    } catch (ServiceResponseException e) {
      fail(String.format("Service returned status code %d: %s\nError details: %s", e.getStatusCode(), e.getMessage(),
          e.getDebuggingInfo()));
    }
  }
  
  //====
  // List Objects block
  //====
  
  @Test(dependsOnMethods = {"testSearchObjects"},
      expectedExceptions = BadRequestException.class)
  public void testListObjectsReturns400WhenBackendInputValidationFails() throws Exception {
    ListObjectsOptions listObjectsOptions = new ListObjectsOptions.Builder()
        .catalogIdentifier(catalogId)
        .name(" ")
        .sort(" ")
        .build();
    
    catalogManagementServiceAuthorized.listObjects(listObjectsOptions).execute();
  }
  
  @Test(dependsOnMethods = {"testSearchObjects"},
      expectedExceptions = ForbiddenException.class)
  public void testListObjectsReturns403WhenUserIsNotAuthorized() throws Exception {
    ListObjectsOptions listObjectsOptions = new ListObjectsOptions.Builder()
        .catalogIdentifier(catalogId)
        .build();
    
    catalogManagementServiceNotAuthorized.listObjects(listObjectsOptions).execute();
  }
  
  @Test(dependsOnMethods = {"testSearchObjects"})
  public void testListObjects() throws Exception {
    try {
      int offset = 0;
      int limit = 50;
      int amountOfObjects = 0;
      boolean isObjectFound = false;
      boolean fetch = true;
      
      while (fetch) {
        ListObjectsOptions listObjectsOptions = new ListObjectsOptions.Builder()
            .catalogIdentifier(catalogId)
            .limit(limit)
            .offset(offset)
            .build();
        
        Response<ObjectListResult> response = catalogManagementServiceAuthorized.listObjects(listObjectsOptions)
            .execute();
        
        assertNotNull(response);
        assertEquals(response.getStatusCode(), 200);
        
        ObjectListResult objectListResultResult = response.getResult();
        assertNotNull(objectListResultResult);
        
        if (objectListResultResult.getResourceCount() > 0) {
          amountOfObjects += objectListResultResult.getResourceCount().intValue();
          offset += 50;
        } else {
          fetch = false;
        }
        
        if (!isObjectFound) {
          Integer count = Math.toIntExact(objectListResultResult.getResources().stream()
              .filter(f -> f.id().equals(objectId))
              .count());
          if (count != 0) {
            isObjectFound = true;
          }
        }
      }
      
      System.out.println(String.format("Amount of objects: %s", amountOfObjects));
      
    } catch (ServiceResponseException e) {
      fail(String.format("Service returned status code %d: %s\nError details: %s", e.getStatusCode(), e.getMessage(),
          e.getDebuggingInfo()));
    }
  }
  
  //====
  // Replace Object block
  //====
  
  @Test(dependsOnMethods = {"testListObjects"},
      expectedExceptions = ForbiddenException.class)
  public void testReplaceObjectReturns403WhenUserIsNotAuthorized() throws Exception {
    
    ReplaceObjectOptions replaceObjectOptions = new ReplaceObjectOptions.Builder()
        .catalogIdentifier(catalogId)
        .objectIdentifier(objectId)
        .id(objectId)
        .name("updated-object-name-created-by-java-sdk")
        .parentId(regionUsSouth)
        .catalogId(catalogId)
        .build();
    
    catalogManagementServiceNotAuthorized.replaceObject(replaceObjectOptions).execute();
  }
  
  @Test(dependsOnMethods = {"testListObjects"},
      expectedExceptions = BadRequestException.class)
  public void testReplaceObjectReturns404WhenNoSuchObject() throws Exception {
    ReplaceObjectOptions replaceObjectOptions = new ReplaceObjectOptions.Builder()
        .catalogIdentifier(catalogId)
        .objectIdentifier(objectId)
        .id("invalid-" + objectId)
        .name("updated-object-name-created-by-java-sdk")
        .parentId(regionUsSouth)
        .catalogId(catalogId)
        .build();
    
    catalogManagementServiceAuthorized.replaceObject(replaceObjectOptions).execute();
  }
  
  @Test(dependsOnMethods = {"testListObjects"},
      expectedExceptions = BadRequestException.class)
  public void testReplaceObjectReturns400WhenBackendInputValidationFails() throws Exception {
    ReplaceObjectOptions replaceObjectOptions = new ReplaceObjectOptions.Builder()
        .catalogIdentifier(catalogId)
        .objectIdentifier(objectId)
        .id(objectId)
        .name("updated object name created by java sdk")
        .parentId(regionUsSouth)
        .catalogId(catalogId)
        .build();
    
    catalogManagementServiceAuthorized.replaceObject(replaceObjectOptions).execute();
  }
  
  // cannot change name of object, what can be changed?
  @Test(dependsOnMethods = {"testListObjects"})
  @Ignore("Cannot change the name of the object.")
  public void testReplaceObject() throws Exception {
    try {
      
      ReplaceObjectOptions replaceObjectOptions = new ReplaceObjectOptions.Builder()
          .catalogIdentifier(catalogId)
          .objectIdentifier(objectId)
          .id(objectId)
          .name("updated-object-name-created-by-java-sdk")
          .parentId(regionUsSouth)
          .kind(kindVpe)
          .catalogId(catalogId)
          .build();
      
      Response<CatalogObject> response = catalogManagementServiceAuthorized.replaceObject(replaceObjectOptions)
          .execute();
      
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
      expectedExceptions = ForbiddenException.class)
  public void testGetObjectReturns403WhenUserIsNotAuthorized() throws Exception {
    GetObjectOptions getObjectOptions = new GetObjectOptions.Builder()
        .catalogIdentifier(catalogId)
        .objectIdentifier(objectId)
        .build();
    
    catalogManagementServiceNotAuthorized.getObject(getObjectOptions).execute();
  }
  
  @Test(dependsOnMethods = {"testListObjects"},
      expectedExceptions = NotFoundException.class)
  public void testGetObjectReturns404WhenNoSuchObject() throws Exception {
    GetObjectOptions getObjectOptions = new GetObjectOptions.Builder()
        .catalogIdentifier(catalogId)
        .objectIdentifier("invalid-" + objectId)
        .build();
    
    catalogManagementServiceAuthorized.getObject(getObjectOptions).execute();
  }
  
  @Test(dependsOnMethods = {"testListObjects"})
  public void testGetObject() throws Exception {
    try {
      GetObjectOptions getObjectOptions = new GetObjectOptions.Builder()
          .catalogIdentifier(catalogId)
          .objectIdentifier(objectId)
          .build();
      
      Response<CatalogObject> response = catalogManagementServiceAuthorized.getObject(getObjectOptions).execute();
      
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
          .objectIdentifier("invalid-" + objectId)
          .build();
      
      Response<AuditLog> response = catalogManagementServiceAuthorized.getObjectAudit(getObjectAuditOptions).execute();
      
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
      
      Response<AuditLog> response = catalogManagementServiceAuthorized.getObjectAudit(getObjectAuditOptions).execute();
      
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
      expectedExceptions = ForbiddenException.class)
  public void testAccountPublishObjectReturns403WhenUserIsNotAuthorized() throws Exception {
    AccountPublishObjectOptions accountPublishObjectOptions = new AccountPublishObjectOptions.Builder()
        .catalogIdentifier(catalogId)
        .objectIdentifier(objectId)
        .build();
    
    catalogManagementServiceNotAuthorized.accountPublishObject(accountPublishObjectOptions).execute();
  }
  
  @Test(dependsOnMethods = {"testGetObjectAudit"},
      expectedExceptions = NotFoundException.class)
  public void testAccountPublishObjectReturns404WhenNoSuchObject() throws Exception {
    AccountPublishObjectOptions accountPublishObjectOptions = new AccountPublishObjectOptions.Builder()
        .catalogIdentifier(catalogId)
        .objectIdentifier("invalid-" + objectId)
        .build();
    
    catalogManagementServiceAuthorized.accountPublishObject(accountPublishObjectOptions).execute();
  }
  
  @Test(dependsOnMethods = {"testGetObjectAudit"})
  public void testAccountPublishObject() throws Exception {
    try {
      AccountPublishObjectOptions accountPublishObjectOptions = new AccountPublishObjectOptions.Builder()
          .catalogIdentifier(catalogId)
          .objectIdentifier(objectId)
          .build();
      
      Response<Void> response = catalogManagementServiceAuthorized.accountPublishObject(accountPublishObjectOptions)
          .execute();
      
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
      expectedExceptions = ForbiddenException.class)
  public void testSharedPublishObjectReturns403WhenUserIsNotAuthorized() throws Exception {
    SharedPublishObjectOptions sharedPublishObjectOptions = new SharedPublishObjectOptions.Builder()
        .catalogIdentifier(catalogId)
        .objectIdentifier(objectId)
        .build();
    
    catalogManagementServiceNotAuthorized.sharedPublishObject(sharedPublishObjectOptions).execute();
  }
  
  @Test(dependsOnMethods = {"testAccountPublishObject"},
      expectedExceptions = NotFoundException.class)
  public void testSharedPublishObjectReturns404WhenNoSuchObject() throws Exception {
    SharedPublishObjectOptions sharedPublishObjectOptions = new SharedPublishObjectOptions.Builder()
        .catalogIdentifier(catalogId)
        .objectIdentifier("invalid-" + objectId)
        .build();
    
    catalogManagementServiceAuthorized.sharedPublishObject(sharedPublishObjectOptions).execute();
  }
  
  @Test(dependsOnMethods = {"testAccountPublishObject"})
  @Ignore("Invalid catalog object.")
  public void testSharedPublishObject() throws Exception {
    try {
      SharedPublishObjectOptions sharedPublishObjectOptions = new SharedPublishObjectOptions.Builder()
          .catalogIdentifier(catalogId)
          .objectIdentifier(objectId)
          .build();
      
      Response<Void> response = catalogManagementServiceAuthorized.sharedPublishObject(sharedPublishObjectOptions)
          .execute();
      
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
      expectedExceptions = ForbiddenException.class)
  public void testIbmPublishObjectReturns403WhenUserIsNotAuthorized() throws Exception {
    IbmPublishObjectOptions ibmPublishObjectOptions = new IbmPublishObjectOptions.Builder()
        .catalogIdentifier(catalogId)
        .objectIdentifier(objectId)
        .build();
    
    catalogManagementServiceNotAuthorized.ibmPublishObject(ibmPublishObjectOptions).execute();
  }
  
  @Test(dependsOnMethods = {"testAccountPublishObject"},
      expectedExceptions = NotFoundException.class)
  public void testIbmPublishObjectReturns404WhenNoSuchObject() throws Exception {
    IbmPublishObjectOptions ibmPublishObjectOptions = new IbmPublishObjectOptions.Builder()
        .catalogIdentifier(catalogId)
        .objectIdentifier("invalid-" + objectId)
        .build();
    
    catalogManagementServiceAuthorized.ibmPublishObject(ibmPublishObjectOptions).execute();
  }
  
  // Error: Object not approved to request publishing to IBM for
  @Test(dependsOnMethods = {"testAccountPublishObject"})
  @Ignore("This user is not granted.")
  public void testIbmPublishObject() throws Exception {
    try {
      IbmPublishObjectOptions ibmPublishObjectOptions = new IbmPublishObjectOptions.Builder()
          .catalogIdentifier(catalogId)
          .objectIdentifier(objectId)
          .build();
      
      Response<Void> response = catalogManagementServiceAuthorized.ibmPublishObject(ibmPublishObjectOptions).execute();
      
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
      expectedExceptions = ForbiddenException.class)
  public void testPublicPublishObjectReturns403WhenUserIsNotAuthorized() throws Exception {
    PublicPublishObjectOptions publicPublishObjectOptions = new PublicPublishObjectOptions.Builder()
        .catalogIdentifier(catalogId)
        .objectIdentifier(objectId)
        .build();
    
    catalogManagementServiceNotAuthorized.publicPublishObject(publicPublishObjectOptions).execute();
  }
  
  @Test(dependsOnMethods = {"testAccountPublishObject"},
      expectedExceptions = NotFoundException.class)
  public void testPublicPublishObjectReturns404WhenNoSuchObject() throws Exception {
    PublicPublishObjectOptions publicPublishObjectOptions = new PublicPublishObjectOptions.Builder()
        .catalogIdentifier(catalogId)
        .objectIdentifier("invalid" + objectId)
        .build();
    
    catalogManagementServiceAuthorized.publicPublishObject(publicPublishObjectOptions).execute();
  }
  
  // Error: Object not approved to request publishing to IBM for
  @Test(dependsOnMethods = {"testAccountPublishObject"})
  @Ignore("This user is not granted.")
  public void testPublicPublishObject() throws Exception {
    try {
      PublicPublishObjectOptions publicPublishObjectOptions = new PublicPublishObjectOptions.Builder()
          .catalogIdentifier(catalogId)
          .objectIdentifier(objectId)
          .build();
      
      Response<Void> response = catalogManagementServiceAuthorized.publicPublishObject(publicPublishObjectOptions)
          .execute();
      
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
      expectedExceptions = ForbiddenException.class)
  public void testCreateObjectAccessReturns403WhenUserIsNotAuthorized() throws Exception {
    CreateObjectAccessOptions createObjectAccessOptions = new CreateObjectAccessOptions.Builder()
        .catalogIdentifier(catalogId)
        .objectIdentifier(objectId)
        .accountIdentifier(accountId)
        .build();
    
    catalogManagementServiceNotAuthorized.createObjectAccess(createObjectAccessOptions).execute();
  }
  
  @Test(dependsOnMethods = {"testAccountPublishObject"},
      expectedExceptions = NotFoundException.class)
  public void testCreateObjectAccessReturns404WhenNoSuchObject() throws Exception {
    CreateObjectAccessOptions createObjectAccessOptions = new CreateObjectAccessOptions.Builder()
        .catalogIdentifier(catalogId)
        .objectIdentifier("invalid-" + objectId)
        .accountIdentifier(accountId)
        .build();
    
    catalogManagementServiceAuthorized.createObjectAccess(createObjectAccessOptions).execute();
  }
  
  @Test(dependsOnMethods = {"testAccountPublishObject"})
  public void testCreateObjectAccess() throws Exception {
    try {
      CreateObjectAccessOptions createObjectAccessOptions = new CreateObjectAccessOptions.Builder()
          .catalogIdentifier(catalogId)
          .objectIdentifier(objectId)
          .accountIdentifier(accountId)
          .build();
      
      Response<Void> response = catalogManagementServiceAuthorized.createObjectAccess(createObjectAccessOptions)
          .execute();
      
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
  public void testGetObjectAccessListReturns200WhenNoSuchObject() throws Exception {
    try {
      GetObjectAccessListOptions getObjectAccessListOptions = new GetObjectAccessListOptions.Builder()
          .catalogIdentifier(catalogId)
          .objectIdentifier("invalid-" + objectId)
          .build();
      
      Response<ObjectAccessListResult> response = catalogManagementServiceAuthorized
          .getObjectAccessList(getObjectAccessListOptions)
          .execute();
      
      assertNotNull(response);
      assertEquals(response.getStatusCode(), 200);
      
    } catch (ServiceResponseException e) {
      fail(String.format("Service returned status code %d: %s\nError details: %s", e.getStatusCode(), e.getMessage(),
          e.getDebuggingInfo()));
    }
  }
  
  @Test(dependsOnMethods = {"testCreateObjectAccess"})
  public void testGetObjectAccessList() throws Exception {
    try {
      GetObjectAccessListOptions getObjectAccessListOptions = new GetObjectAccessListOptions.Builder()
          .catalogIdentifier(catalogId)
          .objectIdentifier(objectId)
          .build();
      
      Response<ObjectAccessListResult> response =
          catalogManagementServiceAuthorized.getObjectAccessList(getObjectAccessListOptions)
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
      expectedExceptions = ForbiddenException.class)
  public void testGetObjectAccessReturns403WhenUserIsNotAuthorized() throws Exception {
    GetObjectAccessOptions getObjectAccessOptions = new GetObjectAccessOptions.Builder()
        .catalogIdentifier(catalogId)
        .objectIdentifier(objectId)
        .accountIdentifier(accountId)
        .build();
    
    catalogManagementServiceNotAuthorized.getObjectAccess(getObjectAccessOptions).execute();
  }
  
  @Test(dependsOnMethods = {"testGetObjectAccessList"},
      expectedExceptions = NotFoundException.class)
  public void testGetObjectAccessReturns404WhenNoSuchObjectAccess() throws Exception {
    GetObjectAccessOptions getObjectAccessOptions = new GetObjectAccessOptions.Builder()
        .catalogIdentifier(catalogId)
        .objectIdentifier("invalid-" + objectId)
        .accountIdentifier(accountId)
        .build();
    
    catalogManagementServiceAuthorized.getObjectAccess(getObjectAccessOptions).execute();
  }
  
  // Error: Error loading version with id: 6e263640-4805-471d-a30c-d7667325581c.
  // e59ad442-d113-49e4-bcd4-5431990135fd: Error[404 Not Found]
  
  @Test(dependsOnMethods = {"testGetObjectAccessList"})
  @Ignore("Strange not found error see comments.")
  public void testGetObjectAccess() throws Exception {
    try {
      GetObjectAccessOptions getObjectAccessOptions = new GetObjectAccessOptions.Builder()
          .catalogIdentifier(catalogId)
          .objectIdentifier(objectId)
          .accountIdentifier(accountId)
          .build();
      
      Response<ObjectAccess> response = catalogManagementServiceAuthorized.getObjectAccess(getObjectAccessOptions)
          .execute();
      
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
      expectedExceptions = ForbiddenException.class)
  public void testAddObjectAccessListReturns403WhenUserIsNotAuthorized() throws Exception {
    AddObjectAccessListOptions addObjectAccessListOptions = new AddObjectAccessListOptions.Builder()
        .catalogIdentifier(catalogId)
        .objectIdentifier(objectId)
        .addAccounts(accountId)
        .build();
    
    catalogManagementServiceNotAuthorized.addObjectAccessList(addObjectAccessListOptions).execute();
  }
  
  @Test(dependsOnMethods = {"testGetObjectAccessList"},
      expectedExceptions = NotFoundException.class)
  public void testAddObjectAccessListReturns404WhenNoSuchObject() throws Exception {
    AddObjectAccessListOptions addObjectAccessListOptions = new AddObjectAccessListOptions.Builder()
        .catalogIdentifier(catalogId)
        .objectIdentifier("invalid-" + objectId)
        .addAccounts(accountId)
        .build();
    
    catalogManagementServiceAuthorized.addObjectAccessList(addObjectAccessListOptions).execute();
  }
  
  @Test(dependsOnMethods = {"testGetObjectAccessList"})
  public void testAddObjectAccessList() throws Exception {
    try {
      AddObjectAccessListOptions addObjectAccessListOptions = new AddObjectAccessListOptions.Builder()
          .catalogIdentifier(catalogId)
          .objectIdentifier(objectId)
          .addAccounts(accountId)
          .build();
      
      Response<AccessListBulkResponse> response =
          catalogManagementServiceAuthorized.addObjectAccessList(addObjectAccessListOptions)
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
      expectedExceptions = NotFoundException.class)
  @Ignore("None of the known kinds work")
  public void testCreateOfferingInstanceReturns404WhenNoSuchCatalog() throws Exception {
    CreateOfferingInstanceOptions createOfferingInstanceOptions = new CreateOfferingInstanceOptions.Builder()
        .xAuthRefreshToken(refreshTokenAuthorized)
        .id(offeringId)
        .catalogId("invalid-" + catalogId)
        .offeringId(offeringId)
        .kindFormat(kindRoks)
        .version("0.0.2")
        .clusterId(clusterId)
        .clusterRegion(regionUsSouth)
        .clusterAllNamespaces(true)
        .build();
    
    catalogManagementServiceAuthorized.createOfferingInstance(createOfferingInstanceOptions).execute();
  }
  
  @Test(dependsOnMethods = {"testAddObjectAccessList"},
      expectedExceptions = ForbiddenException.class)
  @Ignore("None of the known kinds work")
  public void testCreateOfferingInstanceReturns403WhenUserIsNotAuthorized() throws Exception {
    CreateOfferingInstanceOptions createOfferingInstanceOptions = new CreateOfferingInstanceOptions.Builder()
        .xAuthRefreshToken(refreshTokenAuthorized)
        .id(offeringId)
        .catalogId(catalogId)
        .offeringId(offeringId)
        .kindFormat(kindRoks)
        .version("0.0.2")
        .clusterId(clusterId)
        .clusterRegion(regionUsSouth)
        .clusterAllNamespaces(true)
        .build();
    
    catalogManagementServiceNotAuthorized.createOfferingInstance(createOfferingInstanceOptions).execute();
  }
  
  @Test(dependsOnMethods = {"testAddObjectAccessList"},
      expectedExceptions = BadRequestException.class)
  public void testCreateOfferingInstanceReturns400WhenBackendInputValidationFails() throws Exception {
    CreateOfferingInstanceOptions createOfferingInstanceOptions = new CreateOfferingInstanceOptions.Builder()
        .xAuthRefreshToken(refreshTokenAuthorized)
        .id(offeringId)
        .catalogId(catalogId)
        .offeringId(offeringId)
        .kindFormat("bogus kind")
        .version("0.0.2")
        .clusterId(clusterId)
        .clusterRegion(regionUsSouth)
        .clusterAllNamespaces(true)
        .build();
    
    catalogManagementServiceAuthorized.createOfferingInstance(createOfferingInstanceOptions).execute();
  }
  
  @Test(dependsOnMethods = {"testAddObjectAccessList"})
  @Ignore("None of the known kinds work")
  public void testCreateOfferingInstance() throws Exception {
    try {
      CreateOfferingInstanceOptions createOfferingInstanceOptions = new CreateOfferingInstanceOptions.Builder()
          .xAuthRefreshToken(refreshTokenAuthorized)
          .id(offeringId)
          .catalogId(catalogId)
          .offeringId(offeringId)
          .kindFormat(kindRoks)
          .version("0.0.2")
          .clusterId(clusterId)
          .clusterRegion(regionUsSouth)
          .clusterAllNamespaces(true)
          .build();
      
      Response<OfferingInstance> response = catalogManagementServiceAuthorized
          .createOfferingInstance(createOfferingInstanceOptions)
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
  @Ignore("No offering instance id")
  public void testGetOfferingInstanceReturns403WhenUserIsNotAuthorized() throws Exception {
    GetOfferingInstanceOptions getOfferingInstanceOptions = new GetOfferingInstanceOptions.Builder()
        .instanceIdentifier(offeringInstanceId)
        .build();
    
    catalogManagementServiceNotAuthorized.getOfferingInstance(getOfferingInstanceOptions).execute();
  }
  
  @Test(expectedExceptions = NotFoundException.class)
  @Ignore("No offering instance id")
  public void testGetOfferingInstanceReturns404WhenSuchOfferingInstance() throws Exception {
    GetOfferingInstanceOptions getOfferingInstanceOptions = new GetOfferingInstanceOptions.Builder()
        .instanceIdentifier("invalid-" + offeringInstanceId)
        .build();
    
    catalogManagementServiceAuthorized.getOfferingInstance(getOfferingInstanceOptions).execute();
  }
  
  @Test(dependsOnMethods = {"testAddObjectAccessList"})
  @Ignore("No offering instance id")
  public void testGetOfferingInstance() throws Exception {
    try {
      GetOfferingInstanceOptions getOfferingInstanceOptions = new GetOfferingInstanceOptions.Builder()
          .instanceIdentifier(offeringInstanceId)
          .build();
      
      Response<OfferingInstance> response =
          catalogManagementServiceAuthorized.getOfferingInstance(getOfferingInstanceOptions)
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
      expectedExceptions = ForbiddenException.class)
  @Ignore("No offering instance id")
  public void testPutOfferingInstanceReturns403WhenUserIsNotAuthorized() throws Exception {
    PutOfferingInstanceOptions putOfferingInstanceOptions = new PutOfferingInstanceOptions.Builder()
        .instanceIdentifier(offeringInstanceId)
        .xAuthRefreshToken(refreshTokenNotAuthorized)
        .id(offeringInstanceId)
        .catalogId(catalogId)
        .offeringId(offeringId)
        .kindFormat(kindVpe)
        .version("0.0.3")
        .clusterId(clusterId)
        .clusterRegion(regionUsSouth)
        .clusterAllNamespaces(true)
        .build();
    
    catalogManagementServiceNotAuthorized.putOfferingInstance(putOfferingInstanceOptions).execute();
  }
  
  @Test(dependsOnMethods = {"testAddObjectAccessList"},
      expectedExceptions = NotFoundException.class)
  @Ignore("No offering instance id")
  public void testPutOfferingInstanceReturns404WhenNoSuchCatalog() throws Exception {
    PutOfferingInstanceOptions putOfferingInstanceOptions = new PutOfferingInstanceOptions.Builder()
        .instanceIdentifier(offeringInstanceId)
        .xAuthRefreshToken(refreshTokenAuthorized)
        .id(offeringInstanceId)
        .catalogId("invalid-" + catalogId)
        .offeringId(offeringId)
        .kindFormat(kindVpe)
        .version("0.0.3")
        .clusterId(clusterId)
        .clusterRegion(regionUsSouth)
        .clusterAllNamespaces(true)
        .build();
    
    catalogManagementServiceAuthorized.putOfferingInstance(putOfferingInstanceOptions).execute();
  }
  
  @Test(dependsOnMethods = {"testAddObjectAccessList"},
      expectedExceptions = BadRequestException.class)
  @Ignore("No offering instance id")
  public void testPutOfferingInstanceReturns400WhenBackendInputValidationFails() throws Exception {
    PutOfferingInstanceOptions putOfferingInstanceOptions = new PutOfferingInstanceOptions.Builder()
        .instanceIdentifier(offeringInstanceId)
        .xAuthRefreshToken(refreshTokenAuthorized)
        .id(offeringInstanceId)
        .catalogId(catalogId)
        .offeringId(offeringId)
        .kindFormat("bogus kind")
        .version("0.0.3")
        .clusterId(clusterId)
        .clusterRegion(regionUsSouth)
        .clusterAllNamespaces(true)
        .build();
    
    catalogManagementServiceAuthorized.putOfferingInstance(putOfferingInstanceOptions).execute();
  }
  
  @Test(dependsOnMethods = {"testAddObjectAccessList"})
  @Ignore("No offering instance id")
  public void testPutOfferingInstance() throws Exception {
    try {
      PutOfferingInstanceOptions putOfferingInstanceOptions = new PutOfferingInstanceOptions.Builder()
          .instanceIdentifier(offeringInstanceId)
          .xAuthRefreshToken(refreshTokenAuthorized)
          .id(offeringInstanceId)
          .catalogId(catalogId)
          .offeringId(offeringId)
          .kindFormat(kindVpe)
          .version("0.0.3")
          .clusterId(clusterId)
          .clusterRegion(regionUsSouth)
          .clusterAllNamespaces(true)
          .build();
      
      Response<OfferingInstance> response =
          catalogManagementServiceAuthorized.putOfferingInstance(putOfferingInstanceOptions)
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
  public void testDeleteVersionReturns400WhenBackendInputValidationFails() throws Exception {
    DeleteVersionOptions deleteVersionOptions = new DeleteVersionOptions.Builder()
        .versionLocId(bogusVersionLocatorId)
        .build();
    
    catalogManagementServiceAuthorized.deleteVersion(deleteVersionOptions).execute();
  }
  
  @Test(dependsOnMethods = {"testAddObjectAccessList"},
      expectedExceptions = NotFoundException.class)
  public void testDeleteVersionReturns404WhenNoSuchVersion() throws Exception {
    DeleteVersionOptions deleteVersionOptions = new DeleteVersionOptions.Builder()
        .versionLocId("invalid-" + versionLocatorId)
        .build();
    
    catalogManagementServiceAuthorized.deleteVersion(deleteVersionOptions).execute();
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
  public void testDeleteVersion() throws Exception {
    try {
      DeleteVersionOptions deleteVersionOptions = new DeleteVersionOptions.Builder()
          .versionLocId(versionLocatorId)
          .build();
      
      Response<Void> response = catalogManagementServiceAuthorized.deleteVersion(deleteVersionOptions).execute();
      
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
  
  @Test(dependsOnMethods = {"testDeleteVersion"},
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
  
  @Test(dependsOnMethods = {"testDeleteVersion"},
      expectedExceptions = NotFoundException.class)
  public void testDeleteOperatorsReturns404WhenNoSuchVersion() throws Exception {
    DeleteOperatorsOptions deleteOperatorsOptions = new DeleteOperatorsOptions.Builder()
        .xAuthRefreshToken(refreshTokenAuthorized)
        .clusterId(clusterId)
        .region(regionUsSouth)
        .versionLocatorId("invalid-" + versionLocatorId)
        .build();
    
    catalogManagementServiceAuthorized.deleteOperators(deleteOperatorsOptions).execute();
  }
  
  @Test(dependsOnMethods = {"testDeleteVersion"},
      expectedExceptions = BadRequestException.class)
  public void testDeleteOperatorsReturns400WhenBackendInputValidationFails() throws Exception {
    DeleteOperatorsOptions deleteOperatorsOptions = new DeleteOperatorsOptions.Builder()
        .xAuthRefreshToken(refreshTokenAuthorized)
        .clusterId(clusterId)
        .region(regionUsSouth)
        .versionLocatorId(bogusVersionLocatorId)
        .build();
    
    catalogManagementServiceAuthorized.deleteOperators(deleteOperatorsOptions).execute();
  }
  
  // Error: Error loading version with id: fdeefb18-57aa-4390-a9e0-b66b551db803.
  // 2c187aa6-5009-4a2f-8f57-86533d2d3a18: Error[404 Not Found] -
  // Version not found: Catalog[fdeefb18-57aa-4390-a9e0-b66b551db803]:Version[2c187aa6-5009-4a2f-8f57-86533d2d3a18]
  
  @Test(dependsOnMethods = {"testDeleteVersion"})
  @Ignore("Strange not found error, see comments.")
  public void testDeleteOperators() throws Exception {
    try {
      DeleteOperatorsOptions deleteOperatorsOptions = new DeleteOperatorsOptions.Builder()
          .xAuthRefreshToken(refreshTokenAuthorized)
          .clusterId(clusterId)
          .region(regionUsSouth)
          .versionLocatorId(versionLocatorId)
          .build();
      
      Response<Void> response = catalogManagementServiceAuthorized.deleteOperators(deleteOperatorsOptions).execute();
      
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
  
  @Test(dependsOnMethods = {"testDeleteVersion"},
      expectedExceptions = ForbiddenException.class)
  @Ignore("No Offering instance id.")
  public void testDeleteOfferingInstanceReturns403WhenUserIsNotAuthorized() throws Exception {
    DeleteOfferingInstanceOptions deleteOfferingInstanceOptions =
        new DeleteOfferingInstanceOptions.Builder()
            .instanceIdentifier(offeringInstanceId)
            .xAuthRefreshToken(refreshTokenNotAuthorized)
            .build();
    
    catalogManagementServiceNotAuthorized.deleteOfferingInstance(deleteOfferingInstanceOptions)
        .execute();
  }
  
  @Test(dependsOnMethods = {"testDeleteVersion"},
      expectedExceptions = NotFoundException.class)
  @Ignore("No Offering instance id.")
  public void testDeleteOfferingInstanceReturns404WhenNoSuchOfferingInstance() throws Exception {
    DeleteOfferingInstanceOptions deleteOfferingInstanceOptions = new DeleteOfferingInstanceOptions.Builder()
        .instanceIdentifier("invalid-" + offeringInstanceId)
        .xAuthRefreshToken(refreshTokenAuthorized)
        .build();
    
    catalogManagementServiceAuthorized.deleteOfferingInstance(deleteOfferingInstanceOptions)
        .execute();
  }
  
  @Test(dependsOnMethods = {"testDeleteVersion"})
  @Ignore("No Offering instance id.")
  public void testDeleteOfferingInstance() throws Exception {
    try {
      DeleteOfferingInstanceOptions deleteOfferingInstanceOptions = new DeleteOfferingInstanceOptions.Builder()
          .instanceIdentifier(offeringInstanceId)
          .xAuthRefreshToken(refreshTokenAuthorized)
          .build();
      
      Response<Void> response = catalogManagementServiceAuthorized.deleteOfferingInstance(deleteOfferingInstanceOptions)
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
  
  @Test(dependsOnMethods = {"testDeleteVersion"},
      expectedExceptions = ForbiddenException.class)
  public void testDeleteObjectAccessListReturn403WhenUserIsNotAuthorized() throws Exception {
    DeleteObjectAccessListOptions deleteObjectAccessListOptions = new DeleteObjectAccessListOptions.Builder()
        .catalogIdentifier(catalogId)
        .objectIdentifier(objectId)
        .addAccounts(accountId)
        .build();
    
    catalogManagementServiceNotAuthorized.deleteObjectAccessList(deleteObjectAccessListOptions).execute();
  }
  
  @Test(dependsOnMethods = {"testDeleteVersion"},
      expectedExceptions = NotFoundException.class)
  public void testDeleteObjectAccessListReturn404WhenNoSuchCatalog() throws Exception {
    DeleteObjectAccessListOptions deleteObjectAccessListOptions = new DeleteObjectAccessListOptions.Builder()
        .catalogIdentifier("invalid-" + catalogId)
        .objectIdentifier(objectId)
        .addAccounts(accountId)
        .build();
    
    catalogManagementServiceAuthorized.deleteObjectAccessList(deleteObjectAccessListOptions).execute();
  }
  
  @Test(dependsOnMethods = {"testDeleteVersion"})
  public void testDeleteObjectAccessList() throws Exception {
    try {
      DeleteObjectAccessListOptions deleteObjectAccessListOptions = new DeleteObjectAccessListOptions.Builder()
          .catalogIdentifier(catalogId)
          .objectIdentifier(objectId)
          .addAccounts(accountId)
          .build();
      
      Response<AccessListBulkResponse> response =
          catalogManagementServiceAuthorized.deleteObjectAccessList(deleteObjectAccessListOptions)
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
      expectedExceptions = ForbiddenException.class)
  public void testDeleteObjectAccessReturns403WhenUserIsNotAuthorized() throws Exception {
    DeleteObjectAccessOptions deleteObjectAccessOptions = new DeleteObjectAccessOptions.Builder()
        .catalogIdentifier(catalogId)
        .objectIdentifier(objectId)
        .accountIdentifier(accountId)
        .build();
    
    catalogManagementServiceNotAuthorized.deleteObjectAccess(deleteObjectAccessOptions).execute();
  }
  
  @Test(dependsOnMethods = {"testDeleteObjectAccessList"},
      expectedExceptions = NotFoundException.class)
  public void testDeleteObjectAccessReturns404WhenNoSuchCatalog() throws Exception {
    DeleteObjectAccessOptions deleteObjectAccessOptions = new DeleteObjectAccessOptions.Builder()
        .catalogIdentifier("invalid-" + catalogId)
        .objectIdentifier(objectId)
        .accountIdentifier(accountId)
        .build();
    
    catalogManagementServiceAuthorized.deleteObjectAccess(deleteObjectAccessOptions).execute();
  }
  
  @Test(dependsOnMethods = {"testDeleteObjectAccessList"})
  public void testDeleteObjectAccess() throws Exception {
    try {
      DeleteObjectAccessOptions deleteObjectAccessOptions = new DeleteObjectAccessOptions.Builder()
          .catalogIdentifier(catalogId)
          .objectIdentifier(objectId)
          .accountIdentifier(accountId)
          .build();
      
      Response<Void> response = catalogManagementServiceAuthorized.deleteObjectAccess(deleteObjectAccessOptions)
          .execute();
      
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
  
  @Test(dependsOnMethods = {"testDeleteObjectAccess"},
      expectedExceptions = ForbiddenException.class)
  @Ignore("other SDKs returns 403 java is not - temporarily disabled")
  public void testDeleteObjectReturns403WhenUserIsNotAuthorized() throws Exception {
    DeleteObjectOptions deleteObjectOptions = new DeleteObjectOptions.Builder()
        .catalogIdentifier(catalogId)
        .objectIdentifier(objectId)
        .build();
    
    catalogManagementServiceNotAuthorized.deleteObject(deleteObjectOptions).execute();
  }
  
  @Test(dependsOnMethods = {"testDeleteObjectAccess"})
  public void testDeleteObjectReturns200WhenNoSuchObject() throws Exception {
    try {
      DeleteObjectOptions deleteObjectOptions = new DeleteObjectOptions.Builder()
          .catalogIdentifier(catalogId)
          .objectIdentifier("invalid-" + objectId)
          .build();
      
      Response<Void> response = catalogManagementServiceAuthorized.deleteObject(deleteObjectOptions).execute();
      
      assertNotNull(response);
      assertEquals(response.getStatusCode(), 200);
    } catch (ServiceResponseException e) {
      fail(String.format("Service returned status code %d: %s\nError details: %s", e.getStatusCode(), e.getMessage(),
          e.getDebuggingInfo()));
    }
  }
  
  @Test(dependsOnMethods = {"testDeleteObjectAccess"})
  public void testDeleteObject() throws Exception {
    try {
      DeleteObjectOptions deleteObjectOptions = new DeleteObjectOptions.Builder()
          .catalogIdentifier(catalogId)
          .objectIdentifier(objectId)
          .build();
      
      Response<Void> response = catalogManagementServiceAuthorized.deleteObject(deleteObjectOptions).execute();
      
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
  
  @Test(dependsOnMethods = {"testDeleteObject"})
  public void testDeleteOfferingReturns200WhenNoSuchOfferings() throws Exception {
    try {
      DeleteOfferingOptions deleteOfferingOptions = new DeleteOfferingOptions.Builder()
          .catalogIdentifier(catalogId)
          .offeringId("invalid-" + offeringId)
          .build();
      
      Response<Void> response = catalogManagementServiceAuthorized.deleteOffering(deleteOfferingOptions).execute();
      
      assertNotNull(response);
      assertEquals(response.getStatusCode(), 200);
      
    } catch (ServiceResponseException e) {
      fail(String.format("Service returned status code %d: %s\nError details: %s", e.getStatusCode(), e.getMessage(),
          e.getDebuggingInfo()));
    }
  }
  
  @Test(dependsOnMethods = {"testDeleteObject"},
      expectedExceptions = ForbiddenException.class)
  public void testDeleteOfferingReturns403WhenUserIsNotAuthorized() throws Exception {
    DeleteOfferingOptions deleteOfferingOptions = new DeleteOfferingOptions.Builder()
        .catalogIdentifier(catalogId)
        .offeringId(offeringId)
        .build();
    
    catalogManagementServiceNotAuthorized.deleteOffering(deleteOfferingOptions).execute();
  }
  
  @Test(dependsOnMethods = {"testDeleteObject"})
  public void testDeleteOffering() throws Exception {
    try {
      DeleteOfferingOptions deleteOfferingOptions = new DeleteOfferingOptions.Builder()
          .catalogIdentifier(catalogId)
          .offeringId(offeringId)
          .build();
      
      Response<Void> response = catalogManagementServiceAuthorized.deleteOffering(deleteOfferingOptions).execute();
      
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
  
  @Test(dependsOnMethods = {"testDeleteOffering"})
  public void testDeleteCatalogReturns200WhenNoSuchCatalog() throws Exception {
    try {
      DeleteCatalogOptions deleteCatalogOptions = new DeleteCatalogOptions.Builder()
          .catalogIdentifier("invalid-" + catalogId)
          .build();
      
      Response<Void> response = catalogManagementServiceAuthorized.deleteCatalog(deleteCatalogOptions).execute();
      assertNotNull(response);
      assertEquals(response.getStatusCode(), 200);
    } catch (ServiceResponseException e) {
      fail(String.format("Service returned status code %d: %s\nError details: %s", e.getStatusCode(), e.getMessage(),
          e.getDebuggingInfo()));
    }
  }
  
  @Test(dependsOnMethods = {"testDeleteOffering"},
      expectedExceptions = ForbiddenException.class)
  public void testDeleteCatalogReturns403WhenUserIsNotAuthorized() throws Exception {
    DeleteCatalogOptions deleteCatalogOptions = new DeleteCatalogOptions.Builder()
        .catalogIdentifier(catalogId)
        .build();
    
    catalogManagementServiceNotAuthorized.deleteCatalog(deleteCatalogOptions).execute();
  }
  
  @Test(dependsOnMethods = {"testDeleteOffering"})
  public void testDeleteCatalog() throws Exception {
    try {
      DeleteCatalogOptions deleteCatalogOptions = new DeleteCatalogOptions.Builder()
          .catalogIdentifier(catalogId)
          .build();
      
      Response<Void> response = catalogManagementServiceAuthorized.deleteCatalog(deleteCatalogOptions).execute();
      
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
      catalogManagementServiceAuthorized.deleteObjectAccess(deleteObjectAccessOptions).execute();
    } catch (ServiceResponseException e) {
      System.out.println("Object Access is already deleted.");
    }
    
    try {
      DeleteVersionOptions deleteVersionOptions = new DeleteVersionOptions.Builder()
          .versionLocId("testString")
          .build();
      catalogManagementServiceAuthorized.deleteVersion(deleteVersionOptions).execute();
    } catch (ServiceResponseException e) {
      System.out.println("Version is already deleted.");
    }
    
    try {
      DeleteObjectOptions deleteObjectOptions = new DeleteObjectOptions.Builder()
          .catalogIdentifier(catalogId)
          .objectIdentifier(objectId)
          .build();
      catalogManagementServiceAuthorized.deleteObject(deleteObjectOptions).execute();
    } catch (ServiceResponseException e) {
      System.out.println("Object is already deleted.");
    }
    
    try {
      DeleteCatalogOptions deleteCatalogOptions = new DeleteCatalogOptions.Builder().catalogIdentifier(catalogId)
          .build();
      catalogManagementServiceAuthorized.deleteCatalog(deleteCatalogOptions).execute();
    } catch (ServiceResponseException e) {
      System.out.println("Catalog is already deleted.");
    }
    
    System.out.println("Clean up complete.");
  }
  
}
