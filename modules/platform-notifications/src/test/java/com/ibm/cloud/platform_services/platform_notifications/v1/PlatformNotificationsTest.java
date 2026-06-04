/*
 * (C) Copyright IBM Corp. 2026.
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

package com.ibm.cloud.platform_services.platform_notifications.v1;

import com.ibm.cloud.platform_services.platform_notifications.v1.PlatformNotifications;
import com.ibm.cloud.platform_services.platform_notifications.v1.model.Acknowledgement;
import com.ibm.cloud.platform_services.platform_notifications.v1.model.AddDestination;
import com.ibm.cloud.platform_services.platform_notifications.v1.model.AddDestinationCollection;
import com.ibm.cloud.platform_services.platform_notifications.v1.model.AddDestinationEventNotificationDestination;
import com.ibm.cloud.platform_services.platform_notifications.v1.model.AddDestinationPrototype;
import com.ibm.cloud.platform_services.platform_notifications.v1.model.AddDestinationPrototypeEventNotificationDestinationPrototype;
import com.ibm.cloud.platform_services.platform_notifications.v1.model.CreateDistributionListDestinationOptions;
import com.ibm.cloud.platform_services.platform_notifications.v1.model.CreatePreferencesOptions;
import com.ibm.cloud.platform_services.platform_notifications.v1.model.DeleteDistributionListDestinationOptions;
import com.ibm.cloud.platform_services.platform_notifications.v1.model.DeleteNotificationPreferencesOptions;
import com.ibm.cloud.platform_services.platform_notifications.v1.model.GetAcknowledgementOptions;
import com.ibm.cloud.platform_services.platform_notifications.v1.model.GetDistributionListDestinationOptions;
import com.ibm.cloud.platform_services.platform_notifications.v1.model.GetPreferencesOptions;
import com.ibm.cloud.platform_services.platform_notifications.v1.model.ListDistributionListDestinationsOptions;
import com.ibm.cloud.platform_services.platform_notifications.v1.model.ListNotificationsOptions;
import com.ibm.cloud.platform_services.platform_notifications.v1.model.Notification;
import com.ibm.cloud.platform_services.platform_notifications.v1.model.NotificationCollection;
import com.ibm.cloud.platform_services.platform_notifications.v1.model.NotificationsPager;
import com.ibm.cloud.platform_services.platform_notifications.v1.model.PaginationLink;
import com.ibm.cloud.platform_services.platform_notifications.v1.model.PaginationLinkWithToken;
import com.ibm.cloud.platform_services.platform_notifications.v1.model.PreferenceValueWithUpdates;
import com.ibm.cloud.platform_services.platform_notifications.v1.model.PreferenceValueWithoutUpdates;
import com.ibm.cloud.platform_services.platform_notifications.v1.model.PreferencesObject;
import com.ibm.cloud.platform_services.platform_notifications.v1.model.ReplaceNotificationAcknowledgementOptions;
import com.ibm.cloud.platform_services.platform_notifications.v1.model.ReplaceNotificationPreferencesOptions;
import com.ibm.cloud.platform_services.platform_notifications.v1.model.TestDestinationRequestBodyPrototype;
import com.ibm.cloud.platform_services.platform_notifications.v1.model.TestDestinationRequestBodyPrototypeTestEventNotificationDestinationRequestBodyPrototype;
import com.ibm.cloud.platform_services.platform_notifications.v1.model.TestDestinationResponseBody;
import com.ibm.cloud.platform_services.platform_notifications.v1.model.TestDistributionListDestinationOptions;
import com.ibm.cloud.platform_services.platform_notifications.v1.utils.TestUtilities;
import com.ibm.cloud.sdk.core.http.Response;
import com.ibm.cloud.sdk.core.security.Authenticator;
import com.ibm.cloud.sdk.core.security.NoAuthAuthenticator;
import com.ibm.cloud.sdk.core.service.model.FileWithMetadata;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import okhttp3.mockwebserver.MockResponse;
import okhttp3.mockwebserver.MockWebServer;
import okhttp3.mockwebserver.RecordedRequest;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import static org.testng.Assert.*;

/**
 * Unit test class for the PlatformNotifications service.
 */
public class PlatformNotificationsTest {

  final HashMap<String, InputStream> mockStreamMap = TestUtilities.createMockStreamMap();
  final List<FileWithMetadata> mockListFileWithMetadata = TestUtilities.creatMockListFileWithMetadata();

  protected MockWebServer server;
  protected PlatformNotifications platformNotificationsService;

  // Construct the service with a null authenticator (negative test)
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testConstructorWithNullAuthenticator() throws Throwable {
    final String serviceName = "testService";
    new PlatformNotifications(serviceName, null);
  }

  // Test the listNotifications operation with a valid options model parameter
  @Test
  public void testListNotificationsWOptions() throws Throwable {
    // Register a mock response
    String mockResponseBody = "{\"limit\": 50, \"total_count\": 232, \"first\": {\"href\": \"https://notifications.cloud.ibm.com/api/v1/notifications?limit=50\"}, \"previous\": {\"href\": \"https://notifications.cloud.ibm.com/api/v1/notifications?start=3fe78a36b9aa7f26&limit=50\", \"start\": \"3fe78a36b9aa7f26\"}, \"next\": {\"href\": \"https://notifications.cloud.ibm.com/api/v1/notifications?start=3fe78a36b9aa7f26&limit=50\", \"start\": \"3fe78a36b9aa7f26\"}, \"last\": {\"href\": \"https://notifications.cloud.ibm.com/api/v1/notifications?start=3fe78a36b9aa7f26&limit=50\", \"start\": \"3fe78a36b9aa7f26\"}, \"notifications\": [{\"title\": \"System Maintenance Scheduled\", \"body\": \"Scheduled maintenance will occur on March 15th from 10:00 AM to 11:00 AM UTC.\", \"id\": \"12345\", \"category\": \"maintenance\", \"component_names\": [\"componentNames\"], \"start_time\": 1771791490, \"is_global\": false, \"state\": \"new\", \"regions\": [\"regions\"], \"crn_masks\": [\"crnMasks\"], \"record_id\": \"rec-67890\", \"source_id\": \"src-11111\", \"completion_code\": \"successful\", \"end_time\": 1771791490, \"update_time\": 1771791490, \"severity\": 2, \"lucene_query\": \"region:us-south AND service_name:event-notifications\", \"resource_link\": \"https://cloud.ibm.com/status/incident/12345\", \"creation_timestamp\": 1772804159452}]}";
    String listNotificationsPath = "/v1/notifications";
    server.enqueue(new MockResponse()
      .setHeader("Content-type", "application/json")
      .setResponseCode(200)
      .setBody(mockResponseBody));

    // Construct an instance of the ListNotificationsOptions model
    ListNotificationsOptions listNotificationsOptionsModel = new ListNotificationsOptions.Builder()
      .accountId("a1b2c3d4e5f6g7h8i9j0k1l2m3n4o5p6")
      .start("3fe78a36b9aa7f26")
      .limit(Long.valueOf("50"))
      .build();

    // Invoke listNotifications() with a valid options model and verify the result
    Response<NotificationCollection> response = platformNotificationsService.listNotifications(listNotificationsOptionsModel).execute();
    assertNotNull(response);
    NotificationCollection responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request sent to the mock server
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "GET");
    // Verify request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, listNotificationsPath);
    // Verify query params
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNotNull(query);
    assertEquals(query.get("account_id"), "a1b2c3d4e5f6g7h8i9j0k1l2m3n4o5p6");
    assertEquals(query.get("start"), "3fe78a36b9aa7f26");
    assertEquals(Long.valueOf(query.get("limit")), Long.valueOf("50"));
  }

  // Test the listNotifications operation with and without retries enabled
  @Test
  public void testListNotificationsWRetries() throws Throwable {
    platformNotificationsService.enableRetries(4, 30);
    testListNotificationsWOptions();

    platformNotificationsService.disableRetries();
    testListNotificationsWOptions();
  }

  // Test the listNotifications operation using the NotificationsPager.getNext() method
  @Test
  public void testListNotificationsWithPagerGetNext() throws Throwable {
    // Set up the two-page mock response.
    String mockResponsePage1 = "{\"next\":{\"start\":\"1\"},\"total_count\":2,\"limit\":1,\"notifications\":[{\"title\":\"System Maintenance Scheduled\",\"body\":\"Scheduled maintenance will occur on March 15th from 10:00 AM to 11:00 AM UTC.\",\"id\":\"12345\",\"category\":\"maintenance\",\"component_names\":[\"componentNames\"],\"start_time\":1771791490,\"is_global\":false,\"state\":\"new\",\"regions\":[\"regions\"],\"crn_masks\":[\"crnMasks\"],\"record_id\":\"rec-67890\",\"source_id\":\"src-11111\",\"completion_code\":\"successful\",\"end_time\":1771791490,\"update_time\":1771791490,\"severity\":2,\"lucene_query\":\"region:us-south AND service_name:event-notifications\",\"resource_link\":\"https://cloud.ibm.com/status/incident/12345\",\"creation_timestamp\":1772804159452}]}";
    String mockResponsePage2 = "{\"total_count\":2,\"limit\":1,\"notifications\":[{\"title\":\"System Maintenance Scheduled\",\"body\":\"Scheduled maintenance will occur on March 15th from 10:00 AM to 11:00 AM UTC.\",\"id\":\"12345\",\"category\":\"maintenance\",\"component_names\":[\"componentNames\"],\"start_time\":1771791490,\"is_global\":false,\"state\":\"new\",\"regions\":[\"regions\"],\"crn_masks\":[\"crnMasks\"],\"record_id\":\"rec-67890\",\"source_id\":\"src-11111\",\"completion_code\":\"successful\",\"end_time\":1771791490,\"update_time\":1771791490,\"severity\":2,\"lucene_query\":\"region:us-south AND service_name:event-notifications\",\"resource_link\":\"https://cloud.ibm.com/status/incident/12345\",\"creation_timestamp\":1772804159452}]}";
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

    ListNotificationsOptions listNotificationsOptions = new ListNotificationsOptions.Builder()
      .accountId("a1b2c3d4e5f6g7h8i9j0k1l2m3n4o5p6")
      .limit(Long.valueOf("50"))
      .build();

    List<Notification> allResults = new ArrayList<>();
    NotificationsPager pager = new NotificationsPager(platformNotificationsService, listNotificationsOptions);
    while (pager.hasNext()) {
      List<Notification> nextPage = pager.getNext();
      assertNotNull(nextPage);
      allResults.addAll(nextPage);
    }
    assertEquals(allResults.size(), 2);
  }
  
  // Test the listNotifications operation using the NotificationsPager.getAll() method
  @Test
  public void testListNotificationsWithPagerGetAll() throws Throwable {
    // Set up the two-page mock response.
    String mockResponsePage1 = "{\"next\":{\"start\":\"1\"},\"total_count\":2,\"limit\":1,\"notifications\":[{\"title\":\"System Maintenance Scheduled\",\"body\":\"Scheduled maintenance will occur on March 15th from 10:00 AM to 11:00 AM UTC.\",\"id\":\"12345\",\"category\":\"maintenance\",\"component_names\":[\"componentNames\"],\"start_time\":1771791490,\"is_global\":false,\"state\":\"new\",\"regions\":[\"regions\"],\"crn_masks\":[\"crnMasks\"],\"record_id\":\"rec-67890\",\"source_id\":\"src-11111\",\"completion_code\":\"successful\",\"end_time\":1771791490,\"update_time\":1771791490,\"severity\":2,\"lucene_query\":\"region:us-south AND service_name:event-notifications\",\"resource_link\":\"https://cloud.ibm.com/status/incident/12345\",\"creation_timestamp\":1772804159452}]}";
    String mockResponsePage2 = "{\"total_count\":2,\"limit\":1,\"notifications\":[{\"title\":\"System Maintenance Scheduled\",\"body\":\"Scheduled maintenance will occur on March 15th from 10:00 AM to 11:00 AM UTC.\",\"id\":\"12345\",\"category\":\"maintenance\",\"component_names\":[\"componentNames\"],\"start_time\":1771791490,\"is_global\":false,\"state\":\"new\",\"regions\":[\"regions\"],\"crn_masks\":[\"crnMasks\"],\"record_id\":\"rec-67890\",\"source_id\":\"src-11111\",\"completion_code\":\"successful\",\"end_time\":1771791490,\"update_time\":1771791490,\"severity\":2,\"lucene_query\":\"region:us-south AND service_name:event-notifications\",\"resource_link\":\"https://cloud.ibm.com/status/incident/12345\",\"creation_timestamp\":1772804159452}]}";
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

    ListNotificationsOptions listNotificationsOptions = new ListNotificationsOptions.Builder()
      .accountId("a1b2c3d4e5f6g7h8i9j0k1l2m3n4o5p6")
      .limit(Long.valueOf("50"))
      .build();

    NotificationsPager pager = new NotificationsPager(platformNotificationsService, listNotificationsOptions);
    List<Notification> allResults = pager.getAll();
    assertNotNull(allResults);
    assertEquals(allResults.size(), 2);
  }
  
  // Test the getAcknowledgement operation with a valid options model parameter
  @Test
  public void testGetAcknowledgementWOptions() throws Throwable {
    // Register a mock response
    String mockResponseBody = "{\"has_unread\": true, \"last_acknowledged\": 1772804159452}";
    String getAcknowledgementPath = "/v1/notifications/acknowledgement";
    server.enqueue(new MockResponse()
      .setHeader("Content-type", "application/json")
      .setResponseCode(200)
      .setBody(mockResponseBody));

    // Construct an instance of the GetAcknowledgementOptions model
    GetAcknowledgementOptions getAcknowledgementOptionsModel = new GetAcknowledgementOptions.Builder()
      .accountId("a1b2c3d4e5f6g7h8i9j0k1l2m3n4o5p6")
      .build();

    // Invoke getAcknowledgement() with a valid options model and verify the result
    Response<Acknowledgement> response = platformNotificationsService.getAcknowledgement(getAcknowledgementOptionsModel).execute();
    assertNotNull(response);
    Acknowledgement responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request sent to the mock server
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "GET");
    // Verify request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, getAcknowledgementPath);
    // Verify query params
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNotNull(query);
    assertEquals(query.get("account_id"), "a1b2c3d4e5f6g7h8i9j0k1l2m3n4o5p6");
  }

  // Test the getAcknowledgement operation with and without retries enabled
  @Test
  public void testGetAcknowledgementWRetries() throws Throwable {
    platformNotificationsService.enableRetries(4, 30);
    testGetAcknowledgementWOptions();

    platformNotificationsService.disableRetries();
    testGetAcknowledgementWOptions();
  }

  // Test the replaceNotificationAcknowledgement operation with a valid options model parameter
  @Test
  public void testReplaceNotificationAcknowledgementWOptions() throws Throwable {
    // Register a mock response
    String mockResponseBody = "{\"has_unread\": true, \"last_acknowledged\": 1772804159452}";
    String replaceNotificationAcknowledgementPath = "/v1/notifications/acknowledgement";
    server.enqueue(new MockResponse()
      .setHeader("Content-type", "application/json")
      .setResponseCode(200)
      .setBody(mockResponseBody));

    // Construct an instance of the ReplaceNotificationAcknowledgementOptions model
    ReplaceNotificationAcknowledgementOptions replaceNotificationAcknowledgementOptionsModel = new ReplaceNotificationAcknowledgementOptions.Builder()
      .lastAcknowledged(Long.valueOf("1772804159452"))
      .accountId("a1b2c3d4e5f6g7h8i9j0k1l2m3n4o5p6")
      .build();

    // Invoke replaceNotificationAcknowledgement() with a valid options model and verify the result
    Response<Acknowledgement> response = platformNotificationsService.replaceNotificationAcknowledgement(replaceNotificationAcknowledgementOptionsModel).execute();
    assertNotNull(response);
    Acknowledgement responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request sent to the mock server
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "PUT");
    // Verify request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, replaceNotificationAcknowledgementPath);
    // Verify query params
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNotNull(query);
    assertEquals(query.get("account_id"), "a1b2c3d4e5f6g7h8i9j0k1l2m3n4o5p6");
  }

  // Test the replaceNotificationAcknowledgement operation with and without retries enabled
  @Test
  public void testReplaceNotificationAcknowledgementWRetries() throws Throwable {
    platformNotificationsService.enableRetries(4, 30);
    testReplaceNotificationAcknowledgementWOptions();

    platformNotificationsService.disableRetries();
    testReplaceNotificationAcknowledgementWOptions();
  }

  // Test the replaceNotificationAcknowledgement operation with a null options model (negative test)
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testReplaceNotificationAcknowledgementNoOptions() throws Throwable {
    server.enqueue(new MockResponse());
    platformNotificationsService.replaceNotificationAcknowledgement(null).execute();
  }

  // Test the listDistributionListDestinations operation with a valid options model parameter
  @Test
  public void testListDistributionListDestinationsWOptions() throws Throwable {
    // Register a mock response
    String mockResponseBody = "{\"destinations\": [{\"destination_id\": \"12345678-1234-1234-1234-123456789012\", \"destination_type\": \"event_notifications\"}]}";
    String listDistributionListDestinationsPath = "/v1/distribution_lists/a1b2c3d4e5f6g7h8i9j0k1l2m3n4o5p6/destinations";
    server.enqueue(new MockResponse()
      .setHeader("Content-type", "application/json")
      .setResponseCode(200)
      .setBody(mockResponseBody));

    // Construct an instance of the ListDistributionListDestinationsOptions model
    ListDistributionListDestinationsOptions listDistributionListDestinationsOptionsModel = new ListDistributionListDestinationsOptions.Builder()
      .accountId("a1b2c3d4e5f6g7h8i9j0k1l2m3n4o5p6")
      .build();

    // Invoke listDistributionListDestinations() with a valid options model and verify the result
    Response<AddDestinationCollection> response = platformNotificationsService.listDistributionListDestinations(listDistributionListDestinationsOptionsModel).execute();
    assertNotNull(response);
    AddDestinationCollection responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request sent to the mock server
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "GET");
    // Verify request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, listDistributionListDestinationsPath);
    // Verify that there is no query string
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNull(query);
  }

  // Test the listDistributionListDestinations operation with and without retries enabled
  @Test
  public void testListDistributionListDestinationsWRetries() throws Throwable {
    platformNotificationsService.enableRetries(4, 30);
    testListDistributionListDestinationsWOptions();

    platformNotificationsService.disableRetries();
    testListDistributionListDestinationsWOptions();
  }

  // Test the listDistributionListDestinations operation with a null options model (negative test)
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testListDistributionListDestinationsNoOptions() throws Throwable {
    server.enqueue(new MockResponse());
    platformNotificationsService.listDistributionListDestinations(null).execute();
  }

  // Test the createDistributionListDestination operation with a valid options model parameter
  @Test
  public void testCreateDistributionListDestinationWOptions() throws Throwable {
    // Register a mock response
    String mockResponseBody = "{\"destination_id\": \"12345678-1234-1234-1234-123456789012\", \"destination_type\": \"event_notifications\"}";
    String createDistributionListDestinationPath = "/v1/distribution_lists/a1b2c3d4e5f6g7h8i9j0k1l2m3n4o5p6/destinations";
    server.enqueue(new MockResponse()
      .setHeader("Content-type", "application/json")
      .setResponseCode(201)
      .setBody(mockResponseBody));

    // Construct an instance of the AddDestinationPrototypeEventNotificationDestinationPrototype model
    AddDestinationPrototypeEventNotificationDestinationPrototype addDestinationPrototypeModel = new AddDestinationPrototypeEventNotificationDestinationPrototype.Builder()
      .destinationId("12345678-1234-1234-1234-123456789012")
      .destinationType("event_notifications")
      .build();

    // Construct an instance of the CreateDistributionListDestinationOptions model
    CreateDistributionListDestinationOptions createDistributionListDestinationOptionsModel = new CreateDistributionListDestinationOptions.Builder()
      .accountId("a1b2c3d4e5f6g7h8i9j0k1l2m3n4o5p6")
      .addDestinationPrototype(addDestinationPrototypeModel)
      .build();

    // Invoke createDistributionListDestination() with a valid options model and verify the result
    Response<AddDestination> response = platformNotificationsService.createDistributionListDestination(createDistributionListDestinationOptionsModel).execute();
    assertNotNull(response);
    AddDestination responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request sent to the mock server
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "POST");
    // Verify request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, createDistributionListDestinationPath);
    // Verify that there is no query string
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNull(query);
  }

  // Test the createDistributionListDestination operation with and without retries enabled
  @Test
  public void testCreateDistributionListDestinationWRetries() throws Throwable {
    platformNotificationsService.enableRetries(4, 30);
    testCreateDistributionListDestinationWOptions();

    platformNotificationsService.disableRetries();
    testCreateDistributionListDestinationWOptions();
  }

  // Test the createDistributionListDestination operation with a null options model (negative test)
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testCreateDistributionListDestinationNoOptions() throws Throwable {
    server.enqueue(new MockResponse());
    platformNotificationsService.createDistributionListDestination(null).execute();
  }

  // Test the getDistributionListDestination operation with a valid options model parameter
  @Test
  public void testGetDistributionListDestinationWOptions() throws Throwable {
    // Register a mock response
    String mockResponseBody = "{\"destination_id\": \"12345678-1234-1234-1234-123456789012\", \"destination_type\": \"event_notifications\"}";
    String getDistributionListDestinationPath = "/v1/distribution_lists/a1b2c3d4e5f6g7h8i9j0k1l2m3n4o5p6/destinations/12345678-1234-1234-1234-123456789012";
    server.enqueue(new MockResponse()
      .setHeader("Content-type", "application/json")
      .setResponseCode(200)
      .setBody(mockResponseBody));

    // Construct an instance of the GetDistributionListDestinationOptions model
    GetDistributionListDestinationOptions getDistributionListDestinationOptionsModel = new GetDistributionListDestinationOptions.Builder()
      .accountId("a1b2c3d4e5f6g7h8i9j0k1l2m3n4o5p6")
      .destinationId("12345678-1234-1234-1234-123456789012")
      .build();

    // Invoke getDistributionListDestination() with a valid options model and verify the result
    Response<AddDestination> response = platformNotificationsService.getDistributionListDestination(getDistributionListDestinationOptionsModel).execute();
    assertNotNull(response);
    AddDestination responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request sent to the mock server
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "GET");
    // Verify request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, getDistributionListDestinationPath);
    // Verify that there is no query string
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNull(query);
  }

  // Test the getDistributionListDestination operation with and without retries enabled
  @Test
  public void testGetDistributionListDestinationWRetries() throws Throwable {
    platformNotificationsService.enableRetries(4, 30);
    testGetDistributionListDestinationWOptions();

    platformNotificationsService.disableRetries();
    testGetDistributionListDestinationWOptions();
  }

  // Test the getDistributionListDestination operation with a null options model (negative test)
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testGetDistributionListDestinationNoOptions() throws Throwable {
    server.enqueue(new MockResponse());
    platformNotificationsService.getDistributionListDestination(null).execute();
  }

  // Test the deleteDistributionListDestination operation with a valid options model parameter
  @Test
  public void testDeleteDistributionListDestinationWOptions() throws Throwable {
    // Register a mock response
    String mockResponseBody = "";
    String deleteDistributionListDestinationPath = "/v1/distribution_lists/a1b2c3d4e5f6g7h8i9j0k1l2m3n4o5p6/destinations/12345678-1234-1234-1234-123456789012";
    server.enqueue(new MockResponse()
      .setResponseCode(204)
      .setBody(mockResponseBody));

    // Construct an instance of the DeleteDistributionListDestinationOptions model
    DeleteDistributionListDestinationOptions deleteDistributionListDestinationOptionsModel = new DeleteDistributionListDestinationOptions.Builder()
      .accountId("a1b2c3d4e5f6g7h8i9j0k1l2m3n4o5p6")
      .destinationId("12345678-1234-1234-1234-123456789012")
      .build();

    // Invoke deleteDistributionListDestination() with a valid options model and verify the result
    Response<Void> response = platformNotificationsService.deleteDistributionListDestination(deleteDistributionListDestinationOptionsModel).execute();
    assertNotNull(response);
    Void responseObj = response.getResult();
    assertNull(responseObj);

    // Verify the contents of the request sent to the mock server
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "DELETE");
    // Verify request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, deleteDistributionListDestinationPath);
    // Verify that there is no query string
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNull(query);
  }

  // Test the deleteDistributionListDestination operation with and without retries enabled
  @Test
  public void testDeleteDistributionListDestinationWRetries() throws Throwable {
    platformNotificationsService.enableRetries(4, 30);
    testDeleteDistributionListDestinationWOptions();

    platformNotificationsService.disableRetries();
    testDeleteDistributionListDestinationWOptions();
  }

  // Test the deleteDistributionListDestination operation with a null options model (negative test)
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testDeleteDistributionListDestinationNoOptions() throws Throwable {
    server.enqueue(new MockResponse());
    platformNotificationsService.deleteDistributionListDestination(null).execute();
  }

  // Test the testDistributionListDestination operation with a valid options model parameter
  @Test
  public void testTestDistributionListDestinationWOptions() throws Throwable {
    // Register a mock response
    String mockResponseBody = "{\"message\": \"success\"}";
    String testDistributionListDestinationPath = "/v1/distribution_lists/a1b2c3d4e5f6g7h8i9j0k1l2m3n4o5p6/destinations/12345678-1234-1234-1234-123456789012/test";
    server.enqueue(new MockResponse()
      .setHeader("Content-type", "application/json")
      .setResponseCode(200)
      .setBody(mockResponseBody));

    // Construct an instance of the TestDestinationRequestBodyPrototypeTestEventNotificationDestinationRequestBodyPrototype model
    TestDestinationRequestBodyPrototypeTestEventNotificationDestinationRequestBodyPrototype testDestinationRequestBodyPrototypeModel = new TestDestinationRequestBodyPrototypeTestEventNotificationDestinationRequestBodyPrototype.Builder()
      .destinationType("event_notifications")
      .notificationType("incident")
      .build();

    // Construct an instance of the TestDistributionListDestinationOptions model
    TestDistributionListDestinationOptions testDistributionListDestinationOptionsModel = new TestDistributionListDestinationOptions.Builder()
      .accountId("a1b2c3d4e5f6g7h8i9j0k1l2m3n4o5p6")
      .destinationId("12345678-1234-1234-1234-123456789012")
      .testDestinationRequestBodyPrototype(testDestinationRequestBodyPrototypeModel)
      .build();

    // Invoke testDistributionListDestination() with a valid options model and verify the result
    Response<TestDestinationResponseBody> response = platformNotificationsService.testDistributionListDestination(testDistributionListDestinationOptionsModel).execute();
    assertNotNull(response);
    TestDestinationResponseBody responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request sent to the mock server
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "POST");
    // Verify request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, testDistributionListDestinationPath);
    // Verify that there is no query string
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNull(query);
  }

  // Test the testDistributionListDestination operation with and without retries enabled
  @Test
  public void testTestDistributionListDestinationWRetries() throws Throwable {
    platformNotificationsService.enableRetries(4, 30);
    testTestDistributionListDestinationWOptions();

    platformNotificationsService.disableRetries();
    testTestDistributionListDestinationWOptions();
  }

  // Test the testDistributionListDestination operation with a null options model (negative test)
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testTestDistributionListDestinationNoOptions() throws Throwable {
    server.enqueue(new MockResponse());
    platformNotificationsService.testDistributionListDestination(null).execute();
  }

  // Test the getPreferences operation with a valid options model parameter
  @Test
  public void testGetPreferencesWOptions() throws Throwable {
    // Register a mock response
    String mockResponseBody = "{\"incident_severity1\": {\"channels\": [\"email\"], \"updates\": true}, \"incident_severity2\": {\"channels\": [\"email\"], \"updates\": true}, \"incident_severity3\": {\"channels\": [\"email\"], \"updates\": true}, \"incident_severity4\": {\"channels\": [\"email\"], \"updates\": true}, \"maintenance_high\": {\"channels\": [\"email\"], \"updates\": true}, \"maintenance_medium\": {\"channels\": [\"email\"], \"updates\": true}, \"maintenance_low\": {\"channels\": [\"email\"], \"updates\": true}, \"announcements_major\": {\"channels\": [\"email\"]}, \"announcements_minor\": {\"channels\": [\"email\"]}, \"security_normal\": {\"channels\": [\"email\"]}, \"account_normal\": {\"channels\": [\"email\"]}, \"billing_and_usage_order\": {\"channels\": [\"email\"]}, \"billing_and_usage_invoices\": {\"channels\": [\"email\"]}, \"billing_and_usage_payments\": {\"channels\": [\"email\"]}, \"billing_and_usage_subscriptions_and_promo_codes\": {\"channels\": [\"email\"]}, \"billing_and_usage_spending_alerts\": {\"channels\": [\"email\"]}, \"resourceactivity_normal\": {\"channels\": [\"email\"]}, \"ordering_review\": {\"channels\": [\"email\"]}, \"ordering_approved\": {\"channels\": [\"email\"]}, \"ordering_approved_vsi\": {\"channels\": [\"email\"]}, \"ordering_approved_server\": {\"channels\": [\"email\"]}, \"provisioning_reload_complete\": {\"channels\": [\"email\"]}, \"provisioning_complete_vsi\": {\"channels\": [\"email\"]}, \"provisioning_complete_server\": {\"channels\": [\"email\"]}}";
    String getPreferencesPath = "/v1/notifications/IBMid-1234567890/preferences";
    server.enqueue(new MockResponse()
      .setHeader("Content-type", "application/json")
      .setResponseCode(200)
      .setBody(mockResponseBody));

    // Construct an instance of the GetPreferencesOptions model
    GetPreferencesOptions getPreferencesOptionsModel = new GetPreferencesOptions.Builder()
      .iamId("IBMid-1234567890")
      .accountId("a1b2c3d4e5f6g7h8i9j0k1l2m3n4o5p6")
      .build();

    // Invoke getPreferences() with a valid options model and verify the result
    Response<PreferencesObject> response = platformNotificationsService.getPreferences(getPreferencesOptionsModel).execute();
    assertNotNull(response);
    PreferencesObject responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request sent to the mock server
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "GET");
    // Verify request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, getPreferencesPath);
    // Verify query params
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNotNull(query);
    assertEquals(query.get("account_id"), "a1b2c3d4e5f6g7h8i9j0k1l2m3n4o5p6");
  }

  // Test the getPreferences operation with and without retries enabled
  @Test
  public void testGetPreferencesWRetries() throws Throwable {
    platformNotificationsService.enableRetries(4, 30);
    testGetPreferencesWOptions();

    platformNotificationsService.disableRetries();
    testGetPreferencesWOptions();
  }

  // Test the getPreferences operation with a null options model (negative test)
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testGetPreferencesNoOptions() throws Throwable {
    server.enqueue(new MockResponse());
    platformNotificationsService.getPreferences(null).execute();
  }

  // Test the createPreferences operation with a valid options model parameter
  @Test
  public void testCreatePreferencesWOptions() throws Throwable {
    // Register a mock response
    String mockResponseBody = "{\"incident_severity1\": {\"channels\": [\"email\"], \"updates\": true}, \"incident_severity2\": {\"channels\": [\"email\"], \"updates\": true}, \"incident_severity3\": {\"channels\": [\"email\"], \"updates\": true}, \"incident_severity4\": {\"channels\": [\"email\"], \"updates\": true}, \"maintenance_high\": {\"channels\": [\"email\"], \"updates\": true}, \"maintenance_medium\": {\"channels\": [\"email\"], \"updates\": true}, \"maintenance_low\": {\"channels\": [\"email\"], \"updates\": true}, \"announcements_major\": {\"channels\": [\"email\"]}, \"announcements_minor\": {\"channels\": [\"email\"]}, \"security_normal\": {\"channels\": [\"email\"]}, \"account_normal\": {\"channels\": [\"email\"]}, \"billing_and_usage_order\": {\"channels\": [\"email\"]}, \"billing_and_usage_invoices\": {\"channels\": [\"email\"]}, \"billing_and_usage_payments\": {\"channels\": [\"email\"]}, \"billing_and_usage_subscriptions_and_promo_codes\": {\"channels\": [\"email\"]}, \"billing_and_usage_spending_alerts\": {\"channels\": [\"email\"]}, \"resourceactivity_normal\": {\"channels\": [\"email\"]}, \"ordering_review\": {\"channels\": [\"email\"]}, \"ordering_approved\": {\"channels\": [\"email\"]}, \"ordering_approved_vsi\": {\"channels\": [\"email\"]}, \"ordering_approved_server\": {\"channels\": [\"email\"]}, \"provisioning_reload_complete\": {\"channels\": [\"email\"]}, \"provisioning_complete_vsi\": {\"channels\": [\"email\"]}, \"provisioning_complete_server\": {\"channels\": [\"email\"]}}";
    String createPreferencesPath = "/v1/notifications/IBMid-1234567890/preferences";
    server.enqueue(new MockResponse()
      .setHeader("Content-type", "application/json")
      .setResponseCode(201)
      .setBody(mockResponseBody));

    // Construct an instance of the PreferenceValueWithUpdates model
    PreferenceValueWithUpdates preferenceValueWithUpdatesModel = new PreferenceValueWithUpdates.Builder()
      .channels(java.util.Arrays.asList("email"))
      .updates(true)
      .build();

    // Construct an instance of the PreferenceValueWithoutUpdates model
    PreferenceValueWithoutUpdates preferenceValueWithoutUpdatesModel = new PreferenceValueWithoutUpdates.Builder()
      .channels(java.util.Arrays.asList("email"))
      .build();

    // Construct an instance of the CreatePreferencesOptions model
    CreatePreferencesOptions createPreferencesOptionsModel = new CreatePreferencesOptions.Builder()
      .iamId("IBMid-1234567890")
      .incidentSeverity1(preferenceValueWithUpdatesModel)
      .incidentSeverity2(preferenceValueWithUpdatesModel)
      .incidentSeverity3(preferenceValueWithUpdatesModel)
      .incidentSeverity4(preferenceValueWithUpdatesModel)
      .maintenanceHigh(preferenceValueWithUpdatesModel)
      .maintenanceMedium(preferenceValueWithUpdatesModel)
      .maintenanceLow(preferenceValueWithUpdatesModel)
      .announcementsMajor(preferenceValueWithoutUpdatesModel)
      .announcementsMinor(preferenceValueWithoutUpdatesModel)
      .securityNormal(preferenceValueWithoutUpdatesModel)
      .accountNormal(preferenceValueWithoutUpdatesModel)
      .billingAndUsageOrder(preferenceValueWithoutUpdatesModel)
      .billingAndUsageInvoices(preferenceValueWithoutUpdatesModel)
      .billingAndUsagePayments(preferenceValueWithoutUpdatesModel)
      .billingAndUsageSubscriptionsAndPromoCodes(preferenceValueWithoutUpdatesModel)
      .billingAndUsageSpendingAlerts(preferenceValueWithoutUpdatesModel)
      .resourceactivityNormal(preferenceValueWithoutUpdatesModel)
      .orderingReview(preferenceValueWithoutUpdatesModel)
      .orderingApproved(preferenceValueWithoutUpdatesModel)
      .orderingApprovedVsi(preferenceValueWithoutUpdatesModel)
      .orderingApprovedServer(preferenceValueWithoutUpdatesModel)
      .provisioningReloadComplete(preferenceValueWithoutUpdatesModel)
      .provisioningCompleteVsi(preferenceValueWithoutUpdatesModel)
      .provisioningCompleteServer(preferenceValueWithoutUpdatesModel)
      .accountId("a1b2c3d4e5f6g7h8i9j0k1l2m3n4o5p6")
      .build();

    // Invoke createPreferences() with a valid options model and verify the result
    Response<PreferencesObject> response = platformNotificationsService.createPreferences(createPreferencesOptionsModel).execute();
    assertNotNull(response);
    PreferencesObject responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request sent to the mock server
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "POST");
    // Verify request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, createPreferencesPath);
    // Verify query params
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNotNull(query);
    assertEquals(query.get("account_id"), "a1b2c3d4e5f6g7h8i9j0k1l2m3n4o5p6");
  }

  // Test the createPreferences operation with and without retries enabled
  @Test
  public void testCreatePreferencesWRetries() throws Throwable {
    platformNotificationsService.enableRetries(4, 30);
    testCreatePreferencesWOptions();

    platformNotificationsService.disableRetries();
    testCreatePreferencesWOptions();
  }

  // Test the createPreferences operation with a null options model (negative test)
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testCreatePreferencesNoOptions() throws Throwable {
    server.enqueue(new MockResponse());
    platformNotificationsService.createPreferences(null).execute();
  }

  // Test the replaceNotificationPreferences operation with a valid options model parameter
  @Test
  public void testReplaceNotificationPreferencesWOptions() throws Throwable {
    // Register a mock response
    String mockResponseBody = "{\"incident_severity1\": {\"channels\": [\"email\"], \"updates\": true}, \"incident_severity2\": {\"channels\": [\"email\"], \"updates\": true}, \"incident_severity3\": {\"channels\": [\"email\"], \"updates\": true}, \"incident_severity4\": {\"channels\": [\"email\"], \"updates\": true}, \"maintenance_high\": {\"channels\": [\"email\"], \"updates\": true}, \"maintenance_medium\": {\"channels\": [\"email\"], \"updates\": true}, \"maintenance_low\": {\"channels\": [\"email\"], \"updates\": true}, \"announcements_major\": {\"channels\": [\"email\"]}, \"announcements_minor\": {\"channels\": [\"email\"]}, \"security_normal\": {\"channels\": [\"email\"]}, \"account_normal\": {\"channels\": [\"email\"]}, \"billing_and_usage_order\": {\"channels\": [\"email\"]}, \"billing_and_usage_invoices\": {\"channels\": [\"email\"]}, \"billing_and_usage_payments\": {\"channels\": [\"email\"]}, \"billing_and_usage_subscriptions_and_promo_codes\": {\"channels\": [\"email\"]}, \"billing_and_usage_spending_alerts\": {\"channels\": [\"email\"]}, \"resourceactivity_normal\": {\"channels\": [\"email\"]}, \"ordering_review\": {\"channels\": [\"email\"]}, \"ordering_approved\": {\"channels\": [\"email\"]}, \"ordering_approved_vsi\": {\"channels\": [\"email\"]}, \"ordering_approved_server\": {\"channels\": [\"email\"]}, \"provisioning_reload_complete\": {\"channels\": [\"email\"]}, \"provisioning_complete_vsi\": {\"channels\": [\"email\"]}, \"provisioning_complete_server\": {\"channels\": [\"email\"]}}";
    String replaceNotificationPreferencesPath = "/v1/notifications/IBMid-1234567890/preferences";
    server.enqueue(new MockResponse()
      .setHeader("Content-type", "application/json")
      .setResponseCode(200)
      .setBody(mockResponseBody));

    // Construct an instance of the PreferenceValueWithUpdates model
    PreferenceValueWithUpdates preferenceValueWithUpdatesModel = new PreferenceValueWithUpdates.Builder()
      .channels(java.util.Arrays.asList("email"))
      .updates(true)
      .build();

    // Construct an instance of the PreferenceValueWithoutUpdates model
    PreferenceValueWithoutUpdates preferenceValueWithoutUpdatesModel = new PreferenceValueWithoutUpdates.Builder()
      .channels(java.util.Arrays.asList("email"))
      .build();

    // Construct an instance of the ReplaceNotificationPreferencesOptions model
    ReplaceNotificationPreferencesOptions replaceNotificationPreferencesOptionsModel = new ReplaceNotificationPreferencesOptions.Builder()
      .iamId("IBMid-1234567890")
      .incidentSeverity1(preferenceValueWithUpdatesModel)
      .incidentSeverity2(preferenceValueWithUpdatesModel)
      .incidentSeverity3(preferenceValueWithUpdatesModel)
      .incidentSeverity4(preferenceValueWithUpdatesModel)
      .maintenanceHigh(preferenceValueWithUpdatesModel)
      .maintenanceMedium(preferenceValueWithUpdatesModel)
      .maintenanceLow(preferenceValueWithUpdatesModel)
      .announcementsMajor(preferenceValueWithoutUpdatesModel)
      .announcementsMinor(preferenceValueWithoutUpdatesModel)
      .securityNormal(preferenceValueWithoutUpdatesModel)
      .accountNormal(preferenceValueWithoutUpdatesModel)
      .billingAndUsageOrder(preferenceValueWithoutUpdatesModel)
      .billingAndUsageInvoices(preferenceValueWithoutUpdatesModel)
      .billingAndUsagePayments(preferenceValueWithoutUpdatesModel)
      .billingAndUsageSubscriptionsAndPromoCodes(preferenceValueWithoutUpdatesModel)
      .billingAndUsageSpendingAlerts(preferenceValueWithoutUpdatesModel)
      .resourceactivityNormal(preferenceValueWithoutUpdatesModel)
      .orderingReview(preferenceValueWithoutUpdatesModel)
      .orderingApproved(preferenceValueWithoutUpdatesModel)
      .orderingApprovedVsi(preferenceValueWithoutUpdatesModel)
      .orderingApprovedServer(preferenceValueWithoutUpdatesModel)
      .provisioningReloadComplete(preferenceValueWithoutUpdatesModel)
      .provisioningCompleteVsi(preferenceValueWithoutUpdatesModel)
      .provisioningCompleteServer(preferenceValueWithoutUpdatesModel)
      .accountId("a1b2c3d4e5f6g7h8i9j0k1l2m3n4o5p6")
      .build();

    // Invoke replaceNotificationPreferences() with a valid options model and verify the result
    Response<PreferencesObject> response = platformNotificationsService.replaceNotificationPreferences(replaceNotificationPreferencesOptionsModel).execute();
    assertNotNull(response);
    PreferencesObject responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request sent to the mock server
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "PUT");
    // Verify request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, replaceNotificationPreferencesPath);
    // Verify query params
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNotNull(query);
    assertEquals(query.get("account_id"), "a1b2c3d4e5f6g7h8i9j0k1l2m3n4o5p6");
  }

  // Test the replaceNotificationPreferences operation with and without retries enabled
  @Test
  public void testReplaceNotificationPreferencesWRetries() throws Throwable {
    platformNotificationsService.enableRetries(4, 30);
    testReplaceNotificationPreferencesWOptions();

    platformNotificationsService.disableRetries();
    testReplaceNotificationPreferencesWOptions();
  }

  // Test the replaceNotificationPreferences operation with a null options model (negative test)
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testReplaceNotificationPreferencesNoOptions() throws Throwable {
    server.enqueue(new MockResponse());
    platformNotificationsService.replaceNotificationPreferences(null).execute();
  }

  // Test the deleteNotificationPreferences operation with a valid options model parameter
  @Test
  public void testDeleteNotificationPreferencesWOptions() throws Throwable {
    // Register a mock response
    String mockResponseBody = "";
    String deleteNotificationPreferencesPath = "/v1/notifications/IBMid-1234567890/preferences";
    server.enqueue(new MockResponse()
      .setResponseCode(204)
      .setBody(mockResponseBody));

    // Construct an instance of the DeleteNotificationPreferencesOptions model
    DeleteNotificationPreferencesOptions deleteNotificationPreferencesOptionsModel = new DeleteNotificationPreferencesOptions.Builder()
      .iamId("IBMid-1234567890")
      .accountId("a1b2c3d4e5f6g7h8i9j0k1l2m3n4o5p6")
      .build();

    // Invoke deleteNotificationPreferences() with a valid options model and verify the result
    Response<Void> response = platformNotificationsService.deleteNotificationPreferences(deleteNotificationPreferencesOptionsModel).execute();
    assertNotNull(response);
    Void responseObj = response.getResult();
    assertNull(responseObj);

    // Verify the contents of the request sent to the mock server
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "DELETE");
    // Verify request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, deleteNotificationPreferencesPath);
    // Verify query params
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNotNull(query);
    assertEquals(query.get("account_id"), "a1b2c3d4e5f6g7h8i9j0k1l2m3n4o5p6");
  }

  // Test the deleteNotificationPreferences operation with and without retries enabled
  @Test
  public void testDeleteNotificationPreferencesWRetries() throws Throwable {
    platformNotificationsService.enableRetries(4, 30);
    testDeleteNotificationPreferencesWOptions();

    platformNotificationsService.disableRetries();
    testDeleteNotificationPreferencesWOptions();
  }

  // Test the deleteNotificationPreferences operation with a null options model (negative test)
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testDeleteNotificationPreferencesNoOptions() throws Throwable {
    server.enqueue(new MockResponse());
    platformNotificationsService.deleteNotificationPreferences(null).execute();
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
    platformNotificationsService = null;
  }

  // Constructs an instance of the service to be used by the tests
  public void constructClientService() {
    System.setProperty("TESTSERVICE_AUTH_TYPE", "noAuth");
    final String serviceName = "testService";

    platformNotificationsService = PlatformNotifications.newInstance(serviceName);
    String url = server.url("/").toString();
    platformNotificationsService.setServiceUrl(url);
  }
}