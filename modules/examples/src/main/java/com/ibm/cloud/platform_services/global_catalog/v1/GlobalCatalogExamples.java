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

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import org.apache.commons.io.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

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
import com.ibm.cloud.platform_services.global_catalog.v1.model.GetVisibilityOptions;
import com.ibm.cloud.platform_services.global_catalog.v1.model.Image;
import com.ibm.cloud.platform_services.global_catalog.v1.model.ListArtifactsOptions;
import com.ibm.cloud.platform_services.global_catalog.v1.model.ListCatalogEntriesOptions;
import com.ibm.cloud.platform_services.global_catalog.v1.model.ObjectMetadataSet;
import com.ibm.cloud.platform_services.global_catalog.v1.model.Overview;
import com.ibm.cloud.platform_services.global_catalog.v1.model.Provider;
import com.ibm.cloud.platform_services.global_catalog.v1.model.RestoreCatalogEntryOptions;
import com.ibm.cloud.platform_services.global_catalog.v1.model.UpdateCatalogEntryOptions;
import com.ibm.cloud.platform_services.global_catalog.v1.model.UpdateVisibilityOptions;
import com.ibm.cloud.platform_services.global_catalog.v1.model.UploadArtifactOptions;
import com.ibm.cloud.platform_services.global_catalog.v1.model.Visibility;
import com.ibm.cloud.sdk.core.http.Response;
import com.ibm.cloud.sdk.core.service.exception.ServiceResponseException;

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
        CatalogEntry fetchedObject = null;

        try {
            System.out.println("createCatalogEntry() result:");

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

            System.out.println(catalogEntry);

            // end-create_catalog_entry

        } catch (ServiceResponseException e) {
            logger.error(String.format("Service returned status code %s: %s\nError details: %s", e.getStatusCode(),
                    e.getMessage(), e.getDebuggingInfo()), e);
        }

        try {
            System.out.println("getCatalogEntry() result:");

            // begin-get_catalog_entry

            GetCatalogEntryOptions getCatalogEntryOptions = new GetCatalogEntryOptions.Builder()
                    .id(catalogEntryId)
                    .complete(true)
                    .build();

            Response<CatalogEntry> response = service.getCatalogEntry(getCatalogEntryOptions).execute();
            CatalogEntry catalogEntry = response.getResult();
            fetchedObject = catalogEntry;

            System.out.println(catalogEntry);

            // end-get_catalog_entry

        } catch (ServiceResponseException e) {
            logger.error(String.format("Service returned status code %s: %s\nError details: %s", e.getStatusCode(),
                    e.getMessage(), e.getDebuggingInfo()), e);
        }

        try {
            System.out.println("updateCatalogEntry() result:");

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
                    .url(fetchedObject.getUrl())
                    .build();

            Response<CatalogEntry> response = service.updateCatalogEntry(updateCatalogEntryOptions).execute();
            CatalogEntry catalogEntry = response.getResult();

            System.out.println(catalogEntry);

            // end-update_catalog_entry

        } catch (ServiceResponseException e) {
            logger.error(String.format("Service returned status code %s: %s\nError details: %s", e.getStatusCode(),
                    e.getMessage(), e.getDebuggingInfo()), e);
        }

        try {
            System.out.println("listCatalogEntries() result:");

            // begin-list_catalog_entries

            ListCatalogEntriesOptions listCatalogEntriesOptions = new ListCatalogEntriesOptions.Builder()
                    .offset(0)
                    .limit(10)
                    .q("kind:template tag:example-tag-1")
                    .complete(true)
                    .build();

            Response<EntrySearchResult> response = service.listCatalogEntries(listCatalogEntriesOptions).execute();
            EntrySearchResult entrySearchResult = response.getResult();

            System.out.println(entrySearchResult);

            // end-list_catalog_entries

        } catch (ServiceResponseException e) {
            logger.error(String.format("Service returned status code %s: %s\nError details: %s", e.getStatusCode(),
                    e.getMessage(), e.getDebuggingInfo()), e);
        }

        try {
            System.out.println("getChildObjects() result:");

            // begin-get_child_objects

            GetChildObjectsOptions getChildObjectsOptions = new GetChildObjectsOptions.Builder()
                    .id(catalogEntryId)
                    .kind("*")
                    .build();

            Response<EntrySearchResult> response = service.getChildObjects(getChildObjectsOptions).execute();
            EntrySearchResult entrySearchResult = response.getResult();

            System.out.println(entrySearchResult);

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

            Response<Void> response = service.restoreCatalogEntry(restoreCatalogEntryOptions).execute();

            // end-restore_catalog_entry

            System.out.printf("restoreCatalogEntry() response status code: %d%n", response.getStatusCode());
        } catch (ServiceResponseException e) {
            logger.error(String.format("Service returned status code %s: %s\nError details: %s", e.getStatusCode(),
                    e.getMessage(), e.getDebuggingInfo()), e);
        }

        try {
            System.out.println("getVisibility() result:");

            // begin-get_visibility

            GetVisibilityOptions getVisibilityOptions = new GetVisibilityOptions.Builder()
                    .id(catalogEntryId)
                    .build();

            Response<Visibility> response = service.getVisibility(getVisibilityOptions).execute();
            Visibility visibility = response.getResult();

            System.out.println(visibility);

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

            Response<Void> response = service.updateVisibility(updateVisibilityOptions).execute();

            // end-update_visibility

            System.out.printf("updateVisibility() response status code: %d%n", response.getStatusCode());
        } catch (ServiceResponseException e) {
            System.out.println("updateVisibility returned the following error: " + e.getMessage());
        }

        try {
            System.out.println("getAuditLogs() result:");

            // begin-get_audit_logs

            GetAuditLogsOptions getAuditLogsOptions = new GetAuditLogsOptions.Builder()
                    .id(catalogEntryId)
                    .offset(0)
                    .limit(10)
                    .build();

            Response<AuditSearchResult> response = service.getAuditLogs(getAuditLogsOptions).execute();
            AuditSearchResult auditSearchResult = response.getResult();

            System.out.println(auditSearchResult);

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

            Response<Void> response = service.uploadArtifact(uploadArtifactOptions).execute();

            // end-upload_artifact

            System.out.printf("uploadArtifact() response status code: %d%n", response.getStatusCode());
        } catch (ServiceResponseException e) {
            logger.error(String.format("Service returned status code %s: %s\nError details: %s", e.getStatusCode(),
                    e.getMessage(), e.getDebuggingInfo()), e);
        }

        try {
            System.out.println("getArtifact() result:");

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
                System.out.println(artifactContents);
            }

            // end-get_artifact

        } catch (ServiceResponseException e) {
            logger.error(String.format("Service returned status code %s: %s\nError details: %s", e.getStatusCode(),
                    e.getMessage(), e.getDebuggingInfo()), e);
        }

        try {
            System.out.println("listArtifacts() result:");

            // begin-list_artifacts

            ListArtifactsOptions listArtifactsOptions = new ListArtifactsOptions.Builder()
                    .objectId(catalogEntryId)
                    .build();

            Response<Artifacts> response = service.listArtifacts(listArtifactsOptions).execute();
            Artifacts artifacts = response.getResult();

            System.out.println(artifacts);

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

            Response<Void> response = service.deleteArtifact(deleteArtifactOptions).execute();

            // end-delete_artifact

            System.out.printf("deleteArtifact() response status code: %d%n", response.getStatusCode());
        } catch (ServiceResponseException e) {
            logger.error(String.format("Service returned status code %s: %s\nError details: %s", e.getStatusCode(),
                    e.getMessage(), e.getDebuggingInfo()), e);
        }

        try {

            // begin-delete_catalog_entry

            DeleteCatalogEntryOptions deleteCatalogEntryOptions = new DeleteCatalogEntryOptions.Builder()
                    .id(catalogEntryId)
                    .build();

            Response<Void> response = service.deleteCatalogEntry(deleteCatalogEntryOptions).execute();

            // end-delete_catalog_entry

            System.out.printf("deleteCatalogEntry() response status code: %d%n", response.getStatusCode());
        } catch (ServiceResponseException e) {
            logger.error(String.format("Service returned status code %s: %s\nError details: %s", e.getStatusCode(),
                    e.getMessage(), e.getDebuggingInfo()), e);
        }
    }
}
