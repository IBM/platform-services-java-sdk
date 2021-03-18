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

package com.ibm.cloud.platform_services.resource_manager.v2;

import com.ibm.cloud.platform_services.resource_manager.v2.model.CreateResourceGroupOptions;
import com.ibm.cloud.platform_services.resource_manager.v2.model.DeleteResourceGroupOptions;
import com.ibm.cloud.platform_services.resource_manager.v2.model.GetQuotaDefinitionOptions;
import com.ibm.cloud.platform_services.resource_manager.v2.model.GetResourceGroupOptions;
import com.ibm.cloud.platform_services.resource_manager.v2.model.ListQuotaDefinitionsOptions;
import com.ibm.cloud.platform_services.resource_manager.v2.model.ListResourceGroupsOptions;
import com.ibm.cloud.platform_services.resource_manager.v2.model.QuotaDefinition;
import com.ibm.cloud.platform_services.resource_manager.v2.model.QuotaDefinitionList;
import com.ibm.cloud.platform_services.resource_manager.v2.model.ResCreateResourceGroup;
import com.ibm.cloud.platform_services.resource_manager.v2.model.ResourceGroup;
import com.ibm.cloud.platform_services.resource_manager.v2.model.ResourceGroupList;
import com.ibm.cloud.platform_services.resource_manager.v2.model.UpdateResourceGroupOptions;
import com.ibm.cloud.sdk.core.http.Response;
import com.ibm.cloud.sdk.core.service.exception.ServiceResponseException;
import com.ibm.cloud.sdk.core.util.CredentialUtils;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

//
// This file provides an example of how to use the Resource Manager service.
//
// The following configuration properties are assumed to be defined:
// RESOURCE_MANAGER_URL=<service base url>
// RESOURCE_MANAGER_AUTH_TYPE=iam
// RESOURCE_MANAGER_APIKEY=<IAM apikey of the service>
// RESOURCE_MANAGER_AUTH_URL=<IAM token service base URL - omit this if using the production environment>
// RESOURCE_MANAGER_QUOTA_ID=<quota ID>
// RESOURCE_MANAGER_USER_ACCOUNT_ID=<account ID of the user with delete permission>
//
// ALT_RESOURCE_MANAGER_URL=<service base url>
// ALT_RESOURCE_MANAGER_AUTH_TYPE=iam
// ALT_RESOURCE_MANAGER_AUTH_URL=<IAM token service base URL - omit this if using the production environment>
// ALT_RESOURCE_MANAGER_APIKEY=<IAM apikey of the user with delete permission>
//
// These configuration properties can be exported as environment variables, or stored
// in a configuration file and then:
// export IBM_CREDENTIALS_FILE=<name of configuration file>
//
public class ResourceManagerExamples {
  private static final Logger logger = LoggerFactory.getLogger(ResourceManagerExamples.class);
  protected ResourceManagerExamples() { }

  private static String exampleUserAccountId;
  private static String exampleQuotaId;
  private static String resourceGroupId;

  static {
    System.setProperty("IBM_CREDENTIALS_FILE", "../../resource_manager.env");
  }

  @SuppressWarnings("checkstyle:methodlength")
  public static void main(String[] args) throws Exception {
    ResourceManager resourceManagerService = ResourceManager.newInstance(ResourceManager.DEFAULT_SERVICE_NAME);
    ResourceManager deleteResourceManagerService = ResourceManager.newInstance("ALT_RESOURCE_MANAGER");

    // Load up our test-specific config properties.
    Map<String, String> config = CredentialUtils.getServiceProperties(ResourceManager.DEFAULT_SERVICE_NAME);
    exampleQuotaId = config.get("QUOTA_ID");
    exampleUserAccountId = config.get("USER_ACCOUNT_ID");


    try {
      // begin-create_resource_group
      CreateResourceGroupOptions createResourceGroupOptions = new CreateResourceGroupOptions.Builder()
              .accountId(exampleUserAccountId)
              .name("ExampleGroup")
              .build();

      Response<ResCreateResourceGroup> response = resourceManagerService.createResourceGroup(createResourceGroupOptions).execute();
      ResCreateResourceGroup resCreateResourceGroup = response.getResult();

      System.out.println(resCreateResourceGroup);
      // end-create_resource_group
      resourceGroupId = resCreateResourceGroup.getId();
    } catch (ServiceResponseException e) {
        logger.error(String.format("Service returned status code %s: %s\nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()), e);
    }

    try {
      // begin-get_resource_group
      GetResourceGroupOptions getResourceGroupOptions = new GetResourceGroupOptions.Builder()
        .id(resourceGroupId)
        .build();

      Response<ResourceGroup> response = resourceManagerService.getResourceGroup(getResourceGroupOptions).execute();
      ResourceGroup resourceGroup = response.getResult();

      System.out.println(resourceGroup);
      // end-get_resource_group
    } catch (ServiceResponseException e) {
        logger.error(String.format("Service returned status code %s: %s\nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()), e);
    }

    try {
      // begin-update_resource_group
      UpdateResourceGroupOptions updateResourceGroupOptions = new UpdateResourceGroupOptions.Builder()
        .id(resourceGroupId)
        .name("RenamedExampleGroup")
        .state("ACTIVE")
        .build();

      Response<ResourceGroup> response = resourceManagerService.updateResourceGroup(updateResourceGroupOptions).execute();
      ResourceGroup resourceGroup = response.getResult();

      System.out.println(resourceGroup);
      // end-update_resource_group
    } catch (ServiceResponseException e) {
        logger.error(String.format("Service returned status code %s: %s\nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()), e);
    }

    try {
      // begin-list_resource_groups
      ListResourceGroupsOptions listResourceGroupsOptions = new ListResourceGroupsOptions.Builder()
              .accountId(exampleUserAccountId)
              .includeDeleted(true)
              .build();

      Response<ResourceGroupList> response = resourceManagerService.listResourceGroups(listResourceGroupsOptions).execute();
      ResourceGroupList resourceGroupList = response.getResult();

      System.out.println(resourceGroupList);
      // end-list_resource_groups
    } catch (ServiceResponseException e) {
      logger.error(String.format("Service returned status code %s: %s\nError details: %s",
                                 e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()), e);
    }

    try {
      // begin-delete_resource_group
      DeleteResourceGroupOptions deleteResourceGroupOptions = new DeleteResourceGroupOptions.Builder()
              .id(resourceGroupId)
              .build();

      deleteResourceManagerService.deleteResourceGroup(deleteResourceGroupOptions).execute();
      // end-delete_resource_group
    } catch (ServiceResponseException e) {
      logger.error(String.format("Service returned status code %s: %s\nError details: %s",
                                 e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()), e);
    }

    try {
      // begin-list_quota_definitions
      ListQuotaDefinitionsOptions listQuotaDefinitionsOptions = new ListQuotaDefinitionsOptions();

      Response<QuotaDefinitionList> response = resourceManagerService.listQuotaDefinitions().execute();
      QuotaDefinitionList quotaDefinitionList = response.getResult();

      System.out.println(quotaDefinitionList);
      // end-list_quota_definitions
    } catch (ServiceResponseException e) {
        logger.error(String.format("Service returned status code %s: %s\nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()), e);
    }

    try {
      // begin-get_quota_definition
      GetQuotaDefinitionOptions getQuotaDefinitionOptions = new GetQuotaDefinitionOptions.Builder()
        .id(exampleQuotaId)
        .build();

      Response<QuotaDefinition> response = resourceManagerService.getQuotaDefinition(getQuotaDefinitionOptions).execute();
      QuotaDefinition quotaDefinition = response.getResult();

      System.out.println(quotaDefinition);
      // end-get_quota_definition
    } catch (ServiceResponseException e) {
        logger.error(String.format("Service returned status code %s: %s\nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()), e);
    }
  }
}
