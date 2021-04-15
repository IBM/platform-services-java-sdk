/*
 * (C) Copyright IBM Corp. 2020, 2021.
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

import com.ibm.cloud.platform_services.iam_identity.v1.model.AccountSettingsResponse;
import com.ibm.cloud.platform_services.iam_identity.v1.model.ApiKey;
import com.ibm.cloud.platform_services.iam_identity.v1.model.ApiKeyList;
import com.ibm.cloud.platform_services.iam_identity.v1.model.CreateApiKeyOptions;
import com.ibm.cloud.platform_services.iam_identity.v1.model.CreateServiceIdOptions;
import com.ibm.cloud.platform_services.iam_identity.v1.model.DeleteApiKeyOptions;
import com.ibm.cloud.platform_services.iam_identity.v1.model.DeleteServiceIdOptions;
import com.ibm.cloud.platform_services.iam_identity.v1.model.GetAccountSettingsOptions;
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
import com.ibm.cloud.platform_services.iam_identity.v1.model.UpdateAccountSettingsOptions;
import com.ibm.cloud.platform_services.iam_identity.v1.model.UpdateApiKeyOptions;
import com.ibm.cloud.platform_services.iam_identity.v1.model.UpdateServiceIdOptions;
import com.ibm.cloud.sdk.core.http.Response;
import com.ibm.cloud.sdk.core.service.exception.ServiceResponseException;
import com.ibm.cloud.sdk.core.util.CredentialUtils;

//
// This class provides an example of how to use the IAM Identity service.
//
// The following configuration properties are assumed to be defined:
//
// IAM_IDENTITY_URL=<service url>
// IAM_IDENTITY_AUTHTYPE=iam
// IAM_IDENTITY_AUTH_URL=<IAM Token Service url>
// IAM_IDENTITY_APIKEY=<IAM APIKEY for the User>
// IAM_IDENTITY_ACCOUNT_ID=<AccountID which is unique to the User>
// IAM_IDENTITY_IAM_ID=<IAM ID which is unique to the User account>
//
// These configuration properties can be exported as environment variables, or stored
// in a configuration file and then:
// export IBM_CREDENTIALS_FILE=<name of configuration file>
//
public class IamIdentityExamples {
    private static final Logger logger = LoggerFactory.getLogger(IamIdentityExamples.class);

    protected IamIdentityExamples() {
    }

    private static String apiKeyName = "Example-ApiKey";
    private static String serviceIdName = "Example-ServiceId";

    //values to be read from the env file
    private static String accountId;
    private static String iamId;
    private static String iamApiKey;

    // Variables used to hold various values shared between operations.
    private static String apikeyId;
    private static String apikeyEtag;
    private static String svcId;
    private static String svcIdEtag;
    private static String accountSettingsEtag;

    static {
        System.setProperty("IBM_CREDENTIALS_FILE", "../../iam_identity.env");
    }

    public static void main(String[] args) throws Exception {
        IamIdentity service = IamIdentity.newInstance();

        // Load up our test-specific config properties.
        Map<String, String> config = CredentialUtils.getServiceProperties(IamIdentity.DEFAULT_SERVICE_NAME);
        accountId = config.get("ACCOUNT_ID");
        iamApiKey = config.get("APIKEY");
        iamId = config.get("IAM_ID");

        try {
            System.out.println("createApiKey() result:");

            // begin-create_api_key

            CreateApiKeyOptions createApiKeyOptions = new CreateApiKeyOptions.Builder()
                    .name(apiKeyName)
                    .iamId(iamId)
                    .description("Example ApiKey")
                    .build();

            Response<ApiKey> response = service.createApiKey(createApiKeyOptions).execute();
            ApiKey apiKey = response.getResult();
            apikeyId = apiKey.getId();

            System.out.println(apiKey);

            // end-create_api_key

        } catch (ServiceResponseException e) {
            logger.error(String.format("Service returned status code %s: %s\nError details: %s",
                    e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()), e);
        }

        try {
            System.out.println("listApiKeys() result:");

            // begin-list_api_keys

            ListApiKeysOptions listApiKeysOptions = new ListApiKeysOptions.Builder()
                    .accountId(accountId)
                    .iamId(iamId)
                    .includeHistory(true)
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
            System.out.println("getApiKeysDetails() result:");

            // begin-get_api_keys_details

            GetApiKeysDetailsOptions getApiKeysDetailsOptions = new GetApiKeysDetailsOptions.Builder()
                    .iamApiKey(iamApiKey)
                    .includeHistory(false)
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
            System.out.println("getApiKey() result:");

            // begin-get_api_key

            GetApiKeyOptions getApiKeyOptions = new GetApiKeyOptions.Builder()
                    .id(apikeyId)
                    .includeHistory(true)
                    .build();

            Response<ApiKey> response = service.getApiKey(getApiKeyOptions).execute();
            ApiKey apiKey = response.getResult();
            apikeyEtag = response.getHeaders().values("Etag").get(0);

            System.out.println(apiKey);

            // end-get_api_key

        } catch (ServiceResponseException e) {
            logger.error(String.format("Service returned status code %s: %s\nError details: %s",
                    e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()), e);
        }

        try {
            System.out.println("updateApiKey() result:");

            // begin-update_api_key

            UpdateApiKeyOptions updateApiKeyOptions = new UpdateApiKeyOptions.Builder()
                    .id(apikeyId)
                    .ifMatch(apikeyEtag)
                    .description("This is an updated description")
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
                    .id(apikeyId)
                    .build();

            Response<Void> response = service.lockApiKey(lockApiKeyOptions).execute();

            // end-lock_api_key

            System.out.printf("lockApiKey() response status code: %d%n", response.getStatusCode());
        } catch (ServiceResponseException e) {
            logger.error(String.format("Service returned status code %s: %s\nError details: %s",
                    e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()), e);
        }

        try {

            // begin-unlock_api_key

            UnlockApiKeyOptions unlockApiKeyOptions = new UnlockApiKeyOptions.Builder()
                    .id(apikeyId)
                    .build();

            Response<Void> response = service.unlockApiKey(unlockApiKeyOptions).execute();

            // end-unlock_api_key

            System.out.printf("unlockApiKey() response status code: %d%n", response.getStatusCode());
        } catch (ServiceResponseException e) {
            logger.error(String.format("Service returned status code %s: %s\nError details: %s",
                    e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()), e);
        }

        try {

            // begin-delete_api_key

            DeleteApiKeyOptions deleteApiKeyOptions = new DeleteApiKeyOptions.Builder()
                    .id(apikeyId)
                    .build();

            Response<Void> response = service.deleteApiKey(deleteApiKeyOptions).execute();

            // end-delete_api_key

            System.out.printf("deleteApiKey() response status code: %d%n", response.getStatusCode());
        } catch (ServiceResponseException e) {
            logger.error(String.format("Service returned status code %s: %s\nError details: %s",
                    e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()), e);
        }

        try {
            System.out.println("createServiceId() result:");

            // begin-create_service_id

            CreateServiceIdOptions createServiceIdOptions = new CreateServiceIdOptions.Builder()
                    .accountId(accountId)
                    .name(serviceIdName)
                    .description("Example ServiceId")
                    .build();

            Response<ServiceId> response = service.createServiceId(createServiceIdOptions).execute();
            ServiceId serviceId = response.getResult();
            svcId = serviceId.getId();

            System.out.println(serviceId);

            // end-create_service_id

        } catch (ServiceResponseException e) {
            logger.error(String.format("Service returned status code %s: %s\nError details: %s",
                    e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()), e);
        }

        try {
            System.out.println("getServiceId() result:");

            // begin-get_service_id

            GetServiceIdOptions getServiceIdOptions = new GetServiceIdOptions.Builder()
                    .id(svcId)
                    .build();

            Response<ServiceId> response = service.getServiceId(getServiceIdOptions).execute();
            ServiceId serviceId = response.getResult();
            svcIdEtag = response.getHeaders().values("Etag").get(0);

            System.out.println(serviceId);

            // end-get_service_id

        } catch (ServiceResponseException e) {
            logger.error(String.format("Service returned status code %s: %s\nError details: %s",
                    e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()), e);
        }

        try {
            System.out.println("listServiceIds() result:");

            // begin-list_service_ids

            ListServiceIdsOptions listServiceIdsOptions = new ListServiceIdsOptions.Builder()
                    .accountId(accountId)
                    .name(serviceIdName)
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
            System.out.println("updateServiceId() result:");

            // begin-update_service_id

            UpdateServiceIdOptions updateServiceIdOptions = new UpdateServiceIdOptions.Builder()
                    .id(svcId)
                    .ifMatch(svcIdEtag)
                    .description("This is an updated description")
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
                    .id(svcId)
                    .build();

            Response<Void> response = service.lockServiceId(lockServiceIdOptions).execute();

            // end-lock_service_id

            System.out.printf("lockServiceId() response status code: %d%n", response.getStatusCode());
        } catch (ServiceResponseException e) {
            logger.error(String.format("Service returned status code %s: %s\nError details: %s",
                    e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()), e);
        }

        try {

            // begin-unlock_service_id

            UnlockServiceIdOptions unlockServiceIdOptions = new UnlockServiceIdOptions.Builder()
                    .id(svcId)
                    .build();

            Response<Void> response = service.unlockServiceId(unlockServiceIdOptions).execute();

            // end-unlock_service_id

            System.out.printf("unlockServiceId() response status code: %d%n", response.getStatusCode());
        } catch (ServiceResponseException e) {
            logger.error(String.format("Service returned status code %s: %s\nError details: %s",
                    e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()), e);
        }

        try {

            // begin-delete_service_id

            DeleteServiceIdOptions deleteServiceIdOptions = new DeleteServiceIdOptions.Builder()
                    .id(svcId)
                    .build();

            Response<Void> response = service.deleteServiceId(deleteServiceIdOptions).execute();

            // end-delete_service_id

            System.out.printf("deleteServiceId() response status code: %d%n", response.getStatusCode());
        } catch (ServiceResponseException e) {
            logger.error(String.format("Service returned status code %s: %s\nError details: %s",
                    e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()), e);
        }

        try {
            System.out.println("getAccountSettings() result:");

            // begin-getAccountSettings

            GetAccountSettingsOptions getAccountSettingsOptions = new GetAccountSettingsOptions.Builder()
                    .accountId(accountId)
                    .build();

            Response<AccountSettingsResponse> response = service.getAccountSettings(getAccountSettingsOptions).execute();
            AccountSettingsResponse accountSettingsResponse = response.getResult();

            accountSettingsEtag = response.getHeaders().values("Etag").get(0);

            System.out.println(accountSettingsResponse);

            // end-getAccountSettings

        } catch (ServiceResponseException e) {
            logger.error(String.format("Service returned status code %s: %s\nError details: %s",
                    e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()), e);
        }

        try {
            System.out.println("updateAccountSettings() result:");

            // begin-updateAccountSettings

            UpdateAccountSettingsOptions updateAccountSettingsOptions = new UpdateAccountSettingsOptions.Builder()
                    .ifMatch(accountSettingsEtag)
                    .accountId(accountId)
                    .sessionExpirationInSeconds("86400")
                    .sessionInvalidationInSeconds("7200")
                    .restrictCreatePlatformApikey("NOT_RESTRICTED")
                    .restrictCreateServiceId("NOT_RESTRICTED")
                    .mfa("NONE")
                    .build();

            Response<AccountSettingsResponse> response = service.updateAccountSettings(updateAccountSettingsOptions).execute();
            AccountSettingsResponse accountSettingsResponse = response.getResult();

            System.out.println(accountSettingsResponse);

            // end-updateAccountSettings

        } catch (ServiceResponseException e) {
            logger.error(String.format("Service returned status code %s: %s\nError details: %s",
                    e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()), e);
        }
    }
}
