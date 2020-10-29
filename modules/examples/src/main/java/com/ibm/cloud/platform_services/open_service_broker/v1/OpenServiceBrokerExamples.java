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
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class OpenServiceBrokerExamples {
  private static final Logger logger = LoggerFactory.getLogger(OpenServiceBrokerExamples.class);
  protected OpenServiceBrokerExamples() { }


  static {
      System.setProperty("IBM_CREDENTIALS_FILE", "../../open_service_broker.env");
  }

  public static void main(String[] args) throws Exception {
    OpenServiceBroker service = OpenServiceBroker.newInstance();

    // Load up our test-specific config properties.
    Map<String, String> config = CredentialUtils.getServiceProperties(OpenServiceBroker.DEFAULT_SERVICE_NAME);

    try {
      // begin-get_service_instance_state
      GetServiceInstanceStateOptions getServiceInstanceStateOptions = new GetServiceInstanceStateOptions.Builder()
        .instanceId("testString")
        .build();

      Response<Resp1874644Root> response = service.getServiceInstanceState(getServiceInstanceStateOptions).execute();
      Resp1874644Root resp1874644Root = response.getResult();

      System.out.println(resp1874644Root);
      // end-get_service_instance_state
    } catch (ServiceResponseException e) {
        logger.error(String.format("Service returned status code %s: %s\nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()), e);
    }

    try {
      // begin-replace_service_instance_state
      ReplaceServiceInstanceStateOptions replaceServiceInstanceStateOptions = new ReplaceServiceInstanceStateOptions.Builder()
        .instanceId("testString")
        .build();

      Response<Resp2448145Root> response = service.replaceServiceInstanceState(replaceServiceInstanceStateOptions).execute();
      Resp2448145Root resp2448145Root = response.getResult();

      System.out.println(resp2448145Root);
      // end-replace_service_instance_state
    } catch (ServiceResponseException e) {
        logger.error(String.format("Service returned status code %s: %s\nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()), e);
    }

    try {
      // begin-replace_service_instance
      ReplaceServiceInstanceOptions replaceServiceInstanceOptions = new ReplaceServiceInstanceOptions.Builder()
        .instanceId("testString")
        .build();

      Response<Resp2079872Root> response = service.replaceServiceInstance(replaceServiceInstanceOptions).execute();
      Resp2079872Root resp2079872Root = response.getResult();

      System.out.println(resp2079872Root);
      // end-replace_service_instance
    } catch (ServiceResponseException e) {
        logger.error(String.format("Service returned status code %s: %s\nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()), e);
    }

    try {
      // begin-update_service_instance
      UpdateServiceInstanceOptions updateServiceInstanceOptions = new UpdateServiceInstanceOptions.Builder()
        .instanceId("testString")
        .build();

      Response<Resp2079874Root> response = service.updateServiceInstance(updateServiceInstanceOptions).execute();
      Resp2079874Root resp2079874Root = response.getResult();

      System.out.println(resp2079874Root);
      // end-update_service_instance
    } catch (ServiceResponseException e) {
        logger.error(String.format("Service returned status code %s: %s\nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()), e);
    }

    try {
      // begin-list_catalog
      ListCatalogOptions listCatalogOptions = new ListCatalogOptions();

      Response<Resp1874650Root> response = service.listCatalog(listCatalogOptions).execute();
      Resp1874650Root resp1874650Root = response.getResult();

      System.out.println(resp1874650Root);
      // end-list_catalog
    } catch (ServiceResponseException e) {
        logger.error(String.format("Service returned status code %s: %s\nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()), e);
    }

    try {
      // begin-get_last_operation
      GetLastOperationOptions getLastOperationOptions = new GetLastOperationOptions.Builder()
        .instanceId("testString")
        .build();

      Response<Resp2079894Root> response = service.getLastOperation(getLastOperationOptions).execute();
      Resp2079894Root resp2079894Root = response.getResult();

      System.out.println(resp2079894Root);
      // end-get_last_operation
    } catch (ServiceResponseException e) {
        logger.error(String.format("Service returned status code %s: %s\nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()), e);
    }

    try {
      // begin-replace_service_binding
      ReplaceServiceBindingOptions replaceServiceBindingOptions = new ReplaceServiceBindingOptions.Builder()
        .bindingId("testString")
        .instanceId("testString")
        .build();

      Response<Resp2079876Root> response = service.replaceServiceBinding(replaceServiceBindingOptions).execute();
      Resp2079876Root resp2079876Root = response.getResult();

      System.out.println(resp2079876Root);
      // end-replace_service_binding
    } catch (ServiceResponseException e) {
        logger.error(String.format("Service returned status code %s: %s\nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()), e);
    }

    try {
      // begin-delete_service_instance
      DeleteServiceInstanceOptions deleteServiceInstanceOptions = new DeleteServiceInstanceOptions.Builder()
        .serviceId("testString")
        .planId("testString")
        .instanceId("testString")
        .build();

      Response<Resp2079874Root> response = service.deleteServiceInstance(deleteServiceInstanceOptions).execute();
      Resp2079874Root resp2079874Root = response.getResult();

      System.out.println(resp2079874Root);
      // end-delete_service_instance
    } catch (ServiceResponseException e) {
        logger.error(String.format("Service returned status code %s: %s\nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()), e);
    }

    try {
      // begin-delete_service_binding
      DeleteServiceBindingOptions deleteServiceBindingOptions = new DeleteServiceBindingOptions.Builder()
        .bindingId("testString")
        .instanceId("testString")
        .planId("testString")
        .serviceId("testString")
        .build();

      service.deleteServiceBinding(deleteServiceBindingOptions).execute();
      // end-delete_service_binding
    } catch (ServiceResponseException e) {
        logger.error(String.format("Service returned status code %s: %s\nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()), e);
    }

  }
}
