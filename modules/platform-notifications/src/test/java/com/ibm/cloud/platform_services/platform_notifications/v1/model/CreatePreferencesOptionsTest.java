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

package com.ibm.cloud.platform_services.platform_notifications.v1.model;

import com.ibm.cloud.platform_services.platform_notifications.v1.model.CreatePreferencesOptions;
import com.ibm.cloud.platform_services.platform_notifications.v1.model.PreferenceValueWithUpdates;
import com.ibm.cloud.platform_services.platform_notifications.v1.model.PreferenceValueWithoutUpdates;
import com.ibm.cloud.platform_services.platform_notifications.v1.utils.TestUtilities;
import com.ibm.cloud.sdk.core.service.model.FileWithMetadata;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import org.testng.annotations.Test;
import static org.testng.Assert.*;

/**
 * Unit test class for the CreatePreferencesOptions model.
 */
public class CreatePreferencesOptionsTest {
  final HashMap<String, InputStream> mockStreamMap = TestUtilities.createMockStreamMap();
  final List<FileWithMetadata> mockListFileWithMetadata = TestUtilities.creatMockListFileWithMetadata();

  @Test
  public void testCreatePreferencesOptions() throws Throwable {
    PreferenceValueWithUpdates preferenceValueWithUpdatesModel = new PreferenceValueWithUpdates.Builder()
      .channels(java.util.Arrays.asList("email"))
      .updates(true)
      .build();
    assertEquals(preferenceValueWithUpdatesModel.channels(), java.util.Arrays.asList("email"));
    assertEquals(preferenceValueWithUpdatesModel.updates(), Boolean.valueOf(true));

    PreferenceValueWithoutUpdates preferenceValueWithoutUpdatesModel = new PreferenceValueWithoutUpdates.Builder()
      .channels(java.util.Arrays.asList("email"))
      .build();
    assertEquals(preferenceValueWithoutUpdatesModel.channels(), java.util.Arrays.asList("email"));

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
    assertEquals(createPreferencesOptionsModel.iamId(), "IBMid-1234567890");
    assertEquals(createPreferencesOptionsModel.incidentSeverity1(), preferenceValueWithUpdatesModel);
    assertEquals(createPreferencesOptionsModel.incidentSeverity2(), preferenceValueWithUpdatesModel);
    assertEquals(createPreferencesOptionsModel.incidentSeverity3(), preferenceValueWithUpdatesModel);
    assertEquals(createPreferencesOptionsModel.incidentSeverity4(), preferenceValueWithUpdatesModel);
    assertEquals(createPreferencesOptionsModel.maintenanceHigh(), preferenceValueWithUpdatesModel);
    assertEquals(createPreferencesOptionsModel.maintenanceMedium(), preferenceValueWithUpdatesModel);
    assertEquals(createPreferencesOptionsModel.maintenanceLow(), preferenceValueWithUpdatesModel);
    assertEquals(createPreferencesOptionsModel.announcementsMajor(), preferenceValueWithoutUpdatesModel);
    assertEquals(createPreferencesOptionsModel.announcementsMinor(), preferenceValueWithoutUpdatesModel);
    assertEquals(createPreferencesOptionsModel.securityNormal(), preferenceValueWithoutUpdatesModel);
    assertEquals(createPreferencesOptionsModel.accountNormal(), preferenceValueWithoutUpdatesModel);
    assertEquals(createPreferencesOptionsModel.billingAndUsageOrder(), preferenceValueWithoutUpdatesModel);
    assertEquals(createPreferencesOptionsModel.billingAndUsageInvoices(), preferenceValueWithoutUpdatesModel);
    assertEquals(createPreferencesOptionsModel.billingAndUsagePayments(), preferenceValueWithoutUpdatesModel);
    assertEquals(createPreferencesOptionsModel.billingAndUsageSubscriptionsAndPromoCodes(), preferenceValueWithoutUpdatesModel);
    assertEquals(createPreferencesOptionsModel.billingAndUsageSpendingAlerts(), preferenceValueWithoutUpdatesModel);
    assertEquals(createPreferencesOptionsModel.resourceactivityNormal(), preferenceValueWithoutUpdatesModel);
    assertEquals(createPreferencesOptionsModel.orderingReview(), preferenceValueWithoutUpdatesModel);
    assertEquals(createPreferencesOptionsModel.orderingApproved(), preferenceValueWithoutUpdatesModel);
    assertEquals(createPreferencesOptionsModel.orderingApprovedVsi(), preferenceValueWithoutUpdatesModel);
    assertEquals(createPreferencesOptionsModel.orderingApprovedServer(), preferenceValueWithoutUpdatesModel);
    assertEquals(createPreferencesOptionsModel.provisioningReloadComplete(), preferenceValueWithoutUpdatesModel);
    assertEquals(createPreferencesOptionsModel.provisioningCompleteVsi(), preferenceValueWithoutUpdatesModel);
    assertEquals(createPreferencesOptionsModel.provisioningCompleteServer(), preferenceValueWithoutUpdatesModel);
    assertEquals(createPreferencesOptionsModel.accountId(), "a1b2c3d4e5f6g7h8i9j0k1l2m3n4o5p6");
  }

  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testCreatePreferencesOptionsError() throws Throwable {
    new CreatePreferencesOptions.Builder().build();
  }

}