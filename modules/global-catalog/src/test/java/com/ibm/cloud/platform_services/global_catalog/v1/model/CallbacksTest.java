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

package com.ibm.cloud.platform_services.global_catalog.v1.model;

import com.ibm.cloud.platform_services.global_catalog.v1.model.Callbacks;
import com.ibm.cloud.platform_services.global_catalog.v1.utils.TestUtilities;

import com.ibm.cloud.sdk.core.service.model.FileWithMetadata;
import java.io.InputStream;

import java.util.HashMap;
import java.util.List;

import org.testng.annotations.Test;
import static org.testng.Assert.*;

/**
 * Unit test class for the Callbacks model.
 */
public class CallbacksTest {
  final HashMap<String, InputStream> mockStreamMap = TestUtilities.createMockStreamMap();
  final List<FileWithMetadata> mockListFileWithMetadata = TestUtilities.creatMockListFileWithMetadata();

  @Test
  public void testCallbacks() throws Throwable {
    Callbacks callbacksModel = new Callbacks.Builder()
      .brokerUtl("testString")
      .brokerProxyUrl("testString")
      .dashboardUrl("testString")
      .dashboardDataUrl("testString")
      .dashboardDetailTabUrl("testString")
      .dashboardDetailTabExtUrl("testString")
      .serviceMonitorApi("testString")
      .serviceMonitorApp("testString")
      .serviceStagingUrl("testString")
      .serviceProductionUrl("testString")
      .build();
    assertEquals(callbacksModel.brokerUtl(), "testString");
    assertEquals(callbacksModel.brokerProxyUrl(), "testString");
    assertEquals(callbacksModel.dashboardUrl(), "testString");
    assertEquals(callbacksModel.dashboardDataUrl(), "testString");
    assertEquals(callbacksModel.dashboardDetailTabUrl(), "testString");
    assertEquals(callbacksModel.dashboardDetailTabExtUrl(), "testString");
    assertEquals(callbacksModel.serviceMonitorApi(), "testString");
    assertEquals(callbacksModel.serviceMonitorApp(), "testString");
    assertEquals(callbacksModel.serviceStagingUrl(), "testString");
    assertEquals(callbacksModel.serviceProductionUrl(), "testString");

    String json = TestUtilities.serialize(callbacksModel);

    Callbacks callbacksModelNew = TestUtilities.deserialize(json, Callbacks.class);
    assertTrue(callbacksModelNew instanceof Callbacks);
    assertEquals(callbacksModelNew.brokerUtl(), "testString");
    assertEquals(callbacksModelNew.brokerProxyUrl(), "testString");
    assertEquals(callbacksModelNew.dashboardUrl(), "testString");
    assertEquals(callbacksModelNew.dashboardDataUrl(), "testString");
    assertEquals(callbacksModelNew.dashboardDetailTabUrl(), "testString");
    assertEquals(callbacksModelNew.dashboardDetailTabExtUrl(), "testString");
    assertEquals(callbacksModelNew.serviceMonitorApi(), "testString");
    assertEquals(callbacksModelNew.serviceMonitorApp(), "testString");
    assertEquals(callbacksModelNew.serviceStagingUrl(), "testString");
    assertEquals(callbacksModelNew.serviceProductionUrl(), "testString");
  }
}