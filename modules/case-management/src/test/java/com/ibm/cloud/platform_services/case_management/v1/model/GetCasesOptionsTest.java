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

package com.ibm.cloud.platform_services.case_management.v1.model;

import com.ibm.cloud.platform_services.case_management.v1.model.GetCasesOptions;
import com.ibm.cloud.platform_services.case_management.v1.utils.TestUtilities;

import com.ibm.cloud.sdk.core.service.model.FileWithMetadata;
import java.io.InputStream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import org.testng.annotations.Test;
import static org.testng.Assert.*;

/**
 * Unit test class for the GetCasesOptions model.
 */
public class GetCasesOptionsTest {
  final HashMap<String, InputStream> mockStreamMap = TestUtilities.createMockStreamMap();
  final List<FileWithMetadata> mockListFileWithMetadata = TestUtilities.creatMockListFileWithMetadata();

  @Test
  public void testGetCasesOptions() throws Throwable {
    GetCasesOptions getCasesOptionsModel = new GetCasesOptions.Builder()
      .offset(Long.valueOf("26"))
      .limit(Long.valueOf("26"))
      .search("testString")
      .sort("number")
      .status(new java.util.ArrayList<String>(java.util.Arrays.asList("new")))
      .fields(new java.util.ArrayList<String>(java.util.Arrays.asList("number")))
      .build();
    assertEquals(getCasesOptionsModel.offset(), Long.valueOf("26"));
    assertEquals(getCasesOptionsModel.limit(), Long.valueOf("26"));
    assertEquals(getCasesOptionsModel.search(), "testString");
    assertEquals(getCasesOptionsModel.sort(), "number");
    assertEquals(getCasesOptionsModel.status(), new java.util.ArrayList<String>(java.util.Arrays.asList("new")));
    assertEquals(getCasesOptionsModel.fields(), new java.util.ArrayList<String>(java.util.Arrays.asList("number")));
  }
}