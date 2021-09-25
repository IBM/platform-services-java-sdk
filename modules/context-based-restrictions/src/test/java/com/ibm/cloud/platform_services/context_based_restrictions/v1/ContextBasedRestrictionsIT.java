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
import java.util.UUID;

import org.junit.FixMethodOrder;
import org.junit.runner.OrderWith;
import org.junit.runners.MethodSorters;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import static org.testng.Assert.*;

/**
 * Integration test class for the ContextBasedRestrictions service.
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ContextBasedRestrictionsIT extends SdkIntegrationTestBase {
  public ContextBasedRestrictions service = null;
  public static Map<String, String> config = null;
  final HashMap<String, InputStream> mockStreamMap = TestUtilities.createMockStreamMap();
  final List<FileWithMetadata> mockListFileWithMetadata = TestUtilities.creatMockListFileWithMetadata();

  private String NonExistentID = "1234567890abcdef1234567890abcdef";
  private String InvalidID     = "this_is_an_invalid_id";

  private String serviceURL;
  private String testAccountID;
  private String testServiceName;
  private String zoneID;
  private String zoneRev;
  private String ruleID;
  private String ruleRev;
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

    serviceURL = config.get("URL");
    testAccountID = config.get("TEST_ACCOUNT_ID");
    testServiceName = config.get("TEST_SERVICE_NAME");

    System.out.printf("\nService URL: %s\n", serviceURL);
    System.out.printf("Test Account ID: %s\n", testAccountID);
    System.out.printf("Test Service Name: %s\n", testServiceName);
    System.out.println("Setup complete.");
  }

  @Test
  public void t01_testCreateZone() throws Exception {
    try {
      AddressIPAddress addressModel = new AddressIPAddress.Builder()
      .type("ipAddress")
      .value("169.23.56.234")
      .build();

      CreateZoneOptions createZoneOptions = new CreateZoneOptions.Builder()
      .name("SDK TEST - an example of zone")
      .accountId(testAccountID)
      .description("SDK TEST - this is an example of zone")
      .addresses(new java.util.ArrayList<Address>(java.util.Arrays.asList(addressModel)))
      .transactionId("sdk-create-zone-"+UUID.randomUUID().toString())
      .build();

      // Invoke operation
      Response<OutZone> response = service.createZone(createZoneOptions).execute();
      // Validate response
      assertNotNull(response);
      assertEquals(response.getStatusCode(), 201);

      OutZone outZoneResult = response.getResult();

      assertNotNull(outZoneResult);
      this.zoneID = outZoneResult.getId();
      this.zoneRev = response.getHeaders().values("Etag").get(0);
      System.out.println(outZoneResult.getId());
      System.out.println(response.getHeaders().values("Etag").get(0));
      System.out.println(response.getHeaders().values("Etag").size());
    } catch (ServiceResponseException e) {
        fail(String.format("Service returned status code %d: %s%nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()));
    }
  }

  @Test
  public void t02_testListZones() throws Exception {
    try {
      System.out.printf("\nListZones: %s || %s\n",zoneID,zoneRev);
      ListZonesOptions listZonesOptions = new ListZonesOptions.Builder()
      .accountId(testAccountID)
      .transactionId("sdk-list-zones-"+UUID.randomUUID().toString())
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
  public void t03_testGetZone() throws Exception {
    try {
      GetZoneOptions getZoneOptions = new GetZoneOptions.Builder()
      .zoneId(zoneID)
      .transactionId("sdk-get-zone-"+UUID.randomUUID().toString())
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
  public void t04_testReplaceZone() throws Exception {
    try {
      AddressIPAddress addressModel = new AddressIPAddress.Builder()
      .type("ipAddress")
      .value("169.23.56.234")
      .build();

      ReplaceZoneOptions replaceZoneOptions = new ReplaceZoneOptions.Builder()
      .zoneId(zoneID)
      .ifMatch(zoneRev)
      .name("SDK TEST - an example of updated zone")
      .accountId(testAccountID)
      .description("SDK TEST - this is an example of updated zone")
      .addresses(new java.util.ArrayList<Address>(java.util.Arrays.asList(addressModel)))
      .transactionId("sdk-replace-zone-"+UUID.randomUUID().toString())
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
  public void t05_testListAvailableServicerefTargets() throws Exception {
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
  public void t06_testCreateRule() throws Exception {
    try {
      RuleContextAttribute ruleContextAttributeModel = new RuleContextAttribute.Builder()
      .name("networkZoneId")
      .value(zoneID)
      .build();

      RuleContext ruleContextModel = new RuleContext.Builder()
      .attributes(new java.util.ArrayList<RuleContextAttribute>(java.util.Arrays.asList(ruleContextAttributeModel)))
      .build();

      ResourceAttribute resourceAttributeModelAccountID = new ResourceAttribute.Builder()
      .name("accountId")
      .value(testAccountID)
      .build();

      ResourceAttribute resourceAttributeModelServiceName = new ResourceAttribute.Builder()
              .name("serviceName")
              .value(testServiceName)
              .build();

      ResourceTagAttribute resourceTagAttributeModel = new ResourceTagAttribute.Builder()
      .name("tagName")
      .value("tagValue")
      .build();

      Resource resourceModel = new Resource.Builder()
      .attributes(new java.util.ArrayList<ResourceAttribute>(java.util.Arrays.asList(resourceAttributeModelAccountID,resourceAttributeModelServiceName)))
      .tags(new java.util.ArrayList<ResourceTagAttribute>(java.util.Arrays.asList(resourceTagAttributeModel)))
      .build();

      CreateRuleOptions createRuleOptions = new CreateRuleOptions.Builder()
      .description("SDK TEST - this is an example of rule")
      .contexts(new java.util.ArrayList<RuleContext>(java.util.Arrays.asList(ruleContextModel)))
      .resources(new java.util.ArrayList<Resource>(java.util.Arrays.asList(resourceModel)))
      .transactionId("sdk-create-rule-"+UUID.randomUUID().toString())
      .build();

      // Invoke operation
      Response<OutRule> response = service.createRule(createRuleOptions).execute();
      // Validate response
      assertNotNull(response);
      assertEquals(response.getStatusCode(), 201);

      OutRule outRuleResult = response.getResult();

      assertNotNull(outRuleResult);

      this.ruleID = outRuleResult.getId();
      this.ruleRev = response.getHeaders().values("Etag").get(0);
    } catch (ServiceResponseException e) {
        fail(String.format("Service returned status code %d: %s%nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()));
    }
  }

  @Test
  public void t07_testListRules() throws Exception {
    try {
      ListRulesOptions listRulesOptions = new ListRulesOptions.Builder()
      .accountId(testAccountID)
      .transactionId("sdk-list-rules-"+UUID.randomUUID().toString())
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
  public void t08_testGetRule() throws Exception {
    try {
      GetRuleOptions getRuleOptions = new GetRuleOptions.Builder()
      .ruleId(ruleID)
      .transactionId("sdk-get-rule-"+UUID.randomUUID().toString())
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
  public void t09_testReplaceRule() throws Exception {
    try {
      RuleContextAttribute ruleContextAttributeModel = new RuleContextAttribute.Builder()
      .name("networkZoneId")
      .value(zoneID)
      .build();

      RuleContext ruleContextModel = new RuleContext.Builder()
      .attributes(new java.util.ArrayList<RuleContextAttribute>(java.util.Arrays.asList(ruleContextAttributeModel)))
      .build();

      ResourceAttribute resourceAttributeModelAccountName = new ResourceAttribute.Builder()
      .name("accountId")
      .value(testAccountID)
      .build();

      ResourceAttribute resourceAttributeModelServiceName = new ResourceAttribute.Builder()
              .name("serviceName")
              .value(testServiceName)
              .build();

      ResourceTagAttribute resourceTagAttributeModel = new ResourceTagAttribute.Builder()
      .name("tagName")
      .value("updatedTagValue")
      .build();

      Resource resourceModel = new Resource.Builder()
      .attributes(new java.util.ArrayList<ResourceAttribute>(java.util.Arrays.asList(resourceAttributeModelAccountName,resourceAttributeModelServiceName)))
      .tags(new java.util.ArrayList<ResourceTagAttribute>(java.util.Arrays.asList(resourceTagAttributeModel)))
      .build();

      ReplaceRuleOptions replaceRuleOptions = new ReplaceRuleOptions.Builder()
      .ruleId(ruleID)
      .ifMatch(ruleRev)
      .description("SDK TEST - this is an example of updated rule")
      .contexts(new java.util.ArrayList<RuleContext>(java.util.Arrays.asList(ruleContextModel)))
      .resources(new java.util.ArrayList<Resource>(java.util.Arrays.asList(resourceModel)))
      .transactionId("sdk-replace-rule-"+UUID.randomUUID().toString())
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
  public void t10_testGetAccountSettings() throws Exception {
    try {
      GetAccountSettingsOptions getAccountSettingsOptions = new GetAccountSettingsOptions.Builder()
      .accountId(testAccountID)
      .transactionId("sdk-get-account-settings-"+UUID.randomUUID().toString())
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

// Requests with errors

  @Test
  public void t11_testCreateZoneInvalidIP() throws Exception {
    try {
      AddressIPAddress addressModel = new AddressIPAddress.Builder()
      .type("ipAddress")
      .value("169.23.56.234.")
      .build();

      CreateZoneOptions createZoneOptions = new CreateZoneOptions.Builder()
      .name("SDK TEST - an example of zone")
      .accountId(testAccountID)
      .description("SDK TEST - this is an example of zone")
      .addresses(new java.util.ArrayList<Address>(java.util.Arrays.asList(addressModel)))
      .transactionId("sdk-create-zone-"+UUID.randomUUID().toString())
      .build();

      // Invoke operation
      Response<OutZone> response = service.createZone(createZoneOptions).execute();
    } catch (ServiceResponseException e) {
      if (e.getStatusCode() != 400)
        fail(String.format("Service returned status code %d: %s%nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()));
    }
  }

  @Test
  public void t12_testListZonesInvalidAccountID() throws Exception {
    try {
      ListZonesOptions listZonesOptions = new ListZonesOptions.Builder()
      .accountId(InvalidID)
      .transactionId("sdk-list-zones-"+UUID.randomUUID().toString())
      .build();

      // Invoke operation
      Response<OutZonePage> response = service.listZones(listZonesOptions).execute();
    } catch (ServiceResponseException e) {
      if(e.getStatusCode() != 400)
        fail(String.format("Service returned status code %d: %s%nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()));
    }
  }

  @Test
  public void t13_testGetZoneNotFound() throws Exception {
    try {
      GetZoneOptions getZoneOptions = new GetZoneOptions.Builder()
      .zoneId(NonExistentID)
      .transactionId("sdk-get-zone-"+UUID.randomUUID().toString())
      .build();

      // Invoke operation
      Response<OutZone> response = service.getZone(getZoneOptions).execute();
    } catch (ServiceResponseException e) {
      if(e.getStatusCode() != 404)
        fail(String.format("Service returned status code %d: %s%nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()));
    }
  }

  @Test
  public void t14_testReplaceZoneNotFound() throws Exception {
    try {
      AddressIPAddress addressModel = new AddressIPAddress.Builder()
              .type("ipAddress")
              .value("169.23.56.234")
              .build();

      ReplaceZoneOptions replaceZoneOptions = new ReplaceZoneOptions.Builder()
              .zoneId(NonExistentID)
              .ifMatch("abc")
              .name("SDK TEST - an example of zone")
              .accountId(testAccountID)
              .description("SDK TEST - this is an example of zone")
              .addresses(new java.util.ArrayList<Address>(java.util.Arrays.asList(addressModel)))
              .transactionId("sdk-replace-zone-"+UUID.randomUUID().toString())
              .build();

      // Invoke operation
      Response<OutZone> response = service.replaceZone(replaceZoneOptions).execute();
    } catch (ServiceResponseException e) {
      if(e.getStatusCode() != 404)
      fail(String.format("Service returned status code %d: %s%nError details: %s",
              e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()));
    }
  }

  @Test
  public void t15_testListAvailableServicerefTargetsInvalidType() throws Exception {
    try {
      ListAvailableServicerefTargetsOptions listAvailableServicerefTargetsOptions = new ListAvailableServicerefTargetsOptions.Builder()
              .type("invalid-type")
              .build();

      // Invoke operation
      Response<ServiceRefTargetPage> response = service.listAvailableServicerefTargets(listAvailableServicerefTargetsOptions).execute();
    } catch (ServiceResponseException e) {
      if(e.getStatusCode() != 400)
      fail(String.format("Service returned status code %d: %s%nError details: %s",
              e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()));
    }
  }

  @Test
  public void t16_testCreateRuleNotCBREnabled() throws Exception {
    try {
      RuleContextAttribute ruleContextAttributeModel = new RuleContextAttribute.Builder()
              .name("networkZoneId")
              .value(zoneID)
              .build();

      RuleContext ruleContextModel = new RuleContext.Builder()
              .attributes(new java.util.ArrayList<RuleContextAttribute>(java.util.Arrays.asList(ruleContextAttributeModel)))
              .build();

      ResourceAttribute resourceAttributeModelAccountID = new ResourceAttribute.Builder()
              .name("accountId")
              .value(testAccountID)
              .build();

      ResourceAttribute resourceAttributeModelServiceName = new ResourceAttribute.Builder()
              .name("serviceName")
              .value("cbr-not-enabled")
              .build();

      ResourceTagAttribute resourceTagAttributeModel = new ResourceTagAttribute.Builder()
              .name("tagName")
              .value("tagValue")
              .build();

      Resource resourceModel = new Resource.Builder()
              .attributes(new java.util.ArrayList<ResourceAttribute>(java.util.Arrays.asList(resourceAttributeModelAccountID,resourceAttributeModelServiceName)))
              .tags(new java.util.ArrayList<ResourceTagAttribute>(java.util.Arrays.asList(resourceTagAttributeModel)))
              .build();

      CreateRuleOptions createRuleOptions = new CreateRuleOptions.Builder()
              .description("SDK TEST - this is an example of rule")
              .contexts(new java.util.ArrayList<RuleContext>(java.util.Arrays.asList(ruleContextModel)))
              .resources(new java.util.ArrayList<Resource>(java.util.Arrays.asList(resourceModel)))
              .transactionId("sdk-create-rule-"+UUID.randomUUID().toString())
              .build();

      // Invoke operation
      Response<OutRule> response = service.createRule(createRuleOptions).execute();
    } catch (ServiceResponseException e) {
      if(e.getStatusCode() != 400)
      fail(String.format("Service returned status code %d: %s%nError details: %s",
              e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()));
    }
  }

  @Test
  public void t17_testListRulesInvalidAccountID() throws Exception {
    try {
      ListRulesOptions listRulesOptions = new ListRulesOptions.Builder()
              .accountId(InvalidID)
              .transactionId("sdk-list-rules-"+UUID.randomUUID().toString())
              .build();

      // Invoke operation
      Response<OutRulePage> response = service.listRules(listRulesOptions).execute();
    } catch (ServiceResponseException e) {
      if(e.getStatusCode() != 400)
      fail(String.format("Service returned status code %d: %s%nError details: %s",
              e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()));
    }
  }

  @Test
  public void t18_testGetRuleNotFound() throws Exception {
    try {
      GetRuleOptions getRuleOptions = new GetRuleOptions.Builder()
              .ruleId(NonExistentID)
              .transactionId("sdk-get-rule-"+UUID.randomUUID().toString())
              .build();

      // Invoke operation
      Response<OutRule> response = service.getRule(getRuleOptions).execute();
    } catch (ServiceResponseException e) {
      if(e.getStatusCode() != 404)
      fail(String.format("Service returned status code %d: %s%nError details: %s",
              e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()));
    }
  }

  @Test
  public void t19_testReplaceRuleNotFound() throws Exception {
    try {
      RuleContextAttribute ruleContextAttributeModel = new RuleContextAttribute.Builder()
              .name("networkZoneId")
              .value(zoneID)
              .build();

      RuleContext ruleContextModel = new RuleContext.Builder()
              .attributes(new java.util.ArrayList<RuleContextAttribute>(java.util.Arrays.asList(ruleContextAttributeModel)))
              .build();

      ResourceAttribute resourceAttributeModelAccountName = new ResourceAttribute.Builder()
              .name("accountId")
              .value(testAccountID)
              .build();

      ResourceAttribute resourceAttributeModelServiceName = new ResourceAttribute.Builder()
              .name("serviceName")
              .value("cbr-not-enabled")
              .build();

      ResourceTagAttribute resourceTagAttributeModel = new ResourceTagAttribute.Builder()
              .name("tagName")
              .value("updatedTagValue")
              .build();

      Resource resourceModel = new Resource.Builder()
              .attributes(new java.util.ArrayList<ResourceAttribute>(java.util.Arrays.asList(resourceAttributeModelAccountName,resourceAttributeModelServiceName)))
              .tags(new java.util.ArrayList<ResourceTagAttribute>(java.util.Arrays.asList(resourceTagAttributeModel)))
              .build();

      ReplaceRuleOptions replaceRuleOptions = new ReplaceRuleOptions.Builder()
              .ruleId(ruleID)
              .ifMatch("abc")
              .description("SDK TEST - this is an example of rule")
              .contexts(new java.util.ArrayList<RuleContext>(java.util.Arrays.asList(ruleContextModel)))
              .resources(new java.util.ArrayList<Resource>(java.util.Arrays.asList(resourceModel)))
              .transactionId("sdk-replace-rule-"+UUID.randomUUID().toString())
              .build();

      // Invoke operation
      Response<OutRule> response = service.replaceRule(replaceRuleOptions).execute();
    } catch (ServiceResponseException e) {
      if(e.getStatusCode() != 412)
      fail(String.format("Service returned status code %d: %s%nError details: %s",
              e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()));
    }
  }

  @Test
  public void t20_testGetAccountSettingsInvalidAccountID() throws Exception {
    try {
      GetAccountSettingsOptions getAccountSettingsOptions = new GetAccountSettingsOptions.Builder()
              .accountId(InvalidID)
              .transactionId("sdk-get-account-settings-"+UUID.randomUUID().toString())
              .build();

      // Invoke operation
      Response<OutAccountSettings> response = service.getAccountSettings(getAccountSettingsOptions).execute();
    } catch (ServiceResponseException e) {
      if(e.getStatusCode() != 400)
      fail(String.format("Service returned status code %d: %s%nError details: %s",
              e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()));
    }
  }


  @Test
  public void t21_testDeleteRuleNotFound() throws Exception {
    try {
      DeleteRuleOptions deleteRuleOptions = new DeleteRuleOptions.Builder()
              .ruleId(NonExistentID)
              .transactionId("sdk-delete-rule-"+UUID.randomUUID().toString())
              .build();

      // Invoke operation
      Response<Void> response = service.deleteRule(deleteRuleOptions).execute();
    } catch (ServiceResponseException e) {
      if(e.getStatusCode() != 404)
      fail(String.format("Service returned status code %d: %s%nError details: %s",
              e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()));
    }
  }

  @Test
  public void t22_testDeleteZoneNotFound() throws Exception {
    try {
      DeleteZoneOptions deleteZoneOptions = new DeleteZoneOptions.Builder()
              .zoneId(NonExistentID)
              .transactionId("sdk-delete-zone-"+UUID.randomUUID().toString())
              .build();

      // Invoke operation
      Response<Void> response = service.deleteZone(deleteZoneOptions).execute();
    } catch (ServiceResponseException e) {
      if(e.getStatusCode() != 404)
      fail(String.format("Service returned status code %d: %s%nError details: %s",
              e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()));
    }
  }

  @Test
  public void t23_testDeleteRule() throws Exception {
    try {
      DeleteRuleOptions deleteRuleOptions = new DeleteRuleOptions.Builder()
              .ruleId(ruleID)
              .transactionId("sdk-delete-rule-"+UUID.randomUUID().toString())
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

  @Test
  public void t24_testDeleteZone() throws Exception {
    try {
      DeleteZoneOptions deleteZoneOptions = new DeleteZoneOptions.Builder()
//      .zoneId("b80f86e7c78d20b9c98447e4087b354c")
//              .zoneId("e0111b4aa62e694769214661c3bb3ed7")
              .zoneId(zoneID)
              .transactionId("sdk-delete-zone-"+UUID.randomUUID().toString())
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

  @AfterClass
  public void tearDown() {
    // Add any clean up logic here
    System.out.println("Clean up complete.");
  }
 }
