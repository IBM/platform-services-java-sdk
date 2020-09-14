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

import com.ibm.cloud.platform_services.open_service_broker.v1.model.DeleteServiceBindingOptions;
import com.ibm.cloud.platform_services.open_service_broker.v1.utils.TestUtilities;
import com.ibm.cloud.sdk.core.service.model.FileWithMetadata;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import org.testng.annotations.Test;
import static org.testng.Assert.*;

/**
 * Unit test class for the DeleteServiceBindingOptions model.
 */
public class DeleteServiceBindingOptionsTest {
  final HashMap<String, InputStream> mockStreamMap = TestUtilities.createMockStreamMap();
  final List<FileWithMetadata> mockListFileWithMetadata = TestUtilities.creatMockListFileWithMetadata();

  @Test
  public void testDeleteServiceBindingOptions() throws Throwable {
    DeleteServiceBindingOptions deleteServiceBindingOptionsModel = new DeleteServiceBindingOptions.Builder()
      .bindingId("testString")
      .instanceId("testString")
      .planId("testString")
      .serviceId("testString")
      .build();
    assertEquals(deleteServiceBindingOptionsModel.bindingId(), "testString");
    assertEquals(deleteServiceBindingOptionsModel.instanceId(), "testString");
    assertEquals(deleteServiceBindingOptionsModel.planId(), "testString");
    assertEquals(deleteServiceBindingOptionsModel.serviceId(), "testString");
  }

  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testDeleteServiceBindingOptionsError() throws Throwable {
    new DeleteServiceBindingOptions.Builder().build();
  }

}