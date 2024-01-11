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

import com.ibm.cloud.platform_services.iam_policy_management.v1.model.V2PolicySubject;
import com.ibm.cloud.platform_services.iam_policy_management.v1.model.V2PolicySubjectAttribute;
import com.ibm.cloud.platform_services.iam_policy_management.v1.utils.TestUtilities;
import com.ibm.cloud.sdk.core.service.model.FileWithMetadata;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import org.testng.annotations.Test;
import static org.testng.Assert.*;

/**
 * Unit test class for the V2PolicySubject model.
 */
public class V2PolicySubjectTest {
  final HashMap<String, InputStream> mockStreamMap = TestUtilities.createMockStreamMap();
  final List<FileWithMetadata> mockListFileWithMetadata = TestUtilities.creatMockListFileWithMetadata();

  @Test
  public void testV2PolicySubject() throws Throwable {
    V2PolicySubjectAttribute v2PolicySubjectAttributeModel = new V2PolicySubjectAttribute.Builder()
      .key("testString")
      .operator("stringEquals")
      .value("testString")
      .build();
    assertEquals(v2PolicySubjectAttributeModel.key(), "testString");
    assertEquals(v2PolicySubjectAttributeModel.operator(), "stringEquals");
    assertEquals(v2PolicySubjectAttributeModel.value(), "testString");

    V2PolicySubject v2PolicySubjectModel = new V2PolicySubject.Builder()
      .attributes(java.util.Arrays.asList(v2PolicySubjectAttributeModel))
      .build();
    assertEquals(v2PolicySubjectModel.attributes(), java.util.Arrays.asList(v2PolicySubjectAttributeModel));

    String json = TestUtilities.serialize(v2PolicySubjectModel);

    V2PolicySubject v2PolicySubjectModelNew = TestUtilities.deserialize(json, V2PolicySubject.class);
    assertTrue(v2PolicySubjectModelNew instanceof V2PolicySubject);
  }

  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testV2PolicySubjectError() throws Throwable {
    new V2PolicySubject.Builder().build();
  }

}