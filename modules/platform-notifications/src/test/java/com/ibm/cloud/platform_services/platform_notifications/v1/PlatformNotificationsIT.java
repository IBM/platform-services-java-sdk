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
import com.ibm.cloud.platform_services.test.SdkIntegrationTestBase;
import com.ibm.cloud.sdk.core.http.Response;
import com.ibm.cloud.sdk.core.service.exception.ServiceResponseException;
import com.ibm.cloud.sdk.core.service.model.FileWithMetadata;
import com.ibm.cloud.sdk.core.util.CredentialUtils;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import static org.testng.Assert.*;

/**
 * Integration test class for the PlatformNotifications service.
 */
public class PlatformNotificationsIT extends SdkIntegrationTestBase {
  public PlatformNotifications service = null;
  public static Map<String, String> config = null;
  final HashMap<String, InputStream> mockStreamMap = TestUtilities.createMockStreamMap();
  final List<FileWithMetadata> mockListFileWithMetadata = TestUtilities.creatMockListFileWithMetadata();

  private static String accountId;
  private static String destinationId;
  private static String iamId;

  /**
   * This method provides our config filename to the base class.
   */

  public String getConfigFilename() {
    return "../../platform_notifications_v1.env";
  }

  @BeforeClass
  public void constructService() {
    // Ask super if we should skip the tests.
    if (skipTests()) {
      return;
    }

    service = PlatformNotifications.newInstance();
    assertNotNull(service);
    assertNotNull(service.getServiceUrl());

    // Load up our test-specific config properties.
    config = CredentialUtils.getServiceProperties(PlatformNotifications.DEFAULT_SERVICE_NAME);
    assertNotNull(config);

    service.setServiceUrl(config.get("URL"));
    
    assertFalse(config.isEmpty());
    assertEquals(service.getServiceUrl(), config.get("URL"));

    // Load test data from config
    accountId = config.get("ACCOUNT_ID");
    destinationId = config.get("DESTINATION_ID");
    iamId = config.get("IAM_ID");
    
    assertNotNull(accountId, "ACCOUNT_ID must be set in config");
    assertNotNull(destinationId, "DESTINATION_ID must be set in config");
    assertNotNull(iamId, "IAM_ID must be set in config");

    service.enableRetries(4, 30);

    System.out.println("Setup complete.");
  }

  @Test
  public void testListNotifications() throws Exception {
    try {
      ListNotificationsOptions listNotificationsOptions = new ListNotificationsOptions.Builder()
        .accountId(accountId)
        .limit(Long.valueOf("50"))
        .build();

      // Invoke operation
      Response<NotificationCollection> response = service.listNotifications(listNotificationsOptions).execute();
      // Validate response
      assertNotNull(response);
      assertEquals(response.getStatusCode(), 200);

      NotificationCollection notificationCollectionResult = response.getResult();
      assertNotNull(notificationCollectionResult);

    } catch (ServiceResponseException e) {
        fail(String.format("Service returned status code %d: %s%nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()));
    }
  }

  @Test(dependsOnMethods = { "testListNotifications" })
  public void testListNotificationsWithPager() throws Exception {
    try {
      ListNotificationsOptions options = new ListNotificationsOptions.Builder()
        .accountId(accountId)
        .limit(Long.valueOf("50"))
        .build();

      // Test getNext().
      List<Notification> allResults = new ArrayList<>();
      NotificationsPager pager = new NotificationsPager(service, options);
      while (pager.hasNext()) {
        List<Notification> nextPage = pager.getNext();
        assertNotNull(nextPage);
        allResults.addAll(nextPage);
      }
      assertFalse(allResults.isEmpty());

      // Test getAll();
      pager = new NotificationsPager(service, options);
      List<Notification> allItems = pager.getAll();
      assertNotNull(allItems);
      assertFalse(allItems.isEmpty());

      assertEquals(allItems.size(), allResults.size());
      System.out.println(String.format("Retrieved a total of %d item(s) with pagination.", allResults.size()));
    } catch (ServiceResponseException e) {
        fail(String.format("Service returned status code %d: %s%nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()));
    }
  }

  @Test(dependsOnMethods = { "testListNotifications" })
  public void testGetAcknowledgement() throws Exception {
    try {
      GetAcknowledgementOptions getAcknowledgementOptions = new GetAcknowledgementOptions.Builder()
        .accountId(accountId)
        .build();

      // Invoke operation
      Response<Acknowledgement> response = service.getAcknowledgement(getAcknowledgementOptions).execute();
      // Validate response
      assertNotNull(response);
      assertEquals(response.getStatusCode(), 200);

      Acknowledgement acknowledgementResult = response.getResult();
      assertNotNull(acknowledgementResult);

    } catch (ServiceResponseException e) {
        fail(String.format("Service returned status code %d: %s%nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()));
    }
  }

  @Test(dependsOnMethods = { "testGetAcknowledgement" })
  public void testReplaceNotificationAcknowledgement() throws Exception {
    try {
      ReplaceNotificationAcknowledgementOptions replaceNotificationAcknowledgementOptions = new ReplaceNotificationAcknowledgementOptions.Builder()
        .lastAcknowledged(Long.valueOf("1772804159452"))
        .accountId(accountId)
        .build();

      // Invoke operation
      Response<Acknowledgement> response = service.replaceNotificationAcknowledgement(replaceNotificationAcknowledgementOptions).execute();
      // Validate response
      assertNotNull(response);
      assertEquals(response.getStatusCode(), 200);

      Acknowledgement acknowledgementResult = response.getResult();
      assertNotNull(acknowledgementResult);

    } catch (ServiceResponseException e) {
        fail(String.format("Service returned status code %d: %s%nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()));
    }
  }

  @Test(dependsOnMethods = { "testReplaceNotificationAcknowledgement" })
  public void testListDistributionListDestinations() throws Exception {
    try {
      ListDistributionListDestinationsOptions listDistributionListDestinationsOptions = new ListDistributionListDestinationsOptions.Builder()
        .accountId(accountId)
        .build();

      // Invoke operation
      Response<AddDestinationCollection> response = service.listDistributionListDestinations(listDistributionListDestinationsOptions).execute();
      // Validate response
      assertNotNull(response);
      assertEquals(response.getStatusCode(), 200);

      AddDestinationCollection addDestinationCollectionResult = response.getResult();
      assertNotNull(addDestinationCollectionResult);

    } catch (ServiceResponseException e) {
        fail(String.format("Service returned status code %d: %s%nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()));
    }
  }

  @Test(dependsOnMethods = { "testListDistributionListDestinations" })
  public void testCreateDistributionListDestination() throws Exception {
    try {
      AddDestinationPrototypeEventNotificationDestinationPrototype addDestinationPrototypeModel = new AddDestinationPrototypeEventNotificationDestinationPrototype.Builder()
        .destinationId(destinationId)
        .destinationType("event_notifications")
        .build();

      CreateDistributionListDestinationOptions createDistributionListDestinationOptions = new CreateDistributionListDestinationOptions.Builder()
        .accountId(accountId)
        .addDestinationPrototype(addDestinationPrototypeModel)
        .build();

      // Invoke operation
      Response<AddDestination> response = service.createDistributionListDestination(createDistributionListDestinationOptions).execute();
      // Validate response
      assertNotNull(response);
      assertEquals(response.getStatusCode(), 201);

      AddDestination addDestinationResult = response.getResult();
      assertNotNull(addDestinationResult);

    } catch (ServiceResponseException e) {
        fail(String.format("Service returned status code %d: %s%nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()));
    }
  }

  @Test(dependsOnMethods = { "testCreateDistributionListDestination" })
  public void testGetDistributionListDestination() throws Exception {
    try {
      GetDistributionListDestinationOptions getDistributionListDestinationOptions = new GetDistributionListDestinationOptions.Builder()
        .accountId(accountId)
        .destinationId(destinationId)
        .build();

      // Invoke operation
      Response<AddDestination> response = service.getDistributionListDestination(getDistributionListDestinationOptions).execute();
      // Validate response
      assertNotNull(response);
      assertEquals(response.getStatusCode(), 200);

      AddDestination addDestinationResult = response.getResult();
      assertNotNull(addDestinationResult);

    } catch (ServiceResponseException e) {
        fail(String.format("Service returned status code %d: %s%nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()));
    }
  }

  @Test(dependsOnMethods = { "testGetDistributionListDestination" })
  public void testTestDistributionListDestination() throws Exception {
    try {
      TestDestinationRequestBodyPrototypeTestEventNotificationDestinationRequestBodyPrototype testDestinationRequestBodyPrototypeModel = new TestDestinationRequestBodyPrototypeTestEventNotificationDestinationRequestBodyPrototype.Builder()
        .destinationType("event_notifications")
        .notificationType("incident")
        .build();

      TestDistributionListDestinationOptions testDistributionListDestinationOptions = new TestDistributionListDestinationOptions.Builder()
        .accountId(accountId)
        .destinationId(destinationId)
        .testDestinationRequestBodyPrototype(testDestinationRequestBodyPrototypeModel)
        .build();

      // Invoke operation
      Response<TestDestinationResponseBody> response = service.testDistributionListDestination(testDistributionListDestinationOptions).execute();
      // Validate response
      assertNotNull(response);
      assertEquals(response.getStatusCode(), 200);

      TestDestinationResponseBody testDestinationResponseBodyResult = response.getResult();
      assertNotNull(testDestinationResponseBodyResult);

    } catch (ServiceResponseException e) {
        fail(String.format("Service returned status code %d: %s%nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()));
    }
  }

  @Test(dependsOnMethods = { "testGetDistributionListDestination" })
  public void testCreatePreferences() throws Exception {
    try {
      PreferenceValueWithUpdates preferenceValueWithUpdatesModel = new PreferenceValueWithUpdates.Builder()
        .channels(java.util.Arrays.asList("email"))
        .updates(true)
        .build();

      PreferenceValueWithoutUpdates preferenceValueWithoutUpdatesModel = new PreferenceValueWithoutUpdates.Builder()
        .channels(java.util.Arrays.asList("email"))
        .build();

      CreatePreferencesOptions createPreferencesOptions = new CreatePreferencesOptions.Builder()
        .iamId(iamId)
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
        .accountId(accountId)
        .build();

      // Invoke operation
      Response<PreferencesObject> response = service.createPreferences(createPreferencesOptions).execute();
      // Validate response
      assertNotNull(response);
      assertEquals(response.getStatusCode(), 201);

      PreferencesObject preferencesObjectResult = response.getResult();
      assertNotNull(preferencesObjectResult);

    } catch (ServiceResponseException e) {
        fail(String.format("Service returned status code %d: %s%nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()));
    }
  }

  @Test(dependsOnMethods = { "testCreatePreferences" })
  public void testGetPreferences() throws Exception {
    try {
      GetPreferencesOptions getPreferencesOptions = new GetPreferencesOptions.Builder()
        .iamId(iamId)
        .accountId(accountId)
        .build();

      // Invoke operation
      Response<PreferencesObject> response = service.getPreferences(getPreferencesOptions).execute();
      // Validate response
      assertNotNull(response);
      assertEquals(response.getStatusCode(), 200);

      PreferencesObject preferencesObjectResult = response.getResult();
      assertNotNull(preferencesObjectResult);

    } catch (ServiceResponseException e) {
        fail(String.format("Service returned status code %d: %s%nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()));
    }
  }

  @Test(dependsOnMethods = { "testGetPreferences" })
  public void testReplaceNotificationPreferences() throws Exception {
    try {
      PreferenceValueWithUpdates preferenceValueWithUpdatesModel = new PreferenceValueWithUpdates.Builder()
        .channels(java.util.Arrays.asList("email"))
        .updates(true)
        .build();

      PreferenceValueWithoutUpdates preferenceValueWithoutUpdatesModel = new PreferenceValueWithoutUpdates.Builder()
        .channels(java.util.Arrays.asList("email"))
        .build();

      ReplaceNotificationPreferencesOptions replaceNotificationPreferencesOptions = new ReplaceNotificationPreferencesOptions.Builder()
        .iamId(iamId)
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
        .accountId(accountId)
        .build();

      // Invoke operation
      Response<PreferencesObject> response = service.replaceNotificationPreferences(replaceNotificationPreferencesOptions).execute();
      // Validate response
      assertNotNull(response);
      assertEquals(response.getStatusCode(), 200);

      PreferencesObject preferencesObjectResult = response.getResult();
      assertNotNull(preferencesObjectResult);

    } catch (ServiceResponseException e) {
        fail(String.format("Service returned status code %d: %s%nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()));
    }
  }

  @Test(dependsOnMethods = { "testReplaceNotificationPreferences" })
  public void testDeleteDistributionListDestination() throws Exception {
    try {
      DeleteDistributionListDestinationOptions deleteDistributionListDestinationOptions = new DeleteDistributionListDestinationOptions.Builder()
        .accountId(accountId)
        .destinationId(destinationId)
        .build();

      // Invoke operation
      Response<Void> response = service.deleteDistributionListDestination(deleteDistributionListDestinationOptions).execute();
      // Validate response
      assertNotNull(response);
      assertEquals(response.getStatusCode(), 204);
    } catch (ServiceResponseException e) {
        fail(String.format("Service returned status code %d: %s%nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()));
    }
  }

  @Test(dependsOnMethods = { "testDeleteDistributionListDestination" })
  public void testDeleteNotificationPreferences() throws Exception {
    try {
      DeleteNotificationPreferencesOptions deleteNotificationPreferencesOptions = new DeleteNotificationPreferencesOptions.Builder()
        .iamId(iamId)
        .accountId(accountId)
        .build();

      // Invoke operation
      Response<Void> response = service.deleteNotificationPreferences(deleteNotificationPreferencesOptions).execute();
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
