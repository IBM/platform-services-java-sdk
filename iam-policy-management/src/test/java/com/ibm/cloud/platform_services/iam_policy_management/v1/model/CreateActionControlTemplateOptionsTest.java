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

import com.ibm.cloud.platform_services.iam_policy_management.v1.model.CreateActionControlTemplateOptions;
import com.ibm.cloud.platform_services.iam_policy_management.v1.model.TemplateActionControl;
import com.ibm.cloud.platform_services.iam_policy_management.v1.utils.TestUtilities;
import com.ibm.cloud.sdk.core.service.model.FileWithMetadata;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import org.testng.annotations.Test;
import static org.testng.Assert.*;

/**
 * Unit test class for the CreateActionControlTemplateOptions model.
 */
public class CreateActionControlTemplateOptionsTest {
  final HashMap<String, InputStream> mockStreamMap = TestUtilities.createMockStreamMap();
  final List<FileWithMetadata> mockListFileWithMetadata = TestUtilities.creatMockListFileWithMetadata();

  @Test
  public void testCreateActionControlTemplateOptions() throws Throwable {
    TemplateActionControl templateActionControlModel = new TemplateActionControl.Builder()
      .serviceName("testString")
      .description("testString")
      .actions(java.util.Arrays.asList("testString"))
      .build();
    assertEquals(templateActionControlModel.serviceName(), "testString");
    assertEquals(templateActionControlModel.description(), "testString");
    assertEquals(templateActionControlModel.actions(), java.util.Arrays.asList("testString"));

    CreateActionControlTemplateOptions createActionControlTemplateOptionsModel = new CreateActionControlTemplateOptions.Builder()
      .name("testString")
      .accountId("testString")
      .description("testString")
      .committed(true)
      .actionControl(templateActionControlModel)
      .acceptLanguage("default")
      .build();
    assertEquals(createActionControlTemplateOptionsModel.name(), "testString");
    assertEquals(createActionControlTemplateOptionsModel.accountId(), "testString");
    assertEquals(createActionControlTemplateOptionsModel.description(), "testString");
    assertEquals(createActionControlTemplateOptionsModel.committed(), Boolean.valueOf(true));
    assertEquals(createActionControlTemplateOptionsModel.actionControl(), templateActionControlModel);
    assertEquals(createActionControlTemplateOptionsModel.acceptLanguage(), "default");
  }

  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testCreateActionControlTemplateOptionsError() throws Throwable {
    new CreateActionControlTemplateOptions.Builder().build();
  }

}