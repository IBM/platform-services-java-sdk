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

package com.ibm.cloud.platform_services.iam_access_groups.v2.model;

import com.ibm.cloud.platform_services.iam_access_groups.v2.model.AccessActionControls;
import com.ibm.cloud.platform_services.iam_access_groups.v2.model.AccessGroupInput;
import com.ibm.cloud.platform_services.iam_access_groups.v2.model.AssertionsActionControls;
import com.ibm.cloud.platform_services.iam_access_groups.v2.model.AssertionsInput;
import com.ibm.cloud.platform_services.iam_access_groups.v2.model.ConditionInput;
import com.ibm.cloud.platform_services.iam_access_groups.v2.model.GroupActionControls;
import com.ibm.cloud.platform_services.iam_access_groups.v2.model.HrefStruct;
import com.ibm.cloud.platform_services.iam_access_groups.v2.model.ListTemplateVersionsResponse;
import com.ibm.cloud.platform_services.iam_access_groups.v2.model.ListTemplatesVersionsResponse;
import com.ibm.cloud.platform_services.iam_access_groups.v2.model.MembersActionControls;
import com.ibm.cloud.platform_services.iam_access_groups.v2.model.MembersInput;
import com.ibm.cloud.platform_services.iam_access_groups.v2.model.PolicyTemplatesInput;
import com.ibm.cloud.platform_services.iam_access_groups.v2.model.RuleInput;
import com.ibm.cloud.platform_services.iam_access_groups.v2.model.RulesActionControls;
import com.ibm.cloud.platform_services.iam_access_groups.v2.utils.TestUtilities;
import com.ibm.cloud.sdk.core.service.model.FileWithMetadata;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import org.testng.annotations.Test;
import static org.testng.Assert.*;

/**
 * Unit test class for the ListTemplateVersionsResponse model.
 */
public class ListTemplateVersionsResponseTest {
  final HashMap<String, InputStream> mockStreamMap = TestUtilities.createMockStreamMap();
  final List<FileWithMetadata> mockListFileWithMetadata = TestUtilities.creatMockListFileWithMetadata();

  @Test
  public void testListTemplateVersionsResponse() throws Throwable {
    ListTemplateVersionsResponse listTemplateVersionsResponseModel = new ListTemplateVersionsResponse();
    assertNull(listTemplateVersionsResponseModel.getLimit());
    assertNull(listTemplateVersionsResponseModel.getOffset());
    assertNull(listTemplateVersionsResponseModel.getTotalCount());
    assertNull(listTemplateVersionsResponseModel.getFirst());
    assertNull(listTemplateVersionsResponseModel.getPrevious());
    assertNull(listTemplateVersionsResponseModel.getNext());
    assertNull(listTemplateVersionsResponseModel.getLast());
    assertNull(listTemplateVersionsResponseModel.getVersions());
  }
}