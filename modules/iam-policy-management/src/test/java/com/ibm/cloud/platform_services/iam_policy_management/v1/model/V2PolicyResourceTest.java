/*
 * (C) Copyright IBM Corp. 2024.
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

import com.ibm.cloud.platform_services.iam_policy_management.v1.model.V2PolicyResource;
import com.ibm.cloud.platform_services.iam_policy_management.v1.model.V2PolicyResourceAttribute;
import com.ibm.cloud.platform_services.iam_policy_management.v1.model.V2PolicyResourceTag;
import com.ibm.cloud.platform_services.iam_policy_management.v1.utils.TestUtilities;
import com.ibm.cloud.sdk.core.service.model.FileWithMetadata;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import org.testng.annotations.Test;
import static org.testng.Assert.*;

/**
 * Unit test class for the V2PolicyResource model.
 */
public class V2PolicyResourceTest {
  final HashMap<String, InputStream> mockStreamMap = TestUtilities.createMockStreamMap();
  final List<FileWithMetadata> mockListFileWithMetadata = TestUtilities.creatMockListFileWithMetadata();

  @Test
  public void testV2PolicyResource() throws Throwable {
    V2PolicyResourceAttribute v2PolicyResourceAttributeModel = new V2PolicyResourceAttribute.Builder()
      .key("testString")
      .operator("stringEquals")
      .value("testString")
      .build();
    assertEquals(v2PolicyResourceAttributeModel.key(), "testString");
    assertEquals(v2PolicyResourceAttributeModel.operator(), "stringEquals");
    assertEquals(v2PolicyResourceAttributeModel.value(), "testString");

    V2PolicyResourceTag v2PolicyResourceTagModel = new V2PolicyResourceTag.Builder()
      .key("testString")
      .value("testString")
      .operator("stringEquals")
      .build();
    assertEquals(v2PolicyResourceTagModel.key(), "testString");
    assertEquals(v2PolicyResourceTagModel.value(), "testString");
    assertEquals(v2PolicyResourceTagModel.operator(), "stringEquals");

    V2PolicyResource v2PolicyResourceModel = new V2PolicyResource.Builder()
      .attributes(java.util.Arrays.asList(v2PolicyResourceAttributeModel))
      .tags(java.util.Arrays.asList(v2PolicyResourceTagModel))
      .build();
    assertEquals(v2PolicyResourceModel.attributes(), java.util.Arrays.asList(v2PolicyResourceAttributeModel));
    assertEquals(v2PolicyResourceModel.tags(), java.util.Arrays.asList(v2PolicyResourceTagModel));

    String json = TestUtilities.serialize(v2PolicyResourceModel);

    V2PolicyResource v2PolicyResourceModelNew = TestUtilities.deserialize(json, V2PolicyResource.class);
    assertTrue(v2PolicyResourceModelNew instanceof V2PolicyResource);
  }

  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testV2PolicyResourceError() throws Throwable {
    new V2PolicyResource.Builder().build();
  }

}