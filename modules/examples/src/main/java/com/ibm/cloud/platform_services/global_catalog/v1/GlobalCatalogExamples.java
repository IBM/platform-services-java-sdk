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

package com.ibm.cloud.platform_services.global_catalog.v1;

import com.ibm.cloud.platform_services.global_catalog.v1.model.Artifacts;
import com.ibm.cloud.platform_services.global_catalog.v1.model.AuditSearchResult;
import com.ibm.cloud.platform_services.global_catalog.v1.model.CatalogEntry;
import com.ibm.cloud.platform_services.global_catalog.v1.model.CreateCatalogEntryOptions;
import com.ibm.cloud.platform_services.global_catalog.v1.model.DeleteArtifactOptions;
import com.ibm.cloud.platform_services.global_catalog.v1.model.DeleteCatalogEntryOptions;
import com.ibm.cloud.platform_services.global_catalog.v1.model.EntrySearchResult;
import com.ibm.cloud.platform_services.global_catalog.v1.model.GetArtifactOptions;
import com.ibm.cloud.platform_services.global_catalog.v1.model.GetAuditLogsOptions;
import com.ibm.cloud.platform_services.global_catalog.v1.model.GetCatalogEntryOptions;
import com.ibm.cloud.platform_services.global_catalog.v1.model.GetChildObjectsOptions;
import com.ibm.cloud.platform_services.global_catalog.v1.model.GetPricingOptions;
import com.ibm.cloud.platform_services.global_catalog.v1.model.GetVisibilityOptions;
import com.ibm.cloud.platform_services.global_catalog.v1.model.Image;
import com.ibm.cloud.platform_services.global_catalog.v1.model.ListArtifactsOptions;
import com.ibm.cloud.platform_services.global_catalog.v1.model.ListCatalogEntriesOptions;
import com.ibm.cloud.platform_services.global_catalog.v1.model.ObjectMetadataSet;
import com.ibm.cloud.platform_services.global_catalog.v1.model.Overview;
import com.ibm.cloud.platform_services.global_catalog.v1.model.PricingGet;
import com.ibm.cloud.platform_services.global_catalog.v1.model.Provider;
import com.ibm.cloud.platform_services.global_catalog.v1.model.RestoreCatalogEntryOptions;
import com.ibm.cloud.platform_services.global_catalog.v1.model.UpdateCatalogEntryOptions;
import com.ibm.cloud.platform_services.global_catalog.v1.model.UpdateVisibilityOptions;
import com.ibm.cloud.platform_services.global_catalog.v1.model.UploadArtifactOptions;
import com.ibm.cloud.platform_services.global_catalog.v1.model.Visibility;
import com.ibm.cloud.sdk.core.http.Response;
import com.ibm.cloud.sdk.core.service.exception.ServiceResponseException;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import org.apache.commons.io.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

//
// This file provides an example of how to use the Global Catalog service.
//
// The following configuration properties are assumed to be defined:
//
// GLOBAL_CATALOG_URL=<service url>
// GLOBAL_CATALOG_AUTH_TYPE=iam
// GLOBAL_CATALOG_APIKEY=<IAM apikey>
// GLOBAL_CATALOG_AUTH_URL=<IAM token service URL - omit this if using the production environment>
//
// These configuration properties can be exported as environment variables, or stored
// in a configuration file and then:
// export IBM_CREDENTIALS_FILE=<name of configuration file>
//
public class GlobalCatalogExamples {
    private static final Logger logger = LoggerFactory.getLogger(GlobalCatalogExamples.class);

    static {
        System.setProperty("IBM_CREDENTIALS_FILE", "../../global_catalog.env");
    }

    protected GlobalCatalogExamples() {
    }

    public static void main(String[] args) throws Exception {
        GlobalCatalog service = GlobalCatalog.newInstance();

        String catalogEntryId = "";

        try {
            // begin-create_catalog_entry
            Overview overviewModelEN = new Overview.Builder()
                    .displayName("Example Web Starter")
                    .description("Use the Example service in your applications")
                    .longDescription("This is a starter that helps you use the Example service within your applications.")
                    .build();
            Map<String, Overview> overviewUI = new HashMap<>();
            overviewUI.put("en", overviewModelEN);

            Image imageModel = new Image.Builder()
                    .image("https://somehost.com/examplewebstarter/cachedIcon/large/0")
                    .smallImage("https://somehost.com/examplewebstarter/cachedIcon/small/0")
                    .mediumImage("https://somehost.com/examplewebstarter/cachedIcon/medium/0")
                    .featureImage("https://somehost.com/examplewebstarter/cachedIcon/large/0")
                    .build();

            Provider providerModel = new Provider.Builder()
                    .email("info@examplestarter.com")
                    .name("Example Starter Co., Inc.")
                    .contact("Example Starter Developer Relations")
                    .supportEmail("support@examplestarter.com")
                    .phone("800-555-1234")
                    .build();

            ObjectMetadataSet metadataModel = new ObjectMetadataSet.Builder()
                    .version("1.0.0")
                    .build();

            catalogEntryId = UUID.randomUUID().toString();

            CreateCatalogEntryOptions createCatalogEntryOptions = new CreateCatalogEntryOptions.Builder()
                    .name("exampleWebStarter123")
                    .kind(CreateCatalogEntryOptions.Kind.TEMPLATE)
                    .overviewUi(overviewUI)
                    .images(imageModel)
                    .disabled(false)
                    .addTags("example-tag-1")
                    .addTags("example-tag-2")
                    .provider(providerModel)
                    .id(catalogEntryId)
                    .active(true)
                    .metadata(metadataModel)
                    .build();

            Response<CatalogEntry> response = service.createCatalogEntry(createCatalogEntryOptions).execute();
            CatalogEntry catalogEntry = response.getResult();

            System.out.printf("createCatalogEntry() result: %n %s %n", catalogEntry.toString());
            // end-create_catalog_entry
        } catch (ServiceResponseException e) {
            logger.error(String.format("Service returned status code %s: %s\nError details: %s", e.getStatusCode(),
                    e.getMessage(), e.getDebuggingInfo()), e);
        }

        try {
            // begin-get_catalog_entry
            GetCatalogEntryOptions getCatalogEntryOptions = new GetCatalogEntryOptions.Builder()
                    .id(catalogEntryId)
                    .complete(true)
                    .build();

            Response<CatalogEntry> response = service.getCatalogEntry(getCatalogEntryOptions).execute();
            CatalogEntry catalogEntry = response.getResult();

            System.out.printf("getCatalogEntry() result: %n %s %n", catalogEntry);
            // end-get_catalog_entry
        } catch (ServiceResponseException e) {
            logger.error(String.format("Service returned status code %s: %s\nError details: %s", e.getStatusCode(),
                    e.getMessage(), e.getDebuggingInfo()), e);
        }

        try {
            // begin-update_catalog_entry
            Overview overviewModelEN = new Overview.Builder()
                    .displayName("Example Web Starter V2")
                    .description("Use the Example V2 service in your applications")
                    .longDescription("This is a starter that helps you use the Example V2 service within your applications.")
                    .build();
            Map<String, Overview> overviewUI = new HashMap<>();
            overviewUI.put("en", overviewModelEN);

            Image imageModel = new Image.Builder()
                    .image("https://somehost.com/examplewebstarter/cachedIcon/large/0")
                    .smallImage("https://somehost.com/examplewebstarter/cachedIcon/small/0")
                    .mediumImage("https://somehost.com/examplewebstarter/cachedIcon/medium/0")
                    .featureImage("https://somehost.com/examplewebstarter/cachedIcon/large/0")
                    .build();

            Provider providerModel = new Provider.Builder()
                    .email("info@examplestarter.com")
                    .name("Example Starter Co., Inc.")
                    .contact("Example Starter Developer Relations")
                    .supportEmail("support@examplestarter.com")
                    .phone("800-555-1234")
                    .build();

            ObjectMetadataSet metadataModel = new ObjectMetadataSet.Builder()
                    .version("2.0.0")
                    .build();

            UpdateCatalogEntryOptions updateCatalogEntryOptions = new UpdateCatalogEntryOptions.Builder()
                    .id(catalogEntryId)
                    .name("exampleWebStarter123")
                    .kind(UpdateCatalogEntryOptions.Kind.TEMPLATE)
                    .overviewUi(overviewUI)
                    .images(imageModel)
                    .disabled(false)
                    .addTags("example-tag-1")
                    .addTags("example-tag-2")
                    .addTags("new-example-tag-3")
                    .provider(providerModel)
                    .active(true)
                    .metadata(metadataModel)
                    .build();

            Response<CatalogEntry> response = service.updateCatalogEntry(updateCatalogEntryOptions).execute();
            CatalogEntry catalogEntry = response.getResult();

            System.out.printf("updateCatalogEntry() result: %n %s %n", catalogEntry.toString());
            // end-update_catalog_entry
        } catch (ServiceResponseException e) {
            logger.error(String.format("Service returned status code %s: %s\nError details: %s", e.getStatusCode(),
                    e.getMessage(), e.getDebuggingInfo()), e);
        }

        try {
            // begin-list_catalog_entries
            ListCatalogEntriesOptions listCatalogEntriesOptions = new ListCatalogEntriesOptions.Builder()
                    .offset(0)
                    .limit(10)
                    .q("kind:template tag:example-tag-1")
                    .complete(true)
                    .build();

            Response<EntrySearchResult> response = service.listCatalogEntries(listCatalogEntriesOptions).execute();
            EntrySearchResult entrySearchResult = response.getResult();

            System.out.printf("listCatalogEntries() result: %n %s %n", entrySearchResult.toString());
            // end-list_catalog_entries
        } catch (ServiceResponseException e) {
            logger.error(String.format("Service returned status code %s: %s\nError details: %s", e.getStatusCode(),
                    e.getMessage(), e.getDebuggingInfo()), e);
        }

        try {
            // begin-get_child_objects
            GetChildObjectsOptions getChildObjectsOptions = new GetChildObjectsOptions.Builder()
                    .id(catalogEntryId)
                    .kind("*")
                    .build();

            Response<EntrySearchResult> response = service.getChildObjects(getChildObjectsOptions).execute();
            EntrySearchResult entrySearchResult = response.getResult();

            System.out.printf("getChildObjects() result: %n %s %n", entrySearchResult.toString());
            // end-get_child_objects
        } catch (ServiceResponseException e) {
            logger.error(String.format("Service returned status code %s: %s\nError details: %s", e.getStatusCode(),
                    e.getMessage(), e.getDebuggingInfo()), e);
        }

        try {
            // begin-restore_catalog_entry
            RestoreCatalogEntryOptions restoreCatalogEntryOptions = new RestoreCatalogEntryOptions.Builder()
                    .id(catalogEntryId)
                    .build();

            service.restoreCatalogEntry(restoreCatalogEntryOptions).execute();
            System.out.println("restoreCatalogEntry() is executed successfully.");
            // end-restore_catalog_entry
        } catch (ServiceResponseException e) {
            logger.error(String.format("Service returned status code %s: %s\nError details: %s", e.getStatusCode(),
                    e.getMessage(), e.getDebuggingInfo()), e);
        }

        try {
            // begin-get_visibility
            GetVisibilityOptions getVisibilityOptions = new GetVisibilityOptions.Builder()
                    .id(catalogEntryId)
                    .build();

            Response<Visibility> response = service.getVisibility(getVisibilityOptions).execute();
            Visibility visibility = response.getResult();

            System.out.printf("getVisibility() result: %n %s %n", visibility.toString());
            // end-get_visibility
        } catch (ServiceResponseException e) {
            logger.error(String.format("Service returned status code %s: %s\nError details: %s", e.getStatusCode(),
                    e.getMessage(), e.getDebuggingInfo()), e);
        }

        try {
            // begin-update_visibility
            UpdateVisibilityOptions updateVisibilityOptions = new UpdateVisibilityOptions.Builder()
                    .id(catalogEntryId)
                    .extendable(false)
                    .build();

            service.updateVisibility(updateVisibilityOptions).execute();
            System.out.println("updateVisibility() is executed successfully.");
            // end-update_visibility
        } catch (ServiceResponseException e) {
            System.out.println("updateVisibility returned the following error: " + e.getMessage());
        }

        try {
            // begin-get_pricing
            GetPricingOptions getPricingOptions = new GetPricingOptions.Builder()
                    .id(catalogEntryId).build();

            Response<PricingGet> response = service.getPricing(getPricingOptions).execute();
            PricingGet pricingGet = response.getResult();

            System.out.printf("getPricing() result: %n %s %n", pricingGet.toString());
            // end-get_pricing
        } catch (ServiceResponseException e) {
            logger.error(String.format("Service returned status code %s: %s\nError details: %s", e.getStatusCode(),
                    e.getMessage(), e.getDebuggingInfo()), e);
        }

        try {
            // begin-get_audit_logs
            GetAuditLogsOptions getAuditLogsOptions = new GetAuditLogsOptions.Builder()
                    .id(catalogEntryId)
                    .offset(0)
                    .limit(10)
                    .build();

            Response<AuditSearchResult> response = service.getAuditLogs(getAuditLogsOptions).execute();
            AuditSearchResult auditSearchResult = response.getResult();

            System.out.printf("getAuditLogs() result: %n %s %n", auditSearchResult.toString());
            // end-get_audit_logs
        } catch (ServiceResponseException e) {
            logger.error(String.format("Service returned status code %s: %s\nError details: %s", e.getStatusCode(),
                    e.getMessage(), e.getDebuggingInfo()), e);
        }

        try {
            // begin-upload_artifact
            String artifactContents = "This is an example artifact associated with a catalog entry.";

            UploadArtifactOptions uploadArtifactOptions = new UploadArtifactOptions.Builder()
                    .objectId(catalogEntryId)
                    .artifactId("artifact.txt")
                    .artifact(new ByteArrayInputStream(artifactContents.getBytes(StandardCharsets.UTF_8)))
                    .contentType("text/plain")
                    .build();

            service.uploadArtifact(uploadArtifactOptions).execute();
            System.out.println("uploadArtifact() is executed successfully.");
            // end-upload_artifact
        } catch (ServiceResponseException e) {
            logger.error(String.format("Service returned status code %s: %s\nError details: %s", e.getStatusCode(),
                    e.getMessage(), e.getDebuggingInfo()), e);
        }

        try {
            // begin-get_artifact
            GetArtifactOptions getArtifactOptions = new GetArtifactOptions.Builder()
                    .objectId(catalogEntryId)
                    .artifactId("artifact.txt")
                    .build();

            Response<InputStream> response = service.getArtifact(getArtifactOptions).execute();
            InputStream inputStream = response.getResult();
            if (inputStream != null) {
                String artifactContents = IOUtils.toString(inputStream, StandardCharsets.UTF_8);
                inputStream.close();
                System.out.printf("getArtifact(): Artifact content-type: %n %s %n",
                        response.getHeaders().values("Content-Type").toString());
                System.out.printf("getArtifact(): Artifact contents: %n %s %n", artifactContents);
            }
            // end-get_artifact
        } catch (ServiceResponseException e) {
            logger.error(String.format("Service returned status code %s: %s\nError details: %s", e.getStatusCode(),
                    e.getMessage(), e.getDebuggingInfo()), e);
        }

        try {
            // begin-list_artifacts
            ListArtifactsOptions listArtifactsOptions = new ListArtifactsOptions.Builder()
                    .objectId(catalogEntryId)
                    .build();

            Response<Artifacts> response = service.listArtifacts(listArtifactsOptions).execute();
            Artifacts artifacts = response.getResult();

            System.out.printf("listArtifacts() result: %n %s %n", artifacts.toString());
            // end-list_artifacts
        } catch (ServiceResponseException e) {
            logger.error(String.format("Service returned status code %s: %s\nError details: %s", e.getStatusCode(),
                    e.getMessage(), e.getDebuggingInfo()), e);
        }

        try {
            // begin-delete_artifact
            DeleteArtifactOptions deleteArtifactOptions = new DeleteArtifactOptions.Builder()
                    .objectId(catalogEntryId)
                    .artifactId("artifact.txt")
                    .build();

            service.deleteArtifact(deleteArtifactOptions).execute();
            System.out.println("deleteArtifact() is executed successfully.");
            // end-delete_artifact
        } catch (ServiceResponseException e) {
            logger.error(String.format("Service returned status code %s: %s\nError details: %s", e.getStatusCode(),
                    e.getMessage(), e.getDebuggingInfo()), e);
        }

        try {
            // begin-delete_catalog_entry
            DeleteCatalogEntryOptions deleteCatalogEntryOptions = new DeleteCatalogEntryOptions.Builder()
                    .id(catalogEntryId)
                    .build();

            service.deleteCatalogEntry(deleteCatalogEntryOptions).execute();
            System.out.println("deleteCatalogEntry() is executed successfully.");
            // end-delete_catalog_entry
        } catch (ServiceResponseException e) {
            logger.error(String.format("Service returned status code %s: %s\nError details: %s", e.getStatusCode(),
                    e.getMessage(), e.getDebuggingInfo()), e);
        }
    }
}
