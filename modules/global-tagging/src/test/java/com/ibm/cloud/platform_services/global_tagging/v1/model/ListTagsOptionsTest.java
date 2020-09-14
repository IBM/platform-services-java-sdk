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

package com.ibm.cloud.platform_services.global_tagging.v1.model;

import com.ibm.cloud.platform_services.global_tagging.v1.model.ListTagsOptions;
import com.ibm.cloud.platform_services.global_tagging.v1.utils.TestUtilities;
import com.ibm.cloud.sdk.core.service.model.FileWithMetadata;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import org.testng.annotations.Test;
import static org.testng.Assert.*;

/**
 * Unit test class for the ListTagsOptions model.
 */
public class ListTagsOptionsTest {
  final HashMap<String, InputStream> mockStreamMap = TestUtilities.createMockStreamMap();
  final List<FileWithMetadata> mockListFileWithMetadata = TestUtilities.creatMockListFileWithMetadata();

  @Test
  public void testListTagsOptions() throws Throwable {
    ListTagsOptions listTagsOptionsModel = new ListTagsOptions.Builder()
      .providers(new java.util.ArrayList<String>(java.util.Arrays.asList("ghost")))
      .attachedTo("testString")
      .fullData(true)
      .offset(Long.valueOf("0"))
      .limit(Long.valueOf("1"))
      .orderByName("asc")
      .timeout(Long.valueOf("26"))
      .attachedOnly(true)
      .build();
    assertEquals(listTagsOptionsModel.providers(), new java.util.ArrayList<String>(java.util.Arrays.asList("ghost")));
    assertEquals(listTagsOptionsModel.attachedTo(), "testString");
    assertEquals(listTagsOptionsModel.fullData(), Boolean.valueOf(true));
    assertEquals(listTagsOptionsModel.offset(), Long.valueOf("0"));
    assertEquals(listTagsOptionsModel.limit(), Long.valueOf("1"));
    assertEquals(listTagsOptionsModel.orderByName(), "asc");
    assertEquals(listTagsOptionsModel.timeout(), Long.valueOf("26"));
    assertEquals(listTagsOptionsModel.attachedOnly(), Boolean.valueOf(true));
  }
}