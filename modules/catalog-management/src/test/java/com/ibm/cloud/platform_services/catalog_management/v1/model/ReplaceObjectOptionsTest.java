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
import com.ibm.cloud.platform_services.catalog_management.v1.model.ReplaceObjectOptions;
import com.ibm.cloud.platform_services.catalog_management.v1.model.State;
import com.ibm.cloud.platform_services.catalog_management.v1.utils.TestUtilities;
import com.ibm.cloud.sdk.core.service.model.FileWithMetadata;
import com.ibm.cloud.sdk.core.util.DateUtils;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import org.testng.annotations.Test;
import static org.testng.Assert.*;

/**
 * Unit test class for the ReplaceObjectOptions model.
 */
public class ReplaceObjectOptionsTest {
  final HashMap<String, InputStream> mockStreamMap = TestUtilities.createMockStreamMap();
  final List<FileWithMetadata> mockListFileWithMetadata = TestUtilities.creatMockListFileWithMetadata();

  @Test
  public void testReplaceObjectOptions() throws Throwable {
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

    State stateModel = new State.Builder()
      .current("testString")
      .currentEntered(DateUtils.parseAsDateTime("2019-01-01T12:00:00.000Z"))
      .pending("testString")
      .pendingRequested(DateUtils.parseAsDateTime("2019-01-01T12:00:00.000Z"))
      .previous("testString")
      .build();
    assertEquals(stateModel.current(), "testString");
    assertEquals(stateModel.currentEntered(), DateUtils.parseAsDateTime("2019-01-01T12:00:00.000Z"));
    assertEquals(stateModel.pending(), "testString");
    assertEquals(stateModel.pendingRequested(), DateUtils.parseAsDateTime("2019-01-01T12:00:00.000Z"));
    assertEquals(stateModel.previous(), "testString");

    ReplaceObjectOptions replaceObjectOptionsModel = new ReplaceObjectOptions.Builder()
      .catalogIdentifier("testString")
      .objectIdentifier("testString")
      .id("testString")
      .name("testString")
      .rev("testString")
      .crn("testString")
      .url("testString")
      .parentId("testString")
      .labelI18n("testString")
      .label("testString")
      .tags(new java.util.ArrayList<String>(java.util.Arrays.asList("testString")))
      .created(DateUtils.parseAsDateTime("2019-01-01T12:00:00.000Z"))
      .updated(DateUtils.parseAsDateTime("2019-01-01T12:00:00.000Z"))
      .shortDescription("testString")
      .shortDescriptionI18n("testString")
      .kind("testString")
      .publish(publishObjectModel)
      .state(stateModel)
      .catalogId("testString")
      .catalogName("testString")
      .data(new java.util.HashMap<String, Object>() { { put("foo", "testString"); } })
      .build();
    assertEquals(replaceObjectOptionsModel.catalogIdentifier(), "testString");
    assertEquals(replaceObjectOptionsModel.objectIdentifier(), "testString");
    assertEquals(replaceObjectOptionsModel.id(), "testString");
    assertEquals(replaceObjectOptionsModel.name(), "testString");
    assertEquals(replaceObjectOptionsModel.rev(), "testString");
    assertEquals(replaceObjectOptionsModel.crn(), "testString");
    assertEquals(replaceObjectOptionsModel.url(), "testString");
    assertEquals(replaceObjectOptionsModel.parentId(), "testString");
    assertEquals(replaceObjectOptionsModel.labelI18n(), "testString");
    assertEquals(replaceObjectOptionsModel.label(), "testString");
    assertEquals(replaceObjectOptionsModel.tags(), new java.util.ArrayList<String>(java.util.Arrays.asList("testString")));
    assertEquals(replaceObjectOptionsModel.created(), DateUtils.parseAsDateTime("2019-01-01T12:00:00.000Z"));
    assertEquals(replaceObjectOptionsModel.updated(), DateUtils.parseAsDateTime("2019-01-01T12:00:00.000Z"));
    assertEquals(replaceObjectOptionsModel.shortDescription(), "testString");
    assertEquals(replaceObjectOptionsModel.shortDescriptionI18n(), "testString");
    assertEquals(replaceObjectOptionsModel.kind(), "testString");
    assertEquals(replaceObjectOptionsModel.publish(), publishObjectModel);
    assertEquals(replaceObjectOptionsModel.state(), stateModel);
    assertEquals(replaceObjectOptionsModel.catalogId(), "testString");
    assertEquals(replaceObjectOptionsModel.catalogName(), "testString");
    assertEquals(replaceObjectOptionsModel.data(), new java.util.HashMap<String, Object>() { { put("foo", "testString"); } });
  }

  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testReplaceObjectOptionsError() throws Throwable {
    new ReplaceObjectOptions.Builder().build();
  }

}