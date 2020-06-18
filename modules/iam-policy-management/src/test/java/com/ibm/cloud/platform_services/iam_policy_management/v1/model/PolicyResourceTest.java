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

package com.ibm.cloud.platform_services.iam_policy_management.v1.model;

import com.ibm.cloud.platform_services.iam_policy_management.v1.model.PolicyResource;
import com.ibm.cloud.platform_services.iam_policy_management.v1.model.ResourceAttribute;
import com.ibm.cloud.platform_services.iam_policy_management.v1.utils.TestUtilities;

import com.ibm.cloud.sdk.core.service.model.FileWithMetadata;
import java.io.InputStream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import org.testng.annotations.Test;
import static org.testng.Assert.*;

/**
 * Unit test class for the PolicyResource model.
 */
public class PolicyResourceTest {
  final HashMap<String, InputStream> mockStreamMap = TestUtilities.createMockStreamMap();
  final List<FileWithMetadata> mockListFileWithMetadata = TestUtilities.creatMockListFileWithMetadata();

  @Test
  public void testPolicyResource() throws Throwable {
    ResourceAttribute resourceAttributeModel = new ResourceAttribute.Builder()
      .name("testString")
      .value("testString")
      .operator("testString")
      .build();
    assertEquals(resourceAttributeModel.name(), "testString");
    assertEquals(resourceAttributeModel.value(), "testString");
    assertEquals(resourceAttributeModel.operator(), "testString");

    PolicyResource policyResourceModel = new PolicyResource.Builder()
      .attributes(new java.util.ArrayList<ResourceAttribute>(java.util.Arrays.asList(resourceAttributeModel)))
      .build();
    assertEquals(policyResourceModel.attributes(), new java.util.ArrayList<ResourceAttribute>(java.util.Arrays.asList(resourceAttributeModel)));

    String json = TestUtilities.serialize(policyResourceModel);

    PolicyResource policyResourceModelNew = TestUtilities.deserialize(json, PolicyResource.class);
    assertTrue(policyResourceModelNew instanceof PolicyResource);
  }
}