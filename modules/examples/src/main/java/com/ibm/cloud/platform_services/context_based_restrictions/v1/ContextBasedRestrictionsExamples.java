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

package com.ibm.cloud.platform_services.context_based_restrictions.v1;

import com.ibm.cloud.platform_services.context_based_restrictions.v1.model.Address;
import com.ibm.cloud.platform_services.context_based_restrictions.v1.model.AddressIPAddress;
import com.ibm.cloud.platform_services.context_based_restrictions.v1.model.CreateRuleOptions;
import com.ibm.cloud.platform_services.context_based_restrictions.v1.model.CreateZoneOptions;
import com.ibm.cloud.platform_services.context_based_restrictions.v1.model.DeleteRuleOptions;
import com.ibm.cloud.platform_services.context_based_restrictions.v1.model.DeleteZoneOptions;
import com.ibm.cloud.platform_services.context_based_restrictions.v1.model.GetAccountSettingsOptions;
import com.ibm.cloud.platform_services.context_based_restrictions.v1.model.GetRuleOptions;
import com.ibm.cloud.platform_services.context_based_restrictions.v1.model.GetZoneOptions;
import com.ibm.cloud.platform_services.context_based_restrictions.v1.model.ListAvailableServicerefTargetsOptions;
import com.ibm.cloud.platform_services.context_based_restrictions.v1.model.ListRulesOptions;
import com.ibm.cloud.platform_services.context_based_restrictions.v1.model.ListZonesOptions;
import com.ibm.cloud.platform_services.context_based_restrictions.v1.model.OutAccountSettings;
import com.ibm.cloud.platform_services.context_based_restrictions.v1.model.OutRule;
import com.ibm.cloud.platform_services.context_based_restrictions.v1.model.OutRulePage;
import com.ibm.cloud.platform_services.context_based_restrictions.v1.model.OutZone;
import com.ibm.cloud.platform_services.context_based_restrictions.v1.model.OutZonePage;
import com.ibm.cloud.platform_services.context_based_restrictions.v1.model.ReplaceRuleOptions;
import com.ibm.cloud.platform_services.context_based_restrictions.v1.model.ReplaceZoneOptions;
import com.ibm.cloud.platform_services.context_based_restrictions.v1.model.Resource;
import com.ibm.cloud.platform_services.context_based_restrictions.v1.model.ResourceAttribute;
import com.ibm.cloud.platform_services.context_based_restrictions.v1.model.RuleContext;
import com.ibm.cloud.platform_services.context_based_restrictions.v1.model.RuleContextAttribute;
import com.ibm.cloud.platform_services.context_based_restrictions.v1.model.ServiceRefTargetPage;
import com.ibm.cloud.sdk.core.http.Response;
import com.ibm.cloud.sdk.core.service.exception.ServiceResponseException;
import com.ibm.cloud.sdk.core.util.CredentialUtils;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

//
// This file provides an example of how to use the Context Based Restrictions service.
//
// The following configuration properties are assumed to be defined:
// CONTEXT_BASED_RESTRICTIONS_URL=<service base url>
// CONTEXT_BASED_RESTRICTIONS_AUTH_TYPE=iam
// CONTEXT_BASED_RESTRICTIONS_APIKEY=<IAM apikey>
// CONTEXT_BASED_RESTRICTIONS_AUTH_URL=<IAM token service base URL - omit this if using the production environment>
//
// These configuration properties can be exported as environment variables, or stored
// in a configuration file and then:
// export IBM_CREDENTIALS_FILE=<name of configuration file>
//
public class ContextBasedRestrictionsExamples {
  private static final Logger logger = LoggerFactory.getLogger(ContextBasedRestrictionsExamples.class);
  protected ContextBasedRestrictionsExamples() { }

  @SuppressWarnings("checkstyle:methodlength")
  public static void main(String[] args) throws Exception {
    ContextBasedRestrictions contextBasedRestrictionsService = ContextBasedRestrictions.newInstance();

    // Load up our test-specific config properties.
    Map<String, String> config = CredentialUtils.getServiceProperties(ContextBasedRestrictions.DEFAULT_SERVICE_NAME);

    try {
      System.out.println("createZone() result:");
      // begin-create_zone
      AddressIPAddress addressModel = new AddressIPAddress.Builder()
        .type("ipAddress")
        .ipAddress("testString")
        .build();
      CreateZoneOptions createZoneOptions = new CreateZoneOptions.Builder()
        .name("an example of zone")
        .accountId("12ab34cd56ef78ab90cd12ef34ab56cd")
        .description("this is an example of zone")
        .addresses(new java.util.ArrayList<Address>(java.util.Arrays.asList(addressModel)))
        .excluded(new java.util.ArrayList<Address>(java.util.Arrays.asList(addressModel)))
        .build();

      Response<OutZone> response = contextBasedRestrictionsService.createZone(createZoneOptions).execute();
      OutZone outZone = response.getResult();

      System.out.println(outZone);
      // end-create_zone
    } catch (ServiceResponseException e) {
        logger.error(String.format("Service returned status code %s: %s%nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()), e);
    }

    try {
      System.out.println("listZones() result:");
      // begin-list_zones
      ListZonesOptions listZonesOptions = new ListZonesOptions.Builder()
        .accountId("testString")
        .build();

      Response<OutZonePage> response = contextBasedRestrictionsService.listZones(listZonesOptions).execute();
      OutZonePage outZonePage = response.getResult();

      System.out.println(outZonePage);
      // end-list_zones
    } catch (ServiceResponseException e) {
        logger.error(String.format("Service returned status code %s: %s%nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()), e);
    }

    try {
      System.out.println("getZone() result:");
      // begin-get_zone
      GetZoneOptions getZoneOptions = new GetZoneOptions.Builder()
        .zoneId("testString")
        .build();

      Response<OutZone> response = contextBasedRestrictionsService.getZone(getZoneOptions).execute();
      OutZone outZone = response.getResult();

      System.out.println(outZone);
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
        .ipAddress("testString")
        .build();
      ReplaceZoneOptions replaceZoneOptions = new ReplaceZoneOptions.Builder()
        .zoneId("testString")
        .ifMatch("testString")
        .name("an example of zone")
        .accountId("12ab34cd56ef78ab90cd12ef34ab56cd")
        .description("this is an example of zone")
        .addresses(new java.util.ArrayList<Address>(java.util.Arrays.asList(addressModel)))
        .excluded(new java.util.ArrayList<Address>(java.util.Arrays.asList(addressModel)))
        .build();

      Response<OutZone> response = contextBasedRestrictionsService.replaceZone(replaceZoneOptions).execute();
      OutZone outZone = response.getResult();

      System.out.println(outZone);
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

      Response<ServiceRefTargetPage> response = contextBasedRestrictionsService.listAvailableServicerefTargets(listAvailableServicerefTargetsOptions).execute();
      ServiceRefTargetPage serviceRefTargetPage = response.getResult();

      System.out.println(serviceRefTargetPage);
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
        .value("65810ac762004f22ac19f8f8edf70a34")
        .build();
      RuleContext ruleContextModel = new RuleContext.Builder()
        .attributes(new java.util.ArrayList<RuleContextAttribute>(java.util.Arrays.asList(ruleContextAttributeModel)))
        .build();
      ResourceAttribute resourceAttributeModel = new ResourceAttribute.Builder()
        .name("accountId")
        .value("12ab34cd56ef78ab90cd12ef34ab56cd")
        .build();
      Resource resourceModel = new Resource.Builder()
        .attributes(new java.util.ArrayList<ResourceAttribute>(java.util.Arrays.asList(resourceAttributeModel)))
        .build();
      CreateRuleOptions createRuleOptions = new CreateRuleOptions.Builder()
        .description("this is an example of rule")
        .contexts(new java.util.ArrayList<RuleContext>(java.util.Arrays.asList(ruleContextModel)))
        .resources(new java.util.ArrayList<Resource>(java.util.Arrays.asList(resourceModel)))
        .build();

      Response<OutRule> response = contextBasedRestrictionsService.createRule(createRuleOptions).execute();
      OutRule outRule = response.getResult();

      System.out.println(outRule);
      // end-create_rule
    } catch (ServiceResponseException e) {
        logger.error(String.format("Service returned status code %s: %s%nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()), e);
    }

    try {
      System.out.println("listRules() result:");
      // begin-list_rules
      ListRulesOptions listRulesOptions = new ListRulesOptions.Builder()
        .accountId("testString")
        .build();

      Response<OutRulePage> response = contextBasedRestrictionsService.listRules(listRulesOptions).execute();
      OutRulePage outRulePage = response.getResult();

      System.out.println(outRulePage);
      // end-list_rules
    } catch (ServiceResponseException e) {
        logger.error(String.format("Service returned status code %s: %s%nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()), e);
    }

    try {
      System.out.println("getRule() result:");
      // begin-get_rule
      GetRuleOptions getRuleOptions = new GetRuleOptions.Builder()
        .ruleId("testString")
        .build();

      Response<OutRule> response = contextBasedRestrictionsService.getRule(getRuleOptions).execute();
      OutRule outRule = response.getResult();

      System.out.println(outRule);
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
        .value("76921bd873115033bd2a0909fe081b45")
        .build();
      RuleContext ruleContextModel = new RuleContext.Builder()
        .attributes(new java.util.ArrayList<RuleContextAttribute>(java.util.Arrays.asList(ruleContextAttributeModel)))
        .build();
      ResourceAttribute resourceAttributeModel = new ResourceAttribute.Builder()
        .name("accountId")
        .value("12ab34cd56ef78ab90cd12ef34ab56cd")
        .build();
      Resource resourceModel = new Resource.Builder()
        .attributes(new java.util.ArrayList<ResourceAttribute>(java.util.Arrays.asList(resourceAttributeModel)))
        .build();
      ReplaceRuleOptions replaceRuleOptions = new ReplaceRuleOptions.Builder()
        .ruleId("testString")
        .ifMatch("testString")
        .description("this is an example of rule")
        .contexts(new java.util.ArrayList<RuleContext>(java.util.Arrays.asList(ruleContextModel)))
        .resources(new java.util.ArrayList<Resource>(java.util.Arrays.asList(resourceModel)))
        .build();

      Response<OutRule> response = contextBasedRestrictionsService.replaceRule(replaceRuleOptions).execute();
      OutRule outRule = response.getResult();

      System.out.println(outRule);
      // end-replace_rule
    } catch (ServiceResponseException e) {
        logger.error(String.format("Service returned status code %s: %s%nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()), e);
    }

    try {
      System.out.println("getAccountSettings() result:");
      // begin-get_account_settings
      GetAccountSettingsOptions getAccountSettingsOptions = new GetAccountSettingsOptions.Builder()
        .accountId("testString")
        .build();

      Response<OutAccountSettings> response = contextBasedRestrictionsService.getAccountSettings(getAccountSettingsOptions).execute();
      OutAccountSettings outAccountSettings = response.getResult();

      System.out.println(outAccountSettings);
      // end-get_account_settings
    } catch (ServiceResponseException e) {
        logger.error(String.format("Service returned status code %s: %s%nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()), e);
    }

    try {
      // begin-delete_zone
      DeleteZoneOptions deleteZoneOptions = new DeleteZoneOptions.Builder()
        .zoneId("testString")
        .build();

      Response<Void> response = contextBasedRestrictionsService.deleteZone(deleteZoneOptions).execute();
      // end-delete_zone
      System.out.printf("deleteZone() response status code: %d%n", response.getStatusCode());
    } catch (ServiceResponseException e) {
        logger.error(String.format("Service returned status code %s: %s%nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()), e);
    }

    try {
      // begin-delete_rule
      DeleteRuleOptions deleteRuleOptions = new DeleteRuleOptions.Builder()
        .ruleId("testString")
        .build();

      Response<Void> response = contextBasedRestrictionsService.deleteRule(deleteRuleOptions).execute();
      // end-delete_rule
      System.out.printf("deleteRule() response status code: %d%n", response.getStatusCode());
    } catch (ServiceResponseException e) {
        logger.error(String.format("Service returned status code %s: %s%nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()), e);
    }

  }
}
