/*
 * (C) Copyright IBM Corp. 2023.
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

import com.ibm.cloud.platform_services.iam_access_groups.v2.model.ListTemplateVersionsOptions;
import com.ibm.cloud.platform_services.iam_access_groups.v2.utils.TestUtilities;
import com.ibm.cloud.sdk.core.service.model.FileWithMetadata;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import org.testng.annotations.Test;
import static org.testng.Assert.*;

/**
 * Unit test class for the ListTemplateVersionsOptions model.
 */
public class ListTemplateVersionsOptionsTest {
  final HashMap<String, InputStream> mockStreamMap = TestUtilities.createMockStreamMap();
  final List<FileWithMetadata> mockListFileWithMetadata = TestUtilities.creatMockListFileWithMetadata();

  @Test
  public void testListTemplateVersionsOptions() throws Throwable {
    ListTemplateVersionsOptions listTemplateVersionsOptionsModel = new ListTemplateVersionsOptions.Builder()
      .templateId("testString")
      .limit(Long.valueOf("100"))
      .offset(Long.valueOf("0"))
      .build();
    assertEquals(listTemplateVersionsOptionsModel.templateId(), "testString");
    assertEquals(listTemplateVersionsOptionsModel.limit(), Long.valueOf("100"));
    assertEquals(listTemplateVersionsOptionsModel.offset(), Long.valueOf("0"));
  }

  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testListTemplateVersionsOptionsError() throws Throwable {
    new ListTemplateVersionsOptions.Builder().build();
  }

}