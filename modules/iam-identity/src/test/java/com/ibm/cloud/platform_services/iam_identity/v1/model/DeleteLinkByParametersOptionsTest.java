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

package com.ibm.cloud.platform_services.iam_identity.v1.model;

import com.ibm.cloud.platform_services.iam_identity.v1.model.DeleteLinkByParametersOptions;
import com.ibm.cloud.platform_services.iam_identity.v1.utils.TestUtilities;
import com.ibm.cloud.sdk.core.service.model.FileWithMetadata;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import org.testng.annotations.Test;
import static org.testng.Assert.*;

/**
 * Unit test class for the DeleteLinkByParametersOptions model.
 */
public class DeleteLinkByParametersOptionsTest {
  final HashMap<String, InputStream> mockStreamMap = TestUtilities.createMockStreamMap();
  final List<FileWithMetadata> mockListFileWithMetadata = TestUtilities.creatMockListFileWithMetadata();

  @Test
  public void testDeleteLinkByParametersOptions() throws Throwable {
    DeleteLinkByParametersOptions deleteLinkByParametersOptionsModel = new DeleteLinkByParametersOptions.Builder()
      .profileId("testString")
      .type("testString")
      .crn("testString")
      .namespace("testString")
      .name("testString")
      .componentType("testString")
      .componentName("testString")
      .build();
    assertEquals(deleteLinkByParametersOptionsModel.profileId(), "testString");
    assertEquals(deleteLinkByParametersOptionsModel.type(), "testString");
    assertEquals(deleteLinkByParametersOptionsModel.crn(), "testString");
    assertEquals(deleteLinkByParametersOptionsModel.namespace(), "testString");
    assertEquals(deleteLinkByParametersOptionsModel.name(), "testString");
    assertEquals(deleteLinkByParametersOptionsModel.componentType(), "testString");
    assertEquals(deleteLinkByParametersOptionsModel.componentName(), "testString");
  }

  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testDeleteLinkByParametersOptionsError() throws Throwable {
    new DeleteLinkByParametersOptions.Builder().build();
  }

}