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

import com.ibm.cloud.platform_services.platform_notifications.v1.model.PreferenceValueWithUpdates;
import com.ibm.cloud.platform_services.platform_notifications.v1.model.PreferenceValueWithoutUpdates;
import com.ibm.cloud.platform_services.platform_notifications.v1.model.PreferencesObject;
import com.ibm.cloud.platform_services.platform_notifications.v1.utils.TestUtilities;
import com.ibm.cloud.sdk.core.service.model.FileWithMetadata;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import org.testng.annotations.Test;
import static org.testng.Assert.*;

/**
 * Unit test class for the PreferencesObject model.
 */
public class PreferencesObjectTest {
  final HashMap<String, InputStream> mockStreamMap = TestUtilities.createMockStreamMap();
  final List<FileWithMetadata> mockListFileWithMetadata = TestUtilities.creatMockListFileWithMetadata();

  @Test
  public void testPreferencesObject() throws Throwable {
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

    PreferencesObject preferencesObjectModel = new PreferencesObject.Builder()
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
      .build();
    assertEquals(preferencesObjectModel.incidentSeverity1(), preferenceValueWithUpdatesModel);
    assertEquals(preferencesObjectModel.incidentSeverity2(), preferenceValueWithUpdatesModel);
    assertEquals(preferencesObjectModel.incidentSeverity3(), preferenceValueWithUpdatesModel);
    assertEquals(preferencesObjectModel.incidentSeverity4(), preferenceValueWithUpdatesModel);
    assertEquals(preferencesObjectModel.maintenanceHigh(), preferenceValueWithUpdatesModel);
    assertEquals(preferencesObjectModel.maintenanceMedium(), preferenceValueWithUpdatesModel);
    assertEquals(preferencesObjectModel.maintenanceLow(), preferenceValueWithUpdatesModel);
    assertEquals(preferencesObjectModel.announcementsMajor(), preferenceValueWithoutUpdatesModel);
    assertEquals(preferencesObjectModel.announcementsMinor(), preferenceValueWithoutUpdatesModel);
    assertEquals(preferencesObjectModel.securityNormal(), preferenceValueWithoutUpdatesModel);
    assertEquals(preferencesObjectModel.accountNormal(), preferenceValueWithoutUpdatesModel);
    assertEquals(preferencesObjectModel.billingAndUsageOrder(), preferenceValueWithoutUpdatesModel);
    assertEquals(preferencesObjectModel.billingAndUsageInvoices(), preferenceValueWithoutUpdatesModel);
    assertEquals(preferencesObjectModel.billingAndUsagePayments(), preferenceValueWithoutUpdatesModel);
    assertEquals(preferencesObjectModel.billingAndUsageSubscriptionsAndPromoCodes(), preferenceValueWithoutUpdatesModel);
    assertEquals(preferencesObjectModel.billingAndUsageSpendingAlerts(), preferenceValueWithoutUpdatesModel);
    assertEquals(preferencesObjectModel.resourceactivityNormal(), preferenceValueWithoutUpdatesModel);
    assertEquals(preferencesObjectModel.orderingReview(), preferenceValueWithoutUpdatesModel);
    assertEquals(preferencesObjectModel.orderingApproved(), preferenceValueWithoutUpdatesModel);
    assertEquals(preferencesObjectModel.orderingApprovedVsi(), preferenceValueWithoutUpdatesModel);
    assertEquals(preferencesObjectModel.orderingApprovedServer(), preferenceValueWithoutUpdatesModel);
    assertEquals(preferencesObjectModel.provisioningReloadComplete(), preferenceValueWithoutUpdatesModel);
    assertEquals(preferencesObjectModel.provisioningCompleteVsi(), preferenceValueWithoutUpdatesModel);
    assertEquals(preferencesObjectModel.provisioningCompleteServer(), preferenceValueWithoutUpdatesModel);

    String json = TestUtilities.serialize(preferencesObjectModel);

    PreferencesObject preferencesObjectModelNew = TestUtilities.deserialize(json, PreferencesObject.class);
    assertTrue(preferencesObjectModelNew instanceof PreferencesObject);
    assertEquals(preferencesObjectModelNew.incidentSeverity1().toString(), preferenceValueWithUpdatesModel.toString());
    assertEquals(preferencesObjectModelNew.incidentSeverity2().toString(), preferenceValueWithUpdatesModel.toString());
    assertEquals(preferencesObjectModelNew.incidentSeverity3().toString(), preferenceValueWithUpdatesModel.toString());
    assertEquals(preferencesObjectModelNew.incidentSeverity4().toString(), preferenceValueWithUpdatesModel.toString());
    assertEquals(preferencesObjectModelNew.maintenanceHigh().toString(), preferenceValueWithUpdatesModel.toString());
    assertEquals(preferencesObjectModelNew.maintenanceMedium().toString(), preferenceValueWithUpdatesModel.toString());
    assertEquals(preferencesObjectModelNew.maintenanceLow().toString(), preferenceValueWithUpdatesModel.toString());
    assertEquals(preferencesObjectModelNew.announcementsMajor().toString(), preferenceValueWithoutUpdatesModel.toString());
    assertEquals(preferencesObjectModelNew.announcementsMinor().toString(), preferenceValueWithoutUpdatesModel.toString());
    assertEquals(preferencesObjectModelNew.securityNormal().toString(), preferenceValueWithoutUpdatesModel.toString());
    assertEquals(preferencesObjectModelNew.accountNormal().toString(), preferenceValueWithoutUpdatesModel.toString());
    assertEquals(preferencesObjectModelNew.billingAndUsageOrder().toString(), preferenceValueWithoutUpdatesModel.toString());
    assertEquals(preferencesObjectModelNew.billingAndUsageInvoices().toString(), preferenceValueWithoutUpdatesModel.toString());
    assertEquals(preferencesObjectModelNew.billingAndUsagePayments().toString(), preferenceValueWithoutUpdatesModel.toString());
    assertEquals(preferencesObjectModelNew.billingAndUsageSubscriptionsAndPromoCodes().toString(), preferenceValueWithoutUpdatesModel.toString());
    assertEquals(preferencesObjectModelNew.billingAndUsageSpendingAlerts().toString(), preferenceValueWithoutUpdatesModel.toString());
    assertEquals(preferencesObjectModelNew.resourceactivityNormal().toString(), preferenceValueWithoutUpdatesModel.toString());
    assertEquals(preferencesObjectModelNew.orderingReview().toString(), preferenceValueWithoutUpdatesModel.toString());
    assertEquals(preferencesObjectModelNew.orderingApproved().toString(), preferenceValueWithoutUpdatesModel.toString());
    assertEquals(preferencesObjectModelNew.orderingApprovedVsi().toString(), preferenceValueWithoutUpdatesModel.toString());
    assertEquals(preferencesObjectModelNew.orderingApprovedServer().toString(), preferenceValueWithoutUpdatesModel.toString());
    assertEquals(preferencesObjectModelNew.provisioningReloadComplete().toString(), preferenceValueWithoutUpdatesModel.toString());
    assertEquals(preferencesObjectModelNew.provisioningCompleteVsi().toString(), preferenceValueWithoutUpdatesModel.toString());
    assertEquals(preferencesObjectModelNew.provisioningCompleteServer().toString(), preferenceValueWithoutUpdatesModel.toString());
  }
}