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

package com.ibm.cloud.platform_services.resource_controller.v2;

import com.ibm.cloud.platform_services.resource_controller.v2.model.CreateResourceAliasOptions;
import com.ibm.cloud.platform_services.resource_controller.v2.model.CreateResourceBindingOptions;
import com.ibm.cloud.platform_services.resource_controller.v2.model.CreateResourceInstanceOptions;
import com.ibm.cloud.platform_services.resource_controller.v2.model.CreateResourceKeyOptions;
import com.ibm.cloud.platform_services.resource_controller.v2.model.DeleteResourceAliasOptions;
import com.ibm.cloud.platform_services.resource_controller.v2.model.DeleteResourceBindingOptions;
import com.ibm.cloud.platform_services.resource_controller.v2.model.DeleteResourceInstanceOptions;
import com.ibm.cloud.platform_services.resource_controller.v2.model.DeleteResourceKeyOptions;
import com.ibm.cloud.platform_services.resource_controller.v2.model.GetResourceAliasOptions;
import com.ibm.cloud.platform_services.resource_controller.v2.model.GetResourceBindingOptions;
import com.ibm.cloud.platform_services.resource_controller.v2.model.GetResourceInstanceOptions;
import com.ibm.cloud.platform_services.resource_controller.v2.model.GetResourceKeyOptions;
import com.ibm.cloud.platform_services.resource_controller.v2.model.ListReclamationsOptions;
import com.ibm.cloud.platform_services.resource_controller.v2.model.ListResourceAliasesOptions;
import com.ibm.cloud.platform_services.resource_controller.v2.model.ListResourceBindingsOptions;
import com.ibm.cloud.platform_services.resource_controller.v2.model.ListResourceInstancesOptions;
import com.ibm.cloud.platform_services.resource_controller.v2.model.ListResourceKeysOptions;
import com.ibm.cloud.platform_services.resource_controller.v2.model.LockResourceInstanceOptions;
import com.ibm.cloud.platform_services.resource_controller.v2.model.Reclamation;
import com.ibm.cloud.platform_services.resource_controller.v2.model.ReclamationsList;
import com.ibm.cloud.platform_services.resource_controller.v2.model.ResourceAlias;
import com.ibm.cloud.platform_services.resource_controller.v2.model.ResourceAliasesList;
import com.ibm.cloud.platform_services.resource_controller.v2.model.ResourceBinding;
import com.ibm.cloud.platform_services.resource_controller.v2.model.ResourceBindingsList;
import com.ibm.cloud.platform_services.resource_controller.v2.model.ResourceInstance;
import com.ibm.cloud.platform_services.resource_controller.v2.model.ResourceInstancesList;
import com.ibm.cloud.platform_services.resource_controller.v2.model.ResourceKey;
import com.ibm.cloud.platform_services.resource_controller.v2.model.ResourceKeysList;
import com.ibm.cloud.platform_services.resource_controller.v2.model.RunReclamationActionOptions;
import com.ibm.cloud.platform_services.resource_controller.v2.model.UnlockResourceInstanceOptions;
import com.ibm.cloud.platform_services.resource_controller.v2.model.UpdateResourceAliasOptions;
import com.ibm.cloud.platform_services.resource_controller.v2.model.UpdateResourceBindingOptions;
import com.ibm.cloud.platform_services.resource_controller.v2.model.UpdateResourceInstanceOptions;
import com.ibm.cloud.platform_services.resource_controller.v2.model.UpdateResourceKeyOptions;
import com.ibm.cloud.sdk.core.http.Response;
import com.ibm.cloud.sdk.core.service.exception.ServiceResponseException;
import com.ibm.cloud.sdk.core.util.CredentialUtils;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ResourceControllerExamples {
  private static final Logger logger = LoggerFactory.getLogger(ResourceControllerExamples.class);
  protected ResourceControllerExamples() { }

  static {
      System.setProperty("IBM_CREDENTIALS_FILE", "../../resource_controller.env");
  }

  public static void main(String[] args) throws Exception {
    ResourceController service = ResourceController.newInstance();

    // Load up our test-specific config properties.
    Map<String, String> config = CredentialUtils.getServiceProperties(ResourceController.DEFAULT_SERVICE_NAME);

    try {
      // begin-list_resource_instances
      ListResourceInstancesOptions listResourceInstancesOptions = new ListResourceInstancesOptions.Builder()
        .updatedFrom("2019-01-08T00:00:00.000Z")
        .updatedTo("2019-01-08T00:00:00.000Z")
        .build();

      Response<ResourceInstancesList> response = service.listResourceInstances(listResourceInstancesOptions).execute();
      ResourceInstancesList resourceInstancesList = response.getResult();

      System.out.println(resourceInstancesList);
      // end-list_resource_instances
    } catch (ServiceResponseException e) {
        logger.error(String.format("Service returned status code %s: %s\nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()), e);
    }

    try {
      // begin-create_resource_instance
      CreateResourceInstanceOptions createResourceInstanceOptions = new CreateResourceInstanceOptions.Builder()
        .name("my-instance")
        .target("bluemix-us-south")
        .resourceGroup("5c49eabc-f5e8-5881-a37e-2d100a33b3df")
        .resourcePlanId("cloudant-standard")
        .build();

      Response<ResourceInstance> response = service.createResourceInstance(createResourceInstanceOptions).execute();
      ResourceInstance resourceInstance = response.getResult();

      System.out.println(resourceInstance);
      // end-create_resource_instance
    } catch (ServiceResponseException e) {
        logger.error(String.format("Service returned status code %s: %s\nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()), e);
    }

    try {
      // begin-get_resource_instance
      GetResourceInstanceOptions getResourceInstanceOptions = new GetResourceInstanceOptions.Builder()
        .id("testString")
        .build();

      Response<ResourceInstance> response = service.getResourceInstance(getResourceInstanceOptions).execute();
      ResourceInstance resourceInstance = response.getResult();

      System.out.println(resourceInstance);
      // end-get_resource_instance
    } catch (ServiceResponseException e) {
        logger.error(String.format("Service returned status code %s: %s\nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()), e);
    }

    try {
      // begin-update_resource_instance
      UpdateResourceInstanceOptions updateResourceInstanceOptions = new UpdateResourceInstanceOptions.Builder()
        .id("testString")
        .build();

      Response<ResourceInstance> response = service.updateResourceInstance(updateResourceInstanceOptions).execute();
      ResourceInstance resourceInstance = response.getResult();

      System.out.println(resourceInstance);
      // end-update_resource_instance
    } catch (ServiceResponseException e) {
        logger.error(String.format("Service returned status code %s: %s\nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()), e);
    }

    try {
      // begin-lock_resource_instance
      LockResourceInstanceOptions lockResourceInstanceOptions = new LockResourceInstanceOptions.Builder()
        .id("testString")
        .build();

      Response<ResourceInstance> response = service.lockResourceInstance(lockResourceInstanceOptions).execute();
      ResourceInstance resourceInstance = response.getResult();

      System.out.println(resourceInstance);
      // end-lock_resource_instance
    } catch (ServiceResponseException e) {
        logger.error(String.format("Service returned status code %s: %s\nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()), e);
    }

    try {
      // begin-list_resource_keys
      ListResourceKeysOptions listResourceKeysOptions = new ListResourceKeysOptions.Builder()
        .updatedFrom("2019-01-08T00:00:00.000Z")
        .updatedTo("2019-01-08T00:00:00.000Z")
        .build();

      Response<ResourceKeysList> response = service.listResourceKeys(listResourceKeysOptions).execute();
      ResourceKeysList resourceKeysList = response.getResult();

      System.out.println(resourceKeysList);
      // end-list_resource_keys
    } catch (ServiceResponseException e) {
        logger.error(String.format("Service returned status code %s: %s\nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()), e);
    }

    try {
      // begin-create_resource_key
      CreateResourceKeyOptions createResourceKeyOptions = new CreateResourceKeyOptions.Builder()
        .name("my-key")
        .source("25eba2a9-beef-450b-82cf-f5ad5e36c6dd")
        .build();

      Response<ResourceKey> response = service.createResourceKey(createResourceKeyOptions).execute();
      ResourceKey resourceKey = response.getResult();

      System.out.println(resourceKey);
      // end-create_resource_key
    } catch (ServiceResponseException e) {
        logger.error(String.format("Service returned status code %s: %s\nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()), e);
    }

    try {
      // begin-get_resource_key
      GetResourceKeyOptions getResourceKeyOptions = new GetResourceKeyOptions.Builder()
        .id("testString")
        .build();

      Response<ResourceKey> response = service.getResourceKey(getResourceKeyOptions).execute();
      ResourceKey resourceKey = response.getResult();

      System.out.println(resourceKey);
      // end-get_resource_key
    } catch (ServiceResponseException e) {
        logger.error(String.format("Service returned status code %s: %s\nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()), e);
    }

    try {
      // begin-update_resource_key
      UpdateResourceKeyOptions updateResourceKeyOptions = new UpdateResourceKeyOptions.Builder()
        .id("testString")
        .name("my-new-key-name")
        .build();

      Response<ResourceKey> response = service.updateResourceKey(updateResourceKeyOptions).execute();
      ResourceKey resourceKey = response.getResult();

      System.out.println(resourceKey);
      // end-update_resource_key
    } catch (ServiceResponseException e) {
        logger.error(String.format("Service returned status code %s: %s\nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()), e);
    }

    try {
      // begin-list_resource_bindings
      ListResourceBindingsOptions listResourceBindingsOptions = new ListResourceBindingsOptions.Builder()
        .updatedFrom("2019-01-08T00:00:00.000Z")
        .updatedTo("2019-01-08T00:00:00.000Z")
        .build();

      Response<ResourceBindingsList> response = service.listResourceBindings(listResourceBindingsOptions).execute();
      ResourceBindingsList resourceBindingsList = response.getResult();

      System.out.println(resourceBindingsList);
      // end-list_resource_bindings
    } catch (ServiceResponseException e) {
        logger.error(String.format("Service returned status code %s: %s\nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()), e);
    }

    try {
      // begin-create_resource_binding
      CreateResourceBindingOptions createResourceBindingOptions = new CreateResourceBindingOptions.Builder()
        .source("25eba2a9-beef-450b-82cf-f5ad5e36c6dd")
        .target("crn:v1:cf:public:cf:us-south:s/0ba4dba0-a120-4a1e-a124-5a249a904b76::cf-application:a1caa40b-2c24-4da8-8267-ac2c1a42ad0c")
        .build();

      Response<ResourceBinding> response = service.createResourceBinding(createResourceBindingOptions).execute();
      ResourceBinding resourceBinding = response.getResult();

      System.out.println(resourceBinding);
      // end-create_resource_binding
    } catch (ServiceResponseException e) {
        logger.error(String.format("Service returned status code %s: %s\nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()), e);
    }

    try {
      // begin-get_resource_binding
      GetResourceBindingOptions getResourceBindingOptions = new GetResourceBindingOptions.Builder()
        .id("testString")
        .build();

      Response<ResourceBinding> response = service.getResourceBinding(getResourceBindingOptions).execute();
      ResourceBinding resourceBinding = response.getResult();

      System.out.println(resourceBinding);
      // end-get_resource_binding
    } catch (ServiceResponseException e) {
        logger.error(String.format("Service returned status code %s: %s\nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()), e);
    }

    try {
      // begin-update_resource_binding
      UpdateResourceBindingOptions updateResourceBindingOptions = new UpdateResourceBindingOptions.Builder()
        .id("testString")
        .name("my-new-binding-name")
        .build();

      Response<ResourceBinding> response = service.updateResourceBinding(updateResourceBindingOptions).execute();
      ResourceBinding resourceBinding = response.getResult();

      System.out.println(resourceBinding);
      // end-update_resource_binding
    } catch (ServiceResponseException e) {
        logger.error(String.format("Service returned status code %s: %s\nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()), e);
    }

    try {
      // begin-list_resource_aliases
      ListResourceAliasesOptions listResourceAliasesOptions = new ListResourceAliasesOptions.Builder()
        .updatedFrom("2019-01-08T00:00:00.000Z")
        .updatedTo("2019-01-08T00:00:00.000Z")
        .build();

      Response<ResourceAliasesList> response = service.listResourceAliases(listResourceAliasesOptions).execute();
      ResourceAliasesList resourceAliasesList = response.getResult();

      System.out.println(resourceAliasesList);
      // end-list_resource_aliases
    } catch (ServiceResponseException e) {
        logger.error(String.format("Service returned status code %s: %s\nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()), e);
    }

    try {
      // begin-create_resource_alias
      CreateResourceAliasOptions createResourceAliasOptions = new CreateResourceAliasOptions.Builder()
        .name("my-alias")
        .source("a8dff6d3-d287-4668-a81d-c87c55c2656d")
        .target("crn:v1:cf:public:cf:us-south:o/5e939cd5-6377-4383-b9e0-9db22cd11753::cf-space:66c8b915-101a-406c-a784-e6636676e4f5")
        .build();

      Response<ResourceAlias> response = service.createResourceAlias(createResourceAliasOptions).execute();
      ResourceAlias resourceAlias = response.getResult();

      System.out.println(resourceAlias);
      // end-create_resource_alias
    } catch (ServiceResponseException e) {
        logger.error(String.format("Service returned status code %s: %s\nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()), e);
    }

    try {
      // begin-get_resource_alias
      GetResourceAliasOptions getResourceAliasOptions = new GetResourceAliasOptions.Builder()
        .id("testString")
        .build();

      Response<ResourceAlias> response = service.getResourceAlias(getResourceAliasOptions).execute();
      ResourceAlias resourceAlias = response.getResult();

      System.out.println(resourceAlias);
      // end-get_resource_alias
    } catch (ServiceResponseException e) {
        logger.error(String.format("Service returned status code %s: %s\nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()), e);
    }

    try {
      // begin-update_resource_alias
      UpdateResourceAliasOptions updateResourceAliasOptions = new UpdateResourceAliasOptions.Builder()
        .id("testString")
        .name("my-new-alias-name")
        .build();

      Response<ResourceAlias> response = service.updateResourceAlias(updateResourceAliasOptions).execute();
      ResourceAlias resourceAlias = response.getResult();

      System.out.println(resourceAlias);
      // end-update_resource_alias
    } catch (ServiceResponseException e) {
        logger.error(String.format("Service returned status code %s: %s\nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()), e);
    }

    try {
      // begin-list_reclamations
      ListReclamationsOptions listReclamationsOptions = new ListReclamationsOptions.Builder()
        .build();

      Response<ReclamationsList> response = service.listReclamations(listReclamationsOptions).execute();
      ReclamationsList reclamationsList = response.getResult();

      System.out.println(reclamationsList);
      // end-list_reclamations
    } catch (ServiceResponseException e) {
        logger.error(String.format("Service returned status code %s: %s\nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()), e);
    }

    try {
      // begin-run_reclamation_action
      RunReclamationActionOptions runReclamationActionOptions = new RunReclamationActionOptions.Builder()
        .id("testString")
        .actionName("testString")
        .build();

      Response<Reclamation> response = service.runReclamationAction(runReclamationActionOptions).execute();
      Reclamation reclamation = response.getResult();

      System.out.println(reclamation);
      // end-run_reclamation_action
    } catch (ServiceResponseException e) {
        logger.error(String.format("Service returned status code %s: %s\nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()), e);
    }

    try {
      // begin-unlock_resource_instance
      UnlockResourceInstanceOptions unlockResourceInstanceOptions = new UnlockResourceInstanceOptions.Builder()
        .id("testString")
        .build();

      Response<ResourceInstance> response = service.unlockResourceInstance(unlockResourceInstanceOptions).execute();
      ResourceInstance resourceInstance = response.getResult();

      System.out.println(resourceInstance);
      // end-unlock_resource_instance
    } catch (ServiceResponseException e) {
        logger.error(String.format("Service returned status code %s: %s\nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()), e);
    }

    try {
      // begin-delete_resource_key
      DeleteResourceKeyOptions deleteResourceKeyOptions = new DeleteResourceKeyOptions.Builder()
        .id("testString")
        .build();

      service.deleteResourceKey(deleteResourceKeyOptions).execute();
      // end-delete_resource_key
    } catch (ServiceResponseException e) {
        logger.error(String.format("Service returned status code %s: %s\nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()), e);
    }

    try {
      // begin-delete_resource_instance
      DeleteResourceInstanceOptions deleteResourceInstanceOptions = new DeleteResourceInstanceOptions.Builder()
        .id("testString")
        .build();

      service.deleteResourceInstance(deleteResourceInstanceOptions).execute();
      // end-delete_resource_instance
    } catch (ServiceResponseException e) {
        logger.error(String.format("Service returned status code %s: %s\nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()), e);
    }

    try {
      // begin-delete_resource_binding
      DeleteResourceBindingOptions deleteResourceBindingOptions = new DeleteResourceBindingOptions.Builder()
        .id("testString")
        .build();

      service.deleteResourceBinding(deleteResourceBindingOptions).execute();
      // end-delete_resource_binding
    } catch (ServiceResponseException e) {
        logger.error(String.format("Service returned status code %s: %s\nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()), e);
    }

    try {
      // begin-delete_resource_alias
      DeleteResourceAliasOptions deleteResourceAliasOptions = new DeleteResourceAliasOptions.Builder()
        .id("testString")
        .build();

      service.deleteResourceAlias(deleteResourceAliasOptions).execute();
      // end-delete_resource_alias
    } catch (ServiceResponseException e) {
        logger.error(String.format("Service returned status code %s: %s\nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()), e);
    }

  }
}
