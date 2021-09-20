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
import com.ibm.cloud.platform_services.context_based_restrictions.v1.model.AddressIPAddressRange;
import com.ibm.cloud.platform_services.context_based_restrictions.v1.model.AddressServiceRef;
import com.ibm.cloud.platform_services.context_based_restrictions.v1.model.AddressSubnet;
import com.ibm.cloud.platform_services.context_based_restrictions.v1.model.AddressVPC;
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
import com.ibm.cloud.platform_services.context_based_restrictions.v1.model.OutZoneSummary;
import com.ibm.cloud.platform_services.context_based_restrictions.v1.model.ReplaceRuleOptions;
import com.ibm.cloud.platform_services.context_based_restrictions.v1.model.ReplaceZoneOptions;
import com.ibm.cloud.platform_services.context_based_restrictions.v1.model.Resource;
import com.ibm.cloud.platform_services.context_based_restrictions.v1.model.ResourceAttribute;
import com.ibm.cloud.platform_services.context_based_restrictions.v1.model.ResourceTagAttribute;
import com.ibm.cloud.platform_services.context_based_restrictions.v1.model.RuleContext;
import com.ibm.cloud.platform_services.context_based_restrictions.v1.model.RuleContextAttribute;
import com.ibm.cloud.platform_services.context_based_restrictions.v1.model.ServiceRefTarget;
import com.ibm.cloud.platform_services.context_based_restrictions.v1.model.ServiceRefTargetPage;
import com.ibm.cloud.platform_services.context_based_restrictions.v1.model.ServiceRefValue;
import com.ibm.cloud.platform_services.context_based_restrictions.v1.utils.TestUtilities;
import com.ibm.cloud.platform_services.test.SdkIntegrationTestBase;
import com.ibm.cloud.sdk.core.http.Response;
import com.ibm.cloud.sdk.core.service.exception.ServiceResponseException;
import com.ibm.cloud.sdk.core.service.model.FileWithMetadata;
import com.ibm.cloud.sdk.core.util.CredentialUtils;
import com.ibm.cloud.sdk.core.util.DateUtils;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import static org.testng.Assert.*;

/**
 * Integration test class for the ContextBasedRestrictions service.
 */
public class ContextBasedRestrictionsIT extends SdkIntegrationTestBase {
  public ContextBasedRestrictions service = null;
  public static Map<String, String> config = null;
  final HashMap<String, InputStream> mockStreamMap = TestUtilities.createMockStreamMap();
  final List<FileWithMetadata> mockListFileWithMetadata = TestUtilities.creatMockListFileWithMetadata();
  /**
   * This method provides our config filename to the base class.
   */

  public String getConfigFilename() {
    return "../../context_based_restrictions_v1.env";
  }

  @BeforeClass
  public void constructService() {
    // Ask super if we should skip the tests.
    if (skipTests()) {
      return;
    }

    service = ContextBasedRestrictions.newInstance();
    assertNotNull(service);
    assertNotNull(service.getServiceUrl());

    // Load up our test-specific config properties.
    config = CredentialUtils.getServiceProperties(ContextBasedRestrictions.DEFAULT_SERVICE_NAME);
    assertNotNull(config);
    assertFalse(config.isEmpty());
    assertEquals(service.getServiceUrl(), config.get("URL"));

    System.out.println("Setup complete.");
  }

  @Test
  public void testCreateZone() throws Exception {
    try {
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
      .transactionId("testString")
      .build();

      // Invoke operation
      Response<OutZone> response = service.createZone(createZoneOptions).execute();
      // Validate response
      assertNotNull(response);
      assertEquals(response.getStatusCode(), 201);

      OutZone outZoneResult = response.getResult();

      assertNotNull(outZoneResult);
    } catch (ServiceResponseException e) {
        fail(String.format("Service returned status code %d: %s%nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()));
    }
  }

  @Test
  public void testListZones() throws Exception {
    try {
      ListZonesOptions listZonesOptions = new ListZonesOptions.Builder()
      .accountId("testString")
      .transactionId("testString")
      .name("testString")
      .sort("testString")
      .build();

      // Invoke operation
      Response<OutZonePage> response = service.listZones(listZonesOptions).execute();
      // Validate response
      assertNotNull(response);
      assertEquals(response.getStatusCode(), 200);

      OutZonePage outZonePageResult = response.getResult();

      assertNotNull(outZonePageResult);
    } catch (ServiceResponseException e) {
        fail(String.format("Service returned status code %d: %s%nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()));
    }
  }

  @Test
  public void testGetZone() throws Exception {
    try {
      GetZoneOptions getZoneOptions = new GetZoneOptions.Builder()
      .zoneId("testString")
      .transactionId("testString")
      .build();

      // Invoke operation
      Response<OutZone> response = service.getZone(getZoneOptions).execute();
      // Validate response
      assertNotNull(response);
      assertEquals(response.getStatusCode(), 200);

      OutZone outZoneResult = response.getResult();

      assertNotNull(outZoneResult);
    } catch (ServiceResponseException e) {
        fail(String.format("Service returned status code %d: %s%nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()));
    }
  }

  @Test
  public void testReplaceZone() throws Exception {
    try {
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
      .transactionId("testString")
      .build();

      // Invoke operation
      Response<OutZone> response = service.replaceZone(replaceZoneOptions).execute();
      // Validate response
      assertNotNull(response);
      assertEquals(response.getStatusCode(), 200);

      OutZone outZoneResult = response.getResult();

      assertNotNull(outZoneResult);
    } catch (ServiceResponseException e) {
        fail(String.format("Service returned status code %d: %s%nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()));
    }
  }

  @Test
  public void testListAvailableServicerefTargets() throws Exception {
    try {
      ListAvailableServicerefTargetsOptions listAvailableServicerefTargetsOptions = new ListAvailableServicerefTargetsOptions.Builder()
      .type("all")
      .build();

      // Invoke operation
      Response<ServiceRefTargetPage> response = service.listAvailableServicerefTargets(listAvailableServicerefTargetsOptions).execute();
      // Validate response
      assertNotNull(response);
      assertEquals(response.getStatusCode(), 200);

      ServiceRefTargetPage serviceRefTargetPageResult = response.getResult();

      assertNotNull(serviceRefTargetPageResult);
    } catch (ServiceResponseException e) {
        fail(String.format("Service returned status code %d: %s%nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()));
    }
  }

  @Test
  public void testCreateRule() throws Exception {
    try {
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
      .operator("testString")
      .build();

      ResourceTagAttribute resourceTagAttributeModel = new ResourceTagAttribute.Builder()
      .name("testString")
      .value("testString")
      .operator("testString")
      .build();

      Resource resourceModel = new Resource.Builder()
      .attributes(new java.util.ArrayList<ResourceAttribute>(java.util.Arrays.asList(resourceAttributeModel)))
      .tags(new java.util.ArrayList<ResourceTagAttribute>(java.util.Arrays.asList(resourceTagAttributeModel)))
      .build();

      CreateRuleOptions createRuleOptions = new CreateRuleOptions.Builder()
      .description("this is an example of rule")
      .contexts(new java.util.ArrayList<RuleContext>(java.util.Arrays.asList(ruleContextModel)))
      .resources(new java.util.ArrayList<Resource>(java.util.Arrays.asList(resourceModel)))
      .transactionId("testString")
      .build();

      // Invoke operation
      Response<OutRule> response = service.createRule(createRuleOptions).execute();
      // Validate response
      assertNotNull(response);
      assertEquals(response.getStatusCode(), 201);

      OutRule outRuleResult = response.getResult();

      assertNotNull(outRuleResult);
    } catch (ServiceResponseException e) {
        fail(String.format("Service returned status code %d: %s%nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()));
    }
  }

  @Test
  public void testListRules() throws Exception {
    try {
      ListRulesOptions listRulesOptions = new ListRulesOptions.Builder()
      .accountId("testString")
      .transactionId("testString")
      .region("testString")
      .resource("testString")
      .resourceType("testString")
      .serviceInstance("testString")
      .serviceName("testString")
      .serviceType("testString")
      .zoneId("testString")
      .sort("testString")
      .build();

      // Invoke operation
      Response<OutRulePage> response = service.listRules(listRulesOptions).execute();
      // Validate response
      assertNotNull(response);
      assertEquals(response.getStatusCode(), 200);

      OutRulePage outRulePageResult = response.getResult();

      assertNotNull(outRulePageResult);
    } catch (ServiceResponseException e) {
        fail(String.format("Service returned status code %d: %s%nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()));
    }
  }

  @Test
  public void testGetRule() throws Exception {
    try {
      GetRuleOptions getRuleOptions = new GetRuleOptions.Builder()
      .ruleId("testString")
      .transactionId("testString")
      .build();

      // Invoke operation
      Response<OutRule> response = service.getRule(getRuleOptions).execute();
      // Validate response
      assertNotNull(response);
      assertEquals(response.getStatusCode(), 200);

      OutRule outRuleResult = response.getResult();

      assertNotNull(outRuleResult);
    } catch (ServiceResponseException e) {
        fail(String.format("Service returned status code %d: %s%nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()));
    }
  }

  @Test
  public void testReplaceRule() throws Exception {
    try {
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
      .operator("testString")
      .build();

      ResourceTagAttribute resourceTagAttributeModel = new ResourceTagAttribute.Builder()
      .name("testString")
      .value("testString")
      .operator("testString")
      .build();

      Resource resourceModel = new Resource.Builder()
      .attributes(new java.util.ArrayList<ResourceAttribute>(java.util.Arrays.asList(resourceAttributeModel)))
      .tags(new java.util.ArrayList<ResourceTagAttribute>(java.util.Arrays.asList(resourceTagAttributeModel)))
      .build();

      ReplaceRuleOptions replaceRuleOptions = new ReplaceRuleOptions.Builder()
      .ruleId("testString")
      .ifMatch("testString")
      .description("this is an example of rule")
      .contexts(new java.util.ArrayList<RuleContext>(java.util.Arrays.asList(ruleContextModel)))
      .resources(new java.util.ArrayList<Resource>(java.util.Arrays.asList(resourceModel)))
      .transactionId("testString")
      .build();

      // Invoke operation
      Response<OutRule> response = service.replaceRule(replaceRuleOptions).execute();
      // Validate response
      assertNotNull(response);
      assertEquals(response.getStatusCode(), 200);

      OutRule outRuleResult = response.getResult();

      assertNotNull(outRuleResult);
    } catch (ServiceResponseException e) {
        fail(String.format("Service returned status code %d: %s%nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()));
    }
  }

  @Test
  public void testGetAccountSettings() throws Exception {
    try {
      GetAccountSettingsOptions getAccountSettingsOptions = new GetAccountSettingsOptions.Builder()
      .accountId("testString")
      .transactionId("testString")
      .build();

      // Invoke operation
      Response<OutAccountSettings> response = service.getAccountSettings(getAccountSettingsOptions).execute();
      // Validate response
      assertNotNull(response);
      assertEquals(response.getStatusCode(), 200);

      OutAccountSettings outAccountSettingsResult = response.getResult();

      assertNotNull(outAccountSettingsResult);
    } catch (ServiceResponseException e) {
        fail(String.format("Service returned status code %d: %s%nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()));
    }
  }

  @Test
  public void testDeleteZone() throws Exception {
    try {
      DeleteZoneOptions deleteZoneOptions = new DeleteZoneOptions.Builder()
      .zoneId("testString")
      .transactionId("testString")
      .build();

      // Invoke operation
      Response<Void> response = service.deleteZone(deleteZoneOptions).execute();
      // Validate response
      assertNotNull(response);
      assertEquals(response.getStatusCode(), 204);
    } catch (ServiceResponseException e) {
        fail(String.format("Service returned status code %d: %s%nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()));
    }
  }

  @Test
  public void testDeleteRule() throws Exception {
    try {
      DeleteRuleOptions deleteRuleOptions = new DeleteRuleOptions.Builder()
      .ruleId("testString")
      .transactionId("testString")
      .build();

      // Invoke operation
      Response<Void> response = service.deleteRule(deleteRuleOptions).execute();
      // Validate response
      assertNotNull(response);
      assertEquals(response.getStatusCode(), 204);
    } catch (ServiceResponseException e) {
        fail(String.format("Service returned status code %d: %s%nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()));
    }
  }

  @AfterClass
  public void tearDown() {
    // Add any clean up logic here
    System.out.println("Clean up complete.");
  }
 }
