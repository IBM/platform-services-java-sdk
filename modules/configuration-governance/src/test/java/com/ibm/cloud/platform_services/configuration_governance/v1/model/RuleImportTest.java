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

package com.ibm.cloud.platform_services.configuration_governance.v1.model;

import com.ibm.cloud.platform_services.configuration_governance.v1.model.RuleImport;
import com.ibm.cloud.platform_services.configuration_governance.v1.model.UISupport;
import com.ibm.cloud.platform_services.configuration_governance.v1.utils.TestUtilities;
import com.ibm.cloud.sdk.core.service.model.FileWithMetadata;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import org.testng.annotations.Test;
import static org.testng.Assert.*;

/**
 * Unit test class for the RuleImport model.
 */
public class RuleImportTest {
  final HashMap<String, InputStream> mockStreamMap = TestUtilities.createMockStreamMap();
  final List<FileWithMetadata> mockListFileWithMetadata = TestUtilities.creatMockListFileWithMetadata();

  @Test
  public void testRuleImport() throws Throwable {
    UISupport uiSupportModel = new UISupport.Builder()
      .displayName("testString")
      .description("testString")
      .build();
    assertEquals(uiSupportModel.displayName(), "testString");
    assertEquals(uiSupportModel.description(), "testString");

    RuleImport ruleImportModel = new RuleImport.Builder()
      .name("testString")
      .uiSupport(uiSupportModel)
      .build();
    assertEquals(ruleImportModel.name(), "testString");
    assertEquals(ruleImportModel.uiSupport(), uiSupportModel);

    String json = TestUtilities.serialize(ruleImportModel);

    RuleImport ruleImportModelNew = TestUtilities.deserialize(json, RuleImport.class);
    assertTrue(ruleImportModelNew instanceof RuleImport);
    assertEquals(ruleImportModelNew.name(), "testString");
    assertEquals(ruleImportModelNew.uiSupport().toString(), uiSupportModel.toString());
  }

  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testRuleImportError() throws Throwable {
    new RuleImport.Builder().build();
  }

}