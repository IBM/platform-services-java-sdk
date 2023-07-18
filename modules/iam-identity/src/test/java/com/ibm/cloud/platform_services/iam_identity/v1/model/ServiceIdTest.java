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

package com.ibm.cloud.platform_services.iam_identity.v1.model;

import com.ibm.cloud.platform_services.iam_identity.v1.model.Activity;
import com.ibm.cloud.platform_services.iam_identity.v1.model.ApiKey;
import com.ibm.cloud.platform_services.iam_identity.v1.model.EnityHistoryRecord;
import com.ibm.cloud.platform_services.iam_identity.v1.model.ResponseContext;
import com.ibm.cloud.platform_services.iam_identity.v1.model.ServiceId;
import com.ibm.cloud.platform_services.iam_identity.v1.utils.TestUtilities;
import com.ibm.cloud.sdk.core.service.model.FileWithMetadata;
import com.ibm.cloud.sdk.core.util.DateUtils;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import org.testng.annotations.Test;
import static org.testng.Assert.*;

/**
 * Unit test class for the ServiceId model.
 */
public class ServiceIdTest {
  final HashMap<String, InputStream> mockStreamMap = TestUtilities.createMockStreamMap();
  final List<FileWithMetadata> mockListFileWithMetadata = TestUtilities.creatMockListFileWithMetadata();

  @Test
  public void testServiceId() throws Throwable {
    ServiceId serviceIdModel = new ServiceId();
    assertNull(serviceIdModel.getContext());
    assertNull(serviceIdModel.getId());
    assertNull(serviceIdModel.getIamId());
    assertNull(serviceIdModel.getEntityTag());
    assertNull(serviceIdModel.getCrn());
    assertNull(serviceIdModel.isLocked());
    assertNull(serviceIdModel.getCreatedAt());
    assertNull(serviceIdModel.getModifiedAt());
    assertNull(serviceIdModel.getAccountId());
    assertNull(serviceIdModel.getName());
    assertNull(serviceIdModel.getDescription());
    assertNull(serviceIdModel.getUniqueInstanceCrns());
    assertNull(serviceIdModel.getHistory());
    assertNull(serviceIdModel.getApikey());
    assertNull(serviceIdModel.getActivity());
  }
}