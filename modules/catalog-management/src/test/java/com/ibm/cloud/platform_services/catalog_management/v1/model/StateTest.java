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

package com.ibm.cloud.platform_services.catalog_management.v1.model;

import com.ibm.cloud.platform_services.catalog_management.v1.model.State;
import com.ibm.cloud.platform_services.catalog_management.v1.utils.TestUtilities;

import com.ibm.cloud.sdk.core.service.model.FileWithMetadata;
import java.io.InputStream;

import java.util.HashMap;
import java.util.List;

import org.testng.annotations.Test;
import static org.testng.Assert.*;

/**
 * Unit test class for the State model.
 */
public class StateTest {
  final HashMap<String, InputStream> mockStreamMap = TestUtilities.createMockStreamMap();
  final List<FileWithMetadata> mockListFileWithMetadata = TestUtilities.creatMockListFileWithMetadata();

  @Test
  public void testState() throws Throwable {
    State stateModel = new State.Builder()
      .current("testString")
      .currentEntered(TestUtilities.createMockDateTime("2019-01-01T12:00:00"))
      .pending("testString")
      .pendingRequested(TestUtilities.createMockDateTime("2019-01-01T12:00:00"))
      .previous("testString")
      .build();
    assertEquals(stateModel.current(), "testString");
    assertEquals(stateModel.currentEntered(), TestUtilities.createMockDateTime("2019-01-01T12:00:00"));
    assertEquals(stateModel.pending(), "testString");
    assertEquals(stateModel.pendingRequested(), TestUtilities.createMockDateTime("2019-01-01T12:00:00"));
    assertEquals(stateModel.previous(), "testString");

    String json = TestUtilities.serialize(stateModel);

    State stateModelNew = TestUtilities.deserialize(json, State.class);
    assertTrue(stateModelNew instanceof State);
    assertEquals(stateModelNew.current(), "testString");
    assertEquals(stateModelNew.currentEntered().toString(), TestUtilities.createMockDateTime("2019-01-01T12:00:00").toString());
    assertEquals(stateModelNew.pending(), "testString");
    assertEquals(stateModelNew.pendingRequested().toString(), TestUtilities.createMockDateTime("2019-01-01T12:00:00").toString());
    assertEquals(stateModelNew.previous(), "testString");
  }
}