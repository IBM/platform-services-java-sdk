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

package com.ibm.cloud.platform_services.iam_identity.v1.model;

import com.ibm.cloud.platform_services.iam_identity.v1.model.ResponseContext;
import com.ibm.cloud.platform_services.iam_identity.v1.utils.TestUtilities;
import com.ibm.cloud.sdk.core.service.model.FileWithMetadata;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import org.testng.annotations.Test;
import static org.testng.Assert.*;

/**
 * Unit test class for the ResponseContext model.
 */
public class ResponseContextTest {
  final HashMap<String, InputStream> mockStreamMap = TestUtilities.createMockStreamMap();
  final List<FileWithMetadata> mockListFileWithMetadata = TestUtilities.creatMockListFileWithMetadata();

  @Test
  public void testResponseContext() throws Throwable {
    ResponseContext responseContextModel = new ResponseContext();
    assertNull(responseContextModel.getTransactionId());
    assertNull(responseContextModel.getOperation());
    assertNull(responseContextModel.getUserAgent());
    assertNull(responseContextModel.getUrl());
    assertNull(responseContextModel.getInstanceId());
    assertNull(responseContextModel.getThreadId());
    assertNull(responseContextModel.getHost());
    assertNull(responseContextModel.getStartTime());
    assertNull(responseContextModel.getEndTime());
    assertNull(responseContextModel.getElapsedTime());
    assertNull(responseContextModel.getClusterName());
  }
}