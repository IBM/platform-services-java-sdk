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

package com.ibm.cloud.platform_services.iam_access_groups.v2.model;

import com.ibm.cloud.platform_services.iam_access_groups.v2.model.ReplaceAccessGroupRuleOptions;
import com.ibm.cloud.platform_services.iam_access_groups.v2.model.RuleConditions;
import com.ibm.cloud.platform_services.iam_access_groups.v2.utils.TestUtilities;
import com.ibm.cloud.sdk.core.service.model.FileWithMetadata;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import org.testng.annotations.Test;
import static org.testng.Assert.*;

/**
 * Unit test class for the ReplaceAccessGroupRuleOptions model.
 */
public class ReplaceAccessGroupRuleOptionsTest {
  final HashMap<String, InputStream> mockStreamMap = TestUtilities.createMockStreamMap();
  final List<FileWithMetadata> mockListFileWithMetadata = TestUtilities.creatMockListFileWithMetadata();

  @Test
  public void testReplaceAccessGroupRuleOptions() throws Throwable {
    RuleConditions ruleConditionsModel = new RuleConditions.Builder()
      .claim("testString")
      .operator("testString")
      .value("testString")
      .build();
    assertEquals(ruleConditionsModel.claim(), "testString");
    assertEquals(ruleConditionsModel.operator(), "testString");
    assertEquals(ruleConditionsModel.value(), "testString");

    ReplaceAccessGroupRuleOptions replaceAccessGroupRuleOptionsModel = new ReplaceAccessGroupRuleOptions.Builder()
      .accessGroupId("testString")
      .ruleId("testString")
      .ifMatch("testString")
      .expiration(Long.valueOf("26"))
      .realmName("testString")
      .conditions(new java.util.ArrayList<RuleConditions>(java.util.Arrays.asList(ruleConditionsModel)))
      .name("testString")
      .transactionId("testString")
      .build();
    assertEquals(replaceAccessGroupRuleOptionsModel.accessGroupId(), "testString");
    assertEquals(replaceAccessGroupRuleOptionsModel.ruleId(), "testString");
    assertEquals(replaceAccessGroupRuleOptionsModel.ifMatch(), "testString");
    assertEquals(replaceAccessGroupRuleOptionsModel.expiration(), Long.valueOf("26"));
    assertEquals(replaceAccessGroupRuleOptionsModel.realmName(), "testString");
    assertEquals(replaceAccessGroupRuleOptionsModel.conditions(), new java.util.ArrayList<RuleConditions>(java.util.Arrays.asList(ruleConditionsModel)));
    assertEquals(replaceAccessGroupRuleOptionsModel.name(), "testString");
    assertEquals(replaceAccessGroupRuleOptionsModel.transactionId(), "testString");
  }

  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testReplaceAccessGroupRuleOptionsError() throws Throwable {
    new ReplaceAccessGroupRuleOptions.Builder().build();
  }

}