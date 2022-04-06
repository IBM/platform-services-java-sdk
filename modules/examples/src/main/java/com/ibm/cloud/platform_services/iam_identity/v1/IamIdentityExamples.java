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
import java.util.List;
import java.util.ArrayList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.ibm.cloud.platform_services.iam_identity.v1.model.AccountSettingsResponse;
import com.ibm.cloud.platform_services.iam_identity.v1.model.ApiKey;
import com.ibm.cloud.platform_services.iam_identity.v1.model.ApiKeyList;
import com.ibm.cloud.platform_services.iam_identity.v1.model.CreateApiKeyOptions;
import com.ibm.cloud.platform_services.iam_identity.v1.model.CreateClaimRuleOptions;
import com.ibm.cloud.platform_services.iam_identity.v1.model.CreateLinkOptions;
import com.ibm.cloud.platform_services.iam_identity.v1.model.CreateProfileOptions;
import com.ibm.cloud.platform_services.iam_identity.v1.model.CreateProfileLinkRequestLink;
import com.ibm.cloud.platform_services.iam_identity.v1.model.CreateReportOptions;
import com.ibm.cloud.platform_services.iam_identity.v1.model.CreateServiceIdOptions;
import com.ibm.cloud.platform_services.iam_identity.v1.model.DeleteApiKeyOptions;
import com.ibm.cloud.platform_services.iam_identity.v1.model.DeleteClaimRuleOptions;
import com.ibm.cloud.platform_services.iam_identity.v1.model.DeleteLinkOptions;
import com.ibm.cloud.platform_services.iam_identity.v1.model.DeleteProfileOptions;
import com.ibm.cloud.platform_services.iam_identity.v1.model.DeleteServiceIdOptions;
import com.ibm.cloud.platform_services.iam_identity.v1.model.GetAccountSettingsOptions;
import com.ibm.cloud.platform_services.iam_identity.v1.model.GetApiKeyOptions;
import com.ibm.cloud.platform_services.iam_identity.v1.model.GetApiKeysDetailsOptions;
import com.ibm.cloud.platform_services.iam_identity.v1.model.GetClaimRuleOptions;
import com.ibm.cloud.platform_services.iam_identity.v1.model.GetLinkOptions;
import com.ibm.cloud.platform_services.iam_identity.v1.model.GetProfileOptions;
import com.ibm.cloud.platform_services.iam_identity.v1.model.GetReportOptions;
import com.ibm.cloud.platform_services.iam_identity.v1.model.GetServiceIdOptions;
import com.ibm.cloud.platform_services.iam_identity.v1.model.ListApiKeysOptions;
import com.ibm.cloud.platform_services.iam_identity.v1.model.ListClaimRulesOptions;
import com.ibm.cloud.platform_services.iam_identity.v1.model.ListLinksOptions;
import com.ibm.cloud.platform_services.iam_identity.v1.model.ListProfilesOptions;
import com.ibm.cloud.platform_services.iam_identity.v1.model.ListServiceIdsOptions;
import com.ibm.cloud.platform_services.iam_identity.v1.model.LockApiKeyOptions;
import com.ibm.cloud.platform_services.iam_identity.v1.model.LockServiceIdOptions;
import com.ibm.cloud.platform_services.iam_identity.v1.model.ProfileClaimRule;
import com.ibm.cloud.platform_services.iam_identity.v1.model.ProfileClaimRuleConditions;
import com.ibm.cloud.platform_services.iam_identity.v1.model.ProfileClaimRuleList;
import com.ibm.cloud.platform_services.iam_identity.v1.model.ProfileLink;
import com.ibm.cloud.platform_services.iam_identity.v1.model.ProfileLinkList;
import com.ibm.cloud.platform_services.iam_identity.v1.model.Report;
import com.ibm.cloud.platform_services.iam_identity.v1.model.ReportReference;
import com.ibm.cloud.platform_services.iam_identity.v1.model.ServiceId;
import com.ibm.cloud.platform_services.iam_identity.v1.model.ServiceIdList;
import com.ibm.cloud.platform_services.iam_identity.v1.model.TrustedProfile;
import com.ibm.cloud.platform_services.iam_identity.v1.model.TrustedProfilesList;
import com.ibm.cloud.platform_services.iam_identity.v1.model.UnlockApiKeyOptions;
import com.ibm.cloud.platform_services.iam_identity.v1.model.UpdateClaimRuleOptions;
import com.ibm.cloud.platform_services.iam_identity.v1.model.UpdateProfileOptions;
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
    private static String profileName = "Example-Profile";
    private static String claimRuleType = "Profile-SAML";
    private static String realmName = "https://w3id.sso.ibm.com/auth/sps/samlidp2/saml20";

    //values to be read from the env file
    private static String accountId;
    private static String iamId;
    private static String iamApiKey;

    // Variables used to hold various values shared between operations.
    private static String apikeyId;
    private static String apikeyEtag;
    private static String svcId;
    private static String svcIdEtag;
    private static String profileId;
    private static String profileIamId;
    private static String profileEtag;
    private static String claimRuleId;
    private static String claimRuleEtag;
    private static String linkId;
    private static String accountSettingsEtag;
    private static String reportReferenceValue;

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
            profileIamId = profile.getIamId();

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
    }
}
