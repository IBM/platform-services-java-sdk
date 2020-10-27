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
package com.ibm.cloud.platform_services.usage_reports.v4;

import com.ibm.cloud.platform_services.usage_reports.v4.UsageReports;
import com.ibm.cloud.platform_services.usage_reports.v4.model.AccountSummary;
import com.ibm.cloud.platform_services.usage_reports.v4.model.AccountUsage;
import com.ibm.cloud.platform_services.usage_reports.v4.model.Discount;
import com.ibm.cloud.platform_services.usage_reports.v4.model.GetAccountSummaryOptions;
import com.ibm.cloud.platform_services.usage_reports.v4.model.GetAccountUsageOptions;
import com.ibm.cloud.platform_services.usage_reports.v4.model.GetOrgUsageOptions;
import com.ibm.cloud.platform_services.usage_reports.v4.model.GetResourceGroupUsageOptions;
import com.ibm.cloud.platform_services.usage_reports.v4.model.GetResourceUsageAccountOptions;
import com.ibm.cloud.platform_services.usage_reports.v4.model.GetResourceUsageOrgOptions;
import com.ibm.cloud.platform_services.usage_reports.v4.model.GetResourceUsageResourceGroupOptions;
import com.ibm.cloud.platform_services.usage_reports.v4.model.InstanceUsage;
import com.ibm.cloud.platform_services.usage_reports.v4.model.InstancesUsage;
import com.ibm.cloud.platform_services.usage_reports.v4.model.InstancesUsageFirst;
import com.ibm.cloud.platform_services.usage_reports.v4.model.InstancesUsageNext;
import com.ibm.cloud.platform_services.usage_reports.v4.model.Metric;
import com.ibm.cloud.platform_services.usage_reports.v4.model.Offer;
import com.ibm.cloud.platform_services.usage_reports.v4.model.OfferCredits;
import com.ibm.cloud.platform_services.usage_reports.v4.model.OrgUsage;
import com.ibm.cloud.platform_services.usage_reports.v4.model.Plan;
import com.ibm.cloud.platform_services.usage_reports.v4.model.Resource;
import com.ibm.cloud.platform_services.usage_reports.v4.model.ResourceGroupUsage;
import com.ibm.cloud.platform_services.usage_reports.v4.model.ResourcesSummary;
import com.ibm.cloud.platform_services.usage_reports.v4.model.Subscription;
import com.ibm.cloud.platform_services.usage_reports.v4.model.SubscriptionSummary;
import com.ibm.cloud.platform_services.usage_reports.v4.model.SubscriptionTerm;
import com.ibm.cloud.platform_services.usage_reports.v4.model.SubscriptionTermCredits;
import com.ibm.cloud.platform_services.usage_reports.v4.model.SupportSummary;
import com.ibm.cloud.platform_services.usage_reports.v4.utils.TestUtilities;
import com.ibm.cloud.sdk.core.http.Response;
import com.ibm.cloud.sdk.core.security.Authenticator;
import com.ibm.cloud.sdk.core.security.NoAuthAuthenticator;
import com.ibm.cloud.sdk.core.service.model.FileWithMetadata;
import com.ibm.cloud.sdk.core.util.EnvironmentUtils;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import okhttp3.mockwebserver.MockResponse;
import okhttp3.mockwebserver.MockWebServer;
import okhttp3.mockwebserver.RecordedRequest;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PowerMockIgnore;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.testng.PowerMockTestCase;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import static org.testng.Assert.*;

/**
 * Unit test class for the UsageReports service.
 */
@PrepareForTest({ EnvironmentUtils.class })
@PowerMockIgnore({"javax.net.ssl.*", "org.mockito.*"})
public class UsageReportsTest extends PowerMockTestCase {

  final HashMap<String, InputStream> mockStreamMap = TestUtilities.createMockStreamMap();
  final List<FileWithMetadata> mockListFileWithMetadata = TestUtilities.creatMockListFileWithMetadata();

  protected MockWebServer server;
  protected UsageReports usageReportsService;

  // Creates a mock set of environment variables that are returned by EnvironmentUtils.getenv().
  private Map<String, String> getTestProcessEnvironment() {
    Map<String, String> env = new HashMap<>();
    env.put("TESTSERVICE_AUTH_TYPE", "noAuth");
    return env;
  }

  public void constructClientService() throws Throwable {
    PowerMockito.spy(EnvironmentUtils.class);
    PowerMockito.when(EnvironmentUtils.getenv()).thenReturn(getTestProcessEnvironment());
    final String serviceName = "testService";

    usageReportsService = UsageReports.newInstance(serviceName);
    String url = server.url("/").toString();
    usageReportsService.setServiceUrl(url);
  }

  /**
  * Negative Test - construct the service with a null authenticator.
  */
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testConstructorWithNullAuthenticator() throws Throwable {
    final String serviceName = "testService";

    new UsageReports(serviceName, null);
  }

  @Test
  public void testGetAccountSummaryWOptions() throws Throwable {
    // Schedule some responses.
    String mockResponseBody = "{\"account_id\": \"accountId\", \"billing_month\": \"billingMonth\", \"billing_country_code\": \"billingCountryCode\", \"billing_currency_code\": \"billingCurrencyCode\", \"resources\": {\"billable_cost\": 12, \"non_billable_cost\": 15}, \"offers\": [{\"offer_id\": \"offerId\", \"credits_total\": 12, \"offer_template\": \"offerTemplate\", \"valid_from\": \"2019-01-01T12:00:00\", \"expires_on\": \"2019-01-01T12:00:00\", \"credits\": {\"starting_balance\": 15, \"used\": 4, \"balance\": 7}}], \"support\": [{\"cost\": 4, \"type\": \"type\", \"overage\": 7}], \"subscription\": {\"overage\": 7, \"subscriptions\": [{\"subscription_id\": \"subscriptionId\", \"charge_agreement_number\": \"chargeAgreementNumber\", \"type\": \"type\", \"subscription_amount\": 18, \"start\": \"2019-01-01T12:00:00\", \"end\": \"2019-01-01T12:00:00\", \"credits_total\": 12, \"terms\": [{\"start\": \"2019-01-01T12:00:00\", \"end\": \"2019-01-01T12:00:00\", \"credits\": {\"total\": 5, \"starting_balance\": 15, \"used\": 4, \"balance\": 7}}]}]}}";
    String getAccountSummaryPath = "/v4/accounts/testString/summary/testString";

    server.enqueue(new MockResponse()
    .setHeader("Content-type", "application/json")
    .setResponseCode(200)
    .setBody(mockResponseBody));

    constructClientService();

    // Construct an instance of the GetAccountSummaryOptions model
    GetAccountSummaryOptions getAccountSummaryOptionsModel = new GetAccountSummaryOptions.Builder()
    .accountId("testString")
    .billingmonth("testString")
    .build();

    // Invoke operation with valid options model (positive test)
    Response<AccountSummary> response = usageReportsService.getAccountSummary(getAccountSummaryOptionsModel).execute();
    assertNotNull(response);
    AccountSummary responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "GET");

    // Check query
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNull(query);

    // Check request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, getAccountSummaryPath);
  }

  // Test the getAccountSummary operation with null options model parameter
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testGetAccountSummaryNoOptions() throws Throwable {
    // construct the service
    constructClientService();

    server.enqueue(new MockResponse());

    // Invoke operation with null options model (negative test)
    usageReportsService.getAccountSummary(null).execute();
  }

  @Test
  public void testGetAccountUsageWOptions() throws Throwable {
    // Schedule some responses.
    String mockResponseBody = "{\"account_id\": \"accountId\", \"pricing_country\": \"USA\", \"currency_code\": \"USD\", \"month\": \"2017-08\", \"resources\": [{\"resource_id\": \"resourceId\", \"billable_cost\": 12, \"billable_rated_cost\": 17, \"non_billable_cost\": 15, \"non_billable_rated_cost\": 20, \"plans\": [{\"plan_id\": \"planId\", \"pricing_region\": \"pricingRegion\", \"billable\": true, \"cost\": 4, \"rated_cost\": 9, \"usage\": [{\"metric\": \"UP-TIME\", \"quantity\": 711.11, \"rateable_quantity\": 700, \"cost\": 123.45, \"rated_cost\": 130.0, \"price\": [\"anyValue\"], \"unit\": \"HOURS\", \"non_chargeable\": true, \"discounts\": [{\"ref\": \"Discount-d27beddb-111b-4bbf-8cb1-b770f531c1a9\", \"name\": \"platform-discount\", \"display_name\": \"Platform Service Discount\", \"discount\": 5}]}], \"discounts\": [{\"ref\": \"Discount-d27beddb-111b-4bbf-8cb1-b770f531c1a9\", \"name\": \"platform-discount\", \"display_name\": \"Platform Service Discount\", \"discount\": 5}]}], \"discounts\": [{\"ref\": \"Discount-d27beddb-111b-4bbf-8cb1-b770f531c1a9\", \"name\": \"platform-discount\", \"display_name\": \"Platform Service Discount\", \"discount\": 5}]}]}";
    String getAccountUsagePath = "/v4/accounts/testString/usage/testString";

    server.enqueue(new MockResponse()
    .setHeader("Content-type", "application/json")
    .setResponseCode(200)
    .setBody(mockResponseBody));

    constructClientService();

    // Construct an instance of the GetAccountUsageOptions model
    GetAccountUsageOptions getAccountUsageOptionsModel = new GetAccountUsageOptions.Builder()
    .accountId("testString")
    .billingmonth("testString")
    .names(true)
    .acceptLanguage("testString")
    .build();

    // Invoke operation with valid options model (positive test)
    Response<AccountUsage> response = usageReportsService.getAccountUsage(getAccountUsageOptionsModel).execute();
    assertNotNull(response);
    AccountUsage responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "GET");

    // Check query
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNotNull(query);
    // Get query params
    assertEquals(Boolean.valueOf(query.get("_names")), Boolean.valueOf(true));
    // Check request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, getAccountUsagePath);
  }

  // Test the getAccountUsage operation with null options model parameter
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testGetAccountUsageNoOptions() throws Throwable {
    // construct the service
    constructClientService();

    server.enqueue(new MockResponse());

    // Invoke operation with null options model (negative test)
    usageReportsService.getAccountUsage(null).execute();
  }

  @Test
  public void testGetResourceGroupUsageWOptions() throws Throwable {
    // Schedule some responses.
    String mockResponseBody = "{\"account_id\": \"accountId\", \"resource_group_id\": \"resourceGroupId\", \"pricing_country\": \"USA\", \"currency_code\": \"USD\", \"month\": \"2017-08\", \"resources\": [{\"resource_id\": \"resourceId\", \"billable_cost\": 12, \"billable_rated_cost\": 17, \"non_billable_cost\": 15, \"non_billable_rated_cost\": 20, \"plans\": [{\"plan_id\": \"planId\", \"pricing_region\": \"pricingRegion\", \"billable\": true, \"cost\": 4, \"rated_cost\": 9, \"usage\": [{\"metric\": \"UP-TIME\", \"quantity\": 711.11, \"rateable_quantity\": 700, \"cost\": 123.45, \"rated_cost\": 130.0, \"price\": [\"anyValue\"], \"unit\": \"HOURS\", \"non_chargeable\": true, \"discounts\": [{\"ref\": \"Discount-d27beddb-111b-4bbf-8cb1-b770f531c1a9\", \"name\": \"platform-discount\", \"display_name\": \"Platform Service Discount\", \"discount\": 5}]}], \"discounts\": [{\"ref\": \"Discount-d27beddb-111b-4bbf-8cb1-b770f531c1a9\", \"name\": \"platform-discount\", \"display_name\": \"Platform Service Discount\", \"discount\": 5}]}], \"discounts\": [{\"ref\": \"Discount-d27beddb-111b-4bbf-8cb1-b770f531c1a9\", \"name\": \"platform-discount\", \"display_name\": \"Platform Service Discount\", \"discount\": 5}]}]}";
    String getResourceGroupUsagePath = "/v4/accounts/testString/resource_groups/testString/usage/testString";

    server.enqueue(new MockResponse()
    .setHeader("Content-type", "application/json")
    .setResponseCode(200)
    .setBody(mockResponseBody));

    constructClientService();

    // Construct an instance of the GetResourceGroupUsageOptions model
    GetResourceGroupUsageOptions getResourceGroupUsageOptionsModel = new GetResourceGroupUsageOptions.Builder()
    .accountId("testString")
    .resourceGroupId("testString")
    .billingmonth("testString")
    .names(true)
    .acceptLanguage("testString")
    .build();

    // Invoke operation with valid options model (positive test)
    Response<ResourceGroupUsage> response = usageReportsService.getResourceGroupUsage(getResourceGroupUsageOptionsModel).execute();
    assertNotNull(response);
    ResourceGroupUsage responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "GET");

    // Check query
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNotNull(query);
    // Get query params
    assertEquals(Boolean.valueOf(query.get("_names")), Boolean.valueOf(true));
    // Check request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, getResourceGroupUsagePath);
  }

  // Test the getResourceGroupUsage operation with null options model parameter
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testGetResourceGroupUsageNoOptions() throws Throwable {
    // construct the service
    constructClientService();

    server.enqueue(new MockResponse());

    // Invoke operation with null options model (negative test)
    usageReportsService.getResourceGroupUsage(null).execute();
  }

  @Test
  public void testGetOrgUsageWOptions() throws Throwable {
    // Schedule some responses.
    String mockResponseBody = "{\"account_id\": \"accountId\", \"organization_id\": \"organizationId\", \"pricing_country\": \"USA\", \"currency_code\": \"USD\", \"month\": \"2017-08\", \"resources\": [{\"resource_id\": \"resourceId\", \"billable_cost\": 12, \"billable_rated_cost\": 17, \"non_billable_cost\": 15, \"non_billable_rated_cost\": 20, \"plans\": [{\"plan_id\": \"planId\", \"pricing_region\": \"pricingRegion\", \"billable\": true, \"cost\": 4, \"rated_cost\": 9, \"usage\": [{\"metric\": \"UP-TIME\", \"quantity\": 711.11, \"rateable_quantity\": 700, \"cost\": 123.45, \"rated_cost\": 130.0, \"price\": [\"anyValue\"], \"unit\": \"HOURS\", \"non_chargeable\": true, \"discounts\": [{\"ref\": \"Discount-d27beddb-111b-4bbf-8cb1-b770f531c1a9\", \"name\": \"platform-discount\", \"display_name\": \"Platform Service Discount\", \"discount\": 5}]}], \"discounts\": [{\"ref\": \"Discount-d27beddb-111b-4bbf-8cb1-b770f531c1a9\", \"name\": \"platform-discount\", \"display_name\": \"Platform Service Discount\", \"discount\": 5}]}], \"discounts\": [{\"ref\": \"Discount-d27beddb-111b-4bbf-8cb1-b770f531c1a9\", \"name\": \"platform-discount\", \"display_name\": \"Platform Service Discount\", \"discount\": 5}]}]}";
    String getOrgUsagePath = "/v4/accounts/testString/organizations/testString/usage/testString";

    server.enqueue(new MockResponse()
    .setHeader("Content-type", "application/json")
    .setResponseCode(200)
    .setBody(mockResponseBody));

    constructClientService();

    // Construct an instance of the GetOrgUsageOptions model
    GetOrgUsageOptions getOrgUsageOptionsModel = new GetOrgUsageOptions.Builder()
    .accountId("testString")
    .organizationId("testString")
    .billingmonth("testString")
    .names(true)
    .acceptLanguage("testString")
    .build();

    // Invoke operation with valid options model (positive test)
    Response<OrgUsage> response = usageReportsService.getOrgUsage(getOrgUsageOptionsModel).execute();
    assertNotNull(response);
    OrgUsage responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "GET");

    // Check query
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNotNull(query);
    // Get query params
    assertEquals(Boolean.valueOf(query.get("_names")), Boolean.valueOf(true));
    // Check request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, getOrgUsagePath);
  }

  // Test the getOrgUsage operation with null options model parameter
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testGetOrgUsageNoOptions() throws Throwable {
    // construct the service
    constructClientService();

    server.enqueue(new MockResponse());

    // Invoke operation with null options model (negative test)
    usageReportsService.getOrgUsage(null).execute();
  }

  @Test
  public void testGetResourceUsageAccountWOptions() throws Throwable {
    // Schedule some responses.
    String mockResponseBody = "{\"limit\": 5, \"count\": 5, \"first\": {\"href\": \"href\"}, \"next\": {\"href\": \"href\", \"offset\": \"offset\"}, \"resources\": [{\"account_id\": \"accountId\", \"resource_instance_id\": \"resourceInstanceId\", \"resource_id\": \"resourceId\", \"resource_group_id\": \"resourceGroupId\", \"organization_id\": \"organizationId\", \"space\": \"space\", \"consumer_id\": \"consumerId\", \"region\": \"region\", \"pricing_region\": \"pricingRegion\", \"pricing_country\": \"USA\", \"currency_code\": \"USD\", \"billable\": true, \"plan_id\": \"planId\", \"month\": \"2017-08\", \"usage\": [{\"metric\": \"UP-TIME\", \"quantity\": 711.11, \"rateable_quantity\": 700, \"cost\": 123.45, \"rated_cost\": 130.0, \"price\": [\"anyValue\"], \"unit\": \"HOURS\", \"non_chargeable\": true, \"discounts\": [{\"ref\": \"Discount-d27beddb-111b-4bbf-8cb1-b770f531c1a9\", \"name\": \"platform-discount\", \"display_name\": \"Platform Service Discount\", \"discount\": 5}]}]}]}";
    String getResourceUsageAccountPath = "/v4/accounts/testString/resource_instances/usage/testString";

    server.enqueue(new MockResponse()
    .setHeader("Content-type", "application/json")
    .setResponseCode(200)
    .setBody(mockResponseBody));

    constructClientService();

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

    // Invoke operation with valid options model (positive test)
    Response<InstancesUsage> response = usageReportsService.getResourceUsageAccount(getResourceUsageAccountOptionsModel).execute();
    assertNotNull(response);
    InstancesUsage responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "GET");

    // Check query
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNotNull(query);
    // Get query params
    assertEquals(Boolean.valueOf(query.get("_names")), Boolean.valueOf(true));
    assertEquals(Long.valueOf(query.get("_limit")), Long.valueOf("1"));
    assertEquals(query.get("_start"), "testString");
    assertEquals(query.get("resource_group_id"), "testString");
    assertEquals(query.get("organization_id"), "testString");
    assertEquals(query.get("resource_instance_id"), "testString");
    assertEquals(query.get("resource_id"), "testString");
    assertEquals(query.get("plan_id"), "testString");
    assertEquals(query.get("region"), "testString");
    // Check request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, getResourceUsageAccountPath);
  }

  // Test the getResourceUsageAccount operation with null options model parameter
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testGetResourceUsageAccountNoOptions() throws Throwable {
    // construct the service
    constructClientService();

    server.enqueue(new MockResponse());

    // Invoke operation with null options model (negative test)
    usageReportsService.getResourceUsageAccount(null).execute();
  }

  @Test
  public void testGetResourceUsageResourceGroupWOptions() throws Throwable {
    // Schedule some responses.
    String mockResponseBody = "{\"limit\": 5, \"count\": 5, \"first\": {\"href\": \"href\"}, \"next\": {\"href\": \"href\", \"offset\": \"offset\"}, \"resources\": [{\"account_id\": \"accountId\", \"resource_instance_id\": \"resourceInstanceId\", \"resource_id\": \"resourceId\", \"resource_group_id\": \"resourceGroupId\", \"organization_id\": \"organizationId\", \"space\": \"space\", \"consumer_id\": \"consumerId\", \"region\": \"region\", \"pricing_region\": \"pricingRegion\", \"pricing_country\": \"USA\", \"currency_code\": \"USD\", \"billable\": true, \"plan_id\": \"planId\", \"month\": \"2017-08\", \"usage\": [{\"metric\": \"UP-TIME\", \"quantity\": 711.11, \"rateable_quantity\": 700, \"cost\": 123.45, \"rated_cost\": 130.0, \"price\": [\"anyValue\"], \"unit\": \"HOURS\", \"non_chargeable\": true, \"discounts\": [{\"ref\": \"Discount-d27beddb-111b-4bbf-8cb1-b770f531c1a9\", \"name\": \"platform-discount\", \"display_name\": \"Platform Service Discount\", \"discount\": 5}]}]}]}";
    String getResourceUsageResourceGroupPath = "/v4/accounts/testString/resource_groups/testString/resource_instances/usage/testString";

    server.enqueue(new MockResponse()
    .setHeader("Content-type", "application/json")
    .setResponseCode(200)
    .setBody(mockResponseBody));

    constructClientService();

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

    // Invoke operation with valid options model (positive test)
    Response<InstancesUsage> response = usageReportsService.getResourceUsageResourceGroup(getResourceUsageResourceGroupOptionsModel).execute();
    assertNotNull(response);
    InstancesUsage responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "GET");

    // Check query
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNotNull(query);
    // Get query params
    assertEquals(Boolean.valueOf(query.get("_names")), Boolean.valueOf(true));
    assertEquals(Long.valueOf(query.get("_limit")), Long.valueOf("1"));
    assertEquals(query.get("_start"), "testString");
    assertEquals(query.get("resource_instance_id"), "testString");
    assertEquals(query.get("resource_id"), "testString");
    assertEquals(query.get("plan_id"), "testString");
    assertEquals(query.get("region"), "testString");
    // Check request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, getResourceUsageResourceGroupPath);
  }

  // Test the getResourceUsageResourceGroup operation with null options model parameter
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testGetResourceUsageResourceGroupNoOptions() throws Throwable {
    // construct the service
    constructClientService();

    server.enqueue(new MockResponse());

    // Invoke operation with null options model (negative test)
    usageReportsService.getResourceUsageResourceGroup(null).execute();
  }

  @Test
  public void testGetResourceUsageOrgWOptions() throws Throwable {
    // Schedule some responses.
    String mockResponseBody = "{\"limit\": 5, \"count\": 5, \"first\": {\"href\": \"href\"}, \"next\": {\"href\": \"href\", \"offset\": \"offset\"}, \"resources\": [{\"account_id\": \"accountId\", \"resource_instance_id\": \"resourceInstanceId\", \"resource_id\": \"resourceId\", \"resource_group_id\": \"resourceGroupId\", \"organization_id\": \"organizationId\", \"space\": \"space\", \"consumer_id\": \"consumerId\", \"region\": \"region\", \"pricing_region\": \"pricingRegion\", \"pricing_country\": \"USA\", \"currency_code\": \"USD\", \"billable\": true, \"plan_id\": \"planId\", \"month\": \"2017-08\", \"usage\": [{\"metric\": \"UP-TIME\", \"quantity\": 711.11, \"rateable_quantity\": 700, \"cost\": 123.45, \"rated_cost\": 130.0, \"price\": [\"anyValue\"], \"unit\": \"HOURS\", \"non_chargeable\": true, \"discounts\": [{\"ref\": \"Discount-d27beddb-111b-4bbf-8cb1-b770f531c1a9\", \"name\": \"platform-discount\", \"display_name\": \"Platform Service Discount\", \"discount\": 5}]}]}]}";
    String getResourceUsageOrgPath = "/v4/accounts/testString/organizations/testString/resource_instances/usage/testString";

    server.enqueue(new MockResponse()
    .setHeader("Content-type", "application/json")
    .setResponseCode(200)
    .setBody(mockResponseBody));

    constructClientService();

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

    // Invoke operation with valid options model (positive test)
    Response<InstancesUsage> response = usageReportsService.getResourceUsageOrg(getResourceUsageOrgOptionsModel).execute();
    assertNotNull(response);
    InstancesUsage responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "GET");

    // Check query
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNotNull(query);
    // Get query params
    assertEquals(Boolean.valueOf(query.get("_names")), Boolean.valueOf(true));
    assertEquals(Long.valueOf(query.get("_limit")), Long.valueOf("1"));
    assertEquals(query.get("_start"), "testString");
    assertEquals(query.get("resource_instance_id"), "testString");
    assertEquals(query.get("resource_id"), "testString");
    assertEquals(query.get("plan_id"), "testString");
    assertEquals(query.get("region"), "testString");
    // Check request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, getResourceUsageOrgPath);
  }

  // Test the getResourceUsageOrg operation with null options model parameter
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testGetResourceUsageOrgNoOptions() throws Throwable {
    // construct the service
    constructClientService();

    server.enqueue(new MockResponse());

    // Invoke operation with null options model (negative test)
    usageReportsService.getResourceUsageOrg(null).execute();
  }

  /** Initialize the server */
  @BeforeMethod
  public void setUpMockServer() {
    try {
        server = new MockWebServer();
        // register handler
        server.start();
        }
    catch (IOException err) {
        fail("Failed to instantiate mock web server");
    }
  }

  @AfterMethod
  public void tearDownMockServer() throws IOException {
    server.shutdown();
    usageReportsService = null;
  }
}