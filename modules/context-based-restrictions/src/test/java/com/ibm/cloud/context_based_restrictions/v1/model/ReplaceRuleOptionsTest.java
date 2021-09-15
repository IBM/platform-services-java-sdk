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

package com.ibm.cloud.context_based_restrictions.v1.model;

import com.ibm.cloud.context_based_restrictions.v1.model.ReplaceRuleOptions;
import com.ibm.cloud.context_based_restrictions.v1.model.Resource;
import com.ibm.cloud.context_based_restrictions.v1.model.ResourceAttribute;
import com.ibm.cloud.context_based_restrictions.v1.model.ResourceTagAttribute;
import com.ibm.cloud.context_based_restrictions.v1.model.RuleContext;
import com.ibm.cloud.context_based_restrictions.v1.model.RuleContextAttribute;
import com.ibm.cloud.context_based_restrictions.v1.utils.TestUtilities;
import com.ibm.cloud.sdk.core.service.model.FileWithMetadata;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import org.testng.annotations.Test;
import static org.testng.Assert.*;

/**
 * Unit test class for the ReplaceRuleOptions model.
 */
public class ReplaceRuleOptionsTest {
  final HashMap<String, InputStream> mockStreamMap = TestUtilities.createMockStreamMap();
  final List<FileWithMetadata> mockListFileWithMetadata = TestUtilities.creatMockListFileWithMetadata();

  @Test
  public void testReplaceRuleOptions() throws Throwable {
    RuleContextAttribute ruleContextAttributeModel = new RuleContextAttribute.Builder()
      .name("testString")
      .value("testString")
      .build();
    assertEquals(ruleContextAttributeModel.name(), "testString");
    assertEquals(ruleContextAttributeModel.value(), "testString");

    RuleContext ruleContextModel = new RuleContext.Builder()
      .attributes(new java.util.ArrayList<RuleContextAttribute>(java.util.Arrays.asList(ruleContextAttributeModel)))
      .build();
    assertEquals(ruleContextModel.attributes(), new java.util.ArrayList<RuleContextAttribute>(java.util.Arrays.asList(ruleContextAttributeModel)));

    ResourceAttribute resourceAttributeModel = new ResourceAttribute.Builder()
      .name("testString")
      .value("testString")
      .operator("testString")
      .build();
    assertEquals(resourceAttributeModel.name(), "testString");
    assertEquals(resourceAttributeModel.value(), "testString");
    assertEquals(resourceAttributeModel.operator(), "testString");

    ResourceTagAttribute resourceTagAttributeModel = new ResourceTagAttribute.Builder()
      .name("testString")
      .value("testString")
      .operator("testString")
      .build();
    assertEquals(resourceTagAttributeModel.name(), "testString");
    assertEquals(resourceTagAttributeModel.value(), "testString");
    assertEquals(resourceTagAttributeModel.operator(), "testString");

    Resource resourceModel = new Resource.Builder()
      .attributes(new java.util.ArrayList<ResourceAttribute>(java.util.Arrays.asList(resourceAttributeModel)))
      .tags(new java.util.ArrayList<ResourceTagAttribute>(java.util.Arrays.asList(resourceTagAttributeModel)))
      .build();
    assertEquals(resourceModel.attributes(), new java.util.ArrayList<ResourceAttribute>(java.util.Arrays.asList(resourceAttributeModel)));
    assertEquals(resourceModel.tags(), new java.util.ArrayList<ResourceTagAttribute>(java.util.Arrays.asList(resourceTagAttributeModel)));

    ReplaceRuleOptions replaceRuleOptionsModel = new ReplaceRuleOptions.Builder()
      .ruleId("testString")
      .ifMatch("testString")
      .description("testString")
      .contexts(new java.util.ArrayList<RuleContext>(java.util.Arrays.asList(ruleContextModel)))
      .resources(new java.util.ArrayList<Resource>(java.util.Arrays.asList(resourceModel)))
      .transactionId("testString")
      .build();
    assertEquals(replaceRuleOptionsModel.ruleId(), "testString");
    assertEquals(replaceRuleOptionsModel.ifMatch(), "testString");
    assertEquals(replaceRuleOptionsModel.description(), "testString");
    assertEquals(replaceRuleOptionsModel.contexts(), new java.util.ArrayList<RuleContext>(java.util.Arrays.asList(ruleContextModel)));
    assertEquals(replaceRuleOptionsModel.resources(), new java.util.ArrayList<Resource>(java.util.Arrays.asList(resourceModel)));
    assertEquals(replaceRuleOptionsModel.transactionId(), "testString");
  }

  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testReplaceRuleOptionsError() throws Throwable {
    new ReplaceRuleOptions.Builder().build();
  }

}