/*
 * (C) Copyright IBM Corp. 2022.
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

package com.ibm.cloud.platform_services.context_based_restrictions.v1;

import com.ibm.cloud.platform_services.context_based_restrictions.v1.model.AccountSettings;
import com.ibm.cloud.platform_services.context_based_restrictions.v1.model.Address;
import com.ibm.cloud.platform_services.context_based_restrictions.v1.model.AddressIPAddress;
import com.ibm.cloud.platform_services.context_based_restrictions.v1.model.CreateRuleOptions;
import com.ibm.cloud.platform_services.context_based_restrictions.v1.model.CreateZoneOptions;
import com.ibm.cloud.platform_services.context_based_restrictions.v1.model.DeleteRuleOptions;
import com.ibm.cloud.platform_services.context_based_restrictions.v1.model.DeleteZoneOptions;
import com.ibm.cloud.platform_services.context_based_restrictions.v1.model.GetAccountSettingsOptions;
import com.ibm.cloud.platform_services.context_based_restrictions.v1.model.GetRuleOptions;
import com.ibm.cloud.platform_services.context_based_restrictions.v1.model.GetZoneOptions;
import com.ibm.cloud.platform_services.context_based_restrictions.v1.model.ListAvailableServiceOperationsOptions;
import com.ibm.cloud.platform_services.context_based_restrictions.v1.model.ListAvailableServicerefTargetsOptions;
import com.ibm.cloud.platform_services.context_based_restrictions.v1.model.ListRulesOptions;
import com.ibm.cloud.platform_services.context_based_restrictions.v1.model.ListZonesOptions;
import com.ibm.cloud.platform_services.context_based_restrictions.v1.model.OperationsList;
import com.ibm.cloud.platform_services.context_based_restrictions.v1.model.ReplaceRuleOptions;
import com.ibm.cloud.platform_services.context_based_restrictions.v1.model.ReplaceZoneOptions;
import com.ibm.cloud.platform_services.context_based_restrictions.v1.model.Resource;
import com.ibm.cloud.platform_services.context_based_restrictions.v1.model.ResourceAttribute;
import com.ibm.cloud.platform_services.context_based_restrictions.v1.model.ResourceTagAttribute;
import com.ibm.cloud.platform_services.context_based_restrictions.v1.model.Rule;
import com.ibm.cloud.platform_services.context_based_restrictions.v1.model.RuleContext;
import com.ibm.cloud.platform_services.context_based_restrictions.v1.model.RuleContextAttribute;
import com.ibm.cloud.platform_services.context_based_restrictions.v1.model.RuleList;
import com.ibm.cloud.platform_services.context_based_restrictions.v1.model.ServiceRefTargetList;
import com.ibm.cloud.platform_services.context_based_restrictions.v1.model.Zone;
import com.ibm.cloud.platform_services.context_based_restrictions.v1.model.ZoneList;
import com.ibm.cloud.sdk.core.http.Response;
import com.ibm.cloud.sdk.core.service.exception.ServiceResponseException;
import com.ibm.cloud.sdk.core.util.CredentialUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;

//
// This file provides an example of how to use the Context Based Restrictions service.
//
// The following configuration properties are assumed to be defined:
// CONTEXT_BASED_RESTRICTIONS_URL=<service base url>
// CONTEXT_BASED_RESTRICTIONS_AUTH_TYPE=iam
// CONTEXT_BASED_RESTRICTIONS_APIKEY=<IAM apikey>
// CONTEXT_BASED_RESTRICTIONS_AUTH_URL=<IAM token service base URL - omit this if using the production environment>
// CONTEXT_BASED_RESTRICTIONS_TEST_ACCOUNT_ID=<the id of the account under which test CBR zones and rules are created>
// CONTEXT_BASED_RESTRICTIONS_TEST_SERVICE_NAME=<the name of the service to be associated with the test CBR rules>
//
// These configuration properties can be exported as environment variables, or stored
// in a configuration file and then:
// export IBM_CREDENTIALS_FILE=<name of configuration file>
//
public class ContextBasedRestrictionsExamples {
    private static final Logger logger = LoggerFactory.getLogger(ContextBasedRestrictionsExamples.class);

    protected ContextBasedRestrictionsExamples() {
    }

    @SuppressWarnings("checkstyle:methodlength")
    public static void main(String[] args) throws Exception {
        ContextBasedRestrictions contextBasedRestrictionsService = ContextBasedRestrictions.newInstance();
        String serviceURL = null;
        String accountID = null;
        String serviceName = null;
        String zoneID = null;
        String zoneRev = null;
        String ruleID = null;
        String ruleRev = null;
        // Load up our test-specific config properties.
        Map<String, String> config = CredentialUtils.getServiceProperties(ContextBasedRestrictions.DEFAULT_SERVICE_NAME);

        serviceURL = config.get("URL");
        accountID = config.get("TEST_ACCOUNT_ID");
        serviceName = config.get("TEST_SERVICE_NAME");

        try {
            System.out.println("createZone() result:");
            // begin-create_zone
            AddressIPAddress addressModel = new AddressIPAddress.Builder()
                .type("ipAddress")
                .value("169.23.56.234")
                .build();
            CreateZoneOptions createZoneOptions = new CreateZoneOptions.Builder()
                .name("an example of zone")
                .accountId(accountID)
                .description("this is an example of zone")
                .addresses(new java.util.ArrayList<Address>(java.util.Arrays.asList(addressModel)))
                .build();

            Response<Zone> response = contextBasedRestrictionsService.createZone(createZoneOptions).execute();
            Zone zone = response.getResult();

            System.out.println(zone);
            // end-create_zone
            zoneID = zone.getId();
            zoneRev = response.getHeaders().values("Etag").get(0);
        } catch (ServiceResponseException e) {
            logger.error(String.format("Service returned status code %s: %s%nError details: %s",
                e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()), e);
        }

        try {
            System.out.println("listZones() result:");
            // begin-list_zones
            ListZonesOptions listZonesOptions = new ListZonesOptions.Builder()
                .accountId(accountID)
                .build();

            Response<ZoneList> response = contextBasedRestrictionsService.listZones(listZonesOptions).execute();
            ZoneList zoneList = response.getResult();

            System.out.println(zoneList);
            // end-list_zones
        } catch (ServiceResponseException e) {
            logger.error(String.format("Service returned status code %s: %s%nError details: %s",
                e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()), e);
        }

        try {
            System.out.println("getZone() result:");
            // begin-get_zone
            GetZoneOptions getZoneOptions = new GetZoneOptions.Builder()
                .zoneId(zoneID)
                .build();

            Response<Zone> response = contextBasedRestrictionsService.getZone(getZoneOptions).execute();
            Zone zone = response.getResult();

            System.out.println(zone);
            // end-get_zone
        } catch (ServiceResponseException e) {
            logger.error(String.format("Service returned status code %s: %s%nError details: %s",
                e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()), e);
        }

        try {
            System.out.println("replaceZone() result:");
            // begin-replace_zone
            AddressIPAddress addressModel = new AddressIPAddress.Builder()
                .type("ipAddress")
                .value("169.23.56.234")
                .build();
            ReplaceZoneOptions replaceZoneOptions = new ReplaceZoneOptions.Builder()
                .zoneId(zoneID)
                .ifMatch(zoneRev)
                .name("an example of zone")
                .accountId(accountID)
                .description("this is an example of updated zone")
                .addresses(new java.util.ArrayList<Address>(java.util.Arrays.asList(addressModel)))
                .build();

            Response<Zone> response = contextBasedRestrictionsService.replaceZone(replaceZoneOptions).execute();
            Zone zone = response.getResult();

            System.out.println(zone);
            // end-replace_zone
        } catch (ServiceResponseException e) {
            logger.error(String.format("Service returned status code %s: %s%nError details: %s",
                e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()), e);
        }

        try {
            System.out.println("listAvailableServicerefTargets() result:");
            // begin-list_available_serviceref_targets
            ListAvailableServicerefTargetsOptions listAvailableServicerefTargetsOptions = new ListAvailableServicerefTargetsOptions.Builder()
                .build();

            Response<ServiceRefTargetList> response = contextBasedRestrictionsService.listAvailableServicerefTargets(listAvailableServicerefTargetsOptions).execute();
            ServiceRefTargetList serviceRefTargetList = response.getResult();

            System.out.println(serviceRefTargetList);
            // end-list_available_serviceref_targets
        } catch (ServiceResponseException e) {
            logger.error(String.format("Service returned status code %s: %s%nError details: %s",
                e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()), e);
        }

        try {
            System.out.println("createRule() result:");
            // begin-create_rule
            RuleContextAttribute ruleContextAttributeModel = new RuleContextAttribute.Builder()
                .name("networkZoneId")
                .value(zoneID)
                .build();
            RuleContext ruleContextModel = new RuleContext.Builder()
                .attributes(new java.util.ArrayList<RuleContextAttribute>(java.util.Arrays.asList(ruleContextAttributeModel)))
                .build();
            ResourceAttribute resourceAttributeModelAccountID = new ResourceAttribute.Builder()
                .name("accountId")
                .value(accountID)
                .build();
            ResourceAttribute resourceAttributeModelServiceName = new ResourceAttribute.Builder()
                .name("serviceName")
                .value(serviceName)
                .build();
            ResourceTagAttribute resourceTagAttributeModel = new ResourceTagAttribute.Builder()
                .name("tagName")
                .value("tagValue")
                .build();
            Resource resourceModel = new Resource.Builder()
                .addAttributes(resourceAttributeModelAccountID)
                .addAttributes(resourceAttributeModelServiceName)
                .tags(new java.util.ArrayList<ResourceTagAttribute>(java.util.Arrays.asList(resourceTagAttributeModel)))
                .build();
            CreateRuleOptions createRuleOptions = new CreateRuleOptions.Builder()
                .description("this is an example of rule")
                .addContexts(ruleContextModel)
                .addResources(resourceModel)
                .enforcementMode("enabled")
                .build();

            Response<Rule> response = contextBasedRestrictionsService.createRule(createRuleOptions).execute();
            Rule rule = response.getResult();

            System.out.println(rule);
            ruleID = rule.getId();
            ruleRev = response.getHeaders().values("Etag").get(0);
            // end-create_rule
        } catch (ServiceResponseException e) {
            logger.error(String.format("Service returned status code %s: %s%nError details: %s",
                e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()), e);
        }

        try {
            System.out.println("listRules() result:");
            // begin-list_rules
            ListRulesOptions listRulesOptions = new ListRulesOptions.Builder()
                .accountId(accountID)
                .build();

            Response<RuleList> response = contextBasedRestrictionsService.listRules(listRulesOptions).execute();
            RuleList ruleList = response.getResult();

            System.out.println(ruleList);
            // end-list_rules
        } catch (ServiceResponseException e) {
            logger.error(String.format("Service returned status code %s: %s%nError details: %s",
                e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()), e);
        }

        try {
            System.out.println("getRule() result:");
            // begin-get_rule
            GetRuleOptions getRuleOptions = new GetRuleOptions.Builder()
                    .ruleId(ruleID)
                    .build();

            Response<Rule> response = contextBasedRestrictionsService.getRule(getRuleOptions).execute();
            Rule rule = response.getResult();

            System.out.println(rule);
            // end-get_rule
        } catch (ServiceResponseException e) {
            logger.error(String.format("Service returned status code %s: %s%nError details: %s",
                e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()), e);
        }

        try {
            System.out.println("replaceRule() result:");
            // begin-replace_rule
            RuleContextAttribute ruleContextAttributeModel = new RuleContextAttribute.Builder()
                .name("networkZoneId")
                .value(zoneID)
                .build();
            RuleContext ruleContextModel = new RuleContext.Builder()
                .attributes(new java.util.ArrayList<RuleContextAttribute>(java.util.Arrays.asList(ruleContextAttributeModel)))
                .build();
            ResourceAttribute resourceAttributeModelAccountID = new ResourceAttribute.Builder()
                .name("accountId")
                .value(accountID)
                .build();
            ResourceAttribute resourceAttributeModelServiceName = new ResourceAttribute.Builder()
                .name("serviceName")
                .value(serviceName)
                .build();
            ResourceTagAttribute resourceTagAttributeModel = new ResourceTagAttribute.Builder()
                .name("tagName")
                .value("updatedTagValue")
                .build();
            Resource resourceModel = new Resource.Builder()
                .addAttributes(resourceAttributeModelAccountID)
                .addAttributes(resourceAttributeModelServiceName)
                .addTags(resourceTagAttributeModel)
                .build();
            ReplaceRuleOptions replaceRuleOptions = new ReplaceRuleOptions.Builder()
                .ruleId(ruleID)
                .ifMatch(ruleRev)
                .description("this is an example of updated rule")
                .addContexts(ruleContextModel)
                .addResources(resourceModel)
                .enforcementMode("disabled")
                .build();

            Response<Rule> response = contextBasedRestrictionsService.replaceRule(replaceRuleOptions).execute();
            Rule rule = response.getResult();

            System.out.println(rule);
            // end-replace_rule
        } catch (ServiceResponseException e) {
            logger.error(String.format("Service returned status code %s: %s%nError details: %s",
                e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()), e);
        }

        try {
            System.out.println("getAccountSettings() result:");
            // begin-get_account_settings
            GetAccountSettingsOptions getAccountSettingsOptions = new GetAccountSettingsOptions.Builder()
                .accountId(accountID)
                .build();

            Response<AccountSettings> response = contextBasedRestrictionsService.getAccountSettings(getAccountSettingsOptions).execute();
            AccountSettings accountSettings = response.getResult();

            System.out.println(accountSettings);
            // end-get_account_settings
        } catch (ServiceResponseException e) {
            logger.error(String.format("Service returned status code %s: %s%nError details: %s",
                e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()), e);
        }

        try {
            System.out.println("listAvailableServiceOperations() result:");
            // begin-list_available_service_operations
            ListAvailableServiceOperationsOptions listAvailableServiceOperationsOptions = new ListAvailableServiceOperationsOptions.Builder()
                .serviceName("containers-kubernetes")
                .build();

            Response<OperationsList> response = contextBasedRestrictionsService.listAvailableServiceOperations(listAvailableServiceOperationsOptions).execute();
            OperationsList operationsList = response.getResult();

            System.out.println(operationsList);
            // end-list_available_service_operations
        } catch (ServiceResponseException e) {
            logger.error(String.format("Service returned status code %s: %s%nError details: %s",
            e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()), e);
        }

        try {
            // begin-delete_rule
            DeleteRuleOptions deleteRuleOptions = new DeleteRuleOptions.Builder()
                .ruleId(ruleID)
                .build();

            Response<Void> response = contextBasedRestrictionsService.deleteRule(deleteRuleOptions).execute();
            // end-delete_rule
            System.out.printf("deleteRule() response status code: %d%n", response.getStatusCode());
        } catch (ServiceResponseException e) {
            logger.error(String.format("Service returned status code %s: %s%nError details: %s",
                e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()), e);
        }

        try {
            // begin-delete_zone
            DeleteZoneOptions deleteZoneOptions = new DeleteZoneOptions.Builder()
                .zoneId(zoneID)
                .build();

            Response<Void> response = contextBasedRestrictionsService.deleteZone(deleteZoneOptions).execute();
            // end-delete_zone
            System.out.printf("deleteZone() response status code: %d%n", response.getStatusCode());
        } catch (ServiceResponseException e) {
            logger.error(String.format("Service returned status code %s: %s%nError details: %s",
                e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()), e);
        }
    }
}
