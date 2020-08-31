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

import com.ibm.cloud.platform_services.configuration_governance.v1.model.RuleScope;
import com.ibm.cloud.platform_services.configuration_governance.v1.utils.TestUtilities;
import com.ibm.cloud.sdk.core.service.model.FileWithMetadata;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import org.testng.annotations.Test;
import static org.testng.Assert.*;

/**
 * Unit test class for the RuleScope model.
 */
public class RuleScopeTest {
  final HashMap<String, InputStream> mockStreamMap = TestUtilities.createMockStreamMap();
  final List<FileWithMetadata> mockListFileWithMetadata = TestUtilities.creatMockListFileWithMetadata();

  @Test
  public void testRuleScope() throws Throwable {
    RuleScope ruleScopeModel = new RuleScope.Builder()
      .note("testString")
      .scopeId("testString")
      .scopeType("enterprise")
      .build();
    assertEquals(ruleScopeModel.note(), "testString");
    assertEquals(ruleScopeModel.scopeId(), "testString");
    assertEquals(ruleScopeModel.scopeType(), "enterprise");

    String json = TestUtilities.serialize(ruleScopeModel);

    RuleScope ruleScopeModelNew = TestUtilities.deserialize(json, RuleScope.class);
    assertTrue(ruleScopeModelNew instanceof RuleScope);
    assertEquals(ruleScopeModelNew.note(), "testString");
    assertEquals(ruleScopeModelNew.scopeId(), "testString");
    assertEquals(ruleScopeModelNew.scopeType(), "enterprise");
  }

  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testRuleScopeError() throws Throwable {
    new RuleScope.Builder().build();
  }

}