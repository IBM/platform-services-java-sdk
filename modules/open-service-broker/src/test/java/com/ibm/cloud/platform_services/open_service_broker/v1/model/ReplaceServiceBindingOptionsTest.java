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

package com.ibm.cloud.platform_services.open_service_broker.v1.model;

import com.ibm.cloud.platform_services.open_service_broker.v1.model.BindResource;
import com.ibm.cloud.platform_services.open_service_broker.v1.model.ReplaceServiceBindingOptions;
import com.ibm.cloud.platform_services.open_service_broker.v1.utils.TestUtilities;

import com.ibm.cloud.sdk.core.service.model.FileWithMetadata;
import java.io.InputStream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import org.testng.annotations.Test;
import static org.testng.Assert.*;

/**
 * Unit test class for the ReplaceServiceBindingOptions model.
 */
public class ReplaceServiceBindingOptionsTest {
  final HashMap<String, InputStream> mockStreamMap = TestUtilities.createMockStreamMap();
  final List<FileWithMetadata> mockListFileWithMetadata = TestUtilities.creatMockListFileWithMetadata();

  @Test
  public void testReplaceServiceBindingOptions() throws Throwable {
    BindResource bindResourceModel = new BindResource.Builder()
      .accountId("null")
      .serviceidCrn("null")
      .targetCrn("null")
      .build();
    assertEquals(bindResourceModel.accountId(), "null");
    assertEquals(bindResourceModel.serviceidCrn(), "null");
    assertEquals(bindResourceModel.targetCrn(), "null");

    ReplaceServiceBindingOptions replaceServiceBindingOptionsModel = new ReplaceServiceBindingOptions.Builder()
      .bindingId("testString")
      .instanceId("testString")
      .bindResource(new java.util.ArrayList<BindResource>(java.util.Arrays.asList(bindResourceModel)))
      .parameters(new java.util.HashMap<String,Object>(){{put("foo", "testString"); }})
      .planId("null")
      .serviceId("null")
      .build();
    assertEquals(replaceServiceBindingOptionsModel.bindingId(), "testString");
    assertEquals(replaceServiceBindingOptionsModel.instanceId(), "testString");
    assertEquals(replaceServiceBindingOptionsModel.bindResource(), new java.util.ArrayList<BindResource>(java.util.Arrays.asList(bindResourceModel)));
    assertEquals(replaceServiceBindingOptionsModel.parameters(), new java.util.HashMap<String,Object>(){{put("foo", "testString"); }});
    assertEquals(replaceServiceBindingOptionsModel.planId(), "null");
    assertEquals(replaceServiceBindingOptionsModel.serviceId(), "null");
  }

  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testReplaceServiceBindingOptionsError() throws Throwable {
    new ReplaceServiceBindingOptions.Builder().build();
  }

}