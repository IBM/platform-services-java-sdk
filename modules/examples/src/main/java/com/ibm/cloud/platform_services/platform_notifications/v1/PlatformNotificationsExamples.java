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
import com.ibm.cloud.platform_services.platform_notifications.v1.model.NotificationsPager;
import com.ibm.cloud.platform_services.platform_notifications.v1.model.PreferenceValueWithUpdates;
import com.ibm.cloud.platform_services.platform_notifications.v1.model.PreferenceValueWithoutUpdates;
import com.ibm.cloud.platform_services.platform_notifications.v1.model.PreferencesObject;
import com.ibm.cloud.platform_services.platform_notifications.v1.model.ReplaceNotificationAcknowledgementOptions;
import com.ibm.cloud.platform_services.platform_notifications.v1.model.ReplaceNotificationPreferencesOptions;
import com.ibm.cloud.platform_services.platform_notifications.v1.model.TestDestinationRequestBodyPrototypeTestEventNotificationDestinationRequestBodyPrototype;
import com.ibm.cloud.platform_services.platform_notifications.v1.model.TestDestinationResponseBody;
import com.ibm.cloud.platform_services.platform_notifications.v1.model.TestDistributionListDestinationOptions;
import com.ibm.cloud.sdk.core.http.Response;
import com.ibm.cloud.sdk.core.service.exception.ServiceResponseException;
import com.ibm.cloud.sdk.core.util.CredentialUtils;
import com.ibm.cloud.sdk.core.util.GsonSingleton;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * This class contains examples of how to use the Platform Notifications service.
 *
 * The following configuration properties are assumed to be defined:
 * PLATFORM_NOTIFICATIONS_IAM_PROFILE_ID=&lt;account_id&gt;
 * PLATFORM_NOTIFICATIONS_AUTH_TYPE=iam
 * PLATFORM_NOTIFICATIONS_APIKEY=&lt;apiKey&gt;
 * PLATFORM_NOTIFICATIONS_AUTH_URL=&lt;IAM token service base URL - omit this if using the production environment&gt;
 * PLATFORM_NOTIFICATIONS_ACCOUNT_ID=&lt;id&gt;
 * PLATFORM_NOTIFICATIONS_DESTINATION_ID=&lt;account_id&gt;
 * PLATFORM_NOTIFICATIONS_IAM_ID=&lt;iam_id&gt;
 * PLATFORM_NOTIFICATIONS_SERVICE_URL=<service_url&gt;
 *
 * These configuration properties can be exported as environment variables, or stored
 * in a configuration file and then:
 * export IBM_CREDENTIALS_FILE=&lt;name of configuration file&gt;
 */
public class PlatformNotificationsExamples {
  private static final Logger logger = LoggerFactory.getLogger(PlatformNotificationsExamples.class);
  protected PlatformNotificationsExamples() { }

  static {
    System.setProperty("IBM_CREDENTIALS_FILE", "../../platform_notifications_v1.env");
  }

  /**
   * The main() function invokes operations of the Platform Notifications service.
   * @param args command-line arguments
   * @throws Exception an error occurred
   */
  @SuppressWarnings("checkstyle:methodlength")
  public static void main(String[] args) throws Exception {
    PlatformNotifications platformNotificationsService = PlatformNotifications.newInstance();

    // Load up our test-specific config properties.
    Map<String, String> testConfigProperties = CredentialUtils.getServiceProperties(PlatformNotifications.DEFAULT_SERVICE_NAME);

    // Load test data from config
    String accountId = testConfigProperties.get("ACCOUNT_ID");
    String destinationId = testConfigProperties.get("DESTINATION_ID");
    String iamId = testConfigProperties.get("IAM_ID");

    try {
      System.out.println("listNotifications() result:");
      // begin-list_notifications
      ListNotificationsOptions listNotificationsOptions = new ListNotificationsOptions.Builder()
        .accountId(accountId)
        .limit(Long.valueOf("50"))
        .build();

      NotificationsPager pager = new NotificationsPager(platformNotificationsService, listNotificationsOptions);
      List<Notification> allResults = new ArrayList<>();
      while (pager.hasNext()) {
        List<Notification> nextPage = pager.getNext();
        allResults.addAll(nextPage);
      }

      System.out.println(GsonSingleton.getGson().toJson(allResults));
      // end-list_notifications
    } catch (ServiceResponseException e) {
        logger.error(String.format("Service returned status code %s: %s%nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()), e);
    }

    try {
      System.out.println("getAcknowledgement() result:");
      // begin-get_acknowledgement
      GetAcknowledgementOptions getAcknowledgementOptions = new GetAcknowledgementOptions.Builder()
        .accountId(accountId)
        .build();

      Response<Acknowledgement> response = platformNotificationsService.getAcknowledgement(getAcknowledgementOptions).execute();
      Acknowledgement acknowledgement = response.getResult();

      System.out.println(acknowledgement);
      // end-get_acknowledgement
    } catch (ServiceResponseException e) {
        logger.error(String.format("Service returned status code %s: %s%nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()), e);
    }

    try {
      System.out.println("replaceNotificationAcknowledgement() result:");
      // begin-replace_notification_acknowledgement
      ReplaceNotificationAcknowledgementOptions replaceNotificationAcknowledgementOptions = new ReplaceNotificationAcknowledgementOptions.Builder()
        .lastAcknowledged(Long.valueOf("1772804159452"))
        .accountId(accountId)
        .build();

      Response<Acknowledgement> response = platformNotificationsService.replaceNotificationAcknowledgement(replaceNotificationAcknowledgementOptions).execute();
      Acknowledgement acknowledgement = response.getResult();

      System.out.println(acknowledgement);
      // end-replace_notification_acknowledgement
    } catch (ServiceResponseException e) {
        logger.error(String.format("Service returned status code %s: %s%nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()), e);
    }

    try {
      System.out.println("listDistributionListDestinations() result:");
      // begin-list_distribution_list_destinations
      ListDistributionListDestinationsOptions listDistributionListDestinationsOptions = new ListDistributionListDestinationsOptions.Builder()
        .accountId(accountId)
        .build();

      Response<AddDestinationCollection> response = platformNotificationsService.listDistributionListDestinations(listDistributionListDestinationsOptions).execute();
      AddDestinationCollection addDestinationCollection = response.getResult();

      System.out.println(addDestinationCollection);
      // end-list_distribution_list_destinations
    } catch (ServiceResponseException e) {
        logger.error(String.format("Service returned status code %s: %s%nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()), e);
    }

    try {
      System.out.println("createDistributionListDestination() result:");
      // begin-create_distribution_list_destination
      AddDestinationPrototypeEventNotificationDestinationPrototype addDestinationPrototypeModel = new AddDestinationPrototypeEventNotificationDestinationPrototype.Builder()
        .destinationId(destinationId)
        .destinationType("event_notifications")
        .build();
      CreateDistributionListDestinationOptions createDistributionListDestinationOptions = new CreateDistributionListDestinationOptions.Builder()
        .accountId(accountId)
        .addDestinationPrototype(addDestinationPrototypeModel)
        .build();

      Response<AddDestination> response = platformNotificationsService.createDistributionListDestination(createDistributionListDestinationOptions).execute();
      AddDestination addDestination = response.getResult();

      System.out.println(addDestination);
      // end-create_distribution_list_destination
    } catch (ServiceResponseException e) {
        logger.error(String.format("Service returned status code %s: %s%nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()), e);
    }

    try {
      System.out.println("getDistributionListDestination() result:");
      // begin-get_distribution_list_destination
      GetDistributionListDestinationOptions getDistributionListDestinationOptions = new GetDistributionListDestinationOptions.Builder()
        .accountId(accountId)
        .destinationId(destinationId)
        .build();

      Response<AddDestination> response = platformNotificationsService.getDistributionListDestination(getDistributionListDestinationOptions).execute();
      AddDestination addDestination = response.getResult();

      System.out.println(addDestination);
      // end-get_distribution_list_destination
    } catch (ServiceResponseException e) {
        logger.error(String.format("Service returned status code %s: %s%nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()), e);
    }

    try {
      System.out.println("testDistributionListDestination() result:");
      // begin-test_distribution_list_destination
      TestDestinationRequestBodyPrototypeTestEventNotificationDestinationRequestBodyPrototype testDestinationRequestBodyPrototypeModel = new TestDestinationRequestBodyPrototypeTestEventNotificationDestinationRequestBodyPrototype.Builder()
        .destinationType("event_notifications")
        .notificationType("incident")
        .build();
      TestDistributionListDestinationOptions testDistributionListDestinationOptions = new TestDistributionListDestinationOptions.Builder()
        .accountId(accountId)
        .destinationId(destinationId)
        .testDestinationRequestBodyPrototype(testDestinationRequestBodyPrototypeModel)
        .build();

      Response<TestDestinationResponseBody> response = platformNotificationsService.testDistributionListDestination(testDistributionListDestinationOptions).execute();
      TestDestinationResponseBody testDestinationResponseBody = response.getResult();

      System.out.println(testDestinationResponseBody);
      // end-test_distribution_list_destination
    } catch (ServiceResponseException e) {
        logger.error(String.format("Service returned status code %s: %s%nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()), e);
    }

    try {
      System.out.println("createPreferences() result:");
      // begin-create_preferences
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
        .orderingReview(preferenceValueWithoutUpdatesModel)
        .accountId(accountId)
        .build();

      Response<PreferencesObject> response = platformNotificationsService.createPreferences(createPreferencesOptions).execute();
      PreferencesObject preferencesObject = response.getResult();

      System.out.println(preferencesObject);
      // end-create_preferences
    } catch (ServiceResponseException e) {
        logger.error(String.format("Service returned status code %s: %s%nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()), e);
    }

    try {
      System.out.println("getPreferences() result:");
      // begin-get_preferences
      GetPreferencesOptions getPreferencesOptions = new GetPreferencesOptions.Builder()
        .iamId(iamId)
        .accountId(accountId)
        .build();

      Response<PreferencesObject> response = platformNotificationsService.getPreferences(getPreferencesOptions).execute();
      PreferencesObject preferencesObject = response.getResult();

      System.out.println(preferencesObject);
      // end-get_preferences
    } catch (ServiceResponseException e) {
        logger.error(String.format("Service returned status code %s: %s%nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()), e);
    }

    try {
      System.out.println("replaceNotificationPreferences() result:");
      // begin-replace_notification_preferences
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
        .orderingReview(preferenceValueWithoutUpdatesModel)
        .accountId(accountId)
        .build();

      Response<PreferencesObject> response = platformNotificationsService.replaceNotificationPreferences(replaceNotificationPreferencesOptions).execute();
      PreferencesObject preferencesObject = response.getResult();

      System.out.println(preferencesObject);
      // end-replace_notification_preferences
    } catch (ServiceResponseException e) {
        logger.error(String.format("Service returned status code %s: %s%nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()), e);
    }

    try {
      // begin-delete_distribution_list_destination
      DeleteDistributionListDestinationOptions deleteDistributionListDestinationOptions = new DeleteDistributionListDestinationOptions.Builder()
        .accountId(accountId)
        .destinationId(destinationId)
        .build();

      Response<Void> response = platformNotificationsService.deleteDistributionListDestination(deleteDistributionListDestinationOptions).execute();
      // end-delete_distribution_list_destination
      System.out.printf("deleteDistributionListDestination() response status code: %d%n", response.getStatusCode());
    } catch (ServiceResponseException e) {
        logger.error(String.format("Service returned status code %s: %s%nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()), e);
    }

    try {
      // begin-delete_notification_preferences
      DeleteNotificationPreferencesOptions deleteNotificationPreferencesOptions = new DeleteNotificationPreferencesOptions.Builder()
        .iamId(iamId)
        .accountId(accountId)
        .build();

      Response<Void> response = platformNotificationsService.deleteNotificationPreferences(deleteNotificationPreferencesOptions).execute();
      // end-delete_notification_preferences
      System.out.printf("deleteNotificationPreferences() response status code: %d%n", response.getStatusCode());
    } catch (ServiceResponseException e) {
        logger.error(String.format("Service returned status code %s: %s%nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()), e);
    }
  }
}
