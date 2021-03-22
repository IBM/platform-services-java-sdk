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

package com.ibm.cloud.platform_services.open_service_broker.v1;

import com.ibm.cloud.platform_services.open_service_broker.v1.model.Context;
import com.ibm.cloud.platform_services.open_service_broker.v1.model.BindResource;
import com.ibm.cloud.platform_services.open_service_broker.v1.model.DeleteServiceBindingOptions;
import com.ibm.cloud.platform_services.open_service_broker.v1.model.DeleteServiceInstanceOptions;
import com.ibm.cloud.platform_services.open_service_broker.v1.model.GetLastOperationOptions;
import com.ibm.cloud.platform_services.open_service_broker.v1.model.GetServiceInstanceStateOptions;
import com.ibm.cloud.platform_services.open_service_broker.v1.model.ListCatalogOptions;
import com.ibm.cloud.platform_services.open_service_broker.v1.model.ReplaceServiceBindingOptions;
import com.ibm.cloud.platform_services.open_service_broker.v1.model.ReplaceServiceInstanceOptions;
import com.ibm.cloud.platform_services.open_service_broker.v1.model.ReplaceServiceInstanceStateOptions;
import com.ibm.cloud.platform_services.open_service_broker.v1.model.Resp1874644Root;
import com.ibm.cloud.platform_services.open_service_broker.v1.model.Resp1874650Root;
import com.ibm.cloud.platform_services.open_service_broker.v1.model.Resp2079872Root;
import com.ibm.cloud.platform_services.open_service_broker.v1.model.Resp2079874Root;
import com.ibm.cloud.platform_services.open_service_broker.v1.model.Resp2079876Root;
import com.ibm.cloud.platform_services.open_service_broker.v1.model.Resp2079894Root;
import com.ibm.cloud.platform_services.open_service_broker.v1.model.Resp2448145Root;
import com.ibm.cloud.platform_services.open_service_broker.v1.model.UpdateServiceInstanceOptions;
import com.ibm.cloud.sdk.core.http.Response;
import com.ibm.cloud.sdk.core.service.exception.ServiceResponseException;
import com.ibm.cloud.sdk.core.util.CredentialUtils;
import java.util.Map;
import java.util.HashMap;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

//
// This file provides an example of how to use the Open Service Broker service.
//
// The following configuration properties are assumed to be defined:
//
// OPEN_SERVICE_BROKER_URL=<Service broker's URL>
// OPEN_SERVICE_BROKER_AUTH_TYPE=basic
// OPEN_SERVICE_BROKER_USERNAME=<username>
// OPEN_SERVICE_BROKER_PASSWORD=<password>
// OPEN_SERVICE_BROKER_PLAN_ID=<The ID of the plan associated with the service offering>
// OPEN_SERVICE_BROKER_RESOURCE_INSTANCE_ID=<The ID of a previously provisioned service instance>
// OPEN_SERVICE_BROKER_SERVICE_ID=<The ID of the service being offered>
// OPEN_SERVICE_BROKER_ACCOUNT_ID=<User's account ID>
// OPEN_SERVICE_BROKER_BINDING_ID=<The ID of a previously provisioned binding for that service instance>
// OPEN_SERVICE_BROKER_SPACE_GUID=<The identifier for the project space within the IBM Cloud platform organization>
// OPEN_SERVICE_BROKER_APPLICATION_GUID=<GUID of an application associated with the binding>
// OPEN_SERVICE_BROKER_ORGANIZATION_GUID=<The IBM Cloud platform GUID for the organization under which the service instance is to be provisioned>
//
// These configuration properties can be exported as environment variables, or stored
// in a configuration file and then:
// export IBM_CREDENTIALS_FILE=<name of configuration file>
//
public class OpenServiceBrokerExamples {
  private static final Logger logger = LoggerFactory.getLogger(OpenServiceBrokerExamples.class);
  protected OpenServiceBrokerExamples() { }

  private static String instanceId;
  private static String orgGuid;
  private static String planId;
  private static String serviceId;
  private static String spaceGuid;
  private static String accountId;
  private static String bindingId;
  private static String appGuid;
  private static String initiatorId = "null";
  private static String reasonCode = "IBMCLOUD_ACCT_SUSPEND";
  private static String operation = "Provision_45";

  static {
      System.setProperty("IBM_CREDENTIALS_FILE", "../../open_service_broker.env");
  }

  public static void main(String[] args) throws Exception {
    OpenServiceBroker service = OpenServiceBroker.newInstance();

    // Load up our test-specific config properties.
    Map<String, String> config = CredentialUtils.getServiceProperties(OpenServiceBroker.DEFAULT_SERVICE_NAME);
    instanceId = config.get("RESOURCE_INSTANCE_ID");
    orgGuid = config.get("ORGANIZATION_GUID");
    planId = config.get("PLAN_ID");
    serviceId = config.get("SERVICE_ID");
    spaceGuid = config.get("SPACE_GUID");
    accountId = config.get("ACCOUNT_ID");
    bindingId = config.get("BINDING_ID");
    appGuid = config.get("APPLICATION_GUID");

    try {
      // begin-get_service_instance_state
      GetServiceInstanceStateOptions getServiceInstanceStateOptions = new GetServiceInstanceStateOptions.Builder()
        .instanceId(instanceId)
        .build();

      Response<Resp1874644Root> response = service.getServiceInstanceState(getServiceInstanceStateOptions).execute();
      Resp1874644Root result = response.getResult();

      System.out.println(result);
      // end-get_service_instance_state
    } catch (ServiceResponseException e) {
        logger.error(String.format("Service returned status code %s: %s\nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()), e);
    }

    try {
      // begin-replace_service_instance_state
      ReplaceServiceInstanceStateOptions replaceServiceInstanceStateOptions = new ReplaceServiceInstanceStateOptions.Builder()
        .instanceId(instanceId)
        .enabled(false)
        .initiatorId(initiatorId)
        .reasonCode(reasonCode)
        .build();

      Response<Resp2448145Root> response = service.replaceServiceInstanceState(replaceServiceInstanceStateOptions).execute();
      Resp2448145Root result = response.getResult();

      System.out.println(result);
      // end-replace_service_instance_state
    } catch (ServiceResponseException e) {
        logger.error(String.format("Service returned status code %s: %s\nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()), e);
    }

    try {
      // begin-replace_service_instance
      Context contextReq = new Context.Builder()
            .accountId(accountId)
            .crn(instanceId)
            .platform("ibmcloud")
            .build();

        Map<String, String> param = new HashMap<String, String>();
        param.put("example", "property");

      ReplaceServiceInstanceOptions replaceServiceInstanceOptions = new ReplaceServiceInstanceOptions.Builder()
        .instanceId(instanceId)
        .planId(planId)
        .serviceId(serviceId)
        .organizationGuid(orgGuid)
        .spaceGuid(spaceGuid)
        .context(contextReq)
        .parameters(param)
        .acceptsIncomplete(true)
        .build();

      Response<Resp2079872Root> response = service.replaceServiceInstance(replaceServiceInstanceOptions).execute();
      Resp2079872Root result = response.getResult();

      System.out.println(result);
      // end-replace_service_instance
    } catch (ServiceResponseException e) {
        logger.error(String.format("Service returned status code %s: %s\nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()), e);
    }

    try {
      // begin-update_service_instance
      Context contextReq = new Context.Builder()
          .accountId(accountId)
          .crn(instanceId)
          .platform("ibmcloud")
          .build();

      Map<String, String> param = new HashMap<String, String>();
      param.put("example", "property");

      Map<String, String> previousValues = new HashMap<String, String>();
      previousValues.put("plan_id", planId);

      UpdateServiceInstanceOptions updateServiceInstanceOptions = new UpdateServiceInstanceOptions.Builder()
        .instanceId(instanceId)
        .planId(planId)
        .serviceId(serviceId)
        .context(contextReq)
        .parameters(param)
        .previousValues(previousValues)
        .acceptsIncomplete(true)
        .build();

      Response<Resp2079874Root> response = service.updateServiceInstance(updateServiceInstanceOptions).execute();
      Resp2079874Root result = response.getResult();

      System.out.println(result);
      // end-update_service_instance
    } catch (ServiceResponseException e) {
        logger.error(String.format("Service returned status code %s: %s\nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()), e);
    }

    try {
      // begin-list_catalog
      ListCatalogOptions listCatalogOptions = new ListCatalogOptions();

      Response<Resp1874650Root> response = service.listCatalog(listCatalogOptions).execute();
      Resp1874650Root result = response.getResult();

      System.out.println(result);
      // end-list_catalog
    } catch (ServiceResponseException e) {
        logger.error(String.format("Service returned status code %s: %s\nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()), e);
    }

    try {
      // begin-get_last_operation
      GetLastOperationOptions getLastOperationOptions = new GetLastOperationOptions.Builder()
        .instanceId(instanceId)
        .operation(operation)
        .planId(planId)
        .serviceId(serviceId)
        .build();

      Response<Resp2079894Root> response = service.getLastOperation(getLastOperationOptions).execute();
      Resp2079894Root result = response.getResult();

      System.out.println(result);
      // end-get_last_operation
    } catch (ServiceResponseException e) {
        logger.error(String.format("Service returned status code %s: %s\nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()), e);
    }

    try {
      // begin-replace_service_binding
      Map<String, String> param = new HashMap<String, String>();
      param.put("example", "property");

      BindResource bindRes = new BindResource.Builder()
          .accountId(accountId)
          .serviceidCrn(appGuid)
          .build();

      ReplaceServiceBindingOptions replaceServiceBindingOptions = new ReplaceServiceBindingOptions.Builder()
        .instanceId(instanceId)
        .bindingId(bindingId)
        .planId(planId)
        .serviceId(serviceId)
        .parameters(param)
        .bindResource(bindRes)
        .build();

      Response<Resp2079876Root> response = service.replaceServiceBinding(replaceServiceBindingOptions).execute();
      Resp2079876Root result = response.getResult();

      System.out.println(result);
      // end-replace_service_binding
    } catch (ServiceResponseException e) {
        logger.error(String.format("Service returned status code %s: %s\nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()), e);
    }

    try {
      // begin-delete_service_instance
      DeleteServiceInstanceOptions deleteServiceInstanceOptions = new DeleteServiceInstanceOptions.Builder()
        .serviceId(serviceId)
        .planId(planId)
        .instanceId(instanceId)
        .acceptsIncomplete(true)
        .build();

      Response<Resp2079874Root> response = service.deleteServiceInstance(deleteServiceInstanceOptions).execute();
      Resp2079874Root result = response.getResult();

      System.out.println(result);
      // end-delete_service_instance
    } catch (ServiceResponseException e) {
        logger.error(String.format("Service returned status code %s: %s\nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()), e);
    }

    try {
      // begin-delete_service_binding
      DeleteServiceBindingOptions deleteServiceBindingOptions = new DeleteServiceBindingOptions.Builder()
        .bindingId(bindingId)
        .instanceId(instanceId)
        .planId(planId)
        .serviceId(serviceId)
        .build();

      service.deleteServiceBinding(deleteServiceBindingOptions).execute();
      // end-delete_service_binding
    } catch (ServiceResponseException e) {
        logger.error(String.format("Service returned status code %s: %s\nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()), e);
    }

  }
}
