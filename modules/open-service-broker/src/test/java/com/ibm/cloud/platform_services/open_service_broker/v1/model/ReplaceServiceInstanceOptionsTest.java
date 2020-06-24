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

import com.ibm.cloud.platform_services.open_service_broker.v1.model.Context;
import com.ibm.cloud.platform_services.open_service_broker.v1.model.Parameters;
import com.ibm.cloud.platform_services.open_service_broker.v1.model.ReplaceServiceInstanceOptions;
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
 * Unit test class for the ReplaceServiceInstanceOptions model.
 */
public class ReplaceServiceInstanceOptionsTest {
  final HashMap<String, InputStream> mockStreamMap = TestUtilities.createMockStreamMap();
  final List<FileWithMetadata> mockListFileWithMetadata = TestUtilities.creatMockListFileWithMetadata();

  @Test
  public void testReplaceServiceInstanceOptions() throws Throwable {
    Context contextModel = new Context.Builder()
      .accountId("null")
      .crn("null")
      .platform("null")
      .build();
    assertEquals(contextModel.accountId(), "null");
    assertEquals(contextModel.crn(), "null");
    assertEquals(contextModel.platform(), "null");

    Parameters parametersModel = new Parameters.Builder()
      .parameter1(Long.valueOf("26"))
      .parameter2("null")
      .build();
    assertEquals(parametersModel.parameter1(), Long.valueOf("26"));
    assertEquals(parametersModel.parameter2(), "null");

    ReplaceServiceInstanceOptions replaceServiceInstanceOptionsModel = new ReplaceServiceInstanceOptions.Builder()
      .instanceId("testString")
      .context(new java.util.ArrayList<Context>(java.util.Arrays.asList(contextModel)))
      .organizationGuid("null")
      .parameters(new java.util.ArrayList<Parameters>(java.util.Arrays.asList(parametersModel)))
      .planId("null")
      .serviceId("null")
      .spaceGuid("null")
      .acceptsIncomplete(true)
      .build();
    assertEquals(replaceServiceInstanceOptionsModel.instanceId(), "testString");
    assertEquals(replaceServiceInstanceOptionsModel.context(), new java.util.ArrayList<Context>(java.util.Arrays.asList(contextModel)));
    assertEquals(replaceServiceInstanceOptionsModel.organizationGuid(), "null");
    assertEquals(replaceServiceInstanceOptionsModel.parameters(), new java.util.ArrayList<Parameters>(java.util.Arrays.asList(parametersModel)));
    assertEquals(replaceServiceInstanceOptionsModel.planId(), "null");
    assertEquals(replaceServiceInstanceOptionsModel.serviceId(), "null");
    assertEquals(replaceServiceInstanceOptionsModel.spaceGuid(), "null");
    assertEquals(replaceServiceInstanceOptionsModel.acceptsIncomplete(), Boolean.valueOf(true));
  }

  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testReplaceServiceInstanceOptionsError() throws Throwable {
    new ReplaceServiceInstanceOptions.Builder().build();
  }

}