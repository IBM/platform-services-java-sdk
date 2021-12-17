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

import com.ibm.cloud.platform_services.catalog_management.v1.model.CatalogObject;
import com.ibm.cloud.platform_services.catalog_management.v1.model.PublishObject;
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
 * Unit test class for the CatalogObject model.
 */
public class CatalogObjectTest {
  final HashMap<String, InputStream> mockStreamMap = TestUtilities.createMockStreamMap();
  final List<FileWithMetadata> mockListFileWithMetadata = TestUtilities.creatMockListFileWithMetadata();

  @Test
  public void testCatalogObject() throws Throwable {
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

    CatalogObject catalogObjectModel = new CatalogObject.Builder()
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
    assertEquals(catalogObjectModel.id(), "testString");
    assertEquals(catalogObjectModel.name(), "testString");
    assertEquals(catalogObjectModel.rev(), "testString");
    assertEquals(catalogObjectModel.crn(), "testString");
    assertEquals(catalogObjectModel.url(), "testString");
    assertEquals(catalogObjectModel.parentId(), "testString");
    assertEquals(catalogObjectModel.labelI18n(), "testString");
    assertEquals(catalogObjectModel.label(), "testString");
    assertEquals(catalogObjectModel.tags(), new java.util.ArrayList<String>(java.util.Arrays.asList("testString")));
    assertEquals(catalogObjectModel.created(), DateUtils.parseAsDateTime("2019-01-01T12:00:00.000Z"));
    assertEquals(catalogObjectModel.updated(), DateUtils.parseAsDateTime("2019-01-01T12:00:00.000Z"));
    assertEquals(catalogObjectModel.shortDescription(), "testString");
    assertEquals(catalogObjectModel.shortDescriptionI18n(), "testString");
    assertEquals(catalogObjectModel.kind(), "testString");
    assertEquals(catalogObjectModel.publish(), publishObjectModel);
    assertEquals(catalogObjectModel.state(), stateModel);
    assertEquals(catalogObjectModel.catalogId(), "testString");
    assertEquals(catalogObjectModel.catalogName(), "testString");
    assertEquals(catalogObjectModel.data(), new java.util.HashMap<String, Object>() { { put("foo", "testString"); } });

    String json = TestUtilities.serialize(catalogObjectModel);

    CatalogObject catalogObjectModelNew = TestUtilities.deserialize(json, CatalogObject.class);
    assertTrue(catalogObjectModelNew instanceof CatalogObject);
    assertEquals(catalogObjectModelNew.id(), "testString");
    assertEquals(catalogObjectModelNew.name(), "testString");
    assertEquals(catalogObjectModelNew.rev(), "testString");
    assertEquals(catalogObjectModelNew.crn(), "testString");
    assertEquals(catalogObjectModelNew.url(), "testString");
    assertEquals(catalogObjectModelNew.parentId(), "testString");
    assertEquals(catalogObjectModelNew.labelI18n(), "testString");
    assertEquals(catalogObjectModelNew.label(), "testString");
    assertEquals(catalogObjectModelNew.created(), DateUtils.parseAsDateTime("2019-01-01T12:00:00.000Z"));
    assertEquals(catalogObjectModelNew.updated(), DateUtils.parseAsDateTime("2019-01-01T12:00:00.000Z"));
    assertEquals(catalogObjectModelNew.shortDescription(), "testString");
    assertEquals(catalogObjectModelNew.shortDescriptionI18n(), "testString");
    assertEquals(catalogObjectModelNew.kind(), "testString");
    assertEquals(catalogObjectModelNew.publish().toString(), publishObjectModel.toString());
    assertEquals(catalogObjectModelNew.state().toString(), stateModel.toString());
    assertEquals(catalogObjectModelNew.catalogId(), "testString");
    assertEquals(catalogObjectModelNew.catalogName(), "testString");
  }
}