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

import com.ibm.cloud.platform_services.catalog_management.v1.model.AccessListBulkResponse;
import com.ibm.cloud.platform_services.catalog_management.v1.model.Account;
import com.ibm.cloud.platform_services.catalog_management.v1.model.AccountPublishObjectOptions;
import com.ibm.cloud.platform_services.catalog_management.v1.model.AccountPublishVersionOptions;
import com.ibm.cloud.platform_services.catalog_management.v1.model.AccumulatedFilters;
import com.ibm.cloud.platform_services.catalog_management.v1.model.AddObjectAccessListOptions;
import com.ibm.cloud.platform_services.catalog_management.v1.model.ApprovalResult;
import com.ibm.cloud.platform_services.catalog_management.v1.model.AuditLog;
import com.ibm.cloud.platform_services.catalog_management.v1.model.Catalog;
import com.ibm.cloud.platform_services.catalog_management.v1.model.CatalogObject;
import com.ibm.cloud.platform_services.catalog_management.v1.model.CatalogSearchResult;
import com.ibm.cloud.platform_services.catalog_management.v1.model.ClusterInfo;
import com.ibm.cloud.platform_services.catalog_management.v1.model.CommitVersionOptions;
import com.ibm.cloud.platform_services.catalog_management.v1.model.CopyVersionOptions;
import com.ibm.cloud.platform_services.catalog_management.v1.model.CreateCatalogOptions;
import com.ibm.cloud.platform_services.catalog_management.v1.model.CreateObjectAccessOptions;
import com.ibm.cloud.platform_services.catalog_management.v1.model.CreateObjectOptions;
import com.ibm.cloud.platform_services.catalog_management.v1.model.CreateOfferingInstanceOptions;
import com.ibm.cloud.platform_services.catalog_management.v1.model.CreateOfferingOptions;
import com.ibm.cloud.platform_services.catalog_management.v1.model.DeleteCatalogOptions;
import com.ibm.cloud.platform_services.catalog_management.v1.model.DeleteObjectAccessListOptions;
import com.ibm.cloud.platform_services.catalog_management.v1.model.DeleteObjectAccessOptions;
import com.ibm.cloud.platform_services.catalog_management.v1.model.DeleteObjectOptions;
import com.ibm.cloud.platform_services.catalog_management.v1.model.DeleteOfferingInstanceOptions;
import com.ibm.cloud.platform_services.catalog_management.v1.model.DeleteOfferingOptions;
import com.ibm.cloud.platform_services.catalog_management.v1.model.DeleteOperatorsOptions;
import com.ibm.cloud.platform_services.catalog_management.v1.model.DeleteVersionOptions;
import com.ibm.cloud.platform_services.catalog_management.v1.model.DeployOperatorsOptions;
import com.ibm.cloud.platform_services.catalog_management.v1.model.DeprecateVersionOptions;
import com.ibm.cloud.platform_services.catalog_management.v1.model.Filters;
import com.ibm.cloud.platform_services.catalog_management.v1.model.GetCatalogAccountAuditOptions;
import com.ibm.cloud.platform_services.catalog_management.v1.model.GetCatalogAccountFiltersOptions;
import com.ibm.cloud.platform_services.catalog_management.v1.model.GetCatalogAccountOptions;
import com.ibm.cloud.platform_services.catalog_management.v1.model.GetCatalogAuditOptions;
import com.ibm.cloud.platform_services.catalog_management.v1.model.GetCatalogOptions;
import com.ibm.cloud.platform_services.catalog_management.v1.model.GetClusterOptions;
import com.ibm.cloud.platform_services.catalog_management.v1.model.GetConsumptionOfferingsOptions;
import com.ibm.cloud.platform_services.catalog_management.v1.model.GetNamespacesOptions;
import com.ibm.cloud.platform_services.catalog_management.v1.model.GetObjectAccessListOptions;
import com.ibm.cloud.platform_services.catalog_management.v1.model.GetObjectAccessOptions;
import com.ibm.cloud.platform_services.catalog_management.v1.model.GetObjectAuditOptions;
import com.ibm.cloud.platform_services.catalog_management.v1.model.GetObjectOptions;
import com.ibm.cloud.platform_services.catalog_management.v1.model.GetOfferingAboutOptions;
import com.ibm.cloud.platform_services.catalog_management.v1.model.GetOfferingAuditOptions;
import com.ibm.cloud.platform_services.catalog_management.v1.model.GetOfferingContainerImagesOptions;
import com.ibm.cloud.platform_services.catalog_management.v1.model.GetOfferingInstanceOptions;
import com.ibm.cloud.platform_services.catalog_management.v1.model.GetOfferingLicenseOptions;
import com.ibm.cloud.platform_services.catalog_management.v1.model.GetOfferingOptions;
import com.ibm.cloud.platform_services.catalog_management.v1.model.GetOfferingUpdatesOptions;
import com.ibm.cloud.platform_services.catalog_management.v1.model.GetOfferingWorkingCopyOptions;
import com.ibm.cloud.platform_services.catalog_management.v1.model.GetOverrideValuesOptions;
import com.ibm.cloud.platform_services.catalog_management.v1.model.GetPreinstallOptions;
import com.ibm.cloud.platform_services.catalog_management.v1.model.GetValidationStatusOptions;
import com.ibm.cloud.platform_services.catalog_management.v1.model.GetVersionOptions;
import com.ibm.cloud.platform_services.catalog_management.v1.model.IbmPublishObjectOptions;
import com.ibm.cloud.platform_services.catalog_management.v1.model.IbmPublishVersionOptions;
import com.ibm.cloud.platform_services.catalog_management.v1.model.ImageManifest;
import com.ibm.cloud.platform_services.catalog_management.v1.model.ImportOfferingOptions;
import com.ibm.cloud.platform_services.catalog_management.v1.model.ImportOfferingVersionOptions;
import com.ibm.cloud.platform_services.catalog_management.v1.model.InstallStatus;
import com.ibm.cloud.platform_services.catalog_management.v1.model.InstallVersionOptions;
import com.ibm.cloud.platform_services.catalog_management.v1.model.ListCatalogsOptions;
import com.ibm.cloud.platform_services.catalog_management.v1.model.ListObjectsOptions;
import com.ibm.cloud.platform_services.catalog_management.v1.model.ListOfferingsOptions;
import com.ibm.cloud.platform_services.catalog_management.v1.model.ListOperatorsOptions;
import com.ibm.cloud.platform_services.catalog_management.v1.model.NamespaceSearchResult;
import com.ibm.cloud.platform_services.catalog_management.v1.model.ObjectAccess;
import com.ibm.cloud.platform_services.catalog_management.v1.model.ObjectAccessListResult;
import com.ibm.cloud.platform_services.catalog_management.v1.model.ObjectListResult;
import com.ibm.cloud.platform_services.catalog_management.v1.model.ObjectSearchResult;
import com.ibm.cloud.platform_services.catalog_management.v1.model.Offering;
import com.ibm.cloud.platform_services.catalog_management.v1.model.OfferingInstance;
import com.ibm.cloud.platform_services.catalog_management.v1.model.OfferingSearchResult;
import com.ibm.cloud.platform_services.catalog_management.v1.model.OperatorDeployResult;
import com.ibm.cloud.platform_services.catalog_management.v1.model.PreinstallVersionOptions;
import com.ibm.cloud.platform_services.catalog_management.v1.model.PublicPublishObjectOptions;
import com.ibm.cloud.platform_services.catalog_management.v1.model.PublicPublishVersionOptions;
import com.ibm.cloud.platform_services.catalog_management.v1.model.PublishObject;
import com.ibm.cloud.platform_services.catalog_management.v1.model.PutOfferingInstanceOptions;
import com.ibm.cloud.platform_services.catalog_management.v1.model.ReloadOfferingOptions;
import com.ibm.cloud.platform_services.catalog_management.v1.model.ReplaceCatalogOptions;
import com.ibm.cloud.platform_services.catalog_management.v1.model.ReplaceObjectOptions;
import com.ibm.cloud.platform_services.catalog_management.v1.model.ReplaceOfferingIconOptions;
import com.ibm.cloud.platform_services.catalog_management.v1.model.ReplaceOfferingOptions;
import com.ibm.cloud.platform_services.catalog_management.v1.model.ReplaceOperatorsOptions;
import com.ibm.cloud.platform_services.catalog_management.v1.model.SearchObjectsOptions;
import com.ibm.cloud.platform_services.catalog_management.v1.model.SharedPublishObjectOptions;
import com.ibm.cloud.platform_services.catalog_management.v1.model.State;
import com.ibm.cloud.platform_services.catalog_management.v1.model.UpdateCatalogAccountOptions;
import com.ibm.cloud.platform_services.catalog_management.v1.model.UpdateOfferingIbmOptions;
import com.ibm.cloud.platform_services.catalog_management.v1.model.ValidateInstallOptions;
import com.ibm.cloud.platform_services.catalog_management.v1.model.Validation;
import com.ibm.cloud.platform_services.catalog_management.v1.model.Version;
import com.ibm.cloud.platform_services.catalog_management.v1.model.VersionUpdateDescriptor;
import com.ibm.cloud.sdk.core.http.Response;
import com.ibm.cloud.sdk.core.security.IamAuthenticator;
import com.ibm.cloud.sdk.core.service.exception.ServiceResponseException;
import com.ibm.cloud.sdk.core.util.CredentialUtils;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

//
// This file provides an example of how to use the Catalog Management service.
//
// The following configuration properties are assumed to be defined:
// CATALOG_MANAGEMENT_URL=<service base url>
// CATALOG_MANAGEMENT_AUTH_TYPE=iam
// CATALOG_MANAGEMENT_APIKEY=<IAM apikey>
// CATALOG_MANAGEMENT_AUTH_URL=<IAM token service base URL - omit this if using the production environment>
//
// These configuration properties can be exported as environment variables, or stored
// in a configuration file and then:
// export IBM_CREDENTIALS_FILE=<name of configuration file>
//
public class CatalogManagementExamples {
  
  private static final Logger logger = LoggerFactory.getLogger(CatalogManagementExamples.class);
  
  protected CatalogManagementExamples() {
  }
  
  static {
    System.setProperty("IBM_CREDENTIALS_FILE", "../../catalog_mgmt.env");
  }
  
  @SuppressWarnings("checkstyle:methodlength")
  public static void main(String[] args) throws Exception {
    CatalogManagement catalogManagementService = CatalogManagement.newInstance();
    
    // Load up our test-specific config properties.
    Map<String, String> config = CredentialUtils.getServiceProperties(CatalogManagement.DEFAULT_SERVICE_NAME);
    
    String clusterId = config.get("CLUSTER_ID");
    String accountId = config.get("ACCOUNT_ID");
    String gitAuthToken = config.get("GIT_TOKEN");
    
    String catalogId = null;
    String offeringId = null;
    String versionLocatorId = null;
    String objectId = null;
    String bearerToken = null;
    String offeringInstanceId = null;
    
    try {
      IamAuthenticator authenticator = (IamAuthenticator) catalogManagementService.getAuthenticator();
      bearerToken = authenticator.requestToken().getRefreshToken();
    } catch (Exception e) {
      logger.error(String.format("Requesting refresh token failed! %s Error details: %s", e.getMessage()));
    }
    
    // Catalogs
    
    try {
      System.out.println("createCatalog() result:");
      // begin-create_catalog
      CreateCatalogOptions createCatalogOptions = new CreateCatalogOptions.Builder()
          .addTags("java")
          .addTags("sdk")
          .label("label-java")
          .kind("vpe")
          .owningAccount(accountId)
          .build();
      
      Response<Catalog> response = catalogManagementService.createCatalog(createCatalogOptions).execute();
      Catalog catalog = response.getResult();
      
      System.out.println(catalog);
      // end-create_catalog
      catalogId = catalog.id();
    } catch (ServiceResponseException e) {
      logger.error(String.format("Service returned status code %s: %s%nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()), e);
    }
    
    try {
      System.out.println("getCatalog() result:");
      // begin-get_catalog
      GetCatalogOptions getCatalogOptions = new GetCatalogOptions.Builder()
          .catalogIdentifier(catalogId)
          .build();
      
      Response<Catalog> response = catalogManagementService.getCatalog(getCatalogOptions).execute();
      Catalog catalog = response.getResult();
      
      System.out.println(catalog);
      // end-get_catalog
    } catch (ServiceResponseException e) {
      logger.error(String.format("Service returned status code %s: %s%nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()), e);
    }
    
    try {
      System.out.println("replaceCatalog() result:");
      // begin-replace_catalog
      ReplaceCatalogOptions replaceCatalogOptions = new ReplaceCatalogOptions.Builder()
          .catalogIdentifier(catalogId)
          .addTags("ibm")
          .addTags("cloud")
          .owningAccount(accountId)
          .kind("vpe")
          .build();
      
      Response<Catalog> response = catalogManagementService.replaceCatalog(replaceCatalogOptions)
          .execute();
      Catalog catalog = response.getResult();
      
      System.out.println(catalog);
      // end-replace_catalog
    } catch (ServiceResponseException e) {
      logger.error(String.format("Service returned status code %s: %s%nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()), e);
    }
    
    try {
      System.out.println("listCatalogs() result:");
      // begin-list_catalogs
      Response<CatalogSearchResult> response = catalogManagementService.listCatalogs()
          .execute();
      CatalogSearchResult catalogSearchResult = response.getResult();
      
      System.out.println(catalogSearchResult);
      // end-list_catalogs
    } catch (ServiceResponseException e) {
      logger.error(String.format("Service returned status code %s: %s%nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()), e);
    }
    
    try {
      System.out.println("createOffering() result:");
      // begin-create_offering
      CreateOfferingOptions createOfferingOptions = new CreateOfferingOptions.Builder()
          .catalogIdentifier(catalogId)
          .label("label-java")
          .name("offering-created-by-java-sdk")
          .build();
      
      Response<Offering> response = catalogManagementService.createOffering(createOfferingOptions).execute();
      Offering offering = response.getResult();
      
      System.out.println(offering);
      // end-create_offering
      offeringId = offering.id();
    } catch (ServiceResponseException e) {
      logger.error(String.format("Service returned status code %s: %s%nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()), e);
    }
    
    try {
      System.out.println("getOffering() result:");
      // begin-get_offering
      GetOfferingOptions getOfferingOptions = new GetOfferingOptions.Builder()
          .catalogIdentifier(catalogId)
          .offeringId(offeringId)
          .build();
      
      Response<Offering> response = catalogManagementService.getOffering(getOfferingOptions).execute();
      Offering offering = response.getResult();
      
      System.out.println(offering);
      // end-get_offering
    } catch (ServiceResponseException e) {
      logger.error(String.format("Service returned status code %s: %s%nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()), e);
    }
    
    try {
      System.out.println("replaceOffering() result:");
      // begin-replace_offering
      ReplaceOfferingOptions replaceOfferingOptions = new ReplaceOfferingOptions.Builder()
          .catalogIdentifier(catalogId)
          .offeringId(offeringId)
          .id(offeringId)
          .name("updated-offering-name-by-java-sdk")
          .shortDescription("A catchy, but informative short description.")
          .build();
      
      Response<Offering> response = catalogManagementService.replaceOffering(replaceOfferingOptions).execute();
      Offering offering = response.getResult();
      
      System.out.println(offering);
      // end-replace_offering
    } catch (ServiceResponseException e) {
      logger.error(String.format("Service returned status code %s: %s%nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()), e);
    }
    
    try {
      System.out.println("listOfferings() result:");
      // begin-list_offerings
      
        ListOfferingsOptions listOfferingsOptions = new ListOfferingsOptions.Builder()
            .catalogIdentifier(catalogId)
            .limit(100)
            .offset(0)
            .digest(false)
            .build();
        
        Response<OfferingSearchResult> response = catalogManagementService.listOfferings(listOfferingsOptions)
            .execute();
        OfferingSearchResult offeringSearchResult = response.getResult();
        
        System.out.println(offeringSearchResult);
        
      // end-list_offerings
    } catch (ServiceResponseException e) {
      logger.error(String.format("Service returned status code %s: %s%nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()), e);
    }
  
    try {
      System.out.println("importOffering() result:");
      // begin-import_offering
      ImportOfferingOptions importOfferingOptions = new ImportOfferingOptions.Builder()
          .catalogIdentifier(catalogId)
          .offeringId(offeringId)
          .addTags("node-red")
          .addTags("operator")
          .zipurl("https://github.com/rhm-samples/node-red-operator/blob/master/node-red" +
              "-operator/bundle/0.0.2/node-red-operator.v0.0.2.clusterserviceversion.yaml")
          .addTargetKinds("roks")
          .targetVersion("0.0.2")
          .repoType("git_public")
          .xAuthToken(gitAuthToken)
          .build();
    
      Response<Offering> response = catalogManagementService.importOffering(importOfferingOptions).execute();
      Offering offering = response.getResult();
    
      System.out.println(offering);
      // end-import_offering
      versionLocatorId = offering.kinds().get(0).versions().get(0).versionLocator();
    } catch (ServiceResponseException e) {
      logger.error(String.format("Service returned status code %s: %s%nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()), e);
    }
  
    try {
      System.out.println("reloadOffering() result:");
      // begin-reload_offering
      ReloadOfferingOptions reloadOfferingOptions = new ReloadOfferingOptions.Builder()
          .catalogIdentifier(catalogId)
          .offeringId(offeringId)
          .targetVersion("0.0.2")
          .addTargetKinds("roks")
          .zipurl("https://github.com/rhm-samples/node-red-operator/blob/master/node-red" +
              "-operator/bundle/0.0.2/node-red-operator.v0.0.2.clusterserviceversion.yaml")
          .addTags("node-red")
          .addTags("operator")
          .repoType("git_public")
          .build();
    
      Response<Offering> response = catalogManagementService.reloadOffering(reloadOfferingOptions).execute();
      Offering offering = response.getResult();
    
      System.out.println(offering);
      // end-reload_offering
    } catch (ServiceResponseException e) {
      logger.error(String.format("Service returned status code %s: %s%nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()), e);
    }
  
    try {
      System.out.println("createObject() result:");
      // begin-create_object
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
          .name("object_in_ibm_cloud")
          .crn("crn:v1:bluemix:public:iam-global-endpoint:global:::endpoint:private.iam.cloud.ibm" +
              ".com")
          .parentId("us-south")
          .kind("vpe")
          .publish(publishObjectModel)
          .state(stateModel)
          .build();
    
      Response<CatalogObject> response = catalogManagementService.createObject(createObjectOptions).execute();
      CatalogObject catalogObject = response.getResult();
    
      System.out.println(catalogObject);
      objectId = catalogObject.id();
      // end-create_object
    } catch (ServiceResponseException e) {
      logger.error(String.format("Service returned status code %s: %s%nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()), e);
    }
  
    try {
      System.out.println("getOfferingAudit() result:");
      // begin-get_offering_audit
      GetOfferingAuditOptions getOfferingAuditOptions = new GetOfferingAuditOptions.Builder()
          .catalogIdentifier(catalogId)
          .offeringId(offeringId)
          .build();
    
      Response<AuditLog> response = catalogManagementService.getOfferingAudit(getOfferingAuditOptions).execute();
      AuditLog auditLog = response.getResult();
    
      System.out.println(auditLog);
      // end-get_offering_audit
    } catch (ServiceResponseException e) {
      logger.error(String.format("Service returned status code %s: %s%nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()), e);
    }
  
    try {
      System.out.println("getCatalogAccount() result:");
      // begin-get_catalog_account
      Response<Account> response = catalogManagementService.getCatalogAccount()
          .execute();
      Account account = response.getResult();
    
      System.out.println(account);
      // end-get_catalog_account
      accountId = account.id();
    } catch (ServiceResponseException e) {
      logger.error(String.format("Service returned status code %s: %s%nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()), e);
    }
  
    try {
      System.out.println("updateCatalogAccount() result:");
      // begin-update_catalog_account
      Filters filters = new Filters.Builder()
          .includeAll(true)
          .build();
    
      UpdateCatalogAccountOptions updateCatalogAccountOptions = new UpdateCatalogAccountOptions.Builder()
          .id(accountId)
          .accountFilters(filters)
          .build();
    
      Response<Void> response = catalogManagementService.updateCatalogAccount(updateCatalogAccountOptions)
          .execute();
      // end-update_catalog_account
      System.out.printf("updateCatalogAccount() response status code: %d%n", response.getStatusCode());
    } catch (ServiceResponseException e) {
      logger.error(String.format("Service returned status code %s: %s%nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()), e);
    }
    
    try {
      System.out.println("getCatalogAudit() result:");
      // begin-get_catalog_audit
      GetCatalogAuditOptions getCatalogAuditOptions = new GetCatalogAuditOptions.Builder()
          .catalogIdentifier(catalogId)
          .build();
      
      Response<AuditLog> response = catalogManagementService.getCatalogAudit(getCatalogAuditOptions).execute();
      AuditLog auditLog = response.getResult();
      
      System.out.println(auditLog);
      // end-get_catalog_audit
    } catch (ServiceResponseException e) {
      logger.error(String.format("Service returned status code %s: %s%nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()), e);
    }
    
    try {
      System.out.println("getCatalogAccountFilters() result:");
      // begin-get_catalog_account_filters
      GetCatalogAccountFiltersOptions getCatalogAccountFiltersOptions = new GetCatalogAccountFiltersOptions.Builder()
          .catalog(catalogId)
          .build();
      
      Response<AccumulatedFilters> response =
          catalogManagementService.getCatalogAccountFilters(getCatalogAccountFiltersOptions)
              .execute();
      AccumulatedFilters accumulatedFilters = response.getResult();
      
      System.out.println(accumulatedFilters);
      // end-get_catalog_account_filters
    } catch (ServiceResponseException e) {
      logger.error(String.format("Service returned status code %s: %s%nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()), e);
    }
    
    try {
      System.out.println("getCatalogAccountAudit() result:");
      // begin-get_catalog_account_audit
      Response<AuditLog> response = catalogManagementService.getCatalogAccountAudit()
          .execute();
      AuditLog auditLog = response.getResult();
      
      System.out.println(auditLog);
      // end-get_catalog_account_audit
    } catch (ServiceResponseException e) {
      logger.error(String.format("Service returned status code %s: %s%nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()), e);
    }
    
    try {
      System.out.println("getConsumptionOfferings() result:");
      // begin-get_consumption_offerings
      GetConsumptionOfferingsOptions getConsumptionOfferingsOptions = new GetConsumptionOfferingsOptions.Builder()
          .catalog(catalogId)
          .offset(0)
          .limit(2)
          .digest(true)
          .select("all")
          .build();
      
      Response<OfferingSearchResult> response =
          catalogManagementService.getConsumptionOfferings(getConsumptionOfferingsOptions)
              .execute();
      OfferingSearchResult offeringSearchResult = response.getResult();
      
      System.out.println(offeringSearchResult);
      // end-get_consumption_offerings
    } catch (ServiceResponseException e) {
      logger.error(String.format("Service returned status code %s: %s%nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()), e);
    }
    
    try {
      System.out.println("importOfferingVersion() result:");
      // begin-import_offering_version
      ImportOfferingVersionOptions importOfferingVersionOptions = new ImportOfferingVersionOptions.Builder()
          .catalogIdentifier(catalogId)
          .offeringId(offeringId)
          .targetVersion("0.0.3")
          .addTargetKinds("roks")
          .zipurl("https://github.com/rhm-samples/node-red-operator/blob/master/node-red" +
              "-operator/bundle/0.0.2/node-red-operator.v0.0.2.clusterserviceversion.yaml")
          .repoType("git_public")
          .build();
      
      Response<Offering> response = catalogManagementService.importOfferingVersion(importOfferingVersionOptions)
          .execute();
      Offering offering = response.getResult();
      
      System.out.println(offering);
      // end-import_offering_version
    } catch (ServiceResponseException e) {
      logger.error(String.format("Service returned status code %s: %s%nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()), e);
    }
    
    try {
      System.out.println("replaceOfferingIcon() result:");
      // begin-replace_offering_icon
      ReplaceOfferingIconOptions replaceOfferingIconOptions = new ReplaceOfferingIconOptions.Builder()
          .catalogIdentifier(catalogId)
          .offeringId(offeringId)
          .fileName("offering_icon.png")
          .build();
      
      Response<Offering> response = catalogManagementService.replaceOfferingIcon(replaceOfferingIconOptions).execute();
      Offering offering = response.getResult();
      
      System.out.println(offering);
      // end-replace_offering_icon
    } catch (ServiceResponseException e) {
      logger.error(String.format("Service returned status code %s: %s%nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()), e);
    }
    
    try {
      System.out.println("updateOfferingIbm() result:");
      // begin-update_offering_ibm
      UpdateOfferingIbmOptions updateOfferingIbmOptions = new UpdateOfferingIbmOptions.Builder()
          .catalogIdentifier(catalogId)
          .offeringId(offeringId)
          .approvalType("allow_request")
          .approved("true")
          .build();
      
      Response<ApprovalResult> response = catalogManagementService.updateOfferingIbm(updateOfferingIbmOptions)
          .execute();
      ApprovalResult approvalResult = response.getResult();
      
      System.out.println(approvalResult);
      // end-update_offering_ibm
    } catch (ServiceResponseException e) {
      logger.error(String.format("Service returned status code %s: %s%nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()), e);
    }
    
    try {
      System.out.println("getOfferingUpdates() result:");
      // begin-get_offering_updates
      GetOfferingUpdatesOptions getOfferingUpdatesOptions = new GetOfferingUpdatesOptions.Builder()
          .catalogIdentifier(catalogId)
          .offeringId(offeringId)
          .kind("roks")
          .version("0.0.2")
          .clusterId(clusterId)
          .region("us-south")
          .namespace("erp-development-environment")
          .build();
      
      Response<List<VersionUpdateDescriptor>> response =
          catalogManagementService.getOfferingUpdates(getOfferingUpdatesOptions)
              .execute();
      List<VersionUpdateDescriptor> listVersionUpdateDescriptor = response.getResult();
      
      System.out.println(listVersionUpdateDescriptor);
      // end-get_offering_updates
    } catch (ServiceResponseException e) {
      logger.error(String.format("Service returned status code %s: %s%nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()), e);
    }
    
    try {
      System.out.println("getOfferingAbout() result:");
      // begin-get_offering_about
      GetOfferingAboutOptions getOfferingAboutOptions = new GetOfferingAboutOptions.Builder()
          .versionLocId(versionLocatorId)
          .build();
      
      Response<String> response = catalogManagementService.getOfferingAbout(getOfferingAboutOptions).execute();
      String result = response.getResult();
      
      System.out.println(result);
      // end-get_offering_about
    } catch (ServiceResponseException e) {
      logger.error(String.format("Service returned status code %s: %s%nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()), e);
    }
    
    try {
      System.out.println("getOfferingLicense() result:");
      // begin-get_offering_license
      GetOfferingLicenseOptions getOfferingLicenseOptions = new GetOfferingLicenseOptions.Builder()
          .versionLocId(versionLocatorId)
          .licenseId("license-id")
          .build();
      
      Response<String> response = catalogManagementService.getOfferingLicense(getOfferingLicenseOptions).execute();
      String result = response.getResult();
      
      System.out.println(result);
      // end-get_offering_license
    } catch (ServiceResponseException e) {
      logger.error(String.format("Service returned status code %s: %s%nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()), e);
    }
    
    try {
      System.out.println("getOfferingContainerImages() result:");
      // begin-get_offering_container_images
      GetOfferingContainerImagesOptions getOfferingContainerImagesOptions =
          new GetOfferingContainerImagesOptions.Builder()
              .versionLocId(versionLocatorId)
              .build();
      
      Response<ImageManifest> response =
          catalogManagementService.getOfferingContainerImages(getOfferingContainerImagesOptions)
              .execute();
      ImageManifest imageManifest = response.getResult();
      
      System.out.println(imageManifest);
      // end-get_offering_container_images
    } catch (ServiceResponseException e) {
      logger.error(String.format("Service returned status code %s: %s%nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()), e);
    }
  
    try {
      // begin-deprecate_version
      DeprecateVersionOptions deprecateVersionOptions = new DeprecateVersionOptions.Builder()
          .versionLocId(versionLocatorId)
          .build();
    
      Response<Void> response = catalogManagementService.deprecateVersion(deprecateVersionOptions).execute();
      // end-deprecate_version
      System.out.printf("deprecateVersion() response status code: %d%n", response.getStatusCode());
    } catch (ServiceResponseException e) {
      logger.error(String.format("Service returned status code %s: %s%nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()), e);
    }
  
    try {
      // begin-account_publish_version
      AccountPublishVersionOptions accountPublishVersionOptions = new AccountPublishVersionOptions.Builder()
          .versionLocId(versionLocatorId)
          .build();
    
      Response<Void> response = catalogManagementService.accountPublishVersion(accountPublishVersionOptions).execute();
      // end-account_publish_version
      System.out.printf("accountPublishVersion() response status code: %d%n", response.getStatusCode());
    } catch (ServiceResponseException e) {
      logger.error(String.format("Service returned status code %s: %s%nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()), e);
    }
  
    try {
      // begin-ibm_publish_version
      IbmPublishVersionOptions ibmPublishVersionOptions = new IbmPublishVersionOptions.Builder()
          .versionLocId(versionLocatorId)
          .build();
    
      Response<Void> response = catalogManagementService.ibmPublishVersion(ibmPublishVersionOptions).execute();
      // end-ibm_publish_version
      System.out.printf("ibmPublishVersion() response status code: %d%n", response.getStatusCode());
    } catch (ServiceResponseException e) {
      logger.error(String.format("Service returned status code %s: %s%nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()), e);
    }
  
    try {
      // begin-public_publish_version
      PublicPublishVersionOptions publicPublishVersionOptions = new PublicPublishVersionOptions.Builder()
          .versionLocId(versionLocatorId)
          .build();
    
      Response<Void> response = catalogManagementService.publicPublishVersion(publicPublishVersionOptions).execute();
      // end-public_publish_version
      System.out.printf("publicPublishVersion() response status code: %d%n", response.getStatusCode());
    } catch (ServiceResponseException e) {
      logger.error(String.format("Service returned status code %s: %s%nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()), e);
    }
  
    try {
      // begin-commit_version
      CommitVersionOptions commitVersionOptions = new CommitVersionOptions.Builder()
          .versionLocId(versionLocatorId)
          .build();
    
      Response<Void> response = catalogManagementService.commitVersion(commitVersionOptions).execute();
      // end-commit_version
      System.out.printf("commitVersion() response status code: %d%n", response.getStatusCode());
    } catch (ServiceResponseException e) {
      logger.error(String.format("Service returned status code %s: %s%nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()), e);
    }
  
    try {
      // begin-copy_version
      CopyVersionOptions copyVersionOptions = new CopyVersionOptions.Builder()
          .versionLocId(versionLocatorId)
          .build();
    
      Response<Void> response = catalogManagementService.copyVersion(copyVersionOptions).execute();
      // end-copy_version
      System.out.printf("copyVersion() response status code: %d%n", response.getStatusCode());
    } catch (ServiceResponseException e) {
      logger.error(String.format("Service returned status code %s: %s%nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()), e);
    }
  
    try {
      System.out.println("getOfferingWorkingCopy() result:");
      // begin-get_offering_working_copy
      GetOfferingWorkingCopyOptions getOfferingWorkingCopyOptions = new GetOfferingWorkingCopyOptions.Builder()
          .versionLocId(versionLocatorId)
          .build();
    
      Response<Version> response = catalogManagementService.getOfferingWorkingCopy(getOfferingWorkingCopyOptions)
          .execute();
      Version version = response.getResult();
    
      System.out.println(version);
      // end-get_offering_working_copy
    } catch (ServiceResponseException e) {
      logger.error(String.format("Service returned status code %s: %s%nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()), e);
    }
  
    try {
      System.out.println("getVersion() result:");
      // begin-get_version
      GetVersionOptions getVersionOptions = new GetVersionOptions.Builder()
          .versionLocId(versionLocatorId)
          .build();
    
      Response<Offering> response = catalogManagementService.getVersion(getVersionOptions).execute();
      Offering offering = response.getResult();
    
      System.out.println(offering);
      // end-get_version
    } catch (ServiceResponseException e) {
      logger.error(String.format("Service returned status code %s: %s%nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()), e);
    }
  
    try {
      System.out.println("getCluster() result:");
      // begin-get_cluster
      GetClusterOptions getClusterOptions = new GetClusterOptions.Builder()
          .clusterId(clusterId)
          .region("us-south")
          .xAuthRefreshToken(bearerToken)
          .build();
    
      Response<ClusterInfo> response = catalogManagementService.getCluster(getClusterOptions).execute();
      ClusterInfo clusterInfo = response.getResult();
    
      System.out.println(clusterInfo);
      // end-get_cluster
    } catch (ServiceResponseException e) {
      logger.error(String.format("Service returned status code %s: %s%nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()), e);
    }
  
    try {
      System.out.println("getNamespaces() result:");
      // begin-get_namespaces
      GetNamespacesOptions getNamespacesOptions = new GetNamespacesOptions.Builder()
          .clusterId(clusterId)
          .region("us-south")
          .xAuthRefreshToken(bearerToken)
          .build();
    
      Response<NamespaceSearchResult> response = catalogManagementService.getNamespaces(getNamespacesOptions).execute();
      NamespaceSearchResult namespaceSearchResult = response.getResult();
    
      System.out.println(namespaceSearchResult);
      // end-get_namespaces
    } catch (ServiceResponseException e) {
      logger.error(String.format("Service returned status code %s: %s%nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()), e);
    }
  
    try {
      System.out.println("deployOperators() result:");
      // begin-deploy_operators
      DeployOperatorsOptions deployOperatorsOptions = new DeployOperatorsOptions.Builder()
          .clusterId(clusterId)
          .region("us-south")
          .allNamespaces(true)
          .versionLocatorId(versionLocatorId)
          .xAuthRefreshToken(bearerToken)
          .build();
    
      Response<List<OperatorDeployResult>> response = catalogManagementService.deployOperators(deployOperatorsOptions)
          .execute();
      List<OperatorDeployResult> listOperatorDeployResult = response.getResult();
    
      System.out.println(listOperatorDeployResult);
      // end-deploy_operators
    } catch (ServiceResponseException e) {
      logger.error(String.format("Service returned status code %s: %s%nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()), e);
    }
  
    try {
      System.out.println("listOperators() result:");
      // begin-list_operators
      ListOperatorsOptions listOperatorsOptions = new ListOperatorsOptions.Builder()
          .xAuthRefreshToken(bearerToken)
          .clusterId(clusterId)
          .region("us-south")
          .versionLocatorId(versionLocatorId)
          .build();
    
      Response<List<OperatorDeployResult>> response = catalogManagementService.listOperators(listOperatorsOptions)
          .execute();
      List<OperatorDeployResult> listOperatorDeployResult = response.getResult();
    
      System.out.println(listOperatorDeployResult);
      // end-list_operators
    } catch (ServiceResponseException e) {
      logger.error(String.format("Service returned status code %s: %s%nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()), e);
    }
  
    try {
      System.out.println("replaceOperators() result:");
      // begin-replace_operators
      ReplaceOperatorsOptions replaceOperatorsOptions = new ReplaceOperatorsOptions.Builder()
          .clusterId(clusterId)
          .region("us-south")
          .allNamespaces(true)
          .versionLocatorId(versionLocatorId)
          .xAuthRefreshToken(bearerToken)
          .build();
    
      Response<List<OperatorDeployResult>> response = catalogManagementService.replaceOperators(replaceOperatorsOptions)
          .execute();
      List<OperatorDeployResult> listOperatorDeployResult = response.getResult();
    
      System.out.println(listOperatorDeployResult);
      // end-replace_operators
    } catch (ServiceResponseException e) {
      logger.error(String.format("Service returned status code %s: %s%nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()), e);
    }
  
    try {
      // begin-install_version
      InstallVersionOptions installVersionOptions = new InstallVersionOptions.Builder()
          .versionLocId(versionLocatorId)
          .xAuthRefreshToken(bearerToken)
          .build();
    
      Response<Void> response = catalogManagementService.installVersion(installVersionOptions).execute();
      // end-install_version
      System.out.printf("installVersion() response status code: %d%n", response.getStatusCode());
    } catch (ServiceResponseException e) {
      logger.error(String.format("Service returned status code %s: %s%nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()), e);
    }
  
    try {
      // begin-preinstall_version
      PreinstallVersionOptions preinstallVersionOptions = new PreinstallVersionOptions.Builder()
          .versionLocId(versionLocatorId)
          .xAuthRefreshToken(bearerToken)
          .build();
    
      Response<Void> response = catalogManagementService.preinstallVersion(preinstallVersionOptions).execute();
      // end-preinstall_version
      System.out.printf("preinstallVersion() response status code: %d%n", response.getStatusCode());
    } catch (ServiceResponseException e) {
      logger.error(String.format("Service returned status code %s: %s%nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()), e);
    }
  
    try {
      System.out.println("getPreinstall() result:");
      // begin-get_preinstall
      GetPreinstallOptions getPreinstallOptions = new GetPreinstallOptions.Builder()
          .versionLocId(versionLocatorId)
          .xAuthRefreshToken(bearerToken)
          .build();
    
      Response<InstallStatus> response = catalogManagementService.getPreinstall(getPreinstallOptions).execute();
      InstallStatus installStatus = response.getResult();
    
      System.out.println(installStatus);
      // end-get_preinstall
    } catch (ServiceResponseException e) {
      logger.error(String.format("Service returned status code %s: %s%nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()), e);
    }
  
    try {
      // begin-validate_install
      ValidateInstallOptions validateInstallOptions = new ValidateInstallOptions.Builder()
          .versionLocId(versionLocatorId)
          .xAuthRefreshToken(bearerToken)
          .build();
    
      Response<Void> response = catalogManagementService.validateInstall(validateInstallOptions).execute();
      // end-validate_install
      System.out.printf("validateInstall() response status code: %d%n", response.getStatusCode());
    } catch (ServiceResponseException e) {
      logger.error(String.format("Service returned status code %s: %s%nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()), e);
    }
  
    try {
      System.out.println("getValidationStatus() result:");
      // begin-get_validation_status
      GetValidationStatusOptions getValidationStatusOptions = new GetValidationStatusOptions.Builder()
          .versionLocId(versionLocatorId)
          .xAuthRefreshToken(bearerToken)
          .build();
    
      Response<Validation> response = catalogManagementService.getValidationStatus(getValidationStatusOptions)
          .execute();
      Validation validation = response.getResult();
    
      System.out.println(validation);
      // end-get_validation_status
    } catch (ServiceResponseException e) {
      logger.error(String.format("Service returned status code %s: %s%nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()), e);
    }
  
    try {
      System.out.println("getOverrideValues() result:");
      // begin-get_override_values
      GetOverrideValuesOptions getOverrideValuesOptions = new GetOverrideValuesOptions.Builder()
          .versionLocId(versionLocatorId)
          .build();
    
      Response<Map<String, Object>> response = catalogManagementService.getOverrideValues(getOverrideValuesOptions)
          .execute();
      Map<String, Object> getOverrideValuesResponse = response.getResult();
    
      System.out.println(getOverrideValuesResponse);
      // end-get_override_values
    } catch (ServiceResponseException e) {
      logger.error(String.format("Service returned status code %s: %s%nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()), e);
    }
  
    try {
      System.out.println("searchObjects() result:");
      // begin-search_objects
      SearchObjectsOptions searchObjectsOptions = new SearchObjectsOptions.Builder()
          .query("name: object*")
          .limit(50)
          .offset(0)
          .digest(true)
          .build();
    
      Response<ObjectSearchResult> response = catalogManagementService.searchObjects(searchObjectsOptions).execute();
      ObjectSearchResult objectSearchResult = response.getResult();
    
      System.out.println(objectSearchResult);
      // end-search_objects
    } catch (ServiceResponseException e) {
      logger.error(String.format("Service returned status code %s: %s%nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()), e);
    }
  
    try {
      System.out.println("listObjects() result:");
      // begin-list_objects
      ListObjectsOptions listObjectsOptions = new ListObjectsOptions.Builder()
          .catalogIdentifier(catalogId)
          .limit(100)
          .offset(0)
          .build();
    
      Response<ObjectListResult> response = catalogManagementService.listObjects(listObjectsOptions).execute();
      ObjectListResult objectListResult = response.getResult();
    
      System.out.println(objectListResult);
      // end-list_objects
    } catch (ServiceResponseException e) {
      logger.error(String.format("Service returned status code %s: %s%nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()), e);
    }
  
    try {
      System.out.println("replaceObject() result:");
      // begin-replace_object
      ReplaceObjectOptions replaceObjectOptions = new ReplaceObjectOptions.Builder()
          .catalogIdentifier(catalogId)
          .objectIdentifier(objectId)
          .id(objectId)
          .name("updated-object-name")
          .parentId("us-south")
          .kind("vpe")
          .build();
    
      Response<CatalogObject> response = catalogManagementService.replaceObject(replaceObjectOptions).execute();
      CatalogObject catalogObject = response.getResult();
    
      System.out.println(catalogObject);
      // end-replace_object
    } catch (ServiceResponseException e) {
      logger.error(String.format("Service returned status code %s: %s%nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()), e);
    }
    
    try {
      System.out.println("getObject() result:");
      // begin-get_object
      GetObjectOptions getObjectOptions = new GetObjectOptions.Builder()
          .catalogIdentifier(catalogId)
          .objectIdentifier(objectId)
          .build();
      
      Response<CatalogObject> response = catalogManagementService.getObject(getObjectOptions).execute();
      CatalogObject catalogObject = response.getResult();
      
      System.out.println(catalogObject);
      // end-get_object
    } catch (ServiceResponseException e) {
      logger.error(String.format("Service returned status code %s: %s%nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()), e);
    }
    
    try {
      System.out.println("getObjectAudit() result:");
      // begin-get_object_audit
      GetObjectAuditOptions getObjectAuditOptions = new GetObjectAuditOptions.Builder()
          .catalogIdentifier(catalogId)
          .objectIdentifier(objectId)
          .build();
      
      Response<AuditLog> response = catalogManagementService.getObjectAudit(getObjectAuditOptions).execute();
      AuditLog auditLog = response.getResult();
      
      System.out.println(auditLog);
      // end-get_object_audit
    } catch (ServiceResponseException e) {
      logger.error(String.format("Service returned status code %s: %s%nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()), e);
    }
    
    try {
      // begin-account_publish_object
      AccountPublishObjectOptions accountPublishObjectOptions = new AccountPublishObjectOptions.Builder()
          .catalogIdentifier(catalogId)
          .objectIdentifier(objectId)
          .build();
    
      Response<Void> response = catalogManagementService.accountPublishObject(accountPublishObjectOptions).execute();
      // end-account_publish_object
      System.out.printf("accountPublishObject() response status code: %d%n", response.getStatusCode());
    } catch (ServiceResponseException e) {
      logger.error(String.format("Service returned status code %s: %s%nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()), e);
    }
  
    try {
      // begin-shared_publish_object
      SharedPublishObjectOptions sharedPublishObjectOptions = new SharedPublishObjectOptions.Builder()
          .catalogIdentifier(catalogId)
          .objectIdentifier(objectId)
          .build();
    
      Response<Void> response = catalogManagementService.sharedPublishObject(sharedPublishObjectOptions).execute();
      // end-shared_publish_object
      System.out.printf("sharedPublishObject() response status code: %d%n", response.getStatusCode());
    } catch (ServiceResponseException e) {
      logger.error(String.format("Service returned status code %s: %s%nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()), e);
    }
  
    try {
      // begin-ibm_publish_object
      IbmPublishObjectOptions ibmPublishObjectOptions = new IbmPublishObjectOptions.Builder()
          .catalogIdentifier(catalogId)
          .objectIdentifier(objectId)
          .build();
    
      Response<Void> response = catalogManagementService.ibmPublishObject(ibmPublishObjectOptions).execute();
      // end-ibm_publish_object
      System.out.printf("ibmPublishObject() response status code: %d%n", response.getStatusCode());
    } catch (ServiceResponseException e) {
      logger.error(String.format("Service returned status code %s: %s%nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()), e);
    }
  
    try {
      // begin-public_publish_object
      PublicPublishObjectOptions publicPublishObjectOptions = new PublicPublishObjectOptions.Builder()
          .catalogIdentifier(catalogId)
          .objectIdentifier(objectId)
          .build();
    
      Response<Void> response = catalogManagementService.publicPublishObject(publicPublishObjectOptions).execute();
      // end-public_publish_object
      System.out.printf("publicPublishObject() response status code: %d%n", response.getStatusCode());
    } catch (ServiceResponseException e) {
      logger.error(String.format("Service returned status code %s: %s%nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()), e);
    }
  
    try {
      // begin-create_object_access
      CreateObjectAccessOptions createObjectAccessOptions = new CreateObjectAccessOptions.Builder()
          .catalogIdentifier(catalogId)
          .objectIdentifier(objectId)
          .accountIdentifier(accountId)
          .build();
    
      Response<Void> response = catalogManagementService.createObjectAccess(createObjectAccessOptions).execute();
      // end-create_object_access
      System.out.printf("createObjectAccess() response status code: %d%n", response.getStatusCode());
    } catch (ServiceResponseException e) {
      logger.error(String.format("Service returned status code %s: %s%nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()), e);
    }
  
    try {
      System.out.println("getObjectAccess() result:");
      // begin-get_object_access
      GetObjectAccessOptions getObjectAccessOptions = new GetObjectAccessOptions.Builder()
          .catalogIdentifier(catalogId)
          .objectIdentifier(objectId)
          .accountIdentifier(accountId)
          .build();
    
      Response<ObjectAccess> response = catalogManagementService.getObjectAccess(getObjectAccessOptions).execute();
      ObjectAccess objectAccess = response.getResult();
    
      System.out.println(objectAccess);
      // end-get_object_access
    } catch (ServiceResponseException e) {
      logger.error(String.format("Service returned status code %s: %s%nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()), e);
    }
  
    try {
      System.out.println("addObjectAccessList() result:");
      // begin-add_object_access_list
      AddObjectAccessListOptions addObjectAccessListOptions = new AddObjectAccessListOptions.Builder()
          .catalogIdentifier(catalogId)
          .objectIdentifier(objectId)
          .addAccounts(accountId)
          .build();
    
      Response<AccessListBulkResponse> response =
          catalogManagementService.addObjectAccessList(addObjectAccessListOptions)
              .execute();
      AccessListBulkResponse accessListBulkResponse = response.getResult();
    
      System.out.println(accessListBulkResponse);
      // end-add_object_access_list
    } catch (ServiceResponseException e) {
      logger.error(String.format("Service returned status code %s: %s%nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()), e);
    }
    
    try {
      System.out.println("getObjectAccessList() result:");
      // begin-get_object_access_list
      GetObjectAccessListOptions getObjectAccessListOptions = new GetObjectAccessListOptions.Builder()
          .catalogIdentifier(catalogId)
          .objectIdentifier(objectId)
          .build();
    
      Response<ObjectAccessListResult> response =
          catalogManagementService.getObjectAccessList(getObjectAccessListOptions)
              .execute();
      ObjectAccessListResult objectAccessListResult = response.getResult();
    
      System.out.println(objectAccessListResult);
      // end-get_object_access_list
    } catch (ServiceResponseException e) {
      logger.error(String.format("Service returned status code %s: %s%nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()), e);
    }
  
    try {
      System.out.println("createOfferingInstance() result:");
      // begin-create_offering_instance
      CreateOfferingInstanceOptions createOfferingInstanceOptions = new CreateOfferingInstanceOptions.Builder()
          .xAuthRefreshToken(bearerToken)
          .id(offeringId)
          .catalogId(catalogId)
          .offeringId(offeringId)
          .kindFormat("roks")
          .version("0.0.2")
          .clusterId(clusterId)
          .clusterRegion("us-south")
          .clusterAllNamespaces(true)
          .build();
    
      Response<OfferingInstance> response =
          catalogManagementService.createOfferingInstance(createOfferingInstanceOptions)
              .execute();
      OfferingInstance offeringInstance = response.getResult();
    
      System.out.println(offeringInstance);
      // end-create_offering_instance
      offeringInstanceId = offeringInstance.id();
    } catch (ServiceResponseException e) {
      logger.error(String.format("Service returned status code %s: %s%nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()), e);
    }
  
    try {
      System.out.println("getOfferingInstance() result:");
      // begin-get_offering_instance
      GetOfferingInstanceOptions getOfferingInstanceOptions = new GetOfferingInstanceOptions.Builder()
          .instanceIdentifier(offeringInstanceId)
          .build();
    
      Response<OfferingInstance> response = catalogManagementService.getOfferingInstance(getOfferingInstanceOptions)
          .execute();
      OfferingInstance offeringInstance = response.getResult();
    
      System.out.println(offeringInstance);
      // end-get_offering_instance
    } catch (ServiceResponseException e) {
      logger.error(String.format("Service returned status code %s: %s%nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()), e);
    }
  
    try {
      System.out.println("putOfferingInstance() result:");
      // begin-put_offering_instance
      PutOfferingInstanceOptions putOfferingInstanceOptions = new PutOfferingInstanceOptions.Builder()
          .xAuthRefreshToken(bearerToken)
          .id(offeringId)
          .catalogId(catalogId)
          .offeringId(offeringId)
          .kindFormat("roks")
          .version("0.0.2")
          .clusterId(clusterId)
          .clusterRegion("us-south")
          .clusterAllNamespaces(true)
          .label("vnext")
          .build();
    
      Response<OfferingInstance> response = catalogManagementService.putOfferingInstance(putOfferingInstanceOptions)
          .execute();
      OfferingInstance offeringInstance = response.getResult();
    
      System.out.println(offeringInstance);
      // end-put_offering_instance
    } catch (ServiceResponseException e) {
      logger.error(String.format("Service returned status code %s: %s%nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()), e);
    }
  
    try {
      // begin-delete_version
      DeleteVersionOptions deleteVersionOptions = new DeleteVersionOptions.Builder()
          .versionLocId(versionLocatorId)
          .build();
    
      Response<Void> response = catalogManagementService.deleteVersion(deleteVersionOptions).execute();
      // end-delete_version
      System.out.printf("deleteVersion() response status code: %d%n", response.getStatusCode());
    } catch (ServiceResponseException e) {
      logger.error(String.format("Service returned status code %s: %s%nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()), e);
    }
  
    try {
      // begin-delete_operators
      DeleteOperatorsOptions deleteOperatorsOptions = new DeleteOperatorsOptions.Builder()
          .xAuthRefreshToken(versionLocatorId)
          .clusterId(clusterId)
          .region("us-south")
          .versionLocatorId(versionLocatorId)
          .build();
    
      Response<Void> response = catalogManagementService.deleteOperators(deleteOperatorsOptions).execute();
      // end-delete_operators
      System.out.printf("deleteOperators() response status code: %d%n", response.getStatusCode());
    } catch (ServiceResponseException e) {
      logger.error(String.format("Service returned status code %s: %s%nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()), e);
    }
  
    try {
      // begin-delete_offering_instance
      DeleteOfferingInstanceOptions deleteOfferingInstanceOptions = new DeleteOfferingInstanceOptions.Builder()
          .instanceIdentifier(offeringInstanceId)
          .xAuthRefreshToken(bearerToken)
          .build();
    
      Response<Void> response = catalogManagementService.deleteOfferingInstance(deleteOfferingInstanceOptions)
          .execute();
      // end-delete_offering_instance
      System.out.printf("deleteOfferingInstance() response status code: %d%n", response.getStatusCode());
    } catch (ServiceResponseException e) {
      logger.error(String.format("Service returned status code %s: %s%nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()), e);
    }
  
    try {
      System.out.println("deleteObjectAccessList() result:");
      // begin-delete_object_access_list
      DeleteObjectAccessListOptions deleteObjectAccessListOptions = new DeleteObjectAccessListOptions.Builder()
          .catalogIdentifier(catalogId)
          .objectIdentifier(objectId)
          .addAccounts(accountId)
          .build();
    
      Response<AccessListBulkResponse> response =
          catalogManagementService.deleteObjectAccessList(deleteObjectAccessListOptions)
              .execute();
      AccessListBulkResponse accessListBulkResponse = response.getResult();
    
      System.out.println(accessListBulkResponse);
      // end-delete_object_access_list
    } catch (ServiceResponseException e) {
      logger.error(String.format("Service returned status code %s: %s%nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()), e);
    }
  
    try {
      // begin-delete_object_access
      DeleteObjectAccessOptions deleteObjectAccessOptions = new DeleteObjectAccessOptions.Builder()
          .catalogIdentifier(catalogId)
          .objectIdentifier(objectId)
          .accountIdentifier(accountId)
          .build();
    
      Response<Void> response = catalogManagementService.deleteObjectAccess(deleteObjectAccessOptions).execute();
      // end-delete_object_access
      System.out.printf("deleteObjectAccess() response status code: %d%n", response.getStatusCode());
    } catch (ServiceResponseException e) {
      logger.error(String.format("Service returned status code %s: %s%nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()), e);
    }
  
    try {
      // begin-delete_object
      DeleteObjectOptions deleteObjectOptions = new DeleteObjectOptions.Builder()
          .catalogIdentifier(catalogId)
          .objectIdentifier(objectId)
          .build();
    
      Response<Void> response = catalogManagementService.deleteObject(deleteObjectOptions).execute();
      // end-delete_object
      System.out.printf("deleteObject() response status code: %d%n", response.getStatusCode());
    } catch (ServiceResponseException e) {
      logger.error(String.format("Service returned status code %s: %s%nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()), e);
    }
    
    try {
      // begin-delete_offering
      DeleteOfferingOptions deleteOfferingOptions = new DeleteOfferingOptions.Builder()
          .catalogIdentifier(catalogId)
          .offeringId(offeringId)
          .build();
      
      Response<Void> response = catalogManagementService.deleteOffering(deleteOfferingOptions).execute();
      // end-delete_offering
      System.out.printf("deleteOffering() response status code: %d%n", response.getStatusCode());
    } catch (ServiceResponseException e) {
      logger.error(String.format("Service returned status code %s: %s%nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()), e);
    }
    
    try {
      // begin-delete_catalog
      DeleteCatalogOptions deleteCatalogOptions = new DeleteCatalogOptions.Builder()
          .catalogIdentifier(catalogId)
          .build();
      
      Response<Void> response = catalogManagementService.deleteCatalog(deleteCatalogOptions).execute();
      // end-delete_catalog
      System.out.printf("deleteCatalog() response status code: %d%n", response.getStatusCode());
    } catch (ServiceResponseException e) {
      logger.error(String.format("Service returned status code %s: %s%nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()), e);
    }
    
  }
  
}
