/*
 * (C) Copyright IBM Corp. 2023.
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
package com.ibm.cloud.platform_services.usage_reports.v4;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotNull;
import static org.testng.Assert.assertNull;
import static org.testng.Assert.fail;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.ibm.cloud.platform_services.usage_reports.v4.model.AccountSummary;
import com.ibm.cloud.platform_services.usage_reports.v4.model.AccountUsage;
import com.ibm.cloud.platform_services.usage_reports.v4.model.GetAccountSummaryOptions;
import com.ibm.cloud.platform_services.usage_reports.v4.model.GetAccountUsageOptions;
import com.ibm.cloud.platform_services.usage_reports.v4.model.GetOrgUsageOptions;
import com.ibm.cloud.platform_services.usage_reports.v4.model.GetResourceGroupUsageOptions;
import com.ibm.cloud.platform_services.usage_reports.v4.model.GetResourceUsageAccountOptions;
import com.ibm.cloud.platform_services.usage_reports.v4.model.GetResourceUsageAccountPager;
import com.ibm.cloud.platform_services.usage_reports.v4.model.GetResourceUsageOrgOptions;
import com.ibm.cloud.platform_services.usage_reports.v4.model.GetResourceUsageOrgPager;
import com.ibm.cloud.platform_services.usage_reports.v4.model.GetResourceUsageResourceGroupOptions;
import com.ibm.cloud.platform_services.usage_reports.v4.model.GetResourceUsageResourceGroupPager;
import com.ibm.cloud.platform_services.usage_reports.v4.model.InstanceUsage;
import com.ibm.cloud.platform_services.usage_reports.v4.model.InstancesUsage;
import com.ibm.cloud.platform_services.usage_reports.v4.model.OrgUsage;
import com.ibm.cloud.platform_services.usage_reports.v4.model.ResourceGroupUsage;
import com.ibm.cloud.platform_services.usage_reports.v4.utils.TestUtilities;
import com.ibm.cloud.sdk.core.http.Response;
import com.ibm.cloud.sdk.core.service.model.FileWithMetadata;

import okhttp3.mockwebserver.MockResponse;
import okhttp3.mockwebserver.MockWebServer;
import okhttp3.mockwebserver.RecordedRequest;

/**
 * Unit test class for the UsageReports service.
 */
public class UsageReportsTest {

  final HashMap<String, InputStream> mockStreamMap = TestUtilities.createMockStreamMap();
  final List<FileWithMetadata> mockListFileWithMetadata = TestUtilities.creatMockListFileWithMetadata();

  protected MockWebServer server;
  protected UsageReports usageReportsService;

  // Construct the service with a null authenticator (negative test)
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testConstructorWithNullAuthenticator() throws Throwable {
    final String serviceName = "testService";
    new UsageReports(serviceName, null);
  }

  // Test the getAccountSummary operation with a valid options model parameter
  @Test
  public void testGetAccountSummaryWOptions() throws Throwable {
    // Register a mock response
    String mockResponseBody = "{\"account_id\": \"accountId\", \"month\": \"month\", \"billing_country_code\": \"billingCountryCode\", \"billing_currency_code\": \"billingCurrencyCode\", \"resources\": {\"billable_cost\": 12, \"non_billable_cost\": 15}, \"offers\": [{\"offer_id\": \"offerId\", \"credits_total\": 12, \"offer_template\": \"offerTemplate\", \"valid_from\": \"2019-01-01T12:00:00.000Z\", \"expires_on\": \"2019-01-01T12:00:00.000Z\", \"credits\": {\"starting_balance\": 15, \"used\": 4, \"balance\": 7}}], \"support\": [{\"cost\": 4, \"type\": \"type\", \"overage\": 7}], \"subscription\": {\"overage\": 7, \"subscriptions\": [{\"subscription_id\": \"subscriptionId\", \"charge_agreement_number\": \"chargeAgreementNumber\", \"type\": \"type\", \"subscription_amount\": 18, \"start\": \"2019-01-01T12:00:00.000Z\", \"end\": \"2019-01-01T12:00:00.000Z\", \"credits_total\": 12, \"terms\": [{\"start\": \"2019-01-01T12:00:00.000Z\", \"end\": \"2019-01-01T12:00:00.000Z\", \"credits\": {\"total\": 5, \"starting_balance\": 15, \"used\": 4, \"balance\": 7}}]}]}}";
    String getAccountSummaryPath = "/v4/accounts/testString/summary/testString";
    server.enqueue(new MockResponse()
      .setHeader("Content-type", "application/json")
      .setResponseCode(200)
      .setBody(mockResponseBody));

    // Construct an instance of the GetAccountSummaryOptions model
    GetAccountSummaryOptions getAccountSummaryOptionsModel = new GetAccountSummaryOptions.Builder()
      .accountId("testString")
      .billingmonth("testString")
      .build();

    // Invoke getAccountSummary() with a valid options model and verify the result
    Response<AccountSummary> response = usageReportsService.getAccountSummary(getAccountSummaryOptionsModel).execute();
    assertNotNull(response);
    AccountSummary responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request sent to the mock server
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "GET");
    // Verify request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, getAccountSummaryPath);
    // Verify that there is no query string
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNull(query);
  }

  // Test the getAccountSummary operation with and without retries enabled
  @Test
  public void testGetAccountSummaryWRetries() throws Throwable {
    usageReportsService.enableRetries(4, 30);
    testGetAccountSummaryWOptions();

    usageReportsService.disableRetries();
    testGetAccountSummaryWOptions();
  }

  // Test the getAccountSummary operation with a null options model (negative test)
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testGetAccountSummaryNoOptions() throws Throwable {
    server.enqueue(new MockResponse());
    usageReportsService.getAccountSummary(null).execute();
  }

  // Test the getAccountUsage operation with a valid options model parameter
  @Test
  public void testGetAccountUsageWOptions() throws Throwable {
    // Register a mock response
    String mockResponseBody = "{\"account_id\": \"accountId\", \"pricing_country\": \"USA\", \"currency_code\": \"USD\", \"month\": \"2017-08\", \"resources\": [{\"resource_id\": \"resourceId\", \"resource_name\": \"resourceName\", \"billable_cost\": 12, \"billable_rated_cost\": 17, \"non_billable_cost\": 15, \"non_billable_rated_cost\": 20, \"plans\": [{\"plan_id\": \"planId\", \"plan_name\": \"planName\", \"pricing_region\": \"pricingRegion\", \"billable\": true, \"cost\": 4, \"rated_cost\": 9, \"usage\": [{\"metric\": \"UP-TIME\", \"metric_name\": \"UP-TIME\", \"quantity\": 711.11, \"rateable_quantity\": 700, \"cost\": 123.45, \"rated_cost\": 130.0, \"price\": [\"anyValue\"], \"unit\": \"HOURS\", \"unit_name\": \"HOURS\", \"non_chargeable\": true, \"discounts\": [{\"ref\": \"Discount-d27beddb-111b-4bbf-8cb1-b770f531c1a9\", \"name\": \"platform-discount\", \"display_name\": \"Platform Service Discount\", \"discount\": 5}]}], \"discounts\": [{\"ref\": \"Discount-d27beddb-111b-4bbf-8cb1-b770f531c1a9\", \"name\": \"platform-discount\", \"display_name\": \"Platform Service Discount\", \"discount\": 5}], \"pending\": true}], \"discounts\": [{\"ref\": \"Discount-d27beddb-111b-4bbf-8cb1-b770f531c1a9\", \"name\": \"platform-discount\", \"display_name\": \"Platform Service Discount\", \"discount\": 5}]}], \"currency_rate\": 10.8716}";
    String getAccountUsagePath = "/v4/accounts/testString/usage/testString";
    server.enqueue(new MockResponse()
      .setHeader("Content-type", "application/json")
      .setResponseCode(200)
      .setBody(mockResponseBody));

    // Construct an instance of the GetAccountUsageOptions model
    GetAccountUsageOptions getAccountUsageOptionsModel = new GetAccountUsageOptions.Builder()
      .accountId("testString")
      .billingmonth("testString")
      .names(true)
      .acceptLanguage("testString")
      .build();

    // Invoke getAccountUsage() with a valid options model and verify the result
    Response<AccountUsage> response = usageReportsService.getAccountUsage(getAccountUsageOptionsModel).execute();
    assertNotNull(response);
    AccountUsage responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request sent to the mock server
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "GET");
    // Verify request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, getAccountUsagePath);
    // Verify query params
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNotNull(query);
    assertEquals(Boolean.valueOf(query.get("_names")), Boolean.valueOf(true));
  }

  // Test the getAccountUsage operation with and without retries enabled
  @Test
  public void testGetAccountUsageWRetries() throws Throwable {
    usageReportsService.enableRetries(4, 30);
    testGetAccountUsageWOptions();

    usageReportsService.disableRetries();
    testGetAccountUsageWOptions();
  }

  // Test the getAccountUsage operation with a null options model (negative test)
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testGetAccountUsageNoOptions() throws Throwable {
    server.enqueue(new MockResponse());
    usageReportsService.getAccountUsage(null).execute();
  }

  // Test the getResourceGroupUsage operation with a valid options model parameter
  @Test
  public void testGetResourceGroupUsageWOptions() throws Throwable {
    // Register a mock response
    String mockResponseBody = "{\"account_id\": \"accountId\", \"resource_group_id\": \"resourceGroupId\", \"resource_group_name\": \"resourceGroupName\", \"pricing_country\": \"USA\", \"currency_code\": \"USD\", \"month\": \"2017-08\", \"resources\": [{\"resource_id\": \"resourceId\", \"resource_name\": \"resourceName\", \"billable_cost\": 12, \"billable_rated_cost\": 17, \"non_billable_cost\": 15, \"non_billable_rated_cost\": 20, \"plans\": [{\"plan_id\": \"planId\", \"plan_name\": \"planName\", \"pricing_region\": \"pricingRegion\", \"billable\": true, \"cost\": 4, \"rated_cost\": 9, \"usage\": [{\"metric\": \"UP-TIME\", \"metric_name\": \"UP-TIME\", \"quantity\": 711.11, \"rateable_quantity\": 700, \"cost\": 123.45, \"rated_cost\": 130.0, \"price\": [\"anyValue\"], \"unit\": \"HOURS\", \"unit_name\": \"HOURS\", \"non_chargeable\": true, \"discounts\": [{\"ref\": \"Discount-d27beddb-111b-4bbf-8cb1-b770f531c1a9\", \"name\": \"platform-discount\", \"display_name\": \"Platform Service Discount\", \"discount\": 5}]}], \"discounts\": [{\"ref\": \"Discount-d27beddb-111b-4bbf-8cb1-b770f531c1a9\", \"name\": \"platform-discount\", \"display_name\": \"Platform Service Discount\", \"discount\": 5}], \"pending\": true}], \"discounts\": [{\"ref\": \"Discount-d27beddb-111b-4bbf-8cb1-b770f531c1a9\", \"name\": \"platform-discount\", \"display_name\": \"Platform Service Discount\", \"discount\": 5}]}], \"currency_rate\": 10.8716}";
    String getResourceGroupUsagePath = "/v4/accounts/testString/resource_groups/testString/usage/testString";
    server.enqueue(new MockResponse()
      .setHeader("Content-type", "application/json")
      .setResponseCode(200)
      .setBody(mockResponseBody));

    // Construct an instance of the GetResourceGroupUsageOptions model
    GetResourceGroupUsageOptions getResourceGroupUsageOptionsModel = new GetResourceGroupUsageOptions.Builder()
      .accountId("testString")
      .resourceGroupId("testString")
      .billingmonth("testString")
      .names(true)
      .acceptLanguage("testString")
      .build();

    // Invoke getResourceGroupUsage() with a valid options model and verify the result
    Response<ResourceGroupUsage> response = usageReportsService.getResourceGroupUsage(getResourceGroupUsageOptionsModel).execute();
    assertNotNull(response);
    ResourceGroupUsage responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request sent to the mock server
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "GET");
    // Verify request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, getResourceGroupUsagePath);
    // Verify query params
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNotNull(query);
    assertEquals(Boolean.valueOf(query.get("_names")), Boolean.valueOf(true));
  }

  // Test the getResourceGroupUsage operation with and without retries enabled
  @Test
  public void testGetResourceGroupUsageWRetries() throws Throwable {
    usageReportsService.enableRetries(4, 30);
    testGetResourceGroupUsageWOptions();

    usageReportsService.disableRetries();
    testGetResourceGroupUsageWOptions();
  }

  // Test the getResourceGroupUsage operation with a null options model (negative test)
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testGetResourceGroupUsageNoOptions() throws Throwable {
    server.enqueue(new MockResponse());
    usageReportsService.getResourceGroupUsage(null).execute();
  }

  // Test the getResourceUsageAccount operation with a valid options model parameter
  @Test
  public void testGetResourceUsageAccountWOptions() throws Throwable {
    // Register a mock response
    String mockResponseBody = "{\"limit\": 5, \"count\": 5, \"first\": {\"href\": \"href\"}, \"next\": {\"href\": \"href\", \"offset\": \"offset\"}, \"resources\": [{\"account_id\": \"accountId\", \"resource_instance_id\": \"resourceInstanceId\", \"resource_instance_name\": \"resourceInstanceName\", \"resource_id\": \"resourceId\", \"resource_name\": \"resourceName\", \"resource_group_id\": \"resourceGroupId\", \"resource_group_name\": \"resourceGroupName\", \"organization_id\": \"organizationId\", \"organization_name\": \"organizationName\", \"space_id\": \"spaceId\", \"space_name\": \"spaceName\", \"consumer_id\": \"consumerId\", \"region\": \"region\", \"pricing_region\": \"pricingRegion\", \"pricing_country\": \"USA\", \"currency_code\": \"USD\", \"billable\": true, \"plan_id\": \"planId\", \"plan_name\": \"planName\", \"month\": \"2017-08\", \"usage\": [{\"metric\": \"UP-TIME\", \"metric_name\": \"UP-TIME\", \"quantity\": 711.11, \"rateable_quantity\": 700, \"cost\": 123.45, \"rated_cost\": 130.0, \"price\": [\"anyValue\"], \"unit\": \"HOURS\", \"unit_name\": \"HOURS\", \"non_chargeable\": true, \"discounts\": [{\"ref\": \"Discount-d27beddb-111b-4bbf-8cb1-b770f531c1a9\", \"name\": \"platform-discount\", \"display_name\": \"Platform Service Discount\", \"discount\": 5}]}], \"pending\": true, \"currency_rate\": 10.8716}]}";
    String getResourceUsageAccountPath = "/v4/accounts/testString/resource_instances/usage/testString";
    server.enqueue(new MockResponse()
      .setHeader("Content-type", "application/json")
      .setResponseCode(200)
      .setBody(mockResponseBody));

    // Construct an instance of the GetResourceUsageAccountOptions model
    GetResourceUsageAccountOptions getResourceUsageAccountOptionsModel = new GetResourceUsageAccountOptions.Builder()
      .accountId("testString")
      .billingmonth("testString")
      .names(true)
      .acceptLanguage("testString")
      .limit(Long.valueOf("1"))
      .start("testString")
      .resourceGroupId("testString")
      .organizationId("testString")
      .resourceInstanceId("testString")
      .resourceId("testString")
      .planId("testString")
      .region("testString")
      .build();

    // Invoke getResourceUsageAccount() with a valid options model and verify the result
    Response<InstancesUsage> response = usageReportsService.getResourceUsageAccount(getResourceUsageAccountOptionsModel).execute();
    assertNotNull(response);
    InstancesUsage responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request sent to the mock server
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "GET");
    // Verify request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, getResourceUsageAccountPath);
    // Verify query params
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNotNull(query);
    assertEquals(Boolean.valueOf(query.get("_names")), Boolean.valueOf(true));
    assertEquals(Long.valueOf(query.get("_limit")), Long.valueOf("1"));
    assertEquals(query.get("_start"), "testString");
    assertEquals(query.get("resource_group_id"), "testString");
    assertEquals(query.get("organization_id"), "testString");
    assertEquals(query.get("resource_instance_id"), "testString");
    assertEquals(query.get("resource_id"), "testString");
    assertEquals(query.get("plan_id"), "testString");
    assertEquals(query.get("region"), "testString");
  }

  // Test the getResourceUsageAccount operation with and without retries enabled
  @Test
  public void testGetResourceUsageAccountWRetries() throws Throwable {
    usageReportsService.enableRetries(4, 30);
    testGetResourceUsageAccountWOptions();

    usageReportsService.disableRetries();
    testGetResourceUsageAccountWOptions();
  }

  // Test the getResourceUsageAccount operation with a null options model (negative test)
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testGetResourceUsageAccountNoOptions() throws Throwable {
    server.enqueue(new MockResponse());
    usageReportsService.getResourceUsageAccount(null).execute();
  }

  // Test the getResourceUsageAccount operation using the GetResourceUsageAccountPager.getNext() method
  @Test
  public void testGetResourceUsageAccountWithPagerGetNext() throws Throwable {
    // Set up the two-page mock response.
    String mockResponsePage1 = "{\"next\":{\"href\":\"https://myhost.com/somePath?_start=1\"},\"total_count\":2,\"limit\":1,\"resources\":[{\"account_id\":\"accountId\",\"resource_instance_id\":\"resourceInstanceId\",\"resource_instance_name\":\"resourceInstanceName\",\"resource_id\":\"resourceId\",\"resource_name\":\"resourceName\",\"resource_group_id\":\"resourceGroupId\",\"resource_group_name\":\"resourceGroupName\",\"organization_id\":\"organizationId\",\"organization_name\":\"organizationName\",\"space_id\":\"spaceId\",\"space_name\":\"spaceName\",\"consumer_id\":\"consumerId\",\"region\":\"region\",\"pricing_region\":\"pricingRegion\",\"pricing_country\":\"USA\",\"currency_code\":\"USD\",\"billable\":true,\"plan_id\":\"planId\",\"plan_name\":\"planName\",\"month\":\"2017-08\",\"usage\":[{\"metric\":\"UP-TIME\",\"metric_name\":\"UP-TIME\",\"quantity\":711.11,\"rateable_quantity\":700,\"cost\":123.45,\"rated_cost\":130.0,\"price\":[\"anyValue\"],\"unit\":\"HOURS\",\"unit_name\":\"HOURS\",\"non_chargeable\":true,\"discounts\":[{\"ref\":\"Discount-d27beddb-111b-4bbf-8cb1-b770f531c1a9\",\"name\":\"platform-discount\",\"display_name\":\"Platform Service Discount\",\"discount\":5}]}],\"pending\":true,\"currency_rate\":10.8716}]}";
    String mockResponsePage2 = "{\"total_count\":2,\"limit\":1,\"resources\":[{\"account_id\":\"accountId\",\"resource_instance_id\":\"resourceInstanceId\",\"resource_instance_name\":\"resourceInstanceName\",\"resource_id\":\"resourceId\",\"resource_name\":\"resourceName\",\"resource_group_id\":\"resourceGroupId\",\"resource_group_name\":\"resourceGroupName\",\"organization_id\":\"organizationId\",\"organization_name\":\"organizationName\",\"space_id\":\"spaceId\",\"space_name\":\"spaceName\",\"consumer_id\":\"consumerId\",\"region\":\"region\",\"pricing_region\":\"pricingRegion\",\"pricing_country\":\"USA\",\"currency_code\":\"USD\",\"billable\":true,\"plan_id\":\"planId\",\"plan_name\":\"planName\",\"month\":\"2017-08\",\"usage\":[{\"metric\":\"UP-TIME\",\"metric_name\":\"UP-TIME\",\"quantity\":711.11,\"rateable_quantity\":700,\"cost\":123.45,\"rated_cost\":130.0,\"price\":[\"anyValue\"],\"unit\":\"HOURS\",\"unit_name\":\"HOURS\",\"non_chargeable\":true,\"discounts\":[{\"ref\":\"Discount-d27beddb-111b-4bbf-8cb1-b770f531c1a9\",\"name\":\"platform-discount\",\"display_name\":\"Platform Service Discount\",\"discount\":5}]}],\"pending\":true,\"currency_rate\":10.8716}]}";
    server.enqueue(new MockResponse()
      .setHeader("Content-type", "application/json")
      .setResponseCode(200)
      .setBody(mockResponsePage1));
    server.enqueue(new MockResponse()
      .setHeader("Content-type", "application/json")
      .setResponseCode(200)
      .setBody(mockResponsePage2));
    server.enqueue(new MockResponse()
      .setHeader("Content-type", "application/json")
      .setResponseCode(400)
      .setBody("{\"message\": \"No more results available!\"}"));

    GetResourceUsageAccountOptions getResourceUsageAccountOptions = new GetResourceUsageAccountOptions.Builder()
      .accountId("testString")
      .billingmonth("testString")
      .names(true)
      .acceptLanguage("testString")
      .limit(Long.valueOf("1"))
      .resourceGroupId("testString")
      .organizationId("testString")
      .resourceInstanceId("testString")
      .resourceId("testString")
      .planId("testString")
      .region("testString")
      .build();

    List<InstanceUsage> allResults = new ArrayList<>();
    GetResourceUsageAccountPager pager = new GetResourceUsageAccountPager(usageReportsService, getResourceUsageAccountOptions);
    while (pager.hasNext()) {
      List<InstanceUsage> nextPage = pager.getNext();
      assertNotNull(nextPage);
      allResults.addAll(nextPage);
    }
    assertEquals(allResults.size(), 2);
  }
  
  // Test the getResourceUsageAccount operation using the GetResourceUsageAccountPager.getAll() method
  @Test
  public void testGetResourceUsageAccountWithPagerGetAll() throws Throwable {
    // Set up the two-page mock response.
    String mockResponsePage1 = "{\"next\":{\"href\":\"https://myhost.com/somePath?_start=1\"},\"total_count\":2,\"limit\":1,\"resources\":[{\"account_id\":\"accountId\",\"resource_instance_id\":\"resourceInstanceId\",\"resource_instance_name\":\"resourceInstanceName\",\"resource_id\":\"resourceId\",\"resource_name\":\"resourceName\",\"resource_group_id\":\"resourceGroupId\",\"resource_group_name\":\"resourceGroupName\",\"organization_id\":\"organizationId\",\"organization_name\":\"organizationName\",\"space_id\":\"spaceId\",\"space_name\":\"spaceName\",\"consumer_id\":\"consumerId\",\"region\":\"region\",\"pricing_region\":\"pricingRegion\",\"pricing_country\":\"USA\",\"currency_code\":\"USD\",\"billable\":true,\"plan_id\":\"planId\",\"plan_name\":\"planName\",\"month\":\"2017-08\",\"usage\":[{\"metric\":\"UP-TIME\",\"metric_name\":\"UP-TIME\",\"quantity\":711.11,\"rateable_quantity\":700,\"cost\":123.45,\"rated_cost\":130.0,\"price\":[\"anyValue\"],\"unit\":\"HOURS\",\"unit_name\":\"HOURS\",\"non_chargeable\":true,\"discounts\":[{\"ref\":\"Discount-d27beddb-111b-4bbf-8cb1-b770f531c1a9\",\"name\":\"platform-discount\",\"display_name\":\"Platform Service Discount\",\"discount\":5}]}],\"pending\":true,\"currency_rate\":10.8716}]}";
    String mockResponsePage2 = "{\"total_count\":2,\"limit\":1,\"resources\":[{\"account_id\":\"accountId\",\"resource_instance_id\":\"resourceInstanceId\",\"resource_instance_name\":\"resourceInstanceName\",\"resource_id\":\"resourceId\",\"resource_name\":\"resourceName\",\"resource_group_id\":\"resourceGroupId\",\"resource_group_name\":\"resourceGroupName\",\"organization_id\":\"organizationId\",\"organization_name\":\"organizationName\",\"space_id\":\"spaceId\",\"space_name\":\"spaceName\",\"consumer_id\":\"consumerId\",\"region\":\"region\",\"pricing_region\":\"pricingRegion\",\"pricing_country\":\"USA\",\"currency_code\":\"USD\",\"billable\":true,\"plan_id\":\"planId\",\"plan_name\":\"planName\",\"month\":\"2017-08\",\"usage\":[{\"metric\":\"UP-TIME\",\"metric_name\":\"UP-TIME\",\"quantity\":711.11,\"rateable_quantity\":700,\"cost\":123.45,\"rated_cost\":130.0,\"price\":[\"anyValue\"],\"unit\":\"HOURS\",\"unit_name\":\"HOURS\",\"non_chargeable\":true,\"discounts\":[{\"ref\":\"Discount-d27beddb-111b-4bbf-8cb1-b770f531c1a9\",\"name\":\"platform-discount\",\"display_name\":\"Platform Service Discount\",\"discount\":5}]}],\"pending\":true,\"currency_rate\":10.8716}]}";
    server.enqueue(new MockResponse()
      .setHeader("Content-type", "application/json")
      .setResponseCode(200)
      .setBody(mockResponsePage1));
    server.enqueue(new MockResponse()
      .setHeader("Content-type", "application/json")
      .setResponseCode(200)
      .setBody(mockResponsePage2));
    server.enqueue(new MockResponse()
      .setHeader("Content-type", "application/json")
      .setResponseCode(400)
      .setBody("{\"message\": \"No more results available!\"}"));

    GetResourceUsageAccountOptions getResourceUsageAccountOptions = new GetResourceUsageAccountOptions.Builder()
      .accountId("testString")
      .billingmonth("testString")
      .names(true)
      .acceptLanguage("testString")
      .limit(Long.valueOf("1"))
      .resourceGroupId("testString")
      .organizationId("testString")
      .resourceInstanceId("testString")
      .resourceId("testString")
      .planId("testString")
      .region("testString")
      .build();

    GetResourceUsageAccountPager pager = new GetResourceUsageAccountPager(usageReportsService, getResourceUsageAccountOptions);
    List<InstanceUsage> allResults = pager.getAll();
    assertNotNull(allResults);
    assertEquals(allResults.size(), 2);
  }
  
  // Test the getResourceUsageResourceGroup operation with a valid options model parameter
  @Test
  public void testGetResourceUsageResourceGroupWOptions() throws Throwable {
    // Register a mock response
    String mockResponseBody = "{\"limit\": 5, \"count\": 5, \"first\": {\"href\": \"href\"}, \"next\": {\"href\": \"href\", \"offset\": \"offset\"}, \"resources\": [{\"account_id\": \"accountId\", \"resource_instance_id\": \"resourceInstanceId\", \"resource_instance_name\": \"resourceInstanceName\", \"resource_id\": \"resourceId\", \"resource_name\": \"resourceName\", \"resource_group_id\": \"resourceGroupId\", \"resource_group_name\": \"resourceGroupName\", \"organization_id\": \"organizationId\", \"organization_name\": \"organizationName\", \"space_id\": \"spaceId\", \"space_name\": \"spaceName\", \"consumer_id\": \"consumerId\", \"region\": \"region\", \"pricing_region\": \"pricingRegion\", \"pricing_country\": \"USA\", \"currency_code\": \"USD\", \"billable\": true, \"plan_id\": \"planId\", \"plan_name\": \"planName\", \"month\": \"2017-08\", \"usage\": [{\"metric\": \"UP-TIME\", \"metric_name\": \"UP-TIME\", \"quantity\": 711.11, \"rateable_quantity\": 700, \"cost\": 123.45, \"rated_cost\": 130.0, \"price\": [\"anyValue\"], \"unit\": \"HOURS\", \"unit_name\": \"HOURS\", \"non_chargeable\": true, \"discounts\": [{\"ref\": \"Discount-d27beddb-111b-4bbf-8cb1-b770f531c1a9\", \"name\": \"platform-discount\", \"display_name\": \"Platform Service Discount\", \"discount\": 5}]}], \"pending\": true, \"currency_rate\": 10.8716}]}";
    String getResourceUsageResourceGroupPath = "/v4/accounts/testString/resource_groups/testString/resource_instances/usage/testString";
    server.enqueue(new MockResponse()
      .setHeader("Content-type", "application/json")
      .setResponseCode(200)
      .setBody(mockResponseBody));

    // Construct an instance of the GetResourceUsageResourceGroupOptions model
    GetResourceUsageResourceGroupOptions getResourceUsageResourceGroupOptionsModel = new GetResourceUsageResourceGroupOptions.Builder()
      .accountId("testString")
      .resourceGroupId("testString")
      .billingmonth("testString")
      .names(true)
      .acceptLanguage("testString")
      .limit(Long.valueOf("1"))
      .start("testString")
      .resourceInstanceId("testString")
      .resourceId("testString")
      .planId("testString")
      .region("testString")
      .build();

    // Invoke getResourceUsageResourceGroup() with a valid options model and verify the result
    Response<InstancesUsage> response = usageReportsService.getResourceUsageResourceGroup(getResourceUsageResourceGroupOptionsModel).execute();
    assertNotNull(response);
    InstancesUsage responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request sent to the mock server
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "GET");
    // Verify request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, getResourceUsageResourceGroupPath);
    // Verify query params
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNotNull(query);
    assertEquals(Boolean.valueOf(query.get("_names")), Boolean.valueOf(true));
    assertEquals(Long.valueOf(query.get("_limit")), Long.valueOf("1"));
    assertEquals(query.get("_start"), "testString");
    assertEquals(query.get("resource_instance_id"), "testString");
    assertEquals(query.get("resource_id"), "testString");
    assertEquals(query.get("plan_id"), "testString");
    assertEquals(query.get("region"), "testString");
  }

  // Test the getResourceUsageResourceGroup operation with and without retries enabled
  @Test
  public void testGetResourceUsageResourceGroupWRetries() throws Throwable {
    usageReportsService.enableRetries(4, 30);
    testGetResourceUsageResourceGroupWOptions();

    usageReportsService.disableRetries();
    testGetResourceUsageResourceGroupWOptions();
  }

  // Test the getResourceUsageResourceGroup operation with a null options model (negative test)
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testGetResourceUsageResourceGroupNoOptions() throws Throwable {
    server.enqueue(new MockResponse());
    usageReportsService.getResourceUsageResourceGroup(null).execute();
  }

  // Test the getResourceUsageResourceGroup operation using the GetResourceUsageResourceGroupPager.getNext() method
  @Test
  public void testGetResourceUsageResourceGroupWithPagerGetNext() throws Throwable {
    // Set up the two-page mock response.
    String mockResponsePage1 = "{\"next\":{\"href\":\"https://myhost.com/somePath?_start=1\"},\"total_count\":2,\"limit\":1,\"resources\":[{\"account_id\":\"accountId\",\"resource_instance_id\":\"resourceInstanceId\",\"resource_instance_name\":\"resourceInstanceName\",\"resource_id\":\"resourceId\",\"resource_name\":\"resourceName\",\"resource_group_id\":\"resourceGroupId\",\"resource_group_name\":\"resourceGroupName\",\"organization_id\":\"organizationId\",\"organization_name\":\"organizationName\",\"space_id\":\"spaceId\",\"space_name\":\"spaceName\",\"consumer_id\":\"consumerId\",\"region\":\"region\",\"pricing_region\":\"pricingRegion\",\"pricing_country\":\"USA\",\"currency_code\":\"USD\",\"billable\":true,\"plan_id\":\"planId\",\"plan_name\":\"planName\",\"month\":\"2017-08\",\"usage\":[{\"metric\":\"UP-TIME\",\"metric_name\":\"UP-TIME\",\"quantity\":711.11,\"rateable_quantity\":700,\"cost\":123.45,\"rated_cost\":130.0,\"price\":[\"anyValue\"],\"unit\":\"HOURS\",\"unit_name\":\"HOURS\",\"non_chargeable\":true,\"discounts\":[{\"ref\":\"Discount-d27beddb-111b-4bbf-8cb1-b770f531c1a9\",\"name\":\"platform-discount\",\"display_name\":\"Platform Service Discount\",\"discount\":5}]}],\"pending\":true,\"currency_rate\":10.8716}]}";
    String mockResponsePage2 = "{\"total_count\":2,\"limit\":1,\"resources\":[{\"account_id\":\"accountId\",\"resource_instance_id\":\"resourceInstanceId\",\"resource_instance_name\":\"resourceInstanceName\",\"resource_id\":\"resourceId\",\"resource_name\":\"resourceName\",\"resource_group_id\":\"resourceGroupId\",\"resource_group_name\":\"resourceGroupName\",\"organization_id\":\"organizationId\",\"organization_name\":\"organizationName\",\"space_id\":\"spaceId\",\"space_name\":\"spaceName\",\"consumer_id\":\"consumerId\",\"region\":\"region\",\"pricing_region\":\"pricingRegion\",\"pricing_country\":\"USA\",\"currency_code\":\"USD\",\"billable\":true,\"plan_id\":\"planId\",\"plan_name\":\"planName\",\"month\":\"2017-08\",\"usage\":[{\"metric\":\"UP-TIME\",\"metric_name\":\"UP-TIME\",\"quantity\":711.11,\"rateable_quantity\":700,\"cost\":123.45,\"rated_cost\":130.0,\"price\":[\"anyValue\"],\"unit\":\"HOURS\",\"unit_name\":\"HOURS\",\"non_chargeable\":true,\"discounts\":[{\"ref\":\"Discount-d27beddb-111b-4bbf-8cb1-b770f531c1a9\",\"name\":\"platform-discount\",\"display_name\":\"Platform Service Discount\",\"discount\":5}]}],\"pending\":true,\"currency_rate\":10.8716}]}";
    server.enqueue(new MockResponse()
      .setHeader("Content-type", "application/json")
      .setResponseCode(200)
      .setBody(mockResponsePage1));
    server.enqueue(new MockResponse()
      .setHeader("Content-type", "application/json")
      .setResponseCode(200)
      .setBody(mockResponsePage2));
    server.enqueue(new MockResponse()
      .setHeader("Content-type", "application/json")
      .setResponseCode(400)
      .setBody("{\"message\": \"No more results available!\"}"));

    GetResourceUsageResourceGroupOptions getResourceUsageResourceGroupOptions = new GetResourceUsageResourceGroupOptions.Builder()
      .accountId("testString")
      .resourceGroupId("testString")
      .billingmonth("testString")
      .names(true)
      .acceptLanguage("testString")
      .limit(Long.valueOf("1"))
      .resourceInstanceId("testString")
      .resourceId("testString")
      .planId("testString")
      .region("testString")
      .build();

    List<InstanceUsage> allResults = new ArrayList<>();
    GetResourceUsageResourceGroupPager pager = new GetResourceUsageResourceGroupPager(usageReportsService, getResourceUsageResourceGroupOptions);
    while (pager.hasNext()) {
      List<InstanceUsage> nextPage = pager.getNext();
      assertNotNull(nextPage);
      allResults.addAll(nextPage);
    }
    assertEquals(allResults.size(), 2);
  }
  
  // Test the getResourceUsageResourceGroup operation using the GetResourceUsageResourceGroupPager.getAll() method
  @Test
  public void testGetResourceUsageResourceGroupWithPagerGetAll() throws Throwable {
    // Set up the two-page mock response.
    String mockResponsePage1 = "{\"next\":{\"href\":\"https://myhost.com/somePath?_start=1\"},\"total_count\":2,\"limit\":1,\"resources\":[{\"account_id\":\"accountId\",\"resource_instance_id\":\"resourceInstanceId\",\"resource_instance_name\":\"resourceInstanceName\",\"resource_id\":\"resourceId\",\"resource_name\":\"resourceName\",\"resource_group_id\":\"resourceGroupId\",\"resource_group_name\":\"resourceGroupName\",\"organization_id\":\"organizationId\",\"organization_name\":\"organizationName\",\"space_id\":\"spaceId\",\"space_name\":\"spaceName\",\"consumer_id\":\"consumerId\",\"region\":\"region\",\"pricing_region\":\"pricingRegion\",\"pricing_country\":\"USA\",\"currency_code\":\"USD\",\"billable\":true,\"plan_id\":\"planId\",\"plan_name\":\"planName\",\"month\":\"2017-08\",\"usage\":[{\"metric\":\"UP-TIME\",\"metric_name\":\"UP-TIME\",\"quantity\":711.11,\"rateable_quantity\":700,\"cost\":123.45,\"rated_cost\":130.0,\"price\":[\"anyValue\"],\"unit\":\"HOURS\",\"unit_name\":\"HOURS\",\"non_chargeable\":true,\"discounts\":[{\"ref\":\"Discount-d27beddb-111b-4bbf-8cb1-b770f531c1a9\",\"name\":\"platform-discount\",\"display_name\":\"Platform Service Discount\",\"discount\":5}]}],\"pending\":true,\"currency_rate\":10.8716}]}";
    String mockResponsePage2 = "{\"total_count\":2,\"limit\":1,\"resources\":[{\"account_id\":\"accountId\",\"resource_instance_id\":\"resourceInstanceId\",\"resource_instance_name\":\"resourceInstanceName\",\"resource_id\":\"resourceId\",\"resource_name\":\"resourceName\",\"resource_group_id\":\"resourceGroupId\",\"resource_group_name\":\"resourceGroupName\",\"organization_id\":\"organizationId\",\"organization_name\":\"organizationName\",\"space_id\":\"spaceId\",\"space_name\":\"spaceName\",\"consumer_id\":\"consumerId\",\"region\":\"region\",\"pricing_region\":\"pricingRegion\",\"pricing_country\":\"USA\",\"currency_code\":\"USD\",\"billable\":true,\"plan_id\":\"planId\",\"plan_name\":\"planName\",\"month\":\"2017-08\",\"usage\":[{\"metric\":\"UP-TIME\",\"metric_name\":\"UP-TIME\",\"quantity\":711.11,\"rateable_quantity\":700,\"cost\":123.45,\"rated_cost\":130.0,\"price\":[\"anyValue\"],\"unit\":\"HOURS\",\"unit_name\":\"HOURS\",\"non_chargeable\":true,\"discounts\":[{\"ref\":\"Discount-d27beddb-111b-4bbf-8cb1-b770f531c1a9\",\"name\":\"platform-discount\",\"display_name\":\"Platform Service Discount\",\"discount\":5}]}],\"pending\":true,\"currency_rate\":10.8716}]}";
    server.enqueue(new MockResponse()
      .setHeader("Content-type", "application/json")
      .setResponseCode(200)
      .setBody(mockResponsePage1));
    server.enqueue(new MockResponse()
      .setHeader("Content-type", "application/json")
      .setResponseCode(200)
      .setBody(mockResponsePage2));
    server.enqueue(new MockResponse()
      .setHeader("Content-type", "application/json")
      .setResponseCode(400)
      .setBody("{\"message\": \"No more results available!\"}"));

    GetResourceUsageResourceGroupOptions getResourceUsageResourceGroupOptions = new GetResourceUsageResourceGroupOptions.Builder()
      .accountId("testString")
      .resourceGroupId("testString")
      .billingmonth("testString")
      .names(true)
      .acceptLanguage("testString")
      .limit(Long.valueOf("1"))
      .resourceInstanceId("testString")
      .resourceId("testString")
      .planId("testString")
      .region("testString")
      .build();

    GetResourceUsageResourceGroupPager pager = new GetResourceUsageResourceGroupPager(usageReportsService, getResourceUsageResourceGroupOptions);
    List<InstanceUsage> allResults = pager.getAll();
    assertNotNull(allResults);
    assertEquals(allResults.size(), 2);
  }
  
  // Test the getResourceUsageOrg operation with a valid options model parameter
  @Test
  public void testGetResourceUsageOrgWOptions() throws Throwable {
    // Register a mock response
    String mockResponseBody = "{\"limit\": 5, \"count\": 5, \"first\": {\"href\": \"href\"}, \"next\": {\"href\": \"href\", \"offset\": \"offset\"}, \"resources\": [{\"account_id\": \"accountId\", \"resource_instance_id\": \"resourceInstanceId\", \"resource_instance_name\": \"resourceInstanceName\", \"resource_id\": \"resourceId\", \"resource_name\": \"resourceName\", \"resource_group_id\": \"resourceGroupId\", \"resource_group_name\": \"resourceGroupName\", \"organization_id\": \"organizationId\", \"organization_name\": \"organizationName\", \"space_id\": \"spaceId\", \"space_name\": \"spaceName\", \"consumer_id\": \"consumerId\", \"region\": \"region\", \"pricing_region\": \"pricingRegion\", \"pricing_country\": \"USA\", \"currency_code\": \"USD\", \"billable\": true, \"plan_id\": \"planId\", \"plan_name\": \"planName\", \"month\": \"2017-08\", \"usage\": [{\"metric\": \"UP-TIME\", \"metric_name\": \"UP-TIME\", \"quantity\": 711.11, \"rateable_quantity\": 700, \"cost\": 123.45, \"rated_cost\": 130.0, \"price\": [\"anyValue\"], \"unit\": \"HOURS\", \"unit_name\": \"HOURS\", \"non_chargeable\": true, \"discounts\": [{\"ref\": \"Discount-d27beddb-111b-4bbf-8cb1-b770f531c1a9\", \"name\": \"platform-discount\", \"display_name\": \"Platform Service Discount\", \"discount\": 5}]}], \"pending\": true, \"currency_rate\": 10.8716}]}";
    String getResourceUsageOrgPath = "/v4/accounts/testString/organizations/testString/resource_instances/usage/testString";
    server.enqueue(new MockResponse()
      .setHeader("Content-type", "application/json")
      .setResponseCode(200)
      .setBody(mockResponseBody));

    // Construct an instance of the GetResourceUsageOrgOptions model
    GetResourceUsageOrgOptions getResourceUsageOrgOptionsModel = new GetResourceUsageOrgOptions.Builder()
      .accountId("testString")
      .organizationId("testString")
      .billingmonth("testString")
      .names(true)
      .acceptLanguage("testString")
      .limit(Long.valueOf("1"))
      .start("testString")
      .resourceInstanceId("testString")
      .resourceId("testString")
      .planId("testString")
      .region("testString")
      .build();

    // Invoke getResourceUsageOrg() with a valid options model and verify the result
    Response<InstancesUsage> response = usageReportsService.getResourceUsageOrg(getResourceUsageOrgOptionsModel).execute();
    assertNotNull(response);
    InstancesUsage responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request sent to the mock server
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "GET");
    // Verify request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, getResourceUsageOrgPath);
    // Verify query params
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNotNull(query);
    assertEquals(Boolean.valueOf(query.get("_names")), Boolean.valueOf(true));
    assertEquals(Long.valueOf(query.get("_limit")), Long.valueOf("1"));
    assertEquals(query.get("_start"), "testString");
    assertEquals(query.get("resource_instance_id"), "testString");
    assertEquals(query.get("resource_id"), "testString");
    assertEquals(query.get("plan_id"), "testString");
    assertEquals(query.get("region"), "testString");
  }

  // Test the getResourceUsageOrg operation with and without retries enabled
  @Test
  public void testGetResourceUsageOrgWRetries() throws Throwable {
    usageReportsService.enableRetries(4, 30);
    testGetResourceUsageOrgWOptions();

    usageReportsService.disableRetries();
    testGetResourceUsageOrgWOptions();
  }

  // Test the getResourceUsageOrg operation with a null options model (negative test)
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testGetResourceUsageOrgNoOptions() throws Throwable {
    server.enqueue(new MockResponse());
    usageReportsService.getResourceUsageOrg(null).execute();
  }

  // Test the getResourceUsageOrg operation using the GetResourceUsageOrgPager.getNext() method
  @Test
  public void testGetResourceUsageOrgWithPagerGetNext() throws Throwable {
    // Set up the two-page mock response.
    String mockResponsePage1 = "{\"next\":{\"href\":\"https://myhost.com/somePath?_start=1\"},\"total_count\":2,\"limit\":1,\"resources\":[{\"account_id\":\"accountId\",\"resource_instance_id\":\"resourceInstanceId\",\"resource_instance_name\":\"resourceInstanceName\",\"resource_id\":\"resourceId\",\"resource_name\":\"resourceName\",\"resource_group_id\":\"resourceGroupId\",\"resource_group_name\":\"resourceGroupName\",\"organization_id\":\"organizationId\",\"organization_name\":\"organizationName\",\"space_id\":\"spaceId\",\"space_name\":\"spaceName\",\"consumer_id\":\"consumerId\",\"region\":\"region\",\"pricing_region\":\"pricingRegion\",\"pricing_country\":\"USA\",\"currency_code\":\"USD\",\"billable\":true,\"plan_id\":\"planId\",\"plan_name\":\"planName\",\"month\":\"2017-08\",\"usage\":[{\"metric\":\"UP-TIME\",\"metric_name\":\"UP-TIME\",\"quantity\":711.11,\"rateable_quantity\":700,\"cost\":123.45,\"rated_cost\":130.0,\"price\":[\"anyValue\"],\"unit\":\"HOURS\",\"unit_name\":\"HOURS\",\"non_chargeable\":true,\"discounts\":[{\"ref\":\"Discount-d27beddb-111b-4bbf-8cb1-b770f531c1a9\",\"name\":\"platform-discount\",\"display_name\":\"Platform Service Discount\",\"discount\":5}]}],\"pending\":true,\"currency_rate\":10.8716}]}";
    String mockResponsePage2 = "{\"total_count\":2,\"limit\":1,\"resources\":[{\"account_id\":\"accountId\",\"resource_instance_id\":\"resourceInstanceId\",\"resource_instance_name\":\"resourceInstanceName\",\"resource_id\":\"resourceId\",\"resource_name\":\"resourceName\",\"resource_group_id\":\"resourceGroupId\",\"resource_group_name\":\"resourceGroupName\",\"organization_id\":\"organizationId\",\"organization_name\":\"organizationName\",\"space_id\":\"spaceId\",\"space_name\":\"spaceName\",\"consumer_id\":\"consumerId\",\"region\":\"region\",\"pricing_region\":\"pricingRegion\",\"pricing_country\":\"USA\",\"currency_code\":\"USD\",\"billable\":true,\"plan_id\":\"planId\",\"plan_name\":\"planName\",\"month\":\"2017-08\",\"usage\":[{\"metric\":\"UP-TIME\",\"metric_name\":\"UP-TIME\",\"quantity\":711.11,\"rateable_quantity\":700,\"cost\":123.45,\"rated_cost\":130.0,\"price\":[\"anyValue\"],\"unit\":\"HOURS\",\"unit_name\":\"HOURS\",\"non_chargeable\":true,\"discounts\":[{\"ref\":\"Discount-d27beddb-111b-4bbf-8cb1-b770f531c1a9\",\"name\":\"platform-discount\",\"display_name\":\"Platform Service Discount\",\"discount\":5}]}],\"pending\":true,\"currency_rate\":10.8716}]}";
    server.enqueue(new MockResponse()
      .setHeader("Content-type", "application/json")
      .setResponseCode(200)
      .setBody(mockResponsePage1));
    server.enqueue(new MockResponse()
      .setHeader("Content-type", "application/json")
      .setResponseCode(200)
      .setBody(mockResponsePage2));
    server.enqueue(new MockResponse()
      .setHeader("Content-type", "application/json")
      .setResponseCode(400)
      .setBody("{\"message\": \"No more results available!\"}"));

    GetResourceUsageOrgOptions getResourceUsageOrgOptions = new GetResourceUsageOrgOptions.Builder()
      .accountId("testString")
      .organizationId("testString")
      .billingmonth("testString")
      .names(true)
      .acceptLanguage("testString")
      .limit(Long.valueOf("1"))
      .resourceInstanceId("testString")
      .resourceId("testString")
      .planId("testString")
      .region("testString")
      .build();

    List<InstanceUsage> allResults = new ArrayList<>();
    GetResourceUsageOrgPager pager = new GetResourceUsageOrgPager(usageReportsService, getResourceUsageOrgOptions);
    while (pager.hasNext()) {
      List<InstanceUsage> nextPage = pager.getNext();
      assertNotNull(nextPage);
      allResults.addAll(nextPage);
    }
    assertEquals(allResults.size(), 2);
  }
  
  // Test the getResourceUsageOrg operation using the GetResourceUsageOrgPager.getAll() method
  @Test
  public void testGetResourceUsageOrgWithPagerGetAll() throws Throwable {
    // Set up the two-page mock response.
    String mockResponsePage1 = "{\"next\":{\"href\":\"https://myhost.com/somePath?_start=1\"},\"total_count\":2,\"limit\":1,\"resources\":[{\"account_id\":\"accountId\",\"resource_instance_id\":\"resourceInstanceId\",\"resource_instance_name\":\"resourceInstanceName\",\"resource_id\":\"resourceId\",\"resource_name\":\"resourceName\",\"resource_group_id\":\"resourceGroupId\",\"resource_group_name\":\"resourceGroupName\",\"organization_id\":\"organizationId\",\"organization_name\":\"organizationName\",\"space_id\":\"spaceId\",\"space_name\":\"spaceName\",\"consumer_id\":\"consumerId\",\"region\":\"region\",\"pricing_region\":\"pricingRegion\",\"pricing_country\":\"USA\",\"currency_code\":\"USD\",\"billable\":true,\"plan_id\":\"planId\",\"plan_name\":\"planName\",\"month\":\"2017-08\",\"usage\":[{\"metric\":\"UP-TIME\",\"metric_name\":\"UP-TIME\",\"quantity\":711.11,\"rateable_quantity\":700,\"cost\":123.45,\"rated_cost\":130.0,\"price\":[\"anyValue\"],\"unit\":\"HOURS\",\"unit_name\":\"HOURS\",\"non_chargeable\":true,\"discounts\":[{\"ref\":\"Discount-d27beddb-111b-4bbf-8cb1-b770f531c1a9\",\"name\":\"platform-discount\",\"display_name\":\"Platform Service Discount\",\"discount\":5}]}],\"pending\":true,\"currency_rate\":10.8716}]}";
    String mockResponsePage2 = "{\"total_count\":2,\"limit\":1,\"resources\":[{\"account_id\":\"accountId\",\"resource_instance_id\":\"resourceInstanceId\",\"resource_instance_name\":\"resourceInstanceName\",\"resource_id\":\"resourceId\",\"resource_name\":\"resourceName\",\"resource_group_id\":\"resourceGroupId\",\"resource_group_name\":\"resourceGroupName\",\"organization_id\":\"organizationId\",\"organization_name\":\"organizationName\",\"space_id\":\"spaceId\",\"space_name\":\"spaceName\",\"consumer_id\":\"consumerId\",\"region\":\"region\",\"pricing_region\":\"pricingRegion\",\"pricing_country\":\"USA\",\"currency_code\":\"USD\",\"billable\":true,\"plan_id\":\"planId\",\"plan_name\":\"planName\",\"month\":\"2017-08\",\"usage\":[{\"metric\":\"UP-TIME\",\"metric_name\":\"UP-TIME\",\"quantity\":711.11,\"rateable_quantity\":700,\"cost\":123.45,\"rated_cost\":130.0,\"price\":[\"anyValue\"],\"unit\":\"HOURS\",\"unit_name\":\"HOURS\",\"non_chargeable\":true,\"discounts\":[{\"ref\":\"Discount-d27beddb-111b-4bbf-8cb1-b770f531c1a9\",\"name\":\"platform-discount\",\"display_name\":\"Platform Service Discount\",\"discount\":5}]}],\"pending\":true,\"currency_rate\":10.8716}]}";
    server.enqueue(new MockResponse()
      .setHeader("Content-type", "application/json")
      .setResponseCode(200)
      .setBody(mockResponsePage1));
    server.enqueue(new MockResponse()
      .setHeader("Content-type", "application/json")
      .setResponseCode(200)
      .setBody(mockResponsePage2));
    server.enqueue(new MockResponse()
      .setHeader("Content-type", "application/json")
      .setResponseCode(400)
      .setBody("{\"message\": \"No more results available!\"}"));

    GetResourceUsageOrgOptions getResourceUsageOrgOptions = new GetResourceUsageOrgOptions.Builder()
      .accountId("testString")
      .organizationId("testString")
      .billingmonth("testString")
      .names(true)
      .acceptLanguage("testString")
      .limit(Long.valueOf("1"))
      .resourceInstanceId("testString")
      .resourceId("testString")
      .planId("testString")
      .region("testString")
      .build();

    GetResourceUsageOrgPager pager = new GetResourceUsageOrgPager(usageReportsService, getResourceUsageOrgOptions);
    List<InstanceUsage> allResults = pager.getAll();
    assertNotNull(allResults);
    assertEquals(allResults.size(), 2);
  }
  
  // Test the getOrgUsage operation with a valid options model parameter
  @Test
  public void testGetOrgUsageWOptions() throws Throwable {
    // Register a mock response
    String mockResponseBody = "{\"account_id\": \"accountId\", \"organization_id\": \"organizationId\", \"organization_name\": \"organizationName\", \"pricing_country\": \"USA\", \"currency_code\": \"USD\", \"month\": \"2017-08\", \"resources\": [{\"resource_id\": \"resourceId\", \"resource_name\": \"resourceName\", \"billable_cost\": 12, \"billable_rated_cost\": 17, \"non_billable_cost\": 15, \"non_billable_rated_cost\": 20, \"plans\": [{\"plan_id\": \"planId\", \"plan_name\": \"planName\", \"pricing_region\": \"pricingRegion\", \"billable\": true, \"cost\": 4, \"rated_cost\": 9, \"usage\": [{\"metric\": \"UP-TIME\", \"metric_name\": \"UP-TIME\", \"quantity\": 711.11, \"rateable_quantity\": 700, \"cost\": 123.45, \"rated_cost\": 130.0, \"price\": [\"anyValue\"], \"unit\": \"HOURS\", \"unit_name\": \"HOURS\", \"non_chargeable\": true, \"discounts\": [{\"ref\": \"Discount-d27beddb-111b-4bbf-8cb1-b770f531c1a9\", \"name\": \"platform-discount\", \"display_name\": \"Platform Service Discount\", \"discount\": 5}]}], \"discounts\": [{\"ref\": \"Discount-d27beddb-111b-4bbf-8cb1-b770f531c1a9\", \"name\": \"platform-discount\", \"display_name\": \"Platform Service Discount\", \"discount\": 5}], \"pending\": true}], \"discounts\": [{\"ref\": \"Discount-d27beddb-111b-4bbf-8cb1-b770f531c1a9\", \"name\": \"platform-discount\", \"display_name\": \"Platform Service Discount\", \"discount\": 5}]}], \"currency_rate\": 10.8716}";
    String getOrgUsagePath = "/v4/accounts/testString/organizations/testString/usage/testString";
    server.enqueue(new MockResponse()
      .setHeader("Content-type", "application/json")
      .setResponseCode(200)
      .setBody(mockResponseBody));

    // Construct an instance of the GetOrgUsageOptions model
    GetOrgUsageOptions getOrgUsageOptionsModel = new GetOrgUsageOptions.Builder()
      .accountId("testString")
      .organizationId("testString")
      .billingmonth("testString")
      .names(true)
      .acceptLanguage("testString")
      .build();

    // Invoke getOrgUsage() with a valid options model and verify the result
    Response<OrgUsage> response = usageReportsService.getOrgUsage(getOrgUsageOptionsModel).execute();
    assertNotNull(response);
    OrgUsage responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request sent to the mock server
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "GET");
    // Verify request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, getOrgUsagePath);
    // Verify query params
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNotNull(query);
    assertEquals(Boolean.valueOf(query.get("_names")), Boolean.valueOf(true));
  }

  // Test the getOrgUsage operation with and without retries enabled
  @Test
  public void testGetOrgUsageWRetries() throws Throwable {
    usageReportsService.enableRetries(4, 30);
    testGetOrgUsageWOptions();

    usageReportsService.disableRetries();
    testGetOrgUsageWOptions();
  }

  // Test the getOrgUsage operation with a null options model (negative test)
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testGetOrgUsageNoOptions() throws Throwable {
    server.enqueue(new MockResponse());
    usageReportsService.getOrgUsage(null).execute();
  }

  // Perform setup needed before each test method
  @BeforeMethod
  public void beforeEachTest() {
    // Start the mock server.
    try {
      server = new MockWebServer();
      server.start();
    } catch (IOException err) {
      fail("Failed to instantiate mock web server");
    }

    // Construct an instance of the service
    constructClientService();
  }

  // Perform tear down after each test method
  @AfterMethod
  public void afterEachTest() throws IOException {
    server.shutdown();
    usageReportsService = null;
  }

  // Constructs an instance of the service to be used by the tests
  public void constructClientService() {
    System.setProperty("TESTSERVICE_AUTH_TYPE", "noAuth");
    final String serviceName = "testService";

    usageReportsService = UsageReports.newInstance(serviceName);
    String url = server.url("/").toString();
    usageReportsService.setServiceUrl(url);
  }
}
