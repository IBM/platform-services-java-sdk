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

package com.ibm.cloud.platform_services.context_based_restrictions.v1.model;

import com.ibm.cloud.platform_services.context_based_restrictions.v1.model.NewRuleOperations;
import com.ibm.cloud.platform_services.context_based_restrictions.v1.model.NewRuleOperationsApiTypesItem;
import com.ibm.cloud.platform_services.context_based_restrictions.v1.utils.TestUtilities;
import com.ibm.cloud.sdk.core.service.model.FileWithMetadata;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import org.testng.annotations.Test;
import static org.testng.Assert.*;

/**
 * Unit test class for the NewRuleOperations model.
 */
public class NewRuleOperationsTest {
  final HashMap<String, InputStream> mockStreamMap = TestUtilities.createMockStreamMap();
  final List<FileWithMetadata> mockListFileWithMetadata = TestUtilities.creatMockListFileWithMetadata();

  @Test
  public void testNewRuleOperations() throws Throwable {
    NewRuleOperationsApiTypesItem newRuleOperationsApiTypesItemModel = new NewRuleOperationsApiTypesItem.Builder()
      .apiTypeId("testString")
      .build();
    assertEquals(newRuleOperationsApiTypesItemModel.apiTypeId(), "testString");

    NewRuleOperations newRuleOperationsModel = new NewRuleOperations.Builder()
      .apiTypes(java.util.Arrays.asList(newRuleOperationsApiTypesItemModel))
      .build();
    assertEquals(newRuleOperationsModel.apiTypes(), java.util.Arrays.asList(newRuleOperationsApiTypesItemModel));

    String json = TestUtilities.serialize(newRuleOperationsModel);

    NewRuleOperations newRuleOperationsModelNew = TestUtilities.deserialize(json, NewRuleOperations.class);
    assertTrue(newRuleOperationsModelNew instanceof NewRuleOperations);
  }

  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testNewRuleOperationsError() throws Throwable {
    new NewRuleOperations.Builder().build();
  }

}