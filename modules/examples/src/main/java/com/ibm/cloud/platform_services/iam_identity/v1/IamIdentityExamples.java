/*
 * (C) Copyright IBM Corp. 2020, 2023.
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

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.ibm.cloud.platform_services.iam_identity.v1.model.AccountSettingsComponent;
import com.ibm.cloud.platform_services.iam_identity.v1.model.AccountSettingsResponse;
import com.ibm.cloud.platform_services.iam_identity.v1.model.AccountSettingsTemplateList;
import com.ibm.cloud.platform_services.iam_identity.v1.model.AccountSettingsTemplateResponse;
import com.ibm.cloud.platform_services.iam_identity.v1.model.AccountSettingsUserMFA;
import com.ibm.cloud.platform_services.iam_identity.v1.model.ApiKey;
import com.ibm.cloud.platform_services.iam_identity.v1.model.ApiKeyList;
import com.ibm.cloud.platform_services.iam_identity.v1.model.CommitAccountSettingsTemplateOptions;
import com.ibm.cloud.platform_services.iam_identity.v1.model.CommitProfileTemplateOptions;
import com.ibm.cloud.platform_services.iam_identity.v1.model.CreateAccountSettingsAssignmentOptions;
import com.ibm.cloud.platform_services.iam_identity.v1.model.CreateAccountSettingsTemplateOptions;
import com.ibm.cloud.platform_services.iam_identity.v1.model.CreateAccountSettingsTemplateVersionOptions;
import com.ibm.cloud.platform_services.iam_identity.v1.model.CreateApiKeyOptions;
import com.ibm.cloud.platform_services.iam_identity.v1.model.CreateClaimRuleOptions;
import com.ibm.cloud.platform_services.iam_identity.v1.model.CreateLinkOptions;
import com.ibm.cloud.platform_services.iam_identity.v1.model.CreateMfaReportOptions;
import com.ibm.cloud.platform_services.iam_identity.v1.model.CreateProfileLinkRequestLink;
import com.ibm.cloud.platform_services.iam_identity.v1.model.CreateProfileOptions;
import com.ibm.cloud.platform_services.iam_identity.v1.model.CreateProfileTemplateOptions;
import com.ibm.cloud.platform_services.iam_identity.v1.model.CreateProfileTemplateVersionOptions;
import com.ibm.cloud.platform_services.iam_identity.v1.model.CreateReportOptions;
import com.ibm.cloud.platform_services.iam_identity.v1.model.CreateServiceIdOptions;
import com.ibm.cloud.platform_services.iam_identity.v1.model.CreateTrustedProfileAssignmentOptions;
import com.ibm.cloud.platform_services.iam_identity.v1.model.DeleteAccountSettingsAssignmentOptions;
import com.ibm.cloud.platform_services.iam_identity.v1.model.DeleteAccountSettingsTemplateVersionOptions;
import com.ibm.cloud.platform_services.iam_identity.v1.model.DeleteAllVersionsOfAccountSettingsTemplateOptions;
import com.ibm.cloud.platform_services.iam_identity.v1.model.DeleteAllVersionsOfProfileTemplateOptions;
import com.ibm.cloud.platform_services.iam_identity.v1.model.DeleteApiKeyOptions;
import com.ibm.cloud.platform_services.iam_identity.v1.model.DeleteClaimRuleOptions;
import com.ibm.cloud.platform_services.iam_identity.v1.model.DeleteLinkOptions;
import com.ibm.cloud.platform_services.iam_identity.v1.model.DeleteProfileIdentityOptions;
import com.ibm.cloud.platform_services.iam_identity.v1.model.DeleteProfileOptions;
import com.ibm.cloud.platform_services.iam_identity.v1.model.DeleteProfileTemplateVersionOptions;
import com.ibm.cloud.platform_services.iam_identity.v1.model.DeleteServiceIdOptions;
import com.ibm.cloud.platform_services.iam_identity.v1.model.DeleteTrustedProfileAssignmentOptions;
import com.ibm.cloud.platform_services.iam_identity.v1.model.ExceptionResponse;
import com.ibm.cloud.platform_services.iam_identity.v1.model.GetAccountSettingsAssignmentOptions;
import com.ibm.cloud.platform_services.iam_identity.v1.model.GetAccountSettingsOptions;
import com.ibm.cloud.platform_services.iam_identity.v1.model.GetAccountSettingsTemplateVersionOptions;
import com.ibm.cloud.platform_services.iam_identity.v1.model.GetApiKeyOptions;
import com.ibm.cloud.platform_services.iam_identity.v1.model.GetApiKeysDetailsOptions;
import com.ibm.cloud.platform_services.iam_identity.v1.model.GetClaimRuleOptions;
import com.ibm.cloud.platform_services.iam_identity.v1.model.GetLatestAccountSettingsTemplateVersionOptions;
import com.ibm.cloud.platform_services.iam_identity.v1.model.GetLatestProfileTemplateVersionOptions;
import com.ibm.cloud.platform_services.iam_identity.v1.model.GetLinkOptions;
import com.ibm.cloud.platform_services.iam_identity.v1.model.GetMfaReportOptions;
import com.ibm.cloud.platform_services.iam_identity.v1.model.GetMfaStatusOptions;
import com.ibm.cloud.platform_services.iam_identity.v1.model.GetProfileIdentitiesOptions;
import com.ibm.cloud.platform_services.iam_identity.v1.model.GetProfileIdentityOptions;
import com.ibm.cloud.platform_services.iam_identity.v1.model.GetProfileOptions;
import com.ibm.cloud.platform_services.iam_identity.v1.model.GetProfileTemplateVersionOptions;
import com.ibm.cloud.platform_services.iam_identity.v1.model.GetReportOptions;
import com.ibm.cloud.platform_services.iam_identity.v1.model.GetServiceIdOptions;
import com.ibm.cloud.platform_services.iam_identity.v1.model.GetTrustedProfileAssignmentOptions;
import com.ibm.cloud.platform_services.iam_identity.v1.model.ListAccountSettingsTemplatesOptions;
import com.ibm.cloud.platform_services.iam_identity.v1.model.ListApiKeysOptions;
import com.ibm.cloud.platform_services.iam_identity.v1.model.ListClaimRulesOptions;
import com.ibm.cloud.platform_services.iam_identity.v1.model.ListLinksOptions;
import com.ibm.cloud.platform_services.iam_identity.v1.model.ListProfileTemplatesOptions;
import com.ibm.cloud.platform_services.iam_identity.v1.model.ListProfilesOptions;
import com.ibm.cloud.platform_services.iam_identity.v1.model.ListServiceIdsOptions;
import com.ibm.cloud.platform_services.iam_identity.v1.model.ListTrustedProfileAssignmentsOptions;
import com.ibm.cloud.platform_services.iam_identity.v1.model.ListVersionsOfAccountSettingsTemplateOptions;
import com.ibm.cloud.platform_services.iam_identity.v1.model.ListVersionsOfProfileTemplateOptions;
import com.ibm.cloud.platform_services.iam_identity.v1.model.LockApiKeyOptions;
import com.ibm.cloud.platform_services.iam_identity.v1.model.LockServiceIdOptions;
import com.ibm.cloud.platform_services.iam_identity.v1.model.ProfileClaimRule;
import com.ibm.cloud.platform_services.iam_identity.v1.model.ProfileClaimRuleConditions;
import com.ibm.cloud.platform_services.iam_identity.v1.model.ProfileClaimRuleList;
import com.ibm.cloud.platform_services.iam_identity.v1.model.ProfileIdentitiesResponse;
import com.ibm.cloud.platform_services.iam_identity.v1.model.ProfileIdentityRequest;
import com.ibm.cloud.platform_services.iam_identity.v1.model.ProfileIdentityResponse;
import com.ibm.cloud.platform_services.iam_identity.v1.model.ProfileLink;
import com.ibm.cloud.platform_services.iam_identity.v1.model.ProfileLinkList;
import com.ibm.cloud.platform_services.iam_identity.v1.model.Report;
import com.ibm.cloud.platform_services.iam_identity.v1.model.ReportMfaEnrollmentStatus;
import com.ibm.cloud.platform_services.iam_identity.v1.model.ReportReference;
import com.ibm.cloud.platform_services.iam_identity.v1.model.ServiceId;
import com.ibm.cloud.platform_services.iam_identity.v1.model.ServiceIdList;
import com.ibm.cloud.platform_services.iam_identity.v1.model.SetProfileIdentitiesOptions;
import com.ibm.cloud.platform_services.iam_identity.v1.model.SetProfileIdentityOptions;
import com.ibm.cloud.platform_services.iam_identity.v1.model.TemplateAssignmentListResponse;
import com.ibm.cloud.platform_services.iam_identity.v1.model.TemplateAssignmentResponse;
import com.ibm.cloud.platform_services.iam_identity.v1.model.TemplateProfileComponentRequest;
import com.ibm.cloud.platform_services.iam_identity.v1.model.TrustedProfile;
import com.ibm.cloud.platform_services.iam_identity.v1.model.TrustedProfileTemplateClaimRule;
import com.ibm.cloud.platform_services.iam_identity.v1.model.TrustedProfileTemplateList;
import com.ibm.cloud.platform_services.iam_identity.v1.model.TrustedProfileTemplateResponse;
import com.ibm.cloud.platform_services.iam_identity.v1.model.TrustedProfilesList;
import com.ibm.cloud.platform_services.iam_identity.v1.model.UnlockApiKeyOptions;
import com.ibm.cloud.platform_services.iam_identity.v1.model.UnlockServiceIdOptions;
import com.ibm.cloud.platform_services.iam_identity.v1.model.UpdateAccountSettingsAssignmentOptions;
import com.ibm.cloud.platform_services.iam_identity.v1.model.UpdateAccountSettingsOptions;
import com.ibm.cloud.platform_services.iam_identity.v1.model.UpdateAccountSettingsTemplateVersionOptions;
import com.ibm.cloud.platform_services.iam_identity.v1.model.UpdateApiKeyOptions;
import com.ibm.cloud.platform_services.iam_identity.v1.model.UpdateClaimRuleOptions;
import com.ibm.cloud.platform_services.iam_identity.v1.model.UpdateProfileOptions;
import com.ibm.cloud.platform_services.iam_identity.v1.model.UpdateProfileTemplateVersionOptions;
import com.ibm.cloud.platform_services.iam_identity.v1.model.UpdateServiceIdOptions;
import com.ibm.cloud.platform_services.iam_identity.v1.model.UpdateTrustedProfileAssignmentOptions;
import com.ibm.cloud.platform_services.iam_identity.v1.model.UserMfaEnrollments;
import com.ibm.cloud.sdk.core.http.Response;
import com.ibm.cloud.sdk.core.service.exception.NotFoundException;
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
// IAM_IDENTITY_IAM_ID_MEMBER=<IAM ID of a user belonging to the account but different to the one above>
// IAM_IDENTITY_ENTERPISE_ACCOUNT_ID=<AccountID of the enterprise account>
// IAM_IDENTITY_ENTERPISE_SUBACCOUNT_ID=<AccountID of an account in the enterprise>
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
    private static String profileName = "Example-Profile";
    private static String claimRuleType = "Profile-SAML";
    private static String realmName = "https://my.test.realm/1234/saml20";
    private static String profileTemplateName = "Example-Profile-Template";
    private static String profileTemplateProfileName = "Profile-From-Example-Template";
    private static String accountSettingsTemplateName = "Example-Account-Settings-Template";

    //values to be read from the env file
    private static String accountId;
    private static String iamId;
    private static String iamIdMember;
    private static String iamApiKey;
    private static String enterpriseAccountId;
    private static String enterpriseSubAccountId;

    // Variables used to hold various values shared between operations.
    private static String apikeyId;
    private static String apikeyEtag;
    private static String svcId;
    private static String svcIdEtag;
    private static String profileId;
    private static String profileEtag;
    private static String claimRuleId;
    private static String claimRuleEtag;
    private static String linkId;
    private static String accountSettingsEtag;
    private static String reportReferenceValue;
    private static String profileIdentitiesEtag;
    private static String profileTemplateId;
    private static long profileTemplateVersion;
    private static String profileTemplateEtag;
    private static String profileTemplateAssignmentId;
    private static String profileTemplateAssignmentEtag;
    private static String accountSettingsTemplateId;
    private static long accountSettingsTemplateVersion;
    private static String accountSettingsTemplateEtag;
    private static String accountSettingsTemplateAssignmentId;
    private static String accountSettingsTemplateAssignmentEtag;

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
        iamIdMember = config.get("IAM_ID_MEMBER");
        enterpriseAccountId = config.get("ENTERPRISE_ACCOUNT_ID");
        enterpriseSubAccountId = config.get("ENTERPRISE_SUBACCOUNT_ID");

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
                    .includeActivity(true)
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
                    .includeActivity(false)
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
            System.out.println("createProfile() result:");

            // begin-create_profile

            CreateProfileOptions createProfileOptions = new CreateProfileOptions.Builder()
                    .name(profileName)
                    .description("Example Profile")
                    .accountId(accountId)
                    .build();

            Response<TrustedProfile> response = service.createProfile(createProfileOptions).execute();
            TrustedProfile profile = response.getResult();
            profileId = profile.getId();

            System.out.println(profile);

            // end-create_profile

        } catch (ServiceResponseException e) {
            logger.error(String.format("Service returned status code %s: %s\nError details: %s",
                    e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()), e);
        }

        try {
            System.out.println("getProfile() result:");

            // begin-get_profile

            GetProfileOptions getProfileOptions = new GetProfileOptions.Builder()
                    .profileId(profileId)
                    .includeActivity(false)
                    .build();

            Response<TrustedProfile> response = service.getProfile(getProfileOptions).execute();
            TrustedProfile profile = response.getResult();
            profileEtag = response.getHeaders().values("Etag").get(0);

            System.out.println(profile);

            // end-get_profile

        } catch (ServiceResponseException e) {
            logger.error(String.format("Service returned status code %s: %s\nError details: %s",
                    e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()), e);
        }

        try {
            System.out.println("ListProfiles() result:");

            // begin-list_profiles

            ListProfilesOptions listProfilesOptions = new ListProfilesOptions.Builder()
                    .accountId(accountId)
                    .includeHistory(false)
                    .build();

            Response<TrustedProfilesList> response = service.listProfiles(listProfilesOptions).execute();
            TrustedProfilesList profiles = response.getResult();

            System.out.println(profiles);

            // end-list_profiles

        } catch (ServiceResponseException e) {
            logger.error(String.format("Service returned status code %s: %s\nError details: %s",
                    e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()), e);
        }

        try {
            System.out.println("updateProfile() result:");

            // begin-update_profile

            String newDescription = "updated description";
            UpdateProfileOptions updateProfileOptions = new UpdateProfileOptions.Builder()
                    .profileId(profileId)
                    .ifMatch(profileEtag)
                    .description(newDescription)
                    .build();

            Response<TrustedProfile> response = service.updateProfile(updateProfileOptions).execute();
            TrustedProfile profile = response.getResult();

            System.out.println(profile);

            // end-update_profile

        } catch (ServiceResponseException e) {
            logger.error(String.format("Service returned status code %s: %s\nError details: %s",
                    e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()), e);
        }

        try {
            System.out.println("createClaimRule() result:");

            // begin-create_claim_rule

            ProfileClaimRuleConditions condition = new ProfileClaimRuleConditions.Builder()
                    .claim("blueGroups")
                    .operator("EQUALS")
                    .value("\"cloud-docs-dev\"")
                    .build();

            List<ProfileClaimRuleConditions> conditions = new ArrayList<>();
            conditions.add(condition);

            CreateClaimRuleOptions createClaimRuleOptions = new CreateClaimRuleOptions.Builder()
                    .profileId(profileId)
                    .type(claimRuleType)
                    .realmName(realmName)
                    .expiration(43200)
                    .conditions(conditions)
                    .build();

            Response<ProfileClaimRule> response = service.createClaimRule(createClaimRuleOptions).execute();
            ProfileClaimRule claimRule = response.getResult();
            claimRuleId = claimRule.getId();

            System.out.println(claimRule);

            // end-create_claim_rule

        } catch (ServiceResponseException e) {
            logger.error(String.format("Service returned status code %s: %s\nError details: %s",
                    e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()), e);
        }

        try {
            System.out.println("getClaimRule() result:");

            // begin-get_claim_rule

            GetClaimRuleOptions getClaimRuleOptions = new GetClaimRuleOptions.Builder()
                    .profileId(profileId)
                    .ruleId(claimRuleId)
                    .build();

            Response<ProfileClaimRule> response = service.getClaimRule(getClaimRuleOptions).execute();
            ProfileClaimRule claimRule = response.getResult();
            claimRuleEtag = response.getHeaders().values("Etag").get(0);

            System.out.println(claimRule);

            // end-get_claim_rule

        } catch (ServiceResponseException e) {
            logger.error(String.format("Service returned status code %s: %s\nError details: %s",
                    e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()), e);
        }

        try {
            System.out.println("listClaimRule() result:");

            // begin-list_claim_rules

            ListClaimRulesOptions listClaimRulesOptions = new ListClaimRulesOptions.Builder()
                    .profileId(profileId)
                    .build();

            Response<ProfileClaimRuleList> response = service.listClaimRules(listClaimRulesOptions).execute();
            ProfileClaimRuleList claimRules = response.getResult();

            System.out.println(claimRules);

            // end-list_claim_rules

        } catch (ServiceResponseException e) {
            logger.error(String.format("Service returned status code %s: %s\nError details: %s",
                    e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()), e);
        }

        try {
            System.out.println("updateClaimRule() result:");

            // begin-update_claim_rule

            ProfileClaimRuleConditions condition = new ProfileClaimRuleConditions.Builder()
                    .claim("blueGroups")
                    .operator("CONTAINS")
                    .value("\"Europe_Group\"")
                    .build();

            List<ProfileClaimRuleConditions> conditions = new ArrayList<>();
            conditions.add(condition);

            UpdateClaimRuleOptions updateClaimRuleOptions = new UpdateClaimRuleOptions.Builder()
                    .profileId(profileId)
                    .ruleId(claimRuleId)
                    .ifMatch(claimRuleEtag)
                    .expiration(33200)
                    .conditions(conditions)
                    .type(claimRuleType)
                    .realmName(realmName)
                    .build();

            Response<ProfileClaimRule> response = service.updateClaimRule(updateClaimRuleOptions).execute();
            ProfileClaimRule claimRule = response.getResult();

            System.out.println(claimRule);

            // end-update_claim_rule

        } catch (ServiceResponseException e) {
            logger.error(String.format("Service returned status code %s: %s\nError details: %s",
                    e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()), e);
        }

        try {
            System.out.println("deleteClaimRule() result:");

            // begin-delete_claim_rule

            DeleteClaimRuleOptions deleteClaimRuleOptions = new DeleteClaimRuleOptions.Builder()
                    .profileId(profileId)
                    .ruleId(claimRuleId)
                    .build();
            Response<Void> response = service.deleteClaimRule(deleteClaimRuleOptions).execute();

            // end-delete_claim_rule

            System.out.printf("deleteClaimRule() response status code: %d%n", response.getStatusCode());

        } catch (ServiceResponseException e) {
            logger.error(String.format("Service returned status code %s: %s\nError details: %s",
                    e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()), e);
        }

        try {
            System.out.println("createLink() result:");

            // begin-create_link

            CreateProfileLinkRequestLink link = new CreateProfileLinkRequestLink.Builder()
                    .crn("crn:v1:staging:public:iam-identity::a/" + accountId + "::computeresource:Fake-Compute-Resource")
                    .namespace("default")
                    .name("nice name")
                    .build();

            CreateLinkOptions createLinkOptions = new CreateLinkOptions.Builder()
                    .profileId(profileId)
                    .name("Nice link")
                    .crType("ROKS_SA")
                    .link(link)
                    .build();

            Response<ProfileLink> response = service.createLink(createLinkOptions).execute();
            ProfileLink linkResponse = response.getResult();
            linkId = linkResponse.getId();

            System.out.println(linkResponse);

            // end-create_link

        } catch (ServiceResponseException e) {
            logger.error(String.format("Service returned status code %s: %s\nError details: %s",
                    e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()), e);
        }

        try {
            System.out.println("getLink() result:");

            // begin-get_link

            GetLinkOptions getLinkOptions = new GetLinkOptions.Builder()
                    .profileId(profileId)
                    .linkId(linkId)
                    .build();

            Response<ProfileLink> response = service.getLink(getLinkOptions).execute();
            ProfileLink link = response.getResult();

            System.out.println(link);

            // end-get_link

        } catch (ServiceResponseException e) {
            logger.error(String.format("Service returned status code %s: %s\nError details: %s",
                    e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()), e);
        }

        try {
            System.out.println("listLinks() result:");

            // begin-list_links

            ListLinksOptions listLinksOptions = new ListLinksOptions.Builder()
                    .profileId(profileId)
                    .build();

            Response<ProfileLinkList> response = service.listLinks(listLinksOptions).execute();
            ProfileLinkList links = response.getResult();

            System.out.println(links);

            // end-list_links

        } catch (ServiceResponseException e) {
            logger.error(String.format("Service returned status code %s: %s\nError details: %s",
                    e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()), e);
        }

        try {
            System.out.println("deleteLink() result:");

            // begin-delete_link

            DeleteLinkOptions deleteLinkOptions = new DeleteLinkOptions.Builder()
                    .profileId(profileId)
                    .linkId(linkId)
                    .build();
            Response<Void> response = service.deleteLink(deleteLinkOptions).execute();

            // end-delete_link

            System.out.printf("deleteLink() response status code: %d%n", response.getStatusCode());

        } catch (ServiceResponseException e) {
            logger.error(String.format("Service returned status code %s: %s\nError details: %s",
                    e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()), e);
        }

        try {
            System.out.println("getProfileIdentities() result:");

            // begin-get_profile_identities
            GetProfileIdentitiesOptions getProfileIdentitiesOptions = new GetProfileIdentitiesOptions.Builder()
                    .profileId(profileId).build();
            Response<ProfileIdentitiesResponse> response = service.getProfileIdentities(getProfileIdentitiesOptions)
                    .execute();

            ProfileIdentitiesResponse profileIdentityResponseResult = response.getResult();
            profileIdentitiesEtag = profileIdentityResponseResult.getEntityTag();

            // end-get_profile_identities

            System.out.println(profileIdentityResponseResult);

        } catch (ServiceResponseException e) {
            logger.error(String.format("Service returned status code %s: %s\nError details: %s", e.getStatusCode(),
                    e.getMessage(), e.getDebuggingInfo()), e);
        }

        try {
            System.out.println("setProfileIdentities() result:");

            // begin-set_profile_identities
            List<String> accounts = new ArrayList<String>();
            accounts.add(accountId);
            String type = "user";
            String description = "Identity description";
            ProfileIdentityRequest profileIdentity = new ProfileIdentityRequest.Builder()
                    .identifier(iamId)
                    .accounts(accounts)
                    .type(type)
                    .description(description)
                    .build();
            List<ProfileIdentityRequest> listProfileIdentity = new ArrayList<ProfileIdentityRequest>();
            listProfileIdentity.add(profileIdentity);

            SetProfileIdentitiesOptions setProfileIdentitiesOptions = new SetProfileIdentitiesOptions.Builder()
                    .profileId(profileId)
                    .identities(listProfileIdentity)
                    .ifMatch(profileIdentitiesEtag)
                    .build();

            Response<ProfileIdentitiesResponse> response = service.setProfileIdentities(setProfileIdentitiesOptions)
                    .execute();
            ProfileIdentitiesResponse profileIdentitiesResponseResult = response.getResult();

            // end-set_profile_identities

            System.out.println(profileIdentitiesResponseResult);

        } catch (ServiceResponseException e) {
            logger.error(String.format("Service returned status code %s: %s\nError details: %s", e.getStatusCode(),
                    e.getMessage(), e.getDebuggingInfo()), e);
        }

        try {
            System.out.println("setProfileIdentity() result:");

            // begin-set_profile_identity
            List<String> accounts = new ArrayList<String>();
            accounts.add(accountId);
            String type = "user";
            String description = "Identity description";

            SetProfileIdentityOptions setProfileIdentityOptions = new SetProfileIdentityOptions.Builder()
                    .profileId(profileId)
                    .identityType(type)
                    .identifier(iamIdMember)
                    .type("user")
                    .accounts(accounts)
                    .description(description)
                    .build();
            Response<ProfileIdentityResponse> response = service.setProfileIdentity(setProfileIdentityOptions).execute();

            ProfileIdentityResponse profileIdentityResponseResult = response.getResult();
            System.out.println(profileIdentityResponseResult);

            // end-set_profile_identity

        } catch (ServiceResponseException e) {
            logger.error(String.format("Service returned status code %s: %s\nError details: %s", e.getStatusCode(),
                    e.getMessage(), e.getDebuggingInfo()), e);
        }

        try {
            System.out.println("getProfileIdentity() result:");

            // begin-get_profile_identity
            GetProfileIdentityOptions getProfileIdentityOptions = new GetProfileIdentityOptions.Builder()
                    .profileId(profileId)
                    .identityType("user")
                    .identifierId(iamIdMember)
                    .build();
            Response<ProfileIdentityResponse> response = service.getProfileIdentity(getProfileIdentityOptions).execute();

            ProfileIdentityResponse profileIdentityResponseResult = response.getResult();
            System.out.println(profileIdentityResponseResult);

            // end-get_profile_identity

        } catch (ServiceResponseException e) {
            logger.error(String.format("Service returned status code %s: %s\nError details: %s", e.getStatusCode(),
                    e.getMessage(), e.getDebuggingInfo()), e);
        }

        try {
            System.out.println("deleteProfileIdentity() result:");

            // begin-delete_profile_identity
            DeleteProfileIdentityOptions deleteProfileIdentityOptions = new DeleteProfileIdentityOptions.Builder()
                    .profileId(profileId)
                    .identityType("user")
                    .identifierId(iamIdMember)
                    .build();
            Response<Void> response = service.deleteProfileIdentity(deleteProfileIdentityOptions).execute();

            Void profileIdentityResponseResult = response.getResult();
            System.out.println(profileIdentityResponseResult);

            // end-delete_profile_identity

        } catch (ServiceResponseException e) {
            logger.error(String.format("Service returned status code %s: %s\nError details: %s", e.getStatusCode(),
                    e.getMessage(), e.getDebuggingInfo()), e);
        }


        try {
            System.out.println("deleteProfile() result:");

            // begin-delete_profile

            DeleteProfileOptions deleteProfileOptions = new DeleteProfileOptions.Builder()
                    .profileId(profileId)
                    .build();

            Response<Void> response = service.deleteProfile(deleteProfileOptions).execute();

            // end-delete_profile

            System.out.printf("deleteProfile() response status code: %d%n", response.getStatusCode());

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

            AccountSettingsUserMFA userMFA = new AccountSettingsUserMFA.Builder()
                    .iamId(iamIdMember)
                    .mfa("NONE")
                    .build();

            List<AccountSettingsUserMFA> userMFAExpList = new ArrayList<>();
            userMFAExpList.add(userMFA);

            UpdateAccountSettingsOptions updateAccountSettingsOptions = new UpdateAccountSettingsOptions.Builder()
                    .ifMatch(accountSettingsEtag)
                    .accountId(accountId)
                    .sessionExpirationInSeconds("86400")
                    .sessionInvalidationInSeconds("7200")
                    .restrictCreatePlatformApikey("NOT_RESTRICTED")
                    .restrictCreateServiceId("NOT_RESTRICTED")
                    .mfa("NONE")
                    .userMfa(userMFAExpList)
                    .systemAccessTokenExpirationInSeconds("3600")
                    .systemRefreshTokenExpirationInSeconds("259200")
                    .build();

            Response<AccountSettingsResponse> response = service.updateAccountSettings(updateAccountSettingsOptions).execute();
            AccountSettingsResponse accountSettingsResponse = response.getResult();

            System.out.println(accountSettingsResponse);

            // end-updateAccountSettings

        } catch (ServiceResponseException e) {
            logger.error(String.format("Service returned status code %s: %s\nError details: %s",
                    e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()), e);
        }

        try {
            System.out.println("createReport() result:");

            // begin-create_report

            CreateReportOptions createReportOptions = new CreateReportOptions.Builder()
                    .accountId(accountId)
                    .build();

            Response<ReportReference> response = service.createReport(createReportOptions).execute();
            ReportReference reportReference = response.getResult();

            reportReferenceValue = reportReference.getReference();

            System.out.println(reportReferenceValue);

            // end-create_report

        } catch (ServiceResponseException e) {
            logger.error(String.format("Service returned status code %s: %s\nError details: %s",
                    e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()), e);
        }

        try {
            System.out.println("getReport() result:");

            // begin-get_report

            GetReportOptions getReportOptions = new GetReportOptions.Builder()
                    .accountId(accountId)
                    .reference(reportReferenceValue)
                    .build();

            Response<Report> response = service.getReport(getReportOptions).execute();
            Report fetchedReport = response.getResult();

            System.out.println(fetchedReport);

            // end-get_report

        } catch (ServiceResponseException e) {
            logger.error(String.format("Service returned status code %s: %s\nError details: %s",
                    e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()), e);
        }

        try {
            System.out.println("createMfaReport() result:");

            // begin-create_mfa_report

            CreateMfaReportOptions createMfaReportOptions = new CreateMfaReportOptions.Builder()
                    .accountId(accountId)
                    .type("mfa_status")
                    .build();

            Response<ReportReference> response = service.createMfaReport(createMfaReportOptions).execute();
            ReportReference reportReference = response.getResult();

            reportReferenceValue = reportReference.getReference();

            System.out.println(reportReferenceValue);

            // end-create_mfa_report

        } catch (ServiceResponseException e) {
            logger.error(String.format("Service returned status code %s: %s\nError details: %s",
                    e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()), e);
        }

        try {
            System.out.println("getMfaReport() result:");

            // begin-get_mfa_report

            GetMfaReportOptions getMfaReportOptions = new GetMfaReportOptions.Builder()
                    .accountId(accountId)
                    .reference(reportReferenceValue)
                    .build();

            Response<ReportMfaEnrollmentStatus> response = service.getMfaReport(getMfaReportOptions).execute();
            ReportMfaEnrollmentStatus fetchedReport = response.getResult();

            System.out.println(fetchedReport);

            // end-get_mfa_report

        } catch (ServiceResponseException e) {
            logger.error(String.format("Service returned status code %s: %s\nError details: %s",
                    e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()), e);
        }

        try {
            System.out.println("getMfaStatus() result:");

            // begin-get_mfa_status
            GetMfaStatusOptions getMfaStatusOptions = new GetMfaStatusOptions.Builder()
                    .accountId(accountId)
                    .iamId(iamId)
                    .build();

            Response<UserMfaEnrollments> response = service.getMfaStatus(getMfaStatusOptions).execute();
            UserMfaEnrollments userMfaEnrollmentsResponse = response.getResult();

            System.out.println(userMfaEnrollmentsResponse);

            // end-get_mfa_status

        } catch (ServiceResponseException e) {
            logger.error(String.format("Service returned status code %s: %s\nError details: %s",
                    e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()), e);
        }

        try {
            System.out.println("createProfileTemplate() result:");

            // begin-create_profile_template
            ProfileClaimRuleConditions condition = new ProfileClaimRuleConditions.Builder()
                    .claim("blueGroups")
                    .operator("EQUALS")
                    .value("\"cloud-docs-dev\"")
                    .build();
            List<ProfileClaimRuleConditions> conditions = new ArrayList<>();
            conditions.add(condition);

            TrustedProfileTemplateClaimRule claimRule = new TrustedProfileTemplateClaimRule.Builder()
                    .name("My Rule")
                    .realmName(realmName)
                    .type(claimRuleType)
                    .expiration(43200)
                    .conditions(conditions)
                    .build();

            TemplateProfileComponentRequest profile = new TemplateProfileComponentRequest.Builder()
                    .addRules(claimRule)
                    .name(profileTemplateProfileName)
                    .description("Trusted profile created from a template")
                    .build();

            CreateProfileTemplateOptions createProfileTemplateOptions = new CreateProfileTemplateOptions.Builder()
                    .name(profileTemplateName)
                    .description("IAM enterprise trusted profile template example")
                    .accountId(enterpriseAccountId)
                    .profile(profile)
                    .build();

            Response<TrustedProfileTemplateResponse> response = service.createProfileTemplate(createProfileTemplateOptions).execute();
            TrustedProfileTemplateResponse trustedProfileTemplateResult = response.getResult();

            // Save the id for use by other test methods.
            profileTemplateId = trustedProfileTemplateResult.getId();
            profileTemplateVersion = trustedProfileTemplateResult.getVersion().longValue();

            System.out.println(trustedProfileTemplateResult);

            // end-create_profile_template

        } catch (ServiceResponseException e) {
            logger.error(String.format("Service returned status code %s: %s\nError details: %s",
                    e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()), e);
        }

        try {
            System.out.println("getProfileTemplateVersion() result:");

            // begin-get_profile_template_version

            GetProfileTemplateVersionOptions getProfileTemplateOptions = new GetProfileTemplateVersionOptions.Builder()
                    .templateId(profileTemplateId)
                    .version(Long.toString(profileTemplateVersion))
                    .build();

            Response<TrustedProfileTemplateResponse> response = service.getProfileTemplateVersion(getProfileTemplateOptions).execute();
            TrustedProfileTemplateResponse profileTemplateResult = response.getResult();

            // Grab the Etag value from the response for use in the update operation.
            profileTemplateEtag = response.getHeaders().values("Etag").get(0);

            System.out.println(profileTemplateResult);

            // end-get_profile_template_version

        } catch (ServiceResponseException e) {
            logger.error(String.format("Service returned status code %s: %s\nError details: %s",
                    e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()), e);
        }

        try {
            System.out.println("listProfileTemplates() result:");

            // begin-list_profile_templates

            ListProfileTemplatesOptions listOptions = new ListProfileTemplatesOptions.Builder()
                    .accountId(enterpriseAccountId)
                    .build();

            Response<TrustedProfileTemplateList> response = service.listProfileTemplates(listOptions).execute();
            TrustedProfileTemplateList listResult = response.getResult();
            System.out.println(listResult);

            // end-list_profile_templates

        } catch (ServiceResponseException e) {
            logger.error(String.format("Service returned status code %s: %s\nError details: %s",
                    e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()), e);
        }

        try {
            System.out.println("updateProfileTemplateVersion() result:");

            // begin-update_profile_template_version

            UpdateProfileTemplateVersionOptions updateOptions = new UpdateProfileTemplateVersionOptions.Builder()
                    .accountId(enterpriseAccountId)
                    .templateId(profileTemplateId)
                    .version(Long.toString(profileTemplateVersion))
                    .ifMatch(profileTemplateEtag)
                    .name(profileTemplateName)
                    .description("IAM enterprise trusted profile template example - updated")
                    .build();

            Response<TrustedProfileTemplateResponse> updateResponse = service.updateProfileTemplateVersion(updateOptions).execute();
            TrustedProfileTemplateResponse updateResult = updateResponse.getResult();

            // Grab the Etag value from the response for use in the update operation.
            profileTemplateEtag = updateResponse.getHeaders().values("Etag").get(0);

            System.out.println(updateResult);

            // end-update_profile_template_version

        } catch (ServiceResponseException e) {
            logger.error(String.format("Service returned status code %s: %s\nError details: %s",
                    e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()), e);
        }

        try {
            System.out.println("commitProfileTemplate() result:");

            // begin-commit_profile_template

            CommitProfileTemplateOptions commitOptions = new CommitProfileTemplateOptions.Builder()
                    .templateId(profileTemplateId)
                    .version(Long.toString(profileTemplateVersion))
                    .build();

            Response<Void> commitResponse = service.commitProfileTemplate(commitOptions).execute();

            // end-commit_profile_template

            System.out.printf("commitProfileTemplate() response status code: %d%n", commitResponse.getStatusCode());

        } catch (ServiceResponseException e) {
            logger.error(String.format("Service returned status code %s: %s\nError details: %s",
                    e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()), e);
        }

        try {
            System.out.println("createProfileTemplateAssignment() result:");

            // begin-create_trusted_profile_assignment

            CreateTrustedProfileAssignmentOptions assignOptions = new CreateTrustedProfileAssignmentOptions.Builder()
                    .templateId(profileTemplateId)
                    .templateVersion(profileTemplateVersion)
                    .targetType("Account")
                    .target(enterpriseSubAccountId)
                    .build();

            Response<TemplateAssignmentResponse> assignResponse = service.createTrustedProfileAssignment(assignOptions).execute();
            TemplateAssignmentResponse assignmentResponseResult = assignResponse.getResult();

            // Save the id for use by other test methods.
            profileTemplateAssignmentId = assignmentResponseResult.getId();
            // Grab the Etag value from the response for use in the update operation.
            profileTemplateAssignmentEtag = assignResponse.getHeaders().values("Etag").get(0);

            System.out.println(assignmentResponseResult);

            // end-create_trusted_profile_assignment

        } catch (ServiceResponseException e) {
            logger.error(String.format("Service returned status code %s: %s\nError details: %s",
                    e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()), e);
        }

        try {
            System.out.println("getProfileTemplateAssignment() result:");

            // begin-get_trusted_profile_assignment

            GetTrustedProfileAssignmentOptions getOptions = new GetTrustedProfileAssignmentOptions.Builder()
                    .assignmentId(profileTemplateAssignmentId)
                    .build();

            Response<TemplateAssignmentResponse> getResponse = service.getTrustedProfileAssignment(getOptions).execute();
            TemplateAssignmentResponse getResult = getResponse.getResult();

            System.out.println(getResult);

            // end-get_trusted_profile_assignment

        } catch (ServiceResponseException e) {
            logger.error(String.format("Service returned status code %s: %s\nError details: %s",
                    e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()), e);
        }

        try {
            System.out.println("listTrustedProfileAssignments() result:");

            // begin-list_trusted_profile_assignments

            ListTrustedProfileAssignmentsOptions listOptions = new ListTrustedProfileAssignmentsOptions.Builder()
                    .accountId(enterpriseAccountId)
                    .templateId(profileTemplateId)
                    .build();

            Response<TemplateAssignmentListResponse> listResponse = service.listTrustedProfileAssignments(listOptions).execute();
            TemplateAssignmentListResponse listResult = listResponse.getResult();
            System.out.println(listResult);

            // end-list_trusted_profile_assignments

        } catch (ServiceResponseException e) {
            logger.error(String.format("Service returned status code %s: %s\nError details: %s",
                    e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()), e);
        }

        try {
            System.out.println("createProfileTemplateVersion() result:");

            // begin-create_profile_template_version

            ProfileClaimRuleConditions condition = new ProfileClaimRuleConditions.Builder()
                    .claim("blueGroups")
                    .operator("EQUALS")
                    .value("\"cloud-docs-dev\"")
                    .build();
            List<ProfileClaimRuleConditions> conditions = new ArrayList<>();
            conditions.add(condition);

            TrustedProfileTemplateClaimRule claimRule = new TrustedProfileTemplateClaimRule.Builder()
                    .name("My Rule")
                    .realmName(realmName)
                    .type(claimRuleType)
                    .expiration(43200)
                    .conditions(conditions)
                    .build();

            List<String> accounts = new ArrayList<String>();
            accounts.add(enterpriseAccountId);
            ProfileIdentityRequest profileIdentity = new ProfileIdentityRequest.Builder()
                    .identifier(iamId)
                    .accounts(accounts)
                    .type("user")
                    .description("Identity description")
                    .build();
            List<ProfileIdentityRequest> identities = new ArrayList<ProfileIdentityRequest>();
            identities.add(profileIdentity);

            TemplateProfileComponentRequest profile = new TemplateProfileComponentRequest.Builder()
                    .addRules(claimRule)
                    .name(profileTemplateProfileName)
                    .description("Trusted profile created from a template - new version")
                    .identities(identities)
                    .build();

            CreateProfileTemplateVersionOptions createOptions = new CreateProfileTemplateVersionOptions.Builder()
                    .accountId(enterpriseAccountId)
                    .templateId(profileTemplateId)
                    .name(profileTemplateName)
                    .description("IAM enterprise trusted profile template example - new version")
                    .profile(profile)
                    .build();

            Response<TrustedProfileTemplateResponse> createResponse = service.createProfileTemplateVersion(createOptions).execute();
            TrustedProfileTemplateResponse createResult = createResponse.getResult();

            // Save the version for use by other test methods.
            profileTemplateVersion = createResult.getVersion().longValue();
            System.out.println(createResult);

            // end-create_profile_template_version

        } catch (ServiceResponseException e) {
            logger.error(String.format("Service returned status code %s: %s\nError details: %s",
                    e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()), e);
        }

        try {
            System.out.println("getLatestProfileTemplateVersion() result:");

            // begin-get_latest_profile_template_version

            GetLatestProfileTemplateVersionOptions getOptions = new GetLatestProfileTemplateVersionOptions.Builder()
                    .templateId(profileTemplateId)
                    .build();

            Response<TrustedProfileTemplateResponse> getResponse = service.getLatestProfileTemplateVersion(getOptions).execute();
            TrustedProfileTemplateResponse getResult = getResponse.getResult();

            System.out.println(getResult);

            // end-get_latest_profile_template_version

        } catch (ServiceResponseException e) {
            logger.error(String.format("Service returned status code %s: %s\nError details: %s",
                    e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()), e);
        }

        try {
            System.out.println("listVersionsOfProfileTemplate() result:");

            // begin-list_versions_of_profile_template

            ListVersionsOfProfileTemplateOptions listOptions = new ListVersionsOfProfileTemplateOptions.Builder()
                    .templateId(profileTemplateId)
                    .build();

            Response<TrustedProfileTemplateList> listResponse = service.listVersionsOfProfileTemplate(listOptions).execute();
            TrustedProfileTemplateList listResult = listResponse.getResult();

            System.out.println(listResult);

            // end-list_versions_of_profile_template

        } catch (ServiceResponseException e) {
            logger.error(String.format("Service returned status code %s: %s\nError details: %s",
                    e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()), e);
        }

        try {
            CommitProfileTemplateOptions commitOptions = new CommitProfileTemplateOptions.Builder()
                    .templateId(profileTemplateId)
                    .version(Long.toString(profileTemplateVersion))
                    .build();
            service.commitProfileTemplate(commitOptions).execute();

            waitUntilTrustedProfileAssignmentFinished(profileTemplateAssignmentId, service);

            System.out.println("updateTrustedProfileAssignment() result:");

            // begin-update_trusted_profile_assignment

            UpdateTrustedProfileAssignmentOptions updateOptions = new UpdateTrustedProfileAssignmentOptions.Builder()
                    .assignmentId(profileTemplateAssignmentId)
                    .templateVersion(profileTemplateVersion)
                    .ifMatch(profileTemplateAssignmentEtag)
                    .build();

            Response<TemplateAssignmentResponse> updateResponse = service.updateTrustedProfileAssignment(updateOptions).execute();
            TemplateAssignmentResponse updateResult = updateResponse.getResult();

            // Grab the Etag value from the response for use in the update operation.
            profileTemplateAssignmentEtag = updateResponse.getHeaders().values("Etag").get(0);

            System.out.println(updateResult);

            // end-update_trusted_profile_assignment

        } catch (ServiceResponseException e) {
            logger.error(String.format("Service returned status code %s: %s\nError details: %s",
                    e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()), e);
        }

        try {
            System.out.println("deleteTrustedProfileAssignment() result:");

            waitUntilTrustedProfileAssignmentFinished(profileTemplateAssignmentId, service);

            // begin-delete_trusted_profile_assignment

            DeleteTrustedProfileAssignmentOptions deleteOptions = new DeleteTrustedProfileAssignmentOptions.Builder()
                    .assignmentId(profileTemplateAssignmentId)
                    .build();

            Response<ExceptionResponse> deleteResponse = service.deleteTrustedProfileAssignment(deleteOptions).execute();

            // end-delete_trusted_profile_assignment

            System.out.printf("deleteTrustedProfileAssignment() response status code: %d%n", deleteResponse.getStatusCode());

        } catch (ServiceResponseException e) {
            logger.error(String.format("Service returned status code %s: %s\nError details: %s",
                    e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()), e);
        }

        try {
            System.out.println("deleteProfileTemplateVersion() result:");

            // begin-delete_profile_template_version

            DeleteProfileTemplateVersionOptions deleteOptions = new DeleteProfileTemplateVersionOptions.Builder()
                    .templateId(profileTemplateId)
                    .version("1")
                    .build();

            Response<Void> deleteResponse = service.deleteProfileTemplateVersion(deleteOptions).execute();

            // end-delete_profile_template_version

            System.out.printf("deleteProfileTemplateVersion() response status code: %d%n", deleteResponse.getStatusCode());

        } catch (ServiceResponseException e) {
            logger.error(String.format("Service returned status code %s: %s\nError details: %s",
                    e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()), e);
        }

        try {
            System.out.println("deleteProfileTemplateAllVersions() result:");

            waitUntilTrustedProfileAssignmentFinished(profileTemplateAssignmentId, service);

            // begin-delete_all_versions_of_profile_template

            DeleteAllVersionsOfProfileTemplateOptions deleteTeplateOptions = new DeleteAllVersionsOfProfileTemplateOptions.Builder()
                    .templateId(profileTemplateId)
                    .build();

            Response<Void> deleteResponse = service.deleteAllVersionsOfProfileTemplate(deleteTeplateOptions).execute();

            // end-delete_all_versions_of_profile_template

            System.out.printf("deleteProfileTemplateAllVersions() response status code: %d%n", deleteResponse.getStatusCode());

        } catch (ServiceResponseException e) {
            logger.error(String.format("Service returned status code %s: %s\nError details: %s",
                    e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()), e);
        }

        try {
            System.out.println("createAccountSettingsTemplate() result:");

            // begin-create_account_settings_template

            AccountSettingsComponent accountSettings = new AccountSettingsComponent.Builder()
                    .mfa("LEVEL1")
                    .systemAccessTokenExpirationInSeconds("3000")
                    .build();

            CreateAccountSettingsTemplateOptions createOptions = new CreateAccountSettingsTemplateOptions.Builder()
                    .accountId(enterpriseAccountId)
                    .name(accountSettingsTemplateName)
                    .description("IAM enterprise account settings template example")
                    .accountSettings(accountSettings)
                    .build();

            Response<AccountSettingsTemplateResponse> createResponse = service.createAccountSettingsTemplate(createOptions).execute();
            AccountSettingsTemplateResponse createResult = createResponse.getResult();

            // Save the id for use by other test methods.
            accountSettingsTemplateId = createResult.getId();
            accountSettingsTemplateVersion = createResult.getVersion().longValue();

            System.out.println(createResult);

            // end-create_account_settings_template

        } catch (ServiceResponseException e) {
            logger.error(String.format("Service returned status code %s: %s\nError details: %s",
                    e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()), e);
        }

        try {
            System.out.println("getAccountSettingsTemplateVersion() result:");

            // begin-get_account_settings_template_version

            GetAccountSettingsTemplateVersionOptions getOptions = new GetAccountSettingsTemplateVersionOptions.Builder()
                    .templateId(accountSettingsTemplateId)
                    .version(Long.toString(accountSettingsTemplateVersion))
                    .build();

            Response<AccountSettingsTemplateResponse> response = service.getAccountSettingsTemplateVersion(getOptions).execute();
            AccountSettingsTemplateResponse getResult = response.getResult();

            // Grab the Etag value from the response for use in the update operation.
            accountSettingsTemplateEtag = response.getHeaders().values("Etag").get(0);

            System.out.println(getResult);

            // end-get_account_settings_template_version

        } catch (ServiceResponseException e) {
            logger.error(String.format("Service returned status code %s: %s\nError details: %s",
                    e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()), e);
        }

        try {
            System.out.println("listAccountSettingsTemplates() result:");

            // begin-list_account_settings_templates

            ListAccountSettingsTemplatesOptions listOptions = new ListAccountSettingsTemplatesOptions.Builder()
                    .accountId(enterpriseAccountId)
                    .build();

            Response<AccountSettingsTemplateList> response = service.listAccountSettingsTemplates(listOptions).execute();
            AccountSettingsTemplateList result = response.getResult();

            System.out.println(result);

            // end-list_account_settings_templates

        } catch (ServiceResponseException e) {
            logger.error(String.format("Service returned status code %s: %s\nError details: %s",
                    e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()), e);
        }

        try {
            System.out.println("updateAccountSettingsTemplateVersion() result:");

            // begin-update_account_settings_template_version

            AccountSettingsComponent accountSettings = new AccountSettingsComponent.Builder()
                    .mfa("LEVEL1")
                    .systemAccessTokenExpirationInSeconds("3000")
                    .build();
            UpdateAccountSettingsTemplateVersionOptions updateOptions = new UpdateAccountSettingsTemplateVersionOptions.Builder()
                    .accountId(enterpriseAccountId)
                    .templateId(accountSettingsTemplateId)
                    .version(Long.toString(accountSettingsTemplateVersion))
                    .ifMatch(accountSettingsTemplateEtag)
                    .name(accountSettingsTemplateName)
                    .description("IAM enterprise account settings template example - updated")
                    .accountSettings(accountSettings)
                    .build();

            Response<AccountSettingsTemplateResponse> updateResponse = service.updateAccountSettingsTemplateVersion(updateOptions).execute();
            AccountSettingsTemplateResponse updateResult = updateResponse.getResult();

            // Grab the Etag value from the response for use in the update operation.
            accountSettingsTemplateEtag = updateResponse.getHeaders().values("Etag").get(0);

            System.out.println(updateResult);

            // end-update_account_settings_template_version

        } catch (ServiceResponseException e) {
            logger.error(String.format("Service returned status code %s: %s\nError details: %s",
                    e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()), e);
        }

        try {
            System.out.println("commitAccountSettingsTemplate() result:");

            // begin-commit_account_settings_template

            CommitAccountSettingsTemplateOptions commitOptions = new CommitAccountSettingsTemplateOptions.Builder()
                    .templateId(accountSettingsTemplateId)
                    .version(Long.toString(accountSettingsTemplateVersion))
                    .build();

            Response<Void> commitResponse = service.commitAccountSettingsTemplate(commitOptions).execute();

            // end-commit_account_settings_template

            System.out.printf("deleteProfileTemplateAllVersions() response status code: %d%n", commitResponse.getStatusCode());

        } catch (ServiceResponseException e) {
            logger.error(String.format("Service returned status code %s: %s\nError details: %s",
                    e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()), e);
        }

        try {
            System.out.println("createAccountSettingsAssignment() result:");

            // begin-create_account_settings_assignment

            CreateAccountSettingsAssignmentOptions assignOptions = new CreateAccountSettingsAssignmentOptions.Builder()
                    .templateId(accountSettingsTemplateId)
                    .templateVersion(accountSettingsTemplateVersion)
                    .targetType("Account")
                    .target(enterpriseSubAccountId)
                    .build();

            Response<TemplateAssignmentResponse> assignResponse = service.createAccountSettingsAssignment(assignOptions).execute();
            TemplateAssignmentResponse assignmentResult = assignResponse.getResult();

            // Save the id for use by other test methods.
            accountSettingsTemplateAssignmentId = assignmentResult.getId();
            // Grab the Etag value from the response for use in the update operation.
            accountSettingsTemplateAssignmentEtag = assignResponse.getHeaders().values("Etag").get(0);

            System.out.println(assignmentResult);

            // end-create_account_settings_assignment

        } catch (ServiceResponseException e) {
            logger.error(String.format("Service returned status code %s: %s\nError details: %s",
                    e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()), e);
        }

        try {
            System.out.println("listAccountSettingsAssignments() result:");

            // begin-list_account_settings_assignments

            ListAccountSettingsTemplatesOptions listOptions = new ListAccountSettingsTemplatesOptions.Builder()
                    .accountId(enterpriseAccountId)
                    .build();

            Response<AccountSettingsTemplateList> listResponse = service.listAccountSettingsTemplates(listOptions).execute();
            AccountSettingsTemplateList listResult = listResponse.getResult();

            System.out.println(listResult);

            // end-list_account_settings_assignments

        } catch (ServiceResponseException e) {
            logger.error(String.format("Service returned status code %s: %s\nError details: %s",
                    e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()), e);
        }

        try {
            System.out.println("getAccountSettingsAssignment() result:");

            // begin-get_account_settings_assignment

            GetAccountSettingsAssignmentOptions getOptions = new GetAccountSettingsAssignmentOptions.Builder()
                    .assignmentId(accountSettingsTemplateAssignmentId)
                    .build();

            Response<TemplateAssignmentResponse> getResponse = service.getAccountSettingsAssignment(getOptions).execute();
            TemplateAssignmentResponse getResult = getResponse.getResult();

            // Grab the Etag value from the response for use in the update operation.
            accountSettingsTemplateAssignmentEtag = getResponse.getHeaders().values("Etag").get(0);

            System.out.println(getResult);

            // end-get_account_settings_assignment

        } catch (ServiceResponseException e) {
            logger.error(String.format("Service returned status code %s: %s\nError details: %s",
                    e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()), e);
        }

        try {
            System.out.println("createAccountSettingsTemplateVersion() result:");

            // begin-create_account_settings_template_version

            AccountSettingsComponent accountSettings = new AccountSettingsComponent.Builder()
                    .mfa("LEVEL1")
                    .systemAccessTokenExpirationInSeconds("2600")
                    .restrictCreatePlatformApikey("RESTRICTED")
                    .restrictCreateServiceId("RESTRICTED")
                    .build();
            CreateAccountSettingsTemplateVersionOptions createOptions = new CreateAccountSettingsTemplateVersionOptions.Builder()
                    .accountId(enterpriseAccountId)
                    .templateId(accountSettingsTemplateId)
                    .name(accountSettingsTemplateName)
                    .description("IAM enterprise account settings template example - new version")
                    .accountSettings(accountSettings)
                    .build();

            Response<AccountSettingsTemplateResponse> createResponse = service.createAccountSettingsTemplateVersion(createOptions).execute();
            AccountSettingsTemplateResponse createResult = createResponse.getResult();

            // Save the version for use by other test methods.
            accountSettingsTemplateVersion = createResult.getVersion().longValue();

            System.out.println(createResult);

            // end-create_account_settings_template_version

        } catch (ServiceResponseException e) {
            logger.error(String.format("Service returned status code %s: %s\nError details: %s",
                    e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()), e);
        }

        try {
            System.out.println("getLatestAccountSettingsTemplateVersion() result:");

            // begin-get_latest_account_settings_template_version

            GetLatestAccountSettingsTemplateVersionOptions getOptions = new GetLatestAccountSettingsTemplateVersionOptions.Builder()
                    .templateId(accountSettingsTemplateId)
                    .build();

            Response<AccountSettingsTemplateResponse> getResponse = service.getLatestAccountSettingsTemplateVersion(getOptions).execute();
            AccountSettingsTemplateResponse getResult = getResponse.getResult();

            System.out.println(getResult);

            // end-get_latest_account_settings_template_version

        } catch (ServiceResponseException e) {
            logger.error(String.format("Service returned status code %s: %s\nError details: %s",
                    e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()), e);
        }

        try {
            System.out.println("listVersionsOfAccountSettingsTemplate() result:");

            // begin-list_versions_of_account_settings_template

            ListVersionsOfAccountSettingsTemplateOptions listOptions = new ListVersionsOfAccountSettingsTemplateOptions.Builder()
                    .templateId(accountSettingsTemplateId)
                    .build();

            Response<AccountSettingsTemplateList> listResponse = service.listVersionsOfAccountSettingsTemplate(listOptions).execute();
            AccountSettingsTemplateList listResult = listResponse.getResult();

            System.out.println(listResult);

            // end-list_versions_of_account_settings_template

        } catch (ServiceResponseException e) {
            logger.error(String.format("Service returned status code %s: %s\nError details: %s",
                    e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()), e);
        }

        try {
            System.out.println("updateAccountSettingsAssignment() result:");

            CommitAccountSettingsTemplateOptions commitOptions = new CommitAccountSettingsTemplateOptions.Builder()
                    .templateId(accountSettingsTemplateId)
                    .version(Long.toString(accountSettingsTemplateVersion))
                    .build();

            service.commitAccountSettingsTemplate(commitOptions).execute();

            waitUntilAccountSettingsAssignmentFinished(accountSettingsTemplateAssignmentId, service);

            // begin-update_account_settings_assignment

            UpdateAccountSettingsAssignmentOptions updateOptions = new UpdateAccountSettingsAssignmentOptions.Builder()
                    .assignmentId(accountSettingsTemplateAssignmentId)
                    .templateVersion(accountSettingsTemplateVersion)
                    .ifMatch(accountSettingsTemplateAssignmentEtag)
                    .build();

            Response<TemplateAssignmentResponse> updateResponse = service.updateAccountSettingsAssignment(updateOptions).execute();
            TemplateAssignmentResponse updateResult = updateResponse.getResult();

            // Grab the Etag value from the response for use in the update operation.
            accountSettingsTemplateAssignmentEtag = updateResponse.getHeaders().values("Etag").get(0);

            System.out.println(updateResult);

            // end-update_account_settings_assignment

        } catch (ServiceResponseException e) {
            logger.error(String.format("Service returned status code %s: %s\nError details: %s",
                    e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()), e);
        }

        try {
            System.out.println("deleteAccountSettingsAssignment() result:");

            waitUntilAccountSettingsAssignmentFinished(accountSettingsTemplateAssignmentId, service);

            // begin-delete_account_settings_assignment

            DeleteAccountSettingsAssignmentOptions deleteOptions = new DeleteAccountSettingsAssignmentOptions.Builder()
                    .assignmentId(accountSettingsTemplateAssignmentId)
                    .build();

            Response<ExceptionResponse> deleteResponse = service.deleteAccountSettingsAssignment(deleteOptions).execute();

            // end-delete_account_settings_assignment

            System.out.printf("deleteProfileTemplateAllVersions() response status code: %d%n", deleteResponse.getStatusCode());

        } catch (ServiceResponseException e) {
            logger.error(String.format("Service returned status code %s: %s\nError details: %s",
                    e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()), e);
        }

        try {
            System.out.println("deleteAccountSettingsTemplateVersion() result:");

            // begin-delete_account_settings_template_version

            DeleteAccountSettingsTemplateVersionOptions deleteOptions = new DeleteAccountSettingsTemplateVersionOptions.Builder()
                    .templateId(accountSettingsTemplateId)
                    .version("1")
                    .build();

            Response<Void> deleteResponse = service.deleteAccountSettingsTemplateVersion(deleteOptions).execute();

            // end-delete_account_settings_template_version

            System.out.printf("deleteProfileTemplateAllVersions() response status code: %d%n", deleteResponse.getStatusCode());

        } catch (ServiceResponseException e) {
            logger.error(String.format("Service returned status code %s: %s\nError details: %s",
                    e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()), e);
        }

        try {
            System.out.println("deleteAllVersionsOfAccountSettingsTemplate() result:");

            waitUntilAccountSettingsAssignmentFinished(accountSettingsTemplateAssignmentId, service);

            // begin-delete_all_versions_of_account_settings_template

            DeleteAllVersionsOfAccountSettingsTemplateOptions deleteTeplateOptions = new DeleteAllVersionsOfAccountSettingsTemplateOptions.Builder()
                    .templateId(accountSettingsTemplateId)
                    .build();

            Response<Void> deleteResponse = service.deleteAllVersionsOfAccountSettingsTemplate(deleteTeplateOptions).execute();

            // end-delete_all_versions_of_account_settings_template

            System.out.printf("deleteProfileTemplateAllVersions() response status code: %d%n", deleteResponse.getStatusCode());

        } catch (ServiceResponseException e) {
            logger.error(String.format("Service returned status code %s: %s\nError details: %s",
                    e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()), e);
        }
    }

    private static void sleep(int numSecs) {
        try {
            Thread.sleep(numSecs * 1000);
        } catch (Throwable t) {
        }
    }

    private static boolean isFinished(String status) {
        return ("succeeded".equalsIgnoreCase(status) || "failed".equalsIgnoreCase(status));
    }

    private static void waitUntilTrustedProfileAssignmentFinished(String assignmentId, IamIdentity service) {
        GetTrustedProfileAssignmentOptions getOptions = new GetTrustedProfileAssignmentOptions.Builder()
                .assignmentId(assignmentId)
                .build();

        boolean finished = false;
        for (int i = 0; i < 50; i++) {
            Response<TemplateAssignmentResponse> getResponse = null;
            try {
                getResponse = service.getTrustedProfileAssignment(getOptions).execute();
                TemplateAssignmentResponse result = getResponse.getResult();
                finished = isFinished(result.getStatus());
                if (finished) {
                    // Grab the Etag value from the response for use in the update operation.
                    profileTemplateAssignmentEtag = getResponse.getHeaders().values("Etag").get(0);
                    break;
                }
            } catch (NotFoundException e) {
                // assignment removed
                finished = true;
                break;
            }
            sleep(10);
        }
    }

    private static void waitUntilAccountSettingsAssignmentFinished(String assignmentId, IamIdentity service) {
        GetAccountSettingsAssignmentOptions getOptions = new GetAccountSettingsAssignmentOptions.Builder()
                .assignmentId(assignmentId)
                .build();

        boolean finished = false;
        for (int i = 0; i < 50; i++) {
            Response<TemplateAssignmentResponse> getResponse = null;
            try {
                getResponse = service.getAccountSettingsAssignment(getOptions).execute();
                TemplateAssignmentResponse result = getResponse.getResult();
                finished = isFinished(result.getStatus());
                if (finished) {
                    // Grab the Etag value from the response for use in the update operation.
                    accountSettingsTemplateAssignmentEtag = getResponse.getHeaders().values("Etag").get(0);
                    break;
                }
            } catch (NotFoundException e) {
                // assignment removed
                finished = true;
                break;
            }
            sleep(10);
        }
    }
}
