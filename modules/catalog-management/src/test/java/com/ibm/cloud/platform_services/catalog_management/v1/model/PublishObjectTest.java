/*
 * (C) Copyright IBM Corp. 2021.
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

package com.ibm.cloud.platform_services.catalog_management.v1.model;

import com.ibm.cloud.platform_services.catalog_management.v1.model.PublishObject;
import com.ibm.cloud.platform_services.catalog_management.v1.utils.TestUtilities;
import com.ibm.cloud.sdk.core.service.model.FileWithMetadata;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import org.testng.annotations.Test;
import static org.testng.Assert.*;

/**
 * Unit test class for the PublishObject model.
 */
public class PublishObjectTest {
  final HashMap<String, InputStream> mockStreamMap = TestUtilities.createMockStreamMap();
  final List<FileWithMetadata> mockListFileWithMetadata = TestUtilities.creatMockListFileWithMetadata();

  @Test
  public void testPublishObject() throws Throwable {
    PublishObject publishObjectModel = new PublishObject.Builder()
      .permitIbmPublicPublish(true)
      .ibmApproved(true)
      .publicApproved(true)
      .portalApprovalRecord("testString")
      .portalUrl("testString")
      .build();
    assertEquals(publishObjectModel.permitIbmPublicPublish(), Boolean.valueOf(true));
    assertEquals(publishObjectModel.ibmApproved(), Boolean.valueOf(true));
    assertEquals(publishObjectModel.publicApproved(), Boolean.valueOf(true));
    assertEquals(publishObjectModel.portalApprovalRecord(), "testString");
    assertEquals(publishObjectModel.portalUrl(), "testString");

    String json = TestUtilities.serialize(publishObjectModel);

    PublishObject publishObjectModelNew = TestUtilities.deserialize(json, PublishObject.class);
    assertTrue(publishObjectModelNew instanceof PublishObject);
    assertEquals(publishObjectModelNew.permitIbmPublicPublish(), Boolean.valueOf(true));
    assertEquals(publishObjectModelNew.ibmApproved(), Boolean.valueOf(true));
    assertEquals(publishObjectModelNew.publicApproved(), Boolean.valueOf(true));
    assertEquals(publishObjectModelNew.portalApprovalRecord(), "testString");
    assertEquals(publishObjectModelNew.portalUrl(), "testString");
  }
}