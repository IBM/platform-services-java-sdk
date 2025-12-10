/*
 * (C) Copyright IBM Corp. 2025.
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

package com.ibm.cloud.platform_services.iam_policy_management.v1.model;

import com.ibm.cloud.platform_services.iam_policy_management.v1.model.TemplateActionControl;
import com.ibm.cloud.platform_services.iam_policy_management.v1.utils.TestUtilities;
import com.ibm.cloud.sdk.core.service.model.FileWithMetadata;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import org.testng.annotations.Test;
import static org.testng.Assert.*;

/**
 * Unit test class for the TemplateActionControl model.
 */
public class TemplateActionControlTest {
  final HashMap<String, InputStream> mockStreamMap = TestUtilities.createMockStreamMap();
  final List<FileWithMetadata> mockListFileWithMetadata = TestUtilities.creatMockListFileWithMetadata();

  @Test
  public void testTemplateActionControl() throws Throwable {
    TemplateActionControl templateActionControlModel = new TemplateActionControl.Builder()
      .serviceName("testString")
      .description("testString")
      .actions(java.util.Arrays.asList("testString"))
      .build();
    assertEquals(templateActionControlModel.serviceName(), "testString");
    assertEquals(templateActionControlModel.description(), "testString");
    assertEquals(templateActionControlModel.actions(), java.util.Arrays.asList("testString"));

    String json = TestUtilities.serialize(templateActionControlModel);

    TemplateActionControl templateActionControlModelNew = TestUtilities.deserialize(json, TemplateActionControl.class);
    assertTrue(templateActionControlModelNew instanceof TemplateActionControl);
    assertEquals(templateActionControlModelNew.serviceName(), "testString");
    assertEquals(templateActionControlModelNew.description(), "testString");
  }

  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testTemplateActionControlError() throws Throwable {
    new TemplateActionControl.Builder().build();
  }

}