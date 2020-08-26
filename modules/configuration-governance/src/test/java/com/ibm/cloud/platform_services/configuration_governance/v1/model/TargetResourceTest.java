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

import com.ibm.cloud.platform_services.configuration_governance.v1.model.RuleTargetAttribute;
import com.ibm.cloud.platform_services.configuration_governance.v1.model.TargetResource;
import com.ibm.cloud.platform_services.configuration_governance.v1.utils.TestUtilities;
import com.ibm.cloud.sdk.core.service.model.FileWithMetadata;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import org.testng.annotations.Test;
import static org.testng.Assert.*;

/**
 * Unit test class for the TargetResource model.
 */
public class TargetResourceTest {
  final HashMap<String, InputStream> mockStreamMap = TestUtilities.createMockStreamMap();
  final List<FileWithMetadata> mockListFileWithMetadata = TestUtilities.creatMockListFileWithMetadata();

  @Test
  public void testTargetResource() throws Throwable {
    RuleTargetAttribute ruleTargetAttributeModel = new RuleTargetAttribute.Builder()
      .name("resource_id")
      .operator("string_equals")
      .value("f0f8f7994e754ff38f9d370201966561")
      .build();
    assertEquals(ruleTargetAttributeModel.name(), "resource_id");
    assertEquals(ruleTargetAttributeModel.operator(), "string_equals");
    assertEquals(ruleTargetAttributeModel.value(), "f0f8f7994e754ff38f9d370201966561");

    TargetResource targetResourceModel = new TargetResource.Builder()
      .serviceName("iam-groups")
      .resourceKind("zone")
      .additionalTargetAttributes(new java.util.ArrayList<RuleTargetAttribute>(java.util.Arrays.asList(ruleTargetAttributeModel)))
      .build();
    assertEquals(targetResourceModel.serviceName(), "iam-groups");
    assertEquals(targetResourceModel.resourceKind(), "zone");
    assertEquals(targetResourceModel.additionalTargetAttributes(), new java.util.ArrayList<RuleTargetAttribute>(java.util.Arrays.asList(ruleTargetAttributeModel)));

    String json = TestUtilities.serialize(targetResourceModel);

    TargetResource targetResourceModelNew = TestUtilities.deserialize(json, TargetResource.class);
    assertTrue(targetResourceModelNew instanceof TargetResource);
    assertEquals(targetResourceModelNew.serviceName(), "iam-groups");
    assertEquals(targetResourceModelNew.resourceKind(), "zone");
  }

  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testTargetResourceError() throws Throwable {
    new TargetResource.Builder().build();
  }

}