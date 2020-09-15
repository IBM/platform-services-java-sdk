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

package com.ibm.cloud.platform_services.iam_identity.v1;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.ibm.cloud.platform_services.iam_identity.v1.model.ApiKey;
import com.ibm.cloud.platform_services.iam_identity.v1.model.ApiKeyList;
import com.ibm.cloud.platform_services.iam_identity.v1.model.CreateApiKeyOptions;
import com.ibm.cloud.platform_services.iam_identity.v1.model.CreateServiceIdOptions;
import com.ibm.cloud.platform_services.iam_identity.v1.model.DeleteApiKeyOptions;
import com.ibm.cloud.platform_services.iam_identity.v1.model.DeleteServiceIdOptions;
import com.ibm.cloud.platform_services.iam_identity.v1.model.GetApiKeyOptions;
import com.ibm.cloud.platform_services.iam_identity.v1.model.GetApiKeysDetailsOptions;
import com.ibm.cloud.platform_services.iam_identity.v1.model.GetServiceIdOptions;
import com.ibm.cloud.platform_services.iam_identity.v1.model.ListApiKeysOptions;
import com.ibm.cloud.platform_services.iam_identity.v1.model.ListServiceIdsOptions;
import com.ibm.cloud.platform_services.iam_identity.v1.model.LockApiKeyOptions;
import com.ibm.cloud.platform_services.iam_identity.v1.model.LockServiceIdOptions;
import com.ibm.cloud.platform_services.iam_identity.v1.model.ServiceId;
import com.ibm.cloud.platform_services.iam_identity.v1.model.ServiceIdList;
import com.ibm.cloud.platform_services.iam_identity.v1.model.UnlockApiKeyOptions;
import com.ibm.cloud.platform_services.iam_identity.v1.model.UnlockServiceIdOptions;
import com.ibm.cloud.platform_services.iam_identity.v1.model.UpdateApiKeyOptions;
import com.ibm.cloud.platform_services.iam_identity.v1.model.UpdateServiceIdOptions;
import com.ibm.cloud.sdk.core.http.Response;
import com.ibm.cloud.sdk.core.service.exception.ServiceResponseException;
import com.ibm.cloud.sdk.core.util.CredentialUtils;

public class IamIdentityExamples {
  private static final Logger logger = LoggerFactory.getLogger(IamIdentityExamples.class);
  protected IamIdentityExamples() { }


  static {
      System.setProperty("IBM_CREDENTIALS_FILE", "../../iam_identity.env");
  }

  public static void main(String[] args) throws Exception {
    IamIdentity service = IamIdentity.newInstance();

    // Load up our test-specific config properties.
    Map<String, String> config = CredentialUtils.getServiceProperties(IamIdentity.DEFAULT_SERVICE_NAME);

    try {
      // begin-list_api_keys
      ListApiKeysOptions listApiKeysOptions = new ListApiKeysOptions.Builder()
        .build();

      Response<ApiKeyList> response = service.listApiKeys(listApiKeysOptions).execute();
      ApiKeyList apiKeyList = response.getResult();

      System.out.println(apiKeyList);
      // end-list_api_keys
    } catch (ServiceResponseException e) {
        logger.error(String.format("Service returned status code %s: %s\nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()), e);
    }

    try {
      // begin-create_api_key
      CreateApiKeyOptions createApiKeyOptions = new CreateApiKeyOptions.Builder()
        .name("testString")
        .iamId("testString")
        .build();

      Response<ApiKey> response = service.createApiKey(createApiKeyOptions).execute();
      ApiKey apiKey = response.getResult();

      System.out.println(apiKey);
      // end-create_api_key
    } catch (ServiceResponseException e) {
        logger.error(String.format("Service returned status code %s: %s\nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()), e);
    }

    try {
      // begin-get_api_keys_details
      GetApiKeysDetailsOptions getApiKeysDetailsOptions = new GetApiKeysDetailsOptions.Builder()
        .build();

      Response<ApiKey> response = service.getApiKeysDetails(getApiKeysDetailsOptions).execute();
      ApiKey apiKey = response.getResult();

      System.out.println(apiKey);
      // end-get_api_keys_details
    } catch (ServiceResponseException e) {
        logger.error(String.format("Service returned status code %s: %s\nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()), e);
    }

    try {
      // begin-get_api_key
      GetApiKeyOptions getApiKeyOptions = new GetApiKeyOptions.Builder()
        .id("testString")
        .build();

      Response<ApiKey> response = service.getApiKey(getApiKeyOptions).execute();
      ApiKey apiKey = response.getResult();

      System.out.println(apiKey);
      // end-get_api_key
    } catch (ServiceResponseException e) {
        logger.error(String.format("Service returned status code %s: %s\nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()), e);
    }

    try {
      // begin-update_api_key
      UpdateApiKeyOptions updateApiKeyOptions = new UpdateApiKeyOptions.Builder()
        .id("testString")
        .ifMatch("testString")
        .build();

      Response<ApiKey> response = service.updateApiKey(updateApiKeyOptions).execute();
      ApiKey apiKey = response.getResult();

      System.out.println(apiKey);
      // end-update_api_key
    } catch (ServiceResponseException e) {
        logger.error(String.format("Service returned status code %s: %s\nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()), e);
    }

    try {
      // begin-lock_api_key
      LockApiKeyOptions lockApiKeyOptions = new LockApiKeyOptions.Builder()
        .id("testString")
        .build();

      service.lockApiKey(lockApiKeyOptions).execute();
      // end-lock_api_key
    } catch (ServiceResponseException e) {
        logger.error(String.format("Service returned status code %s: %s\nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()), e);
    }

    try {
      // begin-list_service_ids
      ListServiceIdsOptions listServiceIdsOptions = new ListServiceIdsOptions.Builder()
        .build();

      Response<ServiceIdList> response = service.listServiceIds(listServiceIdsOptions).execute();
      ServiceIdList serviceIdList = response.getResult();

      System.out.println(serviceIdList);
      // end-list_service_ids
    } catch (ServiceResponseException e) {
        logger.error(String.format("Service returned status code %s: %s\nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()), e);
    }

    try {
      // begin-create_service_id
      CreateServiceIdOptions createServiceIdOptions = new CreateServiceIdOptions.Builder()
        .accountId("testString")
        .name("testString")
        .build();

      Response<ServiceId> response = service.createServiceId(createServiceIdOptions).execute();
      ServiceId serviceId = response.getResult();

      System.out.println(serviceId);
      // end-create_service_id
    } catch (ServiceResponseException e) {
        logger.error(String.format("Service returned status code %s: %s\nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()), e);
    }

    try {
      // begin-get_service_id
      GetServiceIdOptions getServiceIdOptions = new GetServiceIdOptions.Builder()
        .id("testString")
        .build();

      Response<ServiceId> response = service.getServiceId(getServiceIdOptions).execute();
      ServiceId serviceId = response.getResult();

      System.out.println(serviceId);
      // end-get_service_id
    } catch (ServiceResponseException e) {
        logger.error(String.format("Service returned status code %s: %s\nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()), e);
    }

    try {
      // begin-update_service_id
      UpdateServiceIdOptions updateServiceIdOptions = new UpdateServiceIdOptions.Builder()
        .id("testString")
        .ifMatch("testString")
        .build();

      Response<ServiceId> response = service.updateServiceId(updateServiceIdOptions).execute();
      ServiceId serviceId = response.getResult();

      System.out.println(serviceId);
      // end-update_service_id
    } catch (ServiceResponseException e) {
        logger.error(String.format("Service returned status code %s: %s\nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()), e);
    }

    try {
      // begin-lock_service_id
      LockServiceIdOptions lockServiceIdOptions = new LockServiceIdOptions.Builder()
        .id("testString")
        .build();

      Response<ServiceId> response = service.lockServiceId(lockServiceIdOptions).execute();
      ServiceId serviceId = response.getResult();

      System.out.println(serviceId);
      // end-lock_service_id
    } catch (ServiceResponseException e) {
        logger.error(String.format("Service returned status code %s: %s\nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()), e);
    }

    try {
      // begin-unlock_service_id
      UnlockServiceIdOptions unlockServiceIdOptions = new UnlockServiceIdOptions.Builder()
        .id("testString")
        .build();

      Response<ServiceId> response = service.unlockServiceId(unlockServiceIdOptions).execute();
      ServiceId serviceId = response.getResult();

      System.out.println(serviceId);
      // end-unlock_service_id
    } catch (ServiceResponseException e) {
        logger.error(String.format("Service returned status code %s: %s\nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()), e);
    }

    try {
      // begin-unlock_api_key
      UnlockApiKeyOptions unlockApiKeyOptions = new UnlockApiKeyOptions.Builder()
        .id("testString")
        .build();

      service.unlockApiKey(unlockApiKeyOptions).execute();
      // end-unlock_api_key
    } catch (ServiceResponseException e) {
        logger.error(String.format("Service returned status code %s: %s\nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()), e);
    }

    try {
      // begin-delete_service_id
      DeleteServiceIdOptions deleteServiceIdOptions = new DeleteServiceIdOptions.Builder()
        .id("testString")
        .build();

      service.deleteServiceId(deleteServiceIdOptions).execute();
      // end-delete_service_id
    } catch (ServiceResponseException e) {
        logger.error(String.format("Service returned status code %s: %s\nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()), e);
    }

    try {
      // begin-delete_api_key
      DeleteApiKeyOptions deleteApiKeyOptions = new DeleteApiKeyOptions.Builder()
        .id("testString")
        .build();

      service.deleteApiKey(deleteApiKeyOptions).execute();
      // end-delete_api_key
    } catch (ServiceResponseException e) {
        logger.error(String.format("Service returned status code %s: %s\nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()), e);
    }

  }
}
