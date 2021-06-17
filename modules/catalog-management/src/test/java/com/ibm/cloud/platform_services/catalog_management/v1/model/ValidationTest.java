/*
 * (C) Copyright IBM Corp. 2021.
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

import com.ibm.cloud.platform_services.catalog_management.v1.model.Validation;
import com.ibm.cloud.platform_services.catalog_management.v1.utils.TestUtilities;
import com.ibm.cloud.sdk.core.service.model.FileWithMetadata;
import com.ibm.cloud.sdk.core.util.DateUtils;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import org.testng.annotations.Test;
import static org.testng.Assert.*;

/**
 * Unit test class for the Validation model.
 */
public class ValidationTest {
  final HashMap<String, InputStream> mockStreamMap = TestUtilities.createMockStreamMap();
  final List<FileWithMetadata> mockListFileWithMetadata = TestUtilities.creatMockListFileWithMetadata();

  @Test
  public void testValidation() throws Throwable {
    Validation validationModel = new Validation.Builder()
      .validated(DateUtils.parseAsDateTime("2019-01-01T12:00:00.000Z"))
      .requested(DateUtils.parseAsDateTime("2019-01-01T12:00:00.000Z"))
      .state("testString")
      .lastOperation("testString")
      .target(new java.util.HashMap<String, Object>() { { put("foo", "testString"); } })
      .build();
    assertEquals(validationModel.validated(), DateUtils.parseAsDateTime("2019-01-01T12:00:00.000Z"));
    assertEquals(validationModel.requested(), DateUtils.parseAsDateTime("2019-01-01T12:00:00.000Z"));
    assertEquals(validationModel.state(), "testString");
    assertEquals(validationModel.lastOperation(), "testString");
    assertEquals(validationModel.target(), new java.util.HashMap<String, Object>() { { put("foo", "testString"); } });

    String json = TestUtilities.serialize(validationModel);

    Validation validationModelNew = TestUtilities.deserialize(json, Validation.class);
    assertTrue(validationModelNew instanceof Validation);
    assertEquals(validationModelNew.validated(), DateUtils.parseAsDateTime("2019-01-01T12:00:00.000Z"));
    assertEquals(validationModelNew.requested(), DateUtils.parseAsDateTime("2019-01-01T12:00:00.000Z"));
    assertEquals(validationModelNew.state(), "testString");
    assertEquals(validationModelNew.lastOperation(), "testString");
  }
}