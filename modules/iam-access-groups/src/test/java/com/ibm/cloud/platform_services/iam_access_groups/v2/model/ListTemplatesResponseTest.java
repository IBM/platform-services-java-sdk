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
import com.ibm.cloud.platform_services.iam_access_groups.v2.model.AccessGroupResponse;
import com.ibm.cloud.platform_services.iam_access_groups.v2.model.Assertions;
import com.ibm.cloud.platform_services.iam_access_groups.v2.model.AssertionsActionControls;
import com.ibm.cloud.platform_services.iam_access_groups.v2.model.AssertionsRule;
import com.ibm.cloud.platform_services.iam_access_groups.v2.model.Conditions;
import com.ibm.cloud.platform_services.iam_access_groups.v2.model.GroupActionControls;
import com.ibm.cloud.platform_services.iam_access_groups.v2.model.GroupTemplate;
import com.ibm.cloud.platform_services.iam_access_groups.v2.model.HrefStruct;
import com.ibm.cloud.platform_services.iam_access_groups.v2.model.ListTemplatesResponse;
import com.ibm.cloud.platform_services.iam_access_groups.v2.model.Members;
import com.ibm.cloud.platform_services.iam_access_groups.v2.model.MembersActionControls;
import com.ibm.cloud.platform_services.iam_access_groups.v2.model.PolicyTemplates;
import com.ibm.cloud.platform_services.iam_access_groups.v2.model.RuleActionControls;
import com.ibm.cloud.platform_services.iam_access_groups.v2.utils.TestUtilities;
import com.ibm.cloud.sdk.core.service.model.FileWithMetadata;
import com.ibm.cloud.sdk.core.util.DateUtils;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import org.testng.annotations.Test;
import static org.testng.Assert.*;

/**
 * Unit test class for the ListTemplatesResponse model.
 */
public class ListTemplatesResponseTest {
  final HashMap<String, InputStream> mockStreamMap = TestUtilities.createMockStreamMap();
  final List<FileWithMetadata> mockListFileWithMetadata = TestUtilities.creatMockListFileWithMetadata();

  @Test
  public void testListTemplatesResponse() throws Throwable {
    ListTemplatesResponse listTemplatesResponseModel = new ListTemplatesResponse();
    assertNull(listTemplatesResponseModel.getLimit());
    assertNull(listTemplatesResponseModel.getOffset());
    assertNull(listTemplatesResponseModel.getTotalCount());
    assertNull(listTemplatesResponseModel.getFirst());
    assertNull(listTemplatesResponseModel.getPrevious());
    assertNull(listTemplatesResponseModel.getNext());
    assertNull(listTemplatesResponseModel.getLast());
    assertNull(listTemplatesResponseModel.getGroupTemplates());
  }
}