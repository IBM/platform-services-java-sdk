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
import com.ibm.cloud.platform_services.resource_controller.v2.model.ListResourceAliasesForInstanceOptions;
import com.ibm.cloud.platform_services.resource_controller.v2.model.ListResourceAliasesOptions;
import com.ibm.cloud.platform_services.resource_controller.v2.model.ListResourceBindingsForAliasOptions;
import com.ibm.cloud.platform_services.resource_controller.v2.model.ListResourceBindingsOptions;
import com.ibm.cloud.platform_services.resource_controller.v2.model.ListResourceInstancesOptions;
import com.ibm.cloud.platform_services.resource_controller.v2.model.ListResourceKeysForInstanceOptions;
import com.ibm.cloud.platform_services.resource_controller.v2.model.ListResourceKeysOptions;
import com.ibm.cloud.platform_services.resource_controller.v2.model.LockResourceInstanceOptions;
import com.ibm.cloud.platform_services.resource_controller.v2.model.Reclamation;
import com.ibm.cloud.platform_services.resource_controller.v2.model.ReclamationsList;
import com.ibm.cloud.platform_services.resource_controller.v2.model.ResourceAlias;
import com.ibm.cloud.platform_services.resource_controller.v2.model.ResourceAliasesList;
import com.ibm.cloud.platform_services.resource_controller.v2.model.ResourceBinding;
import com.ibm.cloud.platform_services.resource_controller.v2.model.ResourceBindingPostParameters;
import com.ibm.cloud.platform_services.resource_controller.v2.model.ResourceBindingsList;
import com.ibm.cloud.platform_services.resource_controller.v2.model.ResourceInstance;
import com.ibm.cloud.platform_services.resource_controller.v2.model.ResourceInstancesList;
import com.ibm.cloud.platform_services.resource_controller.v2.model.ResourceKey;
import com.ibm.cloud.platform_services.resource_controller.v2.model.ResourceKeyPostParameters;
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
import java.util.HashMap;
import java.util.concurrent.TimeUnit;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

//
// This class provides an example of how to use the Resource Controller service.
//
// The following configuration properties are assumed to be defined:
//
// RESOURCE_CONTROLLER_URL=<service url>
// RESOURCE_CONTROLLER_AUTH_TYPE=iam
// RESOURCE_CONTROLLER_AUTH_URL=<IAM Token Service url>
// RESOURCE_CONTROLLER_APIKEY=<User's IAM API Key>
// RESOURCE_CONTROLLER_RESOURCE_GROUP=<Short ID of the user's resource group>
// RESOURCE_CONTROLLER_PLAN_ID=<Unique ID of the plan associated with the offering>
// RESOURCE_CONTROLLER_ACCOUNT_ID=<User's account ID>
// RESOURCE_CONTROLLER_ALIAS_TARGET_CRN=<The CRN of target name(space) in a specific environment>
// RESOURCE_CONTROLLER_BINDING_TARGET_CRN=<The CRN of application to bind to in a specific environment>
//
// These configuration properties can be exported as environment variables, or stored
// in a configuration file and then:
// export IBM_CREDENTIALS_FILE=<name of configuration file>
//
public class ResourceControllerExamples {
  private static final Logger logger = LoggerFactory.getLogger(ResourceControllerExamples.class);
  protected ResourceControllerExamples() { }

  private static String instanceGuid;
  private static String aliasGuid;
  private static String bindingGuid;
  private static String instanceKeyGuid;
  private static String resourceGroup;
  private static String resourcePlanId;
  private static String accountId;
  private static String aliasTargetCRN;
  private static String bindingTargetCRN;
  private static String reclamationId;
  private static String resourceInstanceName = "RcSdkInstance1Java";
  private static String resourceInstanceUpdateName = "RcSdkInstanceUpdate1Java";
  private static String aliasName = "RcSdkAlias1Java";
  private static String aliasUpdateName = "RcSdkAliasUpdate1Java";
  private static String bindingName = "RcSdkBinding1Java";
  private static String bindingUpdateName = "RcSdkBindingUpdate1Java";
  private static String keyName = "RcSdkKey1Java";
  private static String keyUpdateName = "RcSdkKeyUpdate1Java";
  private static String targetRegion = "global";

  static {
      System.setProperty("IBM_CREDENTIALS_FILE", "../../resource_controller.env");
  }

  public static void main(String[] args) throws Exception {
    ResourceController service = ResourceController.newInstance();

    // Load up our test-specific config properties.
    Map<String, String> config = CredentialUtils.getServiceProperties(ResourceController.DEFAULT_SERVICE_NAME);
    resourceGroup = config.get("RESOURCE_GROUP");
    resourcePlanId = config.get("RECLAMATION_PLAN_ID");
    accountId = config.get("ACCOUNT_ID");
    aliasTargetCRN = config.get("ALIAS_TARGET_CRN");
    bindingTargetCRN = config.get("BINDING_TARGET_CRN");

    try {
      // begin-create_resource_instance
      CreateResourceInstanceOptions createResourceInstanceOptions = new CreateResourceInstanceOptions.Builder()
        .name(resourceInstanceName)
        .target(targetRegion)
        .resourceGroup(resourceGroup)
        .resourcePlanId(resourcePlanId)
        .build();

      Response<ResourceInstance> response = service.createResourceInstance(createResourceInstanceOptions).execute();
      ResourceInstance resourceInstance = response.getResult();

      System.out.printf("createResourceInstance() response:\n%s\n", resourceInstance.toString());
      // end-create_resource_instance

      instanceGuid = resourceInstance.getGuid();

    } catch (ServiceResponseException e) {
        logger.error(String.format("Service returned status code %s: %s\nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()), e);
    }

    try {
      // begin-get_resource_instance
      GetResourceInstanceOptions getResourceInstanceOptions = new GetResourceInstanceOptions.Builder()
        .id(instanceGuid)
        .build();

      Response<ResourceInstance> response = service.getResourceInstance(getResourceInstanceOptions).execute();
      ResourceInstance resourceInstance = response.getResult();

      System.out.printf("getResourceInstance() response:\n%s\n", resourceInstance.toString());
      // end-get_resource_instance
    } catch (ServiceResponseException e) {
        logger.error(String.format("Service returned status code %s: %s\nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()), e);
    }

    try {
      // begin-list_resource_instances
      ListResourceInstancesOptions listResourceInstancesOptions = new ListResourceInstancesOptions.Builder()
        .name(resourceInstanceName)
        .build();

      Response<ResourceInstancesList> response = service.listResourceInstances(listResourceInstancesOptions).execute();
      ResourceInstancesList resourceInstancesList = response.getResult();

      System.out.printf("listResourceInstances() response:\n%s\n", resourceInstancesList.toString());
      // end-list_resource_instances
    } catch (ServiceResponseException e) {
        logger.error(String.format("Service returned status code %s: %s\nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()), e);
    }

    try {
      // begin-update_resource_instance
      Map<String, Object> parameters = new HashMap<String, Object>();
      parameters.put("exampleProperty", "exampleValue");

      UpdateResourceInstanceOptions updateResourceInstanceOptions = new UpdateResourceInstanceOptions.Builder()
        .id(instanceGuid)
        .name(resourceInstanceUpdateName)
        .parameters(parameters)
        .build();

      Response<ResourceInstance> response = service.updateResourceInstance(updateResourceInstanceOptions).execute();
      ResourceInstance resourceInstance = response.getResult();

      System.out.printf("updateResourceInstance() response:\n%s\n", resourceInstance.toString());
      // end-update_resource_instance
    } catch (ServiceResponseException e) {
        logger.error(String.format("Service returned status code %s: %s\nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()), e);
    }

    try {
      // begin-create_resource_alias
      CreateResourceAliasOptions createResourceAliasOptions = new CreateResourceAliasOptions.Builder()
        .name(aliasName)
        .source(instanceGuid)
        .target(aliasTargetCRN)
        .build();

      Response<ResourceAlias> response = service.createResourceAlias(createResourceAliasOptions).execute();
      ResourceAlias resourceAlias = response.getResult();

      System.out.printf("createResourceAlias() response:\n%s\n", resourceAlias.toString());
      // end-create_resource_alias

      aliasGuid = resourceAlias.getGuid();

    } catch (ServiceResponseException e) {
        logger.error(String.format("Service returned status code %s: %s\nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()), e);
    }

    try {
      // begin-get_resource_alias
      GetResourceAliasOptions getResourceAliasOptions = new GetResourceAliasOptions.Builder()
        .id(aliasGuid)
        .build();

      Response<ResourceAlias> response = service.getResourceAlias(getResourceAliasOptions).execute();
      ResourceAlias resourceAlias = response.getResult();

      System.out.printf("getResourceAlias() response:\n%s\n", resourceAlias.toString());
      // end-get_resource_alias
    } catch (ServiceResponseException e) {
        logger.error(String.format("Service returned status code %s: %s\nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()), e);
    }

    try {
      // begin-list_resource_aliases
      ListResourceAliasesOptions listResourceAliasesOptions = new ListResourceAliasesOptions.Builder()
        .name(aliasName)
        .build();

      Response<ResourceAliasesList> response = service.listResourceAliases(listResourceAliasesOptions).execute();
      ResourceAliasesList resourceAliasesList = response.getResult();

      System.out.printf("listResourceAliases() response:\n%s\n", resourceAliasesList.toString());
      // end-list_resource_aliases
    } catch (ServiceResponseException e) {
        logger.error(String.format("Service returned status code %s: %s\nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()), e);
    }

    try {
      // begin-update_resource_alias
      UpdateResourceAliasOptions updateResourceAliasOptions = new UpdateResourceAliasOptions.Builder()
        .id(aliasGuid)
        .name(aliasUpdateName)
        .build();

      Response<ResourceAlias> response = service.updateResourceAlias(updateResourceAliasOptions).execute();
      ResourceAlias resourceAlias = response.getResult();

      System.out.printf("updateResourceAlias() response:\n%s\n", resourceAlias.toString());
      // end-update_resource_alias
    } catch (ServiceResponseException e) {
        logger.error(String.format("Service returned status code %s: %s\nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()), e);
    }

    try {
      // begin-list_resource_aliases_for_instance
      ListResourceAliasesForInstanceOptions listResourceAliasesForInstanceOptions = new ListResourceAliasesForInstanceOptions.Builder()
        .id(instanceGuid)
        .build();

      Response<ResourceAliasesList> response = service.listResourceAliasesForInstance(listResourceAliasesForInstanceOptions).execute();
      ResourceAliasesList resourceAliasesList = response.getResult();

      System.out.printf("listResourceAliasesForInstance() response:\n%s\n", resourceAliasesList.toString());
      // end-list_resource_aliases_for_instance
    } catch (ServiceResponseException e) {
        logger.error(String.format("Service returned status code %s: %s\nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()), e);
    }

    try {
      // begin-create_resource_binding
      ResourceBindingPostParameters parameters = new ResourceBindingPostParameters.Builder()
        .add("exampleParameter", "exampleValue")
        .build();
      CreateResourceBindingOptions createResourceBindingOptions = new CreateResourceBindingOptions.Builder()
        .source(aliasGuid)
        .target(bindingTargetCRN)
        .name(bindingName)
        .parameters(parameters)
        .build();

      Response<ResourceBinding> response = service.createResourceBinding(createResourceBindingOptions).execute();
      ResourceBinding resourceBinding = response.getResult();

      System.out.printf("createResourceBinding() response:\n%s\n", resourceBinding.toString());
      // end-create_resource_binding

      bindingGuid = resourceBinding.getGuid();

    } catch (ServiceResponseException e) {
        logger.error(String.format("Service returned status code %s: %s\nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()), e);
    }

    try {
      // begin-get_resource_binding
      GetResourceBindingOptions getResourceBindingOptions = new GetResourceBindingOptions.Builder()
        .id(bindingGuid)
        .build();

      Response<ResourceBinding> response = service.getResourceBinding(getResourceBindingOptions).execute();
      ResourceBinding resourceBinding = response.getResult();

      System.out.printf("getResourceBinding() response:\n%s\n", resourceBinding.toString());
      // end-get_resource_binding
    } catch (ServiceResponseException e) {
        logger.error(String.format("Service returned status code %s: %s\nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()), e);
    }

    try {
      // begin-list_resource_bindings
      ListResourceBindingsOptions listResourceBindingsOptions = new ListResourceBindingsOptions.Builder()
        .name(bindingName)
        .build();

      Response<ResourceBindingsList> response = service.listResourceBindings(listResourceBindingsOptions).execute();
      ResourceBindingsList resourceBindingsList = response.getResult();

      System.out.printf("listResourceBindings() response:\n%s\n", resourceBindingsList.toString());
      // end-list_resource_bindings
    } catch (ServiceResponseException e) {
        logger.error(String.format("Service returned status code %s: %s\nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()), e);
    }

    try {
      // begin-update_resource_binding
      UpdateResourceBindingOptions updateResourceBindingOptions = new UpdateResourceBindingOptions.Builder()
        .id(bindingGuid)
        .name(bindingUpdateName)
        .build();

      Response<ResourceBinding> response = service.updateResourceBinding(updateResourceBindingOptions).execute();
      ResourceBinding resourceBinding = response.getResult();

      System.out.printf("updateResourceBinding() response:\n%s\n", resourceBinding.toString());
      // end-update_resource_binding
    } catch (ServiceResponseException e) {
        logger.error(String.format("Service returned status code %s: %s\nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()), e);
    }

    try {
      // begin-list_resource_bindings_for_alias
      ListResourceBindingsForAliasOptions listResourceBindingsForAliasOptions = new ListResourceBindingsForAliasOptions.Builder()
        .id(aliasGuid)
        .build();

      Response<ResourceBindingsList> response = service.listResourceBindingsForAlias(listResourceBindingsForAliasOptions).execute();
      ResourceBindingsList resourceBindingsList = response.getResult();

      System.out.printf("listResourceBindingsForAlias() response:\n%s\n", resourceBindingsList.toString());
      // end-list_resource_bindings_for_alias
    } catch (ServiceResponseException e) {
        logger.error(String.format("Service returned status code %s: %s\nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()), e);
    }

    try {
      // begin-create_resource_key
      ResourceKeyPostParameters parameters = new ResourceKeyPostParameters.Builder()
        .add("exampleParameter", "exampleValue")
        .build();
      CreateResourceKeyOptions createResourceKeyOptions = new CreateResourceKeyOptions.Builder()
        .name(keyName)
        .source(instanceGuid)
        .parameters(parameters)
        .build();

      Response<ResourceKey> response = service.createResourceKey(createResourceKeyOptions).execute();
      ResourceKey resourceKey = response.getResult();

      System.out.printf("createResourceKey() response:\n%s\n", resourceKey.toString());
      // end-create_resource_key

      instanceKeyGuid = resourceKey.getGuid();

    } catch (ServiceResponseException e) {
        logger.error(String.format("Service returned status code %s: %s\nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()), e);
    }

    try {
      // begin-get_resource_key
      GetResourceKeyOptions getResourceKeyOptions = new GetResourceKeyOptions.Builder()
        .id(instanceKeyGuid)
        .build();

      Response<ResourceKey> response = service.getResourceKey(getResourceKeyOptions).execute();
      ResourceKey resourceKey = response.getResult();

      System.out.printf("getResourceKey() response:\n%s\n", resourceKey.toString());
      // end-get_resource_key
    } catch (ServiceResponseException e) {
        logger.error(String.format("Service returned status code %s: %s\nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()), e);
    }

    try {
      // begin-list_resource_keys
      ListResourceKeysOptions listResourceKeysOptions = new ListResourceKeysOptions.Builder()
        .name(keyName)
        .build();

      Response<ResourceKeysList> response = service.listResourceKeys(listResourceKeysOptions).execute();
      ResourceKeysList resourceKeysList = response.getResult();

      System.out.printf("listResourceKeys() response:\n%s\n", resourceKeysList.toString());
      // end-list_resource_keys
    } catch (ServiceResponseException e) {
        logger.error(String.format("Service returned status code %s: %s\nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()), e);
    }

    try {
      // begin-update_resource_key
      UpdateResourceKeyOptions updateResourceKeyOptions = new UpdateResourceKeyOptions.Builder()
        .id(instanceKeyGuid)
        .name(keyUpdateName)
        .build();

      Response<ResourceKey> response = service.updateResourceKey(updateResourceKeyOptions).execute();
      ResourceKey resourceKey = response.getResult();

      System.out.printf("updateResourceKey() response:\n%s\n", resourceKey.toString());
      // end-update_resource_key
    } catch (ServiceResponseException e) {
        logger.error(String.format("Service returned status code %s: %s\nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()), e);
    }

    try {
      // begin-list_resource_keys_for_instance
      ListResourceKeysForInstanceOptions listResourceKeysForInstanceOptions = new ListResourceKeysForInstanceOptions.Builder()
        .id(instanceGuid)
        .build();

      Response<ResourceKeysList> response = service.listResourceKeysForInstance(listResourceKeysForInstanceOptions).execute();
      ResourceKeysList resourceKeysList = response.getResult();

      System.out.printf("listResourceKeysForInstance() response:\n%s\n", resourceKeysList.toString());
      // end-list_resource_keys_for_instance
    } catch (ServiceResponseException e) {
        logger.error(String.format("Service returned status code %s: %s\nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()), e);
    }

    try {
      // begin-delete_resource_binding
      DeleteResourceBindingOptions deleteResourceBindingOptions = new DeleteResourceBindingOptions.Builder()
        .id(bindingGuid)
        .build();

      Response<Void> response = service.deleteResourceBinding(deleteResourceBindingOptions).execute();

      System.out.printf("deleteResourceBinding() response status code: %d\n", response.getStatusCode());
      // end-delete_resource_binding
    } catch (ServiceResponseException e) {
        logger.error(String.format("Service returned status code %s: %s\nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()), e);
    }

    try {
      // begin-delete_resource_key
      DeleteResourceKeyOptions deleteResourceKeyOptions = new DeleteResourceKeyOptions.Builder()
        .id(instanceKeyGuid)
        .build();

      Response<Void> response = service.deleteResourceKey(deleteResourceKeyOptions).execute();

      System.out.printf("deleteResourceKey() response status code: %d\n", response.getStatusCode());
      // end-delete_resource_key
    } catch (ServiceResponseException e) {
        logger.error(String.format("Service returned status code %s: %s\nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()), e);
    }

    try {
      // begin-delete_resource_alias
      DeleteResourceAliasOptions deleteResourceAliasOptions = new DeleteResourceAliasOptions.Builder()
        .id(aliasGuid)
        .build();

      Response<Void> response = service.deleteResourceAlias(deleteResourceAliasOptions).execute();

      System.out.printf("deleteResourceAlias() response status code: %d\n", response.getStatusCode());
      // end-delete_resource_alias
    } catch (ServiceResponseException e) {
        logger.error(String.format("Service returned status code %s: %s\nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()), e);
    }

    try {
      // begin-lock_resource_instance
      LockResourceInstanceOptions lockResourceInstanceOptions = new LockResourceInstanceOptions.Builder()
        .id(instanceGuid)
        .build();

      Response<ResourceInstance> response = service.lockResourceInstance(lockResourceInstanceOptions).execute();
      ResourceInstance resourceInstance = response.getResult();

      System.out.printf("lockResourceInstance() response:\n%s\n", resourceInstance.toString());
      // end-lock_resource_instance
    } catch (ServiceResponseException e) {
        logger.error(String.format("Service returned status code %s: %s\nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()), e);
    }

    try {
      // begin-unlock_resource_instance
      UnlockResourceInstanceOptions unlockResourceInstanceOptions = new UnlockResourceInstanceOptions.Builder()
        .id(instanceGuid)
        .build();

      Response<ResourceInstance> response = service.unlockResourceInstance(unlockResourceInstanceOptions).execute();
      ResourceInstance resourceInstance = response.getResult();

      System.out.printf("unlockResourceInstance() response:\n%s\n", resourceInstance.toString());
      // end-unlock_resource_instance
    } catch (ServiceResponseException e) {
        logger.error(String.format("Service returned status code %s: %s\nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()), e);
    }

    try {
      // begin-delete_resource_instance
      DeleteResourceInstanceOptions deleteResourceInstanceOptions = new DeleteResourceInstanceOptions.Builder()
        .id(instanceGuid)
        .recursive(false)
        .build();

      Response<Void> response = service.deleteResourceInstance(deleteResourceInstanceOptions).execute();

      System.out.printf("deleteResourceInstance() response status code: %d\n", response.getStatusCode());
      // end-delete_resource_instance
      try {
        TimeUnit.SECONDS.sleep(20);
      } catch (Exception e) {
        System.out.println("Failed to wait for 20 seconds.");
      }
    } catch (ServiceResponseException e) {
        logger.error(String.format("Service returned status code %s: %s\nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()), e);
    }

    try {
      // begin-list_reclamations
      ListReclamationsOptions listReclamationsOptions = new ListReclamationsOptions.Builder()
        .accountId(accountId)
        .build();

      Response<ReclamationsList> response = service.listReclamations(listReclamationsOptions).execute();
      ReclamationsList reclamationsList = response.getResult();

      System.out.printf("listReclamations() response:\n%s\n", reclamationsList.toString());
      // end-list_reclamations

      for (Reclamation r : reclamationsList.getResources()) {
        if (r.getResourceInstanceId().equals(instanceGuid)) {
          reclamationId = r.getId();
        }
      }
    } catch (ServiceResponseException e) {
        logger.error(String.format("Service returned status code %s: %s\nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()), e);
    }

    try {
      // begin-run_reclamation_action
      RunReclamationActionOptions runReclamationActionOptions = new RunReclamationActionOptions.Builder()
        .id(reclamationId)
        .actionName("reclaim")
        .build();

      Response<Reclamation> response = service.runReclamationAction(runReclamationActionOptions).execute();
      Reclamation reclamation = response.getResult();

      System.out.printf("runReclamationAction() response:\n%s\n", reclamation.toString());
      // end-run_reclamation_action
      try {
        TimeUnit.SECONDS.sleep(20);
      } catch (Exception e) {
        System.out.println("Failed to wait for 20 seconds.");
      }
    } catch (ServiceResponseException e) {
        logger.error(String.format("Service returned status code %s: %s\nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()), e);
    }

  }
}
